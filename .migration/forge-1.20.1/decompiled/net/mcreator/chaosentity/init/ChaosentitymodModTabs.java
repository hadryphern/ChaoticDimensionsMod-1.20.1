/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.network.chat.Component
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.world.item.CreativeModeTab
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.Items
 *  net.minecraft.world.level.ItemLike
 *  net.minecraft.world.level.block.Block
 *  net.minecraftforge.registries.DeferredRegister
 *  net.minecraftforge.registries.RegistryObject
 */
package net.mcreator.chaosentity.init;

import net.mcreator.chaosentity.init.ChaosentitymodModBlocks;
import net.mcreator.chaosentity.init.ChaosentitymodModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ChaosentitymodModTabs {
    public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create((ResourceKey)Registries.f_279569_, (String)"chaosentitymod");
    public static final RegistryObject<CreativeModeTab> FERRAMENTAS = REGISTRY.register("ferramentas", () -> CreativeModeTab.builder().m_257941_((Component)Component.m_237115_((String)"item_group.chaosentitymod.ferramentas")).m_257737_(() -> new ItemStack((ItemLike)ChaosentitymodModItems.ESPADA_VORTEX.get())).m_257501_((parameters, tabData) -> {
        tabData.m_246326_((ItemLike)ChaosentitymodModItems.ESPADA_VORTEX.get());
        tabData.m_246326_((ItemLike)ChaosentitymodModItems.ESPADASOMBRA.get());
        tabData.m_246326_((ItemLike)ChaosentitymodModItems.PICARETASOMBRA.get());
        tabData.m_246326_((ItemLike)ChaosentitymodModItems.ESPADA_AMETISTA.get());
        tabData.m_246326_((ItemLike)ChaosentitymodModItems.PICARETA_AMETISTA.get());
        tabData.m_246326_((ItemLike)ChaosentitymodModItems.MACHADO_AMETISTA.get());
        tabData.m_246326_((ItemLike)ChaosentitymodModItems.PA_AMETISTA.get());
        tabData.m_246326_((ItemLike)ChaosentitymodModItems.ENXADA_AMETISTA.get());
        tabData.m_246326_((ItemLike)ChaosentitymodModItems.ESPADA_ESMERALDA.get());
        tabData.m_246326_((ItemLike)ChaosentitymodModItems.PICARETA_ESMERALDA.get());
        tabData.m_246326_((ItemLike)ChaosentitymodModItems.MACHADO_ESMERALDA.get());
        tabData.m_246326_((ItemLike)ChaosentitymodModItems.PA_ESMERALDA.get());
        tabData.m_246326_((ItemLike)ChaosentitymodModItems.ENXADA_ESMERALDA.get());
        tabData.m_246326_((ItemLike)ChaosentitymodModItems.MULTI_ESMERALDA.get());
        tabData.m_246326_((ItemLike)ChaosentitymodModItems.ESPADA_RUBY.get());
        tabData.m_246326_((ItemLike)ChaosentitymodModItems.PICARETA_RUBY.get());
        tabData.m_246326_((ItemLike)ChaosentitymodModItems.MACHADO_RUBY.get());
        tabData.m_246326_((ItemLike)ChaosentitymodModItems.PA_RUBY.get());
        tabData.m_246326_((ItemLike)ChaosentitymodModItems.ENXADA_RUBY.get());
        tabData.m_246326_((ItemLike)ChaosentitymodModItems.ESPADA_MADEIRA_SOMBRA.get());
        tabData.m_246326_((ItemLike)ChaosentitymodModItems.PICARETA_MADEIRA_SOMBRA.get());
        tabData.m_246326_((ItemLike)ChaosentitymodModItems.PA_MADEIRA_SOMBRA.get());
        tabData.m_246326_((ItemLike)ChaosentitymodModItems.MACHADO_MADEIRA_SOMBRA.get());
        tabData.m_246326_((ItemLike)ChaosentitymodModItems.ENXADA_MADEIRA_SOMBRA.get());
        tabData.m_246326_((ItemLike)ChaosentitymodModItems.ALUMINIUM_SWORD.get());
        tabData.m_246326_((ItemLike)ChaosentitymodModItems.ALUMINIUM_PICKAXE.get());
        tabData.m_246326_((ItemLike)ChaosentitymodModItems.ALUMINIUM_AXE.get());
        tabData.m_246326_((ItemLike)ChaosentitymodModItems.ALUMINIUM_SHOVEL.get());
        tabData.m_246326_((ItemLike)ChaosentitymodModItems.ALUMINIUM_HOE.get());
        tabData.m_246326_((ItemLike)ChaosentitymodModItems.TITANIUM_SWORD.get());
        tabData.m_246326_((ItemLike)ChaosentitymodModItems.TITANIUM_SHOVEL.get());
        tabData.m_246326_((ItemLike)ChaosentitymodModItems.TITANIUM_PICKAXE.get());
        tabData.m_246326_((ItemLike)ChaosentitymodModItems.TITANIUM_AXE.get());
        tabData.m_246326_((ItemLike)ChaosentitymodModItems.TOXIC_SWORD.get());
        tabData.m_246326_((ItemLike)ChaosentitymodModItems.TOXIC_PICKAXE.get());
        tabData.m_246326_((ItemLike)ChaosentitymodModItems.TOXIC_AXE.get());
        tabData.m_246326_((ItemLike)ChaosentitymodModItems.TOXIC_SHOVEL.get());
        tabData.m_246326_((ItemLike)ChaosentitymodModItems.TOXIC_HOE.get());
        tabData.m_246326_((ItemLike)ChaosentitymodModItems.TITANIUM_HOE.get());
    }).withSearchBar().m_257652_());
    public static final RegistryObject<CreativeModeTab> ENTITYS = REGISTRY.register("entitys", () -> CreativeModeTab.builder().m_257941_((Component)Component.m_237115_((String)"item_group.chaosentitymod.entitys")).m_257737_(() -> new ItemStack((ItemLike)Items.f_254703_)).m_257501_((parameters, tabData) -> {
        tabData.m_246326_((ItemLike)ChaosentitymodModItems.DIMENSION_PIG_SPAWN_EGG.get());
        tabData.m_246326_((ItemLike)ChaosentitymodModItems.GOLD_DIMENSION_PIG_SPAWN_EGG.get());
        tabData.m_246326_((ItemLike)ChaosentitymodModItems.APPLE_COW_SPAWN_EGG.get());
        tabData.m_246326_((ItemLike)ChaosentitymodModItems.GOLDEN_APPLE_COW_SPAWN_EGG.get());
        tabData.m_246326_((ItemLike)ChaosentitymodModItems.CRYSTAL_CREEPER_SPAWN_EGG.get());
        tabData.m_246326_((ItemLike)ChaosentitymodModItems.CRYSTAL_APPLE_COW_SPAWN_EGG.get());
        tabData.m_246326_((ItemLike)ChaosentitymodModItems.CRYSTAL_GOLDEN_APPLE_SPAWN_EGG.get());
    }).withSearchBar().m_257652_());
    public static final RegistryObject<CreativeModeTab> MINERIOS = REGISTRY.register("minerios", () -> CreativeModeTab.builder().m_257941_((Component)Component.m_237115_((String)"item_group.chaosentitymod.minerios")).m_257737_(() -> new ItemStack((ItemLike)ChaosentitymodModItems.TITANIUM_INGOT.get())).m_257501_((parameters, tabData) -> {
        tabData.m_246326_((ItemLike)ChaosentitymodModItems.JOIASOMBRA.get());
        tabData.m_246326_((ItemLike)ChaosentitymodModItems.PEPITASOMBRA.get());
        tabData.m_246326_((ItemLike)ChaosentitymodModItems.GEMAROSALITA.get());
        tabData.m_246326_((ItemLike)ChaosentitymodModItems.JOIAVORTEX.get());
        tabData.m_246326_((ItemLike)ChaosentitymodModItems.RUBY.get());
        tabData.m_246326_((ItemLike)ChaosentitymodModItems.ALUMINIUM_INGOT.get());
        tabData.m_246326_((ItemLike)ChaosentitymodModItems.TITANIUM_INGOT.get());
        tabData.m_246326_((ItemLike)ChaosentitymodModItems.TOXIC_INGOT.get());
    }).withSearchBar().m_257652_());
    public static final RegistryObject<CreativeModeTab> BLOCOS = REGISTRY.register("blocos", () -> CreativeModeTab.builder().m_257941_((Component)Component.m_237115_((String)"item_group.chaosentitymod.blocos")).m_257737_(() -> new ItemStack((ItemLike)ChaosentitymodModBlocks.CERCA_MADEIRA_SOMBRA.get())).m_257501_((parameters, tabData) -> {
        tabData.m_246326_((ItemLike)((Block)ChaosentitymodModBlocks.BLOCO_MADEIRA_BRANCO.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)ChaosentitymodModBlocks.TABUA_SOMBRA.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)ChaosentitymodModBlocks.SLAB_MADEIRA_SOMBRA.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)ChaosentitymodModBlocks.ESCADA_MADEIRA_SOMBRA.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)ChaosentitymodModBlocks.CERCA_MADEIRA_SOMBRA.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)ChaosentitymodModBlocks.PORTA_MADEIRA_SOMBRA.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)ChaosentitymodModBlocks.TRAP_DOOR_MADEIRA_SOMBRA.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)ChaosentitymodModBlocks.PORTAO_MADEIRA_SOMBRA.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)ChaosentitymodModBlocks.PLACA_PRESSAO_MADEIRA_SOMBRA.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)ChaosentitymodModBlocks.BOTAO_MADEIRA_SOMBRA.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)ChaosentitymodModBlocks.BLOCOSOMBRA.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)ChaosentitymodModBlocks.BLOCO_RUBY.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)ChaosentitymodModBlocks.ALUMINIUM_BLOCK.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)ChaosentitymodModBlocks.TITANIUM_BLOCK.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)ChaosentitymodModBlocks.TOXIC_BLOCK.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)ChaosentitymodModBlocks.FIRE_WOOD.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)ChaosentitymodModBlocks.FIRE_PLANKS.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)ChaosentitymodModBlocks.FIRE_STAIRS.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)ChaosentitymodModBlocks.FIRE_SLAB.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)ChaosentitymodModBlocks.FIRE_FENCE.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)ChaosentitymodModBlocks.FIRE_FENCE_GATE.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)ChaosentitymodModBlocks.FIRE_PRESSURE_PLATE.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)ChaosentitymodModBlocks.FIRE_BUTTON.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)ChaosentitymodModBlocks.CRYSTAL_PLANKS.get()).m_5456_());
    }).withSearchBar().m_257652_());
    public static final RegistryObject<CreativeModeTab> UTEIS = REGISTRY.register("uteis", () -> CreativeModeTab.builder().m_257941_((Component)Component.m_237115_((String)"item_group.chaosentitymod.uteis")).m_257737_(() -> new ItemStack((ItemLike)ChaosentitymodModItems.GEMAROSALITA.get())).m_257501_((parameters, tabData) -> {
        tabData.m_246326_((ItemLike)ChaosentitymodModItems.GRAVETOBEDROCK.get());
        tabData.m_246326_((ItemLike)ChaosentitymodModItems.GRAVETO_SOMBRA.get());
        tabData.m_246326_((ItemLike)ChaosentitymodModItems.TOTEM_SOMBRA.get());
        tabData.m_246326_((ItemLike)ChaosentitymodModItems.BORRACHA_ARMOR_BOOTS.get());
        tabData.m_246326_((ItemLike)ChaosentitymodModItems.DIMENSION_APPLE.get());
        tabData.m_246326_((ItemLike)ChaosentitymodModItems.GOLD_DIMENSION_APPLE.get());
        tabData.m_246326_((ItemLike)ChaosentitymodModItems.CRYSTAL_EYE.get());
    }).withSearchBar().m_257652_());
    public static final RegistryObject<CreativeModeTab> ARMADURAS = REGISTRY.register("armaduras", () -> CreativeModeTab.builder().m_257941_((Component)Component.m_237115_((String)"item_group.chaosentitymod.armaduras")).m_257737_(() -> new ItemStack((ItemLike)ChaosentitymodModItems.TITANIUM_ARMOR_CHESTPLATE.get())).m_257501_((parameters, tabData) -> {
        tabData.m_246326_((ItemLike)ChaosentitymodModItems.ARMADURA_AMETISTA_HELMET.get());
        tabData.m_246326_((ItemLike)ChaosentitymodModItems.ARMADURA_AMETISTA_CHESTPLATE.get());
        tabData.m_246326_((ItemLike)ChaosentitymodModItems.ARMADURA_AMETISTA_LEGGINGS.get());
        tabData.m_246326_((ItemLike)ChaosentitymodModItems.ARMADURA_AMETISTA_BOOTS.get());
        tabData.m_246326_((ItemLike)ChaosentitymodModItems.ARMADURA_ESMERALDA_HELMET.get());
        tabData.m_246326_((ItemLike)ChaosentitymodModItems.ARMADURA_ESMERALDA_CHESTPLATE.get());
        tabData.m_246326_((ItemLike)ChaosentitymodModItems.ARMADURA_ESMERALDA_LEGGINGS.get());
        tabData.m_246326_((ItemLike)ChaosentitymodModItems.ARMADURA_ESMERALDA_BOOTS.get());
        tabData.m_246326_((ItemLike)ChaosentitymodModItems.ARMADURA_RUBY_HELMET.get());
        tabData.m_246326_((ItemLike)ChaosentitymodModItems.ARMADURA_RUBY_CHESTPLATE.get());
        tabData.m_246326_((ItemLike)ChaosentitymodModItems.ARMADURA_RUBY_LEGGINGS.get());
        tabData.m_246326_((ItemLike)ChaosentitymodModItems.ARMADURA_RUBY_BOOTS.get());
        tabData.m_246326_((ItemLike)ChaosentitymodModItems.ALUMINIUM_ARMOR_HELMET.get());
        tabData.m_246326_((ItemLike)ChaosentitymodModItems.ALUMINIUM_ARMOR_CHESTPLATE.get());
        tabData.m_246326_((ItemLike)ChaosentitymodModItems.ALUMINIUM_ARMOR_LEGGINGS.get());
        tabData.m_246326_((ItemLike)ChaosentitymodModItems.ALUMINIUM_ARMOR_BOOTS.get());
        tabData.m_246326_((ItemLike)ChaosentitymodModItems.TITANIUM_ARMOR_HELMET.get());
        tabData.m_246326_((ItemLike)ChaosentitymodModItems.TITANIUM_ARMOR_CHESTPLATE.get());
        tabData.m_246326_((ItemLike)ChaosentitymodModItems.TITANIUM_ARMOR_LEGGINGS.get());
        tabData.m_246326_((ItemLike)ChaosentitymodModItems.TITANIUM_ARMOR_BOOTS.get());
        tabData.m_246326_((ItemLike)ChaosentitymodModItems.TOXIC_ARMOR_HELMET.get());
        tabData.m_246326_((ItemLike)ChaosentitymodModItems.TOXIC_ARMOR_CHESTPLATE.get());
        tabData.m_246326_((ItemLike)ChaosentitymodModItems.TOXIC_ARMOR_LEGGINGS.get());
        tabData.m_246326_((ItemLike)ChaosentitymodModItems.TOXIC_ARMOR_BOOTS.get());
    }).withSearchBar().m_257652_());
    public static final RegistryObject<CreativeModeTab> NATURAL_BLOCKS = REGISTRY.register("natural_blocks", () -> CreativeModeTab.builder().m_257941_((Component)Component.m_237115_((String)"item_group.chaosentitymod.natural_blocks")).m_257737_(() -> new ItemStack((ItemLike)ChaosentitymodModBlocks.BLOCO_GRAMA_BRANCO.get())).m_257501_((parameters, tabData) -> {
        tabData.m_246326_((ItemLike)((Block)ChaosentitymodModBlocks.MINERIOSOMBRA.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)ChaosentitymodModBlocks.ROSALITABLOCO.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)ChaosentitymodModBlocks.MINERIO_RUBY.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)ChaosentitymodModBlocks.MADEIRA_SOMBRA.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)ChaosentitymodModBlocks.FOLHA_SOMBRA.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)ChaosentitymodModBlocks.PEDRA_SOMBRA.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)ChaosentitymodModBlocks.GRAMA_SOMBRA.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)ChaosentitymodModBlocks.COBBLESTONE_NEGRA.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)ChaosentitymodModBlocks.BLOCO_GRAMA_BRANCO.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)ChaosentitymodModBlocks.MADEIRA_BRUTA_BRANCA.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)ChaosentitymodModBlocks.BLOCO_FOLHA_BRANCA.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)ChaosentitymodModBlocks.TERRA_BRANCA.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)ChaosentitymodModBlocks.ALUMINIUM_ORE.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)ChaosentitymodModBlocks.TITANIUM_ORE.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)ChaosentitymodModBlocks.TOXIC_ORE.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)ChaosentitymodModBlocks.FIRE_LOG.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)ChaosentitymodModBlocks.FIRE_LEAVES.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)ChaosentitymodModBlocks.VANILLA_2_LEAVES.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)ChaosentitymodModBlocks.TERRA_SOMBRA.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)ChaosentitymodModBlocks.CRYSTAL_DIRT.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)ChaosentitymodModBlocks.CRYSTAL_GRASS_BLOCK.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)ChaosentitymodModBlocks.CRYSTAL_LOG.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)ChaosentitymodModBlocks.CRYSTAL_RED_PLANT.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)ChaosentitymodModBlocks.CRYSTAL_LEAVES_1.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)ChaosentitymodModBlocks.CRYSTAL_LEAVES_2.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)ChaosentitymodModBlocks.CRYSTAL_LEAVES_3.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)ChaosentitymodModBlocks.CRYSTAL_YELLOW_PLANT.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)ChaosentitymodModBlocks.CRYSTAL_BLUE_PLANT.get()).m_5456_());
        tabData.m_246326_((ItemLike)((Block)ChaosentitymodModBlocks.CRYSTAL_GREEN_PLANT.get()).m_5456_());
    }).m_257652_());
}

