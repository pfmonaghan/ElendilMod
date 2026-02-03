package com.monkeyham.elendilmod.item;

import com.monkeyham.elendilmod.ElendilMod;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ElendilMod.MODID);


    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }

}
