package net.peg.branlexcraft.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.peg.branlexcraft.BranlexCraft;

public class MagicSwordItem extends SwordItem {

    private final ItemStack itemStack;

    public MagicSwordItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings, ItemStack itemStack) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
        this.itemStack = itemStack;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        /*
        if (!world.isClient) {
            BranlexProjectileEntity projectile = new BranlexProjectileEntity(world, user);
            projectile.setDamage(10.0f);
            projectile.setItem(itemStack);
            projectile.setVelocity(user.getRotationVector().multiply(3.0f));
            world.spawnEntity(projectile);
        }
         */

        if(!world.isClient){
            BranlexProjectileEntity projectile = new BranlexProjectileEntity(user, world);
            projectile.setVelocity(user.getRotationVector().multiply(3.0f));
            world.spawnEntity(projectile);
        }

        return TypedActionResult.success(user.getStackInHand(hand));
    }
}
