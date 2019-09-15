// 
// Decompiled by Procyon v0.5.36
// 

package diversity.configurations;

import cpw.mods.fml.common.Loader;
import java.io.IOException;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.File;
import net.minecraftforge.common.DimensionManager;
import java.util.Properties;

public enum ConfigGenerationRate
{
    MAXDISTANCEBETWEENVILLAGES(32), 
    MINDISTANCEBETWEENVILLAGES(8), 
    MAXDISTANCEBETWEENSTRUCTURES(32), 
    MINDISTANCEBETWEENSTRUCTURES(8), 
    MAXDISTANCEBETWEENCAVES(32), 
    MINDISTANCEBETWEENCAVES(8);
    
    private String value;
    private static final String configNameFile = "diversity-generation-rate.cfg";
    private static final String configFile;
    
    ConfigGenerationRate(final int config) {
        this.value = String.valueOf(config);
    }
    
    ConfigGenerationRate(final String config) {
        this.value = config;
    }
    
    public int getIntegerConfig() {
        return Integer.valueOf(this.value);
    }
    
    public static void saveConfig(final boolean isWorld) {
        final Properties properties = new Properties();
        for (final ConfigGenerationRate config : values()) {
            properties.setProperty(config.name(), config.value);
        }
        try {
            File file;
            if (isWorld) {
                final File folder = new File(DimensionManager.getCurrentSaveRootDirectory(), "config");
                folder.mkdir();
                file = new File(folder, "diversity-generation-rate.cfg");
            }
            else {
                file = new File(ConfigGenerationRate.configFile);
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
                inputStream = new FileInputStream(new File(folder, "diversity-generation-rate.cfg"));
            }
            else {
                inputStream = new FileInputStream(ConfigGenerationRate.configFile);
            }
            properties.load(inputStream);
            inputStream.close();
        }
        catch (IOException e) {
            return;
        }
        for (final ConfigGenerationRate config : values()) {
            final String value = properties.getProperty(config.name());
            if (value != null && !value.isEmpty()) {
                config.value = value;
            }
        }
    }
    
    static {
        configFile = Loader.instance().getConfigDir() + "/" + "diversity-generation-rate.cfg";
    }
}
