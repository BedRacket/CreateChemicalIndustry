package org.bedracket.creatchemicalindustry.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;
import org.bedracket.creatchemicalindustry.CreateChemicalIndustry;
import org.bedracket.creatchemicalindustry.init.ModItems;

public class CCILanguageProviderZH extends LanguageProvider {

    public CCILanguageProviderZH(DataGenerator gen,  String locale) {
        super(gen, CreateChemicalIndustry.MOD_ID, locale);
    }

    @Override
    protected void addTranslations() {
        add(ModItems.CARBOHYDRATE_RAW_MATERIAL.get(), "碳酸钙粉尘");
        add(ModItems.STARCH_RAW_MATERIAL.get(), "淀粉原料");
        add(ModItems.LIMESTONE_DUST.get(), "石灰石粉尘");
        add(ModItems.CALCIUM_CARBONATE_DUST.get(), "碳酸钙粉尘");
        add(ModItems.IMPURITY.get(), "杂质");
        add("itemGroup.create_chemical_industry.material", "机械动力化学工艺丨材料");
    }
}
