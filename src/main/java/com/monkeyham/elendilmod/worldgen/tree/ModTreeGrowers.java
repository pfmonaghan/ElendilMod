package com.monkeyham.elendilmod.worldgen.tree;

import com.monkeyham.elendilmod.ElendilMod;
import com.monkeyham.elendilmod.worldgen.ModConfiguredFeatures;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public class ModTreeGrowers {

    public static final TreeGrower ITHILIEN_TREE = new TreeGrower(ElendilMod.MODID + ":ithilien_tree",
            Optional.empty(), Optional.of(ModConfiguredFeatures.ITHILIEN_TREE_KEY), Optional.empty());

}
