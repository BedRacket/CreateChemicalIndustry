package org.bedracket.creatchemicalindustry.api.event;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.world.BlockEvent;

/**
 * Use when block drop
 * while you can get the BlockPos when the Block break
 */
public class BlockDropEvent extends BlockEvent.BreakEvent {

    private final BlockPos pos;
    private final BlockState state;
    private final Player player;
    private final Level level;

    public BlockDropEvent(Level level, BlockPos pos, BlockState state, Player player) {
        super(level, pos, state, player);
        this.pos = pos;
        this.state = state;
        this.player = player;
        this.level = level;
    }

    @Override
    public BlockPos getPos() {
        return pos;
    }

    @Override
    public BlockState getState() {
        return state;
    }

    @Override
    public Player getPlayer() {
        return player;
    }

    public Level getLevel() {
        return level;
    }
}