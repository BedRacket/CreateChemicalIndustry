package org.bedracket.creatchemicalindustry.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.loaders.DynamicBucketModelBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.bedracket.creatchemicalindustry.CreateChemicalIndustry;
import org.bedracket.creatchemicalindustry.init.ModGases;
import org.bedracket.creatchemicalindustry.init.ModLiquids;
import org.bedracket.creatchemicalindustry.register.GasDeferredRegister;
import org.bedracket.creatchemicalindustry.register.GasRegistryObject;
import org.bedracket.creatchemicalindustry.register.LiquidDeferredRegister;
import org.bedracket.creatchemicalindustry.register.LiquidRegistryObject;

public class CCIBucketItemModelProvider extends ItemModelProvider {

    public CCIBucketItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, CreateChemicalIndustry.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        registerBuckets(ModLiquids.LIQUIDS, ModGases.GASES);
    }

    protected void registerBuckets(LiquidDeferredRegister registerLiquid, GasDeferredRegister registerGas) {
        for (LiquidRegistryObject<?, ?, ?, ?> fluidRegistryObject : registerLiquid.getAllFluids()) {
            registerLiquidBucket(fluidRegistryObject);
        }
        for (GasRegistryObject<?, ?, ?, ?> gasRegistryObject : registerGas.getAllFluids()) {
            registerGasBucket(gasRegistryObject);
        }
    }

    protected void registerLiquidBucket(LiquidRegistryObject<?, ?, ?, ?> fluidRO) {
        withExistingParent(fluidRO.getBucket().getRegistryName().getPath(),
                new ResourceLocation("forge", "item/bucket"))
                .customLoader(DynamicBucketModelBuilder::begin)
                .fluid(fluidRO.getStillFluid());
    }

    protected void registerGasBucket(GasRegistryObject<?, ?, ?, ?> fluidRO) {
        withExistingParent(fluidRO.getBucket().getRegistryName().getPath(),
                new ResourceLocation("forge", "item/bucket"))
                .customLoader(DynamicBucketModelBuilder::begin)
                .fluid(fluidRO.getStillFluid());
    }
}
