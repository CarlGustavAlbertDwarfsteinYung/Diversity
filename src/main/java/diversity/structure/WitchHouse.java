// 
// Decompiled by Procyon v0.5.36
// 

package diversity.structure;

import net.minecraft.item.Item;
import net.minecraft.init.Items;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.EntityLiving;
import net.minecraftforge.common.ChestGenHooks;
import diversity.utils.ChestGenTools;
import diversity.utils.DirectionTools;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import java.util.Random;
import net.minecraft.util.WeightedRandomChestContent;

public class WitchHouse extends GlobalFeature
{
    public static final WeightedRandomChestContent[] itemsToGenerateInHut;
    
    public WitchHouse() {
    }
    
    public WitchHouse(final Random random, final int coordX, final int coordZ) {
        super(random, coordX, coordZ, 10, 8, 8);
        switch (this.coordBaseMode) {
            case 0:
            case 2: {
                this.boundingBox = new StructureBoundingBox(coordX - this.scatteredFeatureSizeX / 2, 33, coordZ - this.scatteredFeatureSizeZ / 2, coordX + this.scatteredFeatureSizeX / 2 - 1, 33 + this.scatteredFeatureSizeY - 1, coordZ + this.scatteredFeatureSizeZ / 2 - 1);
                break;
            }
            default: {
                this.boundingBox = new StructureBoundingBox(coordX - this.scatteredFeatureSizeZ / 2, 33, coordZ - this.scatteredFeatureSizeX / 2, coordX + this.scatteredFeatureSizeZ / 2 - 1, 33 + this.scatteredFeatureSizeY - 1, coordZ + this.scatteredFeatureSizeX / 2 - 1);
                break;
            }
        }
    }
    
