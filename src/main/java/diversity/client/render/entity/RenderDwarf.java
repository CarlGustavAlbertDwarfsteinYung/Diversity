// 
// Decompiled by Procyon v0.5.36
// 

package diversity.client.render.entity;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.Entity;
import diversity.utils.ResourceTools;
import cpw.mods.fml.common.registry.VillagerRegistry;
import net.minecraft.item.Item;
import net.minecraft.init.Items;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.client.IItemRenderer;
import net.minecraft.item.ItemStack;
import org.lwjgl.opengl.GL11;
import net.minecraft.entity.EntityLivingBase;
import diversity.entity.EntityGlobalVillager;
import net.minecraft.client.model.ModelBase;
import diversity.client.model.ModelDwarf;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderLiving;

@SideOnly(Side.CLIENT)
public class RenderDwarf extends RenderLiving
{
    private static final ResourceLocation defaultTexture;
    protected ModelDwarf dwarfModel;
    
    public RenderDwarf() {
        super((ModelBase)new ModelDwarf(), 0.5f);
        this.dwarfModel = (ModelDwarf)this.mainModel;
    }
    
    protected int shouldRenderPass(final EntityGlobalVillager p_77032_1_, final int p_77032_2_, final float p_77032_3_) {
        return this.shouldRenderPass((EntityLivingBase)p_77032_1_, p_77032_2_, p_77032_3_);
    }
    
    @Override
    protected void renderEquippedItems(final EntityLivingBase par1EntityLiving, final float par2) {
        final float var3 = 1.0f;
        GL11.glColor3f(var3, var3, var3);
        super.renderEquippedItems(par1EntityLiving, par2);
        if (par1EntityLiving.getHeldItem() != null) {
            GL11.glPushMatrix();
            this.dwarfModel.ArmRightHandC.postRender(0.0625f);
            GL11.glTranslatef(0.1f, -0.5f, 0.15f);
            GL11.glRotatef(145.0f, 1.0f, 0.0f, 0.0f);
            this.renderItem(par1EntityLiving, par1EntityLiving.getHeldItem());
            GL11.glPopMatrix();
        }
    }
    
    public void renderItem(final EntityLivingBase par1EntityLiving, final ItemStack itemstack) {
        if (itemstack != null && itemstack.getItem() != null) {
            final Item item = itemstack.getItem();
            if (this.mainModel.isChild) {
                final float f1 = 0.5f;
                GL11.glTranslatef(-0.2f, 0.625f, 0.0f);
                GL11.glRotatef(-20.0f, -1.0f, 0.0f, 0.0f);
                GL11.glScalef(f1, f1, f1);
            }
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
        }
    }
    
    protected ResourceLocation getEntityTexture(final EntityGlobalVillager entity) {
        if (!entity.isChild()) {
            return VillagerRegistry.getVillagerSkin(entity.getProfession(), RenderDwarf.defaultTexture);
        }
        return ResourceTools.getResource(entity.getClass());
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final Entity p_110775_1_) {
        return this.getEntityTexture((EntityGlobalVillager)p_110775_1_);
    }
    
    @Override
    protected void preRenderCallback(final EntityLivingBase p_77041_1_, final float p_77041_2_) {
        this.preRenderCallback((EntityGlobalVillager)p_77041_1_, p_77041_2_);
    }
    
    protected void preRenderCallback(final EntityGlobalVillager p_77041_1_, final float p_77041_2_) {
        super.preRenderCallback((EntityLivingBase)p_77041_1_, p_77041_2_);
        float f1 = 0.9375f;
        if (p_77041_1_.getGrowingAge() < 0) {
            f1 *= 0.5;
            this.shadowSize = 0.25f;
        }
        else {
            this.shadowSize = 0.5f;
        }
        GL11.glScalef(f1, f1, f1);
    }
    
    public void doRender(final EntityVillager p_76986_1_, final double p_76986_2_, final double p_76986_4_, final double p_76986_6_, final float p_76986_8_, final float p_76986_9_) {
        super.doRender((EntityLiving)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
    
    @Override
    public void doRender(final EntityLiving p_76986_1_, final double p_76986_2_, final double p_76986_4_, final double p_76986_6_, final float p_76986_8_, final float p_76986_9_) {
        this.doRender((EntityVillager)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
    
    @Override
    public void doRender(final EntityLivingBase p_76986_1_, final double p_76986_2_, final double p_76986_4_, final double p_76986_6_, final float p_76986_8_, final float p_76986_9_) {
        this.doRender((EntityVillager)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
    
    @Override
    public void doRender(final Entity p_76986_1_, final double p_76986_2_, final double p_76986_4_, final double p_76986_6_, final float p_76986_8_, final float p_76986_9_) {
        this.doRender((EntityVillager)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
    
    static {
        defaultTexture = new ResourceLocation("textures/entity/villager/villager.png");
    }
}
