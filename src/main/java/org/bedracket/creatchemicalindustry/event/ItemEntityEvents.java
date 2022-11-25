package org.bedracket.creatchemicalindustry.event;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.bedracket.creatchemicalindustry.api.event.ItemEntityTickEvent;
import org.bedracket.creatchemicalindustry.init.ModItems;

@Mod.EventBusSubscriber
public class ItemEntityEvents {

    @SubscribeEvent
    public static void spawnFire(ItemEntityTickEvent event) {
        ItemEntity itemEntity = event.getEntityItem();
        ItemStack dropItem = itemEntity.getItem();
        Level level = event.getEntityItem().getLevel();
        if (dropItem.is(ModItems.LIMESTONE_DUST.get())) {
            if (itemEntity.isInWater() || level.isRainingAt(itemEntity.getOnPos().above())) {
                if (itemEntity.getAge() == 4) {
                    itemEntity.remove(Entity.RemovalReason.KILLED);
                    level.setBlockAndUpdate(itemEntity.getOnPos(), Blocks.FIRE.defaultBlockState());
                    level.updateNeighborsAt(itemEntity.getOnPos(), Blocks.FIRE);
                    level.gameEvent(itemEntity, GameEvent.BLOCK_CHANGE, itemEntity.getOnPos());
                }
            }
        }
    }

}
