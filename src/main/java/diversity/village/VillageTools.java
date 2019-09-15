// 
// Decompiled by Procyon v0.5.36
// 

package diversity.village;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import diversity.suppliers.IEnumPiece;
import diversity.suppliers.EnumVillageBasicPiece;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.init.Blocks;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import net.minecraft.world.World;
import net.minecraft.block.Block;
import net.minecraft.world.gen.structure.MapGenVillage;
import net.minecraft.world.gen.structure.StructureVillagePieces;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import java.util.List;
import net.minecraft.world.biome.WorldChunkManager;
import java.util.Iterator;
import diversity.suppliers.EnumVillagePiece;
import java.util.Random;
import java.util.ArrayList;
import diversity.suppliers.EnumVillage;

public abstract class VillageTools
{
    public final EnumVillage village;
    
    VillageTools(final EnumVillage village) {
        this.village = village;
    }
    
    private void getStructureList(final ArrayList arraylist, final Random rand) {
        for (final EnumVillagePiece piece : this.village.pieces) {
            arraylist.add(piece.getVillagePieceWeight(rand, 1));
        }
    }
    
    public abstract GlobalStart getStart(final WorldChunkManager p0, final int p1, final Random p2, final int p3, final int p4, final List p5, final int p6);
    
    protected abstract GlobalTorch getTorch(final GlobalStart p0, final int p1, final Random p2, final StructureBoundingBox p3, final int p4);
    
    protected abstract GlobalPath getPath(final GlobalStart p0, final int p1, final Random p2, final StructureBoundingBox p3, final int p4);
    
    protected static Point getSpherePoint(final int radius, final int u, final int v, final double offset) {
        final double theta = 6.283185307179586 * u / 360.0;
        final double phi = 3.141592653589793 * v / 360.0;
        final int x = (int)(radius * Math.sin(phi) * Math.cos(theta));
        final int z = (int)(radius * Math.sin(phi) * Math.sin(theta));
        final int y = (int)(radius * Math.cos(phi) + offset);
        return new Point(x, y, z);
    }
    
    public static StructureComponent getNextComponentVillagePath(final VillageTools villageInstance, final GlobalStart startPiece, final List componentList, final Random random, final int x, final int y, final int z, final int coordBaseMode, final int componentType) {
        if (componentType > 3 + startPiece.terrainType) {
            return null;
        }
        if (Math.abs(x - startPiece.getBoundingBox().minX) <= 112 && Math.abs(z - startPiece.getBoundingBox().minZ) <= 112) {
            final StructureBoundingBox structureboundingbox = GlobalPath.func_74933_a(startPiece, componentList, random, x, y, z, coordBaseMode);
            if (structureboundingbox != null && structureboundingbox.minY > 10) {
                final GlobalPath path = villageInstance.getPath(startPiece, componentType, random, structureboundingbox, coordBaseMode);
                final int j1 = (path.getBoundingBox().minX + path.getBoundingBox().maxX) / 2;
                final int k1 = (path.getBoundingBox().minZ + path.getBoundingBox().maxZ) / 2;
                final int l1 = path.getBoundingBox().maxX - path.getBoundingBox().minX;
                final int i2 = path.getBoundingBox().maxZ - path.getBoundingBox().minZ;
                final int j2 = (l1 > i2) ? l1 : i2;
                if (startPiece.getWorldChunkManager().areBiomesViable(j1, k1, j2 / 2 + 4, MapGenVillage.villageSpawnBiomes)) {
                    componentList.add(path);
                    startPiece.field_74930_j.add(path);
                    return path;
                }
            }
            return null;
        }
        return null;
    }
    
    private static StructureComponent getNextVillageStructureComponent(final VillageTools village, final GlobalStart startPiece, final List componentList, final Random random, final int p_75077_3_, final int p_75077_4_, final int p_75077_5_, final int p_75077_6_, final int p_75077_7_) {
        if (p_75077_7_ > 50) {
            return null;
        }
        if (Math.abs(p_75077_3_ - startPiece.getBoundingBox().minX) > 112 || Math.abs(p_75077_5_ - startPiece.getBoundingBox().minZ) > 112) {
            return null;
        }
        final GlobalVillage piece = getNextVillageComponent(village, startPiece, componentList, random, p_75077_3_, p_75077_4_, p_75077_5_, p_75077_6_, p_75077_7_ + 1);
        if (piece != null) {
            componentList.add(piece);
            startPiece.field_74932_i.add(piece);
            return piece;
        }
        return null;
    }
    
