package net.peg.branlexcraft;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.peg.branlexcraft.item.ModItemGroups;
import net.peg.branlexcraft.item.ModItems;
import net.peg.branlexcraft.item.custom.BranlexProjectileEntity;
import net.peg.branlexcraft.item.custom.BranlexProjectileEntityRenderer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BranlexCraft implements ModInitializer {
	public static final String MOD_ID = "branlexcraft";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


	public static final EntityType<BranlexProjectileEntity> BRANLEX_PROJECTILE = Registry.register(
			Registries.ENTITY_TYPE,
			new Identifier(MOD_ID, "branlex_projectile"),
			FabricEntityTypeBuilder.<BranlexProjectileEntity>create(SpawnGroup.MISC, BranlexProjectileEntity::new)
					.dimensions(EntityDimensions.fixed(1F, 1F)) // dimensions in Minecraft units of the projectile
					.trackRangeBlocks(4)
					.trackedUpdateRate(10) // necessary for all thrown projectiles (as it prevents it from breaking, lol)
					.build() // VERY IMPORTANT DONT DELETE FOR THE LOVE OF GOD
	);



	//public static final EntityType<BranlexProjectileEntity> BRANLEX_PROJECTILE = EntityType.Builder.create(BranlexProjectileEntity::new, SpawnGroup.MISC)
	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();

		EntityRendererRegistry.register(BRANLEX_PROJECTILE, BranlexProjectileEntityRenderer::new);
	}
}