//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package diversity.structure;

import diversity.cavegen.DwarvenCaveGenerator;
import diversity.cavegen.ICaveGenerator;
import diversity.utils.EnumCubeType;
import diversity.utils.Point;
import diversity.utils.Table3d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.TreeMap;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;

public class DwarvenCave extends GlobalFeature {
    public Table3d blocks = new Table3d();
    public Point startPoint;
    public List<Point> scaffoldingPoint = new ArrayList();

    public DwarvenCave() {
    }

    public DwarvenCave(Random random, int coordX, int coordZ) {
        super(random, coordX, coordZ, 7, 5, 9);
        ICaveGenerator caveGen = new DwarvenCaveGenerator(7, 20, 4);
        List<Point> sphereCenter = caveGen.getControlPoints(random, coordX, 40, coordZ);

        int maxX;
        for(maxX = 0; maxX < sphereCenter.size(); maxX += 2) {
            if (((Point)sphereCenter.get(maxX)).radius == 6 && random.nextInt(10) == 0) {
                this.scaffoldingPoint.add(sphereCenter.get(maxX));
            }
        }

        this.blocks = caveGen.getCavePoints(sphereCenter, random);
        caveGen.generateBlockType(random, this.blocks, 15);
        this.blocks.mutateTable();
        this.startPoint = (Point)sphereCenter.get(0);
        maxX = this.startPoint.x;
        int minX = this.startPoint.x;
        int maxY = this.startPoint.y;
        int minY = this.startPoint.y;
        int maxZ = this.startPoint.z;
        int minZ = this.startPoint.z;
        Iterator var12 = this.blocks.descendingKeySet().iterator();

        while(var12.hasNext()) {
            Integer y = (Integer)var12.next();
            Iterator var14 = this.blocks.rowKeySet(y).iterator();

            while(var14.hasNext()) {
                Integer x = (Integer)var14.next();
                Iterator var16 = this.blocks.columnKeySet(y).iterator();

                while(var16.hasNext()) {
                    Integer z = (Integer)var16.next();
                    if (x < minX) {
                        minX = x;
                    }

                    if (x > maxX) {
                        maxX = x;
                    }

                    if (y < minY) {
                        minY = y;
                    }

                    if (y > maxY) {
                        maxY = y;
                    }

                    if (z < minZ) {
                        minZ = z;
                    }

                    if (z > maxZ) {
                        maxZ = z;
                    }
                }
            }
        }

        this.boundingBox = new StructureBoundingBox(minX, minY, minZ, maxX, maxY, maxZ);
    }

    @Override
    protected boolean build(World world, Random random, StructureBoundingBox structureBoundingBox) {
        if (!this.func_74935_a(world, structureBoundingBox, 0)) {
            return false;
        } else {
            this.generateCaveBlocks(world, random, structureBoundingBox);
            return true;
        }
    }

    @Override
    protected EntityLiving getNewEntity(World world, int choice) {
        return new EntityWitch(world);
    }

    private void generateCaveBlocks(World world, Random random, StructureBoundingBox structureBoundingBox) {
        Iterator var4 = this.blocks.mutation.rowKeySet().iterator();

        Integer x;
        Iterator var6;
        Integer z;
        Iterator var8;
        Integer y;
        label89:
        while(var4.hasNext()) {
            x = (Integer)var4.next();
            var6 = this.blocks.mutation.row(x).keySet().iterator();

            while(true) {
                do {
                    if (!var6.hasNext()) {
                        continue label89;
                    }

                    z = (Integer)var6.next();
                } while(!structureBoundingBox.isVecInside(x, 20, z));

                var8 = ((TreeMap)this.blocks.mutation.get(x, z)).keySet().iterator();

                while(var8.hasNext()) {
                    y = (Integer)var8.next();
                    if (this.blocks.containsKey(x, y, z)) {
                        if (this.blocks.get(x, y, z).equals(EnumCubeType.AIR)) {
                            world.setBlock(x, y, z, Blocks.air);
                        } else if (this.blocks.get(x, y, z).equals(EnumCubeType.WATER)) {
                            world.setBlock(x, y, z, Blocks.water);
                        }
                    }
                }
            }
        }

        var4 = this.blocks.mutation.rowKeySet().iterator();

        label71:
        while(var4.hasNext()) {
            x = (Integer)var4.next();
            var6 = this.blocks.mutation.row(x).keySet().iterator();

            while(true) {
                do {
                    if (!var6.hasNext()) {
                        continue label71;
                    }

                    z = (Integer)var6.next();
                } while(!structureBoundingBox.isVecInside(x, 20, z));

                var8 = ((TreeMap)this.blocks.mutation.get(x, z)).keySet().iterator();

                while(var8.hasNext()) {
                    y = (Integer)var8.next();
                    if (this.blocks.containsKey(x, y, z)) {
                        if (this.blocks.get(x, y, z).equals(EnumCubeType.ROOF)) {
                            world.setBlock(x, y, z, Blocks.stone);
                        } else if (this.blocks.get(x, y, z).equals(EnumCubeType.WALL)) {
                            world.setBlock(x, y, z, Blocks.stone);
                        } else if (this.blocks.get(x, y, z).equals(EnumCubeType.GROUND)) {
                            world.setBlock(x, y, z, Blocks.stone);
                        } else if (this.blocks.get(x, y, z).equals(EnumCubeType.UNDERGROUND)) {
                            world.setBlock(x, y, z, Blocks.stone);
                        } else if (this.blocks.get(x, y, z).equals(EnumCubeType.ORE)) {
                            if (y < 30) {
                                world.setBlock(x, y, z, Blocks.gold_ore);
                            } else {
                                world.setBlock(x, y, z, Blocks.iron_ore);
                            }
                        }

                        this.blocks.remove(x, y, z);
                    }
                }
            }
        }

    }
}
