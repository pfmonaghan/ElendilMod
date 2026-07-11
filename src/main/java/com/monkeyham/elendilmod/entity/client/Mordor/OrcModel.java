package com.monkeyham.elendilmod.entity.client.Mordor;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.monkeyham.elendilmod.ElendilMod;
import com.monkeyham.elendilmod.entity.custom.OrcAbstract;
import com.monkeyham.elendilmod.entity.custom.abstracts.HumanAbstract;
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
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.monster.AbstractIllager;

public class OrcModel<T extends OrcAbstract> extends HierarchicalModel<T> implements ArmedModel {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new
            ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(ElendilMod.MODID, "orc_infantry"), "main");
    public final ModelPart Body;
    public final ModelPart Head;
    public final ModelPart ArmL;
    public final ModelPart ArmR;
    public final ModelPart LegL;
    public final ModelPart LegR;
    public final ModelPart helmet;
    public final ModelPart ShortHair;
    public final ModelPart LongHair;
    public final ModelPart root;

    public OrcModel(ModelPart root) {
        this.root = root;
        this.Body = root.getChild("Body");
        this.Head = this.Body.getChild("Head");
        this.ShortHair = this.Head.getChild("ShortHair");
        this.LongHair = this.Head.getChild("LongHair");
        this.helmet = this.Head.getChild("helmet");
        this.ArmL = this.Body.getChild("ArmL");
        this.ArmR = this.Body.getChild("ArmR");
        this.LegL = this.Body.getChild("LegL");
        this.LegR = this.Body.getChild("LegR");
        this.helmet.visible = false;
        this.ShortHair.visible = false;
        this.LongHair.visible = false;
    }

    public static MeshDefinition createMesh(CubeDeformation cubeDeformation, float yOffset){
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(34, 0).addBox(-4.0833F, -5.1667F, -3.0F, 8.0F, 10.0F, 6.0F, cubeDeformation), PartPose.offset(0.0833F, 8.1667F+ yOffset, 0.0F));

        PartDefinition Head = Body.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 34).addBox(-4.0F, -7.0F, -4.0F, 8.0F, 8.0F, 8.0F, cubeDeformation), PartPose.offset(-0.0833F, -6.1667F+ yOffset, 0.0F));

        PartDefinition ShortHair = Head.addOrReplaceChild("ShortHair", CubeListBuilder.create().texOffs(0, 18).addBox(-4.1F, -7.0F, -4.0F, 9.0F, 8.0F, 8.0F, cubeDeformation)
                .texOffs(32, 34).addBox(-3.0F, -7.1F, -3.0F, 7.0F, 1.0F, 6.0F, cubeDeformation), PartPose.offset(-0.4F, -0.5F+ yOffset, 0.6F));

        PartDefinition LongHair = Head.addOrReplaceChild("LongHair", CubeListBuilder.create().texOffs(0, 0).addBox(-4.1F, -7.0F, -4.0F, 9.0F, 10.0F, 8.0F, cubeDeformation)
                .texOffs(32, 34).addBox(-3.0F, -7.1F, -3.0F, 7.0F, 1.0F, 6.0F, cubeDeformation), PartPose.offset(-0.4F, -0.5F+ yOffset, 0.6F));

        PartDefinition helmet = Head.addOrReplaceChild("helmet", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F+ yOffset, 0.0F));

        PartDefinition cube_r1 = helmet.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(28, 52).addBox(3.0F, -2.0F, -1.0F, 1.0F, 1.0F, 1.0F, cubeDeformation)
                .texOffs(28, 50).addBox(10.0F, -2.0F, -1.0F, 1.0F, 1.0F, 1.0F, cubeDeformation)
                .texOffs(60, 31).addBox(6.0F, -2.0F, -1.0F, 2.0F, 1.0F, 1.0F, cubeDeformation), PartPose.offsetAndRotation(-7.0F, -2.0F, -3.5F, -0.0873F, 0.0F, 0.0F));

        PartDefinition cube_r2 = helmet.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(60, 31).addBox(-1.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, cubeDeformation), PartPose.offsetAndRotation(2.0F, -4.3379F+ yOffset, -4.0674F, -0.0869F, -0.0076F, -0.0869F));

        PartDefinition cube_r3 = helmet.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(60, 31).addBox(-1.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, cubeDeformation), PartPose.offsetAndRotation(-2.0F, -4.2379F+ yOffset, -4.0674F, -0.0869F, 0.0076F, 0.0869F));

        PartDefinition cube_r4 = helmet.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(46, 56).addBox(-1.0F, -4.0F, -1.0F, 8.0F, 5.0F, 1.0F, cubeDeformation), PartPose.offsetAndRotation(4.6F, -3.0F+ yOffset, 3.0F, -1.4835F, 1.5184F, -1.5708F));

        PartDefinition cube_r5 = helmet.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(28, 56).addBox(-1.0F, -4.0F, -1.0F, 8.0F, 5.0F, 1.0F, cubeDeformation), PartPose.offsetAndRotation(-3.5F, -3.0F+ yOffset, 3.0F, -1.6581F, 1.5184F, -1.5708F));

        PartDefinition cube_r6 = helmet.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(34, 16).addBox(-1.0F, -2.0F, -1.0F, 8.0F, 1.0F, 8.0F, cubeDeformation), PartPose.offsetAndRotation(-3.0F, -5.6F+ yOffset, -3.0F, -0.0524F, 0.0F, 0.0F));

        PartDefinition cube_r7 = helmet.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(58, 34).addBox(-1.0F, -4.0F, -1.0F, 8.0F, 5.0F, 1.0F, cubeDeformation), PartPose.offsetAndRotation(-3.0F, -3.0F+ yOffset, 4.6F, 0.0873F, 0.0F, 0.0F));

        PartDefinition cube_r8 = helmet.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(60, 25).addBox(-1.0F, -4.0F, -1.0F, 8.0F, 3.0F, 1.0F, cubeDeformation), PartPose.offsetAndRotation(-3.0F, -3.0F+ yOffset, -3.5F, -0.0873F, 0.0F, 0.0F));

        PartDefinition cube_r9 = helmet.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(60, 29).addBox(-1.0F, -2.0F, -1.0F, 8.0F, 1.0F, 1.0F, cubeDeformation), PartPose.offsetAndRotation(-3.0F, -1.0F+ yOffset, -3.5F, -0.0873F, 0.0F, 0.0F));

        PartDefinition ArmL = Body.addOrReplaceChild("ArmL", CubeListBuilder.create().texOffs(0, 50).addBox(-1.5F, -2.0F, -2.0F, 3.0F, 12.0F, 4.0F, cubeDeformation), PartPose.offset(5.4167F, -3.1667F+ yOffset, 0.0F));

        PartDefinition ArmR = Body.addOrReplaceChild("ArmR", CubeListBuilder.create().texOffs(14, 50).addBox(-2.0F, -2.0F, -2.0F, 3.0F, 12.0F, 4.0F, cubeDeformation), PartPose.offset(-5.0833F, -3.1667F+ yOffset, 0.0F));

        PartDefinition LegL = Body.addOrReplaceChild("LegL", CubeListBuilder.create().texOffs(32, 41).addBox(-2.0F, -1.5F, -2.0F, 4.0F, 11.0F, 4.0F, cubeDeformation), PartPose.offset(1.9167F, 6.3333F+ yOffset, 0.0F));

        PartDefinition LegR = Body.addOrReplaceChild("LegR", CubeListBuilder.create().texOffs(48, 41).addBox(-2.0F, -1.5F, -2.0F, 4.0F, 11.0F, 4.0F, cubeDeformation), PartPose.offset(-2.0833F, 6.3333F+ yOffset, 0.0F));

        return meshdefinition;
    }

    public static LayerDefinition createBodyLayer() {

        return LayerDefinition.create(createMesh(new CubeDeformation(0.0F), 0.0f), 128, 128);
    }


    private ModelPart getArm(HumanoidArm arm)
    {
        return arm == HumanoidArm.LEFT ? this.ArmL : this.ArmR;
    }


    @Override
    public void setupAnim(OrcAbstract entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.Head.yRot = netHeadYaw * (float) (Math.PI / 180.0);
        this.Head.xRot = headPitch * (float) (Math.PI / 180.0);
        if (this.riding) {
            this.ArmR.xRot = (float) (-Math.PI / 5);
            this.ArmR.yRot = 0.0F;
            this.ArmR.zRot = 0.0F;
            this.ArmL.xRot = (float) (-Math.PI / 5);
            this.ArmL.yRot = 0.0F;
            this.ArmL.zRot = 0.0F;
            this.LegR.xRot = -1.4137167F;
            this.LegR.yRot = (float) (Math.PI / 10);
            this.LegR.zRot = 0.07853982F;
            this.LegL.xRot = -1.4137167F;
            this.LegL.yRot = (float) (-Math.PI / 10);
            this.LegL.zRot = -0.07853982F;
        } else {
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
        }

        AbstractIllager.IllagerArmPose abstractillager$illagerarmpose = entity.getArmPose();
        if (abstractillager$illagerarmpose == AbstractIllager.IllagerArmPose.ATTACKING) {
            if (entity.getMainHandItem().isEmpty()) {
                AnimationUtils.animateZombieArms(this.ArmL, this.ArmR, true, this.attackTime, ageInTicks);
            } else {
                AnimationUtils.swingWeaponDown(this.ArmR, this.ArmL, entity, this.attackTime, ageInTicks);
            }
        } else if (abstractillager$illagerarmpose == AbstractIllager.IllagerArmPose.SPELLCASTING) {
            this.ArmR.z = 0.0F;
            this.ArmR.x = -5.0F;
            this.ArmL.z = 0.0F;
            this.ArmL.x = 5.0F;
            this.ArmR.xRot = Mth.cos(ageInTicks * 0.6662F) * 0.25F;
            this.ArmL.xRot = Mth.cos(ageInTicks * 0.6662F) * 0.25F;
            this.ArmR.zRot = (float) (Math.PI * 3.0 / 4.0);
            this.ArmL.zRot = (float) (-Math.PI * 3.0 / 4.0);
            this.ArmR.yRot = 0.0F;
            this.ArmL.yRot = 0.0F;
        } else if (abstractillager$illagerarmpose == AbstractIllager.IllagerArmPose.BOW_AND_ARROW) {
            AnimationUtils.animateCrossbowHold(this.ArmR, this.ArmL, this.Head, !entity.isLeftHanded());
        } else if (abstractillager$illagerarmpose == AbstractIllager.IllagerArmPose.CROSSBOW_HOLD) {
            AnimationUtils.animateCrossbowHold(this.ArmR, this.ArmL, this.Head, true);
        } else if (abstractillager$illagerarmpose == AbstractIllager.IllagerArmPose.CROSSBOW_CHARGE) {
            AnimationUtils.animateCrossbowCharge(this.ArmR, this.ArmL, entity, true);
        } else if (abstractillager$illagerarmpose == AbstractIllager.IllagerArmPose.CELEBRATING) {
            this.ArmR.z = 0.0F;
            this.ArmR.x = -5.0F;
            this.ArmR.xRot = Mth.cos(ageInTicks * 0.6662F) * 0.05F;
            this.ArmR.zRot = 2.670354F;
            this.ArmR.yRot = 0.0F;
            this.ArmL.z = 0.0F;
            this.ArmL.x = 5.0F;
            this.ArmL.xRot = Mth.cos(ageInTicks * 0.6662F) * 0.05F;
            this.ArmL.zRot = (float) (-Math.PI * 3.0 / 4.0);
            this.ArmL.yRot = 0.0F;

        }
        if(entity.isUsingItem())
        switch (entity.getHeadGear()){



            case HELMET -> {
                this.helmet.visible = true;
                this.ShortHair.visible = false;
                this.LongHair.visible = false;
            }
            case BALD -> {
                this.helmet.visible = false;
                this.ShortHair.visible = false;
                this.LongHair.visible = false;
            }
            case SHORT_HAIR -> {
                this.helmet.visible = false;
                this.ShortHair.visible = true;
                this.LongHair.visible = false;
            }
            case LONG_HAIR -> {
                this.helmet.visible = false;
                this.ShortHair.visible = false;
                this.LongHair.visible = true;
            }
        }
    }

