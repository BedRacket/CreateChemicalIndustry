package org.bedracket.creatchemicalindustry.init;

import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class MODBlockProperties {

    //Gas
    public static final BooleanProperty STEAMING = BooleanProperty.create("steaming");
    public static final IntegerProperty LEVEL_STEAMING = IntegerProperty.create("level", 1, 8);

}
