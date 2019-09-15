// 
// Decompiled by Procyon v0.5.36
// 

package diversity.client.model;

import net.minecraft.util.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelVillager;

@SideOnly(Side.CLIENT)
public class ModelTzitzimime extends ModelVillager
{
    public ModelRenderer villagerEar;
    public ModelRenderer[] villagerPens;
    
    public ModelTzitzimime(final float p_i1163_1_) {
        this(p_i1163_1_, 0.0f, 64, 64);
    }
    
    public ModelTzitzimime(final float p_i1164_1_, final float p_i1164_2_, final int p_i1164_3_, final int p_i1164_4_) {
        super(p_i1164_1_, p_i1164_2_, p_i1164_3_, p_i1164_4_);
        this.villagerPens = new ModelRenderer[5];
        this.villagerArms = new ModelRenderer((ModelBase)this).setTextureSize(p_i1164_3_, p_i1164_4_);
        this.villagerArms.setTextureOffset(44, 22).addBox(-8.0f, -2.0f, -2.0f, 4, 12, 4, p_i1164_1_);
        this.villagerArms.setTextureOffset(44, 22).addBox(4.0f, -2.0f, -2.0f, 4, 12, 4, p_i1164_1_);
        (this.villagerHead = new ModelRenderer((ModelBase)this).setTextureSize(p_i1164_3_, p_i1164_4_)).setRotationPoint(0.0f, 0.0f + p_i1164_2_, 0.0f);
        this.villagerHead.setTextureOffset(0, 0).addBox(-4.0f, -10.0f, -4.0f, 8, 10, 8, p_i1164_1_);
        (this.villagerNose = new ModelRenderer((ModelBase)this).setTextureSize(p_i1164_3_, p_i1164_4_)).setTextureSize(p_i1164_3_, p_i1164_4_);
        this.villagerNose.setRotationPoint(0.0f, p_i1164_2_ - 2.0f, 0.0f);
        this.villagerNose.setTextureOffset(32, 10).addBox(-3.0f, -1.0f, -5.0f, 6, 4, 2, p_i1164_1_);
        this.villagerHead.addChild(this.villagerNose);
        this.villagerEar = new ModelRenderer((ModelBase)this).setTextureSize(p_i1164_3_, p_i1164_4_);
        this.villagerEar.setTextureOffset(40, 0).addBox(3.0f, -5.0f, -2.0f, 2, 4, 4, p_i1164_1_);
        this.villagerEar.setTextureOffset(40, 0).addBox(-5.0f, -5.0f, -2.0f, 2, 4, 4, p_i1164_1_);
        this.villagerHead.addChild(this.villagerEar);
        float rotation = -0.5235988f;
        for (int k = 0; k < this.villagerPens.length; ++k) {
            final ModelRenderer villagerPen = new ModelRenderer((ModelBase)this).setTextureSize(p_i1164_3_, p_i1164_4_);
            villagerPen.setTextureOffset(32, 0).addBox(-1.0f, -14.0f, -1.0f, 2, 8, 2, p_i1164_1_);
            villagerPen.rotateAngleZ = rotation;
            this.villagerPens[k] = villagerPen;
            this.villagerHead.addChild(villagerPen);
            rotation += 0.2617994f;
        }
    }
    
    @Override
    public void setRotationAngles(final float p_78087_1_, final float p_78087_2_, final float p_78087_3_, final float p_78087_4_, final float p_78087_5_, final float p_78087_6_, final Entity p_78087_7_) {
        super.setRotationAngles(p_78087_1_, p_78087_2_, p_78087_3_, p_78087_4_, p_78087_5_, p_78087_6_, p_78087_7_);
        this.villagerHead.rotateAngleY = p_78087_4_ / 57.295776f;
        this.villagerHead.rotateAngleX = p_78087_5_ / 57.295776f;
        this.villagerArms.rotationPointY = 3.0f;
        this.villagerArms.rotationPointZ = -1.0f;
        this.villagerArms.rotateAngleX = -0.75f;
        this.rightVillagerLeg.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662f) * 1.4f * p_78087_2_ * 0.5f;
        this.leftVillagerLeg.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662f + 3.1415927f) * 1.4f * p_78087_2_ * 0.5f;
        this.rightVillagerLeg.rotateAngleY = 0.0f;
        this.leftVillagerLeg.rotateAngleY = 0.0f;
    }
}
