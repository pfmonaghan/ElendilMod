package com.monkeyham.elendilmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.monkeyham.elendilmod.ElendilMod;
import com.monkeyham.elendilmod.entity.ModEntities;
import com.monkeyham.elendilmod.entity.custom.OrcInfantryEntity;
import net.minecraft.client.renderer.ItemInHandRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;

public class OrcInfantryRenderer extends MobRenderer<OrcInfantryEntity, OrcInfantryModel<OrcInfantryEntity>> {

    public OrcInfantryRenderer(EntityRendererProvider.Context context) {
        super(context, new OrcInfantryModel<>(context.bakeLayer(OrcInfantryModel.LAYER_LOCATION)), .25f);
       /* this.addLayer(new HumanoidArmorLayer<>(this,
                new OrcArmorModel<>(context.bakeLayer(OrcArmorModel.ORC_ARMOR_OUTER_LAYER_LOCATION)),
                new OrcArmorModel<>(context.bakeLayer(OrcArmorModel.ORC_ARMOR_INNER_LAYER_LOCATION)),
                context.getModelManager()
        ));*/
        this.addLayer(
                new ItemInHandLayer<OrcInfantryEntity, OrcInfantryModel<OrcInfantryEntity> >(this, context.getItemInHandRenderer())
                {
                    @Override
                    public void render(PoseStack poseStack, MultiBufferSource buffer, int packedLight,
                                       OrcInfantryEntity livingEntity, float limbSwing, float limbSwingAmount,
                                       float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {

                        super.render(poseStack, buffer, packedLight, livingEntity, limbSwing, limbSwingAmount, partialTicks, ageInTicks, netHeadYaw, headPitch);
                    }
                }
        );


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
