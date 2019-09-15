// 
// Decompiled by Procyon v0.5.36
// 

package diversity.village;

import diversity.suppliers.EnumVillageBasicPiece;
import net.minecraft.entity.passive.EntityWolf;
import diversity.entity.EntityInuit;
import diversity.suppliers.EnumVillager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.world.gen.structure.StructureComponent;
import java.util.ArrayList;
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

public final class VillageInuit extends VillageTools
{
    private static VillageInuit instance;
    
    public VillageInuit(final EnumVillage village) {
        super(village);
        VillageInuit.instance = this;
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
            super(VillageInuit.instance, p_i2104_1_, p_i2104_2_, p_i2104_3_, p_i2104_4_, p_i2104_5_, p_i2104_6_, p_i2104_7_);
        }
        
        @Override
        public boolean addComponentParts(final World p_74875_1_, final Random p_74875_2_, final StructureBoundingBox p_74875_3_) {
            if (super.addComponentParts(p_74875_1_, p_74875_2_, p_74875_3_, 3)) {
                return true;
            }
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 0, 0, 5, 10, 5, Blocks.ice, (Block)Blocks.flowing_water, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 10, 0, 5, 10, 5, Blocks.snow, Blocks.snow, false);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 2, 10, 2, 3, 10, 3, Blocks.air, Blocks.air, false);
            for (int i = 0; i <= 5; ++i) {
                for (int j = 0; j <= 5; ++j) {
                    this.clearCurrentPositionBlocksUpwards(p_74875_1_, j, 11, i, p_74875_3_);
                }
            }
            this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.fence, 0, 1, 11, 3, p_74875_3_);
            this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.fence, 0, 1, 12, 3, p_74875_3_);
            this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.fence, 0, 4, 11, 3, p_74875_3_);
            this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.fence, 0, 4, 12, 3, p_74875_3_);
            this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.fence, 0, 2, 11, 1, p_74875_3_);
            this.fillWithBlocks(p_74875_1_, p_74875_3_, 1, 13, 3, 4, 13, 3, Blocks.fence, Blocks.fence, false);
            return true;
        }
    }
    
    public static class Path extends GlobalPath
    {
        public Path() {
        }
        
        public Path(final GlobalStart p_i2105_1_, final int p_i2105_2_, final Random p_i2105_3_, final StructureBoundingBox p_i2105_4_, final int p_i2105_5_) {
            super(VillageInuit.instance, p_i2105_1_, p_i2105_2_, p_i2105_3_, p_i2105_4_, p_i2105_5_);
        }
        
        @Override
        protected BlockData getPathBlock(final Random random) {
            return new BlockData(Blocks.snow, 0);
        }
        
        @Override
        protected BlockData getPathBridge(final Random random) {
            return new BlockData((Block)Blocks.wooden_slab, 1);
        }
        
        @Override
        protected BlockData getUnderPathBlock(final Random random) {
            return new BlockData(Blocks.cobblestone, 0);
        }
    }
    
    public abstract static class GlobalEskimoVillage extends GlobalVillage
    {
        public GlobalEskimoVillage() {
        }
        
        public GlobalEskimoVillage(final EnumVillagePiece enumPiece, final StructureVillagePieces.Start startPiece, final int componentType, final StructureBoundingBox structureBoundingBox, final int coordBaseMode) {
            super(enumPiece, startPiece, componentType, structureBoundingBox, coordBaseMode);
        }
        
        protected void generateSphere(final World world, final Random random, final StructureBoundingBox structureBoundingBox, final int baseX, final int baseZ, final int radius, final double offset, final int baseIncrement, final int topIncrement) {
            final List<Point> basePoints = new ArrayList<Point>();
            final List<Point> topPoints = new ArrayList<Point>();
            for (int baseDegree = 0; baseDegree < 360; baseDegree += baseIncrement) {
                for (int topDegree = 0; topDegree < 180; topDegree += topIncrement) {
                    final Point point = VillageTools.getSpherePoint(radius, baseDegree, topDegree, offset);
                    point.set(baseX + point.x, baseZ + point.z);
                    final Point sidePoint = VillageTools.getSpherePoint(radius, baseDegree, 180, offset);
                    sidePoint.set(baseX + sidePoint.x, baseZ + sidePoint.z);
                    this.func_151554_b(world, Blocks.packed_ice, 0, point.x, -1, point.z, structureBoundingBox);
                    if ((Math.abs(point.x - baseX) == radius - 1 || sidePoint.x == point.x) && (Math.abs(point.z - baseZ) == radius - 1 || sidePoint.z == point.z)) {
                        this.placeBlockAtCurrentPosition(world, Blocks.packed_ice, 0, point.x, 0, point.z, structureBoundingBox);
                    }
                    else if (random.nextInt(4) == 0 && point.x != 0 && point.x != 2 * baseX && point.z != 0 && point.z != 2 * baseZ) {
                        this.placeBlockAtCurrentPosition(world, Blocks.log, 3, point.x, 0, point.z, structureBoundingBox);
                    }
                    else {
                        this.placeBlockAtCurrentPosition(world, Blocks.snow, 0, point.x, 0, point.z, structureBoundingBox);
                    }
                    this.clearCurrentPositionBlocksUpwards(world, point.x, 1, point.z, structureBoundingBox);
                    this.placeBlockAtCurrentPosition(world, Blocks.packed_ice, 0, point.x, point.y, point.z, structureBoundingBox);
                }
            }
        }
    }
    
    public static class Igloo1 extends GlobalEskimoVillage
    {
        private StructureBoundingBox structureBoundingBox;
        private World world;
        
        public Igloo1() {
        }
        
        public Igloo1(final StructureVillagePieces.Start startPiece, final int componentType, final Random random, final StructureBoundingBox structureBoundingBox, final int coordBaseMode) {
            super(EnumVillagePiece.INUIT_IGLOO1, startPiece, componentType, structureBoundingBox, coordBaseMode);
            this.setOffset(3);
        }
        
        public static Igloo1 buildComponent(final StructureVillagePieces.Start villagePiece, final List pieces, final Random random, final int x, final int y, final int z, final int coordBaseMode, final int p5) {
            final StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(x, y, z, 0, 0, 0, 9, 5, 10, coordBaseMode);
            return (canVillageGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(pieces, structureboundingbox) == null) ? new Igloo1(villagePiece, p5, random, structureboundingbox, coordBaseMode) : null;
        }
        
        @Override
        public boolean build(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
            final int radius = 5;
            final int baseX = 4;
            final int baseZ = 5;
            final double offset = 0.5;
            this.generateSphere(world, random, structureBoundingBox, baseX, baseZ, radius, offset, 15, 20);
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 4, 1, 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 4, 2, 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 2, 3, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 6, 3, 7, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 6, 3, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 2, 3, 7, structureBoundingBox);
            this.func_151554_b(world, Blocks.packed_ice, 0, 3, -1, 0, structureBoundingBox);
            this.func_151554_b(world, Blocks.packed_ice, 0, 4, -1, 0, structureBoundingBox);
            this.func_151554_b(world, Blocks.packed_ice, 0, 5, -1, 0, structureBoundingBox);
            this.fillWithBlocks(world, structureBoundingBox, 3, 0, 0, 5, 3, 0, Blocks.packed_ice, Blocks.packed_ice, false);
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 4, 2, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 4, 1, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.snow, 0, 4, 0, 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.snow, 0, 4, 0, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 3, 3, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 5, 3, 0, structureBoundingBox);
            this.placeDoorAtCurrentPosition(world, structureBoundingBox, random, 4, 1, 1, this.getMetadataWithOffset(Blocks.wooden_door, 1));
            this.placeBlockAtCurrentPosition(world, Blocks.log, 3, 4, 1, 8, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 1, 2, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 7, 2, 5, structureBoundingBox);
            this.spawnEntity(world, structureBoundingBox, 4, 2, 5, 0);
            this.spawnEntity(world, structureBoundingBox, 4, 2, 5, 0);
            return true;
        }
        
        @Override
        protected EntityLiving getNewEntity(final World world, final int choice) {
            return (EntityLiving)new EntityInuit(world, EnumVillager.INUIT_FISHERMAN);
        }
    }
    
    public static class Igloo2 extends GlobalEskimoVillage
    {
        public Igloo2() {
        }
        
        public Igloo2(final StructureVillagePieces.Start startPiece, final int componentType, final Random random, final StructureBoundingBox structureBoundingBox, final int coordBaseMode) {
            super(EnumVillagePiece.INUIT_IGLOO2, startPiece, componentType, structureBoundingBox, coordBaseMode);
            this.setOffset(2);
        }
        
        public static Igloo2 buildComponent(final StructureVillagePieces.Start villagePiece, final List pieces, final Random random, final int x, final int y, final int z, final int coordBaseMode, final int p5) {
            final StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(x, y, z, 0, 0, 0, 8, 4, 8, coordBaseMode);
            return (canVillageGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(pieces, structureboundingbox) == null) ? new Igloo2(villagePiece, p5, random, structureboundingbox, coordBaseMode) : null;
        }
        
        @Override
        public boolean build(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
            final int radius = 4;
            final int baseX = 3;
            final int baseZ = 3;
            final double offset = 0.7;
            this.generateSphere(world, random, structureBoundingBox, baseX, baseZ, radius, offset, 18, 30);
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 1, 2, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 1, 2, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 5, 2, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 5, 2, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 2, 2, 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 4, 2, 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 2, 2, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 4, 2, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.snow, 0, 3, 0, 0, structureBoundingBox);
            this.placeDoorAtCurrentPosition(world, structureBoundingBox, random, 3, 1, 0, this.getMetadataWithOffset(Blocks.wooden_door, 1));
            this.placeBlockAtCurrentPosition(world, Blocks.packed_ice, 0, 3, 3, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 3, 2, 5, structureBoundingBox);
            this.spawnEntity(world, structureBoundingBox, 3, 2, 3, 0);
            this.spawnEntity(world, structureBoundingBox, 3, 2, 3, 0);
            return true;
        }
        
        @Override
        protected EntityLiving getNewEntity(final World world, final int choice) {
            return (EntityLiving)new EntityInuit(world, EnumVillager.INUIT_HUNTER);
        }
    }
    
    public static class ChiefIgloo extends GlobalEskimoVillage
    {
        public ChiefIgloo() {
        }
        
        public ChiefIgloo(final StructureVillagePieces.Start startPiece, final int componentType, final Random random, final StructureBoundingBox structureBoundingBox, final int coordBaseMode) {
            super(EnumVillagePiece.INUIT_CHIEFIGLOO, startPiece, componentType, structureBoundingBox, coordBaseMode);
            this.setOffset(2);
        }
        
        public static ChiefIgloo buildComponent(final StructureVillagePieces.Start villagePiece, final List pieces, final Random random, final int x, final int y, final int z, final int coordBaseMode, final int p5) {
            final StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(x, y, z, 0, 0, 0, 8, 4, 9, coordBaseMode);
            return (canVillageGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(pieces, structureboundingbox) == null) ? new ChiefIgloo(villagePiece, p5, random, structureboundingbox, coordBaseMode) : null;
        }
        
        @Override
        public boolean build(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
            final int radius = 5;
            final int baseX = 4;
            final int baseZ = 5;
            final double offset = 0.7;
            this.generateSphere(world, random, structureBoundingBox, baseX, baseZ, radius, offset, 10, 20);
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 1, 2, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 1, 2, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 5, 2, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 5, 2, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 2, 2, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 4, 2, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 2, 2, 6, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 4, 2, 6, structureBoundingBox);
            this.func_151554_b(world, Blocks.packed_ice, 0, 3, -1, 0, structureBoundingBox);
            this.func_151554_b(world, Blocks.packed_ice, 0, 4, -1, 0, structureBoundingBox);
            this.func_151554_b(world, Blocks.packed_ice, 0, 5, -1, 0, structureBoundingBox);
            this.fillWithBlocks(world, structureBoundingBox, 3, 0, 0, 5, 3, 0, Blocks.packed_ice, Blocks.packed_ice, false);
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 4, 2, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 4, 1, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.snow, 0, 4, 0, 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.snow, 0, 4, 0, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 3, 3, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 5, 3, 0, structureBoundingBox);
            this.placeDoorAtCurrentPosition(world, structureBoundingBox, random, 4, 1, 1, this.getMetadataWithOffset(Blocks.wooden_door, 1));
            this.placeBlockAtCurrentPosition(world, Blocks.packed_ice, 0, 3, 3, 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 1, 2, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 7, 2, 5, structureBoundingBox);
            this.spawnEntity(world, structureBoundingBox, 4, 2, 5, 0);
            return true;
        }
        
        @Override
        protected EntityLiving getNewEntity(final World world, final int choice) {
            return (EntityLiving)new EntityInuit(world, EnumVillager.INUIT_CHIEF);
        }
    }
    
    public static class Kennel extends GlobalVillage
    {
        private int averageGroundLevel;
        
        public Kennel() {
            this.averageGroundLevel = -1;
        }
        
        public Kennel(final StructureVillagePieces.Start startPiece, final int componentType, final Random random, final StructureBoundingBox structureBoundingBox, final int coordBaseMode) {
            super(EnumVillagePiece.INUIT_KENNEL, startPiece, componentType, structureBoundingBox, coordBaseMode);
            this.averageGroundLevel = -1;
            this.setOffset(3);
        }
        
        public static Kennel buildComponent(final StructureVillagePieces.Start villagePiece, final List pieces, final Random random, final int x, final int y, final int z, final int coordBaseMode, final int p5) {
            final StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(x, y, z, 0, 0, 0, 7, 4, 6, coordBaseMode);
            return (canVillageGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(pieces, structureboundingbox) == null) ? new Kennel(villagePiece, p5, random, structureboundingbox, coordBaseMode) : null;
        }
        
        @Override
        public boolean build(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
            for (int x = 0; x < 7; ++x) {
                for (int z = 0; z < 6; ++z) {
                    this.func_151554_b(world, Blocks.dirt, 0, x, -1, z, structureBoundingBox);
                    this.clearCurrentPositionBlocksUpwards(world, x, 1, z, structureBoundingBox);
                }
            }
            this.fillWithBlocks(world, structureBoundingBox, 0, 0, 0, 6, 0, 5, Blocks.fence, Blocks.air, false);
            this.fillWithBlocks(world, structureBoundingBox, 1, 0, 1, 5, 0, 4, Blocks.air, Blocks.air, false);
            this.placeBlockAtCurrentPosition(world, Blocks.fence_gate, this.getMetadataWithOffset(Blocks.fence_gate, 0), 2, 0, 0, structureBoundingBox);
            this.spawnEntity(world, structureBoundingBox, 3, 2, 3, 0);
            this.spawnEntity(world, structureBoundingBox, 3, 2, 3, 1);
            this.spawnEntity(world, structureBoundingBox, 3, 2, 3, 1);
            this.spawnEntity(world, structureBoundingBox, 3, 2, 3, 1);
            return true;
        }
        
        @Override
        protected EntityLiving getNewEntity(final World world, final int choice) {
            switch (choice) {
                case 0: {
                    return (EntityLiving)new EntityInuit(world, EnumVillager.INUIT_KENNELMASTER);
                }
                case 1: {
                    return (EntityLiving)new EntityWolf(world);
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
            super(EnumVillageBasicPiece.ESKIMO_TORCH, startPiece, componentType, random, structureBoundingBox, coordBaseMode);
            this.setOffset(3);
        }
        
        @Override
        public boolean build(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
            this.fillWithBlocks(world, structureBoundingBox, 0, 0, 0, 2, 3, 1, Blocks.air, Blocks.air, false);
            this.placeBlockAtCurrentPosition(world, Blocks.packed_ice, 0, 1, 0, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 1, 1, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 1, 2, 0, structureBoundingBox);
            return true;
        }
    }
}
