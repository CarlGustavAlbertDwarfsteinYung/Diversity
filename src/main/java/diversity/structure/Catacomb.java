// 
// Decompiled by Procyon v0.5.36
// 

package diversity.structure;

import net.minecraft.item.Item;
import net.minecraft.init.Items;
import diversity.entity.EntityWarriorSkeleton;
import net.minecraft.entity.EntityLiving;
import diversity.utils.ChestGenTools;
import net.minecraft.block.Block;
import diversity.utils.DirectionTools;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.init.Blocks;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.World;
import net.minecraft.nbt.NBTTagCompound;
import java.util.Random;
import net.minecraft.util.WeightedRandomChestContent;

public class Catacomb extends GlobalFeature
{
    private static MossyStones randomMossyStones;
    private static CrackedStones randomCrackedStones;
    private static MossyCobbestones randomMossyCobblestones;
    public static final WeightedRandomChestContent[] itemsToGenerateCatacomb;
    private boolean[] isTrap;
    
    public Catacomb() {
        this.isTrap = new boolean[2];
    }
    
    public Catacomb(final Random random, final int coordX, final int coordZ) {
        super(random, coordX, coordZ, 25, 21, 26);
        (this.isTrap = new boolean[2])[0] = random.nextBoolean();
        this.isTrap[1] = random.nextBoolean();
    }
    
    @Override
    protected void func_143012_a(final NBTTagCompound p_143012_1_) {
        super.func_143012_a(p_143012_1_);
        p_143012_1_.setBoolean("T0", this.isTrap[0]);
        p_143012_1_.setBoolean("T1", this.isTrap[1]);
    }
    
    @Override
    protected void func_143011_b(final NBTTagCompound p_143011_1_) {
        super.func_143011_b(p_143011_1_);
        this.isTrap[0] = p_143011_1_.getBoolean("T0");
        this.isTrap[1] = p_143011_1_.getBoolean("T1");
    }
    
