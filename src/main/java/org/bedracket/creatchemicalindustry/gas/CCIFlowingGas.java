package org.bedracket.creatchemicalindustry.gas;

import com.google.common.collect.Maps;
import com.mojang.datafixers.util.Pair;
import it.unimi.dsi.fastutil.objects.Object2ByteLinkedOpenHashMap;
import it.unimi.dsi.fastutil.shorts.Short2BooleanMap;
import it.unimi.dsi.fastutil.shorts.Short2BooleanOpenHashMap;
import it.unimi.dsi.fastutil.shorts.Short2ObjectMap;
import it.unimi.dsi.fastutil.shorts.Short2ObjectOpenHashMap;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.LiquidBlockContainer;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.system.CallbackI;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Map;

@ParametersAreNonnullByDefault
public abstract class CCIFlowingGas extends ForgeFlowingFluid {

    private static final ThreadLocal<Object2ByteLinkedOpenHashMap<Block.BlockStatePairKey>> OCCLUSION_CACHE = ThreadLocal.withInitial(() -> {
        Object2ByteLinkedOpenHashMap<Block.BlockStatePairKey> object2bytelinkedopenhashmap = new Object2ByteLinkedOpenHashMap<Block.BlockStatePairKey>(200) {
            protected void rehash(int p_76102_) {
            }
        };
        object2bytelinkedopenhashmap.defaultReturnValue((byte)127);
        return object2bytelinkedopenhashmap;
    });

    protected CCIFlowingGas(Properties properties) {
        super(properties);
    }

