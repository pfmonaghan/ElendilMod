package com.monkeyham.elendilmod.entity.client;

import com.monkeyham.elendilmod.ElendilMod;
import com.monkeyham.elendilmod.entity.custom.OrcInfantryEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class OrcArmorModel <T extends OrcInfantryEntity> extends HumanoidModel<OrcInfantryEntity> {

    public static final ModelLayerLocation ORC_ARMOR_OUTER_LAYER_LOCATION = new
            ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(ElendilMod.MODID, "orc_armor_outer"), "orc_armor_outer");
    public static final ModelLayerLocation ORC_ARMOR_INNER_LAYER_LOCATION = new
            ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(ElendilMod.MODID, "orc_armor_inner"), "orc_armor_inner");

    public OrcArmorModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createOuterArmorLayer()
    {
        MeshDefinition meshDefinition = HumanoidModel.createMesh( new CubeDeformation(1.0F), 0.0F);
        PartDefinition partDefinition = meshDefinition.getRoot();
        partDefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -10.0F, -4.0F,
                8.0F, 8.0F, 8.0F, new CubeDeformation(1.0F)), PartPose.offset(0.0F, 1.0F, 0.0F));
        partDefinition.addOrReplaceChild(
                "hat",
                CubeListBuilder.create().texOffs(32, 0).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(1.5F)),
                PartPose.offset(0.0F, 1.0F, 0.0F));
        return LayerDefinition.create(meshDefinition, 64, 32);
    }

    public static LayerDefinition createInnerArmorLayer() {
        MeshDefinition meshdefinition = HumanoidModel.createMesh(new CubeDeformation(0.5F), 0.0F);
        return LayerDefinition.create(meshdefinition, 64, 32);
    }

}
