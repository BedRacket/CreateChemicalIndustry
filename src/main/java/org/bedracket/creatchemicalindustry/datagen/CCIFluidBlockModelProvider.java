package org.bedracket.creatchemicalindustry.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.bedracket.creatchemicalindustry.CreateChemicalIndustry;
import org.bedracket.creatchemicalindustry.register.LiquidDeferredRegister;

public class CCIFluidBlockModelProvider extends BlockModelProvider {

    protected final LiquidDeferredRegister deferredRegister;

    public CCIFluidBlockModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper, LiquidDeferredRegister deferredRegister) {
        super(generator, CreateChemicalIndustry.MOD_ID, existingFileHelper);
        this.deferredRegister = deferredRegister;
    }

    @Override
    protected void registerModels() {

    }
}
