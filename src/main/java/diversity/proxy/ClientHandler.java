// 
// Decompiled by Procyon v0.5.36
// 

package diversity.proxy;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraft.util.MathHelper;
import net.minecraft.potion.Potion;
import net.minecraft.enchantment.EnchantmentHelper;
import diversity.suppliers.EnumBlock;
import net.minecraft.world.World;
import net.minecraft.client.renderer.ActiveRenderInfo;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.EntityViewRenderEvent;

public class ClientHandler extends ServerHandler
{
    @SubscribeEvent
    public void OnFogEvent(final EntityViewRenderEvent.FogColors event) {
        final Block block = ActiveRenderInfo.getBlockAtEntityViewpoint((World)Minecraft.getMinecraft().theWorld, event.entity, (float)event.renderPartialTicks);
        float red = event.red;
        float green = event.green;
        float blue = event.blue;
        if (block.equals(EnumBlock.phos_water.block)) {
            final float f10 = EnchantmentHelper.getRespiration(event.entity) * 0.2f;
            red = 0.16f + f10;
            green = 0.02f + f10;
            blue = 0.2f + f10;
        }
        if (block.equals(EnumBlock.poison_water.block)) {
            final float f10 = EnchantmentHelper.getRespiration(event.entity) * 0.2f;
            red = 0.02f + f10;
            green = 0.2f + f10;
            blue = 0.02f + f10;
        }
        double d0 = (event.entity.lastTickPosY + (event.entity.posY - event.entity.lastTickPosY) * event.renderPartialTicks) * Minecraft.getMinecraft().theWorld.provider.getVoidFogYFactor();
        if (event.entity.isPotionActive(Potion.blindness)) {
            final int i = event.entity.getActivePotionEffect(Potion.blindness).getDuration();
            if (i < 20) {
                d0 *= 1.0f - i / 20.0f;
            }
            else {
                d0 = 0.0;
            }
        }
        if (d0 < 1.0) {
            if (d0 < 0.0) {
                d0 = 0.0;
            }
            d0 *= d0;
            red *= (float)d0;
            green *= (float)d0;
            blue *= (float)d0;
        }
        if (event.entity.isPotionActive(Potion.nightVision)) {
            final int j = Minecraft.getMinecraft().thePlayer.getActivePotionEffect(Potion.nightVision).getDuration();
            final float f11 = (j > 200) ? 1.0f : (0.7f + MathHelper.sin((j - (float)event.renderPartialTicks) * 3.1415927f * 0.2f) * 0.3f);
            float f12 = 1.0f / red;
            if (f12 > 1.0f / green) {
                f12 = 1.0f / green;
            }
            if (f12 > 1.0f / blue) {
                f12 = 1.0f / blue;
            }
            red = red * (1.0f - f11) + red * f12 * f11;
            green = green * (1.0f - f11) + green * f12 * f11;
            blue = blue * (1.0f - f11) + blue * f12 * f11;
        }
        if (Minecraft.getMinecraft().gameSettings.anaglyph) {
            final float f11 = (red * 30.0f + green * 59.0f + blue * 11.0f) / 100.0f;
            final float f12 = (red * 30.0f + green * 70.0f) / 100.0f;
            final float f13 = (red * 30.0f + blue * 70.0f) / 100.0f;
            red = f11;
            green = f12;
            blue = f13;
        }
        event.red = red;
        event.green = green;
        event.blue = blue;
    }
}
