package com.poletti.gay;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartNames;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class IlMostroModel extends EntityModel<IlMostroRenderState> {
 
    private final ModelPart base;
 
    public IlMostroModel(ModelPart modelPart) {
        super(modelPart);
        this.base = modelPart.getChild(PartNames.CUBE);
    }
 
    public static LayerDefinition getTexturedModelData() {
		MeshDefinition modelData = new MeshDefinition();
		PartDefinition modelPartData = modelData.getRoot();
		modelPartData.addOrReplaceChild(PartNames.CUBE, CubeListBuilder.create().texOffs(0, 0).addBox(-6F, 12F, -6F, 12F, 12F, 12F), PartPose.rotation(0F, 0F, 0F));
		return LayerDefinition.create(modelData, 64, 64);
	}


    public void setupAnim(IlMostroRenderState entity) {
    }
}