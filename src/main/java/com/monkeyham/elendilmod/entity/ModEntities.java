package com.monkeyham.elendilmod.entity;

import com.monkeyham.elendilmod.ElendilMod;
import com.monkeyham.elendilmod.entity.custom.GeckoEntity;
import com.monkeyham.elendilmod.entity.custom.OrcInfantryEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, ElendilMod.MODID);

    public static final Supplier<EntityType<GeckoEntity>> GECKO =
            ENTITY_TYPES.register("gecko", ()->EntityType.Builder
                    .of(GeckoEntity::new, MobCategory.MISC).sized(.75f, .35f)
                    .build("gecko"));
    public static final Supplier<EntityType<OrcInfantryEntity>> ORC_INFANTRY =
            ENTITY_TYPES.register("orc_infantry", ()->EntityType.Builder
                    .of(OrcInfantryEntity::new, MobCategory.MONSTER).sized(.75f, .90f)
                    .build("orc_infantry"));

    public static void register(IEventBus eventBus)
    {
        ENTITY_TYPES.register(eventBus);
    }

}
