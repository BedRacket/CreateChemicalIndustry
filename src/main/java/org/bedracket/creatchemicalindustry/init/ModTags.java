package org.bedracket.creatchemicalindustry.init;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import org.bedracket.creatchemicalindustry.CreateCheicalIndustry;

public class ModTags {

    public static class Items {

        public static final TagKey<Item> CARBOHYDRATE = register("carbohydrate");

        private static TagKey<Item> register(String name) {
            return ItemTags.create(new ResourceLocation(CreateCheicalIndustry.MODID, name));
        }
    }
}
