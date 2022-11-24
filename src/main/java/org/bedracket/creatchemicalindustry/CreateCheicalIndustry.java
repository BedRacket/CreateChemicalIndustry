package org.bedracket.creatchemicalindustry;

import com.mojang.logging.LogUtils;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import org.bedracket.creatchemicalindustry.init.ModBlocks;
import org.bedracket.creatchemicalindustry.init.ModConfigs;
import org.bedracket.creatchemicalindustry.init.ModFluids;
import org.bedracket.creatchemicalindustry.init.ModItems;
import org.slf4j.Logger;

@Mod(CreateCheicalIndustry.MODID)
public class CreateCheicalIndustry {

    public static final String MODID = "create_chemical_industry";
    public static final Logger LOGGER = LogUtils.getLogger();

    public CreateCheicalIndustry() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ModConfigs.SPEC, "create_chemical_industry.toml");
        ModConfigs.loadConfig(ModConfigs.SPEC, FMLPaths.CONFIGDIR.get().resolve("create_chemical_industry.toml"));
        ModItems.ITEMS.register(modEventBus);
        ModBlocks.BLOCKS.register(modEventBus);
        ModFluids.FLUIDS.register(modEventBus);
    }
}
