package net.blue.chaoticd.content.item;

import net.blue.chaoticd.content.ModItems;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

/** Tool tier used by the transformed Emerald equipment set. */
public enum EmeraldTier implements Tier {
    INSTANCE;

    @Override
    public int getUses() {
        return 2_500;
    }

    @Override
    public float getSpeed() {
        return 10.0F;
    }

    @Override
    public float getAttackDamageBonus() {
        return 5.0F;
    }

    @Override
    public int getLevel() {
        return 4;
    }

    @Override
    public int getEnchantmentValue() {
        return 25;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.of(ModItems.EMERALD_INGOT);
    }
}
