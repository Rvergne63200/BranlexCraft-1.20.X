package net.peg.branlexcraft;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.data.server.recipe.VanillaRecipeProvider;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.peg.branlexcraft.item.ModItemGroups;
import net.peg.branlexcraft.item.ModItems;
import net.peg.branlexcraft.item.custom.BranlexProjectileEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BranlexCraft implements ModInitializer {
	public static final String MOD_ID = "branlexcraft";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


	public static final EntityType<BranlexProjectileEntity> BRANLEX_PROJECTILE = Registry.register(
			Registries.ENTITY_TYPE,
			new Identifier(MOD_ID, "branlex_projectile"),
			FabricEntityTypeBuilder.<BranlexProjectileEntity>create(SpawnGroup.MISC, BranlexProjectileEntity::new)
					.dimensions(EntityDimensions.fixed(1F, 1F))
					.trackRangeBlocks(150)
					.trackedUpdateRate(150)
					.build()
	);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
	}
}