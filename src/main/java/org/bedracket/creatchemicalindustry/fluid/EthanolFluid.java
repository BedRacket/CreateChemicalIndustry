package org.bedracket.creatchemicalindustry.fluid;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;

public class EthanolFluid extends Fluid {

    @Override
    public Item getBucket() {
        return null;
    }

    @Override
    protected boolean canBeReplacedWith(FluidState pState, BlockGetter pLevel, BlockPos pPos, Fluid pFluid, Direction pDirection) {
        return false;
    }

    @Override
    protected Vec3 getFlow(BlockGetter pBlockReader, BlockPos pPos, FluidState pFluidState) {
        return null;
    }

    @Override
    public int getTickDelay(LevelReader pLevel) {
        return 0;
    }

    @Override
    protected float getExplosionResistance() {
        return 0;
    }

    @Override
    public float getHeight(FluidState pState, BlockGetter pLevel, BlockPos pPos) {
        return 0;
    }

    @Override
    public float getOwnHeight(FluidState pState) {
        return 0;
    }

    @Override
    protected BlockState createLegacyBlock(FluidState pState) {
        return null;
    }

    @Override
    public boolean isSource(FluidState pState) {
        return false;
    }

    @Override
    public int getAmount(FluidState pState) {
        return 0;
    }

    @Override
    public VoxelShape getShape(FluidState pState, BlockGetter pLevel, BlockPos pPos) {
        return null;
    }
}
