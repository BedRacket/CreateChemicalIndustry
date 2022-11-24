package org.bedracket.creatchemicalindustry.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.MinecraftForge;
import org.bedracket.creatchemicalindustry.api.event.BlockDropEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = ForgeHooks.class, remap = false)
public abstract class MixinForgeHooks {

    @Inject(method = "onBlockBreakEvent", at =@At(value = "RETURN"))
    private static void callEvent(Level level, GameType gameType, ServerPlayer entityPlayer, BlockPos pos, CallbackInfoReturnable<Integer> cir) {
        BlockState dropState = level.getBlockState(pos);
        BlockDropEvent blockDropEvent = new BlockDropEvent(level, pos, dropState, entityPlayer);
        MinecraftForge.EVENT_BUS.post(blockDropEvent);
    }
}

