package org.bedracket.creatchemicalindustry.init;

import net.minecraft.world.item.BucketItem;
import net.minecraft.world.level.block.LiquidBlock;
import org.bedracket.creatchemicalindustry.CreateChemicalIndustry;
import net.minecraftforge.fluids.ForgeFlowingFluid.Flowing;
import net.minecraftforge.fluids.ForgeFlowingFluid.Source;
import org.bedracket.creatchemicalindustry.register.LiquidDeferredRegister;
import org.bedracket.creatchemicalindustry.register.LiquidRegistryObject;

public class ModLiquids {
    public static final LiquidDeferredRegister LIQUIDS = new LiquidDeferredRegister(CreateChemicalIndustry.MOD_ID);

    public static final LiquidRegistryObject<Source, Flowing, LiquidBlock, BucketItem> ETHANOL
            = LIQUIDS.registerLiquidChemical("ethanol", 0xFFFFFFFF, 0, 300F, 0.789F);

    public static final LiquidRegistryObject<Source, Flowing, LiquidBlock, BucketItem> FERMENTATION_BROTH
            = LIQUIDS.registerLiquidChemical("fermentation_broth", 0xFF00DD00, 0, 300F, 1F);
}
