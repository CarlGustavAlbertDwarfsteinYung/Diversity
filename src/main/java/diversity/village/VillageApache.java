// 
// Decompiled by Procyon v0.5.36
// 

package diversity.village;

import net.minecraft.entity.passive.EntityHorse;
import diversity.suppliers.EnumVillageBasicPiece;
import diversity.entity.EntityApache;
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

public final class VillageApache extends VillageTools
{
    private static VillageApache instance;
    
    public VillageApache(final EnumVillage ENUM) {
        super(ENUM);
        VillageApache.instance = this;
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
    
    public static class Start extends GlobalStart
    {
        public Start() {
        }
        
        public Start(final WorldChunkManager p_i2104_1_, final int p_i2104_2_, final Random p_i2104_3_, final int p_i2104_4_, final int p_i2104_5_, final List p_i2104_6_, final int p_i2104_7_) {
            super(VillageApache.instance, p_i2104_1_, p_i2104_2_, p_i2104_3_, p_i2104_4_, p_i2104_5_, p_i2104_6_, p_i2104_7_);
        }
        
        @Override
        public boolean addComponentParts(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
            if (super.addComponentParts(world, random, structureBoundingBox, 3)) {
                return true;
            }
            this.fillWithBlocks(world, structureBoundingBox, 0, 0, 0, 5, 9, 5, Blocks.dirt, Blocks.dirt, false);
            this.fillWithBlocks(world, structureBoundingBox, 0, 10, 0, 5, 10, 5, Blocks.stained_hardened_clay, Blocks.stained_hardened_clay, false);
            for (int i = 0; i < 6; ++i) {
                for (int j = 0; j < 6; ++j) {
                    this.clearCurrentPositionBlocksUpwards(world, j, 11, i, structureBoundingBox);
                }
            }
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 0, 11, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 0, 11, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 5, 11, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 5, 11, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 0, 12, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 0, 12, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 5, 12, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 5, 12, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.skull, this.getMetadataWithOffset(Blocks.skull, 1), 0, 13, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.skull, this.getMetadataWithOffset(Blocks.skull, 1), 0, 13, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.skull, this.getMetadataWithOffset(Blocks.skull, 1), 5, 13, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.skull, this.getMetadataWithOffset(Blocks.skull, 1), 5, 13, 5, structureBoundingBox);
            return true;
        }
    }
    
    public static class Path extends GlobalPath
    {
        public Path() {
        }
        
        public Path(final GlobalStart p_i2105_1_, final int p_i2105_2_, final Random p_i2105_3_, final StructureBoundingBox p_i2105_4_, final int p_i2105_5_) {
            super(VillageApache.instance, p_i2105_1_, p_i2105_2_, p_i2105_3_, p_i2105_4_, p_i2105_5_);
        }
        
        @Override
        protected BlockData getPathBlock(final Random random) {
            return new BlockData(Blocks.stained_hardened_clay, 0);
        }
        
        @Override
        protected BlockData getPathBridge(final Random random) {
            return new BlockData((Block)Blocks.wooden_slab, 0);
        }
        
        @Override
        protected BlockData getUnderPathBlock(final Random random) {
            return new BlockData(Blocks.cobblestone, 0);
        }
    }
    
    public static class House1 extends GlobalVillage
    {
        public House1() {
        }
        
        public House1(final StructureVillagePieces.Start villagePiece, final int componentType, final Random random, final StructureBoundingBox structureBoundingBox, final int coordBaseMode) {
            super(EnumVillagePiece.APACHE_HOUSE1, villagePiece, componentType, structureBoundingBox, coordBaseMode);
            this.setOffset(4);
        }
        
        public static House1 buildComponent(final StructureVillagePieces.Start villagePiece, final List pieces, final Random random, final int x, final int y, final int z, final int coordBaseMode, final int p5) {
            final StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(x, y, z, 0, 0, 0, 13, 6, 13, coordBaseMode);
            return (canVillageGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(pieces, structureboundingbox) == null) ? new House1(villagePiece, p5, random, structureboundingbox, coordBaseMode) : null;
        }
        
