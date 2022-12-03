package org.bedracket.creatchemicalindustry.init;

import com.simibubi.create.Create;
import com.simibubi.create.content.contraptions.processing.ProcessingRecipeBuilder;
import com.simibubi.create.content.contraptions.processing.ProcessingRecipeSerializer;
import com.simibubi.create.foundation.utility.Lang;
import com.simibubi.create.foundation.utility.recipe.IRecipeTypeInfo;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.minecraft.world.level.Level;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.bedracket.creatchemicalindustry.CreateChemicalIndustry;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * Code from com\simibubi\create\AllRecipeTypes.java
 * @author Creators-of-Create <a href="https://github.com/Creators-of-Create/Create">...</a>
 * @license MIT
 */
public enum EModRecipes implements IRecipeTypeInfo {;
    private final ResourceLocation id;
    private final RegistryObject<RecipeSerializer<?>> serializerObject;
    private final @Nullable RegistryObject<RecipeType<?>> typeObject;
    private final Supplier<RecipeType<?>> type;

    private EModRecipes(Supplier serializerSupplier, Supplier typeSupplier, boolean registerType) {
        String name = Lang.asId(this.name());
        this.id = Create.asResource(name);
        this.serializerObject = EModRecipes.Registers.SERIALIZER_REGISTER.register(name, serializerSupplier);
        if (registerType) {
            this.typeObject = EModRecipes.Registers.TYPE_REGISTER.register(name, typeSupplier);
            this.type = this.typeObject;
        } else {
            this.typeObject = null;
            this.type = typeSupplier;
        }

    }

    private EModRecipes(Supplier serializerSupplier) {
        String name = Lang.asId(this.name());
        this.id = Create.asResource(name);
        this.serializerObject = EModRecipes.Registers.SERIALIZER_REGISTER.register(name, serializerSupplier);
        this.typeObject = EModRecipes.Registers.TYPE_REGISTER.register(name, () -> {
            return simpleType(this.id);
        });
        this.type = this.typeObject;
    }

    private EModRecipes(ProcessingRecipeBuilder.ProcessingRecipeFactory processingFactory) {
        this(() -> {
            return new ProcessingRecipeSerializer(processingFactory);
        });
    }

    public static <T extends Recipe<?>> RecipeType<T> simpleType(ResourceLocation id) {
        final String stringId = id.toString();
        return new RecipeType<T>() {
            public String toString() {
                return stringId;
            }
        };
    }

    public static void register(IEventBus modEventBus) {
        ShapedRecipe.setCraftingSize(9, 9);
        EModRecipes.Registers.SERIALIZER_REGISTER.register(modEventBus);
        EModRecipes.Registers.TYPE_REGISTER.register(modEventBus);
    }

    public ResourceLocation getId() {
        return this.id;
    }

    public <T extends RecipeSerializer<?>> T getSerializer() {
        return (T) this.serializerObject.get();
    }

    public <T extends RecipeType<?>> T getType() {
        return (T) this.type.get();
    }

    public <C extends Container, T extends Recipe<C>> Optional<T> find(C inv, Level world) {
        return world.getRecipeManager().getRecipeFor(this.getType(), inv, world);
    }

    private static class Registers {
        private static final DeferredRegister<RecipeSerializer<?>> SERIALIZER_REGISTER;
        private static final DeferredRegister<RecipeType<?>> TYPE_REGISTER;

        private Registers() {
        }

        static {
            SERIALIZER_REGISTER = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, CreateChemicalIndustry.MOD_ID);
            TYPE_REGISTER = DeferredRegister.create(Registry.RECIPE_TYPE_REGISTRY, CreateChemicalIndustry.MOD_ID);
        }
    }
}
