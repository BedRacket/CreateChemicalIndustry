package org.bedracket.creatchemicalindustry.init;

import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.bedracket.creatchemicalindustry.CreateChemicalIndustry;
import org.bedracket.creatchemicalindustry.fluid.EthanolFluid;

import java.util.Locale;
import java.util.function.Supplier;

public class ModFluids {

    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(ForgeRegistries.FLUIDS,
                    CreateChemicalIndustry.MOD_ID);

    public static final RegistryObject<FlowingFluid> ETHANOL =
            register("ethanol_fluid", EthanolFluid.Source::new);

    public static final RegistryObject<FlowingFluid> FLOWING_ETHANOL =
            register("flowing_ethanol_fluid", EthanolFluid.Flowing::new);

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
