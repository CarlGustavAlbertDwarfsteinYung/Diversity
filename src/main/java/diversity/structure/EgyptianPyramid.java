// 
// Decompiled by Procyon v0.5.36
// 

package diversity.structure;

import diversity.entity.EntityMummy;
import net.minecraft.entity.EntityLiving;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraft.util.Direction;
import diversity.utils.DirectionTools;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.World;
import net.minecraft.nbt.NBTTagCompound;
import java.util.Random;

public class EgyptianPyramid extends GlobalFeature
{
    private boolean[] isChestPiece;
    
    public EgyptianPyramid() {
        this.isChestPiece = new boolean[4];
    }
    
    public EgyptianPyramid(final Random random, final int coordX, final int coordZ) {
        super(random, coordX, coordZ, 21, 15, 21);
        (this.isChestPiece = new boolean[4])[0] = random.nextBoolean();
        this.isChestPiece[1] = random.nextBoolean();
        this.isChestPiece[2] = random.nextBoolean();
        this.isChestPiece[3] = random.nextBoolean();
    }
    
    @Override
    protected void func_143012_a(final NBTTagCompound p_143012_1_) {
        super.func_143012_a(p_143012_1_);
        p_143012_1_.setBoolean("M0", this.isChestPiece[0]);
        p_143012_1_.setBoolean("M1", this.isChestPiece[1]);
        p_143012_1_.setBoolean("M2", this.isChestPiece[2]);
        p_143012_1_.setBoolean("M3", this.isChestPiece[3]);
    }
    
    @Override
    protected void func_143011_b(final NBTTagCompound p_143011_1_) {
        super.func_143011_b(p_143011_1_);
        this.isChestPiece[0] = p_143011_1_.getBoolean("M0");
        this.isChestPiece[1] = p_143011_1_.getBoolean("M1");
        this.isChestPiece[2] = p_143011_1_.getBoolean("M2");
        this.isChestPiece[3] = p_143011_1_.getBoolean("M3");
    }
    
