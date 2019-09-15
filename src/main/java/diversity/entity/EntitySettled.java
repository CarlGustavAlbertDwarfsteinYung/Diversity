// 
// Decompiled by Procyon v0.5.36
// 

package diversity.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;
import diversity.suppliers.EnumVillager;
import diversity.suppliers.EnumTribe;
import net.minecraft.world.World;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.IRangedAttackMob;

public class EntitySettled extends EntityGlobalVillager implements IRangedAttackMob
{
    private EntityAIArrowAttack aiArrowAttack;
    
    public EntitySettled(final World world) {
        this(world, EnumTribe.SETTLED.getRandomVillager());
    }
    
    public EntitySettled(final World world, final EnumVillager type) {
        super(world, type);
        this.aiArrowAttack = new EntityAIArrowAttack(this, 1.0, 20, 60, 15.0f);
        if (this.rand.nextBoolean()) {
            this.setCurrentItemOrArmor(0, new ItemStack(Items.iron_sword));
        }
        else {
            this.setCurrentItemOrArmor(0, new ItemStack(Items.bow));
        }
    }
    
    @Override
    public EntityVillager createChild(final EntityAgeable p_90011_1_) {
        final EntityGlobalVillager entityvillager = new EntitySettled(this.worldObj);
        entityvillager.onSpawnWithEgg(null);
        return entityvillager;
    }
    
    @Override
    protected boolean canAskForHelp() {
        return false;
    }
    
    @Override
    public boolean canDefend() {
        return this.getProfession() == EnumVillager.SETTLED_GUARD.profession;
    }
    
    @Override
    public void updateTasks(final EnumVillager type) {
        if (this.aiArrowAttack != null) {
            if (this.canDefend() && !this.isChild() && this.getHeldItem() != null && this.getHeldItem().getItem().equals(Items.bow)) {
                this.tasks.addTask(1, this.aiArrowAttack);
                this.tasks.removeTask(this.attackOnCollide);
                this.tasks.removeTask(this.aiMoveTowardsRestriction);
            }
            else {
                this.tasks.removeTask(this.aiArrowAttack);
            }
        }
        super.updateTasks(type);
    }
    
    @Override
    public void attackEntityWithRangedAttack(final EntityLivingBase p_82196_1_, final float p_82196_2_) {
        final EntityArrow entityArrow = new EntityArrow(this.worldObj, this, p_82196_1_, 1.6f, (float)(14 - this.worldObj.difficultySetting.getDifficultyId() * 4));
        entityArrow.setDamage(p_82196_2_ * 2.0f + this.rand.nextGaussian() * 0.25 + this.worldObj.difficultySetting.getDifficultyId() * 0.11f);
        this.playSound("random.bow", 1.0f, 1.0f / (this.getRNG().nextFloat() * 0.4f + 0.8f));
        this.worldObj.spawnEntityInWorld(entityArrow);
    }
}
