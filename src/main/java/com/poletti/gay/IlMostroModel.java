public class IlMostroModel extends EntityModel<IlMostroRenderState> {
 
    private final ModelPart base;
 
    public CubeEntityModel(ModelPart modelPart) {
        this.base = modelPart.getChild(PartNames.CUBE);
    }
 
    	public static LayerDefinition getTexturedModelData() {
		MeshDefinition modelData = new MeshDefinition();
		PartDefinition modelPartData = modelData.getRoot();
		modelPartData.addOrReplaceChild(PartNames.CUBE, CubeListBuilder.create().texOffs(0, 0).addBox(-6F, 12F, -6F, 12F, 12F, 12F), PartPose.rotation(0F, 0F, 0F));
		return LayerDefinition.create(modelData, 64, 64);
	}


        public void setupAnim(CubeEntityRenderState entity) {
    }
}