package net.blue.chaoticd.gameplay;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import net.blue.chaoticd.content.ModEnchantments;
import net.blue.chaoticd.content.ModItems;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;

/**
 * Initializes special gear only after it actually enters a player inventory.
 *
 * <p>This keeps Creative Mode search results completely clean while preserving
 * the intended Sapphire kit and the random Emerald equipment rolls.</p>
 */
public final class ChaoticGearInitialization {
    private static final String INITIALIZED_TAG =
        "chaoticdGearInitialized";

    private static final int CHECK_INTERVAL_TICKS = 5;

    private static final List<Enchantment> TOOL_ENCHANTMENTS = List.of(
        Enchantments.SHARPNESS,
        Enchantments.SMITE,
        Enchantments.BANE_OF_ARTHROPODS,
        Enchantments.BLOCK_EFFICIENCY,
        Enchantments.UNBREAKING,
        Enchantments.BLOCK_FORTUNE,
        Enchantments.SILK_TOUCH,
        Enchantments.MOB_LOOTING,
        Enchantments.KNOCKBACK,
        Enchantments.FIRE_ASPECT,
        Enchantments.MENDING,
        Enchantments.VANISHING_CURSE
    );

    private static final List<Enchantment> ARMOR_ENCHANTMENTS = List.of(
        Enchantments.ALL_DAMAGE_PROTECTION,
        Enchantments.FIRE_PROTECTION,
        Enchantments.BLAST_PROTECTION,
        Enchantments.PROJECTILE_PROTECTION,
        Enchantments.FALL_PROTECTION,
        Enchantments.THORNS,
        Enchantments.UNBREAKING,
        Enchantments.RESPIRATION,
        Enchantments.AQUA_AFFINITY,
        Enchantments.DEPTH_STRIDER,
        Enchantments.FROST_WALKER,
        Enchantments.SOUL_SPEED,
        Enchantments.MENDING,
        Enchantments.BINDING_CURSE,
        Enchantments.VANISHING_CURSE
    );

    private ChaoticGearInitialization() {
    }

    public static void initialize() {
        ServerTickEvents.END_WORLD_TICK.register(
            ChaoticGearInitialization::tickWorld
        );
    }

    private static void tickWorld(ServerLevel level) {
        if (level.getGameTime() % CHECK_INTERVAL_TICKS != 0L) {
            return;
        }

        for (ServerPlayer player : level.players()) {
            boolean changed = false;

            for (
                int slot = 0;
                slot < player.getInventory().getContainerSize();
                slot++
            ) {
                ItemStack stack =
                    player.getInventory().getItem(slot);

                changed |= initializeStack(
                    stack,
                    level.getRandom()
                );
            }

            ItemStack carried =
                player.containerMenu.getCarried();

            changed |= initializeStack(
                carried,
                level.getRandom()
            );

            if (changed) {
                player.getInventory().setChanged();
                player.containerMenu.broadcastChanges();
            }
        }
    }

    private static boolean initializeStack(
        ItemStack stack,
        RandomSource random
    ) {
        if (stack.isEmpty()
            || stack.getOrCreateTag().getBoolean(INITIALIZED_TAG)) {
            return false;
        }

        if (ModItems.isSapphireGear(stack)) {
            initializeSapphire(stack);
            stack.getOrCreateTag().putBoolean(
                INITIALIZED_TAG,
                true
            );
            return true;
        }

        if (ModItems.isEmeraldGear(stack)) {
            initializeEmerald(stack, random);
            stack.getOrCreateTag().putBoolean(
                INITIALIZED_TAG,
                true
            );
            return true;
        }

        return false;
    }

    private static void initializeSapphire(
        ItemStack stack
    ) {
        if (stack.is(ModItems.SAPPHIRE_SWORD)) {
            stack.enchant(ModEnchantments.SAPPHIRIC, 1);
            stack.enchant(ModEnchantments.DHEATHIC, 1);
            return;
        }

        stack.enchant(Enchantments.BLOCK_EFFICIENCY, 50);
        stack.enchant(Enchantments.UNBREAKING, 50);

        if (stack.is(ModItems.SAPPHIRE_PICKAXE)
            || stack.is(ModItems.SAPPHIRE_AXE)) {
            stack.enchant(Enchantments.BLOCK_FORTUNE, 50);
        }

        if (stack.is(ModItems.SAPPHIRE_AXE)) {
            stack.enchant(Enchantments.SHARPNESS, 50);
        }
    }

    private static void initializeEmerald(
        ItemStack stack,
        RandomSource random
    ) {
        /*
         * Luck is guaranteed. Armor and tools both use level V so every
         * Emerald piece fully participates in the requested systems.
         */
        stack.enchant(ModEnchantments.LUCK, 5);

        int additionalEnchantments =
            random.nextInt(6);

        if (additionalEnchantments == 0) {
            return;
        }

        List<Enchantment> pool =
            stack.getItem() instanceof ArmorItem
                ? ARMOR_ENCHANTMENTS
                : TOOL_ENCHANTMENTS;

        Set<Enchantment> selected =
            new LinkedHashSet<>();

        while (
            selected.size() < additionalEnchantments
                && selected.size() < pool.size()
        ) {
            selected.add(
                pool.get(random.nextInt(pool.size()))
            );
        }

        for (Enchantment enchantment : selected) {
            int level =
                random.nextBoolean() ? 10 : 15;

            /*
             * Mending and curses do not benefit from absurd levels, but they
             * still count as part of a lucky or unlucky random roll.
             */
            if (enchantment == Enchantments.MENDING
                || enchantment == Enchantments.BINDING_CURSE
                || enchantment == Enchantments.VANISHING_CURSE) {
                level = 1;
            }

            stack.enchant(enchantment, level);
        }
    }
}
