package net.blue.chaoticd.content.item;

import net.blue.chaoticd.ChaoticDimensions;
import net.blue.chaoticd.content.ModItems;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

/** One-hundred-times-Netherite material for the future-gated Rosalita stage. */
public enum RosalitaArmorMaterial implements ArmorMaterial {
    INSTANCE;

    private static final int DURABILITY_MULTIPLIER = 3_700;

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
            case BOOTS -> 300;
            case LEGGINGS -> 600;
            case CHESTPLATE -> 800;
            case HELMET -> 300;
        };
    }

    @Override
    public int getEnchantmentValue() {
        return 1_500;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ARMOR_EQUIP_NETHERITE;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.of(ModItems.ROSALITA_GEM);
    }

    @Override
    public String getName() {
        return ChaoticDimensions.MOD_ID + ":rosalita";
    }

    @Override
    public float getToughness() {
        return 300.0F;
    }

    @Override
    public float getKnockbackResistance() {
        return 10.0F;
    }
}
