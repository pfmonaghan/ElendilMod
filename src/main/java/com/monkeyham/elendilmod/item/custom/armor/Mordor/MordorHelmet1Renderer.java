package com.monkeyham.elendilmod.item.custom.armor.Mordor;

import com.monkeyham.elendilmod.ElendilMod;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class MordorHelmet1Renderer extends GeoArmorRenderer<MordorHelmet1> {
    public <I extends MordorHelmet1> MordorHelmet1Renderer() {
        super(new DefaultedItemGeoModel<>(ResourceLocation.fromNamespaceAndPath(ElendilMod.MODID, "mordor_helmet_1")));
    }
}
