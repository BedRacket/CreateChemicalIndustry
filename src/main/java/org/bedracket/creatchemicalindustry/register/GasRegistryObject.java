package org.bedracket.creatchemicalindustry.register;

import java.util.Objects;
import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraftforge.registries.RegistryObject;
import org.bedracket.creatchemicalindustry.gas.CCIFlowingGas.Source;
import org.bedracket.creatchemicalindustry.gas.CCIFlowingGas.Flowing;

/**
 * Code from Mekanism/src/api/java/mekanism/api/providers/IFluidProvider.java
 * @author mekanism <a href="https://github.com/mekanism/">...</a>
 * @license MIT
 */
@ParametersAreNonnullByDefault
public class GasRegistryObject<STILL extends Source, FLOWING extends Flowing, BLOCK extends LiquidBlock, BUCKET extends BucketItem> {

    private RegistryObject<STILL> stillRO;
    private RegistryObject<FLOWING> flowingRO;
    private RegistryObject<BLOCK> blockRO;
    private RegistryObject<BUCKET> bucketRO;

    public STILL getStillFluid() {
        return stillRO.get();
    }

    public FLOWING getFlowingFluid() {
        return flowingRO.get();
    }

    public BLOCK getBlock() {
        return blockRO.get();
    }

    public BUCKET getBucket() {
        return bucketRO.get();
    }

    //Make sure these update methods are package local as only the FluidDeferredRegister should be messing with them
    void updateStill(RegistryObject<STILL> stillRO) {
        this.stillRO = Objects.requireNonNull(stillRO);
    }

    void updateFlowing(RegistryObject<FLOWING> flowingRO) {
        this.flowingRO = Objects.requireNonNull(flowingRO);
    }

    void updateBlock(RegistryObject<BLOCK> blockRO) {
        this.blockRO = Objects.requireNonNull(blockRO);
    }

    void updateBucket(RegistryObject<BUCKET> bucketRO) {
        this.bucketRO = Objects.requireNonNull(bucketRO);
    }

    @Nonnull
    public STILL getFluid() {
        //Default our fluid to being the still variant
        return getStillFluid();
    }
}