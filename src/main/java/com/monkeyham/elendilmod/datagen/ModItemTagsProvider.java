package com.monkeyham.elendilmod.datagen;

import com.monkeyham.elendilmod.ElendilMod;
import com.monkeyham.elendilmod.block.ModBlocks;
import com.monkeyham.elendilmod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, ElendilMod.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ItemTags.SWORDS)
                .add(ModItems.MORDOR_FALCHION.get())
                .add(ModItems.MORDOR_MACE.get())
                .add(ModItems.MORDOR_HALBERD.get());
        tag(ItemTags.AXES)
                .add(ModItems.MORDOR_AXE.get());
        tag(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.ITHILIEN_TREE_LOG.get().asItem())
                .add(ModBlocks.ITHILIEN_TREE_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_ITHILIEN_TREE_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_ITHILIEN_TREE_WOOD.get().asItem());
        tag(ItemTags.PLANKS)
                .add(ModBlocks.ITHILIEN_TREE_PLANKS.get().asItem());
    }
}
