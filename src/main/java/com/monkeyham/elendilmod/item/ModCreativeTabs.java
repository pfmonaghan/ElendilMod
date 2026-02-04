package com.monkeyham.elendilmod.item;

import com.monkeyham.elendilmod.ElendilMod;
import com.monkeyham.elendilmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ElendilMod.MODID);

    public static final Supplier<CreativeModeTab> OSGILIATH_TAB = CREATIVE_MODE_TAB.register("osgiliath_tab", ()->CreativeModeTab.builder()
            .icon(()->new ItemStack(ModBlocks.OSGILIATH_STONE_1))
            .title(Component.translatable("creativetab.elendilmod.osgiliath"))
            .displayItems((itemDisplayParameters, output)->{
                output.accept(ModBlocks.OSGILIATH_STONE_1);
                output.accept(ModBlocks.OSGILIATH_STONE_1_SLAB);
                output.accept(ModBlocks.OSGILIATH_STONE_1_STAIRS);

                output.accept(ModBlocks.OSGILIATH_STONE_BRICK_1);
                output.accept(ModBlocks.OSGILIATH_STONE_BRICK_1_SLAB);
                output.accept(ModBlocks.OSGILIATH_STONE_BRICK_1_STAIRS);

                output.accept(ModBlocks.OSGILIATH_RUBBLE_1);
                output.accept(ModBlocks.OSGILIATH_RUBBLE_SLAB);
                output.accept(ModBlocks.OSGILIATH_RUBBLE_STAIRS);

                output.accept(ModBlocks.OSGILIATH_ROOF_TILE_1);
                output.accept(ModBlocks.OSGILIATH_ROOF_TILE_1_SLAB);
                output.accept(ModBlocks.OSGILIATH_ROOF_TILE_1_STAIRS);

                output.accept(ModBlocks.OSGILIATH_ARCH_1);
                output.accept(ModBlocks.OSGILIATH_ARCH_2);
                output.accept(ModBlocks.OSGILIATH_ARCH_PANE);
                output.accept(ModBlocks.OSGILIATH_ARCH_PANE_BOTTOM);
                output.accept(ModBlocks.OSGILIATH_PILLAR_1);
                output.accept(ModBlocks.OSGILIATH_QUARTER_DOME);
                output.accept(ModBlocks.OSGILIATH_DOME_9x9);

            })

            .build());

    public static final Supplier<CreativeModeTab> DEAD_MARSHES_TAB = CREATIVE_MODE_TAB.register("dead_marshes_tab", ()->CreativeModeTab.builder()
            .icon(()->new ItemStack(ModBlocks.DEAD_MARSHES_GRASS_1))
            .title(Component.translatable("creativetab.elendilmod.dead_marshes"))
            .displayItems((itemDisplayParameters, output)->{

                output.accept(ModBlocks.DEAD_MARSHES_GRASS_1);
                output.accept(ModBlocks.DEAD_MARSHES_GRASS_2);
                output.accept(ModBlocks.DEAD_MARSHES_CORPSE_CANDLE);

            }).build());

    public static final Supplier<CreativeModeTab> MORDOR_TAB = CREATIVE_MODE_TAB.register("mordor_tab", ()->CreativeModeTab.builder()
            .icon(()->new ItemStack(ModBlocks.MORDOR_MERLON))
            .title(Component.translatable("creativetab.elendilmod.mordor"))
            .displayItems((itemDisplayParameters, output)->{


            }).build());


    public static void register(IEventBus eventBus)
    {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
