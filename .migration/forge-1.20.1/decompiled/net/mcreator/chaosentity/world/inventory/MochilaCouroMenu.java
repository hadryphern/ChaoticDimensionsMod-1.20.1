/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.network.FriendlyByteBuf
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.Container
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.player.Inventory
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.inventory.AbstractContainerMenu
 *  net.minecraft.world.inventory.ContainerLevelAccess
 *  net.minecraft.world.inventory.MenuType
 *  net.minecraft.world.inventory.Slot
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.entity.BlockEntity
 *  net.minecraftforge.common.capabilities.ForgeCapabilities
 *  net.minecraftforge.items.IItemHandler
 *  net.minecraftforge.items.ItemStackHandler
 *  net.minecraftforge.items.SlotItemHandler
 */
package net.mcreator.chaosentity.world.inventory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import net.mcreator.chaosentity.init.ChaosentitymodModMenus;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Container;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;

public class MochilaCouroMenu
extends AbstractContainerMenu
implements Supplier<Map<Integer, Slot>> {
    public static final HashMap<String, Object> guistate = new HashMap();
    public final Level world;
    public final Player entity;
    public int x;
    public int y;
    public int z;
    private ContainerLevelAccess access = ContainerLevelAccess.f_39287_;
    private IItemHandler internal;
    private final Map<Integer, Slot> customSlots = new HashMap<Integer, Slot>();
    private boolean bound = false;
    private Supplier<Boolean> boundItemMatcher = null;
    private Entity boundEntity = null;
    private BlockEntity boundBlockEntity = null;

    public MochilaCouroMenu(int id, Inventory inv, FriendlyByteBuf extraData) {
        super((MenuType)ChaosentitymodModMenus.MOCHILA_COURO.get(), id);
        int si;
        this.entity = inv.f_35978_;
        this.world = inv.f_35978_.m_9236_();
        this.internal = new ItemStackHandler(55);
        BlockPos pos = null;
        if (extraData != null) {
            pos = extraData.m_130135_();
            this.x = pos.m_123341_();
            this.y = pos.m_123342_();
            this.z = pos.m_123343_();
            this.access = ContainerLevelAccess.m_39289_((Level)this.world, (BlockPos)pos);
        }
        if (pos != null) {
            if (extraData.readableBytes() == 1) {
                byte hand = extraData.readByte();
                ItemStack itemstack = hand == 0 ? this.entity.m_21205_() : this.entity.m_21206_();
                this.boundItemMatcher = () -> itemstack == (hand == 0 ? this.entity.m_21205_() : this.entity.m_21206_());
                itemstack.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
                    this.internal = capability;
                    this.bound = true;
                });
            } else if (extraData.readableBytes() > 1) {
                extraData.readByte();
                this.boundEntity = this.world.m_6815_(extraData.m_130242_());
                if (this.boundEntity != null) {
                    this.boundEntity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
                        this.internal = capability;
                        this.bound = true;
                    });
                }
            } else {
                this.boundBlockEntity = this.world.m_7702_(pos);
                if (this.boundBlockEntity != null) {
                    this.boundBlockEntity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
                        this.internal = capability;
                        this.bound = true;
                    });
                }
            }
        }
        this.customSlots.put(0, this.m_38897_((Slot)new SlotItemHandler(this.internal, 0, 14, 13){
            private final int slot = 0;
            {
                this.slot = 0;
            }
        }));
        this.customSlots.put(1, this.m_38897_((Slot)new SlotItemHandler(this.internal, 1, 14, 31){
            private final int slot = 1;
            {
                this.slot = 1;
            }
        }));
        this.customSlots.put(2, this.m_38897_((Slot)new SlotItemHandler(this.internal, 2, 14, 49){
            private final int slot = 2;
            {
                this.slot = 2;
            }
        }));
        this.customSlots.put(3, this.m_38897_((Slot)new SlotItemHandler(this.internal, 3, 14, 67){
            private final int slot = 3;
            {
                this.slot = 3;
            }
        }));
        this.customSlots.put(4, this.m_38897_((Slot)new SlotItemHandler(this.internal, 4, 14, 85){
            private final int slot = 4;
            {
                this.slot = 4;
            }
        }));
        this.customSlots.put(5, this.m_38897_((Slot)new SlotItemHandler(this.internal, 5, 32, 13){
            private final int slot = 5;
            {
                this.slot = 5;
            }
        }));
        this.customSlots.put(6, this.m_38897_((Slot)new SlotItemHandler(this.internal, 6, 32, 31){
            private final int slot = 6;
            {
                this.slot = 6;
            }
        }));
        this.customSlots.put(7, this.m_38897_((Slot)new SlotItemHandler(this.internal, 7, 32, 49){
            private final int slot = 7;
            {
                this.slot = 7;
            }
        }));
        this.customSlots.put(8, this.m_38897_((Slot)new SlotItemHandler(this.internal, 8, 32, 67){
            private final int slot = 8;
            {
                this.slot = 8;
            }
        }));
        this.customSlots.put(9, this.m_38897_((Slot)new SlotItemHandler(this.internal, 9, 32, 85){
            private final int slot = 9;
            {
                this.slot = 9;
            }
        }));
        this.customSlots.put(10, this.m_38897_((Slot)new SlotItemHandler(this.internal, 10, 50, 13){
            private final int slot = 10;
            {
                this.slot = 10;
            }
        }));
        this.customSlots.put(11, this.m_38897_((Slot)new SlotItemHandler(this.internal, 11, 68, 13){
            private final int slot = 11;
            {
                this.slot = 11;
            }
        }));
        this.customSlots.put(12, this.m_38897_((Slot)new SlotItemHandler(this.internal, 12, 86, 13){
            private final int slot = 12;
            {
                this.slot = 12;
            }
        }));
        this.customSlots.put(13, this.m_38897_((Slot)new SlotItemHandler(this.internal, 13, 104, 13){
            private final int slot = 13;
            {
                this.slot = 13;
            }
        }));
        this.customSlots.put(14, this.m_38897_((Slot)new SlotItemHandler(this.internal, 14, 122, 13){
            private final int slot = 14;
            {
                this.slot = 14;
            }
        }));
        this.customSlots.put(15, this.m_38897_((Slot)new SlotItemHandler(this.internal, 15, 140, 13){
            private final int slot = 15;
            {
                this.slot = 15;
            }
        }));
        this.customSlots.put(16, this.m_38897_((Slot)new SlotItemHandler(this.internal, 16, 158, 13){
            private final int slot = 16;
            {
                this.slot = 16;
            }
        }));
        this.customSlots.put(17, this.m_38897_((Slot)new SlotItemHandler(this.internal, 17, 176, 13){
            private final int slot = 17;
            {
                this.slot = 17;
            }
        }));
        this.customSlots.put(18, this.m_38897_((Slot)new SlotItemHandler(this.internal, 18, 194, 13){
            private final int slot = 18;
            {
                this.slot = 18;
            }
        }));
        this.customSlots.put(19, this.m_38897_((Slot)new SlotItemHandler(this.internal, 19, 50, 31){
            private final int slot = 19;
            {
                this.slot = 19;
            }
        }));
        this.customSlots.put(20, this.m_38897_((Slot)new SlotItemHandler(this.internal, 20, 68, 31){
            private final int slot = 20;
            {
                this.slot = 20;
            }
        }));
        this.customSlots.put(21, this.m_38897_((Slot)new SlotItemHandler(this.internal, 21, 86, 31){
            private final int slot = 21;
            {
                this.slot = 21;
            }
        }));
        this.customSlots.put(22, this.m_38897_((Slot)new SlotItemHandler(this.internal, 22, 104, 31){
            private final int slot = 22;
            {
                this.slot = 22;
            }
        }));
        this.customSlots.put(23, this.m_38897_((Slot)new SlotItemHandler(this.internal, 23, 122, 31){
            private final int slot = 23;
            {
                this.slot = 23;
            }
        }));
        this.customSlots.put(24, this.m_38897_((Slot)new SlotItemHandler(this.internal, 24, 140, 31){
            private final int slot = 24;
            {
                this.slot = 24;
            }
        }));
        this.customSlots.put(25, this.m_38897_((Slot)new SlotItemHandler(this.internal, 25, 158, 31){
            private final int slot = 25;
            {
                this.slot = 25;
            }
        }));
        this.customSlots.put(26, this.m_38897_((Slot)new SlotItemHandler(this.internal, 26, 176, 31){
            private final int slot = 26;
            {
                this.slot = 26;
            }
        }));
        this.customSlots.put(27, this.m_38897_((Slot)new SlotItemHandler(this.internal, 27, 194, 31){
            private final int slot = 27;
            {
                this.slot = 27;
            }
        }));
        this.customSlots.put(28, this.m_38897_((Slot)new SlotItemHandler(this.internal, 28, 50, 49){
            private final int slot = 28;
            {
                this.slot = 28;
            }
        }));
        this.customSlots.put(29, this.m_38897_((Slot)new SlotItemHandler(this.internal, 29, 68, 49){
            private final int slot = 29;
            {
                this.slot = 29;
            }
        }));
        this.customSlots.put(30, this.m_38897_((Slot)new SlotItemHandler(this.internal, 30, 194, 49){
            private final int slot = 30;
            {
                this.slot = 30;
            }
        }));
        this.customSlots.put(31, this.m_38897_((Slot)new SlotItemHandler(this.internal, 31, 86, 49){
            private final int slot = 31;
            {
                this.slot = 31;
            }
        }));
        this.customSlots.put(32, this.m_38897_((Slot)new SlotItemHandler(this.internal, 32, 104, 49){
            private final int slot = 32;
            {
                this.slot = 32;
            }
        }));
        this.customSlots.put(33, this.m_38897_((Slot)new SlotItemHandler(this.internal, 33, 122, 49){
            private final int slot = 33;
            {
                this.slot = 33;
            }
        }));
        this.customSlots.put(34, this.m_38897_((Slot)new SlotItemHandler(this.internal, 34, 140, 49){
            private final int slot = 34;
            {
                this.slot = 34;
            }
        }));
        this.customSlots.put(35, this.m_38897_((Slot)new SlotItemHandler(this.internal, 35, 158, 49){
            private final int slot = 35;
            {
                this.slot = 35;
            }
        }));
        this.customSlots.put(36, this.m_38897_((Slot)new SlotItemHandler(this.internal, 36, 176, 49){
            private final int slot = 36;
            {
                this.slot = 36;
            }
        }));
        this.customSlots.put(37, this.m_38897_((Slot)new SlotItemHandler(this.internal, 37, 50, 67){
            private final int slot = 37;
            {
                this.slot = 37;
            }
        }));
        this.customSlots.put(38, this.m_38897_((Slot)new SlotItemHandler(this.internal, 38, 68, 67){
            private final int slot = 38;
            {
                this.slot = 38;
            }
        }));
        this.customSlots.put(39, this.m_38897_((Slot)new SlotItemHandler(this.internal, 39, 86, 67){
            private final int slot = 39;
            {
                this.slot = 39;
            }
        }));
        this.customSlots.put(40, this.m_38897_((Slot)new SlotItemHandler(this.internal, 40, 104, 67){
            private final int slot = 40;
            {
                this.slot = 40;
            }
        }));
        this.customSlots.put(41, this.m_38897_((Slot)new SlotItemHandler(this.internal, 41, 122, 67){
            private final int slot = 41;
            {
                this.slot = 41;
            }
        }));
        this.customSlots.put(42, this.m_38897_((Slot)new SlotItemHandler(this.internal, 42, 140, 67){
            private final int slot = 42;
            {
                this.slot = 42;
            }
        }));
        this.customSlots.put(43, this.m_38897_((Slot)new SlotItemHandler(this.internal, 43, 158, 67){
            private final int slot = 43;
            {
                this.slot = 43;
            }
        }));
        this.customSlots.put(44, this.m_38897_((Slot)new SlotItemHandler(this.internal, 44, 176, 67){
            private final int slot = 44;
            {
                this.slot = 44;
            }
        }));
        this.customSlots.put(45, this.m_38897_((Slot)new SlotItemHandler(this.internal, 45, 194, 67){
            private final int slot = 45;
            {
                this.slot = 45;
            }
        }));
        this.customSlots.put(46, this.m_38897_((Slot)new SlotItemHandler(this.internal, 46, 50, 85){
            private final int slot = 46;
            {
                this.slot = 46;
            }
        }));
        this.customSlots.put(47, this.m_38897_((Slot)new SlotItemHandler(this.internal, 47, 68, 85){
            private final int slot = 47;
            {
                this.slot = 47;
            }
        }));
        this.customSlots.put(48, this.m_38897_((Slot)new SlotItemHandler(this.internal, 48, 86, 85){
            private final int slot = 48;
            {
                this.slot = 48;
            }
        }));
        this.customSlots.put(49, this.m_38897_((Slot)new SlotItemHandler(this.internal, 49, 104, 85){
            private final int slot = 49;
            {
                this.slot = 49;
            }
        }));
        this.customSlots.put(50, this.m_38897_((Slot)new SlotItemHandler(this.internal, 50, 122, 85){
            private final int slot = 50;
            {
                this.slot = 50;
            }
        }));
        this.customSlots.put(51, this.m_38897_((Slot)new SlotItemHandler(this.internal, 51, 140, 85){
            private final int slot = 51;
            {
                this.slot = 51;
            }
        }));
        this.customSlots.put(52, this.m_38897_((Slot)new SlotItemHandler(this.internal, 52, 158, 85){
            private final int slot = 52;
            {
                this.slot = 52;
            }
        }));
        this.customSlots.put(53, this.m_38897_((Slot)new SlotItemHandler(this.internal, 53, 176, 85){
            private final int slot = 53;
            {
                this.slot = 53;
            }
        }));
        this.customSlots.put(54, this.m_38897_((Slot)new SlotItemHandler(this.internal, 54, 194, 85){
            private final int slot = 54;
            {
                this.slot = 54;
            }
        }));
        for (si = 0; si < 3; ++si) {
            for (int sj = 0; sj < 9; ++sj) {
                this.m_38897_(new Slot((Container)inv, sj + (si + 1) * 9, 33 + sj * 18, 111 + si * 18));
            }
        }
        for (si = 0; si < 9; ++si) {
            this.m_38897_(new Slot((Container)inv, si, 33 + si * 18, 169));
        }
    }

    public boolean m_6875_(Player player) {
        if (this.bound) {
            if (this.boundItemMatcher != null) {
                return this.boundItemMatcher.get();
            }
            if (this.boundBlockEntity != null) {
                return AbstractContainerMenu.m_38889_((ContainerLevelAccess)this.access, (Player)player, (Block)this.boundBlockEntity.m_58900_().m_60734_());
            }
            if (this.boundEntity != null) {
                return this.boundEntity.m_6084_();
            }
        }
        return true;
    }

    public ItemStack m_7648_(Player playerIn, int index) {
        ItemStack itemstack = ItemStack.f_41583_;
        Slot slot = (Slot)this.f_38839_.get(index);
        if (slot != null && slot.m_6657_()) {
            ItemStack itemstack1 = slot.m_7993_();
            itemstack = itemstack1.m_41777_();
            if (index < 55) {
                if (!this.m_38903_(itemstack1, 55, this.f_38839_.size(), true)) {
                    return ItemStack.f_41583_;
                }
                slot.m_40234_(itemstack1, itemstack);
            } else if (!this.m_38903_(itemstack1, 0, 55, false)) {
                if (index < 82 ? !this.m_38903_(itemstack1, 82, this.f_38839_.size(), true) : !this.m_38903_(itemstack1, 55, 82, false)) {
                    return ItemStack.f_41583_;
                }
                return ItemStack.f_41583_;
            }
            if (itemstack1.m_41613_() == 0) {
                slot.m_5852_(ItemStack.f_41583_);
            } else {
                slot.m_6654_();
            }
            if (itemstack1.m_41613_() == itemstack.m_41613_()) {
                return ItemStack.f_41583_;
            }
            slot.m_142406_(playerIn, itemstack1);
        }
        return itemstack;
    }

    protected boolean m_38903_(ItemStack p_38904_, int p_38905_, int p_38906_, boolean p_38907_) {
        boolean flag = false;
        int i = p_38905_;
        if (p_38907_) {
            i = p_38906_ - 1;
        }
        if (p_38904_.m_41753_()) {
            while (!p_38904_.m_41619_() && !(!p_38907_ ? i >= p_38906_ : i < p_38905_)) {
                ItemStack itemstack;
                Slot slot = (Slot)this.f_38839_.get(i);
                if (slot.m_5857_(itemstack = slot.m_7993_()) && !itemstack.m_41619_() && ItemStack.m_150942_((ItemStack)p_38904_, (ItemStack)itemstack)) {
                    int maxSize;
                    int j = itemstack.m_41613_() + p_38904_.m_41613_();
                    if (j <= (maxSize = Math.min(slot.m_6641_(), p_38904_.m_41741_()))) {
                        p_38904_.m_41764_(0);
                        itemstack.m_41764_(j);
                        slot.m_5852_(itemstack);
                        flag = true;
                    } else if (itemstack.m_41613_() < maxSize) {
                        p_38904_.m_41774_(maxSize - itemstack.m_41613_());
                        itemstack.m_41764_(maxSize);
                        slot.m_5852_(itemstack);
                        flag = true;
                    }
                }
                if (p_38907_) {
                    --i;
                    continue;
                }
                ++i;
            }
        }
        if (!p_38904_.m_41619_()) {
            i = p_38907_ ? p_38906_ - 1 : p_38905_;
            while (!(!p_38907_ ? i >= p_38906_ : i < p_38905_)) {
                Slot slot1 = (Slot)this.f_38839_.get(i);
                ItemStack itemstack1 = slot1.m_7993_();
                if (itemstack1.m_41619_() && slot1.m_5857_(p_38904_)) {
                    if (p_38904_.m_41613_() > slot1.m_6641_()) {
                        slot1.m_269060_(p_38904_.m_41620_(slot1.m_6641_()));
                    } else {
                        slot1.m_269060_(p_38904_.m_41620_(p_38904_.m_41613_()));
                    }
                    slot1.m_6654_();
                    flag = true;
                    break;
                }
                if (p_38907_) {
                    --i;
                    continue;
                }
                ++i;
            }
        }
        return flag;
    }

    public void m_6877_(Player playerIn) {
        block4: {
            super.m_6877_(playerIn);
            if (this.bound || !(playerIn instanceof ServerPlayer)) break block4;
            ServerPlayer serverPlayer = (ServerPlayer)playerIn;
            if (!serverPlayer.m_6084_() || serverPlayer.m_9232_()) {
                for (int j = 0; j < this.internal.getSlots(); ++j) {
                    playerIn.m_36176_(this.internal.extractItem(j, this.internal.getStackInSlot(j).m_41613_(), false), false);
                }
            } else {
                for (int i = 0; i < this.internal.getSlots(); ++i) {
                    playerIn.m_150109_().m_150079_(this.internal.extractItem(i, this.internal.getStackInSlot(i).m_41613_(), false));
                }
            }
        }
    }

    @Override
    public Map<Integer, Slot> get() {
        return this.customSlots;
    }
}

