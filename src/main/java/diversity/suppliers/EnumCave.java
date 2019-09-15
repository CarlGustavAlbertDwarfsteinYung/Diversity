// 
// Decompiled by Procyon v0.5.36
// 

package diversity.suppliers;

import java.util.HashMap;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import diversity.structure.SpiderDen;
import diversity.structure.YetiDen;
import diversity.structure.ShroomCave;
import diversity.structure.JungleValley;
import diversity.structure.DwarvenCave;
import diversity.structure.GlobalFeature;
import java.util.Random;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.minecraft.world.biome.BiomeGenBase;
import java.util.Map;
import diversity.configurations.ConfigBiomeGroup;

public enum EnumCave
{
    DWARVEN_CAVE(ConfigBiomeGroup.DWARVEN_CAVE, DwarvenCave.class, new EnumStructure[] { EnumStructure.DWARVEN_CITY, EnumStructure.DWARVEN_SCAFFOLDING }),
    //JUNGLE_VALLEY(ConfigBiomeGroup.JUNGLE_VALLEY, JungleValley.class),
    SHROOM_CAVE(ConfigBiomeGroup.SHROOM_CAVE, ShroomCave.class, new EnumStructure[] { EnumStructure.WITCH_HOUSE }),
    YETI_DEN(ConfigBiomeGroup.YETI_DEN, YetiDen.class),
    SPIDER_DEN(ConfigBiomeGroup.SPIDER_DEN, SpiderDen.class);
    
    private final ConfigBiomeGroup config;
    public final Class pieceClass;
    private EnumStructure[] structure;
    private static Map<BiomeGenBase, List<EnumCave>> biomeEnumMap;
    
    EnumCave(final ConfigBiomeGroup config, final Class pieceClass) {
        this.config = config;
        this.pieceClass = pieceClass;
    }
    
    EnumCave(final ConfigBiomeGroup config, final Class pieceClass, final EnumStructure[] structure) {
        this.config = config;
        this.structure = structure;
        this.pieceClass = pieceClass;
    }
    
    public static void load() {
        EnumCave.biomeEnumMap.clear();
        for (final EnumCave enumStructure : values()) {
            for (final BiomeGenBase biome : enumStructure.config.getBiomes()) {
                if (!EnumCave.biomeEnumMap.containsKey(biome)) {
                    EnumCave.biomeEnumMap.put(biome, new ArrayList<>(Arrays.asList(enumStructure)));
                }
                else if (!EnumCave.biomeEnumMap.get(biome).contains(enumStructure)) {
                    EnumCave.biomeEnumMap.get(biome).add(enumStructure);
                }
            }
        }
    }
    
    public static boolean canSpawnInBiome(final BiomeGenBase biome) {
        return EnumCave.biomeEnumMap.get(biome) != null && !EnumCave.biomeEnumMap.get(biome).isEmpty();
    }
    
    public static EnumCave getRandomCave(final BiomeGenBase biome, final Random random) {
        final List<EnumCave> list = EnumCave.biomeEnumMap.get(biome);
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(random.nextInt(list.size()));
    }
    
    public GlobalFeature getCaveComponent(final Random random, final int coordX, final int coordZ) {
        if (this.pieceClass.equals(DwarvenCave.class)) {
            return new DwarvenCave(random, coordX, coordZ);
        }
        if (this.pieceClass.equals(JungleValley.class)) {
            return new JungleValley(random, coordX, coordZ);
        }
        if (this.pieceClass.equals(ShroomCave.class)) {
            return new ShroomCave(random, coordX, coordZ);
        }
        if (this.pieceClass.equals(YetiDen.class)) {
            return new YetiDen(random, coordX, coordZ);
        }
        if (this.pieceClass.equals(SpiderDen.class)) {
            return new SpiderDen(random, coordX, coordZ);
        }
        return null;
    }
    
    public GlobalFeature getStructureComponent(final int structureNumber, final Random random, final int coordX, final int coordZ) {
        if (this.structure != null) {
            return this.structure[structureNumber].getStructureComponent(random, coordX, coordZ);
        }
        return null;
    }
    
    public static void register() {
        for (final EnumCave structure : values()) {
            MapGenStructureIO.func_143031_a(structure.pieceClass, structure.name());
        }
    }
    
    static {
        EnumCave.biomeEnumMap = new HashMap<BiomeGenBase, List<EnumCave>>();
    }
}
