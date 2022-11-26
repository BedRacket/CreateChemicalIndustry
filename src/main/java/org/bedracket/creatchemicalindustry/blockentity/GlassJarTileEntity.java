package org.bedracket.creatchemicalindustry.blockentity;

import com.simibubi.create.content.contraptions.goggles.IHaveGoggleInformation;
import com.simibubi.create.foundation.tileEntity.SmartTileEntity;
import com.simibubi.create.foundation.tileEntity.TileEntityBehaviour;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;

public class GlassJarTileEntity  extends SmartTileEntity implements IHaveGoggleInformation {
    private boolean contentsChanged;
    public GlassJarTileEntity() {
        super(null, null, null);
    }

    @Override
    public void addBehaviours(List<TileEntityBehaviour> list) {

    }

    public void notifyChangeOfContents() {
        this.contentsChanged = true;
    }
}
