//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package diversity.entity;

import java.util.List;
import java.util.UUID;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.server.management.PreYggdrasilConverter;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityYeti extends EntityMob {
    Item[] foodItems;
    private int eatingTimer;

    public EntityYeti(World world) {
        super(world);
        this.foodItems = new Item[]{Items.porkchop, Items.beef, Items.cooked_beef, Items.cooked_porkchop, Items.chicken, Items.cooked_chicken};
        this.setSize(1.7F, 3.0F);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIAttackOnCollide(this, EntityLivingBase.class, 1.0D, false));
        this.tasks.addTask(2, new EntityAIMoveTowardsRestriction(this, 1.0D));
        this.tasks.addTask(3, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(4, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityLivingBase.class, 0, true));
        this.setHungryAmount(2500.0F);
        this.setOwnerUUID("");
        this.setAttackTimer(20.0F);
        this.eatingTimer = 0;
    }

    @Override
    protected void attackEntity(Entity p_70785_1_, float p_70785_2_) {
        if (p_70785_1_ != this && this.attackTime <= 0 && p_70785_2_ < 3.5F && p_70785_1_.boundingBox.maxY > this.boundingBox.minY && p_70785_1_.boundingBox.minY < this.boundingBox.maxY) {
            this.attackTime = 20;
            this.attackEntityAsMob(p_70785_1_);
            this.setAttackTimer(0.0F);
        }

    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.8000000041723251D);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(100.0D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(10.0D);
    }

    @Override
    protected Entity findPlayerToAttack() {
        EntityPlayer entityplayer;
        if (this.getHungryAmount() > 4500.0F && this.eatingTimer <= 0) {
            entityplayer = this.worldObj.getClosestVulnerablePlayerToEntity(this, 12.0D);
            if (entityplayer != null && !entityplayer.getUniqueID().toString().equals(this.getOwnerUUID())) {
                return entityplayer != null && this.canEntityBeSeen(entityplayer) ? entityplayer : null;
            }
        } else if (this.getHungryAmount() > 2500.0F && this.eatingTimer <= 0) {
            entityplayer = this.worldObj.getClosestVulnerablePlayerToEntity(this, 4.0D);
            if (entityplayer != null && !entityplayer.getUniqueID().toString().equals(this.getOwnerUUID())) {
                return entityplayer != null && this.canEntityBeSeen(entityplayer) ? entityplayer : null;
            }
        }

        return null;
    }

    protected Entity findEnemyToAttack() {
        List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(8.0D, 4.0D, 8.0D));

        for(int i = 0; i < list.size(); ++i) {
            Entity entity = (Entity)list.get(i);
            if (entity != null && (entity instanceof EntitySlime || entity instanceof EntityMob || entity instanceof EntityAnimal && this.getHungryAmount() > 4500.0F)) {
                this.entityToAttack = entity;
            }
        }

        return null;
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        if (this.getAttackTimer() < 20.0F) {
            this.setAttackTimer(this.getAttackTimer() + 1.0F);
        }

        if (this.getHungryAmount() > 2500.0F && this.entityToAttack == null && this.eatingTimer <= 0) {
            EntityItem item = this.findItemsOnGround(this.foodItems);
            EntityPlayer player = this.findPlayerWithItems(this.foodItems);
            PathEntity pathToPlayer;
            if (item != null) {
                pathToPlayer = this.worldObj.getPathEntityToEntity(this, item, 16.0F, true, false, false, true);
                this.setPathToEntity(pathToPlayer);
                if ((double)this.getDistanceToEntity(item) <= 2.5D) {
                    if (!this.worldObj.isRemote && --item.getEntityItem().stackSize == 0) {
                        item.setDead();
                    }

                    EntityPlayer player1 = this.worldObj.getClosestPlayerToEntity(this, 12.0D);
                    if (player1 != null) {
                        this.setOwnerUUID(player1.getUniqueID().toString());
                    }

                    this.setCurrentItemOrArmor(0, item.getEntityItem());
                    this.eatingTimer = 50;
                }
            } else if (player != null) {
                if ((double)this.getDistanceToEntity(player) >= 5.0D) {
                    pathToPlayer = this.worldObj.getPathEntityToEntity(this, player, 16.0F, true, false, false, true);
                    this.setPathToEntity(pathToPlayer);
                } else {
                    this.setPathToEntity((PathEntity)null);
                }
            }
        } else {
            this.followAndDefendPal();
        }

        if (this.entityToAttack == null) {
            this.findEnemyToAttack();
        }

        if (this.getHungryAmount() < 5000.0F) {
            this.setHungryAmount(this.getHungryAmount() + 1.0F);
        } else {
            this.setHungryAmount(5000.0F);
        }

        if (this.getHungryAmount() > 4500.0F) {
            this.worldObj.spawnParticle("smoke", this.posX + (double)(this.rand.nextFloat() - this.rand.nextFloat()), this.posY + 3.5D + (double)(this.rand.nextFloat() - this.rand.nextFloat()), this.posZ + (double)(this.rand.nextFloat() - this.rand.nextFloat()), 0.0D, 0.0D, 0.0D);
        }

        if (this.eatingTimer > 0 && this.getHeldItem() != null) {
            this.entityToAttack = null;
            --this.eatingTimer;
            String s = "iconcrack_" + Item.getIdFromItem(this.getHeldItem().getItem());
            if (this.getHeldItem().getHasSubtypes()) {
                s = s + "_" + this.getHeldItem().getItemDamage();
            }

            if (this.eatingTimer % 2 == 0) {
                this.worldObj.spawnParticle(s, this.posX, this.posY + 3.5D, this.posZ - 1.4D, (double)(this.rand.nextFloat() - this.rand.nextFloat()), 0.1D, (double)(this.rand.nextFloat() - this.rand.nextFloat()));
                this.playSound("random.eat", 0.5F + 0.5F * (float)this.rand.nextInt(2), (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
            }

            if (this.eatingTimer == 1) {
                this.setHungryAmount(0.0F);
                this.setCurrentItemOrArmor(0, (ItemStack)null);
                this.eatingTimer = 0;

                for(int i = 0; i < 8; ++i) {
                    this.worldObj.spawnParticle("heart", this.posX + (double)(this.rand.nextFloat() - this.rand.nextFloat()), this.posY + 3.5D + (double)(this.rand.nextFloat() - this.rand.nextFloat()), this.posZ + (double)(this.rand.nextFloat() - this.rand.nextFloat()), 0.0D, 0.0D, 0.0D);
                }

                this.setHealth(100.0F);
            }
        }

    }

    @Override
    protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_) {
        this.playSound("mob.cow.step", 0.15F, 1.0F);
    }

    public EntityPlayer findPlayerWithItems(Item[] items) {
        EntityPlayer player = this.worldObj.getClosestPlayerToEntity(this, 12.0D);
        if (player != null && player.getHeldItem() != null) {
            ItemStack useItem = player.getHeldItem();

            for(int j = 0; j < items.length; ++j) {
                if (useItem.getItem() == items[j]) {
                    return player;
                }
            }
        }

        return null;
    }

    public void followAndDefendPal() {
        EntityPlayer player = this.worldObj.getClosestPlayerToEntity(this, 12.0D);
        if (player != null && player.getUniqueID().toString().equals(this.getOwnerUUID())) {
            if (player.getLastAttacker() != null) {
                this.entityToAttack = player.getLastAttacker();
            } else if (player.getAITarget() != null) {
                this.entityToAttack = player.getAITarget();
            } else if ((double)this.getDistanceToEntity(player) >= 3.5D) {
                PathEntity pathToPlayer = this.worldObj.getPathEntityToEntity(this, player, 12.0F, true, false, false, true);
                this.setPathToEntity(pathToPlayer);
            } else {
                this.setPathToEntity((PathEntity)null);
            }
        }

    }

    public EntityItem findItemsOnGround(Item[] items) {
        List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(8.0D, 4.0D, 8.0D));

        for(int i = 0; i < list.size(); ++i) {
            Entity entity = (Entity)list.get(i);
            if (entity != null && entity instanceof EntityItem && entity instanceof EntityItem) {
                EntityItem item = (EntityItem)entity;
                ItemStack stack = item.getEntityItem();

                for(int j = 0; j < items.length; ++j) {
                    if (stack != null && stack.getItem() == items[j]) {
                        return item;
                    }
                }
            }
        }

        return null;
    }

    @Override
    public boolean interact(EntityPlayer entityplayer) {
        ItemStack itemstack = entityplayer.inventory.getCurrentItem();
        if (itemstack != null && this.getHungryAmount() > 2500.0F) {
            for(int i = 0; i < this.foodItems.length; ++i) {
                if (itemstack.getItem() == this.foodItems[i]) {
                    if (--itemstack.stackSize == 0) {
                        entityplayer.inventory.setInventorySlotContents(entityplayer.inventory.currentItem, (ItemStack)null);
                    }

                    this.setCurrentItemOrArmor(0, itemstack);
                    this.setOwnerUUID(entityplayer.getUniqueID().toString());
                    this.eatingTimer = 50;
                    this.entityToAttack = null;
                    return true;
                }
            }
        }

        return super.interact(entityplayer);
    }

    @Override
    public boolean attackEntityFrom(DamageSource p_70097_1_, float p_70097_2_) {
        if (super.attackEntityFrom(p_70097_1_, p_70097_2_)) {
            this.motionX *= 0.1D;
            this.motionZ *= 0.1D;
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(18, new Float(0.0F));
        this.dataWatcher.addObject(19, "");
        this.dataWatcher.addObject(20, new Float(0.0F));
    }

    public float getHungryAmount() {
        return this.dataWatcher.getWatchableObjectFloat(18);
    }

    public void setHungryAmount(float p_152115_1_) {
        this.dataWatcher.updateObject(18, p_152115_1_);
    }

    public float getAttackTimer() {
        return this.dataWatcher.getWatchableObjectFloat(20);
    }

    public void setAttackTimer(float p_152115_1_) {
        this.dataWatcher.updateObject(20, p_152115_1_);
    }

    @Override
    protected boolean canDespawn() {
        return false;
    }

    @Override
    protected float getSoundPitch() {
        return (this.rand.nextFloat() - this.rand.nextFloat()) * 0.5F + 0.1F;
    }

    @Override
    protected String getHurtSound() {
        return "mob.villager.hit";
    }

    @Override
    protected String getLivingSound() {
        return "mob.villager.idle";
    }

    @Override
    protected String getDeathSound() {
        return "mob.villager.death";
    }

    public String getOwnerUUID() {
        return this.dataWatcher.getWatchableObjectString(19);
    }

    public void setOwnerUUID(String p_152115_1_) {
        this.dataWatcher.updateObject(19, p_152115_1_);
    }

    public EntityLivingBase getOwner() {
        try {
            UUID uuid = UUID.fromString(this.getOwnerUUID());
            return uuid == null ? null : this.worldObj.func_152378_a(uuid);
        } catch (IllegalArgumentException var2) {
            return null;
        }
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nbttagcompound) {
        super.writeEntityToNBT(nbttagcompound);
        nbttagcompound.setFloat("Hungry", this.getHungryAmount());
        nbttagcompound.setFloat("Timer", this.getAttackTimer());
        if (this.getOwnerUUID() == null) {
            nbttagcompound.setString("OwnerUUID", "");
        } else {
            nbttagcompound.setString("OwnerUUID", this.getOwnerUUID());
        }

    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nbttagcompound) {
        super.readEntityFromNBT(nbttagcompound);
        this.setHungryAmount(nbttagcompound.getFloat("Hungry"));
        this.setAttackTimer(nbttagcompound.getFloat("Timer"));
        String var2 = nbttagcompound.getString("Owner");
        String s = "";
        if (nbttagcompound.hasKey("OwnerUUID", 8)) {
            s = nbttagcompound.getString("OwnerUUID");
        } else {
            String s1 = nbttagcompound.getString("Owner");
            s = PreYggdrasilConverter.func_152719_a(s1);
        }

        if (s.length() > 0) {
            this.setOwnerUUID(s);
        }

    }
}
