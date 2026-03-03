package com.monkeyham.elendilmod.worldgen.structures;

import com.monkeyham.elendilmod.ElendilMod;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.structure.placement.StructurePlacementType;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModStructurePlacements {

    public static final DeferredRegister<StructurePlacementType<?>> STRUCTURE_PLACEMENT_TYPE_DEFERRED_REGISTER =
            DeferredRegister.create(BuiltInRegistries.STRUCTURE_PLACEMENT, ElendilMod.MODID);


}
