package com.monkeyham.elendilmod.entity.client.Mordor.HumanoidModel;

import com.monkeyham.elendilmod.ElendilMod;
import com.monkeyham.elendilmod.entity.custom.Mordor.OrcAbstract;
import net.minecraft.client.model.ArmedModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.resources.ResourceLocation;

public class OrcHumanoidModel<T extends OrcAbstract> extends HumanoidModel<T> implements ArmedModel {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new
            ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(ElendilMod.MODID, "orc_humanoid_infantry"), "main");
    public static final ModelLayerLocation ORC_ARMOR_OUTER_LAYER_LOCATION = new
            ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(ElendilMod.MODID, "orc_humanoid_armor_outer"), "orc_humanoid_armor_outer");
    public static final ModelLayerLocation ORC_ARMOR_INNER_LAYER_LOCATION = new
            ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(ElendilMod.MODID, "orc_humanoid_armor_inner"), "orc_humanoid_armor_inner");


//    public final ModelPart ShortHair;
//    public final ModelPart LongHair;
    public final ModelPart root;

    public OrcHumanoidModel(ModelPart root) {
        super(root);
        this.root = root;
//        this.ShortHair = this.root.getChild("ShortHair");
//        this.LongHair = this.root.getChild("LongHair");
//        this.ShortHair.visible = false;
//        this.LongHair.visible = false;
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        super.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
//        this.LongHair.visible = true;
    }






    //public static LayerDefinition createOuterArmorLayer()
    {
       // MeshDefinition meshDefinition =
    }

}