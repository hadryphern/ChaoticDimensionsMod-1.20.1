/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.screens.MenuScreens
 *  net.minecraft.world.inventory.MenuType
 *  net.minecraftforge.api.distmarker.Dist
 *  net.minecraftforge.eventbus.api.SubscribeEvent
 *  net.minecraftforge.fml.common.Mod$EventBusSubscriber
 *  net.minecraftforge.fml.common.Mod$EventBusSubscriber$Bus
 *  net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent
 */
package net.mcreator.chaosentity.init;

import net.mcreator.chaosentity.client.gui.MochilaCouroScreen;
import net.mcreator.chaosentity.init.ChaosentitymodModMenus;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD, value={Dist.CLIENT})
public class ChaosentitymodModScreens {
    @SubscribeEvent
    public static void clientLoad(FMLClientSetupEvent event) {
        event.enqueueWork(() -> MenuScreens.m_96206_((MenuType)((MenuType)ChaosentitymodModMenus.MOCHILA_COURO.get()), MochilaCouroScreen::new));
    }
}

