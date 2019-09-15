// 
// Decompiled by Procyon v0.5.36
// 

package diversity.client.render.entity;

import diversity.utils.ResourceTools;
import diversity.entity.EntityWarriorSkeleton;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelBase;
import diversity.client.model.ModelWarriorSkeleton;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderLiving;

@SideOnly(Side.CLIENT)
public class RenderWarriorSkeleton extends RenderLiving
{
    private ModelWarriorSkeleton warriorSkeletonModel;
    
    public RenderWarriorSkeleton() {
        super((ModelBase)new ModelWarriorSkeleton(0.0f), 0.5f);
        this.warriorSkeletonModel = (ModelWarriorSkeleton)this.mainModel;
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final Entity p_110775_1_) {
        return ResourceTools.getResource(EntityWarriorSkeleton.class);
    }
}
