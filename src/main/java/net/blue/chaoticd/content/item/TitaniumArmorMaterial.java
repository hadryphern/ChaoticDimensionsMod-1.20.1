package net.blue.chaoticd.content.item;

import net.blue.chaoticd.ChaoticDimensions;
import net.blue.chaoticd.content.ModItems;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

/**
 * Titanium is the direct three-times-Ruby armor upgrade.
 *
 * <p>Its durability, defense, enchantability, toughness and knockback
 * resistance intentionally follow the requested endgame-scale progression.
 * Minecraft's normal armor-damage formula still applies, so this material is
 * powerful without bypassing the game's protection calculations.</p>
 */
public enum TitaniumArmorMaterial implements ArmorMaterial {
    INSTANCE;

    private static final int DURABILITY_MULTIPLIER = 444;

    @Override
    public int getDurabilityForType(ArmorItem.Type type) {
        return switch (type) {
            case BOOTS -> 13 * DURABILITY_MULTIPLIER;
            case LEGGINGS -> 15 * DURABILITY_MULTIPLIER;
            case CHESTPLATE -> 16 * DURABILITY_MULTIPLIER;
            case HELMET -> 11 * DURABILITY_MULTIPLIER;
        };
    }

    @Override
    public int getDefenseForType(ArmorItem.Type type) {
        return switch (type) {
            case BOOTS -> 36;
            case LEGGINGS -> 72;
            case CHESTPLATE -> 96;
            case HELMET -> 36;
        };
    }

    @Override
    public int getEnchantmentValue() {
        return 90;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ARMOR_EQUIP_NETHERITE;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.of(ModItems.TITANIUM_INGOT);
    }

    @Override
    public String getName() {
        return ChaoticDimensions.MOD_ID + ":titanium";
    }

    @Override
    public float getToughness() {
        return 36.0F;
    }

    @Override
    public float getKnockbackResistance() {
        return 1.2F;
    }
}
