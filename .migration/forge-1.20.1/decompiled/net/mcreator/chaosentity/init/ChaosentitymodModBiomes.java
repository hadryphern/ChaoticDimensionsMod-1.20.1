/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Suppliers
 *  com.mojang.datafixers.util.Pair
 *  net.minecraft.core.Holder
 *  net.minecraft.core.Holder$Direct
 *  net.minecraft.core.Registry
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.server.MinecraftServer
 *  net.minecraft.world.level.biome.Biome
 *  net.minecraft.world.level.biome.BiomeGenerationSettings
 *  net.minecraft.world.level.biome.BiomeSource
 *  net.minecraft.world.level.biome.Climate$Parameter
 *  net.minecraft.world.level.biome.Climate$ParameterList
 *  net.minecraft.world.level.biome.Climate$ParameterPoint
 *  net.minecraft.world.level.biome.FeatureSorter
 *  net.minecraft.world.level.biome.MultiNoiseBiomeSource
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.chunk.ChunkGenerator
 *  net.minecraft.world.level.dimension.BuiltinDimensionTypes
 *  net.minecraft.world.level.dimension.DimensionType
 *  net.minecraft.world.level.dimension.LevelStem
 *  net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator
 *  net.minecraft.world.level.levelgen.NoiseGeneratorSettings
 *  net.minecraft.world.level.levelgen.SurfaceRules
 *  net.minecraft.world.level.levelgen.SurfaceRules$ConditionSource
 *  net.minecraft.world.level.levelgen.SurfaceRules$RuleSource
 *  net.minecraft.world.level.levelgen.SurfaceRules$SequenceRuleSource
 *  net.minecraft.world.level.levelgen.placement.CaveSurface
 *  net.minecraftforge.event.server.ServerAboutToStartEvent
 *  net.minecraftforge.eventbus.api.SubscribeEvent
 *  net.minecraftforge.fml.common.Mod$EventBusSubscriber
 */
package net.mcreator.chaosentity.init;

