package com.monkeyham.elendilmod.entity.client.Gondor;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.monkeyham.elendilmod.ElendilMod;
import com.monkeyham.elendilmod.entity.custom.GondorInfantry;
import com.monkeyham.elendilmod.entity.custom.GondorSoldierAbstract;
import com.monkeyham.elendilmod.entity.custom.OrcInfantryEntity;
import net.minecraft.client.model.ArmedModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.HumanoidArm;

public class GondorModel <T extends GondorSoldierAbstract> extends HierarchicalModel<T> implements ArmedModel {

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(ElendilMod.MODID, "gondor"), "main");
    private final ModelPart Body;
    private final ModelPart Head;
    private final ModelPart ArmL;
    private final ModelPart ArmR;
    private final ModelPart LegL;
    private final ModelPart LegR;

    public GondorModel(ModelPart root) {
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

        PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 16).addBox(-3.0F, -21.0F, -3.0F, 8.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 24.0F, 0.0F));

        PartDefinition Head = Body.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -7.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(44, 37).addBox(-4.0F, -3.0F, -5.0F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(46, 6).addBox(-4.0F, -7.0F, -5.0F, 8.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(46, 0).addBox(-4.0F, -7.0F, 4.0F, 8.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(28, 16).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(30, 40).addBox(-2.0F, -9.0F, -3.0F, 4.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(0, 47).addBox(-1.0F, -11.0F, -1.5F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(10, 47).addBox(-1.0F, -4.0F, -5.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(10, 49).addBox(3.0F, -4.0F, -5.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(50, 48).addBox(-4.0F, -4.0F, -5.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, -22.0F, 0.0F));

        PartDefinition cube_r1 = Head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(44, 31).addBox(-1.0F, -4.0F, -1.0F, 8.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, -3.0F, 3.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r2 = Head.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(44, 25).addBox(-1.0F, -4.0F, -1.0F, 8.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -3.0F, 3.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r3 = Head.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(50, 50).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -11.0F, 0.0F, 0.8029F, 0.0F, 0.0F));

        PartDefinition cube_r4 = Head.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(40, 47).addBox(-4.0F, -3.0F, 2.0F, 2.0F, 1.0F, 3.0F, new CubeDeformation(-0.001F)), PartPose.offsetAndRotation(3.1F, -9.6F, -3.5F, 0.0F, 0.0F, -0.7505F));

        PartDefinition cube_r5 = Head.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(46, 10).addBox(-4.0F, -3.0F, 1.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(-0.001F)), PartPose.offsetAndRotation(1.6F, -8.8F, -3.0F, 0.0F, 0.0F, -0.9425F));

        PartDefinition cube_r6 = Head.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(16, 32).addBox(2.0F, -3.0F, 1.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(-0.001F)), PartPose.offsetAndRotation(-1.6F, -8.8F, -3.0F, 0.0F, 0.0F, 0.9425F));

        PartDefinition cube_r7 = Head.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(30, 47).addBox(2.0F, -3.0F, 2.0F, 2.0F, 1.0F, 3.0F, new CubeDeformation(-0.001F)), PartPose.offsetAndRotation(-3.1F, -9.6F, -3.5F, 0.0F, 0.0F, 0.7505F));

        PartDefinition cube_r8 = Head.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(50, 45).addBox(1.0F, -2.0F, -2.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.001F)), PartPose.offsetAndRotation(-2.0F, -7.6F, 1.4F, -0.7156F, 0.0F, 0.0F));

        PartDefinition cube_r9 = Head.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(50, 39).addBox(1.0F, -2.0F, -2.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.001F)), PartPose.offsetAndRotation(-2.5F, -6.2F, 2.2F, -1.0647F, 0.0F, 0.0F));

        PartDefinition cube_r10 = Head.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(16, 37).addBox(1.0F, -2.0F, 0.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.001F)), PartPose.offsetAndRotation(-2.5F, -6.2F, -2.2F, 1.0647F, 0.0F, 0.0F));

        PartDefinition cube_r11 = Head.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(50, 42).addBox(1.0F, -2.0F, 0.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.001F)), PartPose.offsetAndRotation(-2.0F, -7.6F, -1.4F, 0.7156F, 0.0F, 0.0F));

        PartDefinition ArmL = Body.addOrReplaceChild("ArmL", CubeListBuilder.create().texOffs(32, 0).addBox(8.5F, -1.0F, -2.0F, 3.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.5F, -20.0F, 0.0F));

        PartDefinition ArmR = Body.addOrReplaceChild("ArmR", CubeListBuilder.create().texOffs(16, 40).addBox(-11.5F, -1.0F, -2.0F, 3.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(5.5F, -20.0F, 0.0F));

        PartDefinition LegL = Body.addOrReplaceChild("LegL", CubeListBuilder.create().texOffs(28, 25).addBox(2.0F, 0.0F, -1.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, -11.0F, -1.0F));

        PartDefinition LegR = Body.addOrReplaceChild("LegR", CubeListBuilder.create().texOffs(0, 32).addBox(-6.0F, 0.0F, -2.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, -11.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(GondorSoldierAbstract entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
        Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }

    private ModelPart getArm(HumanoidArm arm)
    {
        return arm == HumanoidArm.LEFT ? this.ArmL : this.ArmR;
    }

    @Override
    public void translateToHand(HumanoidArm humanoidArm, PoseStack poseStack) {
        float f = humanoidArm == HumanoidArm.RIGHT ? -.55F : .55F;

        poseStack.translate(f,1.5,0);
        this.getArm(humanoidArm).translateAndRotate(poseStack);
    }

    @Override
    public ModelPart root() {
        return Body;
    }

}
