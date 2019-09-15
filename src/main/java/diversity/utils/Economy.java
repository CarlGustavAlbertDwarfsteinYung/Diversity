//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package diversity.utils;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.google.common.collect.Table.Cell;
import cpw.mods.fml.common.Loader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class Economy {
    private static final String configFile = Loader.instance().getConfigDir() + "/diversity-economy.cfg";

    public Economy() {
    }

    public static void savePrice() {
        Properties properties = new Properties();
        Iterator var1 = Economy.IPrice.priceMap.cellSet().iterator();

        while(var1.hasNext()) {
            Cell<Item, Integer, Economy.IPrice> cell = (Cell)var1.next();
            properties.setProperty(((Economy.IPrice)cell.getValue()).name(), String.valueOf(((Economy.IPrice)cell.getValue()).getPrice()));
        }

        try {
            File file = new File(configFile);
            properties.store(new FileOutputStream(file), (String)null);
        } catch (Exception var3) {
            var3.printStackTrace();
        }

    }

    public static void loadPrice() {
        Properties properties = new Properties();

        try {
            FileInputStream inputStream = new FileInputStream(configFile);
            properties.load(inputStream);
            inputStream.close();
        } catch (IOException var4) {
            var4.printStackTrace();
            return;
        }

        Iterator var5 = Economy.IPrice.priceMap.cellSet().iterator();

        while(var5.hasNext()) {
            Cell<Item, Integer, Economy.IPrice> cell = (Cell)var5.next();
            String price = properties.getProperty(((Economy.IPrice)cell.getValue()).name());
            if (price != null && !price.isEmpty()) {
                ((Economy.IPrice)cell.getValue()).setPrice(Float.valueOf(price));
                properties.remove(((Economy.IPrice)cell.getValue()).name());
            }
        }

    }

    public static float getPrice(Item item, int metaData) {
        return Float.valueOf(((Economy.IPrice)Economy.IPrice.priceMap.get(item, metaData)).getPrice());
    }

    public static float getPrice(Item item) {
        return getPrice(item, 0);
    }

    public static Item getItem(Economy.IPrice itemPrice) {
        Iterator var1 = Economy.IPrice.priceMap.cellSet().iterator();

        Cell cell;
        do {
            if (!var1.hasNext()) {
                return null;
            }

            cell = (Cell)var1.next();
        } while(!((Economy.IPrice)cell.getValue()).name().equals(itemPrice.name()));

        return (Item)cell.getRowKey();
    }

    public static int getMetadata(Economy.IPrice itemPrice) {
        Iterator var1 = Economy.IPrice.priceMap.cellSet().iterator();

        Cell cell;
        do {
            if (!var1.hasNext()) {
                return 0;
            }

            cell = (Cell)var1.next();
        } while(!((Economy.IPrice)cell.getValue()).name().equals(itemPrice.name()));

        return (Integer)cell.getColumnKey();
    }

    public enum EPrice implements Economy.IPrice, Economy.IItem {
        stone(Blocks.stone, 0, 3.0F),
        grass_block(Blocks.grass, 0, 3.0F),
        dirt(Blocks.dirt, 0, 1.0F),
        coarse_dirt(Blocks.dirt, 1, 4.0F),
        potzol(Blocks.dirt, 2, 4.0F),
        cobblestone(Blocks.cobblestone, 0, 1.0F),
        oak_planks(Blocks.planks, 0, 1.0F),
        spruce_planks(Blocks.planks, 1, 1.0F),
        birch_planks(Blocks.planks, 2, 1.0F),
        jungle_planks(Blocks.planks, 3, 1.0F),
        acacia_planks(Blocks.planks, 4, 1.0F),
        dark_oak_planks(Blocks.planks, 5, 1.0F),
        oak_sapling(Blocks.sapling, 0, 3.0F),
        spruce_sapling(Blocks.sapling, 1, 3.0F),
        birch_sapling(Blocks.sapling, 2, 3.0F),
        jungle_sapling(Blocks.sapling, 3, 3.0F),
        acacia_sapling(Blocks.sapling, 4, 3.0F),
        dark_oak_sapling(Blocks.sapling, 5, 3.0F),
        sand(Blocks.sand, 0, 1.0F),
        red_sand(Blocks.sand, 1, 3.0F),
        gravel(Blocks.gravel, 0, 3.0F),
        oak_wood(Blocks.log, 0, 2.0F),
        spruce_wood(Blocks.log, 1, 2.0F),
        birch_wood(Blocks.log, 2, 2.0F),
        jungle_wood(Blocks.log, 3, 2.0F),
        oak_leaves(Blocks.leaves, 0, 3.0F),
        spruce_leaves(Blocks.leaves, 1, 3.0F),
        birch_leaves(Blocks.leaves, 2, 3.0F),
        jungle_leaves(Blocks.leaves, 3, 3.0F),
        sponge(Blocks.sponge, 0, 60.0F),
        glass(Blocks.glass, 0, 3.0F),
        lapis_lazuli_block(Blocks.lapis_block, 0, 24.0F),
        dispenser(Blocks.dispenser, 0, 12.0F),
        sandstone(Blocks.sandstone, 0, 4.0F),
        chiseled_sandstone(Blocks.sandstone, 1, 30.0F),
        smooth_sandstone(Blocks.sandstone, 2, 4.0F),
        note_block(Blocks.noteblock, 0, 8.0F),
        powered_rail(Blocks.golden_rail, 0, 50.0F),
        detector_rail(Blocks.detector_rail, 0, 28.0F),
        sticky_piston(Blocks.sticky_piston, 0, 14.0F),
        cobweb(Blocks.web, 0, 20.0F),
        dead_shrub(Blocks.tallgrass, 0, 4.0F),
        grass(Blocks.tallgrass, 1, 4.0F),
        fern(Blocks.tallgrass, 2, 4.0F),
        piston(Blocks.piston, 0, 12.0F),
        white_wool(Blocks.wool, 0, 6.0F),
        orange_wool(Blocks.wool, 1, 8.0F),
        magenta_wool(Blocks.wool, 2, 8.0F),
        light_blue_wool(Blocks.wool, 3, 8.0F),
        yellow_wool(Blocks.wool, 4, 8.0F),
        lime_wool(Blocks.wool, 5, 8.0F),
        pink_wool(Blocks.wool, 6, 8.0F),
        gray_wool(Blocks.wool, 7, 7.0F),
        light_gray_wool(Blocks.wool, 8, 7.0F),
        cyan_wool(Blocks.wool, 9, 8.0F),
        purple_wool(Blocks.wool, 10, 8.0F),
        blue_wool(Blocks.wool, 11, 8.0F),
        brown_wool(Blocks.wool, 12, 8.0F),
        green_wool(Blocks.wool, 13, 8.0F),
        red_wool(Blocks.wool, 14, 8.0F),
        black_wool(Blocks.wool, 15, 7.0F),
        dandelion(Blocks.yellow_flower, 0, 4.0F),
        poppy(Blocks.red_flower, 0, 4.0F),
        blue_orchid(Blocks.red_flower, 1, 4.0F),
        allium(Blocks.red_flower, 2, 4.0F),
        azure_bluet(Blocks.red_flower, 3, 4.0F),
        red_tulip(Blocks.red_flower, 4, 4.0F),
        orange_tulip(Blocks.red_flower, 5, 4.0F),
        white_tulip(Blocks.red_flower, 6, 4.0F),
        pink_tulip(Blocks.red_flower, 7, 4.0F),
        oxeye_daisy(Blocks.red_flower, 8, 4.0F),
        brown_mushroom(Blocks.brown_mushroom, 0, 4.0F),
        red_mushroom(Blocks.red_mushroom, 0, 4.0F),
        bricks(Blocks.brick_block, 0, 18.0F),
        tnt(Blocks.tnt, 0, 24.0F),
        bookshelf(Blocks.bookshelf, 0, 38.0F),
        mossy_cobblestone(Blocks.mossy_cobblestone, 0, 12.0F),
        obsidian(Blocks.obsidian, 0, 20.0F),
        torch(Blocks.torch, 0, 1.0F),
        chest(Blocks.chest, 0, 8.0F),
        ladder(Blocks.ladder, 0, 1.0F),
        rail(Blocks.rail, 0, 2.0F),
        lever(Blocks.lever, 0, 2.0F),
        snow(Blocks.snow, 0, 4.0F),
        ice(Blocks.ice, 0, 8.0F),
        cactus(Blocks.cactus, 0, 6.0F),
        jukebox(Blocks.jukebox, 0, 60.0F),
        pumpkin(Blocks.pumpkin, 0, 10.0F),
        netherrack(Blocks.netherrack, 0, 3.0F),
        soul_sand(Blocks.soul_sand, 0, 10.0F),
        glowstone(Blocks.glowstone, 0, 30.0F),
        jack_o_lantern(Blocks.lit_pumpkin, 0, 12.0F),
        white_glass(Blocks.stained_glass, 0, 5.0F),
        orange_glass(Blocks.stained_glass, 1, 7.0F),
        magenta_glass(Blocks.stained_glass, 2, 7.0F),
        light_blue_glass(Blocks.stained_glass, 3, 7.0F),
        yellow_glass(Blocks.stained_glass, 4, 6.0F),
        lime_glass(Blocks.stained_glass, 5, 7.0F),
        pink_glass(Blocks.stained_glass, 6, 7.0F),
        gray_glass(Blocks.stained_glass, 7, 7.0F),
        light_gray_glass(Blocks.stained_glass, 8, 7.0F),
        cyan_glass(Blocks.stained_glass, 9, 7.0F),
        purple_glass(Blocks.stained_glass, 10, 7.0F),
        blue_glass(Blocks.stained_glass, 11, 7.0F),
        brown_glass(Blocks.stained_glass, 12, 7.0F),
        green_glass(Blocks.stained_glass, 13, 7.0F),
        red_glass(Blocks.stained_glass, 14, 6.0F),
        black_glass(Blocks.stained_glass, 15, 5.0F),
        stonebrick(Blocks.stonebrick, 0, 3.0F),
        mossy_stonebrick(Blocks.stonebrick, 1, 8.0F),
        cracked_stonebrick(Blocks.stonebrick, 2, 8.0F),
        chiseled_stonebrick(Blocks.stonebrick, 3, 8.0F),
        melon_block(Blocks.melon_block, 0, 10.0F),
        vines(Blocks.vine, 0, 8.0F),
        mycelium(Blocks.mycelium, 0, 24.0F),
        lily_pad(Blocks.waterlily, 0, 10.0F),
        nether_brick_block(Blocks.nether_brick, 0, 20.0F),
        cocoa(Blocks.cocoa, 0, 14.0F),
        quartz_block(Blocks.quartz_block, 0, 32.0F),
        white_clay(Blocks.stained_hardened_clay, 0, 6.0F),
        orange_clay(Blocks.stained_hardened_clay, 1, 6.0F),
        magenta_clay(Blocks.stained_hardened_clay, 2, 6.0F),
        light_blue_clay(Blocks.stained_hardened_clay, 3, 6.0F),
        yellow_clay(Blocks.stained_hardened_clay, 4, 6.0F),
        lime_clay(Blocks.stained_hardened_clay, 5, 6.0F),
        pink_clay(Blocks.stained_hardened_clay, 6, 6.0F),
        gray_clau(Blocks.stained_hardened_clay, 7, 6.0F),
        light_gray_clay(Blocks.stained_hardened_clay, 8, 6.0F),
        cyan_clay(Blocks.stained_hardened_clay, 9, 6.0F),
        purple_clay(Blocks.stained_hardened_clay, 10, 6.0F),
        blue_clay(Blocks.stained_hardened_clay, 11, 6.0F),
        brown_clay(Blocks.stained_hardened_clay, 12, 6.0F),
        green_clay(Blocks.stained_hardened_clay, 13, 6.0F),
        red_clay(Blocks.stained_hardened_clay, 14, 6.0F),
        black_clay(Blocks.stained_hardened_clay, 15, 6.0F),
        accacia_leaves(Blocks.leaves2, 0, 3.0F),
        dark_oak_leaves(Blocks.leaves2, 1, 3.0F),
        accacia_wood(Blocks.log2, 0, 2.0F),
        dark_oak_wood(Blocks.log2, 0, 2.0F),
        hay_bale(Blocks.hay_block, 0, 16.0F),
        hardened_clay(Blocks.hardened_clay, 0, 5.0F),
        packed_ice(Blocks.packed_ice, 0, 24.0F),
        sunflower(Blocks.double_plant, 0, 6.0F),
        lilac(Blocks.double_plant, 1, 6.0F),
        double_tallgrass(Blocks.double_plant, 2, 6.0F),
        large_fern(Blocks.double_plant, 3, 6.0F),
        rose_bush(Blocks.double_plant, 4, 6.0F),
        peony(Blocks.double_plant, 5, 6.0F),
        iron_shovel(Items.iron_shovel, 0, 5.0F),
        iron_pickaxe(Items.iron_pickaxe, 0, 10.0F),
        iron_axe(Items.iron_axe, 0, 10.0F),
        flint_and_steel(Items.flint_and_steel, 0, 8.0F),
        apple(Items.apple, 0, 6.0F),
        bow(Items.bow, 0, 6.0F),
        arrow(Items.arrow, 0, 1.0F),
        coal(Items.coal, 0, 3.0F),
        charcoal(Items.coal, 1, 3.0F),
        diamond(Items.diamond, 0, 60.0F),
        iron_ingot(Items.iron_ingot, 0, 4.0F),
        gold_ingot(Items.gold_ingot, 0, 8.0F),
        iron_sword(Items.iron_sword, 0, 9.0F),
        wooden_sword(Items.wooden_sword, 0, 1.0F),
        wooden_shovel(Items.wooden_shovel, 0, 1.0F),
        wooden_pickaxe(Items.wooden_pickaxe, 0, 2.0F),
        wooden_axe(Items.wooden_axe, 0, 2.0F),
        stone_sword(Items.stone_sword, 0, 3.0F),
        stone_shovel(Items.stone_shovel, 0, 2.0F),
        stone_pickaxe(Items.stone_pickaxe, 0, 4.0F),
        stone_axe(Items.stone_axe, 0, 4.0F),
        diamond_sword(Items.diamond_sword, 0, 120.0F),
        diamond_shovel(Items.diamond_shovel, 0, 60.0F),
        diamond_pickaxe(Items.diamond_pickaxe, 0, 180.0F),
        diamond_axe(Items.diamond_axe, 0, 180.0F),
        stick(Items.stick, 0, 0.1F),
        bowl(Items.bowl, 0, 4.0F),
        mushroom_stew(Items.mushroom_stew, 0, 12.0F),
        golden_sword(Items.golden_sword, 0, 16.0F),
        golden_shovel(Items.golden_shovel, 0, 8.0F),
        golden_pickaxe(Items.golden_pickaxe, 0, 24.0F),
        golden_axe(Items.golden_axe, 0, 24.0F),
        string(Items.string, 0, 0.9F),
        feather(Items.feather, 0, 1.0F),
        gunpowder(Items.gunpowder, 0, 4.0F),
        wooden_hoe(Items.wooden_hoe, 0, 1.0F),
        stone_hoe(Items.stone_hoe, 0, 3.0F),
        iron_hoe(Items.iron_hoe, 0, 9.0F),
        diamond_hoe(Items.diamond_hoe, 0, 120.0F),
        golden_hoe(Items.golden_hoe, 0, 16.0F),
        wheat_seeds(Items.wheat_seeds, 0, 0.5F),
        wheat(Items.wheat, 0, 2.0F),
        bread(Items.bread, 0, 6.0F),
        leather_helmet(Items.leather_helmet, 0, 15.0F),
        leather_tunic(Items.leather_chestplate, 0, 24.0F),
        leather_pants(Items.leather_leggings, 0, 21.0F),
        leather_boots(Items.leather_boots, 0, 12.0F),
        chainmail_helmet(Items.chainmail_helmet, 0, 30.0F),
        chainmail_chestplate(Items.chainmail_chestplate, 0, 48.0F),
        chainmail_leggings(Items.chainmail_leggings, 0, 42.0F),
        chainmail_boots(Items.chainmail_boots, 0, 24.0F),
        iron_helmet(Items.iron_helmet, 0, 20.0F),
        iron_chestplate(Items.iron_chestplate, 0, 32.0F),
        iron_leggings(Items.iron_leggings, 0, 28.0F),
        iron_boots(Items.iron_boots, 0, 16.0F),
        diamond_helmet(Items.diamond_helmet, 0, 300.0F),
        diamond_chestplate(Items.diamond_chestplate, 0, 480.0F),
        diamond_leggings(Items.diamond_leggings, 0, 420.0F),
        diamond_boots(Items.diamond_boots, 0, 240.0F),
        golden_helmet(Items.golden_helmet, 0, 40.0F),
        golden_chesplate(Items.golden_chestplate, 0, 64.0F),
        golden_leggings(Items.golden_leggings, 0, 56.0F),
        golden_boots(Items.golden_boots, 0, 32.0F),
        flint(Items.flint, 0, 4.0F),
        raw_porkchop(Items.porkchop, 0, 3.0F),
        cooked_porkchop(Items.cooked_porkchop, 0, 5.0F),
        painting(Items.painting, 0, 8.0F),
        golden_apple(Items.golden_apple, 0, 70.0F),
        enchanted_golden_apple(Items.golden_apple, 1, 582.0F),
        sign(Items.sign, 0, 2.0F),
        bucket(Items.bucket, 0, 12.0F),
        minecart(Items.minecart, 0, 20.0F),
        saddle(Items.saddle, 0, 32.0F),
        redstone(Items.redstone, 0, 4.0F),
        snowball(Items.snowball, 0, 0.1F),
        boat(Items.boat, 0, 10.0F),
        leather(Items.leather, 0, 3.0F),
        brick(Items.brick, 0, 4.5F),
        clay(Items.clay_ball, 0, 3.0F),
        sugar_canes(Items.reeds, 0, 3.0F),
        paper(Items.paper, 0, 3.0F),
        book(Items.book, 0, 12.0F),
        slimeball(Items.slime_ball, 0, 5.0F),
        egg(Items.egg, 0, 3.0F),
        compass(Items.compass, 0, 20.0F),
        fishing_rod(Items.fishing_rod, 0, 1.0F),
        clock(Items.clock, 0, 36.0F),
        glowstone_dust(Items.glowstone_dust, 0, 7.5F),
        raw_fish(Items.fish, 0, 5.0F),
        raw_salmon(Items.fish, 1, 5.0F),
        clownfish(Items.fish, 2, 5.0F),
        pufferfish(Items.fish, 3, 5.0F),
        cooked_fish(Items.cooked_fished, 0, 7.0F),
        cooked_salmon(Items.cooked_fished, 1, 7.0F),
        ink(Items.dye, 0, 3.0F),
        rose_red(Items.dye, 1, 4.0F),
        cactus_green(Items.dye, 2, 4.0F),
        coco_beans(Items.dye, 3, 4.0F),
        lapis_lazuli(Items.dye, 4, 4.0F),
        purple_dye(Items.dye, 5, 4.0F),
        cyan_dye(Items.dye, 6, 4.0F),
        light_gray_dye(Items.dye, 7, 4.0F),
        gray_dye(Items.dye, 8, 4.0F),
        pink_dye(Items.dye, 9, 4.0F),
        lime_dye(Items.dye, 10, 4.0F),
        dandelion_yellow(Items.dye, 11, 4.0F),
        light_blue_dye(Items.dye, 12, 4.0F),
        magenta_dye(Items.dye, 13, 4.0F),
        orange_dye(Items.dye, 14, 4.0F),
        bone_meal(Items.dye, 15, 1.0F),
        bone(Items.bone, 0, 3.0F),
        sugar(Items.sugar, 0, 3.0F),
        cake(Items.cake, 0, 15.0F),
        cookie(Items.cookie, 0, 1.0F),
        map(Items.filled_map, 0, 60.0F),
        shears(Items.shears, 0, 8.0F),
        melon(Items.melon, 0, 1.5F),
        pumpkin_seeds(Items.pumpkin_seeds, 0, 2.0F),
        melon_seeds(Items.melon_seeds, 0, 2.0F),
        raw_beef(Items.beef, 0, 4.0F),
        steak(Items.cooked_beef, 0, 6.0F),
        raw_chicken(Items.chicken, 0, 4.0F),
        cooked_chicken(Items.cooked_chicken, 0, 6.0F),
        rotten_flesh(Items.rotten_flesh, 0, 0.5F),
        ender_pearl(Items.ender_pearl, 0, 80.0F),
        blaze_rod(Items.blaze_rod, 0, 30.0F),
        ghast_tear(Items.ghast_tear, 0, 80.0F),
        nether_wart(Items.nether_wart, 0, 32.0F),
        potion_speed(Items.potionitem, 1, 30.0F),
        potion_slowness(Items.potionitem, 2, 30.0F),
        potion_haste(Items.potionitem, 3, 30.0F),
        potion_mining_fatigue(Items.potionitem, 4, 30.0F),
        potion_strength(Items.potionitem, 5, 30.0F),
        potion_instant_health(Items.potionitem, 6, 30.0F),
        potion_instant_damage(Items.potionitem, 7, 30.0F),
        potion_jump_boost(Items.potionitem, 8, 30.0F),
        potion_nausea(Items.potionitem, 9, 30.0F),
        potion_renegeration(Items.potionitem, 10, 30.0F),
        potion_resistance(Items.potionitem, 11, 30.0F),
        potion_fire_resistance(Items.potionitem, 12, 30.0F),
        potion_water_breathing(Items.potionitem, 13, 30.0F),
        potion_invisibility(Items.potionitem, 14, 30.0F),
        potion_blindness(Items.potionitem, 15, 30.0F),
        potion_night_vision(Items.potionitem, 16, 30.0F),
        potion_hunger(Items.potionitem, 17, 30.0F),
        potion_weakness(Items.potionitem, 18, 30.0F),
        potion_poison(Items.potionitem, 19, 30.0F),
        potion_wither(Items.potionitem, 20, 30.0F),
        potion_health_boost(Items.potionitem, 21, 30.0F),
        potion_absorption(Items.potionitem, 22, 30.0F),
        potion_saturation(Items.potionitem, 23, 30.0F),
        glass_bottle(Items.glass_bottle, 0, 9.0F),
        spider_eye(Items.spider_eye, 0, 3.0F),
        fermented_spider_eye(Items.fermented_spider_eye, 0, 11.0F),
        blaze_powder(Items.blaze_powder, 0, 30.0F),
        magma_cream(Items.magma_cream, 0, 20.0F),
        glistering_melon(Items.speckled_melon, 0, 11.0F),
        bottle_o_enchanting(Items.experience_bottle, 0, 20.0F),
        fire_charge(Items.fire_charge, 0, 13.0F),
        book_and_quill(Items.writable_book, 0, 15.0F),
        written_book(Items.written_book, 0, 25.0F),
        emerald(Items.emerald, 0, 72.0F),
        item_frame(Items.item_frame, 0, 5.0F),
        flower_pot(Items.flower_pot, 0, 13.0F),
        carrot(Items.carrot, 0, 3.0F),
        potato(Items.potato, 0, 3.0F),
        baked_potato(Items.baked_potato, 0, 5.0F),
        poisonous_potato(Items.poisonous_potato, 0, 3.0F),
        empty_map(Items.map, 0, 44.0F),
        golden_carrot(Items.golden_carrot, 0, 11.0F),
        carrot_on_a_stick(Items.carrot_on_a_stick, 0, 4.0F),
        pumpkin_pie(Items.pumpkin_pie, 0, 8.0F),
        enchanted_book_protection(Items.enchanted_book, 0, 80.0F),
        enchanted_book_fire_protection(Items.enchanted_book, 1, 80.0F),
        enchanted_book_feather_falling(Items.enchanted_book, 2, 80.0F),
        enchanted_book_blast_protection(Items.enchanted_book, 3, 80.0F),
        enchanted_book_projectile_protection(Items.enchanted_book, 4, 80.0F),
        enchanted_book_respiration(Items.enchanted_book, 5, 80.0F),
        enchanted_book_aqua_affinity(Items.enchanted_book, 6, 80.0F),
        enchanted_book_thorns(Items.enchanted_book, 7, 80.0F),
        enchanted_book_depth_strider(Items.enchanted_book, 8, 80.0F),
        enchanted_book_sharpness(Items.enchanted_book, 16, 80.0F),
        enchanted_book_smite(Items.enchanted_book, 17, 80.0F),
        enchanted_book_bane_of_arthropods(Items.enchanted_book, 18, 80.0F),
        enchanted_book_knockback(Items.enchanted_book, 19, 80.0F),
        enchanted_book_fire_aspect(Items.enchanted_book, 20, 80.0F),
        enchanted_book_looting(Items.enchanted_book, 21, 80.0F),
        enchanted_book_efficiency(Items.enchanted_book, 32, 80.0F),
        enchanted_book_silk_touch(Items.enchanted_book, 33, 80.0F),
        enchanted_book_unbreaking(Items.enchanted_book, 34, 80.0F),
        enchanted_book_fortune(Items.enchanted_book, 35, 80.0F),
        enchanted_book_power(Items.enchanted_book, 48, 80.0F),
        enchanted_book_punch(Items.enchanted_book, 49, 80.0F),
        enchanted_book_flame(Items.enchanted_book, 50, 80.0F),
        enchanted_book_infinity(Items.enchanted_book, 51, 80.0F),
        enchanted_book_luck_of_the_sea(Items.enchanted_book, 61, 80.0F),
        enchanted_book_lure(Items.enchanted_book, 62, 80.0F),
        nether_brick(Items.netherbrick, 0, 5.0F),
        quartz(Items.quartz, 0, 8.0F),
        iron_horse_armor(Items.iron_horse_armor, 0, 80.0F),
        golden_horse_armor(Items.golden_horse_armor, 0, 160.0F),
        diamond_horse_armor(Items.diamond_horse_armor, 0, 1200.0F),
        lead(Items.lead, 0, 6.0F);

        private float price;

        EPrice(Block block, int metadataId, float price) {
            this(Item.getItemFromBlock(block), metadataId, price);
        }

        EPrice(Item item, int metadataId, float price) {
            this.price = price;
            priceMap.put(item, metadataId, this);
        }

        @Override
        public float getPrice() {
            return this.price;
        }

        @Override
        public void setPrice(float price) {
            this.price = price;
        }
    }

    public enum GPrice implements Economy.IItem {
        wool(Blocks.wool),
        dye(Items.dye),
        potionitem(Items.potionitem),
        echantmentbook(Items.enchanted_book);

        Item item;

        GPrice(Block block) {
            this(Item.getItemFromBlock(block));
        }

        GPrice(Item item) {
            this.item = item;
        }

        public Economy.IItem[] getIPrices() {
            Map<Integer, Economy.IPrice> map = Economy.IPrice.priceMap.row(this.item);
            return (Economy.IItem[])map.values().toArray(new Economy.IItem[0]);
        }
    }

    public interface IItem {
    }

    public interface IPrice {
        Table<Item, Integer, Economy.IPrice> priceMap = HashBasedTable.create();

        String name();

        float getPrice();

        void setPrice(float var1);
    }
}
