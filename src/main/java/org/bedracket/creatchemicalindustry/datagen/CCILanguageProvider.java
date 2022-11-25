package org.bedracket.creatchemicalindustry.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;
import org.bedracket.creatchemicalindustry.CreateChemicalIndustry;
import org.bedracket.creatchemicalindustry.init.ModItems;

public class CCILanguageProvider extends LanguageProvider {

    public CCILanguageProvider(DataGenerator gen, String locale) {
        super(gen, CreateChemicalIndustry.MOD_ID, locale);
    }

    @Override
    protected void addTranslations() {
        add(ModItems.CARBOHYDRATE_RAW_MATERIAL.get(), "Calcium Carbonate Dust");
        add(ModItems.STARCH_RAW_MATERIAL.get(), "Starch Raw Material");
        add(ModItems.LIMESTONE_DUST.get(), "Lime Stone Dust");
        add(ModItems.CALCIUM_CARBONATE_DUST.get(), "Calcium Carbonate Dust");
        add(ModItems.IMPURITY.get(), "Impurity");
    }
}
