// 
// Decompiled by Procyon v0.5.36
// 

package diversity.entity;

import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.item.ItemStack;
import diversity.suppliers.EnumItem;
import diversity.suppliers.EnumVillager;
import diversity.suppliers.EnumTribe;
import net.minecraft.world.World;

public class EntityZulu extends EntityGlobalVillager
{
    public EntityZulu(final World world) {
        this(world, EnumTribe.ZULU.getRandomVillager());
    }
    
    public EntityZulu(final World world, final EnumVillager type) {
        super(world, type);
        this.setCurrentItemOrArmor(0, new ItemStack(EnumItem.stone_spear.item));
    }
    
    @Override
    public EntityVillager createChild(final EntityAgeable p_90011_1_) {
        final EntityGlobalVillager entityvillager = new EntityZulu(this.worldObj);
        entityvillager.onSpawnWithEgg(null);
        return entityvillager;
    }
    
    @Override
    protected boolean canAskForHelp() {
        return this.getProfession() == EnumVillager.ZULU_CHIEF.profession;
    }
    
    @Override
    public boolean canDefend() {
        return this.getProfession() == EnumVillager.ZULU_WARRIOR.profession;
    }
}
