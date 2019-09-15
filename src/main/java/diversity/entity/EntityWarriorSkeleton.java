// 
// Decompiled by Procyon v0.5.36
// 

package diversity.entity;

import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.init.Blocks;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.block.Block;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIBreakDoor;
import net.minecraft.entity.EntityCreature;
import net.minecraft.world.World;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.monster.EntityMob;

public class EntityWarriorSkeleton extends EntityMob
{
    private EntityAIWander aiWander;
    private boolean canWander;
    
    public EntityWarriorSkeleton(final World world) {
        this(world, true);
    }
    
    public EntityWarriorSkeleton(final World world, final boolean canWander) {
        super(world);
        this.aiWander = new EntityAIWander((EntityCreature)this, 1.0);
        this.canWander = canWander;
        this.getNavigator().setBreakDoors(true);
        this.tasks.addTask(1, (EntityAIBase)new EntityAIBreakDoor((EntityLiving)this));
        this.tasks.addTask(2, (EntityAIBase)new EntityAIAttackOnCollide((EntityCreature)this, (Class)EntityPlayer.class, 1.0, false));
        this.tasks.addTask(5, (EntityAIBase)new EntityAIMoveTowardsRestriction((EntityCreature)this, 1.0));
        if (canWander) {
            this.tasks.addTask(7, (EntityAIBase)this.aiWander);
        }
        this.tasks.addTask(8, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 8.0f));
        this.tasks.addTask(8, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, true));
        this.targetTasks.addTask(2, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityPlayer.class, 0, true));
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(30.0);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(10.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(5.0);
    }
    
    @Override
    protected void entityInit() {
        super.entityInit();
        this.getDataWatcher().addObject(12, (byte)0);
        this.getDataWatcher().addObject(13, (byte)0);
        this.getDataWatcher().addObject(14, (byte)0);
    }
    
    @Override
    protected String getLivingSound() {
        return "mob.skeleton.say";
    }
    
    @Override
    protected String getHurtSound() {
        return "mob.skeleton.hurt";
    }
    
    @Override
    protected String getDeathSound() {
        return "mob.skeleton.death";
    }
    
    @Override
    protected void func_145780_a(final int p_145780_1_, final int p_145780_2_, final int p_145780_3_, final Block p_145780_4_) {
        this.playSound("mob.skeleton.step", 0.15f, 1.0f);
    }
    
    @Override
    protected boolean isAIEnabled() {
        return true;
    }

    @Override
    public boolean isChild() {
        return this.getDataWatcher().getWatchableObjectByte(12) == (byte)1;
    }
    
    @Override
    protected int getExperiencePoints(final EntityPlayer p_70693_1_) {
        return super.getExperiencePoints(p_70693_1_);
    }
    
    public void setChild(final boolean p_82227_1_) {
        this.getDataWatcher().updateObject(12, (byte)(p_82227_1_ ? 1 : 0));
    }
    
    @Override
    protected Item getDropItem() {
        return Items.bone;
    }
    
    @Override
    public EnumCreatureAttribute getCreatureAttribute() {
        return EnumCreatureAttribute.UNDEAD;
    }
    
    protected void dropFewItems(final int p_70600_1_) {
        this.dropItem(Items.bone, 3 + this.rand.nextInt(3));
        this.dropItem(Item.getItemFromBlock(Blocks.vine), this.rand.nextInt(3));
    }
    
    @Override
    protected void dropRareDrop(final int p_70600_1_) {
        if (this.rand.nextBoolean()) {
            this.dropItem(Items.skull, 1);
        }
        this.dropItem(Items.gold_nugget, this.rand.nextInt(6));
    }
    
    @Override
    public void writeEntityToNBT(final NBTTagCompound p_70014_1_) {
        super.writeEntityToNBT(p_70014_1_);
        p_70014_1_.setBoolean("CanWander", this.canWander);
    }
    
    @Override
    public void readEntityFromNBT(final NBTTagCompound p_70037_1_) {
        super.readEntityFromNBT(p_70037_1_);
        if (!(this.canWander = p_70037_1_.getBoolean("CanWander"))) {
            this.tasks.removeTask((EntityAIBase)this.aiWander);
        }
    }
    
    @Override
    public void onLivingUpdate() {
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
        return this.canWander;
    }
}
