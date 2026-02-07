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
                with(sound("elendilmod:mob/orc/orc_ambient_1"), sound("elendilmod:mob/orc/orc_ambient_2"),
                sound("elendilmod:mob/orc/orc_ambient_3"), sound("elendilmod:mob/orc/orc_ambient_4"),
                        sound("elendilmod:mob/orc/orc_ambient_5"), sound("elendilmod:mob/orc/orc_ambient_6"),
                        sound("elendilmod:mob/orc/orc_ambient_7"), sound("elendilmod:mob/orc/orc_ambient_8")));

        this.add(ModSoundEvents.ORC_SOUND_DEATH.get(), SoundDefinition.definition().
                with(sound("elendilmod:mob/orc/orc_death_1"),sound("elendilmod:mob/orc/orc_death_2"),
                        sound("elendilmod:mob/orc/orc_death_3"),sound("elendilmod:mob/orc/orc_death_4"),
                        sound("elendilmod:mob/orc/orc_death_5")))
        ;
        this.add(ModSoundEvents.ORC_SOUND_HURT.get(), SoundDefinition.definition().
                with(sound("elendilmod:mob/orc/orc_hurt_1"),sound("elendilmod:mob/orc/orc_hurt_2"),
                        sound("elendilmod:mob/orc/orc_hurt_3"),sound("elendilmod:mob/orc/orc_hurt_4"),
                        sound("elendilmod:mob/orc/orc_hurt_5")))
        ;

    }
}
