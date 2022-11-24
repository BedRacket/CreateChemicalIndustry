package org.bedracket.creatchemicalindustry.init;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.bedracket.creatchemicalindustry.CreateCheicalIndustry;

import java.util.Locale;
import java.util.function.Supplier;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS,
                    CreateCheicalIndustry.MODID);

    /**
     * Used for registry items
     * @param name Items' registry name
     * @param item Item Instance
     * @return new RegistryObject<Item>
     * @param <T> sth extends Item
     */
    private static <T extends Item> RegistryObject<T> register(String name, Supplier<T> item) {
        return ITEMS.register(name.toLowerCase(Locale.ROOT), item);
    }
}
