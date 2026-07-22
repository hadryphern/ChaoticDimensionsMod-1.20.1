/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EquipmentSlot
 *  net.minecraft.world.item.ArmorItem
 *  net.minecraft.world.item.ArmorItem$Type
 *  net.minecraft.world.item.ArmorMaterial
 *  net.minecraft.world.item.Item$Properties
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.crafting.Ingredient
 *  net.minecraft.world.level.ItemLike
 */
package net.mcreator.chaosentity.item;

import net.mcreator.chaosentity.init.ChaosentitymodModItems;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

public abstract class TitaniumArmorItem
extends ArmorItem {
    public TitaniumArmorItem(ArmorItem.Type type, Item.Properties properties) {
        super(new ArmorMaterial(){

            public int m_266425_(ArmorItem.Type type) {
                return (new int[]{13, 15, 16, 11})[type.m_266308_().m_20749_()] * 26;
            }

            public int m_7366_(ArmorItem.Type type) {
                return (new int[]{3, 9, 10, 3})[type.m_266308_().m_20749_()];
            }

            public int m_6646_() {
                return 15;
            }

            public SoundEvent m_7344_() {
                return SoundEvents.f_271165_;
            }

            public Ingredient m_6230_() {
                return Ingredient.m_43927_((ItemStack[])new ItemStack[]{new ItemStack((ItemLike)ChaosentitymodModItems.TITANIUM_INGOT.get())});
            }

            public String m_6082_() {
                return "titanium_armor";
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
    extends TitaniumArmorItem {
        public Boots() {
            super(ArmorItem.Type.BOOTS, new Item.Properties());
        }

        public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
            return "chaosentitymod:textures/models/armor/titanium_layer_1.png";
        }
    }

    public static class Leggings
    extends TitaniumArmorItem {
        public Leggings() {
            super(ArmorItem.Type.LEGGINGS, new Item.Properties());
        }

        public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
            return "chaosentitymod:textures/models/armor/titanium_layer_2.png";
        }
    }

    public static class Chestplate
    extends TitaniumArmorItem {
        public Chestplate() {
            super(ArmorItem.Type.CHESTPLATE, new Item.Properties());
        }

        public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
            return "chaosentitymod:textures/models/armor/titanium_layer_1.png";
        }
    }

    public static class Helmet
    extends TitaniumArmorItem {
        public Helmet() {
            super(ArmorItem.Type.HELMET, new Item.Properties());
        }

        public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
            return "chaosentitymod:textures/models/armor/titanium_layer_1.png";
        }
    }
}

