// 
// Decompiled by Procyon v0.5.36
// 

package diversity.utils;

import net.minecraft.item.ItemStack;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.init.Items;
import net.minecraft.util.MathHelper;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.ItemEnchantedBook;
import net.minecraft.village.MerchantRecipe;
import java.util.Random;
import diversity.suppliers.EnumTribe;

public class TradeTools
{
    public static MerchantRecipe getBuyTrade(final Economy.IPrice enumPrice, final EnumTribe tribe, final Random random) {
        return getTrade(enumPrice, tribe, random, true);
    }
    
    public static MerchantRecipe getSellTrade(final Economy.IPrice enumPrice, final EnumTribe tribe, final Random random) {
        return getTrade(enumPrice, tribe, random, false);
    }
    
    private static MerchantRecipe getTrade(final Economy.IPrice itemPrice, final EnumTribe tribe, final Random random, final boolean isBuyTrade) {
        float price = itemPrice.getPrice();
        ItemStack buyStack = null;
        ItemStack buyStack2 = null;
        ItemStack sellStack = null;
        int m = 1;
        if (Economy.getItem(itemPrice) instanceof ItemEnchantedBook) {
            final Enchantment enchantment = Enchantment.enchantmentsList[Economy.getMetadata(itemPrice)];
            final int level = MathHelper.getRandomIntegerInRange(random, enchantment.getMinLevel(), enchantment.getMaxLevel());
            if (isBuyTrade) {
                buyStack = Items.enchanted_book.getEnchantedItemStack(new EnchantmentData(enchantment, level));
            }
            else {
                sellStack = Items.enchanted_book.getEnchantedItemStack(new EnchantmentData(enchantment, level));
            }
            price = (float)(int)(itemPrice.getPrice() * level + random.nextInt(level) * itemPrice.getPrice() / 10.0f);
        }
        else {
            while (price != (int)price && m < 10) {
                ++m;
                price = itemPrice.getPrice() * m;
            }
        }
        int nugget_price = 0;
        int ingot_price = 0;
        if (price > 64.0f) {
            if (price % 8.0f == 0.0f) {
                ingot_price = (int)price / 8;
            }
            else {
                nugget_price = (int)price % 8;
                ingot_price = (int)(price - nugget_price) / 8;
            }
        }
        else {
            nugget_price = (int)price;
        }
        if (isBuyTrade) {
            if (buyStack == null) {
                buyStack = new ItemStack(Economy.getItem(itemPrice), m, Economy.getMetadata(itemPrice));
            }
            if (ingot_price == 0) {
                sellStack = new ItemStack(Items.gold_nugget, nugget_price);
            }
            else {
                sellStack = new ItemStack(Items.gold_ingot, ingot_price);
            }
        }
        else {
            if (ingot_price == 0) {
                buyStack = new ItemStack(Items.gold_nugget, nugget_price);
            }
            else if (nugget_price == 0) {
                buyStack = new ItemStack(Items.gold_ingot, ingot_price);
            }
            else {
                buyStack = new ItemStack(Items.gold_ingot, ingot_price);
                buyStack2 = new ItemStack(Items.gold_nugget, nugget_price);
            }
            if (sellStack == null) {
                sellStack = new ItemStack(Economy.getItem(itemPrice), m, Economy.getMetadata(itemPrice));
            }
        }
        if (buyStack2 == null) {
            return new MerchantRecipe(buyStack, sellStack);
        }
        return new MerchantRecipe(buyStack, buyStack2, sellStack);
    }
}
