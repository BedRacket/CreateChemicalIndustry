package org.bedracket.creatchemicalindustry.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.TieredItem;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.bedracket.creatchemicalindustry.CreateChemicalIndustry;
import org.bedracket.creatchemicalindustry.init.ModBlocks;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class CCIItemModelProvider extends ItemModelProvider {
    public static final ResourceLocation GENERATED = new ResourceLocation("item/generated");
    public static final ResourceLocation HANDHELD = new ResourceLocation("item/handheld");
    protected final DeferredRegister<? extends Item> deferredRegister;
    protected Set<Item> skipItems = new HashSet<>();

    public CCIItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper, DeferredRegister<? extends Item> deferredRegister) {
        super(generator, CreateChemicalIndustry.MOD_ID, existingFileHelper);
        this.deferredRegister = deferredRegister;
    }

    private static String name(Item item) {
        ResourceLocation identifier = ForgeRegistries.ITEMS.getKey(item);
        if (identifier == null) {
            return null;
        } else {
            return identifier.getPath();
        }
    }

    @Override
    protected void registerModels() {
        Set<Item> items = getItems();
        addSkipItems();
        items.removeAll(skipItems);
        registerItemBlock(items.stream()
                .filter(item -> item instanceof BlockItem)
                .map(item -> (BlockItem) item)
                .collect(Collectors.toSet()));

        addSkipItems();
        items.removeAll(skipItems);
        registerItem(items);
    }

    protected void skipItems(Item... items) {
        Collections.addAll(skipItems, items);
    }

    protected void skipItems(Collection<? extends Item> items) {
        skipItems.addAll(items);
    }

    protected Set<Item> getItems() {
        return deferredRegister.getEntries().stream().map(RegistryObject::get).collect(Collectors.toSet());
    }

    protected void registerItemBlock(@NotNull Set<BlockItem> blockItems) {
        blockItems.forEach(blockItem -> withExistingParent(name(blockItem),
                modLoc("block/" + name(blockItem))));
        skipItems(blockItems);
    }

    protected void registerItem(Set<Item> items) {
        items.forEach(this::generatedItem);
        items.stream()
                .filter(item -> item instanceof TieredItem)
                .forEach(this::handheldItem);
    }

    protected final void generatedItem(String name) {
        withExistingParent(name, GENERATED)
                .texture("layer0", modLoc("item/" + name));
    }

    protected final void generatedItem(Item item) {
        generatedItem(name(item));
    }

    protected final void handheldItem(String name) {
        withExistingParent(name, HANDHELD)
                .texture("layer0", modLoc("item/" + name));
    }

    protected final void handheldItem(Item item) {
        handheldItem(name(item));
    }

    /**
     * You can add items you want to skip to datagen
     * Example Usage:
     * skipItems(ModItems.EXAMPLE_ITEM.get());
     */
    protected void addSkipItems()  {
        skipItems(ModBlocks.GLASS_JAR.get().asItem());
        skipItems(ModBlocks.SIMPLE_NUCLEAR_REACTOR.get().asItem());
    }
}