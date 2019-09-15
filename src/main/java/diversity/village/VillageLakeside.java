// 
// Decompiled by Procyon v0.5.36
// 

package diversity.village;

import net.minecraft.util.MathHelper;
import net.minecraft.entity.passive.EntityPig;
import diversity.entity.EntityLakeside;
import diversity.suppliers.EnumVillager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.world.gen.structure.StructureComponent;
import diversity.suppliers.IEnumPiece;
import diversity.suppliers.EnumVillagePiece;
import diversity.suppliers.EnumVillageBasicPiece;
import diversity.utils.DirectionTools;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureVillagePieces;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import java.util.List;
import java.util.Random;
import net.minecraft.world.biome.WorldChunkManager;
import diversity.suppliers.EnumVillage;

public class VillageLakeside extends VillageTools
{
    private static VillageLakeside instance;
    
    public VillageLakeside(final EnumVillage ENUM) {
        super(ENUM);
        VillageLakeside.instance = this;
    }
    
    @Override
    public GlobalStart getStart(final WorldChunkManager worldChunkManager, final int i, final Random rand, final int j, final int k, final List list, final int numberOfVillagers) {
        return new Start(worldChunkManager, i, rand, j, k, list, numberOfVillagers);
    }
    
    @Override
    protected GlobalTorch getTorch(final GlobalStart villagePiece, final int par2, final Random rand, final StructureBoundingBox boundingBox, final int coordBaseMode) {
        return new Torch(villagePiece, par2, rand, boundingBox, coordBaseMode);
    }
    
    @Override
    protected GlobalPath getPath(final GlobalStart p_75080_0_, final int p_75080_7_, final Random p_75080_2_, final StructureBoundingBox structureboundingbox, final int p_75080_6_) {
        return new Path(p_75080_0_, p_75080_7_, p_75080_2_, structureboundingbox, p_75080_6_);
    }
    
    public static class Start extends GlobalStart
    {
        public Start() {
        }
        
        public Start(final WorldChunkManager p_i2104_1_, final int p_i2104_2_, final Random p_i2104_3_, final int p_i2104_4_, final int p_i2104_5_, final List p_i2104_6_, final int p_i2104_7_) {
            super(VillageLakeside.instance, p_i2104_1_, p_i2104_2_, p_i2104_3_, p_i2104_4_, p_i2104_5_, p_i2104_6_, p_i2104_7_);
            this.coordBaseMode = 2;
        }
        
