// 
// Decompiled by Procyon v0.5.36
// 

package diversity.client.model;

import diversity.entity.EntityYeti;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;

public class ModelYeti extends ModelBase
{
    ModelRenderer Head;
    ModelRenderer Body;
    ModelRenderer LegLeft;
    ModelRenderer LegRight;
    ModelRenderer ArmLeft;
    ModelRenderer Nose;
    public ModelRenderer ArmRight;
    ModelRenderer ArmLeftHide;
    ModelRenderer ArmRightHide;
    ModelRenderer HeadHide;
    ModelRenderer LegRightHide;
    ModelRenderer LegLeftHide;
    
    public ModelYeti() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        (this.Head = new ModelRenderer((ModelBase)this, 0, 0)).addBox(-4.0f, -9.5f, -5.0f, 8, 10, 8);
        this.Head.setRotationPoint(0.0f, -9.0f, -1.0f);
        this.Head.setTextureSize(128, 128);
        this.Head.mirror = true;
        this.setRotation(this.Head, 0.0f, 0.0f, 0.0f);
        (this.Body = new ModelRenderer((ModelBase)this, 0, 20)).addBox(-8.0f, -10.5f, -6.0f, 16, 21, 12);
        this.Body.setRotationPoint(0.0f, 0.0f, 3.5f);
        this.Body.setTextureSize(128, 128);
        this.Body.mirror = true;
        this.setRotation(this.Body, 0.1745329f, 0.0f, 0.0f);
        (this.LegLeft = new ModelRenderer((ModelBase)this, 69, 3)).addBox(-3.0f, 0.0f, -3.0f, 6, 14, 6);
        this.LegLeft.setRotationPoint(4.0f, 10.0f, 5.0f);
        this.LegLeft.setTextureSize(128, 128);
        this.LegLeft.mirror = true;
        this.setRotation(this.LegLeft, 0.0f, 0.0f, 0.0f);
        (this.LegRight = new ModelRenderer((ModelBase)this, 69, 3)).addBox(-3.0f, 0.0f, -3.0f, 6, 14, 6);
        this.LegRight.setRotationPoint(-4.0f, 10.0f, 5.0f);
        this.LegRight.setTextureSize(128, 128);
        this.LegRight.mirror = true;
        this.setRotation(this.LegRight, 0.0f, 0.0f, 0.0f);
        this.LegRight.mirror = false;
        (this.ArmLeft = new ModelRenderer((ModelBase)this, 57, 24)).addBox(-6.0f, -3.0f, -3.0f, 6, 23, 6);
        this.ArmLeft.setRotationPoint(8.0f, -5.0f, 2.0f);
        this.ArmLeft.setTextureSize(128, 128);
        this.ArmLeft.mirror = true;
        this.setRotation(this.ArmLeft, 0.0f, 3.141593f, 0.0f);
        (this.Nose = new ModelRenderer((ModelBase)this, 24, 0)).addBox(-1.0f, -2.5f, -7.0f, 2, 5, 2);
        this.Nose.setRotationPoint(0.0f, -9.0f, -1.0f);
        this.Nose.setTextureSize(128, 128);
        this.Nose.mirror = true;
        this.setRotation(this.Nose, -0.1570796f, 0.0f, 0.0f);
        (this.ArmRight = new ModelRenderer((ModelBase)this, 57, 24)).addBox(-6.0f, -3.0f, -3.0f, 6, 23, 6);
        this.ArmRight.setRotationPoint(-8.0f, -5.0f, 2.0f);
        this.ArmRight.setTextureSize(128, 128);
        this.ArmRight.mirror = true;
        this.setRotation(this.ArmRight, 0.0f, 0.0f, 0.0f);
        (this.ArmLeftHide = new ModelRenderer((ModelBase)this, 57, 55)).addBox(-6.5f, -3.5f, -3.5f, 7, 17, 7);
        this.ArmLeftHide.setRotationPoint(8.0f, -5.0f, 2.0f);
        this.ArmLeftHide.setTextureSize(128, 128);
        this.ArmLeftHide.mirror = true;
        this.setRotation(this.ArmLeftHide, 0.0f, 3.141593f, 0.0f);
        (this.ArmRightHide = new ModelRenderer((ModelBase)this, 57, 55)).addBox(-6.5f, -3.533333f, -3.5f, 7, 17, 7);
        this.ArmRightHide.setRotationPoint(-8.0f, -5.0f, 2.0f);
        this.ArmRightHide.setTextureSize(128, 128);
        this.ArmRightHide.mirror = true;
        this.setRotation(this.ArmRightHide, 0.0f, 0.0f, 0.0f);
        (this.HeadHide = new ModelRenderer((ModelBase)this, 0, 54)).addBox(-4.5f, -10.0f, -5.5f, 9, 11, 9);
        this.HeadHide.setRotationPoint(0.0f, -9.0f, -1.0f);
        this.HeadHide.setTextureSize(128, 128);
        this.HeadHide.mirror = true;
        this.setRotation(this.HeadHide, 0.0f, 0.0f, 0.0f);
        (this.LegRightHide = new ModelRenderer((ModelBase)this, 83, 24)).addBox(-3.5f, 0.0f, -3.5f, 7, 10, 7);
        this.LegRightHide.setRotationPoint(-4.0f, 10.0f, 5.0f);
        this.LegRightHide.setTextureSize(128, 128);
        this.LegRightHide.mirror = true;
        this.setRotation(this.LegRightHide, 0.0f, 0.0f, 0.0f);
        (this.LegLeftHide = new ModelRenderer((ModelBase)this, 83, 24)).addBox(-3.5f, 0.0f, -3.5f, 7, 10, 7);
        this.LegLeftHide.setRotationPoint(4.0f, 10.0f, 5.0f);
        this.LegLeftHide.setTextureSize(128, 128);
        this.LegLeftHide.mirror = true;
        this.setRotation(this.LegLeftHide, 0.0f, 0.0f, 0.0f);
    }
    
    @Override
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.Head.render(f5);
        this.Body.render(f5);
        this.LegLeft.render(f5);
        this.LegRight.render(f5);
        this.ArmLeft.render(f5);
        this.Nose.render(f5);
        this.ArmRight.render(f5);
        this.ArmLeftHide.render(f5);
        this.ArmRightHide.render(f5);
        this.HeadHide.render(f5);
        this.LegRightHide.render(f5);
        this.LegLeftHide.render(f5);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
    
    @Override
    public void setRotationAngles(final float f, final float f1, final float f2, final float f3, final float f4, final float f5, final Entity entity) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        final EntityYeti yeti = (EntityYeti)entity;
        final float i = yeti.getAttackTimer();
        if (i < 20.0f) {
            this.ArmRight.rotateAngleX = -2.0f + 1.5f * this.func_78172_a(i - f5, 10.0f);
            this.ArmLeft.rotateAngleX = 2.0f + 1.5f * this.func_78172_a(i - f5, 10.0f);
        }
        else {
            this.ArmRight.rotateAngleX = 1.5f * this.func_78172_a(f, 13.0f) * f1;
            this.ArmLeft.rotateAngleX = 1.5f * this.func_78172_a(f, 13.0f) * f1;
        }
        this.Head.rotateAngleY = f3 / 57.29578f;
        this.Head.rotateAngleX = f4 / 57.29578f;
        final ModelRenderer nose = this.Nose;
        final ModelRenderer headHide = this.HeadHide;
        final float rotateAngleY = this.Head.rotateAngleY;
        headHide.rotateAngleY = rotateAngleY;
        nose.rotateAngleY = rotateAngleY;
        final ModelRenderer nose2 = this.Nose;
        final ModelRenderer headHide2 = this.HeadHide;
        final float rotateAngleX = this.Head.rotateAngleX;
        headHide2.rotateAngleX = rotateAngleX;
        nose2.rotateAngleX = rotateAngleX;
        this.ArmRightHide.rotateAngleX = this.ArmRight.rotateAngleX;
        this.ArmLeftHide.rotateAngleX = this.ArmLeft.rotateAngleX;
        this.LegRight.rotateAngleX = 1.5f * this.func_78172_a(f, 13.0f) * f1;
        this.LegRightHide.rotateAngleX = this.LegRight.rotateAngleX;
        this.LegLeft.rotateAngleX = -1.5f * this.func_78172_a(f, 13.0f) * f1;
        this.LegLeftHide.rotateAngleX = this.LegLeft.rotateAngleX;
    }
    
    private float func_78172_a(final float p_78172_1_, final float p_78172_2_) {
        return (Math.abs(p_78172_1_ % p_78172_2_ - p_78172_2_ * 0.5f) - p_78172_2_ * 0.25f) / (p_78172_2_ * 0.25f);
    }
}
