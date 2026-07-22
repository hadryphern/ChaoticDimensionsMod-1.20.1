/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableMultimap
 *  com.google.common.collect.ImmutableMultimap$Builder
 *  com.google.common.collect.Multimap
 *  net.minecraft.core.BlockPos
 *  net.minecraft.tags.BlockTags
 *  net.minecraft.world.entity.EquipmentSlot
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.ai.attributes.Attribute
 *  net.minecraft.world.entity.ai.attributes.AttributeModifier
 *  net.minecraft.world.entity.ai.attributes.AttributeModifier$Operation
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.item.Item$Properties
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.Items
 *  net.minecraft.world.item.Tier
 *  net.minecraft.world.item.TieredItem
 *  net.minecraft.world.item.crafting.Ingredient
 *  net.minecraft.world.level.ItemLike
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraftforge.common.ToolAction
 *  net.minecraftforge.common.ToolActions
 */
package net.mcreator.chaosentity.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;

public class MultiEsmeraldaItem
extends TieredItem {
    public MultiEsmeraldaItem() {
        super(new Tier(){

            public int m_6609_() {
                return 868;
            }

            public float m_6624_() {
                return 74.0f;
            }

            public float m_6631_() {
                return 52.0f;
            }

            public int m_6604_() {
                return 2;
            }

            public int m_6601_() {
                return 2;
            }

            public Ingredient m_6282_() {
                return Ingredient.m_43927_((ItemStack[])new ItemStack[]{new ItemStack((ItemLike)Items.f_42616_)});
            }
        }, new Item.Properties());
    }

    public boolean m_8096_(BlockState blockstate) {
        return !blockstate.m_204336_(BlockTags.f_144284_);
    }

    public boolean canPerformAction(ItemStack stack, ToolAction toolAction) {
        return ToolActions.DEFAULT_AXE_ACTIONS.contains(toolAction) || ToolActions.DEFAULT_HOE_ACTIONS.contains(toolAction) || ToolActions.DEFAULT_SHOVEL_ACTIONS.contains(toolAction) || ToolActions.DEFAULT_PICKAXE_ACTIONS.contains(toolAction) || ToolActions.DEFAULT_SWORD_ACTIONS.contains(toolAction);
    }

    public float m_8102_(ItemStack itemstack, BlockState blockstate) {
        return 74.0f;
    }

    public Multimap<Attribute, AttributeModifier> m_7167_(EquipmentSlot equipmentSlot) {
        if (equipmentSlot == EquipmentSlot.MAINHAND) {
            ImmutableMultimap.Builder builder = ImmutableMultimap.builder();
            builder.putAll(super.m_7167_(equipmentSlot));
            builder.put((Object)Attributes.f_22281_, (Object)new AttributeModifier(f_41374_, "Tool modifier", 53.0, AttributeModifier.Operation.ADDITION));
            builder.put((Object)Attributes.f_22283_, (Object)new AttributeModifier(f_41375_, "Tool modifier", 1.0, AttributeModifier.Operation.ADDITION));
            return builder.build();
        }
        return super.m_7167_(equipmentSlot);
    }

    public boolean m_6813_(ItemStack itemstack, Level world, BlockState blockstate, BlockPos pos, LivingEntity entity) {
        itemstack.m_41622_(1, entity, i -> i.m_21166_(EquipmentSlot.MAINHAND));
        return true;
    }

    public boolean m_7579_(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
        itemstack.m_41622_(2, entity, i -> i.m_21166_(EquipmentSlot.MAINHAND));
        return true;
    }
}

