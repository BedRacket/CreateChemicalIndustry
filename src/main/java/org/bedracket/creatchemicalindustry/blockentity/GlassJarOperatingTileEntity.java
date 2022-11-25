package org.bedracket.creatchemicalindustry.blockentity;

import com.simibubi.create.content.contraptions.base.KineticTileEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

/**
 * Machine that needs glass jar above or below to operate
 */
public abstract class GlassJarOperatingTileEntity extends KineticTileEntity {
    public GlassJarOperatingTileEntity(BlockEntityType<?> typeIn, BlockPos pos, BlockState state) {
        super(typeIn, pos, state);
    }
}
