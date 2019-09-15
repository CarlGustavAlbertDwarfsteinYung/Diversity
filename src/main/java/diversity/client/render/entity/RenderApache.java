// 
// Decompiled by Procyon v0.5.36
// 

package diversity.client.render.entity;

import diversity.client.model.ModelGlobalVillager;
import diversity.client.model.ModelApache;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderApache extends RenderGlobalVillager
{
    protected ModelApache villagerModel;
    
    public RenderApache() {
        super(new ModelApache(0.0f), 0.5f);
        this.villagerModel = (ModelApache)this.mainModel;
    }
}
