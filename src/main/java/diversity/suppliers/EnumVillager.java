// 
// Decompiled by Procyon v0.5.36
// 

package diversity.suppliers;

import org.apache.commons.lang3.ArrayUtils;
import java.util.Iterator;
import diversity.utils.TradeTools;
import java.util.Collections;
import java.util.Collection;
import diversity.entity.EntityGlobalVillager;
import java.util.Random;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.entity.passive.EntityVillager;
import diversity.Diversity;
import java.util.ArrayList;
import diversity.utils.Economy;
import java.util.List;
import cpw.mods.fml.common.registry.VillagerRegistry;

public enum EnumVillager implements VillagerRegistry.IVillageTradeHandler
{
    APACHE_BREEDER(EnumTribe.APACHE, "breeder", new Economy.IItem[] { Economy.EPrice.wheat, Economy.EPrice.wheat_seeds, Economy.EPrice.leather }, new Economy.IItem[] { Economy.EPrice.iron_horse_armor, Economy.EPrice.saddle, Economy.EPrice.lead }), 
    APACHE_HUNTER(EnumTribe.APACHE, "hunter", new Economy.IItem[] { Economy.EPrice.string, Economy.EPrice.stick, Economy.EPrice.flint, Economy.EPrice.feather }, new Economy.IItem[] { Economy.EPrice.bow, Economy.EPrice.arrow, Economy.EPrice.lead }), 
    APACHE_SHAMAN(EnumTribe.APACHE, "shaman", new Economy.IItem[] { Economy.EPrice.bone, Economy.EPrice.gray_dye, Economy.EPrice.orange_dye, Economy.EPrice.light_blue_dye, Economy.EPrice.bowl }, new Economy.IItem[] { Economy.EPrice.bottle_o_enchanting, Economy.EPrice.potion_nausea, Economy.EPrice.potion_speed, Economy.EPrice.potion_fire_resistance }), 
    APACHE_CHIEF(EnumTribe.APACHE, "chief", new Economy.IItem[] { Economy.EPrice.feather }, new Economy.IItem[] { Economy.EPrice.stone_axe, Economy.EPrice.golden_horse_armor, Economy.EPrice.emerald }, true), 
    APACHE_WARRIOR(EnumTribe.APACHE, "warrior", new Economy.IItem[] { Economy.EPrice.iron_axe, Economy.EPrice.iron_sword, Economy.EPrice.leather }, new Economy.IItem[] { Economy.EPrice.stone_axe, Economy.EPrice.stone_sword, Economy.EPrice.lead, Economy.EPrice.leather_helmet, Economy.EPrice.leather_tunic, Economy.EPrice.leather_pants, Economy.EPrice.leather_boots }), 
    AZTEC_HUNTER(EnumTribe.AZTEC, "hunter", new Economy.IItem[0], new Economy.IItem[0]), 
    AZTEC_DYER(EnumTribe.AZTEC, "dyer", new Economy.IItem[] { Economy.EPrice.red_wool, Economy.EPrice.dandelion_yellow, Economy.EPrice.cactus_green }, new Economy.IItem[] { Economy.EPrice.yellow_wool, Economy.EPrice.lime_wool }), 
    AZTEC_CHIEF(EnumTribe.AZTEC, "chief", new Economy.IItem[] { Economy.EPrice.diamond }, new Economy.IItem[] { Economy.EPrice.emerald }, true), 
    AZTEC_HIGHPRIEST(EnumTribe.AZTEC, "highpriest", new Economy.IItem[] { Economy.EPrice.ender_pearl, Economy.EPrice.rose_red }, new Economy.IItem[] { Economy.EPrice.emerald, Economy.EPrice.potion_poison, Economy.EPrice.potion_night_vision, Economy.EPrice.potion_weakness, Economy.EPrice.potion_slowness }), 
    AZTEC_BREEDER(EnumTribe.AZTEC, "breeder", new Economy.IItem[] { Economy.EPrice.wheat_seeds, Economy.EPrice.pumpkin_seeds, Economy.EPrice.melon_seeds }, new Economy.IItem[] { Economy.EPrice.raw_chicken, Economy.EPrice.cooked_chicken, Economy.EPrice.egg }), 
    AZTEC_FARMER(EnumTribe.AZTEC, "farmer", new Economy.IItem[] { Economy.EPrice.wheat_seeds, Economy.EPrice.pumpkin_seeds, Economy.EPrice.melon_seeds }, new Economy.IItem[] { Economy.EPrice.raw_chicken, Economy.EPrice.cooked_chicken, Economy.EPrice.egg }), 
    INUIT_FISHERMAN(EnumTribe.INUIT, "fisherman", new Economy.IItem[] { Economy.EPrice.stick, Economy.EPrice.string, Economy.EPrice.leather, Economy.EPrice.white_wool }, new Economy.IItem[] { Economy.EPrice.raw_fish, Economy.EPrice.cooked_fish, Economy.EPrice.raw_salmon, Economy.EPrice.cooked_salmon, Economy.EPrice.fishing_rod }), 
    INUIT_HUNTER(EnumTribe.INUIT, "hunter", new Economy.IItem[] { Economy.EPrice.string, Economy.EPrice.stick, Economy.EPrice.flint, Economy.EPrice.feather, Economy.EPrice.leather }, new Economy.IItem[] { Economy.EPrice.bow, Economy.EPrice.arrow, Economy.EPrice.leather_helmet, Economy.EPrice.leather_tunic, Economy.EPrice.leather_pants, Economy.EPrice.leather_boots }), 
    INUIT_KENNELMASTER(EnumTribe.INUIT, "kennelmaster", new Economy.IItem[] { Economy.EPrice.bone, Economy.EPrice.raw_porkchop, Economy.EPrice.raw_beef, Economy.EPrice.raw_fish, Economy.EPrice.raw_salmon }, new Economy.IItem[] { Economy.EPrice.lead }), 
    INUIT_CHIEF(EnumTribe.INUIT, "chief", new Economy.IItem[] { Economy.EPrice.diamond, Economy.EPrice.diamond_sword }, new Economy.IItem[] { Economy.EPrice.emerald, Economy.EPrice.enchanted_book_fortune, Economy.EPrice.enchanted_book_silk_touch }, true), 
    ZULU_FARMER(EnumTribe.ZULU, "farmer", new Economy.IItem[] { Economy.EPrice.wheat, Economy.EPrice.wheat_seeds }, new Economy.IItem[] { Economy.EPrice.wheat, Economy.EPrice.bread, Economy.EPrice.stone_hoe }), 
    ZULU_WARRIOR(EnumTribe.ZULU, "warrior", new Economy.IItem[] { Economy.EPrice.iron_axe, Economy.EPrice.iron_sword, Economy.EPrice.leather }, new Economy.IItem[] { Economy.EPrice.stone_axe, Economy.EPrice.stone_sword, Economy.EPrice.iron_axe, Economy.EPrice.leather_helmet, Economy.EPrice.leather_tunic, Economy.EPrice.leather_pants, Economy.EPrice.leather_boots }), 
    ZULU_BREEDER(EnumTribe.ZULU, "breeder", new Economy.IItem[] { Economy.EPrice.wheat, Economy.EPrice.wheat_seeds }, new Economy.IItem[] { Economy.EPrice.raw_beef, Economy.EPrice.steak, Economy.EPrice.leather }), 
    ZULU_CHIEF(EnumTribe.ZULU, "chief", new Economy.IItem[] { Economy.EPrice.golden_sword, Economy.EPrice.golden_helmet, Economy.EPrice.golden_chesplate, Economy.EPrice.golden_leggings, Economy.EPrice.golden_boots }, new Economy.IItem[] { Economy.EPrice.emerald, Economy.EPrice.diamond }, true), 
    ZULU_GURU(EnumTribe.ZULU, "guru", new Economy.IItem[] { Economy.EPrice.bone, Economy.EPrice.ink, Economy.EPrice.light_gray_dye, Economy.EPrice.gray_dye, Economy.EPrice.bone_meal }, new Economy.IItem[] { Economy.EPrice.bowl, Economy.EPrice.bottle_o_enchanting, Economy.EPrice.potion_nausea, Economy.EPrice.potion_jump_boost, Economy.EPrice.potion_saturation, Economy.EPrice.potion_instant_damage }), 
    TIBETAN_MONK(EnumTribe.TIBETAN, "monk", new Economy.IItem[] { Economy.EPrice.pumpkin, Economy.EPrice.pumpkin_seeds, Economy.EPrice.wheat_seeds }, new Economy.IItem[] { Economy.EPrice.wheat, Economy.EPrice.bread, Economy.EPrice.pumpkin_pie }), 
    TIBETAN_MASTER(EnumTribe.TIBETAN, "master", new Economy.IItem[] { Economy.EPrice.rose_red, Economy.EPrice.dandelion_yellow, Economy.EPrice.orange_dye, Economy.EPrice.bone_meal }, new Economy.IItem[] { Economy.EPrice.bottle_o_enchanting, Economy.EPrice.potion_invisibility, Economy.EPrice.enchanted_book_infinity }), 
    TIBETAN_GREATWISE(EnumTribe.TIBETAN, "greatwise", new Economy.IItem[] { Economy.EPrice.clock, Economy.EPrice.enchanted_book_protection }, new Economy.IItem[] { Economy.EPrice.emerald, Economy.EPrice.compass, Economy.EPrice.diamond, Economy.EPrice.ender_pearl }, true), 
    EGYPTIAN_FARMER(EnumTribe.EGYPTIAN, "farmer", new Economy.IItem[] { Economy.EPrice.bone_meal, Economy.EPrice.wheat_seeds, Economy.EPrice.sugar_canes }, new Economy.IItem[] { Economy.EPrice.wheat, Economy.EPrice.sugar }), 
    EGYPTIAN_SCULPTOR(EnumTribe.EGYPTIAN, "sculptor", new Economy.IItem[] { Economy.EPrice.sandstone }, new Economy.IItem[] { Economy.EPrice.chiseled_sandstone, Economy.EPrice.smooth_sandstone }), 
    EGYPTIAN_SCRIBE(EnumTribe.EGYPTIAN, "scribe", new Economy.IItem[] { Economy.EPrice.ink, Economy.EPrice.lapis_lazuli, Economy.EPrice.purple_dye, Economy.EPrice.paper, Economy.EPrice.sugar }, new Economy.IItem[] { Economy.EPrice.map, Economy.EPrice.empty_map }), 
    EGYPTIAN_PRIEST(EnumTribe.EGYPTIAN, "priest", new Economy.IItem[] { Economy.EPrice.ink, Economy.EPrice.lapis_lazuli, Economy.EPrice.purple_dye, Economy.EPrice.bone_meal }, new Economy.IItem[] { Economy.EPrice.bottle_o_enchanting, Economy.EPrice.bowl, Economy.EPrice.enchanted_book_protection, Economy.EPrice.enchanted_book_blast_protection, Economy.EPrice.enchanted_book_flame }), 
    EGYPTIAN_PAINTER(EnumTribe.EGYPTIAN, "painter", (Economy.IItem[])ArrayUtils.addAll((Object[])new Economy.IItem[] { Economy.EPrice.paper, Economy.EPrice.white_wool, Economy.EPrice.stick }, (Object[])Economy.GPrice.dye.getIPrices()), new Economy.IItem[] { Economy.EPrice.painting }), 
    EGYPTIAN_GUARD(EnumTribe.EGYPTIAN, "guard", new Economy.IItem[] { Economy.EPrice.iron_axe, Economy.EPrice.iron_sword, Economy.EPrice.leather }, new Economy.IItem[] { Economy.EPrice.stone_axe, Economy.EPrice.stone_sword, Economy.EPrice.lead, Economy.EPrice.iron_helmet, Economy.EPrice.iron_chestplate, Economy.EPrice.iron_leggings, Economy.EPrice.iron_boots }), 
    EGYPTIAN_PHARAOH(EnumTribe.EGYPTIAN, "pharaoh", new Economy.IItem[] { Economy.EPrice.diamond, Economy.EPrice.compass }, new Economy.IItem[] { Economy.EPrice.emerald, Economy.EPrice.clock }, true), 
    LAKESIDE_FISHERMAN(EnumTribe.LAKESIDE, "fisherman", new Economy.IItem[] { Economy.EPrice.stick, Economy.EPrice.string }, new Economy.IItem[] { Economy.EPrice.raw_fish, Economy.EPrice.cooked_fish, Economy.EPrice.fishing_rod }), 
    LAKESIDE_FARMER(EnumTribe.LAKESIDE, "farmer", new Economy.IItem[] { Economy.EPrice.iron_hoe }, new Economy.IItem[] { Economy.EPrice.carrot, Economy.EPrice.potato, Economy.EPrice.baked_potato, Economy.EPrice.lily_pad, Economy.EPrice.vines }), 
    LAKESIDE_BREEDER(EnumTribe.LAKESIDE, "breeder", new Economy.IItem[] { Economy.EPrice.potato, Economy.EPrice.poisonous_potato, Economy.EPrice.carrot }, new Economy.IItem[] { Economy.EPrice.raw_porkchop, Economy.EPrice.cooked_porkchop, Economy.EPrice.bone }), 
    LAKESIDE_GUARD(EnumTribe.LAKESIDE, "guard", new Economy.IItem[] { Economy.EPrice.iron_axe, Economy.EPrice.iron_sword, Economy.EPrice.leather }, new Economy.IItem[] { Economy.EPrice.stone_axe, Economy.EPrice.stone_sword, Economy.EPrice.lead, Economy.EPrice.iron_helmet, Economy.EPrice.iron_chestplate, Economy.EPrice.iron_leggings, Economy.EPrice.iron_boots }), 
    LAKESIDE_CHIEF(EnumTribe.LAKESIDE, "chief", new Economy.IItem[] { Economy.EPrice.compass }, new Economy.IItem[] { Economy.EPrice.emerald, Economy.EPrice.enchanted_book_punch, Economy.EPrice.enchanted_book_aqua_affinity }, true), 
    SETTLED_BUTCHER(EnumTribe.SETTLED, "butcher", new Economy.IItem[] { Economy.EPrice.coal, Economy.EPrice.raw_porkchop }, new Economy.IItem[] { Economy.EPrice.leather_boots, Economy.EPrice.leather_tunic, Economy.EPrice.leather_pants, Economy.EPrice.leather_boots, Economy.EPrice.saddle, Economy.EPrice.cooked_porkchop, Economy.EPrice.steak, Economy.EPrice.carrot_on_a_stick }), 
    SETTLED_FARMER(EnumTribe.SETTLED, "farmer", new Economy.IItem[] { Economy.EPrice.wheat_seeds, Economy.EPrice.carrot, Economy.EPrice.potato }, new Economy.IItem[] { Economy.EPrice.wheat, Economy.EPrice.carrot, Economy.EPrice.baked_potato }), 
    SETTLED_LIBRARIAN(EnumTribe.SETTLED, "librarian", new Economy.IItem[] { Economy.EPrice.paper, Economy.EPrice.book }, new Economy.IItem[] { Economy.EPrice.compass, Economy.EPrice.clock, Economy.EPrice.bookshelf, Economy.EPrice.enchanted_book_looting, Economy.EPrice.enchanted_book_projectile_protection, Economy.EPrice.enchanted_book_sharpness }), 
    SETTLED_PRIEST(EnumTribe.SETTLED, "priest", new Economy.IItem[] { Economy.EPrice.redstone, Economy.EPrice.glowstone_dust }, new Economy.IItem[] { Economy.EPrice.ender_pearl, Economy.EPrice.bottle_o_enchanting, Economy.EPrice.glowstone, Economy.EPrice.potion_renegeration, Economy.EPrice.potion_health_boost }), 
    SETTLED_SMITH(EnumTribe.SETTLED, "smith", new Economy.IItem[] { Economy.EPrice.iron_ingot }, new Economy.IItem[] { Economy.EPrice.chainmail_helmet, Economy.EPrice.chainmail_chestplate, Economy.EPrice.chainmail_leggings, Economy.EPrice.chainmail_boots, Economy.EPrice.iron_helmet, Economy.EPrice.iron_chestplate, Economy.EPrice.iron_leggings, Economy.EPrice.iron_boots }), 
    SETTLED_VILLAGER(EnumTribe.SETTLED, "villager", new Economy.IItem[] { Economy.EPrice.wheat, Economy.EPrice.white_wool }, new Economy.IItem[] { Economy.EPrice.apple, Economy.EPrice.cookie, Economy.EPrice.shears, Economy.EPrice.bread }), 
    SETTLED_GUARD(EnumTribe.SETTLED, "guard"), 
    SETTLED_INNKEEPER(EnumTribe.SETTLED, "innkeeper", new Economy.IItem[0], new Economy.IItem[] { Economy.EPrice.apple, Economy.EPrice.cooked_porkchop, Economy.EPrice.cooked_chicken, Economy.EPrice.bread, Economy.EPrice.mushroom_stew }), 
    DWARF_SMITH(EnumTribe.DWARF, "smith", new Economy.IItem[] { Economy.EPrice.coal, Economy.EPrice.cobblestone, Economy.EPrice.oak_planks, Economy.EPrice.iron_ingot }, new Economy.IItem[] { Economy.EPrice.stonebrick, Economy.EPrice.iron_pickaxe, Economy.EPrice.iron_axe, Economy.EPrice.chainmail_helmet, Economy.EPrice.chainmail_chestplate, Economy.EPrice.chainmail_leggings, Economy.EPrice.chainmail_boots, Economy.EPrice.iron_helmet, Economy.EPrice.iron_chestplate, Economy.EPrice.iron_leggings, Economy.EPrice.iron_boots, Economy.EPrice.iron_sword }), 
    DWARF_WARRIOR(EnumTribe.DWARF, "warrior", new Economy.IItem[0], new Economy.IItem[0]), 
    DWARF_KING(EnumTribe.DWARF, "king", new Economy.IItem[] { Economy.EPrice.gold_ingot, Economy.EPrice.rose_red, Economy.EPrice.golden_apple, Economy.EPrice.golden_sword, Economy.EPrice.golden_helmet }, new Economy.IItem[] { Economy.EPrice.bottle_o_enchanting, Economy.EPrice.potion_haste, Economy.EPrice.potion_speed, Economy.EPrice.diamond }, true), 
    DWARF_HEALER(EnumTribe.DWARF, "healer", new Economy.IItem[] { Economy.EPrice.melon, Economy.EPrice.glass_bottle, Economy.EPrice.nether_wart }, new Economy.IItem[] { Economy.EPrice.potion_instant_health, Economy.EPrice.potion_health_boost }), 
    DWARF_MINER(EnumTribe.DWARF, "miner", new Economy.IItem[] { Economy.EPrice.iron_pickaxe, Economy.EPrice.iron_shovel, Economy.EPrice.torch }, new Economy.IItem[] { Economy.EPrice.coal, Economy.EPrice.redstone, Economy.EPrice.stone });
    
