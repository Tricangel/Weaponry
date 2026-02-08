package bee.weaponry.entity;

import bee.weaponry.registry.ModItems;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;

public class AxeEntity extends AbstractArrow {
    private float rotation;
    public AxeEntity(EntityType<? extends AbstractArrow> entityType, Level level) {
        super(entityType, level);
    }

    public float getRenderingRotation() {
        rotation += 0.5f;
        if(rotation >= 360) {
            rotation = 0;
        }
        return rotation;
    }

    @Override
    protected ItemStack getDefaultPickupItem() {
        return new ItemStack(ModItems.WEAPONTEST);
    }

    @Override
    protected void onHitEntity(EntityHitResult entityHitResult) {
        Entity entity = entityHitResult.getEntity();
        if (!this.level().isClientSide()) {
            entity.hurtServer((ServerLevel) this.level(), this.damageSources().thrown(this, this.getOwner()), 10);
            LivingEntity livingEntity = level().getPlayerByUUID(owner.getUUID());
            entity.addDeltaMovement(livingEntity.getViewVector(1).scale(.5));
        }

        super.onHitEntity(entityHitResult);
    }
}