    @Override
    public boolean build(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
        if (!this.func_74935_a(world, structureBoundingBox, -16)) {
            return false;
        }
        this.fillWithBlocks(world, structureBoundingBox, 4, 0, 0, 20, 5, 12, Blocks.stonebrick, Blocks.stonebrick, false);
        this.fillWithBlocks(world, structureBoundingBox, 5, -1, 16, 19, 9, 24, Blocks.stonebrick, Blocks.stonebrick, false);
        for (int x = 10; x < 15; ++x) {
            for (int z = 12; z < 17; ++z) {
                this.clearCurrentPositionBlocksUpwards(world, x, 0, z, structureBoundingBox);
                if ((x == 10 || x == 14) && (z == 12 || z == 16)) {
                    final int y = 2 + random.nextInt(5);
                    this.fillWithRandomizedBlocks(world, structureBoundingBox, x, 0, z, x, y, z, false, random, (StructureComponent.BlockSelector)Catacomb.randomMossyStones);
                    this.fillWithRandomizedBlocks(world, structureBoundingBox, x, y + 1, z, x, 16, z, false, random, (StructureComponent.BlockSelector)Catacomb.randomCrackedStones);
                }
                else {
                    this.fillWithRandomizedBlocks(world, structureBoundingBox, x, 0, z, x, 0, z, false, random, (StructureComponent.BlockSelector)Catacomb.randomMossyCobblestones);
                    this.placeBlockAtCurrentPosition(world, Blocks.water, 0, x, 1, z, structureBoundingBox);
                }
            }
        }
        for (int k = 0; k < 3; ++k) {
            int y = 2 + random.nextInt(5);
            this.fillWithRandomizedBlocks(world, structureBoundingBox, 9, 0, 13 + k, 9, y, 13 + k, false, random, (StructureComponent.BlockSelector)Catacomb.randomMossyStones);
            this.fillWithRandomizedBlocks(world, structureBoundingBox, 9, y + 1, 13 + k, 9, 16, 13 + k, false, random, (StructureComponent.BlockSelector)Catacomb.randomCrackedStones);
            y = 2 + random.nextInt(5);
            this.fillWithRandomizedBlocks(world, structureBoundingBox, 15, 0, 13 + k, 15, y, 13 + k, false, random, (StructureComponent.BlockSelector)Catacomb.randomMossyStones);
            this.fillWithRandomizedBlocks(world, structureBoundingBox, 15, y + 1, 13 + k, 15, 16, 13 + k, false, random, (StructureComponent.BlockSelector)Catacomb.randomCrackedStones);
            y = 2 + random.nextInt(5);
            this.fillWithRandomizedBlocks(world, structureBoundingBox, 11 + k, 0, 11, 11 + k, y, 11, false, random, (StructureComponent.BlockSelector)Catacomb.randomMossyStones);
            this.fillWithRandomizedBlocks(world, structureBoundingBox, 11 + k, y + 1, 11, 11 + k, 16, 11, false, random, (StructureComponent.BlockSelector)Catacomb.randomCrackedStones);
            y = 2 + random.nextInt(5);
            this.fillWithRandomizedBlocks(world, structureBoundingBox, 11 + k, 0, 17, 11 + k, y, 17, false, random, (StructureComponent.BlockSelector)Catacomb.randomMossyStones);
            this.fillWithRandomizedBlocks(world, structureBoundingBox, 11 + k, y + 1, 17, 11 + k, 16, 17, false, random, (StructureComponent.BlockSelector)Catacomb.randomCrackedStones);
        }
        for (int y = 17; y < 19; ++y) {
            this.placeBlockAtCurrentPosition(world, Blocks.cobblestone_wall, 0, 9, y, 13, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.cobblestone_wall, 0, 9, y, 15, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.cobblestone_wall, 0, 10, y, 16, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.cobblestone_wall, 0, 10, y, 12, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.cobblestone_wall, 0, 15, y, 13, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.cobblestone_wall, 0, 15, y, 15, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.cobblestone_wall, 0, 14, y, 16, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.cobblestone_wall, 0, 14, y, 12, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.cobblestone_wall, 0, 11, y, 11, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.cobblestone_wall, 0, 13, y, 11, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.cobblestone_wall, 0, 11, y, 17, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, Blocks.cobblestone_wall, 0, 13, y, 17, structureBoundingBox);
        }
        this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, DirectionTools.stair[this.coordBaseMode][0], 11, 19, 16, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, DirectionTools.stair[this.coordBaseMode][0], 10, 19, 15, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, DirectionTools.stair[this.coordBaseMode][0], 9, 19, 14, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, DirectionTools.stair[this.coordBaseMode][0], 10, 19, 13, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, DirectionTools.stair[this.coordBaseMode][0], 11, 19, 12, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, DirectionTools.stair[this.coordBaseMode][3], 9, 19, 13, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, DirectionTools.stair[this.coordBaseMode][3], 10, 19, 12, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, DirectionTools.stair[this.coordBaseMode][3], 11, 19, 11, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, DirectionTools.stair[this.coordBaseMode][3], 12, 19, 11, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, DirectionTools.stair[this.coordBaseMode][3], 13, 19, 11, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, DirectionTools.stair[this.coordBaseMode][3], 14, 19, 12, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, DirectionTools.stair[this.coordBaseMode][3], 15, 19, 13, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, DirectionTools.stair[this.coordBaseMode][1], 13, 19, 16, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, DirectionTools.stair[this.coordBaseMode][1], 14, 19, 15, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, DirectionTools.stair[this.coordBaseMode][1], 15, 19, 14, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, DirectionTools.stair[this.coordBaseMode][1], 14, 19, 13, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, DirectionTools.stair[this.coordBaseMode][1], 13, 19, 12, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, DirectionTools.stair[this.coordBaseMode][2], 9, 19, 15, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, DirectionTools.stair[this.coordBaseMode][2], 10, 19, 16, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, DirectionTools.stair[this.coordBaseMode][2], 11, 19, 17, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, DirectionTools.stair[this.coordBaseMode][2], 12, 19, 17, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, DirectionTools.stair[this.coordBaseMode][2], 13, 19, 17, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, DirectionTools.stair[this.coordBaseMode][2], 14, 19, 16, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, DirectionTools.stair[this.coordBaseMode][2], 15, 19, 15, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 10, 20, 14, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 11, 20, 15, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 12, 20, 16, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 13, 20, 15, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 14, 20, 14, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 13, 20, 13, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 12, 20, 12, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 5, 11, 20, 13, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, DirectionTools.stair[this.coordBaseMode][0], 11, 20, 14, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, DirectionTools.stair[this.coordBaseMode][2], 12, 20, 15, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, DirectionTools.stair[this.coordBaseMode][1], 13, 20, 14, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, DirectionTools.stair[this.coordBaseMode][3], 12, 20, 13, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 0, 12, 20, 14, structureBoundingBox);
        this.fillWithRandomizedBlocks(world, structureBoundingBox, 0, 0, 8, 4, 0, 20, false, random, (StructureComponent.BlockSelector)Catacomb.randomMossyCobblestones);
        this.fillWithRandomizedBlocks(world, structureBoundingBox, 0, 1, 8, 4, 1, 20, false, random, (StructureComponent.BlockSelector)Catacomb.randomMossyStones);
        this.fillWithRandomizedBlocks(world, structureBoundingBox, 0, 2, 8, 4, 4, 20, false, random, (StructureComponent.BlockSelector)Catacomb.randomCrackedStones);
        this.fillWithAir(world, structureBoundingBox, 1, 2, 10, 3, 3, 18);
        this.fillWithBlocks(world, structureBoundingBox, 2, 1, 10, 2, 1, 18, Blocks.water, Blocks.water, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 1, 3, 10, 1, 3, 18, Blocks.stone_brick_stairs, DirectionTools.reversed_stairs[this.coordBaseMode][1], Blocks.stone_stairs, DirectionTools.reversed_stairs[this.coordBaseMode][1], false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 3, 3, 10, 3, 3, 18, Blocks.stone_brick_stairs, DirectionTools.reversed_stairs[this.coordBaseMode][0], Blocks.stone_stairs, DirectionTools.reversed_stairs[this.coordBaseMode][0], false);
        this.spawnEntity(world, structureBoundingBox, 2, 1, 10, 0);
        this.spawnEntity(world, structureBoundingBox, 2, 1, 18, 0);
        this.fillWithRandomizedBlocks(world, structureBoundingBox, 20, 0, 8, 24, 0, 20, false, random, (StructureComponent.BlockSelector)Catacomb.randomMossyCobblestones);
        this.fillWithRandomizedBlocks(world, structureBoundingBox, 20, 1, 8, 24, 1, 20, false, random, (StructureComponent.BlockSelector)Catacomb.randomMossyStones);
        this.fillWithRandomizedBlocks(world, structureBoundingBox, 20, 2, 8, 24, 4, 20, false, random, (StructureComponent.BlockSelector)Catacomb.randomCrackedStones);
        this.fillWithAir(world, structureBoundingBox, 21, 2, 10, 23, 3, 18);
        this.fillWithBlocks(world, structureBoundingBox, 22, 1, 10, 22, 1, 18, Blocks.water, Blocks.water, false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 21, 3, 10, 21, 3, 18, Blocks.stone_brick_stairs, DirectionTools.reversed_stairs[this.coordBaseMode][1], Blocks.stone_stairs, DirectionTools.reversed_stairs[this.coordBaseMode][1], false);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 23, 3, 10, 23, 3, 18, Blocks.stone_brick_stairs, DirectionTools.reversed_stairs[this.coordBaseMode][0], Blocks.stone_stairs, DirectionTools.reversed_stairs[this.coordBaseMode][0], false);
        this.spawnEntity(world, structureBoundingBox, 22, 1, 10, 0);
        this.spawnEntity(world, structureBoundingBox, 22, 1, 18, 0);
        this.fillWithRandomizedBlocks(world, structureBoundingBox, 5, 0, 13, 9, 0, 15, false, random, (StructureComponent.BlockSelector)Catacomb.randomMossyCobblestones);
        this.fillWithRandomizedBlocks(world, structureBoundingBox, 5, 1, 13, 9, 1, 15, false, random, (StructureComponent.BlockSelector)Catacomb.randomMossyStones);
        this.fillWithRandomizedBlocks(world, structureBoundingBox, 5, 2, 13, 9, 3, 15, false, random, (StructureComponent.BlockSelector)Catacomb.randomCrackedStones);
        this.fillWithAir(world, structureBoundingBox, 4, 2, 14, 9, 2, 14);
        this.fillWithBlocks(world, structureBoundingBox, 3, 1, 14, 9, 1, 14, Blocks.water, Blocks.water, false);
        this.fillWithRandomizedBlocks(world, structureBoundingBox, 15, 0, 13, 19, 0, 15, false, random, (StructureComponent.BlockSelector)Catacomb.randomMossyCobblestones);
        this.fillWithRandomizedBlocks(world, structureBoundingBox, 15, 1, 13, 19, 1, 15, false, random, (StructureComponent.BlockSelector)Catacomb.randomMossyStones);
        this.fillWithRandomizedBlocks(world, structureBoundingBox, 15, 2, 13, 19, 3, 15, false, random, (StructureComponent.BlockSelector)Catacomb.randomCrackedStones);
        this.fillWithAir(world, structureBoundingBox, 15, 2, 14, 20, 2, 14);
        this.fillWithBlocks(world, structureBoundingBox, 15, 1, 14, 21, 1, 14, Blocks.water, Blocks.water, false);
        this.fillWithRandomizedBlocks(world, structureBoundingBox, 11, 0, 18, 13, 0, 25, false, random, (StructureComponent.BlockSelector)Catacomb.randomMossyCobblestones);
        this.fillWithRandomizedBlocks(world, structureBoundingBox, 11, 1, 18, 13, 1, 25, false, random, (StructureComponent.BlockSelector)Catacomb.randomMossyStones);
        this.fillWithRandomizedBlocks(world, structureBoundingBox, 11, 2, 18, 13, 3, 25, false, random, (StructureComponent.BlockSelector)Catacomb.randomCrackedStones);
        this.fillWithAir(world, structureBoundingBox, 12, 2, 17, 12, 2, 23);
        this.fillWithBlocks(world, structureBoundingBox, 12, 1, 17, 12, 1, 23, Blocks.water, Blocks.water, false);
        this.fillWithAir(world, structureBoundingBox, 11, 2, 23, 13, 2, 23);
        this.fillWithBlocks(world, structureBoundingBox, 11, 1, 23, 13, 1, 23, Blocks.water, Blocks.water, false);
        this.fillWithRandomizedBlocks(world, structureBoundingBox, 6, 0, 20, 10, 0, 25, false, random, (StructureComponent.BlockSelector)Catacomb.randomMossyCobblestones);
        this.fillWithRandomizedBlocks(world, structureBoundingBox, 6, 1, 20, 10, 4, 25, false, random, (StructureComponent.BlockSelector)Catacomb.randomMossyStones);
        this.fillWithAir(world, structureBoundingBox, 7, 2, 22, 9, 3, 23);
        this.fillWithBlocks(world, structureBoundingBox, 7, 1, 22, 9, 1, 23, Blocks.water, Blocks.water, false);
        this.fillWithAir(world, structureBoundingBox, 10, 1, 22, 10, 2, 22);
        this.fillWithRandomizedBlocks(world, structureBoundingBox, 14, 0, 20, 18, 0, 25, false, random, (StructureComponent.BlockSelector)Catacomb.randomMossyCobblestones);
        this.fillWithRandomizedBlocks(world, structureBoundingBox, 14, 1, 20, 18, 4, 25, false, random, (StructureComponent.BlockSelector)Catacomb.randomMossyStones);
        this.fillWithAir(world, structureBoundingBox, 15, 2, 22, 17, 3, 23);
        this.fillWithBlocks(world, structureBoundingBox, 15, 1, 22, 17, 1, 23, Blocks.water, Blocks.water, false);
        this.fillWithAir(world, structureBoundingBox, 14, 1, 22, 14, 2, 22);
        this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 12, 2, 11, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.water, 0, 12, 1, 11, structureBoundingBox);
        this.fillWithRandomizedBlocks(world, structureBoundingBox, 10, 0, 6, 14, 0, 10, false, random, (StructureComponent.BlockSelector)Catacomb.randomMossyCobblestones);
        this.fillWithBlocks(world, structureBoundingBox, 10, 1, 6, 14, 1, 10, Blocks.water, Blocks.water, false);
        this.fillWithAir(world, structureBoundingBox, 10, 2, 6, 14, 3, 10);
        this.fillWithRandomizedBlocks(world, structureBoundingBox, 10, 4, 6, 14, 4, 10, false, random, (StructureComponent.BlockSelector)Catacomb.randomCrackedStones);
        this.fillWithRandomizedBlocks(world, structureBoundingBox, 10, 1, 6, 10, 1, 6, false, random, (StructureComponent.BlockSelector)Catacomb.randomMossyStones);
        this.fillWithRandomizedBlocks(world, structureBoundingBox, 10, 2, 6, 10, 3, 6, false, random, (StructureComponent.BlockSelector)Catacomb.randomCrackedStones);
        this.fillWithRandomizedBlocks(world, structureBoundingBox, 10, 1, 10, 10, 1, 10, false, random, (StructureComponent.BlockSelector)Catacomb.randomMossyStones);
        this.fillWithRandomizedBlocks(world, structureBoundingBox, 10, 2, 10, 10, 3, 10, false, random, (StructureComponent.BlockSelector)Catacomb.randomCrackedStones);
        this.fillWithRandomizedBlocks(world, structureBoundingBox, 14, 1, 6, 14, 1, 6, false, random, (StructureComponent.BlockSelector)Catacomb.randomMossyStones);
        this.fillWithRandomizedBlocks(world, structureBoundingBox, 14, 2, 6, 14, 3, 6, false, random, (StructureComponent.BlockSelector)Catacomb.randomCrackedStones);
        this.fillWithRandomizedBlocks(world, structureBoundingBox, 14, 1, 10, 14, 1, 10, false, random, (StructureComponent.BlockSelector)Catacomb.randomMossyStones);
        this.fillWithRandomizedBlocks(world, structureBoundingBox, 14, 2, 10, 14, 3, 10, false, random, (StructureComponent.BlockSelector)Catacomb.randomCrackedStones);
        this.fillWithRandomizedBlocks(world, structureBoundingBox, 15, 0, 6, 18, 0, 9, false, random, (StructureComponent.BlockSelector)Catacomb.randomMossyCobblestones);
        this.fillWithRandomizedBlocks(world, structureBoundingBox, 15, 1, 6, 18, 1, 9, false, random, (StructureComponent.BlockSelector)Catacomb.randomMossyStones);
        this.fillWithRandomizedBlocks(world, structureBoundingBox, 15, 2, 6, 18, 3, 9, false, random, (StructureComponent.BlockSelector)Catacomb.randomCrackedStones);
        this.fillWithAir(world, structureBoundingBox, 15, 2, 8, 15, 2, 8);
        this.fillWithAir(world, structureBoundingBox, 17, 2, 8, 17, 2, 8);
        this.fillWithBlocks(world, structureBoundingBox, 15, 1, 8, 15, 1, 8, Blocks.water, Blocks.water, false);
        this.fillWithBlocks(world, structureBoundingBox, 17, 1, 8, 17, 1, 8, Blocks.water, Blocks.water, false);
        this.fillWithAir(world, structureBoundingBox, 16, 1, 9, 16, 2, 9);
        this.fillWithRandomizedBlocks(world, structureBoundingBox, 6, 0, 6, 9, 0, 9, false, random, (StructureComponent.BlockSelector)Catacomb.randomMossyCobblestones);
        this.fillWithRandomizedBlocks(world, structureBoundingBox, 6, 1, 6, 9, 1, 9, false, random, (StructureComponent.BlockSelector)Catacomb.randomMossyStones);
        this.fillWithRandomizedBlocks(world, structureBoundingBox, 6, 2, 6, 9, 3, 9, false, random, (StructureComponent.BlockSelector)Catacomb.randomCrackedStones);
        this.fillWithAir(world, structureBoundingBox, 7, 2, 8, 7, 2, 8);
        this.fillWithAir(world, structureBoundingBox, 9, 2, 8, 9, 2, 8);
        this.fillWithBlocks(world, structureBoundingBox, 7, 1, 8, 7, 1, 8, Blocks.water, Blocks.water, false);
        this.fillWithBlocks(world, structureBoundingBox, 9, 1, 8, 9, 1, 8, Blocks.water, Blocks.water, false);
        this.fillWithAir(world, structureBoundingBox, 8, 1, 9, 8, 2, 9);
        this.fillWithRandomizedBlocks(world, structureBoundingBox, 10, 0, 3, 14, 0, 5, false, random, (StructureComponent.BlockSelector)Catacomb.randomMossyCobblestones);
        this.fillWithRandomizedBlocks(world, structureBoundingBox, 10, 1, 3, 14, 1, 5, false, random, (StructureComponent.BlockSelector)Catacomb.randomMossyStones);
        this.fillWithRandomizedBlocks(world, structureBoundingBox, 10, 2, 3, 14, 3, 5, false, random, (StructureComponent.BlockSelector)Catacomb.randomCrackedStones);
        this.placeBlockAtCurrentPosition(world, Blocks.water, 0, 12, 1, 5, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 12, 2, 5, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 12, 2, 4, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 13, 12, 3, 3, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.torch, 5, 11, 2, 4, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.torch, 5, 13, 2, 4, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.lever, 6, 2, 2, 19, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 3, 1, 19, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 4, 1, 19, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.redstone_torch, DirectionTools.torch[this.coordBaseMode][1], 4, 0, 19, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 5, 0, 19, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 6, 0, 19, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 7, 0, 19, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 8, 0, 19, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 8, 1, 19, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 9, 1, 19, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 9, 2, 19, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 10, 2, 19, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.sticky_piston, this.getMetadataWithOffset((Block)Blocks.sticky_piston, 2), 10, 1, 21, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.sticky_piston, this.getMetadataWithOffset((Block)Blocks.sticky_piston, 2), 10, 2, 21, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.powered_repeater, this.getMetadataWithOffset((Block)Blocks.powered_repeater, 0), 10, 2, 20, structureBoundingBox);
        this.spawnEntity(world, structureBoundingBox, 8, 1, 22, 0);
        this.placeBlockAtCurrentPosition(world, Blocks.lever, 6, 22, 2, 19, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 21, 1, 19, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 20, 1, 19, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.redstone_torch, DirectionTools.torch[this.coordBaseMode][0], 20, 0, 19, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 19, 0, 19, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 18, 0, 19, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 17, 0, 19, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 16, 1, 19, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 16, 0, 19, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 15, 1, 19, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 15, 2, 19, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 14, 2, 19, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.sticky_piston, this.getMetadataWithOffset((Block)Blocks.sticky_piston, 2), 14, 1, 21, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.sticky_piston, this.getMetadataWithOffset((Block)Blocks.sticky_piston, 2), 14, 2, 21, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.powered_repeater, this.getMetadataWithOffset((Block)Blocks.powered_repeater, 0), 14, 2, 20, structureBoundingBox);
        this.spawnEntity(world, structureBoundingBox, 16, 1, 22, 0);
        this.placeBlockAtCurrentPosition(world, Blocks.iron_bars, 0, 12, 2, 24, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.iron_bars, 0, 16, 2, 15, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.iron_bars, 0, 16, 2, 13, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.iron_bars, 0, 19, 2, 15, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.iron_bars, 0, 19, 2, 13, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.iron_bars, 0, 8, 2, 15, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.iron_bars, 0, 8, 2, 13, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.iron_bars, 0, 5, 2, 15, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.iron_bars, 0, 5, 2, 13, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 13, 8, 3, 21, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 13, 16, 3, 21, structureBoundingBox);
        if (this.isTrap[0]) {
            this.generateStructureTrappedChestContents(world, structureBoundingBox, random, 16, 2, 21, ChestGenTools.getItems("catacombChest", random), ChestGenTools.getCount("catacombChest", random));
        }
        else {
            this.generateStructureChestContents(world, structureBoundingBox, random, 16, 2, 21, ChestGenTools.getItems("catacombChest", random), ChestGenTools.getCount("catacombChest", random));
        }
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 16, 2, 20, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 13, 16, 1, 19, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.unpowered_repeater, this.getMetadataWithOffset((Block)Blocks.unpowered_repeater, 2), 16, 2, 19, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 16, 2, 18, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 17, 2, 18, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 17, 2, 19, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 17, 2, 20, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.unpowered_repeater, this.getMetadataWithOffset((Block)Blocks.unpowered_repeater, 3), 15, 2, 18, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 14, 2, 18, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 16, 3, 18, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 16, 3, 17, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 13, 16, 4, 17, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 17, 4, 17, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 17, 5, 17, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 16, 5, 17, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 16, 6, 17, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 16, 6, 18, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 16, 6, 19, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.redstone_torch, 5, 16, 7, 20, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 16, 7, 21, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 16, 8, 21, structureBoundingBox);
        this.fillWithBlocks(world, structureBoundingBox, 15, 8, 22, 17, 8, 23, (Block)Blocks.redstone_wire, (Block)Blocks.redstone_wire, false);
        this.fillWithAir(world, structureBoundingBox, 15, 5, 22, 17, 5, 23);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 15, 6, 22, 17, 6, 23, (Block)Blocks.sticky_piston, 0, (Block)Blocks.sticky_piston, 0, false);
        this.fillWithBlocks(world, structureBoundingBox, 14, 4, 22, 14, 4, 22, Blocks.water, Blocks.water, false);
        this.fillWithBlocks(world, structureBoundingBox, 18, 4, 22, 18, 4, 23, Blocks.water, Blocks.water, false);
        this.fillWithBlocks(world, structureBoundingBox, 15, 4, 21, 17, 4, 21, Blocks.water, Blocks.water, false);
        this.fillWithBlocks(world, structureBoundingBox, 15, 4, 24, 17, 4, 24, Blocks.water, Blocks.water, false);
        if (this.isTrap[1]) {
            this.generateStructureTrappedChestContents(world, structureBoundingBox, random, 8, 2, 21, ChestGenTools.getItems("catacombChest", random), ChestGenTools.getCount("catacombChest", random));
        }
        else {
            this.generateStructureChestContents(world, structureBoundingBox, random, 8, 2, 21, ChestGenTools.getItems("catacombChest", random), ChestGenTools.getCount("catacombChest", random));
        }
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 8, 2, 20, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 13, 8, 1, 19, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.unpowered_repeater, this.getMetadataWithOffset((Block)Blocks.unpowered_repeater, 2), 8, 2, 19, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 8, 2, 18, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 7, 2, 18, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 7, 2, 19, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 7, 2, 20, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.unpowered_repeater, this.getMetadataWithOffset((Block)Blocks.unpowered_repeater, 1), 9, 2, 18, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 10, 2, 18, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 8, 3, 18, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 8, 3, 17, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 13, 8, 4, 17, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 7, 4, 17, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 7, 5, 17, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 8, 5, 17, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 8, 6, 17, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 8, 6, 18, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 8, 6, 19, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.redstone_torch, 5, 8, 7, 20, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 8, 7, 21, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 8, 8, 21, structureBoundingBox);
        this.fillWithBlocks(world, structureBoundingBox, 7, 8, 22, 9, 8, 23, (Block)Blocks.redstone_wire, (Block)Blocks.redstone_wire, false);
        this.fillWithAir(world, structureBoundingBox, 7, 5, 22, 9, 5, 23);
        this.fillWithMetadataBlocks(world, structureBoundingBox, 7, 6, 22, 9, 6, 23, (Block)Blocks.sticky_piston, 0, (Block)Blocks.sticky_piston, 0, false);
        this.fillWithBlocks(world, structureBoundingBox, 6, 4, 22, 6, 4, 23, Blocks.water, Blocks.water, false);
        this.fillWithBlocks(world, structureBoundingBox, 10, 4, 22, 10, 4, 22, Blocks.water, Blocks.water, false);
        this.fillWithBlocks(world, structureBoundingBox, 7, 4, 21, 9, 4, 21, Blocks.water, Blocks.water, false);
        this.fillWithBlocks(world, structureBoundingBox, 7, 4, 24, 9, 4, 24, Blocks.water, Blocks.water, false);
        this.placeBlockAtCurrentPosition(world, Blocks.lever, 6, 22, 2, 9, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.redstone_torch, DirectionTools.torch[this.coordBaseMode][0], 21, 1, 9, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 20, 1, 9, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 20, 2, 9, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 19, 3, 9, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 19, 4, 8, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 19, 2, 9, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 19, 2, 10, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 18, 2, 10, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 19, 3, 8, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 19, 4, 7, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 19, 4, 6, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 19, 4, 5, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 19, 4, 4, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 18, 4, 4, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 17, 4, 4, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 16, 4, 4, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 15, 4, 4, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 14, 4, 4, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 13, 4, 4, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.lever, 6, 2, 2, 9, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.redstone_torch, DirectionTools.torch[this.coordBaseMode][1], 3, 1, 9, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 4, 1, 9, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 4, 2, 9, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 5, 3, 9, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 5, 4, 8, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 5, 2, 9, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 5, 2, 10, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 6, 2, 10, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 5, 3, 8, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 5, 4, 7, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 5, 4, 6, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 5, 4, 5, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 5, 4, 4, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 6, 4, 4, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 7, 4, 4, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 8, 4, 4, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 9, 4, 4, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 10, 4, 4, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 11, 4, 4, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.sticky_piston, this.getMetadataWithOffset((Block)Blocks.sticky_piston, 3), 16, 1, 10, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.sticky_piston, this.getMetadataWithOffset((Block)Blocks.sticky_piston, 3), 16, 2, 10, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 5, 17, 2, 10, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.sticky_piston, this.getMetadataWithOffset((Block)Blocks.sticky_piston, 3), 8, 1, 10, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.sticky_piston, this.getMetadataWithOffset((Block)Blocks.sticky_piston, 3), 8, 2, 10, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 5, 7, 2, 10, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.sticky_piston, 0, 12, 4, 4, structureBoundingBox);
        this.generateStructureTrappedChestContents(world, structureBoundingBox, random, 12, 2, 3, ChestGenTools.getItems("catacombChest", random), ChestGenTools.getCount("catacombChest", random));
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.unpowered_repeater, this.getMetadataWithOffset((Block)Blocks.unpowered_repeater, 2), 12, 2, 2, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 12, 2, 1, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 13, 2, 1, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 14, 2, 1, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 14, 2, 2, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 14, 2, 3, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 15, 2, 3, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 16, 2, 3, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 17, 2, 3, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 15, 2, 4, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.unpowered_repeater, this.getMetadataWithOffset((Block)Blocks.unpowered_repeater, 3), 16, 2, 4, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 17, 2, 4, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 18, 2, 4, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 18, 3, 5, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 18, 2, 5, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 18, 4, 6, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.redstone_torch, 5, 18, 3, 6, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 17, 3, 6, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 15, 1, 6, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 15, 2, 6, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 15, 3, 6, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.sticky_piston, this.getMetadataWithOffset((Block)Blocks.sticky_piston, 4), 16, 1, 6, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.sticky_piston, this.getMetadataWithOffset((Block)Blocks.sticky_piston, 4), 16, 2, 6, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.sticky_piston, this.getMetadataWithOffset((Block)Blocks.sticky_piston, 4), 16, 3, 6, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 14, 2, 5, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 14, 3, 5, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 11, 2, 1, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 10, 2, 1, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 10, 2, 2, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 10, 2, 3, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 9, 2, 3, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 8, 2, 3, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 7, 2, 3, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 9, 2, 4, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.unpowered_repeater, this.getMetadataWithOffset((Block)Blocks.unpowered_repeater, 1), 8, 2, 4, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 7, 2, 4, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 6, 2, 4, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 6, 3, 5, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 6, 2, 5, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 6, 4, 6, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.redstone_torch, 5, 6, 3, 6, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.redstone_wire, 0, 7, 3, 6, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 9, 1, 6, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 9, 2, 6, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 9, 3, 6, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.sticky_piston, this.getMetadataWithOffset((Block)Blocks.sticky_piston, 5), 8, 1, 6, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.sticky_piston, this.getMetadataWithOffset((Block)Blocks.sticky_piston, 5), 8, 2, 6, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.sticky_piston, this.getMetadataWithOffset((Block)Blocks.sticky_piston, 5), 8, 3, 6, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 10, 2, 5, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 10, 3, 5, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.cobblestone, 0, 12, 1, 8, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Blocks.cobblestone, 0, 12, 1, 7, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 0, 12, 2, 8, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, (Block)Blocks.stone_slab, 0, 12, 2, 7, structureBoundingBox);
        this.spawnEntity(world, structureBoundingBox, 17, 1, 8, 0);
        this.spawnEntity(world, structureBoundingBox, 7, 1, 8, 0);
        this.spawnEntity(world, structureBoundingBox, 10, 2, 5, 0);
        this.spawnEntity(world, structureBoundingBox, 14, 2, 5, 0);
        this.spawnEntity(world, structureBoundingBox, 12, 1, 14, 0);
        return false;
    }
    
    @Override
    protected boolean func_74935_a(final World p_74935_1_, final StructureBoundingBox p_74935_2_, final int p_74935_3_) {
        if (this.field_74936_d >= 0) {
            return true;
        }
        int j = 0;
        int k = 0;
        for (int l = this.boundingBox.minZ; l <= this.boundingBox.maxZ; ++l) {
            for (int i1 = this.boundingBox.minX; i1 <= this.boundingBox.maxX; ++i1) {
                if (p_74935_2_.isVecInside(i1, 64, l)) {
                    j += Math.max(p_74935_1_.getTopSolidOrLiquidBlock(i1, l), p_74935_1_.provider.getAverageGroundLevel());
                    ++k;
                }
            }
        }
        if (k == 0) {
            return false;
        }
        this.field_74936_d = j / k;
        this.boundingBox.offset(0, this.field_74936_d - this.boundingBox.minY + p_74935_3_, 0);
        return true;
    }
    
    @Override
    protected EntityLiving getNewEntity(final World world, final int choice) {
        return (EntityLiving)new EntityWarriorSkeleton(world, false);
    }
    
    static {
        Catacomb.randomMossyStones = new MossyStones(null);
        Catacomb.randomCrackedStones = new CrackedStones(null);
        Catacomb.randomMossyCobblestones = new MossyCobbestones(null);
        itemsToGenerateCatacomb = new WeightedRandomChestContent[] { new WeightedRandomChestContent(Items.diamond, 0, 1, 3, 3), new WeightedRandomChestContent(Items.iron_ingot, 0, 1, 5, 10), new WeightedRandomChestContent(Items.gold_ingot, 0, 2, 7, 15), new WeightedRandomChestContent(Items.emerald, 0, 1, 3, 2), new WeightedRandomChestContent(Items.bone, 0, 4, 6, 20), new WeightedRandomChestContent(Items.rotten_flesh, 0, 3, 7, 16), new WeightedRandomChestContent(Items.spider_eye, 0, 1, 1, 3), new WeightedRandomChestContent(Items.ender_eye, 0, 1, 1, 1), new WeightedRandomChestContent(Items.experience_bottle, 0, 1, 1, 1), new WeightedRandomChestContent((Item)Items.chainmail_helmet, 0, 1, 1, 1), new WeightedRandomChestContent((Item)Items.chainmail_chestplate, 0, 1, 1, 1), new WeightedRandomChestContent((Item)Items.chainmail_leggings, 0, 1, 1, 1), new WeightedRandomChestContent((Item)Items.chainmail_boots, 0, 1, 1, 1) };
    }
    
    static class MossyStones extends StructureComponent.BlockSelector
    {
        private MossyStones() {
        }
        
        @Override
        public void selectBlocks(final Random p_75062_1_, final int p_75062_2_, final int p_75062_3_, final int p_75062_4_, final boolean p_75062_5_) {
            this.field_151562_a = Blocks.stonebrick;
            if (p_75062_1_.nextFloat() < 0.4f) {
                this.selectedBlockMetaData = 0;
            }
            else {
                this.selectedBlockMetaData = 1;
            }
        }
        
        MossyStones(final Object p_i2063_1_) {
            this();
        }
    }
    
    static class CrackedStones extends StructureComponent.BlockSelector
    {
        private CrackedStones() {
        }
        
        @Override
        public void selectBlocks(final Random p_75062_1_, final int p_75062_2_, final int p_75062_3_, final int p_75062_4_, final boolean p_75062_5_) {
            this.field_151562_a = Blocks.stonebrick;
            if (p_75062_1_.nextFloat() < 0.4f) {
                this.selectedBlockMetaData = 0;
            }
            else {
                this.selectedBlockMetaData = 2;
            }
        }
        
        CrackedStones(final Object p_i2063_1_) {
            this();
        }
    }
    
    static class MossyCobbestones extends StructureComponent.BlockSelector
    {
        private MossyCobbestones() {
        }
        
        @Override
        public void selectBlocks(final Random p_75062_1_, final int p_75062_2_, final int p_75062_3_, final int p_75062_4_, final boolean p_75062_5_) {
            if (p_75062_1_.nextFloat() < 0.4f) {
                this.field_151562_a = Blocks.cobblestone;
            }
            else {
                this.field_151562_a = Blocks.mossy_cobblestone;
            }
        }
        
        MossyCobbestones(final Object p_i2063_1_) {
            this();
        }
    }
}
