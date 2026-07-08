package com.monkeyham.elendilmod.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.stream.IntStream;

public class Arch_2x2_Middle extends Block {

    public static final MapCodec<OsgiliathArch2> CODEC = simpleCodec(OsgiliathArch2::new);
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final EnumProperty<Half> HALF = BlockStateProperties.HALF;
    public static final EnumProperty<StairsShape> SHAPE = BlockStateProperties.STAIRS_SHAPE;
    protected static final VoxelShape TOP_AABB = Block.box((double)0.0F, (double)8.0F, (double)0.0F, (double)16.0F, (double)16.0F, (double)16.0F);
    protected static final VoxelShape BOTTOM_AABB = Block.box((double)0.0F, (double)0.0F, (double)0.0F, (double)16.0F, (double)8.0F, (double)16.0F);
    protected static final VoxelShape OCTET_NNN = Block.box(0.0, 0.0, 0.0, 8.0, 8.0, 8.0);
    protected static final VoxelShape OCTET_NNP = Block.box(0.0, 0.0, 8.0, 8.0, 8.0, 16.0);
    protected static final VoxelShape OCTET_NPN = Block.box(0.0, 8.0, 0.0, 8.0, 16.0, 8.0);
    protected static final VoxelShape OCTET_NPP = Block.box(0.0, 8.0, 8.0, 8.0, 16.0, 16.0);
    protected static final VoxelShape OCTET_PNN = Block.box(8.0, 0.0, 0.0, 16.0, 8.0, 8.0);
    protected static final VoxelShape OCTET_PNP = Block.box(8.0, 0.0, 8.0, 16.0, 8.0, 16.0);
    protected static final VoxelShape OCTET_PPN = Block.box(8.0, 8.0, 0.0, 16.0, 16.0, 8.0);
    protected static final VoxelShape OCTET_PPP = Block.box(8.0, 8.0, 8.0, 16.0, 16.0, 16.0);
    protected static final VoxelShape[] TOP_SHAPES = makeShapes(TOP_AABB, OCTET_NNN, OCTET_PNN, OCTET_NNP, OCTET_PNP);
    protected static final VoxelShape[] BOTTOM_SHAPES = makeShapes(BOTTOM_AABB, OCTET_NPN, OCTET_PPN, OCTET_NPP, OCTET_PPP);
    private static final int[] SHAPE_BY_STATE = new int[]{12, 5, 3, 10, 14, 13, 7, 11, 13, 7, 11, 14, 8, 4, 1, 2, 4, 1, 2, 8};



    public Arch_2x2_Middle(Properties properties) {
        super(properties);
        this.registerDefaultState(
                this.stateDefinition
                        .any()
                        .setValue(FACING, Direction.NORTH)
                        .setValue(HALF, Half.BOTTOM)
                        .setValue(SHAPE, StairsShape.STRAIGHT)
        );
    }

    private static VoxelShape[] makeShapes(VoxelShape slabShape, VoxelShape nwCorner, VoxelShape neCorner, VoxelShape swCorner, VoxelShape seCorner) {
        return IntStream.range(0, 16)
                .mapToObj(p_56945_ -> makeStairShape(p_56945_, slabShape, nwCorner, neCorner, swCorner, seCorner))
                .toArray(VoxelShape[]::new);
    }

    private static VoxelShape makeStairShape(
            int bitfield, VoxelShape slabShape, VoxelShape nwCorner, VoxelShape neCorner, VoxelShape swCorner, VoxelShape seCorner
    ) {
        VoxelShape voxelshape = slabShape;
        if ((bitfield & 1) != 0) {voxelshape = Shapes.or(slabShape, nwCorner);}

        if ((bitfield & 2) != 0) {voxelshape = Shapes.or(voxelshape, neCorner);}

        if ((bitfield & 4) != 0) { voxelshape = Shapes.or(voxelshape, swCorner);}

        if ((bitfield & 8) != 0) { voxelshape = Shapes.or(voxelshape, seCorner);}
        return voxelshape;
    }

    @Override
    protected MapCodec<? extends Block> codec() {
        return CODEC;
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, HALF, SHAPE);
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return (state.getValue(HALF) == Half.TOP ? TOP_SHAPES : BOTTOM_SHAPES)[SHAPE_BY_STATE[this.getShapeIndex(state)]];
    }

    private int getShapeIndex(BlockState state) {
        return state.getValue(SHAPE).ordinal() * 4 + state.getValue(FACING).get2DDataValue();
    }

}
