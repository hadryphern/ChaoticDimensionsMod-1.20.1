package net.blue.chaoticd.content;

import java.util.Map;
import net.blue.chaoticd.ChaoticDimensions;
import net.blue.chaoticd.content.item.ChaoticAppleItem;
import net.blue.chaoticd.content.item.DeathTotemItem;
import net.blue.chaoticd.content.item.EmeraldArmorMaterial;
import net.blue.chaoticd.content.item.EmeraldTier;
import net.blue.chaoticd.content.item.SapphireSwordItem;
import net.blue.chaoticd.content.item.SapphireTier;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;

/** Items belonging to Chaotic Dimensions progression. */
public final class ModItems {
    public static final Item SAPPHIRE_GEM = register(
        "sapphire_gem",
        new Item(new Item.Properties())
    );

    public static final Item SAPPHIRE_SWORD = register(
        "sapphire_sword",
        new SapphireSwordItem(new Item.Properties())
    );

    public static final Item SAPPHIRE_PICKAXE = register(
        "sapphire_pickaxe",
        new PickaxeItem(
            SapphireTier.INSTANCE,
            1,
            -2.8F,
            new Item.Properties()
        )
    );

    public static final Item SAPPHIRE_AXE = register(
        "sapphire_axe",
        new AxeItem(
            SapphireTier.INSTANCE,
            7.0F,
            -3.0F,
            new Item.Properties()
        )
    );

    public static final Item SAPPHIRE_SHOVEL = register(
        "sapphire_shovel",
        new ShovelItem(
            SapphireTier.INSTANCE,
            1.5F,
            -3.0F,
            new Item.Properties()
        )
    );

    public static final Item SAPPHIRE_HOE = register(
        "sapphire_hoe",
        new HoeItem(
            SapphireTier.INSTANCE,
            -2,
            -1.0F,
            new Item.Properties()
        )
    );

    public static final Item CHAOTIC_APPLE = register(
        "chaotic_apple",
        new ChaoticAppleItem(
            new Item.Properties().food(
                new FoodProperties.Builder()
                    .nutrition(8)
                    .saturationMod(1.2F)
                    .alwaysEat()
                    .build()
            )
        )
    );

    public static final Item DEATH_TOTEM = register(
        "death_totem",
        new DeathTotemItem(
            new Item.Properties()
                .stacksTo(1)
                .fireResistant()
                .rarity(Rarity.EPIC)
        )
    );

    public static final Item EMERALD_INGOT = register(
        "emerald_ingot",
        new Item(new Item.Properties().rarity(Rarity.RARE))
    );

    public static final Item DREAM_FLUID_BUCKET = register(
        "dream_fluid_bucket",
        new BucketItem(
            ModFluids.DREAM_FLUID,
            new Item.Properties()
                .craftRemainder(Items.BUCKET)
                .stacksTo(1)
                .rarity(Rarity.EPIC)
        )
    );

    public static final Item EMERALD_SWORD = register(
        "emerald_sword",
        new SwordItem(
            EmeraldTier.INSTANCE,
            4,
            -2.4F,
            new Item.Properties().rarity(Rarity.EPIC)
        )
    );

    public static final Item EMERALD_PICKAXE = register(
        "emerald_pickaxe",
        new PickaxeItem(
            EmeraldTier.INSTANCE,
            2,
            -2.8F,
            new Item.Properties().rarity(Rarity.EPIC)
        )
    );

    public static final Item EMERALD_AXE = register(
        "emerald_axe",
        new AxeItem(
            EmeraldTier.INSTANCE,
            7.0F,
            -3.0F,
            new Item.Properties().rarity(Rarity.EPIC)
        )
    );

    public static final Item EMERALD_SHOVEL = register(
        "emerald_shovel",
        new ShovelItem(
            EmeraldTier.INSTANCE,
            2.0F,
            -3.0F,
            new Item.Properties().rarity(Rarity.EPIC)
        )
    );

    public static final Item EMERALD_HOE = register(
        "emerald_hoe",
        new HoeItem(
            EmeraldTier.INSTANCE,
            -3,
            0.0F,
            new Item.Properties().rarity(Rarity.EPIC)
        )
    );

    public static final Item EMERALD_HELMET = register(
        "emerald_helmet",
        new ArmorItem(
            EmeraldArmorMaterial.INSTANCE,
            ArmorItem.Type.HELMET,
            new Item.Properties().rarity(Rarity.EPIC)
        )
    );

