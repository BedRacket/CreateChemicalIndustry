package org.bedracket.creatchemicalindustry.mixin;

import net.minecraft.world.entity.item.ItemEntity;
import net.minecraftforge.common.MinecraftForge;
import org.bedracket.creatchemicalindustry.api.event.ItemEntityTickEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemEntity.class)
public class MixinItemEntity {

    @Inject(method = "tick", at = @At("TAIL"))
    private void callItemTickEvent(CallbackInfo ci) {
        ItemEntityTickEvent event = new ItemEntityTickEvent(((ItemEntity) (Object) this));
        MinecraftForge.EVENT_BUS.post(event);
    }
}
