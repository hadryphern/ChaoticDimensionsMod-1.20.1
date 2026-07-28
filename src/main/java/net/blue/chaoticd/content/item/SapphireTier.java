package net.blue.chaoticd.content.item;

import net.blue.chaoticd.content.ModItems;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

/** Shared material rules for every Sapphire tool and weapon. */
public final class SapphireTier implements Tier {
    public static final SapphireTier INSTANCE = new SapphireTier();

    private SapphireTier() {
    }

    @Override
    public int getUses() {
        return 2_031_000;
    }

    @Override
    public float getSpeed() {
        return 9_000.0F;
    }

    @Override
    public float getAttackDamageBonus() {
        return 4_000.0F;
    }

    @Override
    public int getLevel() {
        return 9;
    }

    @Override
    public int getEnchantmentValue() {
        return 15_000;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.of(ModItems.SAPPHIRE_GEM);
    }
}
