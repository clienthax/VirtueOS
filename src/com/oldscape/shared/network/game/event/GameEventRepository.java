package com.oldscape.shared.network.game.event;

import com.oldscape.server.game.Server;
import com.oldscape.shared.event.Event;
import com.oldscape.shared.network.game.event.decoders.DummyDecoder;
import com.oldscape.shared.network.game.event.decoders.chat.CommandDecoder;
import com.oldscape.shared.network.game.event.decoders.chat.PublicChatDecoder;
import com.oldscape.shared.network.game.event.decoders.client.ClientDimensionsDecoder;
import com.oldscape.shared.network.game.event.decoders.client.ClientFocusDecoder;
import com.oldscape.shared.network.game.event.decoders.npc.*;
import com.oldscape.shared.network.game.event.decoders.object.*;
import com.oldscape.shared.network.game.event.decoders.walking.MiniMapWalkDecoder;
import com.oldscape.shared.network.game.event.decoders.walking.WalkDecoder;
import com.oldscape.shared.network.game.event.decoders.widget.WidgetActionDecoder;
import com.oldscape.shared.network.game.event.decoders.widget.WidgetButtonActionDecoder;
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
     * com.oldscape.shared.network.game.event.GameMessageDecoder}s. allocated with
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
        addMessageEncoder(WidgetSetRootEvent.class, new WidgetSetRootEventEncoder());
        addMessageEncoder(VarpEvent.class, new VarpEventEncoder());
        addMessageEncoder(WidgetOpenSubEvent.class, new WidgetOpenSubEventEncoder());
        addMessageEncoder(WidgetSetClickMaskEvent.class, new WidgetSetClickMaskEventEncoder());
        addMessageEncoder(CS2ScriptEvent.class, new CS2ScriptEventEncoder());
        addMessageEncoder(PlayerSynchronizationEvent.class, new PlayerSynchronizationEventEncoder());
        addMessageEncoder(NpcSynchronizationEvent.class, new NpcSynchronizationEventEncoder());
        addMessageEncoder(LogoutEvent.class, new LogoutEventEncoder());
        addMessageEncoder(SlottedItemsUpdateEvent.class, new SlottedItemsUpdateEventEncoder());
        addMessageEncoder(WidgetItemUpdateEvent.class, new WidgetItemUpdateEventEncoder());
        addMessageEncoder(WidgetSetTextEvent.class, new WidgetSetTextEventEncoder());
        addMessageEncoder(ExternalIPEvent.class, new ExternalIPEventEncoder());
        addMessageEncoder(WidgetMoveSubEvent.class, new WidgetMoveSubEventEncoder());
        addMessageEncoder(RunEnergyEvent.class, new RunEnergyEventEncoder());
        addMessageEncoder(SkillEvent.class, new SkillEventEncoder());
        addMessageEncoder(VarpResetEvent.class, new VarpResetEventEncoder());
        addMessageEncoder(VarpRecacheEvent.class, new VarpRecacheEventEncoder());
        addMessageEncoder(MusicEvent.class, new MusicEventEncoder());
        addMessageEncoder(MessageEvent.class, new MessageEventEncoder());
        addMessageEncoder(WidgetCloseSubEvent.class, new WidgetCloseSubEventEncoder());
        addMessageEncoder(CameraResetEvent.class, new CameraResetEventEncoder());
        addMessageEncoder(CameraRepositionEvent.class, new CameraRepositionEventEncoder());

        /* Ignored for now */
        // 93 = Mouse change listener.
        // 76 = ?
        // 64 = Mouse click listener.
        // 1 = Key stoke listener.
        addMessageDecoder(new int[]{1, 64, 76, 93}, new DummyDecoder());

        addMessageDecoder(12, new WalkDecoder());
        addMessageDecoder(13, new MiniMapWalkDecoder());
        addMessageDecoder(new int[] {14, 17, 18, 20, 33, 38, 41, 46, 95, 96}, new WidgetButtonActionDecoder());
        addMessageDecoder(57, new ClientDimensionsDecoder());
        addMessageDecoder(58, new ObjectFirstActionClickDecoder());
        addMessageDecoder(83, new ObjectSecondActionClickDecoder());
        addMessageDecoder(86, new ObjectThirdActionClickDecoder());
        addMessageDecoder(68, new ObjectForthActionClickDecoder());
        addMessageDecoder(60, new ObjectFifthActionClickDecoder());
        addMessageDecoder(37, new NpcFirstActionDecoder());
        addMessageDecoder(91, new NpcSecondActionDecoder());
        addMessageDecoder(81, new NpcThirdActionDecoder());
        addMessageDecoder(62, new NpcForthActionDecoder());
        addMessageDecoder(71, new NpcFifthActionDecoder());
        addMessageDecoder(25, new ClientFocusDecoder());
        addMessageDecoder(26, new PublicChatDecoder());
        addMessageDecoder(32, new CommandDecoder());

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
            throw new IllegalArgumentException("GameEventRepository: Opcode " + opcode + " is invalid!");
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
            System.err.println("GameEventRepository: No decoder for the opcode " + opcode + ".");
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
     * @param opcodes  The opcode of the {@link com.oldscape.shared.network.game.event.GameMessageDecoder} to be set.
     * @param decoder The {@link com.oldscape.shared.network.game.event.GameMessageDecoder} to add.
     */
    public void addMessageDecoder(int[] opcodes, GameMessageDecoder<? extends Event> decoder) {
        for (int o : opcodes)
            addMessageDecoder(o, decoder);
    }
}
