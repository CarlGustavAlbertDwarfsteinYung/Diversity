// 
// Decompiled by Procyon v0.5.36
// 

package diversity.item;

import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.SharedMonsterAttributes;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;

public class ItemSpear extends ItemSword
{
    private float itemDamage;
    
    public ItemSpear(final Item.ToolMaterial p_i45356_1_) {
        super(p_i45356_1_);
        this.setMaxDamage(p_i45356_1_.getMaxUses() - 20);
        this.itemDamage = 5.0f + p_i45356_1_.getDamageVsEntity();
    }
    
    @Override
    public EnumAction getItemUseAction(final ItemStack p_77661_1_) {
        return EnumAction.none;
    }
    
    @Override
    public Multimap getItemAttributeModifiers() {
        final Multimap multimap = (Multimap)HashMultimap.create();
        multimap.put((Object)SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), (Object)new AttributeModifier(ItemSpear.field_111210_e, "Weapon modifier", (double)this.itemDamage, 0));
        return multimap;
    }
}
