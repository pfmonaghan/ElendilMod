package com.monkeyham.elendilmod.entity.client.Gondor;

import com.mojang.blaze3d.vertex.PoseStack;
import com.monkeyham.elendilmod.ElendilMod;
import com.monkeyham.elendilmod.entity.custom.abstracts.GondorInfantryEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class GondorInfantryRenderer extends HumanRenderer<GondorInfantryEntity, GondorModel<GondorInfantryEntity>> {

    public GondorInfantryRenderer(EntityRendererProvider.Context context) {
        super(context, new GondorModel<>(context.bakeLayer(GondorModel.LAYER_LOCATION)), .25f);

    }

    @Override
    public ResourceLocation getTextureLocation(GondorInfantryEntity gondorSoldierAbstract) {
        return ResourceLocation.fromNamespaceAndPath(ElendilMod.MODID, "textures/entity/gondor/gondor_infantry.png");
    }


    @Override
    public void render(GondorInfantryEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight)
    {
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
}