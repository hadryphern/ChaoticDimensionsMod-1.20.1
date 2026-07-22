/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.world.effect.MobEffects
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.block.FlowerBlock
 *  net.minecraft.world.level.block.SoundType
 *  net.minecraft.world.level.block.state.BlockBehaviour$OffsetType
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.material.MapColor
 *  net.minecraft.world.level.material.PushReaction
 */
package net.mcreator.chaosentity.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

public class CrystalGreenPlantBlock
extends FlowerBlock {
    public CrystalGreenPlantBlock() {
        super(() -> MobEffects.f_19599_, 100, BlockBehaviour.Properties.m_284310_().m_284180_(MapColor.f_283915_).m_60918_(SoundType.f_56744_).m_60966_().m_60910_().m_222979_(BlockBehaviour.OffsetType.XZ).m_278166_(PushReaction.DESTROY));
    }

    public int m_53522_() {
        return 100;
    }

    public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return 100;
    }

    public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return 60;
    }
}