    public List getStructureVillageWeightedPieceList(final Random rand) {
        final ArrayList arraylist = new ArrayList();
        this.getStructureList(arraylist, rand);
        final Iterator iterator = arraylist.iterator();
        while (iterator.hasNext()) {
            if (((StructureVillagePieces.PieceWeight)iterator.next()).villagePiecesLimit == 0) {
                iterator.remove();
            }
        }
        return arraylist;
    }
    
    private static GlobalVillage getNextVillageComponent(final VillageTools village, final GlobalStart startPiece, final List p_75081_1_, final Random random, final int p_75081_3_, final int p_75081_4_, final int p_75081_5_, final int coordBaseMode, final int p_75081_7_) {
        final int villagePieceWeight = getVillagePieceWeight(startPiece.structureVillageWeightedPieceList);
        if (villagePieceWeight <= 0) {
            return null;
        }
        int k1 = 0;
        while (k1 < 5) {
            ++k1;
            int l1 = random.nextInt(villagePieceWeight);
            for (final Object pieceweight : startPiece.structureVillageWeightedPieceList) {
                l1 -= ((StructureVillagePieces.PieceWeight)pieceweight).villagePieceWeight;
                if (l1 < 0) {
                    if (!((StructureVillagePieces.PieceWeight)pieceweight).canSpawnMoreVillagePiecesOfType(p_75081_7_)) {
                        break;
                    }
                    if (pieceweight == startPiece.structVillagePieceWeight && startPiece.structureVillageWeightedPieceList.size() > 1) {
                        break;
                    }
                    final GlobalVillage piece = getVillageComponent(startPiece, ((StructureVillagePieces.PieceWeight)pieceweight), p_75081_1_, random, p_75081_3_, p_75081_4_, p_75081_5_, coordBaseMode, p_75081_7_);
                    if (piece != null) {
                        final StructureVillagePieces.PieceWeight pieceWeight = ((StructureVillagePieces.PieceWeight)pieceweight);
                        ++pieceWeight.villagePiecesSpawned;
                        startPiece.structVillagePieceWeight = ((StructureVillagePieces.PieceWeight)pieceweight);
                        if (!((StructureVillagePieces.PieceWeight)pieceweight).canSpawnMoreVillagePieces()) {
                            startPiece.structureVillageWeightedPieceList.remove(pieceweight);
                        }
                        return piece;
                    }
                    continue;
                }
            }
        }
        final StructureBoundingBox structureboundingbox = GlobalTorch.getStructureBoundingBox(startPiece, p_75081_1_, random, p_75081_3_, p_75081_4_, p_75081_5_, coordBaseMode);
        if (structureboundingbox != null) {
            return village.getTorch(startPiece, p_75081_7_, random, structureboundingbox, coordBaseMode);
        }
        return null;
    }
    
    private static int getVillagePieceWeight(final List pieceList) {
        boolean flag = false;
        int i = 0;
        for (final Object pieceweight : pieceList) {
            if (((StructureVillagePieces.PieceWeight)pieceweight).villagePiecesLimit > 0 && ((StructureVillagePieces.PieceWeight)pieceweight).villagePiecesSpawned < ((StructureVillagePieces.PieceWeight)pieceweight).villagePiecesLimit) {
                flag = true;
            }
            i += ((StructureVillagePieces.PieceWeight)pieceweight).villagePieceWeight;
        }
        return flag ? i : -1;
    }
    
    private static GlobalVillage getVillageComponent(final StructureVillagePieces.Start startPiece, final StructureVillagePieces.PieceWeight pieceWeight, final List p_75083_2_, final Random p_75083_3_, final int p_75083_4_, final int p_75083_5_, final int p_75083_6_, final int p_75083_7_, final int p_75083_8_) {
        return EnumVillagePiece.getVillageComponent(pieceWeight, startPiece, p_75083_2_, p_75083_3_, p_75083_4_, p_75083_5_, p_75083_6_, p_75083_7_, p_75083_8_);
    }
    
    public static class BlockData
    {
        protected Block block;
        protected int metaData;
        
        public BlockData(final Block block, final int metaData) {
            this.block = block;
            this.metaData = metaData;
        }
    }
    
