// 
// Decompiled by Procyon v0.5.36
// 

package diversity.utils;

import net.minecraft.item.ItemStack;
import java.util.Random;
import net.minecraft.util.WeightedRandomChestContent;
import diversity.structure.Inn;
import diversity.structure.Catacomb;
import diversity.structure.WitchHutt;
import java.util.HashMap;
import net.minecraftforge.common.ChestGenHooks;

public class ChestGenTools extends ChestGenHooks
{
    public static final String SWAMPHUT_CHEST = "swampHutChest";
    public static final String CATACOMB_CHEST = "catacombChest";
    public static final String INN_CHEST = "underInnChest";
    private static final HashMap<String, ChestGenHooks> chestInfo;
    private static boolean hasInit;
    
    private static void init() {
        if (ChestGenTools.hasInit) {
            return;
        }
        ChestGenTools.hasInit = true;
        addInfo("swampHutChest", WitchHutt.itemsToGenerateInHut, 3, 7);
        addInfo("catacombChest", Catacomb.itemsToGenerateCatacomb, 4, 8);
        addInfo("underInnChest", Inn.itemsToGenerateInn, 2, 5);
    }
    
    public ChestGenTools(final String category, final WeightedRandomChestContent[] items, final int min, final int max) {
        super(category, items, min, max);
    }
    
    private static void addInfo(final String category, final WeightedRandomChestContent[] items, final int min, final int max) {
        ChestGenTools.chestInfo.put(category, new ChestGenHooks(category, items, min, max));
    }
    
    public static ChestGenHooks getInfo(final String category) {
        if (!ChestGenTools.chestInfo.containsKey(category)) {
            ChestGenTools.chestInfo.put(category, new ChestGenHooks(category));
        }
        return ChestGenTools.chestInfo.get(category);
    }
    
    public static WeightedRandomChestContent[] getItems(final String category, final Random rnd) {
        return getInfo(category).getItems(rnd);
    }
    
    public static int getCount(final String category, final Random rand) {
        return getInfo(category).getCount(rand);
    }
    
    public static void addItem(final String category, final WeightedRandomChestContent item) {
        getInfo(category).addItem(item);
    }
    
    public static void removeItem(final String category, final ItemStack item) {
        getInfo(category).removeItem(item);
    }
    
    public static ItemStack getOneItem(final String category, final Random rand) {
        return getInfo(category).getOneItem(rand);
    }
    
    static {
        chestInfo = new HashMap<String, ChestGenHooks>();
        ChestGenTools.hasInit = false;
        init();
    }
}
