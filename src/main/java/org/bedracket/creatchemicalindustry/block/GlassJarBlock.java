package org.bedracket.creatchemicalindustry.block;

import com.simibubi.create.content.contraptions.wrench.IWrenchable;
import com.simibubi.create.foundation.block.ITE;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import org.bedracket.creatchemicalindustry.blockentity.GlassJarTileEntity;

public class GlassJarBlock extends Block implements ITE<GlassJarTileEntity>, IWrenchable {
    public GlassJarBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public Class getTileEntityClass() {
        return GlassJarTileEntity.class;
    }

    @Override
    public BlockEntityType getTileEntityType() {
        return null;
    }
}
