package com.monkeyham.elendilmod.worldgen;

import com.monkeyham.elendilmod.ElendilMod;
import com.monkeyham.elendilmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.featuresize.ThreeLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.SpruceFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;

import java.util.OptionalInt;

public class ModConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?,?>> ITHILIEN_TREE_KEY = registerKey("ithilien_tree_key");


    public static void bootstrap(BootstrapContext<ConfiguredFeature<?,?>> context)
    {
        register(context, ITHILIEN_TREE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.ITHILIEN_TREE_LOG.get()),
                new ForkingTrunkPlacer(4, 4, 3),
                BlockStateProvider.simple(ModBlocks.ITHILIEN_TREE_LEAVES.get()),
                new SpruceFoliagePlacer(ConstantInt.of(2), ConstantInt.of(3), ConstantInt.of(3)),
                new ThreeLayersFeatureSize(1, 0, 3, 2,1, OptionalInt.of(2)))
                .build());
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(ElendilMod.MODID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

}