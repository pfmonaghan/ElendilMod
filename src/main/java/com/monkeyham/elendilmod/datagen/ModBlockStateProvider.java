package com.monkeyham.elendilmod.datagen;

import com.monkeyham.elendilmod.ElendilMod;
import com.monkeyham.elendilmod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, ElendilMod.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {



        blockWithItem(ModBlocks.OSGILIATH_RUBBLE_1);
        slabBlock(ModBlocks.OSGILIATH_RUBBLE_SLAB.get(), blockTexture(ModBlocks.OSGILIATH_RUBBLE_1.get()),blockTexture(ModBlocks.OSGILIATH_RUBBLE_1.get()));
        simpleBlockItem(ModBlocks.OSGILIATH_RUBBLE_SLAB.get(), new ModelFile.UncheckedModelFile(
                "elendilmod:block/" + ModBlocks.OSGILIATH_RUBBLE_SLAB.getId().getPath()));
        stairsBlock(ModBlocks.OSGILIATH_RUBBLE_STAIRS.get(), blockTexture(ModBlocks.OSGILIATH_RUBBLE_1.get()));
        blockItem(ModBlocks.OSGILIATH_RUBBLE_STAIRS);
        wallBlock(ModBlocks.OSGILIATH_RUBBLE_WALL.get(), blockTexture(ModBlocks.OSGILIATH_RUBBLE_1.get()));

        blockWithItem(ModBlocks.OSGILIATH_STONE_1);
        slabBlockWithItem(ModBlocks.OSGILIATH_STONE_1_SLAB, ModBlocks.OSGILIATH_STONE_1);
        stairBlockWithItem(ModBlocks.OSGILIATH_STONE_1_STAIRS, ModBlocks.OSGILIATH_STONE_1);
        wallBlock(ModBlocks.OSGILIATH_STONE_1_WALL.get(), blockTexture(ModBlocks.OSGILIATH_STONE_1.get()));

        blockWithItem(ModBlocks.OSGILIATH_ROOF_TILE_1);
        slabBlockWithItem(ModBlocks.OSGILIATH_ROOF_TILE_1_SLAB, ModBlocks.OSGILIATH_ROOF_TILE_1);
        stairBlockWithItem(ModBlocks.OSGILIATH_ROOF_TILE_1_STAIRS, ModBlocks.OSGILIATH_ROOF_TILE_1);


        blockWithItem(ModBlocks.OSGILIATH_STONE_BRICK_1);
        slabBlockWithItem(ModBlocks.OSGILIATH_STONE_BRICK_1_SLAB, ModBlocks.OSGILIATH_STONE_BRICK_1);
        stairBlockWithItem(ModBlocks.OSGILIATH_STONE_BRICK_1_STAIRS, ModBlocks.OSGILIATH_STONE_BRICK_1);
        wallBlock(ModBlocks.OSGILIATH_STONE_BRICK_1_WALL.get(), blockTexture(ModBlocks.OSGILIATH_STONE_BRICK_1.get()));


        blockWithItem(ModBlocks.MORDOR_BLOCK_1);
        slabBlockWithItem(ModBlocks.MORDOR_BLOCK_1_SLAB, ModBlocks.MORDOR_BLOCK_1);
        stairBlockWithItem(ModBlocks.MORDOR_BLOCK_1_STAIRS, ModBlocks.MORDOR_BLOCK_1);
        wallBlock(ModBlocks.MORDOR_BLOCK_1_WALL.get(), blockTexture(ModBlocks.MORDOR_BLOCK_1.get()));


        blockWithItem(ModBlocks.MORDOR_BLOCK_2);
        slabBlockWithItem(ModBlocks.MORDOR_BLOCK_2_SLAB, ModBlocks.MORDOR_BLOCK_2);
        stairBlockWithItem(ModBlocks.MORDOR_BLOCK_2_STAIRS, ModBlocks.MORDOR_BLOCK_2);
        wallBlock(ModBlocks.MORDOR_BLOCK_2_WALL.get(), blockTexture(ModBlocks.MORDOR_BLOCK_2.get()));


        blockWithItem(ModBlocks.MORDOR_BLOCK_3);
        slabBlockWithItem(ModBlocks.MORDOR_BLOCK_3_SLAB, ModBlocks.MORDOR_BLOCK_3);
        stairBlockWithItem(ModBlocks.MORDOR_BLOCK_3_STAIRS, ModBlocks.MORDOR_BLOCK_3);
        wallBlock(ModBlocks.MORDOR_BLOCK_3_WALL.get(), blockTexture(ModBlocks.MORDOR_BLOCK_3.get()));


        blockWithItem(ModBlocks.MORDOR_BLOCK_4);
        slabBlockWithItem(ModBlocks.MORDOR_BLOCK_4_SLAB, ModBlocks.MORDOR_BLOCK_4);
        stairBlockWithItem(ModBlocks.MORDOR_BLOCK_4_STAIRS, ModBlocks.MORDOR_BLOCK_4);
        wallBlock(ModBlocks.MORDOR_BLOCK_4_WALL.get(), blockTexture(ModBlocks.MORDOR_BLOCK_4.get()));


        blockWithItem(ModBlocks.MORDOR_BLOCK_5);
        slabBlockWithItem(ModBlocks.MORDOR_BLOCK_5_SLAB, ModBlocks.MORDOR_BLOCK_5);
        stairBlockWithItem(ModBlocks.MORDOR_BLOCK_5_STAIRS, ModBlocks.MORDOR_BLOCK_5);
        wallBlock(ModBlocks.MORDOR_BLOCK_5_WALL.get(), blockTexture(ModBlocks.MORDOR_BLOCK_5.get()));


        blockWithItem(ModBlocks.MORDOR_BLOCK_6);
        slabBlockWithItem(ModBlocks.MORDOR_BLOCK_6_SLAB, ModBlocks.MORDOR_BLOCK_6);
        stairBlockWithItem(ModBlocks.MORDOR_BLOCK_6_STAIRS, ModBlocks.MORDOR_BLOCK_6);
        wallBlock(ModBlocks.MORDOR_BLOCK_6_WALL.get(), blockTexture(ModBlocks.MORDOR_BLOCK_6.get()));

        doorBlock(ModBlocks.MORDOR_DOOR_1.get(), modLoc("block/mordor_door_1_bottom"), modLoc("block/mordor_door_1_top"));
        doorBlock(ModBlocks.OSGILIATH_DOOR_1.get(), modLoc("block/osgiliath_door_1_bottom"), modLoc("block/osgiliath_door_1_top"));
        trapdoorBlock(ModBlocks.MORDOR_TRAPDOOR_1.get(), modLoc("block/mordor_trapdoor_1"), true);
        blockItem(ModBlocks.MORDOR_TRAPDOOR_1, "_bottom");

        archBlockWithItem(ModBlocks.OSGILIATH_ARCH_1, "block/osgiliath_arch_1");
        simpleBlockWithItem(ModBlocks.OSGILIATH_ARCH_PANE.get(), models().cubeBottomTop("block/osgiliath_arch_pane", modLoc("block/osgiliath_arch_pane"),
                modLoc("block/transparent"), modLoc("block/osgiliath_rubble_1")).renderType("cutout"));
        simpleBlockWithItem(ModBlocks.OSGILIATH_ARCH_PANE_BOTTOM.get(), models().cubeBottomTop("block/osgiliath_arch_pane_bottom",
                modLoc("block/osgiliath_arch_pane_bottom"), modLoc("block/osgiliath_rubble_1"), modLoc("block/transparent")).renderType("cutout"));

        simpleBlockWithItem(ModBlocks.DEAD_MARSHES_GRASS_1.get(), models().cross("dead_marshes_grass_1", modLoc("block/dead_marshes_grass_1")).renderType("cutout"));
        simpleBlockWithItem(ModBlocks.DEAD_MARSHES_GRASS_2.get(), models().cross("dead_marshes_grass_2", modLoc("block/dead_marshes_grass_2")).renderType("cutout"));
        simpleBlockWithItem(ModBlocks.DEAD_MARSHES_CORPSE_CANDLE.get(), models().cross("dead_marshes_corpse_candle", modLoc("block/dead_marshes_corpse_candle")).renderType("cutout"));


    }

    private void blockWithItem(DeferredBlock<?> deferredBlock)
    {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));

    }

    private void blockItem(DeferredBlock<?> deferredBlock)
    {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("elendilmod:block/" + deferredBlock.getId().getPath()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock, String appendix)
    {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("elendilmod:block/" + deferredBlock.getId().getPath() + appendix));
    }

    private void archBlockWithItem(DeferredBlock<?> deferredBlock, String parent)
    {
        ResourceLocation bottom = modLoc(parent + "_bottom");
        ResourceLocation top = modLoc(parent+"_top");
        ResourceLocation side = modLoc(parent+"_side");
        ResourceLocation front = modLoc(parent+"_front");

        simpleBlockWithItem(deferredBlock.get(), models().orientableWithBottom(parent, side, front, bottom, top).renderType("cutout"));
    }


    private void slabBlockWithItem(DeferredBlock<SlabBlock> deferredBlock, DeferredBlock<Block> textureParent)
    {
        slabBlock(deferredBlock.get(), blockTexture(textureParent.get()),blockTexture(textureParent.get()));
        blockItem(deferredBlock);
    }

    private void stairBlockWithItem(DeferredBlock<StairBlock> deferredBlock, DeferredBlock<Block> textureParent)
    {
        stairsBlock(deferredBlock.get(), blockTexture(textureParent.get()));
        blockItem(deferredBlock);

    }

}
