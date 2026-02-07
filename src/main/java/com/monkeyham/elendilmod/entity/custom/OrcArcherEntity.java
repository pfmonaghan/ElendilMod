package com.monkeyham.elendilmod.entity.custom;

import com.monkeyham.elendilmod.item.ModItems;
import com.monkeyham.elendilmod.sound.ModSoundEvents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.AbstractIllager;
import net.minecraft.world.entity.monster.CrossbowAttackMob;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.entity.raid.Raider;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.storage.loot.LootParams;
import org.jetbrains.annotations.Nullable;

import java.util.function.Predicate;

public class OrcArcherEntity extends AbstractIllager implements RangedAttackMob {

    public OrcArcherEntity(EntityType<? extends OrcArcherEntity> entityType, Level level) {
        super(entityType, level);

    }


    public static final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout=0;
    static final Predicate<Difficulty> DOOR_BREAKING_PREDICATE = (difficulty)->{return difficulty== Difficulty.NORMAL;};

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new BreakDoorGoal(this, DOOR_BREAKING_PREDICATE));
        this.goalSelector.addGoal(2, new RaiderOpenDoorGoal(this));
        this.goalSelector.addGoal(3, new HoldGroundAttackGoal(this, 80.0F));
        this.goalSelector.addGoal(4, new RangedBowAttackGoal(this, (double)1.0F, 20, 80.0F));
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this, new Class[]{Raider.class})).setAlertOthers(new Class[0]));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, AbstractVillager.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, IronGolem.class, true));
        this.goalSelector.addGoal(8, new RandomStrollGoal(this, 0.6));
        this.goalSelector.addGoal(9, new LookAtPlayerGoal(this, Player.class, 3.0F, 1.0F));
        this.goalSelector.addGoal(10, new LookAtPlayerGoal(this, Mob.class, 8.0F));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MOVEMENT_SPEED, 0.35F)
                .add(Attributes.FOLLOW_RANGE, 32.0)
                .add(Attributes.MAX_HEALTH, 24.0)
                .add(Attributes.ATTACK_DAMAGE, 5.0);
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



    private void setupAnimationStates() {
        if(this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = 20;
            this.idleAnimationState.start(this.tickCount);
        } else {
            --this.idleAnimationTimeout;
        }
    }




    @Override
    public @Nullable SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty,
                MobSpawnType spawnType, @Nullable SpawnGroupData spawnGroupData) {
        RandomSource randomSource = level.getRandom();

        this.populateDefaultEquipmentSlots(randomSource, difficulty);
        return super.finalizeSpawn(level, difficulty, spawnType, spawnGroupData);
    }

    @Override
    public void applyRaidBuffs(ServerLevel serverLevel, int i, boolean b) {
        ItemStack itemstack = new ItemStack(Items.IRON_AXE);
        this.setItemSlot(EquipmentSlot.MAINHAND, itemstack);
    }

    public void performRangedAttack(LivingEntity target, float distanceFactor) {
        ItemStack weapon = this.getItemInHand(ProjectileUtil.getWeaponHoldingHand(this, (item) -> item instanceof BowItem));
        ItemStack itemstack1 = this.getProjectile(weapon);
        AbstractArrow abstractarrow = this.getArrow(itemstack1, distanceFactor, weapon);
        Item var7 = weapon.getItem();
        if (var7 instanceof ProjectileWeaponItem weaponItem) {
            abstractarrow = weaponItem.customArrow(abstractarrow, itemstack1, weapon);
        }

        double d0 = target.getX() - this.getX();
        double d1 = target.getY(0.3333333333333333) - abstractarrow.getY();
        double d2 = target.getZ() - this.getZ();
        double d3 = Math.sqrt(d0 * d0 + d2 * d2);
        abstractarrow.shoot(d0, d1 + d3 * (double)0.2F, d2, 1.6F, (float)(14 - this.level().getDifficulty().getId() * 4));
        this.playSound(ModSoundEvents.SHOOT_BOW.get(), 1.0F, 1.0F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
        this.level().addFreshEntity(abstractarrow);
    }



    protected AbstractArrow getArrow(ItemStack arrow, float velocity, @javax.annotation.Nullable ItemStack weapon) {
        return ProjectileUtil.getMobArrow(this, arrow, velocity, weapon);
    }

    @Override
    public SoundEvent getCelebrateSound() {
        return null;
    }

    @Override
    public void tick() {
        super.tick();

        if(this.level().isClientSide())
        {
            this.setupAnimationStates();
        }
    }

    @Override
    public void equip(EquipmentTable equipmentTable, LootParams params) {
        super.equip(equipmentTable, params);
    }

    @Override
    public IllagerArmPose getArmPose() {
        if(this.isAggressive())
        {
            return IllagerArmPose.BOW_AND_ARROW;
        }
        return super.getArmPose();
    }



    @Override
    protected void populateDefaultEquipmentSlots(RandomSource random, DifficultyInstance difficulty) {
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.BOW));
        this.handDropChances[EquipmentSlot.MAINHAND.getIndex()] = 10.0F;
        super.populateDefaultEquipmentSlots(random, difficulty);
    }


    @Override
    public boolean canFireProjectileWeapon(ProjectileWeaponItem projectileWeapon) {
        return projectileWeapon == Items.BOW;
    }
}
