package com.oldscape.shared.network.game.event;

import com.oldscape.server.game.Server;
import com.oldscape.shared.event.Event;
import com.oldscape.shared.network.game.event.decoders.ClientDimensionsDecoder;
import com.oldscape.shared.network.game.event.decoders.DummyDecoder;
import com.oldscape.shared.network.game.event.decoders.chat.CommandDecoder;
import com.oldscape.shared.network.game.event.decoders.chat.PublicChatDecoder;
import com.oldscape.shared.network.game.event.decoders.client.ClientFocusDecoder;
import com.oldscape.shared.network.game.event.decoders.interfaces.ButtonClickDecoder;
import com.oldscape.shared.network.game.event.decoders.npcs.*;
import com.oldscape.shared.network.game.event.decoders.objects.*;
import com.oldscape.shared.network.game.event.decoders.walking.MiniMapWalkDecoder;
import com.oldscape.shared.network.game.event.decoders.walking.WalkDecoder;
import com.oldscape.shared.network.game.event.encoders.*;
import com.oldscape.shared.network.game.event.impl.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sean on 09/08/14.
 */
public final class GameEventRepository {

    /**
     * The maximum number of messages to be stored in the opcode table.
     */
    private static final int MAXIMUM_MESSAGES = 256;

    /*
     * The {@link java.util.Map} of {@link
     * com.etoile.shared.network.game.event.GameMessageDecoder}s. allocated with
     * the maximum size defined in the constant {@code MAXIMUM_MESSAGES}.
     */
    private final GameMessageDecoder<?>[] opcodeTable = new GameMessageDecoder<?>[MAXIMUM_MESSAGES];

    /**
     * The {@link java.util.Map} of
     * {@link com.oldscape.shared.network.game.event.GameMessageEncoder}s.
     */
    private final Map<Class<? extends Event>, GameMessageEncoder<? extends Event>> classTable = new HashMap<Class<? extends Event>, GameMessageEncoder<? extends Event>>();

    /**
     * Creates a new
     * {@link com.oldscape.shared.network.game.event.GameEventRepository}.
     */
    public GameEventRepository(Server server) {
        addMessageEncoder(RegionUpdateEvent.class, new RegionUpdateEventEncoder(server));
        addMessageEncoder(SetRootInterfaceEvent.class, new SetRootInterfaceEncoder());
        addMessageEncoder(VarpEvent.class, new VarpEventEncoder());
        addMessageEncoder(InterfaceOpenSubEvent.class, new InterfaceOpenSubEventEncoder());
        addMessageEncoder(InterfaceSetClickMaskEvent.class, new InterfaceSetClickMaskEventEncoder());
        addMessageEncoder(CS2ScriptEvent.class, new CS2ScriptEventEncoder());
        addMessageEncoder(PlayerSynchronizationEvent.class, new PlayerSynchronizationEventEncoder());
        addMessageEncoder(NpcSynchronizationEvent.class, new NpcSynchronizationEventEncoder());
        addMessageEncoder(LogoutEvent.class, new LogoutEventEncoder());
        addMessageEncoder(SlottedItemsUpdateEvent.class, new SlottedItemsUpdateEventEncoder());
        addMessageEncoder(ItemsUpdateEvent.class, new ItemsUpdateEventEncoder());
        addMessageEncoder(InterfaceSetTextEvent.class, new InterfaceSetTextEventEncoder());
        addMessageEncoder(ExternalIPEvent.class, new ExternalIPEventEncoder());
        addMessageEncoder(InterfaceMoveSubEvent.class, new InterfaceMoveSubEventEncoder());
        addMessageEncoder(RunEnergyEvent.class, new RunEnergyEventEncoder());
        addMessageEncoder(SkillEvent.class, new SkillEventEncoder());
        addMessageEncoder(VarpResetEvent.class, new VarpResetEventEncoder());
        addMessageEncoder(VarpRecacheEvent.class, new VarpRecacheEventEncoder());
        addMessageEncoder(MusicEvent.class, new MusicEventEncoder());
        addMessageEncoder(MessageEvent.class, new MessageEventEncoder());
        addMessageEncoder(InterfaceCloseSubEvent.class, new InterfaceCloseSubEventEncoder());

        //deob168
        //not sure on 93
        //64 fires for EVERY mouse click.. ugh
        addMessageDecoder(new int[]{76, 64, 93}, new DummyDecoder());

        addMessageDecoder(12, new WalkDecoder());//works
        addMessageDecoder(13, new MiniMapWalkDecoder());//works
        addMessageDecoder(17, new ButtonClickDecoder());//17 int clicks?

        addMessageDecoder(57, new ClientDimensionsDecoder());

        //Object options
        addMessageDecoder(58, new ObjectFirstActionClickDecoder());//First Option
        addMessageDecoder(83, new ObjectSecondActionClickDecoder());//Second Option
        addMessageDecoder(86, new ObjectThirdActionClickDecoder());//Third Option
        addMessageDecoder(68, new ObjectForthActionClickDecoder());//Forth Option
        addMessageDecoder(60, new ObjectFifthActionClickDecoder());//Fifth Option
        //29 examine object

        //Npc options
        addMessageDecoder(37, new NpcFirstClickDecoder());
        addMessageDecoder(91, new NpcSecondClickDecoder());
        addMessageDecoder(81, new NpcThirdClickDecoder());
        addMessageDecoder(62, new NpcForthClickDecoder());
        addMessageDecoder(71, new NpcFifthClickDecoder());
        //53 examine npc


        //Client info
        addMessageDecoder(25, new ClientFocusDecoder());

        //Chat
        addMessageDecoder(26, new PublicChatDecoder());
        addMessageDecoder(32, new CommandDecoder());//::commands



		/*
		addMessageDecoder(new int[] {24, 40, 41, 70, 212, 254}, new DummyDecoder());
		addMessageDecoder(new int[] {60, 77, 109, 135, 142, 152, 177, 195, 244, 246}, new InterfaceClickDecoder());
		*/


//		addMessageDecoder(1, new AttackNpcDecoder());
//		addMessageDecoder(new int[] { 13, 245, 76, 125, 240, 236, 108, 103, 104, 193, 112, 163 }, new InterfaceClickDecoder());
//		addMessageDecoder(232, new ItemOptionDecoder()); //
    }

