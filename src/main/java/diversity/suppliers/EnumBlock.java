// 
// Decompiled by Procyon v0.5.36
// 

package diversity.suppliers;

import diversity.block.BlockFungus;
import diversity.block.BlockBlueVine;
import diversity.block.BlockPhosMushroom;
import diversity.block.BlockMushroomCap;
import net.minecraft.block.material.Material;
import diversity.block.BlockBlueMushroom;
import diversity.block.BlockFungal;
import diversity.block.BlockPoisonWater;
import diversity.block.BlockPhosWater;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

public enum EnumBlock
{
    phos_water(new BlockPhosWater().setBlockName("phos_water").setBlockTextureName("diversity:phos_water").setLightOpacity(3).setLightLevel(0.8f)), 
    poison_water(new BlockPoisonWater().setBlockName("poison_water").setBlockTextureName("diversity:poison_water").setLightOpacity(3)), 
    fungal(new BlockFungal().setHardness(0.6f).setStepSound(Block.soundTypeGrass).setBlockName("fungal").setBlockTextureName("diversity:fungal")), 
    blue_mushroom(new BlockBlueMushroom().setHardness(0.0f).setStepSound(Block.soundTypeGrass).setBlockName("blue_mushroom").setBlockTextureName("diversity:blue_mushroom")), 
    blue_mushroom_cap(new BlockMushroomCap(Material.wood).setStepSound(Block.soundTypeWood).setBlockName("blue_mushroom").setBlockTextureName("diversity:blue_mushroom")), 
    phos_mushroom(new BlockPhosMushroom().setHardness(0.0f).setStepSound(Block.soundTypeGrass).setLightLevel(0.6f).setBlockName("phos_mushroom").setBlockTextureName("diversity:phos_mushroom")), 
    phos_mushroom_cap(new BlockMushroomCap(Material.wood).setStepSound(Block.soundTypeWood).setBlockName("phos_mushroom").setBlockTextureName("diversity:phos_mushroom")), 
    blue_vine(new BlockBlueVine().setHardness(0.2f).setStepSound(Block.soundTypeGrass).setBlockName("blue_vine").setBlockTextureName("diversity:blue_vine")), 
    fungus(new BlockFungus().setStepSound(Block.soundTypeWood).setLightLevel(1.0f).setBlockName("fungus").setBlockTextureName("diversity:fungus"));
    
    public final Block block;
    
    EnumBlock(final Block block) {
        this.block = block;
    }
    
    public static void register() {
        for (final EnumBlock enumBlock : values()) {
            GameRegistry.registerBlock(enumBlock.block, enumBlock.name());
        }
    }
}
