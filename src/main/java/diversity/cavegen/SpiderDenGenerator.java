// 
// Decompiled by Procyon v0.5.36
// 

package diversity.cavegen;

import java.util.TreeMap;
import java.util.Iterator;
import diversity.utils.EnumCubeType;
import diversity.utils.Table3d;
import java.util.ArrayList;
import java.util.Random;
import java.util.HashMap;
import java.util.List;
import diversity.utils.Point;
import java.util.Map;

public class SpiderDenGenerator implements ICaveGenerator
{
    private final int minRadius;
    private final int maxRadius;
    private final int radiusRandomer;
    private Map<Point, List<Point>> map;
    
    public SpiderDenGenerator(final int minRadius, final int maxRadius, final int radiusRandomer) {
        this.map = new HashMap<Point, List<Point>>();
        this.minRadius = minRadius;
        this.maxRadius = maxRadius;
        this.radiusRandomer = radiusRandomer;
    }
    
    @Override
    public List<Point> getControlPoints(final Random random, final int initX, final int initY, final int initZ) {
        final List<Point> list = new ArrayList<Point>();
        list.add(new Point(initX, initY, initZ, this.maxRadius));
        final float randX = random.nextFloat() + 0.125f;
        final float randZ = 1.625f - randX;
        for (double teta = Math.toRadians(59.0), tempTeta = 0.0; tempTeta < 6.283185307179586; tempTeta += teta) {
            final int coloneX = initX + (int)(Math.cos(tempTeta) * this.maxRadius * 1.3 * randX) + random.nextInt(3) - 1;
            final int coloneZ = initZ + (int)(Math.sin(tempTeta) * this.maxRadius * 1.3 * randZ) + random.nextInt(3) - 1;
            list.add(new Point(coloneX, initY + random.nextInt(3) - 1, coloneZ, this.maxRadius / 2));
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
            for (int tempY = maxY; tempY >= minY; --tempY) {
                for (int tempX = minX * 2; tempX <= maxX * 2; ++tempX) {
                    for (int tempZ = minZ * 2; tempZ <= maxZ * 2; ++tempZ) {
                        if (Math.pow(tempX / 2, 2.0) + Math.pow(tempY, 2.0) + Math.pow(tempZ / 2, 2.0) < Math.pow(radius, 2.0)) {
                            blocks.put(x + tempX, y + tempY, z + tempZ, EnumCubeType.AIR);
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
                                blocks.put(x, y, z, EnumCubeType.GROUND);
                            }
                            else if (blocks.containsKey(x, y + 1, z) && (blocks.get(x, y + 1, z).equals(EnumCubeType.GROUND) || blocks.get(x, y + 1, z).equals(EnumCubeType.UNDERGROUND)) && (!blocks.containsKey(x, y + 3, z) || !blocks.get(x, y + 2, z).equals(EnumCubeType.UNDERGROUND) || !blocks.get(x, y + 2, z).equals(EnumCubeType.GROUND))) {
                                blocks.put(x, y, z, EnumCubeType.UNDERGROUND);
                            }
                            else {
                                blocks.put(x, y, z, EnumCubeType.WALL);
                            }
                        }
                        else {
                            if (blocks.containsKey(x, y - 1, z)) {
                                continue;
                            }
                            if (y < waterLevel) {
                                blocks.put(x, y, z, EnumCubeType.UNDERGROUND);
                            }
                            else {
                                blocks.put(x, y, z, EnumCubeType.GROUND);
                            }
                        }
                    }
                }
            }
        }
    }
}
