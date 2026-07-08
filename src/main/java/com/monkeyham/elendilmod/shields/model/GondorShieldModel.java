/*package com.monkeyham.elendilmod.shields.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class GondorShieldModel extends ShieldBaseModel
{
//	public ModelRenderer plateLeft;
//  public ModelRenderer plateRight;
	
	protected static final String PART_PLATE_LEFT = "plate_left";
	protected static final String PART_PLATE_RIGHT = "plate_right";
	
	public ModelPart plateLeft;
	public ModelPart plateRight;
	private final ModelPart bb_main;

    public GondorShieldModel(ModelPart rootModel)
    {
    	super(rootModel);
		this.bb_main = root.getChild("bb_main");
///*		plateLeft = new ModelRenderer(this, 52, 0);
//		plateLeft.setRotationPoint(-6.0F, 0.0F, 0.0F);
//		setRotationAngle(plateLeft, 0.0F, 0.0F, -0.1963F);
//		plateLeft.addBox(-1.85f, -10.788f, -1.99f, 4, 20, 1, false);
//
//		plateRight = new ModelRenderer(this, 42, 0);
//		plateRight.setRotationPoint(6.0F, 0.0F, 0.0F);
//		setRotationAngle(plateRight, 0.0F, 0.0F, 0.1963F);
//		plateRight.addBox(-2.15f, -10.788f, -1.99f, 4, 20, 1, false);
    	
    	plateLeft = rootModel.getChild(PART_PLATE_LEFT);
    	plateRight = rootModel.getChild(PART_PLATE_RIGHT);
    }
    
    public static LayerDefinition createLayer()
    {
		MeshDefinition mesh = new MeshDefinition();
		PartDefinition part = mesh.getRoot();

//		part.addOrReplaceChild(PART_PLATE, CubeListBuilder.create().texOffs(0, 0).addBox(-6.0f, -11.0f, -2.0f, 12.0f, 22.0f, 1.0f), PartPose.ZERO);
//		part.addOrReplaceChild(PART_HANDLE, CubeListBuilder.create().texOffs(26, 0).addBox(-1.0f, -3.0f, -1.0f, 2.0f, 6.0f, 6.0f), PartPose.ZERO);
//		part.addOrReplaceChild(PART_PLATE_LEFT, CubeListBuilder.create().texOffs(52, 0).addBox(-1.85f, -10.788f, -1.99f, 4.0f, 20.0f, 1.0f), PartPose.offsetAndRotation(-6.0f, 0.0f, 0.0f, 0.0f, 0.0f, -0.1963f));
//		part.addOrReplaceChild(PART_PLATE_RIGHT, CubeListBuilder.create().texOffs(42, 0).addBox(-2.15f, -10.788f, -1.99f, 4.0f, 20.0f, 1.0f), PartPose.offsetAndRotation(6.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.1963f));

		PartDefinition bb_main = part.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -2.0F, 0.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-1.0F, -19.0F, -3.0F, 7.0F, 19.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-6.0F, -22.0F, -3.0F, 12.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-6.0F, -19.0F, -3.0F, 5.0F, 19.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(26, 0).addBox(-1.0F, -14.0F, -2.0F, 2.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(mesh, 64, 64);
    }

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
		bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);

		//super.renderToBuffer(poseStack, vertexConsumer, packedLight, packedOverlay, color);
	}

	@Override
    public void renderExtraParts(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color)
    {
    	super.renderExtraParts(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    	plateLeft.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    	plateRight.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }

/*    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder vertexBuilder, int packedLightIn, int packedOverlayIn,
    		float red, float green, float blue, float alpha)
    {
    	super.render(matrixStack, vertexBuilder, packedLightIn, packedOverlayIn, red, green, blue, alpha);
    	plateLeft.render(matrixStack, vertexBuilder, packedLightIn, packedOverlayIn);
    	plateRight.render(matrixStack, vertexBuilder, packedLightIn, packedOverlayIn);
    }
	
	protected void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) 
	{
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}*/
