// 
// Decompiled by Procyon v0.5.36
// 

package diversity.client.model;

import diversity.entity.EntityMummy;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelVillager;

@SideOnly(Side.CLIENT)
public class ModelMummy extends ModelVillager
{
    public ModelMummy(final float p_i1163_1_) {
        this(p_i1163_1_, 0.0f, 64, 64);
    }
    
    public ModelMummy(final float p_i1164_1_, final float p_i1164_2_, final int p_i1164_3_, final int p_i1164_4_) {
        super(p_i1164_1_, p_i1164_2_, p_i1164_3_, p_i1164_4_);
        this.villagerArms = new ModelRenderer((ModelBase)this).setTextureSize(p_i1164_3_, p_i1164_4_);
        this.villagerArms.setTextureOffset(44, 22).addBox(-8.0f, -2.0f, -2.0f, 4, 12, 4, p_i1164_1_);
        this.villagerArms.setTextureOffset(44, 22).addBox(4.0f, -2.0f, -2.0f, 4, 12, 4, p_i1164_1_);
    }
    
    @Override
    public void setRotationAngles(final float p_78087_1_, final float p_78087_2_, final float p_78087_3_, final float p_78087_4_, final float p_78087_5_, final float p_78087_6_, final Entity p_78087_7_) {
        super.setRotationAngles(p_78087_1_, p_78087_2_, p_78087_3_, p_78087_4_, p_78087_5_, p_78087_6_, p_78087_7_);
        this.villagerArms.rotationPointY = 3.0f;
        this.villagerArms.rotationPointZ = -1.0f;
        if (p_78087_7_ instanceof EntityMummy && ((EntityMummy)p_78087_7_).getEntityToAttack() != null) {
            this.villagerArms.rotateAngleX = -1.5f;
        }
        else {
            this.villagerArms.rotateAngleX = 0.0f;
        }
    }
}
