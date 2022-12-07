package org.bedracket.creatchemicalindustry.event;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import org.bedracket.creatchemicalindustry.client.renderer.GlassJarRenderer;
import org.bedracket.creatchemicalindustry.client.renderer.SimpleNuclearReactorRenderer;
import org.bedracket.creatchemicalindustry.init.ModBlockEntities;
import org.bedracket.creatchemicalindustry.init.ModBlocks;
import org.bedracket.creatchemicalindustry.init.ModGases;
import org.bedracket.creatchemicalindustry.init.ModLiquids;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientRegisterEvents {

    @SubscribeEvent
    public static void registerRender(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(
                ModBlockEntities.GLASS_JAR.get(),
                GlassJarRenderer::new);
        event.registerBlockEntityRenderer(
                ModBlockEntities.SIMPLE_NUCLEAR_REACTOR.get(),
                SimpleNuclearReactorRenderer::new);
    }

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(ModLiquids.ETHANOL.getFluid(),
                renderType -> renderType == RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModLiquids.ETHANOL.getFlowingFluid(),
                renderType -> renderType == RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModLiquids.FERMENTATION_BROTH.getFluid(),
                renderType -> renderType == RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModLiquids.FERMENTATION_BROTH.getFlowingFluid(),
                renderType -> renderType == RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModLiquids.IMPURE_ETHANOL.getFluid(),
                renderType -> renderType == RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModLiquids.IMPURE_ETHANOL.getFlowingFluid(),
                renderType -> renderType == RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModGases.ETHANOL_GAS.getFluid(),
                renderType -> renderType == RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModGases.ETHANOL_GAS.getFlowingFluid(),
                renderType -> renderType == RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.GLASS_JAR.get(),
                renderType -> renderType == RenderType.cutout());
    }
}
