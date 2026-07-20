package com.monkeyham.elendilmod.worldgen.structures.Pools.Mordor;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import com.monkeyham.elendilmod.worldgen.structures.Pools.ModPools;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.Pools;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;

public class CirithUngolPool {

    public static final ResourceKey<StructureTemplatePool> START = ModPools.createKey("mordor/cirith_ungol/base_pool");
    public static final ResourceKey<StructureTemplatePool> BACK_CLIFF = ModPools.createKey("mordor/cirith_ungol/back_cliff_pool");
    public static final ResourceKey<StructureTemplatePool> BRIDGE = ModPools.createKey("mordor/cirith_ungol/bridge_pool");
    public static final ResourceKey<StructureTemplatePool> TOP = ModPools.createKey("mordor/cirith_ungol/top_pool");

    public static void bootstrap(BootstrapContext<StructureTemplatePool> context) {
        HolderGetter<StructureTemplatePool> templatePools = context.lookup(Registries.TEMPLATE_POOL);
        Holder<StructureTemplatePool> emptyFallback = templatePools.getOrThrow(Pools.EMPTY);

        context.register(START, new StructureTemplatePool(emptyFallback, ImmutableList.of(Pair.of(
                ModPools.singleElementPoolFunction("mordor/cirith_ungol/base_part"), 1)),
                StructureTemplatePool.Projection.RIGID));
        context.register(BACK_CLIFF, new StructureTemplatePool(emptyFallback, ImmutableList.of(Pair.of(
                ModPools.singleElementPoolFunction("mordor/cirith_ungol/back_cliff_part"), 1)),
                StructureTemplatePool.Projection.RIGID));
        context.register(BRIDGE, new StructureTemplatePool(emptyFallback, ImmutableList.of(Pair.of(
                ModPools.singleElementPoolFunction("mordor/cirith_ungol/bridge_part"), 1)),
                StructureTemplatePool.Projection.RIGID));
        context.register(TOP, new StructureTemplatePool(emptyFallback, ImmutableList.of(Pair.of(
                ModPools.singleElementPoolFunction("mordor/cirith_ungol/top_part"), 1)),
                StructureTemplatePool.Projection.RIGID));


    }


}
