package com.poletti.gay;

import net.fabricmc.api.ClientModInitializer;

public class PolettiClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		


		//ENTITIES
		EntityRenderers.register(Poletti.POLETTI, (context) -> {
            return new IlMostroRenderer(context);
        });
        EntityModelLayerRegistry.registerModelLayer(MODEL_CUBE_LAYER, IlMostroModel::getTexturedModelData);
	}
}