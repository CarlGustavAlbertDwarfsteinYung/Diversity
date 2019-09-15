// 
// Decompiled by Procyon v0.5.36
// 

package diversity.configurations;

import java.util.List;
import java.util.ArrayList;
import net.minecraft.world.biome.BiomeGenBase;

public abstract class AConfigTool
{
    static String join(final BiomeGenBase[] biomes) {
        int biomeNumber = 0;
        for (final BiomeGenBase biome : BiomeGenBase.getBiomeGenArray()) {
            if (biome != null) {
                ++biomeNumber;
            }
        }
        if (biomes.length == biomeNumber) {
            return "ALL";
        }
        final StringBuilder sb = new StringBuilder();
        String loopDelim = "";
        for (final BiomeGenBase biome2 : biomes) {
            if (biome2 != null) {
                sb.append(loopDelim);
                sb.append(biome2.biomeID);
                loopDelim = ",";
            }
        }
        return sb.toString();
    }
    
    static BiomeGenBase[] split(final String config) {
        if (config == null) {
            return null;
        }
        final List<BiomeGenBase> biomes = new ArrayList<BiomeGenBase>();
        if (config.equals("ALL")) {
            for (final BiomeGenBase biome : BiomeGenBase.getBiomeGenArray()) {
                if (biome != null) {
                    biomes.add(biome);
                }
            }
        }
        else {
            final String[] split;
            final String[] values = split = config.split(",");
            for (final String value : split) {
                if (value != null && !value.isEmpty()) {
                    final BiomeGenBase biome2 = BiomeGenBase.getBiome((int)Integer.valueOf(value));
                    if (biome2 != null) {
                        biomes.add(biome2);
                    }
                }
            }
        }
        return biomes.toArray(new BiomeGenBase[biomes.size()]);
    }
    
    public static void values() {
        ConfigGenerationRate.values();
        ConfigBiomeGroup.values();
        ConfigVillager.values();
    }
    
    public static void loadAllConfig(final boolean isWorld) {
        ConfigGenerationRate.loadConfig(isWorld);
        ConfigBiomeGroup.loadConfig(isWorld);
        ConfigVillager.loadConfig(isWorld);
    }
    
    public static void saveAllConfig(final boolean isWorld) {
        ConfigGenerationRate.saveConfig(isWorld);
        ConfigBiomeGroup.saveConfig(isWorld);
        ConfigVillager.saveConfig(isWorld);
    }
}
