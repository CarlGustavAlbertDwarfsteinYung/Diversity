// 
// Decompiled by Procyon v0.5.36
// 

package diversity.suppliers;

import diversity.block.FluidPoisonWater;
import net.minecraft.item.EnumRarity;
import diversity.block.FluidPhosWater;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.Fluid;

public enum EnumFluid
{
    phos_water(new FluidPhosWater().setUnlocalizedName("phos_water").setLuminosity(6).setRarity(EnumRarity.rare)), 
    poison_water(new FluidPoisonWater().setUnlocalizedName("poison_water").setRarity(EnumRarity.rare));
    
    public final Fluid fluid;
    
    EnumFluid(final Fluid fluid) {
        FluidRegistry.registerFluid(this.fluid = fluid);
    }
    
    public static void register() {
        for (final EnumFluid enumFluid : values()) {
            FluidRegistry.registerFluid(enumFluid.fluid);
        }
    }
}
