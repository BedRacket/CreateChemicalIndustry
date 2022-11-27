package org.bedracket.creatchemicalindustry.init;

import net.minecraft.world.item.BucketItem;
import net.minecraft.world.level.block.LiquidBlock;
import org.bedracket.creatchemicalindustry.CreateChemicalIndustry;
import org.bedracket.creatchemicalindustry.gas.CCIFlowingGas.Flowing;
import org.bedracket.creatchemicalindustry.gas.CCIFlowingGas.Source;
import org.bedracket.creatchemicalindustry.register.GasDeferredRegister;
import org.bedracket.creatchemicalindustry.register.GasRegistryObject;

public class ModGases {
    public static final GasDeferredRegister GASES = new GasDeferredRegister(CreateChemicalIndustry.MOD_ID);

    public static final GasRegistryObject<Source, Flowing, LiquidBlock, BucketItem> ETHANOL_GAS
            = GASES.registerLiquidChemical("ethanol_gas", 0x55FFFFFF, 0, 300F, 0.789F);

}
