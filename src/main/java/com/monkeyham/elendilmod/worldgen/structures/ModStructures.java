package com.monkeyham.elendilmod.worldgen.structures;

import com.monkeyham.elendilmod.ElendilMod;
import com.monkeyham.elendilmod.entity.ModEntities;
import com.monkeyham.elendilmod.worldgen.biome.ModBiomes;
import com.monkeyham.elendilmod.worldgen.structures.Pools.FarmPools.GondorFarmPools;
import com.monkeyham.elendilmod.worldgen.structures.Pools.FarmPools.RohanFarmPools;
import com.monkeyham.elendilmod.worldgen.structures.Pools.Mordor.CirithUngolPool;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.TrialChambersStructurePools;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.util.random.WeightedRandomList;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.heightproviders.ConstantHeight;
import net.minecraft.world.level.levelgen.heightproviders.UniformHeight;
import net.minecraft.world.level.levelgen.structure.BuiltinStructures;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureSpawnOverride;
import net.minecraft.world.level.levelgen.structure.TerrainAdjustment;
import net.minecraft.world.level.levelgen.structure.pools.DimensionPadding;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.structures.JigsawStructure;
import net.minecraft.world.level.levelgen.structure.templatesystem.LiquidSettings;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static net.minecraft.world.level.levelgen.structure.structures.JigsawStructure.DEFAULT_DIMENSION_PADDING;
import static net.minecraft.world.level.levelgen.structure.structures.JigsawStructure.DEFAULT_LIQUID_SETTINGS;

public class ModStructures {

    public static final ResourceKey<Structure> CIRITH_UNGOL = registerKey("cirith_ungol");
    public static final ResourceKey<Structure> GONDOR_FARM = registerKey("gondor_farm");
    public static final ResourceKey<Structure> ROHAN_FARM = registerKey("rohan_farm");
    public static final ResourceKey<Structure> FARM_3 = registerKey("farm_3");

    public static void bootstrap(BootstrapContext<Structure> context){
        HolderGetter<Biome> biomeHolderGetter = context.lookup(Registries.BIOME);
        HolderGetter<StructureTemplatePool> templatePoolHolderGetter = context.lookup(Registries.TEMPLATE_POOL);

//        context.register(ModStructureSets.CIRITH_UNGOL,
//                new StructureSet(holder))

        context.register(
                CIRITH_UNGOL,
                new JigsawStructure(
                        new Structure.StructureSettings.Builder(HolderSet.direct(biomeHolderGetter.getOrThrow(ModBiomes.MORDOR_BIOME)))
                                .generationStep(GenerationStep.Decoration.SURFACE_STRUCTURES)
                                .terrainAdapation(TerrainAdjustment.BEARD_BOX)
                                .spawnOverrides(
                                        Map.of(
                                                MobCategory.MONSTER,
                                                new StructureSpawnOverride(
                                                        StructureSpawnOverride.BoundingBoxType.STRUCTURE,
                                                        WeightedRandomList.create(new MobSpawnSettings.SpawnerData(ModEntities.ORC_INFANTRY.get(), 1, 1, 1))
                                                )
                                        )
                                )
                                .build(),
                        templatePoolHolderGetter.getOrThrow(CirithUngolPool.START),
                        Optional.empty(),
                        7,
                        ConstantHeight.of(VerticalAnchor.absolute(0)),
                        false,
                        Optional.of(Heightmap.Types.WORLD_SURFACE_WG),
                        116,
                        List.of(),
                        DEFAULT_DIMENSION_PADDING, //new DimensionPadding(10)
                        DEFAULT_LIQUID_SETTINGS
                )
        );


//        context.register(
//                CIRITH_UNGOL,
//                new JigsawStructure(
//                        new Structure.StructureSettings.Builder(HolderSet.direct(biomeHolderGetter.getOrThrow(ModBiomes.MORDOR_BIOME)))
//                                .spawnOverrides(
//                                        Map.of(
//                                                MobCategory.MONSTER,
//                                                new StructureSpawnOverride(
//                                                        StructureSpawnOverride.BoundingBoxType.STRUCTURE,
//                                                        WeightedRandomList.create(new MobSpawnSettings.SpawnerData(ModEntities.ORC_INFANTRY.get(), 1, 1, 1))
//                                                )
//                                        )
//                                )
//                                .terrainAdapation(TerrainAdjustment.BEARD_THIN)
//                                .build(),
//                        templatePoolHolderGetter.getOrThrow(CirithUngolPool.START),
//                        7,
//                        ConstantHeight.of(VerticalAnchor.absolute(0)),
//                        true,
//                        Heightmap.Types.WORLD_SURFACE_WG
//                )
//        );

        context.register(
                GONDOR_FARM,
                new JigsawStructure(
                        new Structure.StructureSettings.Builder(HolderSet.direct(biomeHolderGetter.getOrThrow(ModBiomes.GONDOR_BIOME)))
                                .spawnOverrides(
                                        Map.of(
                                                MobCategory.MONSTER,
                                                new StructureSpawnOverride(
                                                        StructureSpawnOverride.BoundingBoxType.STRUCTURE,
                                                        WeightedRandomList.create(new MobSpawnSettings.SpawnerData(EntityType.PILLAGER, 1, 1, 1))
                                                )
                                        )
                                )
                                .terrainAdapation(TerrainAdjustment.BEARD_THIN)
                                .build(),
                        templatePoolHolderGetter.getOrThrow(GondorFarmPools.START),
                        7,
                        ConstantHeight.of(VerticalAnchor.absolute(0)),
                        true,
                        Heightmap.Types.WORLD_SURFACE_WG
                )
        );
        context.register(
                ROHAN_FARM,
                new JigsawStructure(
                        new Structure.StructureSettings.Builder(HolderSet.direct(biomeHolderGetter.getOrThrow(ModBiomes.ROHAN_BIOME)))
                                .terrainAdapation(TerrainAdjustment.BEARD_THIN)
                                .build(),
                        templatePoolHolderGetter.getOrThrow(RohanFarmPools.START),
                        7,
                        ConstantHeight.of(VerticalAnchor.absolute(0)),
                        true,
                        Heightmap.Types.WORLD_SURFACE_WG
                )
        );
        context.register(
                FARM_3,
                new JigsawStructure(
                        new Structure.StructureSettings.Builder(biomeHolderGetter.getOrThrow(BiomeTags.HAS_PILLAGER_OUTPOST))
                                .spawnOverrides(
                                        Map.of(
                                                MobCategory.MONSTER,
                                                new StructureSpawnOverride(
                                                        StructureSpawnOverride.BoundingBoxType.STRUCTURE,
                                                        WeightedRandomList.create(new MobSpawnSettings.SpawnerData(EntityType.PILLAGER, 1, 1, 1))
                                                )
                                        )
                                )
                                .terrainAdapation(TerrainAdjustment.BEARD_THIN)
                                .build(),
                        templatePoolHolderGetter.getOrThrow(GondorFarmPools.START),
                        7,
                        ConstantHeight.of(VerticalAnchor.absolute(0)),
                        true,
                        Heightmap.Types.WORLD_SURFACE_WG
                )
        );


    }

    private static ResourceKey<Structure> registerKey(String name) {
        return ResourceKey.create(Registries.STRUCTURE, ResourceLocation.fromNamespaceAndPath(ElendilMod.MODID, name));
    }

}
