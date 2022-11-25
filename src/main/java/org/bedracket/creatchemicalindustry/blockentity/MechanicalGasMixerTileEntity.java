package org.bedracket.creatchemicalindustry.blockentity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class MechanicalGasMixerTileEntity extends GlassJarOperatingTileEntity{
    public MechanicalGasMixerTileEntity(BlockEntityType<?> typeIn, BlockPos pos, BlockState state) {
        super(typeIn, pos, state);
    }
}
