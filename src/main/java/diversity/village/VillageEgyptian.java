// 
// Decompiled by Procyon v0.5.36
// 

package diversity.village;

import net.minecraft.util.MathHelper;
import diversity.entity.EntityEgyptian;
import diversity.suppliers.EnumVillager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.world.gen.structure.StructureComponent;
import diversity.suppliers.IEnumPiece;
import diversity.suppliers.EnumVillagePiece;
import diversity.suppliers.EnumVillageBasicPiece;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureVillagePieces;
import java.util.List;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import java.util.Random;
import diversity.suppliers.EnumVillage;

public class VillageEgyptian extends VillageTools
{
    private static VillageEgyptian instance;
    
    public VillageEgyptian(final EnumVillage ENUM) {
        super(ENUM);
        VillageEgyptian.instance = this;
    }
    
    @Override
    protected GlobalPath getPath(final GlobalStart p_75080_0_, final int p_75080_7_, final Random p_75080_2_, final StructureBoundingBox structureboundingbox, final int p_75080_6_) {
        return new Path(p_75080_0_, p_75080_7_, p_75080_2_, structureboundingbox, p_75080_6_);
    }
    
    @Override
    public GlobalStart getStart(final WorldChunkManager worldChunkManager, final int i, final Random rand, final int j, final int k, final List list, final int terrainType) {
        return new Start(worldChunkManager, i, rand, j, k, list, terrainType);
    }
    
    @Override
    protected GlobalTorch getTorch(final GlobalStart villagePiece, final int par2, final Random rand, final StructureBoundingBox boundingBox, final int coordBaseMode) {
        return new Torch(villagePiece, par2, rand, boundingBox, coordBaseMode);
    }
    
    public static class Start extends GlobalStart
    {
        public Start() {
        }
        
        public Start(final WorldChunkManager p_i2104_1_, final int p_i2104_2_, final Random p_i2104_3_, final int p_i2104_4_, final int p_i2104_5_, final List p_i2104_6_, final int p_i2104_7_) {
            super(VillageEgyptian.instance, p_i2104_1_, p_i2104_2_, p_i2104_3_, p_i2104_4_, p_i2104_5_, p_i2104_6_, p_i2104_7_);
        }
        
