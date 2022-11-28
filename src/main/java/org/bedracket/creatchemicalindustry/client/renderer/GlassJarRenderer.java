package org.bedracket.creatchemicalindustry.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.simibubi.create.content.contraptions.processing.BasinRenderer;
import com.simibubi.create.content.contraptions.processing.BasinTileEntity;
import com.simibubi.create.foundation.fluid.FluidRenderer;
import com.simibubi.create.foundation.tileEntity.behaviour.fluid.SmartFluidTankBehaviour;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.util.Mth;
import net.minecraftforge.fluids.FluidStack;

/**
 * Code from com\simibubi\create\content\contraptions\processing\BasinRenderer.class
 * @author Creators-of-Create <a href="https://github.com/Creators-of-Create/Create">...</a>
 * @license MIT
 */
public class GlassJarRenderer extends BasinRenderer {

    public GlassJarRenderer(BlockEntityRendererProvider.Context context) {
        super(context);
    }
    protected float renderFluids(BasinTileEntity basin, float partialTicks, PoseStack ms, MultiBufferSource buffer, int light, int overlay) {
        SmartFluidTankBehaviour inputFluids = (SmartFluidTankBehaviour)basin.getBehaviour(SmartFluidTankBehaviour.INPUT);
        SmartFluidTankBehaviour outputFluids = (SmartFluidTankBehaviour)basin.getBehaviour(SmartFluidTankBehaviour.OUTPUT);
        SmartFluidTankBehaviour[] tanks = new SmartFluidTankBehaviour[]{inputFluids, outputFluids};
        float totalUnits = basin.getTotalFluidUnits(partialTicks);
        if (totalUnits < 1.0F) {
            return 0.0F;
        } else {
            float fluidLevel = Mth.clamp(totalUnits / 2000.0F, 0.0F, 1.0F);
            fluidLevel = 1.0F - (1.0F - fluidLevel) * (1.0F - fluidLevel);
            float xMin = 0.125F;
            float xMax = 0.125F;
            float yMin = 0.125F;
            float yMax = 0.75F * fluidLevel;
            float zMin = 0.125F;
            float zMax = 0.875F;
            SmartFluidTankBehaviour[] var18 = tanks;
            int var19 = tanks.length;

            for(int var20 = 0; var20 < var19; ++var20) {
                SmartFluidTankBehaviour behaviour = var18[var20];
                if (behaviour != null) {
                    SmartFluidTankBehaviour.TankSegment[] var22 = behaviour.getTanks();
                    int var23 = var22.length;

                    for(int var24 = 0; var24 < var23; ++var24) {
                        SmartFluidTankBehaviour.TankSegment tankSegment = var22[var24];
                        FluidStack renderedFluid = tankSegment.getRenderedFluid();
                        if (!renderedFluid.isEmpty()) {
                            float units = tankSegment.getTotalUnits(partialTicks);
                            if (!(units < 1.0F)) {
                                float partial = Mth.clamp(units / totalUnits, 0.0F, 1.0F);
                                xMax += partial * 12.0F / 16.0F;
                                FluidRenderer.renderFluidBox(renderedFluid, xMin, 1F - yMax, 0.125F, xMax, 0.87F, 0.875F, buffer, ms, light, false);
                                xMin = xMax;
                            }
                        }
                    }
                }
            }

            return yMax;
        }
    }
}
