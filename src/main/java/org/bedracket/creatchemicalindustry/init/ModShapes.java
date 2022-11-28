package org.bedracket.creatchemicalindustry.init;

import com.simibubi.create.AllShapes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.shapes.VoxelShape;

/**
 * Machine or some blocks' shapes
 */
public class ModShapes {
    private static AllShapes.Builder shape(VoxelShape shape) {
        return new AllShapes.Builder(shape);
    }

    private static AllShapes.Builder shape(double x1, double y1, double z1, double x2, double y2, double z2) {
        return shape(cuboid(x1, y1, z1, x2, y2, z2));
    }

    private static VoxelShape cuboid(double x1, double y1, double z1, double x2, double y2, double z2) {
        return Block.box(x1, y1, z1, x2, y2, z2);
    }

    public static final VoxelShape GLASS_JAR_SHAPE =
            shape(0.0, 0.0, 0.0, 16.0, 14.0, 16.0).erase(2.0, 0.0, 2.0, 14.0, 14.0, 14.0).add(2.0, 14.0, 2.0, 14.0, 16.0, 14.0).build();
}