        @Override
        public boolean addComponentParts(final World world, final Random rand, final StructureBoundingBox structureBoundingBox) {
            if (super.addComponentParts(world, rand, structureBoundingBox, 3)) {
                return true;
            }
            for (int x = 0; x < 6; ++x) {
                for (int z = 0; z < 6; ++z) {
                    this.clearCurrentPositionBlocksUpwards(world, x, 11, z, structureBoundingBox);
                    if ((x == 1 || x == 4) && (z == 1 || z == 4)) {
                        this.func_151554_b(world, Blocks.sandstone, 0, x, 10, z, structureBoundingBox);
                        this.func_151554_b(world, Blocks.sandstone, 2, x, 12, z, structureBoundingBox);
                        this.placeBlockAtCurrentPosition(world, Blocks.fence, 2, x, 13, z, structureBoundingBox);
                    }
                    else if (x >= 1 && x <= 4 && z >= 1 && z <= 4) {
                        if (x == 1 || x == 4 || z == 1 || z == 4) {
                            this.clearCurrentPositionBlocksUpwards(world, x, 0, z, structureBoundingBox);
                            this.func_151554_b(world, Blocks.sandstone, 0, x, 10, z, structureBoundingBox);
                            this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, x, 13, z, structureBoundingBox);
                        }
                        else {
                            this.clearCurrentPositionBlocksUpwards(world, x, 0, z, structureBoundingBox);
                            this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 0, x, 0, z, structureBoundingBox);
                            this.func_151554_b(world, Blocks.water, 0, x, 10, z, structureBoundingBox);
                            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, x, 13, z, structureBoundingBox);
                        }
                    }
                    else {
                        this.func_151554_b(world, Blocks.sandstone, 0, x, 10, z, structureBoundingBox);
                    }
                }
            }
            return true;
        }
    }
    
    public static class Path extends GlobalPath
    {
        public Path() {
        }
        
        public Path(final GlobalStart p_i2105_1_, final int p_i2105_2_, final Random p_i2105_3_, final StructureBoundingBox p_i2105_4_, final int p_i2105_5_) {
            super(VillageEgyptian.instance, p_i2105_1_, p_i2105_2_, p_i2105_3_, p_i2105_4_, p_i2105_5_);
        }
        
        @Override
        protected BlockData getPathBlock(final Random random) {
            if (random.nextInt(3) == 0) {
                return new BlockData(Blocks.gravel, 0);
            }
            return new BlockData((Block)Blocks.sand, 0);
        }
        
        @Override
        protected BlockData getPathBridge(final Random random) {
            return new BlockData((Block)Blocks.wooden_slab, 1);
        }
        
        @Override
        protected BlockData getUnderPathBlock(final Random random) {
            return new BlockData(Blocks.dirt, 0);
        }
    }
    
    public static class Torch extends GlobalTorch
    {
        public Torch() {
        }
        
        public Torch(final StructureVillagePieces.Start startPiece, final int componentType, final Random random, final StructureBoundingBox structureBoundingBox, final int coordBaseMode) {
            super(EnumVillageBasicPiece.EGYPTIAN_TORCH, startPiece, componentType, random, structureBoundingBox, coordBaseMode);
            this.setOffset(2);
        }
        
        @Override
        public boolean build(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
            this.fillWithBlocks(world, structureBoundingBox, 0, 0, 0, 2, 3, 1, Blocks.air, Blocks.air, false);
            this.func_151554_b(world, Blocks.sandstone, 2, 1, 1, 0, structureBoundingBox);
            this.func_151554_b(world, Blocks.fence, 0, 0, 1, 0, structureBoundingBox);
            this.func_151554_b(world, Blocks.fence, 0, 2, 1, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 1, 2, 0, structureBoundingBox);
            return true;
        }
    }
    
    public static class House1 extends GlobalVillage
    {
        public House1() {
        }
        
        public House1(final StructureVillagePieces.Start villagePiece, final int componentType, final Random random, final StructureBoundingBox structureBoundingBox, final int coordBaseMode) {
            super(EnumVillagePiece.EGYPTIAN_HOUSE1, villagePiece, componentType, structureBoundingBox, coordBaseMode);
            this.setOffset(5);
        }
        
        public static House1 buildComponent(final StructureVillagePieces.Start villagePiece, final List pieces, final Random random, final int x, final int y, final int z, final int coordBaseMode, final int p5) {
            final StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(x, y, z, 0, 0, 0, 8, 6, 6, coordBaseMode);
            return (canVillageGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(pieces, structureboundingbox) == null) ? new House1(villagePiece, p5, random, structureboundingbox, coordBaseMode) : null;
        }
        
        @Override
        public boolean build(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
            for (int x = 0; x < 8; ++x) {
                for (int z = 0; z < 5; ++z) {
                    if (x < 5 || x == 7 || z == 4) {
                        this.func_151554_b(world, Blocks.sandstone, 0, x, 0, z, structureBoundingBox);
                    }
                    this.func_151554_b(world, (Block)Blocks.sand, 0, x, -1, z, structureBoundingBox);
                    this.clearCurrentPositionBlocksUpwards(world, x, 1, z, structureBoundingBox);
                }
            }
            this.fillWithBlocks(world, structureBoundingBox, 0, 0, 0, 4, 2, 4, Blocks.sandstone, Blocks.sandstone, false);
            this.fillWithBlocks(world, structureBoundingBox, 1, 1, 1, 3, 2, 3, Blocks.air, Blocks.air, false);
            for (int k = 0; k < 3; ++k) {
                this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 0, k, 0, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 0, k + 3, 0, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 1 + k, 3, 0, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 5 + k, 3, 0, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 4, k, 0, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 4, k + 3, 0, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 7, k, 0, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 0, 3, 1 + k, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 4, 3, 1 + k, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 7, 3, 1 + k, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 0, k, 4, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 0, k + 3, 4, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 1 + k, 3, 4, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 5 + k, 3, 4, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 4, k, 4, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 4, k + 3, 4, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 7, k, 4, structureBoundingBox);
            }
            this.fillWithBlocks(world, structureBoundingBox, 0, 4, 1, 0, 4, 3, Blocks.sandstone, Blocks.air, false);
            this.fillWithBlocks(world, structureBoundingBox, 4, 4, 1, 4, 4, 3, Blocks.sandstone, Blocks.air, false);
            this.fillWithBlocks(world, structureBoundingBox, 7, 0, 1, 7, 2, 3, Blocks.sandstone, Blocks.air, false);
            this.fillWithBlocks(world, structureBoundingBox, 5, 0, 4, 6, 2, 4, Blocks.sandstone, Blocks.air, false);
            this.fillWithBlocks(world, structureBoundingBox, 5, 3, 0, 6, 3, 3, Blocks.fence, Blocks.air, false);
            for (int k = 0; k < 2; ++k) {
                this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 1, k + 4, 0, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 3, k + 4, 0, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 1, k + 4, 4, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 3, k + 4, 4, structureBoundingBox);
            }
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 0, 5, 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 0, 5, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 4, 5, 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 4, 5, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 2, 2, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 0, 2, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 7, 2, 2, structureBoundingBox);
            for (int x = 1; x < 4; ++x) {
                for (int z = 1; z < 4; ++z) {
                    this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 9, x, 3, z, structureBoundingBox);
                }
            }
            this.func_151554_b(world, Blocks.sandstone, 0, 5, -1, 3, structureBoundingBox);
            this.func_151554_b(world, Blocks.sandstone, 0, 5, -1, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.sandstone_stairs, this.getMetadataWithOffset(Blocks.sandstone_stairs, 1), 5, 0, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.sandstone_stairs, this.getMetadataWithOffset(Blocks.sandstone_stairs, 3), 5, 0, 2, structureBoundingBox);
            this.func_151554_b(world, Blocks.sandstone, 0, 0, -1, 5, structureBoundingBox);
            this.func_151554_b(world, Blocks.sandstone, 0, 1, -1, 5, structureBoundingBox);
            this.func_151554_b(world, Blocks.sandstone, 0, 2, -1, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.sandstone_stairs, this.getMetadataWithOffset(Blocks.sandstone_stairs, 0), 0, 0, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.sandstone_stairs, this.getMetadataWithOffset(Blocks.sandstone_stairs, 2), 1, 0, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.sandstone_stairs, this.getMetadataWithOffset(Blocks.sandstone_stairs, 1), 2, 0, 5, structureBoundingBox);
            for (int k = 1; k < 5; ++k) {
                this.placeBlockAtCurrentPosition(world, Blocks.ladder, this.getMetadataWithOffset(Blocks.ladder, 4), 3, k, 2, structureBoundingBox);
            }
            this.placeDoorAtCurrentPosition(world, structureBoundingBox, random, 4, 1, 3, this.getMetadataWithOffset(Blocks.wooden_door, 2));
            this.placeDoorAtCurrentPosition(world, structureBoundingBox, random, 1, 1, 4, this.getMetadataWithOffset(Blocks.wooden_door, 3));
            this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 3, 2, 1, structureBoundingBox);
            this.spawnEntity(world, structureBoundingBox, 2, 2, 3, 0);
            this.spawnEntity(world, structureBoundingBox, 2, 2, 3, 0);
            return true;
        }
        
        @Override
        protected EntityLiving getNewEntity(final World world, final int choice) {
            return (EntityLiving)new EntityEgyptian(world, EnumVillager.EGYPTIAN_SCULPTOR);
        }
    }
    
    public static class House2 extends GlobalVillage
    {
        public House2() {
        }
        
        public House2(final StructureVillagePieces.Start villagePiece, final int componentType, final Random random, final StructureBoundingBox structureBoundingBox, final int coordBaseMode) {
            super(EnumVillagePiece.EGYPTIAN_HOUSE2, villagePiece, componentType, structureBoundingBox, coordBaseMode);
            this.setOffset(6);
        }
        
        public static House2 buildComponent(final StructureVillagePieces.Start villagePiece, final List pieces, final Random random, final int x, final int y, final int z, final int coordBaseMode, final int p5) {
            final StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(x, y, z, 0, 0, 0, 12, 7, 9, coordBaseMode);
            return (canVillageGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(pieces, structureboundingbox) == null) ? new House2(villagePiece, p5, random, structureboundingbox, coordBaseMode) : null;
        }
        
        @Override
        public boolean build(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
            for (int x = 1; x < 12; ++x) {
                for (int z = 0; z < 9; ++z) {
                    this.func_151554_b(world, Blocks.sandstone, 0, x, 0, z, structureBoundingBox);
                    this.clearCurrentPositionBlocksUpwards(world, x, 1, z, structureBoundingBox);
                }
            }
            this.fillWithBlocks(world, structureBoundingBox, 1, 1, 1, 1, 2, 7, Blocks.sandstone, Blocks.sandstone, false);
            this.fillWithBlocks(world, structureBoundingBox, 11, 1, 1, 11, 2, 7, Blocks.sandstone, Blocks.sandstone, false);
            this.fillWithBlocks(world, structureBoundingBox, 1, 1, 0, 5, 1, 0, Blocks.sandstone, Blocks.sandstone, false);
            this.fillWithBlocks(world, structureBoundingBox, 7, 1, 0, 11, 1, 0, Blocks.sandstone, Blocks.sandstone, false);
            this.fillWithBlocks(world, structureBoundingBox, 1, 1, 8, 11, 2, 8, Blocks.sandstone, Blocks.sandstone, false);
            this.fillWithBlocks(world, structureBoundingBox, 1, 1, 4, 11, 2, 4, Blocks.sandstone, Blocks.sandstone, false);
            this.fillWithBlocks(world, structureBoundingBox, 7, 4, 4, 11, 5, 8, Blocks.sandstone, Blocks.sandstone, false);
            this.fillWithBlocks(world, structureBoundingBox, 8, 4, 5, 10, 5, 7, Blocks.air, Blocks.air, false);
            for (int k = 0; k < 3; ++k) {
                if (k != 2) {
                    this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 1, k, 0, structureBoundingBox);
                    this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 1, k + 2, 0, structureBoundingBox);
                    this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 5, k, 0, structureBoundingBox);
                    this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 5, k + 2, 0, structureBoundingBox);
                    this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 7, k, 0, structureBoundingBox);
                    this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 7, k + 2, 0, structureBoundingBox);
                    this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 11, k, 0, structureBoundingBox);
                    this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 11, k + 2, 0, structureBoundingBox);
                    this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 1, k + 3, 4, structureBoundingBox);
                    this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 1, k + 3, 8, structureBoundingBox);
                    this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, k + 8, 3, 4, structureBoundingBox);
                    this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, k + 8, 3, 8, structureBoundingBox);
                    this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, k + 8, 6, 4, structureBoundingBox);
                    this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, k + 8, 6, 8, structureBoundingBox);
                    this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, k + 10, 3, 4, structureBoundingBox);
                    this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, k + 10, 3, 8, structureBoundingBox);
                    this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, k + 10, 6, 4, structureBoundingBox);
                    this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, k + 10, 6, 8, structureBoundingBox);
                }
                this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 1, k, 4, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 1, k, 8, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 5, k, 4, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 5, k + 4, 4, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 7, k, 4, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 7, k + 4, 4, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 5, k, 8, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 5, k + 4, 8, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 7, k, 8, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 7, k + 4, 8, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, k + 2, 3, 4, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, k + 2, 3, 8, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, k + 5, 3, 4, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, k + 5, 3, 8, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 1, 3, k + 5, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 7, 6, k + 5, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 11, 3, k + 5, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 11, 6, k + 5, structureBoundingBox);
            }
            this.fillWithBlocks(world, structureBoundingBox, 2, 2, 0, 4, 3, 0, Blocks.fence, Blocks.fence, false);
            this.fillWithBlocks(world, structureBoundingBox, 8, 2, 0, 10, 3, 0, Blocks.fence, Blocks.fence, false);
            this.fillWithBlocks(world, structureBoundingBox, 1, 3, 1, 1, 3, 3, Blocks.fence, Blocks.fence, false);
            this.fillWithBlocks(world, structureBoundingBox, 11, 3, 1, 11, 3, 3, Blocks.fence, Blocks.fence, false);
            this.fillWithBlocks(world, structureBoundingBox, 1, 4, 5, 1, 4, 7, Blocks.fence, Blocks.fence, false);
            this.fillWithBlocks(world, structureBoundingBox, 2, 4, 4, 4, 4, 4, Blocks.fence, Blocks.fence, false);
            this.fillWithBlocks(world, structureBoundingBox, 2, 4, 8, 4, 4, 8, Blocks.fence, Blocks.fence, false);
            this.fillWithBlocks(world, structureBoundingBox, 6, 4, 4, 6, 6, 4, Blocks.fence, Blocks.fence, false);
            this.fillWithBlocks(world, structureBoundingBox, 6, 4, 8, 6, 6, 8, Blocks.fence, Blocks.fence, false);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 3, 2, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 9, 2, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 9, 5, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 3, 2, 8, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 9, 2, 8, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 9, 5, 8, structureBoundingBox);
            for (int x = 2; x < 11; ++x) {
                for (int z = 5; z < 8; ++z) {
                    this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 9, x, 3, z, structureBoundingBox);
                }
            }
            for (int x = 8; x < 11; ++x) {
                for (int z = 5; z < 8; ++z) {
                    this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 9, x, 6, z, structureBoundingBox);
                    this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 1, x, 7, z, structureBoundingBox);
                }
            }
            for (int k = 1; k < 5; ++k) {
                this.placeBlockAtCurrentPosition(world, Blocks.ladder, this.getMetadataWithOffset(Blocks.ladder, 4), 10, k, 6, structureBoundingBox);
            }
            this.placeBlockAtCurrentPosition(world, Blocks.sandstone_stairs, this.getMetadataWithOffset(Blocks.sandstone_stairs, 3), 6, 0, 0, structureBoundingBox);
            this.func_151554_b(world, Blocks.sandstone, 0, 0, -1, 5, structureBoundingBox);
            this.func_151554_b(world, Blocks.sandstone, 0, 0, -1, 6, structureBoundingBox);
            this.func_151554_b(world, Blocks.sandstone, 0, 0, -1, 7, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.sandstone_stairs, this.getMetadataWithOffset(Blocks.sandstone_stairs, 3), 0, 0, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.sandstone_stairs, this.getMetadataWithOffset(Blocks.sandstone_stairs, 0), 0, 0, 6, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.sandstone_stairs, this.getMetadataWithOffset(Blocks.sandstone_stairs, 2), 0, 0, 7, structureBoundingBox);
            this.placeDoorAtCurrentPosition(world, structureBoundingBox, random, 6, 1, 4, this.getMetadataWithOffset(Blocks.wooden_door, 1));
            this.placeDoorAtCurrentPosition(world, structureBoundingBox, random, 1, 1, 6, this.getMetadataWithOffset(Blocks.wooden_door, 2));
            this.placeDoorAtCurrentPosition(world, structureBoundingBox, random, 7, 4, 6, this.getMetadataWithOffset(Blocks.wooden_door, 2));
            this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 5, 2, 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 7, 2, 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 4, 2, 7, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 8, 2, 7, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 10, 5, 6, structureBoundingBox);
            this.spawnEntity(world, structureBoundingBox, 6, 2, 6, 0);
            this.spawnEntity(world, structureBoundingBox, 6, 2, 6, 0);
            return true;
        }
        
        @Override
        protected EntityLiving getNewEntity(final World world, final int choice) {
            return (EntityLiving)new EntityEgyptian(world, EnumVillager.EGYPTIAN_SCRIBE);
        }
    }
    
    public static class House3 extends GlobalVillage
    {
        public House3() {
        }
        
        public House3(final StructureVillagePieces.Start villagePiece, final int componentType, final Random random, final StructureBoundingBox structureBoundingBox, final int coordBaseMode) {
            super(EnumVillagePiece.EGYPTIAN_HOUSE3, villagePiece, componentType, structureBoundingBox, coordBaseMode);
            this.setOffset(4);
        }
        
        public static House3 buildComponent(final StructureVillagePieces.Start villagePiece, final List pieces, final Random random, final int x, final int y, final int z, final int coordBaseMode, final int p5) {
            final StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(x, y, z, 0, 0, 0, 7, 5, 8, coordBaseMode);
            return (canVillageGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(pieces, structureboundingbox) == null) ? new House3(villagePiece, p5, random, structureboundingbox, coordBaseMode) : null;
        }
        
        @Override
        public boolean build(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
            for (int x = 0; x < 7; ++x) {
                for (int z = 1; z < 8; ++z) {
                    this.func_151554_b(world, Blocks.sandstone, 0, x, 2, z, structureBoundingBox);
                    this.clearCurrentPositionBlocksUpwards(world, x, 3, z, structureBoundingBox);
                }
            }
            this.fillWithBlocks(world, structureBoundingBox, 1, 1, 2, 5, 2, 6, Blocks.air, Blocks.air, false);
            for (int k = 0; k < 3; ++k) {
                this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 0, k, 1, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 6, k, 1, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 0, k, 7, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 6, k, 7, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 0, 3, 1 + k, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 0, 3, 4 + k, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, k, 3, 7, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 3 + k, 3, 7, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 6, 3, 2 + k, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 6, 3, 5 + k, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 1 + k, 3, 1, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 4 + k, 3, 1, structureBoundingBox);
            }
            for (int x = 1; x < 6; ++x) {
                for (int z = 2; z < 7; ++z) {
                    if (x == 1 || x == 5 || z == 2 || z == 6) {
                        this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 9, x, 3, z, structureBoundingBox);
                        this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, x, 4, z, structureBoundingBox);
                        this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 1, x, 5, z, structureBoundingBox);
                    }
                    else {
                        this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 9, x, 5, z, structureBoundingBox);
                    }
                }
            }
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 0, 2, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 0, 2, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 6, 2, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 6, 2, 5, structureBoundingBox);
            this.func_151554_b(world, Blocks.sandstone, 0, 3, -1, 0, structureBoundingBox);
            this.func_151554_b(world, Blocks.sandstone, 0, 4, -1, 0, structureBoundingBox);
            this.func_151554_b(world, Blocks.sandstone, 0, 5, -1, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.sandstone_stairs, this.getMetadataWithOffset(Blocks.sandstone_stairs, 0), 3, 0, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.sandstone_stairs, this.getMetadataWithOffset(Blocks.sandstone_stairs, 3), 4, 0, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.sandstone_stairs, this.getMetadataWithOffset(Blocks.sandstone_stairs, 1), 5, 0, 0, structureBoundingBox);
            this.placeDoorAtCurrentPosition(world, structureBoundingBox, random, 4, 1, 1, this.getMetadataWithOffset(Blocks.wooden_door, 1));
            this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 3, 2, 6, structureBoundingBox);
            this.spawnEntity(world, structureBoundingBox, 3, 2, 4, 0);
            return true;
        }
        
        @Override
        protected EntityLiving getNewEntity(final World world, final int choice) {
            return (EntityLiving)new EntityEgyptian(world, EnumVillager.EGYPTIAN_PAINTER);
        }
    }
    
    public static class Tower extends GlobalVillage
    {
        public Tower() {
        }
        
        public Tower(final StructureVillagePieces.Start villagePiece, final int componentType, final Random random, final StructureBoundingBox structureBoundingBox, final int coordBaseMode) {
            super(EnumVillagePiece.EGYPTIAN_TOWER, villagePiece, componentType, structureBoundingBox, coordBaseMode);
            this.setOffset(5);
        }
        
        public static Tower buildComponent(final StructureVillagePieces.Start villagePiece, final List pieces, final Random random, final int x, final int y, final int z, final int coordBaseMode, final int p5) {
            final StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(x, y, z, 0, 0, 0, 4, 6, 4, coordBaseMode);
            return (canVillageGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(pieces, structureboundingbox) == null) ? new Tower(villagePiece, p5, random, structureboundingbox, coordBaseMode) : null;
        }
        
        @Override
        public boolean build(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
            for (int x = 0; x < 4; ++x) {
                for (int z = 0; z < 4; ++z) {
                    this.func_151554_b(world, Blocks.sandstone, 0, x, 5, z, structureBoundingBox);
                    this.clearCurrentPositionBlocksUpwards(world, x, 6, z, structureBoundingBox);
                }
            }
            this.fillWithBlocks(world, structureBoundingBox, 1, 0, 1, 2, 5, 2, Blocks.air, Blocks.air, false);
            for (int k = 0; k < 7; ++k) {
                this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 0, k, 0, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 0, k, 3, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 3, k, 0, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 3, k, 3, structureBoundingBox);
            }
            this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 9, 1, 5, 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 9, 2, 5, 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 9, 1, 5, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 0, 6, 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 0, 6, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 3, 6, 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 3, 6, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 1, 6, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 2, 6, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 1, 6, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 2, 6, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 0, 3, 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 3, 3, 1, structureBoundingBox);
            for (int k = 0; k < 5; ++k) {
                this.placeBlockAtCurrentPosition(world, Blocks.ladder, this.getMetadataWithOffset(Blocks.ladder, 4), 2, k, 2, structureBoundingBox);
            }
            this.placeDoorAtCurrentPosition(world, structureBoundingBox, random, 1, 0, 0, this.getMetadataWithOffset(Blocks.wooden_door, 1));
            this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 1, 3, 2, structureBoundingBox);
            this.spawnEntity(world, structureBoundingBox, 1, 2, 1, 0);
            this.spawnEntity(world, structureBoundingBox, 1, 2, 1, 0);
            return true;
        }
        
        @Override
        protected EntityLiving getNewEntity(final World world, final int choice) {
            return (EntityLiving)new EntityEgyptian(world, EnumVillager.EGYPTIAN_GUARD);
        }
    }
    
    public static class Field extends GlobalField
    {
        public Field() {
        }
        
        public Field(final StructureVillagePieces.Start startPiece, final int componentType, final Random random, final StructureBoundingBox structureBoundingBox, final int coordBaseMode) {
            super(EnumVillagePiece.EGYPTIAN_FIELD, startPiece, componentType, random, structureBoundingBox, coordBaseMode);
            this.setOffset(0);
        }
        
        public static Field buildComponent(final StructureVillagePieces.Start villagePiece, final List pieces, final Random random, final int x, final int y, final int z, final int coordBaseMode, final int p5) {
            final StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(x, y, z, 0, 0, 0, 16, 2, 15, coordBaseMode);
            return (canVillageGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(pieces, structureboundingbox) == null) ? new Field(villagePiece, p5, random, structureboundingbox, coordBaseMode) : null;
        }
        
        @Override
        protected Block getCropType(final Random random) {
            return random.nextBoolean() ? Blocks.pumpkin_stem : Blocks.wheat;
        }
        
        @Override
        public boolean build(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
            this.fillWithBlocks(world, structureBoundingBox, 0, 1, 0, 12, 4, 8, Blocks.air, Blocks.air, false);
            this.fillWithBlocks(world, structureBoundingBox, 1, 0, 1, 2, 0, 7, Blocks.farmland, Blocks.farmland, false);
            this.fillWithBlocks(world, structureBoundingBox, 4, 0, 1, 5, 0, 7, Blocks.farmland, Blocks.farmland, false);
            this.fillWithBlocks(world, structureBoundingBox, 7, 0, 1, 8, 0, 7, Blocks.farmland, Blocks.farmland, false);
            this.fillWithBlocks(world, structureBoundingBox, 10, 0, 1, 11, 0, 7, Blocks.farmland, Blocks.farmland, false);
            this.fillWithBlocks(world, structureBoundingBox, 0, 0, 0, 0, 0, 8, Blocks.sandstone, Blocks.sandstone, false);
            this.fillWithBlocks(world, structureBoundingBox, 6, 0, 0, 6, 0, 8, Blocks.sandstone, Blocks.sandstone, false);
            this.fillWithBlocks(world, structureBoundingBox, 12, 0, 0, 12, 0, 8, Blocks.sandstone, Blocks.sandstone, false);
            this.fillWithBlocks(world, structureBoundingBox, 1, 0, 0, 11, 0, 0, Blocks.sandstone, Blocks.sandstone, false);
            this.fillWithBlocks(world, structureBoundingBox, 1, 0, 8, 11, 0, 8, Blocks.sandstone, Blocks.sandstone, false);
            this.fillWithBlocks(world, structureBoundingBox, 3, 0, 1, 3, 0, 7, Blocks.water, Blocks.water, false);
            this.fillWithBlocks(world, structureBoundingBox, 9, 0, 1, 9, 0, 7, Blocks.water, Blocks.water, false);
            for (int i = 1; i <= 7; ++i) {
                this.placeBlockAtCurrentPosition(world, this.cropTypeA, MathHelper.getRandomIntegerInRange(random, 2, 7), 1, 1, i, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, this.cropTypeA, MathHelper.getRandomIntegerInRange(random, 2, 7), 2, 1, i, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, this.cropTypeB, MathHelper.getRandomIntegerInRange(random, 2, 7), 4, 1, i, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, this.cropTypeB, MathHelper.getRandomIntegerInRange(random, 2, 7), 5, 1, i, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, this.cropTypeC, MathHelper.getRandomIntegerInRange(random, 2, 7), 7, 1, i, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, this.cropTypeC, MathHelper.getRandomIntegerInRange(random, 2, 7), 8, 1, i, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, this.cropTypeD, MathHelper.getRandomIntegerInRange(random, 2, 7), 10, 1, i, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, this.cropTypeD, MathHelper.getRandomIntegerInRange(random, 2, 7), 11, 1, i, structureBoundingBox);
            }
            for (int i = 0; i < 9; ++i) {
                for (int j = 0; j < 13; ++j) {
                    this.clearCurrentPositionBlocksUpwards(world, j, 4, i, structureBoundingBox);
                    this.func_151554_b(world, Blocks.sandstone, 0, j, -1, i, structureBoundingBox);
                }
            }
            this.spawnEntity(world, structureBoundingBox, 4, 2, 4, 0);
            this.spawnEntity(world, structureBoundingBox, 4, 2, 4, 0);
            return true;
        }
        
        @Override
        protected EntityLiving getNewEntity(final World world, final int choice) {
            return (EntityLiving)new EntityEgyptian(world, EnumVillager.EGYPTIAN_FARMER);
        }
    }
    
    public static class Temple extends GlobalVillage
    {
        public Temple() {
        }
        
        public Temple(final StructureVillagePieces.Start villagePiece, final int componentType, final Random random, final StructureBoundingBox structureBoundingBox, final int coordBaseMode) {
            super(EnumVillagePiece.EGYPTIAN_TEMPLE, villagePiece, componentType, structureBoundingBox, coordBaseMode);
            this.setOffset(7);
        }
        
        public static Temple buildComponent(final StructureVillagePieces.Start villagePiece, final List pieces, final Random random, final int x, final int y, final int z, final int coordBaseMode, final int p5) {
            final StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(x, y, z, 0, 0, 0, 17, 9, 17, coordBaseMode);
            return (canVillageGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(pieces, structureboundingbox) == null) ? new Temple(villagePiece, p5, random, structureboundingbox, coordBaseMode) : null;
        }
        
        @Override
        public boolean build(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
            for (int x = 0; x < 17; ++x) {
                for (int z = 0; z < 17; ++z) {
                    this.clearCurrentPositionBlocksUpwards(world, x, 0, z, structureBoundingBox);
                    if (x > 4 && x < 12 && z > 4 && z < 12) {
                        this.func_151554_b(world, Blocks.sandstone, 0, x, 0, z, structureBoundingBox);
                        if (x == 5 || x == 11 || z == 5 || z == 11) {
                            this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 0, x, 6, z, structureBoundingBox);
                            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, x, 7, z, structureBoundingBox);
                            this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 1, x, 8, z, structureBoundingBox);
                        }
                        else if (x == 6 || x == 10 || z == 6 || z == 10) {
                            this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 0, x, 8, z, structureBoundingBox);
                        }
                        else {
                            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, x, 8, z, structureBoundingBox);
                        }
                    }
                    else if (x % 4 == 0 && z % 4 == 0) {
                        this.func_151554_b(world, Blocks.sandstone, 2, x, 5, z, structureBoundingBox);
                        if (x > 2 && x < 14 && z > 2 && z < 14) {
                            this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 1, x, 6, z, structureBoundingBox);
                        }
                    }
                    else if (x % 4 == 0 || z % 4 == 0) {
                        this.func_151554_b(world, Blocks.sandstone, 0, x, 0, z, structureBoundingBox);
                        this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, x, 5, z, structureBoundingBox);
                        if (x > 2 && x < 14 && z > 2 && z < 14) {
                            this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 1, x, 6, z, structureBoundingBox);
                        }
                        if (x > 3 && x < 13 && z > 3 && z < 13) {
                            if (x % 2 == 0 && z % 2 == 0) {
                                this.func_151554_b(world, Blocks.sandstone, 2, x, 2, z, structureBoundingBox);
                                this.placeBlockAtCurrentPosition(world, Blocks.lapis_block, 0, x, 3, z, structureBoundingBox);
                                this.placeBlockAtCurrentPosition(world, Blocks.lapis_block, 0, x, 4, z, structureBoundingBox);
                            }
                            else {
                                this.func_151554_b(world, Blocks.sandstone, 1, x, 4, z, structureBoundingBox);
                            }
                            this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, x, 1, z, structureBoundingBox);
                        }
                    }
                    else {
                        this.func_151554_b(world, Blocks.sandstone, 0, x, 0, z, structureBoundingBox);
                        this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, x, 5, z, structureBoundingBox);
                    }
                }
            }
            for (int x = 5; x < 12; ++x) {
                this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, x, 3, 4, structureBoundingBox);
            }
            this.placeDoorAtCurrentPosition(world, structureBoundingBox, random, 6, 1, 4, this.getMetadataWithOffset(Blocks.wooden_door, 1));
            this.placeDoorAtCurrentPosition(world, structureBoundingBox, random, 10, 1, 4, this.getMetadataWithOffset(Blocks.wooden_door, 1));
            this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 4, 4, 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 8, 4, 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 12, 4, 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 4, 4, 15, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 8, 4, 15, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 12, 4, 15, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 1, 4, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 1, 4, 8, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 1, 4, 12, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 15, 4, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 15, 4, 8, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 15, 4, 12, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 8, 4, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 8, 4, 11, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 5, 4, 8, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 11, 4, 8, structureBoundingBox);
            this.spawnEntity(world, structureBoundingBox, 8, 1, 8, 0);
            return true;
        }
        
        @Override
        protected EntityLiving getNewEntity(final World world, final int choice) {
            return (EntityLiving)new EntityEgyptian(world, EnumVillager.EGYPTIAN_PRIEST);
        }
    }
    
    public static class Palace extends GlobalVillage
    {
        public Palace() {
        }
        
        public Palace(final StructureVillagePieces.Start villagePiece, final int componentType, final Random random, final StructureBoundingBox structureBoundingBox, final int coordBaseMode) {
            super(EnumVillagePiece.EGYPTIAN_PALACE, villagePiece, componentType, structureBoundingBox, coordBaseMode);
            this.setOffset(11);
        }
        
        public static Palace buildComponent(final StructureVillagePieces.Start villagePiece, final List pieces, final Random random, final int x, final int y, final int z, final int coordBaseMode, final int p5) {
            final StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(x, y, z, 0, 0, 0, 21, 12, 21, coordBaseMode);
            return (canVillageGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(pieces, structureboundingbox) == null) ? new Palace(villagePiece, p5, random, structureboundingbox, coordBaseMode) : null;
        }
        
        @Override
        public boolean build(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
            for (int x = 0; x < 21; ++x) {
                for (int z = 0; z < 21; ++z) {
                    this.clearCurrentPositionBlocksUpwards(world, x, -1, z, structureBoundingBox);
                }
            }
            for (int y = 1; y < 5; ++y) {
                this.placeBlockAtCurrentPosition(world, Blocks.wool, 1, 1, y, 0, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.wool, 1, 3, y, 0, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.wool, 1, 17, y, 0, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.wool, 1, 19, y, 0, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.wool, 1, 1, y, 20, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.wool, 1, 3, y, 20, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.wool, 1, 17, y, 20, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.wool, 1, 19, y, 20, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.wool, 1, 0, y, 1, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.wool, 1, 0, y, 3, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.wool, 1, 0, y, 17, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.wool, 1, 0, y, 19, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.wool, 1, 20, y, 1, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.wool, 1, 20, y, 3, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.wool, 1, 20, y, 17, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.wool, 1, 20, y, 19, structureBoundingBox);
            }
            this.fillWithBlocks(world, structureBoundingBox, 1, 5, 1, 3, 5, 3, Blocks.fence, Blocks.fence, false);
            this.fillWithBlocks(world, structureBoundingBox, 17, 5, 1, 19, 5, 3, Blocks.fence, Blocks.fence, false);
            this.fillWithBlocks(world, structureBoundingBox, 1, 5, 17, 3, 5, 19, Blocks.fence, Blocks.fence, false);
            this.fillWithBlocks(world, structureBoundingBox, 17, 5, 17, 19, 5, 19, Blocks.fence, Blocks.fence, false);
            for (int x = 0; x < 17; x += 16) {
                for (int z = 0; z < 17; z += 16) {
                    for (int k = 0; k < 4; ++k) {
                        if (k % 2 == 0) {
                            this.func_151554_b(world, Blocks.sandstone, 2, k + x, 5, 0 + z, structureBoundingBox);
                            this.func_151554_b(world, Blocks.sandstone, 2, 4 - k + x, 5, 4 + z, structureBoundingBox);
                            this.func_151554_b(world, Blocks.sandstone, 2, 0 + x, 5, 4 - k + z, structureBoundingBox);
                            this.func_151554_b(world, Blocks.sandstone, 2, 4 + x, 5, k + z, structureBoundingBox);
                        }
                        else {
                            this.func_151554_b(world, Blocks.sandstone, 0, k + x, -1, 0 + z, structureBoundingBox);
                            this.func_151554_b(world, Blocks.sandstone, 0, 4 - k + x, -1, 4 + z, structureBoundingBox);
                            this.func_151554_b(world, Blocks.sandstone, 0, 0 + x, -1, 4 - k + z, structureBoundingBox);
                            this.func_151554_b(world, Blocks.sandstone, 0, 4 + x, -1, k + z, structureBoundingBox);
                            this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, k + x, 0, 0 + z, structureBoundingBox);
                            this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 4 - k + x, 0, 4 + z, structureBoundingBox);
                            this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 0 + x, 0, 4 - k + z, structureBoundingBox);
                            this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 4 + x, 0, k + z, structureBoundingBox);
                            this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, k + x, 5, 0 + z, structureBoundingBox);
                            this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 4 - k + x, 5, 4 + z, structureBoundingBox);
                            this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 0 + x, 5, 4 - k + z, structureBoundingBox);
                            this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 4 + x, 5, k + z, structureBoundingBox);
                        }
                        if (k != 0) {
                            this.func_151554_b(world, Blocks.sandstone, 0, x + k, -1, z + 1, structureBoundingBox);
                            this.func_151554_b(world, Blocks.sandstone, 0, x + k, -1, z + 2, structureBoundingBox);
                            this.func_151554_b(world, Blocks.sandstone, 0, x + k, -1, z + 3, structureBoundingBox);
                            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, x + k, 5, z + 1, structureBoundingBox);
                            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, x + k, 5, z + 2, structureBoundingBox);
                            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, x + k, 5, z + 3, structureBoundingBox);
                        }
                    }
                }
            }
            this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 4, 0, 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 1, 4, 1, 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.lapis_block, 0, 4, 2, 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.lapis_block, 0, 4, 3, 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 4, 4, 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 4, 0, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 1, 4, 1, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.lapis_block, 0, 4, 2, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.lapis_block, 0, 4, 3, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 4, 4, 2, structureBoundingBox);
            this.func_151554_b(world, Blocks.sandstone, 2, 4, 4, 3, structureBoundingBox);
            this.func_151554_b(world, Blocks.sandstone, 2, 1, 4, 4, structureBoundingBox);
            this.func_151554_b(world, Blocks.sandstone, 2, 2, 4, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 3, 2, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 3, 3, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 3, 4, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 16, 0, 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 1, 16, 1, 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.lapis_block, 0, 16, 2, 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.lapis_block, 0, 16, 3, 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 16, 4, 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 16, 0, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 1, 16, 1, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.lapis_block, 0, 16, 2, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.lapis_block, 0, 16, 3, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 16, 4, 2, structureBoundingBox);
            this.func_151554_b(world, Blocks.sandstone, 2, 16, 4, 3, structureBoundingBox);
            this.func_151554_b(world, Blocks.sandstone, 2, 19, 4, 4, structureBoundingBox);
            this.func_151554_b(world, Blocks.sandstone, 2, 18, 4, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 17, 2, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 17, 3, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 17, 4, 4, structureBoundingBox);
            this.func_151554_b(world, Blocks.sandstone, 2, 1, 4, 16, structureBoundingBox);
            this.func_151554_b(world, Blocks.sandstone, 2, 2, 4, 16, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 3, 2, 16, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 3, 3, 16, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 3, 4, 16, structureBoundingBox);
            this.func_151554_b(world, Blocks.sandstone, 2, 4, 4, 19, structureBoundingBox);
            this.func_151554_b(world, Blocks.sandstone, 2, 4, 4, 18, structureBoundingBox);
            this.func_151554_b(world, Blocks.sandstone, 2, 4, 4, 17, structureBoundingBox);
            this.func_151554_b(world, Blocks.sandstone, 2, 19, 4, 16, structureBoundingBox);
            this.func_151554_b(world, Blocks.sandstone, 2, 18, 4, 16, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 17, 2, 16, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 17, 3, 16, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 17, 4, 16, structureBoundingBox);
            this.func_151554_b(world, Blocks.sandstone, 2, 16, 4, 19, structureBoundingBox);
            this.func_151554_b(world, Blocks.sandstone, 2, 16, 4, 18, structureBoundingBox);
            this.func_151554_b(world, Blocks.sandstone, 2, 16, 4, 17, structureBoundingBox);
            for (int i = 0; i < 13; ++i) {
                if (i != 0 && i != 12) {
                    if (i % 3 == 0) {
                        this.func_151554_b(world, Blocks.sandstone, 2, 4 + i, 5, 0, structureBoundingBox);
                        this.func_151554_b(world, Blocks.sandstone, 0, 4 + i, -1, 1, structureBoundingBox);
                        this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 4 + i, 3, 1, structureBoundingBox);
                        this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 4 + i, 5, 1, structureBoundingBox);
                        this.func_151554_b(world, Blocks.sandstone, 0, 4 + i, -1, 2, structureBoundingBox);
                        this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 4 + i, 5, 2, structureBoundingBox);
                        this.func_151554_b(world, Blocks.sandstone, 2, 4 + i, 9, 2, structureBoundingBox);
                        this.func_151554_b(world, Blocks.sandstone, 0, 4 + i, -1, 3, structureBoundingBox);
                        this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 4 + i, 5, 3, structureBoundingBox);
                        this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 4 + i, 9, 3, structureBoundingBox);
                        this.func_151554_b(world, Blocks.sandstone, 2, 4 + i, 9, 4, structureBoundingBox);
                        this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 4 + i, 3, 5, structureBoundingBox);
                        this.func_151554_b(world, Blocks.sandstone, 2, 4 + i, 5, 20, structureBoundingBox);
                        this.func_151554_b(world, Blocks.sandstone, 0, 4 + i, -1, 19, structureBoundingBox);
                        this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 4 + i, 3, 19, structureBoundingBox);
                        this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 4 + i, 5, 19, structureBoundingBox);
                        this.func_151554_b(world, Blocks.sandstone, 2, 4 + i, 9, 18, structureBoundingBox);
                        this.func_151554_b(world, Blocks.sandstone, 0, 4 + i, -1, 17, structureBoundingBox);
                        this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 4 + i, 3, 17, structureBoundingBox);
                        this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 4 + i, 5, 17, structureBoundingBox);
                        this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 4 + i, 9, 17, structureBoundingBox);
                        this.func_151554_b(world, Blocks.sandstone, 0, 4 + i, -1, 16, structureBoundingBox);
                        this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 4 + i, 5, 16, structureBoundingBox);
                        this.func_151554_b(world, Blocks.sandstone, 2, 4 + i, 9, 16, structureBoundingBox);
                        this.func_151554_b(world, Blocks.sandstone, 2, 0, 5, 4 + i, structureBoundingBox);
                        this.func_151554_b(world, Blocks.sandstone, 0, 1, -1, 4 + i, structureBoundingBox);
                        this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 1, 3, 4 + i, structureBoundingBox);
                        this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 1, 5, 4 + i, structureBoundingBox);
                        this.func_151554_b(world, Blocks.sandstone, 2, 2, 9, 4 + i, structureBoundingBox);
                        this.func_151554_b(world, Blocks.sandstone, 0, 3, -1, 4 + i, structureBoundingBox);
                        this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 3, 3, 4 + i, structureBoundingBox);
                        this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 3, 5, 4 + i, structureBoundingBox);
                        this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 3, 9, 4 + i, structureBoundingBox);
                        this.func_151554_b(world, Blocks.sandstone, 2, 4, 9, 4 + i, structureBoundingBox);
                        this.func_151554_b(world, Blocks.sandstone, 2, 20, 5, 4 + i, structureBoundingBox);
                        this.func_151554_b(world, Blocks.sandstone, 0, 19, -1, 4 + i, structureBoundingBox);
                        this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 19, 3, 4 + i, structureBoundingBox);
                        this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 19, 5, 4 + i, structureBoundingBox);
                        this.func_151554_b(world, Blocks.sandstone, 2, 18, 9, 4 + i, structureBoundingBox);
                        this.func_151554_b(world, Blocks.sandstone, 0, 17, -1, 4 + i, structureBoundingBox);
                        this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 17, 3, 4 + i, structureBoundingBox);
                        this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 17, 5, 4 + i, structureBoundingBox);
                        this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 17, 9, 4 + i, structureBoundingBox);
                        this.func_151554_b(world, Blocks.sandstone, 2, 16, 9, 4 + i, structureBoundingBox);
                    }
                    else {
                        this.func_151554_b(world, Blocks.sandstone, 0, 4 + i, -1, 0, structureBoundingBox);
                        this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 4 + i, 5, 0, structureBoundingBox);
                        this.func_151554_b(world, Blocks.sandstone, 0, 4 + i, -1, 1, structureBoundingBox);
                        this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 4 + i, 5, 1, structureBoundingBox);
                        this.func_151554_b(world, Blocks.sandstone, 0, 4 + i, -1, 2, structureBoundingBox);
                        this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 4 + i, 5, 2, structureBoundingBox);
                        this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 4 + i, 9, 2, structureBoundingBox);
                        this.func_151554_b(world, Blocks.sandstone, 0, 4 + i, -1, 3, structureBoundingBox);
                        this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 4 + i, 5, 3, structureBoundingBox);
                        this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 4 + i, 9, 3, structureBoundingBox);
                        this.func_151554_b(world, Blocks.sandstone, 2, 4 + i, 0, 4, structureBoundingBox);
                        this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 1, 4 + i, 1, 4, structureBoundingBox);
                        this.func_151554_b(world, Blocks.lapis_block, 0, 4 + i, 3, 4, structureBoundingBox);
                        this.func_151554_b(world, Blocks.sandstone, 1, 4 + i, 5, 4, structureBoundingBox);
                        this.func_151554_b(world, Blocks.fence, 0, 4 + i, 7, 4, structureBoundingBox);
                        this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 1, 4 + i, 8, 4, structureBoundingBox);
                        this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 4 + i, 9, 4, structureBoundingBox);
                        this.func_151554_b(world, Blocks.sandstone, 0, 4 + i, -1, 20, structureBoundingBox);
                        this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 4 + i, 5, 20, structureBoundingBox);
                        this.func_151554_b(world, Blocks.sandstone, 0, 4 + i, -1, 19, structureBoundingBox);
                        this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 4 + i, 5, 19, structureBoundingBox);
                        this.func_151554_b(world, Blocks.sandstone, 2, 4 + i, 0, 18, structureBoundingBox);
                        this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 1, 4 + i, 1, 18, structureBoundingBox);
                        this.func_151554_b(world, Blocks.lapis_block, 0, 4 + i, 3, 18, structureBoundingBox);
                        this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 1, 4 + i, 4, 18, structureBoundingBox);
                        this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 4 + i, 5, 18, structureBoundingBox);
                        this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 4 + i, 9, 18, structureBoundingBox);
                        this.func_151554_b(world, Blocks.sandstone, 0, 4 + i, -1, 17, structureBoundingBox);
                        this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 4 + i, 5, 17, structureBoundingBox);
                        this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 4 + i, 9, 17, structureBoundingBox);
                        this.func_151554_b(world, Blocks.sandstone, 0, 4 + i, -1, 16, structureBoundingBox);
                        this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 1, 4 + i, 5, 16, structureBoundingBox);
                        this.func_151554_b(world, Blocks.fence, 0, 4 + i, 7, 16, structureBoundingBox);
                        this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 1, 4 + i, 8, 16, structureBoundingBox);
                        this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 4 + i, 9, 16, structureBoundingBox);
                        this.func_151554_b(world, Blocks.sandstone, 0, 0, -1, 4 + i, structureBoundingBox);
                        this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 0, 5, 4 + i, structureBoundingBox);
                        this.func_151554_b(world, Blocks.sandstone, 0, 1, -1, 4 + i, structureBoundingBox);
                        this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 1, 5, 4 + i, structureBoundingBox);
                        this.func_151554_b(world, Blocks.sandstone, 2, 2, 0, 4 + i, structureBoundingBox);
                        this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 1, 2, 1, 4 + i, structureBoundingBox);
                        this.func_151554_b(world, Blocks.lapis_block, 0, 2, 3, 4 + i, structureBoundingBox);
                        this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 1, 2, 4, 4 + i, structureBoundingBox);
                        this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 2, 5, 4 + i, structureBoundingBox);
                        this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 2, 9, 4 + i, structureBoundingBox);
                        this.func_151554_b(world, Blocks.sandstone, 0, 3, -1, 4 + i, structureBoundingBox);
                        this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 3, 5, 4 + i, structureBoundingBox);
                        this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 3, 9, 4 + i, structureBoundingBox);
                        this.func_151554_b(world, Blocks.sandstone, 0, 4, -1, 4 + i, structureBoundingBox);
                        this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 1, 4, 5, 4 + i, structureBoundingBox);
                        this.func_151554_b(world, Blocks.lapis_block, 0, 4, 7, 4 + i, structureBoundingBox);
                        this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 1, 4, 8, 4 + i, structureBoundingBox);
                        this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 4, 9, 4 + i, structureBoundingBox);
                        this.func_151554_b(world, Blocks.sandstone, 0, 20, -1, 4 + i, structureBoundingBox);
                        this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 20, 5, 4 + i, structureBoundingBox);
                        this.func_151554_b(world, Blocks.sandstone, 0, 19, -1, 4 + i, structureBoundingBox);
                        this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 19, 5, 4 + i, structureBoundingBox);
                        this.func_151554_b(world, Blocks.sandstone, 2, 18, 0, 4 + i, structureBoundingBox);
                        this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 1, 18, 1, 4 + i, structureBoundingBox);
                        this.func_151554_b(world, Blocks.lapis_block, 0, 18, 3, 4 + i, structureBoundingBox);
                        this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 1, 18, 4, 4 + i, structureBoundingBox);
                        this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 18, 5, 4 + i, structureBoundingBox);
                        this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 18, 9, 4 + i, structureBoundingBox);
                        this.func_151554_b(world, Blocks.sandstone, 0, 17, -1, 4 + i, structureBoundingBox);
                        this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 17, 5, 4 + i, structureBoundingBox);
                        this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 17, 9, 4 + i, structureBoundingBox);
                        this.func_151554_b(world, Blocks.sandstone, 0, 16, -1, 4 + i, structureBoundingBox);
                        this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 1, 16, 5, 4 + i, structureBoundingBox);
                        this.func_151554_b(world, Blocks.lapis_block, 0, 16, 7, 4 + i, structureBoundingBox);
                        this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 1, 16, 8, 4 + i, structureBoundingBox);
                        this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 16, 9, 4 + i, structureBoundingBox);
                    }
                }
                else {
                    this.func_151554_b(world, Blocks.sandstone, 2, 4 + i, 9, 2, structureBoundingBox);
                    this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 4 + i, 9, 3, structureBoundingBox);
                    this.func_151554_b(world, Blocks.sandstone, 2, 4 + i, 9, 4, structureBoundingBox);
                    this.func_151554_b(world, Blocks.sandstone, 2, 4 + i, 9, 18, structureBoundingBox);
                    this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 4 + i, 9, 17, structureBoundingBox);
                    this.func_151554_b(world, Blocks.sandstone, 2, 4 + i, 9, 16, structureBoundingBox);
                    this.func_151554_b(world, Blocks.sandstone, 2, 2, 9, 4 + i, structureBoundingBox);
                    this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 3, 9, 4 + i, structureBoundingBox);
                    this.func_151554_b(world, Blocks.sandstone, 2, 4, 9, 4 + i, structureBoundingBox);
                    this.func_151554_b(world, Blocks.sandstone, 2, 18, 9, 4 + i, structureBoundingBox);
                    this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 17, 9, 4 + i, structureBoundingBox);
                    this.func_151554_b(world, Blocks.sandstone, 2, 16, 9, 4 + i, structureBoundingBox);
                }
            }
            for (int x = 4; x < 17; ++x) {
                for (int z = 4; z < 17; ++z) {
                    if (x == 4 || x == 16 || z == 4 || z == 16) {
                        this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 1, x, 10, z, structureBoundingBox);
                    }
                    else {
                        this.func_151554_b(world, Blocks.sandstone, 0, x, -1, z, structureBoundingBox);
                        if (x == 5 || x == 15 || z == 5 || z == 15) {
                            this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 0, x, 10, z, structureBoundingBox);
                        }
                        else if (x == 6 || x == 14 || z == 6 || z == 14) {
                            this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 0, x, 10, z, structureBoundingBox);
                            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, x, 11, z, structureBoundingBox);
                            this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 1, x, 12, z, structureBoundingBox);
                        }
                        else if (x == 7 || x == 13 || z == 7 || z == 13) {
                            this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 0, x, 12, z, structureBoundingBox);
                        }
                        else {
                            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, x, 12, z, structureBoundingBox);
                        }
                    }
                }
            }
            this.fillWithBlocks(world, structureBoundingBox, 8, 0, 4, 9, 4, 4, Blocks.air, Blocks.air, false);
            this.fillWithBlocks(world, structureBoundingBox, 11, 0, 4, 12, 4, 4, Blocks.air, Blocks.air, false);
            this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 8, 4, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 9, 4, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 11, 4, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.sandstone, 2, 12, 4, 4, structureBoundingBox);
            this.placeDoorAtCurrentPosition(world, structureBoundingBox, random, 3, 0, 4, this.getMetadataWithOffset(Blocks.wooden_door, 1));
            this.placeDoorAtCurrentPosition(world, structureBoundingBox, random, 3, 0, 16, this.getMetadataWithOffset(Blocks.wooden_door, 1));
            this.placeDoorAtCurrentPosition(world, structureBoundingBox, random, 17, 0, 4, this.getMetadataWithOffset(Blocks.wooden_door, 1));
            this.placeDoorAtCurrentPosition(world, structureBoundingBox, random, 17, 0, 16, this.getMetadataWithOffset(Blocks.wooden_door, 1));
            this.spawnEntity(world, structureBoundingBox, 10, 1, 10, 0);
            this.spawnEntity(world, structureBoundingBox, 12, 1, 10, 1);
            this.spawnEntity(world, structureBoundingBox, 8, 1, 10, 1);
            this.spawnEntity(world, structureBoundingBox, 10, 1, 12, 1);
            this.spawnEntity(world, structureBoundingBox, 10, 1, 8, 1);
            return true;
        }
        
        @Override
        protected EntityLiving getNewEntity(final World world, final int choice) {
            switch (choice) {
                case 0: {
                    return (EntityLiving)new EntityEgyptian(world, EnumVillager.EGYPTIAN_PRIEST);
                }
                case 1: {
                    return (EntityLiving)new EntityEgyptian(world, EnumVillager.EGYPTIAN_GUARD);
                }
                default: {
                    return null;
                }
            }
        }
    }
    
    public static class Field2 extends GlobalField
    {
        public Field2() {
        }
        
        public Field2(final StructureVillagePieces.Start startPiece, final int componentType, final Random random, final StructureBoundingBox structureBoundingBox, final int coordBaseMode) {
            super(EnumVillagePiece.EGYPTIAN_FIELD2, startPiece, componentType, random, structureBoundingBox, coordBaseMode);
            this.setOffset(2);
        }
        
        public static Field2 buildComponent(final StructureVillagePieces.Start villagePiece, final List pieces, final Random random, final int x, final int y, final int z, final int coordBaseMode, final int p5) {
            final StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(x, y, z, 0, 0, 0, 9, 4, 10, coordBaseMode);
            return (canVillageGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(pieces, structureboundingbox) == null) ? new Field2(villagePiece, p5, random, structureboundingbox, coordBaseMode) : null;
        }
        
        @Override
        protected Block getCropType(final Random random) {
            return null;
        }
        
        @Override
        public boolean build(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
            for (int x = 0; x < 8; ++x) {
                for (int z = 0; z < 9; ++z) {
                    this.clearCurrentPositionBlocksUpwards(world, x, 0, z, structureBoundingBox);
                    this.func_151554_b(world, Blocks.sandstone, 0, x, -1, z, structureBoundingBox);
                }
            }
            this.fillWithBlocks(world, structureBoundingBox, 0, 1, 0, 6, 4, 8, Blocks.air, Blocks.air, false);
            this.fillWithBlocks(world, structureBoundingBox, 1, 0, 1, 1, 0, 7, (Block)Blocks.sand, (Block)Blocks.sand, false);
            this.fillWithBlocks(world, structureBoundingBox, 3, 0, 1, 4, 0, 7, (Block)Blocks.sand, (Block)Blocks.sand, false);
            this.fillWithBlocks(world, structureBoundingBox, 6, 0, 1, 6, 0, 7, (Block)Blocks.sand, (Block)Blocks.sand, false);
            this.fillWithBlocks(world, structureBoundingBox, 0, 0, 0, 0, 0, 8, Blocks.sandstone, Blocks.sandstone, false);
            this.fillWithBlocks(world, structureBoundingBox, 7, 0, 0, 7, 0, 8, Blocks.sandstone, Blocks.sandstone, false);
            this.fillWithBlocks(world, structureBoundingBox, 1, 0, 0, 6, 0, 0, Blocks.sandstone, Blocks.sandstone, false);
            this.fillWithBlocks(world, structureBoundingBox, 1, 0, 8, 6, 0, 8, Blocks.sandstone, Blocks.sandstone, false);
            this.fillWithBlocks(world, structureBoundingBox, 2, 0, 1, 2, 0, 7, Blocks.water, Blocks.water, false);
            this.fillWithBlocks(world, structureBoundingBox, 5, 0, 1, 5, 0, 7, Blocks.water, Blocks.water, false);
            for (int z2 = 1; z2 <= 7; ++z2) {
                this.placeBlockAtCurrentPosition(world, Blocks.reeds, 0, 1, 1, z2, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.reeds, 0, 3, 1, z2, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.reeds, 0, 4, 1, z2, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.reeds, 0, 6, 1, z2, structureBoundingBox);
                if (random.nextBoolean()) {
                    this.placeBlockAtCurrentPosition(world, Blocks.reeds, 0, 1, 2, z2, structureBoundingBox);
                    if (random.nextBoolean()) {
                        this.placeBlockAtCurrentPosition(world, Blocks.reeds, 0, 1, 3, z2, structureBoundingBox);
                    }
                }
                if (random.nextBoolean()) {
                    this.placeBlockAtCurrentPosition(world, Blocks.reeds, 0, 3, 2, z2, structureBoundingBox);
                    if (random.nextBoolean()) {
                        this.placeBlockAtCurrentPosition(world, Blocks.reeds, 0, 3, 3, z2, structureBoundingBox);
                    }
                }
                if (random.nextBoolean()) {
                    this.placeBlockAtCurrentPosition(world, Blocks.reeds, 0, 4, 2, z2, structureBoundingBox);
                    if (random.nextBoolean()) {
                        this.placeBlockAtCurrentPosition(world, Blocks.reeds, 0, 4, 3, z2, structureBoundingBox);
                    }
                }
                if (random.nextBoolean()) {
                    this.placeBlockAtCurrentPosition(world, Blocks.reeds, 0, 6, 2, z2, structureBoundingBox);
                    if (random.nextBoolean()) {
                        this.placeBlockAtCurrentPosition(world, Blocks.reeds, 0, 6, 3, z2, structureBoundingBox);
                    }
                }
            }
            this.spawnEntity(world, structureBoundingBox, 4, 2, 4, 0);
            this.spawnEntity(world, structureBoundingBox, 4, 2, 4, 0);
            return true;
        }
        
        @Override
        protected EntityLiving getNewEntity(final World world, final int choice) {
            return (EntityLiving)new EntityEgyptian(world, EnumVillager.EGYPTIAN_FARMER);
        }
    }
}
