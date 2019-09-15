//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package diversity.structure;

import diversity.cavegen.ICaveGenerator;
import diversity.cavegen.JungleValleyGenerator;
import diversity.suppliers.EnumBlock;
import diversity.utils.EnumCubeType;
import diversity.utils.Point;
import diversity.utils.Table3d;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.TreeMap;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;

public class JungleValley extends GlobalFeature {
    public Table3d blocks = new Table3d();
    public Point startPoint;

    public JungleValley() {
    }

    public JungleValley(Random random, int coordX, int coordZ) {
        super(random, coordX, coordZ, 7, 5, 9);
        ICaveGenerator caveGen = new JungleValleyGenerator(7, 18, 4);
        List<Point> sphereCenter = caveGen.getControlPoints(random, coordX, 68, coordZ);
        this.blocks = caveGen.getCavePoints(sphereCenter, random);
        caveGen.generateBlockType(random, this.blocks, 40);
        this.blocks.mutateTable();
        this.startPoint = (Point)sphereCenter.get(0);
        int maxX = this.startPoint.x;
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
        label83:
        while(var4.hasNext()) {
            x = (Integer)var4.next();
            var6 = this.blocks.mutation.row(x).keySet().iterator();

            while(true) {
                do {
                    if (!var6.hasNext()) {
                        continue label83;
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
                            world.setBlock(x, y, z, EnumBlock.poison_water.block);
                        }
                    }
                }
            }
        }

        var4 = this.blocks.mutation.rowKeySet().iterator();

        label65:
        while(var4.hasNext()) {
            x = (Integer)var4.next();
            var6 = this.blocks.mutation.row(x).keySet().iterator();

            while(true) {
                do {
                    if (!var6.hasNext()) {
                        continue label65;
                    }

                    z = (Integer)var6.next();
                } while(!structureBoundingBox.isVecInside(x, 20, z));

                var8 = ((TreeMap)this.blocks.mutation.get(x, z)).keySet().iterator();

                while(var8.hasNext()) {
                    y = (Integer)var8.next();
                    if (this.blocks.containsKey(x, y, z)) {
                        if (this.blocks.get(x, y, z).equals(EnumCubeType.ROOF)) {
                            this.generateRoof(world, random, x, y, z);
                        } else if (this.blocks.get(x, y, z).equals(EnumCubeType.WALL)) {
                            this.generateWall(world, random, x, y, z);
                        } else if (this.blocks.get(x, y, z).equals(EnumCubeType.GROUND)) {
                            world.setBlock(x, y, z, Blocks.grass);
                        } else if (this.blocks.get(x, y, z).equals(EnumCubeType.UNDERGROUND)) {
                            this.generateUnderGround(world, random, x, y, z);
                        }

                        this.blocks.remove(x, y, z);
                    }
                }
            }
        }

    }

    private void generateRoof(World world, Random random, int x, int y, int z) {
        if (y > 60 && !world.getBlock(x, y + 2, z).getMaterial().equals(Material.water) && world.isAirBlock(x, y + 4, z)) {
            boolean canContinue = false;

            for(int tempY = y; tempY < y + 10; ++tempY) {
                world.setBlockToAir(x, tempY, z);
            }

            if (random.nextInt(5) == 0) {
            }
        }

    }

    private void generateWall(World world, Random random, int x, int y, int z) {
        if (random.nextInt(10) == 0 && y < 60) {
            world.setBlock(x, y, z, Blocks.vine);

            while(random.nextBoolean() || random.nextBoolean()) {
                --y;
                if (!this.blocks.containsKey(x, y, z) || !this.blocks.get(x, y, z).equals(EnumCubeType.AIR)) {
                    return;
                }

                world.setBlock(x, y, z, Blocks.vine);
            }
        } else {
            world.setBlockToAir(x, y, z);
        }

    }

    private void generateUnderGround(World world, Random random, int x, int y, int z) {
        if (this.blocks.get(x, y + 1, z).equals(EnumCubeType.WATER)) {
            if (random.nextInt(30) == 0) {
                world.setBlock(x, y, z, Blocks.gold_ore);
            } else {
                world.setBlock(x, y, z, Blocks.stone);
            }
        } else {
            world.setBlock(x, y, z, Blocks.dirt);
        }

    }
}
