package com.poletti.gay;

import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.Registry;
import java.util.function.Function;

public class ModItems {

    public static final Item SUSPICIOUS_SUBSTANCE = register("suspicious_substance", Item::new, new Item.Properties());

    

   public static final TagKey<Item> RIPARA = TagKey.create(BuiltInRegistries.ITEM.key(), Identifier.fromNamespaceAndPath(Poletti.MOD_ID, "ripara"));

    public static final ToolMaterial SUSPICIOUS = new ToolMaterial(
		BlockTags.INCORRECT_FOR_WOODEN_TOOL,
		455,
		0.1F,
		1.5F,
		22,
        RIPARA
);
    public static final Item PISELLO_NERO = register(
		"pisello_nero",
		Item::new,
		new Item.Properties().sword(SUSPICIOUS, 1f, 100f)
    );

    public static void initialize() {
    }

    public static <T extends Item> T register(String name, Function<Item.Properties, T> itemFactory, Item.Properties settings){
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Poletti.MOD_ID, name));

        T item = itemFactory.apply(settings.setId(itemKey));

        Registry.register(BuiltInRegistries.ITEM, itemKey, item);

        return item;
    }
}
