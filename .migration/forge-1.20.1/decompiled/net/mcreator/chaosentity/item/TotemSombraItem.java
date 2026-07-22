/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.Item$Properties
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.Rarity
 *  net.minecraftforge.api.distmarker.Dist
 *  net.minecraftforge.api.distmarker.OnlyIn
 */
package net.mcreator.chaosentity.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class TotemSombraItem
extends Item {
    public TotemSombraItem() {
        super(new Item.Properties().m_41487_(1).m_41497_(Rarity.RARE));
    }

    @OnlyIn(value=Dist.CLIENT)
    public boolean m_5812_(ItemStack itemstack) {
        return true;
    }
}

