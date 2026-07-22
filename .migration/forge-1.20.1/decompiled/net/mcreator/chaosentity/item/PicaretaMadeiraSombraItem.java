/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.item.Item$Properties
 *  net.minecraft.world.item.PickaxeItem
 *  net.minecraft.world.item.Tier
 *  net.minecraft.world.item.crafting.Ingredient
 */
package net.mcreator.chaosentity.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

public class PicaretaMadeiraSombraItem
extends PickaxeItem {
    public PicaretaMadeiraSombraItem() {
        super(new Tier(){

            public int m_6609_() {
                return 100;
            }

            public float m_6624_() {
                return 7.0f;
            }

            public float m_6631_() {
                return 2.0f;
            }

            public int m_6604_() {
                return 0;
            }

            public int m_6601_() {
                return 2;
            }

            public Ingredient m_6282_() {
                return Ingredient.m_151265_();
            }
        }, 1, -3.0f, new Item.Properties());
    }
}

