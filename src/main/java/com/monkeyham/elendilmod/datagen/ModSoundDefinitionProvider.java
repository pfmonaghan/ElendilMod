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
        this.add(ModSoundEvents.SHOOT_BOW.get(), SoundDefinition.definition().with(
                sound("elendilmod:item/bow/bow_shoot_1"),
                sound("elendilmod:item/bow/bow_shoot_2"),
                sound("elendilmod:item/bow/bow_shoot_3"),
                sound("elendilmod:item/bow/bow_shoot_4")));
        this.add(ModSoundEvents.OLOG_HAI_AMBIENT.get(), SoundDefinition.definition().with(
                sound("elendilmod:mob/olog_hai/olog_hai_ambient_1"), sound("elendilmod:mob/olog_hai/olog_hai_ambient_2"),
                sound("elendilmod:mob/olog_hai/olog_hai_ambient_3"), sound("elendilmod:mob/olog_hai/olog_hai_ambient_4"),
                sound("elendilmod:mob/olog_hai/olog_hai_ambient_5"), sound("elendilmod:mob/olog_hai/olog_hai_ambient_6"),
                sound("elendilmod:mob/olog_hai/olog_hai_ambient_7"), sound("elendilmod:mob/olog_hai/olog_hai_ambient_8"),
                sound("elendilmod:mob/olog_hai/olog_hai_ambient_9"), sound("elendilmod:mob/olog_hai/olog_hai_ambient_10"),
                sound("elendilmod:mob/olog_hai/olog_hai_ambient_11"), sound("elendilmod:mob/olog_hai/olog_hai_ambient_12")
        ));

        this.add(ModSoundEvents.OLOG_HAI_DEATH.get(), SoundDefinition.definition().with(
                sound("elendilmod:mob/olog_hai/olog_hai_hurt_1"), sound("elendilmod:mob/olog_hai/olog_hai_hurt_2"),
                sound("elendilmod:mob/olog_hai/olog_hai_hurt_3"), sound("elendilmod:mob/olog_hai/olog_hai_hurt_4"),
                sound("elendilmod:mob/olog_hai/olog_hai_hurt_5")
        ));




        this.add(ModSoundEvents.GONDOR_SOUND_HURT.get(), SoundDefinition.definition().
                with(sound("elendilmod:mob/gondor/gondor_hurt_1"), sound("elendilmod:mob/gondor/gondor_hurt_2"),
                        sound("elendilmod:mob/gondor/gondor_hurt_3"), sound("elendilmod:mob/gondor/gondor_hurt_4"),
                        sound("elendilmod:mob/gondor/gondor_hurt_5"), sound("elendilmod:mob/gondor/gondor_hurt_6"),
                        sound("elendilmod:mob/gondor/gondor_hurt_7"), sound("elendilmod:mob/gondor/gondor_hurt_8")));
        this.add(ModSoundEvents.GONDOR_SOUND_DEATH.get(), SoundDefinition.definition().
                with(sound("elendilmod:mob/gondor/gondor_die_1"), sound("elendilmod:mob/gondor/gondor_die_2"),
                        sound("elendilmod:mob/gondor/gondor_die_3"), sound("elendilmod:mob/gondor/gondor_die_4"),
                        sound("elendilmod:mob/gondor/gondor_die_5"), sound("elendilmod:mob/gondor/gondor_die_6"),
                        sound("elendilmod:mob/gondor/gondor_die_7"), sound("elendilmod:mob/gondor/gondor_die_8"),
                        sound("elendilmod:mob/gondor/gondor_die_9"), sound("elendilmod:mob/gondor/gondor_die_10"),
                        sound("elendilmod:mob/gondor/gondor_die_10"), sound("elendilmod:mob/gondor/gondor_die_12")));
        this.add(ModSoundEvents.GONDOR_SOUND_AMBIENT.get(), SoundDefinition.definition().
                with(sound("elendilmod:mob/gondor/gondor_ambient_1"), sound("elendilmod:mob/gondor/gondor_ambient_2"),
                        sound("elendilmod:mob/gondor/gondor_ambient_3"), sound("elendilmod:mob/gondor/gondor_ambient_4"),
                        sound("elendilmod:mob/gondor/gondor_ambient_5"), sound("elendilmod:mob/gondor/gondor_ambient_6"),
                        sound("elendilmod:mob/gondor/gondor_ambient_7"), sound("elendilmod:mob/gondor/gondor_ambient_8"),
                        sound("elendilmod:mob/gondor/gondor_ambient_9"), sound("elendilmod:mob/gondor/gondor_ambient_10"),
                        sound("elendilmod:mob/gondor/gondor_ambient_10"), sound("elendilmod:mob/gondor/gondor_ambient_12")));

this.add(ModSoundEvents.GONDOR_SOUND_ATTACK.get(), SoundDefinition.definition().
                with(createDefinition("elendilmod:mob/gondor/gondor_attack_", 16)));
this.add(ModSoundEvents.GOOD_BOW_SHOOT.get(), SoundDefinition.definition().
                with(createDefinition("elendilmod:item/good_bow/good_bow_shoot_", 8)));


    }

    public static SoundDefinition.Sound[] createDefinition(String soundBasename, int max){

        SoundDefinition.Sound[] arr = new SoundDefinition.Sound[max];
        for (int i = 0; i < max; i++) {
            arr[i] = sound(soundBasename + (i+1));
        }

        return arr;
    }

}