    public final String resourcePath;
    public final String villagerName;
    public final int profession;
    public final EnumTribe tribe;
    public final boolean isChief;
    private final List<Economy.IItem> buyList;
    private final List<Economy.IItem> sellList;
    
    EnumVillager(final EnumTribe tribe, final String name, final Economy.IItem[] buyList, final Economy.IItem[] sellList, final boolean isChief) {
        this.buyList = new ArrayList<Economy.IItem>();
        this.sellList = new ArrayList<Economy.IItem>();
        tribe.villagers.add(this);
        this.tribe = tribe;
        this.villagerName = name;
        this.profession = tribe.id + tribe.villagers.size();
        this.isChief = isChief;
        this.resourcePath = "textures/entities/villagers/" + tribe.path + name + ".png";
        for (final Economy.IItem item : buyList) {
            this.buyList.add(item);
        }
        for (final Economy.IItem item : sellList) {
            this.sellList.add(item);
        }
    }
    
    EnumVillager(final EnumTribe tribe, final String name, final Economy.IItem[] buyList, final Economy.IItem[] sellList) {
        this(tribe, name, buyList, sellList, false);
    }
    
    EnumVillager(final EnumTribe tribe, final String name) {
        this(tribe, name, new Economy.IItem[0], new Economy.IItem[0], false);
    }
    
