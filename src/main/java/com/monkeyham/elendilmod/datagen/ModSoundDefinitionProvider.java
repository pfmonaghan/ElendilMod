package com.monkeyham.elendilmod.datagen;

import com.monkeyham.elendilmod.ElendilMod;
import com.monkeyham.elendilmod.sound.ModSoundEvents;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.common.data.SoundDefinition;
import net.neoforged.neoforge.common.data.SoundDefinitionsProvider;

public class ModSoundDefinitionProvider extends SoundDefinitionsProvider {
    protected ModSoundDefinitionProvider(PackOutput output, ExistingFileHelper helper) {
        super(output, ElendilMod.MODID, helper);
    }

    @Override
    public void registerSounds() {
        this.add(ModSoundEvents.ORC_SOUND_AMBIENT.get(), SoundDefinition.definition().
                with(sound("mob/orc/orc_ambient_1")).
                with(sound("mob/orc/orc_ambient_2")));
        this.add(ModSoundEvents.ORC_SOUND_DEATH.get(), SoundDefinition.definition().
                with(sound("mob/orc/orc_death_1")));
        this.add(ModSoundEvents.ORC_SOUND_HURT.get(), SoundDefinition.definition().
                with(sound("mob/orc/orc_hurt_1")));

    }
}
