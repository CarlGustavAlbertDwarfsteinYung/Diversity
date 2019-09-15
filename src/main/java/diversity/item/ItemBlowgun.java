// 
// Decompiled by Procyon v0.5.36
// 

package diversity.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.IIcon;
import net.minecraftforge.event.entity.player.ArrowNockEvent;
import net.minecraft.item.EnumAction;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import diversity.entity.EntityDart;
import diversity.suppliers.EnumItem;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantment;
import cpw.mods.fml.common.eventhandler.Event;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;

public class ItemBlowgun extends Item
{
    public ItemBlowgun() {
        this.maxStackSize = 1;
        this.setMaxDamage(192);
    }
    
    @Override
    public void onPlayerStoppedUsing(final ItemStack p_77615_1_, final World p_77615_2_, final EntityPlayer p_77615_3_, final int p_77615_4_) {
        int j = this.getMaxItemUseDuration(p_77615_1_) - p_77615_4_;
        final ArrowLooseEvent event = new ArrowLooseEvent(p_77615_3_, p_77615_1_, j);
        MinecraftForge.EVENT_BUS.post((Event)event);
        if (event.isCanceled()) {
            return;
        }
        j = event.charge;
        final boolean flag = p_77615_3_.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, p_77615_1_) > 0;
        if (flag || p_77615_3_.inventory.hasItem(EnumItem.dart.item)) {
            float f = j / 8.0f;
            f = (f * f + f * 2.0f) / 3.0f;
            if (f < 0.1) {
                return;
            }
            if (f > 1.0f) {
                f = 1.0f;
            }
            final EntityDart entityDart = new EntityDart(p_77615_2_, (EntityLivingBase)p_77615_3_, f * 2.0f);
            if (f == 1.0f) {
                entityDart.setIsCritical(true);
            }
            p_77615_1_.damageItem(1, (EntityLivingBase)p_77615_3_);
            p_77615_2_.playSoundAtEntity((Entity)p_77615_3_, "random.bow", 1.0f, 1.0f / (ItemBlowgun.itemRand.nextFloat() * 0.4f + 1.2f) + f * 0.5f);
            if (flag) {
                entityDart.canBePickedUp = 2;
            }
            else {
                p_77615_3_.inventory.consumeInventoryItem(EnumItem.dart.item);
            }
            if (!p_77615_2_.isRemote) {
                p_77615_2_.spawnEntityInWorld((Entity)entityDart);
            }
        }
    }
    
    @Override
    public ItemStack onEaten(final ItemStack p_77654_1_, final World p_77654_2_, final EntityPlayer p_77654_3_) {
        return p_77654_1_;
    }
    
    @Override
    public int getMaxItemUseDuration(final ItemStack p_77626_1_) {
        return 36000;
    }
    
    @Override
    public EnumAction getItemUseAction(final ItemStack p_77661_1_) {
        return EnumAction.bow;
    }
    
    @Override
    public ItemStack onItemRightClick(final ItemStack p_77659_1_, final World p_77659_2_, final EntityPlayer p_77659_3_) {
        final ArrowNockEvent event = new ArrowNockEvent(p_77659_3_, p_77659_1_);
        MinecraftForge.EVENT_BUS.post((Event)event);
        if (event.isCanceled()) {
            return event.result;
        }
        if (p_77659_3_.capabilities.isCreativeMode || p_77659_3_.inventory.hasItem(EnumItem.dart.item)) {
            p_77659_3_.setItemInUse(p_77659_1_, this.getMaxItemUseDuration(p_77659_1_));
        }
        return p_77659_1_;
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon getItemIconForUseDuration(final int p_94599_1_) {
        return this.itemIcon;
    }
}
