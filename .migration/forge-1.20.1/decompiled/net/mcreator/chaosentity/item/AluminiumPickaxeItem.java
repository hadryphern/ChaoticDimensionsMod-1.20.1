/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.item.Item$Properties
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.PickaxeItem
 *  net.minecraft.world.item.Tier
 *  net.minecraft.world.item.crafting.Ingredient
 *  net.minecraft.world.level.ItemLike
 */
package net.mcreator.chaosentity.item;

import net.mcreator.chaosentity.init.ChaosentitymodModItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

public class AluminiumPickaxeItem
extends PickaxeItem {
    public AluminiumPickaxeItem() {
        super(new Tier(){

            public int m_6609_() {
                return 441;
            }

            public float m_6624_() {
                return 8.0f;
            }

            public float m_6631_() {
                return 4.0f;
            }

            public int m_6604_() {
                return 3;
            }

            public int m_6601_() {
                return 21;
            }

            public Ingredient m_6282_() {
                return Ingredient.m_43927_((ItemStack[])new ItemStack[]{new ItemStack((ItemLike)ChaosentitymodModItems.ALUMINIUM_INGOT.get())});
            }
        }, 1, -2.0f, new Item.Properties());
    }
}

