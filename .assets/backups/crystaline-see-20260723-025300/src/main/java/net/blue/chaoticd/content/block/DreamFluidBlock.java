package net.blue.chaoticd.content.block;

import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.FlowingFluid;

/** Public constructor wrapper around Minecraft's protected LiquidBlock constructor. */
public final class DreamFluidBlock extends LiquidBlock {
    public DreamFluidBlock(
        FlowingFluid fluid,
        BlockBehaviour.Properties properties
    ) {
        super(fluid, properties);
    }
}