        @Override
        public boolean build(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
            final int radius = 6;
            final int base = 6;
            for (int y = 1; y < radius; ++y) {
                for (int x = -6; x < 7; ++x) {
                    for (int z = -6; z < 7; ++z) {
                        if (y == Math.abs(x) + Math.abs(z)) {
                            this.clearCurrentPositionBlocksUpwards(world, base + x, 1, base + z, structureBoundingBox);
                            this.func_151554_b(world, Blocks.stained_hardened_clay, 8, base + x, 0, base + z, structureBoundingBox);
                            this.placeBlockAtCurrentPosition(world, Blocks.wool, 0, base + x, radius - y, base + z, structureBoundingBox);
                            if (y != radius - 1) {
                                this.placeBlockAtCurrentPosition(world, Blocks.wool, 12, base + x, 0, base + z, structureBoundingBox);
                            }
                            if (radius - y == 2) {
                                this.placeBlockAtCurrentPosition(world, Blocks.carpet, 7, base + x, 1, base + z, structureBoundingBox);
                            }
                        }
                        if ((y == Math.abs(x) && z == 0) || (x == 0 && y == Math.abs(z))) {
                            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, base + x, radius - y + 1, base + z, structureBoundingBox);
                        }
                    }
                }
            }
            this.clearCurrentPositionBlocksUpwards(world, base, 2, 0, structureBoundingBox);
            this.func_151554_b(world, Blocks.stained_hardened_clay, 8, base, 0, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, base, 1, 0, structureBoundingBox);
            this.clearCurrentPositionBlocksUpwards(world, base, 2, 12, structureBoundingBox);
            this.func_151554_b(world, Blocks.stained_hardened_clay, 8, base, 0, 12, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, base, 1, 12, structureBoundingBox);
            this.clearCurrentPositionBlocksUpwards(world, 0, 2, base, structureBoundingBox);
            this.func_151554_b(world, Blocks.stained_hardened_clay, 8, 0, 0, base, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 0, 1, base, structureBoundingBox);
            this.clearCurrentPositionBlocksUpwards(world, 12, 2, base, structureBoundingBox);
            this.func_151554_b(world, Blocks.stained_hardened_clay, 8, 12, 0, base, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 12, 1, base, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.wool, 0, base, 5, base, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.wool, 12, base, 0, base, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, base, 1, base, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, base, 2, base, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, base, 3, base, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, base, 4, base, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, base, 6, base, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.carpet, 7, base - 3, 1, base, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.carpet, 7, base + 3, 1, base, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.carpet, 7, base, 1, base - 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.carpet, 7, base, 1, base + 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 4, 1, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 4, 2, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.wool, 0, 5, 1, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.wool, 0, 3, 2, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.wool, 0, 4, 3, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.wool, 0, 5, 1, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.wool, 0, 5, 2, 4, structureBoundingBox);
            this.placeDoorAtCurrentPosition(world, structureBoundingBox, random, 4, 1, 4, this.getMetadataWithOffset(Blocks.wooden_door, 1));
            this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 5, 3, 5, structureBoundingBox);
            this.spawnEntity(world, structureBoundingBox, 6, 2, 6, 0);
            this.spawnEntity(world, structureBoundingBox, 6, 2, 6, 0);
            return true;
        }
        
        @Override
        protected EntityLiving getNewEntity(final World world, final int choice) {
            return (EntityLiving)new EntityApache(world, EnumVillager.APACHE_HUNTER);
        }
    }
    
    public static class House2 extends GlobalVillage
    {
        public House2() {
        }
        
        public House2(final StructureVillagePieces.Start villagePiece, final int componentType, final Random random, final StructureBoundingBox structureBoundingBox, final int coordBaseMode) {
            super(EnumVillagePiece.APACHE_HOUSE2, villagePiece, componentType, structureBoundingBox, coordBaseMode);
            this.setOffset(3);
        }
        
        public static House2 buildComponent(final StructureVillagePieces.Start villagePiece, final List pieces, final Random random, final int x, final int y, final int z, final int coordBaseMode, final int p5) {
            final StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(x, y, z, 0, 0, 0, 11, 5, 11, coordBaseMode);
            return (canVillageGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(pieces, structureboundingbox) == null) ? new House2(villagePiece, p5, random, structureboundingbox, coordBaseMode) : null;
        }
        
        @Override
        public boolean build(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
            final int radius = 5;
            final int base = 5;
            for (int y = 1; y < radius; ++y) {
                for (int x = -5; x < 6; ++x) {
                    for (int z = -5; z < 6; ++z) {
                        if (y == Math.abs(x) + Math.abs(z)) {
                            this.clearCurrentPositionBlocksUpwards(world, base + x, 1, base + z, structureBoundingBox);
                            this.func_151554_b(world, Blocks.stained_hardened_clay, 8, base + x, 0, base + z, structureBoundingBox);
                            this.placeBlockAtCurrentPosition(world, Blocks.wool, 0, base + x, radius - y, base + z, structureBoundingBox);
                            if (y != radius - 1) {
                                this.placeBlockAtCurrentPosition(world, Blocks.wool, 12, base + x, 0, base + z, structureBoundingBox);
                            }
                            if (radius - y == 2) {
                                this.placeBlockAtCurrentPosition(world, Blocks.carpet, 7, base + x, 1, base + z, structureBoundingBox);
                            }
                        }
                        if ((y == Math.abs(x) && z == 0) || (x == 0 && y == Math.abs(z))) {
                            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, base + x, radius - y + 1, base + z, structureBoundingBox);
                        }
                    }
                }
            }
            this.clearCurrentPositionBlocksUpwards(world, base, 2, 0, structureBoundingBox);
            this.func_151554_b(world, Blocks.stained_hardened_clay, 8, base, 0, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, base, 1, 0, structureBoundingBox);
            this.clearCurrentPositionBlocksUpwards(world, base, 2, 10, structureBoundingBox);
            this.func_151554_b(world, Blocks.stained_hardened_clay, 8, base, 0, 10, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, base, 1, 10, structureBoundingBox);
            this.clearCurrentPositionBlocksUpwards(world, 0, 2, base, structureBoundingBox);
            this.func_151554_b(world, Blocks.stained_hardened_clay, 8, 0, 0, base, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 0, 1, base, structureBoundingBox);
            this.clearCurrentPositionBlocksUpwards(world, 10, 2, base, structureBoundingBox);
            this.func_151554_b(world, Blocks.stained_hardened_clay, 8, 10, 0, base, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 10, 1, base, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.wool, 0, base, 4, base, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.wool, 12, base, 0, base, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, base, 5, base, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.carpet, 7, base - 2, 1, base, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.carpet, 7, base + 2, 1, base, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.carpet, 7, base, 1, base - 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.carpet, 7, base, 1, base + 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.wool, 0, 3, 2, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.wool, 0, 5, 2, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.wool, 0, 5, 1, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.wool, 0, 5, 1, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.wool, 0, 4, 3, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 4, 1, 2, structureBoundingBox);
            this.placeDoorAtCurrentPosition(world, structureBoundingBox, random, 4, 1, 3, this.getMetadataWithOffset(Blocks.wooden_door, 1));
            this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 4, 3, 5, structureBoundingBox);
            this.spawnEntity(world, structureBoundingBox, 5, 2, 5, 0);
            this.spawnEntity(world, structureBoundingBox, 5, 2, 5, 0);
            return true;
        }
        
        @Override
        protected EntityLiving getNewEntity(final World world, final int choice) {
            return (EntityLiving)new EntityApache(world, EnumVillager.APACHE_WARRIOR);
        }
    }
    
    public static class ChiefTent extends GlobalVillage
    {
        public ChiefTent() {
        }
        
        public ChiefTent(final StructureVillagePieces.Start villagePiece, final int componentType, final Random random, final StructureBoundingBox structureBoundingBox, final int coordBaseMode) {
            super(EnumVillagePiece.APACHE_CHIEFTENT, villagePiece, componentType, structureBoundingBox, coordBaseMode);
            this.setOffset(5);
        }
        
        public static ChiefTent buildComponent(final StructureVillagePieces.Start villagePiece, final List pieces, final Random random, final int x, final int y, final int z, final int coordBaseMode, final int p5) {
            final StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(x, y, z, 0, 0, 0, 15, 7, 13, coordBaseMode);
            return (canVillageGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(pieces, structureboundingbox) == null) ? new ChiefTent(villagePiece, p5, random, structureboundingbox, coordBaseMode) : null;
        }
        
        @Override
        public boolean build(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
            this.placeBlockAtCurrentPosition(world, Blocks.wool, 0, 1, 1, 5, structureBoundingBox);
            this.clearCurrentPositionBlocksUpwards(world, 1, 2, 5, structureBoundingBox);
            this.func_151554_b(world, Blocks.stained_hardened_clay, 8, 1, 0, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.wool, 0, 13, 1, 5, structureBoundingBox);
            this.clearCurrentPositionBlocksUpwards(world, 13, 2, 5, structureBoundingBox);
            this.func_151554_b(world, Blocks.stained_hardened_clay, 8, 13, 0, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.wool, 0, 7, 1, 11, structureBoundingBox);
            this.clearCurrentPositionBlocksUpwards(world, 7, 2, 11, structureBoundingBox);
            this.func_151554_b(world, Blocks.stained_hardened_clay, 8, 7, 0, 11, structureBoundingBox);
            this.clearCurrentPositionBlocksUpwards(world, 2, 3, 5, structureBoundingBox);
            this.func_151554_b(world, Blocks.stained_hardened_clay, 8, 2, 0, 5, structureBoundingBox);
            this.fillWithBlocks(world, structureBoundingBox, 2, 1, 5, 2, 2, 5, Blocks.wool, Blocks.wool, false);
            this.clearCurrentPositionBlocksUpwards(world, 12, 3, 5, structureBoundingBox);
            this.func_151554_b(world, Blocks.stained_hardened_clay, 8, 12, 0, 5, structureBoundingBox);
            this.fillWithBlocks(world, structureBoundingBox, 12, 1, 5, 12, 2, 5, Blocks.wool, Blocks.wool, false);
            this.clearCurrentPositionBlocksUpwards(world, 7, 3, 10, structureBoundingBox);
            this.func_151554_b(world, Blocks.stained_hardened_clay, 8, 7, 0, 10, structureBoundingBox);
            this.fillWithBlocks(world, structureBoundingBox, 7, 1, 10, 7, 2, 10, Blocks.wool, Blocks.wool, false);
            for (int k = 0; k < 3; ++k) {
                this.clearCurrentPositionBlocksUpwards(world, 3, 1, 4 + k, structureBoundingBox);
                this.func_151554_b(world, Blocks.stained_hardened_clay, 8, 3, 0, 4 + k, structureBoundingBox);
                this.clearCurrentPositionBlocksUpwards(world, 11, 1, 4 + k, structureBoundingBox);
                this.func_151554_b(world, Blocks.stained_hardened_clay, 8, 11, 0, 4 + k, structureBoundingBox);
                this.clearCurrentPositionBlocksUpwards(world, 6 + k, 1, 1, structureBoundingBox);
                this.func_151554_b(world, Blocks.stained_hardened_clay, 8, 6 + k, 0, 1, structureBoundingBox);
                this.clearCurrentPositionBlocksUpwards(world, 6 + k, 1, 9, structureBoundingBox);
                this.func_151554_b(world, Blocks.stained_hardened_clay, 8, 6 + k, 0, 9, structureBoundingBox);
            }
            for (int x = 4; x < 11; ++x) {
                for (int z = 3; z < 8; ++z) {
                    this.clearCurrentPositionBlocksUpwards(world, x, 1, z, structureBoundingBox);
                    this.func_151554_b(world, Blocks.stained_hardened_clay, 8, x, 0, z, structureBoundingBox);
                }
            }
            for (int x = 5; x < 10; ++x) {
                this.clearCurrentPositionBlocksUpwards(world, x, 1, 2, structureBoundingBox);
                this.func_151554_b(world, Blocks.stained_hardened_clay, 8, x, 0, 2, structureBoundingBox);
                this.clearCurrentPositionBlocksUpwards(world, x, 1, 8, structureBoundingBox);
                this.func_151554_b(world, Blocks.stained_hardened_clay, 8, x, 0, 8, structureBoundingBox);
            }
            this.fillWithBlocks(world, structureBoundingBox, 3, 1, 4, 3, 3, 6, Blocks.wool, Blocks.wool, false);
            this.fillWithBlocks(world, structureBoundingBox, 11, 1, 4, 11, 3, 6, Blocks.wool, Blocks.wool, false);
            this.fillWithBlocks(world, structureBoundingBox, 6, 1, 9, 8, 3, 9, Blocks.wool, Blocks.wool, false);
            this.fillWithBlocks(world, structureBoundingBox, 6, 1, 1, 8, 3, 1, Blocks.wool, Blocks.wool, false);
            this.fillWithBlocks(world, structureBoundingBox, 4, 1, 3, 4, 4, 7, Blocks.wool, Blocks.wool, false);
            this.fillWithBlocks(world, structureBoundingBox, 10, 1, 3, 10, 4, 7, Blocks.wool, Blocks.wool, false);
            this.fillWithBlocks(world, structureBoundingBox, 5, 1, 8, 9, 4, 8, Blocks.wool, Blocks.wool, false);
            this.fillWithBlocks(world, structureBoundingBox, 5, 1, 2, 9, 4, 2, Blocks.wool, Blocks.wool, false);
            this.fillWithBlocks(world, structureBoundingBox, 5, 5, 3, 9, 5, 7, Blocks.wool, Blocks.wool, false);
            this.fillWithBlocks(world, structureBoundingBox, 6, 6, 4, 8, 6, 6, Blocks.wool, Blocks.wool, false);
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 5, 5, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.wool, 0, 5, 4, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 9, 5, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.wool, 0, 9, 4, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 5, 5, 7, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.wool, 0, 5, 4, 7, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 9, 5, 7, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.wool, 0, 9, 4, 7, structureBoundingBox);
            this.fillWithBlocks(world, structureBoundingBox, 4, 1, 4, 4, 3, 6, Blocks.air, Blocks.air, false);
            this.fillWithBlocks(world, structureBoundingBox, 10, 1, 4, 10, 3, 6, Blocks.air, Blocks.air, false);
            this.fillWithBlocks(world, structureBoundingBox, 6, 1, 8, 8, 3, 8, Blocks.air, Blocks.air, false);
            this.fillWithBlocks(world, structureBoundingBox, 6, 1, 2, 8, 3, 2, Blocks.air, Blocks.air, false);
            this.fillWithBlocks(world, structureBoundingBox, 6, 5, 4, 8, 5, 6, Blocks.air, Blocks.air, false);
            for (int i = 0; i < 7; ++i) {
                this.placeBlockAtCurrentPosition(world, Blocks.wool, 14, 6, 0, i + 2, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.wool, 14, 7, 0, i + 2, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.wool, 14, 8, 0, i + 2, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.wool, 14, i + 4, 0, 4, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.wool, 14, i + 4, 0, 5, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.wool, 14, i + 4, 0, 6, structureBoundingBox);
            }
            this.placeBlockAtCurrentPosition(world, Blocks.wool, 14, 5, 0, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.wool, 14, 9, 0, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.wool, 14, 5, 0, 7, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.wool, 14, 9, 0, 7, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.wool, 14, 7, 0, 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 0, 1, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 1, 2, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 2, 3, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 3, 4, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 3, 4, 6, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 4, 5, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 4, 5, 6, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 5, 6, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 5, 6, 6, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 6, 7, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 6, 7, 6, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 7, 7, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 7, 7, 6, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 8, 7, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 8, 7, 6, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 9, 6, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 9, 6, 6, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 10, 5, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 10, 5, 6, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 11, 4, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 11, 4, 6, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 12, 3, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 13, 2, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 14, 1, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 7, 1, 12, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 7, 2, 11, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 7, 3, 10, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 6, 4, 9, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 8, 4, 9, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 6, 5, 8, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 8, 5, 8, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 6, 6, 7, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 8, 6, 7, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 6, 7, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 8, 7, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 6, 6, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 8, 6, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 6, 5, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 8, 5, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 6, 4, 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 8, 4, 1, structureBoundingBox);
            this.fillWithBlocks(world, structureBoundingBox, 6, 1, 0, 6, 3, 0, Blocks.fence, Blocks.fence, false);
            this.fillWithBlocks(world, structureBoundingBox, 8, 1, 0, 8, 3, 0, Blocks.fence, Blocks.fence, false);
            this.placeDoorAtCurrentPosition(world, structureBoundingBox, random, 7, 1, 1, this.getMetadataWithOffset(Blocks.wooden_door, 1));
            this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 4, 3, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 10, 3, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 7, 3, 8, structureBoundingBox);
            this.spawnEntity(world, structureBoundingBox, 7, 2, 5, 0);
            return true;
        }
        
        @Override
        protected EntityLiving getNewEntity(final World world, final int choice) {
            return (EntityLiving)new EntityApache(world, EnumVillager.APACHE_CHIEF);
        }
    }
    
    public static class ShamanTent extends GlobalVillage
    {
        public ShamanTent() {
        }
        
        public ShamanTent(final StructureVillagePieces.Start villagePiece, final int componentType, final Random random, final StructureBoundingBox structureBoundingBox, final int coordBaseMode) {
            super(EnumVillagePiece.APACHE_SHAMANTENT, villagePiece, componentType, structureBoundingBox, coordBaseMode);
            this.setOffset(3);
        }
        
        public static ShamanTent buildComponent(final StructureVillagePieces.Start villagePiece, final List pieces, final Random random, final int x, final int y, final int z, final int coordBaseMode, final int p5) {
            final StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(x, y, z, 0, 0, 0, 11, 5, 10, coordBaseMode);
            return (canVillageGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(pieces, structureboundingbox) == null) ? new ShamanTent(villagePiece, p5, random, structureboundingbox, coordBaseMode) : null;
        }
        
        @Override
        public boolean build(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
            this.placeBlockAtCurrentPosition(world, Blocks.wool, 0, 1, 1, 4, structureBoundingBox);
            this.clearCurrentPositionBlocksUpwards(world, 1, 2, 4, structureBoundingBox);
            this.func_151554_b(world, Blocks.stained_hardened_clay, 8, 1, 0, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.wool, 0, 9, 1, 4, structureBoundingBox);
            this.clearCurrentPositionBlocksUpwards(world, 9, 2, 4, structureBoundingBox);
            this.func_151554_b(world, Blocks.stained_hardened_clay, 8, 9, 0, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.wool, 0, 5, 1, 8, structureBoundingBox);
            this.clearCurrentPositionBlocksUpwards(world, 5, 2, 8, structureBoundingBox);
            this.func_151554_b(world, Blocks.stained_hardened_clay, 8, 5, 0, 8, structureBoundingBox);
            for (int k = 0; k < 3; ++k) {
                this.clearCurrentPositionBlocksUpwards(world, 2, 1, 3 + k, structureBoundingBox);
                this.func_151554_b(world, Blocks.stained_hardened_clay, 8, 2, 0, 3 + k, structureBoundingBox);
                this.clearCurrentPositionBlocksUpwards(world, 8, 1, 3 + k, structureBoundingBox);
                this.func_151554_b(world, Blocks.stained_hardened_clay, 8, 8, 0, 3 + k, structureBoundingBox);
                this.clearCurrentPositionBlocksUpwards(world, 4 + k, 1, 1, structureBoundingBox);
                this.func_151554_b(world, Blocks.stained_hardened_clay, 8, 4 + k, 0, 1, structureBoundingBox);
                this.clearCurrentPositionBlocksUpwards(world, 4 + k, 1, 7, structureBoundingBox);
                this.func_151554_b(world, Blocks.stained_hardened_clay, 8, 4 + k, 0, 7, structureBoundingBox);
            }
            for (int x = 3; x < 8; ++x) {
                for (int z = 3; z < 6; ++z) {
                    this.clearCurrentPositionBlocksUpwards(world, x, 1, z, structureBoundingBox);
                    this.func_151554_b(world, Blocks.stained_hardened_clay, 8, x, 0, z, structureBoundingBox);
                }
            }
            for (int x = 4; x < 7; ++x) {
                this.clearCurrentPositionBlocksUpwards(world, x, 1, 2, structureBoundingBox);
                this.func_151554_b(world, Blocks.stained_hardened_clay, 8, x, 0, 2, structureBoundingBox);
                this.clearCurrentPositionBlocksUpwards(world, x, 1, 6, structureBoundingBox);
                this.func_151554_b(world, Blocks.stained_hardened_clay, 8, x, 0, 6, structureBoundingBox);
            }
            this.fillWithBlocks(world, structureBoundingBox, 2, 1, 3, 2, 2, 5, Blocks.wool, Blocks.wool, false);
            this.fillWithBlocks(world, structureBoundingBox, 8, 1, 3, 8, 2, 5, Blocks.wool, Blocks.wool, false);
            this.fillWithBlocks(world, structureBoundingBox, 4, 1, 1, 6, 2, 1, Blocks.wool, Blocks.wool, false);
            this.fillWithBlocks(world, structureBoundingBox, 4, 1, 7, 6, 2, 7, Blocks.wool, Blocks.wool, false);
            this.fillWithBlocks(world, structureBoundingBox, 3, 1, 2, 3, 3, 6, Blocks.wool, Blocks.wool, false);
            this.fillWithBlocks(world, structureBoundingBox, 7, 1, 2, 7, 3, 6, Blocks.wool, Blocks.wool, false);
            this.fillWithBlocks(world, structureBoundingBox, 3, 1, 2, 7, 3, 2, Blocks.wool, Blocks.wool, false);
            this.fillWithBlocks(world, structureBoundingBox, 3, 1, 6, 7, 3, 6, Blocks.wool, Blocks.wool, false);
            this.fillWithBlocks(world, structureBoundingBox, 4, 4, 3, 6, 4, 5, Blocks.wool, Blocks.wool, false);
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 3, 3, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 3, 3, 6, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 7, 3, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 7, 3, 6, structureBoundingBox);
            this.fillWithBlocks(world, structureBoundingBox, 3, 1, 3, 7, 2, 5, Blocks.air, Blocks.air, false);
            this.fillWithBlocks(world, structureBoundingBox, 4, 1, 2, 6, 2, 6, Blocks.air, Blocks.air, false);
            for (int i = 0; i < 5; ++i) {
                this.placeBlockAtCurrentPosition(world, Blocks.wool, 14, 4, 0, i + 2, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.wool, 14, 5, 0, i + 2, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.wool, 14, 6, 0, i + 2, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.wool, 14, i + 3, 0, 3, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.wool, 14, i + 3, 0, 4, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.wool, 14, i + 3, 0, 5, structureBoundingBox);
            }
            this.placeBlockAtCurrentPosition(world, Blocks.wool, 14, 5, 0, 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.wool, 0, 5, 3, 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.wool, 0, 5, 4, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 0, 1, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 1, 2, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 2, 3, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 2, 3, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 3, 4, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 3, 4, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 4, 5, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 4, 5, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 5, 5, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 5, 5, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 6, 5, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 6, 5, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 7, 4, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 7, 4, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 8, 3, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 8, 3, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 9, 2, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 10, 1, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 5, 1, 9, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 5, 2, 8, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 4, 3, 7, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 6, 3, 7, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 4, 4, 6, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 6, 4, 6, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 4, 5, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 6, 5, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 4, 4, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 6, 4, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 4, 3, 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 6, 3, 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 4, 2, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 4, 1, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 6, 2, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 6, 1, 0, structureBoundingBox);
            this.placeDoorAtCurrentPosition(world, structureBoundingBox, random, 5, 1, 1, this.getMetadataWithOffset(Blocks.wooden_door, 1));
            this.placeBlockAtCurrentPosition(world, Blocks.redstone_torch, 0, 3, 2, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.redstone_torch, 0, 7, 2, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.redstone_torch, 0, 5, 2, 6, structureBoundingBox);
            this.spawnEntity(world, structureBoundingBox, 5, 2, 4, 0);
            return true;
        }
        
        @Override
        protected EntityLiving getNewEntity(final World world, final int choice) {
            return (EntityLiving)new EntityApache(world, EnumVillager.APACHE_SHAMAN);
        }
    }
    
    public static class Torch extends GlobalTorch
    {
        public Torch() {
        }
        
        public Torch(final StructureVillagePieces.Start startPiece, final int componentType, final Random random, final StructureBoundingBox structureBoundingBox, final int coordBaseMode) {
            super(EnumVillageBasicPiece.APACHE_TORCH, startPiece, componentType, random, structureBoundingBox, coordBaseMode);
            this.setOffset(3);
        }
        
        @Override
        public boolean build(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
            this.fillWithBlocks(world, structureBoundingBox, 0, 0, 0, 2, 3, 1, Blocks.air, Blocks.air, false);
            this.placeBlockAtCurrentPosition(world, Blocks.wool, random.nextBoolean() ? 1 : 3, 1, 0, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 1, 1, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 1, 2, 0, structureBoundingBox);
            return true;
        }
    }
    
    public static class Livestock extends GlobalVillage
    {
        public Livestock() {
        }
        
        public Livestock(final StructureVillagePieces.Start villagePiece, final int componentType, final Random random, final StructureBoundingBox structureBoundingBox, final int coordBaseMode) {
            super(EnumVillagePiece.APACHE_LIVESTOCK, villagePiece, componentType, structureBoundingBox, coordBaseMode);
            this.setOffset(3);
        }
        
        public static Livestock buildComponent(final StructureVillagePieces.Start villagePiece, final List pieces, final Random random, final int x, final int y, final int z, final int coordBaseMode, final int p5) {
            final StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(x, y, z, 0, 0, 0, 10, 4, 10, coordBaseMode);
            return (canVillageGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(pieces, structureboundingbox) == null) ? new Livestock(villagePiece, p5, random, structureboundingbox, coordBaseMode) : null;
        }
        
        @Override
        public boolean build(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
            for (int x = 0; x < 10; ++x) {
                for (int z = 0; z < 10; ++z) {
                    this.func_151554_b(world, Blocks.stained_hardened_clay, 8, x, -1, z, structureBoundingBox);
                    this.placeBlockAtCurrentPosition(world, Blocks.dirt, 0, x, 0, z, structureBoundingBox);
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
                    return (EntityLiving)new EntityApache(world, EnumVillager.APACHE_BREEDER);
                }
                case 1: {
                    return (EntityLiving)new EntityHorse(world);
                }
                default: {
                    return null;
                }
            }
        }
    }
}
