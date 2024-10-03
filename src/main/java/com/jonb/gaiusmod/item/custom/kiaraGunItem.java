package com.jonb.gaiusmod.item.custom;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;


public class kiaraGunItem extends Item {
    public kiaraGunItem(Properties pProperties) {
        super(pProperties);
    }

    private int gunRandom = 0;

    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
        gunRandom = (int) (Math.random() * (7 - 1)) + 1;
        if (gunRandom == 6){
            player.playSound(SoundEvents.TOTEM_USE, 0.8f, 0.8f);
                entity.hurt(entity.damageSources().magic(), 2000f);

        } else if (gunRandom == 5) {
            entity.playSound(SoundEvents.TOTEM_USE, 1f, 0.8f);
            player.hurt(player.damageSources().magic(), 2000f);
        } else {
            player.playSound(SoundEvents.DISPENSER_FAIL, 1f, 1f);
        }

        stack.hurtAndBreak(1, player, EquipmentSlot.MAINHAND);
        return super.onLeftClickEntity(stack, player, entity);

    }

}
