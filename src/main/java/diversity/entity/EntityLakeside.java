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

public class EntityLakeside extends EntityGlobalVillager
{
    public EntityLakeside(final World world) {
        this(world, EnumTribe.LAKESIDE.getRandomVillager());
    }
    
    public EntityLakeside(final World world, final EnumVillager type) {
        super(world, type);
        if (this.rand.nextBoolean()) {
            this.setCurrentItemOrArmor(0, new ItemStack(Items.stone_axe));
        }
        else {
            this.setCurrentItemOrArmor(0, new ItemStack(Items.stone_sword));
        }
    }
    
    @Override
    public EntityVillager createChild(final EntityAgeable p_90011_1_) {
        final EntityGlobalVillager entityvillager = new EntityLakeside(this.worldObj);
        entityvillager.onSpawnWithEgg(null);
        return entityvillager;
    }
    
    @Override
    protected boolean canAskForHelp() {
        return this.isChief();
    }
    
    @Override
    public boolean canDefend() {
        return this.getProfession() == EnumVillager.LAKESIDE_GUARD.profession;
    }
}
