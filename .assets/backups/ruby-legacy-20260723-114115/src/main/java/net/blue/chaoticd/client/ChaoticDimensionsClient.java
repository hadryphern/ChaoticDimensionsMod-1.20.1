package net.blue.chaoticd.client;

import net.blue.chaoticd.client.visual.AuroraVisuals;
import net.blue.chaoticd.client.visual.ShadowVisuals;
import net.blue.chaoticd.content.ModBlocks;
import net.blue.chaoticd.content.ModFluids;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.minecraft.client.renderer.RenderType;

/** Registers visual behavior that must never be loaded on a dedicated server. */
public final class ChaoticDimensionsClient
    implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        SapphiricVisuals.initialize();
        AuroraVisuals.initialize();
        ShadowVisuals.initialize();

        BlockRenderLayerMap.INSTANCE.putBlocks(
            RenderType.cutoutMipped(),
            ModBlocks.PASTEL_PINK_LEAVES,
            ModBlocks.PASTEL_PURPLE_LEAVES,
            ModBlocks.PASTEL_BLUE_LEAVES,
            ModBlocks.SHADOW_LEAVES
        );

        DreamFluidRenderHandler dreamRenderer =
            new DreamFluidRenderHandler();

        FluidRenderHandlerRegistry.INSTANCE.register(
            ModFluids.DREAM_FLUID,
            ModFluids.FLOWING_DREAM_FLUID,
            dreamRenderer
        );

        BlockRenderLayerMap.INSTANCE.putFluids(
            RenderType.translucent(),
            ModFluids.DREAM_FLUID,
            ModFluids.FLOWING_DREAM_FLUID
        );
    }
}
