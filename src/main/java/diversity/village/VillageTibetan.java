// 
// Decompiled by Procyon v0.5.36
// 

package diversity.village;

import net.minecraft.util.MathHelper;
import diversity.utils.DirectionTools;
import diversity.entity.EntityTibetan;
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
import net.minecraft.world.gen.structure.StructureBoundingBox;
import java.util.List;
import java.util.Random;
import net.minecraft.world.biome.WorldChunkManager;
import diversity.suppliers.EnumVillage;

public class VillageTibetan extends VillageTools
{
    private static VillageTibetan instance;
    
    public VillageTibetan(final EnumVillage village) {
        super(village);
        VillageTibetan.instance = this;
    }
    
    @Override
    public Start getStart(final WorldChunkManager worldChunkManager, final int i, final Random rand, final int j, final int k, final List list, final int terrainType) {
        return new Start(worldChunkManager, i, rand, j, k, list, terrainType);
    }
    
    @Override
    protected GlobalTorch getTorch(final GlobalStart startPiece, final int componentType, final Random random, final StructureBoundingBox structureBoundingBox, final int coordBaseMode) {
        return new Torch(startPiece, componentType, random, structureBoundingBox, coordBaseMode);
    }
    
    @Override
    protected GlobalPath getPath(final GlobalStart startPiece, final int componentType, final Random random, final StructureBoundingBox structureboundingbox, final int coordBaseMode) {
        return new Path(startPiece, componentType, random, structureboundingbox, coordBaseMode);
    }
    
    public static class Start extends GlobalStart
    {
        public Start() {
        }
        
        public Start(final WorldChunkManager p_i2104_1_, final int p_i2104_2_, final Random p_i2104_3_, final int p_i2104_4_, final int p_i2104_5_, final List p_i2104_6_, final int p_i2104_7_) {
            super(VillageTibetan.instance, p_i2104_1_, p_i2104_2_, p_i2104_3_, p_i2104_4_, p_i2104_5_, p_i2104_6_, p_i2104_7_);
        }
        
        @Override
        public boolean addComponentParts(final World world, final Random rand, final StructureBoundingBox structureBoundingBox) {
            if (super.addComponentParts(world, rand, structureBoundingBox, 3)) {
                return true;
            }
            this.fillWithBlocks(world, structureBoundingBox, 0, 0, 0, 5, 9, 5, Blocks.dirt, Blocks.dirt, false);
            for (int i = 0; i < 6; ++i) {
                for (int j = 0; j < 6; ++j) {
                    this.placeBlockAtCurrentPosition(world, Blocks.dirt, 1, j, 10, i, structureBoundingBox);
                    this.clearCurrentPositionBlocksUpwards(world, j, 11, i, structureBoundingBox);
                }
            }
            this.placeBlockAtCurrentPosition(world, Blocks.cobblestone, 0, 0, 11, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.cobblestone_wall, 0, 0, 12, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.cobblestone_wall, 0, 0, 13, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.cobblestone, 0, 0, 11, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.cobblestone_wall, 0, 0, 12, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.cobblestone_wall, 0, 0, 13, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.cobblestone, 0, 5, 11, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.cobblestone_wall, 0, 5, 12, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.cobblestone_wall, 0, 5, 13, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.cobblestone, 0, 5, 11, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.cobblestone_wall, 0, 5, 12, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.cobblestone_wall, 0, 5, 13, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.cobblestone, 0, 2, 11, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.cobblestone, 0, 2, 11, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.cobblestone, 0, 3, 11, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.cobblestone, 0, 3, 11, 3, structureBoundingBox);
            return true;
        }
    }
    
    public static class Path extends GlobalPath
    {
        public Path() {
        }
        
        public Path(final GlobalStart p_i2105_1_, final int p_i2105_2_, final Random p_i2105_3_, final StructureBoundingBox p_i2105_4_, final int p_i2105_5_) {
            super(VillageTibetan.instance, p_i2105_1_, p_i2105_2_, p_i2105_3_, p_i2105_4_, p_i2105_5_);
        }
        
        @Override
        protected BlockData getPathBlock(final Random random) {
            return new BlockData(Blocks.dirt, 1);
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
            super(EnumVillageBasicPiece.TIBETAN_TORCH, startPiece, componentType, random, structureBoundingBox, coordBaseMode);
            this.setOffset(2);
        }
        
        @Override
        public boolean build(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
            final int d0 = (this.coordBaseMode == 0) ? 0 : ((this.coordBaseMode == 1) ? 2 : ((this.coordBaseMode == 2) ? 0 : 2));
            final int d2 = (this.coordBaseMode == 0) ? 1 : ((this.coordBaseMode == 1) ? 3 : ((this.coordBaseMode == 2) ? 1 : 3));
            final int d3 = (this.coordBaseMode == 0) ? 3 : ((this.coordBaseMode == 1) ? 0 : ((this.coordBaseMode == 2) ? 2 : 1));
            final int d4 = (this.coordBaseMode == 0) ? 2 : ((this.coordBaseMode == 1) ? 1 : ((this.coordBaseMode == 2) ? 3 : 0));
            this.fillWithBlocks(world, structureBoundingBox, 0, 1, 0, 2, 3, 1, Blocks.air, Blocks.air, false);
            this.func_151554_b(world, Blocks.cobblestone, 0, 0, 0, 0, structureBoundingBox);
            this.func_151554_b(world, Blocks.cobblestone, 0, 1, 0, 0, structureBoundingBox);
            this.func_151554_b(world, Blocks.cobblestone, 0, 1, 0, 1, structureBoundingBox);
            this.func_151554_b(world, Blocks.cobblestone, 0, 2, 0, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.log, 1, 1, 1, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 0, 1, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 0, 2, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 2, 1, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 2, 2, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 1, 1, 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 1, 2, 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, (Block)Blocks.wooden_slab, 13, 1, 3, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, (Block)Blocks.wooden_slab, 5, 1, 4, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, d0, 0, 3, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, d2, 2, 3, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, d3, 1, 3, 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 1, 2, 0, structureBoundingBox);
            return true;
        }
    }
    
    public static class MainHouse extends GlobalVillage
    {
        private int darkOakStair0;
        private int darkOakStair1;
        private int darkOakStair2;
        private int darkOakStair3;
        
        public MainHouse() {
        }
        
