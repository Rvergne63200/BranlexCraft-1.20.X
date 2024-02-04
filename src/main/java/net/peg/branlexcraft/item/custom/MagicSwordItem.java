package net.peg.branlexcraft.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.peg.branlexcraft.BranlexCraft;

public class MagicSwordItem extends SwordItem {

    private final ItemStack itemStack;
    private final ItemStack ammunition;

    public MagicSwordItem(
            ToolMaterial toolMaterial,
            int attackDamage, float attackSpeed, Settings settings,
            ItemStack ammunition,
            ItemStack itemStack) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
        this.itemStack = itemStack;
        this.ammunition = ammunition;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack handItem = user.getStackInHand(hand);
        int slot = user.getInventory().getSlotWithStack(ammunition);

        if( slot >= 0 || user.getAbilities().creativeMode)
        {
            if(!user.getAbilities().creativeMode){
                user.getInventory().removeStack(slot, 1);
            }

            if(!world.isClient){
                BranlexProjectileEntity projectile = new BranlexProjectileEntity(world, user);
                projectile.setItem(itemStack);
                projectile.setVelocity(user.getRotationVector().multiply(3.0f));
                world.spawnEntity(projectile);
            }

            return TypedActionResult.consume(handItem);
        }

        return TypedActionResult.fail(handItem);
    }
}
