// 
// Decompiled by Procyon v0.5.36
// 

package diversity.entity;

import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;
import diversity.suppliers.EnumVillager;
import diversity.suppliers.EnumTribe;
import net.minecraft.world.World;

public class EntityDwarf extends EntityGlobalVillager
{
    public EntityDwarf(final World world) {
        this(world, EnumTribe.DWARF.getRandomVillager());
    }
    
    public EntityDwarf(final World world, final EnumVillager type) {
        super(world, type);
        this.setSize(0.6f, 1.2f);
        if (this.rand.nextBoolean()) {
            this.setCurrentItemOrArmor(0, new ItemStack(Items.iron_axe));
        }
        else {
            this.setCurrentItemOrArmor(0, new ItemStack(Items.iron_sword));
        }
    }
    
    @Override
    public ItemStack getHeldItem() {
        return (this.canDefend() && !this.isChild()) ? super.getHeldItem() : ((this.isMiner() && !this.isChild()) ? new ItemStack(Items.iron_pickaxe) : null);
    }
    
    @Override
    public EntityVillager createChild(final EntityAgeable p_90011_1_) {
        final EntityGlobalVillager entityvillager = new EntityDwarf(this.worldObj);
        entityvillager.onSpawnWithEgg(null);
        return entityvillager;
    }
    
    @Override
    protected boolean canAskForHelp() {
        return this.getProfession() == EnumVillager.DWARF_KING.profession;
    }
    
    public boolean isMiner() {
        return this.getProfession() == EnumVillager.DWARF_MINER.profession;
    }
    
    @Override
    public boolean canDefend() {
        return this.getProfession() == EnumVillager.DWARF_WARRIOR.profession;
    }
}
