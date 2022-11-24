package org.bedracket.creatchemicalindustry.api.event;

import net.minecraft.world.entity.item.ItemEntity;
import net.minecraftforge.event.entity.item.ItemEvent;
import net.minecraftforge.eventbus.api.Cancelable;

/**
 * Called when an item tick in the world
 */
@Cancelable
public class ItemEntityTickEvent extends ItemEvent {

    /**
     * Creates a new event for an EntityItem.
     *
     * @param itemEntity The EntityItem for this event
     */
    public ItemEntityTickEvent(ItemEntity itemEntity) {
        super(itemEntity);
    }
}
