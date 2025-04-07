package com.jonb.gaiusmod.item.custom;

import com.jonb.gaiusmod.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class hammerCleanItem extends Item {
    private static final int DEFAULT_ATTACK_DAMAGE =  5;
    private static final float DEFAULT_ATTACK_SPEED =  -2.9f;
    public hammerCleanItem(Properties pProperties) {
        super(pProperties);
    }

public static ItemAttributeModifiers createAttributes() {
        return ItemAttributeModifiers.builder()
                .add(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_ID, 4, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
                .add(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_ID, -3.2f, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
                .build();
    };


    @Override
    public boolean canAttackBlock(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer) {
        return !pPlayer.isCreative();
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        pTarget.hurt(pTarget.damageSources().magic(), 8.0f);
        pTarget.addEffect(new MobEffectInstance(MobEffects.GLOWING, 220, 0, true, true, true));
        pTarget.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 220, 1, true, true, true));
        pTarget.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 290, 0, true, true, true));
        pTarget.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 500, 2, true, true, true));
        pTarget.igniteForTicks(220);
        pAttacker.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 40, 0, true, true, true));
        return true;
    }

    @Override
    public void postHurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        pStack.hurtAndBreak(1, pAttacker, EquipmentSlot.MAINHAND);
}

    @Override
    public boolean isValidRepairItem(ItemStack pStack, ItemStack pRepairCandidate) {
        return pRepairCandidate.is(ModItems.FENT.get());
    }

    @Override
    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.SPEAR;
    }
}
