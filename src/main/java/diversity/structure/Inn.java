// 
// Decompiled by Procyon v0.5.36
// 

package diversity.structure;

import net.minecraft.item.Item;
import net.minecraft.init.Items;
import net.minecraft.entity.passive.EntityHorse;
import diversity.entity.EntitySettled;
import diversity.suppliers.EnumVillager;
import diversity.entity.EntityWorshipper;
import net.minecraft.entity.EntityLiving;
import diversity.utils.ChestGenTools;
import net.minecraft.block.BlockLever;
import diversity.utils.DirectionTools;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.World;
import net.minecraft.nbt.NBTTagCompound;
import java.util.Random;
import net.minecraft.util.WeightedRandomChestContent;

public class Inn extends GlobalFeature
{
    public static final WeightedRandomChestContent[] itemsToGenerateInn;
    private boolean[] isTorch;
    
    public Inn() {
        this.isTorch = new boolean[3];
    }
    
    public Inn(final Random random, final int coordX, final int coordZ) {
        super(random, coordX, coordZ, 21, 8, 12);
        (this.isTorch = new boolean[3])[0] = random.nextBoolean();
        this.isTorch[1] = random.nextBoolean();
        this.isTorch[2] = ((!this.isTorch[0] || !this.isTorch[1]) && random.nextBoolean());
    }
    
    @Override
    protected void func_143012_a(final NBTTagCompound p_143012_1_) {
        super.func_143012_a(p_143012_1_);
        p_143012_1_.setBoolean("T0", this.isTorch[0]);
        p_143012_1_.setBoolean("T1", this.isTorch[1]);
        p_143012_1_.setBoolean("T2", this.isTorch[2]);
    }
    
    @Override
    protected void func_143011_b(final NBTTagCompound p_143011_1_) {
        super.func_143011_b(p_143011_1_);
        this.isTorch[0] = p_143011_1_.getBoolean("T0");
        this.isTorch[1] = p_143011_1_.getBoolean("T1");
        this.isTorch[2] = p_143011_1_.getBoolean("T2");
    }
    
