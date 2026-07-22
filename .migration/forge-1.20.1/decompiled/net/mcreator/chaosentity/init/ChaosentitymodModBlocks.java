/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.level.block.Block
 *  net.minecraftforge.registries.DeferredRegister
 *  net.minecraftforge.registries.ForgeRegistries
 *  net.minecraftforge.registries.IForgeRegistry
 *  net.minecraftforge.registries.RegistryObject
 */
package net.mcreator.chaosentity.init;

import net.mcreator.chaosentity.block.AluminiumBlockBlock;
import net.mcreator.chaosentity.block.AluminiumOreBlock;
import net.mcreator.chaosentity.block.BlocoFolhaBrancaBlock;
import net.mcreator.chaosentity.block.BlocoGramaBrancoBlock;
import net.mcreator.chaosentity.block.BlocoMadeiraBrancoBlock;
import net.mcreator.chaosentity.block.BlocoRubyBlock;
import net.mcreator.chaosentity.block.BlocosombraBlock;
import net.mcreator.chaosentity.block.BotaoMadeiraSombraBlock;
import net.mcreator.chaosentity.block.CercaMadeiraSombraBlock;
import net.mcreator.chaosentity.block.CobblestoneNegraBlock;
import net.mcreator.chaosentity.block.CrystalBluePlantBlock;
import net.mcreator.chaosentity.block.CrystalDirtBlock;
import net.mcreator.chaosentity.block.CrystalGrassBlockBlock;
import net.mcreator.chaosentity.block.CrystalGreenPlantBlock;
import net.mcreator.chaosentity.block.CrystalLeaves1Block;
import net.mcreator.chaosentity.block.CrystalLeaves2Block;
import net.mcreator.chaosentity.block.CrystalLeaves3Block;
import net.mcreator.chaosentity.block.CrystalLogBlock;
import net.mcreator.chaosentity.block.CrystalPlanksBlock;
import net.mcreator.chaosentity.block.CrystalRedPlantBlock;
import net.mcreator.chaosentity.block.CrystalYellowPlantBlock;
import net.mcreator.chaosentity.block.EscadaMadeiraSombraBlock;
import net.mcreator.chaosentity.block.FireButtonBlock;
import net.mcreator.chaosentity.block.FireFenceBlock;
import net.mcreator.chaosentity.block.FireFenceGateBlock;
import net.mcreator.chaosentity.block.FireLeavesBlock;
import net.mcreator.chaosentity.block.FireLogBlock;
import net.mcreator.chaosentity.block.FirePlanksBlock;
import net.mcreator.chaosentity.block.FirePressurePlateBlock;
import net.mcreator.chaosentity.block.FireSlabBlock;
import net.mcreator.chaosentity.block.FireStairsBlock;
import net.mcreator.chaosentity.block.FireWoodBlock;
import net.mcreator.chaosentity.block.FolhaSombraBlock;
import net.mcreator.chaosentity.block.GramaSombraBlock;
import net.mcreator.chaosentity.block.MadeiraBrutaBrancaBlock;
import net.mcreator.chaosentity.block.MadeiraSombraBlock;
import net.mcreator.chaosentity.block.MinerioRubyBlock;
import net.mcreator.chaosentity.block.MineriosombraBlock;
import net.mcreator.chaosentity.block.PedraSombraBlock;
import net.mcreator.chaosentity.block.PlacaPressaoMadeiraSombraBlock;
import net.mcreator.chaosentity.block.PortaMadeiraSombraBlock;
import net.mcreator.chaosentity.block.PortaoMadeiraSombraBlock;
import net.mcreator.chaosentity.block.RosalitablocoBlock;
import net.mcreator.chaosentity.block.SlabMadeiraSombraBlock;
import net.mcreator.chaosentity.block.TabuaSombraBlock;
import net.mcreator.chaosentity.block.TerraBrancaBlock;
import net.mcreator.chaosentity.block.TerraSombraBlock;
import net.mcreator.chaosentity.block.TitaniumBlockBlock;
import net.mcreator.chaosentity.block.TitaniumOreBlock;
import net.mcreator.chaosentity.block.ToxicBlockBlock;
import net.mcreator.chaosentity.block.ToxicOreBlock;
import net.mcreator.chaosentity.block.TrapDoorMadeiraSombraBlock;
import net.mcreator.chaosentity.block.Vanilla2LeavesBlock;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryObject;

