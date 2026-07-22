/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.SoundType
 *  net.minecraft.world.level.block.StairBlock
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.properties.NoteBlockInstrument
 */
package net.mcreator.chaosentity.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;

public class FireStairsBlock
extends StairBlock {
    public FireStairsBlock() {
        super(() -> Blocks.f_50016_.m_49966_(), BlockBehaviour.Properties.m_284310_().m_278183_().m_280658_(NoteBlockInstrument.BASS).m_60918_(SoundType.f_56736_).m_60913_(6.0f, 4.0f));
    }

    public float m_7325_() {
        return 4.0f;
    }

    public boolean m_6724_(BlockState state) {
        return false;
    }

    public int m_7753_(BlockState state, BlockGetter worldIn, BlockPos pos) {
        return 0;
    }

    public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return 10;
    }
}

