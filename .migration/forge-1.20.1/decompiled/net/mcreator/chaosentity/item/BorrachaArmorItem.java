/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EquipmentSlot
 *  net.minecraft.world.item.ArmorItem
 *  net.minecraft.world.item.ArmorItem$Type
 *  net.minecraft.world.item.ArmorMaterial
 *  net.minecraft.world.item.Item$Properties
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.crafting.Ingredient
 *  net.minecraftforge.registries.ForgeRegistries
 */
package net.mcreator.chaosentity.item;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.registries.ForgeRegistries;

public abstract class BorrachaArmorItem
extends ArmorItem {
    public BorrachaArmorItem(ArmorItem.Type type, Item.Properties properties) {
        super(new ArmorMaterial(){

            public int m_266425_(ArmorItem.Type type) {
                return (new int[]{13, 15, 16, 11})[type.m_266308_().m_20749_()] * 15;
            }

            public int m_7366_(ArmorItem.Type type) {
                return (new int[]{2, 5, 6, 2})[type.m_266308_().m_20749_()];
            }

            public int m_6646_() {
                return 9;
            }

            public SoundEvent m_7344_() {
                return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_leather"));
            }

            public Ingredient m_6230_() {
                return Ingredient.m_151265_();
            }

            public String m_6082_() {
                return "borracha_armor";
            }

            public float m_6651_() {
                return 0.0f;
            }

            public float m_6649_() {
                return 0.0f;
            }
        }, type, properties);
    }

    public static class Boots
    extends BorrachaArmorItem {
        public Boots() {
            super(ArmorItem.Type.BOOTS, new Item.Properties());
        }

        public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
            return "chaosentitymod:textures/models/armor/borracha_armor_layer_1.png";
        }
    }
}

