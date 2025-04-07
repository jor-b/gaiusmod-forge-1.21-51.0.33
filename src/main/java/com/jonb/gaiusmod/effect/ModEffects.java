package com.jonb.gaiusmod.effect;

import com.jonb.gaiusmod.GaiusMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, GaiusMod.MOD_ID);


    public static final RegistryObject<MobEffect> CREAMY_EFFECT = MOB_EFFECTS.register("creamy",
            () -> new CreamyEffect(MobEffectCategory.HARMFUL, 0xffffff)
                    .addAttributeModifier(Attributes.MOVEMENT_SPEED, ResourceLocation.fromNamespaceAndPath(GaiusMod.MOD_ID, "creamy"),
                    -0.25f, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
                    .addAttributeModifier(Attributes.KNOCKBACK_RESISTANCE, ResourceLocation.fromNamespaceAndPath(GaiusMod.MOD_ID, "creamy"),
                    -0.45f, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
                    .addAttributeModifier(Attributes.ATTACK_KNOCKBACK, ResourceLocation.fromNamespaceAndPath(GaiusMod.MOD_ID, "creamy"),
                    -0.45f, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));

    public static final RegistryObject<MobEffect> ROT_EFFECT = MOB_EFFECTS.register("rot",
            () -> new RotEffect(MobEffectCategory.HARMFUL, 0xf17641)
                    .addAttributeModifier(Attributes.MAX_HEALTH, ResourceLocation.fromNamespaceAndPath(GaiusMod.MOD_ID, "rot"),
                    -2.0, AttributeModifier.Operation.ADD_VALUE));

    public static final RegistryObject<MobEffect> ELECTRIFIED_EFFECT = MOB_EFFECTS.register("electrified",
            () -> new ElectrifiedEffect(MobEffectCategory.HARMFUL, 0xa3d4f0));

    public static final RegistryObject<MobEffect> CRIPPLED_EFFECT = MOB_EFFECTS.register("crippled",
            () -> new CrippledEffect(MobEffectCategory.HARMFUL, 0x1f1f1f)
                    .addAttributeModifier(Attributes.MOVEMENT_SPEED, ResourceLocation.fromNamespaceAndPath(GaiusMod.MOD_ID, "creamy"),
                            -0.85f, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
                    .addAttributeModifier(Attributes.JUMP_STRENGTH, ResourceLocation.fromNamespaceAndPath(GaiusMod.MOD_ID, "creamy"),
                            -0.85f, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
                    .addAttributeModifier(Attributes.SAFE_FALL_DISTANCE, ResourceLocation.fromNamespaceAndPath(GaiusMod.MOD_ID, "creamy"),
                            -2, AttributeModifier.Operation.ADD_VALUE));

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}
