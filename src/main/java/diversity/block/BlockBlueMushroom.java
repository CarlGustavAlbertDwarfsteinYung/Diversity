// 
// Decompiled by Procyon v0.5.36
// 

package diversity.block;

import net.minecraftforge.common.EnumPlantType;
import net.minecraft.world.gen.feature.WorldGenerator;
import diversity.world.WorldGenBlueMushroom;
import net.minecraftforge.common.IPlantable;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.util.ForgeDirection;
import diversity.suppliers.EnumBlock;
import java.util.Random;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.block.Block;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraft.block.material.Material;
import net.minecraft.block.IGrowable;
import net.minecraft.block.BlockBush;

public class BlockBlueMushroom extends BlockBush implements IGrowable
{
    private int metadata;
    
    public BlockBlueMushroom() {
        super(Material.plants);
        this.metadata = 0;
        final float f = 0.3f;
        this.setBlockBounds(0.5f - f, 0.0f, 0.5f - f, 0.5f + f, f * 2.0f, 0.5f + f);
        this.setTickRandomly(true);
    }
    
    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(final World par1World, final int par2, final int par3, final int i) {
        return null;
    }
    
    @Override
    public int tickRate(final World par1World) {
        return 10;
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
    public void onNeighborBlockChange(final World world, final int x, final int y, final int z, final Block block) {
        super.onNeighborBlockChange(world, x, y, z, block);
        this.checkFlowerChange(world, x, y, z);
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(final IIconRegister par1IconRegister) {
        this.blockIcon = par1IconRegister.registerIcon(this.getTextureName());
    }
    
    protected final void checkFlowerChange(final World world, final int x, final int y, final int z) {
        if (!this.canBlockStay(world, x, y, z)) {
            this.dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z), 0);
            world.setBlockToAir(x, y, z);
        }
    }
    
    @Override
    public void updateTick(final World world, int x, int y, int z, final Random random) {
        if (world.canBlockSeeTheSky(x, y, z)) {
            return;
        }
        if (random.nextInt(25) == 0) {
            final byte b0 = 4;
            int l = 5;
            for (int tempX = x - b0; tempX <= x + b0; ++tempX) {
                for (int tempZ = z - b0; tempZ <= z + b0; ++tempZ) {
                    for (int tempY = y - 1; tempY <= y + 1; ++tempY) {
                        if (world.getBlock(tempX, tempY, tempZ) == this && --l <= 0) {
                            return;
                        }
                    }
                }
            }
            int tempX = x + random.nextInt(3) - 1;
            int tempZ = y + random.nextInt(2) - random.nextInt(2);
            int tempY = z + random.nextInt(3) - 1;
            for (int l2 = 0; l2 < 4; ++l2) {
                if (world.isAirBlock(tempX, tempZ, tempY) && this.canBlockStay(world, tempX, tempZ, tempY)) {
                    x = tempX;
                    y = tempZ;
                    z = tempY;
                }
                tempX = x + random.nextInt(3) - 1;
                tempZ = y + random.nextInt(2) - random.nextInt(2);
                tempY = z + random.nextInt(3) - 1;
            }
            if (world.isAirBlock(tempX, tempZ, tempY) && this.canBlockStay(world, tempX, tempZ, tempY)) {
                world.setBlock(tempX, tempZ, tempY, (Block)this);
            }
        }
    }
    
    @Override
    public boolean canPlaceBlockAt(final World world, final int x, final int y, final int z) {
        return super.canPlaceBlockAt(world, x, y, z) && this.canBlockStay(world, x, y, z);
    }
    
    @Override
    public boolean canBlockStay(final World world, final int x, final int y, final int z) {
        if (y >= 0 && y < 256) {
            final Block block = world.getBlock(x, y - 1, z);
            return !world.canBlockSeeTheSky(x, y, z) && block.equals(EnumBlock.fungal.block) && block.canSustainPlant((IBlockAccess)world, x, y - 1, z, ForgeDirection.UP, (IPlantable)this);
        }
        return false;
    }
    
    public boolean fertilizeMushroom(final World world, final int x, final int y, final int z, final Random random) {
        final int i = world.getBlockMetadata(x, y, z);
        final WorldGenerator worldgenbigmushroom = new WorldGenBlueMushroom();
        return worldgenbigmushroom.generate(world, random, x, y, z);
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
