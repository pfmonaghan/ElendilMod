package com.monkeyham.elendilmod.datagen;

import com.monkeyham.elendilmod.ElendilMod;
import com.monkeyham.elendilmod.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, ElendilMod.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE).
                add(ModBlocks.OSGILIATH_RUBBLE_1.get())
                .add(ModBlocks.OSGILIATH_RUBBLE_SLAB.get())
                .add(ModBlocks.OSGILIATH_RUBBLE_STAIRS.get())
                .add(ModBlocks.OSGILIATH_ARCH_1.get())
                .add(ModBlocks.OSGILIATH_ARCH_2.get())
                .add(ModBlocks.OSGILIATH_ARCH_PANE_BOTTOM.get())
                .add(ModBlocks.OSGILIATH_ARCH_PANE.get())
                .add(ModBlocks.OSGILIATH_QUARTER_DOME.get());
    }
}
