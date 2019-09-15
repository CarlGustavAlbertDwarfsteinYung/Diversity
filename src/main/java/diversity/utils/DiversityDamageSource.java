// 
// Decompiled by Procyon v0.5.36
// 

package diversity.utils;

import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.Entity;
import diversity.entity.EntityDart;

public class DiversityDamageSource
{
    public static DamageSource causeDartDamage(final EntityDart p_76353_0_, final Entity p_76353_1_) {
        return new EntityDamageSourceIndirect("dart", (Entity)p_76353_0_, p_76353_1_).setProjectile();
    }
}
