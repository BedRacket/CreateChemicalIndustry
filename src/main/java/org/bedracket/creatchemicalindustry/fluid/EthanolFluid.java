package org.bedracket.creatchemicalindustry.fluid;

import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fluids.FluidAttributes;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.resources.ResourceLocation;
import org.bedracket.creatchemicalindustry.init.ModBlocks;
import org.bedracket.creatchemicalindustry.init.ModFluids;
import org.bedracket.creatchemicalindustry.init.ModItems;

public abstract class EthanolFluid extends ForgeFlowingFluid {
    public static final ForgeFlowingFluid.Properties PROPERTIES =
            new ForgeFlowingFluid
            .Properties(ModFluids.ETHANOL_FLUID,
            ModFluids.FLOWING_ETHANOL_FLUID,
            FluidAttributes.builder(
                    new ResourceLocation("create_chemical_industry:block/ethanol_overlay"),
                    new ResourceLocation("create_chemical_industry:block/ethanol_flow")
            )).explosionResistance(100f)
            .bucket(ModItems.ETHANOL_FLUID_BUCKET).block(() ->
                    (LiquidBlock) ModBlocks.ETHANOL_FLUID_BLOCK.get());

    private EthanolFluid() {
        super(PROPERTIES);
    }

    public static class Source extends EthanolFluid {
        public Source() {
            super();
        }

        public int getAmount(FluidState state) {
            return 8;
        }

        public boolean isSource(FluidState state) {
            return true;
        }
    }

    public static class Flowing extends EthanolFluid {
        public Flowing() {
            super();
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
}
