/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.item.HoeItem
 *  net.minecraft.world.item.Item$Properties
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.Items
 *  net.minecraft.world.item.Tier
 *  net.minecraft.world.item.crafting.Ingredient
 *  net.minecraft.world.level.ItemLike
 */
package net.mcreator.chaosentity.item;

import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

public class EnxadaAmetistaItem
extends HoeItem {
    public EnxadaAmetistaItem() {
        super(new Tier(){

            public int m_6609_() {
                return 680;
            }

            public float m_6624_() {
                return 34.0f;
            }

            public float m_6631_() {
                return 3.0f;
            }

            public int m_6604_() {
                return 2;
            }

            public int m_6601_() {
                return 2;
            }

            public Ingredient m_6282_() {
                return Ingredient.m_43927_((ItemStack[])new ItemStack[]{new ItemStack((ItemLike)Items.f_151049_)});
            }
        }, 0, -3.0f, new Item.Properties());
    }
}

