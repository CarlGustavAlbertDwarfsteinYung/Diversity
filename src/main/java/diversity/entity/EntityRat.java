//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package diversity.entity;

import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityRat extends EntityCreature {
    public EntityRat(World world) {
        super(world);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIWander(this, 0.2D));
        this.tasks.addTask(1, new EntityAIWatchClosest(this, EntityLiving.class, 8.0F));
        this.setSize(0.2F, 0.3F);
    }

    @Override
    protected float getSoundVolume() {
        return 0.1F;
    }

    @Override
    protected float getSoundPitch() {
        return super.getSoundPitch() * 0.95F;
    }

    @Override
    protected String getHurtSound() {
        return "mob.bat.hurt";
    }

    @Override
    protected String getDeathSound() {
        return "mob.bat.death";
    }

    @Override
    public boolean canBePushed() {
        return true;
    }

    protected void collideWithEntity(EntityRat entity) {
        super.collideWithEntity(entity);
    }

    @Override
    protected void collideWithNearbyEntities() {
        List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(0.20000000298023224D, 0.0D, 0.20000000298023224D));
        if (list != null && !list.isEmpty()) {
            for(int i = 0; i < list.size(); ++i) {
                Entity entity = (Entity)list.get(i);
                if (entity instanceof EntityRat) {
                    this.collideWithEntity((EntityRat)entity);
                }
            }
        }

    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(4.0D);
    }

    @Override
    protected boolean isAIEnabled() {
        return true;
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
    }

    @Override
    protected void updateAITasks() {
        super.updateAITasks();
    }

    @Override
    protected boolean canTriggerWalking() {
        return true;
    }

    @Override
    protected void fall(float p_70069_1_) {
    }

    @Override
    protected void updateFallState(double p_70064_1_, boolean p_70064_3_) {
    }

    @Override
    public boolean doesEntityNotTriggerPressurePlate() {
        return true;
    }

    @Override
    public boolean attackEntityFrom(DamageSource p_70097_1_, float p_70097_2_) {
        return this.isEntityInvulnerable() ? false : super.attackEntityFrom(p_70097_1_, p_70097_2_);
    }

    @Override
    public boolean getCanSpawnHere() {
        int i = MathHelper.floor_double(this.boundingBox.minY);
        if (i >= 63) {
            return false;
        } else {
            int j = MathHelper.floor_double(this.posX);
            int k = MathHelper.floor_double(this.posZ);
            int l = this.worldObj.getBlockLightValue(j, i, k);
            byte b0 = 7;
            if (l > this.rand.nextInt(b0) && super.getCanSpawnHere()) {
                for(int x = j - 4; x < j + 5; ++x) {
                    for(int z = k - 4; z < k + 5; ++z) {
                        for(int y = i - 2; y < i + 3; ++y) {
                            if (this.worldObj.getBlock(x, y, z).getMaterial().equals(Blocks.water.getMaterial())) {
                                return true;
                            }
                        }
                    }
                }
            }

            return false;
        }
    }
}
