// 
// Decompiled by Procyon v0.5.36
// 

package diversity.client.model;

import net.minecraft.util.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;

public class ModelDwarf extends ModelBase
{
    ModelRenderer Head;
    ModelRenderer Body;
    ModelRenderer LegLeft;
    ModelRenderer LegRight;
    ModelRenderer ArmLeftShoulder;
    ModelRenderer ArmLeftHand;
    ModelRenderer ArmRightHand;
    ModelRenderer Nose;
    ModelRenderer Skirt;
    ModelRenderer Beard1;
    ModelRenderer Beard2;
    ModelRenderer Helmet;
    public ModelRenderer ArmRightHandC;
    ModelRenderer ArmLeftHandC;
    ModelRenderer Cape;
    ModelRenderer HelmLight;
    
    public ModelDwarf() {
        this.textureWidth = 64;
        this.textureHeight = 128;
        (this.Head = new ModelRenderer((ModelBase)this, 0, 0)).addBox(-4.0f, -9.0f, -4.0f, 8, 10, 8);
        this.Head.setRotationPoint(0.0f, 7.0f, -1.0f);
        this.Head.setTextureSize(64, 128);
        this.Head.mirror = true;
        this.setRotation(this.Head, 0.0f, 0.0f, 0.0f);
        (this.Body = new ModelRenderer((ModelBase)this, 0, 39)).addBox(-5.0f, 0.0f, -4.0f, 8, 10, 6);
        this.Body.setRotationPoint(1.0f, 8.0f, 0.0f);
        this.Body.setTextureSize(64, 128);
        this.Body.mirror = true;
        this.setRotation(this.Body, 0.0f, 0.0f, 0.0f);
        (this.LegLeft = new ModelRenderer((ModelBase)this, 0, 22)).addBox(-2.1f, 0.0f, -2.0f, 4, 7, 4);
        this.LegLeft.setRotationPoint(2.0f, 17.0f, -1.0f);
        this.LegLeft.setTextureSize(64, 128);
        this.LegLeft.mirror = true;
        this.setRotation(this.LegLeft, 0.0f, 0.0f, 0.0f);
        (this.LegRight = new ModelRenderer((ModelBase)this, 0, 22)).addBox(-1.9f, 0.0f, -2.0f, 4, 7, 4);
        this.LegRight.setRotationPoint(-2.0f, 17.0f, -1.0f);
        this.LegRight.setTextureSize(64, 128);
        this.LegRight.mirror = true;
        this.setRotation(this.LegRight, 0.0f, 0.0f, 0.0f);
        (this.ArmLeftShoulder = new ModelRenderer((ModelBase)this, 40, 38)).addBox(-4.0f, 0.1f, -0.3f, 8, 4, 4);
        this.ArmLeftShoulder.setRotationPoint(0.0f, 15.0f, -5.0f);
        this.ArmLeftShoulder.setTextureSize(64, 128);
        this.ArmLeftShoulder.mirror = true;
        this.setRotation(this.ArmLeftShoulder, 2.356194f, 0.0f, 0.0f);
        (this.ArmLeftHand = new ModelRenderer((ModelBase)this, 44, 22)).addBox(2.0f, -7.0f, 1.0f, 4, 6, 4);
        this.ArmLeftHand.setRotationPoint(2.0f, 11.0f, 1.0f);
        this.ArmLeftHand.setTextureSize(64, 128);
        this.ArmLeftHand.mirror = true;
        this.setRotation(this.ArmLeftHand, 2.356194f, 0.0f, 0.0f);
        (this.ArmRightHand = new ModelRenderer((ModelBase)this, 44, 22)).addBox(-6.0f, -7.0f, 1.0f, 4, 6, 4);
        this.ArmRightHand.setRotationPoint(-2.0f, 11.0f, 1.0f);
        this.ArmRightHand.setTextureSize(64, 128);
        this.ArmRightHand.mirror = true;
        this.setRotation(this.ArmRightHand, 2.356194f, 0.0f, 0.0f);
        (this.Nose = new ModelRenderer((ModelBase)this, 24, 0)).addBox(-1.0f, -2.0f, -7.0f, 2, 4, 2);
        this.Nose.setRotationPoint(0.0f, 7.0f, 0.0f);
        this.Nose.setTextureSize(64, 128);
        this.Nose.mirror = true;
        this.setRotation(this.Nose, 0.0f, 0.0f, 0.0f);
        (this.Skirt = new ModelRenderer((ModelBase)this, 32, 4)).addBox(-5.5f, 8.0f, -4.5f, 9, 6, 7);
        this.Skirt.setRotationPoint(1.0f, 7.0f, 0.0f);
        this.Skirt.setTextureSize(64, 128);
        this.Skirt.mirror = true;
        this.setRotation(this.Skirt, 0.0f, 0.0f, 0.0f);
        (this.Beard1 = new ModelRenderer((ModelBase)this, 28, 46)).addBox(-4.5f, -4.0f, -4.5f, 9, 18, 9);
        this.Beard1.setRotationPoint(0.0f, 7.0f, -1.0f);
        this.Beard1.setTextureSize(64, 128);
        this.Beard1.mirror = true;
        this.setRotation(this.Beard1, 0.0f, 0.0f, 0.0f);
        (this.Beard2 = new ModelRenderer((ModelBase)this, 42, 75)).addBox(-5.0f, -5.0f, -5.0f, 10, 18, 1);
        this.Beard2.setRotationPoint(0.0f, 8.0f, -1.0f);
        this.Beard2.setTextureSize(64, 128);
        this.Beard2.mirror = true;
        this.setRotation(this.Beard2, 0.0f, 0.0f, 0.0f);
        (this.Helmet = new ModelRenderer((ModelBase)this, 2, 75)).addBox(-4.5f, -9.5f, -4.5f, 9, 5, 9);
        this.Helmet.setRotationPoint(0.0f, 7.0f, -1.0f);
        this.Helmet.setTextureSize(64, 128);
        this.Helmet.mirror = true;
        this.setRotation(this.Helmet, 0.0f, 0.0f, 0.0f);
        (this.ArmRightHandC = new ModelRenderer((ModelBase)this, 22, 22)).addBox(-4.0f, -1.0f, -2.0f, 4, 10, 4);
        this.ArmRightHandC.setRotationPoint(-4.0f, 9.0f, -1.0f);
        this.ArmRightHandC.setTextureSize(64, 128);
        this.ArmRightHandC.mirror = true;
        this.setRotation(this.ArmRightHandC, 0.0f, 0.0f, 0.0f);
        (this.ArmLeftHandC = new ModelRenderer((ModelBase)this, 22, 22)).addBox(0.0f, -1.0f, -2.0f, 4, 10, 4);
        this.ArmLeftHandC.setRotationPoint(4.0f, 9.0f, -1.0f);
        this.ArmLeftHandC.setTextureSize(64, 128);
        this.ArmLeftHandC.mirror = true;
        this.setRotation(this.ArmLeftHandC, 0.0f, 0.0f, 0.0f);
        (this.Cape = new ModelRenderer((ModelBase)this, 0, 98)).addBox(-8.5f, -1.0f, -7.0f, 17, 14, 8);
        this.Cape.setRotationPoint(0.0f, 8.0f, 3.0f);
        this.Cape.setTextureSize(64, 128);
        this.Cape.mirror = true;
        this.setRotation(this.Cape, 0.0f, 0.0f, 0.0f);
        (this.HelmLight = new ModelRenderer((ModelBase)this, 2, 71)).addBox(-1.5f, -8.5f, -5.6f, 3, 2, 1);
        this.HelmLight.setRotationPoint(0.0f, 7.0f, -1.0f);
        this.HelmLight.setTextureSize(64, 128);
        this.HelmLight.mirror = true;
        this.setRotation(this.HelmLight, 0.0f, 0.0f, 0.0f);
    }
    
