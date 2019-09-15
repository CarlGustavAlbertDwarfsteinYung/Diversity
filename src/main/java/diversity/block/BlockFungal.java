// 
// Decompiled by Procyon v0.5.36
// 

package diversity.block;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.world.IBlockAccess;
import net.minecraft.item.Item;
import diversity.suppliers.EnumBlock;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.init.Blocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.material.Material;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.IIcon;
import net.minecraft.block.Block;

public class BlockFungal extends Block
{
    @SideOnly(Side.CLIENT)
    private IIcon top;
    @SideOnly(Side.CLIENT)
    private IIcon snow;
    
    public BlockFungal() {
        super(Material.grass);
        this.setTickRandomly(true);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(final int p_149691_1_, final int p_149691_2_) {
        return (p_149691_1_ == 1) ? this.top : ((p_149691_1_ == 0) ? Blocks.dirt.getBlockTextureFromSide(p_149691_1_) : this.blockIcon);
    }
    
    @Override
    public void updateTick(final World world, final int x, final int y, final int z, final Random random) {
        if (y > 55 || world.canBlockSeeTheSky(x, y + 1, z) || world.getBlockLightOpacity(x, y + 1, z) > 2) {
            world.setBlock(x, y, z, Blocks.dirt, 0, 3);
        }
        else {
            for (int i = 0; i < 4; ++i) {
                final int tempX = x + random.nextInt(3) - 1;
                final int tempY = y + random.nextInt(5) - 3;
                final int tempZ = z + random.nextInt(3) - 1;
                final Block block = world.getBlock(tempX, tempY + 1, tempZ);
                if (world.getBlock(tempX, tempY, tempZ).equals(Blocks.dirt) && !world.canBlockSeeTheSky(x, y + 1, z) && world.getBlockLightOpacity(tempX, tempY + 1, tempZ) <= 2) {
                    world.setBlock(tempX, tempY, tempZ, EnumBlock.fungal.block, 0, 3);
                }
            }
        }
    }
    
    @Override
    public Item getItemDropped(final int p_149650_1_, final Random p_149650_2_, final int p_149650_3_) {
        return Blocks.dirt.getItemDropped(0, p_149650_2_, p_149650_3_);
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(final IBlockAccess world, final int x, final int y, final int z, final int type) {
        if (type == 1) {
            return this.top;
        }
        if (type == 0) {
            return Blocks.dirt.getBlockTextureFromSide(type);
        }
        final Material material = world.getBlock(x, y + 1, z).getMaterial();
        return (!material.equals(Material.snow) && !material.equals(Material.craftedSnow)) ? this.blockIcon : this.snow;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(final IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon(this.getTextureName() + "_side");
        this.top = iconRegister.registerIcon(this.getTextureName() + "_top");
        this.snow = iconRegister.registerIcon("grass_side_snowed");
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(final World world, final int x, final int y, final int z, final Random random) {
        super.randomDisplayTick(world, x, y, z, random);
        if (random.nextInt(10) == 0) {
            world.spawnParticle("townaura", (double)(x + random.nextFloat()), (double)(y + 1.1f), (double)(z + random.nextFloat()), 0.0, 0.0, 0.0);
        }
    }
}
