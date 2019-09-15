// 
// Decompiled by Procyon v0.5.36
// 

package diversity;

import net.minecraft.entity.EntityList;
import diversity.configurations.ConfigVillager;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import diversity.suppliers.EnumEntity;
import diversity.suppliers.EnumVillager;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import diversity.suppliers.EnumCave;
import diversity.suppliers.EnumStructure;
import diversity.suppliers.EnumVillagePiece;
import diversity.suppliers.EnumVillageBasicPiece;
import diversity.suppliers.EnumVillage;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import diversity.utils.Economy;
import diversity.suppliers.EnumTribe;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;
import diversity.suppliers.EnumItem;
import diversity.suppliers.EnumBlock;
import diversity.suppliers.EnumFluid;
import diversity.configurations.AConfigTool;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.SidedProxy;
import diversity.proxy.ServerProxy;
import java.util.logging.Logger;
import cpw.mods.fml.common.Mod;

@Mod(modid = "diversity", name = "Diversity", version = "ALPHA 1.6.1")
public class Diversity
{
    public static final String MODID = "diversity";
    public static final String NAME = "Diversity";
    public static final String VERSION = "ALPHA 1.6.1";
    @Mod.Instance("diversity")
    public static Diversity instance;
    public static Logger Divlogger;
    @SidedProxy(clientSide = "diversity.proxy.ClientProxy", serverSide = "diversity.proxy.ServerProxy")
    public static ServerProxy proxy;
    
    @Mod.EventHandler
    public void PreInit(final FMLPreInitializationEvent event) {
        AConfigTool.values();
        AConfigTool.loadAllConfig(false);
        AConfigTool.saveAllConfig(false);
        Diversity.Divlogger = Logger.getLogger("Diversity");
        EnumFluid.register();
        EnumBlock.register();
        EnumItem.register();
        GameRegistry.addShapelessRecipe(new ItemStack(Items.mushroom_stew), new Object[] { Item.getItemFromBlock((Block)Blocks.red_mushroom), Item.getItemFromBlock(EnumBlock.blue_mushroom.block), Items.bowl });
        GameRegistry.addShapelessRecipe(new ItemStack(Items.mushroom_stew), new Object[] { Item.getItemFromBlock((Block)Blocks.brown_mushroom), Item.getItemFromBlock(EnumBlock.blue_mushroom.block), Items.bowl });
        EnumTribe.register();
        Economy.GPrice.values();
        Economy.EPrice.values();
        Economy.savePrice();
        Economy.loadPrice();
        Diversity.proxy.registerRenderers();
    }
    
    @Mod.EventHandler
    public void init(final FMLInitializationEvent event) {
        EnumVillage.values();
        EnumVillageBasicPiece.register();
        EnumVillagePiece.register();
        EnumStructure.values();
        EnumCave.values();
        EnumStructure.register();
        EnumCave.register();
        MapGenStructureIO.registerStructure((Class)MapGenVillageDiversity.Start.class, "diversity.Village");
        MapGenStructureIO.registerStructure((Class)MapGenStructureDiversity.Start.class, "diversity.Structure");
        MapGenStructureIO.registerStructure((Class)MapGenCaveDiversity.Start.class, "diversity.CaveStructure");
        EnumVillager.register();
        EnumEntity.register();
        Diversity.proxy.registerHandler();
    }
    
    @Mod.EventHandler
    public void PostInit(final FMLPostInitializationEvent event) {
        EnumEntity.load();
        if (ConfigVillager.REMOVE_VANILLA_SPAWN_EGG.equals("true")) {
            EntityList.entityEggs.remove(120);
        }
    }
}
