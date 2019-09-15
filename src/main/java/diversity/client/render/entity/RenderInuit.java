// 
// Decompiled by Procyon v0.5.36
// 

package diversity.client.render.entity;

import diversity.client.model.ModelGlobalVillager;
import diversity.client.model.ModelInuit;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderInuit extends RenderGlobalVillager
{
    protected ModelInuit villagerModel;
    
    public RenderInuit() {
        super(new ModelInuit(0.0f), 0.5f);
        this.villagerModel = (ModelInuit)this.mainModel;
    }
}
