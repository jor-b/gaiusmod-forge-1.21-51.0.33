package com.jonb.gaiusmod.item.custom;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;



public class fentCartItem extends Item {
    public fentCartItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        pLevel.playSound(null,
                pPlayer.getX(),
                pPlayer.getY(),
                pPlayer.getZ(),
                SoundEvents.FOX_SNIFF,
                SoundSource.NEUTRAL,
                2.5f,
                0.5f);

        pPlayer.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 1250, 2, false, false, false));
        pPlayer.addEffect(new MobEffectInstance(MobEffects.POISON, 1250, 1, false, false, false));
        pPlayer.addEffect(new MobEffectInstance(MobEffects.WITHER, 1250, 1, false, false, false));
        pPlayer.addEffect(new MobEffectInstance(MobEffects.HUNGER, 1250, 3, false, false, false));
        pPlayer.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 800, 1, false, false, false));
        pPlayer.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 800, 1, false, false, false));
        pPlayer.addEffect(new MobEffectInstance(MobEffects.HEAL, 1, 2));

        if(!pLevel.isClientSide()){
            pPlayer.getItemInHand(pUsedHand).hurtAndBreak(1, ((ServerLevel) pLevel), ((ServerPlayer) pPlayer),
                    item -> pPlayer.onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

        }


        return super.use(pLevel, pPlayer, pUsedHand);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();


        if(!level.isClientSide()){
            pContext.getItemInHand().hurtAndBreak(1, ((ServerLevel) level), (ServerPlayer) pContext.getPlayer(),
                    item -> pContext.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

            level.playSound(null, pContext.getClickedPos(), SoundEvents.FOX_SNIFF, SoundSource.NEUTRAL, 1.5f, 0.8f);
        }
        return InteractionResult.SUCCESS;
    }



    @Override
    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.DRINK;
    }
}
