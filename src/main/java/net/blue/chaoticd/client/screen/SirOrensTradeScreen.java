package net.blue.chaoticd.client.screen;

import net.blue.chaoticd.content.menu.SirOrensTradeMenu;
import net.blue.chaoticd.content.trade.SirOrensTrade;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;

/** A readable paged screen for the large, multi-item Sir. Orens offers. */
public final class SirOrensTradeScreen extends AbstractContainerScreen<SirOrensTradeMenu> {
    private static final int PANEL_COLOR = 0xEE170C23;
    private static final int BORDER_COLOR = 0xFF7953A3;
    private static final int LOCKED_COLOR = 0xFFE26A6A;
    private static final int AVAILABLE_COLOR = 0xFF8ED5FF;
    private static final int TEXT_COLOR = 0xFFF4E9FF;

    private int page;
    private Button completeTradeButton;

    public SirOrensTradeScreen(SirOrensTradeMenu menu, Inventory inventory, Component title) {
        super(menu, inventory, title);
        imageWidth = 362;
        imageHeight = 342;
    }

    @Override
    protected void init() {
        super.init();
        buildWidgets();
    }

    @Override
    public void containerTick() {
        super.containerTick();

        if (completeTradeButton != null) {
            completeTradeButton.active = currentTrade().level() <= menu.unlockedLevel();
        }
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
        renderBackground(graphics);
        super.render(graphics, mouseX, mouseY, partialTick);
        renderCostTooltips(graphics, mouseX, mouseY);
    }

    @Override
    protected void renderBg(GuiGraphics graphics, float partialTick, int mouseX, int mouseY) {
        graphics.fill(leftPos, topPos, leftPos + imageWidth, topPos + imageHeight, PANEL_COLOR);
        graphics.renderOutline(leftPos, topPos, imageWidth, imageHeight, BORDER_COLOR);
        graphics.fill(leftPos + 8, topPos + 31, leftPos + imageWidth - 8, topPos + 184, 0xB20B0611);
        graphics.renderOutline(leftPos + 8, topPos + 31, imageWidth - 16, 153, 0xFF4B335F);
        graphics.fill(leftPos + 8, topPos + 244, leftPos + 180, topPos + 332, 0x8A0B0611);
        graphics.renderOutline(leftPos + 8, topPos + 244, 172, 88, 0xFF4B335F);
    }

    @Override
    protected void renderLabels(GuiGraphics graphics, int mouseX, int mouseY) {
        SirOrensTrade trade = currentTrade();
        boolean unlocked = trade.level() <= menu.unlockedLevel();
        int stateColor = unlocked ? AVAILABLE_COLOR : LOCKED_COLOR;

        graphics.drawString(font, title, 12, 11, 0xFFF1C6FF, false);
        graphics.drawString(
            font,
            Component.translatable("container.chaoticd.sir_orens.level", trade.level()),
            12,
            22,
            stateColor,
            false
        );
        graphics.drawString(
            font,
            Component.translatable(unlocked
                ? "container.chaoticd.sir_orens.available"
                : "container.chaoticd.sir_orens.locked"),
            212,
            22,
            stateColor,
            false
        );

        graphics.drawString(
            font,
            Component.translatable("container.chaoticd.sir_orens.costs"),
            18,
            40,
            TEXT_COLOR,
            false
        );

        int y = 57;
        for (SirOrensTrade.Cost cost : trade.costs()) {
            ItemStack stack = cost.displayStack();
            graphics.renderItem(stack, 18, y - 3);
            graphics.renderItemDecorations(font, stack, 18, y - 3, Integer.toString(cost.count()));
            graphics.drawString(font, stack.getHoverName(), 40, y, TEXT_COLOR, false);
            y += 21;
        }

        ItemStack output = trade.outputStack();
        graphics.drawString(
            font,
            Component.translatable("container.chaoticd.sir_orens.reward"),
            205,
            57,
            0xFFFFDB77,
            false
        );
        graphics.renderItem(output, 207, 73);
        graphics.renderItemDecorations(font, output, 207, 73, Integer.toString(trade.outputCount()));
        graphics.drawString(font, output.getHoverName(), 229, 77, TEXT_COLOR, false);

        graphics.drawString(
            font,
            Component.translatable(
                "container.chaoticd.sir_orens.page",
                page + 1,
                SirOrensTrade.ALL.size()
            ),
            148,
            225,
            0xFFC8ADD8,
            false
        );

        graphics.drawString(font, playerInventoryTitle, 10, 242, 0xFFC8ADD8, false);
    }

    private void buildWidgets() {
        clearWidgets();

        completeTradeButton = addRenderableWidget(Button.builder(
            Component.translatable("container.chaoticd.sir_orens.complete_trade"),
            button -> requestTrade()
        ).bounds(leftPos + 102, topPos + 190, 158, 20).build());

        completeTradeButton.active = currentTrade().level() <= menu.unlockedLevel();

        addRenderableWidget(Button.builder(
            Component.literal("<"),
            button -> changePage(-1)
        ).bounds(leftPos + 12, topPos + 218, 20, 20).build()).active = page > 0;

        addRenderableWidget(Button.builder(
            Component.literal(">"),
            button -> changePage(1)
        ).bounds(leftPos + imageWidth - 32, topPos + 218, 20, 20).build()).active = page < SirOrensTrade.ALL.size() - 1;
    }

    private void changePage(int change) {
        page = Math.max(0, Math.min(SirOrensTrade.ALL.size() - 1, page + change));
        buildWidgets();
    }

    private void requestTrade() {
        if (minecraft != null && minecraft.gameMode != null) {
            minecraft.gameMode.handleInventoryButtonClick(menu.containerId, currentTrade().id());
        }
    }

    private SirOrensTrade currentTrade() {
        return SirOrensTrade.ALL.get(page);
    }

    private void renderCostTooltips(GuiGraphics graphics, int mouseX, int mouseY) {
        SirOrensTrade trade = currentTrade();
        int y = topPos + 54;

        for (SirOrensTrade.Cost cost : trade.costs()) {
            if (mouseX >= leftPos + 18 && mouseX < leftPos + 34
                && mouseY >= y && mouseY < y + 16) {
                graphics.renderTooltip(font, cost.displayStack(), mouseX, mouseY);
                return;
            }
            y += 21;
        }

        if (mouseX >= leftPos + 207 && mouseX < leftPos + 223
            && mouseY >= topPos + 73 && mouseY < topPos + 89) {
            graphics.renderTooltip(font, trade.outputStack(), mouseX, mouseY);
        }
    }
}
