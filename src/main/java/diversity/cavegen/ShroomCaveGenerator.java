//
// Decompiled by Procyon v0.5.36
//

package diversity.cavegen;

import java.util.TreeMap;
import java.util.Iterator;
import diversity.utils.EnumCubeType;
import diversity.utils.Table3d;
import java.util.ArrayList;
import diversity.utils.Point;
import java.util.List;
import java.util.Random;

public class ShroomCaveGenerator implements ICaveGenerator
{
    private final int minRadius;
    private final int maxRadius;
    private final int radiusRandomer;

    public ShroomCaveGenerator(final int minRadius, final int maxRadius, final int radiusRandomer) {
        this.minRadius = minRadius;
        this.maxRadius = maxRadius;
        this.radiusRandomer = radiusRandomer;
    }

    @Override
    public List<Point> getControlPoints(final Random random, final int initX, final int initY, final int initZ) {
        final List<Point> list = new ArrayList<Point>();
        list.add(new Point(initX, initY, initZ, this.maxRadius));
        int coloneY = initY - 3;
        int coloneRadius = this.maxRadius;
        for (double teta = Math.toRadians(90.0), tempTeta = 1.5707963267948966; tempTeta <= 7.853981633974483; tempTeta += teta) {
            final int coloneX = initX + (int)(Math.cos(tempTeta) * this.maxRadius * 2.5) + random.nextInt(3) - 1;
            final int coloneZ = initZ + (int)(Math.sin(tempTeta) * this.maxRadius * 2.5) + random.nextInt(3) - 1;
            list.add(new Point(coloneX, coloneY + random.nextInt(3) - 1, coloneZ, coloneRadius));
        }
        coloneY = initY + this.maxRadius / 4 - 3;
        coloneRadius = this.maxRadius / 2 + 1;
        double teta = Math.toRadians(35.0);
        for (double tempTeta = 0.0; tempTeta < 6.283185307179586; tempTeta += teta) {
            final int coloneX = initX + (int)(Math.cos(tempTeta) * this.maxRadius / 2.2) + random.nextInt(3) - 1;
            final int coloneZ = initZ + (int)(Math.sin(tempTeta) * this.maxRadius / 2.2) + random.nextInt(3) - 1;
            list.add(new Point(coloneX, coloneY + random.nextInt(3) - 1, coloneZ, coloneRadius));
        }
        coloneY = initY;
        for (double tempTeta = 0.0; tempTeta < 6.283185307179586; tempTeta += teta) {
            final int coloneX = initX + (int)(Math.cos(tempTeta) * this.maxRadius * 1.7) + random.nextInt(3) - 1;
            final int coloneZ = initZ + (int)(Math.sin(tempTeta) * this.maxRadius * 1.7) + random.nextInt(3) - 1;
            list.add(new Point(coloneX, coloneY + random.nextInt(7) - 1, coloneZ, coloneRadius));
        }
        coloneY = initY - this.maxRadius / 4 + 2 - 1;
        teta = Math.toRadians(45.0);
        final double tetaColone = Math.toRadians(35.275759);
        for (double tempTeta2 = 0.0; tempTeta2 < 6.283185307179586; tempTeta2 += teta) {
            if (random.nextInt(10) != 0) {
                final int coloneX2 = initX + (int)(Math.cos(tempTeta2) * this.maxRadius * 2.7) + random.nextInt(3) - 1;
                final int coloneZ2 = initZ + (int)(Math.sin(tempTeta2) * this.maxRadius * 2.7) + random.nextInt(3) - 1;
                for (double tempTetaColone = 0.0; tempTetaColone < 6.283185307179586; tempTetaColone += tetaColone) {
                    final int tempColoneX = coloneX2 + (int)(Math.cos(tempTetaColone) * coloneRadius * 1.7) + random.nextInt(3) - 1;
                    final int tempColoneZ = coloneZ2 + (int)(Math.sin(tempTetaColone) * coloneRadius * 1.7) + random.nextInt(3) - 1;
                    if (random.nextInt(10) != 0) {
                        list.add(new Point(tempColoneX, coloneY + random.nextInt(7) - 4, tempColoneZ, coloneRadius));
                    }
                }
            }
        }
        return list;
    }

