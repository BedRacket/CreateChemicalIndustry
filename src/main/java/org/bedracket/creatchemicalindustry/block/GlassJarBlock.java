package org.bedracket.creatchemicalindustry.block;

import com.simibubi.create.content.contraptions.processing.BasinBlock;
import com.simibubi.create.content.contraptions.relays.belt.BeltTileEntity;
import com.simibubi.create.content.logistics.block.funnel.FunnelBlock;
import com.simibubi.create.foundation.tileEntity.TileEntityBehaviour;
import com.simibubi.create.foundation.tileEntity.behaviour.belt.DirectBeltInputBehaviour;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.EntityCollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.bedracket.creatchemicalindustry.blockentity.GlassJarTileEntity;
import org.bedracket.creatchemicalindustry.init.ModBlockEntities;
import org.bedracket.creatchemicalindustry.init.ModShapes;

/**
 * Code from com\simibubi\create\content\contraptions\processing\BasinTileEntity.java
 * @author Creators-of-Create <a href="https://github.com/Creators-of-Create/Create">...</a>
 * @license MIT
 */
public class GlassJarBlock extends BasinBlock {

    public GlassJarBlock() {
        super(BlockBehaviour.Properties.of(Material.GLASS)
                .strength(0.3F).sound(SoundType.GLASS)
                .noOcclusion().isValidSpawn(GlassJarBlock::never)
                .isRedstoneConductor(GlassJarBlock::never)
                .isSuffocating(GlassJarBlock::never)
                .isViewBlocking(GlassJarBlock::never));
    }

    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
        return ModShapes.GLASS_JAR_SHAPE;
    }

    public VoxelShape getCollisionShape(BlockState state, BlockGetter reader, BlockPos pos, CollisionContext ctx) {
        return ctx instanceof EntityCollisionContext && ((EntityCollisionContext)ctx).getEntity() instanceof ItemEntity ? ModShapes.GLASS_JAR_SHAPE : this.getShape(state, reader, pos, ctx);
    }

    private static boolean never(BlockState state, BlockGetter blockGetter, BlockPos blockPos) {
        return false;
    }

    private static boolean never(BlockState state, BlockGetter blockGetter, BlockPos blockPos, EntityType<?> entityType) {
        return false;
    }

    public static boolean canOutputTo(BlockGetter world, BlockPos basinPos, Direction direction) {
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
