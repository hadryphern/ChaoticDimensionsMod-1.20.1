/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.core.Direction$Axis
 *  net.minecraft.world.item.context.BlockPlaceContext
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.Rotation
 *  net.minecraft.world.level.block.SoundType
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.StateDefinition$Builder
 *  net.minecraft.world.level.block.state.properties.BlockStateProperties
 *  net.minecraft.world.level.block.state.properties.EnumProperty
 *  net.minecraft.world.level.block.state.properties.NoteBlockInstrument
 *  net.minecraft.world.level.block.state.properties.Property
 */
package net.mcreator.chaosentity.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.Property;

public class FireLogBlock
extends Block {
    public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.f_61365_;

    public FireLogBlock() {
        super(BlockBehaviour.Properties.m_284310_().m_278183_().m_280658_(NoteBlockInstrument.BASS).m_60918_(SoundType.f_56736_).m_60913_(4.0f, 3.4822023f));
        this.m_49959_((BlockState)((BlockState)this.f_49792_.m_61090_()).m_61124_(AXIS, (Comparable)Direction.Axis.Y));
    }

    public int m_7753_(BlockState state, BlockGetter worldIn, BlockPos pos) {
        return 15;
    }

    protected void m_7926_(StateDefinition.Builder<Block, BlockState> builder) {
        super.m_7926_(builder);
        builder.m_61104_(new Property[]{AXIS});
    }

    public BlockState m_5573_(BlockPlaceContext context) {
        return (BlockState)super.m_5573_(context).m_61124_(AXIS, (Comparable)context.m_43719_().m_122434_());
    }

    public BlockState m_6843_(BlockState state, Rotation rot) {
        if (rot == Rotation.CLOCKWISE_90 || rot == Rotation.COUNTERCLOCKWISE_90) {
            if (state.m_61143_(AXIS) == Direction.Axis.X) {
                return (BlockState)state.m_61124_(AXIS, (Comparable)Direction.Axis.Z);
            }
            if (state.m_61143_(AXIS) == Direction.Axis.Z) {
                return (BlockState)state.m_61124_(AXIS, (Comparable)Direction.Axis.X);
            }
        }
        return state;
    }

    public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return 10;
    }
}

