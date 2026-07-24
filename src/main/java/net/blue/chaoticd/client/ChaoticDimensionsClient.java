package net.blue.chaoticd.client;

import net.blue.chaoticd.client.entity.LegacyMobRenderer;
import net.blue.chaoticd.client.visual.AuroraVisuals;
import net.blue.chaoticd.client.visual.ShadowVisuals;
import net.blue.chaoticd.content.ModBlocks;
import net.blue.chaoticd.content.ModEntities;
import net.blue.chaoticd.content.ModFluids;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.renderer.RenderType;

public final class ChaoticDimensionsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        AuroraVisuals.initialize();
        ShadowVisuals.initialize();

        BlockRenderLayerMap.INSTANCE.putBlocks(
            RenderType.cutoutMipped(),
            ModBlocks.PASTEL_PINK_LEAVES,
            ModBlocks.PASTEL_PURPLE_LEAVES,
            ModBlocks.PASTEL_BLUE_LEAVES,
            ModBlocks.SHADOW_LEAVES,
            ModBlocks.CRYSTAL_LEAVES_1,
            ModBlocks.CRYSTAL_LEAVES_2,
            ModBlocks.CRYSTAL_LEAVES_3
        );

        BlockRenderLayerMap.INSTANCE.putBlocks(
            RenderType.cutout(),
            ModBlocks.CRYSTAL_RED_PLANT,
            ModBlocks.CRYSTAL_YELLOW_PLANT,
            ModBlocks.CRYSTAL_BLUE_PLANT,
            ModBlocks.CRYSTAL_GREEN_PLANT
        );

        BlockRenderLayerMap.INSTANCE.putFluids(
            RenderType.translucent(),
            ModFluids.DREAM_FLUID,
            ModFluids.FLOWING_DREAM_FLUID
        );

        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.DREAM_FLUID, new DreamFluidRenderHandler());
        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.FLOWING_DREAM_FLUID, new DreamFluidRenderHandler());

        EntityRendererRegistry.register(
            ModEntities.DIMENSION_PIG,
            context -> new LegacyMobRenderer<>(context)
        );
        EntityRendererRegistry.register(
            ModEntities.GOLD_DIMENSION_PIG,
            context -> new LegacyMobRenderer<>(context)
        );
        EntityRendererRegistry.register(
            ModEntities.APPLE_COW,
            context -> new LegacyMobRenderer<>(context)
        );
        EntityRendererRegistry.register(
            ModEntities.GOLDEN_APPLE_COW,
            context -> new LegacyMobRenderer<>(context)
        );
        EntityRendererRegistry.register(
            ModEntities.CRYSTAL_APPLE_COW,
            context -> new LegacyMobRenderer<>(context)
        );
        EntityRendererRegistry.register(
            ModEntities.CRYSTAL_GOLDEN_APPLE,
            context -> new LegacyMobRenderer<>(context)
        );
        EntityRendererRegistry.register(
            ModEntities.CRYSTAL_CREEPER,
            context -> new LegacyMobRenderer<>(context)
        );
    }
}