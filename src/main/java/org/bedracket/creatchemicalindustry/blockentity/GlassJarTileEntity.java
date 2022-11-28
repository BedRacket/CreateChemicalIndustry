package org.bedracket.creatchemicalindustry.blockentity;

import com.simibubi.create.content.contraptions.processing.BasinBlock;
import com.simibubi.create.content.contraptions.processing.BasinTileEntity;
import com.simibubi.create.foundation.item.SmartInventory;
import com.simibubi.create.foundation.tileEntity.behaviour.fluid.SmartFluidTankBehaviour;
import com.simibubi.create.foundation.utility.Iterate;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlockContainer;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.bedracket.creatchemicalindustry.init.ModBlockEntities;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

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

    public void tick() {
        super.tick();
        if (level != null && level.getBlockState(this.getBlockPos().below()).is(Blocks.AIR)) {
            if (!this.inputInventory.isEmpty()) {
                clearItemInventory(this.inputInventory);
            }
            if (!this.outputInventory.isEmpty()) {
                clearItemInventory(this.outputInventory);
            }
        }
    }
}
