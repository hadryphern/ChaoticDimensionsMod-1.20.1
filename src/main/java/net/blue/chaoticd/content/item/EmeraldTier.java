package net.blue.chaoticd.content.item;

import net.blue.chaoticd.content.ModItems;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

/**
 * Tool tier representing the direct progression after Netherite.
 *
 * <p>The important material attributes are twice their Netherite equivalents:
 * 4062 durability, 18 mining speed, 8 attack bonus and 30 enchantability.</p>
 */
public enum EmeraldTier implements Tier {
    INSTANCE;

    @Override
    public int getUses() {
        return 4_062;
    }

    @Override
    public float getSpeed() {
        return 18.0F;
    }

    @Override
    public float getAttackDamageBonus() {
        return 8.0F;
    }

    @Override
    public int getLevel() {
        return 4;
    }

    @Override
    public int getEnchantmentValue() {
        return 30;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.of(ModItems.EMERALD_INGOT);
    }
}
