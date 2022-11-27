package org.bedracket.creatchemicalindustry.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import org.bedracket.creatchemicalindustry.CreateChemicalIndustry;
import org.bedracket.creatchemicalindustry.init.ModItems;
import org.bedracket.creatchemicalindustry.init.ModLiquids;

@Mod.EventBusSubscriber(modid = CreateChemicalIndustry.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CCIDataGenerator {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper helper = event.getExistingFileHelper();
        generator.addProvider(new CCICrushingRecipeGen(generator));
        generator.addProvider(new CCIMillingRecipeGen(generator));
        generator.addProvider(new CCIMixingRecipeGen(generator));
        generator.addProvider(new CCIItemModelProvider(generator, helper, ModItems.ITEMS));
        generator.addProvider(new CCIBucketItemModelProvider(generator, helper));
        generator.addProvider(new CCILanguageProvider(generator, "en_us"));
        generator.addProvider(new CCILanguageProviderZH(generator, "zh_cn"));
    }
}