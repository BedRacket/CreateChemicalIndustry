package org.bedracket.creatchemicalindustry.api.event;

import net.minecraft.world.entity.item.ItemEntity;
import net.minecraftforge.event.entity.item.ItemEvent;

/**
 * Used when Item spawn in the world
 */
public class ItemSpawnEvent extends ItemEvent {

    /**
     * Creates a new event for an EntityItem.
     *
     * @param itemEntity The EntityItem for this event
     */
    public ItemSpawnEvent(ItemEntity itemEntity) {
        super(itemEntity);
    }
}
