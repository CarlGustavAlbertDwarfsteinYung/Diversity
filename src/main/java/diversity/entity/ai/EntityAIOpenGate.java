// 
// Decompiled by Procyon v0.5.36
// 

package diversity.entity.ai;

import diversity.entity.EntityGlobalVillager;
import net.minecraft.entity.EntityLiving;

public class EntityAIOpenGate extends EntityAIGateInteract
{
    boolean field_75361_i;
    int field_75360_j;
    
    public EntityAIOpenGate(final EntityLiving p_i1644_1_, final boolean p_i1644_2_) {
        super(p_i1644_1_);
        this.theEntity = p_i1644_1_;
        this.field_75361_i = p_i1644_2_;
    }
    
    @Override
    public boolean continueExecuting() {
        return this.field_75361_i && this.field_75360_j > 0 && super.continueExecuting();
    }
    
    @Override
    public void startExecuting() {
        this.field_75360_j = 20;
        this.onGateActivated(this.theEntity.worldObj, this.entityPosX, this.entityPosY, this.entityPosZ, (EntityGlobalVillager)this.theEntity, this.field_151504_e);
    }
    
    @Override
    public void resetTask() {
        if (this.field_75361_i) {
            this.onGateActivated(this.theEntity.worldObj, this.entityPosX, this.entityPosY, this.entityPosZ, (EntityGlobalVillager)this.theEntity, this.field_151504_e);
        }
    }
    
    @Override
    public void updateTask() {
        --this.field_75360_j;
        super.updateTask();
    }
}
