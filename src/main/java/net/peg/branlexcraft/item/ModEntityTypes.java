package net.peg.branlexcraft.item;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.peg.branlexcraft.BranlexCraft;
import net.peg.branlexcraft.item.custom.BranlexProjectileEntity;

public class ModEntityTypes<T extends Entity> {
    public static final EntityType<BranlexProjectileEntity> BRANLEX_PROJECTILE = register(
            "branlex_projectile",
            EntityType.Builder
                .create(BranlexProjectileEntity::new, SpawnGroup.MISC)
                .setDimensions(0.25f, 0.25f)
    );

    private static <T extends Entity> EntityType<T> register(String id, EntityType.Builder<T> type) {
        return Registry.register(Registries.ENTITY_TYPE, id, type.build(id));
    }

}
