package com.monkeyham.elendilmod.worldgen.features;

import com.mojang.serialization.Codec;
import com.monkeyham.elendilmod.ElendilMod;
import com.monkeyham.elendilmod.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.predicate.BlockStatePredicate;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.NoOpFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class RockyTerrain extends Feature<NoneFeatureConfiguration> {

    private static final BlockStatePredicate IS_STONE;

    public RockyTerrain(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
     BlockPos blockpos = context.origin();
     WorldGenLevel world = context.level();
     RandomSource random = context.random();

        for(blockpos = blockpos.above();
            world.isEmptyBlock(blockpos) && blockpos.getY() > world.getMinBuildHeight() + 2;
            blockpos = blockpos.below()) {
        }

     if (!IS_STONE.test(world.getBlockState(blockpos)))
     {
         return false;
     }
     else {
         int height = random.nextInt(3, 7);
         int width_x = random.nextInt(3, 5);
         int width_z = random.nextInt(3, 5);

         for (int i = 0; i < height; ++i) {
             this.setBlock(world, blockpos.above(i), Blocks.DIAMOND_BLOCK.defaultBlockState());
         }
         for (int i = 0; i < width_x; ++i) {
             this.setBlock(world, blockpos.west(i), Blocks.DIAMOND_BLOCK.defaultBlockState());
             this.setBlock(world, blockpos.east(i), Blocks.DIAMOND_BLOCK.defaultBlockState());
         }
         for (int i = 0; i < (width_z); ++i) {
             this.setBlock(world, blockpos.north(i), Blocks.DIAMOND_BLOCK.defaultBlockState());
             this.setBlock(world, blockpos.south(i), Blocks.DIAMOND_BLOCK.defaultBlockState());
         }

         return true;
     }
    }
    static {
        IS_STONE = BlockStatePredicate.forBlock(Blocks.DEEPSLATE);
    }
}
