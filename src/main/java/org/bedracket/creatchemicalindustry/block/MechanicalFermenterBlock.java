package org.bedracket.creatchemicalindustry.block;

import com.simibubi.create.content.contraptions.base.KineticBlock;
import com.simibubi.create.content.contraptions.relays.elementary.ICogWheel;
import com.simibubi.create.foundation.block.ITE;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.bedracket.creatchemicalindustry.blockentity.MechanicalFermenterTileEntity;

public class MechanicalFermenterBlock extends KineticBlock implements ITE<MechanicalFermenterTileEntity>, ICogWheel {
    public MechanicalFermenterBlock(Properties properties) {
        super(properties);
    }

    @Override
    public Direction.Axis getRotationAxis(BlockState blockState) {
        return Direction.Axis.Y;
    }

    @Override
    public Class<MechanicalFermenterTileEntity> getTileEntityClass() {
        return MechanicalFermenterTileEntity.class;
    }

    @Override
    public BlockEntityType<? extends MechanicalFermenterTileEntity> getTileEntityType() {
        return null;
    }
}
