package com.oldscape.client;

public final class Player extends Actor {

	static int cameraX;

	Name name;

	PlayerComposition composition;

	int skullIcon;

	int overheadIcon;

	String[] actions;

	int combatLevel;

	int totalLevel;

	int field842;

	int animationCycleStart;

	int animationCycleEnd;

	int field845;

	int field858;

	int field843;

	Model model;

	int field849;

	int field850;

	int field851;

	int field852;

	boolean isLowDetail;

	int team;

	boolean hidden;

	int field856;

	int playerId;

	class303 field859;

	class303 field835;

	boolean field860;

	int field861;

	int field837;

	Player() {
		this.skullIcon = -1;
		this.overheadIcon = -1;
		this.actions = new String[3];

		for (int var1 = 0; var1 < 3; ++var1) {
			this.actions[var1] = "";
		}

		this.combatLevel = 0;
		this.totalLevel = 0;
		this.animationCycleStart = 0;
		this.animationCycleEnd = 0;
		this.isLowDetail = false;
		this.team = 0;
		this.hidden = false;
		this.field859 = class303.field3851;
		this.field835 = class303.field3851;
		this.field860 = false;
	}

	final void decodeApperance(Buffer var1) {
		var1.offset = 0;
		int var2 = var1.readUnsignedByte();
		this.skullIcon = var1.readByte();
		this.overheadIcon = var1.readByte();
		int var3 = -1;
		this.team = 0;
		int[] var4 = new int[12];

		int var6;
		int var7;
		for (int var5 = 0; var5 < 12; ++var5) {
			var6 = var1.readUnsignedByte();
			if (var6 == 0) {
				var4[var5] = 0;
			} else {
				var7 = var1.readUnsignedByte();
				var4[var5] = var7 + (var6 << 8);
				if (var5 == 0 && var4[0] == 65535) {
					var3 = var1.readUnsignedShort();
					break;
				}

				if (var4[var5] >= 512) {
					int var8 = class47.getItemDefinition(var4[var5] - 512).team;
					if (var8 != 0) {
						this.team = var8;
					}
				}
			}
		}

		int[] var9 = new int[5];

		for (var6 = 0; var6 < 5; ++var6) {
			var7 = var1.readUnsignedByte();
			if (var7 < 0 || var7 >= PlayerComposition.colorsToReplace[var6].length) {
				var7 = 0;
			}

			var9[var6] = var7;
		}

		super.idlePoseAnimation = var1.readUnsignedShort();
		if (super.idlePoseAnimation == 65535) {
			super.idlePoseAnimation = -1;
		}

		super.field1163 = var1.readUnsignedShort();
		if (super.field1163 == 65535) {
			super.field1163 = -1;
		}

		super.field1164 = super.field1163;
		super.field1165 = var1.readUnsignedShort();
		if (super.field1165 == 65535) {
			super.field1165 = -1;
		}

		super.field1209 = var1.readUnsignedShort();
		if (super.field1209 == 65535) {
			super.field1209 = -1;
		}

		super.field1167 = var1.readUnsignedShort();
		if (super.field1167 == 65535) {
			super.field1167 = -1;
		}

		super.field1177 = var1.readUnsignedShort();
		if (super.field1177 == 65535) {
			super.field1177 = -1;
		}

		super.field1169 = var1.readUnsignedShort();
		if (super.field1169 == 65535) {
			super.field1169 = -1;
		}

		this.name = new Name(var1.readString(), GZipDecompressor.loginType);
		this.method1188();
		this.method1191();
		if (this == SoundTaskDataProvider.localPlayer) {
			RunException.field2194 = this.name.getName();
		}

		this.combatLevel = var1.readUnsignedByte();
		this.totalLevel = var1.readUnsignedShort();
		this.hidden = var1.readUnsignedByte() == 1;
		if (Client.socketType == 0 && Client.rights >= 2) {
			this.hidden = false;
		}

		if (this.composition == null) {
			this.composition = new PlayerComposition();
		}

		this.composition.method4396(var4, var9, var2 == 1, var3);
	}

	boolean isFriend() {
		if (this.field859 == class303.field3851) {
			this.method1189();
		}

		return this.field859 == class303.field3850;
	}

	void method1188() {
		this.field859 = class303.field3851;
	}

	void method1189() {
		this.field859 = WorldMapRectangle.friendManager.method1776(this.name) ? class303.field3850 : class303.field3849;
	}

