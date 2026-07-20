package com.monkeyham.elendilmod.entity.client.Mordor.HumanoidModel;

import com.mojang.blaze3d.vertex.PoseStack;
import com.monkeyham.elendilmod.ElendilMod;
import com.monkeyham.elendilmod.entity.custom.Mordor.OrcAbstract;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.resources.ResourceLocation;

public class OrcHumanoidRenderer<T extends OrcAbstract> extends HumanoidMobRenderer<T, OrcHumanoidModel<T>> {
    public OrcHumanoidRenderer(EntityRendererProvider.Context context) {
        super(context, new OrcHumanoidModel<>(context.bakeLayer(OrcHumanoidModel.LAYER_LOCATION)), .25f);
       /* this.addLayer(new HumanoidArmorLayer<>(this,
                new OrcArmorModel<>(context.bakeLayer(OrcArmorModel.ORC_ARMOR_OUTER_LAYER_LOCATION)),
                new OrcArmorModel<>(context.bakeLayer(OrcArmorModel.ORC_ARMOR_INNER_LAYER_LOCATION)),
                context.getModelManager()
        ));*/

        this.addLayer(new HumanoidArmorLayer<>(
                this,
                new OrcHumanoidModel(context.bakeLayer(OrcHumanoidModel.ORC_ARMOR_INNER_LAYER_LOCATION)),
                new OrcHumanoidModel(context.bakeLayer(OrcHumanoidModel.ORC_ARMOR_OUTER_LAYER_LOCATION)),
                context.getModelManager()));

    }



    @Override
    public ResourceLocation getTextureLocation(T orcEntity) {
        return ResourceLocation.fromNamespaceAndPath(ElendilMod.MODID, "textures/entity/orc_infantry/orc_humanoid_infantry.png");
    }



    @Override
    public void render(T entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight)
    {

        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
}
