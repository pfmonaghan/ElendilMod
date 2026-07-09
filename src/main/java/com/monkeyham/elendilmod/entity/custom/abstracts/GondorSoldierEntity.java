package com.monkeyham.elendilmod.entity.custom.abstracts;

import com.monkeyham.elendilmod.entity.custom.OrcInfantryEntity;
import com.monkeyham.elendilmod.item.ModItems;
import com.monkeyham.elendilmod.sound.ModSoundEvents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
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
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.monster.Monster;
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

public class GondorSoldierEntity extends HumanAbstract{
    public GondorSoldierEntity(EntityType<? extends PathfinderMob> entityType, Level level) {
        super(entityType, level);
    }


    public static final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout=0;
    static final Predicate<Difficulty> DOOR_BREAKING_PREDICATE = (difficulty)->{return difficulty== Difficulty.NORMAL;};

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new FloatGoal(this));
        //this.goalSelector.addGoal(3, new Raider.HoldGroundAttackGoal(this, 10.0F));
        this.goalSelector.addGoal(2, new MoveTowardsTargetGoal(this, 0.9, 32.0F));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal(this, Mob.class, 5, false, false, (p_28879_) -> p_28879_ instanceof Enemy ));
        this.goalSelector.addGoal(4, new MeleeAttackGoal(this, (double)1.0F, true));
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this, new Class[]{IronGolem.class, HumanAbstract.class})).setAlertOthers(new Class[0]));
        this.goalSelector.addGoal(8, new RandomStrollGoal(this, 0.8));
        this.goalSelector.addGoal(9, new LookAtPlayerGoal(this, Player.class, 7.0F, 1.0F));
        this.goalSelector.addGoal(10, new LookAtPlayerGoal(this, Mob.class, 8.0F));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MOVEMENT_SPEED, 0.35F)
                .add(Attributes.FOLLOW_RANGE, 35.0F)
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
    public HumanArmPose getArmPose() {
        if(this.isAggressive())
        {
            return HumanAbstract.HumanArmPose.ATTACKING;
        }
        return super.getArmPose();
    }

    @Override
    protected void playAttackSound() {
        this.playSound(ModSoundEvents.ORC_SOUND_AMBIENT.get());
    }

    @Override
    protected void populateDefaultEquipmentSlots(RandomSource random, DifficultyInstance difficulty) {

        int mainItemInt = random.nextInt(100);
        if(mainItemInt<49){
            this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.IRON_SWORD));

        }else if(mainItemInt>49 && mainItemInt<74 ){
            this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ModItems.GONDOR_SPEAR.get()));

        }else {

            this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.IRON_AXE));
        }
        if(random.nextBoolean()){
            this.setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(ModItems.GONDOR_SHIELD.get()));
        }
        this.setItemSlot(EquipmentSlot.BODY, new ItemStack(Items.IRON_CHESTPLATE));
        this.handDropChances[EquipmentSlot.MAINHAND.getIndex()] = 5.0F;
        super.populateDefaultEquipmentSlots(random, difficulty);
    }

}
