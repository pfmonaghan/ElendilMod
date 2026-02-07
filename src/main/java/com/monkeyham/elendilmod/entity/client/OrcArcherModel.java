package com.monkeyham.elendilmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.monkeyham.elendilmod.ElendilMod;
import com.monkeyham.elendilmod.entity.custom.OrcArcherEntity;
import net.minecraft.client.model.AnimationUtils;
import net.minecraft.client.model.ArmedModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.monster.AbstractIllager;

public class OrcArcherModel<T extends OrcArcherEntity> extends HierarchicalModel<T> implements ArmedModel {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new
            ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(ElendilMod.MODID, "orc_infantry"), "main");
    private final ModelPart Body;
    private final ModelPart Head;
    private final ModelPart ArmL;
    private final ModelPart ArmR;
    private final ModelPart LegL;
    private final ModelPart LegR;

    public OrcArcherModel(ModelPart root) {
        this.Body = root.getChild("Body");
        this.Head = this.Body.getChild("Head");
        this.ArmL = this.Body.getChild("ArmL");
        this.ArmR = this.Body.getChild("ArmR");
        this.LegL = this.Body.getChild("LegL");
        this.LegR = this.Body.getChild("LegR");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 16).addBox(-3.0F, -21.0F, -3.0F, 8.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition Head = Body.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -7.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, -22.0F, 0.0F));

        PartDefinition ArmL = Body.addOrReplaceChild("ArmL", CubeListBuilder.create().texOffs(28, 31).addBox(8.5F, -1.0F, -2.0F, 3.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.5F, -20.0F, 0.0F));

        PartDefinition ArmR = Body.addOrReplaceChild("ArmR", CubeListBuilder.create().texOffs(28, 31).mirror().addBox(-11.5F, -1.0F, -2.0F, 3.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(5.5F, -20.0F, 0.0F));

        PartDefinition LegL = Body.addOrReplaceChild("LegL", CubeListBuilder.create().texOffs(28, 16).addBox(2.0F, 0.0F, -1.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, -11.0F, -1.0F));

        PartDefinition LegR = Body.addOrReplaceChild("LegR", CubeListBuilder.create().texOffs(28, 16).mirror().addBox(-6.0F, 0.0F, -2.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(3.0F, -11.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    private ModelPart getArm(HumanoidArm arm)
    {
        return arm == HumanoidArm.LEFT ? this.ArmL : this.ArmR;
    }


    @Override
    public void setupAnim(OrcArcherEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(netHeadYaw, headPitch);

        //this.animateWalk(OrcInfantryAnimations.WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
        //this.animate(entity.idleAnimationState, OrcInfantryAnimations.WALK, ageInTicks, 1f);

        this.ArmR.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 2.0F * limbSwingAmount * 0.5F;
        this.ArmR.yRot = 0.0F;
        this.ArmR.zRot = 0.0F;
        this.ArmL.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
        this.ArmL.yRot = 0.0F;
        this.ArmL.zRot = 0.0F;
        this.LegR.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount * 0.5F;
        this.LegR.yRot = 0.0F;
        this.LegR.zRot = 0.0F;
        this.LegL.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount * 0.5F;
        this.LegL.yRot = 0.0F;
        this.LegL.zRot = 0.0F;

        final AbstractIllager.IllagerArmPose state = entity.getArmPose();
        if(state == AbstractIllager.IllagerArmPose.BOW_AND_ARROW)
        {

            AnimationUtils.animateCrossbowHold(this.ArmR, this.ArmL, this.Head, !entity.isLeftHanded());


        }
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
        Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }

    private void applyHeadRotation(float headYaw, float headPitch) {
        headYaw = Mth.clamp(headYaw, -30f, 30f);
        headPitch = Mth.clamp(headPitch, -25f, 45);

        this.Head.yRot = headYaw * ((float)Math.PI / 180f);
        this.Head.xRot = headPitch *  ((float)Math.PI / 180f);
    }

    @Override
    public ModelPart root() {
        return Body;
    }


    @Override
    public void translateToHand(HumanoidArm humanoidArm, PoseStack poseStack) {

        float f = humanoidArm == HumanoidArm.RIGHT ? -.55F : 0.0F;
        //ModelPart modelpart = this.getArm(humanoidArm);
        //  modelpart.x += f;
        // modelpart.translateAndRotate(poseStack);
        //modelpart.x -= f;

        poseStack.translate(f,1.5,0);
        this.getArm(humanoidArm).translateAndRotate(poseStack);

       // if(this.getArm(humanoidArm)==ArmR)
     //   {
        //    poseStack.translate(-.55,1.5,0);
       // }else{poseStack.translate(1.5,1.5,0);}
       // this.getArm(humanoidArm).translateAndRotate(poseStack);
    }

    //public static LayerDefinition createOuterArmorLayer()
    //{
       // MeshDefinition meshDefinition =
   // }

}