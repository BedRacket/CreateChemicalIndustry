package org.bedracket.creatchemicalindustry.util;

import com.simibubi.create.content.contraptions.fluids.actors.ItemDrainBlock;
import com.simibubi.create.content.contraptions.fluids.actors.SpoutBlock;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

public class EventUtils {

    public static void handleGasUseBlock(PlayerInteractEvent.RightClickBlock event,Item fluidItem) {
        Block block = event.getWorld().getBlockState(event.getPos()).getBlock();
        Player player = event.getPlayer();
        ItemStack itemStack = player.getMainHandItem();
        if (block instanceof SpoutBlock && itemStack.is(fluidItem)) {
            event.setCancellationResult(InteractionResult.PASS);
        }
        if (block instanceof ItemDrainBlock && itemStack.is(fluidItem)) {
            event.setCancellationResult(InteractionResult.PASS);
        }
    }
}