//    @Override
//    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
//        Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
//    }

    private void applyHeadRotation(float headYaw, float headPitch) {
        headYaw = Mth.clamp(headYaw, -30f, 30f);
        headPitch = Mth.clamp(headPitch, -25f, 45);

        this.Head.yRot = headYaw * ((float)Math.PI / 180f);
        this.Head.xRot = headPitch *  ((float)Math.PI / 180f);
    }

    @Override
    public ModelPart root() {
        return root;
    }



    @Override
    public void translateToHand(HumanoidArm humanoidArm, PoseStack poseStack) {
//        float f = humanoidArm == HumanoidArm.RIGHT ? -.55F : .55F;
//        //ModelPart modelpart = this.getArm(humanoidArm);
//      //  modelpart.x += f;
//       // modelpart.translateAndRotate(poseStack);
//        //modelpart.x -= f;
//
//        poseStack.translate(f,1.5,0);
//        this.getArm(humanoidArm).translateAndRotate(poseStack);

        float f = humanoidArm == HumanoidArm.RIGHT ? .1F : -.1F;
        poseStack.translate(f,.60,0);
        this.getArm(humanoidArm).translateAndRotate(poseStack);

    }

    //public static LayerDefinition createOuterArmorLayer()
    {
       // MeshDefinition meshDefinition =
    }

    public ModelPart getHelmet() {
        return this.helmet;
    }

    public void setAllVisible(boolean visible) {
        this.Head.visible = visible;
        this.helmet.visible = visible;
        this.ShortHair.visible = visible;
        this.LongHair.visible = visible;
        this.Body.visible = visible;
        this.ArmR.visible = visible;
        this.ArmL.visible = visible;
        this.LegR.visible = visible;
        this.LegL.visible = visible;
    }

}