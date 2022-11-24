package org.bedracket.creatchemicalindustry.fluid;

import net.minecraft.world.item.Item;

import javax.annotation.ParametersAreNonnullByDefault;

//TODO - improve Ethanol Gas
@ParametersAreNonnullByDefault
public abstract class EthanolGas extends EthanolFluid {

    public Item getBucket() {
        return null;
    }
}
