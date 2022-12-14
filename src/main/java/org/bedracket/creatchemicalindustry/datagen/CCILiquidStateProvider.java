package org.bedracket.creatchemicalindustry.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.bedracket.creatchemicalindustry.CreateChemicalIndustry;
import org.bedracket.creatchemicalindustry.init.ModGases;
import org.bedracket.creatchemicalindustry.init.ModLiquids;
import org.bedracket.creatchemicalindustry.register.GasRegistryObject;
import org.bedracket.creatchemicalindustry.register.LiquidRegistryObject;

import java.util.List;

public class CCILiquidStateProvider extends BlockStateProvider {

    public CCILiquidStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, CreateChemicalIndustry.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        registerFluidBlockStates(ModLiquids.LIQUIDS.getAllFluids());
        registerGasBlockStates(ModGases.GASES.getAllFluids());
    }

    protected void registerFluidBlockStates(List<LiquidRegistryObject<?, ?, ?, ?>> fluidROs) {
        for (LiquidRegistryObject<?, ?, ?, ?> fluidRO : fluidROs) {
            simpleBlock(fluidRO.getBlock(), models().getBuilder(name(fluidRO.getBlock())).texture("particle",
                    fluidRO.getStillFluid().getAttributes().getStillTexture()));
        }
    }

    protected void registerGasBlockStates(List<GasRegistryObject<?, ?, ?, ?>> gasRos) {
        for (GasRegistryObject<?, ?, ?, ?> gasRO : gasRos) {
            simpleBlock(gasRO.getBlock(), models().getBuilder(name(gasRO.getBlock())).texture("particle",
                    gasRO.getStillFluid().getAttributes().getStillTexture()));
        }
    }

    private String name(Block block) {
        return block.getRegistryName().getPath();
    }
}
