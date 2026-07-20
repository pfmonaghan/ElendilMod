package com.monkeyham.elendilmod.worldgen.structures.Pools.FarmPools;

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

public class RohanFarmPools {

    public static final ResourceKey<StructureTemplatePool> START = ModPools.createKey("farms/rohan/homestead_base");
    private static final ResourceKey<StructureTemplatePool> TERMINATORS_KEY = ModPools.createKey("farms/rohan/terminators");

    public static void bootstrap(BootstrapContext<StructureTemplatePool> context) {
        HolderGetter<StructureTemplatePool> templatePools = context.lookup(Registries.TEMPLATE_POOL);
        Holder<StructureTemplatePool> emptyFallback = templatePools.getOrThrow(Pools.EMPTY);

        context.register(START, new StructureTemplatePool(emptyFallback, ImmutableList.of(Pair.of(ModPools.legacyPoolFunction("farms/rohan/small_farm"), 1)),
                StructureTemplatePool.Projection.RIGID));


    }

}


