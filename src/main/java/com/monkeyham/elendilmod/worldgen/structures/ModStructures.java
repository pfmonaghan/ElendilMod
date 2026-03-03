package com.monkeyham.elendilmod.worldgen.structures;

import com.mojang.serialization.MapCodec;
import com.monkeyham.elendilmod.ElendilMod;
import com.monkeyham.elendilmod.worldgen.structures.structureTypes.OutpostStructure;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModStructures {

    public static final DeferredRegister<StructureType<?>> DEFERRED_REGISTER_STRUCTURE = DeferredRegister.create(BuiltInRegistries.STRUCTURE_TYPE, ElendilMod.MODID);

    public static final DeferredHolder<StructureType<?>, StructureType<OutpostStructure>> OUTPOST_STRUCTURE = DEFERRED_REGISTER_STRUCTURE.register("outpost_structures", ()->explicitStructureTypeTyping(OutpostStructure.CODEC));

    private static <T extends Structure> StructureType<T> explicitStructureTypeTyping(MapCodec<T> structureCodec)
    {
        return ()->structureCodec;
    }

}
