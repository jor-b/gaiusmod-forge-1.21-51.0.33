package com.jonb.gaiusmod.entity.custom;

import com.jonb.gaiusmod.effect.ModEffects;
import com.jonb.gaiusmod.entity.ModEntities;
import com.jonb.gaiusmod.item.ModItems;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;

public class lightningBallProjectile extends ThrowableItemProjectile {
    public lightningBallProjectile(EntityType<? extends ThrowableItemProjectile> pEntityType, Level pLevel) { super(pEntityType, pLevel); }

    public lightningBallProjectile(Level pLevel, LivingEntity pShooter) { super(ModEntities.FENTBAG_PROJECTILE.get(), pShooter, pLevel); };

    public lightningBallProjectile(Level pLevel, double pX, double pY, double pZ) { super(ModEntities.FENTBAG_PROJECTILE.get(), pX, pY, pZ, pLevel); }

    @Override
    protected Item getDefaultItem() {
        return ModItems.FENT_BAG.get();
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        super.onHitEntity(pResult);
        LivingEntity entity = (LivingEntity) pResult.getEntity();
        entity.addEffect(new MobEffectInstance(ModEffects.ELECTRIFIED_EFFECT.getHolder().get(), 200, 0));
        this.discard();

    }
}
