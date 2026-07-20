package com.monkeyham.elendilmod.entity.custom.Mordor;

import com.google.common.collect.ImmutableList;
import com.monkeyham.elendilmod.sound.ModSoundEvents;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.AbstractIllager;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.level.Level;

import java.util.Arrays;

public abstract class OrcAbstract extends AbstractIllager implements Enemy {

    private final HeadGear headGear;

    public OrcAbstract(EntityType<? extends OrcAbstract> entityType, Level level) {
        super(entityType, level);
        headGear = getRandomOrcHeadgear(level.getRandom());
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return ModSoundEvents.ORC_SOUND_AMBIENT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSoundEvents.ORC_SOUND_DEATH.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return ModSoundEvents.ORC_SOUND_HURT.get();
    }

    @Override
    protected void playAttackSound() {
        this.playSound(ModSoundEvents.ORC_SOUND_AMBIENT.get());
    }

    @Override
    public SoundEvent getCelebrateSound() {
        return null;
    }

//    public abstract boolean isWearingHelmet();

    @Override
    public void checkDespawn() {
        super.checkDespawn();
    }

    public enum HeadGear{
        HELMET,
        BALD,
        SHORT_HAIR,
        LONG_HAIR;
        public static ImmutableList<HeadGear> enums = Arrays.stream(HeadGear.values()).collect(ImmutableList.toImmutableList());
        public static final int enumsSize = enums.size();
    }

    public HeadGear getHeadGear() {
        return headGear;
    }

    protected HeadGear getRandomOrcHeadgear(RandomSource r){
        return HeadGear.enums.get(r.nextInt(HeadGear.enumsSize));
    }

}
