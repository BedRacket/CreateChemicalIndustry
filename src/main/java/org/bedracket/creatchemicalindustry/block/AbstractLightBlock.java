package org.bedracket.creatchemicalindustry.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import org.bedracket.creatchemicalindustry.init.ModBlockProperties;

/**
 * A Block that has light
 * you can extend it to make a custom light block
 */
public class AbstractLightBlock extends Block {

    protected static final BooleanProperty LIT = ModBlockProperties.LIT;

    public AbstractLightBlock(Properties pProperties) {
        super(pProperties);
    }

    /**
     * A method to get lit state
     * @return lit state
     */
    public static BooleanProperty getLitState() {
        return LIT;
    }
}
