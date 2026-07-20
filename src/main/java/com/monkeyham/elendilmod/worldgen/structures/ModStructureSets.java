package com.monkeyham.elendilmod.worldgen.structures;

import com.monkeyham.elendilmod.ElendilMod;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadStructurePlacement;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadType;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;

import java.util.List;

public class ModStructureSets {

    public static ResourceKey<StructureSet> CIRITH_UNGOL = registerKey("cirith_ungol");
    public static ResourceKey<StructureSet> FARMS = registerKey("farms");

    public static void bootstrap(BootstrapContext<StructureSet> context){
        HolderGetter<Structure> structureHoldergetter = context.lookup(Registries.STRUCTURE);
        HolderGetter<Biome> biomeHolderGetter = context.lookup(Registries.BIOME);
        HolderGetter<StructureTemplatePool> templatePoolHolderGetter = context.lookup(Registries.TEMPLATE_POOL);

        context.register(
                FARMS,
                new StructureSet(
                        List.of(
                                StructureSet.entry(structureHoldergetter.getOrThrow(ModStructures.GONDOR_FARM)),
                                StructureSet.entry(structureHoldergetter.getOrThrow(ModStructures.ROHAN_FARM)),
                                StructureSet.entry(structureHoldergetter.getOrThrow(ModStructures.FARM_3))
                        ),
                        new RandomSpreadStructurePlacement(34, 8, RandomSpreadType.LINEAR, 10387312)
                )
        );
        context.register(
                CIRITH_UNGOL,
                new StructureSet(
                        List.of(
                                StructureSet.entry(structureHoldergetter.getOrThrow(ModStructures.CIRITH_UNGOL))
                        ),
                        new RandomSpreadStructurePlacement(64, 16, RandomSpreadType.LINEAR, 10387312)
                )
        );

    }

    private static ResourceKey<StructureSet> registerKey(String name) {
        return ResourceKey.create(Registries.STRUCTURE_SET, ResourceLocation.fromNamespaceAndPath(ElendilMod.MODID, name));
    }

}
