package com.monkeyham.elendilmod.worldgen.features.FeatureClasses;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.BlockStateConfiguration;

public class LargeStoneFeature extends Feature<BlockStateConfiguration> {

    private static final int DEFAULT_RADIUS_X = 6;
    private static final int DEFAULT_RADIUS_Y = 4;
    private static final int DEFAULT_RADIUS_Z = 5;
    private static final float ELLIPSOID_FILL_FACTOR = 0.85f;

    public LargeStoneFeature(Codec<BlockStateConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<BlockStateConfiguration> context) {
        BlockPos origin = context.origin();
        WorldGenLevel level = context.level();
        RandomSource random = context.random();
        BlockStateConfiguration config = context.config();

        // Move down to find the surface
        while (origin.getY() > level.getMinBuildHeight() + 3) {
            if (!level.isEmptyBlock(origin.below())) {
                BlockState below = level.getBlockState(origin.below());
                if (isDirt(below) || isStone(below)) {
                    break;
                }
            }
            origin = origin.below();
        }

        if (origin.getY() <= level.getMinBuildHeight() + 3) {
            return false;
        }

        // Generate the ellipsoid
        boolean placed = generateEllipsoid(level, origin, random, config.state);

        // Generate some smaller ellipsoids around it for variation
        for (int i = 0; i < 3; i++) {
            BlockPos offset = origin.offset(
                    -2 + random.nextInt(5),
                    -1 + random.nextInt(3),
                    -2 + random.nextInt(5)
            );
            generateEllipsoid(level, offset, random, config.state);
        }

        return placed;
    }

    private boolean generateEllipsoid(WorldGenLevel level, BlockPos center, RandomSource random, BlockState state) {
        // Randomize radii slightly for organic variation
        float radiusX = DEFAULT_RADIUS_X + (random.nextFloat() - 0.5f) * 2f;
        float radiusY = DEFAULT_RADIUS_Y + (random.nextFloat() - 0.5f) * 1.5f;
        float radiusZ = DEFAULT_RADIUS_Z + (random.nextFloat() - 0.5f) * 2f;

        // Ensure minimum size
        radiusX = Math.max(radiusX, 4f);
        radiusY = Math.max(radiusY, 3f);
        radiusZ = Math.max(radiusZ, 4f);

        int minX = (int) Math.floor(center.getX() - radiusX);
        int maxX = (int) Math.ceil(center.getX() + radiusX);
        int minY = (int) Math.floor(center.getY() - radiusY);
        int maxY = (int) Math.ceil(center.getY() + radiusY);
        int minZ = (int) Math.floor(center.getZ() - radiusZ);
        int maxZ = (int) Math.ceil(center.getZ() + radiusZ);

        boolean anyPlaced = false;

        for (int x = minX; x <= maxX; x++) {
            for (int y = minY; y <= maxY; y++) {
                for (int z = minZ; z <= maxZ; z++) {
                    BlockPos pos = new BlockPos(x, y, z);

                    // Check if position is inside the ellipsoid
                    double dx = (x - center.getX()) / radiusX;
                    double dy = (y - center.getY()) / radiusY;
                    double dz = (z - center.getZ()) / radiusZ;

                    double distanceSq = dx * dx + dy * dy + dz * dz;

                    // Add some randomness to the boundary for a natural look
                    double threshold = 1.0 + (random.nextDouble() - 0.5) * 0.15;

                    // Apply fill factor to prevent perfect smoothness
                    if (distanceSq <= threshold * ELLIPSOID_FILL_FACTOR) {
                        // Add some internal voids for a more natural stone blob
                        if (random.nextFloat() > 0.05f) { // 5% chance of void
                            if (level.getBlockState(pos).isAir() ||
                                    level.getBlockState(pos).canBeReplaced()) {
                                level.setBlock(pos, state, 3);
                                anyPlaced = true;
                            }
                        }
                    }
                }
            }
        }

        return anyPlaced;
    }
}
