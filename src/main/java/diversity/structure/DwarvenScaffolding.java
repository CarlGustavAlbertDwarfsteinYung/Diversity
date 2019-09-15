// 
// Decompiled by Procyon v0.5.36
// 

package diversity.structure;

import diversity.entity.EntityTzitzimime;
import net.minecraft.entity.EntityLiving;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import java.util.Random;

public class DwarvenScaffolding extends GlobalFeature
{
    private int randomX;
    private int randomZ;
    
    public DwarvenScaffolding() {
    }
    
    public DwarvenScaffolding(final Random random, final int coordX, final int coordZ) {
        super(random, coordX, coordZ, 6, 15, 6);
        switch (this.coordBaseMode) {
            case 0:
            case 2: {
                this.boundingBox = new StructureBoundingBox(coordX - 3, 26, coordZ - 3, coordX + this.scatteredFeatureSizeX - 1 - 3, 26 + this.scatteredFeatureSizeY - 1, coordZ + this.scatteredFeatureSizeZ - 1 - 3);
                break;
            }
            default: {
                this.boundingBox = new StructureBoundingBox(coordX - 3, 26, coordZ - 3, coordX + this.scatteredFeatureSizeZ - 1 - 3, 26 + this.scatteredFeatureSizeY - 1, coordZ + this.scatteredFeatureSizeX - 1 - 3);
                break;
            }
        }
        this.randomX = random.nextInt(3);
        this.randomZ = random.nextInt(3);
    }
    
    @Override
    protected void func_143012_a(final NBTTagCompound p_143012_1_) {
        super.func_143012_a(p_143012_1_);
        p_143012_1_.setInteger("randX", this.randomX);
        p_143012_1_.setInteger("randZ", this.randomZ);
    }
    
    @Override
    protected void func_143011_b(final NBTTagCompound p_143011_1_) {
        super.func_143011_b(p_143011_1_);
        this.randomX = p_143011_1_.getInteger("randX");
        this.randomZ = p_143011_1_.getInteger("randZ");
    }
    
    @Override
    public boolean build(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
        this.func_151554_b(world, Blocks.fence, 0, 0, 5, 0, structureBoundingBox);
        this.func_151554_b(world, Blocks.fence, 0, 4, 5, 0, structureBoundingBox);
        this.func_151554_b(world, Blocks.fence, 0, 0, 5, 4, structureBoundingBox);
        this.func_151554_b(world, Blocks.fence, 0, 4, 5, 4, structureBoundingBox);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 0, 6, 0, 4, 6, 4, (Block)Blocks.wooden_slab, 0, (Block)Blocks.wooden_slab, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, this.randomX, 11, this.randomZ, 2 + this.randomX, 11, 2 + this.randomZ, (Block)Blocks.wooden_slab, 0, (Block)Blocks.wooden_slab, 0, false);
        this.func_151554_b(world, Blocks.fence, 0, this.randomX, 10, this.randomZ, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.planks, 0, this.randomX, 6, this.randomZ, structureBoundingBox);
        this.func_151554_b(world, Blocks.fence, 0, 2 + this.randomX, 10, this.randomZ, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.planks, 0, 2 + this.randomX, 6, this.randomZ, structureBoundingBox);
        this.func_151554_b(world, Blocks.fence, 0, this.randomX, 10, 2 + this.randomZ, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.planks, 0, this.randomX, 6, 2 + this.randomZ, structureBoundingBox);
        this.func_151554_b(world, Blocks.fence, 0, 2 + this.randomX, 10, 2 + this.randomZ, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.planks, 0, 2 + this.randomX, 6, 2 + this.randomZ, structureBoundingBox);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 1 + this.randomX, 5, this.randomZ, 1 + this.randomX, 12, this.randomZ, Blocks.planks, 0, Blocks.planks, 0, false);
        this.func_151554_b(world, Blocks.planks, 0, 1 + this.randomX, 4, this.randomZ, structureBoundingBox);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 1 + this.randomX, 5, 1 + this.randomZ, 1 + this.randomX, 12, 1 + this.randomZ, Blocks.ladder, this.getMetadataWithOffset(Blocks.ladder, 2), Blocks.ladder, this.getMetadataWithOffset(Blocks.ladder, 2), false);
        this.func_151554_b(world, Blocks.ladder, this.getMetadataWithOffset(Blocks.ladder, 2), 1 + this.randomX, 4, 1 + this.randomZ, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 1 + this.randomX, 13, this.randomZ, structureBoundingBox);
        return true;
    }
    
    @Override
    protected EntityLiving getNewEntity(final World world, final int choice) {
        return (EntityLiving)new EntityTzitzimime(world);
    }
}
