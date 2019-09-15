// 
// Decompiled by Procyon v0.5.36
// 

package diversity.block;

import net.minecraftforge.common.EnumPlantType;
import diversity.world.WorldGenPhosMushroom;
import net.minecraftforge.common.IPlantable;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraft.init.Blocks;
import java.util.Random;
import diversity.suppliers.EnumBlock;
import net.minecraft.block.Block;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.block.material.Material;
import net.minecraft.block.IGrowable;
import net.minecraft.block.BlockBush;

public class BlockPhosMushroom extends BlockBush implements IGrowable
{
    private int metadata;
    
    public BlockPhosMushroom() {
        super(Material.plants);
        this.metadata = 0;
        final float f = 0.5f;
        this.setBlockBounds(0.5f - f, 0.0f, 0.5f - f, 0.5f + f, f * 2.0f, 0.5f + f);
        this.setTickRandomly(true);
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(final IIconRegister par1IconRegister) {
        this.blockIcon = par1IconRegister.registerIcon(this.getTextureName());
    }
    
    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(final World par1World, final int par2, final int par3, final int i) {
        return null;
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
    @SideOnly(Side.CLIENT)
    public int getRenderType() {
        return 1;
    }
    
    @Override
    public void onNeighborBlockChange(final World par1World, final int par2, final int par3, final int par4, final Block par5) {
        super.onNeighborBlockChange(par1World, par2, par3, par4, par5);
        this.checkFlowerChange(par1World, par2, par3, par4);
    }
    
    protected final void checkFlowerChange(final World par1World, final int par2, final int par3, final int par4) {
        if (!this.canBlockStay(par1World, par2, par3, par4) || par1World.getBlock(par2, par3 - 1, par4) != EnumBlock.fungal.block) {
            this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
            par1World.setBlockToAir(par2, par3, par4);
        }
    }
    
    @Override
    public void updateTick(final World par1World, int par2, int par3, int par4, final Random par5Random) {
        if (par1World.canBlockSeeTheSky(par2, par3, par4)) {
            return;
        }
        if (par5Random.nextInt(100) == 0) {
            final byte byte0 = 4;
            int i = 5;
            for (int j = par2 - byte0; j <= par2 + byte0; ++j) {
                for (int l = par4 - byte0; l <= par4 + byte0; ++l) {
                    for (int j2 = par3 - 1; j2 <= par3 + 1; ++j2) {
                        if (par1World.getBlock(j, j2, l) == this && --i <= 0) {
                            return;
                        }
                    }
                }
                int k = par2 + par5Random.nextInt(3) - 1;
                int i2 = par3 + par5Random.nextInt(2) - par5Random.nextInt(2);
                int k2 = par4 + par5Random.nextInt(3) - 1;
                for (int l2 = 0; l2 < 4; ++l2) {
                    if (par1World.isAirBlock(k, i2, k2) && this.canBlockStay(par1World, k, i2, k2)) {
                        par2 = k;
                        par3 = i2;
                        par4 = k2;
                    }
                    k = par2 + par5Random.nextInt(3) - 1;
                    i2 = par3 + par5Random.nextInt(2) - par5Random.nextInt(2);
                    k2 = par4 + par5Random.nextInt(3) - 1;
                }
                if (par1World.isAirBlock(k, i2, k2) && this.canBlockStay(par1World, k, i2, k2) && par5Random.nextInt(5) == 0) {
                    par1World.setBlock(k, i2, k2, (Block)this);
                }
            }
        }
    }
    
    @Override
    public boolean canPlaceBlockAt(final World world, final int x, final int y, final int z) {
        return world.getBlock(x, y + 1, z) == Blocks.air && world.getBlock(x, y - 1, z) == EnumBlock.fungal.block && super.canPlaceBlockAt(world, x, y, z) && this.canBlockStay(world, x, y, z);
    }
    
    @Override
    public boolean canBlockStay(final World world, final int x, final int y, final int z) {
        if (y < 0 || y >= 256) {
            return false;
        }
        final Block block = world.getBlock(x, y - 1, z);
        return !world.canBlockSeeTheSky(x, y, z) && world.getBlock(x, y - 1, z) == EnumBlock.fungal.block && block.canSustainPlant((IBlockAccess)world, x, y, z, ForgeDirection.UP, (IPlantable)this);
    }
    
    public int idDropped(final int par1, final Random par2Random, final int par3) {
        return Block.getIdFromBlock(EnumBlock.phos_mushroom.block);
    }
    
    public boolean fertilizeMushroom(final World world, final int x, final int y, final int z, final Random random) {
        world.setBlockToAir(x, y, z);
        final WorldGenPhosMushroom worldgenbigmushroom = new WorldGenPhosMushroom();
        if (worldgenbigmushroom == null || !worldgenbigmushroom.generate(world, random, x, y - 1, z)) {
            world.setBlock(x, y, z, EnumBlock.phos_mushroom.block);
            return false;
        }
        return true;
    }
    
    @Override
    public boolean func_149851_a(final World p_149851_1_, final int p_149851_2_, final int p_149851_3_, final int p_149851_4_, final boolean p_149851_5_) {
        return true;
    }
    
    @Override
    public boolean func_149852_a(final World p_149852_1_, final Random p_149852_2_, final int p_149852_3_, final int p_149852_4_, final int p_149852_5_) {
        return p_149852_2_.nextFloat() < 0.4;
    }
    
    @Override
    public void func_149853_b(final World p_149853_1_, final Random p_149853_2_, final int p_149853_3_, final int p_149853_4_, final int p_149853_5_) {
        this.fertilizeMushroom(p_149853_1_, p_149853_3_, p_149853_4_, p_149853_5_, p_149853_2_);
    }
    
    @Override
    public EnumPlantType getPlantType(final IBlockAccess world, final int x, final int y, final int z) {
        return EnumPlantType.Cave;
    }
}
