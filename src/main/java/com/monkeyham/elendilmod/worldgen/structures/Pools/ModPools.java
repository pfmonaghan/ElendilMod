package com.monkeyham.elendilmod.worldgen.structures.Pools;

import com.monkeyham.elendilmod.ElendilMod;
import com.monkeyham.elendilmod.worldgen.structures.Pools.FarmPools.GondorFarmPools;
import com.monkeyham.elendilmod.worldgen.structures.Pools.FarmPools.RohanFarmPools;
import com.monkeyham.elendilmod.worldgen.structures.Pools.Mordor.MordorPools;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;

import java.util.function.Function;

public class ModPools {

    public static void bootstrap(BootstrapContext<StructureTemplatePool> context){
        GondorFarmPools.bootstrap(context);
        RohanFarmPools.bootstrap(context);
        MordorPools.bootstrap(context);
    }

    public static ResourceKey<StructureTemplatePool> createKey(String name) {
        return ResourceKey.create(Registries.TEMPLATE_POOL, ResourceLocation.fromNamespaceAndPath(ElendilMod.MODID, name));
    }

    public static Function<StructureTemplatePool.Projection, ? extends StructurePoolElement> legacyPoolFunction(String s) {
        return StructurePoolElement.legacy(ElendilMod.MODID + ':' + s);
    }
    public static Function<StructureTemplatePool.Projection, ? extends StructurePoolElement> singleElementPoolFunction(String s) {
        return StructurePoolElement.single(ElendilMod.MODID + ':' + s);
    }
}
