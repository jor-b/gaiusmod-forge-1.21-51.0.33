package com.jonb.gaiusmod.effect;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;

public class ElectrifiedEffect extends MobEffect {
    protected ElectrifiedEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }


    @Override
    public boolean applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        EntityType.LIGHTNING_BOLT.spawn((ServerLevel) , pLivingEntity.getOnPos(), MobSpawnType.TRIGGERED);

        return true;
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int pDuration, int pAmplifier) {
        int i = 40 >> pAmplifier;
        return i > 0 ? pDuration % i == 0 : true;
    }

}