	boolean isClanMember() {
		if (this.field835 == class303.field3851) {
			this.method1206();
		}

		return this.field835 == class303.field3850;
	}

	void method1191() {
		this.field835 = class303.field3851;
	}

	void method1206() {
		this.field835 = GameEngine.clanMemberManager != null && GameEngine.clanMemberManager.isMember(this.name)
				? class303.field3850
				: class303.field3849;
	}

	int getSize() {
		return this.composition != null && this.composition.transformedNpcId != -1
				? class234.getNpcDefinition(this.composition.transformedNpcId).size
				: 1;
	}

	@Override
	protected final Model getModel() {
		if (this.composition == null) {
			return null;
		} else {
			Sequence var1 = super.animation != -1 && super.actionAnimationDisable == 0
					? CombatInfo1.getAnimation(super.animation)
					: null;
			Sequence var2 = super.poseAnimation == -1 || this.isLowDetail
					|| super.idlePoseAnimation == super.poseAnimation && var1 != null ? null
							: CombatInfo1.getAnimation(super.poseAnimation);
			Model var3 = this.composition.getModel(var1, super.actionFrame, var2, super.poseFrame);
			if (var3 == null) {
				return null;
			} else {
				var3.calculateBoundsCylinder();
				super.logicalHeight = var3.modelHeight;
				Model var4;
				Model[] var5;
				if (!this.isLowDetail && super.graphic != -1 && super.spotAnimFrame != -1) {
					var4 = class86.getSpotAnimType(super.graphic).getModel(super.spotAnimFrame);
					if (var4 != null) {
						var4.offsetBy(0, -super.field1198, 0);
						var5 = new Model[] { var3, var4 };
						var3 = new Model(var5, 2);
					}
				}

				if (!this.isLowDetail && this.model != null) {
					if (Client.gameCycle >= this.animationCycleEnd) {
						this.model = null;
					}

					if (Client.gameCycle >= this.animationCycleStart && Client.gameCycle < this.animationCycleEnd) {
						var4 = this.model;
						var4.offsetBy(this.field845 - super.x, this.field858 - this.field842, this.field843 - super.y);
						if (super.orientation == 512) {
							var4.rotateY90Ccw();
							var4.rotateY90Ccw();
							var4.rotateY90Ccw();
						} else if (super.orientation == 1024) {
							var4.rotateY90Ccw();
							var4.rotateY90Ccw();
						} else if (super.orientation == 1536) {
							var4.rotateY90Ccw();
						}

						var5 = new Model[] { var3, var4 };
						var3 = new Model(var5, 2);
						if (super.orientation == 512) {
							var4.rotateY90Ccw();
						} else if (super.orientation == 1024) {
							var4.rotateY90Ccw();
							var4.rotateY90Ccw();
						} else if (super.orientation == 1536) {
							var4.rotateY90Ccw();
							var4.rotateY90Ccw();
							var4.rotateY90Ccw();
						}

						var4.offsetBy(super.x - this.field845, this.field842 - this.field858, super.y - this.field843);
					}
				}

				var3.field1874 = true;
				return var3;
			}
		}
	}

	final void method1195(int var1, int var2, byte var3) {
		if (super.animation != -1 && CombatInfo1.getAnimation(super.animation).priority == 1) {
			super.animation = -1;
		}

		super.field1185 = -1;
		if (var1 >= 0 && var1 < 104 && var2 >= 0 && var2 < 104) {
			if (super.pathX[0] >= 0 && super.pathX[0] < 104 && super.pathY[0] >= 0 && super.pathY[0] < 104) {
				if (var3 == 2) {
					BaseVarType.method9(this, var1, var2, (byte) 2);
				}

				this.method1186(var1, var2, var3);
			} else {
				this.method1196(var1, var2);
			}
		} else {
			this.method1196(var1, var2);
		}

	}

	void method1196(int var1, int var2) {
		super.queueSize = 0;
		super.field1216 = 0;
		super.field1158 = 0;
		super.pathX[0] = var1;
		super.pathY[0] = var2;
		int var3 = this.getSize();
		super.x = super.pathX[0] * 128 + var3 * 64;
		super.y = super.pathY[0] * 128 + var3 * 64;
	}

