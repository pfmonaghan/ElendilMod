package com.monkeyham.elendilmod.entity.client.Mordor;

import com.mojang.blaze3d.vertex.PoseStack;
import com.monkeyham.elendilmod.ElendilMod;
import com.monkeyham.elendilmod.entity.custom.OrcInfantryEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;

public class OrcInfantryRenderer extends OrcRenderer<OrcInfantryEntity> {

    public OrcInfantryRenderer(EntityRendererProvider.Context context) {
        super(context);

    }

    @Override
    public ResourceLocation getTextureLocation(OrcInfantryEntity orcInfantryEntity) {
        return ResourceLocation.fromNamespaceAndPath(ElendilMod.MODID, "textures/entity/orc_infantry/orc_infantry.png");
    }

    @Override
    public void render(OrcInfantryEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight)
    {
//        if(entity.isWearingHelmet())
//            this.model.getHelmet().visible = true;

        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
}
