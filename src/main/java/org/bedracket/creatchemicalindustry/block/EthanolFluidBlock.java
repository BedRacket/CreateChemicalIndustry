package org.bedracket.creatchemicalindustry.block;

import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import org.bedracket.creatchemicalindustry.init.ModFluids;

public class EthanolFluidBlock extends LiquidBlock {

    public EthanolFluidBlock() {
        super(ModFluids.ETHANOL,
                BlockBehaviour.Properties
                        .of(Material.WATER)
                        .strength(100f)
                        .noCollission().noDrops());
    }
}
