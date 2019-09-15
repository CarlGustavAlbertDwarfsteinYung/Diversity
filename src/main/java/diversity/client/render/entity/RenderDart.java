// 
// Decompiled by Procyon v0.5.36
// 

package diversity.client.render.entity;

import net.minecraft.util.MathHelper;
import net.minecraft.client.renderer.Tessellator;
import org.lwjgl.opengl.GL11;
import net.minecraft.entity.Entity;
import diversity.entity.EntityDart;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.Render;

@SideOnly(Side.CLIENT)
public class RenderDart extends Render
{
    private static final ResourceLocation dartTextures;
    
    public void doRender(final EntityDart p_76986_1_, final double p_76986_2_, final double p_76986_4_, final double p_76986_6_, final float p_76986_8_, final float p_76986_9_) {
        this.bindEntityTexture((Entity)p_76986_1_);
        GL11.glPushMatrix();
        GL11.glTranslatef((float)p_76986_2_, (float)p_76986_4_, (float)p_76986_6_);
        GL11.glRotatef(p_76986_1_.prevRotationYaw + (p_76986_1_.rotationYaw - p_76986_1_.prevRotationYaw) * p_76986_9_ - 90.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(p_76986_1_.prevRotationPitch + (p_76986_1_.rotationPitch - p_76986_1_.prevRotationPitch) * p_76986_9_, 0.0f, 0.0f, 1.0f);
        final Tessellator tessellator = Tessellator.instance;
        final byte b0 = 0;
        final float f2 = 0.0f;
        final float f3 = 0.5f;
        final float f4 = (0 + b0 * 10) / 32.0f;
        final float f5 = (5 + b0 * 10) / 32.0f;
        final float f6 = 0.0f;
        final float f7 = 0.15625f;
        final float f8 = (5 + b0 * 10) / 32.0f;
        final float f9 = (10 + b0 * 10) / 32.0f;
        final float f10 = 0.0225f;
        GL11.glEnable(32826);
        final float f11 = p_76986_1_.arrowShake - p_76986_9_;
        if (f11 > 0.0f) {
            final float f12 = -MathHelper.sin(f11 * 3.0f) * f11;
            GL11.glRotatef(f12, 0.0f, 0.0f, 1.0f);
        }
        GL11.glRotatef(45.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScalef(f10, f10, f10);
        GL11.glTranslatef(-4.0f, 0.0f, 0.0f);
        GL11.glNormal3f(f10, 0.0f, 0.0f);
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(-7.0, -2.0, -2.0, (double)f6, (double)f8);
        tessellator.addVertexWithUV(-7.0, -2.0, 2.0, (double)f7, (double)f8);
        tessellator.addVertexWithUV(-7.0, 2.0, 2.0, (double)f7, (double)f9);
        tessellator.addVertexWithUV(-7.0, 2.0, -2.0, (double)f6, (double)f9);
        tessellator.draw();
        GL11.glNormal3f(-f10, 0.0f, 0.0f);
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(-7.0, 2.0, -2.0, (double)f6, (double)f8);
        tessellator.addVertexWithUV(-7.0, 2.0, 2.0, (double)f7, (double)f8);
        tessellator.addVertexWithUV(-7.0, -2.0, 2.0, (double)f7, (double)f9);
        tessellator.addVertexWithUV(-7.0, -2.0, -2.0, (double)f6, (double)f9);
        tessellator.draw();
        for (int i = 0; i < 4; ++i) {
            GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
            GL11.glNormal3f(0.0f, 0.0f, f10);
            tessellator.startDrawingQuads();
            tessellator.addVertexWithUV(-8.0, -2.0, 0.0, (double)f2, (double)f4);
            tessellator.addVertexWithUV(8.0, -2.0, 0.0, (double)f3, (double)f4);
            tessellator.addVertexWithUV(8.0, 2.0, 0.0, (double)f3, (double)f5);
            tessellator.addVertexWithUV(-8.0, 2.0, 0.0, (double)f2, (double)f5);
            tessellator.draw();
        }
        GL11.glDisable(32826);
        GL11.glPopMatrix();
    }
    
    protected ResourceLocation getEntityTexture(final EntityDart p_110775_1_) {
        return RenderDart.dartTextures;
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final Entity p_110775_1_) {
        return this.getEntityTexture((EntityDart)p_110775_1_);
    }
    
    @Override
    public void doRender(final Entity p_76986_1_, final double p_76986_2_, final double p_76986_4_, final double p_76986_6_, final float p_76986_8_, final float p_76986_9_) {
        this.doRender((EntityDart)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
    
    static {
        dartTextures = new ResourceLocation("diversity", "textures/entities/projectiles/dart.png");
    }
}
