package org.bedracket.creatchemicalindustry.block;

import com.simibubi.create.content.contraptions.base.DirectionalKineticBlock;
import com.simibubi.create.content.contraptions.fluids.PumpTileEntity;
import com.simibubi.create.content.contraptions.relays.elementary.ICogWheel;
import com.simibubi.create.foundation.block.ITE;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.bedracket.creatchemicalindustry.blockentity.MechanicalCondenserTileEntity;

public class MechanicalCondenser extends DirectionalKineticBlock implements SimpleWaterloggedBlock, ICogWheel, ITE<MechanicalCondenserTileEntity> {
    public MechanicalCondenser(Properties properties) {
        super(properties);
    }

    @Override
    public Direction.Axis getRotationAxis(BlockState blockState) {
        return null;
    }

    @Override
    public Class<MechanicalCondenserTileEntity> getTileEntityClass() {
        return MechanicalCondenserTileEntity.class;
    }

    @Override
    public BlockEntityType<? extends MechanicalCondenserTileEntity> getTileEntityType() {
        return null;
    }
}
