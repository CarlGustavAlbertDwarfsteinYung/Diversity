// 
// Decompiled by Procyon v0.5.36
// 

package diversity.village;

import diversity.suppliers.EnumVillageBasicPiece;
import net.minecraft.util.MathHelper;
import net.minecraft.entity.passive.EntityChicken;
import diversity.entity.EntityAztec;
import diversity.suppliers.EnumVillager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.world.gen.structure.StructureComponent;
import diversity.suppliers.IEnumPiece;
import diversity.suppliers.EnumVillagePiece;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.init.Blocks;
import net.minecraft.world.gen.structure.StructureVillagePieces;
import java.util.List;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import java.util.Random;
import diversity.suppliers.EnumVillage;

public class VillageAztec extends VillageTools
{
    private static VillageAztec instance;
    
    public VillageAztec(final EnumVillage ENUM) {
        super(ENUM);
        VillageAztec.instance = this;
    }
    
    @Override
    protected GlobalPath getPath(final GlobalStart p_75080_0_, final int p_75080_7_, final Random p_75080_2_, final StructureBoundingBox structureboundingbox, final int p_75080_6_) {
        return new Path(p_75080_0_, p_75080_7_, p_75080_2_, structureboundingbox, p_75080_6_);
    }
    
    @Override
    public GlobalStart getStart(final WorldChunkManager worldChunkManager, final int i, final Random rand, final int j, final int k, final List list, final int numberOfVillagers) {
        return new Start(worldChunkManager, i, rand, j, k, list, numberOfVillagers);
    }
    
    @Override
    protected GlobalTorch getTorch(final GlobalStart villagePiece, final int par2, final Random rand, final StructureBoundingBox boundingBox, final int coordBaseMode) {
        return new Torch(villagePiece, par2, rand, boundingBox, coordBaseMode);
    }
    
    private static BlockData getRandomBlock(final Random random) {
        return (random.nextInt(6) == 0) ? new BlockData(Blocks.stonebrick, 2) : new BlockData(Blocks.stonebrick, 0);
    }
    
    public static class Start extends GlobalStart
    {
        public Start() {
        }
        
        public Start(final WorldChunkManager p_i2104_1_, final int p_i2104_2_, final Random p_i2104_3_, final int p_i2104_4_, final int p_i2104_5_, final List p_i2104_6_, final int p_i2104_7_) {
            super(VillageAztec.instance, p_i2104_1_, p_i2104_2_, p_i2104_3_, p_i2104_4_, p_i2104_5_, p_i2104_6_, p_i2104_7_);
        }
        