    private boolean canHoldFluid(BlockGetter pLevel, BlockPos pPos, BlockState pState, Fluid pFluid) {
        Block block = pState.getBlock();
        if (block instanceof LiquidBlockContainer) {
            return ((LiquidBlockContainer)block).canPlaceLiquid(pLevel, pPos, pState, pFluid);
        } else if (!(block instanceof DoorBlock) && !pState.is(BlockTags.SIGNS) && !pState.is(Blocks.LADDER) && !pState.is(Blocks.SUGAR_CANE) && !pState.is(Blocks.BUBBLE_COLUMN)) {
            Material material = pState.getMaterial();
            if (material != Material.PORTAL && material != Material.STRUCTURAL_AIR && material != Material.WATER_PLANT && material != Material.REPLACEABLE_WATER_PLANT) {
                return !material.blocksMotion();
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    private boolean isWaterHole(BlockGetter pLevel, Fluid pFluid, BlockPos p_75959_, BlockState p_75960_, BlockPos p_75961_, BlockState p_75962_) {
        return p_75962_.getFluidState().getType().isSame(this) ? true : this.canHoldFluid(pLevel, p_75961_, p_75962_, pFluid);
    }
    protected void spread(LevelAccessor pLevel, BlockPos pPos, FluidState pState) {
        if (!pState.isEmpty()) {
            BlockState blockstate = pLevel.getBlockState(pPos);
            BlockPos blockpos = pPos.below();
            BlockState blockstate1 = pLevel.getBlockState(blockpos);
            FluidState fluidstate = this.getNewLiquid(pLevel, blockpos, blockstate1);
            this.spreadToSides(pLevel, pPos, pState, blockstate);

        }
    }

    private boolean isSourceBlockOfThisType(FluidState pState) {
        return pState.getType().isSame(this) && pState.isSource();
    }

    private static short getCacheKey(BlockPos p_76059_, BlockPos p_76060_) {
        int i = p_76060_.getX() - p_76059_.getX();
        int j = p_76060_.getZ() - p_76059_.getZ();
        return (short)((i + 128 & 255) << 8 | j + 128 & 255);
    }

    private boolean canPassThroughWall(Direction pDirection, BlockGetter pLevel, BlockPos p_76064_, BlockState p_76065_, BlockPos p_76066_, BlockState p_76067_) {
        Object2ByteLinkedOpenHashMap<Block.BlockStatePairKey> object2bytelinkedopenhashmap;
        if (!p_76065_.getBlock().hasDynamicShape() && !p_76067_.getBlock().hasDynamicShape()) {
            object2bytelinkedopenhashmap = OCCLUSION_CACHE.get();
        } else {
            object2bytelinkedopenhashmap = null;
        }

        Block.BlockStatePairKey block$blockstatepairkey;
        if (object2bytelinkedopenhashmap != null) {
            block$blockstatepairkey = new Block.BlockStatePairKey(p_76065_, p_76067_, pDirection);
            byte b0 = object2bytelinkedopenhashmap.getAndMoveToFirst(block$blockstatepairkey);
            if (b0 != 127) {
                return b0 != 0;
            }
        } else {
            block$blockstatepairkey = null;
        }

        VoxelShape voxelshape1 = p_76065_.getCollisionShape(pLevel, p_76064_);
        VoxelShape voxelshape = p_76067_.getCollisionShape(pLevel, p_76066_);
        boolean flag = !Shapes.mergedFaceOccludes(voxelshape1, voxelshape, pDirection);
        if (object2bytelinkedopenhashmap != null) {
            if (object2bytelinkedopenhashmap.size() == 200) {
                object2bytelinkedopenhashmap.removeLastByte();
            }

            object2bytelinkedopenhashmap.putAndMoveToFirst(block$blockstatepairkey, (byte)(flag ? 1 : 0));
        }

        return flag;
    }

    private boolean canPassThrough(BlockGetter pLevel, Fluid pFluid, BlockPos p_75966_, BlockState p_75967_, Direction pDirection, BlockPos p_75969_, BlockState p_75970_, FluidState p_75971_) {
        return !this.isSourceBlockOfThisType(p_75971_) && this.canPassThroughWall(pDirection, pLevel, p_75966_, p_75967_, p_75969_, p_75970_) && this.canHoldFluid(pLevel, p_75969_, p_75970_, pFluid);
    }

    protected @NotNull Map<Direction, FluidState> getSpread(LevelReader pLevel, BlockPos pPos, BlockState pState) {
        int i = 1000;
        Map<Direction, FluidState> map = Maps.newEnumMap(Direction.class);
        Short2ObjectMap<Pair<BlockState, FluidState>> short2objectmap = new Short2ObjectOpenHashMap<>();
        Short2BooleanMap short2booleanmap = new Short2BooleanOpenHashMap();

        for(Direction direction : Direction.Plane.HORIZONTAL) {
            BlockPos blockpos = pPos.relative(direction);
            short short1 = getCacheKey(pPos, blockpos);
            Pair<BlockState, FluidState> pair = short2objectmap.computeIfAbsent(short1, (p_192907_) -> {
                BlockState blockstate1 = pLevel.getBlockState(blockpos);
                return Pair.of(blockstate1, blockstate1.getFluidState());
            });
            BlockState blockstate = pair.getFirst();
            FluidState fluidstate = pair.getSecond();
            FluidState fluidstate1 = this.getNewLiquid(pLevel, blockpos, blockstate);
            if (this.canPassThrough(pLevel, fluidstate1.getType(), pPos, pState, direction, blockpos, blockstate, fluidstate)) {
                BlockPos blockpos1 = blockpos;
                boolean flag = short2booleanmap.computeIfAbsent(short1, (p_192903_) -> {
                    BlockState blockstate1 = pLevel.getBlockState(blockpos1);
                    return this.isWaterHole(pLevel, this.getFlowing(), blockpos, blockstate, blockpos1, blockstate1);
                });
                int j;
                if (flag) {
                    j = 0;
                } else {
                    j = this.getSlopeDistance(pLevel, blockpos, 1, direction.getOpposite(), blockstate, pPos, short2objectmap, short2booleanmap);
                }

                if (j < i) {
                    map.clear();
                }

                if (j <= i) {
                    map.put(direction, fluidstate1);
                    i = j;
                }
            }
        }

        return map;
    }

    private void spreadToSides(LevelAccessor pLevel, BlockPos pPos, FluidState pFluidState, BlockState pBlockState) {
        int i = pFluidState.getAmount() - this.getDropOff(pLevel);
        if (i > 0) {
            Map<Direction, FluidState> map = this.getSpread(pLevel, pPos, pBlockState);

            for(Map.Entry<Direction, FluidState> entry : map.entrySet()) {
                Direction direction = entry.getKey();
                FluidState fluidstate = entry.getValue();
                BlockPos blockpos = pPos.relative(direction);
                BlockState blockstate = pLevel.getBlockState(blockpos);
                if (this.canSpreadTo(pLevel, pPos, pBlockState, direction, blockpos, blockstate, pLevel.getFluidState(blockpos), fluidstate.getType())) {
                    this.spreadTo(pLevel, blockpos, blockstate, direction, fluidstate);
                }
            }

        }
    }

    public void tick(Level pLevel, BlockPos pPos, FluidState pState) {
        this.spread(pLevel, pPos, pState);
        if (!pState.isSource()) {
            FluidState fluidstate = this.getNewLiquid(pLevel, pPos, pLevel.getBlockState(pPos));
            int i = this.getSpreadDelay(pLevel, pPos, pState, fluidstate);
            if (!fluidstate.equals(pState)) {
                pState = fluidstate;
                BlockState blockstate = fluidstate.createLegacyBlock();
                pLevel.setBlock(pPos, blockstate, 2);
                pLevel.scheduleTick(pPos, fluidstate.getType(), i);
                pLevel.updateNeighborsAt(pPos, blockstate.getBlock());
            }else if (fluidstate.isEmpty()) {
                pState = fluidstate;
                pLevel.setBlock(pPos, Blocks.AIR.defaultBlockState(), 3);
            }
        }
        if (pState.isSource()) {
            pLevel.setBlock(pPos, Blocks.AIR.defaultBlockState(), 3);
        }
    }


    public static class Flowing extends CCIFlowingGas
    {
        public Flowing(Properties properties)
        {
            super(properties);
            registerDefaultState(getStateDefinition().any().setValue(LEVEL, 7));
        }

        protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
            super.createFluidStateDefinition(builder);
            builder.add(LEVEL);
        }

        public int getAmount(FluidState state) {
            return state.getValue(LEVEL);
        }

        public boolean isSource(FluidState state) {
            return false;
        }
    }

    public static class Source extends CCIFlowingGas {
        public Source(Properties properties)
        {
            super(properties);
        }

        public int getAmount(FluidState state) {
            return 8;
        }

        public boolean isSource(FluidState state) {
            return true;
        }
    }
}
