package org.bedracket.creatchemicalindustry.datagen;

import com.simibubi.create.AllRecipeTypes;
import com.simibubi.create.foundation.data.recipe.CreateRecipeProvider;
import net.minecraft.data.DataGenerator;
import org.bedracket.creatchemicalindustry.init.ModItems;
import org.bedracket.creatchemicalindustry.init.ModTags;
import org.jetbrains.annotations.NotNull;

public class CCIMixingRecipeGen extends CCIProcessingRecipeGen{

    public CreateRecipeProvider.GeneratedRecipe CARBOHYDRATE_RAW_MATERIAL = create(ModItems.CARBOHYDRATE_RAW_MATERIAL.getId(), (b) -> {
        return b.duration(100).require(ModTags.Items.CARBOHYDRATE)
                .output(ModItems.CARBOHYDRATE_RAW_MATERIAL.get());
    });

    public CCIMixingRecipeGen(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected AllRecipeTypes getRecipeType() {
        return AllRecipeTypes.MIXING;
    }

    @Override
    public @NotNull String getName() {
        return "Create: Chemical Industry's Mixing Recipes";
    }
}
