package net.peg.branlexcraft.item.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;

public class BranlexProjectileEntity extends PersistentProjectileEntity {

    public BranlexProjectileEntity(EntityType<? extends BranlexProjectileEntity> entityType, World world) {
        super((EntityType<? extends PersistentProjectileEntity>) entityType, world);
    }

    @Override
    protected ItemStack asItemStack() {
        return new ItemStack(Items.BONE_MEAL);
    }
}
