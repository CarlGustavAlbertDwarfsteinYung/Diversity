// 
// Decompiled by Procyon v0.5.36
// 

package diversity.suppliers;

import net.minecraft.init.Items;
import net.minecraft.item.ItemBucket;
import diversity.item.ItemSpear;
import diversity.entity.EntityDart;
import net.minecraft.creativetab.CreativeTabs;
import diversity.item.ItemBlowgun;
import diversity.Diversity;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public enum EnumItem
{
    blowgun(new ItemBlowgun().setUnlocalizedName("blowgun").setCreativeTab(CreativeTabs.tabCombat).setTextureName("diversity:blowgun")), 
    dart(new Item().setUnlocalizedName("dart").setCreativeTab(CreativeTabs.tabCombat).setTextureName("diversity:dart"), (Class)EntityDart.class), 
    iron_spear(new ItemSpear(Item.ToolMaterial.IRON).setUnlocalizedName("iron_spear").setTextureName("diversity:iron_spear")), 
    wooden_spear(new ItemSpear(Item.ToolMaterial.WOOD).setUnlocalizedName("wooden_spear").setTextureName("diversity:wooden_spear")), 
    stone_spear(new ItemSpear(Item.ToolMaterial.STONE).setUnlocalizedName("stone_spear").setTextureName("diversity:stone_spear")), 
    diamond_spear(new ItemSpear(Item.ToolMaterial.EMERALD).setUnlocalizedName("diamond_spear").setTextureName("diversity:diamond_spear")), 
    golden_spear(new ItemSpear(Item.ToolMaterial.GOLD).setUnlocalizedName("golden_spear").setTextureName("diversity:golden_spear")), 
    phos_water_bucket(new ItemBucket(EnumBlock.phos_water.block).setUnlocalizedName("phos_water_bucket").setContainerItem(Items.bucket).setTextureName("diversity:phos_water_bucket")), 
    poison_water_bucket(new ItemBucket(EnumBlock.poison_water.block).setUnlocalizedName("poison_water_bucket").setContainerItem(Items.bucket).setTextureName("diversity:poison_water_bucket"));
    
    public Item item;
    public final Class entityClass;
    
    EnumItem(final Item item) {
        this(item, null);
    }
    
    EnumItem(final Item item, final Class entityClass) {
        this.item = item;
        this.entityClass = entityClass;
    }
    
    public static void register() {
        for (final EnumItem item : values()) {
            GameRegistry.registerItem(item.item, item.name());
            if (item.entityClass != null) {
                final int id = EntityRegistry.findGlobalUniqueEntityId();
                EntityRegistry.registerGlobalEntityID(item.entityClass, "diversity." + item.name(), id);
                EntityRegistry.registerModEntity(item.entityClass, "diversity." + item.name(), id, (Object)Diversity.instance, 64, 1, true);
            }
            Diversity.proxy.registerItemRenderer(item);
        }
    }
}