    @Override
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.Head.render(f5);
        this.Body.render(f5);
        this.LegLeft.render(f5);
        this.LegRight.render(f5);
        this.ArmLeftShoulder.render(f5);
        this.ArmLeftHand.render(f5);
        this.ArmRightHand.render(f5);
        this.Nose.render(f5);
        this.Skirt.render(f5);
        this.Beard1.render(f5);
        this.Beard2.render(f5);
        this.Helmet.render(f5);
        this.ArmRightHandC.render(f5);
        this.ArmLeftHandC.render(f5);
        this.Cape.render(f5);
        this.HelmLight.render(f5);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
    
    @Override
    public void setRotationAngles(final float f, final float f1, final float f2, final float f3, final float f4, final float f5, final Entity entity) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.Head.rotateAngleY = f4 / 57.295776f;
        this.Head.rotateAngleX = f5 / 57.295776f;
        final ModelRenderer nose = this.Nose;
        final ModelRenderer helmet = this.Helmet;
        final ModelRenderer beard1 = this.Beard1;
        final ModelRenderer beard2 = this.Beard2;
        final ModelRenderer helmLight = this.HelmLight;
        final float rotateAngleY = this.Head.rotateAngleY;
        helmLight.rotateAngleY = rotateAngleY;
        beard2.rotateAngleY = rotateAngleY;
        beard1.rotateAngleY = rotateAngleY;
        helmet.rotateAngleY = rotateAngleY;
        nose.rotateAngleY = rotateAngleY;
        final ModelRenderer nose2 = this.Nose;
        final ModelRenderer helmet2 = this.Helmet;
        final ModelRenderer beard3 = this.Beard1;
        final ModelRenderer beard4 = this.Beard2;
        final ModelRenderer helmLight2 = this.HelmLight;
        final float rotateAngleX = this.Head.rotateAngleX;
        helmLight2.rotateAngleX = rotateAngleX;
        beard4.rotateAngleX = rotateAngleX;
        beard3.rotateAngleX = rotateAngleX;
        helmet2.rotateAngleX = rotateAngleX;
        nose2.rotateAngleX = rotateAngleX;
        this.ArmRightHandC.rotateAngleX = MathHelper.cos(f * 0.6662f * 2.0f + 0.0f) * 0.6f * f1;
        this.ArmLeftHandC.rotateAngleX = -MathHelper.cos(f * 0.6662f * 2.0f + 0.0f) * 0.6f * f1;
        this.LegRight.rotateAngleX = MathHelper.cos(f * 0.6662f * 2.0f + 0.0f) * 0.6f * f1;
        this.LegLeft.rotateAngleX = -MathHelper.cos(f * 0.6662f * 2.0f + 0.0f) * 0.6f * f1;
    }
}
