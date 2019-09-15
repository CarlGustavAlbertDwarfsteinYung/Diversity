// 
// Decompiled by Procyon v0.5.36
// 

package diversity.suppliers;

import diversity.entity.EntityYeti;
import diversity.entity.EntityDarkSpider;
import diversity.entity.EntityWorshipper;
import diversity.entity.EntityWarriorSkeleton;
import diversity.entity.EntityTzitzimime;
import diversity.entity.EntityMummy;
import net.minecraft.entity.EntityList;
import cpw.mods.fml.common.registry.EntityRegistry;
import diversity.Diversity;
import diversity.configurations.ConfigBiomeGroup;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.entity.EnumCreatureType;

public enum EnumEntity
{
    MUMMY(EntityMummy.class),
    TZITZIMIME(EntityTzitzimime.class),
    WARRIOR_SKELETON(EntityWarriorSkeleton.class, 75, 2, 5, EnumCreatureType.monster, new BiomeGenBase[] { BiomeGenBase.swampland }),
    WORSHIPPER(EntityWorshipper.class, 25, 1, 2, EnumCreatureType.monster, ConfigBiomeGroup.SHROOM_CAVE),
    DARKSPIDER(EntityDarkSpider.class),
    YETI(EntityYeti.class);
    
    public final Class entityClass;
    public final String resourcePath;
    public final int weight;
    public final int min;
    public final int max;
    public final EnumCreatureType spawnList;
    public final BiomeGenBase[] biomes;
    public final ConfigBiomeGroup config;
    static int startEntityId;
    
    EnumEntity(final Class entityClass) {
        this(entityClass, 0, 0, 0, null, null, null);
    }
    
    EnumEntity(final Class entityClass, final int weight, final int min, final int max, final EnumCreatureType spawnList, final BiomeGenBase[] biomes) {
        this(entityClass, weight, min, max, spawnList, null, biomes);
    }
    
    EnumEntity(final Class entityClass, final int weight, final int min, final int max, final EnumCreatureType spawnList, final ConfigBiomeGroup config) {
        this(entityClass, weight, min, max, spawnList, config, null);
    }
    
    EnumEntity(final Class entityClass, final int weight, final int min, final int max, final EnumCreatureType spawnList, final ConfigBiomeGroup config, final BiomeGenBase[] biomes) {
        this.entityClass = entityClass;
        this.resourcePath = "textures/entities/monsters/" + this.name().toLowerCase() + ".png";
        this.weight = weight;
        this.min = min;
        this.max = max;
        this.spawnList = spawnList;
        this.config = config;
        this.biomes = biomes;
    }
    
    public static void register() {
        for (final EnumEntity entity : values()) {
            Diversity.proxy.registerEntityResource(entity);
            final int id = getUniqueEntityId();
            final Integer[] eggcolor = Diversity.proxy.searchEggColor(entity);
            EntityRegistry.registerModEntity(entity.entityClass, entity.name().toLowerCase(), id, Diversity.instance, 64, 1, true);
            EntityList.IDtoClassMapping.put(id, entity.entityClass);
            EntityList.entityEggs.put(id, new EntityList.EntityEggInfo(id, eggcolor[0], eggcolor[1]));
        }
    }
    
    public static int getUniqueEntityId() {
        do {
            ++EnumEntity.startEntityId;
        } while (EntityList.getStringFromID(EnumEntity.startEntityId) != null);
        return EnumEntity.startEntityId;
    }
    
    public static void load() {
        for (final EnumEntity entity : values()) {
            if (entity.biomes != null && entity.biomes.length > 0) {
                EntityRegistry.addSpawn(entity.entityClass, entity.weight, entity.min, entity.max, entity.spawnList, entity.biomes);
            }
            else if (entity.config != null) {
                EntityRegistry.addSpawn(entity.entityClass, entity.weight, entity.min, entity.max, entity.spawnList, entity.config.getBiomes());
            }
        }
    }
    
    static {
        EnumEntity.startEntityId = 300;
    }
}
