package net.blue.chaoticd.content.item;

import net.blue.chaoticd.content.ModItems;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

/** Tool material that is exactly four times the Netherite material attributes. */
public enum RubyTier implements Tier {
    INSTANCE;

    @Override
    public int getUses() {
        return 8_124;
    }

    @Override
    public float getSpeed() {
        return 36.0F;
    }

    @Override
    public float getAttackDamageBonus() {
        return 16.0F;
    }

    @Override
    public int getLevel() {
        // Ruby opens the Jaxy harvest gate.
        return 6;
    }

    @Override
    public int getEnchantmentValue() {
        return 60;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.of(ModItems.RUBY);
    }
}
