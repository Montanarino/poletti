package com.poletti.gay;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.resources.Identifier;

public class PolettiClient implements ClientModInitializer {

	public static final ModelLayerLocation MODEL_CUBE_LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("poletti", "poletti"), "main");
	@Override
	public void onInitializeClient() {
		


		//ENTITIES
		EntityRenderers.register(Poletti.POLETTI, (context) -> {
            return new IlMostroRenderer(context);
        });
        EntityModelLayerRegistry.registerModelLayer(MODEL_CUBE_LAYER, IlMostroModel::getTexturedModelData);
	}
}