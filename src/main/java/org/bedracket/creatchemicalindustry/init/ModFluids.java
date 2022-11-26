package org.bedracket.creatchemicalindustry.init;

import net.minecraft.world.item.BucketItem;
import net.minecraft.world.level.block.LiquidBlock;
import org.bedracket.creatchemicalindustry.CreateChemicalIndustry;
import net.minecraftforge.fluids.ForgeFlowingFluid.Flowing;
import net.minecraftforge.fluids.ForgeFlowingFluid.Source;
import org.bedracket.creatchemicalindustry.register.FluidDeferredRegister;
import org.bedracket.creatchemicalindustry.register.FluidRegistryObject;

public class ModFluids {
    public static final FluidDeferredRegister FLUIDS = new FluidDeferredRegister(CreateChemicalIndustry.MOD_ID);

    public static final FluidRegistryObject<Source, Flowing, LiquidBlock, BucketItem> ETHANOL
            = FLUIDS.registerLiquidChemical("ethanol", 0xFFFFFFFF, 0, 300F, 0.789F);

    public static final FluidRegistryObject<Source, Flowing, LiquidBlock, BucketItem> FERMENTATION_BROTH
            = FLUIDS.registerLiquidChemical("fermentation_broth", 0xFF00DD00, 0, 300F, 1F);
}