    public abstract static class GlobalStart extends StructureVillagePieces.Start
    {
        private VillageTools village;
        
        public GlobalStart() {
        }
        
        public GlobalStart(final VillageTools village, final WorldChunkManager p_i2104_1_, final int p_i2104_2_, final Random p_i2104_3_, final int p_i2104_4_, final int p_i2104_5_, final List p_i2104_6_, final int p_i2104_7_) {
            super(p_i2104_1_, p_i2104_2_, p_i2104_3_, p_i2104_4_, p_i2104_5_, p_i2104_6_, p_i2104_7_);
            this.village = village;
        }
        
        @Override
        public void buildComponent(final StructureComponent startPiece, final List componentList, final Random random) {
            VillageTools.getNextComponentVillagePath(this.village, (GlobalStart)startPiece, componentList, random, this.boundingBox.minX - 1, this.boundingBox.maxY - 4, this.boundingBox.minZ + 1, 1, this.getComponentType());
            VillageTools.getNextComponentVillagePath(this.village, (GlobalStart)startPiece, componentList, random, this.boundingBox.maxX + 1, this.boundingBox.maxY - 4, this.boundingBox.minZ + 1, 3, this.getComponentType());
            VillageTools.getNextComponentVillagePath(this.village, (GlobalStart)startPiece, componentList, random, this.boundingBox.minX + 1, this.boundingBox.maxY - 4, this.boundingBox.minZ - 1, 2, this.getComponentType());
            VillageTools.getNextComponentVillagePath(this.village, (GlobalStart)startPiece, componentList, random, this.boundingBox.minX + 1, this.boundingBox.maxY - 4, this.boundingBox.maxZ + 1, 0, this.getComponentType());
        }
        
        public boolean addComponentParts(final World world, final Random random, final StructureBoundingBox structureBoundingBox, final int offset) {
            if (this.field_143015_k < 0) {
                this.field_143015_k = this.getAverageGroundLevel(world, structureBoundingBox);
                if (this.field_143015_k < 0) {
                    return true;
                }
                this.boundingBox.offset(0, this.field_143015_k - this.boundingBox.maxY + offset, 0);
            }
            return false;
        }
    }
    
    public abstract static class GlobalPath extends StructureVillagePieces.Path
    {
        private int averageGroundLevel;
        private StructureVillagePieces.Start startPiece;
        private VillageTools village;
        Table<Integer, Integer, Integer> points;
        private int recursiveCounter;
        
        public GlobalPath() {
            this.points = HashBasedTable.create();
        }
        
        public GlobalPath(final VillageTools village, final GlobalStart startPiece, final int p_i2105_2_, final Random random, final StructureBoundingBox structureBoundingBox, final int coordBaseMode) {
            super(startPiece, p_i2105_2_, random, structureBoundingBox, coordBaseMode);
            this.points = HashBasedTable.create();
            this.startPiece = startPiece;
            this.averageGroundLevel = Math.max(structureBoundingBox.getXSize(), structureBoundingBox.getZSize());
            this.village = village;
        }
        
        @Override
        public boolean addComponentParts(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
            for (int x = this.boundingBox.minX; x <= this.boundingBox.maxX; ++x) {
                for (int z = this.boundingBox.minZ; z <= this.boundingBox.maxZ; ++z) {
                    if (structureBoundingBox.isVecInside(x, 64, z)) {
                        final int y = world.getTopSolidOrLiquidBlock(x, z) - 1;
                        this.points.put(x, z, y);
                        final BlockData blockData = this.getPathBlock(random);
                        world.setBlock(x, y, z, blockData.block, blockData.metaData, 2);
                    }
                }
            }
            return true;
        }
        
