// 
// Decompiled by Procyon v0.5.36
// 

package diversity.structure;

import diversity.entity.EntityDwarf;
import diversity.suppliers.EnumVillager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import java.util.Random;

public class DwarvenCity extends GlobalFeature
{
    public DwarvenCity() {
    }
    
    public DwarvenCity(final Random random, final int coordX, final int coordZ) {
        super(random, coordX, coordZ, 39, 19, 17);
        switch (this.coordBaseMode) {
            case 0:
            case 2: {
                this.boundingBox = new StructureBoundingBox(coordX - 8, 30, coordZ - 8, coordX + this.scatteredFeatureSizeX - 1 - 8, 30 + this.scatteredFeatureSizeY - 1, coordZ + this.scatteredFeatureSizeZ - 1 - 8);
                break;
            }
            default: {
                this.boundingBox = new StructureBoundingBox(coordX - 8, 30, coordZ - 8, coordX + this.scatteredFeatureSizeZ - 1 - 8, 30 + this.scatteredFeatureSizeY - 1, coordZ + this.scatteredFeatureSizeX - 1 - 8);
                break;
            }
        }
    }
    
    @Override
    protected boolean build(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
        this.fillWithMetadataBlocks(world, structureBoundingBox, 2, 0, 2, 14, 0, 14, Blocks.cobblestone, 0, Blocks.cobblestone, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 5, 0, 1, 11, 0, 1, Blocks.cobblestone, 0, Blocks.cobblestone, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 5, 0, 15, 11, 0, 15, Blocks.cobblestone, 0, Blocks.cobblestone, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 1, 0, 5, 1, 0, 11, Blocks.cobblestone, 0, Blocks.cobblestone, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 15, 0, 5, 15, 0, 11, Blocks.cobblestone, 0, Blocks.cobblestone, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 5, 0, 0, 11, 6, 0, Blocks.stonebrick, 0, Blocks.stonebrick, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 5, 0, 16, 11, 6, 16, Blocks.stonebrick, 0, Blocks.stonebrick, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 0, 0, 5, 0, 6, 11, Blocks.stonebrick, 0, Blocks.stonebrick, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 16, 0, 5, 16, 6, 11, Blocks.stonebrick, 0, Blocks.stonebrick, 0, false);
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 0, 6, 3, 0, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 0, 10, 3, 0, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 0, 6, 3, 16, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 0, 10, 3, 16, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 0, 0, 3, 6, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 0, 0, 3, 10, structureBoundingBox);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 3, 0, 1, 4, 6, 1, Blocks.stonebrick, 0, Blocks.stonebrick, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 3, 0, 15, 4, 6, 15, Blocks.stonebrick, 0, Blocks.stonebrick, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 12, 0, 1, 13, 6, 1, Blocks.stonebrick, 0, Blocks.stonebrick, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 12, 0, 15, 13, 6, 15, Blocks.stonebrick, 0, Blocks.stonebrick, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 1, 0, 3, 1, 6, 4, Blocks.stonebrick, 0, Blocks.stonebrick, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 15, 0, 3, 15, 6, 4, Blocks.stonebrick, 0, Blocks.stonebrick, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 1, 0, 12, 1, 6, 13, Blocks.stonebrick, 0, Blocks.stonebrick, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 15, 0, 12, 15, 6, 13, Blocks.stonebrick, 0, Blocks.stonebrick, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 2, 0, 2, 2, 6, 2, Blocks.stonebrick, 0, Blocks.stonebrick, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 14, 0, 2, 14, 6, 2, Blocks.stonebrick, 0, Blocks.stonebrick, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 2, 0, 14, 2, 6, 14, Blocks.stonebrick, 0, Blocks.stonebrick, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 14, 0, 14, 14, 6, 14, Blocks.stonebrick, 0, Blocks.stonebrick, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 16, 6, 6, 16, 6, 10, Blocks.air, 0, Blocks.air, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 16, 1, 7, 16, 3, 9, Blocks.air, 0, Blocks.air, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 17, -2, 6, 18, 6, 6, Blocks.stonebrick, 0, Blocks.stonebrick, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 17, -2, 10, 18, 6, 10, Blocks.stonebrick, 0, Blocks.stonebrick, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 18, 5, 7, 18, 6, 9, Blocks.stonebrick, 0, Blocks.stonebrick, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 17, 6, 7, 17, 6, 9, (Block)Blocks.stone_slab, 5, (Block)Blocks.stone_slab, 5, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 17, 5, 7, 17, 5, 9, Blocks.log, this.getMetadataWithOffset(Blocks.log, 4), Blocks.log, this.getMetadataWithOffset(Blocks.log, 4), false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 17, 4, 7, 17, 4, 9, Blocks.iron_bars, 0, Blocks.iron_bars, 0, false);
        this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 16, 4, 8, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 2) + 4, 16, 4, 7, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 3) + 4, 16, 4, 9, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 2) + 4, 18, 4, 7, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 3) + 4, 18, 4, 9, structureBoundingBox);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 2, 5, 2, 14, 5, 14, Blocks.stonebrick, 0, Blocks.stonebrick, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 5, 5, 1, 11, 5, 1, Blocks.stonebrick, 0, Blocks.stonebrick, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 5, 5, 15, 11, 5, 15, Blocks.stonebrick, 0, Blocks.stonebrick, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 1, 5, 5, 1, 5, 11, Blocks.stonebrick, 0, Blocks.stonebrick, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 15, 5, 5, 15, 5, 11, Blocks.stonebrick, 0, Blocks.stonebrick, 0, false);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 5, 7, 0, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 7, 7, 0, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 9, 7, 0, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 11, 7, 0, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 13, 7, 1, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 15, 7, 3, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 16, 7, 5, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 18, 7, 6, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 18, 7, 8, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 18, 7, 10, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 16, 7, 11, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 15, 7, 13, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 13, 7, 15, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 11, 7, 16, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 9, 7, 16, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 7, 7, 16, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 5, 7, 16, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 3, 7, 15, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 1, 7, 13, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 0, 7, 11, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 0, 7, 9, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 0, 7, 7, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 0, 7, 5, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 1, 7, 3, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 3, 7, 1, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 3, 6, 3, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 3, 6, 13, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 13, 6, 3, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 13, 6, 13, structureBoundingBox);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 6, 6, 2, 10, 11, 2, Blocks.stonebrick, 0, Blocks.stonebrick, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 6, 6, 14, 10, 11, 14, Blocks.stonebrick, 0, Blocks.stonebrick, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 2, 6, 6, 2, 11, 10, Blocks.stonebrick, 0, Blocks.stonebrick, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 14, 6, 6, 14, 11, 10, Blocks.stonebrick, 0, Blocks.stonebrick, 0, false);
        this.placeBlockAtCurrentPosition(world, Blocks.cobblestone_wall, 0, 7, 8, 2, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.cobblestone_wall, 0, 7, 9, 2, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.cobblestone_wall, 0, 9, 8, 2, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.cobblestone_wall, 0, 9, 9, 2, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.cobblestone_wall, 0, 7, 8, 14, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.cobblestone_wall, 0, 7, 9, 14, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.cobblestone_wall, 0, 9, 8, 14, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.cobblestone_wall, 0, 9, 9, 14, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.cobblestone_wall, 0, 2, 8, 7, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.cobblestone_wall, 0, 2, 9, 7, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.cobblestone_wall, 0, 2, 8, 9, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.cobblestone_wall, 0, 2, 9, 9, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.cobblestone_wall, 0, 14, 9, 7, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.cobblestone_wall, 0, 14, 9, 9, structureBoundingBox);
        this.placeDoorAtCurrentPosition(world, structureBoundingBox, random, 14, 6, 7, this.getMetadataWithOffset(Blocks.wooden_door, 1));
        this.placeDoorAtCurrentPosition(world, structureBoundingBox, random, 14, 6, 9, this.getMetadataWithOffset(Blocks.wooden_door, 1));
        this.fillWithMetadataBlocks(world, structureBoundingBox, 7, 12, 2, 9, 12, 2, Blocks.stonebrick, 0, Blocks.stonebrick, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 7, 12, 14, 9, 12, 14, Blocks.stonebrick, 0, Blocks.stonebrick, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 2, 12, 7, 2, 12, 9, Blocks.stonebrick, 0, Blocks.stonebrick, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 14, 12, 7, 14, 12, 9, Blocks.stonebrick, 0, Blocks.stonebrick, 0, false);
        this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 0), 6, 12, 2, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 0), 6, 12, 14, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 1), 10, 12, 2, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 1), 10, 12, 14, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 3), 2, 12, 6, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 3), 14, 12, 6, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 2), 2, 12, 10, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 2), 14, 12, 10, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 8, 13, 2, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 8, 13, 14, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 2, 13, 8, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 14, 13, 8, structureBoundingBox);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 4, 6, 3, 5, 11, 3, Blocks.stonebrick, 0, Blocks.stonebrick, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 4, 6, 13, 5, 11, 13, Blocks.stonebrick, 0, Blocks.stonebrick, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 11, 6, 3, 12, 11, 3, Blocks.stonebrick, 0, Blocks.stonebrick, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 11, 6, 13, 12, 11, 13, Blocks.stonebrick, 0, Blocks.stonebrick, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 3, 6, 4, 3, 11, 5, Blocks.stonebrick, 0, Blocks.stonebrick, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 13, 6, 4, 13, 11, 5, Blocks.stonebrick, 0, Blocks.stonebrick, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 3, 6, 11, 3, 11, 12, Blocks.stonebrick, 0, Blocks.stonebrick, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 13, 6, 11, 13, 11, 12, Blocks.stonebrick, 0, Blocks.stonebrick, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 4, 11, 4, 12, 11, 12, Blocks.stonebrick, 0, Blocks.stonebrick, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 6, 11, 3, 10, 11, 3, Blocks.stonebrick, 0, Blocks.stonebrick, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 6, 11, 13, 10, 11, 13, Blocks.stonebrick, 0, Blocks.stonebrick, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 3, 11, 6, 3, 11, 10, Blocks.stonebrick, 0, Blocks.stonebrick, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 13, 11, 6, 13, 11, 10, Blocks.stonebrick, 0, Blocks.stonebrick, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 4, 12, 3, 6, 14, 3, Blocks.stonebrick, 0, Blocks.stonebrick, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 4, 12, 13, 6, 14, 13, Blocks.stonebrick, 0, Blocks.stonebrick, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 10, 12, 3, 12, 14, 3, Blocks.stonebrick, 0, Blocks.stonebrick, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 10, 12, 13, 12, 14, 13, Blocks.stonebrick, 0, Blocks.stonebrick, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 3, 12, 4, 3, 14, 6, Blocks.stonebrick, 0, Blocks.stonebrick, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 13, 12, 4, 13, 14, 6, Blocks.stonebrick, 0, Blocks.stonebrick, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 3, 12, 10, 3, 14, 12, Blocks.stonebrick, 0, Blocks.stonebrick, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 13, 12, 10, 13, 14, 12, Blocks.stonebrick, 0, Blocks.stonebrick, 0, false);
        this.placeBlockAtCurrentPosition(world, Blocks.cobblestone_wall, 0, 5, 13, 3, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.cobblestone_wall, 0, 5, 13, 13, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.cobblestone_wall, 0, 11, 13, 3, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.cobblestone_wall, 0, 11, 13, 13, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.cobblestone_wall, 0, 3, 13, 5, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.cobblestone_wall, 0, 13, 13, 5, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.cobblestone_wall, 0, 3, 13, 11, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.cobblestone_wall, 0, 13, 13, 11, structureBoundingBox);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 7, 12, 4, 9, 14, 4, Blocks.stonebrick, 0, Blocks.stonebrick, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 7, 12, 12, 9, 14, 12, Blocks.stonebrick, 0, Blocks.stonebrick, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 4, 12, 7, 4, 14, 9, Blocks.stonebrick, 0, Blocks.stonebrick, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 12, 12, 7, 12, 14, 9, Blocks.stonebrick, 0, Blocks.stonebrick, 0, false);
        this.placeDoorAtCurrentPosition(world, structureBoundingBox, random, 8, 12, 4, this.getMetadataWithOffset(Blocks.wooden_door, 1));
        this.placeDoorAtCurrentPosition(world, structureBoundingBox, random, 8, 12, 12, this.getMetadataWithOffset(Blocks.wooden_door, 1));
        this.placeDoorAtCurrentPosition(world, structureBoundingBox, random, 4, 12, 8, this.getMetadataWithOffset(Blocks.wooden_door, 1));
        this.placeDoorAtCurrentPosition(world, structureBoundingBox, random, 12, 12, 8, this.getMetadataWithOffset(Blocks.wooden_door, 1));
        this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 8, 12, 3, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 8, 12, 13, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 3, 12, 8, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 13, 12, 8, structureBoundingBox);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 5, 15, 5, 11, 15, 11, Blocks.stonebrick, 0, Blocks.stonebrick, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 7, 16, 7, 9, 16, 9, (Block)Blocks.stone_slab, 5, (Block)Blocks.stone_slab, 5, false);
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 0, 4, 15, 4, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 0, 4, 16, 4, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 0, 6, 15, 4, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 0, 6, 16, 4, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 0, 4, 15, 6, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 0, 4, 16, 6, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 0, 5, 16, 5, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 0, 6, 16, 6, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 0, 4, 15, 5, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 0, 5, 15, 4, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 0, 12, 15, 4, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 0, 12, 16, 4, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 0, 10, 15, 4, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 0, 10, 16, 4, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 0, 12, 15, 6, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 0, 12, 16, 6, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 0, 11, 16, 5, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 0, 10, 16, 6, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 0, 12, 15, 5, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 0, 11, 15, 4, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 0, 4, 15, 12, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 0, 4, 16, 12, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 0, 6, 15, 12, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 0, 6, 16, 12, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 0, 4, 15, 10, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 0, 4, 16, 10, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 0, 5, 16, 11, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 0, 6, 16, 10, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 0, 4, 15, 11, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 0, 5, 15, 12, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 0, 12, 15, 12, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 0, 12, 16, 12, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 0, 10, 15, 12, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 0, 10, 16, 12, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 0, 12, 15, 10, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 0, 12, 16, 10, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 0, 11, 16, 11, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 0, 10, 16, 10, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 0, 12, 15, 11, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 0, 11, 15, 12, structureBoundingBox);
        for (int k = 0; k < 2; ++k) {
            this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 3), 5 + k, 17, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 3), 5 + k, 17, 10, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 3), 11 + k, 17, 4, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 3), 11 + k, 17, 10, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 2), 4 + k, 17, 6, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 2), 4 + k, 17, 12, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 2), 10 + k, 17, 6, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 2), 10 + k, 17, 12, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 1), 6, 17, 5 + k, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 1), 6, 17, 11 + k, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 1), 12, 17, 5 + k, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 1), 12, 17, 11 + k, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 0), 4, 17, 4 + k, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 0), 4, 17, 10 + k, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 0), 10, 17, 4 + k, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 0), 10, 17, 10 + k, structureBoundingBox);
        }
        this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 5, 17, 5, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 11, 17, 5, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 5, 17, 11, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 11, 17, 11, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.gold_block, 0, 5, 18, 5, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.gold_block, 0, 11, 18, 5, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.gold_block, 0, 5, 18, 11, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.gold_block, 0, 11, 18, 11, structureBoundingBox);
        this.func_151554_b(world, Blocks.stonebrick, 0, 17, -1, 7, structureBoundingBox);
        this.func_151554_b(world, Blocks.stonebrick, 0, 18, -1, 7, structureBoundingBox);
        this.func_151554_b(world, Blocks.stonebrick, 0, 17, -1, 8, structureBoundingBox);
        this.func_151554_b(world, Blocks.stonebrick, 0, 18, -1, 8, structureBoundingBox);
        this.func_151554_b(world, Blocks.stonebrick, 0, 17, -1, 9, structureBoundingBox);
        this.func_151554_b(world, Blocks.stonebrick, 0, 18, -1, 9, structureBoundingBox);
        this.func_151554_b(world, Blocks.stonebrick, 0, 19, -1, 7, structureBoundingBox);
        this.func_151554_b(world, Blocks.stonebrick, 0, 19, -1, 8, structureBoundingBox);
        this.func_151554_b(world, Blocks.stonebrick, 0, 19, -1, 9, structureBoundingBox);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 20, -5, 7, 20, 0, 9, Blocks.stonebrick, 0, Blocks.stonebrick, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 20, -6, 7, 20, -6, 9, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 1) + 4, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 1) + 4, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 21, -3, 7, 21, 0, 9, Blocks.stonebrick, 0, Blocks.stonebrick, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 21, -4, 7, 21, -4, 9, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 1) + 4, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 1) + 4, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 22, -2, 7, 22, 0, 9, Blocks.stonebrick, 0, Blocks.stonebrick, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 22, -3, 7, 22, -3, 9, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 1) + 4, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 1) + 4, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 23, -2, 7, 23, 0, 9, Blocks.stonebrick, 0, Blocks.stonebrick, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 24, -1, 7, 25, 0, 9, Blocks.stonebrick, 0, Blocks.stonebrick, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 24, -2, 7, 25, -2, 9, (Block)Blocks.stone_slab, 13, (Block)Blocks.stone_slab, 13, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 26, -1, 7, 27, 0, 9, Blocks.stonebrick, 0, Blocks.stonebrick, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 28, -1, 7, 29, 0, 9, Blocks.stonebrick, 0, Blocks.stonebrick, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 28, -2, 7, 29, -2, 9, (Block)Blocks.stone_slab, 13, (Block)Blocks.stone_slab, 13, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 30, -2, 7, 30, 0, 9, Blocks.stonebrick, 0, Blocks.stonebrick, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 31, -2, 7, 31, 0, 9, Blocks.stonebrick, 0, Blocks.stonebrick, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 31, -3, 7, 31, -3, 9, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 0) + 4, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 0) + 4, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 32, -3, 7, 32, 0, 9, Blocks.stonebrick, 0, Blocks.stonebrick, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 32, -4, 7, 32, -4, 9, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 0) + 4, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 0) + 4, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 33, -5, 7, 33, 0, 9, Blocks.stonebrick, 0, Blocks.stonebrick, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 33, -6, 7, 33, -6, 9, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 0) + 4, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 0) + 4, false);
        this.func_151554_b(world, Blocks.stonebrick, 0, 34, -1, 7, structureBoundingBox);
        this.func_151554_b(world, Blocks.stonebrick, 0, 35, -1, 7, structureBoundingBox);
        this.func_151554_b(world, Blocks.stonebrick, 0, 34, -1, 8, structureBoundingBox);
        this.func_151554_b(world, Blocks.stonebrick, 0, 35, -1, 8, structureBoundingBox);
        this.func_151554_b(world, Blocks.stonebrick, 0, 34, -1, 9, structureBoundingBox);
        this.func_151554_b(world, Blocks.stonebrick, 0, 35, -1, 9, structureBoundingBox);
        this.func_151554_b(world, Blocks.stonebrick, 0, 36, -1, 7, structureBoundingBox);
        this.func_151554_b(world, Blocks.stonebrick, 0, 36, -1, 8, structureBoundingBox);
        this.func_151554_b(world, Blocks.stonebrick, 0, 36, -1, 9, structureBoundingBox);
        this.func_151554_b(world, Blocks.stonebrick, 0, 37, -1, 7, structureBoundingBox);
        this.func_151554_b(world, Blocks.stonebrick, 0, 37, -1, 8, structureBoundingBox);
        this.func_151554_b(world, Blocks.stonebrick, 0, 37, -1, 9, structureBoundingBox);
        this.func_151554_b(world, Blocks.stonebrick, 0, 38, -1, 7, structureBoundingBox);
        this.func_151554_b(world, Blocks.stonebrick, 0, 38, -1, 8, structureBoundingBox);
        this.func_151554_b(world, Blocks.stonebrick, 0, 38, -1, 9, structureBoundingBox);
        this.func_151554_b(world, Blocks.stonebrick, 0, 39, -1, 7, structureBoundingBox);
        this.func_151554_b(world, Blocks.stonebrick, 0, 39, -1, 8, structureBoundingBox);
        this.func_151554_b(world, Blocks.stonebrick, 0, 39, -1, 9, structureBoundingBox);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 16, 0, 7, 38, 0, 9, Blocks.cobblestone, 0, Blocks.cobblestone, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 19, 0, 6, 34, 0, 6, (Block)Blocks.stone_slab, 11, (Block)Blocks.stone_slab, 11, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 19, 1, 6, 34, 1, 6, Blocks.cobblestone_wall, 0, Blocks.cobblestone_wall, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 19, 0, 10, 34, 0, 10, (Block)Blocks.stone_slab, 11, (Block)Blocks.stone_slab, 11, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 19, 1, 10, 34, 1, 10, Blocks.cobblestone_wall, 0, Blocks.cobblestone_wall, 0, false);
        for (int k = 0; k <= 15; ++k) {
            if (k % 3 == 0) {
                this.placeBlockAtCurrentPosition(world, Blocks.iron_bars, 0, 19 + k, -1, 7, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.torch, 5, 19 + k, -1, 8, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, Blocks.iron_bars, 0, 19 + k, -1, 9, structureBoundingBox);
            }
        }
        this.fillWithMetadataBlocks(world, structureBoundingBox, 39, 0, 7, 39, 0, 9, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 1), Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 1), false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 35, -1, 6, 39, 6, 6, Blocks.stonebrick, 0, Blocks.stonebrick, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 35, -1, 10, 39, 6, 10, Blocks.stonebrick, 0, Blocks.stonebrick, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 35, 5, 7, 39, 6, 9, Blocks.stonebrick, 0, Blocks.stonebrick, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 35, 5, 7, 39, 6, 9, Blocks.stonebrick, 0, Blocks.stonebrick, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 36, 4, 6, 36, 5, 6, Blocks.cobblestone_wall, 0, Blocks.cobblestone_wall, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 36, 4, 10, 36, 5, 10, Blocks.cobblestone_wall, 0, Blocks.cobblestone_wall, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 38, 4, 6, 38, 5, 6, Blocks.cobblestone_wall, 0, Blocks.cobblestone_wall, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 38, 4, 10, 38, 5, 10, Blocks.cobblestone_wall, 0, Blocks.cobblestone_wall, 0, false);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 36, 6, 7, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 36, 6, 8, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 36, 6, 9, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 37, 6, 7, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 37, 6, 9, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 38, 6, 7, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 38, 6, 8, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 38, 6, 9, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 37, 7, 8, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 2) + 4, 35, 4, 7, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 2) + 4, 36, 4, 7, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 2) + 4, 38, 4, 7, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 2) + 4, 39, 4, 7, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 3) + 4, 35, 4, 9, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 3) + 4, 36, 4, 9, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 3) + 4, 38, 4, 9, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 3) + 4, 39, 4, 9, structureBoundingBox);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 37, 5, 7, 37, 5, 9, Blocks.log, this.getMetadataWithOffset(Blocks.log, 4), Blocks.log, this.getMetadataWithOffset(Blocks.log, 4), false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 37, 1, 7, 37, 4, 9, Blocks.iron_bars, 0, Blocks.iron_bars, 0, false);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 35, 7, 6, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 37, 7, 6, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 39, 7, 6, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 39, 7, 8, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 39, 7, 10, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 37, 7, 10, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 35, 7, 10, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 35, 7, 8, structureBoundingBox);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 8, 1, 8, 8, 14, 8, Blocks.stonebrick, 0, Blocks.stonebrick, 0, false);
        this.placeBlockAtCurrentPosition(world, Blocks.cobblestone_wall, 0, 6, 3, 0, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.cobblestone_wall, 0, 10, 3, 0, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.cobblestone_wall, 0, 6, 3, 16, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.cobblestone_wall, 0, 10, 3, 16, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.cobblestone_wall, 0, 0, 3, 6, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.cobblestone_wall, 0, 0, 3, 10, structureBoundingBox);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 4, 1, 2, 4, 4, 11, Blocks.stonebrick, 0, Blocks.stonebrick, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 2, 1, 12, 14, 4, 12, Blocks.stonebrick, 0, Blocks.stonebrick, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 1, 1, 8, 3, 4, 8, Blocks.stonebrick, 0, Blocks.stonebrick, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 8, 1, 13, 8, 4, 15, Blocks.stonebrick, 0, Blocks.stonebrick, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 8, 1, 1, 8, 2, 2, Blocks.stonebrick, 0, Blocks.stonebrick, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 7, 1, 3, 7, 2, 3, Blocks.stonebrick, 0, Blocks.stonebrick, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 9, 1, 3, 9, 2, 3, Blocks.stonebrick, 0, Blocks.stonebrick, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 6, 1, 1, 6, 1, 2, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 0), Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 0), false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 7, 2, 1, 7, 2, 2, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 0), Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 0), false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 9, 2, 1, 9, 2, 2, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 1), Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 1), false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 10, 1, 1, 10, 1, 2, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 1), Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 1), false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 7, 3, 3, 9, 3, 3, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 3), Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 3), false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 7, 4, 4, 9, 4, 4, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 3), Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 3), false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 7, 5, 5, 9, 5, 5, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 3), Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 3), false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 7, 5, 2, 9, 5, 4, Blocks.air, 0, Blocks.air, 0, false);
        this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 6), 8, 2, 3, structureBoundingBox);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 7, 3, 4, 9, 3, 4, Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 6), Blocks.stone_brick_stairs, this.getMetadataWithOffset(Blocks.stone_brick_stairs, 6), false);
        this.placeDoorAtCurrentPosition(world, structureBoundingBox, random, 4, 1, 6, this.getMetadataWithOffset(Blocks.wooden_door, 1));
        this.placeDoorAtCurrentPosition(world, structureBoundingBox, random, 4, 1, 10, this.getMetadataWithOffset(Blocks.wooden_door, 1));
        this.placeDoorAtCurrentPosition(world, structureBoundingBox, random, 6, 1, 12, this.getMetadataWithOffset(Blocks.wooden_door, 1));
        this.placeDoorAtCurrentPosition(world, structureBoundingBox, random, 10, 1, 12, this.getMetadataWithOffset(Blocks.wooden_door, 1));
        this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 7, 3, 8, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 9, 3, 8, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 8, 3, 7, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 8, 3, 9, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 12, 3, 2, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 14, 3, 4, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 2, 3, 4, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 3, 3, 10, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 4, 3, 14, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 12, 3, 14, structureBoundingBox);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 11, 6, 5, 11, 14, 5, Blocks.stonebrick, 0, Blocks.stonebrick, 0, false);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 11, 6, 4, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 0, 12, 6, 4, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 0, 12, 6, 5, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 12, 7, 5, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 13, 12, 7, 6, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 11, 8, 6, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 13, 10, 8, 6, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 10, 9, 5, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 13, 10, 9, 4, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 11, 10, 4, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 13, 12, 10, 4, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 12, 11, 5, structureBoundingBox);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 10, 11, 6, 12, 11, 6, (Block)Blocks.stone_slab, 13, (Block)Blocks.stone_slab, 13, false);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 13, 10, 12, 5, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 10, 11, 5, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 10, 11, 4, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 11, 11, 4, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 12, 11, 4, structureBoundingBox);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 11, 6, 11, 11, 14, 11, Blocks.stonebrick, 0, Blocks.stonebrick, 0, false);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 11, 6, 12, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 0, 12, 6, 12, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 0, 12, 6, 11, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 12, 7, 11, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 13, 12, 7, 10, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 11, 8, 10, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 13, 10, 8, 10, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 10, 9, 11, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 13, 10, 9, 12, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 11, 10, 12, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 13, 12, 10, 12, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 12, 11, 11, structureBoundingBox);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 10, 11, 10, 12, 11, 10, (Block)Blocks.stone_slab, 13, (Block)Blocks.stone_slab, 13, false);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 13, 10, 12, 11, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 10, 11, 11, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 10, 11, 12, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 11, 11, 12, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 12, 11, 12, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 8, 8, 3, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 8, 8, 13, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 3, 8, 8, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 13, 8, 8, structureBoundingBox);
        this.spawnEntity(world, structureBoundingBox, 6, 6, 10, 0);
        this.spawnEntity(world, structureBoundingBox, 7, 6, 10, 1);
        this.spawnEntity(world, structureBoundingBox, 6, 6, 9, 1);
        this.spawnEntity(world, structureBoundingBox, 6, 1, 14, 2);
        this.spawnEntity(world, structureBoundingBox, 7, 1, 14, 2);
        this.spawnEntity(world, structureBoundingBox, 9, 1, 14, 2);
        this.spawnEntity(world, structureBoundingBox, 10, 1, 14, 2);
        this.spawnEntity(world, structureBoundingBox, 2, 6, 10, 3);
        this.spawnEntity(world, structureBoundingBox, 2, 6, 6, 1);
        this.spawnEntity(world, structureBoundingBox, 15, 6, 7, 1);
        this.spawnEntity(world, structureBoundingBox, 15, 6, 9, 1);
        this.spawnEntity(world, structureBoundingBox, 9, 1, 7, 4);
        this.spawnEntity(world, structureBoundingBox, 14, 1, 7, 2);
        this.spawnEntity(world, structureBoundingBox, 14, 1, 9, 2);
        this.spawnEntity(world, structureBoundingBox, 34, 1, 8, 4);
        this.spawnEntity(world, structureBoundingBox, 35, 1, 7, 1);
        this.spawnEntity(world, structureBoundingBox, 35, 1, 8, 1);
        this.spawnEntity(world, structureBoundingBox, 35, 1, 9, 1);
        return true;
    }
    
    @Override
    protected EntityLiving getNewEntity(final World world, final int choice) {
        switch (choice) {
            case 0: {
                return (EntityLiving)new EntityDwarf(world, EnumVillager.DWARF_KING);
            }
            case 1: {
                return (EntityLiving)new EntityDwarf(world, EnumVillager.DWARF_WARRIOR);
            }
            case 2: {
                return (EntityLiving)new EntityDwarf(world, EnumVillager.DWARF_MINER);
            }
            case 3: {
                return (EntityLiving)new EntityDwarf(world, EnumVillager.DWARF_SMITH);
            }
            case 4: {
                return (EntityLiving)new EntityDwarf(world, EnumVillager.DWARF_HEALER);
            }
            default: {
                return (EntityLiving)new EntityDwarf(world, EnumVillager.DWARF_MINER);
            }
        }
    }
}
