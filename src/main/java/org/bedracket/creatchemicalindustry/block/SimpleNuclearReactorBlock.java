package org.bedracket.creatchemicalindustry.block;

import com.simibubi.create.AllShapes;
import com.simibubi.create.content.contraptions.base.DirectionalKineticBlock;
import com.simibubi.create.foundation.block.ITE;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.bedracket.creatchemicalindustry.blockentity.SimpleNuclearReactorTileEntity;
import org.bedracket.creatchemicalindustry.init.ModBlockEntities;
import org.bedracket.creatchemicalindustry.init.ModItems;

public class SimpleNuclearReactorBlock extends DirectionalKineticBlock implements ITE<SimpleNuclearReactorTileEntity> {

    public static final BooleanProperty notFueled = BooleanProperty.create("not_fueled");
    public static final BooleanProperty notWatered = BooleanProperty.create("not_watered");
    public SimpleNuclearReactorBlock() {
        super(BlockBehaviour.Properties.of(Material.STONE)
                .strength(0.3F).sound(SoundType.STONE)
                .noOcclusion().isValidSpawn(SimpleNuclearReactorBlock::never)
                .isRedstoneConductor(SimpleNuclearReactorBlock::never)
                .isSuffocating(SimpleNuclearReactorBlock::never)
                .isViewBlocking(SimpleNuclearReactorBlock::never));
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        ItemStack heldItem = pPlayer.getItemInHand(pHand);
        System.out.println(pState.getValue(notFueled));
        if (heldItem.is(ModItems.SIMPLE_URANIUM_FUEL_ROD.get()) && pState.getValue(notFueled)) {
            pLevel.setBlock(pPos, pState.setValue(notFueled, false), 3);
            heldItem.setCount(heldItem.getCount() - 1);
            return InteractionResult.SUCCESS;
        } else if (heldItem.is(Items.WATER_BUCKET) && pState.getValue(notWatered)) {
            pLevel.setBlock(pPos, pState.setValue(notWatered, false), 3);
            pPlayer.setItemInHand(pHand, new ItemStack(Items.BUCKET, 1));
            return InteractionResult.SUCCESS;
        }else {
            return InteractionResult.FAIL;
        }
    }


    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
        return AllShapes.MOTOR_BLOCK.get((Direction)state.getValue(FACING));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(notFueled, notWatered);
    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Direction preferred = this.getPreferredFacing(context);
        return (context.getPlayer() == null || !context.getPlayer().isShiftKeyDown()) && preferred != null ? (BlockState)this.defaultBlockState().setValue(FACING, preferred) : super.getStateForPlacement(context);
    }

    public boolean hasShaftTowards(LevelReader world, BlockPos pos, BlockState state, Direction face) {
        return face == state.getValue(FACING);
    }

    @Override
    public Direction.Axis getRotationAxis(BlockState state) {
        return ((Direction)state.getValue(FACING)).getAxis();
    }

    public boolean hideStressImpact() {
        return true;
    }

    public boolean isPathfindable(BlockState state, BlockGetter reader, BlockPos pos, PathComputationType type) {
        return false;
    }

    @Override
    public Class<SimpleNuclearReactorTileEntity> getTileEntityClass() {
        return SimpleNuclearReactorTileEntity.class;
    }

    @Override
    public BlockEntityType<? extends SimpleNuclearReactorTileEntity> getTileEntityType() {
        return ModBlockEntities.SIMPLE_NUCLEAR_REACTOR.get();
    }

    private static boolean never(BlockState state, BlockGetter blockGetter, BlockPos blockPos) {
        return false;
    }

    private static boolean never(BlockState state, BlockGetter blockGetter, BlockPos blockPos, EntityType<?> entityType) {
        return false;
    }
}
