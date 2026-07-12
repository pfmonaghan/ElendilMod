package com.monkeyham.elendilmod.item;

import com.monkeyham.elendilmod.ElendilMod;
import com.monkeyham.elendilmod.entity.ModEntities;
import com.monkeyham.elendilmod.item.custom.ModBannerPatterns;
import com.monkeyham.elendilmod.item.custom.armor.Mordor.MordorHelmet1;
import com.monkeyham.elendilmod.item.custom.shields.GondorShield;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
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
    public static final DeferredItem<Item> GONDOR_SOLDIER_SPAWN_EGG = ITEMS.register("gondor_soldier_spawn_egg", ()-> new
            DeferredSpawnEggItem(ModEntities.GONDOR_SOLDIER, 0x31afaf, 0xffac00, new Item.Properties()));
public static final DeferredItem<Item> GONDOR_ARCHER_SPAWN_EGG = ITEMS.register("gondor_archer_spawn_egg", ()-> new
            DeferredSpawnEggItem(ModEntities.GONDOR_ARCHER, 0x31afaf, 0xffac00, new Item.Properties()));

    public static final DeferredItem<SwordItem> MORDOR_FALCHION = ITEMS.register("mordor_falchion",
            () -> new SwordItem(Tiers.IRON, new Item.Properties().attributes(SwordItem.createAttributes(Tiers.IRON, 6, -2.45f))));
    public static final DeferredItem<AxeItem> MORDOR_AXE = ITEMS.register("mordor_axe",
            () -> new AxeItem(Tiers.IRON, new Item.Properties().attributes(AxeItem.createAttributes(Tiers.IRON, 7, -2.85f))));
    public static final DeferredItem<SwordItem> MORDOR_MACE = ITEMS.register("mordor_mace",
            () -> new SwordItem(Tiers.IRON, new Item.Properties().attributes(SwordItem.createAttributes(Tiers.IRON, 4.5f, -2.15f))));
    public static final DeferredItem<MordorHelmet1> MORDOR_HELMET_1 = ITEMS.register("mordor_helmet_1",
            () -> new MordorHelmet1(ArmorMaterials.IRON, ArmorItem.Type.HELMET, new Item.Properties()));
public static final DeferredItem<MordorHelmet1> MORDOR_CHESTPLATE_1 = ITEMS.register("mordor_chestplate_1",
            () -> new MordorHelmet1(ArmorMaterials.IRON, ArmorItem.Type.CHESTPLATE, new Item.Properties()));

    public static final DeferredItem<SwordItem> MORDOR_HALBERD = ITEMS.register("mordor_halberd",
            () -> new SwordItem(Tiers.IRON, new Item.Properties().attributes(SwordItem.createAttributes(Tiers.IRON, 7, -3.45f))));
    public static final DeferredItem<SwordItem> MORDOR_GLAIVE = ITEMS.register("mordor_glaive",
            () -> new SwordItem(Tiers.IRON, new Item.Properties().attributes(SwordItem.createAttributes(Tiers.IRON, 8, -3.95f))));
    public static final DeferredItem<SwordItem> GONDOR_SPEAR = ITEMS.register("gondor_spear",
            () -> new SwordItem(Tiers.IRON, new Item.Properties().attributes(SwordItem.createAttributes(Tiers.IRON, 8, -3.95f))));
    public static final DeferredItem<GondorShield> GONDOR_SHIELD = ITEMS.register("gondor_shield",
            () -> new GondorShield(8, new Item.Properties()));

    public static final DeferredItem<GondorShield> MORDOR_SHIELD_1 = ITEMS.register("mordor_shield_1",
            () -> new GondorShield(8, new Item.Properties()));

    public static final DeferredItem<BannerPatternItem> EYE_OF_SAURON_PATTERN_ITEM = ITEMS.register("eye_of_sauron_pattern",
            () -> new BannerPatternItem(ModBannerPatterns.EYE_OF_SAURON, new Item.Properties()));


    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }

}
