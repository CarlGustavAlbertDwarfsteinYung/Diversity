// 
// Decompiled by Procyon v0.5.36
// 

package diversity.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import diversity.item.ItemSpear;
import net.minecraft.util.IIcon;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import cpw.mods.fml.common.registry.VillagerRegistry;
import diversity.configurations.ConfigVillager;
import java.util.Random;
import diversity.utils.VillageData;
import net.minecraft.util.MathHelper;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.SharedMonsterAttributes;
import diversity.Diversity;
import diversity.entity.ai.EntityAIOpenGate;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest2;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.ai.EntityAIPlay;
import net.minecraft.entity.ai.EntityAIFollowGolem;
import net.minecraft.entity.ai.EntityAIVillagerMate;
import net.minecraft.entity.ai.EntityAIOpenDoor;
import net.minecraft.entity.ai.EntityAIRestrictOpenDoor;
import net.minecraft.entity.ai.EntityAIMoveIndoors;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAISwimming;
import diversity.entity.ai.EntityAIChiefHurtByTarget;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import diversity.suppliers.EnumVillager;
import net.minecraft.world.World;
import net.minecraft.entity.ai.EntityAILookAtTradePlayer;
import net.minecraft.entity.ai.EntityAITradePlayer;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAIBase;
import diversity.suppliers.EnumTribe;
import net.minecraft.village.Village;
import net.minecraft.entity.passive.EntityVillager;

public abstract class EntityGlobalVillager extends EntityVillager
{
    private Village villageObj;
    public final EnumTribe tribe;
    private int randomTickDivider;
    private EntityAIBase askForHelp;
    protected EntityAIBase attackOnCollide;
    protected EntityAIMoveTowardsRestriction aiMoveTowardsRestriction;
    private EntityAIBase chiefHurt;
    private EntityAIBase entityHurt;
    private EntityAITradePlayer aiTradePlayer;
    private EntityAILookAtTradePlayer aiLookAtTradePlayer;
    
    public EntityGlobalVillager(final World world) {
        this(world, EnumVillager.SETTLED_VILLAGER);
    }
    
