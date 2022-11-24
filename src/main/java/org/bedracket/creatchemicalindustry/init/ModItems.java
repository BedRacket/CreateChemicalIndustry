package org.bedracket.creatchemicalindustry.init;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.bedracket.creatchemicalindustry.CreateCheicalIndustry;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS,
                    CreateCheicalIndustry.MODID);
}
