//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package diversity.cavegen;

import diversity.utils.EnumCubeType;
import diversity.utils.Point;
import diversity.utils.Table3d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class DwarvenCaveGenerator implements ICaveGenerator {
    private final int minRadius;
    private final int maxRadius;
    private final int radiusRandomer;

    public DwarvenCaveGenerator(int minRadius, int maxRadius, int radiusRandomer) {
        this.minRadius = minRadius;
        this.maxRadius = maxRadius;
        this.radiusRandomer = radiusRandomer;
    }

    @Override
    public List<Point> getControlPoints(Random random, int initX, int initY, int initZ) {
        List<Point> list = new ArrayList();
        list.add(new Point(initX, initY, initZ, this.maxRadius));
        int coloneY = initY - this.maxRadius + 5;
        int coloneRadius = this.maxRadius / 2;
        double teta = Math.toRadians(28.95502438D);

        double tempTeta;
        int coloneX;
        int coloneZ;
        for(tempTeta = 0.0D; tempTeta < 6.283185307179586D; tempTeta += teta) {
            coloneX = initX + (int)(Math.cos(tempTeta) * (double)this.maxRadius) + random.nextInt(3) - 1;
            coloneZ = initZ + (int)(Math.sin(tempTeta) * (double)this.maxRadius) + random.nextInt(3) - 1;
            list.add(new Point(coloneX, coloneY + random.nextInt(3) - 1, coloneZ, coloneRadius));
        }

        coloneY -= coloneRadius;
        coloneRadius = this.maxRadius / 2 - 1;
        teta = Math.toRadians(23.07391806D);

        for(tempTeta = 0.0D; tempTeta < 6.283185307179586D; tempTeta += teta) {
            coloneX = initX + (int)(Math.cos(tempTeta) * (double)this.maxRadius) + random.nextInt(3) - 1;
            coloneZ = initZ + (int)(Math.sin(tempTeta) * (double)this.maxRadius) + random.nextInt(3) - 1;
            list.add(new Point(coloneX, coloneY + random.nextInt(3) - 1, coloneZ, coloneRadius));
        }

        coloneY = initY - 2;
        coloneRadius = this.maxRadius / 2;
        teta = Math.toRadians(44.04862568D);

        for(tempTeta = 0.0D; tempTeta < 6.283185307179586D; tempTeta += teta) {
            int tempColoneRadius;
            double tetaColone;
            double tempTetaColone;
            int tempColoneX;
            int tempColoneZ;
            if (random.nextInt(10) != 0) {
                coloneX = initX + (int)(Math.cos(tempTeta) * (double)this.maxRadius * 2.3D) + random.nextInt(3) - 1;
                coloneZ = initZ + (int)(Math.sin(tempTeta) * (double)this.maxRadius * 2.3D) + random.nextInt(3) - 1;
                tempColoneRadius = this.maxRadius / 3;
                tetaColone = Math.toRadians(35.275759D);

                for(tempTetaColone = 0.0D; tempTetaColone < 6.283185307179586D; tempTetaColone += tetaColone) {
                    tempColoneX = coloneX + (int)(Math.cos(tempTetaColone) * (double)coloneRadius) + random.nextInt(3) - 1;
                    tempColoneZ = coloneZ + (int)(Math.sin(tempTetaColone) * (double)coloneRadius) + random.nextInt(3) - 1;
                    list.add(new Point(tempColoneX, coloneY + random.nextInt(3) - 1, tempColoneZ, tempColoneRadius));
                }
            }

            if (random.nextInt(7) == 0) {
                coloneX = initX + (int)(Math.cos(tempTeta) * (double)this.maxRadius * 3.0D) + random.nextInt(3) - 1;
                coloneZ = initZ + (int)(Math.sin(tempTeta) * (double)this.maxRadius * 3.0D) + random.nextInt(3) - 1;
                tempColoneRadius = this.maxRadius / 3;
                tetaColone = Math.toRadians(35.275759D);

                for(tempTetaColone = Math.toRadians(17.6378795D); tempTetaColone < 6.283185307179586D + Math.toRadians(17.6378795D); tempTetaColone += tetaColone) {
                    tempColoneX = coloneX + (int)(Math.cos(tempTetaColone) * (double)coloneRadius) + random.nextInt(3) - 1;
                    tempColoneZ = coloneZ + (int)(Math.sin(tempTetaColone) * (double)coloneRadius) + random.nextInt(3) - 1;
                    list.add(new Point(tempColoneX, coloneY + random.nextInt(3) - 1, tempColoneZ, tempColoneRadius));
                }
            }
        }

        return list;
    }

    @Override
    public Table3d getCavePoints(List<Point> sphereCenter, Random random) {
        Table3d blocks = new Table3d();
        Iterator var4 = sphereCenter.iterator();

        while(true) {
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
                int tempY;
                int tempX;
                int tempZ;
                if (radius == this.maxRadius) {
                    for(tempY = radius; tempY >= minY; --tempY) {
                        for(tempX = minX * 2; tempX <= maxX * 2; ++tempX) {
                            for(tempZ = minZ * 2; tempZ <= maxZ * 2; ++tempZ) {
                                if (Math.pow((double)(tempX / 2), 2.0D) + Math.pow((double)tempY, 2.0D) + Math.pow((double)(tempZ / 2), 2.0D) < Math.pow((double)radius, 2.0D) && (y + tempY >= 30 || y + tempY >= 12 && Math.pow((double)(x + tempX - ((Point)sphereCenter.get(0)).x), 2.0D) + Math.pow((double)(z + tempZ - ((Point)sphereCenter.get(0)).z), 2.0D) + Math.pow((double)(y + tempY - ((Point)sphereCenter.get(0)).z), 2.0D) > Math.pow((double)(((Point)sphereCenter.get(0)).radius * 2 / 3), 2.0D) && Math.pow((double)(x + tempX - ((Point)sphereCenter.get(0)).x), 2.0D) + Math.pow((double)(z + tempZ - ((Point)sphereCenter.get(0)).z), 2.0D) > Math.pow((double)(((Point)sphereCenter.get(0)).radius * 2 / 3), 2.0D))) {
                                    blocks.put(x + tempX, y + tempY, z + tempZ, EnumCubeType.AIR);
                                }
                            }
                        }
                    }
                } else if (radius != this.maxRadius / 2 && radius != this.maxRadius / 2 - 1) {
                    if (radius == this.maxRadius / 3) {
                        for(tempY = radius * 2; tempY >= minY * 2; --tempY) {
                            for(tempX = minX; tempX <= maxX; ++tempX) {
                                for(tempZ = minZ; tempZ <= maxZ; ++tempZ) {
                                    if (Math.pow((double)tempX, 2.0D) + Math.pow((double)(tempY / 2), 2.0D) + Math.pow((double)tempZ, 2.0D) < Math.pow((double)radius, 2.0D)) {
                                        blocks.put(x + tempX, y + tempY, z + tempZ, EnumCubeType.AIR);
                                    }
                                }
                            }
                        }
                    }
                } else {
                    for(tempY = radius; tempY >= minY; --tempY) {
                        for(tempX = minX; tempX <= maxX; ++tempX) {
                            for(tempZ = minZ; tempZ <= maxZ; ++tempZ) {
                                if (Math.pow((double)tempX, 2.0D) + Math.pow((double)tempY, 2.0D) + Math.pow((double)tempZ, 2.0D) < Math.pow((double)radius, 2.0D) && (y + tempY >= 30 || y + tempY >= 12 && Math.pow((double)(x + tempX - ((Point)sphereCenter.get(0)).x), 2.0D) + Math.pow((double)(z + tempZ - ((Point)sphereCenter.get(0)).z), 2.0D) + Math.pow((double)(y + tempY - ((Point)sphereCenter.get(0)).z), 2.0D) > Math.pow((double)(((Point)sphereCenter.get(0)).radius / 2), 2.0D))) {
                                    blocks.put(x + tempX, y + tempY, z + tempZ, EnumCubeType.AIR);
                                }
                            }
                        }
                    }
                }
            }

            return blocks;
        }
    }

    @Override
    public void generateBlockType(Random random, Table3d blocks, int waterLevel) {
        Iterator var4 = blocks.descendingKeySet().iterator();

        while(var4.hasNext()) {
            Integer y = (Integer)var4.next();
            Iterator var6 = blocks.rowKeySet(y).iterator();

            label143:
            while(var6.hasNext()) {
                Integer x = (Integer)var6.next();
                Iterator var8 = blocks.columnKeySet(y).iterator();

                while(true) {
                    while(true) {
                        Integer z;
                        do {
                            if (!var8.hasNext()) {
                                continue label143;
                            }

                            z = (Integer)var8.next();
                        } while(!blocks.containsKey(x, y, z));

                        if (!blocks.containsKey(x, y + 1, z) && blocks.containsKey(x + 1, y - 1, z) && blocks.containsKey(x - 1, y - 1, z) && blocks.containsKey(x, y - 1, z + 1) && blocks.containsKey(x, y - 1, z - 1)) {
                            blocks.put(x, y, z, EnumCubeType.ROOF);
                        } else if (blocks.containsKey(x + 1, y, z) && blocks.containsKey(x - 1, y, z) && blocks.containsKey(x, y, z + 1) && blocks.containsKey(x, y, z - 1)) {
                            if (!blocks.containsKey(x, y - 1, z)) {
                                if (y < waterLevel) {
                                    if (random.nextInt(15) == 0 && !blocks.containsKey(x, y - 1, z) && blocks.get(x, y + 1, z).equals(EnumCubeType.WATER)) {
                                        blocks.put(x, y, z, EnumCubeType.ORE);
                                    } else {
                                        blocks.put(x, y, z, EnumCubeType.UNDERGROUND);
                                    }
                                } else {
                                    blocks.put(x, y, z, EnumCubeType.GROUND);
                                }
                            } else if (y <= waterLevel) {
                                blocks.put(x, y, z, EnumCubeType.WATER);
                            }
                        } else if (blocks.containsKey(x, y + 1, z) && blocks.get(x, y + 1, z).equals(EnumCubeType.ROOF) && blocks.containsKey(x + 1, y - 1, z) && blocks.containsKey(x - 1, y - 1, z) && blocks.containsKey(x, y - 1, z + 1) && blocks.containsKey(x, y - 1, z - 1)) {
                            blocks.put(x, y, z, EnumCubeType.ROOF);
                        } else if (blocks.containsKey(x, y + 1, z) && blocks.get(x, y + 1, z).equals(EnumCubeType.AIR)) {
                            if (y < waterLevel) {
                                if (random.nextInt(15) == 0 && !blocks.containsKey(x, y - 1, z) && blocks.get(x, y + 1, z).equals(EnumCubeType.WATER)) {
                                    blocks.put(x, y, z, EnumCubeType.ORE);
                                } else {
                                    blocks.put(x, y, z, EnumCubeType.UNDERGROUND);
                                }
                            } else {
                                blocks.put(x, y, z, EnumCubeType.GROUND);
                            }
                        } else if (!blocks.containsKey(x, y + 1, z) || !blocks.get(x, y + 1, z).equals(EnumCubeType.GROUND) && !blocks.get(x, y + 1, z).equals(EnumCubeType.UNDERGROUND) || blocks.containsKey(x, y + 3, z) && blocks.get(x, y + 2, z).equals(EnumCubeType.UNDERGROUND) && blocks.get(x, y + 2, z).equals(EnumCubeType.GROUND)) {
                            if (y >= 15 && y <= 45 && random.nextInt((y - 15) / 5 + 4) == 0) {
                                blocks.put(x, y, z, EnumCubeType.ORE);
                            } else {
                                blocks.put(x, y, z, EnumCubeType.WALL);
                            }
                        } else if (random.nextInt(15) == 0 && !blocks.containsKey(x, y - 1, z) && blocks.get(x, y + 1, z).equals(EnumCubeType.WATER)) {
                            blocks.put(x, y, z, EnumCubeType.ORE);
                        } else {
                            blocks.put(x, y, z, EnumCubeType.UNDERGROUND);
                        }
                    }
                }
            }
        }

    }
}
