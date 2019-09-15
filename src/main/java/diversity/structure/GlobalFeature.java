// 
// Decompiled by Procyon v0.5.36
// 

package diversity.structure;

import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.init.Blocks;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import java.util.Random;
import net.minecraft.world.gen.structure.StructureComponent;

public abstract class GlobalFeature extends StructureComponent
{
    protected int scatteredFeatureSizeX;
    protected int scatteredFeatureSizeY;
    protected int scatteredFeatureSizeZ;
    protected int field_74936_d;
    
    public GlobalFeature() {
        this.field_74936_d = -1;
    }
    
    public GlobalFeature(final Random random, final int coordX, final int coordZ, final int sizeX, final int sizeY, final int sizeZ) {
        super(0);
        this.field_74936_d = -1;
        this.scatteredFeatureSizeX = sizeX;
        this.scatteredFeatureSizeY = sizeY;
        this.scatteredFeatureSizeZ = sizeZ;
        switch (this.coordBaseMode = random.nextInt(4)) {
            case 0:
            case 2: {
                this.boundingBox = new StructureBoundingBox(coordX, 64, coordZ, coordX + sizeX - 1, 64 + sizeY - 1, coordZ + sizeZ - 1);
                break;
            }
            default: {
                this.boundingBox = new StructureBoundingBox(coordX, 64, coordZ, coordX + sizeZ - 1, 64 + sizeY - 1, coordZ + sizeX - 1);
                break;
            }
        }
    }
    
    @Override
    protected void func_143012_a(final NBTTagCompound p_143012_1_) {
        p_143012_1_.setInteger("Width", this.scatteredFeatureSizeX);
        p_143012_1_.setInteger("Height", this.scatteredFeatureSizeY);
        p_143012_1_.setInteger("Depth", this.scatteredFeatureSizeZ);
        p_143012_1_.setInteger("HPos", this.field_74936_d);
    }
    
    @Override
    protected void func_143011_b(final NBTTagCompound p_143011_1_) {
        this.scatteredFeatureSizeX = p_143011_1_.getInteger("Width");
        this.scatteredFeatureSizeY = p_143011_1_.getInteger("Height");
        this.scatteredFeatureSizeZ = p_143011_1_.getInteger("Depth");
        this.field_74936_d = p_143011_1_.getInteger("HPos");
    }
    
    protected boolean func_74935_a(final World p_74935_1_, final StructureBoundingBox p_74935_2_, final int p_74935_3_) {
        if (this.field_74936_d >= 0) {
            return true;
        }
        int j = 0;
        int k = 0;
        for (int l = this.boundingBox.minZ; l <= this.boundingBox.maxZ; ++l) {
            for (int i1 = this.boundingBox.minX; i1 <= this.boundingBox.maxX; ++i1) {
                if (p_74935_2_.isVecInside(i1, 64, l)) {
                    j += Math.max(p_74935_1_.getTopSolidOrLiquidBlock(i1, l), p_74935_1_.provider.getAverageGroundLevel());
                    ++k;
                }
            }
        }
        if (k == 0) {
            return false;
        }
        this.field_74936_d = j / k;
        this.boundingBox.offset(0, this.field_74936_d - this.boundingBox.minY + p_74935_3_, 0);
        return true;
    }
    
    @Override
    public boolean addComponentParts(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
        this.build(world, random, structureBoundingBox);
        return true;
    }
    
    protected abstract boolean build(final World p0, final Random p1, final StructureBoundingBox p2);
    
    protected void spawnEntity(final World world, final StructureBoundingBox structureBoundingBox, final int spawnX, final int spawnY, final int spawnZ, final int choice) {
        final int x = this.getXWithOffset(spawnX, spawnZ);
        final int y = this.getYWithOffset(spawnY);
        final int z = this.getZWithOffset(spawnX, spawnZ);
        if (!structureBoundingBox.isVecInside(x, y, z)) {
            return;
        }
        final EntityLiving entity = this.getNewEntity(world, choice);
        entity.setLocationAndAngles(x + 0.5, (double)y, z + 0.5, 0.0f, 0.0f);
        world.spawnEntityInWorld((Entity)entity);
    }
    
    protected abstract EntityLiving getNewEntity(final World p0, final int p1);
    
    protected int getAverageGroundLevel(final World p_74889_1_, final StructureBoundingBox p_74889_2_) {
        int i = 0;
        int j = 0;
        for (int k = this.boundingBox.minZ; k <= this.boundingBox.maxZ; ++k) {
            for (int l = this.boundingBox.minX; l <= this.boundingBox.maxX; ++l) {
                if (p_74889_2_.isVecInside(l, 64, k)) {
                    i += Math.max(p_74889_1_.getTopSolidOrLiquidBlock(l, k), p_74889_1_.provider.getAverageGroundLevel());
                    ++j;
                }
            }
        }
        if (j == 0) {
            return -1;
        }
        return i / j;
    }
    
    protected boolean generateStructureTrappedChestContents(final World p_74879_1_, final StructureBoundingBox p_74879_2_, final Random p_74879_3_, final int p_74879_4_, final int p_74879_5_, final int p_74879_6_, final WeightedRandomChestContent[] p_74879_7_, final int p_74879_8_) {
        final int i1 = this.getXWithOffset(p_74879_4_, p_74879_6_);
        final int j1 = this.getYWithOffset(p_74879_5_);
        final int k1 = this.getZWithOffset(p_74879_4_, p_74879_6_);
        if (p_74879_2_.isVecInside(i1, j1, k1) && p_74879_1_.getBlock(i1, j1, k1) != Blocks.trapped_chest) {
            p_74879_1_.setBlock(i1, j1, k1, Blocks.trapped_chest, 0, 2);
            final TileEntityChest tileentitychest = (TileEntityChest)p_74879_1_.getTileEntity(i1, j1, k1);
            if (tileentitychest != null) {
                WeightedRandomChestContent.generateChestContents(p_74879_3_, p_74879_7_, (IInventory)tileentitychest, p_74879_8_);
            }
            return true;
        }
        return false;
    }
}
