// 
// Decompiled by Procyon v0.5.36
// 

package diversity.world;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import diversity.suppliers.EnumBlock;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenPhosMushroom extends WorldGenerator
{
    private final int radius = 5;
    
    @Override
    public boolean generate(final World world, final Random random, final int x, final int y, final int z) {
        final int b = random.nextInt(6);
        final int j = b + 15;
        if (this.canGenerate(world, random, x, y, z, j)) {
            this.generateMushroomCap(world, random, x, y, z, j);
            for (int height = 0; height <= j - 5; ++height) {
                for (int iwidth = 0; iwidth <= 1; ++iwidth) {
                    for (int kwidth = 0; kwidth <= 1; ++kwidth) {
                        this.setBlockAndNotifyAdequately(world, iwidth + x, height + y, kwidth + z, EnumBlock.phos_mushroom_cap.block, 10);
                        if (random.nextInt(10) == 0 && height > 2 && height < j - 5) {
                            final WorldGenerator worldGenFungus = new WorldGenFungus(iwidth, kwidth);
                            worldGenFungus.generate(world, random, iwidth + x, height + y, kwidth + z);
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }
    
    public boolean canGenerate(final World world, final Random random, final int par3, final int par4, final int par5, final int j) {
        Block block = world.getBlock(par3, par4 - 1, par5);
        if (!block.equals(EnumBlock.fungal.block)) {
            return false;
        }
        block = world.getBlock(par3 + 1, par4 - 1, par5);
        if (!block.equals(EnumBlock.fungal.block)) {
            return false;
        }
        block = world.getBlock(par3 + 1, par4 - 1, par5 + 1);
        if (!block.equals(EnumBlock.fungal.block)) {
            return false;
        }
        block = world.getBlock(par3, par4 - 1, par5 + 1);
        if (!block.equals(EnumBlock.fungal.block)) {
            return false;
        }
        boolean flag = true;
        if (par4 < 1 || par4 + j + 1 >= 256) {
            return false;
        }
        for (int k = par4; k <= par4 + j; ++k) {
            byte byte0 = 3;
            if (k == par4) {
                byte0 = 0;
            }
            for (int j2 = 0; j2 <= 2 && flag; ++j2) {
                for (int i2 = 0; i2 <= 2 && flag; ++i2) {
                    if (k >= 0 && k < 256) {
                        block = world.getBlock(j2 - 1 + par3, k, i2 - 1 + par5);
                        if (!block.equals(Blocks.air) && !block.getMaterial().equals(Material.leaves) && !block.equals(EnumBlock.phos_mushroom_cap.block)) {
                            flag = false;
                        }
                    }
                    else {
                        flag = false;
                    }
                }
            }
        }
        for (int height = j - 1; height >= j - 5; --height) {
            for (int iwidth = -6; iwidth <= 6; ++iwidth) {
                for (int kwidth = -6; kwidth <= 6; ++kwidth) {
                    if (!world.getBlock(iwidth + par3 + 1, height + par4, kwidth + par5 + 1).equals(Blocks.air) && !world.getBlock(iwidth + par3 + 1, height + par4, kwidth + par5 + 1).equals(EnumBlock.phos_mushroom_cap.block) && !world.getBlock(iwidth + par3 + 1, height + par4, kwidth + par5 + 1).equals(EnumBlock.phos_mushroom.block)) {
                        return false;
                    }
                }
            }
        }
        for (int height = -3; height >= 3; ++height) {
            for (int iwidth = -7; iwidth <= 7; ++iwidth) {
                for (int kwidth = -7; kwidth <= 7; ++kwidth) {
                    if (world.getBlock(iwidth + par3 + 1, height + par4, kwidth + par5 + 1).equals(EnumBlock.phos_mushroom_cap.block)) {
                        return false;
                    }
                }
            }
        }
        return flag && EnumBlock.fungal.block.canPlaceBlockAt(world, par3, par4, par5);
    }
    
    public void generateMushroomCap(final World world, final Random random, final int par3, final int par4, final int par5, final int j) {
        byte modi = 0;
        byte modk = 0;
        for (int height = j - 1; height >= j - 5; --height) {
            for (int iwidth = -5; iwidth <= 5; ++iwidth) {
                for (int kwidth = -5; kwidth <= 5; ++kwidth) {
                    if (iwidth == 0) {
                        iwidth = 1;
                    }
                    if (kwidth == 0) {
                        kwidth = 1;
                    }
                    if (kwidth > 0) {
                        modk = 1;
                    }
                    else {
                        modk = 0;
                    }
                    if (iwidth > 0) {
                        modi = 1;
                    }
                    else {
                        modi = 0;
                    }
                    if (height != j - 5) {
                        if (height != j - 1) {
                            if (height != j - 4) {
                                if (Math.pow(iwidth, 2.0) + Math.pow(kwidth, 2.0) < Math.pow(5 - height + j - 3, 2.0)) {
                                    this.setBlockAndNotifyAdequately(world, iwidth + par3 + 1 - modi, height + par4, kwidth + par5 + 1 - modk, EnumBlock.phos_mushroom_cap.block, 14);
                                }
                            }
                            else if (Math.pow(iwidth, 2.0) + Math.pow(kwidth, 2.0) < Math.pow(5 - height + j - 3, 2.0) && Math.abs(iwidth) + Math.abs(kwidth) != 8) {
                                this.setBlockAndNotifyAdequately(world, iwidth + par3 + 1 - modi, height + par4, kwidth + par5 + 1 - modk, EnumBlock.phos_mushroom_cap.block, 14);
                            }
                        }
                        else if (Math.pow(iwidth, 2.0) + Math.pow(kwidth, 2.0) < Math.pow(5 - height + j - 3, 2.0) && Math.abs(iwidth) + Math.abs(kwidth) != 4) {
                            this.setBlockAndNotifyAdequately(world, iwidth + par3 + 1 - modi, height + par4, kwidth + par5 + 1 - modk, EnumBlock.phos_mushroom_cap.block, 14);
                        }
                    }
                    else if (Math.pow(iwidth, 2.0) + Math.pow(kwidth, 2.0) < Math.pow(5 - height + j - 5, 2.0)) {
                        if (Math.abs(iwidth) + Math.abs(kwidth) == 6 || Math.abs(kwidth) > 3 || Math.abs(iwidth) > 3) {
                            this.setBlockAndNotifyAdequately(world, iwidth + par3 + 1 - modi, height + par4, kwidth + par5 + 1 - modk, EnumBlock.phos_mushroom_cap.block, 14);
                            if (random.nextInt(6) != 0) {
                                final WorldGenerator worldgenbluevine = new WorldGenBlueVine(j);
                                worldgenbluevine.generate(world, random, iwidth + par3 + 1 - modi, height + par4 - 1, kwidth + par5 + 1 - modk);
                            }
                        }
                        else {
                            world.setBlockMetadataWithNotify(iwidth + par3 + 1 - modi, height + par4 + 1, kwidth + par5 + 1 - modk, 0, 3);
                        }
                    }
                }
            }
        }
    }
}
