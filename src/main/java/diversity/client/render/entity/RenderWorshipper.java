// 
// Decompiled by Procyon v0.5.36
// 

package diversity.client.render.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import diversity.utils.ResourceTools;
import net.minecraft.entity.EntityLiving;
import diversity.entity.EntityWorshipper;
import net.minecraft.client.model.ModelBiped;
import diversity.client.model.ModelWorshipper;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderBiped;

@SideOnly(Side.CLIENT)
public class RenderWorshipper extends RenderBiped
{
    private static final ResourceLocation defaultTexture;
    
    public RenderWorshipper() {
        super((ModelBiped)new ModelWorshipper(0.0f), 0.5f, 0.5f);
    }
    
    protected int shouldRenderPass(final EntityWorshipper p_77032_1_, final int p_77032_2_, final float p_77032_3_) {
        return this.shouldRenderPass((EntityLiving)p_77032_1_, p_77032_2_, p_77032_3_);
    }
    
    protected void renderEquippedItems(final EntityWorshipper p_77029_1_, final float p_77029_2_) {
        this.renderEquippedItems((EntityLiving)p_77029_1_, p_77029_2_);
    }
    
    protected ResourceLocation getEntityTexture(final EntityWorshipper entity) {
        return ResourceTools.getResource(entity.getClass());
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final Entity p_110775_1_) {
        return this.getEntityTexture((EntityWorshipper)p_110775_1_);
    }
    
    @Override
    protected void preRenderCallback(final EntityLivingBase p_77041_1_, final float p_77041_2_) {
        this.preRenderCallback((EntityWorshipper)p_77041_1_, p_77041_2_);
    }
    
    protected void preRenderCallback(final EntityWorshipper p_77041_1_, final float p_77041_2_) {
        super.preRenderCallback((EntityLivingBase)p_77041_1_, p_77041_2_);
    }
    
    public void doRender(final EntityWorshipper p_76986_1_, final double p_76986_2_, final double p_76986_4_, final double p_76986_6_, final float p_76986_8_, final float p_76986_9_) {
        super.doRender((EntityLiving)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
    
    @Override
    public void doRender(final EntityLiving p_76986_1_, final double p_76986_2_, final double p_76986_4_, final double p_76986_6_, final float p_76986_8_, final float p_76986_9_) {
        this.doRender((EntityWorshipper)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
    
    @Override
    public void doRender(final EntityLivingBase p_76986_1_, final double p_76986_2_, final double p_76986_4_, final double p_76986_6_, final float p_76986_8_, final float p_76986_9_) {
        this.doRender((EntityWorshipper)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
    
    @Override
    public void doRender(final Entity p_76986_1_, final double p_76986_2_, final double p_76986_4_, final double p_76986_6_, final float p_76986_8_, final float p_76986_9_) {
        this.doRender((EntityWorshipper)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
    
    static {
        defaultTexture = new ResourceLocation("textures/entity/villager/villager.png");
    }
}
