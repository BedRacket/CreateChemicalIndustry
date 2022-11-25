package org.bedracket.creatchemicalindustry.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import org.bedracket.creatchemicalindustry.CreateCheicalIndustry;

@Mod.EventBusSubscriber(modid = CreateCheicalIndustry.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModDataGenerator {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        System.out.println("YESS");
        DataGenerator generator = event.getGenerator();
        generator.addProvider(new CCICrushingRecipeGen(generator));
    }
}