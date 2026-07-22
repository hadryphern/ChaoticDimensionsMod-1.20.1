/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.block.FallingBlock
 *  net.minecraft.world.level.block.SoundType
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 */
package net.mcreator.chaosentity.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class BlocosombraBlock
extends FallingBlock {
    public BlocosombraBlock() {
        super(BlockBehaviour.Properties.m_284310_().m_60918_(SoundType.f_56739_).m_60913_(7.0f, 100.0f).m_60953_(s -> 15).m_60910_().m_60956_(0.0f).m_60967_(-0.7f));
    }

    public int m_7753_(BlockState state, BlockGetter worldIn, BlockPos pos) {
        return 15;
    }
}

