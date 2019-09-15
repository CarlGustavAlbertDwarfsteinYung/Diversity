// 
// Decompiled by Procyon v0.5.36
// 

package diversity.entity;

import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.EntityAgeable;
import diversity.suppliers.EnumVillager;
import diversity.suppliers.EnumTribe;
import net.minecraft.world.World;

public class EntityTibetan extends EntityGlobalVillager
{
    public EntityTibetan(final World world) {
        this(world, EnumTribe.TIBETAN.getRandomVillager());
    }
    
    public EntityTibetan(final World world, final EnumVillager type) {
        super(world, type);
    }
    
    @Override
    public EntityVillager createChild(final EntityAgeable p_90011_1_) {
        final EntityGlobalVillager entityvillager = new EntityTibetan(this.worldObj);
        entityvillager.onSpawnWithEgg(null);
        return entityvillager;
    }
    
    @Override
    protected boolean canAskForHelp() {
        return false;
    }
    
    @Override
    public boolean canDefend() {
        return false;
    }
}
