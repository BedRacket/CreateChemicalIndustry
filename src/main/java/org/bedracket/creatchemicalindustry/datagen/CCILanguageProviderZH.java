package org.bedracket.creatchemicalindustry.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;
import org.bedracket.creatchemicalindustry.CreateChemicalIndustry;
import org.bedracket.creatchemicalindustry.init.ModBlocks;
import org.bedracket.creatchemicalindustry.init.ModItems;
import org.bedracket.creatchemicalindustry.init.ModLiquids;

public class CCILanguageProviderZH extends LanguageProvider {

    public CCILanguageProviderZH(DataGenerator gen,  String locale) {
        super(gen, CreateChemicalIndustry.MOD_ID, locale);
    }

    @Override
    protected void addTranslations() {
        add(ModItems.CARBOHYDRATE_RAW_MATERIAL.get(), "糖类原料");
        add(ModItems.STARCH_RAW_MATERIAL.get(), "淀粉原料");
        add(ModItems.LIMESTONE_DUST.get(), "石灰石粉");
        add(ModItems.CALCIUM_CARBONATE_DUST.get(), "碳酸钙粉");
        add(ModItems.CALCIUM_OXIDE_DUST.get(), "氧化钙粉");
        add(ModItems.IMPURITY.get(), "杂质");
        add(ModLiquids.ETHANOL.getBlock(), "乙醇流体");
        add(ModLiquids.ETHANOL.getBucket(), "乙醇流体桶");
        add("itemGroup.create_chemical_industry.material", "机械动力化学工艺丨材料");
        add("itemGroup.create_chemical_industry.facility", "设备");
        add(ModBlocks.GLASS_JAR.get(), "玻璃罐");
    }
}
