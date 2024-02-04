package net.peg.branlexcraft.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.FlyingItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownEntity;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import net.peg.branlexcraft.BranlexCraft;

public class BranlexProjectileEntity extends ThrownEntity {
    private int lifeTime = 0;

    public BranlexProjectileEntity(EntityType<? extends BranlexProjectileEntity> entityType, World world) {
        super((EntityType<? extends ThrownEntity>) entityType, world);
        this.setBoundingBox(new Box(-0.5, 0.0, -0.5, 0.5, 1.0, 0.5));
    }

    protected BranlexProjectileEntity(double x, double y, double z, World world) {
        this(BranlexCraft.BRANLEX_PROJECTILE, world);
        this.setPosition(x, y, z);
    }

    protected BranlexProjectileEntity(LivingEntity owner, World world) {
        this(owner.getX(), owner.getEyeY() - (double)0.1f, owner.getZ(), world);
        this.setOwner(owner);
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        entityHitResult.getEntity().damage(this.getDamageSources().arrow(null, this), 5.0f);
        BranlexCraft.LOGGER.info("degats");
    }

    @Override
    protected void initDataTracker() {

    }

    public void tick() {
        super.tick();

        this.setPosition(getPos().add(getVelocity()));

//        if(lifeTime == 0)
//        {
//            this.getWorld().addParticle(ModParticles.BRANLEX_PARTICLE, getX(), getY(), getZ(), getVelocity().x, getVelocity().y, getVelocity().z);
//        }

        if(getWorld().isClient){
            for (int i = 0; i < 5; i++){
                //this.getWorld().addParticle(ParticleTypes.CLOUD, getX(), getY(), getZ(), this.random.nextDouble() / 10, this.random.nextDouble() / 10, this.random.nextDouble() / 10);
            }
        }

        if(lifeTime > 300)
        {
            this.remove(RemovalReason.DISCARDED);
        }

        lifeTime++;
    }
}
