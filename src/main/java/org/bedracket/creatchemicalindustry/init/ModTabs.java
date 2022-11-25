package org.bedracket.creatchemicalindustry.init;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.bedracket.creatchemicalindustry.CreateChemicalIndustry;
import org.jetbrains.annotations.NotNull;

public class ModTabs {
    public static final CreativeModeTab MATERIAL = new CreativeModeTab(CreateChemicalIndustry.MOD_ID + ".material") {
        @NotNull
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.CALCIUM_CARBONATE_DUST.get());
        }
    };
    public static final CreativeModeTab FACILITY = new CreativeModeTab(CreateChemicalIndustry.MOD_ID + ".facility") {
        @NotNull
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.CALCIUM_CARBONATE_DUST.get());
        }
    };
}
