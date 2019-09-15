// 
// Decompiled by Procyon v0.5.36
// 

package diversity.client.render.entity;

import diversity.utils.ResourceTools;
import diversity.entity.EntityMummy;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelBase;
import diversity.client.model.ModelMummy;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderLiving;

@SideOnly(Side.CLIENT)
public class RenderMummy extends RenderLiving
{
    private ModelMummy mummyModel;
    
    public RenderMummy() {
        super((ModelBase)new ModelMummy(0.0f), 0.5f);
        this.mummyModel = (ModelMummy)this.mainModel;
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final Entity p_110775_1_) {
        return ResourceTools.getResource(EntityMummy.class);
    }
}
