package org.bedracket.creatchemicalindustry.datagen;

import com.simibubi.create.content.contraptions.processing.ProcessingRecipe;
import com.simibubi.create.content.contraptions.processing.ProcessingRecipeBuilder;
import com.simibubi.create.content.contraptions.processing.ProcessingRecipeSerializer;
import com.simibubi.create.foundation.data.recipe.*;
import com.simibubi.create.foundation.utility.recipe.IRecipeTypeInfo;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.HashCache;
import net.minecraft.resources.ResourceLocation;
import org.bedracket.creatchemicalindustry.CreateCheicalIndustry;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

/**
 * Code from create: \com\simibubi\create\foundation\data\recipe\ProcessingRecipeGen.java
 */
public abstract class CCIProcessingRecipeGen extends CreateRecipeProvider {
    protected static final List<CCIProcessingRecipeGen> GENERATORS = new ArrayList<>();
    public CCIProcessingRecipeGen(DataGenerator generator) {
        super(generator);
    }

    public static void registerAll(DataGenerator gen) {
        GENERATORS.add(new CCICrushingRecipeGen(gen));
        gen.addProvider(new DataProvider() {
            public @NotNull String getName() {
                return "Create: Chemical Industry's Processing Recipes";
            }

            public void run(@NotNull HashCache dc) throws IOException {
                CCIProcessingRecipeGen.GENERATORS.forEach((g) -> {
                    try {
                        g.run(dc);
                    } catch (Exception var3) {
                        var3.printStackTrace();
                    }

                });
            }
        });
    }

    protected <T extends ProcessingRecipe<?>> GeneratedRecipe create(String name,
                                                                 UnaryOperator<ProcessingRecipeBuilder<T>> transform) {
        return create(new ResourceLocation(CreateCheicalIndustry.MODID, name), transform);
    }

    protected <T extends ProcessingRecipe<?>> GeneratedRecipe create(ResourceLocation name,
                                                                UnaryOperator<ProcessingRecipeBuilder<T>> transform) {

        return createWithDeferredId(() -> name, transform);
    }


    protected <T extends ProcessingRecipe<?>> GeneratedRecipe createWithDeferredId(Supplier<ResourceLocation> name,
                                                                UnaryOperator<ProcessingRecipeBuilder<T>> transform) {
        ProcessingRecipeSerializer<T> serializer = getSerializer();
        GeneratedRecipe generatedRecipe =
                c -> transform.apply(new ProcessingRecipeBuilder<>(serializer.getFactory(), name.get()))
                        .build(c);
        all.add(generatedRecipe);
        return generatedRecipe;
    }

    protected <T extends ProcessingRecipe<?>> ProcessingRecipeSerializer<T> getSerializer() {
        return getRecipeType().getSerializer();
    }

    abstract IRecipeTypeInfo getRecipeType();
}
