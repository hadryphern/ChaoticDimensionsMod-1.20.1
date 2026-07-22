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

public class BlocoMadeiraBrancoBlock
extends Block {
    public BlocoMadeiraBrancoBlock() {
        super(BlockBehaviour.Properties.m_284310_().m_60918_(SoundType.f_56736_).m_60913_(1.0f, 10.0f));
    }

    public int m_7753_(BlockState state, BlockGetter worldIn, BlockPos pos) {
        return 15;
    }
}

