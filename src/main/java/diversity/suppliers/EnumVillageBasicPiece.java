// 
// Decompiled by Procyon v0.5.36
// 

package diversity.suppliers;

import diversity.village.VillageLakeside;
import diversity.village.VillageEgyptian;
import diversity.village.VillageTibetan;
import diversity.village.VillageZulu;
import diversity.village.VillageSettled;
import diversity.village.VillageInuit;
import diversity.village.VillageAztec;
import diversity.village.VillageApache;
import net.minecraft.world.gen.structure.MapGenStructureIO;

public enum EnumVillageBasicPiece implements IEnumPiece
{
    APACHE_START(EnumVillage.APACHE, VillageApache.Start.class),
    APACHE_PATH(EnumVillage.APACHE, VillageApache.Path.class),
    APACHE_TORCH(EnumVillage.APACHE, VillageApache.Torch.class),
    AZTEC_START(EnumVillage.AZTEC, VillageAztec.Start.class),
    AZTEC_PATH(EnumVillage.AZTEC, VillageAztec.Path.class),
    AZTEC_TORCH(EnumVillage.AZTEC, VillageAztec.Torch.class),
    ESKIMO_START(EnumVillage.INUIT, VillageInuit.Start.class),
    ESKIMO_PATH(EnumVillage.INUIT, VillageInuit.Path.class),
    ESKIMO_TORCH(EnumVillage.INUIT, VillageInuit.Torch.class),
    SETTLED_START(EnumVillage.SETTLED, VillageSettled.Start.class),
    SETTLED_PATH(EnumVillage.SETTLED, VillageSettled.Path.class),
    SETTLED_TORCH(EnumVillage.SETTLED, VillageSettled.Torch.class),
    ZOULOU_START(EnumVillage.ZULU, VillageZulu.Start.class),
    ZOULOU_PATH(EnumVillage.ZULU, VillageZulu.Path.class),
    ZOULOU_TORCH(EnumVillage.ZULU, VillageZulu.Torch.class),
    TIBETAN_START(EnumVillage.TIBETAN, VillageTibetan.Start.class),
    TIBETAN_PATH(EnumVillage.TIBETAN, VillageTibetan.Path.class),
    TIBETAN_TORCH(EnumVillage.TIBETAN, VillageTibetan.Torch.class),
    EGYPTIAN_START(EnumVillage.EGYPTIAN, VillageEgyptian.Start.class),
    EGYPTIAN_PATH(EnumVillage.EGYPTIAN, VillageEgyptian.Path.class),
    EGYPTIAN_TORCH(EnumVillage.EGYPTIAN, VillageEgyptian.Torch.class),
    LAKE_START(EnumVillage.LAKESIDE, VillageLakeside.Start.class),
    LAKE_PATH(EnumVillage.LAKESIDE, VillageLakeside.Path.class),
    LAKE_TORCH(EnumVillage.LAKESIDE, VillageLakeside.Torch.class);
    
    public EnumVillage village;
    public Class pieceClass;
    
    EnumVillageBasicPiece(final EnumVillage village, final Class pieceClass) {
        village.defaultPieces.add(this);
        this.village = village;
        this.pieceClass = pieceClass;
    }
    
    @Override
    public EnumVillage getVillage() {
        return this.village;
    }
    
    public static void register() {
        for (final EnumVillageBasicPiece defaultPiece : values()) {
            MapGenStructureIO.func_143031_a(defaultPiece.pieceClass, defaultPiece.name());
        }
    }
}
