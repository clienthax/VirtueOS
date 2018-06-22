package com.oldscape.shared.script.listeners;

import com.oldscape.server.game.model.entity.item.Item;
import com.oldscape.server.game.model.entity.player.Player;
import com.oldscape.server.game.model.region.Region;

public interface LocationListener {

    /**
     * Gets the location ids which are bound to this listener
     *
     * @return an array of integers containing the ids to bind to
     */
    public int[] getIDs();

    /**
     * Called whenever a account clicks an option on one of the bound locations
     *
     * @param player   The account who clicked the location
     * @param loc      The {@link SceneLocation} which was clicked
     * @param optionID The id of the option which was clicked. Ranges from 1 to 5,
     *                 with 6 being reserved for "Examine".
     * @return True if the interaction was handled, false otherwise
     */
    public boolean handleInteraction(Player player, Region loc, int optionID);

    /**
     * Called when an item is used on one of the bound locations
     *
     * @param player  The account who used the item on the location
     * @param loc     The {@link SceneLocation} on which the item was used
     * @param item    The {@link Item} which was used on the location
     * @param invSlot The backpack slot of the item
     * @return True if the interaction was handled, false otherwise
     */

    public boolean handleItemOnLoc(Player player, Region loc, Item item, int invSlot);

    /**
     * Gets the minimum number of tiles a account must be within to interact with
     * the location. If the account is not within the minimum range, they will
     * attempt to move towards the location before the interaction is handled
     *
     * @param loc      The {@link SceneLocation} to check
     * @param optionID The id of the option clicked
     * @return The number of tiles the account must be within to interact
     */
    public int getInteractRange(Region loc, int optionID);

}
