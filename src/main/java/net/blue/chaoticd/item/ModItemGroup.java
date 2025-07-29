package net.blue.chaoticd.item;

import net.blue.chaoticd.ChaoticDimensions;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {

    //Chaotic Dimensions Ores ItemGroup
    public static final ItemGroup CHAOTIC_ORES = Registry.register(Registries.ITEM_GROUP,
            new Identifier(ChaoticDimensions.MOD_ID, "shadow_gem1"),
            FabricItemGroup.builder().displayName(Text.translatable("chaoticd_ores"))
                    .icon(() -> new ItemStack(ModItems.SHADOW_GEM)).entries((displayContext, entries) -> {

                        entries.add(ModItems.RUBY);
                        entries.add(ModItems.ALUMINIUM_INGOT);
                        entries.add(ModItems.TITANIUM_INGOT);
                        entries.add(ModItems.ROSALITA_GEM);
                        entries.add(ModItems.CHLOROPHYTE_INGOT);
                        entries.add(ModItems.LAVA_INGOT);
                        entries.add(ModItems.WATER_INGOT);
                        entries.add(ModItems.SHADOW_GEM);
                        entries.add(ModItems.SHADOW_NUGGET);
                        entries.add(ModItems.ENTERALDA);
                        entries.add(ModItems.DERMAN_GEM);
                        entries.add(ModItems.SUN_TEAR);
                        entries.add(ModItems.VYLAM_GEM);
                        entries.add(ModItems.VORTEX_GEM);
                        entries.add(ModItems.HERO_GEM);

                    }).build());

    //Utility Chaotic Items Group
    public static final ItemGroup CHAOTIC_ITEMS = Registry.register(Registries.ITEM_GROUP,
            new Identifier(ChaoticDimensions.MOD_ID, "shadow_gem2"),
            FabricItemGroup.builder().displayName(Text.translatable("chaoticd_items"))
                    .icon(() -> new ItemStack(ModItems.DIMENSION_APPLE)).entries((displayContext, entries) -> {

                        entries.add(ModItems.GOLD_SPECIAL_APPLE);
                        entries.add(ModItems.DIMENSION_APPLE);
                        entries.add(ModItems.BEDROCK_STICK);

                    }).build());

    //Chaotic Dimensions Armors Group
    public static final ItemGroup CHAOTIC_ARMORS = Registry.register(Registries.ITEM_GROUP,
            new Identifier(ChaoticDimensions.MOD_ID, "hero_gem"),
            FabricItemGroup.builder().displayName(Text.translatable("chaoticd_armors"))
                    .icon(() -> new ItemStack(ModItems.RUBY)).entries((displayContext, entries) -> {



                    }).build());

    public static void registerItemGroups() {
        ChaoticDimensions.LOGGER.info("Registering Item Groups for " + ChaoticDimensions.MOD_ID);
    }

}
