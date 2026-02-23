package com.monkeyham.elendilmod.worldgen;

import com.monkeyham.elendilmod.ElendilMod;
import com.monkeyham.elendilmod.block.ModBlocks;
import com.monkeyham.elendilmod.worldgen.features.ModdedFeatures;
import com.monkeyham.elendilmod.worldgen.features.RockyTerrain;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.ThreeLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.SpruceFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.OptionalInt;

public class ModConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?,?>> ITHILIEN_TREE_KEY = registerKey("ithilien_tree_key");
    public static final ResourceKey<ConfiguredFeature<?,?>> DEAD_MARSHES_GRASS_1_KEY = registerKey("dead_marshes_grass_1_key");
    public static final ResourceKey<ConfiguredFeature<?,?>> DEAD_MARSHES_CORPSE_CANDLES_KEY = registerKey("dead_marshes_corpse_candles_key");
    public static final ResourceKey<ConfiguredFeature<?,?>> DIAMOND_BLOCK_FEATURE_KEY = registerKey("diamond_block_feature_key");
    //public static final ResourceKey<ConfiguredFeature<?,?>> MORDOR_GRASS = registerKey("mordor_grass");


    public static void bootstrap(BootstrapContext<ConfiguredFeature<?,?>> context)
    {
        register(context, ITHILIEN_TREE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.ITHILIEN_TREE_LOG.get()),
                new ForkingTrunkPlacer(4, 4, 3),
                BlockStateProvider.simple(ModBlocks.ITHILIEN_TREE_LEAVES.get()),
                new SpruceFoliagePlacer(ConstantInt.of(2), ConstantInt.of(3), ConstantInt.of(3)),
                new ThreeLayersFeatureSize(1, 0, 3, 2,1, OptionalInt.of(2)))
                .build());


        context.register(DEAD_MARSHES_GRASS_1_KEY, new ConfiguredFeature<>(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(
        new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                .add(ModBlocks.DEAD_MARSHES_GRASS_1.get().defaultBlockState(), 15)
                .add(ModBlocks.DEAD_MARSHES_GRASS_2.get().defaultBlockState(), 10)
        ))));

        context.register(DEAD_MARSHES_CORPSE_CANDLES_KEY, new ConfiguredFeature<>(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(
        new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                .add(ModBlocks.DEAD_MARSHES_CORPSE_CANDLE.get().defaultBlockState(), 5)
        ))));

        context.register(DIAMOND_BLOCK_FEATURE_KEY, new ConfiguredFeature<>(ModdedFeatures.ROCKY_TERRAIN_FEATURE.get(), new NoneFeatureConfiguration()));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(ElendilMod.MODID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

}