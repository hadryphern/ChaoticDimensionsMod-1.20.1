package net.blue.chaoticd;

import net.blue.chaoticd.content.ModBlocks;
import net.blue.chaoticd.content.ModEffects;
import net.blue.chaoticd.content.ModEnchantments;
import net.blue.chaoticd.content.ModFluids;
import net.blue.chaoticd.content.ModGameplayEvents;
import net.blue.chaoticd.content.ModItemGroups;
import net.blue.chaoticd.content.ModItems;
import net.blue.chaoticd.content.ModPotions;
import net.blue.chaoticd.content.ModRecipes;
import net.blue.chaoticd.gameplay.ChaoticGearInitialization;
import net.blue.chaoticd.gameplay.DreamFluidSystems;
import net.blue.chaoticd.gameplay.EmeraldLuckSystems;
import net.blue.chaoticd.rarity.ModRarities;
import net.blue.chaoticd.worldgen.AuroraAquaticLife;
import net.blue.chaoticd.worldgen.ModWorldgenFeatures;
import net.blue.chaoticd.worldgen.ShadowDimensionSystems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Main Fabric entry point for Chaotic Dimensions content and gameplay systems. */
public final class ChaoticDimensions implements ModInitializer {
    public static final String MOD_ID = "chaoticd";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ModEnchantments.initialize();
        ModEffects.initialize();
        ModFluids.initialize();
        ModItems.initialize();
        ModBlocks.initialize();
        ModWorldgenFeatures.initialize();

        AuroraAquaticLife.initialize();
        ShadowDimensionSystems.initialize();
        DreamFluidSystems.initialize();
        ChaoticGearInitialization.initialize();
        EmeraldLuckSystems.initialize();

        ModPotions.initialize();
        ModRarities.bootstrap();
        ModItemGroups.initialize();
        ModRecipes.initialize();
        ModGameplayEvents.initialize();

        LOGGER.info(
            "Chaotic Dimensions, Aurora, Shadow, Dream Fluid and Emerald progression systems loaded"
        );
    }
}
