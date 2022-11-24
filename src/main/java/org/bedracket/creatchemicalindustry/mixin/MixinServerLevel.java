package org.bedracket.creatchemicalindustry.mixin;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraftforge.common.MinecraftForge;
import org.bedracket.creatchemicalindustry.api.event.ItemSpawnEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ServerLevel.class)
public class MixinServerLevel {

    @Inject(method = "addFreshEntity", at = @At("HEAD"))
    private void callItemSpawnEvent(Entity pEntity, CallbackInfoReturnable<Boolean> cir) {
        if (pEntity instanceof ItemEntity) {
            ItemSpawnEvent event = new ItemSpawnEvent((ItemEntity) pEntity);
            MinecraftForge.EVENT_BUS.post(event);
        }
    }
}
