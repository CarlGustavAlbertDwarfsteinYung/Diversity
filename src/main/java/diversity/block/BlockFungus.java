// 
// Decompiled by Procyon v0.5.36
// 

package diversity.block;

import java.util.Random;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.block.material.Material;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.IIcon;
import net.minecraft.block.Block;

public class BlockFungus extends Block
{
    @SideOnly(Side.CLIENT)
    private IIcon side;
    
    public BlockFungus() {
        super(Material.grass);
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(final IIconRegister par1IconRegister) {
        this.side = par1IconRegister.registerIcon(this.getTextureName() + "_side");
        this.blockIcon = par1IconRegister.registerIcon(this.getTextureName());
    }
    
    @Override
    public IIcon getIcon(final int i, final int k) {
        if (i == 1 || i == 0) {
            return this.blockIcon;
        }
        return this.side;
    }
    
    @Override
    public int quantityDropped(final Random par1Random) {
        return 5 + par1Random.nextInt(5);
    }
    
    public int idDropped(final int par1, final Random par2Random, final int par3) {
        return 0;
    }
}
