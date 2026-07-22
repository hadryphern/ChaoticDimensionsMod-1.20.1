/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.item.BlockItem
 *  net.minecraft.world.item.DoubleHighBlockItem
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.Item$Properties
 *  net.minecraft.world.level.block.Block
 *  net.minecraftforge.common.ForgeSpawnEggItem
 *  net.minecraftforge.registries.DeferredRegister
 *  net.minecraftforge.registries.ForgeRegistries
 *  net.minecraftforge.registries.IForgeRegistry
 *  net.minecraftforge.registries.RegistryObject
 */
package net.mcreator.chaosentity.init;

import net.mcreator.chaosentity.init.ChaosentitymodModBlocks;
import net.mcreator.chaosentity.init.ChaosentitymodModEntities;
import net.mcreator.chaosentity.item.AluminiumArmorItem;
import net.mcreator.chaosentity.item.AluminiumAxeItem;
import net.mcreator.chaosentity.item.AluminiumHoeItem;
import net.mcreator.chaosentity.item.AluminiumIngotItem;
import net.mcreator.chaosentity.item.AluminiumPickaxeItem;
import net.mcreator.chaosentity.item.AluminiumShovelItem;
import net.mcreator.chaosentity.item.AluminiumSwordItem;
import net.mcreator.chaosentity.item.ArmaduraAmetistaItem;
import net.mcreator.chaosentity.item.ArmaduraEsmeraldaItem;
import net.mcreator.chaosentity.item.ArmaduraRubyItem;
import net.mcreator.chaosentity.item.BorrachaArmorItem;
import net.mcreator.chaosentity.item.CrystalEyeItem;
import net.mcreator.chaosentity.item.DimensionAppleItem;
import net.mcreator.chaosentity.item.EnxadaAmetistaItem;
import net.mcreator.chaosentity.item.EnxadaEsmeraldaItem;
import net.mcreator.chaosentity.item.EnxadaMadeiraSombraItem;
import net.mcreator.chaosentity.item.EnxadaRubyItem;
import net.mcreator.chaosentity.item.EspadaAmetistaItem;
import net.mcreator.chaosentity.item.EspadaEsmeraldaItem;
import net.mcreator.chaosentity.item.EspadaMadeiraSombraItem;
import net.mcreator.chaosentity.item.EspadaRubyItem;
import net.mcreator.chaosentity.item.EspadaVortexItem;
import net.mcreator.chaosentity.item.EspadasombraItem;
import net.mcreator.chaosentity.item.GemarosalitaItem;
import net.mcreator.chaosentity.item.GoldDimensionAppleItem;
import net.mcreator.chaosentity.item.GravetoSombraItem;
import net.mcreator.chaosentity.item.GravetobedrockItem;
import net.mcreator.chaosentity.item.JoiasombraItem;
import net.mcreator.chaosentity.item.JoiavortexItem;
import net.mcreator.chaosentity.item.MachadoAmetistaItem;
import net.mcreator.chaosentity.item.MachadoEsmeraldaItem;
import net.mcreator.chaosentity.item.MachadoMadeiraSombraItem;
import net.mcreator.chaosentity.item.MachadoRubyItem;
import net.mcreator.chaosentity.item.MultiEsmeraldaItem;
import net.mcreator.chaosentity.item.PaAmetistaItem;
import net.mcreator.chaosentity.item.PaEsmeraldaItem;
import net.mcreator.chaosentity.item.PaMadeiraSombraItem;
import net.mcreator.chaosentity.item.PaRubyItem;
import net.mcreator.chaosentity.item.PepitasombraItem;
import net.mcreator.chaosentity.item.PicaretaAmetistaItem;
import net.mcreator.chaosentity.item.PicaretaEsmeraldaItem;
import net.mcreator.chaosentity.item.PicaretaMadeiraSombraItem;
import net.mcreator.chaosentity.item.PicaretaRubyItem;
import net.mcreator.chaosentity.item.PicaretasombraItem;
import net.mcreator.chaosentity.item.RubyItem;
import net.mcreator.chaosentity.item.TitaniumArmorItem;
import net.mcreator.chaosentity.item.TitaniumAxeItem;
import net.mcreator.chaosentity.item.TitaniumHoeItem;
import net.mcreator.chaosentity.item.TitaniumIngotItem;
import net.mcreator.chaosentity.item.TitaniumPickaxeItem;
import net.mcreator.chaosentity.item.TitaniumShovelItem;
import net.mcreator.chaosentity.item.TitaniumSwordItem;
import net.mcreator.chaosentity.item.TotemSombraItem;
import net.mcreator.chaosentity.item.ToxicArmorItem;
import net.mcreator.chaosentity.item.ToxicAxeItem;
import net.mcreator.chaosentity.item.ToxicHoeItem;
import net.mcreator.chaosentity.item.ToxicIngotItem;
import net.mcreator.chaosentity.item.ToxicPickaxeItem;
import net.mcreator.chaosentity.item.ToxicShovelItem;
import net.mcreator.chaosentity.item.ToxicSwordItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DoubleHighBlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryObject;

