/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.block.ButtonBlock
 *  net.minecraft.world.level.block.SoundType
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.properties.BlockSetType
 *  net.minecraft.world.level.block.state.properties.NoteBlockInstrument
 */
package net.mcreator.chaosentity.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;

public class FireButtonBlock
extends ButtonBlock {
    public FireButtonBlock() {
        super(BlockBehaviour.Properties.m_284310_().m_278183_().m_280658_(NoteBlockInstrument.BASS).m_60918_(SoundType.f_56736_).m_60913_(4.0f, 6.0f), BlockSetType.f_271198_, 30, true);
    }

    public int m_7753_(BlockState state, BlockGetter worldIn, BlockPos pos) {
        return 0;
    }

    public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return 10;
    }
}

