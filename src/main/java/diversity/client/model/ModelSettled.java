// 
// Decompiled by Procyon v0.5.36
// 

package diversity.client.model;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelSettled extends ModelGlobalVillager
{
    public ModelSettled(final float p_i1163_1_) {
        this(p_i1163_1_, 0.0f, 64, 64);
    }
    
    public ModelSettled(final float p_i1164_1_, final float p_i1164_2_, final int p_i1164_3_, final int p_i1164_4_) {
        super(p_i1164_1_, p_i1164_2_, p_i1164_3_, p_i1164_4_);
        this.bipedHead.setTextureOffset(32, 0).addBox(-4.0f, -10.0f, -4.0f, 8, 11, 8, p_i1164_1_ + 0.5f);
    }
}
