package com.oldscape.shared.network.login;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

import com.oldscape.shared.utility.BufferUtils;
import com.oldscape.shared.utility.IsaacRandom;
import com.oldscape.shared.utility.XTEA;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

/**
 * Created by sean on 23/07/14.
 */
public final class LoginDecoder extends ByteToMessageDecoder {

	/**
	 * The Login Modulus RSA Key
	 */
	public static final BigInteger LOGIN_MODULUS = new BigInteger(
			"165865706435016682110653568563251120094278686912987295809145491806194715902716739338411927793058925228087565434562948389222225588420069703784252638483569608159614392485969864899137973999614056797405232846059198315441808544524190866210655169682670028293787208173603935453834899795395794572295868565624049196373");

	/**
	 * The Login Exponent RSA Key
	 */
	public static final BigInteger LOGIN_EXPONENT = new BigInteger(
			"56600403721755849042871300293705052867669386058593586576677751174965876168398876338011266203274025417717477354449635744336265820214938719432244777866648612856409222657603092909839244312101542583618644127794582316068916809421286289618425813349038287935817476491851970456260849477664967448547154113206350117073");

	public static final int LOGIN_TYPE = 16;
	public static final int RECONNECTION_TYPE = 18;

	public boolean userReconnecting;

	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf buf, List<Object> out) throws Exception {

		if (!buf.isReadable())
			return;

		int type = buf.readUnsignedByte();

		if (type != LOGIN_TYPE && type != RECONNECTION_TYPE)
			throw new IOException("Invalid login type: " + type);

		if (type == RECONNECTION_TYPE)
			userReconnecting = true;

		int size = buf.readUnsignedShort();

		if (buf.readableBytes() < size)
			return;

		int major = buf.readInt();
		System.out.println(major);

		int rsaBlockSize = buf.readUnsignedShort();
		byte[] rsaBlockBytes = new byte[rsaBlockSize];
		buf.readBytes(rsaBlockBytes);
		ByteBuf rBuf = Unpooled.wrappedBuffer(new BigInteger(rsaBlockBytes).modPow(LOGIN_EXPONENT, LOGIN_MODULUS).toByteArray());

		int blockMagic = rBuf.readUnsignedByte();
		if (blockMagic != 1)
			throw new IllegalStateException("Invalid RSA Block Header.");

		int blockType = rBuf.readUnsignedByte();

		int[] cKeys = new int[4];
		for (int i = 0; i < cKeys.length; i++)
			cKeys[i] = rBuf.readInt();

		if (blockType == 2) {
			rBuf.readerIndex(rBuf.readerIndex() + 8);
		} else if (blockType == 3 || blockType == 1) {// Authenticator
			rBuf.readUnsignedMedium();
			rBuf.readerIndex(rBuf.readerIndex() + 5);
		} else if (blockType == 0) {// TrustedComputer
			rBuf.readInt();
			rBuf.readerIndex(rBuf.readerIndex() + 4);
		}

		String password = BufferUtils.getString(rBuf);

		int xteaBlockSize = buf.readableBytes();
		byte[] xteaBlockBytes = new byte[xteaBlockSize];
		buf.readBytes(xteaBlockBytes);
		XTEA.decrypt(xteaBlockBytes, 0, xteaBlockBytes.length, cKeys);
		ByteBuf xBuf = Unpooled.wrappedBuffer(xteaBlockBytes);

		String username = BufferUtils.getString(xBuf);
		xBuf.readUnsignedByte();// low mem

		xBuf.readUnsignedShort();// width
		xBuf.readUnsignedShort();// height

		byte[] random = new byte[24];
		for (int i = 0; i < random.length; i++) {
			random[i] = xBuf.readByte();
		}

		String token = BufferUtils.getString(xBuf);
		xBuf.readInt();// affiliate id

		xBuf.readUnsignedByte();// 6
		xBuf.readUnsignedByte();// OS Type
		xBuf.readUnsignedByte();// 64-Bit OS
		xBuf.readUnsignedByte();// OS Version
		xBuf.readUnsignedByte();// Java Vendor
		xBuf.readUnsignedByte();// Something todo with Java
		xBuf.readUnsignedByte();// Something todo with Java
		xBuf.readUnsignedByte();
		xBuf.readUnsignedByte();// 0
		xBuf.readUnsignedShort();// Max Mem
		xBuf.readUnsignedByte();// Availible Processors
		xBuf.readUnsignedMedium();// 0
		xBuf.readUnsignedShort();// 0
		BufferUtils.getJagString(xBuf);// usually null
		BufferUtils.getJagString(xBuf);// usually null
		BufferUtils.getJagString(xBuf);// usually null
		BufferUtils.getJagString(xBuf);// usually null
		xBuf.readUnsignedByte();
		xBuf.readUnsignedShort();
		BufferUtils.getJagString(xBuf);// usually null
		BufferUtils.getJagString(xBuf);// usually null
		xBuf.readUnsignedByte();
		xBuf.readUnsignedByte();

		int[] var = new int[3];
		for (int i = 0; i < var.length; i++)
			var[i] = xBuf.readInt();

		xBuf.readInt();
		xBuf.readUnsignedByte();

		int[] crc = new int[16];// xBuf.readableBytes() / 4
		for (int i = 0; i < crc.length; i++)
			crc[i] = xBuf.readInt();

		int[] sKeys = new int[cKeys.length];
		for (int i = 0; i < sKeys.length; i++)
			sKeys[i] = cKeys[i] + 50;

		System.out.println(username + ", " + password + ", " + token); // wtf why isnt it pritning shit? am i using th 
		out.add(new LoginEvent(major, token, username, password, crc, new IsaacRandom(sKeys), new IsaacRandom(cKeys)));
	}
}