        private void buildBridge(final World world, final Random random, final StructureBoundingBox structureBoundingBox, final Point point, final int counter, final int bridgeSize) {
            this.clearCurrentPositionBlocksUpwards(world, point.x, 65, point.z, structureBoundingBox);
            this.clearCurrentPositionBlocksUpwards(world, point.leftPoint.x, 65, point.leftPoint.z, structureBoundingBox);
            this.clearCurrentPositionBlocksUpwards(world, point.rightPoint.x, 65, point.rightPoint.z, structureBoundingBox);
            if (counter == 0 || counter == bridgeSize) {
                world.setBlock(point.leftPoint.x, 65, point.leftPoint.z, Blocks.cobblestone, 0, 2);
                world.setBlock(point.rightPoint.x, 65, point.rightPoint.z, Blocks.cobblestone, 0, 2);
                world.setBlock(point.x, 65, point.z, Blocks.wooden_slab, 0, 2);
            }
            else if ((counter == 2 || counter == bridgeSize - 1) && bridgeSize - 1 > 2) {
                world.setBlock(point.leftPoint.x, 65, point.leftPoint.z, Blocks.cobblestone, 0, 2);
                world.setBlock(point.rightPoint.x, 65, point.rightPoint.z, Blocks.cobblestone, 0, 2);
                world.setBlock(point.leftPoint.x, 66, point.leftPoint.z, Blocks.stone_slab, 3, 2);
                world.setBlock(point.rightPoint.x, 66, point.rightPoint.z, Blocks.stone_slab, 3, 2);
                world.setBlock(point.x, 65, point.z, Blocks.planks, 0, 2);
            }
            else if ((counter == 3 || counter == bridgeSize - 2) && bridgeSize - 2 > 3) {
                world.setBlock(point.leftPoint.x, 66, point.leftPoint.z, Blocks.cobblestone, 0, 2);
                world.setBlock(point.rightPoint.x, 66, point.rightPoint.z, Blocks.cobblestone, 0, 2);
                world.setBlock(point.x, 66, point.z, Blocks.wooden_slab, 0, 2);
            }
            else {
                world.setBlock(point.leftPoint.x, 66, point.leftPoint.z, Blocks.cobblestone, 0, 2);
                world.setBlock(point.rightPoint.x, 66, point.rightPoint.z, Blocks.cobblestone, 0, 2);
                world.setBlock(point.leftPoint.x, 67, point.leftPoint.z, Blocks.stone_slab, 3, 2);
                world.setBlock(point.rightPoint.x, 67, point.rightPoint.z, Blocks.stone_slab, 3, 2);
                world.setBlock(point.x, 66, point.z, Blocks.wooden_slab, 0, 2);
            }
        }
        
        private void placePoint(final World world, final Random random, final StructureBoundingBox structureBoundingBox, final Point point) {
            if (point.y > 63) {
                BlockData blockData = this.getUnderPathBlock(random);
                this.func_151554_b(world, blockData.block, blockData.metaData, point.x, point.y - 1, point.z, structureBoundingBox);
                blockData = this.getPathBlock(random);
                world.setBlock(point.x, point.y, point.z, blockData.block, blockData.metaData, 2);
                this.clearCurrentPositionBlocksUpwards(world, point.x, point.y + 1, point.z, structureBoundingBox);
            }
            else {
                point.submarine = true;
            }
        }
        
        private void evaluatePointHeight(final Point point) {
            int maxHeight = point.parentPoint.y + 1;
            int minHeight = point.parentPoint.y - 1;
            if (point.leftPoint != null) {
                if (point.leftPoint.y <= minHeight) {
                    maxHeight = point.parentPoint.y;
                }
                else if (point.leftPoint.y >= maxHeight) {
                    minHeight = point.parentPoint.y;
                }
            }
            if (point.rightPoint != null) {
                if (point.rightPoint.y <= minHeight) {
                    maxHeight = point.parentPoint.y;
                }
                else if (point.rightPoint.y >= maxHeight) {
                    minHeight = point.parentPoint.y;
                }
            }
            int totalMaxHeigh = (point.y == maxHeight ? 1 : 0) + (point.leftPoint != null ? (point.leftPoint.y == maxHeight ? 1 : 0) : 0) + (point.rightPoint != null ? (point.rightPoint.y == maxHeight ? 1 : 0) : 0);
            int totalMinHeight = (point.y == minHeight ? 1 : 0) + (point.leftPoint != null ? (point.leftPoint.y == minHeight ? 1 : 0) : 0) + (point.rightPoint != null ? (point.rightPoint.y == minHeight ? 1 : 0) : 0);
            if (totalMaxHeigh >= 2) {
                point.y = maxHeight;
            }
            else if (totalMinHeight >= 2) {
                point.y = minHeight;
            }
            else {
                point.y = point.parentPoint.y;
            }
        }
        
        protected abstract BlockData getPathBridge(final Random p0);
        
        protected abstract BlockData getPathBlock(final Random p0);
        
        protected abstract BlockData getUnderPathBlock(final Random p0);
        