    public EntityGlobalVillager(final World world, final EnumVillager type) {
        super(world, type.profession);
        this.askForHelp = new EntityAIHurtByTarget(this, true);
        this.attackOnCollide = new EntityAIAttackOnCollide(this, 1.0, false);
        this.aiMoveTowardsRestriction = new EntityAIMoveTowardsRestriction(this, 1.0);
        this.chiefHurt = new EntityAIChiefHurtByTarget(this);
        this.entityHurt = new EntityAIHurtByTarget(this, true);
        this.aiTradePlayer = new EntityAITradePlayer(this);
        this.aiLookAtTradePlayer = new EntityAILookAtTradePlayer(this);
        this.tasks.taskEntries.clear();
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIAvoidEntity(this, EntityZombie.class, 8.0f, 0.6, 0.6));
        this.tasks.addTask(2, this.aiTradePlayer);
        this.tasks.addTask(2, this.aiLookAtTradePlayer);
        this.tasks.addTask(3, new EntityAIMoveIndoors(this));
        this.tasks.addTask(4, new EntityAIRestrictOpenDoor(this));
        this.tasks.addTask(5, new EntityAIOpenDoor(this, true));
        this.tasks.addTask(7, new EntityAIVillagerMate(this));
        this.tasks.addTask(8, new EntityAIFollowGolem(this));
        this.tasks.addTask(9, new EntityAIPlay(this, 0.32));
        this.tasks.addTask(10, new EntityAIWatchClosest2(this, EntityPlayer.class, 3.0f, 1.0f));
        this.tasks.addTask(10, new EntityAIWatchClosest2(this, EntityVillager.class, 5.0f, 0.02f));
        this.tasks.addTask(10, new EntityAIWander(this, 0.6));
        this.tasks.addTask(11, new EntityAIWatchClosest(this, EntityLiving.class, 8.0f));
        this.tasks.addTask(5, new EntityAIOpenGate(this, true));
        this.tribe = type.tribe;
        this.updateTasks(type);
    }
    
    public void updateTasks(final EnumVillager type) {
        if (this.canAskForHelp() && !this.isChild()) {
            this.targetTasks.addTask(1, this.askForHelp);
        }
        else {
            this.targetTasks.removeTask(this.askForHelp);
        }
        if (this.canDefend() && !this.isChild()) {
            if (type != EnumVillager.TIBETAN_MONK) {
                this.tasks.removeTask(this.aiTradePlayer);
                this.tasks.removeTask(this.aiLookAtTradePlayer);
            }
            this.tasks.addTask(1, this.attackOnCollide);
            this.tasks.addTask(1, this.aiMoveTowardsRestriction);
            this.targetTasks.addTask(2, this.chiefHurt);
            this.targetTasks.addTask(3, this.entityHurt);
        }
        else {
            this.tasks.removeTask(this.attackOnCollide);
            this.tasks.removeTask(this.aiMoveTowardsRestriction);
            this.targetTasks.removeTask(this.chiefHurt);
            this.targetTasks.removeTask(this.entityHurt);
            this.tasks.addTask(2, this.aiTradePlayer);
            this.tasks.addTask(2, this.aiLookAtTradePlayer);
        }
        this.setCustomNameTag(Diversity.proxy.getI18format(type));
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        final IAttributeInstance attribute = this.getEntityAttribute(SharedMonsterAttributes.attackDamage);
        if (attribute != null) {
            attribute.setBaseValue(2.0);
        }
        else {
            this.getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage);
        }
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.36000001192092895);
    }
    
    protected abstract boolean canAskForHelp();
    
    public abstract boolean canDefend();
    
    public boolean isChief() {
        return EnumVillager.findEnum(this.getProfession()).isChief;
    }
    
    public void setChief() {
        final EnumVillager villager = EnumVillager.findEnum(this.getProfession()).tribe.findChief();
        if (villager != null && villager.isChief) {
            this.setProfession(villager.profession);
            this.updateTasks(villager);
        }
    }
    
    @Override
    public IEntityLivingData onSpawnWithEgg(IEntityLivingData p_110161_1_) {
        p_110161_1_ = super.onSpawnWithEgg(p_110161_1_);
        this.setRandomProfession();
        return p_110161_1_;
    }
    
    private void setRandomProfession() {
        do {
            this.setProfession(this.getEnumTribe().getRandomVillager().profession);
        } while (this.isChief());
        this.updateTasks(EnumVillager.findEnum(this.getProfession()));
    }
    
    private EnumTribe getEnumTribe() {
        return EnumTribe.getEnumTribe(this);
    }
    
    @Override
    protected void updateAITick() {
        super.updateAITick();
        final int randomTickDivider = this.randomTickDivider - 1;
        this.randomTickDivider = randomTickDivider;
        if (randomTickDivider <= 0) {
            this.randomTickDivider = 70 + this.rand.nextInt(50);
            this.villageObj = this.worldObj.villageCollectionObj.findNearestVillage(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ), 32);
            if (this.villageObj != null) {
                if (this.villageObj.isAnnihilated()) {
                    VillageData.onAnihilated(this.villageObj);
                    return;
                }
                final EntityGlobalVillager chief = (EntityGlobalVillager)this.getChief();
                if (this.isChief()) {
                    if (chief == null) {
                        VillageData.addChief(this.villageObj, this);
                    }
                    else if (!chief.equals(this)) {
                        this.setRandomProfession();
                    }
                }
                else {
                    final Random random = new Random();
                    if (chief == null && random.nextInt(ConfigVillager.TICK_UNTIL_RANDOM_VILLAGER_BECOMES_CHIEF.getIntegerConfig()) == 0) {
                        VillageData.addChief(this.villageObj, this);
                        if (this.isChief()) {
                            this.getRecipes(null).clear();
                            VillagerRegistry.manageVillagerTrades(this.getRecipes(null), this, this.getProfession(), this.rand);
                            this.worldObj.spawnParticle("reddust", this.posX, this.posY + 1.666, this.posZ, 1.0, 1.0, 1.0);
                            this.worldObj.spawnParticle("reddust", this.posX - 0.5, this.posY + 1.666, this.posZ, 1.0, 1.0, 1.0);
                            this.worldObj.spawnParticle("reddust", this.posX + 0.5, this.posY + 1.666, this.posZ, 1.0, 1.0, 1.0);
                            this.worldObj.spawnParticle("reddust", this.posX, this.posY + 1.666, this.posZ - 0.5, 1.0, 1.0, 1.0);
                            this.worldObj.spawnParticle("reddust", this.posX, this.posY + 1.666, this.posZ + 0.5, 1.0, 1.0, 1.0);
                        }
                    }
                }
            }
        }
    }
    
    @Override
    protected void attackEntity(final Entity p_70785_1_, final float p_70785_2_) {
        if (this.attackTime <= 0 && p_70785_2_ < 2.0f && p_70785_1_.boundingBox.maxY > this.boundingBox.minY && p_70785_1_.boundingBox.minY < this.boundingBox.maxY) {
            this.attackTime = 20;
            this.attackEntityAsMob(p_70785_1_);
        }
    }
    
    @Override
    public boolean attackEntityAsMob(final Entity p_70652_1_) {
        float f = (float)this.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
        int i = 0;
        if (p_70652_1_ instanceof EntityLivingBase) {
            f += EnchantmentHelper.getEnchantmentModifierLiving(this, (EntityLivingBase)p_70652_1_);
            i += EnchantmentHelper.getKnockbackModifier(this, (EntityLivingBase)p_70652_1_);
        }
        final boolean flag = p_70652_1_.attackEntityFrom(DamageSource.causeMobDamage(this), f);
        return flag;
    }
    
    @Override
    protected void onDeathUpdate() {
        if (this.isChief()) {
            VillageData.onDeadChief(this.villageObj = this.worldObj.villageCollectionObj.findNearestVillage(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ), 32));
        }
        super.onDeathUpdate();
    }
    
    @Override
    protected Item getDropItem() {
        return Items.gold_nugget;
    }
    
    @Override
    protected void dropFewItems(final boolean p_70628_1_, final int p_70628_2_) {
        if (!this.canDefend() && !this.isChild()) {
            this.dropItem(Items.gold_nugget, 2 + this.rand.nextInt(4));
        }
    }
    
    @Override
    protected void dropEquipment(final boolean p_82160_1_, final int p_82160_2_) {
        if (this.canDefend() && !this.isChild()) {
            super.dropEquipment(p_82160_1_, p_82160_2_);
        }
    }
    
    public boolean func_142018_a(final EntityLivingBase p_142018_1_, final EntityLivingBase p_142018_2_) {
        if (!(p_142018_1_ instanceof EntityCreeper) && !(p_142018_1_ instanceof EntityGhast)) {
            if (p_142018_1_ instanceof EntityWolf) {
                final EntityWolf entitywolf = (EntityWolf)p_142018_1_;
                if (entitywolf.isTamed() && entitywolf.getOwner() == p_142018_2_) {
                    return false;
                }
            }
            return (!(p_142018_1_ instanceof EntityPlayer) || !(p_142018_2_ instanceof EntityGlobalVillager)) && (!(p_142018_1_ instanceof EntityHorse) || !((EntityHorse)p_142018_1_).isTame());
        }
        return false;
    }
    
    @Override
    public boolean interact(final EntityPlayer p_70085_1_) {
        return !this.canDefend() && super.interact(p_70085_1_);
    }
    
    public EntityLivingBase getChief() {
        if (this.villageObj != null) {
            return VillageData.getChief(this.villageObj);
        }
        return null;
    }
    
    @Override
    public boolean hasCustomNameTag() {
        return false;
    }
    
    @Override
    public ItemStack getHeldItem() {
        return (this.canDefend() && !this.isChild()) ? super.getHeldItem() : null;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getItemIcon(final ItemStack p_70620_1_, final int p_70620_2_) {
        if (p_70620_1_.getItem() instanceof ItemSpear) {
            return p_70620_1_.getItem().getIcon(p_70620_1_, 0);
        }
        return p_70620_1_.getItem().requiresMultipleRenderPasses() ? p_70620_1_.getItem().getIconFromDamageForRenderPass(p_70620_1_.getItemDamage(), p_70620_2_) : p_70620_1_.getIconIndex();
    }
}
