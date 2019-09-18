// 
// Decompiled by Procyon v0.5.36
// 

package diversity;

import diversity.configurations.ConfigBiomeGroup;
import diversity.configurations.ConfigVillager;
import net.minecraft.nbt.NBTTagCompound;

import java.util.*;

import diversity.village.VillageTools;
import net.minecraft.util.MathHelper;
import net.minecraft.world.gen.structure.StructureVillagePieces;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import diversity.suppliers.EnumVillage;
import diversity.configurations.ConfigGenerationRate;
import net.minecraft.world.gen.structure.StructureStart;
import net.minecraft.world.gen.structure.MapGenVillage;

import java.util.Map.Entry;

public class MapGenVillageDiversity extends MapGenVillage
{
    private int terrainType, terrainType2;
    private int maxDistanceBetweenVillages;
    private int minDistanceBetweenVillages;
    public boolean customVillages;
    
    public MapGenVillageDiversity() {
        maxDistanceBetweenVillages = ConfigGenerationRate.MAXDISTANCEBETWEENVILLAGES.getIntegerConfig();
        minDistanceBetweenVillages = ConfigGenerationRate.MINDISTANCEBETWEENVILLAGES.getIntegerConfig();
    }
    
    public MapGenVillageDiversity(final Map p_i2093_1_) {
        this();
        Iterator iterator = p_i2093_1_.entrySet().iterator();

        while (iterator.hasNext())
        {
            Entry entry = (Entry)iterator.next();

            if (entry.getKey().equals("size"))
            {
                this.terrainType2 = MathHelper.parseIntWithDefaultAndMax((String)entry.getValue(), this.terrainType2, 0);
            }
            else if (entry.getKey().equals("distance"))
            {
                this.maxDistanceBetweenVillages = MathHelper.parseIntWithDefaultAndMax((String)entry.getValue(), this.maxDistanceBetweenVillages, this.minDistanceBetweenVillages + 1);
            }
        }
    }
    
    @Override
    public String func_143025_a() {
        if (!customVillages) {
            super.func_143025_a();
        }

        return "Diversity.Village";
    }
    
    @Override
    protected StructureStart getStructureStart(int coordX, int coordZ) {
        if (!customVillages) {
            return new MapGenVillage.Start(this.worldObj, this.rand, coordX, coordZ, this.terrainType2);
        }

        return new Start(this.worldObj, this.rand, coordX, coordZ, this.terrainType);
    }
    
    @Override
    protected boolean canSpawnStructureAtCoords(int x, int z) {
        int coordX = x;
        int coordZ = z;

        if (x < 0)
        {
            x -= maxDistanceBetweenVillages - 1;
        }

        if (z < 0)
        {
            z -= maxDistanceBetweenVillages - 1;
        }

        int i1 = x / maxDistanceBetweenVillages;
        int j1 = z / maxDistanceBetweenVillages;
        Random random = this.worldObj.setRandomSeed(i1, j1, 10387312);
        i1 *= maxDistanceBetweenVillages;
        j1 *= maxDistanceBetweenVillages;
        i1 += random.nextInt(maxDistanceBetweenVillages - minDistanceBetweenVillages);
        j1 += random.nextInt(maxDistanceBetweenVillages - minDistanceBetweenVillages);

        if (coordX == i1 && coordZ == j1)
        {
            boolean flag = this.worldObj.getWorldChunkManager().areBiomesViable(coordX * 16 + 8, coordZ * 16 + 8, 0, villageSpawnBiomes);
            if (flag)
            {
                BiomeGenBase biome = this.worldObj.getWorldChunkManager().getBiomeGenAt(coordX * 16 + 8, coordZ * 16 + 8);
                customVillages = EnumVillage.canSpawnInBiome(biome);
                boolean vanillaVillages = ConfigBiomeGroup.VANILLA_VILLAGE.getBiomesList().contains(biome);

                //custom and vanilla villages compete for the same biome coin flip
                if (customVillages && vanillaVillages) {
                    if (random.nextInt(100) < ConfigGenerationRate.CUSTOMVILLAGECHANCE.getIntegerConfig()) {
                        customVillages = false;
                    }
                }

                return customVillages || vanillaVillages;
            }
        }
        return false;
    }
    
    public static class Start extends StructureStart
    {
        private boolean hasMoreThanTwoComponents;
        
        public Start() {}
        
        public Start(final World world, final Random random, final int coordX, final int coordZ, final int terrainType)
        {
            super(coordX, coordZ);
            final BiomeGenBase biome = world.getWorldChunkManager().getBiomeGenAt(coordX * 16 + 8, coordZ * 16 + 8);
            final VillageTools villageInstance = EnumVillage.getRandomVillage(biome, random);
            if (villageInstance == null) {
                this.hasMoreThanTwoComponents = false;
                this.updateBoundingBox();
                return;
            }
            final List list = villageInstance.getStructureVillageWeightedPieceList(random);
            final VillageTools.GlobalStart start = villageInstance.getStart(world.getWorldChunkManager(), 0, random, (coordX << 4) + 2, (coordZ << 4) + 2, list, terrainType);
            this.components.add(start);
            start.buildComponent(start, this.components, random);
            final List basicComponents = start.field_74930_j;
            final List pieceComponents = start.field_74932_i;
            while (!basicComponents.isEmpty() || !pieceComponents.isEmpty()) {
                if (basicComponents.isEmpty()) {
                    final int l = random.nextInt(pieceComponents.size());
                    final StructureComponent structurecomponent = (StructureComponent) pieceComponents.remove(l);
                    structurecomponent.buildComponent(start, this.components, random);
                }
                else {
                    final int l = random.nextInt(basicComponents.size());
                    final StructureComponent structurecomponent = (StructureComponent) basicComponents.remove(l);
                    structurecomponent.buildComponent(start, this.components, random);
                }
            }
            int l = 0;
            for (final Object structurecomponent2 : this.components) {
                if (!(structurecomponent2 instanceof StructureVillagePieces.Road)) {
                    ++l;
                }
            }
            this.hasMoreThanTwoComponents = (l > 2);
            this.updateBoundingBox();
        }
        
        @Override
        public boolean isSizeableStructure() {
            return this.hasMoreThanTwoComponents;
        }
        
        @Override
        public void func_143022_a(final NBTTagCompound p_143022_1_) {
            super.func_143022_a(p_143022_1_);
            p_143022_1_.setBoolean("Valid", this.hasMoreThanTwoComponents);
        }
        
        @Override
        public void func_143017_b(final NBTTagCompound p_143017_1_) {
            super.func_143017_b(p_143017_1_);
            this.hasMoreThanTwoComponents = p_143017_1_.getBoolean("Valid");
        }
    }
}
