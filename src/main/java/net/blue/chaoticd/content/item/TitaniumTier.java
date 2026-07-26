package net.blue.chaoticd.content.item;

import net.blue.chaoticd.content.ModItems;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

/** Titanium is the requested three-times-Ruby tool material. */
public enum TitaniumTier implements Tier {
    INSTANCE;

    @Override
    public int getUses() {
        return 24_372;
    }

    @Override
    public float getSpeed() {
        return 108.0F;
    }

    @Override
    public float getAttackDamageBonus() {
        return 48.0F;
    }

    @Override
    public int getLevel() {
        return 6;
    }

    @Override
    public int getEnchantmentValue() {
        return 90;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.of(ModItems.TITANIUM_INGOT);
    }
}
