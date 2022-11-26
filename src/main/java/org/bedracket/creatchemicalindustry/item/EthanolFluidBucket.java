package org.bedracket.creatchemicalindustry.item;

import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import org.bedracket.creatchemicalindustry.init.ModFluids;
import org.bedracket.creatchemicalindustry.init.ModTabs;

public class EthanolFluidBucket extends BucketItem {

    public EthanolFluidBucket() {
        super(ModFluids.ETHANOL_FLUID.get(),
                new Item.Properties().craftRemainder(Items.BUCKET)
                        .stacksTo(1).rarity(Rarity.COMMON)
                        .tab(ModTabs.MATERIAL));
    }
}
