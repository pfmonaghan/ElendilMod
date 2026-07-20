package com.monkeyham.elendilmod.entity.custom.Gondor;

import com.monkeyham.elendilmod.entity.ModEntities;
import com.monkeyham.elendilmod.entity.goals.FollowPlayerGoal;
import com.monkeyham.elendilmod.sound.ModSoundEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ProjectileWeaponItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.neoforged.neoforge.common.CommonHooks;
import org.jetbrains.annotations.Nullable;

import java.util.function.Predicate;

public abstract class HumanAbstract extends PathfinderMob {
    protected HumanAbstract(EntityType<? extends PathfinderMob> entityType, Level level) {
        super(entityType, level);
    }

    public void aiStep() {
        this.updateSwingTime();
        this.updateNoActionTime();
        super.aiStep();
//        if (this.level() instanceof ServerLevel && this.isAlive()) {
//            LivingEntity livingentity = this.getTarget();
//            if (livingentity != null && (livingentity instanceof Enemy)) {
//                this.noActionTime = 0;
//            }
//        }
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

    @Override
    protected @Nullable SoundEvent getAmbientSound() {
        if(this.random.nextFloat() > .66)
        return ModSoundEvents.GONDOR_SOUND_AMBIENT.get();
        else return null;
    }

    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return ModSoundEvents.GONDOR_SOUND_HURT.get();
    }

    protected SoundEvent getDeathSound() {
        return ModSoundEvents.GONDOR_SOUND_DEATH.get();
    }

    @Override
    protected void playAttackSound() {
        this.playSound(ModSoundEvents.GONDOR_SOUND_ATTACK.get());
    }

    public LivingEntity.Fallsounds getFallSounds() {
        return new LivingEntity.Fallsounds(SoundEvents.HOSTILE_SMALL_FALL, SoundEvents.HOSTILE_BIG_FALL);
    }

    public float getWalkTargetValue(BlockPos pos, LevelReader level) {
        return 0;
    }

    protected void registerGoals() {
        super.registerGoals();

    }

    public HumanArmPose getArmPose() {
        return HumanArmPose.NEUTRAL;
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

    @Override
    public void checkDespawn() {
        super.checkDespawn();
    }

    @Override
    public float getVoicePitch() {
        return 1.0F;
    }

    public ItemStack getProjectile(ItemStack shootable) {
        if (shootable.getItem() instanceof ProjectileWeaponItem) {
            Predicate<ItemStack> predicate = ((ProjectileWeaponItem)shootable.getItem()).getSupportedHeldProjectiles(shootable);
            ItemStack itemstack = ProjectileWeaponItem.getHeldProjectile(this, predicate);
            return CommonHooks.getProjectile(this, shootable, itemstack.isEmpty() ? new ItemStack(Items.ARROW) : itemstack);
        } else {
            return CommonHooks.getProjectile(this, shootable, ItemStack.EMPTY);
        }
    }

    public boolean follow=false;

    @Override
    protected InteractionResult mobInteract(Player player, InteractionHand hand) {

        if(!this.level().isClientSide && hand == InteractionHand.MAIN_HAND) {
            follow = !follow;
            this.goalSelector.addGoal(1, new FollowPlayerGoal(this, player));
            player.displayClientMessage(Component.literal("Gondorian is " + (follow ? "following" : "not following")), false);
            return InteractionResult.SUCCESS_NO_ITEM_USED;
        }


        return InteractionResult.FAIL;
    }
}
