//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package diversity.entity;

import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntitySpider.GroupData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityDarkSpider extends EntitySpider {
    public float squishb;
    public float squishc;
    public float squishd;
    public float squishe;
    public float squishh;

    public EntityDarkSpider(World p_i1743_1_) {
        super(p_i1743_1_);
        this.setSize(2.8F, 1.8F);
        this.squishb = 0.0F;
        this.squishc = 0.0F;
        this.squishh = 1.0F;
        this.setPhase(0);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(120.0D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(10.0D);
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        if (this.getPhase() != 2) {
            this.squishe = this.squishb;
            this.squishd = this.squishc;
            this.squishc = (float)((double)this.squishc + 0.8D);
            if (this.squishc < 0.0F) {
                this.squishc = 0.0F;
            }

            if (this.squishc > 0.2F) {
                this.squishc = 0.2F;
            }

            if (this.squishh < 0.2F) {
                this.squishh = 0.2F;
            }

            this.squishh = (float)((double)this.squishh * 0.2D);
            this.squishb += this.squishh * 1.5F;
        }

        if (this.getPhase() == 0) {
            if (this.getHealth() < 80.0F) {
                this.spawnSpiders();
                this.setPhase(1);
            }
        } else if (this.getPhase() == 1) {
            if (this.getHealth() < 60.0F) {
                this.spawnSpiders();
                this.setPhase(2);
            }
        } else if (this.getPhase() == 2) {
            this.squishb = 0.0F;
            this.squishc = 0.0F;
            this.squishd = 0.0F;
            this.squishe = 0.0F;
            this.squishh = 1.0F;
        }

        if (this.findSpiders(8.0D) == null && (this.getAttackTarget() != null || this.getEntityToAttack() != null) && (this.getAttackTarget() != null && this.getAttackTarget().getDistanceSqToEntity(this) < 100.0D || this.getEntityToAttack() != null && this.getEntityToAttack().getDistanceSqToEntity(this) < 100.0D)) {
            this.spawnSpiders();
        }

        super.onUpdate();
    }

    @Override
    protected void attackEntity(Entity p_70785_1_, float p_70785_2_) {
        if (this.getPhase() == 2) {
            if (p_70785_2_ > 2.0F && p_70785_2_ < 6.0F && this.rand.nextInt(10) == 0) {
                if (this.onGround) {
                    double d0 = p_70785_1_.posX - this.posX;
                    double d1 = p_70785_1_.posZ - this.posZ;
                    float f2 = MathHelper.sqrt_double(d0 * d0 + d1 * d1);
                    this.motionX = d0 / (double)f2 * 0.5D * 0.800000011920929D + this.motionX * 0.20000000298023224D;
                    this.motionZ = d1 / (double)f2 * 0.5D * 0.800000011920929D + this.motionZ * 0.20000000298023224D;
                    this.motionY = 0.4000000059604645D;
                }
            } else if (this.attackTime <= 0 && p_70785_2_ < 3.6F && p_70785_1_.boundingBox.maxY > this.boundingBox.minY && p_70785_1_.boundingBox.minY < this.boundingBox.maxY) {
                this.attackTime = 20;
                this.attackEntityAsMob(p_70785_1_);
            }
        }

    }

    @Override
    public boolean isMovementCeased() {
        return this.getPhase() != 2;
    }

    public void spawnSpiders() {
        for(int i = 0; i < this.rand.nextInt(3) + 2; ++i) {
            if (!this.worldObj.isRemote) {
                EntitySpider entity = new EntitySpider(this.worldObj);
                entity.setLocationAndAngles(this.posX + this.rand.nextDouble(), this.posY, this.posZ + this.rand.nextDouble(), this.rotationYaw, 0.0F);
                if (this.getAttackTarget() != null) {
                    entity.setAttackTarget(this.getAttackTarget());
                }

                if (this.getEntityToAttack() != null) {
                    if (this.getEntityToAttack() instanceof EntityPlayer) {
                        entity.attackEntityFrom(DamageSource.causeMobDamage((EntityPlayer)this.getEntityToAttack()), 0.0F);
                    } else if (this.getEntityToAttack() instanceof EntityLivingBase) {
                        entity.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this.getEntityToAttack()), 0.0F);
                    }
                }

                this.worldObj.spawnEntityInWorld(entity);
            }

            for(int j = 0; j < 12; ++j) {
                this.worldObj.spawnParticle("cloud", this.posX + (double)(this.rand.nextFloat() - this.rand.nextFloat()), this.posY + 1.0D + (double)(this.rand.nextFloat() - this.rand.nextFloat()), this.posZ + (double)(this.rand.nextFloat() - this.rand.nextFloat()), 0.0D, 0.0D, 0.0D);
            }
        }

    }

    public EntitySpider findSpiders(double d) {
        List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(d, 4.0D, d));

        for(int i = 0; i < list.size(); ++i) {
            Entity entity = (Entity)list.get(i);
            if (entity != null && entity instanceof EntitySpider) {
                EntitySpider entityspider = (EntitySpider)entity;
                return entityspider;
            }
        }

        return null;
    }

    @Override
    public boolean canBePushed() {
        return false;
    }

    @Override
    public boolean canBeCollidedWith() {
        return !this.isDead;
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(18, (byte)0);
    }

    public int getPhase() {
        return this.dataWatcher.getWatchableObjectByte(18);
    }

    public void setPhase(int par1) {
        this.dataWatcher.updateObject(18, (byte)par1);
    }

    @Override
    protected boolean canDespawn() {
        return false;
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nbttagcompound) {
        super.writeEntityToNBT(nbttagcompound);
        nbttagcompound.setInteger("Phase", this.getPhase());
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nbttagcompound) {
        super.readEntityFromNBT(nbttagcompound);
        this.setPhase(nbttagcompound.getInteger("Phase"));
    }

    @Override
    public IEntityLivingData onSpawnWithEgg(IEntityLivingData p_110161_1_) {
        Object p_110161_1_1 = super.onSpawnWithEgg(p_110161_1_);
        if (p_110161_1_1 == null) {
            p_110161_1_1 = new GroupData();
            if (this.worldObj.difficultySetting == EnumDifficulty.HARD && this.worldObj.rand.nextFloat() < 0.1F * this.worldObj.func_147462_b(this.posX, this.posY, this.posZ)) {
                ((GroupData)p_110161_1_1).func_111104_a(this.worldObj.rand);
            }
        }

        if (p_110161_1_1 instanceof GroupData) {
            int i = ((GroupData)p_110161_1_1).field_111105_a;
            if (i > 0 && Potion.potionTypes[i] != null) {
                this.addPotionEffect(new PotionEffect(i, 2147483647));
            }
        }

        return (IEntityLivingData)p_110161_1_1;
    }
}
