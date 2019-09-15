// 
// Decompiled by Procyon v0.5.36
// 

package diversity.world;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import diversity.suppliers.EnumBlock;
import net.minecraft.world.IBlockAccess;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenBlueMushroom extends WorldGenerator
{
    @Override
    public boolean generate(final World world, final Random random, final int x, final int y, final int z) {
        final int i1 = random.nextInt(2) + 4;
        boolean flag = true;
        if (y < 1 || y + i1 + 1 >= 256) {
            return false;
        }
        for (int tempY = y; tempY <= y + 1 + i1; ++tempY) {
            byte b0 = 3;
            if (tempY <= y + 2) {
                b0 = 0;
            }
            for (int tempX = x - b0; tempX <= x + b0 && flag; ++tempX) {
                for (int tempZ = z - b0; tempZ <= z + b0 && flag; ++tempZ) {
                    if (tempY >= 0 && tempY < 256) {
                        final Block block = world.getBlock(tempX, tempY, tempZ);
                        if (!block.isAir((IBlockAccess)world, tempX, tempY, tempZ) && !block.isLeaves((IBlockAccess)world, tempX, tempY, tempZ)) {
                            flag = false;
                        }
                    }
                    else {
                        flag = false;
                    }
                }
            }
        }
        if (!flag) {
            return false;
        }
        Block block = world.getBlock(x, y - 1, z);
        if (!block.equals(EnumBlock.fungal.block) && block != Blocks.dirt) {
            return false;
        }
        int tempY;
        for (int j2 = tempY = y + i1 - 3; tempY <= y + i1; ++tempY) {
            int temp = 1;
            if (tempY < y + i1) {
                ++temp;
            }
            for (int tempX = x - temp; tempX <= x + temp; ++tempX) {
                for (int tempZ = z - temp; tempZ <= z + temp; ++tempZ) {
                    int l2 = 5;
                    if (tempX == x - temp) {
                        --l2;
                    }
                    if (tempX == x + temp) {
                        ++l2;
                    }
                    if (tempZ == z - temp) {
                        l2 -= 3;
                    }
                    if (tempZ == z + temp) {
                        l2 += 3;
                    }
                    if (tempY < y + i1) {
                        if (tempX == x - temp || tempX == x + temp) {
                            if (tempZ == z - temp) {
                                continue;
                            }
                            if (tempZ == z + temp) {
                                continue;
                            }
                        }
                        if (tempX == x - (temp - 1) && tempZ == z - temp) {
                            l2 = 1;
                        }
                        if (tempX == x - temp && tempZ == z - (temp - 1)) {
                            l2 = 1;
                        }
                        if (tempX == x + (temp - 1) && tempZ == z - temp) {
                            l2 = 3;
                        }
                        if (tempX == x + temp && tempZ == z - (temp - 1)) {
                            l2 = 3;
                        }
                        if (tempX == x - (temp - 1) && tempZ == z + temp) {
                            l2 = 7;
                        }
                        if (tempX == x - temp && tempZ == z + (temp - 1)) {
                            l2 = 7;
                        }
                        if (tempX == x + (temp - 1) && tempZ == z + temp) {
                            l2 = 9;
                        }
                        if (tempX == x + temp && tempZ == z + (temp - 1)) {
                            l2 = 9;
                        }
                    }
                    if (l2 == 5 && tempY < y + i1) {
                        l2 = 0;
                    }
                    block = world.getBlock(tempX, tempY, tempZ);
                    if ((l2 != 0 || y >= y + i1 - 1) && block.canBeReplacedByLeaves((IBlockAccess)world, tempX, tempY, tempZ)) {
                        this.setBlockAndNotifyAdequately(world, tempX, tempY, tempZ, EnumBlock.blue_mushroom_cap.block, l2);
                    }
                }
            }
        }
        for (tempY = 0; tempY < i1; ++tempY) {
            block = world.getBlock(x, y + tempY, z);
            if (block.canBeReplacedByLeaves((IBlockAccess)world, x, y + tempY, z)) {
                this.setBlockAndNotifyAdequately(world, x, y + tempY, z, EnumBlock.blue_mushroom_cap.block, 10);
            }
        }
        return true;
    }
}
