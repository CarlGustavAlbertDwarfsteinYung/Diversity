// 
// Decompiled by Procyon v0.5.36
// 

package diversity.world;

import diversity.suppliers.EnumBlock;
import net.minecraft.init.Blocks;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenFungus extends WorldGenerator
{
    private int iwidth;
    private int kwidth;
    
    public WorldGenFungus(final int iwidth, final int kwidth) {
        this.iwidth = iwidth;
        this.kwidth = kwidth;
    }
    
    @Override
    public boolean generate(final World world, final Random random, final int x, final int y, final int z) {
        this.iwidth = this.iwidth * 2 - 1;
        this.kwidth = this.kwidth * 2 - 1;
        boolean flag = false;
        for (int tempX = this.iwidth; tempX != -this.iwidth; tempX -= this.iwidth) {
            for (int tempZ = this.kwidth; tempZ != -this.kwidth; tempZ -= this.kwidth) {
                if (world.getBlock(x + tempX, y, z + tempZ).equals(Blocks.air)) {
                    world.setBlock(x + tempX, y, z + tempZ, EnumBlock.fungus.block);
                    flag = true;
                }
            }
        }
        return flag;
    }
}
