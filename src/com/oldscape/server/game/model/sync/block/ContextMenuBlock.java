package com.oldscape.server.game.model.sync.block;

/**
 * The context menu block {@link SynchronizationBlock}.
 *
 * @author Clienthax
 */
public final class ContextMenuBlock extends SynchronizationBlock {

    /**
     * The actions.
     */
    private final String firstAction;
    private final String secondAction;
    private final String thirdAction;


    /**
     * Creates the context menu block.
     */
    ContextMenuBlock(String firstAction, String secondAction, String thirdAction) {
        this.firstAction = firstAction;
        this.secondAction = secondAction;
        this.thirdAction = thirdAction;
    }

    public String getFirstAction() {
        return firstAction;
    }

    public String getSecondAction() {
        return secondAction;
    }

    public String getThirdAction() {
        return thirdAction;
    }

    /* (non-Javadoc)
     * @see com.oldscape.server.game.model.sync.block.SynchronizationBlock#getType()
     */
    @Override
    public BlockType getType() {
        return BlockType.CONTEXT_MENU;
    }

}