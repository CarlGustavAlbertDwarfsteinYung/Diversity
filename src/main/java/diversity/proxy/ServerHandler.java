//
// Decompiled by Procyon v0.5.36
//

package diversity.proxy;

import net.minecraft.world.gen.MapGenBase;
import diversity.suppliers.EnumItem;
import java.util.HashMap;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import java.util.Iterator;
import java.util.Collections;
import java.util.ArrayList;
import net.minecraft.block.material.Material;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraft.entity.monster.EntitySpider;
import cpw.mods.fml.common.eventhandler.Event;
import diversity.entity.EntityWorshipper;
import net.minecraft.entity.monster.EntityWitch;
import diversity.suppliers.EnumBlock;
import net.minecraft.block.BlockFalling;
import net.minecraft.init.Blocks;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import diversity.suppliers.EnumVillage;
import diversity.suppliers.EnumCave;
import diversity.suppliers.EnumStructure;
import net.minecraft.entity.EntityList;
import diversity.configurations.ConfigVillager;
import diversity.configurations.AConfigTool;
import net.minecraftforge.event.world.WorldEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.terraingen.InitMapGenEvent;
import diversity.world.WorldGenFungus;
import diversity.world.WorldGenBlueVine;
import diversity.world.WorldGenPhosMushroom;
import diversity.world.WorldGenBlueMushroom;
import net.minecraft.item.Item;
import net.minecraft.block.Block;
import java.util.Map;
import java.util.List;
import net.minecraft.world.gen.feature.WorldGenerator;
import diversity.MapGenCaveDiversity;
import diversity.MapGenStructureDiversity;
import diversity.MapGenVillageDiversity;

public class ServerHandler
{
    public static final MapGenVillageDiversity mapGenVillageDiversity;
    public static final MapGenStructureDiversity mapGenStructureDiversity;
    public static final MapGenCaveDiversity mapGenCaveStructureDiversity;
    private final WorldGenerator blueMushroom;
    private final WorldGenerator phosMushroom;
    private final WorldGenerator vineMushroom;
    private final WorldGenerator fungusGen;
    public static List<Integer[]> listMushroomChunk;
    private static final Map<Block, Item> buckets;

    public ServerHandler() {
        this.blueMushroom = new WorldGenBlueMushroom();
        this.phosMushroom = new WorldGenPhosMushroom();
        this.vineMushroom = new WorldGenBlueVine();
        this.fungusGen = new WorldGenFungus(1, 1);
    }

    @SubscribeEvent
    public void OnInitMapGen(final InitMapGenEvent event) {
        if (InitMapGenEvent.EventType.VILLAGE == event.type) {
            event.newGen = (MapGenBase)ServerHandler.mapGenVillageDiversity;
        }
        else if (InitMapGenEvent.EventType.SCATTERED_FEATURE == event.type) {
            event.newGen = (MapGenBase)ServerHandler.mapGenStructureDiversity;
        }
    }

    @SubscribeEvent
    public void OnWorldUnload(final WorldEvent.Unload event) {
        AConfigTool.loadAllConfig(false);
        AConfigTool.saveAllConfig(false);
        if (ConfigVillager.REMOVE_VANILLA_SPAWN_EGG.equals("true")) {
            if (EntityList.entityEggs.containsKey(120)) {
                EntityList.entityEggs.remove(120);
            }
        }
        else if (!EntityList.entityEggs.containsKey(120)) {
            EntityList.entityEggs.put(120, new EntityList.EntityEggInfo(120, 5651507, 12422002));
        }
    }

    @SubscribeEvent
    public void OnWorldLoad(final WorldEvent.Load event) {
        AConfigTool.loadAllConfig(true);
        AConfigTool.saveAllConfig(true);
        EnumStructure.load();
        EnumCave.load();
        EnumVillage.load();
        if (ConfigVillager.REMOVE_VANILLA_SPAWN_EGG.equals("true")) {
            if (EntityList.entityEggs.containsKey(120)) {
                EntityList.entityEggs.remove(120);
            }
        }
        else if (!EntityList.entityEggs.containsKey(120)) {
            EntityList.entityEggs.put(120, new EntityList.EntityEggInfo(120, 5651507, 12422002));
        }
    }

