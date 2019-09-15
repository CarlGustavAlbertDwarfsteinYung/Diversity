// 
// Decompiled by Procyon v0.5.36
// 

package diversity.client.render.entity;

import diversity.client.model.ModelGlobalVillager;
import diversity.client.model.ModelTibetan;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderTibetan extends RenderGlobalVillager
{
    protected ModelTibetan villagerModel;
    
    public RenderTibetan() {
        super(new ModelTibetan(0.0f), 0.5f);
        this.villagerModel = (ModelTibetan)this.mainModel;
    }
}