        @Override
        public boolean addComponentParts(final World world, final Random rand, final StructureBoundingBox structureBoundingBox) {
            if (super.addComponentParts(world, rand, structureBoundingBox, 3)) {
                return true;
            }
            this.fillWithBlocks(world, structureBoundingBox, 0, 0, 0, 5, 9, 5, Blocks.dirt, Blocks.dirt, false);
            for (int x = 0; x < 6; ++x) {
                for (int z = 0; z < 6; ++z) {
                    this.clearCurrentPositionBlocksUpwards(world, x, 11, z, structureBoundingBox);
                }
            }
            this.fillWithBlocks(world, structureBoundingBox, 0, 8, 0, 5, 9, 5, Blocks.stone, Blocks.stone, false);
            this.fillWithBlocks(world, structureBoundingBox, 0, 10, 0, 5, 10, 5, Blocks.stonebrick, Blocks.stonebrick, false);
            this.fillWithBlocks(world, structureBoundingBox, 2, 9, 2, 3, 10, 3, Blocks.water, Blocks.water, false);
            this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 3, 1, 11, 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 3, 1, 11, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 3, 4, 11, 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 3, 4, 11, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 3, 1, 12, 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 3, 1, 12, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 3, 4, 12, 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 3, 4, 12, 4, structureBoundingBox);
            for (int k = 1; k < 4; ++k) {
                this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 3), k, 13, 1, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 0), 1, 13, k + 1, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 2), k + 1, 13, 4, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 1), 4, 13, k, structureBoundingBox);
            }
            return true;
        }
    }
    
    public static class Path extends GlobalPath
    {
        public Path() {
        }
        
        public Path(final GlobalStart p_i2105_1_, final int p_i2105_2_, final Random p_i2105_3_, final StructureBoundingBox p_i2105_4_, final int p_i2105_5_) {
            super(VillageAztec.instance, p_i2105_1_, p_i2105_2_, p_i2105_3_, p_i2105_4_, p_i2105_5_);
        }
        
        @Override
        protected BlockData getPathBlock(final Random random) {
            return (random.nextInt(3) == 1) ? new BlockData((Block)Blocks.grass, 0) : ((random.nextInt(2) == 1) ? new BlockData(Blocks.stonebrick, 1) : new BlockData(Blocks.stonebrick, 0));
        }
        
        @Override
        protected BlockData getPathBridge(final Random random) {
            return new BlockData((Block)Blocks.wooden_slab, 0);
        }
        
        @Override
        protected BlockData getUnderPathBlock(final Random random) {
            return (random.nextInt(2) == 1) ? new BlockData(Blocks.cobblestone, 0) : new BlockData(Blocks.mossy_cobblestone, 0);
        }
    }
    
    public static class House1 extends GlobalVillage
    {
        public House1() {
        }
        
        public House1(final StructureVillagePieces.Start startPiece, final int componentType, final Random random, final StructureBoundingBox structureBoundingBox, final int coordBaseMode) {
            super(EnumVillagePiece.AZTEC_HOUSE1, startPiece, componentType, structureBoundingBox, coordBaseMode);
            this.setOffset(4);
        }
        
        public static House1 buildComponent(final StructureVillagePieces.Start villagePiece, final List pieces, final Random random, final int x, final int y, final int z, final int coordBaseMode, final int p5) {
            final StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(x, y, z, 0, 0, 0, 9, 6, 7, coordBaseMode);
            return (canVillageGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(pieces, structureboundingbox) == null) ? new House1(villagePiece, p5, random, structureboundingbox, coordBaseMode) : null;
        }
        
        @Override
        public boolean build(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
            for (int x = 0; x < 9; ++x) {
                for (int z = 1; z < 6; ++z) {
                    this.func_151554_b(world, Blocks.dirt, 0, x, -1, z, structureBoundingBox);
                    this.clearCurrentPositionBlocksUpwards(world, x, 1, z, structureBoundingBox);
                }
            }
            for (int x = 1; x < 8; ++x) {
                this.func_151554_b(world, Blocks.dirt, 0, x, -1, 0, structureBoundingBox);
                this.func_151554_b(world, Blocks.dirt, 0, x, -1, 6, structureBoundingBox);
                this.clearCurrentPositionBlocksUpwards(world, x, 1, 0, structureBoundingBox);
                this.clearCurrentPositionBlocksUpwards(world, x, 1, 6, structureBoundingBox);
            }
            for (int y = 0; y < 4; ++y) {
                for (int x2 = 1; x2 < 8; ++x2) {
                    this.placeBlockAtCurrentPosition(world, getRandomBlock(random), x2, y, 0, structureBoundingBox);
                    this.placeBlockAtCurrentPosition(world, getRandomBlock(random), x2, y, 6, structureBoundingBox);
                }
                for (int z = 1; z < 6; ++z) {
                    this.placeBlockAtCurrentPosition(world, getRandomBlock(random), 0, y, z, structureBoundingBox);
                    this.placeBlockAtCurrentPosition(world, getRandomBlock(random), 8, y, z, structureBoundingBox);
                }
            }
            this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 0, 1, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 0, 2, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 0, 1, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 0, 2, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 8, 1, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 8, 2, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 8, 1, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 8, 2, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 2, 1, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 2, 2, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 6, 1, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 6, 2, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 2, 1, 6, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 2, 2, 6, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 6, 1, 6, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 6, 2, 6, structureBoundingBox);
            for (int x = 1; x < 8; ++x) {
                for (int z = 1; z < 6; ++z) {
                    this.placeBlockAtCurrentPosition(world, Blocks.planks, 3, x, 0, z, structureBoundingBox);
                }
            }
            this.fillWithBlocks(world, structureBoundingBox, 1, 4, 1, 7, 4, 5, Blocks.stonebrick, Blocks.stonebrick, false);
            this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 3, 2, 5, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 3, 2, 6, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 3, 5, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 3, 6, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 0, 4, 5, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 0, 4, 6, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 5, 5, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 5, 6, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 3, 6, 5, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 3, 6, 6, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 6, 5, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 6, 6, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 3, 6, 5, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 3, 6, 6, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 5, 5, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 5, 6, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 0, 4, 5, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 0, 4, 6, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 3, 5, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 3, 6, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 3, 2, 5, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 3, 2, 6, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 2, 5, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 2, 6, 3, structureBoundingBox);
            for (int x = 2; x < 7; ++x) {
                for (int z = 2; z < 5; ++z) {
                    this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, x, 7, z, structureBoundingBox);
                }
            }
            this.placeDoorAtCurrentPosition(world, structureBoundingBox, random, 4, 1, 0, this.getMetadataWithOffset(Blocks.wooden_door, 1));
            this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 1, 3, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 7, 3, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 3, 5, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 4, 5, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 5, 5, 3, structureBoundingBox);
            this.spawnEntity(world, structureBoundingBox, 4, 2, 3, 0);
            this.spawnEntity(world, structureBoundingBox, 4, 2, 3, 0);
            this.spawnEntity(world, structureBoundingBox, 4, 2, 3, 0);
            return true;
        }
        
        @Override
        protected EntityLiving getNewEntity(final World world, final int choice) {
            return (EntityLiving)new EntityAztec(world, EnumVillager.AZTEC_HUNTER);
        }
    }
    
    public static class House2 extends GlobalVillage
    {
        public House2() {
        }
        
        public House2(final StructureVillagePieces.Start startPiece, final int componentType, final Random random, final StructureBoundingBox structureBoundingBox, final int coordBaseMode) {
            super(EnumVillagePiece.AZTEC_HOUSE2, startPiece, componentType, structureBoundingBox, coordBaseMode);
            this.setOffset(4);
        }
        
        public static House2 buildComponent(final StructureVillagePieces.Start villagePiece, final List pieces, final Random random, final int x, final int y, final int z, final int coordBaseMode, final int p5) {
            final StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(x, y, z, 0, 0, 0, 7, 6, 7, coordBaseMode);
            return (canVillageGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(pieces, structureboundingbox) == null) ? new House2(villagePiece, p5, random, structureboundingbox, coordBaseMode) : null;
        }
        
        @Override
        public boolean build(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
            for (int x = 0; x < 7; ++x) {
                for (int z = 1; z < 6; ++z) {
                    this.func_151554_b(world, Blocks.dirt, 0, x, -1, z, structureBoundingBox);
                    if (x == 0 || x == 6) {
                        this.placeBlockAtCurrentPosition(world, getRandomBlock(random), x, 0, z, structureBoundingBox);
                    }
                    else {
                        this.placeBlockAtCurrentPosition(world, Blocks.planks, 3, x, 0, z, structureBoundingBox);
                    }
                    this.clearCurrentPositionBlocksUpwards(world, x, 1, z, structureBoundingBox);
                }
            }
            for (int x = 1; x < 6; ++x) {
                this.func_151554_b(world, Blocks.dirt, 0, x, -1, 0, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, getRandomBlock(random), x, 0, 0, structureBoundingBox);
                this.func_151554_b(world, Blocks.dirt, 0, x, -1, 6, structureBoundingBox);
                this.clearCurrentPositionBlocksUpwards(world, x, 1, 0, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, getRandomBlock(random), x, 0, 6, structureBoundingBox);
                this.clearCurrentPositionBlocksUpwards(world, x, 1, 6, structureBoundingBox);
            }
            for (int k = 1; k < 6; ++k) {
                if (k != 3) {
                    this.placeBlockAtCurrentPosition(world, getRandomBlock(random), 0, 1, k, structureBoundingBox);
                    this.placeBlockAtCurrentPosition(world, getRandomBlock(random), 0, 2, k, structureBoundingBox);
                    this.placeBlockAtCurrentPosition(world, getRandomBlock(random), 6, 1, k, structureBoundingBox);
                    this.placeBlockAtCurrentPosition(world, getRandomBlock(random), 6, 2, k, structureBoundingBox);
                    this.placeBlockAtCurrentPosition(world, getRandomBlock(random), k, 1, 0, structureBoundingBox);
                    this.placeBlockAtCurrentPosition(world, getRandomBlock(random), k, 2, 0, structureBoundingBox);
                    this.placeBlockAtCurrentPosition(world, getRandomBlock(random), k, 1, 6, structureBoundingBox);
                    this.placeBlockAtCurrentPosition(world, getRandomBlock(random), k, 2, 6, structureBoundingBox);
                }
            }
            for (int x = 1; x < 6; ++x) {
                for (int z = 1; z < 6; ++z) {
                    this.placeBlockAtCurrentPosition(world, getRandomBlock(random), x, 3, z, structureBoundingBox);
                }
            }
            this.fillWithBlocks(world, structureBoundingBox, 2, 3, 2, 4, 3, 4, Blocks.air, Blocks.air, false);
            for (int x = 2; x < 5; ++x) {
                for (int z = 2; z < 5; ++z) {
                    this.placeBlockAtCurrentPosition(world, getRandomBlock(random), x, 4, z, structureBoundingBox);
                }
            }
            this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 0), 0, 3, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 0), 0, 3, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 0), 1, 4, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 0), 1, 4, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 1), 6, 3, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 1), 6, 3, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 1), 5, 4, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 1), 5, 4, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 3), 2, 3, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 3), 3, 3, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 3), 4, 3, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 3), 2, 4, 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 3), 4, 4, 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 2), 2, 3, 6, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 2), 4, 3, 6, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 2), 2, 4, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 2), 4, 4, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 3, 2, 5, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 3, 2, 6, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 3, 5, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 3, 6, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 3, 4, 5, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 3, 4, 6, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 3, 5, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 4, 6, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 3, 4, 5, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 3, 4, 6, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 3, 5, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 3, 6, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 3, 2, 5, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 3, 2, 6, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 2, 5, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 2, 6, 3, structureBoundingBox);
            for (int k = 2; k < 4; ++k) {
                this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 2, 7, k, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 4, 7, k + 1, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, k + 1, 7, 2, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, k, 7, 4, structureBoundingBox);
            }
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 3, 7, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.cobblestone_wall, 0, 1, 1, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.cobblestone_wall, 0, 1, 2, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.cobblestone_wall, 0, 5, 1, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.cobblestone_wall, 0, 5, 2, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.cobblestone_wall, 0, 3, 1, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.cobblestone_wall, 0, 3, 2, 5, structureBoundingBox);
            this.placeDoorAtCurrentPosition(world, structureBoundingBox, random, 3, 1, 0, this.getMetadataWithOffset(Blocks.wooden_door, 1));
            this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 3, 3, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 3, 5, 3, structureBoundingBox);
            this.spawnEntity(world, structureBoundingBox, 3, 2, 3, 0);
            this.spawnEntity(world, structureBoundingBox, 3, 2, 3, 0);
            return true;
        }
        
        @Override
        protected EntityLiving getNewEntity(final World world, final int choice) {
            return (EntityLiving)new EntityAztec(world, EnumVillager.AZTEC_DYER);
        }
    }
    
    public static class Temple extends GlobalVillage
    {
        public Temple() {
        }
        
        public Temple(final StructureVillagePieces.Start startPiece, final int componentType, final Random random, final StructureBoundingBox structureBoundingBox, final int coordBaseMode) {
            super(EnumVillagePiece.AZTEC_TEMPLE, startPiece, componentType, structureBoundingBox, coordBaseMode);
            this.setOffset(9);
        }
        
        public static Temple buildComponent(final StructureVillagePieces.Start villagePiece, final List pieces, final Random random, final int x, final int y, final int z, final int coordBaseMode, final int p5) {
            final StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(x, y, z, 0, 0, 0, 16, 11, 15, coordBaseMode);
            return (canVillageGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(pieces, structureboundingbox) == null) ? new Temple(villagePiece, p5, random, structureboundingbox, coordBaseMode) : null;
        }
        
        @Override
        public boolean build(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
            for (int x = 0; x < 16; ++x) {
                for (int z = 0; z < 15; ++z) {
                    if (x > 4 && x < 11 && z > 4 && z < 13) {
                        this.clearCurrentPositionBlocksUpwards(world, x, 1, z, structureBoundingBox);
                    }
                    if (x != 0 && z != 0 && x != 15) {
                        this.func_151554_b(world, Blocks.dirt, 0, x, -1, z, structureBoundingBox);
                        this.placeBlockAtCurrentPosition(world, getRandomBlock(random), x, 0, z, structureBoundingBox);
                        this.placeBlockAtCurrentPosition(world, getRandomBlock(random), x, 1, z, structureBoundingBox);
                        this.placeBlockAtCurrentPosition(world, getRandomBlock(random), x, 2, z, structureBoundingBox);
                    }
                }
            }
            this.fillWithBlocks(world, structureBoundingBox, 3, 0, 3, 12, 2, 12, Blocks.dirt, Blocks.dirt, false);
            for (int x = 3; x < 13; ++x) {
                for (int z = 3; z < 13; ++z) {
                    this.placeBlockAtCurrentPosition(world, getRandomBlock(random), x, 3, z, structureBoundingBox);
                    this.placeBlockAtCurrentPosition(world, getRandomBlock(random), x, 4, z, structureBoundingBox);
                }
            }
            this.fillWithBlocks(world, structureBoundingBox, 5, 0, 5, 10, 2, 12, Blocks.dirt, Blocks.dirt, false);
            for (int x = 5; x < 11; ++x) {
                for (int z = 5; z < 13; ++z) {
                    this.placeBlockAtCurrentPosition(world, getRandomBlock(random), x, 5, z, structureBoundingBox);
                    this.placeBlockAtCurrentPosition(world, getRandomBlock(random), x, 6, z, structureBoundingBox);
                }
            }
            for (int x = 6; x < 10; ++x) {
                for (int y = 3; y < 7; ++y) {
                    this.placeBlockAtCurrentPosition(world, getRandomBlock(random), x, y, 13, structureBoundingBox);
                    this.placeBlockAtCurrentPosition(world, getRandomBlock(random), x, y, 13, structureBoundingBox);
                    if (x == 7 || x == 8) {
                        this.placeBlockAtCurrentPosition(world, getRandomBlock(random), x, y, 14, structureBoundingBox);
                        this.placeBlockAtCurrentPosition(world, getRandomBlock(random), x, y, 14, structureBoundingBox);
                    }
                }
            }
            for (int k = 6; k < 10; ++k) {
                this.placeBlockAtCurrentPosition(world, getRandomBlock(random), k, 1, 0, structureBoundingBox);
                this.func_151554_b(world, Blocks.stonebrick, 0, k, 0, 0, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, getRandomBlock(random), k, 3, 2, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, getRandomBlock(random), k, 5, 4, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, getRandomBlock(random), 0, 1, k, structureBoundingBox);
                this.func_151554_b(world, Blocks.stonebrick, 0, 0, 0, k, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, getRandomBlock(random), 2, 3, k, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, getRandomBlock(random), 4, 5, k, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, getRandomBlock(random), 15, 1, k, structureBoundingBox);
                this.func_151554_b(world, Blocks.stonebrick, 0, 15, 0, k, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, getRandomBlock(random), 13, 3, k, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, getRandomBlock(random), 11, 5, k, structureBoundingBox);
            }
            this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 3), 6, 2, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 3), 6, 4, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 3), 6, 6, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 3), 9, 2, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 3), 9, 4, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 3), 9, 6, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 0), 0, 2, 6, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 0), 2, 4, 6, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 0), 4, 6, 6, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 0), 0, 2, 9, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 0), 2, 4, 9, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 0), 4, 6, 9, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 1), 15, 2, 6, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 1), 13, 4, 6, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 1), 11, 6, 6, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 1), 15, 2, 9, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 1), 13, 4, 9, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 1), 11, 6, 9, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, getRandomBlock(random), 5, 3, 13, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, getRandomBlock(random), 10, 3, 13, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 2), 5, 4, 13, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 2), 10, 4, 13, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 2), 7, 6, 14, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 2), 8, 6, 14, structureBoundingBox);
            this.fillWithBlocks(world, structureBoundingBox, 5, 7, 9, 5, 8, 12, Blocks.fence, Blocks.fence, false);
            this.fillWithBlocks(world, structureBoundingBox, 6, 7, 13, 9, 8, 13, Blocks.wool, Blocks.wool, false);
            this.fillWithBlocks(world, structureBoundingBox, 7, 7, 13, 8, 7, 13, Blocks.fence, Blocks.fence, false);
            this.fillWithBlocks(world, structureBoundingBox, 10, 7, 9, 10, 8, 12, Blocks.fence, Blocks.fence, false);
            this.fillWithBlocks(world, structureBoundingBox, 6, 7, 9, 9, 8, 9, Blocks.wool, Blocks.wool, false);
            for (int k = 0; k < 4; ++k) {
                this.placeBlockAtCurrentPosition(world, Blocks.planks, 3, 6 + k, 9, 9, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.planks, 3, 6 + k, 9, 13, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.planks, 3, 5, 9, 9 + k, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.planks, 3, 10, 9, 9 + k, structureBoundingBox);
            }
            this.fillWithBlocks(world, structureBoundingBox, 6, 9, 10, 9, 9, 12, Blocks.fence, Blocks.fence, false);
            for (int x = 6; x < 10; ++x) {
                for (int z = 10; z < 13; ++z) {
                    this.placeBlockAtCurrentPosition(world, this.func_151558_b((Block)Blocks.wooden_slab, 3), 3, x, 10, z, structureBoundingBox);
                }
            }
            this.placeBlockAtCurrentPosition(world, (Block)Blocks.double_stone_slab, 0, 7, 7, 6, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, (Block)Blocks.double_stone_slab, 0, 8, 7, 6, structureBoundingBox);
            this.placeDoorAtCurrentPosition(world, structureBoundingBox, random, 7, 7, 9, this.getMetadataWithOffset(Blocks.wooden_door, 1));
            this.placeDoorAtCurrentPosition(world, structureBoundingBox, random, 8, 7, 9, this.getMetadataWithOffset(Blocks.wooden_door, 1));
            this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 7, 8, 13, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 8, 8, 13, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 5, 7, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 10, 7, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 5, 8, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 10, 8, 5, structureBoundingBox);
            this.spawnVillagers(world, structureBoundingBox, 7, 7, 11, 0);
            return true;
        }
        
        @Override
        protected EntityLiving getNewEntity(final World world, final int choice) {
            return (EntityLiving)new EntityAztec(world, EnumVillager.AZTEC_HIGHPRIEST);
        }
    }
    
    public static class Livestock extends GlobalVillage
    {
        public Livestock() {
        }
        
        public Livestock(final StructureVillagePieces.Start startPiece, final int componentType, final Random random, final StructureBoundingBox structureBoundingBox, final int coordBaseMode) {
            super(EnumVillagePiece.AZTEC_LIVESTOCK, startPiece, componentType, structureBoundingBox, coordBaseMode);
            this.setOffset(1);
        }
        
        public static Livestock buildComponent(final StructureVillagePieces.Start villagePiece, final List pieces, final Random random, final int x, final int y, final int z, final int coordBaseMode, final int p5) {
            final StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(x, y, z, 0, 0, 0, 7, 3, 5, coordBaseMode);
            return (canVillageGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(pieces, structureboundingbox) == null) ? new Livestock(villagePiece, p5, random, structureboundingbox, coordBaseMode) : null;
        }
        
        @Override
        public boolean build(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
            for (int x = 0; x < 7; ++x) {
                for (int z = 0; z < 5; ++z) {
                    this.func_151554_b(world, Blocks.dirt, 0, x, -2, z, structureBoundingBox);
                    this.clearCurrentPositionBlocksUpwards(world, x, 1, z, structureBoundingBox);
                    if (x == 0 || x == 6 || z == 0 || z == 4) {
                        this.placeBlockAtCurrentPosition(world, getRandomBlock(random), x, 0, z, structureBoundingBox);
                    }
                    else {
                        this.placeBlockAtCurrentPosition(world, Blocks.dirt, 0, x, 0, z, structureBoundingBox);
                        this.placeBlockAtCurrentPosition(world, getRandomBlock(random), x, -1, z, structureBoundingBox);
                    }
                }
                this.placeBlockAtCurrentPosition(world, getRandomBlock(random), x, 1, 0, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, getRandomBlock(random), x, 2, 0, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, getRandomBlock(random), x, 3, 0, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, getRandomBlock(random), x, 1, 4, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, getRandomBlock(random), x, 2, 4, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, getRandomBlock(random), x, 3, 4, structureBoundingBox);
            }
            for (int z2 = 1; z2 < 4; ++z2) {
                this.placeBlockAtCurrentPosition(world, getRandomBlock(random), 0, 1, z2, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, getRandomBlock(random), 6, 1, z2, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, getRandomBlock(random), 6, 2, z2, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, getRandomBlock(random), 6, 3, z2, structureBoundingBox);
            }
            this.fillWithBlocks(world, structureBoundingBox, 0, 2, 1, 0, 3, 3, Blocks.fence, Blocks.fence, false);
            this.fillWithBlocks(world, structureBoundingBox, 4, 1, 0, 5, 3, 0, Blocks.fence, Blocks.fence, false);
            this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 3, 0, 3, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 3, 0, 3, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 3, 3, 3, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 3, 3, 3, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 3, 6, 3, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 3, 6, 3, 4, structureBoundingBox);
            this.placeDoorAtCurrentPosition(world, structureBoundingBox, random, 2, 1, 0, this.getMetadataWithOffset(Blocks.wooden_door, 1));
            this.spawnEntity(world, structureBoundingBox, 4, 2, 2, 0);
            this.spawnEntity(world, structureBoundingBox, 4, 2, 2, 1);
            this.spawnEntity(world, structureBoundingBox, 4, 2, 2, 1);
            this.spawnEntity(world, structureBoundingBox, 4, 2, 2, 1);
            this.spawnEntity(world, structureBoundingBox, 4, 2, 2, 1);
            this.spawnEntity(world, structureBoundingBox, 4, 2, 2, 1);
            this.spawnEntity(world, structureBoundingBox, 4, 2, 2, 1);
            return true;
        }
        
        @Override
        protected EntityLiving getNewEntity(final World world, final int choice) {
            switch (choice) {
                case 0: {
                    return (EntityLiving)new EntityAztec(world, EnumVillager.AZTEC_BREEDER);
                }
                case 1: {
                    return (EntityLiving)new EntityChicken(world);
                }
                default: {
                    return null;
                }
            }
        }
    }
    
    public static class Palace extends GlobalVillage
    {
        public Palace() {
        }
        
        public Palace(final StructureVillagePieces.Start startPiece, final int componentType, final Random random, final StructureBoundingBox structureBoundingBox, final int coordBaseMode) {
            super(EnumVillagePiece.AZTEC_PALACE, startPiece, componentType, structureBoundingBox, coordBaseMode);
            this.setOffset(9);
        }
        
        public static Palace buildComponent(final StructureVillagePieces.Start villagePiece, final List pieces, final Random random, final int x, final int y, final int z, final int coordBaseMode, final int p5) {
            final StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(x, y, z, 0, 0, 0, 16, 11, 15, coordBaseMode);
            return (canVillageGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(pieces, structureboundingbox) == null) ? new Palace(villagePiece, p5, random, structureboundingbox, coordBaseMode) : null;
        }
        
        @Override
        public boolean build(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
            for (int x = 0; x < 16; ++x) {
                for (int z = 0; z < 15; ++z) {
                    if (x > 4 && x < 11 && z > 4 && z < 13) {
                        this.clearCurrentPositionBlocksUpwards(world, x, 1, z, structureBoundingBox);
                    }
                    if (x != 0 && z != 0 && x != 15) {
                        this.func_151554_b(world, Blocks.dirt, 0, x, -1, z, structureBoundingBox);
                        this.placeBlockAtCurrentPosition(world, getRandomBlock(random), x, 0, z, structureBoundingBox);
                        this.placeBlockAtCurrentPosition(world, getRandomBlock(random), x, 1, z, structureBoundingBox);
                        this.placeBlockAtCurrentPosition(world, getRandomBlock(random), x, 2, z, structureBoundingBox);
                    }
                }
            }
            this.fillWithBlocks(world, structureBoundingBox, 3, 0, 3, 12, 2, 12, Blocks.dirt, Blocks.dirt, false);
            for (int x = 3; x < 13; ++x) {
                for (int z = 3; z < 13; ++z) {
                    this.placeBlockAtCurrentPosition(world, getRandomBlock(random), x, 3, z, structureBoundingBox);
                    this.placeBlockAtCurrentPosition(world, getRandomBlock(random), x, 4, z, structureBoundingBox);
                }
            }
            this.fillWithBlocks(world, structureBoundingBox, 5, 0, 5, 10, 2, 12, Blocks.dirt, Blocks.dirt, false);
            for (int x = 5; x < 11; ++x) {
                for (int z = 5; z < 13; ++z) {
                    this.placeBlockAtCurrentPosition(world, getRandomBlock(random), x, 5, z, structureBoundingBox);
                    this.placeBlockAtCurrentPosition(world, getRandomBlock(random), x, 6, z, structureBoundingBox);
                }
            }
            for (int x = 6; x < 10; ++x) {
                for (int y = 3; y < 7; ++y) {
                    this.placeBlockAtCurrentPosition(world, getRandomBlock(random), x, y, 13, structureBoundingBox);
                    this.placeBlockAtCurrentPosition(world, getRandomBlock(random), x, y, 13, structureBoundingBox);
                    if (x == 7 || x == 8) {
                        this.placeBlockAtCurrentPosition(world, getRandomBlock(random), x, y, 14, structureBoundingBox);
                        this.placeBlockAtCurrentPosition(world, getRandomBlock(random), x, y, 14, structureBoundingBox);
                    }
                }
            }
            for (int k = 6; k < 10; ++k) {
                this.placeBlockAtCurrentPosition(world, getRandomBlock(random), k, 1, 0, structureBoundingBox);
                this.func_151554_b(world, Blocks.stonebrick, 0, k, 0, 0, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, getRandomBlock(random), k, 3, 2, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, getRandomBlock(random), k, 5, 4, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, getRandomBlock(random), 0, 1, k, structureBoundingBox);
                this.func_151554_b(world, Blocks.stonebrick, 0, 0, 0, k, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, getRandomBlock(random), 2, 3, k, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, getRandomBlock(random), 4, 5, k, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, getRandomBlock(random), 15, 1, k, structureBoundingBox);
                this.func_151554_b(world, Blocks.stonebrick, 0, 15, 0, k, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, getRandomBlock(random), 13, 3, k, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, getRandomBlock(random), 11, 5, k, structureBoundingBox);
            }
            this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 3), 6, 2, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 3), 6, 4, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 3), 6, 6, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 3), 9, 2, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 3), 9, 4, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 3), 9, 6, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 0), 0, 2, 6, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 0), 2, 4, 6, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 0), 4, 6, 6, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 0), 0, 2, 9, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 0), 2, 4, 9, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 0), 4, 6, 9, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 1), 15, 2, 6, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 1), 13, 4, 6, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 1), 11, 6, 6, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 1), 15, 2, 9, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 1), 13, 4, 9, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 1), 11, 6, 9, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, getRandomBlock(random), 5, 3, 13, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, getRandomBlock(random), 10, 3, 13, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 2), 5, 4, 13, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 2), 10, 4, 13, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 2), 7, 6, 14, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 2), 8, 6, 14, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 3, 5, 8, 6, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 3, 5, 7, 6, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 3, 5, 8, 9, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 3, 5, 7, 9, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 3, 6, 8, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 3, 6, 7, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 3, 9, 8, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 3, 9, 7, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 3, 10, 8, 6, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 3, 10, 7, 6, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 3, 10, 8, 9, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 3, 10, 7, 9, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 2), 5, 7, 10, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 2), 5, 8, 10, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 2), 5, 7, 11, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 2), 5, 8, 11, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, getRandomBlock(random), 5, 7, 12, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, getRandomBlock(random), 5, 8, 12, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, getRandomBlock(random), 6, 7, 13, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, getRandomBlock(random), 6, 8, 13, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 2), 10, 7, 10, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 2), 10, 8, 10, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 2), 10, 7, 11, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 2), 10, 8, 11, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, getRandomBlock(random), 10, 7, 12, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, getRandomBlock(random), 10, 8, 12, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, getRandomBlock(random), 9, 7, 13, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, getRandomBlock(random), 9, 8, 13, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, getRandomBlock(random), 6, 7, 9, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, getRandomBlock(random), 6, 8, 9, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, getRandomBlock(random), 9, 7, 9, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, getRandomBlock(random), 9, 8, 9, structureBoundingBox);
            this.fillWithBlocks(world, structureBoundingBox, 7, 7, 13, 8, 8, 13, Blocks.fence, Blocks.fence, false);
            for (int x = 6; x < 10; ++x) {
                this.placeBlockAtCurrentPosition(world, getRandomBlock(random), x, 9, 5, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, getRandomBlock(random), x, 9, 13, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, getRandomBlock(random), x, 9, 9, structureBoundingBox);
                for (int z = 6; z < 13; ++z) {
                    this.placeBlockAtCurrentPosition(world, getRandomBlock(random), x, 10, z, structureBoundingBox);
                }
            }
            for (int z2 = 6; z2 < 13; ++z2) {
                this.placeBlockAtCurrentPosition(world, getRandomBlock(random), 5, 9, z2, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, getRandomBlock(random), 10, 9, z2, structureBoundingBox);
            }
            this.placeDoorAtCurrentPosition(world, structureBoundingBox, random, 7, 7, 9, this.getMetadataWithOffset(Blocks.wooden_door, 1));
            this.placeDoorAtCurrentPosition(world, structureBoundingBox, random, 8, 7, 9, this.getMetadataWithOffset(Blocks.wooden_door, 1));
            this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 6, 9, 11, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 9, 9, 11, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 5, 7, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 10, 7, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 5, 8, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 10, 8, 5, structureBoundingBox);
            this.spawnEntity(world, structureBoundingBox, 7, 7, 11, 0);
            return true;
        }
        
        @Override
        protected EntityLiving getNewEntity(final World world, final int choice) {
            return (EntityLiving)new EntityAztec(world, EnumVillager.AZTEC_CHIEF);
        }
    }
    
    public static class Field extends GlobalField
    {
        public Field() {
        }
        
        public Field(final StructureVillagePieces.Start startPiece, final int componentType, final Random random, final StructureBoundingBox structureBoundingBox, final int coordBaseMode) {
            super(EnumVillagePiece.AZTEC_FIELD, startPiece, componentType, random, structureBoundingBox, coordBaseMode);
            this.setOffset(8);
        }
        
        public static Field buildComponent(final StructureVillagePieces.Start villagePiece, final List pieces, final Random random, final int x, final int y, final int z, final int coordBaseMode, final int p5) {
            final StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(x, y, z, 0, 0, 0, 16, 11, 15, coordBaseMode);
            return (canVillageGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(pieces, structureboundingbox) == null) ? new Field(villagePiece, p5, random, structureboundingbox, coordBaseMode) : null;
        }
        
        @Override
        protected Block getCropType(final Random random) {
            return random.nextBoolean() ? Blocks.melon_stem : Blocks.pumpkin_stem;
        }
        
        @Override
        public boolean build(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
            this.fillWithBlocks(world, structureBoundingBox, 0, 1, 0, 12, 4, 8, Blocks.air, Blocks.air, false);
            this.fillWithBlocks(world, structureBoundingBox, 1, 0, 1, 2, 0, 7, Blocks.farmland, Blocks.farmland, false);
            this.fillWithBlocks(world, structureBoundingBox, 4, 0, 1, 5, 0, 7, Blocks.farmland, Blocks.farmland, false);
            this.fillWithBlocks(world, structureBoundingBox, 7, 0, 1, 8, 0, 7, Blocks.farmland, Blocks.farmland, false);
            this.fillWithBlocks(world, structureBoundingBox, 10, 0, 1, 11, 0, 7, Blocks.farmland, Blocks.farmland, false);
            this.fillWithBlocks(world, structureBoundingBox, 0, 0, 0, 0, 0, 8, Blocks.log, Blocks.log, false);
            this.fillWithBlocks(world, structureBoundingBox, 6, 0, 0, 6, 0, 8, Blocks.log, Blocks.log, false);
            this.fillWithBlocks(world, structureBoundingBox, 12, 0, 0, 12, 0, 8, Blocks.log, Blocks.log, false);
            this.fillWithBlocks(world, structureBoundingBox, 1, 0, 0, 11, 0, 0, Blocks.log, Blocks.log, false);
            this.fillWithBlocks(world, structureBoundingBox, 1, 0, 8, 11, 0, 8, Blocks.log, Blocks.log, false);
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
                    this.func_151554_b(world, Blocks.dirt, 0, j, -1, i, structureBoundingBox);
                }
            }
            this.spawnEntity(world, structureBoundingBox, 4, 2, 4, 0);
            return true;
        }
        
        @Override
        protected EntityLiving getNewEntity(final World world, final int choice) {
            return (EntityLiving)new EntityAztec(world, EnumVillager.AZTEC_FARMER);
        }
    }
    
    public static class Torch extends GlobalTorch
    {
        public Torch() {
        }
        
        public Torch(final StructureVillagePieces.Start startPiece, final int componentType, final Random random, final StructureBoundingBox structureBoundingBox, final int coordBaseMode) {
            super(EnumVillageBasicPiece.AZTEC_TORCH, startPiece, componentType, random, structureBoundingBox, coordBaseMode);
            this.setOffset(3);
        }
        
        @Override
        public boolean build(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
            this.fillWithBlocks(world, structureBoundingBox, 0, 1, 0, 2, 3, 1, Blocks.air, Blocks.air, false);
            this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 0, 0, 0, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 0, 1, 0, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 0, 2, 0, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 0, 1, 0, 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 0), 0, 1, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 1), 2, 1, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 2), 1, 1, 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.cobblestone_wall, 0, 1, 1, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 1, 2, 0, structureBoundingBox);
            return true;
        }
    }
}
