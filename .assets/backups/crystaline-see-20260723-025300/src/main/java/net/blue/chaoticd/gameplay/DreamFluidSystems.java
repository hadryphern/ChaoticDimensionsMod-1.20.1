package net.blue.chaoticd.gameplay;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import net.blue.chaoticd.content.ModItems;
import net.blue.chaoticd.content.ModTags;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.material.FluidState;

/**
 * Server-side Dream Fluid hazard and Shimmer-style item transformation.
 */
public final class DreamFluidSystems {
    private static final String START_TIME_TAG =
        "chaoticdDreamFluidStart";

    private static final String OWNER_TAG =
        "chaoticdDreamFluidOwner";

    private static final int TRANSFORMATION_TICKS = 100;
    private static final double ITEM_SEARCH_RADIUS = 96.0D;

    private DreamFluidSystems() {
    }

    public static void initialize() {
        ServerTickEvents.END_WORLD_TICK.register(
            DreamFluidSystems::tickWorld
        );
    }

    private static void tickWorld(ServerLevel level) {
        if (level.players().isEmpty()) {
            return;
        }

        killPlayersInsideDreamFluid(level);
        transformItemsInsideDreamFluid(level);
    }

    private static void killPlayersInsideDreamFluid(
        ServerLevel level
    ) {
        for (ServerPlayer player : level.players()) {
            if (player.isSpectator()) {
                continue;
            }

            FluidState feetFluid =
                level.getFluidState(player.blockPosition());

            FluidState bodyFluid =
                level.getFluidState(
                    player.blockPosition().above()
                );

            if (
                feetFluid.is(ModTags.DREAM_FLUID)
                    || bodyFluid.is(ModTags.DREAM_FLUID)
            ) {
                player.kill();
            }
        }
    }

    private static void transformItemsInsideDreamFluid(
        ServerLevel level
    ) {
        Set<UUID> processed = new HashSet<>();

        for (ServerPlayer observer : level.players()) {
            List<ItemEntity> items =
                level.getEntitiesOfClass(
                    ItemEntity.class,
                    observer.getBoundingBox().inflate(
                        ITEM_SEARCH_RADIUS
                    ),
                    item ->
                        item.isAlive()
                            && isInsideDreamFluid(level, item)
                );

            for (ItemEntity item : items) {
                if (!processed.add(item.getUUID())) {
                    continue;
                }

                processItem(level, item);
            }
        }
    }

    private static boolean isInsideDreamFluid(
        ServerLevel level,
        ItemEntity item
    ) {
        return level.getFluidState(
            item.blockPosition()
        ).is(ModTags.DREAM_FLUID);
    }

    private static void processItem(
        ServerLevel level,
        ItemEntity item
    ) {
        ItemStack input = item.getItem();
        ItemStack preview = transform(input);

        if (preview.isEmpty()) {
            clearProgress(input);
            return;
        }

        long now = level.getGameTime();

        if (!input.getOrCreateTag().contains(START_TIME_TAG)) {
            input.getOrCreateTag().putLong(
                START_TIME_TAG,
                now
            );

            ServerPlayer owner =
                nearestPlayer(level, item);

            if (owner != null) {
                input.getOrCreateTag().putUUID(
                    OWNER_TAG,
                    owner.getUUID()
                );
            }

            item.setItem(input);
            level.playSound(
                null,
                item.blockPosition(),
                SoundEvents.AMETHYST_BLOCK_CHIME,
                SoundSource.BLOCKS,
                0.65F,
                1.45F
            );
            return;
        }

        long start =
            input.getOrCreateTag().getLong(START_TIME_TAG);

        if ((now - start) % 10L == 0L) {
            level.sendParticles(
                ParticleTypes.END_ROD,
                item.getX(),
                item.getY() + 0.25D,
                item.getZ(),
                3,
                0.15D,
                0.10D,
                0.15D,
                0.01D
            );

            level.sendParticles(
                ParticleTypes.WITCH,
                item.getX(),
                item.getY() + 0.20D,
                item.getZ(),
                2,
                0.18D,
                0.08D,
                0.18D,
                0.0D
            );
        }

        if (now - start < TRANSFORMATION_TICKS) {
            return;
        }

        ItemStack result = transform(input);

        if (result.isEmpty()) {
            clearProgress(input);
            item.setItem(input);
            return;
        }

        ServerPlayer owner =
            resolveOwner(level, input);

        if (owner == null) {
            owner = nearestPlayer(level, item);
        }

        item.discard();

        if (owner != null) {
            if (!owner.getInventory().add(result)) {
                owner.drop(result, false);
            }

            owner.containerMenu.broadcastChanges();

            level.sendParticles(
                ParticleTypes.FIREWORK,
                owner.getX(),
                owner.getY() + 1.0D,
                owner.getZ(),
                12,
                0.35D,
                0.55D,
                0.35D,
                0.04D
            );

            level.playSound(
                null,
                owner.blockPosition(),
                SoundEvents.PLAYER_LEVELUP,
                SoundSource.PLAYERS,
                0.55F,
                1.75F
            );

            return;
        }

        ItemEntity replacement =
            new ItemEntity(
                level,
                item.getX(),
                item.getY(),
                item.getZ(),
                result
            );

        level.addFreshEntity(replacement);
    }

    /**
     * Central transformation table. New Shimmer-like recipes belong here.
     */
    private static ItemStack transform(ItemStack input) {
        if (input.is(Items.EMERALD)) {
            return new ItemStack(
                ModItems.EMERALD_INGOT,
                input.getCount()
            );
        }

        return ItemStack.EMPTY;
    }

    private static void clearProgress(ItemStack stack) {
        if (!stack.hasTag()) {
            return;
        }

        stack.getOrCreateTag().remove(START_TIME_TAG);
        stack.getOrCreateTag().remove(OWNER_TAG);
    }

    private static ServerPlayer resolveOwner(
        ServerLevel level,
        ItemStack stack
    ) {
        if (!stack.hasTag()
            || !stack.getOrCreateTag().hasUUID(OWNER_TAG)) {
            return null;
        }

        return level.getServer()
            .getPlayerList()
            .getPlayer(
                stack.getOrCreateTag().getUUID(OWNER_TAG)
            );
    }

    private static ServerPlayer nearestPlayer(
        ServerLevel level,
        ItemEntity item
    ) {
        ServerPlayer nearest = null;
        double bestDistance = Double.MAX_VALUE;

        for (ServerPlayer player : level.players()) {
            double distance =
                player.distanceToSqr(item);

            if (distance < bestDistance) {
                nearest = player;
                bestDistance = distance;
            }
        }

        return nearest;
    }
}