        @Override
        protected void func_143012_a(final NBTTagCompound p_143012_1_) {
            super.func_143012_a(p_143012_1_);
            p_143012_1_.setInteger("Length", this.averageGroundLevel);
        }
        
        @Override
        protected void func_143011_b(final NBTTagCompound p_143011_1_) {
            super.func_143011_b(p_143011_1_);
            this.averageGroundLevel = p_143011_1_.getInteger("Length");
        }
        
        @Override
        public void buildComponent(final StructureComponent startPiece, final List componentList, final Random random) {
            boolean flag = false;
            for (int i = random.nextInt(5); i < this.averageGroundLevel - 8; i += 2 + random.nextInt(5)) {
                final StructureComponent piece = this.getNextComponentNN((GlobalStart)startPiece, componentList, random, 0, i);
                if (piece != null) {
                    i += Math.max(piece.getBoundingBox().getXSize(), piece.getBoundingBox().getZSize());
                    flag = true;
                }
            }
            for (int i = random.nextInt(5); i < this.averageGroundLevel - 8; i += 2 + random.nextInt(5)) {
                final StructureComponent piece = this.getNextComponentPP((GlobalStart)startPiece, componentList, random, 0, i);
                if (piece != null) {
                    i += Math.max(piece.getBoundingBox().getXSize(), piece.getBoundingBox().getZSize());
                    flag = true;
                }
            }
            if (flag && random.nextInt(3) > 0) {
                switch (this.coordBaseMode) {
                    case 0: {
                        VillageTools.getNextComponentVillagePath(this.village, (GlobalStart)startPiece, componentList, random, this.boundingBox.minX - 1, this.boundingBox.minY, this.boundingBox.maxZ - 2, 1, this.getComponentType());
                        break;
                    }
                    case 1: {
                        VillageTools.getNextComponentVillagePath(this.village, (GlobalStart)startPiece, componentList, random, this.boundingBox.minX, this.boundingBox.minY, this.boundingBox.minZ - 1, 2, this.getComponentType());
                        break;
                    }
                    case 2: {
                        VillageTools.getNextComponentVillagePath(this.village, (GlobalStart)startPiece, componentList, random, this.boundingBox.minX - 1, this.boundingBox.minY, this.boundingBox.minZ, 1, this.getComponentType());
                        break;
                    }
                    case 3: {
                        VillageTools.getNextComponentVillagePath(this.village, (GlobalStart)startPiece, componentList, random, this.boundingBox.maxX - 2, this.boundingBox.minY, this.boundingBox.minZ - 1, 2, this.getComponentType());
                        break;
                    }
                }
            }
            if (flag && random.nextInt(3) > 0) {
                switch (this.coordBaseMode) {
                    case 0: {
                        VillageTools.getNextComponentVillagePath(this.village, (GlobalStart)startPiece, componentList, random, this.boundingBox.maxX + 1, this.boundingBox.minY, this.boundingBox.maxZ - 2, 3, this.getComponentType());
                        break;
                    }
                    case 1: {
                        VillageTools.getNextComponentVillagePath(this.village, (GlobalStart)startPiece, componentList, random, this.boundingBox.minX, this.boundingBox.minY, this.boundingBox.maxZ + 1, 0, this.getComponentType());
                        break;
                    }
                    case 2: {
                        VillageTools.getNextComponentVillagePath(this.village, (GlobalStart)startPiece, componentList, random, this.boundingBox.maxX + 1, this.boundingBox.minY, this.boundingBox.minZ, 3, this.getComponentType());
                        break;
                    }
                    case 3: {
                        VillageTools.getNextComponentVillagePath(this.village, (GlobalStart)startPiece, componentList, random, this.boundingBox.maxX - 2, this.boundingBox.minY, this.boundingBox.maxZ + 1, 0, this.getComponentType());
                        break;
                    }
                }
            }
        }
        