    @Override
    protected boolean build(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
        if (!this.func_74935_a(world, structureBoundingBox, -1)) {
            return false;
        }
        for (int x = 3; x < 19; ++x) {
            for (int z = 1; z < 10; ++z) {
                this.clearCurrentPositionBlocksUpwards(world, x, 1, z, structureBoundingBox);
            }
        }
        for (int x = 0; x < 21; ++x) {
            for (int z = -1; z < 11; ++z) {
                this.func_151554_b(world, Blocks.dirt, 0, x, -1, z, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, (Block)Blocks.grass, 0, x, 0, z, structureBoundingBox);
            }
        }
        this.fillWithBlocks(world, structureBoundingBox, 1, -2, 4, 11, -1, 10, Blocks.cobblestone, Blocks.cobblestone, false);
        this.fillWithAir(world, structureBoundingBox, 4, -2, 5, 10, -1, 8);
        this.fillWithBlocks(world, structureBoundingBox, 0, -10, -1, 20, -3, 10, Blocks.cobblestone, Blocks.cobblestone, false);
        this.fillWithBlocks(world, structureBoundingBox, 3, 1, 4, 3, 5, 4, Blocks.log, Blocks.log, false);
        this.fillWithBlocks(world, structureBoundingBox, 3, -2, 8, 3, 5, 8, Blocks.log, Blocks.log, false);
        this.fillWithBlocks(world, structureBoundingBox, 4, 1, 3, 4, 6, 3, Blocks.log, Blocks.log, false);
        this.fillWithBlocks(world, structureBoundingBox, 4, -2, 9, 4, 6, 9, Blocks.log, Blocks.log, false);
        this.fillWithBlocks(world, structureBoundingBox, 8, 1, 3, 8, 6, 3, Blocks.log, Blocks.log, false);
        this.fillWithBlocks(world, structureBoundingBox, 8, 1, 9, 8, 6, 9, Blocks.log, Blocks.log, false);
        this.fillWithBlocks(world, structureBoundingBox, 9, 1, 4, 9, 5, 4, Blocks.log, Blocks.log, false);
        this.fillWithBlocks(world, structureBoundingBox, 9, 1, 8, 9, 5, 8, Blocks.log, Blocks.log, false);
        this.fillWithBlocks(world, structureBoundingBox, 13, 1, 4, 13, 3, 4, Blocks.log, Blocks.log, false);
        this.fillWithBlocks(world, structureBoundingBox, 13, 1, 8, 13, 3, 8, Blocks.log, Blocks.log, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 5, 4, 3, 7, 4, 3, Blocks.log, DirectionTools.log[this.coordBaseMode][0], Blocks.log, DirectionTools.log[this.coordBaseMode][0], false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 5, 4, 9, 7, 4, 9, Blocks.log, DirectionTools.log[this.coordBaseMode][0], Blocks.log, DirectionTools.log[this.coordBaseMode][0], false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 3, 4, 5, 3, 4, 7, Blocks.log, DirectionTools.log[this.coordBaseMode][1], Blocks.log, DirectionTools.log[this.coordBaseMode][1], false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 9, 4, 5, 9, 4, 7, Blocks.log, DirectionTools.log[this.coordBaseMode][1], Blocks.log, DirectionTools.log[this.coordBaseMode][1], false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 13, 4, 5, 13, 4, 7, Blocks.log, DirectionTools.log[this.coordBaseMode][1], Blocks.log, DirectionTools.log[this.coordBaseMode][1], false);
        this.fillWithBlocks(world, structureBoundingBox, 5, 1, 3, 7, 3, 3, Blocks.cobblestone, Blocks.cobblestone, false);
        this.fillWithBlocks(world, structureBoundingBox, 5, 5, 3, 7, 7, 3, Blocks.cobblestone, Blocks.cobblestone, false);
        this.fillWithBlocks(world, structureBoundingBox, 5, 1, 9, 7, 3, 9, Blocks.cobblestone, Blocks.cobblestone, false);
        this.fillWithBlocks(world, structureBoundingBox, 5, 5, 9, 7, 7, 9, Blocks.cobblestone, Blocks.cobblestone, false);
        this.fillWithBlocks(world, structureBoundingBox, 10, 1, 4, 12, 3, 4, Blocks.cobblestone, Blocks.cobblestone, false);
        this.fillWithBlocks(world, structureBoundingBox, 10, 1, 8, 12, 3, 8, Blocks.cobblestone, Blocks.cobblestone, false);
        this.fillWithBlocks(world, structureBoundingBox, 3, 1, 5, 3, 3, 7, Blocks.cobblestone, Blocks.cobblestone, false);
        this.fillWithBlocks(world, structureBoundingBox, 13, 1, 5, 13, 3, 7, Blocks.cobblestone, Blocks.cobblestone, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 2, 5, 4, 2, 5, 8, Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][0], Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][0], false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 3, 6, 3, 3, 6, 9, Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][0], Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][0], false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 4, 7, 3, 4, 7, 9, Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][0], Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][0], false);
        this.fillWithBlocks(world, structureBoundingBox, 5, 8, 3, 5, 8, 9, (Block)Blocks.wooden_slab, (Block)Blocks.wooden_slab, false);
        this.fillWithBlocks(world, structureBoundingBox, 6, 8, 3, 6, 8, 9, Blocks.planks, Blocks.planks, false);
        this.fillWithBlocks(world, structureBoundingBox, 7, 8, 3, 7, 8, 9, (Block)Blocks.wooden_slab, (Block)Blocks.wooden_slab, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 8, 7, 3, 8, 7, 9, Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][1], Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][1], false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 9, 6, 3, 9, 6, 9, Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][1], Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][1], false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 10, 5, 4, 10, 5, 8, Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][1], Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][1], false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 9, 3, 3, 13, 3, 3, Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][3], Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][3], false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 10, 4, 4, 13, 4, 4, Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][3], Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][3], false);
        this.fillWithBlocks(world, structureBoundingBox, 11, 5, 5, 13, 5, 5, (Block)Blocks.wooden_slab, (Block)Blocks.wooden_slab, false);
        this.fillWithBlocks(world, structureBoundingBox, 10, 5, 6, 13, 5, 6, Blocks.planks, Blocks.planks, false);
        this.fillWithBlocks(world, structureBoundingBox, 11, 5, 7, 13, 5, 7, (Block)Blocks.wooden_slab, (Block)Blocks.wooden_slab, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 10, 4, 8, 13, 4, 8, Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][2], Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][2], false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 9, 3, 9, 13, 3, 9, Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][2], Blocks.oak_stairs, DirectionTools.stair[this.coordBaseMode][2], false);
        this.fillWithBlocks(world, structureBoundingBox, 4, 0, 4, 8, 0, 8, Blocks.planks, Blocks.planks, false);
        this.fillWithBlocks(world, structureBoundingBox, 9, 0, 5, 12, 0, 7, Blocks.planks, Blocks.planks, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 4, 4, 4, 8, 4, 8, (Block)Blocks.wooden_slab, 8, (Block)Blocks.wooden_slab, 8, false);
        this.placeBlockAtCurrentPosition(world, Blocks.log, DirectionTools.log[this.coordBaseMode][0], 6, 0, 3, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.log, DirectionTools.log[this.coordBaseMode][0], 11, 0, 8, structureBoundingBox);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 5, 0, 5, 5, 0, 7, Blocks.log, DirectionTools.log[this.coordBaseMode][1], Blocks.log, DirectionTools.log[this.coordBaseMode][1], false);
        this.placeBlockAtCurrentPosition(world, Blocks.log, 0, 5, 1, 5, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.wooden_slab, 8, 5, 1, 6, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.wooden_slab, 8, 5, 1, 7, structureBoundingBox);
        this.fillWithBlocks(world, structureBoundingBox, 5, -2, 8, 5, 1, 8, Blocks.log, Blocks.log, false);
        this.placeBlockAtCurrentPosition(world, Blocks.fence_gate, this.getMetadataWithOffset(Blocks.fence_gate, 1), 5, 1, 4, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.torch, 5, 5, 2, 8, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.spruce_stairs, DirectionTools.stair[this.coordBaseMode][1], 6, 1, 8, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 7, 1, 8, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.wooden_pressure_plate, 0, 7, 2, 8, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.spruce_stairs, DirectionTools.stair[this.coordBaseMode][0], 8, 1, 8, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.spruce_stairs, DirectionTools.stair[this.coordBaseMode][2], 8, 1, 4, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 8, 1, 5, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.wooden_pressure_plate, 0, 8, 2, 5, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.spruce_stairs, DirectionTools.stair[this.coordBaseMode][0], 9, 1, 5, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.spruce_stairs, DirectionTools.stair[this.coordBaseMode][3], 12, 1, 7, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 12, 1, 6, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.wooden_pressure_plate, 0, 12, 2, 6, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.spruce_stairs, DirectionTools.stair[this.coordBaseMode][2], 12, 1, 5, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.double_plant, 3, 9, 1, 9, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.double_plant, 11, 9, 2, 9, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 10, 1, 9, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 10, 2, 9, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 12, 1, 9, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 12, 2, 9, structureBoundingBox);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 9, 0, 3, 12, 0, 3, Blocks.dirt, 1, Blocks.dirt, 1, false);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.double_plant, 4, 9, 1, 3, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.double_plant, 12, 9, 2, 3, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.red_flower, 8, 10, 1, 3, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.red_flower, 0, 11, 1, 3, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.double_plant, 3, 12, 1, 3, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.double_plant, 11, 12, 2, 3, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 8, 3, 2, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 4, 1, 2, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 4, 1, 1, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 5, 1, 1, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 7, 1, 1, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 9, 1, 1, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 11, 1, 1, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 13, 1, 3, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.fence_gate, this.getMetadataWithOffset(Blocks.fence_gate, 1), 13, 1, 2, structureBoundingBox);
        this.fillWithBlocks(world, structureBoundingBox, 13, 1, 1, 18, 1, 1, Blocks.fence, Blocks.fence, false);
        this.fillWithBlocks(world, structureBoundingBox, 18, 1, 2, 18, 1, 7, Blocks.fence, Blocks.fence, false);
        this.fillWithBlocks(world, structureBoundingBox, 14, 1, 8, 18, 1, 8, Blocks.fence, Blocks.fence, false);
        this.placeBlockAtCurrentPosition(world, Blocks.glass_pane, 0, 3, 2, 6, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.glass_pane, 0, 6, 2, 9, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.glass_pane, 0, 6, 6, 3, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.glass_pane, 0, 6, 6, 9, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.glass_pane, 0, 11, 2, 4, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.glass_pane, 0, 13, 2, 6, structureBoundingBox);
        this.placeDoorAtCurrentPosition(world, structureBoundingBox, random, 6, 1, 3, this.getMetadataWithOffset(Blocks.wooden_door, 1));
        this.placeDoorAtCurrentPosition(world, structureBoundingBox, random, 11, 1, 8, this.getMetadataWithOffset(Blocks.wooden_door, 1));
        this.fillWithBlocks(world, structureBoundingBox, 5, 0, 2, 12, 0, 2, Blocks.gravel, Blocks.gravel, false);
        this.placeBlockAtCurrentPosition(world, Blocks.gravel, 0, 11, 0, 9, structureBoundingBox);
        this.fillWithBlocks(world, structureBoundingBox, 10, 4, 5, 12, 4, 7, Blocks.planks, Blocks.planks, false);
        final int meta = this.getMetadataWithOffset(Blocks.ladder, 3);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 4, -2, 8, 4, 5, 8, Blocks.ladder, meta, Blocks.ladder, meta, false);
        this.placeBlockAtCurrentPosition(world, Blocks.log, 0, 7, -2, 5, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.wooden_slab, 8, 8, -2, 5, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.wooden_slab, 8, 9, -2, 5, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.log, 0, 10, -2, 5, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.torch, 5, 10, -1, 5, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.cobblestone_wall, 0, 6, -2, 8, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.log, DirectionTools.log[this.coordBaseMode][1], 6, -1, 8, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.lever, BlockLever.invertMetadata(this.getMetadataWithOffset(Blocks.lever, 3)) + 8, 6, -1, 7, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.cobblestone_wall, 0, 8, -2, 8, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.log, DirectionTools.log[this.coordBaseMode][1], 8, -1, 8, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.lever, BlockLever.invertMetadata(this.getMetadataWithOffset(Blocks.lever, 3)) + 8, 8, -1, 7, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.cobblestone_wall, 0, 10, -2, 8, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.log, DirectionTools.log[this.coordBaseMode][1], 10, -1, 8, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.lever, BlockLever.invertMetadata(this.getMetadataWithOffset(Blocks.lever, 3)) + 8, 10, -1, 7, structureBoundingBox);
        if (this.isTorch[0]) {
            this.placeBlockAtCurrentPosition(world, Blocks.redstone_torch, DirectionTools.torch[this.coordBaseMode][2], 6, -1, 9, structureBoundingBox);
        }
        else {
            this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 6, -1, 9, structureBoundingBox);
        }
        if (this.isTorch[1]) {
            this.placeBlockAtCurrentPosition(world, Blocks.redstone_torch, DirectionTools.torch[this.coordBaseMode][2], 8, -1, 9, structureBoundingBox);
        }
        else {
            this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 8, -1, 9, structureBoundingBox);
        }
        if (this.isTorch[2]) {
            this.placeBlockAtCurrentPosition(world, Blocks.redstone_torch, DirectionTools.torch[this.coordBaseMode][2], 10, -1, 9, structureBoundingBox);
        }
        else {
            this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 10, -1, 9, structureBoundingBox);
        }
        this.fillWithBlocks(world, structureBoundingBox, 4, -1, 10, 10, -1, 10, (Block)Blocks.redstone_wire, (Block)Blocks.redstone_wire, false);
        this.fillWithBlocks(world, structureBoundingBox, 4, -1, 11, 10, -1, 11, Blocks.dirt, Blocks.dirt, false);
        this.fillWithBlocks(world, structureBoundingBox, 3, -7, 9, 3, -1, 9, Blocks.log, Blocks.log, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 3, -7, 8, 3, -3, 8, Blocks.ladder, this.getMetadataWithOffset(Blocks.ladder, 3), Blocks.ladder, this.getMetadataWithOffset(Blocks.ladder, 3), false);
        this.fillWithAir(world, structureBoundingBox, 3, -2, 8, 3, -1, 8);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.sticky_piston, this.getMetadataWithOffset((Block)Blocks.sticky_piston, 3), 3, -1, 10, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.sticky_piston, this.getMetadataWithOffset((Block)Blocks.sticky_piston, 3), 3, -2, 10, structureBoundingBox);
        this.fillWithBlocks(world, structureBoundingBox, 4, -3, 1, 19, -3, 9, Blocks.stonebrick, Blocks.stonebrick, false);
        this.fillWithAir(world, structureBoundingBox, 3, -7, 7, 3, -6, 7);
        this.fillWithBlocks(world, structureBoundingBox, 1, -8, 4, 3, -8, 8, Blocks.stonebrick, Blocks.stonebrick, false);
        this.fillWithBlocks(world, structureBoundingBox, 4, -8, 4, 4, -8, 6, (Block)Blocks.stone_slab, (Block)Blocks.stone_slab, false);
        this.fillWithAir(world, structureBoundingBox, 1, -7, 4, 4, -5, 6);
        this.fillWithBlocks(world, structureBoundingBox, 5, -9, 3, 5, -9, 7, (Block)Blocks.double_stone_slab, (Block)Blocks.double_stone_slab, false);
        this.fillWithAir(world, structureBoundingBox, 5, -8, 3, 5, -5, 7);
        this.fillWithBlocks(world, structureBoundingBox, 6, -9, 2, 6, -9, 8, (Block)Blocks.stone_slab, (Block)Blocks.stone_slab, false);
        this.fillWithAir(world, structureBoundingBox, 6, -8, 2, 6, -5, 8);
        this.fillWithBlocks(world, structureBoundingBox, 7, -10, 1, 16, -10, 9, Blocks.stonebrick, Blocks.stonebrick, false);
        this.fillWithAir(world, structureBoundingBox, 7, -9, 1, 16, -4, 9);
        this.fillWithBlocks(world, structureBoundingBox, 17, -10, 2, 17, -10, 8, Blocks.stonebrick, Blocks.stonebrick, false);
        this.fillWithAir(world, structureBoundingBox, 17, -9, 2, 17, -4, 8);
        this.fillWithBlocks(world, structureBoundingBox, 18, -10, 3, 18, -10, 7, Blocks.stonebrick, Blocks.stonebrick, false);
        this.fillWithAir(world, structureBoundingBox, 18, -9, 3, 18, -4, 7);
        this.fillWithBlocks(world, structureBoundingBox, 19, -10, 4, 19, -10, 6, Blocks.stonebrick, Blocks.stonebrick, false);
        this.fillWithAir(world, structureBoundingBox, 19, -9, 4, 19, -4, 6);
        this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 1, -7, 5, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.torch, 5, 1, -6, 5, structureBoundingBox);
        this.fillWithBlocks(world, structureBoundingBox, 9, -9, 2, 9, -4, 2, Blocks.cobblestone, Blocks.cobblestone, false);
        this.fillWithBlocks(world, structureBoundingBox, 9, -9, 3, 9, -8, 3, Blocks.fence, Blocks.fence, false);
        this.placeBlockAtCurrentPosition(world, Blocks.torch, 5, 9, -7, 3, structureBoundingBox);
        this.fillWithBlocks(world, structureBoundingBox, 9, -9, 8, 9, -4, 8, Blocks.cobblestone, Blocks.cobblestone, false);
        this.fillWithBlocks(world, structureBoundingBox, 9, -9, 7, 9, -8, 7, Blocks.fence, Blocks.fence, false);
        this.placeBlockAtCurrentPosition(world, Blocks.torch, 5, 9, -7, 7, structureBoundingBox);
        this.fillWithBlocks(world, structureBoundingBox, 12, -9, 2, 12, -4, 2, Blocks.cobblestone, Blocks.cobblestone, false);
        this.fillWithBlocks(world, structureBoundingBox, 12, -9, 3, 12, -8, 3, Blocks.fence, Blocks.fence, false);
        this.placeBlockAtCurrentPosition(world, Blocks.torch, 5, 12, -7, 3, structureBoundingBox);
        this.fillWithBlocks(world, structureBoundingBox, 12, -9, 8, 12, -4, 8, Blocks.cobblestone, Blocks.cobblestone, false);
        this.fillWithBlocks(world, structureBoundingBox, 12, -9, 7, 12, -8, 7, Blocks.fence, Blocks.fence, false);
        this.placeBlockAtCurrentPosition(world, Blocks.torch, 5, 12, -7, 7, structureBoundingBox);
        this.fillWithBlocks(world, structureBoundingBox, 15, -9, 2, 15, -4, 2, Blocks.cobblestone, Blocks.cobblestone, false);
        this.fillWithBlocks(world, structureBoundingBox, 15, -9, 3, 15, -8, 3, Blocks.fence, Blocks.fence, false);
        this.placeBlockAtCurrentPosition(world, Blocks.torch, 5, 15, -7, 3, structureBoundingBox);
        this.fillWithBlocks(world, structureBoundingBox, 15, -9, 8, 15, -4, 8, Blocks.cobblestone, Blocks.cobblestone, false);
        this.fillWithBlocks(world, structureBoundingBox, 15, -9, 7, 15, -8, 7, Blocks.fence, Blocks.fence, false);
        this.placeBlockAtCurrentPosition(world, Blocks.torch, 5, 15, -7, 7, structureBoundingBox);
        this.fillWithBlocks(world, structureBoundingBox, 15, -9, 4, 17, -9, 6, (Block)Blocks.stone_slab, (Block)Blocks.stone_slab, false);
        this.fillWithBlocks(world, structureBoundingBox, 15, -9, 5, 16, -9, 5, (Block)Blocks.double_stone_slab, (Block)Blocks.double_stone_slab, false);
        this.fillWithBlocks(world, structureBoundingBox, 15, -8, 5, 16, -8, 5, (Block)Blocks.stone_slab, (Block)Blocks.stone_slab, false);
        this.fillWithBlocks(world, structureBoundingBox, 19, -9, 5, 19, -8, 5, Blocks.fence, Blocks.fence, false);
        this.placeBlockAtCurrentPosition(world, Blocks.torch, 5, 19, -7, 5, structureBoundingBox);
        this.generateStructureChestContents(world, structureBoundingBox, random, 14, -9, 5, ChestGenTools.getItems("underInnChest", random), ChestGenTools.getCount("underInnChest", random));
        this.spawnEntity(world, structureBoundingBox, 10, -8, 1, 0);
        this.spawnEntity(world, structureBoundingBox, 10, -8, 9, 0);
        this.spawnEntity(world, structureBoundingBox, 13, -8, 1, 0);
        this.spawnEntity(world, structureBoundingBox, 13, -8, 9, 0);
        this.spawnEntity(world, structureBoundingBox, 16, -8, 1, 0);
        this.spawnEntity(world, structureBoundingBox, 16, -8, 9, 0);
        this.spawnEntity(world, structureBoundingBox, 17, -7, 5, 0);
        this.spawnEntity(world, structureBoundingBox, 4, 2, 6, 1);
        this.spawnEntity(world, structureBoundingBox, 7, 2, 6, 2);
        this.spawnEntity(world, structureBoundingBox, 8, 2, 6, 2);
        this.spawnEntity(world, structureBoundingBox, 9, 2, 6, 2);
        this.spawnEntity(world, structureBoundingBox, 16, 2, 3, 3);
        this.spawnEntity(world, structureBoundingBox, 16, 2, 5, 3);
        return false;
    }
    
    @Override
    protected EntityLiving getNewEntity(final World world, final int choice) {
        switch (choice) {
            case 0: {
                return (EntityLiving)new EntityWorshipper(world, false);
            }
            case 1: {
                return (EntityLiving)new EntitySettled(world, EnumVillager.SETTLED_INNKEEPER);
            }
            case 2: {
                return (EntityLiving)new EntitySettled(world, world.rand.nextBoolean() ? EnumVillager.SETTLED_VILLAGER : EnumVillager.SETTLED_FARMER);
            }
            case 3: {
                final EntityHorse entityHorse = new EntityHorse(world);
                entityHorse.setHorseVariant(3 + world.rand.nextInt(4));
                return (EntityLiving)entityHorse;
            }
            default: {
                return null;
            }
        }
    }
    
    static {
        itemsToGenerateInn = new WeightedRandomChestContent[] { new WeightedRandomChestContent((Item)Items.golden_helmet, 0, 1, 5, 10), new WeightedRandomChestContent((Item)Items.golden_boots, 0, 1, 5, 10), new WeightedRandomChestContent(Items.gold_ingot, 0, 2, 9, 15), new WeightedRandomChestContent(Items.golden_sword, 0, 1, 5, 12), new WeightedRandomChestContent((Item)Items.golden_chestplate, 0, 1, 5, 10), new WeightedRandomChestContent(Items.golden_apple, 0, 5, 10, 20), new WeightedRandomChestContent((Item)Items.golden_leggings, 0, 1, 5, 10), new WeightedRandomChestContent(Items.gold_nugget, 0, 10, 10, 20) };
    }
}
