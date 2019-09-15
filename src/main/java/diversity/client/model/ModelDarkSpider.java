// 
// Decompiled by Procyon v0.5.36
// 

package diversity.client.model;

import org.lwjgl.opengl.GL11;
import diversity.entity.EntityDarkSpider;
import net.minecraft.entity.Entity;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelSpider;

@SideOnly(Side.CLIENT)
public class ModelDarkSpider extends ModelSpider
{
    public float scale;
    private int index;
    
    public ModelDarkSpider(final int i) {
        this.index = i;
        this.scale = 0.0f;
    }
    
    @Override
    public void render(final Entity p_78088_1_, final float p_78088_2_, final float p_78088_3_, final float p_78088_4_, final float p_78088_5_, final float p_78088_6_, final float p_78088_7_) {
        this.setRotationAngles(p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, p_78088_7_, p_78088_1_);
        final EntityDarkSpider spider = (EntityDarkSpider)p_78088_1_;
        if (this.index == 0) {
            this.spiderHead.render(p_78088_7_);
            this.spiderNeck.render(p_78088_7_);
            this.spiderLeg1.render(p_78088_7_);
            this.spiderLeg2.render(p_78088_7_);
            this.spiderLeg3.render(p_78088_7_);
            this.spiderLeg4.render(p_78088_7_);
            this.spiderLeg5.render(p_78088_7_);
            this.spiderLeg6.render(p_78088_7_);
            this.spiderLeg7.render(p_78088_7_);
            this.spiderLeg8.render(p_78088_7_);
        }
        if (this.index == 1 && spider.getPhase() < 2) {
            GL11.glPushMatrix();
            GL11.glScalef(this.scale, this.scale, this.scale);
            GL11.glScalef(0.1f, 0.1f, 0.1f);
            GL11.glTranslatef(0.0f, 2.0f, 3.0f);
            GL11.glRotatef(80.0f, 0.0f, 1.0f, 0.0f);
            this.renderMiniSpider(p_78088_7_);
            GL11.glRotatef(100.0f, 0.0f, 1.0f, 0.0f);
            GL11.glTranslatef(-3.0f, 3.0f, -1.0f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, -1.0f);
            this.renderMiniSpider(p_78088_7_);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(6.0f, -0.2f, 1.5f);
            GL11.glRotatef(180.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, -1.0f);
            this.renderMiniSpider(p_78088_7_);
            GL11.glRotatef(180.0f, 0.0f, -1.0f, 0.0f);
            GL11.glTranslatef(0.0f, 3.0f, -3.5f);
            GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
            this.renderMiniSpider(p_78088_7_);
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glScalef(this.scale / 2.0f * 1.5f, this.scale / 2.0f * 1.5f, this.scale / 2.0f * 1.5f);
            GL11.glTranslatef(0.0f, -0.35f, -0.1f);
            this.spiderBody.render(p_78088_7_);
            GL11.glPopMatrix();
        }
        else {
            this.spiderBody.render(p_78088_7_);
        }
    }
    
    public void renderMiniSpider(final float p_78088_7_) {
        this.spiderHead.render(p_78088_7_);
        this.spiderNeck.render(p_78088_7_);
        this.spiderLeg1.render(p_78088_7_);
        this.spiderLeg2.render(p_78088_7_);
        this.spiderLeg3.render(p_78088_7_);
        this.spiderLeg4.render(p_78088_7_);
        this.spiderLeg5.render(p_78088_7_);
        this.spiderLeg6.render(p_78088_7_);
        this.spiderLeg7.render(p_78088_7_);
        this.spiderLeg8.render(p_78088_7_);
        this.spiderBody.render(p_78088_7_);
    }
    
    @Override
    public void setRotationAngles(final float p_78087_1_, final float p_78087_2_, final float p_78087_3_, final float p_78087_4_, final float p_78087_5_, final float p_78087_6_, final Entity p_78087_7_) {
        super.setRotationAngles(p_78087_1_, p_78087_2_, p_78087_3_, p_78087_4_, p_78087_5_, p_78087_6_, p_78087_7_);
        if (this.index == 1) {
            this.spiderHead.rotateAngleY = 0.0f;
            this.spiderHead.rotateAngleX = 0.0f;
            this.scale = p_78087_3_ + 2.0f;
        }
    }
}
