package org.bedracket.creatchemicalindustry.datagen;

import com.simibubi.create.AllRecipeTypes;
import com.simibubi.create.foundation.data.recipe.CreateRecipeProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.material.Fluids;
import org.bedracket.creatchemicalindustry.init.ModItems;
import org.bedracket.creatchemicalindustry.init.ModLiquids;
import org.jetbrains.annotations.NotNull;

public class CCIMixingRecipeGen extends CCIProcessingRecipeGen{

    public CreateRecipeProvider.GeneratedRecipe FERMENTATION_BROTH = create(ModLiquids.FERMENTATION_BROTH.getStillFluid().getRegistryName(), (b) -> {
        return b.duration(100).require(ModItems.STARCH_RAW_MATERIAL.get())
                .require(ModItems.CARBOHYDRATE_RAW_MATERIAL.get())
                .require(Fluids.WATER, 100)
                .output(ModLiquids.FERMENTATION_BROTH.getFluid(), 100);
    });

    public CreateRecipeProvider.GeneratedRecipe IMPURE_ETHANOL = create(ModLiquids.IMPURE_ETHANOL.getStillFluid().getRegistryName(), (b) -> {
        return b.duration(100).require(ModLiquids.FERMENTATION_BROTH.getFluid(), 100)
                .output(ModLiquids.IMPURE_ETHANOL.getFluid(), 1);
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
