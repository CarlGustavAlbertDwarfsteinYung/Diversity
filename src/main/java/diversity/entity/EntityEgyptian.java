// 
// Decompiled by Procyon v0.5.36
// 

package diversity.entity;

import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.EntityAgeable;
import diversity.suppliers.EnumItem;
import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;
import diversity.suppliers.EnumVillager;
import diversity.suppliers.EnumTribe;
import net.minecraft.world.World;

public class EntityEgyptian extends EntityGlobalVillager
{
    public EntityEgyptian(final World world) {
        this(world, EnumTribe.EGYPTIAN.getRandomVillager());
    }
    
    public EntityEgyptian(final World world, final EnumVillager type) {
        super(world, type);
        if (this.rand.nextBoolean()) {
            this.setCurrentItemOrArmor(0, new ItemStack(Items.iron_sword));
        }
        else {
            this.setCurrentItemOrArmor(0, new ItemStack(EnumItem.iron_spear.item));
        }
    }
    
    @Override
    public EntityVillager createChild(final EntityAgeable p_90011_1_) {
        final EntityGlobalVillager entityvillager = new EntityEgyptian(this.worldObj);
        entityvillager.onSpawnWithEgg(null);
        return entityvillager;
    }
    
    @Override
    protected boolean canAskForHelp() {
        return this.getProfession() == EnumVillager.EGYPTIAN_PHARAOH.profession;
    }
    
    @Override
    public boolean canDefend() {
        return this.getProfession() == EnumVillager.EGYPTIAN_GUARD.profession;
    }
}
