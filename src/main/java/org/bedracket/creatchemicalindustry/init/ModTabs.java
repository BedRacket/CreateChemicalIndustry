package org.bedracket.creatchemicalindustry.init;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.bedracket.creatchemicalindustry.CreateCheicalIndustry;
import org.jetbrains.annotations.NotNull;

public class ModTabs {
    public static final CreativeModeTab MATERIAL = new CreativeModeTab(CreateCheicalIndustry.MODID + ".material") {
        @NotNull
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.CALCIUM_CARBONATE_DUST.get());
        }
    };
}
