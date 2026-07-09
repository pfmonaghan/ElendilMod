package com.monkeyham.elendilmod.entity.goals;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.monster.AbstractIllager;
import net.minecraft.world.entity.raid.Raider;

import java.util.EnumSet;

public class HumanHoldGroundAttackGoal extends Goal{
    @Override
    public boolean canUse() {
        return false;
    }
//    private final Raider mob;
//    private final float hostileRadiusSqr;
//    public final TargetingConditions shoutTargeting = TargetingConditions.forNonCombat().range((double)8.0F).ignoreLineOfSight().ignoreInvisibilityTesting();
//
//    public HumanHoldGroundAttackGoal(AbstractIllager mob, float hostileRadiusSquare) {
//        this.mob = mob;
//        this.hostileRadiusSqr = hostileRadiusSquare * hostileRadiusSquare;
//        this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
//    }
//
//    public boolean canUse() {
//        LivingEntity livingentity = this.mob.getLastHurtByMob();
//        return this.mob.getCurrentRaid() == null && this.mob.isPatrolling() && this.mob.getTarget() != null && !this.mob.isAggressive() && (livingentity == null || livingentity.getType() != EntityType.PLAYER);
//    }
//
//    public void start() {
//        super.start();
//        this.mob.getNavigation().stop();
//
//        for(Raider raider : this.mob.level().getNearbyEntities(Raider.class, this.shoutTargeting, this.mob, this.mob.getBoundingBox().inflate((double)8.0F, (double)8.0F, (double)8.0F))) {
//            raider.setTarget(this.mob.getTarget());
//        }
//
//    }
//
//    public void stop() {
//        super.stop();
//        LivingEntity livingentity = this.mob.getTarget();
//        if (livingentity != null) {
//            for(Raider raider : this.mob.level().getNearbyEntities(Raider.class, this.shoutTargeting, this.mob, this.mob.getBoundingBox().inflate((double)8.0F, (double)8.0F, (double)8.0F))) {
//                raider.setTarget(livingentity);
//                raider.setAggressive(true);
//            }
//
//            this.mob.setAggressive(true);
//        }
//
//    }
//
//    public boolean requiresUpdateEveryTick() {
//        return true;
//    }
//
//    public void tick() {
//        LivingEntity livingentity = this.mob.getTarget();
//        if (livingentity != null) {
//            if (this.mob.distanceToSqr(livingentity) > (double)this.hostileRadiusSqr) {
//                this.mob.getLookControl().setLookAt(livingentity, 30.0F, 30.0F);
//                if (this.mob.random.nextInt(50) == 0) {
//                    this.mob.playAmbientSound();
//                }
//            } else {
//                this.mob.setAggressive(true);
//            }
//
//            super.tick();
//        }
//
//    }
}
