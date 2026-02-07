package com.monkeyham.elendilmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.monkeyham.elendilmod.ElendilMod;
import com.monkeyham.elendilmod.entity.custom.OrcArcherEntity;
import com.monkeyham.elendilmod.entity.custom.OrcInfantryEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;

public class OrcArcherRenderer extends MobRenderer<OrcArcherEntity, OrcArcherModel<OrcArcherEntity>> {

    public OrcArcherRenderer(EntityRendererProvider.Context context) {
        super(context, new OrcArcherModel<OrcArcherEntity>(context.bakeLayer(OrcInfantryModel.LAYER_LOCATION)), .25f);
        this.addLayer(
                new ItemInHandLayer<OrcArcherEntity, OrcArcherModel<OrcArcherEntity> >(this, context.getItemInHandRenderer())
                {
                    @Override
                    public void render(PoseStack poseStack, MultiBufferSource buffer, int packedLight,
                                       OrcArcherEntity livingEntity, float limbSwing, float limbSwingAmount,
                                       float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {

                        super.render(poseStack, buffer, packedLight, livingEntity, limbSwing, limbSwingAmount, partialTicks, ageInTicks, netHeadYaw, headPitch);
                    }
                }
        );


    }

    @Override
    public ResourceLocation getTextureLocation(OrcArcherEntity orcInfantryEntity) {
        return ResourceLocation.fromNamespaceAndPath(ElendilMod.MODID, "textures/entity/orc_infantry/orc_infantry.png");
    }



    @Override
    public void render(OrcArcherEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight)
    {
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
}
