package net.blue.chaoticd.content.item;

import net.blue.chaoticd.ChaoticDimensions;
import net.blue.chaoticd.content.ModItems;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

/** Strong post-Netherite armor material used by the Emerald set. */
public enum EmeraldArmorMaterial implements ArmorMaterial {
    INSTANCE;

    private static final int DURABILITY_MULTIPLIER = 45;

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
            case BOOTS -> 4;
            case LEGGINGS -> 7;
            case CHESTPLATE -> 9;
            case HELMET -> 4;
        };
    }

    @Override
    public int getEnchantmentValue() {
        return 25;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ARMOR_EQUIP_DIAMOND;
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
        return 4.0F;
    }

    @Override
    public float getKnockbackResistance() {
        return 0.15F;
    }
}
