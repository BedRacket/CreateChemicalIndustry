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
import org.bedracket.creatchemicalindustry.blockentity.GlassJarTileEntity;
import org.bedracket.creatchemicalindustry.init.ModBlockEntities;

public class GlassJarBlock extends Block implements ITE<GlassJarTileEntity>, IWrenchable {

    public GlassJarBlock() {
        super(BlockBehaviour.Properties.of(Material.GLASS)
                .strength(0.3F).sound(SoundType.GLASS)
                .noOcclusion().isValidSpawn(GlassJarBlock::never)
                .isRedstoneConductor(GlassJarBlock::never)
                .isSuffocating(GlassJarBlock::never)
                .isViewBlocking(GlassJarBlock::never));
    }

    private static boolean never(BlockState state, BlockGetter blockGetter, BlockPos blockPos) {
        return false;
    }

    private static boolean never(BlockState state, BlockGetter blockGetter, BlockPos blockPos, EntityType<?> entityType) {
        return false;
    }

    @Override
    public Class getTileEntityClass() {
        return GlassJarTileEntity.class;
    }

    @Override
    public BlockEntityType getTileEntityType() {
        return ModBlockEntities.GLASS_JAR.get();
    }
}
