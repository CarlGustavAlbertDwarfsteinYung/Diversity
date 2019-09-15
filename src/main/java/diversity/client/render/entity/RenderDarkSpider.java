// 
// Decompiled by Procyon v0.5.36
// 

package diversity.client.render.entity;

import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.entity.EntityLivingBase;
import diversity.utils.ResourceTools;
import net.minecraft.client.renderer.OpenGlHelper;
import org.lwjgl.opengl.GL11;
import diversity.entity.EntityDarkSpider;
import diversity.client.model.ModelDarkSpider;
import net.minecraft.client.model.ModelBase;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderLiving;

@SideOnly(Side.CLIENT)
public class RenderDarkSpider extends RenderLiving
{
    private static final ResourceLocation spiderEyesTextures;
    private static final ResourceLocation spiderBackTextures;
    private ModelBase eggSack;
    
    public RenderDarkSpider() {
        super((ModelBase)new ModelDarkSpider(0), 1.0f);
        this.setRenderPassModel((ModelBase)new ModelDarkSpider(0));
        this.eggSack = (ModelBase)new ModelDarkSpider(1);
    }
    
    protected float getDeathMaxRotation(final EntityDarkSpider p_77037_1_) {
        return 180.0f;
    }
    
    protected int shouldRenderPass(final EntityDarkSpider p_77032_1_, final int p_77032_2_, final float p_77032_3_) {
        if (p_77032_2_ == 0) {
            this.setRenderPassModel(this.eggSack);
            this.bindTexture(RenderDarkSpider.spiderBackTextures);
            GL11.glEnable(2977);
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 771);
            return 1;
        }
        if (p_77032_2_ == 1) {
            GL11.glDisable(3042);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        }
        this.bindTexture(RenderDarkSpider.spiderEyesTextures);
        GL11.glEnable(3042);
        GL11.glDisable(3008);
        GL11.glBlendFunc(1, 1);
        if (p_77032_1_.isInvisible()) {
            GL11.glDepthMask(false);
        }
        else {
            GL11.glDepthMask(true);
        }
        final char c0 = '\uf0f0';
        final int j = c0 % 65536;
        final int k = c0 / 65536;
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, j / 1.0f, k / 1.0f);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glDisable(3042);
        return -1;
    }
    
    protected ResourceLocation getEntityTexture(final EntityDarkSpider p_110775_1_) {
        return ResourceTools.getResource(EntityDarkSpider.class);
    }
    
    @Override
    protected float getDeathMaxRotation(final EntityLivingBase p_77037_1_) {
        return this.getDeathMaxRotation((EntityDarkSpider)p_77037_1_);
    }
    
    @Override
    protected float handleRotationFloat(final EntityLivingBase entityliving, final float f) {
        final EntityDarkSpider entityDarkSpider = (EntityDarkSpider)entityliving;
        final float f2 = entityDarkSpider.squishe + (entityDarkSpider.squishb - entityDarkSpider.squishe) * f;
        final float f3 = entityDarkSpider.squishd + (entityDarkSpider.squishc - entityDarkSpider.squishd) * f;
        return (MathHelper.sin(f2) + 0.1f) * f3;
    }
    
    @Override
    protected void preRenderCallback(final EntityLivingBase par1EntityLiving, final float par2) {
        GL11.glScalef(2.0f, 2.0f, 2.0f);
    }
    
    @Override
    protected int shouldRenderPass(final EntityLivingBase p_77032_1_, final int p_77032_2_, final float p_77032_3_) {
        return this.shouldRenderPass((EntityDarkSpider)p_77032_1_, p_77032_2_, p_77032_3_);
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final Entity p_110775_1_) {
        return this.getEntityTexture((EntityDarkSpider)p_110775_1_);
    }
    
    static {
        spiderEyesTextures = new ResourceLocation("diversity:textures/entities/monsters/spider_eyes.png");
        spiderBackTextures = new ResourceLocation("diversity:textures/entities/monsters/darkspider_back.png");
    }
}
