//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package diversity.proxy;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry;
import diversity.client.render.entity.RenderApache;
import diversity.client.render.entity.RenderAztec;
import diversity.client.render.entity.RenderDarkSpider;
import diversity.client.render.entity.RenderDart;
import diversity.client.render.entity.RenderDwarf;
import diversity.client.render.entity.RenderEgyptian;
import diversity.client.render.entity.RenderInuit;
import diversity.client.render.entity.RenderLakeside;
import diversity.client.render.entity.RenderMummy;
import diversity.client.render.entity.RenderSettled;
import diversity.client.render.entity.RenderTibetan;
import diversity.client.render.entity.RenderTzitzimime;
import diversity.client.render.entity.RenderWarriorSkeleton;
import diversity.client.render.entity.RenderWorshipper;
import diversity.client.render.entity.RenderYeti;
import diversity.client.render.entity.RenderZulu;
import diversity.client.render.item.RenderBlowgun;
import diversity.client.render.item.RenderSpear;
import diversity.entity.EntityApache;
import diversity.entity.EntityAztec;
import diversity.entity.EntityDarkSpider;
import diversity.entity.EntityDart;
import diversity.entity.EntityDwarf;
import diversity.entity.EntityEgyptian;
import diversity.entity.EntityInuit;
import diversity.entity.EntityLakeside;
import diversity.entity.EntityMummy;
import diversity.entity.EntitySettled;
import diversity.entity.EntityTibetan;
import diversity.entity.EntityTzitzimime;
import diversity.entity.EntityWarriorSkeleton;
import diversity.entity.EntityWorshipper;
import diversity.entity.EntityYeti;
import diversity.entity.EntityZulu;
import diversity.item.ItemBlowgun;
import diversity.item.ItemSpear;
import diversity.suppliers.EnumEntity;
import diversity.suppliers.EnumItem;
import diversity.suppliers.EnumTribe;
import diversity.suppliers.EnumVillager;
import diversity.utils.ResourceTools;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.imageio.ImageIO;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.resources.IResource;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy extends ServerProxy {
    private static Map<Class, Class> map = new HashMap();

    public ClientProxy() {
    }

    @Override
    public void registerHandler() {
        this.handler = new ClientHandler();
        MinecraftForge.TERRAIN_GEN_BUS.register(this.handler);
        MinecraftForge.EVENT_BUS.register(this.handler);
    }

    @Override
    public void registerRenderers() {
        RenderingRegistry.registerEntityRenderingHandler(EntityApache.class, new RenderApache());
        RenderingRegistry.registerEntityRenderingHandler(EntityAztec.class, new RenderAztec());
        RenderingRegistry.registerEntityRenderingHandler(EntityInuit.class, new RenderInuit());
        RenderingRegistry.registerEntityRenderingHandler(EntityZulu.class, new RenderZulu());
        RenderingRegistry.registerEntityRenderingHandler(EntityTibetan.class, new RenderTibetan());
        RenderingRegistry.registerEntityRenderingHandler(EntityEgyptian.class, new RenderEgyptian());
        RenderingRegistry.registerEntityRenderingHandler(EntityLakeside.class, new RenderLakeside());
        RenderingRegistry.registerEntityRenderingHandler(EntitySettled.class, new RenderSettled());
        RenderingRegistry.registerEntityRenderingHandler(EntityMummy.class, new RenderMummy());
        RenderingRegistry.registerEntityRenderingHandler(EntityTzitzimime.class, new RenderTzitzimime());
        RenderingRegistry.registerEntityRenderingHandler(EntityWarriorSkeleton.class, new RenderWarriorSkeleton());
        RenderingRegistry.registerEntityRenderingHandler(EntityDart.class, new RenderDart());
        RenderingRegistry.registerEntityRenderingHandler(EntityWorshipper.class, new RenderWorshipper());
        RenderingRegistry.registerEntityRenderingHandler(EntityDarkSpider.class, new RenderDarkSpider());
        RenderingRegistry.registerEntityRenderingHandler(EntityYeti.class, new RenderYeti());
        RenderingRegistry.registerEntityRenderingHandler(EntityDwarf.class, new RenderDwarf());
    }

    @Override
    public Integer[] searchEggColor(EnumEntity entity) {
        int principalColor = 0;
        int secondColor = 16777215;
        ResourceLocation resource = ResourceTools.getResource(entity.entityClass);
        if (resource == null) {
            return new Integer[]{principalColor, secondColor};
        } else {
            InputStream inputstream = null;
            HashMap map = new HashMap();

            int secondCount;
            try {
                IResource iresource = Minecraft.getMinecraft().getResourceManager().getResource(resource);
                inputstream = iresource.getInputStream();
                BufferedImage bufferedimage = ImageIO.read(inputstream);

                for(secondCount = 0; secondCount < bufferedimage.getWidth(); ++secondCount) {
                    for(int y = 0; y < bufferedimage.getHeight(); ++y) {
                        int color = bufferedimage.getRGB(secondCount, y);
                        if ((color >> 24 & 255) != 0) {
                            if (map.containsKey(color)) {
                                map.put(color, (Integer)map.get(color) + 1);
                            } else {
                                map.put(color, 1);
                            }
                        }
                    }
                }
            } catch (IOException var20) {
                var20.printStackTrace();
            } finally {
                if (inputstream != null) {
                    try {
                        inputstream.close();
                    } catch (IOException var19) {
                        var19.printStackTrace();
                    }
                }

            }

            Collection<Integer> values = map.values();
            int principalCount = 0;
            secondCount = 0;
            Iterator var24 = map.keySet().iterator();

            while(var24.hasNext()) {
                Integer color = (Integer)var24.next();
                if ((Integer)map.get(color) > principalCount) {
                    principalCount = (Integer)map.get(color);
                    principalColor = color;
                }

                if ((Integer)map.get(color) >= secondCount && (Integer)map.get(color) != principalCount) {
                    int principal = principalColor >> 16 & 255 + (principalColor >> 8) & 255 + principalColor & 255;
                    int thisone = color >> 16 & 255 + (color >> 8) & 255 + color & 255;
                    if (Math.abs(principal - thisone) > 150) {
                        secondCount = (Integer)map.get(color);
                        secondColor = color;
                    }
                }
            }

            return new Integer[]{principalColor, secondColor};
        }
    }

    @Override
    public Integer[] searchEggColor(EnumTribe tribe) {
        int principalColor = 0;
        int secondColor = 16777215;
        InputStream inputstream = null;
        Map<Integer, Integer> map = new HashMap();
        Iterator var6 = tribe.villagers.iterator();

        while(true) {
            ResourceLocation resource;
            int x;
            int y;
            do {
                if (!var6.hasNext()) {
                    Collection<Integer> values = map.values();
                    int principalCount = 0;
                    int secondCount = 0;
                    Iterator var27 = map.keySet().iterator();

                    while(var27.hasNext()) {
                        Integer color = (Integer)var27.next();
                        if ((Integer)map.get(color) > principalCount) {
                            principalCount = (Integer)map.get(color);
                            principalColor = color;
                        }

                        if ((Integer)map.get(color) >= secondCount && (Integer)map.get(color) != principalCount) {
                            x = principalColor >> 16 & 255 + (principalColor >> 8) & 255 + principalColor & 255;
                            y = color >> 16 & 255 + (color >> 8) & 255 + color & 255;
                            if (Math.abs(x - y) > 150) {
                                secondCount = (Integer)map.get(color);
                                secondColor = color;
                            }
                        }
                    }

                    return new Integer[]{principalColor, secondColor};
                }

                EnumVillager villager = (EnumVillager)var6.next();
                resource = VillagerRegistry.getVillagerSkin(villager.profession, (ResourceLocation)null);
            } while(resource == null);

            try {
                IResource iresource = Minecraft.getMinecraft().getResourceManager().getResource(resource);
                inputstream = iresource.getInputStream();
                BufferedImage bufferedimage = ImageIO.read(inputstream);

                for(x = 0; x < bufferedimage.getWidth(); ++x) {
                    for(y = 0; y < bufferedimage.getHeight(); ++y) {
                        int color = bufferedimage.getRGB(x, y);
                        if ((color >> 24 & 255) != 0) {
                            if (map.containsKey(color)) {
                                map.put(color, (Integer)map.get(color) + 1);
                            } else {
                                map.put(color, 1);
                            }
                        }
                    }
                }
            } catch (IOException var22) {
                var22.printStackTrace();
            } finally {
                if (inputstream != null) {
                    try {
                        inputstream.close();
                    } catch (IOException var21) {
                        var21.printStackTrace();
                    }
                }

            }
        }
    }

    @Override
    public void registerItemRenderer(EnumItem item) {
        if (map.containsKey(item.item.getClass())) {
            try {
                MinecraftForgeClient.registerItemRenderer(item.item, (IItemRenderer)((Class)map.get(item.item.getClass())).getConstructor().newInstance());
            } catch (InstantiationException var3) {
                var3.printStackTrace();
            } catch (IllegalAccessException var4) {
                var4.printStackTrace();
            } catch (IllegalArgumentException var5) {
                var5.printStackTrace();
            } catch (InvocationTargetException var6) {
                var6.printStackTrace();
            } catch (NoSuchMethodException var7) {
                var7.printStackTrace();
            } catch (SecurityException var8) {
                var8.printStackTrace();
            }
        }

    }

    @Override
    public void registerVillagerSkin(EnumVillager villager) {
        ResourceLocation resource = new ResourceLocation("diversity", villager.resourcePath);
        VillagerRegistry.instance().registerVillagerSkin(villager.profession, resource);
    }

    @Override
    public void registerEntityResource(EnumEntity entity) {
        ResourceTools.register(entity.entityClass, entity.resourcePath);
    }

    @Override
    public String getI18format(EnumVillager villager) {
        return I18n.format("entity.diversity." + villager.tribe.name().toLowerCase() + '.' + villager.villagerName + ".name", new Object[0]);
    }

    static {
        map.put(ItemBlowgun.class, RenderBlowgun.class);
        map.put(ItemSpear.class, RenderSpear.class);
    }
}
