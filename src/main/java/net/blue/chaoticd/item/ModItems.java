package net.blue.chaoticd.item;

import net.blue.chaoticd.ChaoticDimensions;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    //All ChaoticDimensions items
    public static final Item ROSALITA_GEM =registerItem("rosalita_gem", new Item(new FabricItemSettings()));
    public static final Item ALUMINIUM_INGOT =registerItem("aluminium_ingot", new Item(new FabricItemSettings()));
    public static final Item CHLOROPHYTE_INGOT =registerItem("chlorophyte_ingot", new Item(new FabricItemSettings()));
    public static final Item HERO_GEM =registerItem("hero_gem", new Item(new FabricItemSettings()));
    public static final Item RUBY =registerItem("ruby", new Item(new FabricItemSettings()));
    public static final Item LAVA_INGOT =registerItem("lava_ingot", new Item(new FabricItemSettings()));
    public static final Item WATER_INGOT =registerItem("water_ingot", new Item(new FabricItemSettings()));
    public static final Item SHADOW_GEM =registerItem("shadow_gem", new Item(new FabricItemSettings()));
    public static final Item SHADOW_NUGGET =registerItem("shadow_nugget", new Item(new FabricItemSettings()));
    public static final Item SUN_TEAR =registerItem("sun_tear", new Item(new FabricItemSettings()));
    public static final Item TITANIUM_INGOT =registerItem("titanium_ingot", new Item(new FabricItemSettings()));
    public static final Item VORTEX_GEM =registerItem("vortex_gem", new Item(new FabricItemSettings()));
    public static final Item VYLAM_GEM =registerItem("vylam_gem", new Item(new FabricItemSettings()));
    public static final Item GOLD_SPECIAL_APPLE =registerItem("gold_especial_apple", new Item(new FabricItemSettings()));
    public static final Item ENTERALDA =registerItem("enteralda", new Item(new FabricItemSettings()));
    public static final Item DIMENSION_APPLE =registerItem("dimension_apple", new Item(new FabricItemSettings()));
    public static final Item DERMAN_GEM =registerItem("derman_gem", new Item(new FabricItemSettings()));
    public static final Item BEDROCK_STICK =registerItem("bedrock_stick", new Item(new FabricItemSettings()));

    //Ruby Items

    //Emerald Items

    //Chlorophyte Items

    //Titanium Items

    //Aluminium Items

    //Lava Items

    //Shadow Items

    //Hero Items

    //Vylam Items

    //Vortex Items

    //Derman Items

    //Water Items

    //Rosalita Items


    //Registering Items in ItemGroups vanilla
    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
        ;
    }

    //---------------------------------------------------------------------------------------------------------------//

    //RegistersItems and RegisterGroups
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(ChaoticDimensions.MOD_ID, name), item);
    }
    public static void registerModItems() {
        ChaoticDimensions.LOGGER.info("Registering Mod Items for " + ChaoticDimensions.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(ModItems::addItemsToIngredientItemGroup);
    }
}
