package org.bedracket.creatchemicalindustry.blockentity;

import com.simibubi.create.content.contraptions.base.GeneratingKineticTileEntity;
import com.simibubi.create.foundation.config.AllConfigs;
import com.simibubi.create.foundation.tileEntity.TileEntityBehaviour;
import com.simibubi.create.foundation.tileEntity.behaviour.CenteredSideValueBoxTransform;
import com.simibubi.create.foundation.tileEntity.behaviour.scrollvalue.ScrollValueBehaviour;
import com.simibubi.create.foundation.utility.Lang;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.BlockState;
import org.bedracket.creatchemicalindustry.block.SimpleNuclearReactorBlock;
import org.bedracket.creatchemicalindustry.init.ModBlockEntities;

import java.util.List;

public class SimpleNuclearReactorTileEntity extends GeneratingKineticTileEntity {
    public static final int DEFAULT_SPEED = 16;
    protected ScrollValueBehaviour generatedSpeed;
    public SimpleNuclearReactorTileEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.SIMPLE_NUCLEAR_REACTOR.get(), pos, state);
    }

    public void addBehaviours(List<TileEntityBehaviour> behaviours) {
        super.addBehaviours(behaviours);
        Integer max = (Integer) AllConfigs.SERVER.kinetics.maxMotorSpeed.get();
        CenteredSideValueBoxTransform slot = new CenteredSideValueBoxTransform((motor, side) -> {
            return motor.getValue(SimpleNuclearReactorBlock.FACING) == side.getOpposite();
        });
        this.generatedSpeed = new ScrollValueBehaviour(Lang.translateDirect("generic.speed", new Object[0]), this, slot);
        this.generatedSpeed.between(-max, max);
        this.generatedSpeed.value = 16;
        this.generatedSpeed.scrollableValue = 16;
        this.generatedSpeed.withUnit((i) -> {
            return Lang.translateDirect("generic.unit.rpm", new Object[0]);
        });
        this.generatedSpeed.withCallback((i) -> {
            this.updateGeneratedRotation();
        });
        this.generatedSpeed.withStepFunction(SimpleNuclearReactorTileEntity::step);
        behaviours.add(this.generatedSpeed);
    }

    public void initialize() {
        super.initialize();
        if (!this.hasSource() || this.getGeneratedSpeed() > this.getTheoreticalSpeed()) {
            this.updateGeneratedRotation();
        }

    }

    public float getGeneratedSpeed() {
        if (level != null) {
            return level.getBlockState(worldPosition).getValue(SimpleNuclearReactorBlock.notWatered) &&
                    level.getBlockState(worldPosition).getValue(SimpleNuclearReactorBlock.notFueled)
                    ? 0 : convertToDirection((float)this.generatedSpeed.getValue(), (Direction)this.getBlockState().getValue(SimpleNuclearReactorBlock.FACING));
        }
        return 0;
    }

    public static int step(ScrollValueBehaviour.StepContext context) {
        int current = context.currentValue;
        int step = 1;
        if (!context.shift) {
            int magnitude = Math.abs(current) - (context.forward == current > 0 ? 0 : 1);
            if (magnitude >= 4) {
                step *= 4;
            }

            if (magnitude >= 32) {
                step *= 4;
            }

            if (magnitude >= 128) {
                step *= 4;
            }
        }

        return current + (context.forward ? step : -step) == 0 ? step + 1 : step;
    }
}
