package com.monkeyham.elendilmod.entity.client.Mordor;

import com.mojang.blaze3d.vertex.PoseStack;
import com.monkeyham.elendilmod.ElendilMod;
import com.monkeyham.elendilmod.entity.custom.OrcAbstract;
import com.monkeyham.elendilmod.entity.custom.OrcInfantryEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;

public class OrcRenderer<T extends OrcAbstract> extends MobRenderer<T, OrcModel<T>> {
    public OrcRenderer(EntityRendererProvider.Context context) {
        super(context, new OrcModel<>(context.bakeLayer(OrcModel.LAYER_LOCATION)), .25f);
       /* this.addLayer(new HumanoidArmorLayer<>(this,
                new OrcArmorModel<>(context.bakeLayer(OrcArmorModel.ORC_ARMOR_OUTER_LAYER_LOCATION)),
                new OrcArmorModel<>(context.bakeLayer(OrcArmorModel.ORC_ARMOR_INNER_LAYER_LOCATION)),
                context.getModelManager()
        ));*/
        this.addLayer(
                new ItemInHandLayer<T, OrcModel<T>>(this, context.getItemInHandRenderer())
                {
                    @Override
                    public void render(PoseStack poseStack, MultiBufferSource buffer, int packedLight,
                                       T livingEntity, float limbSwing, float limbSwingAmount,
                                       float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {

                        super.render(poseStack, buffer, packedLight, livingEntity, limbSwing, limbSwingAmount, partialTicks, ageInTicks, netHeadYaw, headPitch);
                    }
                }
        );
        this.addLayer(new OrcArmorLayer<T, OrcModel<T>, OrcModel<T>>(
                this,
                new OrcModel<>(context.bakeLayer(OrcArmorModel.ORC_ARMOR_INNER_LAYER_LOCATION)),
                new OrcModel<>(context.bakeLayer(OrcArmorModel.ORC_ARMOR_OUTER_LAYER_LOCATION)),
                context.getModelManager()));


    }



    @Override
    public ResourceLocation getTextureLocation(T orcEntity) {
        return ResourceLocation.fromNamespaceAndPath(ElendilMod.MODID, "textures/entity/orc_infantry/orc_infantry.png");
    }



    @Override
    public void render(T entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight)
    {
//        if(entity.isWearingHelmet())
//            this.model.getHelmet().visible = true;


        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
}
