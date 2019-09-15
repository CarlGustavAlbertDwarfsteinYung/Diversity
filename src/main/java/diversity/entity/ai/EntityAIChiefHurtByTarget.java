// 
// Decompiled by Procyon v0.5.36
// 

package diversity.entity.ai;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import diversity.entity.EntityGlobalVillager;
import net.minecraft.entity.ai.EntityAITarget;

public class EntityAIChiefHurtByTarget extends EntityAITarget
{
    EntityGlobalVillager theDefendingVillager;
    EntityLivingBase theChiefAttacker;
    private int field_142051_e;
    
    public EntityAIChiefHurtByTarget(final EntityGlobalVillager p_i1667_1_) {
        super((EntityCreature)p_i1667_1_, false);
        this.theDefendingVillager = p_i1667_1_;
        this.setMutexBits(1);
    }
    
    @Override
    public boolean shouldExecute() {
        if (!this.theDefendingVillager.isChild()) {
            return false;
        }
        final EntityLivingBase entitylivingbase = this.theDefendingVillager.getChief();
        if (entitylivingbase == null) {
            return false;
        }
        this.theChiefAttacker = entitylivingbase.getAITarget();
        final int i = entitylivingbase.func_142015_aE();
        return i != this.field_142051_e && this.isSuitableTarget(this.theChiefAttacker, false) && this.theDefendingVillager.func_142018_a(this.theChiefAttacker, entitylivingbase);
    }
    
    @Override
    public void startExecuting() {
        this.taskOwner.setAttackTarget(this.theChiefAttacker);
        final EntityLivingBase entitylivingbase = this.theDefendingVillager.getChief();
        if (entitylivingbase != null) {
            this.field_142051_e = entitylivingbase.func_142015_aE();
        }
        super.startExecuting();
    }
}
