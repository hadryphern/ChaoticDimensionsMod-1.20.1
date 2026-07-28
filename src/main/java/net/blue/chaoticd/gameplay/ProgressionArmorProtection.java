package net.blue.chaoticd.gameplay;

import net.blue.chaoticd.content.ModItems;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;

/**
 * Makes the announced post-Netherite armor multipliers real in vanilla.
 *
 * <p>Minecraft's native armor formula caps the armor-point contribution at
 * twenty.  The material attributes still describe the gear accurately in the
 * UI, but without this small server-side layer Ruby, Jaxy, Titanium and
 * Rosalita would absorb almost the same damage.  The scale applies only to a
 * complete matching set and leaves void/kill damage untouched.</p>
 */
public final class ProgressionArmorProtection {
    private ProgressionArmorProtection() {
    }

    public static float scaleIncomingDamage(LivingEntity entity, DamageSource source, float amount) {
        if (amount <= 0.0F || !Float.isFinite(amount)
            || source.is(DamageTypes.FELL_OUT_OF_WORLD)
            || source.is(DamageTypes.GENERIC_KILL)) {
            return amount;
        }

        int materialMultiplier = fullSetMultiplier(entity);
        if (materialMultiplier <= 1) {
            return amount;
        }

        float scaled = amount / materialMultiplier;
        return Float.isFinite(scaled) ? scaled : amount;
    }

    private static int fullSetMultiplier(LivingEntity entity) {
        if (wearsFullSet(entity,
            ModItems.ROSALITA_HELMET,
            ModItems.ROSALITA_CHESTPLATE,
            ModItems.ROSALITA_LEGGINGS,
            ModItems.ROSALITA_BOOTS)) {
            return 100;
        }
        if (wearsFullSet(entity,
            ModItems.TITANIUM_HELMET,
            ModItems.TITANIUM_CHESTPLATE,
            ModItems.TITANIUM_LEGGINGS,
            ModItems.TITANIUM_BOOTS)) {
            return 40;
        }
        if (wearsFullSet(entity,
            ModItems.JAXY_HELMET,
            ModItems.JAXY_CHESTPLATE,
            ModItems.JAXY_LEGGINGS,
            ModItems.JAXY_BOOTS)) {
            return 8;
        }
        if (wearsFullSet(entity,
            ModItems.RUBY_HELMET,
            ModItems.RUBY_CHESTPLATE,
            ModItems.RUBY_LEGGINGS,
            ModItems.RUBY_BOOTS)) {
            return 4;
        }
        if (wearsFullSet(entity,
            ModItems.EMERALD_HELMET,
            ModItems.EMERALD_CHESTPLATE,
            ModItems.EMERALD_LEGGINGS,
            ModItems.EMERALD_BOOTS)) {
            return 2;
        }
        return 1;
    }

    private static boolean wearsFullSet(
        LivingEntity entity,
        Item helmet,
        Item chestplate,
        Item leggings,
        Item boots
    ) {
        return entity.getItemBySlot(EquipmentSlot.HEAD).is(helmet)
            && entity.getItemBySlot(EquipmentSlot.CHEST).is(chestplate)
            && entity.getItemBySlot(EquipmentSlot.LEGS).is(leggings)
            && entity.getItemBySlot(EquipmentSlot.FEET).is(boots);
    }
}
