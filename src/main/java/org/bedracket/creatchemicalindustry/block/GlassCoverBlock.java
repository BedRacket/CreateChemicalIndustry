package org.bedracket.creatchemicalindustry.block;

import com.simibubi.create.content.contraptions.wrench.IWrenchable;
import com.simibubi.create.foundation.block.ITE;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import org.bedracket.creatchemicalindustry.blockentity.GlassCoverTileEntity;
import org.bedracket.creatchemicalindustry.init.ModBlockEntities;
import org.bedracket.creatchemicalindustry.init.ModBlocks;

public class GlassCoverBlock extends Block implements IWrenchable, ITE<GlassCoverTileEntity> {
    public GlassCoverBlock() {
        super(BlockBehaviour.Properties.of(Material.GLASS)
                .strength(0.3F).sound(SoundType.GLASS)
                .noOcclusion().isValidSpawn(GlassCoverBlock::never)
                .isRedstoneConductor(GlassCoverBlock::never)
                .isSuffocating(GlassCoverBlock::never)
                .isViewBlocking(GlassCoverBlock::never));
    }

    @Override
    public Class<GlassCoverTileEntity> getTileEntityClass() {
        return GlassCoverTileEntity.class;
    }

    @Override
    public BlockEntityType<? extends GlassCoverTileEntity> getTileEntityType() {
        return ModBlockEntities.GLASS_COVER.get();
    }

    private static boolean never(BlockState state, BlockGetter blockGetter, BlockPos blockPos) {
        return false;
    }

    private static boolean never(BlockState state, BlockGetter blockGetter, BlockPos blockPos, EntityType<?> entityType) {
        return false;
    }
}
