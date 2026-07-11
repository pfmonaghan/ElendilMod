package com.monkeyham.elendilmod.entity.client.Gondor;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.monkeyham.elendilmod.ElendilMod;
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
import net.minecraft.world.entity.monster.AbstractIllager;

public class GondorModel<T extends HumanAbstract> extends HierarchicalModel<T> implements ArmedModel {

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(ElendilMod.MODID, "gondor_soldier"), "main");

    private final ModelPart root;
    private final ModelPart body;
    private final ModelPart head;
    private final ModelPart left_arm;
    private final ModelPart right_arm;
    private final ModelPart left_leg;
    private final ModelPart right_leg;

    public GondorModel(ModelPart root) {
        this.root = root;
        this.body = root.getChild("body");
        this.head = this.body.getChild("head");
        this.left_arm = this.body.getChild("left_arm");
        this.right_arm = this.body.getChild("right_arm");
        this.left_leg = this.body.getChild("left_leg");
        this.right_leg = this.body.getChild("right_leg");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 16).addBox(-4.0F, -6.7196F, -2.8571F, 8.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 9.7196F, -0.1429F));

        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -6.3176F, -3.1429F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(44, 37).addBox(-4.0F, -2.3176F, -4.1429F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(46, 6).addBox(-4.0F, -6.3176F, -4.1429F, 8.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(46, 0).addBox(-4.0F, -6.3176F, 4.8571F, 8.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(28, 16).addBox(-4.0F, -7.3176F, -3.1429F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(30, 40).addBox(-2.0F, -8.3176F, -2.1429F, 4.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(0, 47).addBox(-1.0F, -10.3176F, -0.6429F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(10, 47).addBox(-1.0F, -3.3176F, -4.1429F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(10, 49).addBox(3.0F, -3.3176F, -4.1429F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(50, 48).addBox(-4.0F, -3.3176F, -4.1429F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -8.402F, -0.7143F));

        PartDefinition cube_r1 = head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(44, 31).addBox(-1.0F, -4.0F, -1.0F, 8.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, -2.3176F, 3.8571F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r2 = head.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(44, 25).addBox(-1.0F, -4.0F, -1.0F, 8.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -2.3176F, 3.8571F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r3 = head.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(50, 50).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.3176F, 0.8571F, 0.8029F, 0.0F, 0.0F));

        PartDefinition cube_r4 = head.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(40, 47).addBox(-4.0F, -3.0F, 2.0F, 2.0F, 1.0F, 3.0F, new CubeDeformation(-0.001F)), PartPose.offsetAndRotation(3.1F, -8.9176F, -2.6429F, 0.0F, 0.0F, -0.7505F));

        PartDefinition cube_r5 = head.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(46, 10).addBox(-4.0F, -3.0F, 1.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(-0.001F)), PartPose.offsetAndRotation(1.6F, -8.1176F, -2.1429F, 0.0F, 0.0F, -0.9425F));

        PartDefinition cube_r6 = head.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(16, 32).addBox(2.0F, -3.0F, 1.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(-0.001F)), PartPose.offsetAndRotation(-1.6F, -8.1176F, -2.1429F, 0.0F, 0.0F, 0.9425F));

        PartDefinition cube_r7 = head.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(30, 47).addBox(2.0F, -3.0F, 2.0F, 2.0F, 1.0F, 3.0F, new CubeDeformation(-0.001F)), PartPose.offsetAndRotation(-3.1F, -8.9176F, -2.6429F, 0.0F, 0.0F, 0.7505F));

        PartDefinition cube_r8 = head.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(50, 45).addBox(1.0F, -2.0F, -2.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.001F)), PartPose.offsetAndRotation(-2.0F, -6.9176F, 2.2571F, -0.7156F, 0.0F, 0.0F));

        PartDefinition cube_r9 = head.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(50, 39).addBox(1.0F, -2.0F, -2.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.001F)), PartPose.offsetAndRotation(-2.5F, -5.5176F, 3.0571F, -1.0647F, 0.0F, 0.0F));

        PartDefinition cube_r10 = head.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(16, 37).addBox(1.0F, -2.0F, 0.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.001F)), PartPose.offsetAndRotation(-2.5F, -5.5176F, -1.3429F, 1.0647F, 0.0F, 0.0F));

        PartDefinition cube_r11 = head.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(50, 42).addBox(1.0F, -2.0F, 0.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.001F)), PartPose.offsetAndRotation(-2.0F, -6.9176F, -0.5429F, 0.7156F, 0.0F, 0.0F));

        PartDefinition left_arm = body.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(32, 0).addBox(-1.5F, -1.0F, -2.0F, 3.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(5.5F, -5.7196F, 0.1429F));

        PartDefinition right_arm = body.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(16, 40).addBox(-1.5F, -2.0F, -3.0F, 3.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.5F, -4.7196F, 1.1429F));

        PartDefinition left_leg = body.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(28, 25).addBox(-2.0F, 0.5F, -2.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 2.7804F, 0.1429F));

        PartDefinition right_leg = body.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 32).addBox(-2.0F, 0.5F, -2.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 2.7804F, 0.1429F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

//    @Override
//    public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, int color) {
//        body.render(poseStack, buffer, packedLight, packedOverlay, color);
//    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.head.yRot = netHeadYaw * (float) (Math.PI / 180.0);
        this.head.xRot = headPitch * (float) (Math.PI / 180.0);
        if (this.riding) {
            this.right_arm.xRot = (float) (-Math.PI / 5);
            this.right_arm.yRot = 0.0F;
            this.right_arm.zRot = 0.0F;
            this.left_arm.xRot = (float) (-Math.PI / 5);
            this.left_arm.yRot = 0.0F;
            this.left_arm.zRot = 0.0F;
            this.right_leg.xRot = -1.4137167F;
            this.right_leg.yRot = (float) (Math.PI / 10);
            this.right_leg.zRot = 0.07853982F;
            this.left_leg.xRot = -1.4137167F;
            this.left_leg.yRot = (float) (-Math.PI / 10);
            this.left_leg.zRot = -0.07853982F;
        } else {
            this.right_arm.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 2.0F * limbSwingAmount * 0.5F;
            this.right_arm.yRot = 0.0F;
            this.right_arm.zRot = 0.0F;
            this.left_arm.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
            this.left_arm.yRot = 0.0F;
            this.left_arm.zRot = 0.0F;
            this.right_leg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount * 0.5F;
            this.right_leg.yRot = 0.0F;
            this.right_leg.zRot = 0.0F;
            this.left_leg.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount * 0.5F;
            this.left_leg.yRot = 0.0F;
            this.left_leg.zRot = 0.0F;
        }

        HumanAbstract.HumanArmPose abstractillager$illagerarmpose = entity.getArmPose();
        if (abstractillager$illagerarmpose == HumanAbstract.HumanArmPose.ATTACKING) {
            if (entity.getMainHandItem().isEmpty()) {
                AnimationUtils.animateZombieArms(this.left_arm, this.right_arm, true, this.attackTime, ageInTicks);
            } else {
                AnimationUtils.swingWeaponDown(this.right_arm, this.left_arm, entity, this.attackTime, ageInTicks);
            }
        } else if (abstractillager$illagerarmpose == HumanAbstract.HumanArmPose.SPELLCASTING) {
            this.right_arm.z = 0.0F;
            this.right_arm.x = -5.0F;
            this.left_arm.z = 0.0F;
            this.left_arm.x = 5.0F;
            this.right_arm.xRot = Mth.cos(ageInTicks * 0.6662F) * 0.25F;
            this.left_arm.xRot = Mth.cos(ageInTicks * 0.6662F) * 0.25F;
            this.right_arm.zRot = (float) (Math.PI * 3.0 / 4.0);
            this.left_arm.zRot = (float) (-Math.PI * 3.0 / 4.0);
            this.right_arm.yRot = 0.0F;
            this.left_arm.yRot = 0.0F;
        } else if (abstractillager$illagerarmpose == HumanAbstract.HumanArmPose.BOW_AND_ARROW) {
            AnimationUtils.animateCrossbowHold(this.right_arm, this.left_arm, this.head, !entity.isLeftHanded());
        } else if (abstractillager$illagerarmpose == HumanAbstract.HumanArmPose.CROSSBOW_HOLD) {
            AnimationUtils.animateCrossbowHold(this.right_arm, this.left_arm, this.head, true);
        } else if (abstractillager$illagerarmpose == HumanAbstract.HumanArmPose.CROSSBOW_CHARGE) {
            AnimationUtils.animateCrossbowCharge(this.right_arm, this.left_arm, entity, true);
        } else if (abstractillager$illagerarmpose == HumanAbstract.HumanArmPose.CELEBRATING) {
            this.right_arm.z = 0.0F;
            this.right_arm.x = -5.0F;
            this.right_arm.xRot = Mth.cos(ageInTicks * 0.6662F) * 0.05F;
            this.right_arm.zRot = 2.670354F;
            this.right_arm.yRot = 0.0F;
            this.left_arm.z = 0.0F;
            this.left_arm.x = 5.0F;
            this.left_arm.xRot = Mth.cos(ageInTicks * 0.6662F) * 0.05F;
            this.left_arm.zRot = (float) (-Math.PI * 3.0 / 4.0);
            this.left_arm.yRot = 0.0F;
        }

    }

//    @Override
//    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
//        Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
//    }

    private ModelPart getArm(HumanoidArm arm)
    {
        return arm == HumanoidArm.LEFT ? this.left_arm : this.right_arm;
    }

    @Override
    public void translateToHand(HumanoidArm humanoidArm, PoseStack poseStack) {
//        float f = humanoidArm == HumanoidArm.RIGHT ? -.55F : .55F;
//
//        poseStack.translate(f,1.5,0);
        //this.getArm(humanoidArm).translateAndRotate(poseStack);

//        float f = humanoidArm == HumanoidArm.RIGHT ? 1.0F : -1.0F;
//        ModelPart modelpart = this.getArm(humanoidArm);
//        modelpart.x += f;
//        modelpart.translateAndRotate(poseStack);
//        modelpart.x -= f;
        float f = humanoidArm == HumanoidArm.RIGHT ? .1F : -.1F;
        poseStack.translate(f,.60,0);
        this.getArm(humanoidArm).translateAndRotate(poseStack);
    }

    @Override
    public ModelPart root() {
        return this.root;
    }

}
