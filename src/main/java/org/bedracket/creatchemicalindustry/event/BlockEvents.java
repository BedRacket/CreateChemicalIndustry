package org.bedracket.creatchemicalindustry.event;

import com.simibubi.create.content.contraptions.fluids.actors.ItemDrainBlock;
import com.simibubi.create.content.contraptions.fluids.actors.SpoutBlock;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.bedracket.creatchemicalindustry.init.ModGases;

@Mod.EventBusSubscriber
public class BlockEvents {

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void stopUse(PlayerInteractEvent.RightClickBlock event) {
        Block block = event.getWorld().getBlockState(event.getPos()).getBlock();
        Player player = event.getPlayer();
        ItemStack itemStack = player.getMainHandItem();
        if (block instanceof ItemDrainBlock && itemStack.is(ModGases.ETHANOL_GAS.getBucket())) {
            event.setCancellationResult(InteractionResult.FAIL);
        }
        if (block instanceof SpoutBlock && itemStack.is(ModGases.ETHANOL_GAS.getBucket())) {
            event.setCancellationResult(InteractionResult.FAIL);
        }
    }
}