        public MainHouse(final StructureVillagePieces.Start villagePiece, final int componentType, final Random random, final StructureBoundingBox structureBoundingBox, final int coordBaseMode) {
            super(EnumVillagePiece.TIBETAN_MAINHOUSE, villagePiece, componentType, structureBoundingBox, coordBaseMode);
            this.setOffset(13);
            this.darkOakStair0 = ((coordBaseMode == 0) ? 0 : ((coordBaseMode == 1) ? 2 : ((coordBaseMode == 2) ? 0 : 2)));
            this.darkOakStair1 = ((coordBaseMode == 0) ? 1 : ((coordBaseMode == 1) ? 3 : ((coordBaseMode == 2) ? 1 : 3)));
            this.darkOakStair2 = ((coordBaseMode == 0) ? 3 : ((coordBaseMode == 1) ? 0 : ((coordBaseMode == 2) ? 2 : 1)));
            this.darkOakStair3 = ((coordBaseMode == 0) ? 2 : ((coordBaseMode == 1) ? 1 : ((coordBaseMode == 2) ? 3 : 0)));
        }
        
        public static MainHouse buildComponent(final StructureVillagePieces.Start villagePiece, final List pieces, final Random random, final int x, final int y, final int z, final int coordBaseMode, final int p5) {
            final StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(x, y, z, 0, 0, 0, 11, 15, 13, coordBaseMode);
            return (canVillageGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(pieces, structureboundingbox) == null) ? new MainHouse(villagePiece, p5, random, structureboundingbox, coordBaseMode) : null;
        }
        
