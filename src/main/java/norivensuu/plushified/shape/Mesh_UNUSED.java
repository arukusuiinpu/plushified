package norivensuu.plushified.shape;

import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;

public class Mesh_UNUSED {
    //UNUSED! THIS CODE IS UNUSED! DON'T EVEN TRY TO IMPLEMENT IT, I DEAR YOU
    public final double[][] points;

    public Mesh_UNUSED(double[][] points) {
        this.points = points;
    }

    public boolean isEmpty() {
        return Arrays.stream(Arrays.stream(this.points).toArray()).allMatch(null);
    }

    @Nullable
    public BlockHitResult raycast(Vec3d start, Vec3d end, BlockPos pos) {
        // Perform raycast against custom mesh
        Vec3d direction = end.subtract(start).normalize();

        double closestDistance = Double.POSITIVE_INFINITY;
        Vec3d hitPos = null;

        for (double[] point : points) {
            Vec3d point1 = new Vec3d(point[0], point[1], point[2]);
            Vec3d point2 = new Vec3d(point[3], point[4], point[5]);

            Vec3d intersection = getClosestIntersection(start, direction, point1, point2);

            if (intersection != null) {
                double distance = start.distanceTo(intersection);
                if (distance < closestDistance) {
                    closestDistance = distance;
                    hitPos = intersection;
                }
            }
        }

        // Determine side and insideBlock
        Direction side = Direction.getFacing(direction.x, direction.y, direction.z).getOpposite();

        return new BlockHitResult(hitPos, side, pos, true);
    }

    private Vec3d getClosestIntersection(Vec3d start, Vec3d direction, Vec3d point1, Vec3d point2) {
        return start;
    }

}
