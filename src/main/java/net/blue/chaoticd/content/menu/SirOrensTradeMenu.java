package net.blue.chaoticd.content.menu;

import java.util.UUID;
import net.blue.chaoticd.content.ModMenus;
import net.blue.chaoticd.content.entity.SirOrensEntity;
import net.blue.chaoticd.content.trade.SirOrensTrade;
import net.blue.chaoticd.content.trade.SirOrensTradeService;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.DataSlot;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

/**
 * A button-only menu that safely completes Sir. Orens' large multi-item
 * trades. The player's inventory remains the payment source, so 350+ item
 * requirements are supported without fake stacks or client trust.
 */
public final class SirOrensTradeMenu extends AbstractContainerMenu {
    private final UUID sirOrensUuid;
    private final DataSlot unlockedLevel;

    /** Client construction path used by the extended screen-handler packet. */
    public SirOrensTradeMenu(int containerId, Inventory inventory, FriendlyByteBuf buffer) {
        this(containerId, inventory, buffer.readUUID(), buffer.readVarInt(), null);
    }

    /** Server construction path used when the player interacts with Sir. Orens. */
    public SirOrensTradeMenu(int containerId, Inventory inventory, SirOrensEntity sirOrens) {
        this(containerId, inventory, sirOrens.getUUID(), sirOrens.getUnlockedLevel(), sirOrens);
    }

    private SirOrensTradeMenu(
        int containerId,
        Inventory inventory,
        UUID sirOrensUuid,
        int initialUnlockedLevel,
        SirOrensEntity serverSirOrens
    ) {
        super(ModMenus.SIR_ORENS_TRADES, containerId);
        this.sirOrensUuid = sirOrensUuid;
        this.unlockedLevel = serverSirOrens == null
            ? clientLevelSlot(initialUnlockedLevel)
            : new DataSlot() {
                @Override
                public int get() {
                    return serverSirOrens.getUnlockedLevel();
                }

                @Override
                public void set(int value) {
                    // The entity is server authoritative; client values are ignored.
                }
        };
        addDataSlot(unlockedLevel);
        addPlayerInventorySlots(inventory);
    }

    private static DataSlot clientLevelSlot(int initialUnlockedLevel) {
        DataSlot slot = DataSlot.standalone();
        slot.set(initialUnlockedLevel);
        return slot;
    }

    public UUID sirOrensUuid() {
        return sirOrensUuid;
    }

    public int unlockedLevel() {
        return unlockedLevel.get();
    }

    @Override
    public boolean clickMenuButton(Player player, int tradeId) {
        if (player.level().isClientSide) {
            return true;
        }

        SirOrensTrade trade = SirOrensTrade.byId(tradeId).orElse(null);
        SirOrensEntity sirOrens = findSirOrens(player);

        if (trade == null || sirOrens == null || !sirOrens.canTradeWith(player)) {
            return false;
        }

        if (trade.level() > sirOrens.getUnlockedLevel()) {
            player.sendSystemMessage(Component.translatable("message.chaoticd.sir_orens_trade_locked"));
            return true;
        }

        if (!SirOrensTradeService.tryComplete(player, trade)) {
            player.sendSystemMessage(Component.translatable("message.chaoticd.sir_orens_missing_items"));
            return true;
        }

        sirOrens.advanceLevelAfterTrade(trade.level());
        player.sendSystemMessage(Component.translatable("message.chaoticd.sir_orens_trade_complete"));
        broadcastChanges();
        return true;
    }

    @Override
    public boolean stillValid(Player player) {
        if (player.level().isClientSide) {
            return true;
        }

        SirOrensEntity sirOrens = findSirOrens(player);
        return sirOrens != null && sirOrens.canTradeWith(player);
    }

    @Override
    public ItemStack quickMoveStack(Player player, int slot) {
        if (slot < 0 || slot >= slots.size()) {
            return ItemStack.EMPTY;
        }

        Slot source = slots.get(slot);

        if (!source.hasItem()) {
            return ItemStack.EMPTY;
        }

        ItemStack stack = source.getItem();
        ItemStack original = stack.copy();
        int hotbarStart = 27;

        if (slot < hotbarStart) {
            if (!moveItemStackTo(stack, hotbarStart, 36, false)) {
                return ItemStack.EMPTY;
            }
        } else if (!moveItemStackTo(stack, 0, hotbarStart, false)) {
            return ItemStack.EMPTY;
        }

        if (stack.isEmpty()) {
            source.set(ItemStack.EMPTY);
        } else {
            source.setChanged();
        }

        return original;
    }

    private void addPlayerInventorySlots(Inventory inventory) {
        int inventoryY = 253;

        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 9; column++) {
                addSlot(new Slot(inventory, column + row * 9 + 9, 10 + column * 18, inventoryY + row * 18));
            }
        }

        int hotbarY = inventoryY + 58;

        for (int column = 0; column < 9; column++) {
            addSlot(new Slot(inventory, column, 10 + column * 18, hotbarY));
        }
    }

    private SirOrensEntity findSirOrens(Player player) {
        if (!(player instanceof net.minecraft.server.level.ServerPlayer serverPlayer)) {
            return null;
        }

        Entity entity = serverPlayer.serverLevel().getEntity(sirOrensUuid);
        return entity instanceof SirOrensEntity sirOrens ? sirOrens : null;
    }
}
