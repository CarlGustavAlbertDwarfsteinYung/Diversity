// 
// Decompiled by Procyon v0.5.36
// 

package diversity.client.render.entity;

import diversity.client.model.ModelGlobalVillager;
import diversity.client.model.ModelZulu;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderZulu extends RenderGlobalVillager
{
    protected ModelZulu villagerModel;
    
    public RenderZulu() {
        super(new ModelZulu(0.0f), 0.5f);
        this.villagerModel = (ModelZulu)this.mainModel;
    }
}
