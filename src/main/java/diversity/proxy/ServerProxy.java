// 
// Decompiled by Procyon v0.5.36
// 

package diversity.proxy;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import diversity.suppliers.EnumItem;
import diversity.suppliers.EnumVillager;
import diversity.suppliers.EnumEntity;
import diversity.suppliers.EnumTribe;
import net.minecraftforge.common.MinecraftForge;

public class ServerProxy
{
    public ServerHandler handler;
    
    public void registerHandler() {
        this.handler = new ServerHandler();
        MinecraftForge.TERRAIN_GEN_BUS.register((Object)this.handler);
        MinecraftForge.EVENT_BUS.register((Object)this.handler);
    }
    
    public void registerRenderers() {
    }
    
    public Integer[] searchEggColor(final EnumTribe tribe) {
        return new Integer[] { 0, 0 };
    }
    
    public Integer[] searchEggColor(final EnumEntity monster) {
        return new Integer[] { 0, 0 };
    }
    
    public void registerVillagerSkin(final EnumVillager villager) {
    }
    
    public void registerEntityResource(final EnumEntity entity) {
    }
    
    public String getI18format(final EnumVillager villager) {
        return villager.villagerName;
    }
    
    public void registerItemRenderer(final EnumItem item) {
    }
    
    public Block getBlockAtEntityViewPoint(final EntityLivingBase entity, final float renderPartialTicks) {
        return null;
    }
}
