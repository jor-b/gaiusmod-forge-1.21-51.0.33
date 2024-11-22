package com.jonb.gaiusmod.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;

public class CreamyEffect extends MobEffect {
    protected CreamyEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }


    @Override
    public boolean applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        if(pLivingEntity.verticalCollisionBelow) {
            Vec3 initialVec = pLivingEntity.getDeltaMovement();
            // Vec3 pushVec = new Vec3(Math.random() * 0.1 - 0.039, initialVec.y, Math.random() * 0.1 - 0.039);
            Vec3 pushVec = new Vec3(-0.2 + Math.random() * (0.4), initialVec.y, -0.2 + Math.random() * (0.4));
            pLivingEntity.setDeltaMovement(pushVec);
            return true;
        }

        return super.applyEffectTick(pLivingEntity, pAmplifier);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int pDuration, int pAmplifier) {
        return true;
    }

}
