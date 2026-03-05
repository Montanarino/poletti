package com.poletti.gay;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.minecraft.commands.arguments.ResourceKeyArgument;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.CreativeModeTabs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Poletti implements ModInitializer {
	public static final String MOD_ID = "poletti";
	

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	//Entities
    public static final EntityType<IlMostro> POLETTI = Registry.register(
            BuiltInRegistries.ENTITY_TYPE,
            Identifier.fromNamespaceAndPath(Poletti.MOD_ID, "Poletti"),
            EntityType.Builder.of(IlMostro::new, MobCategory.CREATURE).build(ResourceKey.createRegistryKey(Identifier.fromNamespaceAndPath(MOD_ID, "poletti")))
    );

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		ModItems.initialize();

		// CREATIVE TABS
		ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.INGREDIENTS)
		.register((itemGroup) -> itemGroup.accept(ModItems.SUSPICIOUS_SUBSTANCE));
		ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES)
		.register((itemGroup) -> itemGroup.accept(ModItems.PISELLO_NERO));


		// COMPOSTING
		CompostingChanceRegistry.INSTANCE.add(ModItems.SUSPICIOUS_SUBSTANCE, 0.3f);


		// FUELING
		FuelRegistryEvents.BUILD.register((builder, context) -> {
			builder.add(ModItems.SUSPICIOUS_SUBSTANCE, 30 * 20);
		});

		// ENTITIES
		FabricDefaultAttributeRegistry.register(Poletti.POLETTI, IlMostro.createMobAttributes());

		LOGGER.info("Hello Fabric world!");
	}
}