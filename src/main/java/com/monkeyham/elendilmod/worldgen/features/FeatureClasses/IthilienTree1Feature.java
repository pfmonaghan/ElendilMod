package com.monkeyham.elendilmod.worldgen.features.FeatureClasses;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import static net.minecraft.world.level.block.state.properties.BlockStateProperties.DISTANCE;

public class IthilienTree1Feature extends Feature<NoneFeatureConfiguration> {

    // Configurable parameters
    private static final int MIN_HEIGHT = 14;
    private static final int MAX_HEIGHT = 22;
    private static final Direction[] NS = new Direction[]{Direction.NORTH, Direction.SOUTH, Direction.UP, Direction.DOWN};
    private static final Direction[] EW = new Direction[]{Direction.WEST, Direction.EAST, Direction.UP, Direction.DOWN};
    private static final Direction[] DIRS = new Direction[]{Direction.WEST, Direction.EAST, Direction.NORTH, Direction.SOUTH};



    public IthilienTree1Feature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        WorldGenLevel level = context.level();
        RandomSource random = context.random();
        BlockPos origin = context.origin();

        // Find the ground level
        BlockPos.MutableBlockPos pos = origin.mutable();
        while (pos.getY() > level.getMinBuildHeight() + 1 &&
                !level.getBlockState(pos.below()).isSolid()) {
            pos.move(0, -1, 0);
        }

        int height = MIN_HEIGHT + random.nextInt(MAX_HEIGHT - MIN_HEIGHT + 1);
        //int baseRadius = BASE_RADIUS + (random.nextBoolean() ? 1 : 0);

        // Check space
        if (!isSpaceValid(level, pos.immutable(), height)) {//baseRadius + 1
            return false;
        }

        // Build the tree
        return buildConifer(level, pos.immutable(), height, random);
    }

    private static Direction getRandomHorizontalDir(RandomSource r){


        Direction d = Direction.getRandom(r);
        while(d == Direction.UP || d == Direction.DOWN){
            d = Direction.getRandom(r);
        }
        return d;
    }

    private boolean buildConifer(WorldGenLevel level, BlockPos basePos, int height, RandomSource random) {
        BlockState logState = Blocks.SPRUCE_LOG.defaultBlockState();//Blocks.SPRUCE_LOG.defaultBlockState();
        BlockState woodState = Blocks.SPRUCE_WOOD.defaultBlockState();//Blocks.SPRUCE_WOOD.defaultBlockState();
        BlockState leaves = Blocks.SPRUCE_LEAVES.defaultBlockState().setValue(DISTANCE, 1);//Blocks.SPRUCE_LEAVES.defaultBlockState();


        for (int i = 0; i < height; i++) {
            BlockPos bb = basePos.mutable().move(Direction.UP, i);
            level.setBlock(bb, logState, 3);
            if(i>2&&random.nextBoolean() && i<height/2){
                for (Direction dir : DIRS) {
                    if(random.nextBoolean())
                        placeBigBranch(level, bb, random, getRandomHorizontalDir(random), woodState, leaves);
                }
            }
            else if((random.nextBoolean() && i > 2 && i<height-3) ||(i>=height/2&&i<height-3)){
                for (Direction dir : DIRS) {
                    if(random.nextBoolean())
                        placeSmallBranch(level, bb, random, getRandomHorizontalDir(random), woodState, leaves);

                }
            } else if ((random.nextBoolean()&& i > 2)||(i >= height -3)) {
                for (Direction dir : DIRS) {
                    if(random.nextBoolean())
                        placeLeaf(level, bb, random, getRandomHorizontalDir(random), leaves);

                }
            }
        }
        for (int i = height; i < height+2; i++) {
            BlockPos bb = basePos.mutable().move(Direction.UP, i);
            level.setBlock(bb, leaves, 3);
        }

        return true;
    }

    private void placeLeaf(WorldGenLevel level, BlockPos blockPos, RandomSource random, Direction dir, BlockState leaf) {
        BlockPos o1 = blockPos.mutable().move(dir, 1);
        level.setBlock(o1, leaf, 3);
    }


    private void placeSmallBranch(WorldGenLevel level, BlockPos basePos, RandomSource random, Direction d, BlockState log, BlockState leaves) {
        BlockPos o1 = basePos.mutable().move(d, 1);
        level.setBlock(o1, log, 3);

        Direction[] directions = (d == Direction.NORTH || d == Direction.SOUTH) ? EW : NS;

        for (Direction dir : directions){
            BlockPos bb = o1.mutable().move(dir, 1);
            level.setBlock(bb, leaves, 3);
        }
        level.setBlock(o1.mutable().move(d, 1), leaves, 3);
    }

    public void placeBigBranch(WorldGenLevel level, BlockPos basePos, RandomSource random, Direction d,
                               BlockState log, BlockState leaves){

        BlockPos o1 = basePos.mutable().move(d, 1);
        level.setBlock(o1, log, 3);

        Direction[] directions = (d == Direction.NORTH || d == Direction.SOUTH) ? EW : NS;

        for (Direction dir : directions){
            BlockPos bb = o1.mutable().move(dir, 1);
            level.setBlock(bb, leaves, 3);
        }
        BlockPos o2 = o1.mutable().move(d, 1);
        level.setBlock(o2, log, 3);
        for (Direction dir : directions){
            BlockPos bb = o2.mutable().move(dir, 1);
            level.setBlock(bb, leaves, 3);
        }
        level.setBlock(o2.mutable().move(d, 1), leaves, 3);
    }

    private boolean isSpaceValid(WorldGenLevel level, BlockPos basePos, int height) { //, int radius
        // Check vertical space
        for (int y = 0; y <= height + 2; y++) {
            BlockPos pos = basePos.above(y);
            if (!level.getBlockState(pos).isAir() && !level.getBlockState(pos).is(BlockTags.REPLACEABLE_BY_TREES)) {
                return false;
            }
        }
        return true;
    }



}