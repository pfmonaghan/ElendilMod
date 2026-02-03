package com.monkeyham.elendilmod.datagen;

import com.monkeyham.elendilmod.ElendilMod;
import com.monkeyham.elendilmod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
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
        archBlockWithItem(ModBlocks.OSGILIATH_ARCH_1, "block/osgiliath_arch_1");
        simpleBlockWithItem(ModBlocks.OSGILIATH_ARCH_PANE.get(), models().cubeBottomTop("block/osgiliath_arch_pane", modLoc("block/osgiliath_arch_pane"),
                modLoc("block/transparent"), modLoc("block/osgiliath_rubble_1")).renderType("cutout"));
        simpleBlockWithItem(ModBlocks.OSGILIATH_ARCH_PANE_BOTTOM.get(), models().cubeBottomTop("block/osgiliath_arch_pane_bottom",
                modLoc("block/osgiliath_arch_pane_bottom"), modLoc("block/osgiliath_rubble_1"), modLoc("block/transparent")).renderType("cutout"));

        simpleBlockWithItem(ModBlocks.DEAD_MARSHES_GRASS_1.get(), models().cross("dead_marshes_grass_1", modLoc("block/dead_marshes_grass_1")).renderType("cutout"));
        simpleBlockWithItem(ModBlocks.DEAD_MARSHES_GRASS_2.get(), models().cross("dead_marshes_grass_2", modLoc("block/dead_marshes_grass_2")).renderType("cutout"));

    }

    private void blockWithItem(DeferredBlock<?> deferredBlock)
    {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));

    }

    private void blockItem(DeferredBlock<?> deferredBlock)
    {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("elendilmod:block/" + deferredBlock.getId().getPath()));
    }

    private void archBlockWithItem(DeferredBlock<?> deferredBlock, String parent)
    {
        ResourceLocation bottom = modLoc(parent + "_bottom");
        ResourceLocation top = modLoc(parent+"_top");
        ResourceLocation side = modLoc(parent+"_side");
        ResourceLocation front = modLoc(parent+"_front");

        simpleBlockWithItem(deferredBlock.get(), models().orientableWithBottom(parent, side, front, bottom, top).renderType("cutout"));
    }


}
