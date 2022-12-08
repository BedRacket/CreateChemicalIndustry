package org.bedracket.creatchemicalindustry.datagen;

import com.simibubi.create.AllRecipeTypes;
import com.simibubi.create.content.contraptions.processing.HeatCondition;
import com.simibubi.create.foundation.data.recipe.CreateRecipeProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.material.Fluids;
import org.bedracket.creatchemicalindustry.init.ModItems;
import org.bedracket.creatchemicalindustry.init.ModLiquids;

public class CCICompactingRecipeGen extends CCIProcessingRecipeGen{
    public CreateRecipeProvider.GeneratedRecipe FAKE_URANIUM_FUEL = create(ModItems.FAKE_URANIUM_FUEL.getId(), (b) -> {
        return b.duration(1000).require(ModLiquids.FERMENTATION_BROTH.getFluid(), 100)
                .require(Fluids.WATER, 100)
                .requiresHeat(HeatCondition.SUPERHEATED)
                .output(0.05F, ModItems.FAKE_URANIUM_FUEL.get());
    });
    public CreateRecipeProvider.GeneratedRecipe SIMPLE_URANIUM_FUEL_ROD = create(ModItems.SIMPLE_URANIUM_FUEL_ROD.getId(), (b) -> {
        return b.duration(100).require(Items.CLAY)
                .require(ModItems.FAKE_URANIUM_FUEL.get())
                .requiresHeat(HeatCondition.HEATED)
                .output(ModItems.SIMPLE_URANIUM_FUEL_ROD.get());
    });


    public CCICompactingRecipeGen(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected AllRecipeTypes getRecipeType() {
        return AllRecipeTypes.COMPACTING;
    }
}