public class ChaosentitymodModItems {
    public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create((IForgeRegistry)ForgeRegistries.ITEMS, (String)"chaosentitymod");
    public static final RegistryObject<Item> JOIASOMBRA = REGISTRY.register("joiasombra", () -> new JoiasombraItem());
    public static final RegistryObject<Item> ESPADASOMBRA = REGISTRY.register("espadasombra", () -> new EspadasombraItem());
    public static final RegistryObject<Item> PEPITASOMBRA = REGISTRY.register("pepitasombra", () -> new PepitasombraItem());
    public static final RegistryObject<Item> MINERIOSOMBRA = ChaosentitymodModItems.block(ChaosentitymodModBlocks.MINERIOSOMBRA);
    public static final RegistryObject<Item> BLOCOSOMBRA = ChaosentitymodModItems.block(ChaosentitymodModBlocks.BLOCOSOMBRA);
    public static final RegistryObject<Item> PICARETASOMBRA = REGISTRY.register("picaretasombra", () -> new PicaretasombraItem());
    public static final RegistryObject<Item> GEMAROSALITA = REGISTRY.register("gemarosalita", () -> new GemarosalitaItem());
    public static final RegistryObject<Item> ROSALITABLOCO = ChaosentitymodModItems.block(ChaosentitymodModBlocks.ROSALITABLOCO);
    public static final RegistryObject<Item> GRAVETOBEDROCK = REGISTRY.register("gravetobedrock", () -> new GravetobedrockItem());
    public static final RegistryObject<Item> JOIAVORTEX = REGISTRY.register("joiavortex", () -> new JoiavortexItem());
    public static final RegistryObject<Item> ESPADA_VORTEX = REGISTRY.register("espada_vortex", () -> new EspadaVortexItem());
    public static final RegistryObject<Item> ARMADURA_AMETISTA_HELMET = REGISTRY.register("armadura_ametista_helmet", () -> new ArmaduraAmetistaItem.Helmet());
    public static final RegistryObject<Item> ARMADURA_AMETISTA_CHESTPLATE = REGISTRY.register("armadura_ametista_chestplate", () -> new ArmaduraAmetistaItem.Chestplate());
    public static final RegistryObject<Item> ARMADURA_AMETISTA_LEGGINGS = REGISTRY.register("armadura_ametista_leggings", () -> new ArmaduraAmetistaItem.Leggings());
    public static final RegistryObject<Item> ARMADURA_AMETISTA_BOOTS = REGISTRY.register("armadura_ametista_boots", () -> new ArmaduraAmetistaItem.Boots());
    public static final RegistryObject<Item> ESPADA_AMETISTA = REGISTRY.register("espada_ametista", () -> new EspadaAmetistaItem());
    public static final RegistryObject<Item> PICARETA_AMETISTA = REGISTRY.register("picareta_ametista", () -> new PicaretaAmetistaItem());
    public static final RegistryObject<Item> MACHADO_AMETISTA = REGISTRY.register("machado_ametista", () -> new MachadoAmetistaItem());
    public static final RegistryObject<Item> PA_AMETISTA = REGISTRY.register("pa_ametista", () -> new PaAmetistaItem());
    public static final RegistryObject<Item> ENXADA_AMETISTA = REGISTRY.register("enxada_ametista", () -> new EnxadaAmetistaItem());
    public static final RegistryObject<Item> ARMADURA_ESMERALDA_HELMET = REGISTRY.register("armadura_esmeralda_helmet", () -> new ArmaduraEsmeraldaItem.Helmet());
    public static final RegistryObject<Item> ARMADURA_ESMERALDA_CHESTPLATE = REGISTRY.register("armadura_esmeralda_chestplate", () -> new ArmaduraEsmeraldaItem.Chestplate());
    public static final RegistryObject<Item> ARMADURA_ESMERALDA_LEGGINGS = REGISTRY.register("armadura_esmeralda_leggings", () -> new ArmaduraEsmeraldaItem.Leggings());
    public static final RegistryObject<Item> ARMADURA_ESMERALDA_BOOTS = REGISTRY.register("armadura_esmeralda_boots", () -> new ArmaduraEsmeraldaItem.Boots());
    public static final RegistryObject<Item> ESPADA_ESMERALDA = REGISTRY.register("espada_esmeralda", () -> new EspadaEsmeraldaItem());
    public static final RegistryObject<Item> PICARETA_ESMERALDA = REGISTRY.register("picareta_esmeralda", () -> new PicaretaEsmeraldaItem());
    public static final RegistryObject<Item> MACHADO_ESMERALDA = REGISTRY.register("machado_esmeralda", () -> new MachadoEsmeraldaItem());
    public static final RegistryObject<Item> PA_ESMERALDA = REGISTRY.register("pa_esmeralda", () -> new PaEsmeraldaItem());
    public static final RegistryObject<Item> ENXADA_ESMERALDA = REGISTRY.register("enxada_esmeralda", () -> new EnxadaEsmeraldaItem());
    public static final RegistryObject<Item> RUBY = REGISTRY.register("ruby", () -> new RubyItem());
    public static final RegistryObject<Item> ARMADURA_RUBY_HELMET = REGISTRY.register("armadura_ruby_helmet", () -> new ArmaduraRubyItem.Helmet());
    public static final RegistryObject<Item> ARMADURA_RUBY_CHESTPLATE = REGISTRY.register("armadura_ruby_chestplate", () -> new ArmaduraRubyItem.Chestplate());
    public static final RegistryObject<Item> ARMADURA_RUBY_LEGGINGS = REGISTRY.register("armadura_ruby_leggings", () -> new ArmaduraRubyItem.Leggings());
    public static final RegistryObject<Item> ARMADURA_RUBY_BOOTS = REGISTRY.register("armadura_ruby_boots", () -> new ArmaduraRubyItem.Boots());
    public static final RegistryObject<Item> ESPADA_RUBY = REGISTRY.register("espada_ruby", () -> new EspadaRubyItem());
    public static final RegistryObject<Item> PICARETA_RUBY = REGISTRY.register("picareta_ruby", () -> new PicaretaRubyItem());
    public static final RegistryObject<Item> MACHADO_RUBY = REGISTRY.register("machado_ruby", () -> new MachadoRubyItem());
    public static final RegistryObject<Item> PA_RUBY = REGISTRY.register("pa_ruby", () -> new PaRubyItem());
    public static final RegistryObject<Item> ENXADA_RUBY = REGISTRY.register("enxada_ruby", () -> new EnxadaRubyItem());
    public static final RegistryObject<Item> MULTI_ESMERALDA = REGISTRY.register("multi_esmeralda", () -> new MultiEsmeraldaItem());
    public static final RegistryObject<Item> BLOCO_RUBY = ChaosentitymodModItems.block(ChaosentitymodModBlocks.BLOCO_RUBY);
    public static final RegistryObject<Item> MINERIO_RUBY = ChaosentitymodModItems.block(ChaosentitymodModBlocks.MINERIO_RUBY);
    public static final RegistryObject<Item> MADEIRA_SOMBRA = ChaosentitymodModItems.block(ChaosentitymodModBlocks.MADEIRA_SOMBRA);
    public static final RegistryObject<Item> FOLHA_SOMBRA = ChaosentitymodModItems.block(ChaosentitymodModBlocks.FOLHA_SOMBRA);
    public static final RegistryObject<Item> PEDRA_SOMBRA = ChaosentitymodModItems.block(ChaosentitymodModBlocks.PEDRA_SOMBRA);
    public static final RegistryObject<Item> GRAMA_SOMBRA = ChaosentitymodModItems.block(ChaosentitymodModBlocks.GRAMA_SOMBRA);
    public static final RegistryObject<Item> TABUA_SOMBRA = ChaosentitymodModItems.block(ChaosentitymodModBlocks.TABUA_SOMBRA);
    public static final RegistryObject<Item> COBBLESTONE_NEGRA = ChaosentitymodModItems.block(ChaosentitymodModBlocks.COBBLESTONE_NEGRA);
    public static final RegistryObject<Item> ESPADA_MADEIRA_SOMBRA = REGISTRY.register("espada_madeira_sombra", () -> new EspadaMadeiraSombraItem());
    public static final RegistryObject<Item> PICARETA_MADEIRA_SOMBRA = REGISTRY.register("picareta_madeira_sombra", () -> new PicaretaMadeiraSombraItem());
    public static final RegistryObject<Item> PA_MADEIRA_SOMBRA = REGISTRY.register("pa_madeira_sombra", () -> new PaMadeiraSombraItem());
    public static final RegistryObject<Item> MACHADO_MADEIRA_SOMBRA = REGISTRY.register("machado_madeira_sombra", () -> new MachadoMadeiraSombraItem());
    public static final RegistryObject<Item> ENXADA_MADEIRA_SOMBRA = REGISTRY.register("enxada_madeira_sombra", () -> new EnxadaMadeiraSombraItem());
    public static final RegistryObject<Item> GRAVETO_SOMBRA = REGISTRY.register("graveto_sombra", () -> new GravetoSombraItem());
    public static final RegistryObject<Item> TOTEM_SOMBRA = REGISTRY.register("totem_sombra", () -> new TotemSombraItem());
    public static final RegistryObject<Item> SLAB_MADEIRA_SOMBRA = ChaosentitymodModItems.block(ChaosentitymodModBlocks.SLAB_MADEIRA_SOMBRA);
    public static final RegistryObject<Item> ESCADA_MADEIRA_SOMBRA = ChaosentitymodModItems.block(ChaosentitymodModBlocks.ESCADA_MADEIRA_SOMBRA);
    public static final RegistryObject<Item> CERCA_MADEIRA_SOMBRA = ChaosentitymodModItems.block(ChaosentitymodModBlocks.CERCA_MADEIRA_SOMBRA);
    public static final RegistryObject<Item> PORTA_MADEIRA_SOMBRA = ChaosentitymodModItems.doubleBlock(ChaosentitymodModBlocks.PORTA_MADEIRA_SOMBRA);
    public static final RegistryObject<Item> TRAP_DOOR_MADEIRA_SOMBRA = ChaosentitymodModItems.block(ChaosentitymodModBlocks.TRAP_DOOR_MADEIRA_SOMBRA);
    public static final RegistryObject<Item> PORTAO_MADEIRA_SOMBRA = ChaosentitymodModItems.block(ChaosentitymodModBlocks.PORTAO_MADEIRA_SOMBRA);
    public static final RegistryObject<Item> PLACA_PRESSAO_MADEIRA_SOMBRA = ChaosentitymodModItems.block(ChaosentitymodModBlocks.PLACA_PRESSAO_MADEIRA_SOMBRA);
    public static final RegistryObject<Item> BOTAO_MADEIRA_SOMBRA = ChaosentitymodModItems.block(ChaosentitymodModBlocks.BOTAO_MADEIRA_SOMBRA);
    public static final RegistryObject<Item> BORRACHA_ARMOR_BOOTS = REGISTRY.register("borracha_armor_boots", () -> new BorrachaArmorItem.Boots());
    public static final RegistryObject<Item> BLOCO_GRAMA_BRANCO = ChaosentitymodModItems.block(ChaosentitymodModBlocks.BLOCO_GRAMA_BRANCO);
    public static final RegistryObject<Item> BLOCO_MADEIRA_BRANCO = ChaosentitymodModItems.block(ChaosentitymodModBlocks.BLOCO_MADEIRA_BRANCO);
    public static final RegistryObject<Item> MADEIRA_BRUTA_BRANCA = ChaosentitymodModItems.block(ChaosentitymodModBlocks.MADEIRA_BRUTA_BRANCA);
    public static final RegistryObject<Item> BLOCO_FOLHA_BRANCA = ChaosentitymodModItems.block(ChaosentitymodModBlocks.BLOCO_FOLHA_BRANCA);
    public static final RegistryObject<Item> TERRA_BRANCA = ChaosentitymodModItems.block(ChaosentitymodModBlocks.TERRA_BRANCA);
    public static final RegistryObject<Item> ALUMINIUM_INGOT = REGISTRY.register("aluminium_ingot", () -> new AluminiumIngotItem());
    public static final RegistryObject<Item> ALUMINIUM_ORE = ChaosentitymodModItems.block(ChaosentitymodModBlocks.ALUMINIUM_ORE);
    public static final RegistryObject<Item> ALUMINIUM_BLOCK = ChaosentitymodModItems.block(ChaosentitymodModBlocks.ALUMINIUM_BLOCK);
    public static final RegistryObject<Item> ALUMINIUM_PICKAXE = REGISTRY.register("aluminium_pickaxe", () -> new AluminiumPickaxeItem());
    public static final RegistryObject<Item> ALUMINIUM_AXE = REGISTRY.register("aluminium_axe", () -> new AluminiumAxeItem());
    public static final RegistryObject<Item> ALUMINIUM_SWORD = REGISTRY.register("aluminium_sword", () -> new AluminiumSwordItem());
    public static final RegistryObject<Item> ALUMINIUM_SHOVEL = REGISTRY.register("aluminium_shovel", () -> new AluminiumShovelItem());
    public static final RegistryObject<Item> ALUMINIUM_HOE = REGISTRY.register("aluminium_hoe", () -> new AluminiumHoeItem());
    public static final RegistryObject<Item> ALUMINIUM_ARMOR_HELMET = REGISTRY.register("aluminium_armor_helmet", () -> new AluminiumArmorItem.Helmet());
    public static final RegistryObject<Item> ALUMINIUM_ARMOR_CHESTPLATE = REGISTRY.register("aluminium_armor_chestplate", () -> new AluminiumArmorItem.Chestplate());
    public static final RegistryObject<Item> ALUMINIUM_ARMOR_LEGGINGS = REGISTRY.register("aluminium_armor_leggings", () -> new AluminiumArmorItem.Leggings());
    public static final RegistryObject<Item> ALUMINIUM_ARMOR_BOOTS = REGISTRY.register("aluminium_armor_boots", () -> new AluminiumArmorItem.Boots());
    public static final RegistryObject<Item> TITANIUM_INGOT = REGISTRY.register("titanium_ingot", () -> new TitaniumIngotItem());
    public static final RegistryObject<Item> TITANIUM_ORE = ChaosentitymodModItems.block(ChaosentitymodModBlocks.TITANIUM_ORE);
    public static final RegistryObject<Item> TITANIUM_BLOCK = ChaosentitymodModItems.block(ChaosentitymodModBlocks.TITANIUM_BLOCK);
    public static final RegistryObject<Item> TITANIUM_PICKAXE = REGISTRY.register("titanium_pickaxe", () -> new TitaniumPickaxeItem());
    public static final RegistryObject<Item> TITANIUM_AXE = REGISTRY.register("titanium_axe", () -> new TitaniumAxeItem());
    public static final RegistryObject<Item> TITANIUM_SWORD = REGISTRY.register("titanium_sword", () -> new TitaniumSwordItem());
    public static final RegistryObject<Item> TITANIUM_SHOVEL = REGISTRY.register("titanium_shovel", () -> new TitaniumShovelItem());
    public static final RegistryObject<Item> TITANIUM_HOE = REGISTRY.register("titanium_hoe", () -> new TitaniumHoeItem());
    public static final RegistryObject<Item> TITANIUM_ARMOR_HELMET = REGISTRY.register("titanium_armor_helmet", () -> new TitaniumArmorItem.Helmet());
    public static final RegistryObject<Item> TITANIUM_ARMOR_CHESTPLATE = REGISTRY.register("titanium_armor_chestplate", () -> new TitaniumArmorItem.Chestplate());
    public static final RegistryObject<Item> TITANIUM_ARMOR_LEGGINGS = REGISTRY.register("titanium_armor_leggings", () -> new TitaniumArmorItem.Leggings());
    public static final RegistryObject<Item> TITANIUM_ARMOR_BOOTS = REGISTRY.register("titanium_armor_boots", () -> new TitaniumArmorItem.Boots());
    public static final RegistryObject<Item> TOXIC_INGOT = REGISTRY.register("toxic_ingot", () -> new ToxicIngotItem());
    public static final RegistryObject<Item> TOXIC_ORE = ChaosentitymodModItems.block(ChaosentitymodModBlocks.TOXIC_ORE);
    public static final RegistryObject<Item> TOXIC_BLOCK = ChaosentitymodModItems.block(ChaosentitymodModBlocks.TOXIC_BLOCK);
    public static final RegistryObject<Item> TOXIC_PICKAXE = REGISTRY.register("toxic_pickaxe", () -> new ToxicPickaxeItem());
    public static final RegistryObject<Item> TOXIC_AXE = REGISTRY.register("toxic_axe", () -> new ToxicAxeItem());
    public static final RegistryObject<Item> TOXIC_SWORD = REGISTRY.register("toxic_sword", () -> new ToxicSwordItem());
    public static final RegistryObject<Item> TOXIC_SHOVEL = REGISTRY.register("toxic_shovel", () -> new ToxicShovelItem());
    public static final RegistryObject<Item> TOXIC_HOE = REGISTRY.register("toxic_hoe", () -> new ToxicHoeItem());
    public static final RegistryObject<Item> TOXIC_ARMOR_HELMET = REGISTRY.register("toxic_armor_helmet", () -> new ToxicArmorItem.Helmet());
    public static final RegistryObject<Item> TOXIC_ARMOR_CHESTPLATE = REGISTRY.register("toxic_armor_chestplate", () -> new ToxicArmorItem.Chestplate());
    public static final RegistryObject<Item> TOXIC_ARMOR_LEGGINGS = REGISTRY.register("toxic_armor_leggings", () -> new ToxicArmorItem.Leggings());
    public static final RegistryObject<Item> TOXIC_ARMOR_BOOTS = REGISTRY.register("toxic_armor_boots", () -> new ToxicArmorItem.Boots());
    public static final RegistryObject<Item> FIRE_WOOD = ChaosentitymodModItems.block(ChaosentitymodModBlocks.FIRE_WOOD);
    public static final RegistryObject<Item> FIRE_LOG = ChaosentitymodModItems.block(ChaosentitymodModBlocks.FIRE_LOG);
    public static final RegistryObject<Item> FIRE_PLANKS = ChaosentitymodModItems.block(ChaosentitymodModBlocks.FIRE_PLANKS);
    public static final RegistryObject<Item> FIRE_LEAVES = ChaosentitymodModItems.block(ChaosentitymodModBlocks.FIRE_LEAVES);
    public static final RegistryObject<Item> FIRE_STAIRS = ChaosentitymodModItems.block(ChaosentitymodModBlocks.FIRE_STAIRS);
    public static final RegistryObject<Item> FIRE_SLAB = ChaosentitymodModItems.block(ChaosentitymodModBlocks.FIRE_SLAB);
    public static final RegistryObject<Item> FIRE_FENCE = ChaosentitymodModItems.block(ChaosentitymodModBlocks.FIRE_FENCE);
    public static final RegistryObject<Item> FIRE_FENCE_GATE = ChaosentitymodModItems.block(ChaosentitymodModBlocks.FIRE_FENCE_GATE);
    public static final RegistryObject<Item> FIRE_PRESSURE_PLATE = ChaosentitymodModItems.block(ChaosentitymodModBlocks.FIRE_PRESSURE_PLATE);
    public static final RegistryObject<Item> FIRE_BUTTON = ChaosentitymodModItems.block(ChaosentitymodModBlocks.FIRE_BUTTON);
    public static final RegistryObject<Item> DIMENSION_APPLE = REGISTRY.register("dimension_apple", () -> new DimensionAppleItem());
    public static final RegistryObject<Item> DIMENSION_PIG_SPAWN_EGG = REGISTRY.register("dimension_pig_spawn_egg", () -> new ForgeSpawnEggItem(ChaosentitymodModEntities.DIMENSION_PIG, -65536, -12648448, new Item.Properties()));
    public static final RegistryObject<Item> GOLD_DIMENSION_APPLE = REGISTRY.register("gold_dimension_apple", () -> new GoldDimensionAppleItem());
    public static final RegistryObject<Item> GOLD_DIMENSION_PIG_SPAWN_EGG = REGISTRY.register("gold_dimension_pig_spawn_egg", () -> new ForgeSpawnEggItem(ChaosentitymodModEntities.GOLD_DIMENSION_PIG, -5376, -16171264, new Item.Properties()));
    public static final RegistryObject<Item> VANILLA_2_LEAVES = ChaosentitymodModItems.block(ChaosentitymodModBlocks.VANILLA_2_LEAVES);
    public static final RegistryObject<Item> TERRA_SOMBRA = ChaosentitymodModItems.block(ChaosentitymodModBlocks.TERRA_SOMBRA);
    public static final RegistryObject<Item> APPLE_COW_SPAWN_EGG = REGISTRY.register("apple_cow_spawn_egg", () -> new ForgeSpawnEggItem(ChaosentitymodModEntities.APPLE_COW, -65536, -16145664, new Item.Properties()));
    public static final RegistryObject<Item> GOLDEN_APPLE_COW_SPAWN_EGG = REGISTRY.register("golden_apple_cow_spawn_egg", () -> new ForgeSpawnEggItem(ChaosentitymodModEntities.GOLDEN_APPLE_COW, -1507584, -16145664, new Item.Properties()));
    public static final RegistryObject<Item> CRYSTAL_DIRT = ChaosentitymodModItems.block(ChaosentitymodModBlocks.CRYSTAL_DIRT);
    public static final RegistryObject<Item> CRYSTAL_GRASS_BLOCK = ChaosentitymodModItems.block(ChaosentitymodModBlocks.CRYSTAL_GRASS_BLOCK);
    public static final RegistryObject<Item> CRYSTAL_LOG = ChaosentitymodModItems.block(ChaosentitymodModBlocks.CRYSTAL_LOG);
    public static final RegistryObject<Item> CRYSTAL_PLANKS = ChaosentitymodModItems.block(ChaosentitymodModBlocks.CRYSTAL_PLANKS);
    public static final RegistryObject<Item> CRYSTAL_RED_PLANT = ChaosentitymodModItems.block(ChaosentitymodModBlocks.CRYSTAL_RED_PLANT);
    public static final RegistryObject<Item> CRYSTAL_LEAVES_1 = ChaosentitymodModItems.block(ChaosentitymodModBlocks.CRYSTAL_LEAVES_1);
    public static final RegistryObject<Item> CRYSTAL_LEAVES_2 = ChaosentitymodModItems.block(ChaosentitymodModBlocks.CRYSTAL_LEAVES_2);
    public static final RegistryObject<Item> CRYSTAL_LEAVES_3 = ChaosentitymodModItems.block(ChaosentitymodModBlocks.CRYSTAL_LEAVES_3);
    public static final RegistryObject<Item> CRYSTAL_YELLOW_PLANT = ChaosentitymodModItems.block(ChaosentitymodModBlocks.CRYSTAL_YELLOW_PLANT);
    public static final RegistryObject<Item> CRYSTAL_BLUE_PLANT = ChaosentitymodModItems.block(ChaosentitymodModBlocks.CRYSTAL_BLUE_PLANT);
    public static final RegistryObject<Item> CRYSTAL_GREEN_PLANT = ChaosentitymodModItems.block(ChaosentitymodModBlocks.CRYSTAL_GREEN_PLANT);
    public static final RegistryObject<Item> CRYSTAL_EYE = REGISTRY.register("crystal_eye", () -> new CrystalEyeItem());
    public static final RegistryObject<Item> CRYSTAL_CREEPER_SPAWN_EGG = REGISTRY.register("crystal_creeper_spawn_egg", () -> new ForgeSpawnEggItem(ChaosentitymodModEntities.CRYSTAL_CREEPER, -10027060, -1, new Item.Properties()));
    public static final RegistryObject<Item> CRYSTAL_APPLE_COW_SPAWN_EGG = REGISTRY.register("crystal_apple_cow_spawn_egg", () -> new ForgeSpawnEggItem(ChaosentitymodModEntities.CRYSTAL_APPLE_COW, -65536, -13434880, new Item.Properties()));
    public static final RegistryObject<Item> CRYSTAL_GOLDEN_APPLE_SPAWN_EGG = REGISTRY.register("crystal_golden_apple_spawn_egg", () -> new ForgeSpawnEggItem(ChaosentitymodModEntities.CRYSTAL_GOLDEN_APPLE, -256, -13312, new Item.Properties()));

    private static RegistryObject<Item> block(RegistryObject<Block> block) {
        return REGISTRY.register(block.getId().m_135815_(), () -> new BlockItem((Block)block.get(), new Item.Properties()));
    }

    private static RegistryObject<Item> doubleBlock(RegistryObject<Block> block) {
        return REGISTRY.register(block.getId().m_135815_(), () -> new DoubleHighBlockItem((Block)block.get(), new Item.Properties()));
    }
}

