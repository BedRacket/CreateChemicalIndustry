package org.bedracket.creatchemicalindustry.gas;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import org.bedracket.creatchemicalindustry.api.gas.Gas;
import org.bedracket.creatchemicalindustry.init.ModBlockProperties;

//TODO improve gas block
@MethodsReturnNonnullByDefault
public abstract class AbstractGasBlock extends FlowingFluid implements Gas {

    public static final BooleanProperty STEAMING = ModBlockProperties.STEAMING;
    public static final IntegerProperty LEVEL_STEAMING = ModBlockProperties.LEVEL_STEAMING;

    @Override
    protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> pBuilder) {
        pBuilder.add(STEAMING);
    }


    public FluidState getFlowing(int pLevel, boolean pFalling) {
        return this.getFlowing().defaultFluidState().setValue(LEVEL_STEAMING, pLevel).setValue(STEAMING, pFalling);
    }

}
