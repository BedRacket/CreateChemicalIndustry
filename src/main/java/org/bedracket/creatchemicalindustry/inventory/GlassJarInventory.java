package org.bedracket.creatchemicalindustry.inventory;

import com.simibubi.create.foundation.item.SmartInventory;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.ItemHandlerHelper;
import org.bedracket.creatchemicalindustry.blockentity.GlassJarTileEntity;

public class GlassJarInventory extends SmartInventory {
    private GlassJarTileEntity glassJarTileEntity;

    public GlassJarInventory(int slots, GlassJarTileEntity glassJarTileEntity) {
        super(slots, glassJarTileEntity, 16, true);
        this.glassJarTileEntity = glassJarTileEntity;
    }

    public ItemStack insertItem(int slot, ItemStack stack, boolean simulate) {
        for(int i = 0; i < this.getSlots(); ++i) {
            if (i != slot && ItemHandlerHelper.canItemStacksStack(stack, this.inv.getStackInSlot(i))) {
                return stack;
            }
        }

        return super.insertItem(slot, stack, simulate);
    }

    public ItemStack extractItem(int slot, int amount, boolean simulate) {
        ItemStack extractItem = super.extractItem(slot, amount, simulate);
        if (!simulate && !extractItem.isEmpty()) {
            this.glassJarTileEntity.notifyUpdate();
        }

        return extractItem;
    }
}
