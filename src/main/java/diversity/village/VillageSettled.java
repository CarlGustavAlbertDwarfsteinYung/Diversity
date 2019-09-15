// 
// Decompiled by Procyon v0.5.36
// 

package diversity.village;

import diversity.suppliers.EnumVillageBasicPiece;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.util.MathHelper;
import diversity.entity.EntitySettled;
import diversity.suppliers.EnumVillager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.block.material.Material;
import diversity.utils.DirectionTools;
import net.minecraft.world.gen.structure.StructureComponent;
import diversity.suppliers.IEnumPiece;
import diversity.suppliers.EnumVillagePiece;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureVillagePieces;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import java.util.List;
import java.util.Random;
import net.minecraft.world.biome.WorldChunkManager;
import diversity.suppliers.EnumVillage;

public class VillageSettled extends VillageTools
{
    private static VillageSettled instance;
    
    public VillageSettled(final EnumVillage ENUM) {
        super(ENUM);
        VillageSettled.instance = this;
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
            super(VillageSettled.instance, p_i2104_1_, p_i2104_2_, p_i2104_3_, p_i2104_4_, p_i2104_5_, p_i2104_6_, p_i2104_7_);
        }
        
        @Override
        public boolean addComponentParts(final World world, final Random rand, final StructureBoundingBox structureBoundingBox) {
            if (super.addComponentParts(world, rand, structureBoundingBox, 3)) {
                return true;
            }
            this.fillWithBlocks(world, structureBoundingBox, 1, 0, 1, 4, 12, 4, Blocks.cobblestone, (Block)Blocks.flowing_water, false);
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 2, 12, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 3, 12, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 2, 12, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 3, 12, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 1, 13, 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 1, 14, 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 4, 13, 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 4, 14, 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 1, 13, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 1, 14, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 4, 13, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 4, 14, 4, structureBoundingBox);
            this.fillWithBlocks(world, structureBoundingBox, 1, 15, 1, 4, 15, 4, Blocks.planks, Blocks.planks, false);
            this.fillWithMetadataBlocks(world, structureBoundingBox, 2, 15, 2, 3, 15, 3, (Block)Blocks.wooden_slab, 0, (Block)Blocks.wooden_slab, 0, false);
            for (int x = 0; x <= 5; ++x) {
                for (int z = 0; z <= 5; ++z) {
                    if (x == 0 || x == 5 || z == 0 || z == 5) {
                        this.placeBlockAtCurrentPosition(world, Blocks.gravel, 0, x, 11, z, structureBoundingBox);
                        this.clearCurrentPositionBlocksUpwards(world, x, 12, z, structureBoundingBox);
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
            super(VillageSettled.instance, p_i2105_1_, p_i2105_2_, p_i2105_3_, p_i2105_4_, p_i2105_5_);
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
    
    public static class Church extends GlobalVillage
    {
        public Church() {
        }
        
        public Church(final StructureVillagePieces.Start startPiece, final int componentType, final Random random, final StructureBoundingBox structureBoundingBox, final int coordBaseMode) {
            super(EnumVillagePiece.SETTLED_CHURCH, startPiece, componentType, structureBoundingBox, coordBaseMode);
            this.setOffset(10);
        }
        
        public static Church buildComponent(final StructureVillagePieces.Start villagePiece, final List pieces, final Random random, final int x, final int y, final int z, final int coordBaseMode, final int p5) {
            final StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(x, y, z, 0, 0, 0, 5, 12, 9, coordBaseMode);
            return (canVillageGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(pieces, structureboundingbox) == null) ? new Church(villagePiece, p5, random, structureboundingbox, coordBaseMode) : null;
        }
        
        @Override
        public boolean build(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
            for (int j = 0; j < 9; ++j) {
                for (int k = 0; k < 5; ++k) {
                    this.clearCurrentPositionBlocksUpwards(world, k, 0, j, structureBoundingBox);
                    this.func_151554_b(world, Blocks.cobblestone, 0, k, -1, j, structureBoundingBox);
                }
            }
            this.fillWithBlocks(world, structureBoundingBox, 1, 1, 1, 3, 3, 7, Blocks.air, Blocks.air, false);
            this.fillWithBlocks(world, structureBoundingBox, 1, 5, 1, 3, 9, 3, Blocks.air, Blocks.air, false);
            this.fillWithBlocks(world, structureBoundingBox, 1, 0, 0, 3, 0, 8, Blocks.cobblestone, Blocks.cobblestone, false);
            this.fillWithBlocks(world, structureBoundingBox, 1, 1, 0, 3, 10, 0, Blocks.cobblestone, Blocks.cobblestone, false);
            this.fillWithBlocks(world, structureBoundingBox, 0, 0, 1, 0, 10, 3, Blocks.cobblestone, Blocks.cobblestone, false);
            this.fillWithBlocks(world, structureBoundingBox, 4, 0, 1, 4, 10, 3, Blocks.cobblestone, Blocks.cobblestone, false);
            this.fillWithBlocks(world, structureBoundingBox, 0, 0, 4, 0, 4, 7, Blocks.cobblestone, Blocks.cobblestone, false);
            this.fillWithBlocks(world, structureBoundingBox, 4, 0, 4, 4, 4, 7, Blocks.cobblestone, Blocks.cobblestone, false);
            this.fillWithBlocks(world, structureBoundingBox, 1, 1, 8, 3, 4, 8, Blocks.cobblestone, Blocks.cobblestone, false);
            this.fillWithBlocks(world, structureBoundingBox, 1, 5, 4, 3, 10, 4, Blocks.cobblestone, Blocks.cobblestone, false);
            this.fillWithBlocks(world, structureBoundingBox, 1, 5, 5, 3, 5, 7, Blocks.cobblestone, Blocks.cobblestone, false);
            this.fillWithBlocks(world, structureBoundingBox, 1, 9, 1, 3, 9, 3, Blocks.stone, Blocks.stone, false);
            this.fillWithMetadataBlocks(world, structureBoundingBox, 1, 4, 1, 3, 4, 3, (Block)Blocks.wooden_slab, 8, (Block)Blocks.wooden_slab, 8, false);
            this.placeBlockAtCurrentPosition(world, Blocks.cobblestone, 0, 0, 11, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.cobblestone, 0, 4, 11, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.cobblestone, 0, 2, 11, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.cobblestone, 0, 2, 11, 4, structureBoundingBox);
            this.fillWithBlocks(world, structureBoundingBox, 1, 0, 1, 3, 0, 7, (Block)Blocks.double_stone_slab, (Block)Blocks.double_stone_slab, false);
            this.fillWithBlocks(world, structureBoundingBox, 1, 1, 6, 3, 1, 7, (Block)Blocks.stone_slab, (Block)Blocks.stone_slab, false);
            this.placeBlockAtCurrentPosition(world, (Block)Blocks.double_stone_slab, 0, 2, 1, 6, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 0, 2, 2, 6, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.glass_pane, 0, 0, 2, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.glass_pane, 0, 0, 3, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.glass_pane, 0, 4, 2, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.glass_pane, 0, 4, 3, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.glass_pane, 0, 0, 6, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.glass_pane, 0, 0, 7, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.glass_pane, 0, 4, 6, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.glass_pane, 0, 4, 7, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.glass_pane, 0, 2, 6, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.glass_pane, 0, 2, 7, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.glass_pane, 0, 2, 6, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.glass_pane, 0, 2, 7, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.glass_pane, 0, 0, 3, 6, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.glass_pane, 0, 4, 3, 6, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.glass_pane, 0, 2, 3, 8, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.torch, DirectionTools.torch[this.coordBaseMode][3], 1, 3, 7, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.torch, DirectionTools.torch[this.coordBaseMode][3], 3, 3, 7, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.torch, DirectionTools.torch[this.coordBaseMode][2], 2, 3, 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, (Block)Blocks.wooden_slab, 8, 1, 5, 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.torch, 5, 1, 6, 1, structureBoundingBox);
            final int i = this.getMetadataWithOffset(Blocks.ladder, 4);
            for (int j = 1; j <= 9; ++j) {
                this.placeBlockAtCurrentPosition(world, Blocks.ladder, i, 3, j, 1, structureBoundingBox);
            }
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 2, 1, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 2, 2, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, (Block)Blocks.double_stone_slab, 0, 2, 0, 0, structureBoundingBox);
            this.placeDoorAtCurrentPosition(world, structureBoundingBox, random, 2, 1, 0, this.getMetadataWithOffset(Blocks.wooden_door, 1));
            if (this.getBlockAtCurrentPosition(world, 2, 0, -1, structureBoundingBox).getMaterial() == Material.air && this.getBlockAtCurrentPosition(world, 2, -1, -1, structureBoundingBox).getMaterial() != Material.air) {
                this.placeBlockAtCurrentPosition(world, Blocks.stone_stairs, this.getMetadataWithOffset(Blocks.stone_stairs, 3), 2, 0, -1, structureBoundingBox);
            }
            this.fillWithMetadataBlocks(world, structureBoundingBox, 2, 1, 1, 2, 1, 5, Blocks.carpet, 14, Blocks.carpet, 14, false);
            this.placeBlockAtCurrentPosition(world, Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][2], 1, 1, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][2], 3, 1, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][2], 1, 1, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][2], 3, 1, 4, structureBoundingBox);
            for (int k = 0; k < 4; ++k) {
                this.placeBlockAtCurrentPosition(world, Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][0], 0, 5, 4 + k, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][1], 4, 5, 4 + k, structureBoundingBox);
                if (k < 3) {
                    this.placeBlockAtCurrentPosition(world, Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][2], 1 + k, 5, 8, structureBoundingBox);
                }
            }
            this.spawnEntity(world, structureBoundingBox, 2, 1, 2, 0);
            return true;
        }
        
        @Override
        protected EntityLiving getNewEntity(final World world, final int choice) {
            return (EntityLiving)new EntitySettled(world, EnumVillager.SETTLED_PRIEST);
        }
    }
    
    public static class Field1 extends GlobalField
    {
        public Field1() {
        }
        
        public Field1(final StructureVillagePieces.Start startPiece, final int componentType, final Random random, final StructureBoundingBox structureBoundingBox, final int coordBaseMode) {
            super(EnumVillagePiece.SETTLED_FIELD1, startPiece, componentType, random, structureBoundingBox, coordBaseMode);
            this.setOffset(3);
        }
        
        public static Field1 buildComponent(final StructureVillagePieces.Start villagePiece, final List pieces, final Random random, final int x, final int y, final int z, final int coordBaseMode, final int p5) {
            final StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(x, y, z, 0, 0, 0, 13, 4, 9, coordBaseMode);
            return (canVillageGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(pieces, structureboundingbox) == null) ? new Field1(villagePiece, p5, random, structureboundingbox, coordBaseMode) : null;
        }
        
        @Override
        protected Block getCropType(final Random random) {
            switch (random.nextInt(5)) {
                case 0: {
                    return Blocks.carrots;
                }
                case 1: {
                    return Blocks.potatoes;
                }
                default: {
                    return Blocks.wheat;
                }
            }
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
            this.spawnEntity(world, structureBoundingBox, 4, 2, 4, 0);
            return true;
        }
        
        @Override
        protected EntityLiving getNewEntity(final World world, final int choice) {
            return (EntityLiving)new EntitySettled(world, EnumVillager.SETTLED_FARMER);
        }
    }
    
    public static class Field2 extends GlobalField
    {
        public Field2() {
        }
        
        public Field2(final StructureVillagePieces.Start startPiece, final int componentType, final Random random, final StructureBoundingBox structureBoundingBox, final int coordBaseMode) {
            super(EnumVillagePiece.SETTLED_FIELD2, startPiece, componentType, random, structureBoundingBox, coordBaseMode);
            this.setOffset(3);
        }
        
        public static Field2 buildComponent(final StructureVillagePieces.Start villagePiece, final List pieces, final Random random, final int x, final int y, final int z, final int coordBaseMode, final int p5) {
            final StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(x, y, z, 0, 0, 0, 7, 4, 9, coordBaseMode);
            return (canVillageGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(pieces, structureboundingbox) == null) ? new Field2(villagePiece, p5, random, structureboundingbox, coordBaseMode) : null;
        }
        
        @Override
        protected Block getCropType(final Random random) {
            switch (random.nextInt(5)) {
                case 0: {
                    return Blocks.carrots;
                }
                case 1: {
                    return Blocks.potatoes;
                }
                default: {
                    return Blocks.wheat;
                }
            }
        }
        
        @Override
        public boolean build(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
            this.fillWithBlocks(world, structureBoundingBox, 0, 1, 0, 6, 4, 8, Blocks.air, Blocks.air, false);
            this.fillWithBlocks(world, structureBoundingBox, 1, 0, 1, 2, 0, 7, Blocks.farmland, Blocks.farmland, false);
            this.fillWithBlocks(world, structureBoundingBox, 4, 0, 1, 5, 0, 7, Blocks.farmland, Blocks.farmland, false);
            this.fillWithBlocks(world, structureBoundingBox, 0, 0, 0, 0, 0, 8, Blocks.log, Blocks.log, false);
            this.fillWithBlocks(world, structureBoundingBox, 6, 0, 0, 6, 0, 8, Blocks.log, Blocks.log, false);
            this.fillWithBlocks(world, structureBoundingBox, 1, 0, 0, 5, 0, 0, Blocks.log, Blocks.log, false);
            this.fillWithBlocks(world, structureBoundingBox, 1, 0, 8, 5, 0, 8, Blocks.log, Blocks.log, false);
            this.fillWithBlocks(world, structureBoundingBox, 3, 0, 1, 3, 0, 7, Blocks.water, Blocks.water, false);
            for (int i = 1; i <= 7; ++i) {
                this.placeBlockAtCurrentPosition(world, this.cropTypeA, MathHelper.getRandomIntegerInRange(random, 2, 7), 1, 1, i, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, this.cropTypeA, MathHelper.getRandomIntegerInRange(random, 2, 7), 2, 1, i, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, this.cropTypeB, MathHelper.getRandomIntegerInRange(random, 2, 7), 4, 1, i, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, this.cropTypeB, MathHelper.getRandomIntegerInRange(random, 2, 7), 5, 1, i, structureBoundingBox);
            }
            for (int i = 0; i < 9; ++i) {
                for (int j = 0; j < 7; ++j) {
                    this.clearCurrentPositionBlocksUpwards(world, j, 4, i, structureBoundingBox);
                    this.func_151554_b(world, Blocks.dirt, 0, j, -1, i, structureBoundingBox);
                }
            }
            this.spawnEntity(world, structureBoundingBox, 4, 2, 4, 0);
            return true;
        }
        
        @Override
        protected EntityLiving getNewEntity(final World world, final int choice) {
            return (EntityLiving)new EntitySettled(world, EnumVillager.SETTLED_FARMER);
        }
    }
    
    public static class Butchery extends GlobalVillage
    {
        public Butchery() {
        }
        
        public Butchery(final StructureVillagePieces.Start startPiece, final int componentType, final Random random, final StructureBoundingBox structureBoundingBox, final int coordBaseMode) {
            super(EnumVillagePiece.SETTLED_BUTCHERY, startPiece, componentType, structureBoundingBox, coordBaseMode);
            this.setOffset(5);
        }
        
        public static Butchery buildComponent(final StructureVillagePieces.Start villagePiece, final List pieces, final Random random, final int x, final int y, final int z, final int coordBaseMode, final int p5) {
            final StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(x, y, z, 0, 0, 0, 9, 7, 11, coordBaseMode);
            return (canVillageGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(pieces, structureboundingbox) == null) ? new Butchery(villagePiece, p5, random, structureboundingbox, coordBaseMode) : null;
        }
        
        @Override
        public boolean build(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
            this.fillWithBlocks(world, structureBoundingBox, 1, 1, 1, 7, 4, 4, Blocks.air, Blocks.air, false);
            this.fillWithBlocks(world, structureBoundingBox, 2, 1, 6, 8, 4, 10, Blocks.air, Blocks.air, false);
            for (int x = 2; x < 9; ++x) {
                for (int z = 6; z < 11; ++z) {
                    this.func_151554_b(world, Blocks.dirt, 0, x, -1, z, structureBoundingBox);
                }
            }
            this.fillWithBlocks(world, structureBoundingBox, 2, 0, 6, 8, 0, 10, (Block)Blocks.grass, (Block)Blocks.grass, false);
            this.placeBlockAtCurrentPosition(world, Blocks.cobblestone, 0, 6, 0, 6, structureBoundingBox);
            this.fillWithBlocks(world, structureBoundingBox, 2, 1, 6, 2, 1, 10, Blocks.fence, Blocks.fence, false);
            this.fillWithBlocks(world, structureBoundingBox, 8, 1, 6, 8, 1, 10, Blocks.fence, Blocks.fence, false);
            this.fillWithBlocks(world, structureBoundingBox, 3, 1, 10, 7, 1, 10, Blocks.fence, Blocks.fence, false);
            this.fillWithBlocks(world, structureBoundingBox, 1, 0, 1, 7, 0, 4, Blocks.planks, Blocks.planks, false);
            this.fillWithBlocks(world, structureBoundingBox, 0, 0, 0, 0, 3, 5, Blocks.cobblestone, Blocks.cobblestone, false);
            this.fillWithBlocks(world, structureBoundingBox, 8, 0, 0, 8, 3, 5, Blocks.cobblestone, Blocks.cobblestone, false);
            this.fillWithBlocks(world, structureBoundingBox, 1, 0, 0, 7, 1, 0, Blocks.cobblestone, Blocks.cobblestone, false);
            this.fillWithBlocks(world, structureBoundingBox, 1, 0, 5, 7, 1, 5, Blocks.cobblestone, Blocks.cobblestone, false);
            this.fillWithBlocks(world, structureBoundingBox, 1, 2, 0, 7, 3, 0, Blocks.planks, Blocks.planks, false);
            this.fillWithBlocks(world, structureBoundingBox, 1, 2, 5, 7, 3, 5, Blocks.planks, Blocks.planks, false);
            this.fillWithBlocks(world, structureBoundingBox, 1, 4, 1, 7, 4, 1, Blocks.planks, Blocks.planks, false);
            this.fillWithBlocks(world, structureBoundingBox, 1, 4, 4, 7, 4, 4, Blocks.planks, Blocks.planks, false);
            this.fillWithBlocks(world, structureBoundingBox, 1, 5, 2, 7, 5, 3, Blocks.planks, Blocks.planks, false);
            this.fillWithBlocks(world, structureBoundingBox, 0, 4, 1, 0, 5, 4, Blocks.cobblestone, Blocks.cobblestone, false);
            this.fillWithBlocks(world, structureBoundingBox, 8, 4, 1, 8, 5, 4, Blocks.cobblestone, Blocks.cobblestone, false);
            final int i = this.getMetadataWithOffset(Blocks.oak_stairs, 3);
            final int j = this.getMetadataWithOffset(Blocks.oak_stairs, 2);
            for (int k = -1; k <= 2; ++k) {
                for (int l = 0; l <= 8; ++l) {
                    if (k != -1 || (l != 0 && l != 8)) {
                        this.placeBlockAtCurrentPosition(world, Blocks.oak_stairs, i, l, 4 + k, k, structureBoundingBox);
                        this.placeBlockAtCurrentPosition(world, Blocks.oak_stairs, j, l, 4 + k, 5 - k, structureBoundingBox);
                    }
                }
            }
            for (int k = 0; k < 5; ++k) {
                this.placeBlockAtCurrentPosition(world, Blocks.log, 0, 0, k, 1, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.log, 0, 0, k, 4, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.log, 0, 8, k, 1, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.log, 0, 8, k, 4, structureBoundingBox);
                if (k < 4) {
                    this.placeBlockAtCurrentPosition(world, Blocks.log, 0, 1, k, 0, structureBoundingBox);
                    this.placeBlockAtCurrentPosition(world, Blocks.log, 0, 1, k, 5, structureBoundingBox);
                    this.placeBlockAtCurrentPosition(world, Blocks.log, 0, 7, k, 0, structureBoundingBox);
                    this.placeBlockAtCurrentPosition(world, Blocks.log, 0, 7, k, 5, structureBoundingBox);
                    this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 0, k, 0, structureBoundingBox);
                    this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 0, k, 5, structureBoundingBox);
                    this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 8, k, 0, structureBoundingBox);
                    this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 8, k, 5, structureBoundingBox);
                }
            }
            this.placeBlockAtCurrentPosition(world, (Block)Blocks.grass, 0, 8, 0, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 8, 1, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.glass_pane, 0, 0, 2, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.glass_pane, 0, 0, 2, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.glass_pane, 0, 8, 2, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.glass_pane, 0, 8, 2, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.glass_pane, 0, 2, 2, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.glass_pane, 0, 3, 2, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.glass_pane, 0, 5, 2, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.glass_pane, 0, 6, 2, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 2, 1, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.wooden_pressure_plate, 0, 2, 2, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.planks, 0, 1, 1, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.oak_stairs, this.getMetadataWithOffset(Blocks.oak_stairs, 3), 2, 1, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.oak_stairs, this.getMetadataWithOffset(Blocks.oak_stairs, 1), 1, 1, 3, structureBoundingBox);
            this.fillWithBlocks(world, structureBoundingBox, 5, 0, 1, 7, 0, 3, (Block)Blocks.double_stone_slab, (Block)Blocks.double_stone_slab, false);
            this.placeBlockAtCurrentPosition(world, (Block)Blocks.double_stone_slab, 0, 6, 1, 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, (Block)Blocks.double_stone_slab, 0, 6, 1, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 2, 1, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 2, 2, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 2, 3, 1, structureBoundingBox);
            this.placeDoorAtCurrentPosition(world, structureBoundingBox, random, 2, 1, 0, this.getMetadataWithOffset(Blocks.wooden_door, 1));
            if (this.getBlockAtCurrentPosition(world, 2, 0, -1, structureBoundingBox).getMaterial() == Material.air && this.getBlockAtCurrentPosition(world, 2, -1, -1, structureBoundingBox).getMaterial() != Material.air) {
                this.placeBlockAtCurrentPosition(world, Blocks.stone_stairs, this.getMetadataWithOffset(Blocks.stone_stairs, 3), 2, 0, -1, structureBoundingBox);
            }
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 6, 1, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 6, 2, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 6, 3, 4, structureBoundingBox);
            this.placeDoorAtCurrentPosition(world, structureBoundingBox, random, 6, 1, 5, this.getMetadataWithOffset(Blocks.wooden_door, 1));
            for (int k = 0; k < 5; ++k) {
                for (int l = 0; l < 9; ++l) {
                    this.clearCurrentPositionBlocksUpwards(world, l, 7, k, structureBoundingBox);
                    this.func_151554_b(world, Blocks.cobblestone, 0, l, -1, k, structureBoundingBox);
                }
            }
            this.spawnEntity(world, structureBoundingBox, 5, 1, 8, 0);
            this.spawnEntity(world, structureBoundingBox, 5, 1, 8, 1);
            this.spawnEntity(world, structureBoundingBox, 5, 1, 8, 1);
            this.spawnEntity(world, structureBoundingBox, 5, 1, 8, 1);
            this.spawnEntity(world, structureBoundingBox, 5, 1, 8, 1);
            return true;
        }
        
        @Override
        protected EntityLiving getNewEntity(final World world, final int choice) {
            switch (choice) {
                case 0: {
                    return (EntityLiving)new EntitySettled(world, EnumVillager.SETTLED_BUTCHER);
                }
                case 1: {
                    return (EntityLiving)new EntityPig(world);
                }
                default: {
                    return null;
                }
            }
        }
    }
    
    public static class Library extends GlobalVillage
    {
        public Library() {
        }
        
        public Library(final StructureVillagePieces.Start startPiece, final int componentType, final Random random, final StructureBoundingBox structureBoundingBox, final int coordBaseMode) {
            super(EnumVillagePiece.SETTLED_LIBRARY, startPiece, componentType, structureBoundingBox, coordBaseMode);
            this.setOffset(7);
        }
        
        public static Library buildComponent(final StructureVillagePieces.Start villagePiece, final List pieces, final Random random, final int x, final int y, final int z, final int coordBaseMode, final int p5) {
            final StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(x, y, z, 0, 0, 0, 9, 9, 7, coordBaseMode);
            return (canVillageGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(pieces, structureboundingbox) == null) ? new Library(villagePiece, p5, random, structureboundingbox, coordBaseMode) : null;
        }
        
        @Override
        public boolean build(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
            for (int x = 2; x < 7; ++x) {
                for (int z = 0; z < 5; ++z) {
                    this.clearCurrentPositionBlocksUpwards(world, x, 1, z, structureBoundingBox);
                    this.func_151554_b(world, Blocks.cobblestone, 0, x, -1, z, structureBoundingBox);
                }
            }
            for (int k = 0; k < 3; ++k) {
                for (int l = 0; l < 2; ++l) {
                    this.clearCurrentPositionBlocksUpwards(world, l, 1, k + 1, structureBoundingBox);
                    this.func_151554_b(world, Blocks.cobblestone, 0, l, -1, k + 1, structureBoundingBox);
                    this.clearCurrentPositionBlocksUpwards(world, 8 - l, 1, k + 1, structureBoundingBox);
                    this.func_151554_b(world, Blocks.cobblestone, 0, 8 - l, -1, k + 1, structureBoundingBox);
                    this.clearCurrentPositionBlocksUpwards(world, k + 3, 1, l + 5, structureBoundingBox);
                    this.func_151554_b(world, Blocks.cobblestone, 0, k + 3, -1, l + 5, structureBoundingBox);
                }
            }
            this.fillWithBlocks(world, structureBoundingBox, 2, 0, 0, 2, 4, 0, Blocks.log, Blocks.log, false);
            this.fillWithBlocks(world, structureBoundingBox, 6, 0, 0, 6, 4, 0, Blocks.log, Blocks.log, false);
            this.fillWithBlocks(world, structureBoundingBox, 2, 0, 4, 2, 4, 4, Blocks.log, Blocks.log, false);
            this.fillWithBlocks(world, structureBoundingBox, 6, 0, 4, 6, 4, 4, Blocks.log, Blocks.log, false);
            this.fillWithBlocks(world, structureBoundingBox, 0, 0, 1, 0, 3, 1, Blocks.log, Blocks.log, false);
            this.fillWithBlocks(world, structureBoundingBox, 0, 0, 3, 0, 3, 3, Blocks.log, Blocks.log, false);
            this.fillWithBlocks(world, structureBoundingBox, 8, 0, 1, 8, 3, 1, Blocks.log, Blocks.log, false);
            this.fillWithBlocks(world, structureBoundingBox, 8, 0, 3, 8, 3, 3, Blocks.log, Blocks.log, false);
            this.fillWithBlocks(world, structureBoundingBox, 3, 0, 6, 3, 3, 6, Blocks.log, Blocks.log, false);
            this.fillWithBlocks(world, structureBoundingBox, 5, 0, 6, 5, 3, 6, Blocks.log, Blocks.log, false);
            this.fillWithBlocks(world, structureBoundingBox, 1, 0, 1, 1, 3, 1, Blocks.cobblestone, Blocks.cobblestone, false);
            this.fillWithBlocks(world, structureBoundingBox, 1, 0, 3, 1, 3, 3, Blocks.cobblestone, Blocks.cobblestone, false);
            this.fillWithBlocks(world, structureBoundingBox, 7, 0, 1, 7, 3, 1, Blocks.cobblestone, Blocks.cobblestone, false);
            this.fillWithBlocks(world, structureBoundingBox, 7, 0, 3, 7, 3, 3, Blocks.cobblestone, Blocks.cobblestone, false);
            this.fillWithBlocks(world, structureBoundingBox, 3, 0, 5, 3, 3, 5, Blocks.cobblestone, Blocks.cobblestone, false);
            this.fillWithBlocks(world, structureBoundingBox, 5, 0, 5, 5, 3, 5, Blocks.cobblestone, Blocks.cobblestone, false);
            this.fillWithBlocks(world, structureBoundingBox, 3, 0, 0, 5, 3, 0, Blocks.cobblestone, Blocks.cobblestone, false);
            this.placeBlockAtCurrentPosition(world, Blocks.log, DirectionTools.log[this.coordBaseMode][1], 0, 0, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.log, DirectionTools.log[this.coordBaseMode][1], 0, 4, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.log, DirectionTools.log[this.coordBaseMode][1], 1, 4, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.log, DirectionTools.log[this.coordBaseMode][1], 7, 4, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.log, DirectionTools.log[this.coordBaseMode][1], 8, 4, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.log, DirectionTools.log[this.coordBaseMode][1], 8, 0, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.log, DirectionTools.log[this.coordBaseMode][0], 4, 0, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.log, DirectionTools.log[this.coordBaseMode][0], 3, 4, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.log, DirectionTools.log[this.coordBaseMode][0], 4, 4, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.log, DirectionTools.log[this.coordBaseMode][0], 5, 4, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.log, DirectionTools.log[this.coordBaseMode][0], 3, 4, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.log, DirectionTools.log[this.coordBaseMode][0], 4, 4, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.log, DirectionTools.log[this.coordBaseMode][0], 5, 4, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.log, DirectionTools.log[this.coordBaseMode][0], 4, 4, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.log, DirectionTools.log[this.coordBaseMode][0], 4, 4, 6, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.log, DirectionTools.log[this.coordBaseMode][0], 4, 0, 6, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.cobblestone, 0, 3, 5, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.cobblestone, 0, 4, 5, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.cobblestone, 0, 5, 5, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.cobblestone, 0, 3, 5, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.cobblestone, 0, 4, 5, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.cobblestone, 0, 5, 5, 4, structureBoundingBox);
            int z2;
            for (z2 = 0; z2 < 5; ++z2) {
                this.placeBlockAtCurrentPosition(world, Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][0], 2, 5, z2, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][0], 3, 6, z2, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, (Block)Blocks.wooden_slab, 0, 4, 7, z2, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.log, DirectionTools.log[this.coordBaseMode][0], 4, 6, z2, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][1], 5, 6, z2, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][1], 6, 5, z2, structureBoundingBox);
                if (z2 != 2) {
                    this.placeBlockAtCurrentPosition(world, Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][0], 1, 4, z2, structureBoundingBox);
                    this.placeBlockAtCurrentPosition(world, Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][1], 7, 4, z2, structureBoundingBox);
                }
                else {
                    this.placeBlockAtCurrentPosition(world, (Block)Blocks.wooden_slab, 0, 1, 5, z2, structureBoundingBox);
                    this.placeBlockAtCurrentPosition(world, (Block)Blocks.wooden_slab, 0, 7, 5, z2, structureBoundingBox);
                }
                if (z2 != 0 && z2 != 4) {
                    this.placeBlockAtCurrentPosition(world, Blocks.planks, 0, 3, 5, z2, structureBoundingBox);
                    this.placeBlockAtCurrentPosition(world, Blocks.planks, 0, 5, 5, z2, structureBoundingBox);
                }
            }
            while (z2 < 7) {
                this.placeBlockAtCurrentPosition(world, Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][0], 2, 3, z2, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][0], 3, 4, z2, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, (Block)Blocks.wooden_slab, 0, 4, 5, z2, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][1], 5, 4, z2, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][1], 6, 3, z2, structureBoundingBox);
                ++z2;
            }
            for (int x2 = 0; x2 < 2; ++x2) {
                this.placeBlockAtCurrentPosition(world, Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][3], x2, 3, 0, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][3], x2, 4, 1, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, (Block)Blocks.wooden_slab, 0, x2, 5, 2, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][2], x2, 4, 3, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][2], x2, 3, 4, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][3], 8 - x2, 3, 0, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][3], 8 - x2, 4, 1, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, (Block)Blocks.wooden_slab, 0, 8 - x2, 5, 2, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][2], 8 - x2, 4, 3, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][2], 8 - x2, 3, 4, structureBoundingBox);
            }
            this.fillWithBlocks(world, structureBoundingBox, 2, 0, 1, 6, 0, 3, Blocks.planks, Blocks.planks, false);
            this.fillWithBlocks(world, structureBoundingBox, 3, 0, 4, 5, 0, 4, Blocks.planks, Blocks.planks, false);
            this.placeBlockAtCurrentPosition(world, Blocks.planks, 0, 1, 0, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.planks, 0, 7, 0, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.planks, 0, 4, 0, 5, structureBoundingBox);
            this.fillWithBlocks(world, structureBoundingBox, 2, 1, 1, 2, 3, 1, Blocks.bookshelf, Blocks.bookshelf, false);
            this.fillWithBlocks(world, structureBoundingBox, 6, 1, 1, 6, 3, 1, Blocks.bookshelf, Blocks.bookshelf, false);
            this.fillWithBlocks(world, structureBoundingBox, 2, 1, 3, 2, 3, 3, Blocks.bookshelf, Blocks.bookshelf, false);
            this.fillWithBlocks(world, structureBoundingBox, 6, 1, 3, 6, 3, 3, Blocks.bookshelf, Blocks.bookshelf, false);
            this.fillWithBlocks(world, structureBoundingBox, 3, 1, 4, 3, 3, 4, Blocks.bookshelf, Blocks.bookshelf, false);
            this.fillWithBlocks(world, structureBoundingBox, 5, 1, 4, 5, 3, 4, Blocks.bookshelf, Blocks.bookshelf, false);
            this.fillWithBlocks(world, structureBoundingBox, 2, 4, 1, 2, 4, 3, Blocks.bookshelf, Blocks.bookshelf, false);
            this.fillWithBlocks(world, structureBoundingBox, 6, 4, 1, 6, 4, 3, Blocks.bookshelf, Blocks.bookshelf, false);
            this.fillWithBlocks(world, structureBoundingBox, 0, 1, 2, 0, 3, 2, Blocks.glass_pane, Blocks.glass_pane, false);
            this.fillWithBlocks(world, structureBoundingBox, 8, 1, 2, 8, 3, 2, Blocks.glass_pane, Blocks.glass_pane, false);
            this.fillWithBlocks(world, structureBoundingBox, 4, 1, 6, 4, 3, 6, Blocks.glass_pane, Blocks.glass_pane, false);
            this.placeBlockAtCurrentPosition(world, Blocks.torch, DirectionTools.torch[this.coordBaseMode][2], 4, 5, 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.torch, DirectionTools.torch[this.coordBaseMode][3], 4, 5, 3, structureBoundingBox);
            this.placeDoorAtCurrentPosition(world, structureBoundingBox, random, 4, 1, 0, this.getMetadataWithOffset(Blocks.wooden_door, 1));
            if (this.getBlockAtCurrentPosition(world, 4, 0, -1, structureBoundingBox).getMaterial() == Material.air && this.getBlockAtCurrentPosition(world, 2, -1, -1, structureBoundingBox).getMaterial() != Material.air) {
                this.placeBlockAtCurrentPosition(world, Blocks.stone_stairs, this.getMetadataWithOffset(Blocks.stone_stairs, 3), 4, 0, -1, structureBoundingBox);
            }
            this.spawnEntity(world, structureBoundingBox, 4, 1, 2, 0);
            return true;
        }
        
        @Override
        protected EntityLiving getNewEntity(final World world, final int choice) {
            return (EntityLiving)new EntitySettled(world, EnumVillager.SETTLED_LIBRARIAN);
        }
    }
    
    public static class Forge extends GlobalVillage
    {
        private boolean hasMadeChest;
        
        public Forge() {
        }
        
        public Forge(final StructureVillagePieces.Start startPiece, final int componentType, final Random random, final StructureBoundingBox structureBoundingBox, final int coordBaseMode) {
            super(EnumVillagePiece.SETTLED_FORGE, startPiece, componentType, structureBoundingBox, coordBaseMode);
            this.setOffset(5);
        }
        
        public static Forge buildComponent(final StructureVillagePieces.Start villagePiece, final List pieces, final Random random, final int x, final int y, final int z, final int coordBaseMode, final int p5) {
            final StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(x, y, z, 0, 0, 0, 10, 6, 7, coordBaseMode);
            return (canVillageGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(pieces, structureboundingbox) == null) ? new Forge(villagePiece, p5, random, structureboundingbox, coordBaseMode) : null;
        }
        
        @Override
        public boolean build(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
            for (int i = 0; i < 7; ++i) {
                for (int j = 0; j < 10; ++j) {
                    this.clearCurrentPositionBlocksUpwards(world, j, 0, i, structureBoundingBox);
                    this.func_151554_b(world, Blocks.cobblestone, 0, j, -1, i, structureBoundingBox);
                }
            }
            this.fillWithBlocks(world, structureBoundingBox, 0, 1, 0, 9, 4, 6, Blocks.air, Blocks.air, false);
            this.fillWithBlocks(world, structureBoundingBox, 0, 0, 0, 9, 0, 6, Blocks.cobblestone, Blocks.cobblestone, false);
            this.fillWithBlocks(world, structureBoundingBox, 0, 4, 0, 9, 4, 6, Blocks.cobblestone, Blocks.cobblestone, false);
            this.fillWithBlocks(world, structureBoundingBox, 1, 4, 1, 8, 4, 5, Blocks.stone, Blocks.stone, false);
            this.fillWithBlocks(world, structureBoundingBox, 0, 5, 0, 9, 5, 6, (Block)Blocks.stone_slab, (Block)Blocks.stone_slab, false);
            this.fillWithBlocks(world, structureBoundingBox, 1, 5, 1, 8, 5, 5, Blocks.air, Blocks.air, false);
            this.fillWithBlocks(world, structureBoundingBox, 1, 1, 0, 2, 3, 0, Blocks.planks, Blocks.planks, false);
            this.fillWithBlocks(world, structureBoundingBox, 0, 1, 0, 0, 4, 0, Blocks.log, Blocks.log, false);
            this.fillWithBlocks(world, structureBoundingBox, 3, 1, 0, 3, 4, 0, Blocks.log, Blocks.log, false);
            this.fillWithBlocks(world, structureBoundingBox, 0, 1, 6, 0, 4, 6, Blocks.log, Blocks.log, false);
            this.placeBlockAtCurrentPosition(world, Blocks.planks, 0, 3, 3, 1, structureBoundingBox);
            this.fillWithBlocks(world, structureBoundingBox, 3, 1, 2, 3, 3, 2, Blocks.planks, Blocks.planks, false);
            this.fillWithBlocks(world, structureBoundingBox, 4, 1, 3, 5, 3, 3, Blocks.planks, Blocks.planks, false);
            this.fillWithBlocks(world, structureBoundingBox, 0, 1, 1, 0, 3, 5, Blocks.planks, Blocks.planks, false);
            this.fillWithBlocks(world, structureBoundingBox, 1, 1, 6, 5, 3, 6, Blocks.planks, Blocks.planks, false);
            this.fillWithBlocks(world, structureBoundingBox, 5, 1, 0, 5, 3, 0, Blocks.fence, Blocks.fence, false);
            this.fillWithBlocks(world, structureBoundingBox, 9, 1, 0, 9, 3, 0, Blocks.fence, Blocks.fence, false);
            this.fillWithBlocks(world, structureBoundingBox, 6, 1, 4, 9, 4, 6, Blocks.stone, Blocks.stone, false);
            this.placeBlockAtCurrentPosition(world, (Block)Blocks.flowing_lava, 0, 7, 1, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, (Block)Blocks.flowing_lava, 0, 8, 1, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.iron_bars, 0, 9, 2, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.iron_bars, 0, 9, 2, 4, structureBoundingBox);
            this.fillWithBlocks(world, structureBoundingBox, 7, 2, 4, 8, 2, 5, Blocks.air, Blocks.air, false);
            this.fillWithBlocks(world, structureBoundingBox, 6, 1, 6, 6, 4, 6, Blocks.log, Blocks.log, false);
            this.fillWithBlocks(world, structureBoundingBox, 9, 1, 6, 9, 4, 6, Blocks.log, Blocks.log, false);
            this.fillWithBlocks(world, structureBoundingBox, 7, 1, 6, 8, 4, 6, Blocks.cobblestone, Blocks.cobblestone, false);
            this.placeBlockAtCurrentPosition(world, Blocks.cobblestone, 0, 9, 4, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.cobblestone, 0, 9, 4, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stone, 0, 6, 1, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.furnace, 0, 6, 2, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.furnace, 0, 6, 3, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, (Block)Blocks.double_stone_slab, 0, 8, 1, 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.glass_pane, 0, 0, 2, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.glass_pane, 0, 0, 2, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.glass_pane, 0, 2, 2, 6, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.glass_pane, 0, 4, 2, 6, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 2, 1, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.wooden_pressure_plate, 0, 2, 2, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.planks, 0, 1, 1, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.oak_stairs, this.getMetadataWithOffset(Blocks.oak_stairs, 3), 2, 1, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.oak_stairs, this.getMetadataWithOffset(Blocks.oak_stairs, 1), 1, 1, 4, structureBoundingBox);
            if (!this.hasMadeChest) {
                final int i = this.getYWithOffset(1);
                final int j = this.getXWithOffset(5, 5);
                final int k = this.getZWithOffset(5, 5);
                if (structureBoundingBox.isVecInside(j, i, k)) {
                    this.hasMadeChest = true;
                    this.generateStructureChestContents(world, structureBoundingBox, random, 5, 1, 5, ChestGenHooks.getItems("villageBlacksmith", random), ChestGenHooks.getCount("villageBlacksmith", random));
                }
            }
            for (int i = 6; i <= 8; ++i) {
                if (this.getBlockAtCurrentPosition(world, i, 0, -1, structureBoundingBox).getMaterial() == Material.air && this.getBlockAtCurrentPosition(world, i, -1, -1, structureBoundingBox).getMaterial() != Material.air) {
                    this.placeBlockAtCurrentPosition(world, Blocks.stone_stairs, this.getMetadataWithOffset(Blocks.stone_stairs, 3), i, 0, -1, structureBoundingBox);
                }
            }
            this.spawnEntity(world, structureBoundingBox, 7, 1, 1, 0);
            return true;
        }
        
        @Override
        protected void func_143012_a(final NBTTagCompound p_143012_1_) {
            super.func_143012_a(p_143012_1_);
            p_143012_1_.setBoolean("Chest", this.hasMadeChest);
        }
        
        @Override
        protected void func_143011_b(final NBTTagCompound p_143011_1_) {
            super.func_143011_b(p_143011_1_);
            this.hasMadeChest = p_143011_1_.getBoolean("Chest");
        }
        
        @Override
        protected EntityLiving getNewEntity(final World world, final int choice) {
            return (EntityLiving)new EntitySettled(world, EnumVillager.SETTLED_SMITH);
        }
    }
    
    public static class House3 extends GlobalVillage
    {
        public House3() {
        }
        
        public House3(final StructureVillagePieces.Start startPiece, final int componentType, final Random random, final StructureBoundingBox structureBoundingBox, final int coordBaseMode) {
            super(EnumVillagePiece.SETTLED_HOUSE3, startPiece, componentType, structureBoundingBox, coordBaseMode);
            this.setOffset(6);
        }
        
        public static House3 buildComponent(final StructureVillagePieces.Start villagePiece, final List pieces, final Random random, final int x, final int y, final int z, final int coordBaseMode, final int p5) {
            final StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(x, y, z, 0, 0, 0, 9, 7, 7, coordBaseMode);
            return (canVillageGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(pieces, structureboundingbox) == null) ? new House3(villagePiece, p5, random, structureboundingbox, coordBaseMode) : null;
        }
        
        @Override
        public boolean build(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
            for (int x = 1; x < 8; ++x) {
                for (int z = 0; z < 7; ++z) {
                    if ((x != 1 && x != 7) || (z != 0 && z != 6)) {
                        this.clearCurrentPositionBlocksUpwards(world, x, 0, z, structureBoundingBox);
                        this.func_151554_b(world, Blocks.cobblestone, 0, x, -1, z, structureBoundingBox);
                    }
                }
            }
            this.fillWithBlocks(world, structureBoundingBox, 2, 0, 0, 2, 4, 0, Blocks.log, Blocks.log, false);
            this.fillWithBlocks(world, structureBoundingBox, 6, 0, 0, 6, 4, 0, Blocks.log, Blocks.log, false);
            this.fillWithBlocks(world, structureBoundingBox, 1, 0, 1, 1, 4, 1, Blocks.log, Blocks.log, false);
            this.fillWithBlocks(world, structureBoundingBox, 7, 0, 1, 7, 4, 1, Blocks.log, Blocks.log, false);
            this.fillWithBlocks(world, structureBoundingBox, 2, 0, 6, 2, 4, 6, Blocks.log, Blocks.log, false);
            this.fillWithBlocks(world, structureBoundingBox, 6, 0, 6, 6, 4, 6, Blocks.log, Blocks.log, false);
            this.fillWithBlocks(world, structureBoundingBox, 1, 0, 5, 1, 4, 5, Blocks.log, Blocks.log, false);
            this.fillWithBlocks(world, structureBoundingBox, 7, 0, 5, 7, 4, 5, Blocks.log, Blocks.log, false);
            this.fillWithBlocks(world, structureBoundingBox, 3, 0, 0, 5, 5, 0, Blocks.cobblestone, Blocks.cobblestone, false);
            this.fillWithBlocks(world, structureBoundingBox, 3, 0, 6, 5, 5, 6, Blocks.cobblestone, Blocks.cobblestone, false);
            this.fillWithBlocks(world, structureBoundingBox, 1, 0, 2, 1, 2, 4, Blocks.cobblestone, Blocks.cobblestone, false);
            this.fillWithBlocks(world, structureBoundingBox, 7, 0, 2, 7, 2, 4, Blocks.cobblestone, Blocks.cobblestone, false);
            for (int k = 0; k < 5; ++k) {
                if (k < 1) {
                    this.placeBlockAtCurrentPosition(world, Blocks.log, DirectionTools.log[this.coordBaseMode][0], 4 + k, 6, 0, structureBoundingBox);
                    this.placeBlockAtCurrentPosition(world, Blocks.log, DirectionTools.log[this.coordBaseMode][0], 4 + k, 6, 6, structureBoundingBox);
                }
                if (k < 3) {
                    this.placeBlockAtCurrentPosition(world, Blocks.log, DirectionTools.log[this.coordBaseMode][0], 3 + k, 3, 0, structureBoundingBox);
                    this.placeBlockAtCurrentPosition(world, Blocks.log, DirectionTools.log[this.coordBaseMode][0], 3 + k, 3, 6, structureBoundingBox);
                    this.placeBlockAtCurrentPosition(world, Blocks.log, DirectionTools.log[this.coordBaseMode][1], 1, 3, 2 + k, structureBoundingBox);
                    this.placeBlockAtCurrentPosition(world, Blocks.log, DirectionTools.log[this.coordBaseMode][1], 7, 3, 2 + k, structureBoundingBox);
                }
                this.placeBlockAtCurrentPosition(world, Blocks.log, DirectionTools.log[this.coordBaseMode][1], 2, 4, 1 + k, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.log, DirectionTools.log[this.coordBaseMode][1], 6, 4, 1 + k, structureBoundingBox);
            }
            this.fillWithBlocks(world, structureBoundingBox, 2, 0, 1, 6, 0, 5, Blocks.planks, Blocks.planks, false);
            this.fillWithMetadataBlocks(world, structureBoundingBox, 2, 3, 1, 6, 3, 5, (Block)Blocks.wooden_slab, 8, (Block)Blocks.wooden_slab, 8, false);
            for (int z2 = 0; z2 < 7; ++z2) {
                if (z2 != 0 && z2 != 6) {
                    this.placeBlockAtCurrentPosition(world, Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][0], 0, 3, z2, structureBoundingBox);
                    this.placeBlockAtCurrentPosition(world, Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][1], 8, 3, z2, structureBoundingBox);
                }
                this.placeBlockAtCurrentPosition(world, Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][0], 1, 4, z2, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][0], 2, 5, z2, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][0], 3, 6, z2, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, (Block)Blocks.wooden_slab, 0, 4, 7, z2, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][1], 5, 6, z2, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][1], 6, 5, z2, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][1], 7, 4, z2, structureBoundingBox);
            }
            this.fillWithBlocks(world, structureBoundingBox, 4, 4, 0, 4, 5, 0, Blocks.glass_pane, Blocks.glass_pane, false);
            this.fillWithBlocks(world, structureBoundingBox, 4, 4, 6, 4, 5, 6, Blocks.glass_pane, Blocks.glass_pane, false);
            this.placeBlockAtCurrentPosition(world, Blocks.glass_pane, 0, 4, 2, 6, structureBoundingBox);
            for (int k = 1; k < 4; ++k) {
                this.placeBlockAtCurrentPosition(world, Blocks.ladder, this.getMetadataWithOffset(Blocks.ladder, 3), 3, k, 5, structureBoundingBox);
            }
            this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 3, 2, 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 5, 2, 5, structureBoundingBox);
            this.placeDoorAtCurrentPosition(world, structureBoundingBox, random, 4, 1, 0, this.getMetadataWithOffset(Blocks.wooden_door, 1));
            if (this.getBlockAtCurrentPosition(world, 4, 0, -1, structureBoundingBox).getMaterial() == Material.air && this.getBlockAtCurrentPosition(world, 2, -1, -1, structureBoundingBox).getMaterial() != Material.air) {
                this.placeBlockAtCurrentPosition(world, Blocks.stone_stairs, this.getMetadataWithOffset(Blocks.stone_stairs, 3), 4, 0, -1, structureBoundingBox);
            }
            this.spawnEntity(world, structureBoundingBox, 4, 1, 2, 0);
            this.spawnEntity(world, structureBoundingBox, 4, 1, 2, 0);
            return true;
        }
        
        @Override
        protected EntityLiving getNewEntity(final World world, final int choice) {
            return (EntityLiving)new EntitySettled(world, EnumVillager.SETTLED_VILLAGER);
        }
    }
    
    public static class House4Garden extends GlobalVillage
    {
        public House4Garden() {
        }
        
        public House4Garden(final StructureVillagePieces.Start startPiece, final int componentType, final Random random, final StructureBoundingBox structureBoundingBox, final int coordBaseMode) {
            super(EnumVillagePiece.SETTLED_HOUSE4GARDEN, startPiece, componentType, structureBoundingBox, coordBaseMode);
            this.setOffset(4);
        }
        
        public static House4Garden buildComponent(final StructureVillagePieces.Start villagePiece, final List pieces, final Random random, final int x, final int y, final int z, final int coordBaseMode, final int p5) {
            final StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(x, y, z, 0, 0, 0, 5, 6, 5, coordBaseMode);
            return (canVillageGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(pieces, structureboundingbox) == null) ? new House4Garden(villagePiece, p5, random, structureboundingbox, coordBaseMode) : null;
        }
        
        @Override
        public boolean build(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
            for (int i = 0; i < 5; ++i) {
                for (int j = 0; j < 5; ++j) {
                    this.clearCurrentPositionBlocksUpwards(world, j, 0, i, structureBoundingBox);
                    this.func_151554_b(world, Blocks.cobblestone, 0, j, -1, i, structureBoundingBox);
                }
            }
            this.fillWithBlocks(world, structureBoundingBox, 0, 0, 0, 4, 0, 4, Blocks.cobblestone, Blocks.cobblestone, false);
            this.fillWithBlocks(world, structureBoundingBox, 1, 0, 1, 3, 0, 3, Blocks.stone, Blocks.stone, false);
            this.placeBlockAtCurrentPosition(world, Blocks.stone, 0, 2, 0, 0, structureBoundingBox);
            this.fillWithBlocks(world, structureBoundingBox, 1, 4, 1, 3, 4, 3, Blocks.planks, Blocks.planks, false);
            for (int k = 0; k < 5; ++k) {
                this.placeBlockAtCurrentPosition(world, Blocks.log, 0, 0, k, 0, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.log, 0, 4, k, 0, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.log, 0, 0, k, 4, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.log, 0, 4, k, 4, structureBoundingBox);
                if (k < 3) {
                    this.placeBlockAtCurrentPosition(world, Blocks.log, DirectionTools.log[this.coordBaseMode][0], 1 + k, 4, 0, structureBoundingBox);
                    this.placeBlockAtCurrentPosition(world, Blocks.log, DirectionTools.log[this.coordBaseMode][0], 1 + k, 4, 4, structureBoundingBox);
                    this.placeBlockAtCurrentPosition(world, Blocks.log, DirectionTools.log[this.coordBaseMode][1], 0, 4, 1 + k, structureBoundingBox);
                    this.placeBlockAtCurrentPosition(world, Blocks.log, DirectionTools.log[this.coordBaseMode][1], 4, 4, 1 + k, structureBoundingBox);
                }
            }
            this.fillWithBlocks(world, structureBoundingBox, 0, 1, 1, 0, 3, 3, Blocks.planks, Blocks.planks, false);
            this.fillWithBlocks(world, structureBoundingBox, 4, 1, 1, 4, 3, 3, Blocks.planks, Blocks.planks, false);
            this.fillWithBlocks(world, structureBoundingBox, 1, 1, 4, 3, 3, 4, Blocks.planks, Blocks.planks, false);
            this.placeBlockAtCurrentPosition(world, Blocks.glass_pane, 0, 0, 2, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.glass_pane, 0, 2, 2, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.glass_pane, 0, 4, 2, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.planks, 0, 1, 1, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.planks, 0, 1, 2, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.planks, 0, 1, 3, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.planks, 0, 2, 3, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.planks, 0, 3, 3, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.planks, 0, 3, 2, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.planks, 0, 3, 1, 0, structureBoundingBox);
            if (this.getBlockAtCurrentPosition(world, 2, 0, -1, structureBoundingBox).getMaterial() == Material.air && this.getBlockAtCurrentPosition(world, 2, -1, -1, structureBoundingBox).getMaterial() != Material.air) {
                this.placeBlockAtCurrentPosition(world, Blocks.stone_stairs, this.getMetadataWithOffset(Blocks.stone_stairs, 3), 2, 0, -1, structureBoundingBox);
            }
            this.fillWithBlocks(world, structureBoundingBox, 1, 1, 1, 3, 3, 3, Blocks.air, Blocks.air, false);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 0, 5, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 1, 5, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 2, 5, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 3, 5, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 4, 5, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 0, 5, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 1, 5, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 2, 5, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 3, 5, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 4, 5, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 4, 5, 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 4, 5, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 4, 5, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 0, 5, 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 0, 5, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 0, 5, 3, structureBoundingBox);
            int i = this.getMetadataWithOffset(Blocks.ladder, 3);
            this.placeBlockAtCurrentPosition(world, Blocks.ladder, i, 3, 1, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.ladder, i, 3, 2, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.ladder, i, 3, 3, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.ladder, i, 3, 4, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 2, 3, 1, structureBoundingBox);
            this.spawnEntity(world, structureBoundingBox, 1, 1, 2, 0);
            this.spawnEntity(world, structureBoundingBox, 1, 1, 2, 0);
            this.spawnEntity(world, structureBoundingBox, 1, 1, 2, 0);
            return true;
        }
        
        @Override
        protected EntityLiving getNewEntity(final World world, final int choice) {
            return (EntityLiving)new EntitySettled(world, EnumVillager.SETTLED_GUARD);
        }
    }
    
    public static class Torch extends GlobalTorch
    {
        public Torch() {
        }
        
        public Torch(final StructureVillagePieces.Start startPiece, final int componentType, final Random random, final StructureBoundingBox structureBoundingBox, final int coordBaseMode) {
            super(EnumVillageBasicPiece.SETTLED_TORCH, startPiece, componentType, random, structureBoundingBox, coordBaseMode);
            this.setOffset(3);
        }
        
        @Override
        public boolean build(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
            this.fillWithBlocks(world, structureBoundingBox, 0, 0, 0, 2, 3, 1, Blocks.air, Blocks.air, false);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 1, 0, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 1, 1, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 1, 2, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.wool, 15, 1, 3, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 0, 3, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 1, 3, 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 2, 3, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 1, 3, -1, structureBoundingBox);
            return true;
        }
    }
}
