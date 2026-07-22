/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.inventory.MenuType
 *  net.minecraftforge.common.extensions.IForgeMenuType
 *  net.minecraftforge.registries.DeferredRegister
 *  net.minecraftforge.registries.ForgeRegistries
 *  net.minecraftforge.registries.IForgeRegistry
 *  net.minecraftforge.registries.RegistryObject
 */
package net.mcreator.chaosentity.init;

import net.mcreator.chaosentity.world.inventory.MochilaCouroMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryObject;

public class ChaosentitymodModMenus {
    public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create((IForgeRegistry)ForgeRegistries.MENU_TYPES, (String)"chaosentitymod");
    public static final RegistryObject<MenuType<MochilaCouroMenu>> MOCHILA_COURO = REGISTRY.register("mochila_couro", () -> IForgeMenuType.create(MochilaCouroMenu::new));
}

