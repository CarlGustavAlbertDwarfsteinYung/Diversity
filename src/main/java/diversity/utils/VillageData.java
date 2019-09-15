// 
// Decompiled by Procyon v0.5.36
// 

package diversity.utils;

import java.util.HashMap;
import diversity.entity.EntityGlobalVillager;
import net.minecraft.village.Village;
import java.util.Map;

public class VillageData
{
    private static final Map<Village, EntityGlobalVillager> map;
    
    public static void addChief(final Village village, final EntityGlobalVillager chief) {
        if (!VillageData.map.containsKey(village) || VillageData.map.get(village) == null) {
            chief.setChief();
            VillageData.map.put(village, chief);
        }
    }
    
    public static EntityGlobalVillager getChief(final Village village) {
        return VillageData.map.get(village);
    }
    
    public static void onDeadChief(final Village village) {
        VillageData.map.remove(village);
    }
    
    public static void onAnihilated(final Village village) {
        VillageData.map.remove(village);
    }
    
    static {
        map = new HashMap<Village, EntityGlobalVillager>();
    }
}
