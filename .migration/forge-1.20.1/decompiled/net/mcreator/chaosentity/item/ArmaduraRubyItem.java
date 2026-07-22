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
 *  net.minecraft.world.level.ItemLike
 *  net.minecraftforge.registries.ForgeRegistries
 */
package net.mcreator.chaosentity.item;

import net.mcreator.chaosentity.init.ChaosentitymodModItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.registries.ForgeRegistries;

public abstract class ArmaduraRubyItem
extends ArmorItem {
    public ArmaduraRubyItem(ArmorItem.Type type, Item.Properties properties) {
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
                return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_diamond"));
            }

            public Ingredient m_6230_() {
                return Ingredient.m_43927_((ItemStack[])new ItemStack[]{new ItemStack((ItemLike)ChaosentitymodModItems.RUBY.get())});
            }

            public String m_6082_() {
                return "armadura_ruby";
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
    extends ArmaduraRubyItem {
        public Boots() {
            super(ArmorItem.Type.BOOTS, new Item.Properties());
        }

        public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
            return "chaosentitymod:textures/models/armor/armadura_de_ruby_layer_1.png";
        }
    }

    public static class Leggings
    extends ArmaduraRubyItem {
        public Leggings() {
            super(ArmorItem.Type.LEGGINGS, new Item.Properties());
        }

        public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
            return "chaosentitymod:textures/models/armor/armadura_de_ruby_layer_2.png";
        }
    }

    public static class Chestplate
    extends ArmaduraRubyItem {
        public Chestplate() {
            super(ArmorItem.Type.CHESTPLATE, new Item.Properties());
        }

        public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
            return "chaosentitymod:textures/models/armor/armadura_de_ruby_layer_1.png";
        }
    }

    public static class Helmet
    extends ArmaduraRubyItem {
        public Helmet() {
            super(ArmorItem.Type.HELMET, new Item.Properties());
        }

        public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
            return "chaosentitymod:textures/models/armor/armadura_de_ruby_layer_1.png";
        }
    }
}

