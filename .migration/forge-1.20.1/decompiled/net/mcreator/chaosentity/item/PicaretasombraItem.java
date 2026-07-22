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
 *  net.minecraftforge.api.distmarker.Dist
 *  net.minecraftforge.api.distmarker.OnlyIn
 */
package net.mcreator.chaosentity.item;

import net.mcreator.chaosentity.init.ChaosentitymodModItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class PicaretasombraItem
extends PickaxeItem {
    public PicaretasombraItem() {
        super(new Tier(){

            public int m_6609_() {
                return 9000;
            }

            public float m_6624_() {
                return 102.0f;
            }

            public float m_6631_() {
                return 38.0f;
            }

            public int m_6604_() {
                return 4;
            }

            public int m_6601_() {
                return 2;
            }

            public Ingredient m_6282_() {
                return Ingredient.m_43927_((ItemStack[])new ItemStack[]{new ItemStack((ItemLike)ChaosentitymodModItems.JOIASOMBRA.get())});
            }
        }, 1, -3.0f, new Item.Properties().m_41486_());
    }

    @OnlyIn(value=Dist.CLIENT)
    public boolean m_5812_(ItemStack itemstack) {
        return true;
    }
}

