// 
// Decompiled by Procyon v0.5.36
// 

package diversity;

import diversity.structure.GlobalFeature;
import diversity.proxy.ServerHandler;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.structure.StructureStart;
import net.minecraft.world.biome.BiomeGenBase;
import java.util.Random;
import diversity.suppliers.EnumStructure;
import diversity.configurations.ConfigGenerationRate;
import java.util.Map;
import net.minecraft.world.gen.structure.MapGenScatteredFeature;

public class MapGenStructureDiversity extends MapGenScatteredFeature
{
    public MapGenStructureDiversity() {
    }
    
    public MapGenStructureDiversity(final Map p_i2061_1_) {
        this();
    }
    
    @Override
    public String func_143025_a() {
        return "Diversity.Structure";
    }
    
    @Override
    protected boolean canSpawnStructureAtCoords(int x, int z) {
        final int maxDistanceBetweenScatteredFeatures = ConfigGenerationRate.MAXDISTANCEBETWEENSTRUCTURES.getIntegerConfig();
        final int minDistanceBetweenScatteredFeatures = ConfigGenerationRate.MINDISTANCEBETWEENSTRUCTURES.getIntegerConfig();
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
        final Random random = this.worldObj.setRandomSeed(x2, z2, 14357617);
        x2 *= maxDistanceBetweenScatteredFeatures;
        z2 *= maxDistanceBetweenScatteredFeatures;
        x2 += random.nextInt(maxDistanceBetweenScatteredFeatures - minDistanceBetweenScatteredFeatures);
        z2 += random.nextInt(maxDistanceBetweenScatteredFeatures - minDistanceBetweenScatteredFeatures);
        if (coordX == x2 && coordZ == z2) {
            final BiomeGenBase biome = this.worldObj.getWorldChunkManager().getBiomeGenAt(coordX * 16 + 8, coordZ * 16 + 8);
            return EnumStructure.canSpawnInBiome(biome);
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
    
    @Override
    public void func_151539_a(final IChunkProvider chunkProvider, final World world, final int chunkX, final int chunkZ, final Block[] blocks) {
        final ServerHandler handler = Diversity.proxy.handler;
        ServerHandler.mapGenCaveStructureDiversity.func_151539_a(chunkProvider, world, chunkX, chunkZ, blocks);
        super.func_151539_a(chunkProvider, world, chunkX, chunkZ, blocks);
    }
    
    @Override
    public boolean generateStructuresInChunk(final World world, final Random random, final int p_75051_3_, final int p_75051_4_) {
        final ServerHandler handler = Diversity.proxy.handler;
        final boolean bool1 = ServerHandler.mapGenCaveStructureDiversity.generateStructuresInChunk(world, random, p_75051_3_, p_75051_4_);
        final boolean bool2 = super.generateStructuresInChunk(world, random, p_75051_3_, p_75051_4_);
        return bool1 && bool2;
    }
    
    public static class Start extends StructureStart
    {
        public Start() {
        }
        
        public Start(final World world, final Random random, final int coordX, final int coordZ) {
            super(coordX, coordZ);
            final BiomeGenBase biome = world.getBiomeGenForCoords(coordX * 16 + 8, coordZ * 16 + 8);
            final EnumStructure structure = EnumStructure.getRandomStructure(biome, random);
            final GlobalFeature feature = structure.getStructureComponent(random, coordX * 16, coordZ * 16);
            if (feature != null) {
                this.components.add(feature);
            }
            this.updateBoundingBox();
        }
    }
}
