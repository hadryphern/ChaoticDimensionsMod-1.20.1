package net.blue.chaoticd.content;

import net.blue.chaoticd.ChaoticDimensions;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.material.Fluid;

/** Central tag keys used by code-backed Chaotic Dimensions systems. */
public final class ModTags {
    public static final TagKey<Fluid> DREAM_FLUID = TagKey.create(
        Registries.FLUID,
        new ResourceLocation(ChaoticDimensions.MOD_ID, "dream_fluid")
    );

    private ModTags() {
    }
}