    @Override
    protected boolean build(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
        this.fillWithMetadataBlocks(world, structureBoundingBox, 1, 0, 1, 9, 4, 6, Blocks.cobblestone, 0, Blocks.air, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 2, 0, 2, 8, 0, 5, Blocks.planks, 1, Blocks.planks, 1, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 0, 1, 2, 0, 4, 2, Blocks.log, 0, Blocks.log, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 10, 1, 2, 10, 4, 2, Blocks.log, 0, Blocks.log, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 0, 1, 5, 0, 4, 5, Blocks.log, 0, Blocks.log, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 10, 1, 5, 10, 4, 5, Blocks.log, 0, Blocks.log, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 1, 1, 1, 1, 3, 1, Blocks.log, 0, Blocks.log, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 9, 1, 1, 9, 3, 1, Blocks.log, 0, Blocks.log, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 1, 1, 6, 1, 3, 6, Blocks.log, 0, Blocks.log, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 9, 1, 6, 9, 3, 6, Blocks.log, 0, Blocks.log, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 2, 1, 0, 2, 2, 0, Blocks.log, 0, Blocks.log, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 8, 1, 0, 8, 2, 0, Blocks.log, 0, Blocks.log, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 2, 1, 7, 2, 2, 7, Blocks.log, 0, Blocks.log, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 8, 1, 7, 8, 2, 7, Blocks.log, 0, Blocks.log, 0, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 2, 4, 2, 8, 4, 5, Blocks.planks, 1, Blocks.planks, 1, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 1, 5, 3, 9, 5, 4, Blocks.planks, 1, Blocks.planks, 1, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 5, 3, 2, 5, 3, 5, Blocks.log, DirectionTools.log[this.coordBaseMode][1], Blocks.log, DirectionTools.log[this.coordBaseMode][1], false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 1, 3, 0, 9, 3, 0, Blocks.spruce_stairs, DirectionTools.stair[this.coordBaseMode][3], Blocks.spruce_stairs, DirectionTools.stair[this.coordBaseMode][3], false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 0, 4, 1, 10, 4, 1, Blocks.spruce_stairs, DirectionTools.stair[this.coordBaseMode][3], Blocks.spruce_stairs, DirectionTools.stair[this.coordBaseMode][3], false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 0, 5, 2, 10, 5, 2, Blocks.spruce_stairs, DirectionTools.stair[this.coordBaseMode][3], Blocks.spruce_stairs, DirectionTools.stair[this.coordBaseMode][3], false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 0, 6, 3, 10, 6, 3, Blocks.spruce_stairs, DirectionTools.stair[this.coordBaseMode][3], Blocks.spruce_stairs, DirectionTools.stair[this.coordBaseMode][3], false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 0, 6, 4, 10, 6, 4, Blocks.spruce_stairs, DirectionTools.stair[this.coordBaseMode][2], Blocks.spruce_stairs, DirectionTools.stair[this.coordBaseMode][2], false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 0, 5, 5, 10, 5, 5, Blocks.spruce_stairs, DirectionTools.stair[this.coordBaseMode][2], Blocks.spruce_stairs, DirectionTools.stair[this.coordBaseMode][2], false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 0, 4, 6, 10, 4, 6, Blocks.spruce_stairs, DirectionTools.stair[this.coordBaseMode][2], Blocks.spruce_stairs, DirectionTools.stair[this.coordBaseMode][2], false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 1, 3, 7, 9, 3, 7, Blocks.spruce_stairs, DirectionTools.stair[this.coordBaseMode][2], Blocks.spruce_stairs, DirectionTools.stair[this.coordBaseMode][2], false);
        this.placeBlockAtCurrentPosition(world, Blocks.spruce_stairs, DirectionTools.stair[this.coordBaseMode][0] + 4, 0, 5, 4, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.spruce_stairs, DirectionTools.stair[this.coordBaseMode][1] + 4, 10, 5, 4, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.spruce_stairs, DirectionTools.stair[this.coordBaseMode][0] + 4, 0, 5, 3, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.spruce_stairs, DirectionTools.stair[this.coordBaseMode][1] + 4, 10, 5, 3, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.web, 0, 0, 1 + random.nextInt(4), 3, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.web, 0, 10, 1 + random.nextInt(4), 3, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.web, 0, 0, 1 + random.nextInt(4), 4, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.web, 0, 10, 1 + random.nextInt(4), 4, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 4, 2, 1, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 4, 2, 6, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 6, 2, 6, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 6, 2, 1, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 6, 1, 1, structureBoundingBox);
        this.placeDoorAtCurrentPosition(world, structureBoundingBox, random, 6, 1, 1, this.getMetadataWithOffset(Blocks.wooden_door, 1));
        this.fillWithMetadataBlocks(world, structureBoundingBox, 2, 5, 5, 2, 7, 5, Blocks.cobblestone, 0, Blocks.cobblestone, 0, false);
        this.placeBlockAtCurrentPosition(world, Blocks.log, 0, 5, 1, 2, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 5, 2, 2, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.bed, this.getMetadataWithOffset(Blocks.bed, 1) + 8, 2, 1, 3, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.bed, this.getMetadataWithOffset(Blocks.bed, 1), 3, 1, 3, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 3, 2, 2, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 7, 2, 2, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 3, 2, 5, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 7, 2, 5, structureBoundingBox);
        final ChestGenHooks chest = ChestGenTools.getInfo("swampHutChest");
        this.generateStructureChestContents(world, structureBoundingBox, random, 8, 1, 3, chest.getItems(random), chest.getCount(random));
        this.spawnEntity(world, structureBoundingBox, 6, 1, 4, 0);
        return true;
    }
    
    @Override
    protected EntityLiving getNewEntity(final World world, final int choice) {
        return (EntityLiving)new EntityWitch(world);
    }
    
    static {
        itemsToGenerateInHut = new WeightedRandomChestContent[] { new WeightedRandomChestContent(Items.rotten_flesh, 0, 4, 6, 10), new WeightedRandomChestContent(Items.bone, 0, 4, 5, 10), new WeightedRandomChestContent(Items.spider_eye, 0, 3, 7, 15), new WeightedRandomChestContent(Items.apple, 0, 1, 4, 8), new WeightedRandomChestContent(Items.glass_bottle, 0, 2, 6, 20), new WeightedRandomChestContent((Item)Items.potionitem, 0, 0, 2, 16), new WeightedRandomChestContent(Items.fermented_spider_eye, 0, 1, 5, 6), new WeightedRandomChestContent(Items.ender_pearl, 0, 1, 1, 1), new WeightedRandomChestContent(Items.gunpowder, 0, 1, 5, 5) };
    }
}
