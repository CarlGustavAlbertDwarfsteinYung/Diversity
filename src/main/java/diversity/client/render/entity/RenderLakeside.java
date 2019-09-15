// 
// Decompiled by Procyon v0.5.36
// 

package diversity.client.render.entity;

import diversity.client.model.ModelGlobalVillager;
import diversity.client.model.ModelLakeside;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderLakeside extends RenderGlobalVillager
{
    protected ModelLakeside villagerModel;
    
    public RenderLakeside() {
        super(new ModelLakeside(0.0f), 0.5f);
        this.villagerModel = (ModelLakeside)this.mainModel;
    }
}
