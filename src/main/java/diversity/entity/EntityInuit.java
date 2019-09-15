// 
// Decompiled by Procyon v0.5.36
// 

package diversity.entity;

import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;
import diversity.suppliers.EnumVillager;
import diversity.suppliers.EnumTribe;
import net.minecraft.world.World;

public class EntityInuit extends EntityGlobalVillager
{
    public EntityInuit(final World world) {
        this(world, EnumTribe.INUIT.getRandomVillager());
    }
    
    public EntityInuit(final World world, final EnumVillager type) {
        super(world, type);
        this.setCurrentItemOrArmor(0, new ItemStack(Items.stone_sword));
    }
    
    @Override
    public EntityVillager createChild(final EntityAgeable p_90011_1_) {
        final EntityGlobalVillager entityvillager = new EntityInuit(this.worldObj);
        entityvillager.onSpawnWithEgg(null);
        return entityvillager;
    }
    
    @Override
    protected boolean canAskForHelp() {
        return this.getProfession() == EnumVillager.INUIT_CHIEF.profession;
    }
    
    @Override
    public boolean canDefend() {
        return this.getProfession() == EnumVillager.INUIT_HUNTER.profession;
    }
}
