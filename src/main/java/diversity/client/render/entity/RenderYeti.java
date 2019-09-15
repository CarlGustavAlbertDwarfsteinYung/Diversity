// 
// Decompiled by Procyon v0.5.36
// 

package diversity.client.render.entity;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;
import net.minecraft.entity.EntityLivingBase;
import diversity.utils.ResourceTools;
import diversity.entity.EntityYeti;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelBase;
import diversity.client.model.ModelYeti;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderLiving;

@SideOnly(Side.CLIENT)
public class RenderYeti extends RenderLiving
{
    private ModelYeti yetiModel;
    
    public RenderYeti() {
        super((ModelBase)new ModelYeti(), 0.5f);
        this.yetiModel = (ModelYeti)this.mainModel;
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final Entity p_110775_1_) {
        return ResourceTools.getResource(EntityYeti.class);
    }
    
    protected void rotateCorpse(final EntityYeti p_77043_1_, final float p_77043_2_, final float p_77043_3_, final float p_77043_4_) {
        super.rotateCorpse((EntityLivingBase)p_77043_1_, p_77043_2_, p_77043_3_, p_77043_4_);
        if (p_77043_1_.limbSwingAmount >= 0.01) {
            final float f3 = 13.0f;
            final float f4 = p_77043_1_.limbSwing - p_77043_1_.limbSwingAmount * (1.0f - p_77043_4_) + 6.0f;
            final float f5 = (Math.abs(f4 % f3 - f3 * 0.5f) - f3 * 0.25f) / (f3 * 0.25f);
            GL11.glRotatef(6.5f * f5, 0.0f, 0.0f, 1.0f);
        }
    }
    
    @Override
    protected void rotateCorpse(final EntityLivingBase p_77043_1_, final float p_77043_2_, final float p_77043_3_, final float p_77043_4_) {
        this.rotateCorpse((EntityYeti)p_77043_1_, p_77043_2_, p_77043_3_, p_77043_4_);
    }
    
    @Override
    protected void renderEquippedItems(final EntityLivingBase par1EntityLiving, final float par2) {
        final float var3 = 1.0f;
        GL11.glColor3f(var3, var3, var3);
        super.renderEquippedItems(par1EntityLiving, par2);
        final ItemStack itemstack = par1EntityLiving.getHeldItem();
        if (itemstack != null && itemstack.getItem() != null) {
            final Item item = itemstack.getItem();
            GL11.glPushMatrix();
            this.yetiModel.ArmRight.postRender(0.0625f);
            GL11.glTranslatef(-0.2225f, 1.0375f, 0.0325f);
            final IItemRenderer customRenderer = MinecraftForgeClient.getItemRenderer(itemstack, IItemRenderer.ItemRenderType.EQUIPPED);
            final boolean is3D = customRenderer != null && customRenderer.shouldUseRenderHelper(IItemRenderer.ItemRenderType.EQUIPPED, itemstack, IItemRenderer.ItemRendererHelper.BLOCK_3D);
            if (item instanceof ItemBlock && (is3D || RenderBlocks.renderItemIn3d(Block.getBlockFromItem(item).getRenderType()))) {
                float f1 = 0.5f;
                GL11.glTranslatef(0.0f, 0.1875f, -0.3125f);
                f1 *= 0.75f;
                GL11.glRotatef(20.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
                GL11.glScalef(-f1, -f1, f1);
            }
            else if (item == Items.bow) {
                final float f1 = 0.625f;
                GL11.glTranslatef(0.0f, 0.125f, 0.3125f);
                GL11.glRotatef(-20.0f, 0.0f, 1.0f, 0.0f);
                GL11.glScalef(f1, -f1, f1);
                GL11.glRotatef(40.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            }
            else if (item.isFull3D()) {
                final float f1 = 0.625f;
                if (item.shouldRotateAroundWhenRendering()) {
                    GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
                    GL11.glTranslatef(0.0f, -0.125f, 0.0f);
                }
                GL11.glScalef(f1, -f1, f1);
                GL11.glTranslatef(-0.3f, 1.4f, -0.8f);
                GL11.glRotatef(40.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            }
            else {
                final float f1 = 0.375f;
                GL11.glTranslatef(0.25f, 0.1875f, -0.1875f);
                GL11.glScalef(f1, f1, f1);
                GL11.glRotatef(60.0f, 0.0f, 0.0f, 1.0f);
                GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(20.0f, 0.0f, 0.0f, 1.0f);
            }
            if (itemstack.getItem().requiresMultipleRenderPasses()) {
                for (int i = 0; i < itemstack.getItem().getRenderPasses(itemstack.getItemDamage()); ++i) {
                    final int j = itemstack.getItem().getColorFromItemStack(itemstack, i);
                    final float f2 = (j >> 16 & 0xFF) / 255.0f;
                    final float f3 = (j >> 8 & 0xFF) / 255.0f;
                    final float f4 = (j & 0xFF) / 255.0f;
                    GL11.glColor4f(f2, f3, f4, 1.0f);
                    this.renderManager.itemRenderer.renderItem(par1EntityLiving, itemstack, i);
                }
            }
            else {
                final int i = itemstack.getItem().getColorFromItemStack(itemstack, 0);
                final float f5 = (i >> 16 & 0xFF) / 255.0f;
                final float f2 = (i >> 8 & 0xFF) / 255.0f;
                final float f3 = (i & 0xFF) / 255.0f;
                GL11.glColor4f(f5, f2, f3, 1.0f);
                this.renderManager.itemRenderer.renderItem(par1EntityLiving, itemstack, 0);
            }
            GL11.glPopMatrix();
        }
    }
    
    @Override
    protected void preRenderCallback(final EntityLivingBase par1EntityLiving, final float par2) {
        GL11.glScalef(1.5f, 1.5f, 1.5f);
    }
}
