package com.monkeyham.elendilmod.worldgen.structures.Pools.FarmPools;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import com.monkeyham.elendilmod.worldgen.features.ModPlacedFeatures;
import com.monkeyham.elendilmod.worldgen.structures.Pools.ModPools;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.Pools;
import net.minecraft.data.worldgen.placement.TreePlacements;
import net.minecraft.data.worldgen.placement.VillagePlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;

public class GondorFarmPools {

    public static final ResourceKey<StructureTemplatePool> START = ModPools.createKey("farms/gondor/homestead_base");
    private static final ResourceKey<StructureTemplatePool> TERMINATORS_KEY = ModPools.createKey("farms/gondor/terminators");
    private static final ResourceKey<StructureTemplatePool> FARMS_COMMON_TREES = ModPools.createKey("farms/common/trees");
    private static final ResourceKey<StructureTemplatePool> FARMS_COMMON_PATHS = ModPools.createKey("farms/common/paths");
    private static final ResourceKey<StructureTemplatePool> FARMS_COMMON_FEATURES = ModPools.createKey("farms/common/features");


    public static void bootstrap(BootstrapContext<StructureTemplatePool> context) {
        HolderGetter<StructureTemplatePool> templatePools = context.lookup(Registries.TEMPLATE_POOL);
        HolderGetter<PlacedFeature> placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        Holder<PlacedFeature> oakTree = placedFeatures.getOrThrow(TreePlacements.FANCY_OAK_CHECKED);
        Holder<PlacedFeature> spruceTree = placedFeatures.getOrThrow(ModPlacedFeatures.ITHILIEN_TREE_1_CHECKED);
        Holder<PlacedFeature> cherryTree = placedFeatures.getOrThrow(TreePlacements.CHERRY_CHECKED);
        Holder<PlacedFeature> birchTree = placedFeatures.getOrThrow(TreePlacements.BIRCH_CHECKED);
        Holder<PlacedFeature> pineTree = placedFeatures.getOrThrow(TreePlacements.PINE_CHECKED);
        Holder<PlacedFeature> hayPile = placedFeatures.getOrThrow(VillagePlacements.PILE_HAY_VILLAGE);

        Holder<StructureTemplatePool> emptyFallback = templatePools.getOrThrow(Pools.EMPTY);
        context.register(START,
                new StructureTemplatePool(emptyFallback,
                ImmutableList.of(
                        Pair.of(ModPools.legacyPoolFunction("farms/gondor/small_farm"), 1)),
                StructureTemplatePool.Projection.RIGID));

        context.register(FARMS_COMMON_TREES,
                new StructureTemplatePool(emptyFallback,
                        ImmutableList.of(
                                Pair.of(StructurePoolElement.feature(oakTree), 1),
                                Pair.of(StructurePoolElement.feature(spruceTree), 1),
                                Pair.of(StructurePoolElement.feature(cherryTree), 1),
                                Pair.of(StructurePoolElement.feature(birchTree), 1),
                                Pair.of(StructurePoolElement.feature(pineTree), 1),
                                Pair.of(StructurePoolElement.feature(hayPile), 1)
                        ), StructureTemplatePool.Projection.RIGID));

        context.register(FARMS_COMMON_PATHS,
                new StructureTemplatePool(emptyFallback,
                        ImmutableList.of(
                                Pair.of(ModPools.legacyPoolFunction("farms/common/paths/small_straight_path"), 2),
                                Pair.of(ModPools.legacyPoolFunction("farms/common/paths/corner_path"), 3),
                                Pair.of(ModPools.legacyPoolFunction("farms/common/paths/path_crossing"), 1),
                                Pair.of(ModPools.legacyPoolFunction("farms/common/paths/path_to_feature"), 2)
                        ),
                        StructureTemplatePool.Projection.TERRAIN_MATCHING));

        context.register(FARMS_COMMON_FEATURES,
                new StructureTemplatePool(emptyFallback,
                        ImmutableList.of(
                                Pair.of(ModPools.legacyPoolFunction("farms/common/farm_features/outdoor_chicken_coop"), 2),
                                Pair.of(ModPools.legacyPoolFunction("farms/common/farm_features/wheat_plot"), 2),
                                Pair.of(ModPools.legacyPoolFunction("farms/common/farm_features/pig_pen"), 2),
                                Pair.of(ModPools.legacyPoolFunction("farms/common/farm_features/small_farm_well"), 2),
                                Pair.of(ModPools.legacyPoolFunction("farms/common/farm_features/farm_feature"), 2)
                        ),
                        StructureTemplatePool.Projection.RIGID));

//        Pools.register(context, "farms/common/trees",
//                new StructureTemplatePool(emptyFallback,
//                        ImmutableList.of(
//                                Pair.of(StructurePoolElement.feature(oakTree), 1),
//                                Pair.of(StructurePoolElement.feature(spruceTree), 1),
//                                Pair.of(StructurePoolElement.feature(cherryTree), 1),
//                                Pair.of(StructurePoolElement.feature(birchTree), 1),
//                                Pair.of(StructurePoolElement.feature(pineTree), 1),
//                                Pair.of(StructurePoolElement.feature(hayPile), 1)
//                        ), StructureTemplatePool.Projection.RIGID));
//        Pools.register(context, "farms/common/paths",
//                new StructureTemplatePool(emptyFallback,
//                        ImmutableList.of(
//                                Pair.of(ModPools.legacyPoolFunction("farms/common/paths/small_straight_path"), 2),
//                                Pair.of(ModPools.legacyPoolFunction("farms/common/paths/corner_path"), 3),
//                                Pair.of(ModPools.legacyPoolFunction("farms/common/paths/path_crossing"), 1),
//                                Pair.of(ModPools.legacyPoolFunction("farms/common/paths/path_to_feature"), 2)
//                                ),
//                        StructureTemplatePool.Projection.TERRAIN_MATCHING));
//        Pools.register(context, "farms/common/features",
//                new StructureTemplatePool(emptyFallback,
//                        ImmutableList.of(
//                                Pair.of(ModPools.legacyPoolFunction("elendilmod/structures/outdoor_chicken_coop"), 2),
//                                Pair.of(ModPools.legacyPoolFunction("elendilmod/structures/wheat_plot"), 2),
//                                Pair.of(ModPools.legacyPoolFunction("elendilmod/structures/pig_pen"), 2),
//                                Pair.of(ModPools.legacyPoolFunction("elendilmod/structures/small_farm_well"), 2),
//                                Pair.of(ModPools.legacyPoolFunction("elendilmod/structures/farm_feature"), 2)
//                                ),
//                        StructureTemplatePool.Projection.RIGID));



        }

}
