package com.monkeyham.elendilmod.worldgen.features;

import com.mojang.serialization.Codec;
import com.monkeyham.elendilmod.ElendilMod;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static com.monkeyham.elendilmod.sound.ModSoundEvents.SOUND_EVENTS;

public class ModdedFeatures  {

    public static final DeferredRegister<Feature<?>> MOD_FEATURES =
            DeferredRegister.create(BuiltInRegistries.FEATURE, ElendilMod.MODID);

    public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> ROCKY_TERRAIN_FEATURE =
            MOD_FEATURES.register("rocky_terrain_feature_1",
            ()-> new RockyTerrain(NoneFeatureConfiguration.CODEC));

    public static void register(IEventBus bus)
    {
        MOD_FEATURES.register(bus);
    }

//
//    private static Supplier<Feature<?>> register(String key, F value) {
//        return (F) MOD_FEATURES.register(key, ()->value).get();
//    }
}