    /**
     * Gets a {@link com.oldscape.shared.network.game.event.GameMessageDecoder} from
     * the {@code opcodeTable}.
     *
     * @param opcode The opcode of the {@link com.oldscape.shared.network.game.event.GameMessageDecoder}.
     * @return The {@link com.oldscape.shared.network.game.event.GameMessageDecoder}
     * based on the {@opcode opcode} or null, no data if not
     * present.
     */
    public GameMessageDecoder<?> getMessageDecoder(int opcode) {

        /**
         * If the opcode is less than 0 or greater than the maximum messages, an
         * {@link java.lang.IllegalAccessException} will be thrown.
         */
        if (opcode < 0 || opcode > MAXIMUM_MESSAGES) {
            throw new IllegalArgumentException("Error opcode invalid " + opcode);
        }

        /**
         * The {@link com.oldscape.server.rs3.shared.net.game.event.GameMessageDecoder}
         * from the {@code opcodeTable}.
         */
        GameMessageDecoder<?> decoder = opcodeTable[opcode];

        /**
         * If the decoder is null, a {@link java.lang.IllegalAccessException}
         * will be thrown.
         */
        if (decoder == null) {
            // System.err.println("No decoder for: " + opcode);
        }

        /**
         * The decoder.
         */
        return decoder;
    }

    /**
     * Gets a {@link com.oldscape.shared.network.game.event.GameMessageEncoder} from
     * the {@code classTable}.
     *
     * @param event The {@link java.lang.Class} of the
     *              {@link com.oldscape.shared.event.Event}.
     * @return The {@link com.oldscape.shared.network.game.event.GameMessageEncoder}
     * .
     */
    public GameMessageEncoder<?> getMessageEncoder(Class<? extends Event> event) {

        /**
         * Gets a {@link com.oldscape.server.rs3.shared.net.game.event.GameMessageEncoder}
         * based on the
         *
         * @param event
         *            .
         */
        GameMessageEncoder<?> encoder = classTable.get(event);

        /**
         * If the encoder is null, throw a
         * {@link java.lang.IllegalAccessException}.
         */
        if (encoder == null) {
            throw new IllegalArgumentException("No encoder defined for event " + event);
        }

        /**
         * The encoder.
         */
        return encoder;
    }

    /**
     * Adds a {@link com.oldscape.shared.network.game.event.GameMessageEncoder} to
     * the {@code classTable}.
     *
     * @param event   The {@link java.lang.Class} of the
     *                {@link com.oldscape.shared.event.Event}.
     * @param encoder THe
     *                {@link com.oldscape.shared.network.game.event.GameMessageEncoder}
     *                .
     */
    public void addMessageEncoder(Class<? extends Event> event, GameMessageEncoder<? extends Event> encoder) {
        classTable.put(event, encoder);
    }

    /**
     * Adds a {@link com.oldscape.shared.network.game.event.GameMessageDecoder}.
     *
     * @param opcode  The opcode of the
     *                {@link com.oldscape.shared.network.game.event.GameMessageDecoder}
     *                to be set.
     * @param decoder The
     *                {@link com.oldscape.shared.network.game.event.GameMessageDecoder}
     *                to add.
     */
    public void addMessageDecoder(int opcode, GameMessageDecoder<? extends Event> decoder) {

        /**
         * If the opcode is less than 0 or greater than the maximum messages, an
         * {@link java.lang.IllegalAccessException} will be thrown.
         */
        if (opcode < 0 || opcode > MAXIMUM_MESSAGES) {
            throw new IllegalArgumentException("Error opcode invalid " + opcode);
        }

        /**
         * Adds the
         * {@link com.oldscape.server.rs3.shared.net.game.event.GameMessageDecoder}.
         */
        opcodeTable[opcode] = decoder;
    }

    /**
     * Adds a {@link com.oldscape.shared.network.game.event.GameMessageDecoder}.
     *
     * @param opcode  The opcode of the {@link com.oldscape.shared.network.game.event.GameMessageDecoder} to be set.
     * @param decoder The {@link com.oldscape.shared.network.game.event.GameMessageDecoder} to add.
     */
    public void addMessageDecoder(int[] opcodes, GameMessageDecoder<? extends Event> decoder) {
        for (int o : opcodes)
            addMessageDecoder(o, decoder);
    }
}
