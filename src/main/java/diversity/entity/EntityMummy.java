// 
// Decompiled by Procyon v0.5.36
// 

package diversity.entity;

import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.ai.EntityAIBreakDoor;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.world.World;
import net.minecraft.entity.monster.EntityMob;

public class EntityMummy extends EntityMob
{
    public EntityMummy(final World world) {
        super(world);
        this.getNavigator().setBreakDoors(true);
        this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.tasks.addTask(1, (EntityAIBase)new EntityAIBreakDoor((EntityLiving)this));
        this.tasks.addTask(2, (EntityAIBase)new EntityAIAttackOnCollide((EntityCreature)this, (Class)EntityPlayer.class, 1.0, false));
        this.tasks.addTask(5, (EntityAIBase)new EntityAIMoveTowardsRestriction((EntityCreature)this, 1.0));
        this.tasks.addTask(7, (EntityAIBase)new EntityAIWander((EntityCreature)this, 1.0));
        this.tasks.addTask(8, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 8.0f));
        this.tasks.addTask(8, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, true));
        this.targetTasks.addTask(2, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityPlayer.class, 0, true));
        this.setSize(0.6f, 1.8f);
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(40.0);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(20.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.20000000417232514);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(6.0);
    }
    
    @Override
    protected void entityInit() {
        super.entityInit();
        this.getDataWatcher().addObject(12, (byte)0);
        this.getDataWatcher().addObject(13, (byte)0);
        this.getDataWatcher().addObject(14, (byte)0);
    }
    
    @Override
    protected boolean isAIEnabled() {
        return true;
    }
    
    @Override
    public boolean isChild() {
        return  this.getDataWatcher().getWatchableObjectByte(12) == (byte)1;
    }
    
    @Override
    protected int getExperiencePoints(final EntityPlayer p_70693_1_) {
        return super.getExperiencePoints(p_70693_1_);
    }
    
    public void setChild(final boolean p_82227_1_) {
        this.getDataWatcher().updateObject(12, (Object)(byte)(p_82227_1_ ? 1 : 0));
    }
    
    @Override
    protected Item getDropItem() {
        return Items.rotten_flesh;
    }
    
    @Override
    public EnumCreatureAttribute getCreatureAttribute() {
        return EnumCreatureAttribute.UNDEAD;
    }
    
    protected void dropFewItems(final int p_70600_1_) {
        this.dropItem(Items.rotten_flesh, 2 + this.rand.nextInt(2));
        this.dropItem(Items.paper, 2 + this.rand.nextInt(4));
    }
    
    @Override
    protected void dropRareDrop(final int p_70600_1_) {
        switch (this.rand.nextInt(3)) {
            case 0: {
                this.dropItem((Item)Items.golden_helmet, 1);
                break;
            }
            case 1: {
                this.dropItem(Items.golden_hoe, 1);
                break;
            }
            case 2: {
                this.dropItem(Items.golden_sword, 1);
                break;
            }
        }
        this.dropItem(Items.gold_nugget, 6 + this.rand.nextInt(6));
    }
    
    @Override
    public void writeEntityToNBT(final NBTTagCompound p_70014_1_) {
        super.writeEntityToNBT(p_70014_1_);
        if (this.isChild()) {
            p_70014_1_.setBoolean("IsBaby", true);
        }
    }
    
    @Override
    public void readEntityFromNBT(final NBTTagCompound p_70037_1_) {
        super.readEntityFromNBT(p_70037_1_);
        if (p_70037_1_.getBoolean("IsBaby")) {
            this.setChild(true);
        }
    }
    
    @Override
    public void onLivingUpdate() {
        this.worldObj.spawnParticle("reddust", this.posX, this.posY + 1.666, this.posZ, 1.0, 0.0, 0.0);
        if (this.isRiding() && this.getAttackTarget() != null && this.ridingEntity instanceof EntityChicken) {
            ((EntityLiving)this.ridingEntity).getNavigator().setPath(this.getNavigator().getPath(), 1.5);
        }
        super.onLivingUpdate();
    }
    
    @Override
    public boolean attackEntityFrom(final DamageSource p_70097_1_, final float p_70097_2_) {
        return super.attackEntityFrom(p_70097_1_, p_70097_2_);
    }
    
    @Override
    public void onUpdate() {
        super.onUpdate();
    }
    
    @Override
    public boolean attackEntityAsMob(final Entity p_70652_1_) {
        final boolean flag = super.attackEntityAsMob(p_70652_1_);
        if (flag) {
            final int i = this.worldObj.difficultySetting.getDifficultyId();
            if (this.getHeldItem() == null && this.isBurning() && this.rand.nextFloat() < i * 0.3f) {
                p_70652_1_.setFire(2 * i);
            }
        }
        return flag;
    }
    
    @Override
    protected boolean canDespawn() {
        return false;
    }
}
