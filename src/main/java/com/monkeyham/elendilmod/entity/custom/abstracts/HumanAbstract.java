package com.monkeyham.elendilmod.entity.custom.abstracts;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;

public abstract class HumanAbstract extends PathfinderMob {
    protected HumanAbstract(EntityType<? extends PathfinderMob> entityType, Level level) {
        super(entityType, level);
    }

    public void aiStep() {
        this.updateSwingTime();
        this.updateNoActionTime();
        LivingEntity livingentity = this.getTarget();
        if (livingentity != null && (livingentity instanceof Enemy)) {
            this.noActionTime = 0;
        }
        super.aiStep();
    }

    protected void updateNoActionTime() {
        this.noActionTime += 2;
    }

    protected boolean shouldDespawnInPeaceful() {
        return false;
    }

    protected SoundEvent getSwimSound() {
        return SoundEvents.HOSTILE_SWIM;
    }

    protected SoundEvent getSwimSplashSound() {
        return SoundEvents.HOSTILE_SPLASH;
    }

    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return SoundEvents.HOSTILE_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.HOSTILE_DEATH;
    }

    public LivingEntity.Fallsounds getFallSounds() {
        return new LivingEntity.Fallsounds(SoundEvents.HOSTILE_SMALL_FALL, SoundEvents.HOSTILE_BIG_FALL);
    }

    public float getWalkTargetValue(BlockPos pos, LevelReader level) {
        return -level.getPathfindingCostFromLightLevels(pos);
    }

    protected void registerGoals() {
        super.registerGoals();
    }

    public HumanArmPose getArmPose() {
        return HumanArmPose.NEUTRAL;
    }

    public boolean canAttack(LivingEntity target) {
        return target instanceof Enemy;
    }

    public boolean isAlliedTo(Entity entity) {
            return entity instanceof Villager || entity instanceof Player;

    }

    public static enum HumanArmPose {
        CROSSED,
        ATTACKING,
        SPELLCASTING,
        BOW_AND_ARROW,
        CROSSBOW_HOLD,
        CROSSBOW_CHARGE,
        CELEBRATING,
        NEUTRAL;
    }



}
