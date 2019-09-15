// 
// Decompiled by Procyon v0.5.36
// 

package diversity.client.render.item;

import net.minecraft.util.IIcon;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureUtil;
import org.lwjgl.opengl.GL11;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

public class RenderSpear implements IItemRenderer
{
    private static final ResourceLocation RES_ITEM_GLINT;
    private static final ResourceLocation RES_MAP_BACKGROUND;
    private static final ResourceLocation RES_UNDERWATER_OVERLAY;
    
    @Override
    public boolean handleRenderType(final ItemStack item, final IItemRenderer.ItemRenderType type) {
        return type == IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON || type == IItemRenderer.ItemRenderType.EQUIPPED;
    }
    
    @Override
    public boolean shouldUseRenderHelper(final IItemRenderer.ItemRenderType type, final ItemStack item, final IItemRenderer.ItemRendererHelper helper) {
        return false;
    }
    
    @Override
    public void renderItem(final IItemRenderer.ItemRenderType type, final ItemStack item, final Object... data) {
        if (data.length != 2 || !(data[1] instanceof EntityLivingBase)) {
            return;
        }
        final EntityLivingBase entityLivingBase = (EntityLivingBase)data[1];
        final TextureManager texturemanager = Minecraft.getMinecraft().getTextureManager();
        final IIcon iicon = entityLivingBase.getItemIcon(item, 0);
        if (iicon == null) {
            GL11.glPopMatrix();
            return;
        }
        TextureUtil.func_152777_a(false, false, 1.0f);
        final Tessellator tessellator = Tessellator.instance;
        final float f = iicon.getMinU();
        final float f2 = iicon.getMaxU();
        final float f3 = iicon.getMinV();
        final float f4 = iicon.getMaxV();
        GL11.glEnable(32826);
        if (type == IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON) {
            GL11.glRotatef(45.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScalef(1.0f, 2.0f, 1.0f);
            GL11.glRotatef(-45.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.15f, 0.0f, 0.0f);
        }
        else if (type == IItemRenderer.ItemRenderType.EQUIPPED) {
            GL11.glRotatef(45.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScalef(1.0f, 2.0f, 1.0f);
            GL11.glRotatef(-45.0f, 0.0f, 0.0f, 1.0f);
        }
        ItemRenderer.renderItemIn2D(tessellator, f2, f3, f, f4, iicon.getIconWidth(), iicon.getIconHeight(), 0.0625f);
        GL11.glDisable(32826);
        texturemanager.bindTexture(texturemanager.getResourceLocation(item.getItemSpriteNumber()));
        TextureUtil.func_147945_b();
    }
    
    static {
        RES_ITEM_GLINT = new ResourceLocation("textures/misc/enchanted_item_glint.png");
        RES_MAP_BACKGROUND = new ResourceLocation("textures/map/map_background.png");
        RES_UNDERWATER_OVERLAY = new ResourceLocation("textures/misc/underwater.png");
    }
}
