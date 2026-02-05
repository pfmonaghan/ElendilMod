package com.monkeyham.elendilmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.monkeyham.elendilmod.ElendilMod;
import com.monkeyham.elendilmod.entity.custom.OrcInfantryEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class OrcInfantryRenderer extends MobRenderer<OrcInfantryEntity, OrcInfantryModel<OrcInfantryEntity>> {

    public OrcInfantryRenderer(EntityRendererProvider.Context context) {
        super(context, new OrcInfantryModel<>(context.bakeLayer(OrcInfantryModel.LAYER_LOCATION)), .25f);
    }

    @Override
    public ResourceLocation getTextureLocation(OrcInfantryEntity orcInfantryEntity) {
        return ResourceLocation.fromNamespaceAndPath(ElendilMod.MODID, "textures/entity/orc_infantry/orc_infantry.png");
    }



    @Override
    public void render(OrcInfantryEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight)
    {
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
}
