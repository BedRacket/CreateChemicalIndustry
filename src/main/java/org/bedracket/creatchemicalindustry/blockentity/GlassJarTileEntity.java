package org.bedracket.creatchemicalindustry.blockentity;

import com.simibubi.create.content.contraptions.goggles.IHaveGoggleInformation;
import com.simibubi.create.foundation.tileEntity.SmartTileEntity;
import com.simibubi.create.foundation.tileEntity.TileEntityBehaviour;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import org.bedracket.creatchemicalindustry.init.ModBlockEntities;

import java.util.List;

public class GlassJarTileEntity extends SmartTileEntity implements IHaveGoggleInformation {
    public GlassJarTileEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.GLASS_JAR.get(), pos, state);
    }

    @Override
    public void addBehaviours(List<TileEntityBehaviour> list) {

    }
}
