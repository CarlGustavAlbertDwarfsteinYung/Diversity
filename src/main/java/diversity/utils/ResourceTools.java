// 
// Decompiled by Procyon v0.5.36
// 

package diversity.utils;

import java.util.HashMap;
import net.minecraft.util.ResourceLocation;
import java.util.Map;

public class ResourceTools
{
    private static Map<Class, ResourceLocation> resources;
    
    public static void register(final Class entityClass, final String resourcePath) {
        if (resourcePath != null) {
            ResourceTools.resources.put(entityClass, new ResourceLocation("diversity", resourcePath));
        }
    }
    
    public static ResourceLocation getResource(final Class entityClass) {
        return ResourceTools.resources.get(entityClass);
    }
    
    static {
        ResourceTools.resources = new HashMap<Class, ResourceLocation>();
    }
}