        @Override
        public boolean addComponentParts(final World world, final Random rand, final StructureBoundingBox structureBoundingBox) {
            if (super.addComponentParts(world, rand, structureBoundingBox, 2)) {
                return true;
            }
            for (int x = 0; x <= 5; ++x) {
                for (int z = 0; z <= 5; ++z) {
                    this.clearCurrentPositionBlocksUpwards(world, x, 11, z, structureBoundingBox);
                }
            }
            this.fillWithMetadataBlocks(world, structureBoundingBox, 1, 12, 2, 4, 12, 3, (Block)Blocks.wooden_slab, 9, (Block)Blocks.wooden_slab, 9, false);
            this.fillWithMetadataBlocks(world, structureBoundingBox, 2, 12, 1, 3, 12, 4, (Block)Blocks.wooden_slab, 9, (Block)Blocks.wooden_slab, 9, false);
            this.func_151554_b(world, Blocks.log, 0, 0, 13, 0, structureBoundingBox);
            this.func_151554_b(world, Blocks.log, 0, 0, 13, 5, structureBoundingBox);
            this.func_151554_b(world, Blocks.log, 0, 5, 13, 0, structureBoundingBox);
            this.func_151554_b(world, Blocks.log, 0, 5, 13, 5, structureBoundingBox);
            this.func_151554_b(world, Blocks.log, 0, 1, 15, 1, structureBoundingBox);
            this.func_151554_b(world, Blocks.log, 0, 1, 15, 4, structureBoundingBox);
            this.func_151554_b(world, Blocks.log, 0, 4, 15, 1, structureBoundingBox);
            this.func_151554_b(world, Blocks.log, 0, 4, 15, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 0, 14, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 0, 14, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 5, 14, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 5, 14, 5, structureBoundingBox);
            for (int k = 1; k < 5; ++k) {
                this.placeBlockAtCurrentPosition(world, Blocks.log, DirectionTools.log[this.coordBaseMode][1], 0, 12, k, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.log, DirectionTools.log[this.coordBaseMode][1], 5, 12, k, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.log, DirectionTools.log[this.coordBaseMode][0], k, 12, 0, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.log, DirectionTools.log[this.coordBaseMode][0], k, 12, 5, structureBoundingBox);
                if (k == 2 || k == 3) {
                    this.placeBlockAtCurrentPosition(world, Blocks.log, DirectionTools.log[this.coordBaseMode][0], k, 15, 1, structureBoundingBox);
                    this.placeBlockAtCurrentPosition(world, Blocks.log, DirectionTools.log[this.coordBaseMode][0], k, 15, 4, structureBoundingBox);
                    this.placeBlockAtCurrentPosition(world, Blocks.log, DirectionTools.log[this.coordBaseMode][1], 1, 15, k, structureBoundingBox);
                    this.placeBlockAtCurrentPosition(world, Blocks.log, DirectionTools.log[this.coordBaseMode][1], 4, 15, k, structureBoundingBox);
                }
            }
            this.fillWithMetadataBlocks(world, structureBoundingBox, 0, 15, 0, 0, 15, 4, Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][0], Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][0], false);
            this.fillWithMetadataBlocks(world, structureBoundingBox, 0, 15, 5, 4, 15, 5, Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][2], Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][2], false);
            this.fillWithMetadataBlocks(world, structureBoundingBox, 5, 15, 1, 5, 15, 5, Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][1], Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][1], false);
            this.fillWithMetadataBlocks(world, structureBoundingBox, 1, 15, 0, 5, 15, 0, Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][3], Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][3], false);
            this.fillWithMetadataBlocks(world, structureBoundingBox, 1, 16, 1, 4, 16, 4, (Block)Blocks.wooden_slab, 0, (Block)Blocks.wooden_slab, 0, false);
            this.fillWithMetadataBlocks(world, structureBoundingBox, 2, 16, 2, 3, 16, 3, (Block)Blocks.wooden_slab, 8, (Block)Blocks.wooden_slab, 8, false);
            return true;
        }
    }
    
    public static class Path extends GlobalPath
    {
        public Path() {
        }
        
        public Path(final GlobalStart p_i2105_1_, final int p_i2105_2_, final Random p_i2105_3_, final StructureBoundingBox p_i2105_4_, final int p_i2105_5_) {
            super(VillageLakeside.instance, p_i2105_1_, p_i2105_2_, p_i2105_3_, p_i2105_4_, p_i2105_5_);
        }
        
        @Override
        protected BlockData getPathBlock(final Random random) {
            return new BlockData(Blocks.gravel, 0);
        }
        
        @Override
        protected BlockData getPathBridge(final Random random) {
            return new BlockData((Block)Blocks.wooden_slab, 1);
        }
        
        @Override
        protected BlockData getUnderPathBlock(final Random random) {
            return new BlockData(Blocks.dirt, 0);
        }
        
        @Override
        public boolean addComponentParts(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
            for (int x = this.boundingBox.minX; x <= this.boundingBox.maxX; ++x) {
                for (int z = this.boundingBox.minZ; z <= this.boundingBox.maxZ; ++z) {
                    if (structureBoundingBox.isVecInside(x, 64, z)) {
                        int y = world.getTopSolidOrLiquidBlock(x, z) - 1;
                        if (y < 64) {
                            boolean isSupport = false;
                            switch (this.coordBaseMode) {
                                case 1:
                                case 3: {
                                    isSupport = (x % 4 == 0 && (z == this.boundingBox.minZ || z == this.boundingBox.maxZ) && random.nextBoolean());
                                    break;
                                }
                                case 0:
                                case 2: {
                                    isSupport = (z % 4 == 0 && (x == this.boundingBox.minX || x == this.boundingBox.maxX) && random.nextBoolean());
                                    break;
                                }
                            }
                            if (isSupport) {
                                y = 64;
                                while (isSupport) {
                                    if (world.isAirBlock(x, y, z) || world.getBlock(x, y, z).getMaterial().isLiquid()) {
                                        world.setBlock(x, y, z, Blocks.log, 0, 2);
                                    }
                                    else {
                                        isSupport = false;
                                    }
                                    --y;
                                    if (y == 50) {
                                        isSupport = false;
                                    }
                                }
                            }
                            else {
                                world.setBlock(x, 64, z, (Block)Blocks.wooden_slab, 9, 2);
                            }
                        }
                        else {
                            final BlockData blockData = this.getPathBlock(random);
                            world.setBlock(x, y, z, blockData.block, blockData.metaData, 2);
                        }
                    }
                }
            }
            return true;
        }
    }
    
    public static class Torch extends GlobalTorch
    {
        public Torch() {
        }
        
        public Torch(final StructureVillagePieces.Start startPiece, final int componentType, final Random random, final StructureBoundingBox structureBoundingBox, final int coordBaseMode) {
            super(EnumVillageBasicPiece.LAKE_TORCH, startPiece, componentType, random, structureBoundingBox, coordBaseMode);
            this.setOffset(3);
        }
        
        @Override
        public boolean build(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
            this.fillWithMetadataBlocks(world, structureBoundingBox, 0, -2, 0, 2, -2, 1, (Block)Blocks.wooden_slab, 9, (Block)Blocks.wooden_slab, 9, false);
            this.placeBlockAtCurrentPosition(world, Blocks.air, 1, 1, -2, 1, structureBoundingBox);
            this.func_151554_b(world, Blocks.log, 0, 0, 1, 0, structureBoundingBox);
            for (int k = -1; k < 2; ++k) {
                this.placeBlockAtCurrentPosition(world, Blocks.ladder, this.getMetadataWithOffset(Blocks.ladder, 4), 0, k, 1, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.ladder, this.getMetadataWithOffset(Blocks.ladder, 2), 2, k, 1, structureBoundingBox);
            }
            this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 1, 2, 1, structureBoundingBox);
            return true;
        }
    }
    
    public static class House1 extends GlobalVillage
    {
        public House1() {
        }
        
        public House1(final StructureVillagePieces.Start villagePiece, final int componentType, final Random random, final StructureBoundingBox structureBoundingBox, final int coordBaseMode) {
            super(EnumVillagePiece.LAKESIDE_HOUSE1, villagePiece, componentType, structureBoundingBox, coordBaseMode);
            this.setOffset(3);
        }
        
        public static House1 buildComponent(final StructureVillagePieces.Start villagePiece, final List pieces, final Random random, final int x, final int y, final int z, final int coordBaseMode, final int p5) {
            final StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(x, y, z, 0, 0, 0, 7, 4, 6, coordBaseMode);
            return (canVillageGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(pieces, structureboundingbox) == null) ? new House1(villagePiece, p5, random, structureboundingbox, coordBaseMode) : null;
        }
        
        @Override
        public boolean build(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
            for (int x = 0; x < 7; ++x) {
                for (int z = 0; z < 7; ++z) {
                    this.clearCurrentPositionBlocksUpwards(world, x, -1, z, structureBoundingBox);
                }
            }
            this.func_151554_b(world, Blocks.log, 0, 1, 3, 1, structureBoundingBox);
            this.func_151554_b(world, Blocks.log, 0, 5, 3, 1, structureBoundingBox);
            this.func_151554_b(world, Blocks.log, 0, 1, 3, 5, structureBoundingBox);
            this.func_151554_b(world, Blocks.log, 0, 5, 3, 5, structureBoundingBox);
            for (int k = 0; k < 3; ++k) {
                this.placeBlockAtCurrentPosition(world, Blocks.log, DirectionTools.log[this.coordBaseMode][0], 2 + k, 0, 1, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.log, DirectionTools.log[this.coordBaseMode][0], 2 + k, 0, 5, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.log, DirectionTools.log[this.coordBaseMode][0], 2 + k, 3, 1, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.log, DirectionTools.log[this.coordBaseMode][0], 2 + k, 3, 5, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.log, DirectionTools.log[this.coordBaseMode][1], 1, 0, 2 + k, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.log, DirectionTools.log[this.coordBaseMode][1], 5, 0, 2 + k, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.log, DirectionTools.log[this.coordBaseMode][1], 1, 3, 2 + k, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.log, DirectionTools.log[this.coordBaseMode][1], 5, 3, 2 + k, structureBoundingBox);
            }
            this.fillWithMetadataBlocks(world, structureBoundingBox, 2, 1, 1, 4, 2, 1, Blocks.planks, 1, Blocks.planks, 1, false);
            this.fillWithMetadataBlocks(world, structureBoundingBox, 2, 1, 5, 4, 2, 5, Blocks.planks, 1, Blocks.planks, 1, false);
            this.fillWithMetadataBlocks(world, structureBoundingBox, 1, 1, 2, 1, 2, 4, Blocks.planks, 1, Blocks.planks, 1, false);
            this.fillWithMetadataBlocks(world, structureBoundingBox, 5, 1, 2, 5, 2, 4, Blocks.planks, 1, Blocks.planks, 1, false);
            this.fillWithMetadataBlocks(world, structureBoundingBox, 2, 0, 2, 4, 0, 4, (Block)Blocks.wooden_slab, 9, (Block)Blocks.wooden_slab, 9, false);
            this.fillWithMetadataBlocks(world, structureBoundingBox, 1, 0, 0, 5, 0, 0, (Block)Blocks.wooden_slab, 9, (Block)Blocks.wooden_slab, 9, false);
            this.fillWithMetadataBlocks(world, structureBoundingBox, 0, 3, 0, 0, 3, 5, Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][0], Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][0], false);
            this.fillWithMetadataBlocks(world, structureBoundingBox, 0, 3, 6, 5, 3, 6, Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][2], Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][2], false);
            this.fillWithMetadataBlocks(world, structureBoundingBox, 6, 3, 1, 6, 3, 6, Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][1], Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][1], false);
            this.fillWithMetadataBlocks(world, structureBoundingBox, 1, 3, 0, 6, 3, 0, Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][3], Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][3], false);
            this.fillWithMetadataBlocks(world, structureBoundingBox, 1, 4, 1, 5, 4, 5, (Block)Blocks.wooden_slab, 0, (Block)Blocks.wooden_slab, 0, false);
            this.fillWithMetadataBlocks(world, structureBoundingBox, 2, 4, 2, 4, 4, 4, (Block)Blocks.wooden_slab, 8, (Block)Blocks.wooden_slab, 8, false);
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 1, 2, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 5, 2, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 3, 2, 5, structureBoundingBox);
            this.placeDoorAtCurrentPosition(world, structureBoundingBox, random, 3, 1, 1, this.getMetadataWithOffset(Blocks.wooden_door, 1));
            this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 3, 3, 2, structureBoundingBox);
            this.spawnEntity(world, structureBoundingBox, 3, 1, 3, 0);
            this.spawnEntity(world, structureBoundingBox, 3, 1, 3, 0);
            return true;
        }
        
        @Override
        protected EntityLiving getNewEntity(final World world, final int choice) {
            return (EntityLiving)new EntityLakeside(world, EnumVillager.LAKESIDE_FISHERMAN);
        }
    }
    
    public static class House2 extends GlobalVillage
    {
        public House2() {
        }
        
        public House2(final StructureVillagePieces.Start villagePiece, final int componentType, final Random random, final StructureBoundingBox structureBoundingBox, final int coordBaseMode) {
            super(EnumVillagePiece.LAKESIDE_HOUSE2, villagePiece, componentType, structureBoundingBox, coordBaseMode);
            this.setOffset(4);
        }
        
        public static House2 buildComponent(final StructureVillagePieces.Start villagePiece, final List pieces, final Random random, final int x, final int y, final int z, final int coordBaseMode, final int p5) {
            final StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(x, y, z, 0, 0, 0, 8, 4, 6, coordBaseMode);
            return (canVillageGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(pieces, structureboundingbox) == null) ? new House2(villagePiece, p5, random, structureboundingbox, coordBaseMode) : null;
        }
        
        @Override
        public boolean build(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
            for (int x = 0; x < 8; ++x) {
                for (int z = 0; z < 7; ++z) {
                    this.clearCurrentPositionBlocksUpwards(world, x, -1, z, structureBoundingBox);
                }
            }
            this.func_151554_b(world, Blocks.log, 0, 1, 3, 1, structureBoundingBox);
            this.func_151554_b(world, Blocks.log, 0, 6, 3, 1, structureBoundingBox);
            this.func_151554_b(world, Blocks.log, 0, 1, 3, 5, structureBoundingBox);
            this.func_151554_b(world, Blocks.log, 0, 6, 3, 5, structureBoundingBox);
            for (int k = 0; k < 4; ++k) {
                this.placeBlockAtCurrentPosition(world, Blocks.log, DirectionTools.log[this.coordBaseMode][0], 2 + k, 0, 1, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.log, DirectionTools.log[this.coordBaseMode][0], 2 + k, 0, 5, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.log, DirectionTools.log[this.coordBaseMode][0], 2 + k, 3, 1, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.log, DirectionTools.log[this.coordBaseMode][0], 2 + k, 3, 5, structureBoundingBox);
                if (k != 3) {
                    this.placeBlockAtCurrentPosition(world, Blocks.log, DirectionTools.log[this.coordBaseMode][1], 1, 0, 2 + k, structureBoundingBox);
                    this.placeBlockAtCurrentPosition(world, Blocks.log, DirectionTools.log[this.coordBaseMode][1], 6, 0, 2 + k, structureBoundingBox);
                    this.placeBlockAtCurrentPosition(world, Blocks.log, DirectionTools.log[this.coordBaseMode][1], 1, 3, 2 + k, structureBoundingBox);
                    this.placeBlockAtCurrentPosition(world, Blocks.log, DirectionTools.log[this.coordBaseMode][1], 6, 3, 2 + k, structureBoundingBox);
                }
            }
            this.fillWithMetadataBlocks(world, structureBoundingBox, 2, 1, 1, 5, 2, 1, Blocks.planks, 1, Blocks.planks, 1, false);
            this.fillWithMetadataBlocks(world, structureBoundingBox, 2, 1, 5, 5, 2, 5, Blocks.planks, 1, Blocks.planks, 1, false);
            this.fillWithMetadataBlocks(world, structureBoundingBox, 1, 1, 2, 1, 2, 4, Blocks.planks, 1, Blocks.planks, 1, false);
            this.fillWithMetadataBlocks(world, structureBoundingBox, 6, 1, 2, 6, 2, 4, Blocks.planks, 1, Blocks.planks, 1, false);
            this.fillWithMetadataBlocks(world, structureBoundingBox, 2, 0, 2, 5, 0, 4, (Block)Blocks.wooden_slab, 9, (Block)Blocks.wooden_slab, 9, false);
            this.fillWithMetadataBlocks(world, structureBoundingBox, 1, -1, 0, 6, -1, 0, (Block)Blocks.wooden_slab, 9, (Block)Blocks.wooden_slab, 9, false);
            this.placeBlockAtCurrentPosition(world, Blocks.spruce_stairs, DirectionTools.stair[this.coordBaseMode][0], 3, 0, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.spruce_stairs, DirectionTools.stair[this.coordBaseMode][3], 4, 0, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.spruce_stairs, DirectionTools.stair[this.coordBaseMode][1], 5, 0, 0, structureBoundingBox);
            this.fillWithMetadataBlocks(world, structureBoundingBox, 0, 3, 0, 0, 3, 5, Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][0], Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][0], false);
            this.fillWithMetadataBlocks(world, structureBoundingBox, 0, 3, 6, 6, 3, 6, Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][2], Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][2], false);
            this.fillWithMetadataBlocks(world, structureBoundingBox, 7, 3, 1, 7, 3, 6, Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][1], Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][1], false);
            this.fillWithMetadataBlocks(world, structureBoundingBox, 1, 3, 0, 7, 3, 0, Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][3], Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][3], false);
            this.fillWithMetadataBlocks(world, structureBoundingBox, 1, 4, 1, 6, 4, 5, (Block)Blocks.wooden_slab, 0, (Block)Blocks.wooden_slab, 0, false);
            this.fillWithMetadataBlocks(world, structureBoundingBox, 2, 4, 2, 5, 4, 4, (Block)Blocks.wooden_slab, 8, (Block)Blocks.wooden_slab, 8, false);
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 1, 2, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 6, 2, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 3, 2, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 4, 2, 5, structureBoundingBox);
            this.placeDoorAtCurrentPosition(world, structureBoundingBox, random, 4, 1, 1, this.getMetadataWithOffset(Blocks.wooden_door, 1));
            this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 4, 3, 2, structureBoundingBox);
            this.spawnEntity(world, structureBoundingBox, 3, 1, 3, 0);
            return true;
        }
        
        @Override
        protected EntityLiving getNewEntity(final World world, final int choice) {
            return (EntityLiving)new EntityLakeside(world, EnumVillager.LAKESIDE_CHIEF);
        }
    }
    
    public static class Tower extends GlobalVillage
    {
        public Tower() {
        }
        
        public Tower(final StructureVillagePieces.Start villagePiece, final int componentType, final Random random, final StructureBoundingBox structureBoundingBox, final int coordBaseMode) {
            super(EnumVillagePiece.LAKESIDE_TOWER, villagePiece, componentType, structureBoundingBox, coordBaseMode);
            this.setOffset(7);
        }
        
        public static Tower buildComponent(final StructureVillagePieces.Start villagePiece, final List pieces, final Random random, final int x, final int y, final int z, final int coordBaseMode, final int p5) {
            final StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(x, y, z, 0, 0, 0, 6, 7, 5, coordBaseMode);
            return (canVillageGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(pieces, structureboundingbox) == null) ? new Tower(villagePiece, p5, random, structureboundingbox, coordBaseMode) : null;
        }
        
        @Override
        public boolean build(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
            for (int x = 0; x < 6; ++x) {
                for (int z = 0; z < 6; ++z) {
                    this.clearCurrentPositionBlocksUpwards(world, x, -2, z, structureBoundingBox);
                }
            }
            this.func_151554_b(world, Blocks.log, 0, 1, 6, 1, structureBoundingBox);
            this.func_151554_b(world, Blocks.log, 0, 4, 6, 1, structureBoundingBox);
            this.func_151554_b(world, Blocks.log, 0, 1, 6, 4, structureBoundingBox);
            this.func_151554_b(world, Blocks.log, 0, 4, 6, 4, structureBoundingBox);
            this.func_151554_b(world, Blocks.log, 0, 5, 0, 1, structureBoundingBox);
            this.func_151554_b(world, Blocks.log, 0, 5, -2, 5, structureBoundingBox);
            this.func_151554_b(world, Blocks.log, 0, 3, -3, 5, structureBoundingBox);
            for (int k = 0; k < 2; ++k) {
                this.placeBlockAtCurrentPosition(world, Blocks.log, DirectionTools.log[this.coordBaseMode][0], 2 + k, 0, 1, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.log, DirectionTools.log[this.coordBaseMode][0], 2 + k, 0, 4, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.log, DirectionTools.log[this.coordBaseMode][0], 2 + k, 3, 1, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.log, DirectionTools.log[this.coordBaseMode][0], 2 + k, 3, 4, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.log, DirectionTools.log[this.coordBaseMode][0], 2 + k, 6, 1, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.log, DirectionTools.log[this.coordBaseMode][0], 2 + k, 6, 4, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.log, DirectionTools.log[this.coordBaseMode][1], 1, 0, 2 + k, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.log, DirectionTools.log[this.coordBaseMode][1], 4, 0, 2 + k, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.log, DirectionTools.log[this.coordBaseMode][1], 1, 3, 2 + k, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.log, DirectionTools.log[this.coordBaseMode][1], 4, 3, 2 + k, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.log, DirectionTools.log[this.coordBaseMode][1], 1, 6, 2 + k, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.log, DirectionTools.log[this.coordBaseMode][1], 4, 6, 2 + k, structureBoundingBox);
            }
            this.fillWithMetadataBlocks(world, structureBoundingBox, 2, 1, 1, 3, 2, 1, Blocks.planks, 1, Blocks.planks, 1, false);
            this.fillWithMetadataBlocks(world, structureBoundingBox, 2, 1, 4, 3, 2, 4, Blocks.planks, 1, Blocks.planks, 1, false);
            this.fillWithMetadataBlocks(world, structureBoundingBox, 1, 1, 2, 1, 2, 3, Blocks.planks, 1, Blocks.planks, 1, false);
            this.fillWithMetadataBlocks(world, structureBoundingBox, 4, 1, 2, 4, 2, 3, Blocks.planks, 1, Blocks.planks, 1, false);
            this.fillWithMetadataBlocks(world, structureBoundingBox, 2, 4, 1, 3, 5, 1, Blocks.planks, 1, Blocks.planks, 1, false);
            this.fillWithMetadataBlocks(world, structureBoundingBox, 2, 4, 4, 3, 5, 4, Blocks.planks, 1, Blocks.planks, 1, false);
            this.fillWithMetadataBlocks(world, structureBoundingBox, 1, 4, 2, 1, 5, 3, Blocks.planks, 1, Blocks.planks, 1, false);
            this.fillWithMetadataBlocks(world, structureBoundingBox, 4, 4, 2, 4, 5, 3, Blocks.planks, 1, Blocks.planks, 1, false);
            this.fillWithMetadataBlocks(world, structureBoundingBox, 2, 0, 2, 3, 0, 3, (Block)Blocks.wooden_slab, 9, (Block)Blocks.wooden_slab, 9, false);
            this.fillWithMetadataBlocks(world, structureBoundingBox, 1, -1, 0, 4, -1, 0, (Block)Blocks.wooden_slab, 9, (Block)Blocks.wooden_slab, 9, false);
            this.placeBlockAtCurrentPosition(world, Blocks.spruce_stairs, DirectionTools.stair[this.coordBaseMode][0], 1, 0, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.spruce_stairs, DirectionTools.stair[this.coordBaseMode][3], 2, 0, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.spruce_stairs, DirectionTools.stair[this.coordBaseMode][1], 3, 0, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 5, 1, 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, (Block)Blocks.wooden_slab, 9, 5, 0, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.spruce_stairs, DirectionTools.stair[this.coordBaseMode][2], 5, 0, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.spruce_stairs, DirectionTools.stair[this.coordBaseMode][2], 5, -1, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.spruce_stairs, DirectionTools.stair[this.coordBaseMode][0], 4, -2, 5, structureBoundingBox);
            this.fillWithMetadataBlocks(world, structureBoundingBox, 2, 3, 2, 3, 3, 3, (Block)Blocks.wooden_slab, 9, (Block)Blocks.wooden_slab, 9, false);
            this.fillWithMetadataBlocks(world, structureBoundingBox, 1, 3, 0, 4, 3, 0, (Block)Blocks.wooden_slab, 9, (Block)Blocks.wooden_slab, 9, false);
            this.fillWithMetadataBlocks(world, structureBoundingBox, 0, 3, 1, 0, 3, 4, (Block)Blocks.wooden_slab, 9, (Block)Blocks.wooden_slab, 9, false);
            this.fillWithMetadataBlocks(world, structureBoundingBox, 1, 3, 5, 4, 3, 5, (Block)Blocks.wooden_slab, 9, (Block)Blocks.wooden_slab, 9, false);
            this.fillWithMetadataBlocks(world, structureBoundingBox, 5, 3, 1, 5, 3, 4, (Block)Blocks.wooden_slab, 9, (Block)Blocks.wooden_slab, 9, false);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 0, 4, 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 0, 5, 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 0, 4, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 0, 5, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 5, 4, 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 5, 5, 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 5, 4, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 5, 5, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 1, 4, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 1, 5, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 4, 4, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 4, 5, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 1, 4, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 1, 5, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 4, 4, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 4, 5, 5, structureBoundingBox);
            this.fillWithMetadataBlocks(world, structureBoundingBox, 0, 6, 0, 0, 6, 4, Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][0], Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][0], false);
            this.fillWithMetadataBlocks(world, structureBoundingBox, 0, 6, 5, 4, 6, 5, Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][2], Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][2], false);
            this.fillWithMetadataBlocks(world, structureBoundingBox, 5, 6, 1, 5, 6, 5, Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][1], Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][1], false);
            this.fillWithMetadataBlocks(world, structureBoundingBox, 1, 6, 0, 5, 6, 0, Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][3], Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][3], false);
            this.fillWithMetadataBlocks(world, structureBoundingBox, 1, 7, 1, 4, 7, 4, (Block)Blocks.wooden_slab, 0, (Block)Blocks.wooden_slab, 0, false);
            this.fillWithMetadataBlocks(world, structureBoundingBox, 2, 7, 2, 3, 7, 3, (Block)Blocks.wooden_slab, 8, (Block)Blocks.wooden_slab, 8, false);
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 1, 2, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 2, 2, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 3, 3, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 1, 4, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 1, 5, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 3, 4, 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 3, 5, 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 4, 4, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 4, 5, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 2, 4, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 2, 5, 4, structureBoundingBox);
            for (int k = 1; k < 4; ++k) {
                this.placeBlockAtCurrentPosition(world, Blocks.ladder, this.getMetadataWithOffset(Blocks.ladder, 4), 3, k, 3, structureBoundingBox);
            }
            this.placeDoorAtCurrentPosition(world, structureBoundingBox, random, 2, 1, 1, this.getMetadataWithOffset(Blocks.wooden_door, 1));
            this.placeDoorAtCurrentPosition(world, structureBoundingBox, random, 4, 1, 2, this.getMetadataWithOffset(Blocks.wooden_door, 2));
            this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 2, 2, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 2, 5, 2, structureBoundingBox);
            this.spawnEntity(world, structureBoundingBox, 3, 1, 3, 0);
            this.spawnEntity(world, structureBoundingBox, 3, 1, 3, 0);
            this.spawnEntity(world, structureBoundingBox, 3, 4, 3, 0);
            return true;
        }
        
        @Override
        protected EntityLiving getNewEntity(final World world, final int choice) {
            return (EntityLiving)new EntityLakeside(world, EnumVillager.LAKESIDE_GUARD);
        }
    }
    
    public static class Breeding extends GlobalVillage
    {
        private static Planks randomSwampPlanks;
        
        public Breeding() {
        }
        
        public Breeding(final StructureVillagePieces.Start villagePiece, final int componentType, final Random random, final StructureBoundingBox structureBoundingBox, final int coordBaseMode) {
            super(EnumVillagePiece.LAKESIDE_BREEDING, villagePiece, componentType, structureBoundingBox, coordBaseMode);
            this.setOffset(4);
        }
        
        public static Breeding buildComponent(final StructureVillagePieces.Start villagePiece, final List pieces, final Random random, final int x, final int y, final int z, final int coordBaseMode, final int p5) {
            final StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(x, y, z, 0, 0, 0, 10, 4, 8, coordBaseMode);
            return (canVillageGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(pieces, structureboundingbox) == null) ? new Breeding(villagePiece, p5, random, structureboundingbox, coordBaseMode) : null;
        }
        
        @Override
        public boolean build(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
            for (int x = 0; x < 10; ++x) {
                for (int z = 0; z < 9; ++z) {
                    this.clearCurrentPositionBlocksUpwards(world, x, -2, z, structureBoundingBox);
                }
            }
            this.fillWithRandomizedBlocks(world, structureBoundingBox, 0, -6, 2, 0, -3, 7, false, random, (StructureComponent.BlockSelector)Breeding.randomSwampPlanks);
            this.fillWithRandomizedBlocks(world, structureBoundingBox, 8, -6, 2, 8, -3, 7, false, random, (StructureComponent.BlockSelector)Breeding.randomSwampPlanks);
            this.fillWithRandomizedBlocks(world, structureBoundingBox, 1, -6, 1, 7, -3, 1, false, random, (StructureComponent.BlockSelector)Breeding.randomSwampPlanks);
            this.fillWithRandomizedBlocks(world, structureBoundingBox, 1, -6, 8, 7, -3, 8, false, random, (StructureComponent.BlockSelector)Breeding.randomSwampPlanks);
            for (int x = 1; x < 8; ++x) {
                for (int z = 2; z < 8; ++z) {
                    this.func_151554_b(world, Blocks.dirt, 0, x, -4, z, structureBoundingBox);
                    this.placeBlockAtCurrentPosition(world, (Block)Blocks.grass, 0, x, -3, z, structureBoundingBox);
                }
            }
            for (int x = 0; x < 9; ++x) {
                for (int z = 1; z < 9; ++z) {
                    this.func_151554_b(world, Blocks.dirt, 0, x, -7, z, structureBoundingBox);
                }
            }
            this.fillWithAir(world, structureBoundingBox, 4, -6, 1, 4, -3, 1);
            this.fillWithAir(world, structureBoundingBox, 8, -6, 4, 8, -3, 4);
            this.func_151554_b(world, Blocks.log, 0, 0, -2, 1, structureBoundingBox);
            this.func_151554_b(world, Blocks.log, 0, 0, -2, 8, structureBoundingBox);
            this.func_151554_b(world, Blocks.log, 0, 8, -2, 8, structureBoundingBox);
            this.func_151554_b(world, Blocks.log, 0, 8, 3, 1, structureBoundingBox);
            this.func_151554_b(world, Blocks.log, 0, 4, 3, 1, structureBoundingBox);
            this.func_151554_b(world, Blocks.log, 0, 8, 3, 4, structureBoundingBox);
            this.func_151554_b(world, Blocks.log, 0, 4, 3, 4, structureBoundingBox);
            this.fillWithBlocks(world, structureBoundingBox, 1, -2, 1, 3, -2, 1, Blocks.fence, Blocks.fence, false);
            this.fillWithBlocks(world, structureBoundingBox, 0, -2, 2, 0, -2, 7, Blocks.fence, Blocks.fence, false);
            this.fillWithBlocks(world, structureBoundingBox, 1, -2, 8, 7, -2, 8, Blocks.fence, Blocks.fence, false);
            this.fillWithBlocks(world, structureBoundingBox, 8, -2, 5, 8, -2, 7, Blocks.fence, Blocks.fence, false);
            this.fillWithBlocks(world, structureBoundingBox, 8, -2, 2, 8, -1, 3, Blocks.fence, Blocks.fence, false);
            this.fillWithBlocks(world, structureBoundingBox, 5, -2, 1, 7, -1, 1, Blocks.fence, Blocks.fence, false);
            for (int k = 0; k < 3; ++k) {
                this.placeBlockAtCurrentPosition(world, Blocks.log, DirectionTools.log[this.coordBaseMode][0], 5 + k, 0, 1, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.log, DirectionTools.log[this.coordBaseMode][0], 5 + k, 0, 4, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.log, DirectionTools.log[this.coordBaseMode][0], 5 + k, 3, 1, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.log, DirectionTools.log[this.coordBaseMode][0], 5 + k, 3, 4, structureBoundingBox);
                if (k != 2) {
                    this.placeBlockAtCurrentPosition(world, Blocks.log, DirectionTools.log[this.coordBaseMode][1], 4, 0, 2 + k, structureBoundingBox);
                    this.placeBlockAtCurrentPosition(world, Blocks.log, DirectionTools.log[this.coordBaseMode][1], 8, 0, 2 + k, structureBoundingBox);
                    this.placeBlockAtCurrentPosition(world, Blocks.log, DirectionTools.log[this.coordBaseMode][1], 4, 3, 2 + k, structureBoundingBox);
                    this.placeBlockAtCurrentPosition(world, Blocks.log, DirectionTools.log[this.coordBaseMode][1], 8, 3, 2 + k, structureBoundingBox);
                }
            }
            this.fillWithMetadataBlocks(world, structureBoundingBox, 5, 1, 1, 7, 2, 1, Blocks.planks, 1, Blocks.planks, 1, false);
            this.fillWithMetadataBlocks(world, structureBoundingBox, 5, 1, 4, 7, 2, 4, Blocks.planks, 1, Blocks.planks, 1, false);
            this.fillWithMetadataBlocks(world, structureBoundingBox, 4, 1, 2, 4, 2, 3, Blocks.planks, 1, Blocks.planks, 1, false);
            this.fillWithMetadataBlocks(world, structureBoundingBox, 8, 1, 2, 8, 2, 3, Blocks.planks, 1, Blocks.planks, 1, false);
            this.fillWithMetadataBlocks(world, structureBoundingBox, 5, 0, 2, 7, 0, 3, (Block)Blocks.wooden_slab, 9, (Block)Blocks.wooden_slab, 9, false);
            this.fillWithMetadataBlocks(world, structureBoundingBox, 4, -1, 0, 8, -1, 0, (Block)Blocks.wooden_slab, 9, (Block)Blocks.wooden_slab, 9, false);
            this.placeBlockAtCurrentPosition(world, Blocks.spruce_stairs, DirectionTools.stair[this.coordBaseMode][0], 5, 0, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.spruce_stairs, DirectionTools.stair[this.coordBaseMode][3], 6, 0, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.spruce_stairs, DirectionTools.stair[this.coordBaseMode][1], 7, 0, 0, structureBoundingBox);
            this.fillWithMetadataBlocks(world, structureBoundingBox, 3, 0, 1, 3, 0, 4, (Block)Blocks.wooden_slab, 9, (Block)Blocks.wooden_slab, 9, false);
            this.fillWithMetadataBlocks(world, structureBoundingBox, 9, 0, 1, 9, 0, 4, (Block)Blocks.wooden_slab, 9, (Block)Blocks.wooden_slab, 9, false);
            this.placeBlockAtCurrentPosition(world, (Block)Blocks.wooden_slab, 9, 6, 0, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, (Block)Blocks.wooden_slab, 9, 7, 0, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.spruce_stairs, DirectionTools.stair[this.coordBaseMode][0], 5, 0, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.spruce_stairs, DirectionTools.stair[this.coordBaseMode][0], 4, -1, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.spruce_stairs, DirectionTools.stair[this.coordBaseMode][0], 3, -2, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 3, 1, 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 3, 2, 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 3, 1, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 3, 2, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 9, 1, 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 9, 2, 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 9, 1, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 9, 2, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 7, 1, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 7, 2, 5, structureBoundingBox);
            this.fillWithMetadataBlocks(world, structureBoundingBox, 3, 3, 0, 3, 3, 4, Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][0], Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][0], false);
            this.fillWithMetadataBlocks(world, structureBoundingBox, 3, 3, 5, 8, 3, 5, Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][2], Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][2], false);
            this.fillWithMetadataBlocks(world, structureBoundingBox, 9, 3, 1, 9, 3, 5, Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][1], Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][1], false);
            this.fillWithMetadataBlocks(world, structureBoundingBox, 4, 3, 0, 9, 3, 0, Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][3], Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][3], false);
            this.fillWithMetadataBlocks(world, structureBoundingBox, 4, 4, 1, 8, 4, 4, (Block)Blocks.wooden_slab, 0, (Block)Blocks.wooden_slab, 0, false);
            this.fillWithMetadataBlocks(world, structureBoundingBox, 5, 4, 2, 7, 4, 3, (Block)Blocks.wooden_slab, 8, (Block)Blocks.wooden_slab, 8, false);
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 4, 1, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 4, 2, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 8, 1, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 8, 2, 2, structureBoundingBox);
            this.placeDoorAtCurrentPosition(world, structureBoundingBox, random, 6, 1, 1, this.getMetadataWithOffset(Blocks.wooden_door, 1));
            this.placeDoorAtCurrentPosition(world, structureBoundingBox, random, 6, 1, 4, this.getMetadataWithOffset(Blocks.wooden_door, 1));
            this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 6, 3, 2, structureBoundingBox);
            this.spawnEntity(world, structureBoundingBox, 2, -2, 1, 0);
            this.spawnEntity(world, structureBoundingBox, 2, -2, 1, 1);
            this.spawnEntity(world, structureBoundingBox, 2, -2, 1, 1);
            this.spawnEntity(world, structureBoundingBox, 2, -2, 1, 1);
            this.spawnEntity(world, structureBoundingBox, 2, -2, 1, 1);
            return true;
        }
        
        @Override
        protected EntityLiving getNewEntity(final World world, final int choice) {
            switch (choice) {
                case 0: {
                    return (EntityLiving)new EntityLakeside(world, EnumVillager.LAKESIDE_BREEDER);
                }
                case 1: {
                    return (EntityLiving)new EntityPig(world);
                }
                default: {
                    return null;
                }
            }
        }
        
        static {
            Breeding.randomSwampPlanks = new Planks(null);
        }
    }
    
    public static class Field extends GlobalField
    {
        private static Planks randomSwampPlanks;
        
        public Field() {
        }
        
        public Field(final StructureVillagePieces.Start villagePiece, final int componentType, final Random random, final StructureBoundingBox structureBoundingBox, final int coordBaseMode) {
            super(EnumVillagePiece.LAKESIDE_FIELD, villagePiece, componentType, random, structureBoundingBox, coordBaseMode);
            this.setOffset(1);
        }
        
        public static Field buildComponent(final StructureVillagePieces.Start villagePiece, final List pieces, final Random random, final int x, final int y, final int z, final int coordBaseMode, final int p5) {
            final StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(x, y, z, 0, 0, 0, 8, 4, 7, coordBaseMode);
            return (canVillageGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(pieces, structureboundingbox) == null) ? new Field(villagePiece, p5, random, structureboundingbox, coordBaseMode) : null;
        }
        
        @Override
        protected Block getCropType(final Random random) {
            return random.nextBoolean() ? Blocks.carrots : Blocks.potatoes;
        }
        
        @Override
        public boolean build(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
            for (int x = 0; x < 8; ++x) {
                for (int z = 0; z < 8; ++z) {
                    this.clearCurrentPositionBlocksUpwards(world, x, 1, z, structureBoundingBox);
                }
            }
            this.fillWithRandomizedBlocks(world, structureBoundingBox, 0, -3, 2, 0, 0, 6, false, random, (StructureComponent.BlockSelector)Field.randomSwampPlanks);
            this.fillWithRandomizedBlocks(world, structureBoundingBox, 7, -3, 2, 7, 0, 6, false, random, (StructureComponent.BlockSelector)Field.randomSwampPlanks);
            this.fillWithRandomizedBlocks(world, structureBoundingBox, 1, -3, 1, 6, 0, 1, false, random, (StructureComponent.BlockSelector)Field.randomSwampPlanks);
            this.fillWithRandomizedBlocks(world, structureBoundingBox, 1, -3, 7, 6, 0, 7, false, random, (StructureComponent.BlockSelector)Field.randomSwampPlanks);
            for (int x = 1; x < 7; ++x) {
                for (int z = 2; z < 7; ++z) {
                    this.func_151554_b(world, Blocks.dirt, 0, x, -1, z, structureBoundingBox);
                    this.placeBlockAtCurrentPosition(world, Blocks.farmland, 0, x, 0, z, structureBoundingBox);
                }
            }
            this.func_151554_b(world, Blocks.log, 0, 0, 2, 0, structureBoundingBox);
            this.func_151554_b(world, Blocks.log, 0, 0, 1, 1, structureBoundingBox);
            this.func_151554_b(world, Blocks.log, 0, 0, 1, 7, structureBoundingBox);
            this.func_151554_b(world, Blocks.log, 0, 7, 2, 0, structureBoundingBox);
            this.func_151554_b(world, Blocks.log, 0, 7, 1, 1, structureBoundingBox);
            this.func_151554_b(world, Blocks.log, 0, 7, 1, 7, structureBoundingBox);
            for (int x = 0; x < 8; ++x) {
                for (int z = 1; z < 8; ++z) {
                    this.func_151554_b(world, Blocks.dirt, 0, x, -4, z, structureBoundingBox);
                }
            }
            for (int x = 1; x < 7; ++x) {
                this.clearCurrentPositionBlocksUpwards(world, x, 1, 0, structureBoundingBox);
            }
            this.fillWithRandomizedBlocks(world, structureBoundingBox, 1, -3, 0, 6, 0, 0, false, random, (StructureComponent.BlockSelector)Field.randomSwampPlanks);
            this.placeBlockAtCurrentPosition(world, Blocks.spruce_stairs, DirectionTools.stair[this.coordBaseMode][1], 2, 1, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.spruce_stairs, DirectionTools.stair[this.coordBaseMode][1], 1, 2, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.planks, 1, 1, 1, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][0], 6, 1, 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][0], 6, 1, 7, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][1], 1, 1, 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][1], 1, 1, 7, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][2], 0, 1, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][2], 7, 1, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][3], 0, 1, 6, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][3], 7, 1, 6, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, (Block)Blocks.wooden_slab, 0, 0, 1, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, (Block)Blocks.wooden_slab, 0, 7, 1, 4, structureBoundingBox);
            this.fillWithBlocks(world, structureBoundingBox, 0, 0, 4, 7, 0, 4, Blocks.water, Blocks.water, false);
            for (int x = 1; x < 7; ++x) {
                this.placeBlockAtCurrentPosition(world, this.cropTypeA, MathHelper.getRandomIntegerInRange(random, 2, 7), x, 1, 2, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, this.cropTypeA, MathHelper.getRandomIntegerInRange(random, 2, 7), x, 1, 3, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, this.cropTypeB, MathHelper.getRandomIntegerInRange(random, 2, 7), x, 1, 5, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, this.cropTypeB, MathHelper.getRandomIntegerInRange(random, 2, 7), x, 1, 6, structureBoundingBox);
            }
            this.spawnEntity(world, structureBoundingBox, 3, 1, 1, 0);
            this.spawnEntity(world, structureBoundingBox, 3, 1, 1, 0);
            return true;
        }
        
        @Override
        protected EntityLiving getNewEntity(final World world, final int choice) {
            return (EntityLiving)new EntityLakeside(world, EnumVillager.LAKESIDE_FARMER);
        }
        
        static {
            Field.randomSwampPlanks = new Planks(null);
        }
    }
    
    static class Planks extends StructureComponent.BlockSelector
    {
        private Planks() {
        }
        
        @Override
        public void selectBlocks(final Random p_75062_1_, final int p_75062_2_, final int p_75062_3_, final int p_75062_4_, final boolean p_75062_5_) {
            this.field_151562_a = Blocks.planks;
            if (p_75062_1_.nextFloat() < 0.4f) {
                this.selectedBlockMetaData = 0;
            }
            else {
                this.selectedBlockMetaData = 1;
            }
        }
        
        Planks(final Object p_i2063_1_) {
            this();
        }
    }
}
