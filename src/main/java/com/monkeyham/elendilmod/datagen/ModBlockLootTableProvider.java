package com.monkeyham.elendilmod.datagen;

import com.monkeyham.elendilmod.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {

    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.OSGILIATH_RUBBLE_1.get());
        dropSelf(ModBlocks.OSGILIATH_RUBBLE_SLAB.get());
        dropSelf(ModBlocks.OSGILIATH_RUBBLE_STAIRS.get());
        dropSelf(ModBlocks.OSGILIATH_RUBBLE_WALL.get());

        dropSelf(ModBlocks.OSGILIATH_STONE_1.get());
        dropSelf(ModBlocks.OSGILIATH_STONE_1_SLAB.get());
        dropSelf(ModBlocks.OSGILIATH_STONE_1_STAIRS.get());
        dropSelf(ModBlocks.OSGILIATH_STONE_1_WALL.get());

        dropSelf(ModBlocks.OSGILIATH_ROOF_TILE_1.get());
        dropSelf(ModBlocks.OSGILIATH_ROOF_TILE_1_SLAB.get());
        dropSelf(ModBlocks.OSGILIATH_ROOF_TILE_1_STAIRS.get());

        dropSelf(ModBlocks.OSGILIATH_STONE_BRICK_1.get());
        dropSelf(ModBlocks.OSGILIATH_STONE_BRICK_1_SLAB.get());
        dropSelf(ModBlocks.OSGILIATH_STONE_BRICK_1_STAIRS.get());
        dropSelf(ModBlocks.OSGILIATH_STONE_BRICK_1_WALL.get());

        dropSelf(ModBlocks.OSGILIATH_ARCH_1.get());
        dropSelf(ModBlocks.OSGILIATH_ARCH_PANE.get());
        dropSelf(ModBlocks.OSGILIATH_ARCH_PANE_BOTTOM.get());
        dropSelf(ModBlocks.OSGILIATH_ARCH_2.get());
        dropSelf(ModBlocks.MORDOR_MERLON.get());
        dropSelf(ModBlocks.DEAD_MARSHES_GRASS_1.get());
        dropSelf(ModBlocks.DEAD_MARSHES_GRASS_2.get());
        dropSelf(ModBlocks.OSGILIATH_QUARTER_DOME.get());
        dropSelf(ModBlocks.OSGILIATH_PILLAR_1.get());
        dropSelf(ModBlocks.AMON_HEN_STATUE_EAGLE.get());
        dropSelf(ModBlocks.OSGILIATH_DOME_9x9.get());
        dropSelf(ModBlocks.OSGILIATH_DOOR_1.get());


        dropSelf(ModBlocks.MORDOR_BLOCK_1.get());
        dropSelf(ModBlocks.MORDOR_BLOCK_1_SLAB.get());
        dropSelf(ModBlocks.MORDOR_BLOCK_1_STAIRS.get());
        dropSelf(ModBlocks.MORDOR_BLOCK_1_WALL.get());

        dropSelf(ModBlocks.MORDOR_BLOCK_2.get());
        dropSelf(ModBlocks.MORDOR_BLOCK_2_SLAB.get());
        dropSelf(ModBlocks.MORDOR_BLOCK_2_STAIRS.get());
        dropSelf(ModBlocks.MORDOR_BLOCK_2_WALL.get());

        dropSelf(ModBlocks.MORDOR_BLOCK_3.get());
        dropSelf(ModBlocks.MORDOR_BLOCK_3_SLAB.get());
        dropSelf(ModBlocks.MORDOR_BLOCK_3_STAIRS.get());
        dropSelf(ModBlocks.MORDOR_BLOCK_3_WALL.get());

        dropSelf(ModBlocks.MORDOR_BLOCK_4.get());
        dropSelf(ModBlocks.MORDOR_BLOCK_4_SLAB.get());
        dropSelf(ModBlocks.MORDOR_BLOCK_4_STAIRS.get());
        dropSelf(ModBlocks.MORDOR_BLOCK_4_WALL.get());

        dropSelf(ModBlocks.MORDOR_BLOCK_5.get());
        dropSelf(ModBlocks.MORDOR_BLOCK_5_SLAB.get());
        dropSelf(ModBlocks.MORDOR_BLOCK_5_STAIRS.get());
        dropSelf(ModBlocks.MORDOR_BLOCK_5_WALL.get());

        dropSelf(ModBlocks.MORDOR_BLOCK_6.get());
        dropSelf(ModBlocks.MORDOR_BLOCK_6_SLAB.get());
        dropSelf(ModBlocks.MORDOR_BLOCK_6_STAIRS.get());
        dropSelf(ModBlocks.MORDOR_BLOCK_6_WALL.get());

        dropSelf(ModBlocks.MORDOR_DOOR_1.get());
        dropSelf(ModBlocks.MORDOR_TRAPDOOR_1.get());

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
