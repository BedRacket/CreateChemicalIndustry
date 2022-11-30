package org.bedracket.creatchemicalindustry.blockentity;

import com.google.common.collect.ImmutableList;
import com.simibubi.create.content.contraptions.processing.BasinTileEntity;
import com.simibubi.create.foundation.item.SmartInventory;
import com.simibubi.create.foundation.tileEntity.behaviour.fluid.SmartFluidTankBehaviour;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.IFluidHandler;
import org.bedracket.creatchemicalindustry.init.ModBlockEntities;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Collections;

/**
 * Code from com\simibubi\create\content\contraptions\processing\BasinTileEntity.java
 * @author Creators-of-Create <a href="https://github.com/Creators-of-Create/Create">...</a>
 * @license MIT
 */
public class GlassJarTileEntity extends BasinTileEntity {
    public GlassJarTileEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.GLASS_JAR.get(), pos, state);
    }

    public void clearItemInventory(SmartInventory inventory) {
        for (int i = 0; i < inventory.getSlots(); i++) {
            ItemStack itemStack = inventory.getItem(i);
            var pos = this.getBlockPos();
            double x = pos.getX() + 0.5;
            double y = pos.getY() + 0.5;
            double z = pos.getZ() + 0.5;
            if (level != null) {
                level.addFreshEntity(new ItemEntity(level, x, y, z, itemStack.copy()));
            }
            this.inputInventory.removeItem(i, itemStack.getCount());
        }
    }

    public void clearFluidInventory(SmartFluidTankBehaviour tankBehaviour) {
        IFluidHandler handler = (IFluidHandler)tankBehaviour.getCapability().orElse(null);

        for(int slot = 0; slot < handler.getTanks(); ++slot) {
            FluidStack fs = handler.getFluidInTank(slot).copy();
            if (fs.getAmount() >= 1000) {
                BlockState blockstate = fs.getFluid().defaultFluidState().createLegacyBlock();
                level.setBlock(getBlockPos().below(), blockstate, 2);
            }
            handler.drain(fs, IFluidHandler.FluidAction.EXECUTE);
        }
    }

    public void tick() {
        super.tick();
        if (level.getBlockState(this.getBlockPos().below()).is(Blocks.AIR)) {
            if (!this.inputInventory.isEmpty()) {
                clearItemInventory(this.inputInventory);
            }
            if (!this.outputInventory.isEmpty()) {
                clearItemInventory(this.outputInventory);
            }
            if (!this.inputTank.isEmpty()) {
                clearFluidInventory(this.inputTank);
            }
            if (!this.outputTank.isEmpty()) {
                clearFluidInventory(this.outputTank);
            }
        }
    }

}
