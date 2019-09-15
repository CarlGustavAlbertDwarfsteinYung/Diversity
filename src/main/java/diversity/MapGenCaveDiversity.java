// 
// Decompiled by Procyon v0.5.36
// 

package diversity;

import java.util.Iterator;
import diversity.structure.GlobalFeature;
import diversity.utils.Point;
import diversity.structure.DwarvenCave;
import net.minecraft.world.World;
import java.util.HashMap;
import net.minecraft.world.gen.structure.StructureStart;
import net.minecraft.world.biome.BiomeGenBase;
import java.util.Random;
import diversity.suppliers.EnumCave;
import diversity.configurations.ConfigGenerationRate;
import java.util.Map;
import net.minecraft.world.gen.structure.MapGenScatteredFeature;

public class MapGenCaveDiversity extends MapGenScatteredFeature
{
    static Map<Class, Class> caveStructureMap;
    
    public MapGenCaveDiversity() {
    }
    
    public MapGenCaveDiversity(final Map p_i2061_1_) {
        this();
    }
    
    @Override
    public String func_143025_a() {
        return "Diversity.CaveStructure";
    }
    
    @Override
    protected boolean canSpawnStructureAtCoords(int x, int z) {
        final int maxDistanceBetweenScatteredFeatures = ConfigGenerationRate.MAXDISTANCEBETWEENCAVES.getIntegerConfig();
        final int minDistanceBetweenScatteredFeatures = ConfigGenerationRate.MINDISTANCEBETWEENCAVES.getIntegerConfig();
        final int coordX = x;
        final int coordZ = z;
        if (x < 0) {
            x -= maxDistanceBetweenScatteredFeatures - 1;
        }
        if (z < 0) {
            z -= maxDistanceBetweenScatteredFeatures - 1;
        }
        int x2 = x / maxDistanceBetweenScatteredFeatures;
        int z2 = z / maxDistanceBetweenScatteredFeatures;
        final Random random = this.worldObj.setRandomSeed(x2, z2, 9707617);
        x2 *= maxDistanceBetweenScatteredFeatures;
        z2 *= maxDistanceBetweenScatteredFeatures;
        x2 += random.nextInt(maxDistanceBetweenScatteredFeatures - minDistanceBetweenScatteredFeatures);
        z2 += random.nextInt(maxDistanceBetweenScatteredFeatures - minDistanceBetweenScatteredFeatures);
        if (coordX == x2 && coordZ == z2) {
            final BiomeGenBase biome = this.worldObj.getWorldChunkManager().getBiomeGenAt(coordX * 16 + 8, coordZ * 16 + 8);
            return EnumCave.canSpawnInBiome(biome);
        }
        return false;
    }
    
    @Override
    protected StructureStart getStructureStart(final int coordX, final int coordZ) {
        return new Start(this.worldObj, this.rand, coordX, coordZ);
    }
    
    @Override
    public boolean func_143030_a(final int p_143030_1_, final int p_143030_2_, final int p_143030_3_) {
        return false;
    }
    
    static {
        MapGenCaveDiversity.caveStructureMap = new HashMap<Class, Class>();
    }
    
    public static class Start extends StructureStart
    {
        public Start() {
        }
        
        public Start(final World world, final Random random, final int coordX, final int coordZ) {
            super(coordX, coordZ);
            final BiomeGenBase biome = world.getBiomeGenForCoords(coordX * 16 + 8, coordZ * 16 + 8);
            final EnumCave cave = EnumCave.getRandomCave(biome, random);
            final GlobalFeature feature = cave.getCaveComponent(random, coordX * 16, coordZ * 16);
            if (feature != null) {
                this.components.add(feature);
                GlobalFeature structureFeature = cave.getStructureComponent(0, random, coordX * 16, coordZ * 16);
                if (structureFeature != null) {
                    this.components.add(structureFeature);
                }
                if (feature instanceof DwarvenCave) {
                    for (final Point point : ((DwarvenCave)feature).scaffoldingPoint) {
                        structureFeature = cave.getStructureComponent(1, random, point.x, point.z);
                        if (feature != null) {
                            this.components.add(structureFeature);
                        }
                    }
                }
            }
            this.updateBoundingBox();
        }
    }
}
