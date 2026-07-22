/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.DimensionSpecialEffects
 *  net.minecraft.client.renderer.DimensionSpecialEffects$SkyType
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.phys.Vec3
 *  net.minecraftforge.api.distmarker.Dist
 *  net.minecraftforge.api.distmarker.OnlyIn
 *  net.minecraftforge.client.event.RegisterDimensionSpecialEffectsEvent
 *  net.minecraftforge.eventbus.api.SubscribeEvent
 *  net.minecraftforge.fml.common.Mod$EventBusSubscriber
 *  net.minecraftforge.fml.common.Mod$EventBusSubscriber$Bus
 */
package net.mcreator.chaosentity.world.dimension;

import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RegisterDimensionSpecialEffectsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class CrystalDimensionPortalDimension {

    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class CrystalDimensionPortalSpecialEffectsHandler {
        @SubscribeEvent
        @OnlyIn(value=Dist.CLIENT)
        public static void registerDimensionSpecialEffects(RegisterDimensionSpecialEffectsEvent event) {
            DimensionSpecialEffects customEffect = new DimensionSpecialEffects(Float.NaN, true, DimensionSpecialEffects.SkyType.NONE, false, false){

                public Vec3 m_5927_(Vec3 color, float sunHeight) {
                    return color;
                }

                public boolean m_5781_(int x, int y) {
                    return false;
                }
            };
            event.register(new ResourceLocation("chaosentitymod:crystal_dimension_portal"), customEffect);
        }
    }
}

