package org.bedracket.creatchemicalindustry.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import org.bedracket.creatchemicalindustry.CreateChemicalIndustry;
import org.bedracket.creatchemicalindustry.init.ModBlocks;

public class CCIBlockModelProvider extends BlockModelProvider {

    public CCIBlockModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, CreateChemicalIndustry.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleParent(ModBlocks.GLASS_JAR.get());
    }

    protected void simpleParent(Block block) {
        String path = ForgeRegistries.BLOCKS.getKey(block).getPath();
        withExistingParent(path, "create_chemical_industry:block/" + path);
    }
}
