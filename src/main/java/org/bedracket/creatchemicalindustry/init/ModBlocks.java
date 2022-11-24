package org.bedracket.creatchemicalindustry.init;

import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.bedracket.creatchemicalindustry.CreateCheicalIndustry;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS,
                    CreateCheicalIndustry.MODID);

}
