/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderSystem
 *  net.minecraft.client.gui.GuiGraphics
 *  net.minecraft.client.gui.screens.inventory.AbstractContainerScreen
 *  net.minecraft.network.chat.Component
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.entity.player.Inventory
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.inventory.AbstractContainerMenu
 *  net.minecraft.world.level.Level
 */
package net.mcreator.chaosentity.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.HashMap;
import net.mcreator.chaosentity.world.inventory.MochilaCouroMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.Level;

public class MochilaCouroScreen
extends AbstractContainerScreen<MochilaCouroMenu> {
    private static final HashMap<String, Object> guistate = MochilaCouroMenu.guistate;
    private final Level world;
    private final int x;
    private final int y;
    private final int z;
    private final Player entity;
    private static final ResourceLocation texture = new ResourceLocation("chaosentitymod:textures/screens/mochila_couro.png");

    public MochilaCouroScreen(MochilaCouroMenu container, Inventory inventory, Component text) {
        super((AbstractContainerMenu)container, inventory, text);
        this.world = container.world;
        this.x = container.x;
        this.y = container.y;
        this.z = container.z;
        this.entity = container.entity;
        this.f_97726_ = 226;
        this.f_97727_ = 195;
    }

    public void m_88315_(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
        this.m_280273_(guiGraphics);
        super.m_88315_(guiGraphics, mouseX, mouseY, partialTicks);
        this.m_280072_(guiGraphics, mouseX, mouseY);
    }

    protected void m_7286_(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
        RenderSystem.setShaderColor((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        guiGraphics.m_280163_(texture, this.f_97735_, this.f_97736_, 0.0f, 0.0f, this.f_97726_, this.f_97727_, this.f_97726_, this.f_97727_);
        RenderSystem.disableBlend();
    }

    public boolean m_7933_(int key, int b, int c) {
        if (key == 256) {
            this.f_96541_.f_91074_.m_6915_();
            return true;
        }
        return super.m_7933_(key, b, c);
    }

    protected void m_280003_(GuiGraphics guiGraphics, int mouseX, int mouseY) {
    }

    public void m_7856_() {
        super.m_7856_();
    }
}

