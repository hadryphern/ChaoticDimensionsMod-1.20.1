package net.blue.chaoticd.content.item;

import java.util.function.Supplier;
import net.blue.chaoticd.content.ModItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

/**
 * Tier definitions for the new assets that have a known tool form.
 *
 * <p>The established post-Netherite tiers in this project are expressed as a
 * multiplier of the Netherite {@link Tier} values (2× Emerald, 4× Ruby, 8×
 * Jaxy, 40× Titanium, 100× Rosalita and 1000× Sapphire). Shadow is an
 * alternate-dimension branch in the Jaxy band.
 *
 * <p>The new official list places Vylam, Chlorophyte, Hero, Derman and Vortex
 * between Titanium and Rosalita, but its repeated “5×” labels do not specify
 * whether they are cumulative or relative values. Applying all of them
 * cumulatively would put Chlorophyte and Hero above the already released
 * Rosalita/Sapphire tiers, and would make later values unsafe. To preserve
 * existing saves and the established upper bounds, the currently usable
 * entries occupy monotonic compatibility slots: Vylam is reserved at 45×,
 * Chlorophyte is 50×, Hero is 60×, Derman is reserved at 70× and Vortex at
 * 85×. Rosalita and Sapphire remain unchanged at 100× and 1000×. This table
 * is deliberately centralized here until a complete, explicit rebalance of
 * every released material is requested.</p>
 */
public enum FutureProgressionTier implements Tier {
    SHADOW(8, 7, () -> ModItems.SHADOW_GEM),
    CHLOROPHYTE(50, 8, () -> ModItems.CHLOROPHYTE_INGOT),
    HERO(60, 9, () -> ModItems.HERO_GEM);

    private static final int NETHERITE_USES = 2_031;
    private static final float NETHERITE_SPEED = 9.0F;
    private static final float NETHERITE_ATTACK_BONUS = 4.0F;
    private static final int NETHERITE_ENCHANTABILITY = 15;

    private final int uses;
    private final float speed;
    private final float attackDamageBonus;
    private final int harvestLevel;
    private final int enchantability;
    private final Supplier<Item> repairItem;

    FutureProgressionTier(
        int multiplier,
        int harvestLevel,
        Supplier<Item> repairItem
    ) {
        this.uses = Math.multiplyExact(NETHERITE_USES, multiplier);
        this.speed = NETHERITE_SPEED * multiplier;
        this.attackDamageBonus = NETHERITE_ATTACK_BONUS * multiplier;
        this.harvestLevel = harvestLevel;
        this.enchantability = Math.multiplyExact(
            NETHERITE_ENCHANTABILITY,
            multiplier
        );
        this.repairItem = repairItem;
    }

    @Override
    public int getUses() {
        return uses;
    }

    @Override
    public float getSpeed() {
        return speed;
    }

    @Override
    public float getAttackDamageBonus() {
        return attackDamageBonus;
    }

    @Override
    public int getLevel() {
        return harvestLevel;
    }

    @Override
    public int getEnchantmentValue() {
        return enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.of(repairItem.get());
    }
}