import com.google.common.base.Suppliers;
import com.mojang.datafixers.util.Pair;
import java.util.ArrayList;
import java.util.List;
import net.mcreator.chaosentity.init.ChaosentitymodModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.FeatureSorter;
import net.minecraft.world.level.biome.MultiNoiseBiomeSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.placement.CaveSurface;
import net.minecraftforge.event.server.ServerAboutToStartEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class ChaosentitymodModBiomes {
    @SubscribeEvent
    public static void onServerAboutToStart(ServerAboutToStartEvent event) {
        MinecraftServer server = event.getServer();
        Registry dimensionTypeRegistry = server.m_206579_().m_175515_(Registries.f_256787_);
        Registry levelStemTypeRegistry = server.m_206579_().m_175515_(Registries.f_256862_);
        Registry biomeRegistry = server.m_206579_().m_175515_(Registries.f_256952_);
        for (LevelStem levelStem : levelStemTypeRegistry.m_123024_().toList()) {
            DimensionType dimensionType = (DimensionType)levelStem.f_63975_().m_203334_();
            if (dimensionType != dimensionTypeRegistry.m_123013_(BuiltinDimensionTypes.f_223538_)) continue;
            ChunkGenerator chunkGenerator = levelStem.f_63976_();
            BiomeSource biomeSource = chunkGenerator.m_62218_();
            if (biomeSource instanceof MultiNoiseBiomeSource) {
                MultiNoiseBiomeSource noiseSource = (MultiNoiseBiomeSource)biomeSource;
                ArrayList<Pair<Climate.ParameterPoint, Holder<Biome>>> parameters = new ArrayList<Pair<Climate.ParameterPoint, Holder<Biome>>>(noiseSource.m_274409_().m_186850_());
                ChaosentitymodModBiomes.addParameterPoint(parameters, (Pair<Climate.ParameterPoint, Holder<Biome>>)new Pair((Object)new Climate.ParameterPoint(Climate.Parameter.m_186822_((float)-0.5f, (float)0.5f), Climate.Parameter.m_186822_((float)-0.5f, (float)0.5f), Climate.Parameter.m_186822_((float)0.3026f, (float)1.0048f), Climate.Parameter.m_186822_((float)-2.0f, (float)1.0f), Climate.Parameter.m_186820_((float)0.0f), Climate.Parameter.m_186822_((float)-1.0f, (float)1.0f), 0L), (Object)biomeRegistry.m_246971_(ResourceKey.m_135785_((ResourceKey)Registries.f_256952_, (ResourceLocation)new ResourceLocation("chaosentitymod", "bioma_luz")))));
                ChaosentitymodModBiomes.addParameterPoint(parameters, (Pair<Climate.ParameterPoint, Holder<Biome>>)new Pair((Object)new Climate.ParameterPoint(Climate.Parameter.m_186822_((float)-0.5f, (float)0.5f), Climate.Parameter.m_186822_((float)-0.5f, (float)0.5f), Climate.Parameter.m_186822_((float)0.3026f, (float)1.0048f), Climate.Parameter.m_186822_((float)-2.0f, (float)1.0f), Climate.Parameter.m_186820_((float)1.0f), Climate.Parameter.m_186822_((float)-1.0f, (float)1.0f), 0L), (Object)biomeRegistry.m_246971_(ResourceKey.m_135785_((ResourceKey)Registries.f_256952_, (ResourceLocation)new ResourceLocation("chaosentitymod", "bioma_luz")))));
                ChaosentitymodModBiomes.addParameterPoint(parameters, (Pair<Climate.ParameterPoint, Holder<Biome>>)new Pair((Object)new Climate.ParameterPoint(Climate.Parameter.m_186822_((float)-1.0f, (float)1.0f), Climate.Parameter.m_186822_((float)-1.0f, (float)1.0f), Climate.Parameter.m_186822_((float)-1.0f, (float)1.0f), Climate.Parameter.m_186822_((float)0.6f, (float)0.9f), Climate.Parameter.m_186820_((float)0.0f), Climate.Parameter.m_186822_((float)0.0f, (float)1.0f), 0L), (Object)biomeRegistry.m_246971_(ResourceKey.m_135785_((ResourceKey)Registries.f_256952_, (ResourceLocation)new ResourceLocation("chaosentitymod", "vanilla_2")))));
                ChaosentitymodModBiomes.addParameterPoint(parameters, (Pair<Climate.ParameterPoint, Holder<Biome>>)new Pair((Object)new Climate.ParameterPoint(Climate.Parameter.m_186822_((float)-1.0f, (float)1.0f), Climate.Parameter.m_186822_((float)-1.0f, (float)1.0f), Climate.Parameter.m_186822_((float)-1.0f, (float)1.0f), Climate.Parameter.m_186822_((float)0.6f, (float)0.9f), Climate.Parameter.m_186820_((float)1.0f), Climate.Parameter.m_186822_((float)0.0f, (float)1.0f), 0L), (Object)biomeRegistry.m_246971_(ResourceKey.m_135785_((ResourceKey)Registries.f_256952_, (ResourceLocation)new ResourceLocation("chaosentitymod", "vanilla_2")))));
                ChaosentitymodModBiomes.addParameterPoint(parameters, (Pair<Climate.ParameterPoint, Holder<Biome>>)new Pair((Object)new Climate.ParameterPoint(Climate.Parameter.m_186822_((float)-0.5f, (float)0.5f), Climate.Parameter.m_186822_((float)-0.5f, (float)0.5f), Climate.Parameter.m_186822_((float)0.3026f, (float)1.0048f), Climate.Parameter.m_186822_((float)-2.0f, (float)1.0f), Climate.Parameter.m_186820_((float)0.0f), Climate.Parameter.m_186822_((float)-1.0f, (float)1.0f), 0L), (Object)biomeRegistry.m_246971_(ResourceKey.m_135785_((ResourceKey)Registries.f_256952_, (ResourceLocation)new ResourceLocation("chaosentitymod", "bioma_sombra")))));
                ChaosentitymodModBiomes.addParameterPoint(parameters, (Pair<Climate.ParameterPoint, Holder<Biome>>)new Pair((Object)new Climate.ParameterPoint(Climate.Parameter.m_186822_((float)-0.5f, (float)0.5f), Climate.Parameter.m_186822_((float)-0.5f, (float)0.5f), Climate.Parameter.m_186822_((float)0.3026f, (float)1.0048f), Climate.Parameter.m_186822_((float)-2.0f, (float)1.0f), Climate.Parameter.m_186820_((float)1.0f), Climate.Parameter.m_186822_((float)-1.0f, (float)1.0f), 0L), (Object)biomeRegistry.m_246971_(ResourceKey.m_135785_((ResourceKey)Registries.f_256952_, (ResourceLocation)new ResourceLocation("chaosentitymod", "bioma_sombra")))));
                chunkGenerator.f_62137_ = MultiNoiseBiomeSource.m_274596_((Climate.ParameterList)new Climate.ParameterList(parameters));
                chunkGenerator.f_223020_ = Suppliers.memoize(() -> FeatureSorter.m_220603_(List.copyOf(chunkGenerator.f_62137_.m_207840_()), biome -> ((BiomeGenerationSettings)chunkGenerator.f_223021_.apply(biome)).m_47818_(), (boolean)true));
            }
            if (!(chunkGenerator instanceof NoiseBasedChunkGenerator)) continue;
            NoiseBasedChunkGenerator noiseGenerator = (NoiseBasedChunkGenerator)chunkGenerator;
            NoiseGeneratorSettings noiseGeneratorSettings = (NoiseGeneratorSettings)noiseGenerator.f_64318_.m_203334_();
            SurfaceRules.RuleSource currentRuleSource = noiseGeneratorSettings.f_188871_();
            if (!(currentRuleSource instanceof SurfaceRules.SequenceRuleSource)) continue;
            SurfaceRules.SequenceRuleSource sequenceRuleSource = (SurfaceRules.SequenceRuleSource)currentRuleSource;
            ArrayList<SurfaceRules.RuleSource> surfaceRules = new ArrayList<SurfaceRules.RuleSource>(sequenceRuleSource.f_189697_());
            ChaosentitymodModBiomes.addSurfaceRule(surfaceRules, 1, ChaosentitymodModBiomes.preliminarySurfaceRule((ResourceKey<Biome>)ResourceKey.m_135785_((ResourceKey)Registries.f_256952_, (ResourceLocation)new ResourceLocation("chaosentitymod", "bioma_luz")), ((Block)ChaosentitymodModBlocks.BLOCO_GRAMA_BRANCO.get()).m_49966_(), ((Block)ChaosentitymodModBlocks.TERRA_BRANCA.get()).m_49966_(), ((Block)ChaosentitymodModBlocks.TERRA_BRANCA.get()).m_49966_()));
            ChaosentitymodModBiomes.addSurfaceRule(surfaceRules, 1, ChaosentitymodModBiomes.preliminarySurfaceRule((ResourceKey<Biome>)ResourceKey.m_135785_((ResourceKey)Registries.f_256952_, (ResourceLocation)new ResourceLocation("chaosentitymod", "vanilla_2")), Blocks.f_50440_.m_49966_(), Blocks.f_50493_.m_49966_(), Blocks.f_50493_.m_49966_()));
            ChaosentitymodModBiomes.addSurfaceRule(surfaceRules, 1, ChaosentitymodModBiomes.preliminarySurfaceRule((ResourceKey<Biome>)ResourceKey.m_135785_((ResourceKey)Registries.f_256952_, (ResourceLocation)new ResourceLocation("chaosentitymod", "bioma_sombra")), ((Block)ChaosentitymodModBlocks.GRAMA_SOMBRA.get()).m_49966_(), ((Block)ChaosentitymodModBlocks.PEDRA_SOMBRA.get()).m_49966_(), ((Block)ChaosentitymodModBlocks.PEDRA_SOMBRA.get()).m_49966_()));
            NoiseGeneratorSettings moddedNoiseGeneratorSettings = new NoiseGeneratorSettings(noiseGeneratorSettings.f_64439_(), noiseGeneratorSettings.f_64440_(), noiseGeneratorSettings.f_64441_(), noiseGeneratorSettings.f_209353_(), SurfaceRules.m_198272_((SurfaceRules.RuleSource[])((SurfaceRules.RuleSource[])surfaceRules.toArray(SurfaceRules.RuleSource[]::new))), noiseGeneratorSettings.f_224370_(), noiseGeneratorSettings.f_64444_(), noiseGeneratorSettings.f_64445_(), noiseGeneratorSettings.f_158533_(), noiseGeneratorSettings.m_209369_(), noiseGeneratorSettings.f_209354_());
            noiseGenerator.f_64318_ = new Holder.Direct((Object)moddedNoiseGeneratorSettings);
        }
    }

    private static SurfaceRules.RuleSource preliminarySurfaceRule(ResourceKey<Biome> biomeKey, BlockState groundBlock, BlockState undergroundBlock, BlockState underwaterBlock) {
        return SurfaceRules.m_189394_((SurfaceRules.ConditionSource)SurfaceRules.m_189416_((ResourceKey[])new ResourceKey[]{biomeKey}), (SurfaceRules.RuleSource)SurfaceRules.m_189394_((SurfaceRules.ConditionSource)SurfaceRules.m_189425_(), (SurfaceRules.RuleSource)SurfaceRules.m_198272_((SurfaceRules.RuleSource[])new SurfaceRules.RuleSource[]{SurfaceRules.m_189394_((SurfaceRules.ConditionSource)SurfaceRules.m_202171_((int)0, (boolean)false, (int)0, (CaveSurface)CaveSurface.FLOOR), (SurfaceRules.RuleSource)SurfaceRules.m_198272_((SurfaceRules.RuleSource[])new SurfaceRules.RuleSource[]{SurfaceRules.m_189394_((SurfaceRules.ConditionSource)SurfaceRules.m_189382_((int)-1, (int)0), (SurfaceRules.RuleSource)SurfaceRules.m_189390_((BlockState)groundBlock)), SurfaceRules.m_189390_((BlockState)underwaterBlock)})), SurfaceRules.m_189394_((SurfaceRules.ConditionSource)SurfaceRules.m_202171_((int)0, (boolean)true, (int)0, (CaveSurface)CaveSurface.FLOOR), (SurfaceRules.RuleSource)SurfaceRules.m_189390_((BlockState)undergroundBlock))})));
    }

    private static void addParameterPoint(List<Pair<Climate.ParameterPoint, Holder<Biome>>> parameters, Pair<Climate.ParameterPoint, Holder<Biome>> point) {
        if (!parameters.contains(point)) {
            parameters.add(point);
        }
    }

    private static void addSurfaceRule(List<SurfaceRules.RuleSource> surfaceRules, int index, SurfaceRules.RuleSource rule) {
        if (!surfaceRules.contains(rule)) {
            surfaceRules.add(index, rule);
        }
    }
}

