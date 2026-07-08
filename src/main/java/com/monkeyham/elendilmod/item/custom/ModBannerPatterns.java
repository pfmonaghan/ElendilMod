package com.monkeyham.elendilmod.item.custom;

import com.monkeyham.elendilmod.ElendilMod;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BannerPatternTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.entity.BannerPattern;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBannerPatterns{
    public static final DeferredRegister<BannerPattern> BANNER_PATTERNS = DeferredRegister.create(Registries.BANNER_PATTERN, ElendilMod.MODID);

    public static final TagKey<BannerPattern> EYE_OF_SAURON = TagKey.create(BANNER_PATTERNS.getRegistryKey(),
            ResourceLocation.fromNamespaceAndPath(ElendilMod.MODID, "eye_of_sauron"));

    public static final DeferredHolder<BannerPattern, BannerPattern> EYE_OF_SAURON_PATTERN =
            BANNER_PATTERNS.register("eye_of_sauron_pattern", ()->new BannerPattern(
                    ResourceLocation.fromNamespaceAndPath(ElendilMod.MODID, "eye_of_sauron_pattern"),
                    "block.minecraft.banner.elendilmod.eye_of_sauron_pattern"
            ));

    public static void register(IEventBus bus)
    {
        BANNER_PATTERNS.register(bus);
    }

}