        protected StructureComponent getNextComponentNN(final GlobalStart startPiece, final List componentList, final Random random, final int p_74891_4_, final int p_74891_5_) {
            switch (this.coordBaseMode) {
                case 0: {
                    return getNextVillageStructureComponent(this.village, startPiece, componentList, random, this.boundingBox.minX - 1, this.boundingBox.minY + p_74891_4_, this.boundingBox.minZ + p_74891_5_, 1, this.getComponentType());
                }
                case 1: {
                    return getNextVillageStructureComponent(this.village, startPiece, componentList, random, this.boundingBox.minX + p_74891_5_, this.boundingBox.minY + p_74891_4_, this.boundingBox.minZ - 1, 2, this.getComponentType());
                }
                case 2: {
                    return getNextVillageStructureComponent(this.village, startPiece, componentList, random, this.boundingBox.minX - 1, this.boundingBox.minY + p_74891_4_, this.boundingBox.minZ + p_74891_5_, 1, this.getComponentType());
                }
                case 3: {
                    return getNextVillageStructureComponent(this.village, startPiece, componentList, random, this.boundingBox.minX + p_74891_5_, this.boundingBox.minY + p_74891_4_, this.boundingBox.minZ - 1, 2, this.getComponentType());
                }
                default: {
                    return null;
                }
            }
        }
        
        protected StructureComponent getNextComponentPP(final GlobalStart startPiece, final List componentList, final Random random, final int p_74894_4_, final int p_74894_5_) {
            switch (this.coordBaseMode) {
                case 0: {
                    return getNextVillageStructureComponent(this.village, startPiece, componentList, random, this.boundingBox.maxX + 1, this.boundingBox.minY + p_74894_4_, this.boundingBox.minZ + p_74894_5_, 3, this.getComponentType());
                }
                case 1: {
                    return getNextVillageStructureComponent(this.village, startPiece, componentList, random, this.boundingBox.minX + p_74894_5_, this.boundingBox.minY + p_74894_4_, this.boundingBox.maxZ + 1, 0, this.getComponentType());
                }
                case 2: {
                    return getNextVillageStructureComponent(this.village, startPiece, componentList, random, this.boundingBox.maxX + 1, this.boundingBox.minY + p_74894_4_, this.boundingBox.minZ + p_74894_5_, 3, this.getComponentType());
                }
                case 3: {
                    return getNextVillageStructureComponent(this.village, startPiece, componentList, random, this.boundingBox.minX + p_74894_5_, this.boundingBox.minY + p_74894_4_, this.boundingBox.maxZ + 1, 0, this.getComponentType());
                }
                default: {
                    return null;
                }
            }
        }
    }
    
    public abstract static class GlobalTorch extends GlobalVillage
    {
        public GlobalTorch() {
        }
        
        public GlobalTorch(final EnumVillageBasicPiece enumPiece, final StructureVillagePieces.Start startPiece, final int componentType, final Random random, final StructureBoundingBox structureBoundingBox, final int coordBaseMode) {
            super(enumPiece, startPiece, componentType, structureBoundingBox, coordBaseMode);
        }
        
        public static StructureBoundingBox getStructureBoundingBox(final StructureVillagePieces.Start startPiece, final List list, final Random random, final int coordX, final int coordY, final int coordZ, final int p_74904_6_) {
            final StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(coordX, coordY, coordZ, 0, 0, 0, 3, 4, 2, p_74904_6_);
            return (StructureComponent.findIntersecting(list, structureboundingbox) != null) ? null : structureboundingbox;
        }
        
        @Override
        protected EntityLiving getNewEntity(final World world, final int choice) {
            return null;
        }
    }
    
    public abstract static class GlobalVillage extends StructureVillagePieces.Village
    {
        private int villagersSpawned;
        protected IEnumPiece piece;
        private int offset;
        
        public GlobalVillage() {
        }
        
        protected GlobalVillage(final IEnumPiece piece, final StructureVillagePieces.Start startPiece, final int componentType, final StructureBoundingBox structureBoundingBox, final int coordBaseMode) {
            super(startPiece, componentType);
            this.coordBaseMode = coordBaseMode;
            this.boundingBox = structureBoundingBox;
            this.piece = piece;
        }
        
        @Override
        protected void func_143012_a(final NBTTagCompound tagCompound) {
            super.func_143012_a(tagCompound);
            tagCompound.setInteger("VCount", this.villagersSpawned);
        }
        
        @Override
        protected void func_143011_b(final NBTTagCompound tagCompound) {
            super.func_143011_b(tagCompound);
            this.villagersSpawned = tagCompound.getInteger("VCount");
        }
        
        protected void setOffset(final int offset) {
            this.offset = offset;
        }
        
