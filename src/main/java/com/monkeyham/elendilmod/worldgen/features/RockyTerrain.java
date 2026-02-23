package com.monkeyham.elendilmod.worldgen.features;

import com.mojang.serialization.Codec;
import com.monkeyham.elendilmod.ElendilMod;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.NoOpFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class RockyTerrain extends Feature<NoneFeatureConfiguration> {

    public RockyTerrain(Codec codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext context) {
     BlockPos blockpos = context.origin();
     WorldGenLevel world = context.level();
        for(int i = 0; i < 4; ++i) {
            this.setBlock(world, blockpos.above(i), Blocks.DIAMOND_BLOCK.defaultBlockState());

        }
        return true;
    }

}
