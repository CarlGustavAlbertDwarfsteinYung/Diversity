// 
// Decompiled by Procyon v0.5.36
// 

package diversity.client.render.entity;

import diversity.client.model.ModelGlobalVillager;
import diversity.client.model.ModelEgyptian;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderEgyptian extends RenderGlobalVillager
{
    protected ModelEgyptian villagerModel;
    
    public RenderEgyptian() {
        super(new ModelEgyptian(0.0f), 0.5f);
        this.villagerModel = (ModelEgyptian)this.mainModel;
    }
}
