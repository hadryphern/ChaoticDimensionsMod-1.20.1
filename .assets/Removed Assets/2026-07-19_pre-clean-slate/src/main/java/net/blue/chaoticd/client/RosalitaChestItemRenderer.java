package net.blue.chaoticd.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.blue.chaoticd.content.block.ModBlocks;
import net.blue.chaoticd.content.block.entity.RosalitaChestBlockEntity;
import net.blue.chaoticd.content.item.ModItems;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

/** Uses the Rosalita chest block-entity renderer for the 3D inventory item. */
public final class RosalitaChestItemRenderer {
    private static final RosalitaChestBlockEntity CHEST = new RosalitaChestBlockEntity(
        BlockPos.ZERO, ModBlocks.get("rosalita_chest").defaultBlockState());

    private RosalitaChestItemRenderer() {
    }

    public static void initialize() {
        BuiltinItemRendererRegistry.INSTANCE.register(ModItems.get("rosalita_chest"),
            RosalitaChestItemRenderer::render);
    }

    private static void render(ItemStack stack, ItemDisplayContext mode, PoseStack poseStack,
                               MultiBufferSource buffers, int packedLight, int packedOverlay) {
        Minecraft.getInstance().getBlockEntityRenderDispatcher().renderItem(CHEST, poseStack, buffers,
            packedLight, packedOverlay);
    }
}
