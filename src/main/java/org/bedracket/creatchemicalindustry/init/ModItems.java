package org.bedracket.creatchemicalindustry.init;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.bedracket.creatchemicalindustry.CreateChemicalIndustry;

import java.util.Locale;
import java.util.function.Supplier;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS,
                    CreateChemicalIndustry.MOD_ID);

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

    /**
     * Used for registry material items
     * @param name Items' registry name
     * @return new RegistryObject<Item>
     */
    private static RegistryObject<Item> material(String name) {
        return ITEMS.register(name, () -> new Item(new Item.Properties().tab(ModTabs.MATERIAL)));
    }

    public static final RegistryObject<Item> CARBOHYDRATE_RAW_MATERIAL = material("carbohydrate_raw_material");
    public static final RegistryObject<Item> STARCH_RAW_MATERIAL = material("starch_raw_material");
    public static final RegistryObject<Item> LIMESTONE_DUST = material("limestone_dust");
    public static final RegistryObject<Item> CALCIUM_CARBONATE_DUST = material("calcium_carbonate_dust");
    public static final RegistryObject<Item> IMPURITY = material("impurity_dust");
}
