// 
// Decompiled by Procyon v0.5.36
// 

package diversity.client.render.entity;

import diversity.client.model.ModelGlobalVillager;
import diversity.client.model.ModelAztec;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderAztec extends RenderGlobalVillager
{
    protected ModelAztec villagerModel;
    
    public RenderAztec() {
        super(new ModelAztec(0.0f), 0.5f);
        this.villagerModel = (ModelAztec)this.mainModel;
    }
}
