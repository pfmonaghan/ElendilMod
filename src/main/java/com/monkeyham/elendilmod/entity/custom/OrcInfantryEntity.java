package com.monkeyham.elendilmod.entity.custom;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.AbstractIllager;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Vindicator;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.raid.Raider;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.storage.loot.LootParams;
import org.jetbrains.annotations.Nullable;

import java.util.function.Predicate;

public class OrcInfantryEntity extends AbstractIllager {


    public static final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout=0;
    static final Predicate<Difficulty> DOOR_BREAKING_PREDICATE = (difficulty)->{return difficulty== Difficulty.NORMAL;};

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new BreakDoorGoal(this, DOOR_BREAKING_PREDICATE));
        this.goalSelector.addGoal(2, new RaiderOpenDoorGoal(this));
        this.goalSelector.addGoal(3, new HoldGroundAttackGoal(this, 10.0F));
        this.goalSelector.addGoal(4, new MeleeAttackGoal(this, (double)1.0F, true));
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
                .add(Attributes.FOLLOW_RANGE, 24.0)
                .add(Attributes.MAX_HEALTH, 24.0)
                .add(Attributes.ATTACK_DAMAGE, 5.0);
    }

    private void setupAnimationStates() {
        if(this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = 20;
            this.idleAnimationState.start(this.tickCount);
        } else {
            --this.idleAnimationTimeout;
        }
    }

    public OrcInfantryEntity(EntityType<? extends OrcInfantryEntity> entityType, Level level) {
        super(entityType, level);

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
            return IllagerArmPose.ATTACKING;
        }
        return super.getArmPose();
    }



    @Override
    protected void populateDefaultEquipmentSlots(RandomSource random, DifficultyInstance difficulty) {
        this.setItemSlot(EquipmentSlot.BODY, new ItemStack(Items.IRON_CHESTPLATE));
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.IRON_AXE));
        this.handDropChances[EquipmentSlot.MAINHAND.getIndex()] = 25.0F;
        super.populateDefaultEquipmentSlots(random, difficulty);
    }


}
