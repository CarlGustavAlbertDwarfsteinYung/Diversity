// 
// Decompiled by Procyon v0.5.36
// 

package diversity.configurations;

import cpw.mods.fml.common.Loader;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.File;

import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.DimensionManager;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import net.minecraft.world.biome.BiomeGenBase;

public enum ConfigBiomeGroup
{
    //EGYPTIAN_PYRAMID(new BiomeGenBase[] { BiomeGenBase.desert, BiomeGenBase.desertHills }),
   // AZTEC_PYRAMID(new BiomeGenBase[] { BiomeGenBase.jungle, BiomeGenBase.jungleHills }),
    CATACOMB(new BiomeGenBase[]{BiomeGenBase.roofedForest}),
   // WITCH_HUTT(new BiomeGenBase[] { BiomeGenBase.swampland }),
    INN(new BiomeGenBase [] { BiomeGenBase.plains}),
    //JUNGLE_VALLEY(new BiomeGenBase[] { BiomeGenBase.jungle, BiomeGenBase.jungleHills }),
    SHROOM_CAVE(BiomeDictionary.getBiomesForType(BiomeDictionary.Type.MAGICAL)),
    YETI_DEN(new BiomeGenBase[]{BiomeGenBase.iceMountains, BiomeGenBase.icePlains.createMutation()}),
    SPIDER_DEN(BiomeDictionary.getBiomesForType(BiomeDictionary.Type.SPOOKY)),
    VANILLA_VILLAGE(new BiomeGenBase[] {BiomeGenBase.plains, BiomeGenBase.desert, BiomeGenBase.savanna, BiomeGenBase.taiga}),
    DWARVEN_CAVE(new BiomeGenBase[]{BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsPlus}),
    APACHE_VILLAGE(new BiomeGenBase[]{BiomeGenBase.mesaPlateau, BiomeGenBase.mesaPlateau_F}),
    AZTEC_VILLAGE(new BiomeGenBase[]{BiomeGenBase.jungle}),
    INUIT_VILLAGE(new BiomeGenBase[]{BiomeGenBase.icePlains, BiomeGenBase.coldBeach}),
    SETTLED_VILLAGE(new BiomeGenBase [] {BiomeGenBase.taiga, BiomeGenBase.taigaHills}),
    ZULU_VILLAGE(new BiomeGenBase[] {BiomeGenBase.savanna, BiomeGenBase.savannaPlateau}),
    TIBETAN_VILLAGE(new BiomeGenBase[]{BiomeGenBase.extremeHills}),
    EGYPTIAN_VILLAGE(new BiomeGenBase[] {BiomeGenBase.desert}),
    LAKESIDE_VILLAGE(new BiomeGenBase[]{BiomeGenBase.swampland});
    private BiomeGenBase[] biomes;
    private static final String configNameFile = "diversity-biome-groups.cfg";
    private static final String configFile;
    
    ConfigBiomeGroup(final BiomeGenBase[] biomes) {
        this.biomes = biomes;
    }
    
    public static void saveConfig(final boolean isWorld) {
        final Properties properties = new Properties();
        for (final ConfigBiomeGroup config : values()) {
            properties.setProperty(config.name(), AConfigTool.join(config.biomes));
        }
        try {
            File file;
            if (isWorld) {
                final File folder = new File(DimensionManager.getCurrentSaveRootDirectory(), "config");
                folder.mkdir();
                file = new File(folder, "diversity-biome-groups.cfg");
            }
            else {
                file = new File(ConfigBiomeGroup.configFile);
            }
            properties.store(new FileOutputStream(file), null);
        }
        catch (Exception ex) {}
    }
    
    public static void loadConfig(final boolean isWorld) {
        final Properties properties = new Properties();
        try {
            FileInputStream inputStream;
            if (isWorld) {
                final File folder = new File(DimensionManager.getCurrentSaveRootDirectory(), "config");
                folder.mkdir();
                inputStream = new FileInputStream(new File(folder, "diversity-biome-groups.cfg"));
            }
            else {
                inputStream = new FileInputStream(ConfigBiomeGroup.configFile);
            }
            properties.load(inputStream);
            inputStream.close();
        }
        catch (IOException e) {
            return;
        }
        for (final ConfigBiomeGroup config : values()) {
            final BiomeGenBase[] biomes = AConfigTool.split(properties.getProperty(config.name()));
            if (biomes != null) {
                config.biomes = biomes;
            }
        }
    }
    
    public BiomeGenBase[] getBiomes() {
        return this.biomes;
    }

    public List<BiomeGenBase> getBiomesList() {
        return Arrays.asList(getBiomes());
    }
    
    static {
        configFile = Loader.instance().getConfigDir() + "/" + "diversity-biome-groups.cfg";
    }
}