    @SubscribeEvent
    public void OnSpawnEntity(final LivingSpawnEvent.CheckSpawn event) {
        final int x = (int)event.x;
        final int y = (int)event.y;
        final int z = (int)event.z;
        boolean flag = false;
        for (int tempX = -1; tempX <= 1; ++tempX) {
            for (int tempZ = -1; tempZ <= 1; ++tempZ) {
                int tempY;
                for (tempY = y; event.world.getBlock(x, tempY, z).equals(Blocks.air) || event.world.getBlock(x, tempY, z) instanceof BlockFalling; --tempY) {}
                if (event.world.getBlock(x, tempY, z).equals(EnumBlock.fungal.block) || event.world.getBlock(x, tempY, z).equals(EnumBlock.blue_mushroom_cap.block) || event.world.getBlock(x, tempY, z).equals(EnumBlock.phos_mushroom_cap.block) || event.world.getBlock(x, tempY, z).equals(EnumBlock.phos_water.block) || event.world.getBlock(x, tempY, z).equals(EnumBlock.blue_mushroom.block) || event.world.getBlock(x, tempY, z).equals(EnumBlock.phos_mushroom.block) || event.world.getBlock(x, tempY, z).equals(EnumBlock.blue_vine.block)) {
                    flag = true;
                }
            }
        }
        if (flag) {
            if (event.entity instanceof EntityWitch || event.entity instanceof EntityWorshipper) {
                event.setResult(Event.Result.ALLOW);
            }
            else {
                event.setResult(Event.Result.DENY);
            }
        }
        else if (event.entity instanceof EntityWorshipper) {
            event.setResult(Event.Result.DENY);
        }
        if (event.entity instanceof EntitySpider) {
            for (int tempX = -1; tempX <= 1; ++tempX) {
                for (int tempZ = -1; tempZ <= 1; ++tempZ) {
                    if (event.world.getBlock(x, y, z).equals(Blocks.web)) {
                        event.setResult(Event.Result.ALLOW);
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public void OnDecorate(final DecorateBiomeEvent.Decorate event) {
        if (event.type == DecorateBiomeEvent.Decorate.EventType.BIG_SHROOM || event.type == DecorateBiomeEvent.Decorate.EventType.SHROOM || event.type == DecorateBiomeEvent.Decorate.EventType.GRASS) {
            for (final Integer[] chunkP : ServerHandler.listMushroomChunk) {
                if (event.chunkX == chunkP[0] && event.chunkZ == chunkP[1]) {
                    if (event.type == DecorateBiomeEvent.Decorate.EventType.BIG_SHROOM) {
                        for (int j = 0; j < 3; ++j) {
                            final int x = event.chunkX + event.rand.nextInt(16) + 8;
                            final int z = event.chunkZ + event.rand.nextInt(16) + 8;
                            int y = 20;
                            while (y < 50) {
                                if (event.world.getBlock(x, y, z).equals(EnumBlock.fungal.block)) {
                                    if (event.rand.nextInt(8) == 0) {
                                        this.phosMushroom.generate(event.world, event.rand, x, y + 1, z);
                                        break;
                                    }
                                    this.blueMushroom.generate(event.world, event.rand, x, y + 1, z);
                                    break;
                                }
                                else {
                                    ++y;
                                }
                            }
                        }
                    }
                    else if (event.type == DecorateBiomeEvent.Decorate.EventType.SHROOM) {
                        for (int j = 0; j < 10; ++j) {
                            final int x = event.chunkX + event.rand.nextInt(16) + 8;
                            final int z = event.chunkZ + event.rand.nextInt(16) + 8;
                            for (int y = 20; y < 50; ++y) {
                                if (event.world.getBlock(x, y, z).equals(EnumBlock.fungal.block) && event.world.getBlock(x, y + 1, z).equals(Blocks.air)) {
                                    if (event.rand.nextInt(8) == 0) {
                                        event.world.setBlock(x, y + 1, z, EnumBlock.phos_mushroom.block);
                                    }
                                    else {
                                        event.world.setBlock(x, y + 1, z, EnumBlock.blue_mushroom.block);
                                    }
                                }
                            }
                        }
                    }
                    else {
                        if (event.type != DecorateBiomeEvent.Decorate.EventType.GRASS) {
                            continue;
                        }
                        for (int tempX = 8; tempX < 24; ++tempX) {
                            for (int tempZ = 8; tempZ < 24; ++tempZ) {
                                final int x2 = event.chunkX + tempX;
                                final int z2 = event.chunkZ + tempZ;
                                for (int tempY = 30; tempY < 60; ++tempY) {
                                    if (event.world.getBlock(x2, tempY, z2).getMaterial().equals(Material.air) && event.world.getBlock(x2, tempY - 1, z2).getMaterial().equals(Material.air) && event.world.getBlock(x2, tempY + 1, z2).getMaterial().equals(Material.air) && (event.world.getBlock(x2 + 1, tempY, z2).equals(Blocks.stone) || event.world.getBlock(x2 - 1, tempY, z2).equals(Blocks.stone) || event.world.getBlock(x2, tempY, z2 + 1).equals(Blocks.stone) || event.world.getBlock(x2, tempY, z2 - 1).equals(Blocks.stone)) && event.rand.nextInt(40) == 0) {
                                        final List<Integer[]> solution = new ArrayList<Integer[]>();
                                        if (tempX - 1 >= 8) {
                                            solution.add(new Integer[] { x2 - 1, tempY, z2 });
                                        }
                                        if (tempX + 1 < 24) {
                                            solution.add(new Integer[] { x2 + 1, tempY, z2 });
                                        }
                                        if (tempZ - 1 >= 8) {
                                            solution.add(new Integer[] { x2, tempY, z2 - 1 });
                                        }
                                        if (tempZ + 1 < 24) {
                                            solution.add(new Integer[] { x2, tempY, z2 + 1 });
                                        }
                                        Collections.shuffle(solution);
                                        while (!solution.isEmpty() && !event.world.getBlock((int)solution.get(0)[0], (int)solution.get(0)[1], (int)solution.get(0)[2]).getMaterial().equals(Material.rock)) {
                                            solution.remove(0);
                                        }
                                        if (!solution.isEmpty()) {
                                            this.fungusGen.generate(event.world, event.rand, (int)solution.get(0)[0], (int)solution.get(0)[1], (int)solution.get(0)[2]);
                                        }
                                        solution.clear();
                                    }
                                }
                                if (event.rand.nextInt(5) == 0) {
                                    for (int tempY = 30; tempY < 60; ++tempY) {
                                        if (event.world.getBlock(x2, tempY, z2).equals(Blocks.air) && event.world.getBlock(x2, tempY + 1, z2).getMaterial().equals(Material.rock)) {
                                            this.vineMushroom.generate(event.world, event.rand, x2, tempY, z2);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public void OnPostDecorate(DecorateBiomeEvent.Post event) {
        Iterator var2 = listMushroomChunk.iterator();

        Integer[] chunkP;
        do {
            if (!var2.hasNext()) {
                return;
            }

            chunkP = (Integer[])var2.next();
        } while(event.chunkX != chunkP[0] || event.chunkZ != chunkP[1]);

        listMushroomChunk.remove(chunkP);
    }

    @SubscribeEvent
    public void onBucketFill(final FillBucketEvent event) {
        final Block block = event.world.getBlock(event.target.blockX, event.target.blockY, event.target.blockZ);
        if (event.world.getBlockMetadata(event.target.blockX, event.target.blockY, event.target.blockZ) == 0) {
            for (final Block bukketBlock : ServerHandler.buckets.keySet()) {
                if (block.equals(bukketBlock)) {
                    event.world.setBlockToAir(event.target.blockX, event.target.blockY, event.target.blockZ);
                    final ItemStack result = new ItemStack((Item)ServerHandler.buckets.get(bukketBlock));
                    event.result = result;
                    event.setResult(Event.Result.ALLOW);
                }
            }
        }
    }

    static {
        mapGenVillageDiversity = new MapGenVillageDiversity();
        mapGenStructureDiversity = new MapGenStructureDiversity();
        mapGenCaveStructureDiversity = new MapGenCaveDiversity();
        ServerHandler.listMushroomChunk = new ArrayList<>();
        (buckets = new HashMap<>()).put(EnumBlock.phos_water.block, EnumItem.phos_water_bucket.item);
        ServerHandler.buckets.put(EnumBlock.poison_water.block, EnumItem.poison_water_bucket.item);
    }
}
