package net.blue.chaoticd.datagen;

import net.blue.chaoticd.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

        itemModelGenerator.register(ModItems.ALUMINIUM_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.TITANIUM_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.BEDROCK_STICK, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SHADOW_GEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.SHADOW_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ModItems.SUN_TEAR, Models.GENERATED);
        itemModelGenerator.register(ModItems.ROSALITA_GEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.DERMAN_GEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.ENTERALDA, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHLOROPHYTE_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.HERO_GEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.RUBY, Models.GENERATED);
        itemModelGenerator.register(ModItems.LAVA_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.WATER_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.VORTEX_GEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.VYLAM_GEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.GOLD_SPECIAL_APPLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.DIMENSION_APPLE, Models.GENERATED);

    }
}
