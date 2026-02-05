package com.monkeyham.elendilmod.datagen;

import com.monkeyham.elendilmod.ElendilMod;
import com.monkeyham.elendilmod.block.ModBlocks;
import com.monkeyham.elendilmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ElendilMod.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

        basicItem(ModBlocks.MORDOR_DOOR_1.asItem());
        basicItem(ModBlocks.OSGILIATH_DOOR_1.asItem());

        wallItem(ModBlocks.OSGILIATH_RUBBLE_WALL, ModBlocks.OSGILIATH_RUBBLE_1);
        wallItem(ModBlocks.OSGILIATH_STONE_1_WALL, ModBlocks.OSGILIATH_STONE_1);
        wallItem(ModBlocks.OSGILIATH_STONE_BRICK_1_WALL, ModBlocks.OSGILIATH_STONE_BRICK_1);
        wallItem(ModBlocks.MORDOR_BLOCK_1_WALL, ModBlocks.MORDOR_BLOCK_1);
        wallItem(ModBlocks.MORDOR_BLOCK_2_WALL, ModBlocks.MORDOR_BLOCK_2);
        wallItem(ModBlocks.MORDOR_BLOCK_3_WALL, ModBlocks.MORDOR_BLOCK_3);
        wallItem(ModBlocks.MORDOR_BLOCK_4_WALL, ModBlocks.MORDOR_BLOCK_4);
        wallItem(ModBlocks.MORDOR_BLOCK_5_WALL, ModBlocks.MORDOR_BLOCK_5);
        wallItem(ModBlocks.MORDOR_BLOCK_6_WALL, ModBlocks.MORDOR_BLOCK_6);

        withExistingParent(ModItems.GECKO_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(ModItems.ORC_INFANTRY_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));

    }

    public void wallItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  ResourceLocation.fromNamespaceAndPath(ElendilMod.MODID,
                        "block/" + baseBlock.getId().getPath()));
    }

}