    public static EnumVillager findEnum(final int profession) {
        for (final EnumVillager villager : values()) {
            if (profession == villager.profession) {
                return villager;
            }
        }
        return null;
    }
    
    public static void register() {
        for (final EnumVillager villager : values()) {
            VillagerRegistry.instance().registerVillageTradeHandler(villager.profession, (VillagerRegistry.IVillageTradeHandler)villager);
            Diversity.proxy.registerVillagerSkin(villager);
        }
    }
    
    @Override
    public void manipulateTradesForVillager(final EntityVillager villager, final MerchantRecipeList recipeList, final Random random) {
        if (villager instanceof EntityGlobalVillager) {
            final List<Economy.IItem> totalList = new ArrayList<Economy.IItem>();
            totalList.addAll(this.buyList);
            totalList.addAll(this.sellList);
            Collections.shuffle(totalList);
            for (final Economy.IItem item : totalList) {
                if (item instanceof Economy.IPrice) {
                    if (this.buyList.contains(item)) {
                        recipeList.addToListWithCheck(TradeTools.getBuyTrade((Economy.IPrice)item, ((EntityGlobalVillager)villager).tribe, random));
                    }
                    if (!this.sellList.contains(item)) {
                        continue;
                    }
                    recipeList.addToListWithCheck(TradeTools.getSellTrade((Economy.IPrice)item, ((EntityGlobalVillager)villager).tribe, random));
                }
            }
        }
    }
}
