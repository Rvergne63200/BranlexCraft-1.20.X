package net.peg.branlexcraft.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityStatuses;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;
import net.peg.branlexcraft.BranlexCraft;

public class BranlexProjectileEntity extends ThrownItemEntity {

    private float damage = 5.0f;
    private boolean canCramming = false;

    public BranlexProjectileEntity(EntityType<? extends BranlexProjectileEntity> entityType, World world) {
        super(entityType, world);
    }

    public BranlexProjectileEntity(World world, LivingEntity owner) {
        super(BranlexCraft.BRANLEX_PROJECTILE, owner, world);
    }

    public BranlexProjectileEntity(World world, double x, double y, double z) {
        super(BranlexCraft.BRANLEX_PROJECTILE, x, y, z, world);
    }

    public void setDamage(float damage)
    {
        this.damage = damage;
    }

    public void setCanCramming(boolean canCramming)
    {
        this.canCramming = canCramming;
        this.setOnFire(canCramming);
    }

    @Override
    protected Item getDefaultItem() {
        return Items.BONE_MEAL;
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        Entity entity = entityHitResult.getEntity();

        if(entity instanceof LivingEntity && !this.getWorld().isClient){
            if(this.canCramming)
            {
                entity.setOnFireFor(5);
            }

            entity.damage(this.getDamageSources().arrow(null, this.getOwner()), damage);
        }
    }

    @Override
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        if (!this.getWorld().isClient) {
            this.getWorld().sendEntityStatus(this, EntityStatuses.PLAY_DEATH_SOUND_OR_ADD_PROJECTILE_HIT_PARTICLES);
            this.discard();
        }
    }

    @Override
    public void handleStatus(byte status) {
        if (status == EntityStatuses.PLAY_DEATH_SOUND_OR_ADD_PROJECTILE_HIT_PARTICLES && getWorld().isClient) {
            ParticleEffect particleEffect = this.getParticleParameters();
            for (int i = 0; i < 8; ++i) {
                this.getWorld().addParticle(particleEffect, this.getX(), this.getY(), this.getZ(), 0.0, 0.0, 0.0);
            }
        }
    }

    private ParticleEffect getParticleParameters() {
        return ParticleTypes.FIREWORK;
    }

    public void tick() {
        super.tick();

        if(!getWorld().isClient)
        {
            setOnFire(canCramming);
        }

        if(getWorld().isClient){
            for (int i = 0; i < 4; i++){
                this.getWorld().addParticle(ParticleTypes.CLOUD, getX(), getY(), getZ(), this.random.nextDouble() / 10, this.random.nextDouble() / 10, this.random.nextDouble() / 10);
            }
        }
    }
}
