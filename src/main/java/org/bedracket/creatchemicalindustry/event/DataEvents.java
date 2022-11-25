package org.bedracket.creatchemicalindustry.event;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import org.bedracket.creatchemicalindustry.CreateCheicalIndustry;
import org.bedracket.creatchemicalindustry.recipe.CCIProcessingRecipeGen;

@Mod.EventBusSubscriber(modid = CreateCheicalIndustry.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataEvents {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        System.out.println("YESS");
        DataGenerator generator = event.getGenerator();
        CCIProcessingRecipeGen.registerAll(generator);
    }
}