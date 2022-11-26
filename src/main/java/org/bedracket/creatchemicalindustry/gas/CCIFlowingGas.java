package org.bedracket.creatchemicalindustry.gas;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlockContainer;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraftforge.fluids.ForgeFlowingFluid;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public abstract class CCIFlowingGas extends ForgeFlowingFluid {
    protected CCIFlowingGas(Properties properties) {
        super(properties);
    }


    public void tick(Level pLevel, BlockPos pPos, FluidState pState) {
        if (!pState.isSource()) {
            FluidState fluidstate = this.getNewLiquid(pLevel, pPos, pLevel.getBlockState(pPos));
            int i = this.getSpreadDelay(pLevel, pPos, pState, fluidstate);
            if (fluidstate.isEmpty()) {
                pState = fluidstate;
                pLevel.setBlock(pPos, Blocks.AIR.defaultBlockState(), 3);
            } else if (!fluidstate.equals(pState)) {
                pState = fluidstate;
                BlockState blockstate = fluidstate.createLegacyBlock();
                pLevel.setBlock(pPos, blockstate, 2);
                pLevel.scheduleTick(pPos, fluidstate.getType(), i);
                pLevel.updateNeighborsAt(pPos, blockstate.getBlock());
            }
        }

        this.spread(pLevel, pPos, pState);
    }


    public static class Flowing extends CCIFlowingGas
    {
        public Flowing(Properties properties)
        {
            super(properties);
            registerDefaultState(getStateDefinition().any().setValue(LEVEL, 7));
        }

        protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
            super.createFluidStateDefinition(builder);
            builder.add(LEVEL);
        }

        public int getAmount(FluidState state) {
            return state.getValue(LEVEL);
        }

        public boolean isSource(FluidState state) {
            return false;
        }
    }

    public static class Source extends CCIFlowingGas {
        public Source(Properties properties)
        {
            super(properties);
        }

        public int getAmount(FluidState state) {
            return 8;
        }

        public boolean isSource(FluidState state) {
            return true;
        }
    }
}
