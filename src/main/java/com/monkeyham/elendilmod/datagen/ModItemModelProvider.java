package com.monkeyham.elendilmod.datagen;

import com.monkeyham.elendilmod.ElendilMod;
import com.monkeyham.elendilmod.block.ModBlocks;
import com.monkeyham.elendilmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ElendilMod.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

        basicItem(ModBlocks.MORDOR_DOOR_1.asItem());
        basicItem(ModBlocks.OSGILIATH_DOOR_1.asItem());

        handheldItem(ModItems.MORDOR_FALCHION);
        handheldItem(ModItems.MORDOR_AXE);
        handheldItem(ModItems.MORDOR_MACE);
        handheldItem(ModItems.MORDOR_HALBERD);
        //shieldItem(ModItems.GONDOR_SHIELD);

        wallItem(ModBlocks.OSGILIATH_RUBBLE_WALL, ModBlocks.OSGILIATH_RUBBLE_1);
        wallItem(ModBlocks.OSGILIATH_STONE_1_WALL, ModBlocks.OSGILIATH_STONE_1);
        wallItem(ModBlocks.OSGILIATH_STONE_BRICK_1_WALL, ModBlocks.OSGILIATH_STONE_BRICK_1);
        wallItem(ModBlocks.MORDOR_BLOCK_1_WALL, ModBlocks.MORDOR_BLOCK_1);
        wallItem(ModBlocks.MORDOR_BLOCK_2_WALL, ModBlocks.MORDOR_BLOCK_2);
        wallItem(ModBlocks.MORDOR_BLOCK_3_WALL, ModBlocks.MORDOR_BLOCK_3);
        wallItem(ModBlocks.MORDOR_BLOCK_4_WALL, ModBlocks.MORDOR_BLOCK_4);
        wallItem(ModBlocks.MORDOR_BLOCK_5_WALL, ModBlocks.MORDOR_BLOCK_5);
        wallItem(ModBlocks.MORDOR_BLOCK_6_WALL, ModBlocks.MORDOR_BLOCK_6);
        wallItem(ModBlocks.CIRITH_UNGOL_WALL, ModBlocks.CIRITH_UNGOL_BLOCK);
        withExistingParent(ModBlocks.POLISHED_DIORITE_WALL.getId().getPath(), mcLoc("block/wall_inventory")).texture("wall",
                ResourceLocation.fromNamespaceAndPath("minecraft", "block/polished_diorite"));

        withExistingParent(ModItems.GECKO_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(ModItems.ORC_INFANTRY_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(ModItems.ORC_ARCHER_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(ModItems.GONDOR_SOLDIER_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(ModItems.GONDOR_ARCHER_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(ModItems.EYE_OF_SAURON_PATTERN_ITEM.getId().getPath(), mcLoc("item/creeper_banner_pattern"));

        saplingItem(ModBlocks.ITHILIEN_TREE_SAPLING);


    }

    private ResourceLocation shieldItem(DeferredItem<?> shieldItem) {
        String p = shieldItem.getId().getPath();
        ModelFile blockingModel = withExistingParent(shieldItem.getId().getPath() + "_blocking", ResourceLocation.fromNamespaceAndPath(ElendilMod.MODID, "basic_shield_base_blocking"))
                .texture("layer0", "item/" + shieldItem.getId().getPath());
        return withExistingParent(p, ResourceLocation.fromNamespaceAndPath(ElendilMod.MODID, "basic_shield_base"))
                .texture("layer0", "item/" + p)
                .override().predicate(ResourceLocation.withDefaultNamespace("blocking"), 1.0f).model(blockingModel).end()
                .getLocation();
    }

    private ItemModelBuilder saplingItem(DeferredBlock<Block> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(ElendilMod.MODID,"block/" + item.getId().getPath()));
    }
    public void wallItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  ResourceLocation.fromNamespaceAndPath(ElendilMod.MODID,
                        "block/" + baseBlock.getId().getPath()));
    }

    private ItemModelBuilder handheldItem(DeferredItem<?> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/handheld")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(ElendilMod.MODID,"item/" + item.getId().getPath()));
    }

}
