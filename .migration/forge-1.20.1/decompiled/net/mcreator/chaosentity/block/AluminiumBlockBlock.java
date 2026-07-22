/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.SoundType
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 */
package net.mcreator.chaosentity.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class AluminiumBlockBlock
extends Block {
    public AluminiumBlockBlock() {
        super(BlockBehaviour.Properties.m_284310_().m_60918_(SoundType.f_56743_).m_60913_(5.0f, 10.0f).m_60999_());
    }

    public int m_7753_(BlockState state, BlockGetter worldIn, BlockPos pos) {
        return 15;
    }
}

