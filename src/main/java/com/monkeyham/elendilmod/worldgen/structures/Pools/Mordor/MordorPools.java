package com.monkeyham.elendilmod.worldgen.structures.Pools.Mordor;

import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;

public class MordorPools {

    public static void bootstrap(BootstrapContext<StructureTemplatePool> context) {
        CirithUngolPool.bootstrap(context);
    }

}
