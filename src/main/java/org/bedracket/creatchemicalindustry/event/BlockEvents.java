package org.bedracket.creatchemicalindustry.event;

import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.bedracket.creatchemicalindustry.init.ModGases;
import org.bedracket.creatchemicalindustry.util.EventUtils;

@Mod.EventBusSubscriber
public class BlockEvents {

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void stopUse(PlayerInteractEvent.RightClickBlock event) {
        EventUtils.handleGasUseBlock(event, ModGases.ETHANOL_GAS.getBucket());
    }
}
