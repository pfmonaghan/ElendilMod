package com.monkeyham.elendilmod.entity.client.Mordor;

import com.monkeyham.elendilmod.ElendilMod;
import com.monkeyham.elendilmod.entity.custom.Mordor.OrcInfantryEntity;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class OrcArmorModel <T extends OrcInfantryEntity> extends OrcModel<OrcInfantryEntity> {

    public static final ModelLayerLocation ORC_ARMOR_OUTER_LAYER_LOCATION = new
            ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(ElendilMod.MODID, "orc_armor_outer"), "orc_armor_outer");
    public static final ModelLayerLocation ORC_ARMOR_INNER_LAYER_LOCATION = new
            ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(ElendilMod.MODID, "orc_armor_inner"), "orc_armor_inner");

    public OrcArmorModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createOuterArmorLayer()
    {
        MeshDefinition meshDefinition = OrcModel.createMesh(new CubeDeformation(.2F), -1.0F);
                //HumanoidModel.createMesh( new CubeDeformation(1.0F), 0.0F);
        PartDefinition partDefinition = meshDefinition.getRoot();
        partDefinition.addOrReplaceChild(
                "hat",
                CubeListBuilder.create().texOffs(32, 0).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(1.5F)),
                PartPose.offset(0.0F, 1.0F, 0.0F));
        CubeDeformation cubeDeformation = new CubeDeformation(0.0F);
        partDefinition.addOrReplaceChild("body",
                CubeListBuilder.create()
                        .texOffs(16, 16)
                        .addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, cubeDeformation.extend(0.1F, 0.1F, 0.6F)),
                PartPose.ZERO);
        partDefinition.getChild("body").addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 34).addBox(-4.0F, -7.0F, -4.0F, 8.0F, 8.0F, 8.0F, cubeDeformation), PartPose.offset(-0.0833F, -6.1667F, 0.0F));
                PartDefinition arms = partDefinition.addOrReplaceChild("arms",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(0.0F, 3.0F, -1.0F, -0.75F, 0.0F, 0.0F));
        arms.addOrReplaceChild("right_shoulder",
                CubeListBuilder.create().texOffs(40, 16).addBox(-8.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, cubeDeformation),
                PartPose.ZERO);
        arms.addOrReplaceChild("left_shoulder",
                CubeListBuilder.create()
                        .texOffs(40, 16)
                        .mirror()
                        .addBox(4.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, cubeDeformation),
                PartPose.ZERO);
        //partDefinition.getChild("head").addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.ZERO);

        return LayerDefinition.create(meshDefinition, 64, 32);
    }

    public static LayerDefinition createInnerArmorLayer() {
        MeshDefinition meshDefinition = OrcModel.createMesh(new CubeDeformation(0.5F), 5.0F);
                //HumanoidModel.createMesh(new CubeDeformation(0.5F), 0.0F);
        PartDefinition partDefinition = meshDefinition.getRoot();
        partDefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F,new CubeDeformation(0.05F)), PartPose.offset(-1.9F, 12.0F, 0.0F)); //new CubeDeformation(0.0F).extend(-0.1F)
        partDefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offset(1.9F, 12.0F, 0.0F));

        return LayerDefinition.create(meshDefinition, 64, 32);
    }

}
