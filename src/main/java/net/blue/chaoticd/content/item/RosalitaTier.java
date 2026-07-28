package net.blue.chaoticd.content.item;

import net.blue.chaoticd.content.ModItems;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

/**
 * Rosalita is intentionally unavailable through the current direct Smithing
 * chain: the planned ten intermediary progressions remain required.  Its
 * values are nevertheless registered now so creative/testing stacks are
 * consistent with the announced one-hundred-times material tier.
 */
public enum RosalitaTier implements Tier {
    INSTANCE;

    @Override
    public int getUses() {
        return 203_100;
    }

    @Override
    public float getSpeed() {
        return 900.0F;
    }

    @Override
    public float getAttackDamageBonus() {
        return 400.0F;
    }

    @Override
    public int getLevel() {
        return 8;
    }

    @Override
    public int getEnchantmentValue() {
        return 1_500;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.of(ModItems.ROSALITA_GEM);
    }
}
