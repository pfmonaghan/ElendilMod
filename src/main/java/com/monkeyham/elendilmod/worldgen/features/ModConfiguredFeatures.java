package com.monkeyham.elendilmod.worldgen.features;

import com.monkeyham.elendilmod.ElendilMod;
import com.monkeyham.elendilmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.ThreeLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.SpruceFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;
import java.util.OptionalInt;

public class ModConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?,?>> ITHILIEN_TREE_KEY = registerKey("ithilien_tree_key");
    public static final ResourceKey<ConfiguredFeature<?,?>> DEAD_MARSHES_GRASS_1_KEY = registerKey("dead_marshes_grass_1_key");
    public static final ResourceKey<ConfiguredFeature<?,?>> DEAD_MARSHES_CORPSE_CANDLES_KEY = registerKey("dead_marshes_corpse_candles_key");
    public static final ResourceKey<ConfiguredFeature<?,?>> DIAMOND_BLOCK_FEATURE_KEY = registerKey("diamond_block_feature_key");
    public static final ResourceKey<ConfiguredFeature<?,?>> ROCK_FEATURE_KEY = registerKey("rock_feature_key");
    public static final ResourceKey<ConfiguredFeature<?,?>> DEEPSLATE_ROCK_FEATURE_KEY = registerKey("deepslate_rock_feature_key");
    public static final ResourceKey<ConfiguredFeature<?,?>> ITHILIEN_TREE_1_KEY = registerKey("ithilien_tree_1");
    public static final ResourceKey<ConfiguredFeature<?,?>> FANGORN_TREES_KEY = registerKey("fangorn_trees");
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

        var holderGetter = context.lookup(Registries.CONFIGURED_FEATURE);
        var h1 = holderGetter.getOrThrow(TreeFeatures.FANCY_OAK);
        var h2 = holderGetter.getOrThrow(TreeFeatures.DARK_OAK);
        var h3 = holderGetter.getOrThrow(TreeFeatures.MEGA_SPRUCE);
        var h4 = holderGetter.getOrThrow(TreeFeatures.SUPER_BIRCH_BEES);
        var h5 = holderGetter.getOrThrow(TreeFeatures.PINE);


        context.register(ROCK_FEATURE_KEY, new ConfiguredFeature<>(ModdedFeatures.LARGE_STONE.get(), new BlockStateConfiguration(Blocks.STONE.defaultBlockState())));
        context.register(DEEPSLATE_ROCK_FEATURE_KEY, new ConfiguredFeature<>(ModdedFeatures.LARGE_STONE.get(), new BlockStateConfiguration(Blocks.DEEPSLATE.defaultBlockState())));
        context.register(ITHILIEN_TREE_1_KEY, new ConfiguredFeature<>(ModdedFeatures.ITHILIEN_TREE_1.get(), new NoneFeatureConfiguration()));
        register(context, FANGORN_TREES_KEY, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(
                List.of(new WeightedPlacedFeature(PlacementUtils.inlinePlaced(h1, new PlacementModifier[0]), 0.33333334F),
                        new WeightedPlacedFeature(PlacementUtils.inlinePlaced(h2, new PlacementModifier[0]), 0.33333334F),
                        new WeightedPlacedFeature(PlacementUtils.inlinePlaced(h3, new PlacementModifier[0]), 0.33333334F),
                        new WeightedPlacedFeature(PlacementUtils.inlinePlaced(h4, new PlacementModifier[0]), 0.33333334F),
                        new WeightedPlacedFeature(PlacementUtils.inlinePlaced(h5, new PlacementModifier[0]), 0.33333334F)),
                PlacementUtils.inlinePlaced(h1, new PlacementModifier[0])
        ));

    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(ElendilMod.MODID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

}