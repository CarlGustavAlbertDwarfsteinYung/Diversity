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

import java.util.ArrayList;
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
    VANILLA_VILLAGE(null),
    DWARVEN_CAVE(BiomeDictionary.getBiomesForType(BiomeDictionary.Type.HILLS)),
    APACHE_VILLAGE(BiomeDictionary.getBiomesForType(BiomeDictionary.Type.MESA)),
    AZTEC_VILLAGE(BiomeDictionary.getBiomesForType(BiomeDictionary.Type.JUNGLE)),
    INUIT_VILLAGE(BiomeDictionary.getBiomesForType(BiomeDictionary.Type.COLD)),
    SETTLED_VILLAGE(BiomeDictionary.getBiomesForType(BiomeDictionary.Type.FOREST)),
    ZULU_VILLAGE(BiomeDictionary.getBiomesForType(BiomeDictionary.Type.SAVANNA)),
    TIBETAN_VILLAGE(new BiomeGenBase[]{BiomeGenBase.extremeHills}),
    EGYPTIAN_VILLAGE(new BiomeGenBase[] {BiomeGenBase.desert}),
    LAKESIDE_VILLAGE(BiomeDictionary.getBiomesForType(BiomeDictionary.Type.SWAMP));
    private BiomeGenBase[] biomes;
    private static final String configNameFile = "diversity-biome-groups.cfg";
    private static final String configFile;
    
    ConfigBiomeGroup(BiomeGenBase[] biomes) {
        if (biomes == null) {

            ArrayList<BiomeGenBase> bims = new ArrayList<BiomeGenBase>();
            bims.addAll(Arrays.asList(BiomeDictionary.getBiomesForType(BiomeDictionary.Type.PLAINS)));
            bims.addAll(Arrays.asList(BiomeDictionary.getBiomesForType(BiomeDictionary.Type.CONIFEROUS)));
            bims.addAll(Arrays.asList(BiomeDictionary.getBiomesForType(BiomeDictionary.Type.SAVANNA)));
            bims.addAll(Arrays.asList(BiomeDictionary.getBiomesForType(BiomeDictionary.Type.FOREST)));

            biomes = (BiomeGenBase[])bims.toArray();
        }
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
