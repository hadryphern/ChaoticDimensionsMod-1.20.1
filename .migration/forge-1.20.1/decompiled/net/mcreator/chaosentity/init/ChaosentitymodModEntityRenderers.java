/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.entity.EntityType
 *  net.minecraftforge.api.distmarker.Dist
 *  net.minecraftforge.client.event.EntityRenderersEvent$RegisterRenderers
 *  net.minecraftforge.eventbus.api.SubscribeEvent
 *  net.minecraftforge.fml.common.Mod$EventBusSubscriber
 *  net.minecraftforge.fml.common.Mod$EventBusSubscriber$Bus
 */
package net.mcreator.chaosentity.init;

import net.mcreator.chaosentity.client.renderer.AppleCowRenderer;
import net.mcreator.chaosentity.client.renderer.CrystalAppleCowRenderer;
import net.mcreator.chaosentity.client.renderer.CrystalCreeperRenderer;
import net.mcreator.chaosentity.client.renderer.CrystalGoldenAppleRenderer;
import net.mcreator.chaosentity.client.renderer.DimensionPigRenderer;
import net.mcreator.chaosentity.client.renderer.GoldDimensionPigRenderer;
import net.mcreator.chaosentity.client.renderer.GoldenAppleCowRenderer;
import net.mcreator.chaosentity.init.ChaosentitymodModEntities;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD, value={Dist.CLIENT})
public class ChaosentitymodModEntityRenderers {
    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer((EntityType)ChaosentitymodModEntities.DIMENSION_PIG.get(), DimensionPigRenderer::new);
        event.registerEntityRenderer((EntityType)ChaosentitymodModEntities.GOLD_DIMENSION_PIG.get(), GoldDimensionPigRenderer::new);
        event.registerEntityRenderer((EntityType)ChaosentitymodModEntities.APPLE_COW.get(), AppleCowRenderer::new);
        event.registerEntityRenderer((EntityType)ChaosentitymodModEntities.GOLDEN_APPLE_COW.get(), GoldenAppleCowRenderer::new);
        event.registerEntityRenderer((EntityType)ChaosentitymodModEntities.CRYSTAL_CREEPER.get(), CrystalCreeperRenderer::new);
        event.registerEntityRenderer((EntityType)ChaosentitymodModEntities.CRYSTAL_APPLE_COW.get(), CrystalAppleCowRenderer::new);
        event.registerEntityRenderer((EntityType)ChaosentitymodModEntities.CRYSTAL_GOLDEN_APPLE.get(), CrystalGoldenAppleRenderer::new);
    }
}

