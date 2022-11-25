package org.bedracket.creatchemicalindustry.block;

import com.simibubi.create.content.contraptions.base.KineticBlock;
import com.simibubi.create.content.contraptions.relays.elementary.ICogWheel;
import com.simibubi.create.foundation.block.ITE;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.bedracket.creatchemicalindustry.blockentity.MechanicalGasMixerTileEntity;

public class MechanicalGasMixerBlock extends KineticBlock implements ITE<MechanicalGasMixerTileEntity>, ICogWheel {
    public MechanicalGasMixerBlock(Properties properties) {
        super(properties);
    }

    @Override
    public Direction.Axis getRotationAxis(BlockState blockState) {
        return Direction.Axis.Y;
    }

    @Override
    public Class<MechanicalGasMixerTileEntity> getTileEntityClass() {
        return MechanicalGasMixerTileEntity.class;
    }

    @Override
    public BlockEntityType<? extends MechanicalGasMixerTileEntity> getTileEntityType() {
        return null;
    }
}
