package net.blue.chaoticd.worldgen;

import net.blue.chaoticd.ChaoticDimensions;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

/** Adds only the requested extremely rare Ruby ore to Overworld terrain. */
public final class LegacyWorldgen {
    private static final ResourceKey<PlacedFeature> RUBY_ORE = ResourceKey.create(
        Registries.PLACED_FEATURE,
        new ResourceLocation(ChaoticDimensions.MOD_ID, "ruby_ore")
    );

    private LegacyWorldgen() {
    }

    public static void initialize() {
        BiomeModifications.addFeature(
            BiomeSelectors.foundInOverworld(),
            GenerationStep.Decoration.UNDERGROUND_ORES,
            RUBY_ORE
        );
    }
}
