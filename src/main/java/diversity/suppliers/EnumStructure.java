// 
// Decompiled by Procyon v0.5.36
// 

package diversity.suppliers;

import java.util.HashMap;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import diversity.structure.WitchHouse;
import diversity.structure.DwarvenScaffolding;
import diversity.structure.DwarvenCity;
import diversity.structure.Inn;
import diversity.structure.WitchHutt;
import diversity.structure.Catacomb;
import diversity.structure.AztecPyramid;
import diversity.structure.EgyptianPyramid;
import diversity.structure.GlobalFeature;
import java.util.Random;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.minecraft.world.biome.BiomeGenBase;
import java.util.Map;
import diversity.configurations.ConfigBiomeGroup;

public enum EnumStructure
{
    //EGYPTIAN_PYRAMID(ConfigBiomeGroup.EGYPTIAN_PYRAMID, (Class)EgyptianPyramid.class),
    //AZTEC_PYRAMID(ConfigBiomeGroup.AZTEC_PYRAMID, (Class)AztecPyramid.class),
    CATACOMB(ConfigBiomeGroup.CATACOMB, (Class)Catacomb.class), 
    //WITCH_HUTT(ConfigBiomeGroup.WITCH_HUTT, (Class)WitchHutt.class),
    INN(ConfigBiomeGroup.INN, (Class)Inn.class), 
    DWARVEN_CITY((Class)DwarvenCity.class), 
    DWARVEN_SCAFFOLDING((Class)DwarvenScaffolding.class), 
    WITCH_HOUSE((Class)WitchHouse.class);
    
    public int totalWeight;
    private final ConfigBiomeGroup config;
    public final Class pieceClass;
    private static Map<BiomeGenBase, List<EnumStructure>> biomeEnumMap;
    
    EnumStructure(final ConfigBiomeGroup config, final Class pieceClass) {
        this.config = config;
        this.pieceClass = pieceClass;
    }
    
    EnumStructure(final Class pieceClass) {
        this(null, pieceClass);
    }
    
    public static void load() {
        EnumStructure.biomeEnumMap.clear();
        for (final EnumStructure enumStructure : values()) {
            if (enumStructure.config != null) {
                for (final BiomeGenBase biome : enumStructure.config.getBiomes()) {
                    if (!EnumStructure.biomeEnumMap.containsKey(biome)) {
                        EnumStructure.biomeEnumMap.put(biome, new ArrayList<>(Arrays.asList(enumStructure)));
                    }
                    else if (!EnumStructure.biomeEnumMap.get(biome).contains(enumStructure)) {
                        EnumStructure.biomeEnumMap.get(biome).add(enumStructure);
                    }
                }
            }
        }
    }
    
    public static boolean canSpawnInBiome(final BiomeGenBase biome) {
        return EnumStructure.biomeEnumMap.get(biome) != null && !EnumStructure.biomeEnumMap.get(biome).isEmpty();
    }
    
    public static EnumStructure getRandomStructure(final BiomeGenBase biome, final Random random) {
        final List<EnumStructure> list = EnumStructure.biomeEnumMap.get(biome);
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(random.nextInt(list.size()));
    }
    
    public GlobalFeature getStructureComponent(final Random random, final int coordX, final int coordZ) {
        if (this.pieceClass.equals(EgyptianPyramid.class)) {
            return new EgyptianPyramid(random, coordX, coordZ);
        }
        if (this.pieceClass.equals(AztecPyramid.class)) {
            return new AztecPyramid(random, coordX, coordZ);
        }
        if (this.pieceClass.equals(Catacomb.class)) {
            return new Catacomb(random, coordX, coordZ);
        }
        if (this.pieceClass.equals(WitchHutt.class)) {
            return new WitchHutt(random, coordX, coordZ);
        }
        if (this.pieceClass.equals(Inn.class)) {
            return new Inn(random, coordX, coordZ);
        }
        if (this.pieceClass.equals(DwarvenCity.class)) {
            return new DwarvenCity(random, coordX, coordZ);
        }
        if (this.pieceClass.equals(DwarvenScaffolding.class)) {
            return new DwarvenScaffolding(random, coordX, coordZ);
        }
        if (this.pieceClass.equals(WitchHouse.class)) {
            return new WitchHouse(random, coordX, coordZ);
        }
        return null;
    }
    
    public static void register() {
        for (final EnumStructure structure : values()) {
            MapGenStructureIO.func_143031_a(structure.pieceClass, structure.name());
        }
    }
    
    static {
        EnumStructure.biomeEnumMap = new HashMap<BiomeGenBase, List<EnumStructure>>();
    }
}