    @Override
    public boolean build(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
        this.fillWithBlocks(world, structureBoundingBox, 0, -4, 0, this.scatteredFeatureSizeX - 1, 0, this.scatteredFeatureSizeZ - 1, Blocks.sandstone, Blocks.sandstone, false);
        for (int i = 1; i <= 9; ++i) {
            this.fillWithBlocks(world, structureBoundingBox, i, i, i, this.scatteredFeatureSizeX - 1 - i, i, this.scatteredFeatureSizeZ - 1 - i, Blocks.sandstone, Blocks.sandstone, false);
            this.fillWithBlocks(world, structureBoundingBox, i + 1, i, i + 1, this.scatteredFeatureSizeX - 2 - i, i, this.scatteredFeatureSizeZ - 2 - i, Blocks.air, Blocks.air, false);
        }
        for (int i = 0; i < this.scatteredFeatureSizeX; ++i) {
            for (int j = 0; j < this.scatteredFeatureSizeZ; ++j) {
                final byte b0 = -5;
                this.func_151554_b(world, Blocks.sandstone, 0, i, (int)b0, j, structureBoundingBox);
            }
        }
        int i = this.getMetadataWithOffset(Blocks.sandstone_stairs, 3);
        int j = this.getMetadataWithOffset(Blocks.sandstone_stairs, 2);
        final int k1 = this.getMetadataWithOffset(Blocks.sandstone_stairs, 0);
        final int l = this.getMetadataWithOffset(Blocks.sandstone_stairs, 1);
        final byte b2 = 1;
        final byte b3 = 11;
        this.fillWithBlocks(world, structureBoundingBox, 0, 0, 0, 4, 9, 4, Blocks.sandstone, Blocks.air, false);
        this.fillWithBlocks(world, structureBoundingBox, 1, 10, 1, 3, 10, 3, Blocks.sandstone, Blocks.sandstone, false);
        this.placeBlockAtCurrentPosition(world, Blocks.sandstone_stairs, i, 2, 10, 0, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.sandstone_stairs, j, 2, 10, 4, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.sandstone_stairs, k1, 0, 10, 2, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.sandstone_stairs, l, 4, 10, 2, structureBoundingBox);
        this.fillWithBlocks(world, structureBoundingBox, this.scatteredFeatureSizeX - 5, 0, 0, this.scatteredFeatureSizeX - 1, 9, 4, Blocks.sandstone, Blocks.air, false);
        this.fillWithBlocks(world, structureBoundingBox, this.scatteredFeatureSizeX - 4, 10, 1, this.scatteredFeatureSizeX - 2, 10, 3, Blocks.sandstone, Blocks.sandstone, false);
        this.placeBlockAtCurrentPosition(world, Blocks.sandstone_stairs, i, this.scatteredFeatureSizeX - 3, 10, 0, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.sandstone_stairs, j, this.scatteredFeatureSizeX - 3, 10, 4, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.sandstone_stairs, k1, this.scatteredFeatureSizeX - 5, 10, 2, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.sandstone_stairs, l, this.scatteredFeatureSizeX - 1, 10, 2, structureBoundingBox);
        this.fillWithBlocks(world, structureBoundingBox, 8, 0, 0, 12, 4, 4, Blocks.sandstone, Blocks.air, false);
        this.fillWithBlocks(world, structureBoundingBox, 9, 1, 0, 11, 3, 4, Blocks.air, Blocks.air, false);
        this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 9, 1, 1, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 9, 2, 1, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 9, 3, 1, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 10, 3, 1, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 11, 3, 1, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 11, 2, 1, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 11, 1, 1, structureBoundingBox);
        this.fillWithBlocks(world, structureBoundingBox, 4, 1, 1, 8, 3, 3, Blocks.sandstone, Blocks.air, false);
        this.fillWithBlocks(world, structureBoundingBox, 4, 1, 2, 8, 2, 2, Blocks.air, Blocks.air, false);
        this.fillWithBlocks(world, structureBoundingBox, 12, 1, 1, 16, 3, 3, Blocks.sandstone, Blocks.air, false);
        this.fillWithBlocks(world, structureBoundingBox, 12, 1, 2, 16, 2, 2, Blocks.air, Blocks.air, false);
        this.fillWithBlocks(world, structureBoundingBox, 5, 4, 5, this.scatteredFeatureSizeX - 6, 4, this.scatteredFeatureSizeZ - 6, Blocks.sandstone, Blocks.sandstone, false);
        this.fillWithBlocks(world, structureBoundingBox, 9, 4, 9, 11, 4, 11, Blocks.air, Blocks.air, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 8, 1, 8, 8, 3, 8, Blocks.sandstone, 2, Blocks.sandstone, 2, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 12, 1, 8, 12, 3, 8, Blocks.sandstone, 2, Blocks.sandstone, 2, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 8, 1, 12, 8, 3, 12, Blocks.sandstone, 2, Blocks.sandstone, 2, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 12, 1, 12, 12, 3, 12, Blocks.sandstone, 2, Blocks.sandstone, 2, false);
        this.fillWithBlocks(world, structureBoundingBox, 1, 1, 5, 4, 4, 11, Blocks.sandstone, Blocks.sandstone, false);
        this.fillWithBlocks(world, structureBoundingBox, this.scatteredFeatureSizeX - 5, 1, 5, this.scatteredFeatureSizeX - 2, 4, 11, Blocks.sandstone, Blocks.sandstone, false);
        this.fillWithBlocks(world, structureBoundingBox, 6, 7, 9, 6, 7, 11, Blocks.sandstone, Blocks.sandstone, false);
        this.fillWithBlocks(world, structureBoundingBox, this.scatteredFeatureSizeX - 7, 7, 9, this.scatteredFeatureSizeX - 7, 7, 11, Blocks.sandstone, Blocks.sandstone, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 5, 5, 9, 5, 7, 11, Blocks.sandstone, 2, Blocks.sandstone, 2, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, this.scatteredFeatureSizeX - 6, 5, 9, this.scatteredFeatureSizeX - 6, 7, 11, Blocks.sandstone, 2, Blocks.sandstone, 2, false);
        this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 5, 5, 10, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 5, 6, 10, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 6, 6, 10, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.air, 0, this.scatteredFeatureSizeX - 6, 5, 10, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.air, 0, this.scatteredFeatureSizeX - 6, 6, 10, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.air, 0, this.scatteredFeatureSizeX - 7, 6, 10, structureBoundingBox);
        this.fillWithBlocks(world, structureBoundingBox, 2, 4, 4, 2, 6, 4, Blocks.air, Blocks.air, false);
        this.fillWithBlocks(world, structureBoundingBox, this.scatteredFeatureSizeX - 3, 4, 4, this.scatteredFeatureSizeX - 3, 6, 4, Blocks.air, Blocks.air, false);
        this.placeBlockAtCurrentPosition(world, Blocks.sandstone_stairs, i, 2, 4, 5, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.sandstone_stairs, i, 2, 3, 4, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.sandstone_stairs, i, this.scatteredFeatureSizeX - 3, 4, 5, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.sandstone_stairs, i, this.scatteredFeatureSizeX - 3, 3, 4, structureBoundingBox);
        this.fillWithBlocks(world, structureBoundingBox, 1, 1, 3, 2, 2, 3, Blocks.sandstone, Blocks.sandstone, false);
        this.fillWithBlocks(world, structureBoundingBox, this.scatteredFeatureSizeX - 3, 1, 3, this.scatteredFeatureSizeX - 2, 2, 3, Blocks.sandstone, Blocks.sandstone, false);
        this.placeBlockAtCurrentPosition(world, Blocks.sandstone_stairs, 0, 1, 1, 2, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.sandstone_stairs, 0, this.scatteredFeatureSizeX - 2, 1, 2, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 1, 1, 2, 2, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 1, this.scatteredFeatureSizeX - 2, 2, 2, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.sandstone_stairs, l, 2, 1, 2, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.sandstone_stairs, k1, this.scatteredFeatureSizeX - 3, 1, 2, structureBoundingBox);
        this.fillWithBlocks(world, structureBoundingBox, 4, 3, 5, 4, 3, 18, Blocks.sandstone, Blocks.sandstone, false);
        this.fillWithBlocks(world, structureBoundingBox, this.scatteredFeatureSizeX - 5, 3, 5, this.scatteredFeatureSizeX - 5, 3, 17, Blocks.sandstone, Blocks.sandstone, false);
        this.fillWithBlocks(world, structureBoundingBox, 3, 1, 5, 4, 2, 16, Blocks.air, Blocks.air, false);
        this.fillWithBlocks(world, structureBoundingBox, this.scatteredFeatureSizeX - 6, 1, 5, this.scatteredFeatureSizeX - 5, 2, 16, Blocks.air, Blocks.air, false);
        for (int m = 5; m <= 17; m += 2) {
            this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 4, 1, m, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 1, 4, 2, m, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, this.scatteredFeatureSizeX - 5, 1, m, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 1, this.scatteredFeatureSizeX - 5, 2, m, structureBoundingBox);
        }
        this.placeBlockAtCurrentPosition(world, Blocks.wool, (int)b2, 10, 0, 7, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.wool, (int)b2, 10, 0, 8, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.wool, (int)b2, 9, 0, 9, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.wool, (int)b2, 11, 0, 9, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.wool, (int)b2, 8, 0, 10, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.wool, (int)b2, 12, 0, 10, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.wool, (int)b2, 7, 0, 10, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.wool, (int)b2, 13, 0, 10, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.wool, (int)b2, 9, 0, 11, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.wool, (int)b2, 11, 0, 11, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.wool, (int)b2, 10, 0, 12, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.wool, (int)b2, 10, 0, 13, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.wool, (int)b3, 10, 0, 10, structureBoundingBox);
        for (int m = 0; m <= this.scatteredFeatureSizeX - 1; m += this.scatteredFeatureSizeX - 1) {
            this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, m, 2, 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.wool, (int)b2, m, 2, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, m, 2, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, m, 3, 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.wool, (int)b2, m, 3, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, m, 3, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.wool, (int)b2, m, 4, 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 1, m, 4, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.wool, (int)b2, m, 4, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, m, 5, 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.wool, (int)b2, m, 5, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, m, 5, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.wool, (int)b2, m, 6, 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 1, m, 6, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.wool, (int)b2, m, 6, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.wool, (int)b2, m, 7, 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.wool, (int)b2, m, 7, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.wool, (int)b2, m, 7, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, m, 8, 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, m, 8, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, m, 8, 3, structureBoundingBox);
        }
        for (int m = 2; m <= this.scatteredFeatureSizeX - 3; m += this.scatteredFeatureSizeX - 3 - 2) {
            this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, m - 1, 2, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.wool, (int)b2, m, 2, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, m + 1, 2, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, m - 1, 3, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.wool, (int)b2, m, 3, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, m + 1, 3, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.wool, (int)b2, m - 1, 4, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 1, m, 4, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.wool, (int)b2, m + 1, 4, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, m - 1, 5, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.wool, (int)b2, m, 5, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, m + 1, 5, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.wool, (int)b2, m - 1, 6, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 1, m, 6, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.wool, (int)b2, m + 1, 6, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.wool, (int)b2, m - 1, 7, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.wool, (int)b2, m, 7, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.wool, (int)b2, m + 1, 7, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, m - 1, 8, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, m, 8, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, m + 1, 8, 0, structureBoundingBox);
        }
        this.fillWithMetadataBlocks(world, structureBoundingBox, 8, 4, 0, 12, 6, 0, Blocks.sandstone, 2, Blocks.sandstone, 2, false);
        this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 8, 6, 0, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 12, 6, 0, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.wool, (int)b2, 9, 5, 0, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 1, 10, 5, 0, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.wool, (int)b2, 11, 5, 0, structureBoundingBox);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 8, -14, 8, 12, -11, 12, Blocks.sandstone, 2, Blocks.sandstone, 2, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 8, -10, 8, 12, -10, 12, Blocks.sandstone, 1, Blocks.sandstone, 1, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 8, -9, 8, 12, -9, 12, Blocks.sandstone, 2, Blocks.sandstone, 2, false);
        this.fillWithBlocks(world, structureBoundingBox, 8, -8, 8, 12, -1, 12, Blocks.sandstone, Blocks.sandstone, false);
        this.fillWithBlocks(world, structureBoundingBox, 9, -11, 9, 11, -1, 11, Blocks.air, Blocks.air, false);
        this.placeBlockAtCurrentPosition(world, Blocks.stone_pressure_plate, 0, 10, -11, 10, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 8, -11, 10, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 8, -10, 10, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 1, 7, -10, 10, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 7, -11, 10, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 12, -11, 10, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 12, -10, 10, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 1, 13, -10, 10, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 13, -11, 10, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 10, -11, 8, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 10, -10, 8, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 1, 10, -10, 7, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 10, -11, 7, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 10, -11, 12, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 10, -10, 12, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 1, 10, -10, 13, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 10, -11, 13, structureBoundingBox);
        this.fillWithBlocks(world, structureBoundingBox, 8, -13, 8, 12, -13, 12, Blocks.air, Blocks.air, false);
        this.fillWithBlocks(world, structureBoundingBox, 1, -14, 8, 12, -14, 12, Blocks.sandstone, Blocks.sandstone, false);
        this.fillWithBlocks(world, structureBoundingBox, 1, -14, 8, 2, -4, 12, Blocks.sandstone, Blocks.sandstone, false);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 8, -13, 12, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 0, 10, -13, 12, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.redstone_torch, DirectionTools.torch[this.coordBaseMode][1], 11, -13, 12, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 12, -13, 12, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 12, -13, 11, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 12, -13, 10, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 12, -13, 9, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 12, -13, 8, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 11, -13, 8, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 10, -13, 8, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 9, -13, 8, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 8, -13, 8, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 8, -13, 9, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 0, 8, -13, 10, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.redstone_torch, DirectionTools.torch[this.coordBaseMode][2], 8, -13, 11, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 10, -13, 11, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 10, -13, 10, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 13, -13, 12, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 13, -12, 12, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 0, 13, -13, 13, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 13, -12, 13, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 13, -11, 13, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 0, 13, -12, 14, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.redstone_torch, 5, 13, -11, 14, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 0, 13, -10, 14, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 14, -10, 13, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 12, -10, 13, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 13, -10, 12, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.redstone_torch, DirectionTools.torch[this.coordBaseMode][3], 13, -10, 13, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 7, -13, 8, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 7, -12, 8, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 0, 7, -13, 7, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 7, -12, 7, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 7, -11, 7, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 0, 7, -12, 6, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.redstone_torch, 5, 7, -11, 6, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 0, 7, -10, 6, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 6, -10, 7, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 8, -10, 7, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 7, -10, 8, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.redstone_torch, DirectionTools.torch[this.coordBaseMode][2], 7, -10, 7, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 9, -13, 12, structureBoundingBox);
        for (int m = 0; m < 4; ++m) {
            int x = Direction.offsetX[m] * 3 + Direction.offsetZ[m];
            int z = Direction.offsetZ[m] * 3 + Direction.offsetX[m];
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 10 + x, -10, 10 + z, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 10 + x, -11, 10 + z, structureBoundingBox);
            x = Direction.offsetX[m] * 3 + Direction.offsetZ[m] * 2;
            z = Direction.offsetZ[m] * 3 + Direction.offsetX[m] * 2;
            final int direction = this.getMetadataWithOffset((Block)Blocks.sticky_piston, Direction.directionToFacing[(m + 1) % 4]);
            this.placeBlockAtCurrentPosition(world, (Block)Blocks.sticky_piston, direction, 10 + x, -10, 10 + z, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, (Block)Blocks.sticky_piston, direction, 10 + x, -11, 10 + z, structureBoundingBox);
            x = Direction.offsetX[m] * 2;
            z = Direction.offsetZ[m] * 2;
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 10 + x, -11, 10 + z, structureBoundingBox);
            x = Direction.offsetX[m] - Direction.offsetZ[m];
            z = Direction.offsetZ[m] - Direction.offsetX[m];
            if (Direction.offsetZ[m] == 0) {
                this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 1, 10 + x * 3, -10, 10 + z, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 10 + x * 3, -11, 10 + z, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 0, 10 + x * 3, -12, 10, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 10 + x * 3, -9, 10, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 10 + x * 3, -9, 10 + z, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 10 + x * 3, -9, 10 - z, structureBoundingBox);
            }
            else {
                this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 1, 10 + x, -10, 10 + z * 3, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 10 + x, -11, 10 + z * 3, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 0, 10, -12, 10 + z * 3, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 10, -9, 10 + z * 3, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 10 + x, -9, 10 + z * 3, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 10 - x, -9, 10 + z * 3, structureBoundingBox);
            }
            if (this.isChestPiece[m]) {
                if (Direction.offsetZ[m] == 0) {
                    if (x < 0) {
                        this.fillWithMetadataBlocks(world, structureBoundingBox, 10 + x * 6, -12, 9, 10 + x * 4, -12, 11, Blocks.sandstone, 2, Blocks.sandstone, 2, false);
                        this.fillWithMetadataBlocks(world, structureBoundingBox, 10 + x * 7, -11, 8, 10 + x * 4, -8, 12, Blocks.sandstone, 2, Blocks.sandstone, 2, false);
                        this.fillWithMetadataBlocks(world, structureBoundingBox, 10 + x * 7, -10, 8, 10 + x * 4, -10, 12, Blocks.sandstone, 1, Blocks.sandstone, 1, false);
                        this.fillWithAir(world, structureBoundingBox, 10 + x * 6, -11, 9, 10 + x * 4, -9, 11);
                    }
                    else {
                        this.fillWithMetadataBlocks(world, structureBoundingBox, 10 + x * 4, -12, 9, 10 + x * 6, -12, 11, Blocks.sandstone, 2, Blocks.sandstone, 2, false);
                        this.fillWithMetadataBlocks(world, structureBoundingBox, 10 + x * 4, -11, 8, 10 + x * 7, -8, 12, Blocks.sandstone, 2, Blocks.sandstone, 2, false);
                        this.fillWithMetadataBlocks(world, structureBoundingBox, 10 + x * 4, -10, 8, 10 + x * 7, -10, 12, Blocks.sandstone, 1, Blocks.sandstone, 1, false);
                        this.fillWithAir(world, structureBoundingBox, 10 + x * 4, -11, 9, 10 + x * 6, -9, 11);
                    }
                }
                else if (z < 0) {
                    this.fillWithMetadataBlocks(world, structureBoundingBox, 9, -12, 10 + z * 6, 11, -12, 10 + z * 4, Blocks.sandstone, 2, Blocks.sandstone, 2, false);
                    this.fillWithMetadataBlocks(world, structureBoundingBox, 8, -11, 10 + z * 7, 12, -8, 10 + z * 4, Blocks.sandstone, 2, Blocks.sandstone, 2, false);
                    this.fillWithMetadataBlocks(world, structureBoundingBox, 8, -10, 10 + z * 7, 12, -10, 10 + z * 4, Blocks.sandstone, 1, Blocks.sandstone, 1, false);
                    this.fillWithAir(world, structureBoundingBox, 9, -11, 10 + z * 6, 11, -9, 10 + z * 4);
                }
                else {
                    this.fillWithMetadataBlocks(world, structureBoundingBox, 9, -12, 10 + z * 4, 11, -12, 10 + z * 6, Blocks.sandstone, 2, Blocks.sandstone, 2, false);
                    this.fillWithMetadataBlocks(world, structureBoundingBox, 8, -11, 10 + z * 4, 12, -8, 10 + z * 7, Blocks.sandstone, 2, Blocks.sandstone, 2, false);
                    this.fillWithMetadataBlocks(world, structureBoundingBox, 8, -10, 10 + z * 4, 12, -10, 10 + z * 7, Blocks.sandstone, 1, Blocks.sandstone, 1, false);
                    this.fillWithAir(world, structureBoundingBox, 9, -11, 10 + z * 4, 11, -9, 10 + z * 6);
                }
                this.generateStructureChestContents(world, structureBoundingBox, random, 10 + Direction.offsetX[m] * 6, -11, 10 + Direction.offsetZ[m] * 6, ChestGenHooks.getItems("pyramidDesertyChest", random), ChestGenHooks.getCount("pyramidDesertyChest", random));
                this.spawnEntity(world, structureBoundingBox, 10 + Direction.offsetX[m] * 5, -11, 10 + Direction.offsetZ[m] * 5, 0);
            }
            else {
                if (Direction.offsetZ[m] == 0) {
                    if (x < 0) {
                        this.fillWithMetadataBlocks(world, structureBoundingBox, 10 + x * 4, -12, 10, 10 + x * 4, -12, 10, Blocks.sandstone, 2, Blocks.sandstone, 2, false);
                        this.fillWithMetadataBlocks(world, structureBoundingBox, 10 + x * 5, -11, 9, 10 + x * 4, -9, 11, Blocks.sandstone, 2, Blocks.sandstone, 2, false);
                        this.fillWithMetadataBlocks(world, structureBoundingBox, 10 + x * 5, -10, 9, 10 + x * 4, -10, 11, Blocks.sandstone, 1, Blocks.sandstone, 1, false);
                        this.fillWithAir(world, structureBoundingBox, 10 + x * 4, -11, 10, 10 + x * 4, -10, 10);
                    }
                    else {
                        this.fillWithMetadataBlocks(world, structureBoundingBox, 10 + x * 4, -12, 10, 10 + x * 4, -12, 10, Blocks.sandstone, 2, Blocks.sandstone, 2, false);
                        this.fillWithMetadataBlocks(world, structureBoundingBox, 10 + x * 4, -11, 9, 10 + x * 5, -9, 11, Blocks.sandstone, 2, Blocks.sandstone, 2, false);
                        this.fillWithMetadataBlocks(world, structureBoundingBox, 10 + x * 4, -10, 9, 10 + x * 5, -10, 11, Blocks.sandstone, 1, Blocks.sandstone, 1, false);
                        this.fillWithAir(world, structureBoundingBox, 10 + x * 4, -11, 10, 10 + x * 4, -10, 10);
                    }
                }
                else if (z < 0) {
                    this.fillWithMetadataBlocks(world, structureBoundingBox, 10, -12, 10 + z * 4, 10, -12, 10 + z * 4, Blocks.sandstone, 2, Blocks.sandstone, 2, false);
                    this.fillWithMetadataBlocks(world, structureBoundingBox, 9, -11, 10 + z * 5, 11, -9, 10 + z * 4, Blocks.sandstone, 2, Blocks.sandstone, 2, false);
                    this.fillWithMetadataBlocks(world, structureBoundingBox, 9, -10, 10 + z * 5, 11, -10, 10 + z * 4, Blocks.sandstone, 1, Blocks.sandstone, 1, false);
                    this.fillWithAir(world, structureBoundingBox, 10, -11, 10 + z * 4, 10, -10, 10 + z * 4);
                }
                else {
                    this.fillWithMetadataBlocks(world, structureBoundingBox, 10, -12, 10 + z * 4, 10, -12, 10 + z * 4, Blocks.sandstone, 2, Blocks.sandstone, 2, false);
                    this.fillWithMetadataBlocks(world, structureBoundingBox, 9, -11, 10 + z * 4, 11, -9, 10 + z * 5, Blocks.sandstone, 2, Blocks.sandstone, 2, false);
                    this.fillWithMetadataBlocks(world, structureBoundingBox, 9, -10, 10 + z * 4, 11, -10, 10 + z * 5, Blocks.sandstone, 1, Blocks.sandstone, 1, false);
                    this.fillWithAir(world, structureBoundingBox, 10, -11, 10 + z * 4, 10, -10, 10 + z * 4);
                }
                this.spawnEntity(world, structureBoundingBox, 10 + Direction.offsetX[m] * 4, -11, 10 + Direction.offsetZ[m] * 4, 0);
            }
        }
        this.spawnEntity(world, structureBoundingBox, 10, 2, 10, 0);
        return true;
    }
    
    @Override
    protected EntityLiving getNewEntity(final World world, final int choice) {
        return (EntityLiving)new EntityMummy(world);
    }
}
