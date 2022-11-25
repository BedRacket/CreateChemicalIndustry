package org.bedracket.creatchemicalindustry;

import com.mojang.logging.LogUtils;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import org.bedracket.creatchemicalindustry.init.*;
import org.slf4j.Logger;

@Mod(CreateChemicalIndustry.MOD_ID)
public class CreateChemicalIndustry {

    public static final String MOD_ID = "create_chemical_industry";
    public static final Logger LOGGER = LogUtils.getLogger();

    public CreateChemicalIndustry() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        LOGGER.info("Loading Create Chemical Industry Mod....");
        try {
            ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ModConfigs.SPEC, "create_chemical_industry.toml");
            ModConfigs.loadConfig(ModConfigs.SPEC, FMLPaths.CONFIGDIR.get().resolve("create_chemical_industry.toml"));
            ModItems.ITEMS.register(modEventBus);
            ModBlocks.BLOCKS.register(modEventBus);
            ModFluids.FLUIDS.register(modEventBus);
            ModBlockEntities.BLOCK_ENTITIES.register(modEventBus);
            LOGGER.info("Create Chemical Industry Mod has been loaded successfully!");
        } catch (Exception e) {
            LOGGER.error("Create Chemical Industry Mod load failed...");
            LOGGER.error("Please report it to authors then try to solve this problem.");
        }
    }
}
