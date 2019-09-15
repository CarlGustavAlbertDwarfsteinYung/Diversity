// 
// Decompiled by Procyon v0.5.36
// 

package diversity.block;

import net.minecraft.entity.EntityLiving;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.Potion;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraft.util.IIcon;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.block.material.Material;
import diversity.suppliers.EnumFluid;
import net.minecraftforge.fluids.BlockFluidClassic;

public class BlockPoisonWater extends BlockFluidClassic
{
    public BlockPoisonWater() {
        super(EnumFluid.poison_water.fluid, Material.water);
    }
    
    @Override
    public void registerBlockIcons(final IIconRegister iconRegister) {
        this.getFluid().setStillIcon(iconRegister.registerIcon(this.getTextureName() + "_still"));
        this.getFluid().setFlowingIcon(iconRegister.registerIcon(this.getTextureName() + "_flow"));
    }
    
    @Override
    public IIcon getIcon(final int side, final int meta) {
        return (side == 0 || side == 1) ? this.getFluid().getStillIcon() : this.getFluid().getFlowingIcon();
    }
    
    @Override
    public void onEntityCollidedWithBlock(final World world, final int x, final int y, final int z, final Entity entity) {
        if (entity instanceof EntityPlayer) {
            ((EntityPlayer)entity).addPotionEffect(new PotionEffect(Potion.poison.id, 200, 4));
        }
        else if (entity instanceof EntityLiving) {
            ((EntityLiving)entity).addPotionEffect(new PotionEffect(Potion.poison.id, 200, 4));
        }
    }
}
