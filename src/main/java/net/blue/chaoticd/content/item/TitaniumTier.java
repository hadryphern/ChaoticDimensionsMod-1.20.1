package net.blue.chaoticd.content.item;

import net.blue.chaoticd.content.ModItems;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

/** Titanium follows Jaxy at forty times Netherite's baseline tool attributes. */
public enum TitaniumTier implements Tier {
    INSTANCE;

    @Override
    public int getUses() {
        return 81_240;
    }

    @Override
    public float getSpeed() {
        return 360.0F;
    }

    @Override
    public float getAttackDamageBonus() {
        return 160.0F;
    }

    @Override
    public int getLevel() {
        // Jaxy is the first tier that can mine Titanium; Rosalita remains a
        // separate, future-gated level-8 harvest target.
        return 7;
    }

    @Override
    public int getEnchantmentValue() {
        return 600;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.of(ModItems.TITANIUM_INGOT);
    }
}
