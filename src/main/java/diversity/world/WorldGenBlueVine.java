// 
// Decompiled by Procyon v0.5.36
// 

package diversity.world;

import diversity.suppliers.EnumBlock;
import net.minecraft.block.material.Material;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenBlueVine extends WorldGenerator
{
    private int height;
    
    public WorldGenBlueVine(final int height) {
        this.height = height;
    }
    
    public WorldGenBlueVine() {
        this(0);
    }
    
    @Override
    public boolean generate(final World world, final Random random, final int x, final int y, final int z) {
        if (this.height == 0) {
            for (int tempHeight = 0; tempHeight < 1 + random.nextInt(4); ++tempHeight) {
                if (world.getBlock(x, y - tempHeight, z).getMaterial().equals(Material.air)) {
                    world.setBlock(x, y - tempHeight, z, EnumBlock.blue_vine.block);
                }
            }
        }
        else {
            for (int tempHeight = 0; tempHeight < this.height; ++tempHeight) {
                if (world.getBlock(x, y - tempHeight, z).getMaterial().equals(Material.air)) {
                    world.setBlock(x, y - tempHeight, z, EnumBlock.blue_vine.block);
                }
            }
        }
        return true;
    }
}
