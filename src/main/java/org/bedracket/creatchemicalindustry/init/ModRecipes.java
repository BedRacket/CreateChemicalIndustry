package org.bedracket.creatchemicalindustry.init;

import net.minecraft.core.Registry;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.bedracket.creatchemicalindustry.CreateChemicalIndustry;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZER_REGISTER =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, CreateChemicalIndustry.MOD_ID);
    public static final DeferredRegister<RecipeType<?>> TYPE_REGISTER =
            DeferredRegister.create(Registry.RECIPE_TYPE_REGISTRY, CreateChemicalIndustry.MOD_ID);

}
