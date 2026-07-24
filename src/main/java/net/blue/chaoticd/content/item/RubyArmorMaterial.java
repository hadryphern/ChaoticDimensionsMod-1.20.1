package net.blue.chaoticd.content.item;

import net.blue.chaoticd.ChaoticDimensions;
import net.blue.chaoticd.content.ModItems;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

/** Armor material with twice every base Emerald armor attribute. */
public enum RubyArmorMaterial implements ArmorMaterial {
    INSTANCE;

    private static final int DURABILITY_MULTIPLIER = 148;

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
            case BOOTS -> 12;
            case LEGGINGS -> 24;
            case CHESTPLATE -> 32;
            case HELMET -> 12;
        };
    }

    @Override
    public int getEnchantmentValue() {
        return 60;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ARMOR_EQUIP_NETHERITE;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.of(ModItems.RUBY);
    }

    @Override
    public String getName() {
        return ChaoticDimensions.MOD_ID + ":ruby";
    }

    @Override
    public float getToughness() {
        return 12.0F;
    }

    @Override
    public float getKnockbackResistance() {
        return 0.40F;
    }
}
