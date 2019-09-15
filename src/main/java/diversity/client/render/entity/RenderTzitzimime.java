// 
// Decompiled by Procyon v0.5.36
// 

package diversity.client.render.entity;

import diversity.utils.ResourceTools;
import diversity.entity.EntityTzitzimime;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelBase;
import diversity.client.model.ModelTzitzimime;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderLiving;

@SideOnly(Side.CLIENT)
public class RenderTzitzimime extends RenderLiving
{
    private ModelTzitzimime tzitzimimeModel;
    
    public RenderTzitzimime() {
        super((ModelBase)new ModelTzitzimime(0.0f), 0.5f);
        this.tzitzimimeModel = (ModelTzitzimime)this.mainModel;
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final Entity p_110775_1_) {
        return ResourceTools.getResource(EntityTzitzimime.class);
    }
}
