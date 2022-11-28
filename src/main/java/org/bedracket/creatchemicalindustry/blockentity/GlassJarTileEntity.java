package org.bedracket.creatchemicalindustry.blockentity;

import com.simibubi.create.content.contraptions.processing.BasinTileEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import org.bedracket.creatchemicalindustry.init.ModBlockEntities;

/**
 * Code from com\simibubi\create\content\contraptions\processing\BasinTileEntity.java
 * @author Creators-of-Create <a href="https://github.com/Creators-of-Create/Create">...</a>
 * @license MIT
 */
public class GlassJarTileEntity extends BasinTileEntity {
    public GlassJarTileEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.GLASS_JAR.get(), pos, state);
    }
}