        protected void spawnEntity(final World world, final StructureBoundingBox structureBoundingBox, final int spawnX, final int spawnY, final int spawnZ, final int choice) {
            final int x = this.getXWithOffset(spawnX, spawnZ);
            final int y = this.getYWithOffset(spawnY);
            final int z = this.getZWithOffset(spawnX, spawnZ);
            if (!structureBoundingBox.isVecInside(x, y, z)) {
                return;
            }
            final EntityLiving entity = this.getNewEntity(world, choice);
            entity.setLocationAndAngles(x + 0.5, y, z + 0.5, 0.0f, 0.0f);
            world.spawnEntityInWorld(entity);
        }
        
        @Override
        public boolean addComponentParts(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
            if (this.field_143015_k < 0) {
                this.field_143015_k = this.getAverageGroundLevel(world, structureBoundingBox);
                if (this.field_143015_k < 0) {
                    return true;
                }
                this.boundingBox.offset(0, this.field_143015_k - this.boundingBox.maxY + this.offset, 0);
            }
            this.build(world, random, structureBoundingBox);
            return true;
        }
        
        protected void placeBlockAtCurrentPosition(final World p_151550_1_, final BlockData blockData, final int p_151550_4_, final int p_151550_5_, final int p_151550_6_, final StructureBoundingBox p_151550_7_) {
            this.placeBlockAtCurrentPosition(p_151550_1_, blockData.block, blockData.metaData, p_151550_4_, p_151550_5_, p_151550_6_, p_151550_7_);
        }
        
        protected abstract boolean build(final World p0, final Random p1, final StructureBoundingBox p2);
        
        protected abstract EntityLiving getNewEntity(final World p0, final int p1);
    }
    
    protected static class Point
    {
        public boolean submarine;
        private Point leftPoint;
        private Point rightPoint;
        private Point parentPoint;
        int x;
        int y;
        int z;
        
        Point(final int x, final int y, final int z) {
            this.submarine = false;
            this.x = x;
            this.y = y;
            this.z = z;
        }
        
        Point(final int x, final int z) {
            this.submarine = false;
            this.x = x;
            this.z = z;
        }
        
        Point(final int x, final int z, final Point parentPoint) {
            this.submarine = false;
            this.x = x;
            this.z = z;
            this.parentPoint = parentPoint;
        }
        
        int getPointDiff(final Point point) {
            return point.y - this.y;
        }
        
        int getPointDiff(final int y) {
            return y - this.y;
        }
        
        boolean equals(final Point point) {
            return this.x == point.x && this.z == point.z;
        }
        
        public void set(final int x, final int z) {
            this.x = x;
            this.z = z;
        }
    }
    
    public abstract static class GlobalField extends GlobalVillage
    {
        protected Block cropTypeA;
        protected Block cropTypeB;
        protected Block cropTypeC;
        protected Block cropTypeD;
        
        public GlobalField() {
        }
        
        public GlobalField(final EnumVillagePiece enumPiece, final StructureVillagePieces.Start startPiece, final int componentType, final Random random, final StructureBoundingBox structureBoundingBox, final int coordBaseMode) {
            super(enumPiece, startPiece, componentType, structureBoundingBox, coordBaseMode);
            this.cropTypeA = this.getCropType(random);
            this.cropTypeB = this.getCropType(random);
            this.cropTypeC = this.getCropType(random);
            this.cropTypeD = this.getCropType(random);
        }
        
        @Override
        protected void func_143012_a(final NBTTagCompound p_143012_1_) {
            super.func_143012_a(p_143012_1_);
            p_143012_1_.setInteger("CA", Block.blockRegistry.getIDForObject(this.cropTypeA));
            p_143012_1_.setInteger("CB", Block.blockRegistry.getIDForObject(this.cropTypeB));
            p_143012_1_.setInteger("CC", Block.blockRegistry.getIDForObject(this.cropTypeC));
            p_143012_1_.setInteger("CD", Block.blockRegistry.getIDForObject(this.cropTypeD));
        }
        
        @Override
        protected void func_143011_b(final NBTTagCompound p_143011_1_) {
            super.func_143011_b(p_143011_1_);
            this.cropTypeA = Block.getBlockById(p_143011_1_.getInteger("CA"));
            this.cropTypeB = Block.getBlockById(p_143011_1_.getInteger("CB"));
            this.cropTypeC = Block.getBlockById(p_143011_1_.getInteger("CC"));
            this.cropTypeD = Block.getBlockById(p_143011_1_.getInteger("CD"));
        }
        
        protected abstract Block getCropType(final Random p0);
    }
}
