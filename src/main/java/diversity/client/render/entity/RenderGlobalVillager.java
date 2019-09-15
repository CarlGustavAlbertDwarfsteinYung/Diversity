// 
// Decompiled by Procyon v0.5.36
// 

package diversity.client.render.entity;

import net.minecraft.entity.passive.EntityVillager;
import org.lwjgl.opengl.GL11;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import diversity.utils.ResourceTools;
import cpw.mods.fml.common.registry.VillagerRegistry;
import net.minecraft.entity.EntityLiving;
import diversity.entity.EntityGlobalVillager;
import net.minecraft.client.model.ModelBiped;
import diversity.client.model.ModelGlobalVillager;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderBiped;

@SideOnly(Side.CLIENT)
public abstract class RenderGlobalVillager extends RenderBiped
{
    private static final ResourceLocation defaultTexture;
    
    public RenderGlobalVillager(final ModelGlobalVillager p_i1262_1_, final float p_i1262_2_) {
        super((ModelBiped)p_i1262_1_, p_i1262_2_, p_i1262_2_);
    }
    
    protected int shouldRenderPass(final EntityGlobalVillager p_77032_1_, final int p_77032_2_, final float p_77032_3_) {
        return this.shouldRenderPass((EntityLiving)p_77032_1_, p_77032_2_, p_77032_3_);
    }
    
    protected void renderEquippedItems(final EntityGlobalVillager p_77029_1_, final float p_77029_2_) {
        this.renderEquippedItems((EntityLiving)p_77029_1_, p_77029_2_);
    }
    
    protected ResourceLocation getEntityTexture(final EntityGlobalVillager entity) {
        if (!entity.isChild()) {
            return VillagerRegistry.getVillagerSkin(entity.getProfession(), RenderGlobalVillager.defaultTexture);
        }
        return ResourceTools.getResource(entity.getClass());
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final Entity p_110775_1_) {
        return this.getEntityTexture((EntityGlobalVillager)p_110775_1_);
    }
    
    @Override
    protected void preRenderCallback(final EntityLivingBase p_77041_1_, final float p_77041_2_) {
        this.preRenderCallback((EntityGlobalVillager)p_77041_1_, p_77041_2_);
    }
    
    protected void preRenderCallback(final EntityGlobalVillager p_77041_1_, final float p_77041_2_) {
        super.preRenderCallback((EntityLivingBase)p_77041_1_, p_77041_2_);
        float f1 = 0.9375f;
        if (p_77041_1_.getGrowingAge() < 0) {
            f1 *= 0.5;
            this.shadowSize = 0.25f;
        }
        else {
            this.shadowSize = 0.5f;
        }
        GL11.glScalef(f1, f1, f1);
    }
    
    public void doRender(final EntityVillager p_76986_1_, final double p_76986_2_, final double p_76986_4_, final double p_76986_6_, final float p_76986_8_, final float p_76986_9_) {
        super.doRender((EntityLiving)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
    
    @Override
    public void doRender(final EntityLiving p_76986_1_, final double p_76986_2_, final double p_76986_4_, final double p_76986_6_, final float p_76986_8_, final float p_76986_9_) {
        this.doRender((EntityVillager)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
    
    @Override
    public void doRender(final EntityLivingBase p_76986_1_, final double p_76986_2_, final double p_76986_4_, final double p_76986_6_, final float p_76986_8_, final float p_76986_9_) {
        this.doRender((EntityVillager)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
    
    @Override
    public void doRender(final Entity p_76986_1_, final double p_76986_2_, final double p_76986_4_, final double p_76986_6_, final float p_76986_8_, final float p_76986_9_) {
        this.doRender((EntityVillager)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
    
    static {
        defaultTexture = new ResourceLocation("textures/entity/villager/villager.png");
    }
}
