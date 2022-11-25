package org.bedracket.creatchemicalindustry.block;

import com.simibubi.create.content.contraptions.wrench.IWrenchable;
import com.simibubi.create.foundation.block.ITE;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import org.bedracket.creatchemicalindustry.blockentity.CalcinatorTileEntity;

public class CalcinatorBlock extends Block implements ITE<CalcinatorTileEntity>, IWrenchable {
    public CalcinatorBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public Class getTileEntityClass() {
        return CalcinatorTileEntity.class;
    }

    @Override
    public BlockEntityType getTileEntityType() {
        return null;
    }
}
