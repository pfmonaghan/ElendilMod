package com.monkeyham.elendilmod.item;

import com.monkeyham.elendilmod.ElendilMod;
import com.monkeyham.elendilmod.entity.ModEntities;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ElendilMod.MODID);

    public static final DeferredItem<Item> GECKO_SPAWN_EGG = ITEMS.register("gecko_spawn_egg", ()-> new
            DeferredSpawnEggItem(ModEntities.GECKO, 0x31afaf, 0xffac00, new Item.Properties()));
    public static final DeferredItem<Item> ORC_INFANTRY_SPAWN_EGG = ITEMS.register("orc_infantry_spawn_egg", ()-> new
            DeferredSpawnEggItem(ModEntities.ORC_INFANTRY, 0x31afaf, 0xffac00, new Item.Properties()));
    public static final DeferredItem<Item> ORC_ARCHER_SPAWN_EGG = ITEMS.register("orc_archer_spawn_egg", ()-> new
            DeferredSpawnEggItem(ModEntities.ORC_ARCHER, 0x31afaf, 0xffac00, new Item.Properties()));
    public static final DeferredItem<SwordItem> MORDOR_FALCHION = ITEMS.register("mordor_falchion",
            () -> new SwordItem(Tiers.IRON, new Item.Properties().attributes(SwordItem.createAttributes(Tiers.IRON, 6, -2.45f))));


    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }

}
