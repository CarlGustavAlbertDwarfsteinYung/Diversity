//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package diversity.structure;

import diversity.cavegen.ICaveGenerator;
import diversity.cavegen.YetiDenGenerator;
import diversity.entity.EntityYeti;
import diversity.utils.EnumCubeType;
import diversity.utils.Point;
import diversity.utils.Table3d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.TreeMap;
import net.minecraft.entity.EntityLiving;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntitySkull;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;

public class YetiDen extends GlobalFeature {
    public Table3d blocks = new Table3d();
    public Point startPoint;
    private Integer caveH = -100;
    public ICaveGenerator caveGen;
    public List<Point> sphereCenter = new ArrayList();

    public YetiDen() {
    }

    public YetiDen(Random random, int coordX, int coordZ) {
        super(random, coordX, coordZ, 7, 5, 9);
        this.caveGen = new YetiDenGenerator(3, 6, 4);
        this.sphereCenter = this.caveGen.getControlPoints(random, coordX, 55, coordZ);
        this.blocks = this.caveGen.getCavePoints(this.sphereCenter, random);
        this.caveGen.generateBlockType(random, this.blocks, 0);
        this.blocks.mutateTable();
        this.startPoint = (Point)this.sphereCenter.get(0);
        int maxX = this.startPoint.x;
        int minX = this.startPoint.x;
        int maxY = this.startPoint.y;
        int minY = this.startPoint.y;
        int maxZ = this.startPoint.z;
        int minZ = this.startPoint.z;
        Iterator var10 = this.blocks.descendingKeySet().iterator();

        while(var10.hasNext()) {
            Integer y = (Integer)var10.next();
            Iterator var12 = this.blocks.rowKeySet(y).iterator();

            while(var12.hasNext()) {
                Integer x = (Integer)var12.next();
                Iterator var14 = this.blocks.columnKeySet(y).iterator();

                while(var14.hasNext()) {
                    Integer z = (Integer)var14.next();
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
    protected void func_143012_a(NBTTagCompound p_143012_1_) {
        super.func_143012_a(p_143012_1_);
        p_143012_1_.setInteger("caveH", this.caveH);
        p_143012_1_.setInteger("startX", this.startPoint.x);
        p_143012_1_.setInteger("startY", this.startPoint.y);
        p_143012_1_.setInteger("startZ", this.startPoint.z);
    }

    @Override
    protected void func_143011_b(NBTTagCompound p_143011_1_) {
        super.func_143011_b(p_143011_1_);
        this.caveH = p_143011_1_.getInteger("caveH");
        this.startPoint = new Point();
        this.startPoint.x = p_143011_1_.getInteger("startX");
        this.startPoint.y = p_143011_1_.getInteger("startY");
        this.startPoint.z = p_143011_1_.getInteger("startZ");
        Random rand = new Random();
        this.caveGen = new YetiDenGenerator(3, 6, 4);
        this.sphereCenter = this.caveGen.getControlPoints(rand, this.boundingBox.minX, 55, this.boundingBox.minZ);
        this.blocks = this.caveGen.getCavePoints(this.sphereCenter, rand);
        this.caveGen.generateBlockType(rand, this.blocks, 0);
        this.blocks.mutateTable();
    }

    @Override
    protected boolean build(World world, Random random, StructureBoundingBox structureBoundingBox) {
        if (!this.func_74935_a(world, structureBoundingBox, 0)) {
            return false;
        } else {
            if (this.caveH == -100) {
                for(int index = 0; index < this.sphereCenter.size(); ++index) {
                    Point center = (Point)this.sphereCenter.get(index);
                    if (structureBoundingBox.intersectsWith(center.x, center.z, center.x, center.z)) {
                        this.caveH = world.getTopSolidOrLiquidBlock(center.x, center.z) - center.y - (this.sphereCenter.size() - 1 - index) * 2;
                        break;
                    }
                }
            }

            if (this.caveH != -100) {
                this.generateCaveBlocks(world, random, structureBoundingBox);
                if (structureBoundingBox.intersectsWith(this.startPoint.x, this.startPoint.z, this.startPoint.x, this.startPoint.z)) {
                    EntityLiving entity = this.getNewEntity(world, 0);
                    entity.setLocationAndAngles((double)this.startPoint.x + 0.5D, (double)this.startPoint.y + (double)this.caveH, (double)this.startPoint.z + 0.5D, 0.0F, 0.0F);
                    world.spawnEntityInWorld(entity);
                }
            }

            return true;
        }
    }

    @Override
    protected EntityLiving getNewEntity(World world, int choice) {
        return new EntityYeti(world);
    }

    private void generateCaveBlocks(World world, Random random, StructureBoundingBox structureBoundingBox) {
        Iterator var4 = this.blocks.mutation.rowKeySet().iterator();

        Integer x;
        Iterator var6;
        Integer z;
        Iterator var8;
        Integer y;
        label115:
        while(var4.hasNext()) {
            x = (Integer)var4.next();
            var6 = this.blocks.mutation.row(x).keySet().iterator();

            label113:
            while(true) {
                do {
                    if (!var6.hasNext()) {
                        continue label115;
                    }

                    z = (Integer)var6.next();
                } while(!structureBoundingBox.isVecInside(x, 20, z));

                var8 = ((TreeMap)this.blocks.mutation.get(x, z)).keySet().iterator();

                while(true) {
                    while(true) {
                        do {
                            do {
                                do {
                                    if (!var8.hasNext()) {
                                        continue label113;
                                    }

                                    y = (Integer)var8.next();
                                } while(!this.blocks.containsKey(x, y, z));
                            } while(world.getTopSolidOrLiquidBlock(x, z) < y + this.caveH);
                        } while(!this.blocks.get(x, y, z).equals(EnumCubeType.AIR));

                        if (this.blocks.containsKey(x, y - 1, z) && this.blocks.get(x, y - 1, z).equals(EnumCubeType.GROUND) && world.getTopSolidOrLiquidBlock(x, z) - (y + this.caveH) > 15 && random.nextInt(6) == 0) {
                            world.setBlock(x, y + this.caveH, z, Blocks.skull, 1, 0);
                            TileEntitySkull tileEntity = (TileEntitySkull)Blocks.skull.createTileEntity(world, 0);
                            tileEntity.func_145903_a(random.nextInt(8));
                            world.setTileEntity(x, y + this.caveH, z, tileEntity);
                        } else {
                            world.setBlock(x, y + this.caveH, z, Blocks.air, 0, 1);
                        }
                    }
                }
            }
        }

        var4 = this.blocks.mutation.rowKeySet().iterator();

        label77:
        while(var4.hasNext()) {
            x = (Integer)var4.next();
            var6 = this.blocks.mutation.row(x).keySet().iterator();

            while(true) {
                do {
                    if (!var6.hasNext()) {
                        continue label77;
                    }

                    z = (Integer)var6.next();
                } while(!structureBoundingBox.isVecInside(x, 20, z));

                var8 = ((TreeMap)this.blocks.mutation.get(x, z)).keySet().iterator();

                while(var8.hasNext()) {
                    y = (Integer)var8.next();
                    if (this.blocks.containsKey(x, y, z)) {
                        if (world.getTopSolidOrLiquidBlock(x, z) > y + this.caveH) {
                            if (this.blocks.get(x, y, z).equals(EnumCubeType.ROOF)) {
                                if (world.getTopSolidOrLiquidBlock(x, z) - (y + this.caveH) > 1) {
                                    world.setBlock(x, y + this.caveH, z, Blocks.packed_ice);
                                } else {
                                    world.setBlock(x, y + this.caveH, z, Blocks.snow);
                                }
                            } else if (this.blocks.get(x, y, z).equals(EnumCubeType.WALL)) {
                                if (world.getTopSolidOrLiquidBlock(x, z) - (y + this.caveH) > 3) {
                                    world.setBlock(x, y + this.caveH, z, Blocks.packed_ice);
                                } else {
                                    world.setBlock(x, y + this.caveH, z, Blocks.snow);
                                }
                            } else if (this.blocks.get(x, y, z).equals(EnumCubeType.GROUND)) {
                                world.setBlock(x, y + this.caveH, z, Blocks.snow);
                            } else if (this.blocks.get(x, y, z).equals(EnumCubeType.UNDERGROUND)) {
                                if (world.getTopSolidOrLiquidBlock(x, z) - (y + this.caveH) > 1) {
                                    world.setBlock(x, y + this.caveH, z, Blocks.packed_ice);
                                } else {
                                    world.setBlock(x, y + this.caveH, z, Blocks.snow);
                                }
                            }
                        }

                        this.blocks.remove(x, y, z);
                    }
                }
            }
        }

    }
}
