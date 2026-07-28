package net.blue.chaoticd.content.item;

import net.blue.chaoticd.content.ModItems;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

/**
 * Jaxy is the material after Ruby: eight times the baseline Netherite tool
 * attributes, while remaining below Titanium in harvest level.
 */
public enum JaxyTier implements Tier {
    INSTANCE;

    @Override
    public int getUses() {
        return 16_248;
    }

    @Override
    public float getSpeed() {
        return 72.0F;
    }

    @Override
    public float getAttackDamageBonus() {
        return 32.0F;
    }

    @Override
    public int getLevel() {
        return 7;
    }

    @Override
    public int getEnchantmentValue() {
        return 120;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.of(ModItems.JAXY_GEM);
    }
}
