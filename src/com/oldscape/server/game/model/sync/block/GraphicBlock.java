package com.oldscape.server.game.model.sync.block;

import com.oldscape.server.game.model.sync.reference.Graphic;

/**
 * The graphic {@link SynchronizationBlock}. Both players and npcs can utilise
 * this block.
 *
 * @author Graham
 */
public final class GraphicBlock extends SynchronizationBlock {

    /**
     * The graphic.
     */
    private final Graphic graphic;

    /**
     * Creates the graphic block.
     *
     * @param graphic The graphic.
     */
    GraphicBlock(Graphic graphic) {
        this.graphic = graphic;
    }

    /**
     * Gets the {@link Graphic}.
     *
     * @return The graphic.
     */
    public Graphic getGraphic() {
        return graphic;
    }

    /* (non-Javadoc)
     * @see com.oldscape.server.game.model.sync.block.SynchronizationBlock#getType()
     */
    @Override
    public BlockType getType() {
        return BlockType.GRAPHIC;
    }

}