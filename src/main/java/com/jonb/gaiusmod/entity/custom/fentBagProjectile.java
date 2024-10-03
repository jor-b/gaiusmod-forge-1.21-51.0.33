package com.jonb.gaiusmod.entity.custom;

import com.jonb.gaiusmod.entity.ModEntities;
import com.jonb.gaiusmod.item.ModItems;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.effect.MobEffectInstance;

public class fentBagProjectile extends ThrowableItemProjectile {
    public fentBagProjectile(EntityType<? extends ThrowableItemProjectile> pEntityType, Level pLevel) { super(pEntityType, pLevel); }

    public fentBagProjectile(Level pLevel, LivingEntity pShooter) { super(ModEntities.FENTBAG_PROJECTILE.get(), pShooter, pLevel); };

    public fentBagProjectile(Level pLevel, double pX, double pY, double pZ) { super(ModEntities.FENTBAG_PROJECTILE.get(), pX, pY, pZ, pLevel); }

    @Override
    protected Item getDefaultItem() {
        return ModItems.FENT_BAG.get();
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        super.onHitEntity(pResult);
        LivingEntity entity = (LivingEntity) pResult.getEntity();
        entity.addEffect(new MobEffectInstance(MobEffects.WITHER, 480, 0, true, true, true));
        entity.addEffect(new MobEffectInstance(MobEffects.POISON, 360, 0, true, true, true));
        entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 660, 0, true, true, true));
        entity.addEffect(new MobEffectInstance(MobEffects.HUNGER, 860, 4, true, true, true));
        entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 480, 1, true, true, true));
        entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 860, 0, true, true, true));
        this.discard();

    }
}
