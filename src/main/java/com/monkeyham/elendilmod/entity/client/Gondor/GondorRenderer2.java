package com.monkeyham.elendilmod.entity.client.Gondor;

import com.mojang.blaze3d.vertex.PoseStack;
import com.monkeyham.elendilmod.ElendilMod;
import com.monkeyham.elendilmod.entity.custom.abstracts.GondorSoldierEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;

public class GondorRenderer2 extends MobRenderer<GondorSoldierEntity, GondorModel2<GondorSoldierEntity>> {

    public GondorRenderer2(EntityRendererProvider.Context context) {
        super(context, new GondorModel2<>(context.bakeLayer(GondorModel2.LAYER_LOCATION)), .25f);

        this.addLayer(
                new ItemInHandLayer<GondorSoldierEntity, GondorModel2<GondorSoldierEntity> >(this, context.getItemInHandRenderer())
                {
                    @Override
                    public void render(PoseStack poseStack, MultiBufferSource buffer, int packedLight,
                                       GondorSoldierEntity livingEntity, float limbSwing, float limbSwingAmount,
                                       float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {

                        super.render(poseStack, buffer, packedLight, livingEntity, limbSwing, limbSwingAmount, partialTicks, ageInTicks, netHeadYaw, headPitch);
                    }
                }
        );


    }

    @Override
    public ResourceLocation getTextureLocation(GondorSoldierEntity gondorSoldierAbstract) {
        return ResourceLocation.fromNamespaceAndPath(ElendilMod.MODID, "textures/entity/gondor/gondor_infantry.png");
    }


    @Override
    public void render(GondorSoldierEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight)
    {
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
}