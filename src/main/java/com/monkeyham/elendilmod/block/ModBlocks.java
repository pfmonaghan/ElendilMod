package com.monkeyham.elendilmod.block;

import com.monkeyham.elendilmod.ElendilMod;
import com.monkeyham.elendilmod.block.custom.MordorMerlonBlock;
import com.monkeyham.elendilmod.block.custom.OsgiliathArch2;
import com.monkeyham.elendilmod.block.custom.OsgiliathQuarterDome;
import com.monkeyham.elendilmod.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(ElendilMod.MODID);

    public static final DeferredBlock<Block> OSGILIATH_RUBBLE_1 = registerBlock("osgiliath_rubble_1",
            ()-> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<SlabBlock> OSGILIATH_RUBBLE_SLAB = registerBlock("osgiliath_rubble_slab",
            ()-> new SlabBlock(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<StairBlock> OSGILIATH_RUBBLE_STAIRS = registerBlock("osgiliath_rubble_stairs",
            ()-> new StairBlock(ModBlocks.OSGILIATH_RUBBLE_1.get().defaultBlockState(), BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> OSGILIATH_ARCH_PANE = registerBlock("osgiliath_arch_pane",
            ()-> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().sound(SoundType.STONE).noCollission()));
    public static final DeferredBlock<Block> OSGILIATH_ARCH_PANE_BOTTOM = registerBlock("osgiliath_arch_pane_bottom",
            ()-> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().sound(SoundType.STONE).noCollission()));
    public static final DeferredBlock<Block> OSGILIATH_ARCH_1 = registerBlock("osgiliath_arch_1",
            ()->new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().sound(SoundType.STONE).noOcclusion()));
    public static final DeferredBlock<Block> OSGILIATH_ARCH_2 = registerBlock("osgiliath_arch_2",
            ()->new OsgiliathArch2(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().sound(SoundType.STONE).noOcclusion().noCollission()));
    public static final DeferredBlock<Block> MORDOR_MERLON = registerBlock("mordor_merlon",
            ()->new MordorMerlonBlock(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().sound(SoundType.METAL).noOcclusion()));
    public static final DeferredBlock<Block> OSGILIATH_QUARTER_DOME = registerBlock("osgiliath_quarter_dome",
            ()->new OsgiliathQuarterDome(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().sound(SoundType.STONE).noOcclusion()));

    public static final DeferredBlock<Block> DEAD_MARSHES_GRASS_1 = registerBlock("dead_marshes_grass_1",
            ()->new Block(BlockBehaviour.Properties.of().strength(4f).sound(SoundType.GRASS).noOcclusion().noCollission()));
    public static final DeferredBlock<Block> DEAD_MARSHES_GRASS_2 = registerBlock("dead_marshes_grass_2",
            ()->new Block(BlockBehaviour.Properties.of().strength(4f).sound(SoundType.GRASS).noOcclusion().noCollission()));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block)
    {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block)
    {
        ModItems.ITEMS.register(name, ()->new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus)
    {
        BLOCKS.register(eventBus);
    }

}
