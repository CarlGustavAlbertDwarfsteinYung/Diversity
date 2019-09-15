// 
// Decompiled by Procyon v0.5.36
// 

package diversity.client.render.item;

import net.minecraft.util.IIcon;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureUtil;
import diversity.item.ItemBlowgun;
import net.minecraft.util.MathHelper;
import org.lwjgl.opengl.GL11;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderManager;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraftforge.client.IItemRenderer;

@SideOnly(Side.CLIENT)
public class RenderBlowgun implements IItemRenderer
{
    private RenderManager renderManager;
    private Minecraft mc;
    
    public RenderBlowgun() {
        this.renderManager = RenderManager.instance;
        this.mc = Minecraft.getMinecraft();
    }
    
    @Override
    public boolean handleRenderType(final ItemStack item, final IItemRenderer.ItemRenderType type) {
        return type == IItemRenderer.ItemRenderType.EQUIPPED || type == IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON;
    }
    
    @Override
    public boolean shouldUseRenderHelper(final IItemRenderer.ItemRenderType type, final ItemStack stack, final IItemRenderer.ItemRendererHelper helper) {
        return false;
    }
    
    @Override
    public void renderItem(final IItemRenderer.ItemRenderType type, final ItemStack stack, final Object... data) {
        EntityPlayer player = null;
        final EntityLivingBase baseEntity = (EntityLivingBase)data[1];
        if (data[1] instanceof EntityPlayer) {
            player = (EntityPlayer)data[1];
        }
        GL11.glPopMatrix();
        if (type == IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON) {
            int count = 0;
            if (player != null) {
                count = player.getItemInUseCount();
            }
            if (count > 0) {
                GL11.glPopMatrix();
                GL11.glPopMatrix();
                GL11.glPushMatrix();
                final float f13 = 0.8f;
                final float f14 = baseEntity.getSwingProgress(0.0f);
                final float f15 = MathHelper.sin(f14 * 3.1415927f);
                final float f16 = MathHelper.sin(MathHelper.sqrt_float(f14) * 3.1415927f);
                GL11.glTranslatef(-f16 * 0.4f, MathHelper.sin(MathHelper.sqrt_float(f14) * 3.1415927f * 2.0f) * 0.2f, -f15 * 0.2f);
                GL11.glTranslatef(0.7f * f13, -0.65f * f13 - 0.0f, -0.9f * f13);
                GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
                GL11.glEnable(32826);
                GL11.glRotatef(-f15 * 20.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(-f16 * 20.0f, 0.0f, 0.0f, 1.0f);
                GL11.glRotatef(-f16 * 80.0f, 1.0f, 0.0f, 0.0f);
                final float f17 = 0.4f;
                GL11.glScalef(f17, f17, f17);
                GL11.glRotatef(-18.0f, 0.0f, 0.0f, 1.0f);
                GL11.glRotatef(-12.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(-8.0f, 1.0f, 0.0f, 0.0f);
                GL11.glTranslatef(-0.9f, 0.2f, 0.0f);
                final ItemBlowgun blowgun = (ItemBlowgun)stack.getItem();
                final float f18 = blowgun.getMaxItemUseDuration(stack) - (count + 1.0f);
                float f19 = f18 / 8.0f;
                f19 = (f19 * f19 + f19 * 2.0f) / 3.0f;
                if (f19 > 1.0f) {
                    f19 = 1.0f;
                }
                if (f19 > 0.1f) {
                    GL11.glTranslatef(0.0f, MathHelper.sin((f18 - 0.1f) * 1.3f) * 0.01f * (f19 - 0.1f), 0.0f);
                }
                GL11.glTranslatef(0.0f, 0.0f, f19 * 0.1f);
                GL11.glRotatef(-335.0f, 0.0f, 0.0f, 1.0f);
                GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
                GL11.glTranslatef(0.0f, 0.5f, 0.0f);
                final float f20 = 1.0f + f19 * 0.2f;
                GL11.glScalef(1.0f, 1.0f, f20);
                GL11.glTranslatef(0.0f, -0.5f, 0.0f);
                GL11.glRotatef(50.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(335.0f, 0.0f, 0.0f, 1.0f);
                this.renderItem(baseEntity, stack, 0);
                GL11.glPopMatrix();
                GL11.glPushMatrix();
                GL11.glPushMatrix();
            }
            else {
                this.renderItem(baseEntity, stack, 0);
            }
        }
        else {
            GL11.glPushMatrix();
            final float f21 = 2.6666667f;
            GL11.glRotatef(-20.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-60.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScalef(f21, f21, f21);
            GL11.glTranslatef(-0.25f, -0.1875f, 0.1875f);
            final float f22 = 0.625f;
            GL11.glTranslatef(0.0f, 0.125f, 0.3125f);
            GL11.glRotatef(-20.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScalef(f22, -f22, f22);
            GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            this.renderItem(baseEntity, stack, 0);
            GL11.glPopMatrix();
        }
        GL11.glPushMatrix();
    }
    
    private void renderItem(final EntityLivingBase entity, final ItemStack stack, final int pass) {
        final TextureManager texturemanager = this.mc.getTextureManager();
        final IIcon iicon = entity.getItemIcon(stack, pass);
        if (iicon == null || texturemanager == null) {
            System.err.println("Um... there was no texture. This should never happen.");
            GL11.glPopMatrix();
            return;
        }
        texturemanager.bindTexture(texturemanager.getResourceLocation(stack.getItemSpriteNumber()));
        TextureUtil.func_152777_a(false, false, 1.0f);
        final Tessellator tessellator = Tessellator.instance;
        final float f = iicon.getMinU();
        final float f2 = iicon.getMaxU();
        final float f3 = iicon.getMinV();
        final float f4 = iicon.getMaxV();
        final float f5 = 0.0f;
        final float f6 = 0.3f;
        GL11.glEnable(32826);
        GL11.glTranslatef(-f5, -f6, 0.0f);
        final float f7 = 1.5f;
        GL11.glScalef(f7, f7, f7);
        GL11.glRotatef(50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(335.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.9375f, -0.0625f, 0.0f);
        ItemRenderer.renderItemIn2D(tessellator, f2, f3, f, f4, iicon.getIconWidth(), iicon.getIconHeight(), 0.0625f);
        if (stack.hasEffect(pass)) {
            GL11.glDepthFunc(514);
            GL11.glDisable(2896);
            texturemanager.bindTexture(new ResourceLocation("textures/misc/enchanted_item_glint.png"));
            GL11.glEnable(3042);
            OpenGlHelper.glBlendFunc(768, 1, 1, 0);
            final float f8 = 0.76f;
            GL11.glColor4f(0.5f * f8, 0.25f * f8, 0.8f * f8, 1.0f);
            GL11.glMatrixMode(5890);
            GL11.glPushMatrix();
            final float f9 = 0.125f;
            GL11.glScalef(f9, f9, f9);
            float f10 = Minecraft.getSystemTime() % 3000L / 3000.0f * 8.0f;
            GL11.glTranslatef(f10, 0.0f, 0.0f);
            GL11.glRotatef(-50.0f, 0.0f, 0.0f, 1.0f);
            ItemRenderer.renderItemIn2D(tessellator, 0.0f, 0.0f, 1.0f, 1.0f, 256, 256, 0.0625f);
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glScalef(f9, f9, f9);
            f10 = Minecraft.getSystemTime() % 4873L / 4873.0f * 8.0f;
            GL11.glTranslatef(-f10, 0.0f, 0.0f);
            GL11.glRotatef(10.0f, 0.0f, 0.0f, 1.0f);
            ItemRenderer.renderItemIn2D(tessellator, 0.0f, 0.0f, 1.0f, 1.0f, 256, 256, 0.0625f);
            GL11.glPopMatrix();
            GL11.glMatrixMode(5888);
            GL11.glDisable(3042);
            GL11.glEnable(2896);
            GL11.glDepthFunc(515);
        }
        GL11.glDisable(32826);
        texturemanager.bindTexture(texturemanager.getResourceLocation(stack.getItemSpriteNumber()));
        TextureUtil.func_147945_b();
    }
}
