package org.bedracket.creatchemicalindustry.blockentity;

import com.simibubi.create.content.contraptions.components.structureMovement.StructureTransform;
import com.simibubi.create.content.contraptions.fluids.FluidPropagator;
import com.simibubi.create.content.contraptions.fluids.FluidTransportBehaviour;
import com.simibubi.create.content.contraptions.fluids.pipes.EncasedPipeBlock;
import com.simibubi.create.content.contraptions.fluids.pipes.FluidPipeBlock;
import com.simibubi.create.content.contraptions.relays.elementary.BracketedTileEntityBehaviour;
import com.simibubi.create.content.contraptions.relays.elementary.ICogWheel;
import com.simibubi.create.foundation.block.ITE;
import com.simibubi.create.foundation.tileEntity.SmartTileEntity;
import com.simibubi.create.foundation.tileEntity.TileEntityBehaviour;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;

import java.util.List;

public class GasPipeTileEntity extends SmartTileEntity implements SimpleWaterloggedBlock, ICogWheel, ITE<GasPumpTileEntity> {
    public GasPipeTileEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    public void addBehaviours(List<TileEntityBehaviour> behaviours) {
        behaviours.add(new GasPipeTileEntity.StandardPipeGasTransportBehaviour(this));
        behaviours.add(new BracketedTileEntityBehaviour(this, this::canHaveBracket));
        this.registerAwardables(behaviours, FluidPropagator.getSharedTriggers());
    }

    public void transform(StructureTransform transform) {
        BracketedTileEntityBehaviour bracketBehaviour = (BracketedTileEntityBehaviour)this.getBehaviour(BracketedTileEntityBehaviour.TYPE);
        if (bracketBehaviour != null) {
            bracketBehaviour.transformBracket(transform);
        }

    }

    private boolean canHaveBracket(BlockState state) {
        return !(state.getBlock() instanceof EncasedPipeBlock);
    }

    @Override
    public boolean hasShaftTowards(LevelReader levelReader, BlockPos blockPos, BlockState blockState, Direction direction) {
        return false;
    }

    @Override
    public Direction.Axis getRotationAxis(BlockState blockState) {
        return null;
    }

    @Override
    public Class<GasPumpTileEntity> getTileEntityClass() {
        return null;
    }

    @Override
    public BlockEntityType<? extends GasPumpTileEntity> getTileEntityType() {
        return null;
    }

    class StandardPipeGasTransportBehaviour extends FluidTransportBehaviour {
        public StandardPipeGasTransportBehaviour(SmartTileEntity te) {
            super(te);
        }

        public boolean canHaveFlowToward(BlockState state, Direction direction) {
            return (FluidPipeBlock.isPipe(state) || state.getBlock() instanceof EncasedPipeBlock) && (Boolean)state.getValue((Property)FluidPipeBlock.PROPERTY_BY_DIRECTION.get(direction));
        }

    }
}