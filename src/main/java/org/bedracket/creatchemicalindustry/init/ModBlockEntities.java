package org.bedracket.creatchemicalindustry.init;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.bedracket.creatchemicalindustry.CreateChemicalIndustry;

import java.util.Locale;
import java.util.function.Supplier;

public class ModBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES,
                    CreateChemicalIndustry.MOD_ID);

    /**
     * Used for registry items
     * @param name BlockEntities' registry name
     * @param type BlockEntity Type
     * @return new RegistryObject<BlockEntityType<?>>
     * @param <T> sth extends BlockEntityType<?>
     */
    private static <T extends BlockEntityType<?>> RegistryObject<T> register(String name, Supplier<T> type) {
        return BLOCK_ENTITIES.register(name.toLowerCase(Locale.ROOT), type);
    }

}
