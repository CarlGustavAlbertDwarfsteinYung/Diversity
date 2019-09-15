// 
// Decompiled by Procyon v0.5.36
// 

package diversity.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import diversity.suppliers.EnumItem;
import diversity.suppliers.EnumVillager;
import diversity.suppliers.EnumTribe;
import net.minecraft.world.World;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.IRangedAttackMob;

public class EntityAztec extends EntityGlobalVillager implements IRangedAttackMob
{
    private EntityAIArrowAttack aiArrowAttack;
    
    public EntityAztec(final World world) {
        this(world, EnumTribe.AZTEC.getRandomVillager());
    }
    
    public EntityAztec(final World world, final EnumVillager type) {
        super(world, type);
        this.aiArrowAttack = new EntityAIArrowAttack((IRangedAttackMob)this, 1.0, 20, 60, 15.0f);
        switch (this.rand.nextInt(3)) {
            case 0: {
                this.setCurrentItemOrArmor(0, new ItemStack(EnumItem.blowgun.item));
                break;
            }
            case 1: {
                this.setCurrentItemOrArmor(0, new ItemStack(Items.stone_axe));
                break;
            }
            case 2: {
                this.setCurrentItemOrArmor(0, new ItemStack(EnumItem.wooden_spear.item));
                break;
            }
        }
    }
    
    @Override
    public EntityVillager createChild(final EntityAgeable p_90011_1_) {
        final EntityGlobalVillager entityvillager = new EntityAztec(this.worldObj);
        entityvillager.onSpawnWithEgg(null);
        return entityvillager;
    }
    
    @Override
    protected boolean canAskForHelp() {
        return this.getProfession() == EnumVillager.AZTEC_CHIEF.profession;
    }
    
    @Override
    public boolean canDefend() {
        return this.getProfession() == EnumVillager.AZTEC_HUNTER.profession;
    }
    
    @Override
    public void updateTasks(final EnumVillager type) {
        if (this.aiArrowAttack != null) {
            if (this.canDefend() && !this.isChild() && this.getHeldItem() != null && this.getHeldItem().getItem().equals(EnumItem.blowgun.item)) {
                this.tasks.addTask(1, (EntityAIBase)this.aiArrowAttack);
                this.tasks.removeTask(this.attackOnCollide);
                this.tasks.removeTask((EntityAIBase)this.aiMoveTowardsRestriction);
            }
            else {
                this.tasks.removeTask((EntityAIBase)this.aiArrowAttack);
            }
        }
        super.updateTasks(type);
    }
    
    @Override
    public void attackEntityWithRangedAttack(final EntityLivingBase p_82196_1_, final float p_82196_2_) {
        final EntityDart entityDart = new EntityDart(this.worldObj, (EntityLivingBase)this, p_82196_1_, 1.6f, (float)(14 - this.worldObj.difficultySetting.getDifficultyId() * 4));
        entityDart.setDamage(p_82196_2_ * 2.0f + this.rand.nextGaussian() * 0.25 + this.worldObj.difficultySetting.getDifficultyId() * 0.11f);
        this.playSound("random.bow", 1.0f, 1.0f / (this.getRNG().nextFloat() * 0.4f + 0.8f));
        this.worldObj.spawnEntityInWorld((Entity)entityDart);
    }
}
