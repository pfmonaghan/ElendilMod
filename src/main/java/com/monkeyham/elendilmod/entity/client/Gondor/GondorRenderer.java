package com.monkeyham.elendilmod.entity.client.Gondor;

import com.mojang.blaze3d.vertex.PoseStack;
import com.monkeyham.elendilmod.ElendilMod;
import com.monkeyham.elendilmod.entity.client.OrcInfantryModel;
import com.monkeyham.elendilmod.entity.custom.GondorSoldierAbstract;
import com.monkeyham.elendilmod.entity.custom.OrcInfantryEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;

public class GondorRenderer extends MobRenderer<GondorSoldierAbstract, GondorModel<GondorSoldierAbstract>> {

    public GondorRenderer(EntityRendererProvider.Context context) {
        super(context, new GondorModel<>(context.bakeLayer(GondorModel.LAYER_LOCATION)), .25f);

        this.addLayer(
                new ItemInHandLayer<GondorSoldierAbstract, GondorModel<GondorSoldierAbstract> >(this, context.getItemInHandRenderer())
                {
                    @Override
                    public void render(PoseStack poseStack, MultiBufferSource buffer, int packedLight,
                                       GondorSoldierAbstract livingEntity, float limbSwing, float limbSwingAmount,
                                       float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {

                        super.render(poseStack, buffer, packedLight, livingEntity, limbSwing, limbSwingAmount, partialTicks, ageInTicks, netHeadYaw, headPitch);
                    }
                }
        );


    }

    @Override
    public ResourceLocation getTextureLocation(GondorSoldierAbstract gondorSoldierAbstract) {
        return ResourceLocation.fromNamespaceAndPath(ElendilMod.MODID, "textures/entity/gondor/gondor_infantry.png");
    }


    @Override
    public void render(GondorSoldierAbstract entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight)
    {
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
}