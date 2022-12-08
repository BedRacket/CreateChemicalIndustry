package org.bedracket.creatchemicalindustry.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import org.bedracket.creatchemicalindustry.CreateChemicalIndustry;
import org.bedracket.creatchemicalindustry.init.ModBlocks;

public class CCIBlockItemModelProvider extends ItemModelProvider {

    public CCIBlockItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, CreateChemicalIndustry.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleParent(ModBlocks.GLASS_JAR.get());
        multiParent(ModBlocks.SIMPLE_NUCLEAR_REACTOR.get(), "horizontal");
    }

    protected void simpleParent(Block block) {
        ResourceLocation identifier = ForgeRegistries.BLOCKS.getKey(block);
        if (identifier!= null) {
            String path = identifier.getPath();
            withExistingParent(path, "create_chemical_industry:block/" + path);
        }
    }

    /**
     * When one block has many models, specify one of them in the directory
     * @param block Block instance
     * @param name specific name of a single model
     */
    protected void multiParent(Block block, String name) {
        ResourceLocation identifier = ForgeRegistries.BLOCKS.getKey(block);
        if (identifier!= null) {
            String path = identifier.getPath();
            withExistingParent(path, "create_chemical_industry:block/"+ path + "/" + name);
        }
    }
}
