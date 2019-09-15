// 
// Decompiled by Procyon v0.5.36
// 

package diversity.suppliers;

import diversity.entity.EntityDwarf;
import diversity.entity.EntityZulu;
import diversity.entity.EntityTibetan;
import diversity.entity.EntitySettled;
import diversity.entity.EntityLakeside;
import diversity.entity.EntityInuit;
import diversity.entity.EntityEgyptian;
import diversity.entity.EntityAztec;
import diversity.entity.EntityApache;
import diversity.Diversity;
import cpw.mods.fml.common.registry.EntityRegistry;
import java.util.Iterator;
import diversity.entity.EntityGlobalVillager;
import java.util.Random;
import diversity.utils.ResourceTools;
import java.util.ArrayList;
import java.util.List;

public enum EnumTribe
{
    APACHE(10, "apache", EntityApache.class),
    AZTEC(20, "aztec", EntityAztec.class),
    EGYPTIAN(60, "egyptian", EntityEgyptian.class),
    INUIT(30, "inuit", EntityInuit.class),
    LAKESIDE(70, "lakeside", EntityLakeside.class),
    SETTLED(80, "settled", EntitySettled.class),
    TIBETAN(50, "tibetan", EntityTibetan.class),
    ZULU(40, "zulu", EntityZulu.class),
    DWARF(90, "dwarf", EntityDwarf.class);
    
    public final List<EnumVillager> villagers;
    public final int id;
    public final String path;
    public final Class entityClass;
    
    EnumTribe(final int id, final String path, final Class entityClass) {
        this.villagers = new ArrayList<EnumVillager>();
        this.id = id;
        this.path = path + "/";
        ResourceTools.register(this.entityClass = entityClass, "textures/entities/villagers/" + this.path + "child" + ".png");
    }
    
    public EnumVillager getRandomVillager() {
        return this.villagers.get(new Random().nextInt(this.villagers.size()));
    }
    
    public static EnumTribe getEnumTribe(final EntityGlobalVillager villager) {
        for (final EnumTribe tribe : values()) {
            if (tribe.entityClass.isInstance(villager)) {
                return tribe;
            }
        }
        return null;
    }
    
    public EnumVillager findChief() {
        for (final EnumVillager villager : this.villagers) {
            if (villager.isChief) {
                return villager;
            }
        }
        return null;
    }
    
    public static void register() {
        for (final EnumTribe tribe : values()) {
            final int id = EntityRegistry.findGlobalUniqueEntityId();
            final Integer[] eggcolor = Diversity.proxy.searchEggColor(tribe);
            EntityRegistry.registerGlobalEntityID(tribe.entityClass, "diversity." + tribe.name().toLowerCase(), id, eggcolor[0], eggcolor[1]);
        }
    }
}
