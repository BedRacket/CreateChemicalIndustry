package org.bedracket.creatchemicalindustry.blockentity;

import com.simibubi.create.content.contraptions.processing.BasinOperatingTileEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.Container;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.block.state.BlockState;
import org.bedracket.creatchemicalindustry.init.ModBlockEntities;

public class GlassCoverTileEntity extends BasinOperatingTileEntity {
    public GlassCoverTileEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.GLASS_COVER.get(), pos, state);
    }

    @Override
    protected boolean isRunning() {
        return false;
    }

    @Override
    protected void onBasinRemoved() {

    }

    @Override
    protected <C extends Container> boolean matchStaticFilters(Recipe<C> recipe) {
        return false;
    }

    @Override
    protected Object getRecipeCacheKey() {
        return null;
    }
}
