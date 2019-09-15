//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package diversity.cavegen;

import diversity.utils.EnumCubeType;
import diversity.utils.Point;
import diversity.utils.Table3d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class YetiDenGenerator implements ICaveGenerator {
    private final int minRadius;
    private final int maxRadius;
    private final int radiusRandomer;
    private Map<Point, List<Point>> map = new HashMap();

    public YetiDenGenerator(int minRadius, int maxRadius, int radiusRandomer) {
        this.minRadius = minRadius;
        this.maxRadius = maxRadius;
        this.radiusRandomer = radiusRandomer;
    }

    @Override
    public List<Point> getControlPoints(Random random, int initX, int initY, int initZ) {
        List<Point> list = new ArrayList();
        list.add(new Point(initX, initY, initZ, this.maxRadius - 1));
        int tempX = 0;
        int tempY = 0;
        int tempZ = 0;
        int counter = 10;

        for(double teta = 6.283185307179586D * (double)random.nextFloat(); counter > 0; --counter) {
            teta += 3.141592653589793D * (double)(0.0F - random.nextFloat() / 2.0F);
            tempX = (int)((double)tempX + ((double)(this.maxRadius - 2) * Math.cos(teta) - (double)random.nextInt(2)));
            tempY += 2;
            tempZ = (int)((double)tempZ + ((double)(this.maxRadius - 2) * Math.sin(teta) - (double)random.nextInt(2)));
            list.add(new Point(initX + tempX, initY + tempY, initZ + tempZ, this.maxRadius - 2));
        }

        return list;
    }

    @Override
    public Table3d getCavePoints(List<Point> sphereCenter, Random random) {
        Table3d blocks = new Table3d();
        Iterator var4 = sphereCenter.iterator();

        while(var4.hasNext()) {
            Point center = (Point)var4.next();
            int x = center.x;
            int y = center.y;
            int z = center.z;
            int radius = center.radius;
            int minY = -radius;
            int minX = -radius - this.radiusRandomer / 2 + random.nextInt(this.radiusRandomer + 1);
            int maxX = radius - this.radiusRandomer / 2 + random.nextInt(this.radiusRandomer + 1);
            int minZ = -radius - this.radiusRandomer / 2 + random.nextInt(this.radiusRandomer + 1);
            int maxZ = radius - this.radiusRandomer / 2 + random.nextInt(this.radiusRandomer + 1);

            for(int tempY = radius; tempY >= minY; --tempY) {
                for(int tempX = minX; tempX <= maxX; ++tempX) {
                    for(int tempZ = minZ; tempZ <= maxZ; ++tempZ) {
                        if (Math.pow((double)tempX, 2.0D) + Math.pow((double)tempY, 2.0D) + Math.pow((double)tempZ, 2.0D) < Math.pow((double)radius, 2.0D)) {
                            blocks.put(x + tempX, y + tempY, z + tempZ, EnumCubeType.AIR);
                        }
                    }
                }
            }
        }

        return blocks;
    }

    @Override
    public void generateBlockType(Random random, Table3d blocks, int waterLevel) {
        Iterator var4 = blocks.descendingKeySet().iterator();

        while(var4.hasNext()) {
            Integer y = (Integer)var4.next();
            Iterator var6 = blocks.rowKeySet(y).iterator();

            label102:
            while(var6.hasNext()) {
                Integer x = (Integer)var6.next();
                Iterator var8 = blocks.columnKeySet(y).iterator();

                while(true) {
                    while(true) {
                        Integer z;
                        do {
                            if (!var8.hasNext()) {
                                continue label102;
                            }

                            z = (Integer)var8.next();
                        } while(!blocks.containsKey(x, y, z));

                        if (!blocks.containsKey(x, y + 1, z) && blocks.containsKey(x + 1, y - 1, z) && blocks.containsKey(x - 1, y - 1, z) && blocks.containsKey(x, y - 1, z + 1) && blocks.containsKey(x, y - 1, z - 1)) {
                            blocks.put(x, y, z, EnumCubeType.ROOF);
                        } else if (blocks.containsKey(x + 1, y, z) && blocks.containsKey(x - 1, y, z) && blocks.containsKey(x, y, z + 1) && blocks.containsKey(x, y, z - 1)) {
                            if (!blocks.containsKey(x, y - 1, z)) {
                                if (y < waterLevel) {
                                    blocks.put(x, y, z, EnumCubeType.UNDERGROUND);
                                } else {
                                    blocks.put(x, y, z, EnumCubeType.GROUND);
                                }
                            }
                        } else if (blocks.containsKey(x, y + 1, z) && blocks.get(x, y + 1, z).equals(EnumCubeType.ROOF) && blocks.containsKey(x + 1, y - 1, z) && blocks.containsKey(x - 1, y - 1, z) && blocks.containsKey(x, y - 1, z + 1) && blocks.containsKey(x, y - 1, z - 1)) {
                            blocks.put(x, y, z, EnumCubeType.ROOF);
                        } else if (blocks.containsKey(x, y + 1, z) && blocks.get(x, y + 1, z).equals(EnumCubeType.AIR)) {
                            blocks.put(x, y, z, EnumCubeType.GROUND);
                        } else if (!blocks.containsKey(x, y + 1, z) || !blocks.get(x, y + 1, z).equals(EnumCubeType.GROUND) && !blocks.get(x, y + 1, z).equals(EnumCubeType.UNDERGROUND) || blocks.containsKey(x, y + 3, z) && blocks.get(x, y + 2, z).equals(EnumCubeType.UNDERGROUND) && blocks.get(x, y + 2, z).equals(EnumCubeType.GROUND)) {
                            blocks.put(x, y, z, EnumCubeType.WALL);
                        } else {
                            blocks.put(x, y, z, EnumCubeType.UNDERGROUND);
                        }
                    }
                }
            }
        }

    }
}
