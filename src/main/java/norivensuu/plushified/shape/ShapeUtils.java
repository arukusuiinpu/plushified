package norivensuu.plushified.shape;

import it.unimi.dsi.fastutil.doubles.DoubleArrayList;
import net.minecraft.block.Block;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.BitSetVoxelSet;
import net.minecraft.util.shape.VoxelSet;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;

public class ShapeUtils {
    public static VoxelShape rotateShape(Direction from, Direction to, VoxelShape shape) {
        VoxelShape[] buffer = new VoxelShape[]{shape, VoxelShapes.empty()};

        int times = (to.getHorizontal() - from.getHorizontal() + 4) % 4;
        for (int i = 0; i < times; i++) {
            buffer[0].forEachBox((minX, minY, minZ, maxX, maxY, maxZ) -> buffer[1] = VoxelShapes.union(buffer[1], VoxelShapes.cuboid(1 - maxZ, minY, minX, 1 - minZ, maxY, maxX)));
            buffer[0] = buffer[1];
            buffer[1] = VoxelShapes.empty();
        }

        return buffer[0];
    }

    public static VoxelShape rotateShape(Direction to, VoxelShape shape) {
        VoxelShape[] buffer = new VoxelShape[]{shape, VoxelShapes.empty()};

        int times = (to.getHorizontal() - Direction.NORTH.getHorizontal() + 4) % 4;
        for (int i = 0; i < times; i++) {
            buffer[0].forEachBox((minX, minY, minZ, maxX, maxY, maxZ) -> buffer[1] = VoxelShapes.union(buffer[1], VoxelShapes.cuboid(1 - maxZ, minY, minX, 1 - minZ, maxY, maxX)));
            buffer[0] = buffer[1];
            buffer[1] = VoxelShapes.empty();
        }

        return buffer[0];
    }

    public static double voxelizePoint(float f, float offset) {
        return (f + offset) / 16f;
    }
    public static double voxelizePoint(float f) {
        return f / 16f;
    }

    public static double voxelizePoint(double f, double offset) {
        return (f + offset) / 16f;
    }
    public static double voxelizePoint(double f) {
        return f / 16f;
    }

    public static double voxelizePoint(int f, int offset) {
        return (f + offset) / 16f;
    }
    public static double voxelizePoint(int f) {
        return f / 16f;
    }

    public static double[] voxelizePoints(double[] points, double offset) {
        double[] voxelizedPoints = points.clone();
        for(int i = 0; i < points.length; i++) {
            voxelizedPoints[i] = voxelizePoint(points[i],offset);
        }
        return voxelizedPoints;
    }
    public static double[] voxelizePoints(double[] points, float offset) {
        double[] voxelizedPoints = points.clone();
        for(int i = 0; i < points.length; i++) {
            voxelizedPoints[i] = voxelizePoint(points[i],offset);
        }
        return voxelizedPoints;
    }
    public static double[] voxelizePoints(double[] points, int offset) {
        double[] voxelizedPoints = points.clone();
        for(int i = 0; i < points.length; i++) {
            voxelizedPoints[i] = voxelizePoint(points[i],offset);
        }
        return voxelizedPoints;
    }
    public static double[] voxelizePoints(double[] points) {
        double[] voxelizedPoints = points.clone();
        for(int i = 0; i < points.length; i++) {
            voxelizedPoints[i] = voxelizePoint(points[i]);
        }
        return voxelizedPoints;
    }

    public static VoxelShape createArrayShape(double[] xPoints, double[] yPoints, double[] zPoints) {
        VoxelSet voxelSet = new BitSetVoxelSet(2, 2, 2);
        voxelSet.set(0, 0, 0);
        return new CustomArrayVoxelShape(
                voxelSet,
                DoubleArrayList.wrap(xPoints),
                DoubleArrayList.wrap(yPoints),
                DoubleArrayList.wrap(zPoints)
        );
        //return new CustomSimpleVoxelShape(voxelSet);
    }

    public static VoxelShape createIterationalStairsShape(double minX, double minY, double minZ, double maxX, double maxY, double maxZ, int amount, int scale) {
        VoxelShape parts = Block.createCuboidShape(0,0,0,16,16,16);
        double[] X = new double[amount+1];
        double[] Y = new double[amount+1];
        double[] Z = new double[amount+1];
        int a = 0;
        for (double i = 0; i < (maxX-minX); i += (maxX-minX)/amount) {
            X[a] = i;
            a++;
        }
        a = 0;
        for (double i = 0; i < (maxY-minY); i += (maxY-minY)/amount) {
            Y[a] = i;
            a++;
        }
        a = 0;
        for (double i = 0; i < (maxZ-minZ); i += (maxZ-minZ)/amount) {
            Z[a] = i;
            a++;
        }
        X[0] = Math.min(X[0],X[scale]);
        X[scale] = Math.max(X[0],X[scale]);
        Y[0] = Math.min(Y[0],Y[scale]);
        Y[scale] = Math.max(Y[0],Y[scale]);
        Z[0] = Math.min(Z[0],Z[scale]);
        Z[scale] = Math.max(Z[0],Z[scale]);
        VoxelShape last_part = Block.createCuboidShape(X[0],Y[0],Z[0],X[scale],Y[scale],Z[scale]);
        for (int i = 1; i < X.length-scale; i += 1) {
            X[i] = Math.min(X[i],X[i+scale]);
            X[i+scale] = Math.max(X[i],X[i+scale]);
            Y[i] = Math.min(Y[i],Y[i+scale]);
            Y[i+scale] = Math.max(Y[i],Y[i+scale]);
            Z[i] = Math.min(Z[i],Z[i+scale]);
            Z[i+scale] = Math.max(Z[i],Z[i+scale]);
            parts = VoxelShapes.union(last_part,Block.createCuboidShape(X[i],Y[i],Z[i],X[i+scale],Y[i+scale],Z[i+scale]));
            last_part = parts;
        }
        return parts;
    }
}
