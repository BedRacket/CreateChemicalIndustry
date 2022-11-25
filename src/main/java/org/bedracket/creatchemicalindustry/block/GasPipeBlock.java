package org.bedracket.creatchemicalindustry.block;

import com.simibubi.create.content.contraptions.wrench.IWrenchableWithBracket;
import com.simibubi.create.foundation.block.ITE;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.PipeBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import org.bedracket.creatchemicalindustry.blockentity.GasPipeTileEntity;

import java.util.Optional;

public class GasPipeBlock extends PipeBlock implements SimpleWaterloggedBlock, IWrenchableWithBracket, ITE<GasPipeTileEntity> {
    public GasPipeBlock(float pApothem, Properties pProperties) {
        super(pApothem, pProperties);
    }

    @Override
    public Optional<ItemStack> removeBracket(BlockGetter blockGetter, BlockPos blockPos, boolean b) {
        return Optional.empty();
    }

    @Override
    public Class<GasPipeTileEntity> getTileEntityClass() {
        return null;
    }

    @Override
    public BlockEntityType<? extends GasPipeTileEntity> getTileEntityType() {
        return null;
    }
}
