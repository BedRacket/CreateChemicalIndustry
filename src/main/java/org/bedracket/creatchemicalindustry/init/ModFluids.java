package org.bedracket.creatchemicalindustry.init;

import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.bedracket.creatchemicalindustry.CreateCheicalIndustry;

import java.util.Locale;
import java.util.function.Supplier;

public class ModFluids {

    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(ForgeRegistries.FLUIDS,
                    CreateCheicalIndustry.MODID);

    /**
     * Used for registry fluids
     * @param name Fluids' registry name
     * @param fluid Fluid Instance
     * @return new RegistryObject<Fluid>
     * @param <T> sth extends Fluid
     */
    private static <T extends Fluid> RegistryObject<T> register(String name, Supplier<T> fluid) {
        return FLUIDS.register(name.toLowerCase(Locale.ROOT), fluid);
    }
}
