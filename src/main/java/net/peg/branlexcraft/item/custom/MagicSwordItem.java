package net.peg.branlexcraft.item.custom;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.peg.branlexcraft.BranlexCraft;

public class MagicSwordItem extends SwordItem {

    private final ItemStack itemStack;
    private final ItemStack ammunition;

    private final float projectileDamages;

    public MagicSwordItem(
            ToolMaterial toolMaterial,
            int attackDamage, float attackSpeed, float projectileDamages, Settings settings,
            ItemStack ammunition,
            ItemStack itemStack) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
        this.itemStack = itemStack;
        this.ammunition = ammunition;
        this.projectileDamages = projectileDamages;
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
                // EnchantmentHelper.getLevel(Enchantments.FIRE_ASPECT, handItem) > 0
                BranlexProjectileEntity projectile = new BranlexProjectileEntity(world, user);
                projectile.setItem(itemStack);
                projectile.setDamage(projectileDamages);
                projectile.setCanCramming(true);
                projectile.setVelocity(user.getRotationVector().multiply(3.0f));
                world.spawnEntity(projectile);
            }

            world.playSound(user, user.getX(), user.getY(), user.getZ(), SoundEvents.BLOCK_AZALEA_HIT, SoundCategory.PLAYERS, 1f, 1f);

            return TypedActionResult.consume(handItem);
        }

        return TypedActionResult.fail(handItem);
    }
}
