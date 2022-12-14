package org.bedracket.creatchemicalindustry.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;
import org.bedracket.creatchemicalindustry.CreateChemicalIndustry;
import org.bedracket.creatchemicalindustry.init.ModBlocks;
import org.bedracket.creatchemicalindustry.init.ModItems;
import org.bedracket.creatchemicalindustry.init.ModLiquids;

public class CCILanguageProvider extends LanguageProvider {

    public CCILanguageProvider(DataGenerator gen, String locale) {
        super(gen, CreateChemicalIndustry.MOD_ID, locale);
    }

    @Override
    protected void addTranslations() {
        add(ModItems.CARBOHYDRATE_RAW_MATERIAL.get(), "Carbohydrate Raw Material");
        add(ModItems.STARCH_RAW_MATERIAL.get(), "Starch Raw Material");
        add(ModItems.LIMESTONE_DUST.get(), "Lime Stone Dust");
        add(ModItems.CALCIUM_CARBONATE_DUST.get(), "Calcium Carbonate Dust");
        add(ModItems.IMPURITY.get(), "Impurity");
        add(ModItems.CALCIUM_OXIDE_DUST.get(), "Calcium Oxide Dust");
        add(ModLiquids.ETHANOL.getBlock(), "Ethanol");
        add(ModLiquids.ETHANOL.getBucket(), "Ethanol Bucket");
        add(ModLiquids.FERMENTATION_BROTH.getBlock(), "Fermentation Broth");
        add(ModLiquids.FERMENTATION_BROTH.getBucket(), "Fermentation Broth Bucket");
        add("itemGroup.create_chemical_industry.material", "Material");
        add("itemGroup.create_chemical_industry.facility", "Facility");
        add(ModBlocks.GLASS_JAR.get(), "Glass Jar");
    }
}
