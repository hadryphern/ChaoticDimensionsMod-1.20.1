package net.blue.chaoticd.content.item;

import net.blue.chaoticd.ChaoticDimensions;
import net.blue.chaoticd.content.ModItems;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

/**
 * Armor material representing the direct progression after Netherite.
 *
 * <p>The base material values are configured at twice the equivalent
 * Netherite values:</p>
 *
 * <ul>
 *     <li>Twice the durability multiplier: 74 instead of 37.</li>
 *     <li>Twice the armor points for every piece.</li>
 *     <li>Twice the toughness: 6 instead of 3.</li>
 *     <li>Twice the knockback resistance: 0.20 instead of 0.10.</li>
 *     <li>Twice the enchantability: 30 instead of 15.</li>
 * </ul>
 */
public enum EmeraldArmorMaterial implements ArmorMaterial {
    INSTANCE;

    private static final int DURABILITY_MULTIPLIER = 74;

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
            case BOOTS -> 6;
            case LEGGINGS -> 12;
            case CHESTPLATE -> 16;
            case HELMET -> 6;
        };
    }

    @Override
    public int getEnchantmentValue() {
        return 30;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ARMOR_EQUIP_NETHERITE;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.of(ModItems.EMERALD_INGOT);
    }

    @Override
    public String getName() {
        return ChaoticDimensions.MOD_ID + ":emerald";
    }

    @Override
    public float getToughness() {
        return 6.0F;
    }

    @Override
    public float getKnockbackResistance() {
        return 0.20F;
    }
}
