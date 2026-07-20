package com.monkeyham.elendilmod.entity.client.Mordor;

import com.monkeyham.elendilmod.ElendilMod;
import com.monkeyham.elendilmod.entity.custom.Mordor.OlogHaiEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class OlogHaiRenderer extends GeoEntityRenderer<OlogHaiEntity> {
    public OlogHaiRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new DefaultedEntityGeoModel<>(ResourceLocation.fromNamespaceAndPath(ElendilMod.MODID, "olog_hai")));
    }



}
