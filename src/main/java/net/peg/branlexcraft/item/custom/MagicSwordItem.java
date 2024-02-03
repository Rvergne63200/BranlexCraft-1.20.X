package net.peg.branlexcraft.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.peg.branlexcraft.item.ModEntityTypes;

public class MagicSwordItem extends SwordItem {

    private final ItemStack itemStack;
    public MagicSwordItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings, ItemStack itemStack) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
        this.itemStack = itemStack;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {


        if (!world.isClient) {
            BranlexProjectileEntity projectile = new BranlexProjectileEntity(ModEntityTypes.BRANLEX_PROJECTILE, world);
            projectile.setOwner(user);
            projectile.setVelocity(user.getRotationVector().x, user.getRotationVector().y, user.getRotationVector().z);
            world.spawnEntity(projectile);
        }

        /*

        if (!world.isClient) {
            SnowballEntity snowballEntity = new SnowballEntity(world, user);
            snowballEntity.setItem(itemStack);
            snowballEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 1.5F, 1.0F);
            world.spawnEntity(snowballEntity);
        }
        */


        return TypedActionResult.success(user.getStackInHand(hand));
    }
}
