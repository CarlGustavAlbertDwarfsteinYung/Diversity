// 
// Decompiled by Procyon v0.5.36
// 

package diversity.suppliers;

import java.util.HashMap;
import diversity.village.VillageLakeside;
import diversity.village.VillageEgyptian;
import diversity.village.VillageTibetan;
import diversity.village.VillageZulu;
import diversity.village.VillageSettled;
import diversity.village.VillageInuit;
import diversity.village.VillageAztec;
import diversity.village.VillageApache;
import java.util.Random;
import java.util.Collection;
import java.util.Arrays;

import net.minecraft.entity.passive.EntityVillager;
import net.minecraftforge.common.BiomeManager;
import java.util.ArrayList;
import net.minecraft.world.biome.BiomeGenBase;
import java.util.Map;
import java.util.List;
import diversity.configurations.ConfigBiomeGroup;
import diversity.village.VillageTools;

public enum EnumVillage
{
    APACHE(VillageApache.class, ConfigBiomeGroup.APACHE_VILLAGE, true),
    AZTEC(VillageAztec.class, ConfigBiomeGroup.AZTEC_VILLAGE, true),
    INUIT(VillageInuit.class, ConfigBiomeGroup.INUIT_VILLAGE, true),
    SETTLED(VillageSettled.class, ConfigBiomeGroup.SETTLED_VILLAGE, true),
    ZULU(VillageZulu.class, ConfigBiomeGroup.ZULU_VILLAGE, true),
    TIBETAN(VillageTibetan.class, ConfigBiomeGroup.TIBETAN_VILLAGE, true),
    EGYPTIAN(VillageEgyptian.class, ConfigBiomeGroup.EGYPTIAN_VILLAGE, true),
    LAKESIDE(VillageLakeside.class, ConfigBiomeGroup.LAKESIDE_VILLAGE, true);
    
    public VillageTools instance;
    private final boolean canSpawnRandomly;
    private final ConfigBiomeGroup config;
    public final List<EnumVillagePiece> pieces;
    public final List<EnumVillageBasicPiece> defaultPieces;
    private static Map<BiomeGenBase, List<EnumVillage>> biomeEnumMap;
    
    EnumVillage(final Class villageClass, final ConfigBiomeGroup config, final boolean canSpawnRandomly) {
        this.pieces = new ArrayList<>();
        this.defaultPieces = new ArrayList<>();
        if (villageClass.getSuperclass() == VillageTools.class) {
            try {
                this.instance = (VillageTools)villageClass.getConstructors()[0].newInstance(this);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.config = config;
        this.canSpawnRandomly = canSpawnRandomly;
    }
    
    public static void load() {
        for (final BiomeGenBase biome : BiomeGenBase.getBiomeGenArray()) {
            BiomeManager.addVillageBiome(biome, true);
        }
        EnumVillage.biomeEnumMap.clear();
        for (final EnumVillage enumVillage : values()) {
            if (enumVillage.canSpawnRandomly) {
                for (final BiomeGenBase biome2 : enumVillage.config.getBiomes()) {
                    if (!EnumVillage.biomeEnumMap.containsKey(biome2)) {
                        EnumVillage.biomeEnumMap.put(biome2, new ArrayList<>(Arrays.asList(enumVillage)));
                    }
                    else if (!EnumVillage.biomeEnumMap.get(biome2).contains(enumVillage)) {
                        EnumVillage.biomeEnumMap.get(biome2).add(enumVillage);
                    }
                }
            }
        }
    }
    
    public static boolean canSpawnInBiome(final BiomeGenBase biome) {
        return EnumVillage.biomeEnumMap.get(biome) != null && !EnumVillage.biomeEnumMap.get(biome).isEmpty();
    }
    
    public static VillageTools getRandomVillage(final BiomeGenBase biome, final Random rand) {
        final List<EnumVillage> list = EnumVillage.biomeEnumMap.get(biome);
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(rand.nextInt(list.size())).instance;
    }
    
    static {
        EnumVillage.biomeEnumMap = new HashMap<>();
    }
}
