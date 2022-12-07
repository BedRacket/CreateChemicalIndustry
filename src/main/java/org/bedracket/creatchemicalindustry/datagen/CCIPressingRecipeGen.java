package org.bedracket.creatchemicalindustry.datagen;

import com.simibubi.create.AllRecipeTypes;
import com.simibubi.create.content.contraptions.processing.HeatCondition;
import com.simibubi.create.foundation.data.recipe.CreateRecipeProvider;
import com.simibubi.create.foundation.data.recipe.Mods;
import com.simibubi.create.foundation.utility.recipe.IRecipeTypeInfo;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.material.Fluids;
import org.bedracket.creatchemicalindustry.init.ModItems;
import org.bedracket.creatchemicalindustry.init.ModLiquids;
import org.jetbrains.annotations.NotNull;

public class CCIPressingRecipeGen extends CCIProcessingRecipeGen{
    public CreateRecipeProvider.GeneratedRecipe FAKE_URANIUM_FUEL = create(ModItems.FAKE_URANIUM_FUEL.getId(), (b) -> {
        return b.duration(1000).require(ModLiquids.FERMENTATION_BROTH.getFluid(), 100)
                .require(Fluids.WATER, 100)
                .output(0.125F, ModItems.FAKE_URANIUM_FUEL.get())
                .requiresHeat(HeatCondition.SUPERHEATED);
    });

    public CCIPressingRecipeGen(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected AllRecipeTypes getRecipeType() {
        return AllRecipeTypes.PRESSING;
    }
}
