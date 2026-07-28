package net.blue.chaoticd.content.entity;

import java.util.UUID;
import net.blue.chaoticd.content.ModMenus;
import net.blue.chaoticd.content.menu.SirOrensTradeMenu;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

/**
 * A one-owner, stationary villager whose offers are completed by
 * {@link SirOrensTradeMenu}.  It deliberately does not use vanilla merchant
 * offers, because those offers cannot represent the six-item, 500-count
 * payments in Sir. Orens' catalogue.
 */
public final class SirOrensEntity extends Villager {
    private static final String OWNER_KEY = "SirOrensOwner";
    private static final String UNLOCKED_LEVEL_KEY = "SirOrensUnlockedLevel";
    private static final int MAX_LEVEL = 5;
    private static final double INTERACTION_RANGE_SQUARED = 64.0D;

    @Nullable
    private UUID ownerUuid;
    private int unlockedLevel = 1;

    public SirOrensEntity(EntityType<? extends Villager> type, Level level) {
        super(type, level);
    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        if (level().isClientSide) {
            return InteractionResult.SUCCESS;
        }

        if (!isOwner(player)) {
            player.sendSystemMessage(Component.translatable("message.chaoticd.sir_orens_owner_only"));
            return InteractionResult.CONSUME;
        }

        if (!isWithinTradeRange(player)) {
            player.sendSystemMessage(Component.translatable("message.chaoticd.sir_orens_too_far"));
            return InteractionResult.CONSUME;
        }

        if (player instanceof ServerPlayer serverPlayer) {
            serverPlayer.openMenu(new TradeMenuProvider());
        }

        return InteractionResult.CONSUME;
    }

    @Override
    public boolean isPushable() {
        return false;
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);

        if (ownerUuid != null) {
            tag.putUUID(OWNER_KEY, ownerUuid);
        }

        tag.putInt(UNLOCKED_LEVEL_KEY, unlockedLevel);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        ownerUuid = tag.hasUUID(OWNER_KEY) ? tag.getUUID(OWNER_KEY) : null;
        unlockedLevel = Math.max(1, Math.min(MAX_LEVEL, tag.getInt(UNLOCKED_LEVEL_KEY)));
    }

    public void setOwnerUuid(UUID ownerUuid) {
        this.ownerUuid = ownerUuid;
    }

    public boolean isOwner(Player player) {
        return isOwnedBy(player.getUUID());
    }

    public boolean isOwnedBy(UUID ownerUuid) {
        return this.ownerUuid != null && this.ownerUuid.equals(ownerUuid);
    }

    public boolean isWithinTradeRange(Player player) {
        return distanceToSqr(player) <= INTERACTION_RANGE_SQUARED;
    }

    public boolean canTradeWith(Player player) {
        return isOwner(player) && isWithinTradeRange(player) && !isRemoved();
    }

    public int getUnlockedLevel() {
        return unlockedLevel;
    }

    /** Unlocks the next tier after a successful offer from the current tier. */
    public void advanceLevelAfterTrade(int completedTradeLevel) {
        if (completedTradeLevel == unlockedLevel && unlockedLevel < MAX_LEVEL) {
            unlockedLevel++;
        }
    }

    /** Applies the persistent, home-bound rules configured by the spawn system. */
    public void configureForHome(UUID ownerUuid) {
        setOwnerUuid(ownerUuid);
        setCustomName(Component.literal("Sir. Orens"));
        setCustomNameVisible(true);
        setPersistenceRequired();
        setInvulnerable(true);
        setNoAi(true);
        setCanPickUpLoot(false);
    }

    private final class TradeMenuProvider implements ExtendedScreenHandlerFactory {
        @Override
        public Component getDisplayName() {
            return Component.translatable("container.chaoticd.sir_orens");
        }

        @Override
        public AbstractContainerMenu createMenu(
            int containerId,
            net.minecraft.world.entity.player.Inventory inventory,
            Player player
        ) {
            return new SirOrensTradeMenu(containerId, inventory, SirOrensEntity.this);
        }

        @Override
        public void writeScreenOpeningData(ServerPlayer player, FriendlyByteBuf buffer) {
            buffer.writeUUID(getUUID());
            buffer.writeVarInt(getUnlockedLevel());
        }
    }
}
