// 
// Decompiled by Procyon v0.5.36
// 

package diversity.client.render.entity;

import diversity.client.model.ModelGlobalVillager;
import diversity.client.model.ModelSettled;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderSettled extends RenderGlobalVillager
{
    protected ModelSettled villagerModel;
    
    public RenderSettled() {
        super(new ModelSettled(0.0f), 0.5f);
        this.villagerModel = (ModelSettled)this.mainModel;
    }
}
