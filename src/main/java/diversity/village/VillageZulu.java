// 
// Decompiled by Procyon v0.5.36
// 

package diversity.village;

import diversity.suppliers.EnumVillageBasicPiece;
import net.minecraft.entity.passive.EntityCow;
import diversity.entity.EntityZulu;
import diversity.suppliers.EnumVillager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.world.gen.structure.StructureComponent;
import diversity.suppliers.IEnumPiece;
import diversity.suppliers.EnumVillagePiece;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureVillagePieces;
import java.util.List;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import java.util.Random;
import diversity.suppliers.EnumVillage;

public final class VillageZulu extends VillageTools
{
    private static VillageZulu instance;
    
    public VillageZulu(final EnumVillage ENUM) {
        super(ENUM);
        VillageZulu.instance = this;
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
            super(VillageZulu.instance, p_i2104_1_, p_i2104_2_, p_i2104_3_, p_i2104_4_, p_i2104_5_, p_i2104_6_, p_i2104_7_);
        }
        
        @Override
        public boolean addComponentParts(final World world, final Random rand, final StructureBoundingBox structureBoundingBox) {
            if (super.addComponentParts(world, rand, structureBoundingBox, 3)) {
                return true;
            }
            this.fillWithBlocks(world, structureBoundingBox, 0, 0, 0, 5, 9, 5, Blocks.dirt, Blocks.dirt, false);
            this.fillWithBlocks(world, structureBoundingBox, 0, 10, 0, 5, 10, 5, Blocks.gravel, Blocks.gravel, false);
            for (int i = 0; i < 6; ++i) {
                for (int j = 0; j < 6; ++j) {
                    this.clearCurrentPositionBlocksUpwards(world, j, 11, i, structureBoundingBox);
                }
            }
            this.fillWithBlocks(world, structureBoundingBox, 1, 13, 0, 4, 13, 5, Blocks.hay_block, Blocks.hay_block, false);
            this.fillWithBlocks(world, structureBoundingBox, 0, 13, 1, 5, 13, 4, Blocks.hay_block, Blocks.hay_block, false);
            this.fillWithBlocks(world, structureBoundingBox, 1, 13, 1, 4, 13, 4, Blocks.fence, Blocks.fence, false);
            this.fillWithBlocks(world, structureBoundingBox, 2, 13, 2, 3, 13, 3, Blocks.air, Blocks.air, false);
            this.fillWithBlocks(world, structureBoundingBox, 1, 14, 1, 4, 14, 4, Blocks.hay_block, Blocks.hay_block, false);
            this.fillWithBlocks(world, structureBoundingBox, 2, 15, 2, 3, 15, 3, Blocks.hay_block, Blocks.hay_block, false);
            for (int i = 1; i <= 3; ++i) {
                this.placeBlockAtCurrentPosition(world, Blocks.stained_hardened_clay, 7, 1, 10 + i, 1, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.stained_hardened_clay, 7, 1, 10 + i, 4, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.stained_hardened_clay, 7, 4, 10 + i, 1, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.stained_hardened_clay, 7, 4, 10 + i, 4, structureBoundingBox);
            }
            return true;
        }
    }
    
    public static class Path extends GlobalPath
    {
        public Path() {
        }
        
        public Path(final GlobalStart p_i2105_1_, final int p_i2105_2_, final Random p_i2105_3_, final StructureBoundingBox p_i2105_4_, final int p_i2105_5_) {
            super(VillageZulu.instance, p_i2105_1_, p_i2105_2_, p_i2105_3_, p_i2105_4_, p_i2105_5_);
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
    }
    
    public static class House1 extends GlobalVillage
    {
        public House1() {
        }
        
        public House1(final StructureVillagePieces.Start villagePiece, final int componentType, final Random random, final StructureBoundingBox structureBoundingBox, final int coordBaseMode) {
            super(EnumVillagePiece.ZULU_HOUSE1, villagePiece, componentType, structureBoundingBox, coordBaseMode);
            this.setOffset(4);
        }
        
        public static House1 buildComponent(final StructureVillagePieces.Start villagePiece, final List pieces, final Random random, final int x, final int y, final int z, final int coordBaseMode, final int p5) {
            final StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(x, y, z, 0, 0, 0, 9, 6, 9, coordBaseMode);
            return (canVillageGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(pieces, structureboundingbox) == null) ? new House1(villagePiece, p5, random, structureboundingbox, coordBaseMode) : null;
        }
        
        @Override
        public boolean build(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
            for (int x = 1; x < 8; ++x) {
                for (int z = 2; z < 7; ++z) {
                    this.func_151554_b(world, Blocks.dirt, 0, x, -1, z, structureBoundingBox);
                    this.clearCurrentPositionBlocksUpwards(world, x, 1, z, structureBoundingBox);
                }
            }
            for (int x = 2; x < 7; ++x) {
                this.func_151554_b(world, Blocks.dirt, 0, x, -1, 1, structureBoundingBox);
                this.func_151554_b(world, Blocks.dirt, 0, x, -1, 7, structureBoundingBox);
                this.clearCurrentPositionBlocksUpwards(world, x, 1, 1, structureBoundingBox);
                this.clearCurrentPositionBlocksUpwards(world, x, 1, 7, structureBoundingBox);
            }
            this.fillWithBlocks(world, structureBoundingBox, 2, 3, 0, 6, 3, 8, Blocks.hay_block, Blocks.air, false);
            this.fillWithBlocks(world, structureBoundingBox, 0, 3, 2, 8, 3, 6, Blocks.hay_block, Blocks.air, false);
            this.fillWithBlocks(world, structureBoundingBox, 2, 0, 1, 6, 3, 1, Blocks.stained_hardened_clay, Blocks.air, false);
            this.fillWithBlocks(world, structureBoundingBox, 2, 0, 7, 6, 3, 7, Blocks.stained_hardened_clay, Blocks.air, false);
            this.fillWithBlocks(world, structureBoundingBox, 1, 0, 2, 1, 3, 6, Blocks.stained_hardened_clay, Blocks.air, false);
            this.fillWithBlocks(world, structureBoundingBox, 7, 0, 2, 7, 3, 6, Blocks.stained_hardened_clay, Blocks.air, false);
            this.fillWithBlocks(world, structureBoundingBox, 2, 0, 2, 6, 0, 6, Blocks.hay_block, Blocks.hay_block, false);
            this.fillWithBlocks(world, structureBoundingBox, 3, 5, 2, 5, 5, 6, Blocks.hay_block, Blocks.hay_block, false);
            this.fillWithBlocks(world, structureBoundingBox, 2, 5, 3, 6, 5, 5, Blocks.hay_block, Blocks.hay_block, false);
            this.fillWithBlocks(world, structureBoundingBox, 2, 4, 1, 6, 4, 7, Blocks.hay_block, Blocks.hay_block, false);
            this.fillWithBlocks(world, structureBoundingBox, 1, 4, 2, 7, 4, 6, Blocks.hay_block, Blocks.hay_block, false);
            this.fillWithBlocks(world, structureBoundingBox, 1, 3, 1, 7, 3, 7, Blocks.stained_hardened_clay, Blocks.air, false);
            this.placeBlockAtCurrentPosition(world, Blocks.hay_block, 0, 1, 3, 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.hay_block, 0, 1, 3, 7, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.hay_block, 0, 7, 3, 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.hay_block, 0, 7, 3, 7, structureBoundingBox);
            for (int x = 2; x <= 6; ++x) {
                for (int y = 2; y <= 6; ++y) {
                    this.placeBlockAtCurrentPosition(world, Blocks.air, 0, x, 3, y, structureBoundingBox);
                }
            }
            for (int x = 2; x < 6; ++x) {
                this.placeBlockAtCurrentPosition(world, (Block)Blocks.wooden_slab, 4, x, 3, 2, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, (Block)Blocks.wooden_slab, 4, x + 1, 3, 6, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, (Block)Blocks.wooden_slab, 4, 2, 3, x + 1, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, (Block)Blocks.wooden_slab, 4, 6, 3, x, structureBoundingBox);
            }
            this.placeDoorAtCurrentPosition(world, structureBoundingBox, random, 4, 1, 1, this.getMetadataWithOffset(Blocks.wooden_door, 1));
            this.fillWithBlocks(world, structureBoundingBox, 2, 1, 0, 6, 2, 0, Blocks.air, Blocks.air, false);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 3, 2, 7, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 5, 2, 7, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 1, 2, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 7, 2, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 4, 2, 6, structureBoundingBox);
            this.spawnEntity(world, structureBoundingBox, 4, 2, 4, 0);
            this.spawnEntity(world, structureBoundingBox, 4, 2, 4, 0);
            return true;
        }
        
        @Override
        protected EntityLiving getNewEntity(final World world, final int choice) {
            return (EntityLiving)new EntityZulu(world, EnumVillager.ZULU_FARMER);
        }
    }
    
    public static class House2 extends GlobalVillage
    {
        public House2() {
        }
        
        public House2(final StructureVillagePieces.Start villagePiece, final int componentType, final Random random, final StructureBoundingBox structureBoundingBox, final int coordBaseMode) {
            super(EnumVillagePiece.ZULU_HOUSE2, villagePiece, componentType, structureBoundingBox, coordBaseMode);
            this.setOffset(5);
        }
        
        public static House2 buildComponent(final StructureVillagePieces.Start villagePiece, final List pieces, final Random random, final int x, final int y, final int z, final int coordBaseMode, final int p5) {
            final StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(x, y, z, 0, 0, 0, 9, 7, 9, coordBaseMode);
            return (canVillageGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(pieces, structureboundingbox) == null) ? new House2(villagePiece, p5, random, structureboundingbox, coordBaseMode) : null;
        }
        
        @Override
        public boolean build(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
            for (int x = 1; x < 8; ++x) {
                for (int z = 3; z < 6; ++z) {
                    this.func_151554_b(world, Blocks.dirt, 0, x, -1, z, structureBoundingBox);
                    this.clearCurrentPositionBlocksUpwards(world, x, 1, z, structureBoundingBox);
                }
            }
            for (int x = 2; x < 7; ++x) {
                this.func_151554_b(world, Blocks.dirt, 0, x, -1, 2, structureBoundingBox);
                this.func_151554_b(world, Blocks.dirt, 0, x, -1, 6, structureBoundingBox);
                this.clearCurrentPositionBlocksUpwards(world, x, 1, 2, structureBoundingBox);
                this.clearCurrentPositionBlocksUpwards(world, x, 1, 6, structureBoundingBox);
            }
            for (int x = 3; x < 6; ++x) {
                this.func_151554_b(world, Blocks.dirt, 0, x, -1, 1, structureBoundingBox);
                this.func_151554_b(world, Blocks.dirt, 0, x, -1, 7, structureBoundingBox);
                this.clearCurrentPositionBlocksUpwards(world, x, 1, 1, structureBoundingBox);
                this.clearCurrentPositionBlocksUpwards(world, x, 1, 7, structureBoundingBox);
            }
            this.fillWithBlocks(world, structureBoundingBox, 0, 3, 3, 8, 3, 5, Blocks.hay_block, Blocks.hay_block, false);
            this.fillWithBlocks(world, structureBoundingBox, 3, 3, 0, 5, 3, 8, Blocks.hay_block, Blocks.hay_block, false);
            this.placeBlockAtCurrentPosition(world, Blocks.hay_block, 0, 2, 3, 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.hay_block, 0, 1, 3, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.hay_block, 0, 1, 3, 6, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.hay_block, 0, 2, 3, 7, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.hay_block, 0, 6, 3, 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.hay_block, 0, 7, 3, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.hay_block, 0, 6, 3, 7, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.hay_block, 0, 7, 3, 6, structureBoundingBox);
            this.fillWithBlocks(world, structureBoundingBox, 1, 0, 3, 7, 3, 5, Blocks.stained_hardened_clay, Blocks.stained_hardened_clay, false);
            this.fillWithBlocks(world, structureBoundingBox, 3, 0, 1, 5, 3, 7, Blocks.stained_hardened_clay, Blocks.stained_hardened_clay, false);
            this.fillWithBlocks(world, structureBoundingBox, 2, 0, 2, 2, 3, 2, Blocks.stained_hardened_clay, Blocks.stained_hardened_clay, false);
            this.fillWithBlocks(world, structureBoundingBox, 2, 0, 6, 2, 3, 6, Blocks.stained_hardened_clay, Blocks.stained_hardened_clay, false);
            this.fillWithBlocks(world, structureBoundingBox, 6, 0, 2, 6, 3, 2, Blocks.stained_hardened_clay, Blocks.stained_hardened_clay, false);
            this.fillWithBlocks(world, structureBoundingBox, 6, 0, 6, 6, 3, 6, Blocks.stained_hardened_clay, Blocks.stained_hardened_clay, false);
            this.fillWithBlocks(world, structureBoundingBox, 2, 1, 3, 6, 3, 5, Blocks.air, Blocks.air, false);
            this.fillWithBlocks(world, structureBoundingBox, 3, 1, 2, 5, 3, 6, Blocks.air, Blocks.air, false);
            this.fillWithBlocks(world, structureBoundingBox, 2, 0, 3, 6, 0, 5, Blocks.hay_block, Blocks.hay_block, false);
            this.fillWithBlocks(world, structureBoundingBox, 3, 0, 2, 5, 0, 6, Blocks.hay_block, Blocks.hay_block, false);
            this.fillWithBlocks(world, structureBoundingBox, 1, 4, 3, 7, 4, 5, Blocks.hay_block, Blocks.hay_block, false);
            this.fillWithBlocks(world, structureBoundingBox, 3, 4, 1, 5, 4, 7, Blocks.hay_block, Blocks.hay_block, false);
            this.placeBlockAtCurrentPosition(world, Blocks.hay_block, 0, 2, 4, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.hay_block, 0, 2, 4, 6, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.hay_block, 0, 6, 4, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.hay_block, 0, 6, 4, 6, structureBoundingBox);
            this.fillWithBlocks(world, structureBoundingBox, 2, 5, 3, 6, 5, 5, Blocks.hay_block, Blocks.hay_block, false);
            this.fillWithBlocks(world, structureBoundingBox, 3, 5, 2, 5, 5, 6, Blocks.hay_block, Blocks.hay_block, false);
            this.fillWithBlocks(world, structureBoundingBox, 3, 6, 3, 5, 6, 5, Blocks.hay_block, Blocks.hay_block, false);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 1, 2, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 7, 2, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 4, 2, 7, structureBoundingBox);
            this.placeDoorAtCurrentPosition(world, structureBoundingBox, random, 4, 1, 1, this.getMetadataWithOffset(Blocks.wooden_door, 1));
            this.fillWithBlocks(world, structureBoundingBox, 3, 1, 0, 5, 2, 0, Blocks.air, Blocks.air, false);
            for (int i = 0; i < 3; ++i) {
                this.placeBlockAtCurrentPosition(world, (Block)Blocks.wooden_slab, 4, 3 + i, 3, 2, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, (Block)Blocks.wooden_slab, 4, 3 + i, 3, 6, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, (Block)Blocks.wooden_slab, 4, 2, 3, 3 + i, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, (Block)Blocks.wooden_slab, 4, 6, 3, 3 + i, structureBoundingBox);
            }
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 6, 1, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 6, 2, 5, structureBoundingBox);
            this.spawnEntity(world, structureBoundingBox, 4, 2, 4, 0);
            this.spawnEntity(world, structureBoundingBox, 4, 2, 4, 0);
            return true;
        }
        
        @Override
        protected EntityLiving getNewEntity(final World world, final int choice) {
            return (EntityLiving)new EntityZulu(world, EnumVillager.ZULU_WARRIOR);
        }
    }
    
    public static class House3 extends GlobalVillage
    {
        public House3() {
        }
        
        public House3(final StructureVillagePieces.Start villagePiece, final int componentType, final Random random, final StructureBoundingBox structureBoundingBox, final int coordBaseMode) {
            super(EnumVillagePiece.ZULU_HOUSE3, villagePiece, componentType, structureBoundingBox, coordBaseMode);
            this.setOffset(5);
        }
        
        public static House3 buildComponent(final StructureVillagePieces.Start villagePiece, final List pieces, final Random random, final int x, final int y, final int z, final int coordBaseMode, final int p5) {
            final StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(x, y, z, 0, 0, 0, 11, 7, 7, coordBaseMode);
            return (canVillageGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(pieces, structureboundingbox) == null) ? new House3(villagePiece, p5, random, structureboundingbox, coordBaseMode) : null;
        }
        
        @Override
        public boolean build(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
            for (int x = 1; x < 10; ++x) {
                for (int z = 2; z < 5; ++z) {
                    this.func_151554_b(world, Blocks.dirt, 0, x, -1, z, structureBoundingBox);
                    this.clearCurrentPositionBlocksUpwards(world, x, 1, z, structureBoundingBox);
                }
            }
            for (int x = 2; x < 9; ++x) {
                this.func_151554_b(world, Blocks.dirt, 0, x, -1, 1, structureBoundingBox);
                this.func_151554_b(world, Blocks.dirt, 0, x, -1, 5, structureBoundingBox);
                this.clearCurrentPositionBlocksUpwards(world, x, 1, 1, structureBoundingBox);
                this.clearCurrentPositionBlocksUpwards(world, x, 1, 5, structureBoundingBox);
            }
            this.fillWithBlocks(world, structureBoundingBox, 0, 3, 0, 10, 3, 6, Blocks.hay_block, Blocks.hay_block, false);
            this.fillWithBlocks(world, structureBoundingBox, 1, 4, 1, 9, 4, 5, Blocks.hay_block, Blocks.hay_block, false);
            this.fillWithBlocks(world, structureBoundingBox, 2, 5, 2, 8, 5, 4, Blocks.hay_block, Blocks.hay_block, false);
            this.fillWithBlocks(world, structureBoundingBox, 2, 0, 1, 8, 3, 1, Blocks.stained_hardened_clay, Blocks.air, false);
            this.fillWithBlocks(world, structureBoundingBox, 2, 0, 5, 8, 3, 5, Blocks.stained_hardened_clay, Blocks.air, false);
            this.fillWithBlocks(world, structureBoundingBox, 1, 0, 2, 1, 3, 4, Blocks.stained_hardened_clay, Blocks.air, false);
            this.fillWithBlocks(world, structureBoundingBox, 9, 0, 2, 9, 3, 4, Blocks.stained_hardened_clay, Blocks.air, false);
            this.fillWithBlocks(world, structureBoundingBox, 0, 3, 0, 1, 4, 1, Blocks.air, Blocks.air, false);
            this.fillWithBlocks(world, structureBoundingBox, 0, 3, 5, 1, 4, 6, Blocks.air, Blocks.air, false);
            this.fillWithBlocks(world, structureBoundingBox, 9, 3, 0, 10, 4, 1, Blocks.air, Blocks.air, false);
            this.fillWithBlocks(world, structureBoundingBox, 9, 3, 5, 10, 4, 6, Blocks.air, Blocks.air, false);
            this.fillWithBlocks(world, structureBoundingBox, 2, 1, 2, 8, 3, 4, Blocks.air, Blocks.air, false);
            this.fillWithBlocks(world, structureBoundingBox, 2, 0, 2, 8, 0, 4, Blocks.hay_block, Blocks.hay_block, false);
            this.placeBlockAtCurrentPosition(world, Blocks.hay_block, 0, 1, 3, 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.hay_block, 0, 1, 3, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.hay_block, 0, 9, 3, 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.hay_block, 0, 9, 3, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 3, 2, 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 7, 2, 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 3, 2, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 7, 2, 5, structureBoundingBox);
            this.placeDoorAtCurrentPosition(world, structureBoundingBox, random, 5, 1, 1, this.getMetadataWithOffset(Blocks.wooden_door, 1));
            this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 5, 2, 4, structureBoundingBox);
            this.fillWithBlocks(world, structureBoundingBox, 3, 1, 0, 7, 2, 0, Blocks.air, Blocks.air, false);
            this.spawnEntity(world, structureBoundingBox, 5, 2, 3, 0);
            this.spawnEntity(world, structureBoundingBox, 5, 2, 3, 1);
            return true;
        }
        
        @Override
        protected EntityLiving getNewEntity(final World world, final int choice) {
            switch (choice) {
                case 0: {
                    return (EntityLiving)new EntityZulu(world, EnumVillager.ZULU_CHIEF);
                }
                case 1: {
                    return (EntityLiving)new EntityZulu(world, EnumVillager.ZULU_WARRIOR);
                }
                default: {
                    return null;
                }
            }
        }
    }
    
    public static class House4 extends GlobalVillage
    {
        public House4() {
        }
        
        public House4(final StructureVillagePieces.Start villagePiece, final int componentType, final Random random, final StructureBoundingBox structureBoundingBox, final int coordBaseMode) {
            super(EnumVillagePiece.ZULU_HOUSE4, villagePiece, componentType, structureBoundingBox, coordBaseMode);
            this.setOffset(3);
        }
        
        public static House4 buildComponent(final StructureVillagePieces.Start villagePiece, final List pieces, final Random random, final int x, final int y, final int z, final int coordBaseMode, final int p5) {
            final StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(x, y, z, 0, 0, 0, 8, 5, 8, coordBaseMode);
            return (canVillageGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(pieces, structureboundingbox) == null) ? new House4(villagePiece, p5, random, structureboundingbox, coordBaseMode) : null;
        }
        
        @Override
        public boolean build(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
            for (int x = 1; x < 6; ++x) {
                for (int z = 2; z < 5; ++z) {
                    this.func_151554_b(world, Blocks.dirt, 0, x, -1, z, structureBoundingBox);
                    this.clearCurrentPositionBlocksUpwards(world, x, 1, z, structureBoundingBox);
                }
            }
            for (int x = 2; x < 5; ++x) {
                this.func_151554_b(world, Blocks.dirt, 0, x, -1, 1, structureBoundingBox);
                this.func_151554_b(world, Blocks.dirt, 0, x, -1, 5, structureBoundingBox);
                this.clearCurrentPositionBlocksUpwards(world, x, 1, 1, structureBoundingBox);
                this.clearCurrentPositionBlocksUpwards(world, x, 1, 5, structureBoundingBox);
            }
            this.fillWithBlocks(world, structureBoundingBox, 0, 3, 2, 0, 3, 4, Blocks.hay_block, Blocks.hay_block, false);
            this.fillWithBlocks(world, structureBoundingBox, 1, 4, 2, 1, 4, 4, Blocks.hay_block, Blocks.hay_block, false);
            this.fillWithBlocks(world, structureBoundingBox, 1, 0, 2, 1, 3, 4, this.func_151558_b(Blocks.stained_hardened_clay, 7), Blocks.air, false);
            this.fillWithBlocks(world, structureBoundingBox, 6, 3, 2, 6, 3, 4, Blocks.hay_block, Blocks.hay_block, false);
            this.fillWithBlocks(world, structureBoundingBox, 5, 4, 2, 5, 4, 4, Blocks.hay_block, Blocks.hay_block, false);
            this.fillWithBlocks(world, structureBoundingBox, 5, 0, 2, 5, 3, 4, this.func_151558_b(Blocks.stained_hardened_clay, 7), Blocks.air, false);
            this.fillWithBlocks(world, structureBoundingBox, 2, 3, 0, 4, 3, 0, Blocks.hay_block, Blocks.hay_block, false);
            this.fillWithBlocks(world, structureBoundingBox, 2, 4, 1, 4, 4, 1, Blocks.hay_block, Blocks.hay_block, false);
            this.fillWithBlocks(world, structureBoundingBox, 2, 0, 1, 4, 3, 1, this.func_151558_b(Blocks.stained_hardened_clay, 7), Blocks.air, false);
            this.fillWithBlocks(world, structureBoundingBox, 2, 3, 6, 4, 3, 6, Blocks.hay_block, Blocks.hay_block, false);
            this.fillWithBlocks(world, structureBoundingBox, 2, 4, 5, 4, 4, 5, Blocks.hay_block, Blocks.hay_block, false);
            this.fillWithBlocks(world, structureBoundingBox, 2, 0, 5, 4, 3, 5, this.func_151558_b(Blocks.stained_hardened_clay, 7), Blocks.air, false);
            this.fillWithBlocks(world, structureBoundingBox, 2, 4, 2, 4, 5, 4, Blocks.hay_block, Blocks.hay_block, false);
            this.placeBlockAtCurrentPosition(world, Blocks.hay_block, 0, 1, 3, 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.hay_block, 0, 1, 3, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.hay_block, 0, 5, 3, 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.hay_block, 0, 5, 3, 5, structureBoundingBox);
            this.fillWithBlocks(world, structureBoundingBox, 2, 0, 2, 4, 0, 4, Blocks.hay_block, Blocks.hay_block, false);
            this.placeDoorAtCurrentPosition(world, structureBoundingBox, random, 3, 1, 1, this.getMetadataWithOffset(Blocks.wooden_door, 1));
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 1, 2, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 5, 2, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 3, 2, 4, structureBoundingBox);
            this.spawnEntity(world, structureBoundingBox, 3, 2, 3, 0);
            return true;
        }
        
        @Override
        protected EntityLiving getNewEntity(final World world, final int choice) {
            return (EntityLiving)new EntityZulu(world, EnumVillager.ZULU_GURU);
        }
    }
    
    public static class Livestock extends GlobalVillage
    {
        public Livestock() {
        }
        
        public Livestock(final StructureVillagePieces.Start villagePiece, final int componentType, final Random random, final StructureBoundingBox structureBoundingBox, final int coordBaseMode) {
            super(EnumVillagePiece.ZULU_LIVESTOCK, villagePiece, componentType, structureBoundingBox, coordBaseMode);
            this.setOffset(3);
        }
        
        public static Livestock buildComponent(final StructureVillagePieces.Start villagePiece, final List pieces, final Random random, final int x, final int y, final int z, final int coordBaseMode, final int p5) {
            final StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(x, y, z, 0, 0, 0, 10, 4, 10, coordBaseMode);
            return (canVillageGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(pieces, structureboundingbox) == null) ? new Livestock(villagePiece, p5, random, structureboundingbox, coordBaseMode) : null;
        }
        
        @Override
        public boolean build(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
            this.fillWithBlocks(world, structureBoundingBox, 0, -3, 0, 9, 0, 9, (Block)Blocks.grass, (Block)Blocks.grass, false);
            for (int x = 0; x < 10; ++x) {
                for (int z = 0; z < 10; ++z) {
                    this.func_151554_b(world, Blocks.dirt, 0, x, -1, z, structureBoundingBox);
                    this.clearCurrentPositionBlocksUpwards(world, x, 1, z, structureBoundingBox);
                }
            }
            this.fillWithBlocks(world, structureBoundingBox, 0, 0, 0, 9, 0, 9, Blocks.fence, Blocks.air, false);
            this.fillWithBlocks(world, structureBoundingBox, 1, 0, 1, 8, 0, 8, Blocks.air, Blocks.air, false);
            this.placeBlockAtCurrentPosition(world, Blocks.fence_gate, this.getMetadataWithOffset(Blocks.fence_gate, 0), 3, 0, 0, structureBoundingBox);
            this.spawnEntity(world, structureBoundingBox, 4, 2, 4, 0);
            this.spawnEntity(world, structureBoundingBox, 4, 2, 4, 1);
            this.spawnEntity(world, structureBoundingBox, 4, 2, 4, 1);
            this.spawnEntity(world, structureBoundingBox, 4, 2, 4, 1);
            this.spawnEntity(world, structureBoundingBox, 4, 2, 4, 1);
            return true;
        }
        
        @Override
        protected EntityLiving getNewEntity(final World world, final int choice) {
            switch (choice) {
                case 0: {
                    return (EntityLiving)new EntityZulu(world, EnumVillager.ZULU_BREEDER);
                }
                case 1: {
                    return (EntityLiving)new EntityCow(world);
                }
                default: {
                    return null;
                }
            }
        }
    }
    
    public static class Torch extends GlobalTorch
    {
        public Torch() {
        }
        
        public Torch(final StructureVillagePieces.Start startPiece, final int componentType, final Random random, final StructureBoundingBox structureBoundingBox, final int coordBaseMode) {
            super(EnumVillageBasicPiece.ZOULOU_TORCH, startPiece, componentType, random, structureBoundingBox, coordBaseMode);
            this.setOffset(3);
        }
        
        @Override
        public boolean build(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
            this.fillWithBlocks(world, structureBoundingBox, 0, 0, 0, 2, 3, 1, Blocks.air, Blocks.air, false);
            this.placeBlockAtCurrentPosition(world, Blocks.log2, 0, 1, 0, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 1, 1, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 1, 2, 0, structureBoundingBox);
            return true;
        }
    }
}