public class ChaosentitymodModBlocks {
    public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create((IForgeRegistry)ForgeRegistries.BLOCKS, (String)"chaosentitymod");
    public static final RegistryObject<Block> MINERIOSOMBRA = REGISTRY.register("mineriosombra", () -> new MineriosombraBlock());
    public static final RegistryObject<Block> BLOCOSOMBRA = REGISTRY.register("blocosombra", () -> new BlocosombraBlock());
    public static final RegistryObject<Block> ROSALITABLOCO = REGISTRY.register("rosalitabloco", () -> new RosalitablocoBlock());
    public static final RegistryObject<Block> BLOCO_RUBY = REGISTRY.register("bloco_ruby", () -> new BlocoRubyBlock());
    public static final RegistryObject<Block> MINERIO_RUBY = REGISTRY.register("minerio_ruby", () -> new MinerioRubyBlock());
    public static final RegistryObject<Block> MADEIRA_SOMBRA = REGISTRY.register("madeira_sombra", () -> new MadeiraSombraBlock());
    public static final RegistryObject<Block> FOLHA_SOMBRA = REGISTRY.register("folha_sombra", () -> new FolhaSombraBlock());
    public static final RegistryObject<Block> PEDRA_SOMBRA = REGISTRY.register("pedra_sombra", () -> new PedraSombraBlock());
    public static final RegistryObject<Block> GRAMA_SOMBRA = REGISTRY.register("grama_sombra", () -> new GramaSombraBlock());
    public static final RegistryObject<Block> TABUA_SOMBRA = REGISTRY.register("tabua_sombra", () -> new TabuaSombraBlock());
    public static final RegistryObject<Block> COBBLESTONE_NEGRA = REGISTRY.register("cobblestone_negra", () -> new CobblestoneNegraBlock());
    public static final RegistryObject<Block> SLAB_MADEIRA_SOMBRA = REGISTRY.register("slab_madeira_sombra", () -> new SlabMadeiraSombraBlock());
    public static final RegistryObject<Block> ESCADA_MADEIRA_SOMBRA = REGISTRY.register("escada_madeira_sombra", () -> new EscadaMadeiraSombraBlock());
    public static final RegistryObject<Block> CERCA_MADEIRA_SOMBRA = REGISTRY.register("cerca_madeira_sombra", () -> new CercaMadeiraSombraBlock());
    public static final RegistryObject<Block> PORTA_MADEIRA_SOMBRA = REGISTRY.register("porta_madeira_sombra", () -> new PortaMadeiraSombraBlock());
    public static final RegistryObject<Block> TRAP_DOOR_MADEIRA_SOMBRA = REGISTRY.register("trap_door_madeira_sombra", () -> new TrapDoorMadeiraSombraBlock());
    public static final RegistryObject<Block> PORTAO_MADEIRA_SOMBRA = REGISTRY.register("portao_madeira_sombra", () -> new PortaoMadeiraSombraBlock());
    public static final RegistryObject<Block> PLACA_PRESSAO_MADEIRA_SOMBRA = REGISTRY.register("placa_pressao_madeira_sombra", () -> new PlacaPressaoMadeiraSombraBlock());
    public static final RegistryObject<Block> BOTAO_MADEIRA_SOMBRA = REGISTRY.register("botao_madeira_sombra", () -> new BotaoMadeiraSombraBlock());
    public static final RegistryObject<Block> BLOCO_GRAMA_BRANCO = REGISTRY.register("bloco_grama_branco", () -> new BlocoGramaBrancoBlock());
    public static final RegistryObject<Block> BLOCO_MADEIRA_BRANCO = REGISTRY.register("bloco_madeira_branco", () -> new BlocoMadeiraBrancoBlock());
    public static final RegistryObject<Block> MADEIRA_BRUTA_BRANCA = REGISTRY.register("madeira_bruta_branca", () -> new MadeiraBrutaBrancaBlock());
    public static final RegistryObject<Block> BLOCO_FOLHA_BRANCA = REGISTRY.register("bloco_folha_branca", () -> new BlocoFolhaBrancaBlock());
    public static final RegistryObject<Block> TERRA_BRANCA = REGISTRY.register("terra_branca", () -> new TerraBrancaBlock());
    public static final RegistryObject<Block> ALUMINIUM_ORE = REGISTRY.register("aluminium_ore", () -> new AluminiumOreBlock());
    public static final RegistryObject<Block> ALUMINIUM_BLOCK = REGISTRY.register("aluminium_block", () -> new AluminiumBlockBlock());
    public static final RegistryObject<Block> TITANIUM_ORE = REGISTRY.register("titanium_ore", () -> new TitaniumOreBlock());
    public static final RegistryObject<Block> TITANIUM_BLOCK = REGISTRY.register("titanium_block", () -> new TitaniumBlockBlock());
    public static final RegistryObject<Block> TOXIC_ORE = REGISTRY.register("toxic_ore", () -> new ToxicOreBlock());
    public static final RegistryObject<Block> TOXIC_BLOCK = REGISTRY.register("toxic_block", () -> new ToxicBlockBlock());
    public static final RegistryObject<Block> FIRE_WOOD = REGISTRY.register("fire_wood", () -> new FireWoodBlock());
    public static final RegistryObject<Block> FIRE_LOG = REGISTRY.register("fire_log", () -> new FireLogBlock());
    public static final RegistryObject<Block> FIRE_PLANKS = REGISTRY.register("fire_planks", () -> new FirePlanksBlock());
    public static final RegistryObject<Block> FIRE_LEAVES = REGISTRY.register("fire_leaves", () -> new FireLeavesBlock());
    public static final RegistryObject<Block> FIRE_STAIRS = REGISTRY.register("fire_stairs", () -> new FireStairsBlock());
    public static final RegistryObject<Block> FIRE_SLAB = REGISTRY.register("fire_slab", () -> new FireSlabBlock());
    public static final RegistryObject<Block> FIRE_FENCE = REGISTRY.register("fire_fence", () -> new FireFenceBlock());
    public static final RegistryObject<Block> FIRE_FENCE_GATE = REGISTRY.register("fire_fence_gate", () -> new FireFenceGateBlock());
    public static final RegistryObject<Block> FIRE_PRESSURE_PLATE = REGISTRY.register("fire_pressure_plate", () -> new FirePressurePlateBlock());
    public static final RegistryObject<Block> FIRE_BUTTON = REGISTRY.register("fire_button", () -> new FireButtonBlock());
    public static final RegistryObject<Block> VANILLA_2_LEAVES = REGISTRY.register("vanilla_2_leaves", () -> new Vanilla2LeavesBlock());
    public static final RegistryObject<Block> TERRA_SOMBRA = REGISTRY.register("terra_sombra", () -> new TerraSombraBlock());
    public static final RegistryObject<Block> CRYSTAL_DIRT = REGISTRY.register("crystal_dirt", () -> new CrystalDirtBlock());
    public static final RegistryObject<Block> CRYSTAL_GRASS_BLOCK = REGISTRY.register("crystal_grass_block", () -> new CrystalGrassBlockBlock());
    public static final RegistryObject<Block> CRYSTAL_LOG = REGISTRY.register("crystal_log", () -> new CrystalLogBlock());
    public static final RegistryObject<Block> CRYSTAL_PLANKS = REGISTRY.register("crystal_planks", () -> new CrystalPlanksBlock());
    public static final RegistryObject<Block> CRYSTAL_RED_PLANT = REGISTRY.register("crystal_red_plant", () -> new CrystalRedPlantBlock());
    public static final RegistryObject<Block> CRYSTAL_LEAVES_1 = REGISTRY.register("crystal_leaves_1", () -> new CrystalLeaves1Block());
    public static final RegistryObject<Block> CRYSTAL_LEAVES_2 = REGISTRY.register("crystal_leaves_2", () -> new CrystalLeaves2Block());
    public static final RegistryObject<Block> CRYSTAL_LEAVES_3 = REGISTRY.register("crystal_leaves_3", () -> new CrystalLeaves3Block());
    public static final RegistryObject<Block> CRYSTAL_YELLOW_PLANT = REGISTRY.register("crystal_yellow_plant", () -> new CrystalYellowPlantBlock());
    public static final RegistryObject<Block> CRYSTAL_BLUE_PLANT = REGISTRY.register("crystal_blue_plant", () -> new CrystalBluePlantBlock());
    public static final RegistryObject<Block> CRYSTAL_GREEN_PLANT = REGISTRY.register("crystal_green_plant", () -> new CrystalGreenPlantBlock());
}