    @Override
    public Table3d getCavePoints(final List<Point> sphereCenter, final Random random) {
        final Table3d blocks = new Table3d();
        for (final Point center : sphereCenter) {
            final int x = center.x;
            final int y = center.y;
            final int z = center.z;
            final int radius = center.radius;
            final int minY = -radius;
            final int maxY = radius;
            final int minX = -radius - this.radiusRandomer / 2 + random.nextInt(this.radiusRandomer + 1);
            final int maxX = radius - this.radiusRandomer / 2 + random.nextInt(this.radiusRandomer + 1);
            final int minZ = -radius - this.radiusRandomer / 2 + random.nextInt(this.radiusRandomer + 1);
            final int maxZ = radius - this.radiusRandomer / 2 + random.nextInt(this.radiusRandomer + 1);
            if (sphereCenter.get(0).equals(center)) {
                for (int tempY = maxY; tempY >= minY / 2; --tempY) {
                    for (int tempX = minX; tempX <= maxX; ++tempX) {
                        for (int tempZ = minZ; tempZ <= maxZ; ++tempZ) {
                            if (Math.pow(tempX, 2.0) + Math.pow(tempY * 2, 2.0) + Math.pow(tempZ, 2.0) < Math.pow(radius, 2.0)) {
                                blocks.put(x + tempX, y + tempY, z + tempZ, EnumCubeType.AIR);
                            }
                        }
                    }
                }
            }
            else if (center.radius == this.maxRadius / 2 + 1) {
                for (double tempY2 = maxY * 1.5; tempY2 >= minY; --tempY2) {
                    for (int tempX2 = minX; tempX2 <= maxX; ++tempX2) {
                        for (int tempZ2 = minZ; tempZ2 <= maxZ; ++tempZ2) {
                            if ((tempY2 < 0.0 && Math.pow(tempX2 / 2, 2.0) + Math.pow(tempY2, 2.0) + Math.pow(tempZ2, 2.0) < Math.pow(radius, 2.0)) || Math.pow(tempX2 / 2, 2.0) + Math.pow(tempY2 / 1.5, 2.0) + Math.pow(tempZ2, 2.0) < Math.pow(radius, 2.0)) {
                                blocks.put(x + tempX2, y + (int)tempY2, z + tempZ2, EnumCubeType.AIR);
                            }
                        }
                    }
                }
            }
            else {
                for (int tempY = maxY; tempY >= minY; --tempY) {
                    for (int tempX = minX; tempX <= maxX; ++tempX) {
                        for (int tempZ = minZ; tempZ <= maxZ; ++tempZ) {
                            if (Math.pow(tempX, 2.0) + Math.pow(tempY, 2.0) + Math.pow(tempZ, 2.0) < Math.pow(radius, 2.0)) {
                                blocks.put(x + tempX, y + tempY, z + tempZ, EnumCubeType.AIR);
                            }
                        }
                    }
                }
            }
        }
        return blocks;
    }

    @Override
    public void generateBlockType(final Random random, final Table3d blocks, final int waterLevel) {
        for (final Integer y : blocks.descendingKeySet()) {
            for (final Integer x : blocks.rowKeySet(y)) {
                for (final Integer z : blocks.columnKeySet(y)) {
                    if (blocks.containsKey(x, y, z)) {
                        if (!blocks.containsKey(x, y + 1, z) && blocks.containsKey(x + 1, y - 1, z) && blocks.containsKey(x - 1, y - 1, z) && blocks.containsKey(x, y - 1, z + 1) && blocks.containsKey(x, y - 1, z - 1)) {
                            blocks.put(x, y, z, EnumCubeType.ROOF);
                        }
                        else if (!blocks.containsKey(x + 1, y, z) || !blocks.containsKey(x - 1, y, z) || !blocks.containsKey(x, y, z + 1) || !blocks.containsKey(x, y, z - 1)) {
                            if (blocks.containsKey(x, y + 1, z) && blocks.get(x, y + 1, z).equals(EnumCubeType.ROOF) && blocks.containsKey(x + 1, y - 1, z) && blocks.containsKey(x - 1, y - 1, z) && blocks.containsKey(x, y - 1, z + 1) && blocks.containsKey(x, y - 1, z - 1)) {
                                blocks.put(x, y, z, EnumCubeType.ROOF);
                            }
                            else if (blocks.containsKey(x, y + 1, z) && blocks.get(x, y + 1, z).equals(EnumCubeType.AIR)) {
                                if (y < waterLevel) {
                                    blocks.put(x, y, z, EnumCubeType.UNDERGROUND);
                                }
                                else {
                                    blocks.put(x, y, z, EnumCubeType.GROUND);
                                }
                            }
                            else if (blocks.containsKey(x, y + 1, z) && (blocks.get(x, y + 1, z).equals(EnumCubeType.GROUND) || blocks.get(x, y + 1, z).equals(EnumCubeType.UNDERGROUND)) && (!blocks.containsKey(x, y + 3, z) || !blocks.get(x, y + 2, z).equals(EnumCubeType.UNDERGROUND) || !blocks.get(x, y + 2, z).equals(EnumCubeType.GROUND))) {
                                blocks.put(x, y, z, EnumCubeType.UNDERGROUND);
                            }
                            else if (y <= waterLevel) {
                                blocks.put(x, y, z, EnumCubeType.UNDERGROUND);
                            }
                            else {
                                blocks.put(x, y, z, EnumCubeType.WALL);
                            }
                        }
                        else if (!blocks.containsKey(x, y - 1, z)) {
                            if (y < waterLevel) {
                                blocks.put(x, y, z, EnumCubeType.UNDERGROUND);
                            }
                            else {
                                blocks.put(x, y, z, EnumCubeType.GROUND);
                            }
                        }
                        else {
                            if (y > waterLevel) {
                                continue;
                            }
                            blocks.put(x, y, z, EnumCubeType.WATER);
                        }
                    }
                }
            }
        }
    }
}
