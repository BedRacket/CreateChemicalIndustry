package org.bedracket.creatchemicalindustry.recipe;

import com.simibubi.create.content.contraptions.processing.ProcessingRecipe;
import com.simibubi.create.content.contraptions.processing.ProcessingRecipeBuilder;
import com.simibubi.create.foundation.item.SmartInventory;
import com.simibubi.create.foundation.utility.recipe.IRecipeTypeInfo;
import lombok.NonNull;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class EvaporatingRecipe extends ProcessingRecipe<SmartInventory> {
    public EvaporatingRecipe(IRecipeTypeInfo typeInfo, ProcessingRecipeBuilder.ProcessingRecipeParams params) {
        super(typeInfo, params);
    }

    @Override
    protected int getMaxInputCount() {
        return 9;
    }

    @Override
    protected int getMaxOutputCount() {
        return 4;
    }

    @Override
    protected int getMaxFluidInputCount() {
        return 2;
    }

    @Override
    protected int getMaxFluidOutputCount() {
        return 2;
    }

    @Override
    protected boolean canRequireHeat() {
        return true;
    }

    @Override
    public boolean matches(@NonNull SmartInventory pContainer,@NonNull Level pLevel) {
        return false;
    }
}
