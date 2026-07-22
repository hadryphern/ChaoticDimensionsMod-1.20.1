/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.block.FenceBlock
 *  net.minecraft.world.level.block.SoundType
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 */
package net.mcreator.chaosentity.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class CercaMadeiraSombraBlock
extends FenceBlock {
    public CercaMadeiraSombraBlock() {
        super(BlockBehaviour.Properties.m_284310_().m_60918_(SoundType.f_56763_).m_60913_(1.0f, 10.0f).m_60955_().m_60924_((bs, br, bp) -> false).m_280606_());
    }

    public int m_7753_(BlockState state, BlockGetter worldIn, BlockPos pos) {
        return 0;
    }
}

