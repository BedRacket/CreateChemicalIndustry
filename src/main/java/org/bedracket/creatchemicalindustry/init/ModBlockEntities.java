package org.bedracket.creatchemicalindustry.init;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.bedracket.creatchemicalindustry.CreateChemicalIndustry;
import org.bedracket.creatchemicalindustry.blockentity.GlassCoverTileEntity;
import org.bedracket.creatchemicalindustry.blockentity.GlassJarTileEntity;
import org.bedracket.creatchemicalindustry.blockentity.SimpleNuclearReactorTileEntity;

import java.util.Locale;
import java.util.function.Supplier;

public class ModBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES,
                    CreateChemicalIndustry.MOD_ID);

    public static final RegistryObject<BlockEntityType<GlassJarTileEntity>> GLASS_JAR =
            register("glass_jar",
            () -> BlockEntityType.Builder.of(GlassJarTileEntity::new,
                    ModBlocks.GLASS_JAR.get()).build(null));
    public static final RegistryObject<BlockEntityType<GlassCoverTileEntity>> GLASS_COVER =
            register("glass_cover",
                    () -> BlockEntityType.Builder.of(GlassCoverTileEntity::new,
                            ModBlocks.GLASS_COVER.get()).build(null));
    public static final RegistryObject<BlockEntityType<SimpleNuclearReactorTileEntity>> SIMPLE_NUCLEAR_REACTOR =
            register("simple_nuclear_reactor",
                    () -> BlockEntityType.Builder.of(SimpleNuclearReactorTileEntity::new,
                            ModBlocks.SIMPLE_NUCLEAR_REACTOR.get()).build(null));

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