    public static final Item EMERALD_CHESTPLATE = register(
        "emerald_chestplate",
        new ArmorItem(
            EmeraldArmorMaterial.INSTANCE,
            ArmorItem.Type.CHESTPLATE,
            new Item.Properties().rarity(Rarity.EPIC)
        )
    );

    public static final Item EMERALD_LEGGINGS = register(
        "emerald_leggings",
        new ArmorItem(
            EmeraldArmorMaterial.INSTANCE,
            ArmorItem.Type.LEGGINGS,
            new Item.Properties().rarity(Rarity.EPIC)
        )
    );

    public static final Item EMERALD_BOOTS = register(
        "emerald_boots",
        new ArmorItem(
            EmeraldArmorMaterial.INSTANCE,
            ArmorItem.Type.BOOTS,
            new Item.Properties().rarity(Rarity.EPIC)
        )
    );

    private ModItems() {
    }

    private static Item register(String id, Item item) {
        return Registry.register(
            BuiltInRegistries.ITEM,
            new ResourceLocation(ChaoticDimensions.MOD_ID, id),
            item
        );
    }

    /**
     * Canonical Sapphire Sword stack used after it actually enters a player's
     * inventory. Creative tabs intentionally use the raw item instead.
     */
    public static ItemStack createSapphireSword() {
        ItemStack result = new ItemStack(SAPPHIRE_SWORD);

        EnchantmentHelper.setEnchantments(
            Map.of(
                ModEnchantments.SAPPHIRIC, 1,
                ModEnchantments.DHEATHIC, 1
            ),
            result
        );

        return result;
    }

    public static ItemStack createSapphireTool(SapphireToolType type) {
        ItemStack result = new ItemStack(type.item());

        Map<net.minecraft.world.item.enchantment.Enchantment, Integer> enchantments =
            switch (type) {
                case PICKAXE -> Map.of(
                    Enchantments.BLOCK_FORTUNE, 50,
                    Enchantments.BLOCK_EFFICIENCY, 50,
                    Enchantments.UNBREAKING, 50
                );
                case AXE -> Map.of(
                    Enchantments.BLOCK_FORTUNE, 50,
                    Enchantments.BLOCK_EFFICIENCY, 50,
                    Enchantments.UNBREAKING, 50,
                    Enchantments.SHARPNESS, 50
                );
                case SHOVEL, HOE -> Map.of(
                    Enchantments.BLOCK_EFFICIENCY, 50,
                    Enchantments.UNBREAKING, 50
                );
            };

        EnchantmentHelper.setEnchantments(enchantments, result);
        return result;
    }

    public static boolean isSapphireGear(ItemStack stack) {
        return stack.is(SAPPHIRE_SWORD)
            || stack.is(SAPPHIRE_PICKAXE)
            || stack.is(SAPPHIRE_AXE)
            || stack.is(SAPPHIRE_SHOVEL)
            || stack.is(SAPPHIRE_HOE);
    }

    public static boolean isEmeraldGear(ItemStack stack) {
        return stack.is(EMERALD_SWORD)
            || stack.is(EMERALD_PICKAXE)
            || stack.is(EMERALD_AXE)
            || stack.is(EMERALD_SHOVEL)
            || stack.is(EMERALD_HOE)
            || stack.is(EMERALD_HELMET)
            || stack.is(EMERALD_CHESTPLATE)
            || stack.is(EMERALD_LEGGINGS)
            || stack.is(EMERALD_BOOTS);
    }

    public static boolean isEmeraldArmor(ItemStack stack) {
        return stack.is(EMERALD_HELMET)
            || stack.is(EMERALD_CHESTPLATE)
            || stack.is(EMERALD_LEGGINGS)
            || stack.is(EMERALD_BOOTS);
    }

    public enum SapphireToolType {
        PICKAXE(SAPPHIRE_PICKAXE),
        AXE(SAPPHIRE_AXE),
        SHOVEL(SAPPHIRE_SHOVEL),
        HOE(SAPPHIRE_HOE);

        private final Item item;

        SapphireToolType(Item item) {
            this.item = item;
        }

        public Item item() {
            return item;
        }
    }

    public static void initialize() {
        // Static fields perform registry insertion.
    }
}
