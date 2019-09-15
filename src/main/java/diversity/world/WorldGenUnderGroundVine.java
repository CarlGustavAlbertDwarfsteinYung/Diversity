// 
// Decompiled by Procyon v0.5.36
// 

package diversity.world;

import net.minecraft.util.Facing;
import net.minecraft.util.Direction;
import net.minecraft.init.Blocks;
import java.util.Random;
import net.minecraft.world.World;

public class WorldGenUnderGroundVine
{
    public boolean generate(final World world, final Random random, int x, int y, int z, final int h) {
        final int l = x;
        final int i1 = z;
        while (y < h) {
            if (world.isAirBlock(x, y, z)) {
                for (int j1 = 2; j1 <= 5; ++j1) {
                    if (Blocks.vine.canPlaceBlockOnSide(world, x, y, z, j1)) {
                        world.setBlock(x, y, z, Blocks.vine, 1 << Direction.facingToDirection[Facing.oppositeSide[j1]], 2);
                        break;
                    }
                }
            }
            else {
                x = l + random.nextInt(4) - random.nextInt(4);
                z = i1 + random.nextInt(4) - random.nextInt(4);
            }
            ++y;
        }
        return true;
    }
}
