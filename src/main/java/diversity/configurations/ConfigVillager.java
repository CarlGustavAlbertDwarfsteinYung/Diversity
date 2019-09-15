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

public enum ConfigVillager
{
    TICK_UNTIL_RANDOM_VILLAGER_BECOMES_CHIEF("5000"), 
    REMOVE_VANILLA_SPAWN_EGG("true");
    
    private String value;
    private static final String configNameFile = "diversity-villager.cfg";
    private static final String configFile;
    
    ConfigVillager(final String value) {
        this.value = value;
    }
    
    public int getIntegerConfig() {
        return Integer.valueOf(this.value);
    }
    
    public String getStringConfig() {
        return this.value;
    }
    
    public static void saveConfig(final boolean isWorld) {
        final Properties properties = new Properties();
        for (final ConfigVillager config : values()) {
            properties.setProperty(config.name(), config.value);
        }
        try {
            File file;
            if (isWorld) {
                final File folder = new File(DimensionManager.getCurrentSaveRootDirectory(), "config");
                folder.mkdir();
                file = new File(folder, "diversity-villager.cfg");
            }
            else {
                file = new File(ConfigVillager.configFile);
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
                inputStream = new FileInputStream(new File(folder, "diversity-villager.cfg"));
            }
            else {
                inputStream = new FileInputStream(ConfigVillager.configFile);
            }
            properties.load(inputStream);
            inputStream.close();
        }
        catch (IOException e) {
            return;
        }
        for (final ConfigVillager config : values()) {
            final String value = properties.getProperty(config.name());
            if (value != null && !value.isEmpty()) {
                config.value = value;
            }
        }
    }
    
    static {
        configFile = Loader.instance().getConfigDir() + "/" + "diversity-villager.cfg";
    }
}
