package com.jonb.gaiusmod.item.custom;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;


public class rouletteGunItem extends Item {
    public rouletteGunItem(Properties pProperties) {
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
            player.playSound(SoundEvents.DISPENSER_FAIL, 1.5f, 1f);
        }

        stack.hurtAndBreak(1, player, EquipmentSlot.MAINHAND);
        return super.onLeftClickEntity(stack, player, entity);

    }

}
