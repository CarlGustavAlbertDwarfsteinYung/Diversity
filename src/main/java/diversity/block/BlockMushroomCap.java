// 
// Decompiled by Procyon v0.5.36
// 

package diversity.block;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import diversity.suppliers.EnumBlock;
import net.minecraft.item.Item;
import java.util.Random;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.block.material.Material;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.IIcon;
import net.minecraft.block.Block;

public class BlockMushroomCap extends Block
{
    @SideOnly(Side.CLIENT)
    private IIcon capOUT;
    @SideOnly(Side.CLIENT)
    private IIcon capIN;
    
    public BlockMushroomCap(final Material material) {
        super(material);
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(final IIconRegister par1IconRegister) {
        this.blockIcon = par1IconRegister.registerIcon(this.getTextureName() + "_sterm_side");
        this.capIN = par1IconRegister.registerIcon(this.getTextureName() + "_cap_in");
        this.capOUT = par1IconRegister.registerIcon(this.getTextureName() + "_cap_out");
    }
    
    @Override
    public IIcon getIcon(final int par1, final int par2) {
        if (par2 == 11 && par1 > 0) {
            return this.capOUT;
        }
        if (par2 == 10 && par1 > 1) {
            return this.blockIcon;
        }
        if (par2 >= 1 && par2 <= 9 && par1 == 1) {
            return this.capOUT;
        }
        if (par2 >= 1 && par2 <= 3 && par1 == 2) {
            return this.capOUT;
        }
        if (par2 >= 7 && par2 <= 9 && par1 == 3) {
            return this.capOUT;
        }
        if ((par2 == 1 || par2 == 4 || par2 == 7) && par1 == 4) {
            return this.capOUT;
        }
        if ((par2 == 3 || par2 == 6 || par2 == 9) && par1 == 5) {
            return this.capOUT;
        }
        if (par2 == 14) {
            return this.capOUT;
        }
        if (par2 == 15) {
            return this.blockIcon;
        }
        return this.capIN;
    }
    
    @Override
    public int quantityDropped(final Random par1Random) {
        int i = par1Random.nextInt(10) - 7;
        if (i < 0) {
            i = 0;
        }
        return i;
    }
    
    @Override
    public Item getItemDropped(final int p_149650_1_, final Random p_149650_2_, final int p_149650_3_) {
        return Item.getItemById(Block.getIdFromBlock(EnumBlock.blue_mushroom.block));
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public Item getItem(final World p_149694_1_, final int p_149694_2_, final int p_149694_3_, final int p_149694_4_) {
        return Item.getItemById(Block.getIdFromBlock(EnumBlock.blue_mushroom.block));
    }
    
    @Override
    public boolean canPlaceBlockAt(final World par1World, final int par2, final int par3, final int par4) {
        return par1World.getBlock(par2, par3 + 1, par4) == Blocks.air && par1World.getBlock(par2, par3 - 1, par4) == EnumBlock.fungal.block && super.canPlaceBlockAt(par1World, par2, par3, par4) && this.canBlockStay(par1World, par2, par3, par4);
    }
}