	final void method1186(int var1, int var2, byte var3) {
		if (super.queueSize < 9) {
			++super.queueSize;
		}

		for (int var4 = super.queueSize; var4 > 0; --var4) {
			super.pathX[var4] = super.pathX[var4 - 1];
			super.pathY[var4] = super.pathY[var4 - 1];
			super.pathTraversed[var4] = super.pathTraversed[var4 - 1];
		}

		super.pathX[0] = var1;
		super.pathY[0] = var2;
		super.pathTraversed[0] = var3;
	}

	@Override
	final boolean hasConfig() {
		return this.composition != null;
	}

	public static boolean method1232(IndexDataBase var0, IndexDataBase var1) {
		Area.field3461 = var1;
		if (!var0.method4624()) {
			return false;
		} else {
			class155.field2162 = var0.fileCount(35);
			Area.mapAreaType = new Area[class155.field2162];

			for (int var2 = 0; var2 < class155.field2162; ++var2) {
				byte[] var3 = var0.getConfigData(35, var2);
				if (var3 != null) {
					Area.mapAreaType[var2] = new Area(var2);
					Area.mapAreaType[var2].method4757(new Buffer(var3));
					Area.mapAreaType[var2].method4744();
				}
			}

			return true;
		}
	}

	static void method1230(IndexDataBase var0, IndexDataBase var1, boolean var2, int var3) {
		if (class90.field1387) {
			if (var3 == 4) {
				class90.loginIndex = 4;
			}

		} else {
			class90.loginIndex = var3;
			Rasterizer2D.reset();
			byte[] var4 = var0.takeRecordByNames("title.jpg", "");
			class321.field3938 = class185.method3448(var4);
			class90.field1381 = class321.field3938.method5847();
			if ((Client.flags & 536870912) != 0) {
				class33.logoSprite = FriendManager.getSprite(var1, "logo_deadman_mode", "");
			} else {
				class33.logoSprite = FriendManager.getSprite(var1, "logo", "");
			}

			IndexStoreActionHandler.field3398 = FriendManager.getSprite(var1, "titlebox", "");
			class90.field1388 = FriendManager.getSprite(var1, "titlebutton", "");
			class90.runeSprites = WorldMapManager.getIndexedSprites(var1, "runes", "");
			class57.titlemuteSprite = WorldMapManager.getIndexedSprites(var1, "title_mute", "");
			class90.field1363 = FriendManager.getSprite(var1, "options_radio_buttons,0", "");
			Frames.field2074 = FriendManager.getSprite(var1, "options_radio_buttons,4", "");
			class90.field1393 = FriendManager.getSprite(var1, "options_radio_buttons,2", "");
			class246.field2979 = FriendManager.getSprite(var1, "options_radio_buttons,6", "");
			NPC.field1318 = class90.field1363.width;
			class203.field2616 = class90.field1363.height;
			class21.field347 = new int[256];

			int var5;
			for (var5 = 0; var5 < 64; ++var5) {
				class21.field347[var5] = var5 * 262144;
			}

			for (var5 = 0; var5 < 64; ++var5) {
				class21.field347[var5 + 64] = var5 * 1024 + 16711680;
			}

			for (var5 = 0; var5 < 64; ++var5) {
				class21.field347[var5 + 128] = var5 * 4 + 16776960;
			}

			for (var5 = 0; var5 < 64; ++var5) {
				class21.field347[var5 + 192] = 16777215;
			}

			ScriptState.field762 = new int[256];

			for (var5 = 0; var5 < 64; ++var5) {
				ScriptState.field762[var5] = var5 * 1024;
			}

			for (var5 = 0; var5 < 64; ++var5) {
				ScriptState.field762[var5 + 64] = var5 * 4 + 65280;
			}

			for (var5 = 0; var5 < 64; ++var5) {
				ScriptState.field762[var5 + 128] = var5 * 262144 + 65535;
			}

			for (var5 = 0; var5 < 64; ++var5) {
				ScriptState.field762[var5 + 192] = 16777215;
			}

			GrandExchangeEvent.field298 = new int[256];

			for (var5 = 0; var5 < 64; ++var5) {
				GrandExchangeEvent.field298[var5] = var5 * 4;
			}

			for (var5 = 0; var5 < 64; ++var5) {
				GrandExchangeEvent.field298[var5 + 64] = var5 * 262144 + 255;
			}

			for (var5 = 0; var5 < 64; ++var5) {
				GrandExchangeEvent.field298[var5 + 128] = var5 * 1024 + 16711935;
			}

			for (var5 = 0; var5 < 64; ++var5) {
				GrandExchangeEvent.field298[var5 + 192] = 16777215;
			}

			class21.field344 = new int[256];
			MouseRecorder.field819 = new int['耀'];
			GrandExchangeEvents.field287 = new int['耀'];
			class44.method663((IndexedSprite) null);
			Huffman.field2513 = new int['耀'];
			AbstractSoundSystem.field1585 = new int['耀'];
			if (var2) {
				class90.username = "";
				class90.password = "";
			}

			Size.field369 = 0;
			class37.field501 = "";
			class90.field1385 = true;
			class90.worldSelectShown = false;
			if (!Client.preferences.muted) {
				IndexData var8 = PacketBuffer.indexTrack1;
				int var6 = var8.getFile("scape main");
				int var7 = var8.getChild(var6, "");
				class163.method3213(2, var8, var6, var7, 255, false);
			} else {
				class229.field2687 = 1;
				class185.field2511 = null;
				VertexNormal.field1931 = -1;
				GrandExchangeEvents.field284 = -1;
				class86.field1330 = 0;
				class229.field2692 = false;
				class2.field11 = 2;
			}

			GraphicsObject.sendConInfo(false);
			class90.field1387 = true;
			class90.field1359 = (MapLabel.canvasWidth - 765) / 2;
			class90.loginWindowX = class90.field1359 + 202;
			WorldComparator.field279 = class90.loginWindowX + 180;
			class321.field3938.method5856(class90.field1359, 0);
			class90.field1381.method5856(class90.field1359 + 382, 0);
			class33.logoSprite.method5825(class90.field1359 + 382 - class33.logoSprite.width / 2, 18);
		}
	}

