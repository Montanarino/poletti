public class IlMostroRenderer extends MobRenderer<IlMostro, IlMostroRenderState, IlMostroModel> {
 
    public IlMostroRenderer(EntityRendererProvider.Context context) {
        super(context, new IlMostroModel(context.bakeLayer(EntityTestingClient.MODEL_CUBE_LAYER)), 0.5f);
    }
 
    @Override
	public IlMostroRenderState createRenderState() {
		return new IlMostroRenderState();
	}
 
	@Override
	public Identifier getTextureLocation(IlMostroRenderState livingEntityRenderState) {
		return Identifier.fromNamespaceAndPath(MOD_ID, "textures/entity/poletti/poletti.png");
	}
}