package com.jonb.gaiusmod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class fentTrapBlock extends Block {
    public fentTrapBlock(Properties pProperties) {
        super(pProperties);
    }


    private int entOnBlockCount = 30;

    @Override
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {
        if(pEntity instanceof LivingEntity livingEntity){
            livingEntity.addEffect(new MobEffectInstance(MobEffects.WITHER, 480, 0, true, true, true));
            livingEntity.addEffect(new MobEffectInstance(MobEffects.POISON, 360, 0, true, true, true));
            livingEntity.addEffect(new MobEffectInstance(MobEffects.HUNGER, 860, 4, true, true, true));
            livingEntity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 860, 0, true, true, true));
            livingEntity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 480, 1, true, true, true));
            livingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 200, 1, true, true, true));

            if (!pLevel.isClientSide()){
                entOnBlockCount++;
            }

            if (entOnBlockCount >= 30){
                pLevel.playSound(null,
                        pPos.getX(),
                        pPos.getY(),
                        pPos.getZ(),
                        SoundEvents.TOTEM_USE,
                        SoundSource.NEUTRAL,
                        1f,
                        1f);
                livingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 25, 9, true, true, true));
                livingEntity.igniteForTicks(100);
                entOnBlockCount = 0;
            }




        }

        super.stepOn(pLevel, pPos, pState, pEntity);
    }


}
