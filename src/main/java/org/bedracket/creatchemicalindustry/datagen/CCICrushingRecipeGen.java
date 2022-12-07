package org.bedracket.creatchemicalindustry.datagen;

import com.simibubi.create.AllRecipeTypes;
import com.simibubi.create.content.palettes.AllPaletteStoneTypes;
import com.simibubi.create.foundation.data.recipe.CreateRecipeProvider;
import net.minecraft.data.DataGenerator;
import org.bedracket.creatchemicalindustry.init.ModItems;
import org.bedracket.creatchemicalindustry.init.ModTags;
import org.jetbrains.annotations.NotNull;

public class CCICrushingRecipeGen extends CCIProcessingRecipeGen{

    public CreateRecipeProvider.GeneratedRecipe CARBOHYDRATE_RAW_MATERIAL = create(ModItems.CARBOHYDRATE_RAW_MATERIAL.getId(), (b) -> {
        return b.duration(100).require(ModTags.Items.CARBOHYDRATE)
                .output(ModItems.CARBOHYDRATE_RAW_MATERIAL.get());
    });

    public CreateRecipeProvider.GeneratedRecipe STARCH_RAW_MATERIAL = create(ModItems.STARCH_RAW_MATERIAL.getId(), (b) -> {
        return b.duration(100).require(ModTags.Items.STARCH)
                .output(ModItems.STARCH_RAW_MATERIAL.get());
    });

    public CreateRecipeProvider.GeneratedRecipe LIMESTONE_DUST = create(ModItems.LIMESTONE_DUST.getId(), (b) -> {
        return b.duration(100).require(AllPaletteStoneTypes.LIMESTONE.materialTag)
                .output(ModItems.LIMESTONE_DUST.get());
    });

    public CCICrushingRecipeGen(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected AllRecipeTypes getRecipeType() {
        return AllRecipeTypes.CRUSHING;
    }
}
