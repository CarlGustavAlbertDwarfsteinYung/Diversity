// 
// Decompiled by Procyon v0.5.36
// 

package diversity.client.model;

import diversity.entity.EntityGlobalVillager;
import org.lwjgl.opengl.GL11;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBiped;

@SideOnly(Side.CLIENT)
public abstract class ModelGlobalVillager extends ModelBiped
{
    public ModelRenderer bipedVillagerArms;
    public ModelRenderer bipedVillagerNose;
    
    public ModelGlobalVillager(final float p_i1163_1_) {
        this(p_i1163_1_, 0.0f, 64, 64);
    }
    
    public ModelGlobalVillager(final float p_i1164_1_, final float p_i1164_2_, final int p_i1164_3_, final int p_i1164_4_) {
        super(p_i1164_1_, p_i1164_2_, p_i1164_3_, p_i1164_4_);
        (this.bipedHead = new ModelRenderer((ModelBase)this).setTextureSize(p_i1164_3_, p_i1164_4_)).setRotationPoint(0.0f, 0.0f + p_i1164_2_, 0.0f);
        this.bipedHead.setTextureOffset(0, 0).addBox(-4.0f, -10.0f, -4.0f, 8, 10, 8, p_i1164_1_);
        (this.bipedVillagerNose = new ModelRenderer((ModelBase)this).setTextureSize(p_i1164_3_, p_i1164_4_)).setRotationPoint(0.0f, p_i1164_2_ - 2.0f, 0.0f);
        this.bipedVillagerNose.setTextureOffset(24, 0).addBox(-1.0f, -1.0f, -6.0f, 2, 4, 2, p_i1164_1_);
        this.bipedHead.addChild(this.bipedVillagerNose);
        (this.bipedBody = new ModelRenderer((ModelBase)this).setTextureSize(p_i1164_3_, p_i1164_4_)).setRotationPoint(0.0f, 0.0f + p_i1164_2_, 0.0f);
        this.bipedBody.setTextureOffset(16, 20).addBox(-4.0f, 0.0f, -3.0f, 8, 12, 6, p_i1164_1_);
        this.bipedBody.setTextureOffset(0, 38).addBox(-4.0f, 0.0f, -3.0f, 8, 18, 6, p_i1164_1_ + 0.5f);
        (this.bipedVillagerArms = new ModelRenderer((ModelBase)this).setTextureSize(p_i1164_3_, p_i1164_4_)).setRotationPoint(0.0f, 0.0f + p_i1164_2_ + 2.0f, 0.0f);
        this.bipedVillagerArms.setTextureOffset(44, 22).addBox(-8.0f, -2.0f, -2.0f, 4, 8, 4, p_i1164_1_);
        this.bipedVillagerArms.setTextureOffset(44, 22).addBox(4.0f, -2.0f, -2.0f, 4, 8, 4, p_i1164_1_);
        this.bipedVillagerArms.setTextureOffset(40, 38).addBox(-4.0f, 2.0f, -2.0f, 8, 4, 4, p_i1164_1_);
        (this.bipedRightLeg = new ModelRenderer((ModelBase)this, 0, 22).setTextureSize(p_i1164_3_, p_i1164_4_)).setRotationPoint(-2.0f, 12.0f + p_i1164_2_, 0.0f);
        this.bipedRightLeg.addBox(-2.0f, 0.0f, -2.0f, 4, 12, 4, p_i1164_1_);
        this.bipedLeftLeg = new ModelRenderer((ModelBase)this, 0, 22).setTextureSize(p_i1164_3_, p_i1164_4_);
        this.bipedLeftLeg.mirror = true;
        this.bipedLeftLeg.setRotationPoint(2.0f, 12.0f + p_i1164_2_, 0.0f);
        this.bipedLeftLeg.addBox(-2.0f, 0.0f, -2.0f, 4, 12, 4, p_i1164_1_);
        (this.bipedRightArm = new ModelRenderer((ModelBase)this).setTextureSize(p_i1164_3_, p_i1164_4_)).setRotationPoint(-5.0f, 2.0f + p_i1164_2_, 0.0f);
        this.bipedRightArm.setTextureOffset(44, 22).addBox(-3.0f, -2.0f, -2.0f, 4, 12, 4, p_i1164_1_);
        this.bipedLeftArm = new ModelRenderer((ModelBase)this).setTextureSize(p_i1164_3_, p_i1164_4_);
        this.bipedLeftArm.mirror = true;
        this.bipedLeftArm.setRotationPoint(5.0f, 2.0f + p_i1164_2_, 0.0f);
        this.bipedLeftArm.setTextureOffset(44, 22).addBox(-1.0f, -2.0f, -2.0f, 4, 12, 4, p_i1164_1_);
    }
    
    @Override
    public void render(final Entity p_78088_1_, final float p_78088_2_, final float p_78088_3_, final float p_78088_4_, final float p_78088_5_, final float p_78088_6_, final float p_78088_7_) {
        this.setRotationAngles(p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, p_78088_7_, p_78088_1_);
        if (this.isChild) {
            GL11.glPushMatrix();
            GL11.glScalef(1.3f, 1.3f, 1.3f);
            this.bipedHead.render(p_78088_7_);
            GL11.glPopMatrix();
        }
        else {
            this.bipedHead.render(p_78088_7_);
        }
        this.bipedBody.render(p_78088_7_);
        if (p_78088_1_ instanceof EntityGlobalVillager && ((EntityGlobalVillager)p_78088_1_).canDefend() && !((EntityGlobalVillager)p_78088_1_).isChild()) {
            this.bipedRightArm.render(p_78088_7_);
            this.bipedLeftArm.render(p_78088_7_);
        }
        else {
            this.bipedVillagerArms.render(p_78088_7_);
        }
        this.bipedRightLeg.render(p_78088_7_);
        this.bipedLeftLeg.render(p_78088_7_);
    }
    
    @Override
    public void setRotationAngles(final float p_78087_1_, final float p_78087_2_, final float p_78087_3_, final float p_78087_4_, final float p_78087_5_, final float p_78087_6_, final Entity p_78087_7_) {
        super.setRotationAngles(p_78087_1_, p_78087_2_, p_78087_3_, p_78087_4_, p_78087_5_, p_78087_6_, p_78087_7_);
        this.bipedVillagerArms.rotationPointY = 3.0f;
        this.bipedVillagerArms.rotationPointZ = -1.0f;
        this.bipedVillagerArms.rotateAngleX = -0.75f;
    }
}
