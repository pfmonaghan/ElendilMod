package com.monkeyham.elendilmod.entity.client.Gondor;

import com.mojang.blaze3d.vertex.PoseStack;
import com.monkeyham.elendilmod.entity.custom.Gondor.HumanAbstract;
import net.minecraft.client.model.ArmedModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;

public abstract class HumanRenderer<T extends HumanAbstract, M extends HierarchicalModel<T> & ArmedModel> extends MobRenderer<T, M> {

    public HumanRenderer(EntityRendererProvider.Context context, M model, float shadowRadius) {
        super(context, model, shadowRadius);

        this.addLayer(
                new ItemInHandLayer<T, M >(this, context.getItemInHandRenderer())
                {
                    @Override
                    public void render(PoseStack poseStack, MultiBufferSource buffer, int packedLight,
                                       T livingEntity, float limbSwing, float limbSwingAmount,
                                       float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {

                        super.render(poseStack, buffer, packedLight, livingEntity, limbSwing, limbSwingAmount, partialTicks, ageInTicks, netHeadYaw, headPitch);
                    }
                }
        );


    }
}