        @Override
        public boolean build(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
            for (int x = 0; x < 11; ++x) {
                for (int z = 1; z < 12; ++z) {
                    this.func_151554_b(world, Blocks.cobblestone, 0, x, 2, z, structureBoundingBox);
                    this.clearCurrentPositionBlocksUpwards(world, x, 3, z, structureBoundingBox);
                }
            }
            for (int x = 3; x < 8; ++x) {
                this.func_151554_b(world, Blocks.cobblestone, 0, x, 0, 0, structureBoundingBox);
                this.func_151554_b(world, Blocks.cobblestone, 0, x, 0, 12, structureBoundingBox);
                this.clearCurrentPositionBlocksUpwards(world, x, 1, 0, structureBoundingBox);
                this.clearCurrentPositionBlocksUpwards(world, x, 1, 12, structureBoundingBox);
            }
            this.fillWithBlocks(world, structureBoundingBox, 1, 2, 2, 9, 2, 10, Blocks.planks, Blocks.planks, false);
            this.fillWithBlocks(world, structureBoundingBox, 2, 3, 3, 8, 5, 9, Blocks.wool, Blocks.wool, false);
            this.fillWithBlocks(world, structureBoundingBox, 3, 3, 4, 7, 5, 8, Blocks.air, Blocks.air, false);
            this.fillWithBlocks(world, structureBoundingBox, 3, 6, 4, 7, 8, 8, Blocks.wool, Blocks.wool, false);
            this.fillWithBlocks(world, structureBoundingBox, 4, 6, 5, 6, 8, 7, Blocks.air, Blocks.air, false);
            this.fillWithBlocks(world, structureBoundingBox, 4, 9, 5, 6, 11, 7, Blocks.wool, Blocks.wool, false);
            this.fillWithBlocks(world, structureBoundingBox, 5, 9, 6, 5, 11, 6, Blocks.air, Blocks.air, false);
            for (int y = 0; y <= 2; ++y) {
                this.placeBlockAtCurrentPosition(world, Blocks.log, 1, 2, y + 3, 3, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.log, 1, 4, y + 3, 3, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.log, 1, 2, y + 3, 5, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.log, 1, 4, y + 6, 4, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.log, 1, 3, y + 6, 5, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.log, 1, 4, y + 9, 5, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.log, 1, 8, y + 3, 3, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.log, 1, 6, y + 3, 3, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.log, 1, 8, y + 3, 5, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.log, 1, 6, y + 6, 4, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.log, 1, 7, y + 6, 5, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.log, 1, 6, y + 9, 5, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.log, 1, 2, y + 3, 9, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.log, 1, 4, y + 3, 9, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.log, 1, 2, y + 3, 7, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.log, 1, 4, y + 6, 8, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.log, 1, 3, y + 6, 7, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.log, 1, 4, y + 9, 7, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.log, 1, 8, y + 3, 9, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.log, 1, 6, y + 3, 9, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.log, 1, 8, y + 3, 7, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.log, 1, 6, y + 6, 8, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.log, 1, 7, y + 6, 7, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.log, 1, 6, y + 9, 7, structureBoundingBox);
            }
            for (int x = 3; x < 8; ++x) {
                for (int z = 4; z < 9; ++z) {
                    this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 10, x, 5, z, structureBoundingBox);
                    if (x != 3 && x != 7 && z != 4 && z != 8) {
                        this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 10, x, 8, z, structureBoundingBox);
                    }
                }
            }
            for (int x = 0; x < 11; ++x) {
                for (int z = 1; z < 12; ++z) {
                    if ((x == 0 || x == 10) && (z == 1 || z == 11)) {
                        this.placeBlockAtCurrentPosition(world, (Block)Blocks.wooden_slab, 5, x, 7, z, structureBoundingBox);
                    }
                    else if (((x == 1 || x == 9) && (z == 1 || z == 11)) || ((z == 2 || z == 10) && (x == 0 || x == 10))) {
                        this.placeBlockAtCurrentPosition(world, (Block)Blocks.wooden_slab, 13, x, 6, z, structureBoundingBox);
                    }
                    else if (x + z <= 4 || x + 12 - z <= 4 || 10 - x + z <= 4 || 10 - x + 12 - z <= 4) {
                        this.placeBlockAtCurrentPosition(world, (Block)Blocks.wooden_slab, 5, x, 6, z, structureBoundingBox);
                    }
                    else if (x < 2 || x > 8 || z < 3 || z > 9) {
                        this.placeBlockAtCurrentPosition(world, (Block)Blocks.wooden_slab, 13, x, 5, z, structureBoundingBox);
                    }
                    else if (((x == 2 || x == 8) && z >= 3 && z <= 9) || ((z == 3 || z == 9) && x >= 2 && x <= 8)) {
                        this.placeBlockAtCurrentPosition(world, (Block)Blocks.wooden_slab, 5, x, 6, z, structureBoundingBox);
                    }
                }
            }
            for (int x = 1; x < 10; ++x) {
                for (int z = 2; z < 11; ++z) {
                    if ((x == 1 || x == 9) && (z == 2 || z == 10)) {
                        this.placeBlockAtCurrentPosition(world, (Block)Blocks.wooden_slab, 13, x, 9, z, structureBoundingBox);
                    }
                    else if (x + z <= 5 || x + 12 - z <= 5 || 10 - x + z <= 5 || 10 - x + 12 - z <= 5) {
                        this.placeBlockAtCurrentPosition(world, (Block)Blocks.wooden_slab, 5, x, 9, z, structureBoundingBox);
                    }
                    else if (x < 3 || x > 7 || z < 4 || z > 8) {
                        this.placeBlockAtCurrentPosition(world, (Block)Blocks.wooden_slab, 13, x, 8, z, structureBoundingBox);
                    }
                    else if (((x == 3 || x == 7) && z >= 4 && z <= 8) || ((z == 4 || z == 8) && x >= 3 && x <= 7)) {
                        this.placeBlockAtCurrentPosition(world, (Block)Blocks.wooden_slab, 5, x, 9, z, structureBoundingBox);
                    }
                }
            }
            for (int x = 2; x < 9; ++x) {
                for (int z = 3; z < 10; ++z) {
                    if ((x == 2 || x == 8) && (z == 3 || z == 9)) {
                        this.placeBlockAtCurrentPosition(world, (Block)Blocks.wooden_slab, 13, x, 12, z, structureBoundingBox);
                    }
                    else if (x + z <= 6 || x + 12 - z <= 6 || 10 - x + z <= 6 || 10 - x + 12 - z <= 6) {
                        this.placeBlockAtCurrentPosition(world, (Block)Blocks.wooden_slab, 5, x, 12, z, structureBoundingBox);
                    }
                    else if (x < 4 || x > 6 || z < 5 || z > 7) {
                        this.placeBlockAtCurrentPosition(world, (Block)Blocks.wooden_slab, 13, x, 11, z, structureBoundingBox);
                    }
                    else if (x != 5 && z != 6) {
                        this.placeBlockAtCurrentPosition(world, Blocks.planks, 5, x, 12, z, structureBoundingBox);
                    }
                    else {
                        this.placeBlockAtCurrentPosition(world, Blocks.planks, 0, x, 12, z, structureBoundingBox);
                    }
                }
            }
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair0, 2, 6, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair0, 2, 6, 6, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair0, 2, 6, 7, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair1, 8, 6, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair1, 8, 6, 6, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair1, 8, 6, 7, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair2, 4, 6, 9, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair2, 5, 6, 9, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair2, 6, 6, 9, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair3, 4, 6, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair3, 5, 6, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair3, 6, 6, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair0, 4, 9, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair0, 3, 9, 6, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair0, 4, 9, 8, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair1, 6, 9, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair1, 7, 9, 6, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair1, 6, 9, 8, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair2, 3, 9, 7, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair2, 5, 9, 8, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair2, 7, 9, 7, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair3, 3, 9, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair3, 5, 9, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair3, 7, 9, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair0, 3, 12, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair0, 3, 12, 6, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair0, 3, 12, 7, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair1, 7, 12, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair1, 7, 12, 6, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair1, 7, 12, 7, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair2, 4, 12, 8, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair2, 5, 12, 8, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair2, 6, 12, 8, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair3, 4, 12, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair3, 5, 12, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair3, 6, 12, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair0, 4, 13, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair0, 4, 13, 6, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair1, 6, 13, 6, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair1, 6, 13, 7, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair2, 4, 13, 7, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair2, 5, 13, 7, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair3, 5, 13, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair3, 6, 13, 5, structureBoundingBox);
            this.fillWithBlocks(world, structureBoundingBox, 4, 12, 5, 6, 12, 7, Blocks.planks, Blocks.planks, false);
            this.placeBlockAtCurrentPosition(world, Blocks.planks, 5, 5, 13, 6, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.planks, 5, 5, 14, 6, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, (Block)Blocks.wooden_slab, 5, 5, 15, 6, structureBoundingBox);
            this.fillWithBlocks(world, structureBoundingBox, 0, 3, 1, 10, 3, 1, Blocks.fence, Blocks.fence, false);
            this.fillWithBlocks(world, structureBoundingBox, 0, 3, 11, 10, 3, 11, Blocks.fence, Blocks.fence, false);
            this.fillWithBlocks(world, structureBoundingBox, 0, 3, 1, 0, 3, 11, Blocks.fence, Blocks.fence, false);
            this.fillWithBlocks(world, structureBoundingBox, 10, 3, 1, 10, 3, 11, Blocks.fence, Blocks.fence, false);
            this.fillWithBlocks(world, structureBoundingBox, 2, 4, 1, 2, 5, 1, Blocks.fence, Blocks.fence, false);
            this.fillWithBlocks(world, structureBoundingBox, 3, 6, 2, 3, 8, 2, Blocks.fence, Blocks.fence, false);
            this.fillWithBlocks(world, structureBoundingBox, 3, 9, 3, 3, 11, 3, Blocks.fence, Blocks.fence, false);
            this.fillWithBlocks(world, structureBoundingBox, 8, 4, 1, 8, 5, 1, Blocks.fence, Blocks.fence, false);
            this.fillWithBlocks(world, structureBoundingBox, 7, 6, 2, 7, 8, 2, Blocks.fence, Blocks.fence, false);
            this.fillWithBlocks(world, structureBoundingBox, 7, 9, 3, 7, 11, 3, Blocks.fence, Blocks.fence, false);
            this.fillWithBlocks(world, structureBoundingBox, 0, 4, 3, 0, 5, 3, Blocks.fence, Blocks.fence, false);
            this.fillWithBlocks(world, structureBoundingBox, 1, 6, 4, 1, 8, 4, Blocks.fence, Blocks.fence, false);
            this.fillWithBlocks(world, structureBoundingBox, 2, 9, 4, 2, 11, 4, Blocks.fence, Blocks.fence, false);
            this.fillWithBlocks(world, structureBoundingBox, 10, 4, 3, 10, 5, 3, Blocks.fence, Blocks.fence, false);
            this.fillWithBlocks(world, structureBoundingBox, 9, 6, 4, 9, 8, 4, Blocks.fence, Blocks.fence, false);
            this.fillWithBlocks(world, structureBoundingBox, 8, 9, 4, 8, 11, 4, Blocks.fence, Blocks.fence, false);
            this.fillWithBlocks(world, structureBoundingBox, 0, 4, 9, 0, 5, 9, Blocks.fence, Blocks.fence, false);
            this.fillWithBlocks(world, structureBoundingBox, 1, 6, 8, 1, 8, 8, Blocks.fence, Blocks.fence, false);
            this.fillWithBlocks(world, structureBoundingBox, 2, 9, 8, 2, 11, 8, Blocks.fence, Blocks.fence, false);
            this.fillWithBlocks(world, structureBoundingBox, 10, 4, 9, 10, 5, 9, Blocks.fence, Blocks.fence, false);
            this.fillWithBlocks(world, structureBoundingBox, 9, 6, 8, 9, 8, 8, Blocks.fence, Blocks.fence, false);
            this.fillWithBlocks(world, structureBoundingBox, 8, 9, 8, 8, 11, 8, Blocks.fence, Blocks.fence, false);
            this.fillWithBlocks(world, structureBoundingBox, 2, 4, 11, 2, 5, 11, Blocks.fence, Blocks.fence, false);
            this.fillWithBlocks(world, structureBoundingBox, 3, 6, 10, 3, 8, 10, Blocks.fence, Blocks.fence, false);
            this.fillWithBlocks(world, structureBoundingBox, 3, 9, 9, 3, 11, 9, Blocks.fence, Blocks.fence, false);
            this.fillWithBlocks(world, structureBoundingBox, 8, 4, 11, 8, 5, 11, Blocks.fence, Blocks.fence, false);
            this.fillWithBlocks(world, structureBoundingBox, 7, 6, 10, 7, 8, 10, Blocks.fence, Blocks.fence, false);
            this.fillWithBlocks(world, structureBoundingBox, 7, 9, 9, 7, 11, 9, Blocks.fence, Blocks.fence, false);
            this.fillWithBlocks(world, structureBoundingBox, 3, 1, 0, 3, 2, 0, Blocks.cobblestone, Blocks.cobblestone, false);
            this.fillWithBlocks(world, structureBoundingBox, 7, 1, 0, 7, 2, 0, Blocks.cobblestone, Blocks.cobblestone, false);
            this.fillWithBlocks(world, structureBoundingBox, 3, 1, 12, 3, 2, 12, Blocks.cobblestone, Blocks.cobblestone, false);
            this.fillWithBlocks(world, structureBoundingBox, 7, 1, 12, 7, 2, 12, Blocks.cobblestone, Blocks.cobblestone, false);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 3, 3, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 7, 3, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 3, 3, 12, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 7, 3, 12, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 2, 4, 6, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 8, 4, 6, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 3, 7, 6, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 7, 7, 6, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 5, 7, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 5, 7, 8, structureBoundingBox);
            for (int x = 4; x < 7; ++x) {
                this.placeBlockAtCurrentPosition(world, Blocks.air, 0, x, 3, 1, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.air, 0, x, 3, 11, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.oak_stairs, this.darkOakStair3, x, 1, 0, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.oak_stairs, this.darkOakStair3, x, 2, 1, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.oak_stairs, this.darkOakStair2, x, 1, 12, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.oak_stairs, this.darkOakStair2, x, 2, 11, structureBoundingBox);
            }
            this.placeDoorAtCurrentPosition(world, structureBoundingBox, random, 5, 3, 3, this.getMetadataWithOffset(Blocks.wooden_door, 1));
            this.placeDoorAtCurrentPosition(world, structureBoundingBox, random, 5, 3, 9, this.getMetadataWithOffset(Blocks.wooden_door, 1));
            for (int y = 3; y < 7; ++y) {
                this.placeBlockAtCurrentPosition(world, Blocks.log, 1, 6, y, 6, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.ladder, this.getMetadataWithOffset(Blocks.ladder, 4), 5, y, 6, structureBoundingBox);
            }
            this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 6, 4, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 6, 4, 7, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 6, 7, 6, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 4, 10, 6, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 6, 10, 6, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 5, 10, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 5, 10, 7, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.planks, 0, 5, 9, 6, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 5, 10, 6, structureBoundingBox);
            this.spawnEntity(world, structureBoundingBox, 5, 4, 2, 0);
            return true;
        }
        
        @Override
        protected EntityLiving getNewEntity(final World world, final int choice) {
            return (EntityLiving)new EntityTibetan(world, EnumVillager.TIBETAN_GREATWISE);
        }
    }
    
    public static class House2 extends GlobalVillage
    {
        private int darkOakStair0;
        private int darkOakStair1;
        private int darkOakStair2;
        private int darkOakStair3;
        
        public House2() {
        }
        
        public House2(final StructureVillagePieces.Start villagePiece, final int componentType, final Random random, final StructureBoundingBox structureBoundingBox, final int coordBaseMode) {
            super(EnumVillagePiece.TIBETAN_HOUSE2, villagePiece, componentType, structureBoundingBox, coordBaseMode);
            this.setOffset(9);
            this.darkOakStair0 = ((coordBaseMode == 0) ? 0 : ((coordBaseMode == 1) ? 2 : ((coordBaseMode == 2) ? 0 : 2)));
            this.darkOakStair1 = ((coordBaseMode == 0) ? 1 : ((coordBaseMode == 1) ? 3 : ((coordBaseMode == 2) ? 1 : 3)));
            this.darkOakStair2 = ((coordBaseMode == 0) ? 3 : ((coordBaseMode == 1) ? 0 : ((coordBaseMode == 2) ? 2 : 1)));
            this.darkOakStair3 = ((coordBaseMode == 0) ? 2 : ((coordBaseMode == 1) ? 1 : ((coordBaseMode == 2) ? 3 : 0)));
        }
        
        public static House2 buildComponent(final StructureVillagePieces.Start villagePiece, final List pieces, final Random random, final int x, final int y, final int z, final int coordBaseMode, final int p5) {
            final StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(x, y, z, 0, 0, 0, 7, 11, 8, coordBaseMode);
            return (canVillageGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(pieces, structureboundingbox) == null) ? new House2(villagePiece, p5, random, structureboundingbox, coordBaseMode) : null;
        }
        
        @Override
        public boolean build(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
            for (int x = 1; x < 6; ++x) {
                for (int z = 1; z < 7; ++z) {
                    this.func_151554_b(world, Blocks.cobblestone, 0, x, 2, z, structureBoundingBox);
                    this.clearCurrentPositionBlocksUpwards(world, x, 3, z, structureBoundingBox);
                }
            }
            this.fillWithBlocks(world, structureBoundingBox, 2, 2, 3, 4, 2, 5, Blocks.planks, Blocks.planks, false);
            this.placeBlockAtCurrentPosition(world, Blocks.planks, 0, 3, 2, 2, structureBoundingBox);
            this.fillWithBlocks(world, structureBoundingBox, 1, 3, 2, 5, 5, 6, Blocks.wool, Blocks.wool, false);
            this.fillWithBlocks(world, structureBoundingBox, 2, 3, 3, 4, 5, 5, Blocks.air, Blocks.air, false);
            this.fillWithBlocks(world, structureBoundingBox, 2, 6, 3, 4, 8, 5, Blocks.wool, Blocks.wool, false);
            this.fillWithBlocks(world, structureBoundingBox, 3, 7, 4, 3, 8, 4, Blocks.air, Blocks.air, false);
            for (int y = 0; y <= 2; ++y) {
                this.placeBlockAtCurrentPosition(world, Blocks.log, 1, 2, y + 3, 2, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.log, 1, 4, y + 3, 2, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.log, 1, 1, y + 3, 3, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.log, 1, 5, y + 3, 3, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.log, 1, 1, y + 3, 5, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.log, 1, 5, y + 3, 5, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.log, 1, 2, y + 3, 6, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.log, 1, 4, y + 3, 6, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.log, 1, 2, y + 6, 3, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.log, 1, 4, y + 6, 3, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.log, 1, 2, y + 6, 5, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.log, 1, 4, y + 6, 5, structureBoundingBox);
            }
            for (int x = 2; x < 5; ++x) {
                for (int z = 3; z < 6; ++z) {
                    this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 10, x, 5, z, structureBoundingBox);
                }
            }
            for (int x = 0; x < 7; ++x) {
                for (int z = 1; z < 8; ++z) {
                    if ((x == 0 || x == 6) && (z == 1 || z == 7)) {
                        this.placeBlockAtCurrentPosition(world, (Block)Blocks.wooden_slab, 13, x, 6, z, structureBoundingBox);
                    }
                    else if (x + z <= 2 || x + 7 - z <= 1 || 6 - x + z <= 2 || 6 - x + 7 - z <= 1) {
                        this.placeBlockAtCurrentPosition(world, (Block)Blocks.wooden_slab, 5, x, 6, z, structureBoundingBox);
                    }
                    else if (x < 1 || x > 5 || z < 2 || z > 6) {
                        this.placeBlockAtCurrentPosition(world, (Block)Blocks.wooden_slab, 13, x, 5, z, structureBoundingBox);
                    }
                }
            }
            this.placeBlockAtCurrentPosition(world, (Block)Blocks.wooden_slab, 5, 1, 6, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, (Block)Blocks.wooden_slab, 5, 5, 6, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, (Block)Blocks.wooden_slab, 5, 1, 6, 6, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, (Block)Blocks.wooden_slab, 5, 5, 6, 6, structureBoundingBox);
            for (int x = 1; x < 6; ++x) {
                for (int z = 2; z < 7; ++z) {
                    if ((x == 1 || x == 5) && (z == 2 || z == 6)) {
                        this.placeBlockAtCurrentPosition(world, (Block)Blocks.wooden_slab, 13, x, 9, z, structureBoundingBox);
                    }
                    else if (x + z <= 4 || x + 7 - z <= 3 || 6 - x + z <= 4 || 6 - x + 7 - z <= 3) {
                        this.placeBlockAtCurrentPosition(world, (Block)Blocks.wooden_slab, 5, x, 9, z, structureBoundingBox);
                    }
                    else if (x < 2 || x > 4 || z < 3 || z > 5) {
                        this.placeBlockAtCurrentPosition(world, (Block)Blocks.wooden_slab, 13, x, 8, z, structureBoundingBox);
                    }
                }
            }
            this.placeBlockAtCurrentPosition(world, Blocks.planks, 5, 1, 6, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.planks, 5, 1, 6, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.planks, 5, 5, 6, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.planks, 5, 5, 6, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.planks, 5, 2, 6, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.planks, 5, 2, 6, 6, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.planks, 5, 4, 6, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.planks, 5, 4, 6, 6, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair0, 1, 6, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair1, 5, 6, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair2, 3, 6, 6, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair3, 3, 6, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, (Block)Blocks.wooden_slab, 5, 2, 9, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, (Block)Blocks.wooden_slab, 5, 2, 9, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, (Block)Blocks.wooden_slab, 5, 4, 9, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, (Block)Blocks.wooden_slab, 5, 4, 9, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair0, 2, 9, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair1, 4, 9, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair2, 3, 9, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair3, 3, 9, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, (Block)Blocks.wooden_slab, 8, 3, 8, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.planks, 5, 3, 9, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.planks, 5, 3, 10, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, (Block)Blocks.wooden_slab, 5, 3, 11, 4, structureBoundingBox);
            this.func_151554_b(world, Blocks.cobblestone, 0, 1, 2, 1, structureBoundingBox);
            this.fillWithBlocks(world, structureBoundingBox, 1, 3, 1, 1, 5, 1, Blocks.fence, Blocks.fence, false);
            this.func_151554_b(world, Blocks.cobblestone, 0, 5, 2, 1, structureBoundingBox);
            this.fillWithBlocks(world, structureBoundingBox, 5, 3, 1, 5, 5, 1, Blocks.fence, Blocks.fence, false);
            this.func_151554_b(world, Blocks.cobblestone, 0, 1, 2, 7, structureBoundingBox);
            this.fillWithBlocks(world, structureBoundingBox, 1, 3, 7, 1, 5, 7, Blocks.fence, Blocks.fence, false);
            this.func_151554_b(world, Blocks.cobblestone, 0, 5, 2, 7, structureBoundingBox);
            this.fillWithBlocks(world, structureBoundingBox, 5, 3, 7, 5, 5, 7, Blocks.fence, Blocks.fence, false);
            this.func_151554_b(world, Blocks.cobblestone, 0, 0, 2, 2, structureBoundingBox);
            this.fillWithBlocks(world, structureBoundingBox, 0, 3, 2, 0, 5, 2, Blocks.fence, Blocks.fence, false);
            this.func_151554_b(world, Blocks.cobblestone, 0, 0, 2, 6, structureBoundingBox);
            this.fillWithBlocks(world, structureBoundingBox, 0, 3, 6, 0, 5, 6, Blocks.fence, Blocks.fence, false);
            this.func_151554_b(world, Blocks.cobblestone, 0, 6, 2, 2, structureBoundingBox);
            this.fillWithBlocks(world, structureBoundingBox, 6, 3, 2, 6, 5, 2, Blocks.fence, Blocks.fence, false);
            this.func_151554_b(world, Blocks.cobblestone, 0, 6, 2, 6, structureBoundingBox);
            this.fillWithBlocks(world, structureBoundingBox, 6, 3, 6, 6, 5, 6, Blocks.fence, Blocks.fence, false);
            this.fillWithBlocks(world, structureBoundingBox, 2, 7, 2, 2, 8, 2, Blocks.fence, Blocks.fence, false);
            this.fillWithBlocks(world, structureBoundingBox, 4, 7, 2, 4, 8, 2, Blocks.fence, Blocks.fence, false);
            this.fillWithBlocks(world, structureBoundingBox, 2, 7, 6, 2, 8, 6, Blocks.fence, Blocks.fence, false);
            this.fillWithBlocks(world, structureBoundingBox, 4, 7, 6, 4, 8, 6, Blocks.fence, Blocks.fence, false);
            this.fillWithBlocks(world, structureBoundingBox, 1, 7, 3, 1, 8, 3, Blocks.fence, Blocks.fence, false);
            this.fillWithBlocks(world, structureBoundingBox, 1, 7, 5, 1, 8, 5, Blocks.fence, Blocks.fence, false);
            this.fillWithBlocks(world, structureBoundingBox, 5, 7, 3, 5, 8, 3, Blocks.fence, Blocks.fence, false);
            this.fillWithBlocks(world, structureBoundingBox, 5, 7, 5, 5, 8, 5, Blocks.fence, Blocks.fence, false);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 3, 7, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 3, 7, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 2, 7, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 4, 7, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 3, 7, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 1, 4, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 5, 4, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 3, 4, 6, structureBoundingBox);
            this.func_151554_b(world, Blocks.cobblestone, 0, 2, 1, 0, structureBoundingBox);
            this.func_151554_b(world, Blocks.cobblestone, 0, 3, 1, 0, structureBoundingBox);
            this.func_151554_b(world, Blocks.cobblestone, 0, 4, 1, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][3], 3, 1, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][3], 3, 2, 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 2, 2, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 4, 2, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 2, 3, 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 4, 3, 1, structureBoundingBox);
            this.placeDoorAtCurrentPosition(world, structureBoundingBox, random, 3, 3, 2, this.getMetadataWithOffset(Blocks.wooden_door, 1));
            this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 2, 4, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 4, 4, 3, structureBoundingBox);
            this.spawnEntity(world, structureBoundingBox, 3, 4, 3, 0);
            return true;
        }
        
        @Override
        protected EntityLiving getNewEntity(final World world, final int choice) {
            return (EntityLiving)new EntityTibetan(world, EnumVillager.TIBETAN_MASTER);
        }
    }
    
    public static class Field extends GlobalField
    {
        public Field() {
        }
        
        public Field(final StructureVillagePieces.Start startPiece, final int componentType, final Random random, final StructureBoundingBox structureBoundingBox, final int coordBaseMode) {
            super(EnumVillagePiece.TIBETAN_FIELD, startPiece, componentType, random, structureBoundingBox, coordBaseMode);
            this.setOffset(0);
        }
        
        public static Field buildComponent(final StructureVillagePieces.Start villagePiece, final List pieces, final Random random, final int x, final int y, final int z, final int coordBaseMode, final int p5) {
            final StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(x, y, z, 0, 0, 0, 13, 2, 9, coordBaseMode);
            return (canVillageGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(pieces, structureboundingbox) == null) ? new Field(villagePiece, p5, random, structureboundingbox, coordBaseMode) : null;
        }
        
        @Override
        protected Block getCropType(final Random random) {
            return random.nextBoolean() ? Blocks.pumpkin_stem : Blocks.wheat;
        }
        
        @Override
        public boolean build(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
            for (int x = 0; x < 13; ++x) {
                for (int z = 0; z < 9; ++z) {
                    this.clearCurrentPositionBlocksUpwards(world, x, 0, z, structureBoundingBox);
                    this.func_151554_b(world, Blocks.cobblestone, 0, x, -1, z, structureBoundingBox);
                }
            }
            this.fillWithBlocks(world, structureBoundingBox, 0, 1, 0, 12, 4, 8, Blocks.air, Blocks.air, false);
            this.fillWithBlocks(world, structureBoundingBox, 1, 0, 1, 2, 0, 7, Blocks.farmland, Blocks.farmland, false);
            this.fillWithBlocks(world, structureBoundingBox, 4, 0, 1, 5, 0, 7, Blocks.farmland, Blocks.farmland, false);
            this.fillWithBlocks(world, structureBoundingBox, 7, 0, 1, 8, 0, 7, Blocks.farmland, Blocks.farmland, false);
            this.fillWithBlocks(world, structureBoundingBox, 10, 0, 1, 11, 0, 7, Blocks.farmland, Blocks.farmland, false);
            this.fillWithBlocks(world, structureBoundingBox, 0, 0, 0, 0, 0, 8, Blocks.cobblestone, Blocks.cobblestone, false);
            this.fillWithBlocks(world, structureBoundingBox, 6, 0, 0, 6, 0, 8, Blocks.cobblestone, Blocks.cobblestone, false);
            this.fillWithBlocks(world, structureBoundingBox, 12, 0, 0, 12, 0, 8, Blocks.cobblestone, Blocks.cobblestone, false);
            this.fillWithBlocks(world, structureBoundingBox, 1, 0, 0, 11, 0, 0, Blocks.cobblestone, Blocks.cobblestone, false);
            this.fillWithBlocks(world, structureBoundingBox, 1, 0, 8, 11, 0, 8, Blocks.cobblestone, Blocks.cobblestone, false);
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
            this.spawnEntity(world, structureBoundingBox, 4, 2, 4, 0);
            return true;
        }
        
        @Override
        protected EntityLiving getNewEntity(final World world, final int choice) {
            return (EntityLiving)new EntityTibetan(world, EnumVillager.TIBETAN_MONK);
        }
    }
    
    public static class House1 extends GlobalVillage
    {
        private int darkOakStair0;
        private int darkOakStair1;
        private int darkOakStair2;
        private int darkOakStair3;
        
        public House1() {
        }
        
        public House1(final StructureVillagePieces.Start villagePiece, final int componentType, final Random random, final StructureBoundingBox structureBoundingBox, final int coordBaseMode) {
            super(EnumVillagePiece.TIBETAN_HOUSE1, villagePiece, componentType, structureBoundingBox, coordBaseMode);
            this.setOffset(8);
            this.darkOakStair0 = ((coordBaseMode == 0) ? 0 : ((coordBaseMode == 1) ? 2 : ((coordBaseMode == 2) ? 0 : 2)));
            this.darkOakStair1 = ((coordBaseMode == 0) ? 1 : ((coordBaseMode == 1) ? 3 : ((coordBaseMode == 2) ? 1 : 3)));
            this.darkOakStair2 = ((coordBaseMode == 0) ? 3 : ((coordBaseMode == 1) ? 0 : ((coordBaseMode == 2) ? 2 : 1)));
            this.darkOakStair3 = ((coordBaseMode == 0) ? 2 : ((coordBaseMode == 1) ? 1 : ((coordBaseMode == 2) ? 3 : 0)));
        }
        
        public static House1 buildComponent(final StructureVillagePieces.Start villagePiece, final List pieces, final Random random, final int x, final int y, final int z, final int coordBaseMode, final int p5) {
            final StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(x, y, z, 0, 0, 0, 11, 10, 10, coordBaseMode);
            return (canVillageGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(pieces, structureboundingbox) == null) ? new House1(villagePiece, p5, random, structureboundingbox, coordBaseMode) : null;
        }
        
        @Override
        public boolean build(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
            for (int x = 0; x < 11; ++x) {
                for (int z = 1; z < 10; ++z) {
                    this.func_151554_b(world, Blocks.cobblestone, 0, x, 2, z, structureBoundingBox);
                    this.clearCurrentPositionBlocksUpwards(world, x, 3, z, structureBoundingBox);
                }
            }
            this.fillWithBlocks(world, structureBoundingBox, 1, 2, 2, 9, 2, 8, Blocks.planks, Blocks.planks, false);
            this.placeBlockAtCurrentPosition(world, Blocks.cobblestone, 0, 5, 2, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.cobblestone, 0, 5, 2, 8, structureBoundingBox);
            this.fillWithBlocks(world, structureBoundingBox, 1, 3, 3, 9, 5, 7, Blocks.wool, Blocks.wool, false);
            this.fillWithBlocks(world, structureBoundingBox, 2, 3, 4, 8, 5, 6, Blocks.air, Blocks.air, false);
            this.fillWithBlocks(world, structureBoundingBox, 5, 3, 4, 5, 5, 6, Blocks.wool, Blocks.wool, false);
            this.fillWithBlocks(world, structureBoundingBox, 2, 6, 4, 8, 8, 6, Blocks.wool, Blocks.wool, false);
            for (int y = 0; y <= 2; ++y) {
                this.placeBlockAtCurrentPosition(world, Blocks.log, 1, 5, y + 3, 5, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.log, 1, 1, y + 3, 3, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.log, 1, 3, y + 3, 3, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.log, 1, 5, y + 3, 3, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.log, 1, 7, y + 3, 3, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.log, 1, 9, y + 3, 3, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.log, 1, 1, y + 3, 7, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.log, 1, 3, y + 3, 7, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.log, 1, 5, y + 3, 7, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.log, 1, 7, y + 3, 7, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.log, 1, 9, y + 3, 7, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.log, 1, 1, y + 3, 5, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.log, 1, 9, y + 3, 5, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.log, 1, 3, y + 6, 4, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.log, 1, 5, y + 6, 4, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.log, 1, 7, y + 6, 4, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.log, 1, 3, y + 6, 6, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.log, 1, 5, y + 6, 6, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.log, 1, 7, y + 6, 6, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.log, 1, 2, y + 6, 5, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.log, 1, 8, y + 6, 5, structureBoundingBox);
            }
            for (int x = 2; x < 9; ++x) {
                for (int z = 4; z < 7; ++z) {
                    if (x != 5) {
                        this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 10, x, 5, z, structureBoundingBox);
                    }
                }
            }
            for (int x = 0; x < 11; ++x) {
                for (int z = 1; z < 10; ++z) {
                    if ((x == 0 || x == 10) && (z == 1 || z == 9)) {
                        this.placeBlockAtCurrentPosition(world, (Block)Blocks.wooden_slab, 13, x, 6, z, structureBoundingBox);
                    }
                    else if (x + z <= 3 || x + 10 - z <= 3 || 10 - x + z <= 3 || 10 - x + 10 - z <= 3) {
                        this.placeBlockAtCurrentPosition(world, (Block)Blocks.wooden_slab, 5, x, 6, z, structureBoundingBox);
                    }
                    else if ((z == 2 || z == 8) && x >= 4 && x <= 6) {
                        this.placeBlockAtCurrentPosition(world, (Block)Blocks.wooden_slab, 5, x, 6, z, structureBoundingBox);
                    }
                    else if (x < 1 || x > 9 || z < 3 || z > 7) {
                        this.placeBlockAtCurrentPosition(world, (Block)Blocks.wooden_slab, 13, x, 5, z, structureBoundingBox);
                    }
                }
            }
            this.placeBlockAtCurrentPosition(world, (Block)Blocks.wooden_slab, 5, 1, 6, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, (Block)Blocks.wooden_slab, 5, 9, 6, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, (Block)Blocks.wooden_slab, 5, 1, 6, 7, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, (Block)Blocks.wooden_slab, 5, 9, 6, 7, structureBoundingBox);
            for (int x = 1; x < 10; ++x) {
                for (int z = 2; z < 9; ++z) {
                    if ((x == 1 || x == 9) && (z == 2 || z == 8)) {
                        this.placeBlockAtCurrentPosition(world, (Block)Blocks.wooden_slab, 13, x, 9, z, structureBoundingBox);
                    }
                    else if (x + z <= 4 || x + 10 - z <= 4 || 10 - x + z <= 4 || 10 - x + 10 - z <= 4) {
                        this.placeBlockAtCurrentPosition(world, (Block)Blocks.wooden_slab, 5, x, 9, z, structureBoundingBox);
                    }
                    else if (x + z <= 5 || x + 10 - z <= 5 || 10 - x + z <= 5 || 10 - x + 10 - z <= 5) {
                        this.placeBlockAtCurrentPosition(world, (Block)Blocks.wooden_slab, 13, x, 8, z, structureBoundingBox);
                    }
                    else if ((x < 2 || x > 8) && z == 5) {
                        this.placeBlockAtCurrentPosition(world, (Block)Blocks.wooden_slab, 13, x, 8, z, structureBoundingBox);
                    }
                    else if (z < 3 || z > 7) {
                        this.placeBlockAtCurrentPosition(world, (Block)Blocks.wooden_slab, 5, x, 8, z, structureBoundingBox);
                    }
                    else if ((x == 3 || x == 7) && (z == 3 || z == 7)) {
                        this.placeBlockAtCurrentPosition(world, (Block)Blocks.wooden_slab, 13, x, 8, z, structureBoundingBox);
                    }
                    else if ((x == 2 || x == 8) && (z == 4 || z == 6)) {
                        this.placeBlockAtCurrentPosition(world, (Block)Blocks.wooden_slab, 5, x, 9, z, structureBoundingBox);
                    }
                }
            }
            this.placeBlockAtCurrentPosition(world, Blocks.planks, 5, 5, 6, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.planks, 5, 5, 6, 7, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.planks, 5, 3, 9, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.planks, 5, 4, 9, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.planks, 5, 5, 9, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.planks, 5, 6, 9, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.planks, 5, 7, 9, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair0, 4, 6, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair0, 1, 6, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair0, 1, 6, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair0, 1, 6, 6, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair0, 4, 6, 7, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair0, 2, 9, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair0, 3, 10, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair0, 6, 10, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair1, 6, 6, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair1, 9, 6, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair1, 9, 6, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair1, 9, 6, 6, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair1, 6, 6, 7, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair1, 8, 9, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair1, 7, 10, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair1, 4, 10, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair2, 2, 6, 7, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair2, 3, 6, 7, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair2, 5, 6, 8, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair2, 7, 6, 7, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair2, 8, 6, 7, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair2, 4, 8, 7, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair2, 5, 8, 7, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair2, 6, 8, 7, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair2, 3, 9, 6, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair2, 4, 9, 6, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair2, 5, 9, 6, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair2, 6, 9, 6, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair2, 7, 9, 6, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair3, 2, 6, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair3, 3, 6, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair3, 5, 6, 2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair3, 7, 6, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair3, 8, 6, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair3, 4, 8, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair3, 5, 8, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair3, 6, 8, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair3, 3, 9, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair3, 4, 9, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair3, 5, 9, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair3, 6, 9, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.dark_oak_stairs, this.darkOakStair3, 7, 9, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, (Block)Blocks.wooden_slab, 5, 5, 10, 5, structureBoundingBox);
            for (int k = 0; k < 3; ++k) {
                this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, k, 3, 1, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 0, 3, k + 1, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, k, 3, 9, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 0, 3, 9 - k, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 10 - k, 3, 1, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 10, 3, k + 1, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 10 - k, 3, 9, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 10, 3, 9 - k, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 5 - k, 3, 9, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 5 + k, 3, 9, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 2, 3 + k, 1, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 5, 3 + k, 2, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 8, 3 + k, 1, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 2, 6 + k, 2, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 8, 6 + k, 2, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 2, 3 + k, 9, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 5, 3 + k, 8, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 8, 3 + k, 9, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 2, 6 + k, 8, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 8, 6 + k, 8, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 0, 3 + k, 3, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 0, 3 + k, 7, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 10, 3 + k, 3, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 10, 3 + k, 7, structureBoundingBox);
            }
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 5, 3, 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 5, 7, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 5, 7, 7, structureBoundingBox);
            for (int k = 2; k < 9; ++k) {
                if (k == 2 || k == 8) {
                    this.func_151554_b(world, Blocks.cobblestone, 0, k, 2, 0, structureBoundingBox);
                }
                else {
                    this.func_151554_b(world, Blocks.cobblestone, 0, k, 0, 0, structureBoundingBox);
                    this.placeBlockAtCurrentPosition(world, Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][3], k, 1, 0, structureBoundingBox);
                    if (k != 5) {
                        this.placeBlockAtCurrentPosition(world, Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][3], k, 2, 1, structureBoundingBox);
                    }
                }
            }
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 1, 4, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 1, 4, 6, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 2, 4, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 4, 4, 7, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 6, 4, 7, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 8, 4, 3, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 9, 4, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 9, 4, 6, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 4, 7, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 4, 7, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 4, 7, 6, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 6, 7, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 6, 7, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 6, 7, 6, structureBoundingBox);
            this.placeDoorAtCurrentPosition(world, structureBoundingBox, random, 4, 3, 3, this.getMetadataWithOffset(Blocks.wooden_door, 1));
            this.placeDoorAtCurrentPosition(world, structureBoundingBox, random, 6, 3, 3, this.getMetadataWithOffset(Blocks.wooden_door, 0));
            this.placeDoorAtCurrentPosition(world, structureBoundingBox, random, 2, 3, 7, this.getMetadataWithOffset(Blocks.wooden_door, 3));
            this.placeDoorAtCurrentPosition(world, structureBoundingBox, random, 8, 3, 7, this.getMetadataWithOffset(Blocks.wooden_door, 2));
            this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 4, 4, 5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 6, 4, 5, structureBoundingBox);
            this.spawnEntity(world, structureBoundingBox, 3, 4, 5, 0);
            this.spawnEntity(world, structureBoundingBox, 3, 4, 5, 0);
            this.spawnEntity(world, structureBoundingBox, 3, 4, 5, 0);
            return true;
        }
        
        @Override
        protected EntityLiving getNewEntity(final World world, final int choice) {
            return (EntityLiving)new EntityTibetan(world, EnumVillager.TIBETAN_MONK);
        }
    }
}
