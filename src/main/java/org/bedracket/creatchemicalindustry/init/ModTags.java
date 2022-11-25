package org.bedracket.creatchemicalindustry.init;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import org.bedracket.creatchemicalindustry.CreateChemicalIndustry;

public class ModTags {
    public static class Items {

        public static final TagKey<Item> CARBOHYDRATE = register("carbohydrate");
        public static final TagKey<Item> STARCH = register("starch");
        private static TagKey<Item> register(String name)
        {
            return ItemTags.create(new ResourceLocation(CreateChemicalIndustry.MODID, name));
        }
    }
}
