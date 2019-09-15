// 
// Decompiled by Procyon v0.5.36
// 

package diversity.block;

import java.util.ArrayList;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.IBlockAccess;
import net.minecraft.entity.player.EntityPlayer;
import diversity.suppliers.EnumBlock;
import java.util.Random;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.IShearable;
import net.minecraft.block.Block;

public class BlockBlueVine extends Block implements IShearable
{
    public BlockBlueVine() {
        super(Material.plants);
        this.setTickRandomly(true);
        this.setCreativeTab(CreativeTabs.tabDecorations);
    }
    
    @Override
    public void setBlockBoundsForItemRender() {
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
    }
    
    @Override
    public int getRenderType() {
        return 1;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(final IIconRegister par1IconRegister) {
        this.blockIcon = par1IconRegister.registerIcon(this.getTextureName());
    }
    
    @Override
    public boolean isOpaqueCube() {
        return false;
    }
    
    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }
    
    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(final World par1World, final int par2, final int par3, final int par4) {
        return null;
    }
    
    private boolean canBePlacedOn(final Block block) {
        return block != Blocks.air && (block == this || (block.renderAsNormalBlock() && block.getMaterial().blocksMovement()));
    }
    
    @Override
    public void onPostBlockPlaced(final World p_149714_1_, final int p_149714_2_, final int p_149714_3_, final int p_149714_4_, final int p_149714_5_) {
        super.onPostBlockPlaced(p_149714_1_, p_149714_2_, p_149714_3_, p_149714_4_, p_149714_5_);
    }
    
    @Override
    public void updateTick(final World world, final int x, final int y, final int z, final Random random) {
        if (!world.isRemote && world.rand.nextInt(40) == 0) {
            int tempY = 0;
            if (world.getBlock(x, y - 1, z).equals(Blocks.air)) {
                while (tempY != 5) {
                    if (!world.getBlock(x, y + tempY, z).equals(EnumBlock.blue_vine.block)) {
                        world.setBlock(x, y - 1, z, EnumBlock.blue_vine.block);
                    }
                    ++tempY;
                }
            }
        }
    }
    
    @Override
    public boolean canPlaceBlockAt(final World world, final int x, final int y, final int z) {
        return this.canBlockStay(world, x, y, z) && super.canPlaceBlockAt(world, x, y, z);
    }
    
    public int idDropped(final int par1, final Random par2Random, final int par3) {
        return 0;
    }
    
    @Override
    public int quantityDropped(final Random par1Random) {
        return 0;
    }
    
    @Override
    public void harvestBlock(final World par1World, final EntityPlayer par2EntityPlayer, final int par3, final int par4, final int par5, final int par6) {
        super.harvestBlock(par1World, par2EntityPlayer, par3, par4, par5, par6);
    }
    
    @Override
    public boolean isLadder(final IBlockAccess world, final int x, final int y, final int z, final EntityLivingBase entity) {
        return true;
    }
    
    @Override
    public boolean isShearable(final ItemStack item, final IBlockAccess world, final int x, final int y, final int z) {
        return true;
    }
    
    @Override
    public ArrayList<ItemStack> onSheared(final ItemStack item, final IBlockAccess world, final int x, final int y, final int z, final int fortune) {
        final ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
        ret.add(new ItemStack((Block)this, 1, 0));
        return ret;
    }
    
    @Override
    public void onNeighborBlockChange(final World world, final int x, final int y, final int z, final Block block) {
        if (!world.isRemote && !this.canBlockStay(world, x, y, z)) {
            this.dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z), 0);
            world.setBlockToAir(x, y, z);
        }
    }
    
    @Override
    public boolean canBlockStay(final World world, final int x, final int y, final int z) {
        final Block block = world.getBlock(x, y + 1, z);
        return block.equals(EnumBlock.blue_vine.block) || block.getMaterial().isSolid();
    }
}