	static final void method1231(String var0) {
		if (var0.equalsIgnoreCase("toggleroof")) {
			Client.preferences.hideRoofs = !Client.preferences.hideRoofs;
			MouseInput.method1062();
			if (Client.preferences.hideRoofs) {
				class57.sendGameMessage(99, "", "Roofs are now all hidden");
			} else {
				class57.sendGameMessage(99, "", "Roofs will only be removed selectively");
			}
		}

		if (var0.equalsIgnoreCase("displayfps")) {
			Client.displayFps = !Client.displayFps;
		}

		if (var0.equalsIgnoreCase("renderself")) {
			Client.field988 = !Client.field988;
		}

		if (var0.equalsIgnoreCase("mouseovertext")) {
			Client.field1017 = !Client.field1017;
		}

		if (Client.rights >= 2) {
			if (var0.equalsIgnoreCase("aabb")) {
				if (!class7.drawBoundingBoxes3D) {
					class7.drawBoundingBoxes3D = true;
					class7.boundingBox3DDrawMode = BoundingBox3DDrawMode.ALWAYS;
				} else if (BoundingBox3DDrawMode.ALWAYS == class7.boundingBox3DDrawMode) {
					class7.drawBoundingBoxes3D = true;
					class7.boundingBox3DDrawMode = BoundingBox3DDrawMode.ON_MOUSEOVER;
				} else {
					class7.drawBoundingBoxes3D = false;
				}
			}

			if (var0.equalsIgnoreCase("showcoord")) {
				Preferences.renderOverview.field4016 = !Preferences.renderOverview.field4016;
			}

			if (var0.equalsIgnoreCase("fpson")) {
				Client.displayFps = true;
			}

			if (var0.equalsIgnoreCase("fpsoff")) {
				Client.displayFps = false;
			}

			if (var0.equalsIgnoreCase("gc")) {
				System.gc();
			}

			if (var0.equalsIgnoreCase("clientdrop")) {
				if (Client.field915 > 0) {
					VarPlayerType.method4736();
				} else {
					Client.field918.method5211();
					class64.setGameState(40);
					FaceNormal.field2069 = Client.field957.getSocket();
					Client.field957.method2043();
				}
			}

			if (var0.equalsIgnoreCase("cs")) {
				class57.sendGameMessage(99, "", "" + Client.field917);
			}

			if (var0.equalsIgnoreCase("errortest") && Client.socketType == 2) {
				throw new RuntimeException();
			}
		}

		PacketNode var1 = WorldMapRectangle.method280(ClientPacket.field2415, Client.field957.field1484);
		var1.packetBuffer.putByte(var0.length() + 1);
		var1.packetBuffer.putString(var0);
		Client.field957.method2052(var1);
	}
}
