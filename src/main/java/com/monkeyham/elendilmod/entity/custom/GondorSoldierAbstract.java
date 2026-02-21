package com.monkeyham.elendilmod.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.animal.AbstractGolem;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;

public class GondorSoldierAbstract extends AbstractGolem {
    protected GondorSoldierAbstract(EntityType<? extends AbstractGolem> entityType, Level level) {
        super(entityType, level);

    }

    @Nullable
    protected SoundEvent getAmbientSound() {
        return null;
    }

    @Nullable
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return null;
    }

    @Nullable
    protected SoundEvent getDeathSound() {
        return null;
    }

    public int getAmbientSoundInterval() {
        return 120;
    }

    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return false;
    }

    @Override
    public void restrictTo(BlockPos pos, int distance) {
        super.restrictTo(pos, distance);
    }
}
