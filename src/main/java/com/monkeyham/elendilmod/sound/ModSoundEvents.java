package com.monkeyham.elendilmod.sound;

import com.google.gson.JsonArray;
import com.monkeyham.elendilmod.ElendilMod;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModSoundEvents {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, ElendilMod.MODID);

    public static final Supplier<SoundEvent> ORC_SOUND_AMBIENT = registerSoundEvent("orc_sound_ambient");
    public static final Supplier<SoundEvent> ORC_SOUND_DEATH = registerSoundEvent("orc_sound_death");
    public static final Supplier<SoundEvent> ORC_SOUND_HURT = registerSoundEvent("orc_sound_hurt");
    public static final Supplier<SoundEvent> SHOOT_BOW = registerSoundEvent("shoot_bow");
    public static final Supplier<SoundEvent> GOOD_BOW_SHOOT = registerSoundEvent("good_bow_shoot");

    public static final Supplier<SoundEvent> GONDOR_SOUND_AMBIENT = registerSoundEvent("gondor_sound_ambient");
    public static final Supplier<SoundEvent> GONDOR_SOUND_ATTACK = registerSoundEvent("gondor_sound_attack");
    public static final Supplier<SoundEvent> GONDOR_SOUND_DEATH = registerSoundEvent("gondor_sound_death");
    public static final Supplier<SoundEvent> GONDOR_SOUND_HURT = registerSoundEvent("gondor_sound_hurt");
    public static final Supplier<SoundEvent> OLOG_HAI_AMBIENT = registerSoundEvent("olog_hai_sound_ambient");
    //public static final Supplier<SoundEvent> OLOG_HAI_HURT = registerSoundEvent("olog_hai_sound_ambient");
    public static final Supplier<SoundEvent> OLOG_HAI_DEATH = registerSoundEvent("olog_hai_sound_death");


    private static Supplier<SoundEvent> registerSoundEvent(String name)
    {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(ElendilMod.MODID, name);
        return SOUND_EVENTS.register(name, ()->SoundEvent.createVariableRangeEvent(id));
    }


    public static void register(IEventBus eventBus)
    {
        SOUND_EVENTS.register(eventBus);
    }

}
