// 
// Decompiled by Procyon v0.5.36
// 

package diversity.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelInuit extends ModelGlobalVillager
{
    public ModelRenderer villagerHoodie;
    
    public ModelInuit(final float p_i1163_1_) {
        this(p_i1163_1_, 0.0f, 64, 64);
    }
    
    public ModelInuit(final float p_i1164_1_, final float p_i1164_2_, final int p_i1164_3_, final int p_i1164_4_) {
        super(p_i1164_1_, p_i1164_2_, p_i1164_3_, p_i1164_4_);
        (this.villagerHoodie = new ModelRenderer((ModelBase)this).setTextureSize(p_i1164_3_, p_i1164_4_)).setRotationPoint(0.0f, 0.0f + p_i1164_2_, 0.0f);
        this.villagerHoodie.setTextureOffset(0, 18).addBox(-5.0f, -11.0f, -5.0f, 10, 12, 10, p_i1164_1_);
        this.bipedHead.addChild(this.villagerHoodie);
        (this.bipedBody = new ModelRenderer((ModelBase)this).setTextureSize(p_i1164_3_, p_i1164_4_)).setRotationPoint(0.0f, 0.0f + p_i1164_2_, 0.0f);
        this.bipedBody.setTextureOffset(0, 40).addBox(-4.5f, 0.0f, -3.5f, 9, 17, 7, p_i1164_1_ + 0.5f);
        (this.bipedVillagerArms = new ModelRenderer((ModelBase)this).setTextureSize(p_i1164_3_, p_i1164_4_)).setRotationPoint(0.0f, 0.0f + p_i1164_2_ + 2.0f, 0.0f);
        this.bipedVillagerArms.setTextureOffset(48, 0).addBox(-8.0f, -2.0f, -2.0f, 4, 8, 4, p_i1164_1_);
        this.bipedVillagerArms.setTextureOffset(48, 0).addBox(4.0f, -2.0f, -2.0f, 4, 8, 4, p_i1164_1_);
        this.bipedVillagerArms.setTextureOffset(31, 19).addBox(-4.0f, 2.0f, -2.0f, 8, 4, 4, p_i1164_1_);
        (this.bipedRightLeg = new ModelRenderer((ModelBase)this, 32, 0).setTextureSize(p_i1164_3_, p_i1164_4_)).setRotationPoint(-2.0f, 12.0f + p_i1164_2_, 0.0f);
        this.bipedRightLeg.addBox(-2.0f, 0.0f, -2.0f, 4, 12, 4, p_i1164_1_);
        this.bipedLeftLeg = new ModelRenderer((ModelBase)this, 32, 0).setTextureSize(p_i1164_3_, p_i1164_4_);
        this.bipedLeftLeg.mirror = true;
        this.bipedLeftLeg.setRotationPoint(2.0f, 12.0f + p_i1164_2_, 0.0f);
        this.bipedLeftLeg.addBox(-2.0f, 0.0f, -2.0f, 4, 12, 4, p_i1164_1_);
        (this.bipedRightArm = new ModelRenderer((ModelBase)this).setTextureSize(p_i1164_3_, p_i1164_4_)).setRotationPoint(-5.0f, 2.0f + p_i1164_2_, 0.0f);
        this.bipedRightArm.setTextureOffset(48, 0).addBox(-3.0f, -2.0f, -2.0f, 4, 12, 4, p_i1164_1_);
        this.bipedLeftArm = new ModelRenderer((ModelBase)this).setTextureSize(p_i1164_3_, p_i1164_4_);
        this.bipedLeftArm.mirror = true;
        this.bipedLeftArm.setRotationPoint(5.0f, 2.0f + p_i1164_2_, 0.0f);
        this.bipedLeftArm.setTextureOffset(48, 0).addBox(-1.0f, -2.0f, -2.0f, 4, 12, 4, p_i1164_1_);
    }
}
