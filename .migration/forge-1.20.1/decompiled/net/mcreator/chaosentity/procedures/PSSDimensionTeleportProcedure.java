/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.network.protocol.Packet
 *  net.minecraft.network.protocol.game.ClientboundGameEventPacket
 *  net.minecraft.network.protocol.game.ClientboundLevelEventPacket
 *  net.minecraft.network.protocol.game.ClientboundPlayerAbilitiesPacket
 *  net.minecraft.network.protocol.game.ClientboundUpdateMobEffectPacket
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.effect.MobEffectInstance
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.level.Level
 *  net.minecraftforge.event.entity.player.PlayerInteractEvent$RightClickItem
 *  net.minecraftforge.eventbus.api.Event
 *  net.minecraftforge.eventbus.api.SubscribeEvent
 *  net.minecraftforge.fml.common.Mod$EventBusSubscriber
 */
package net.mcreator.chaosentity.procedures;

import javax.annotation.Nullable;
import net.mcreator.chaosentity.init.ChaosentitymodModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundGameEventPacket;
import net.minecraft.network.protocol.game.ClientboundLevelEventPacket;
import net.minecraft.network.protocol.game.ClientboundPlayerAbilitiesPacket;
import net.minecraft.network.protocol.game.ClientboundUpdateMobEffectPacket;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class PSSDimensionTeleportProcedure {
    @SubscribeEvent
    public static void onRightClickItem(PlayerInteractEvent.RightClickItem event) {
        if (event.getHand() != event.getEntity().m_7655_()) {
            return;
        }
        PSSDimensionTeleportProcedure.execute((Event)event, (Entity)event.getEntity());
    }

    public static void execute(Entity entity) {
        PSSDimensionTeleportProcedure.execute(null, entity);
    }

    private static void execute(@Nullable Event event, Entity entity) {
        ItemStack itemStack;
        ServerLevel nextLevel;
        ResourceKey destinationType;
        ServerPlayer _player;
        ItemStack itemStack2;
        LivingEntity _livEnt;
        if (entity == null) {
            return;
        }
        if (entity instanceof LivingEntity) {
            _livEnt = (LivingEntity)entity;
            itemStack2 = _livEnt.m_21205_();
        } else {
            itemStack2 = ItemStack.f_41583_;
        }
        if (itemStack2.m_41720_() == ChaosentitymodModItems.DIMENSION_APPLE.get() && ((Item)ChaosentitymodModItems.DIMENSION_APPLE.get()).m_41472_() && entity instanceof ServerPlayer && !(_player = (ServerPlayer)entity).m_9236_().m_5776_()) {
            destinationType = ResourceKey.m_135785_((ResourceKey)Registries.f_256858_, (ResourceLocation)new ResourceLocation("chaosentitymod:pss_dimension_portal"));
            if (_player.m_9236_().m_46472_() == destinationType) {
                return;
            }
            nextLevel = _player.f_8924_.m_129880_(destinationType);
            if (nextLevel != null) {
                _player.f_8906_.m_9829_((Packet)new ClientboundGameEventPacket(ClientboundGameEventPacket.f_132157_, 0.0f));
                _player.m_8999_(nextLevel, _player.m_20185_(), _player.m_20186_(), _player.m_20189_(), _player.m_146908_(), _player.m_146909_());
                _player.f_8906_.m_9829_((Packet)new ClientboundPlayerAbilitiesPacket(_player.m_150110_()));
                for (MobEffectInstance _effectinstance : _player.m_21220_()) {
                    _player.f_8906_.m_9829_((Packet)new ClientboundUpdateMobEffectPacket(_player.m_19879_(), _effectinstance));
                }
                _player.f_8906_.m_9829_((Packet)new ClientboundLevelEventPacket(1032, BlockPos.f_121853_, 0, false));
            }
        }
        if (entity instanceof LivingEntity) {
            _livEnt = (LivingEntity)entity;
            itemStack = _livEnt.m_21205_();
        } else {
            itemStack = ItemStack.f_41583_;
        }
        if (itemStack.m_41720_() == ChaosentitymodModItems.GOLD_DIMENSION_APPLE.get() && ((Item)ChaosentitymodModItems.GOLD_DIMENSION_APPLE.get()).m_41472_() && entity instanceof ServerPlayer && !(_player = (ServerPlayer)entity).m_9236_().m_5776_()) {
            destinationType = Level.f_46428_;
            if (_player.m_9236_().m_46472_() == destinationType) {
                return;
            }
            nextLevel = _player.f_8924_.m_129880_(destinationType);
            if (nextLevel != null) {
                _player.f_8906_.m_9829_((Packet)new ClientboundGameEventPacket(ClientboundGameEventPacket.f_132157_, 0.0f));
                _player.m_8999_(nextLevel, _player.m_20185_(), _player.m_20186_(), _player.m_20189_(), _player.m_146908_(), _player.m_146909_());
                _player.f_8906_.m_9829_((Packet)new ClientboundPlayerAbilitiesPacket(_player.m_150110_()));
                for (MobEffectInstance _effectinstance : _player.m_21220_()) {
                    _player.f_8906_.m_9829_((Packet)new ClientboundUpdateMobEffectPacket(_player.m_19879_(), _effectinstance));
                }
                _player.f_8906_.m_9829_((Packet)new ClientboundLevelEventPacket(1032, BlockPos.f_121853_, 0, false));
            }
        }
    }
}

