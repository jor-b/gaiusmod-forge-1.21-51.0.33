package com.jonb.gaiusmod.entity;

import com.jonb.gaiusmod.GaiusMod;
import com.jonb.gaiusmod.entity.custom.fentBagProjectile;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, GaiusMod.MOD_ID);

    public static final RegistryObject<EntityType<fentBagProjectile>> FENTBAG_PROJECTILE =
            ENTITY_TYPES.register("fentbag_projectile", () -> EntityType.Builder.<fentBagProjectile>of(fentBagProjectile::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f)
                    .clientTrackingRange(4)
                    .updateInterval(10)
                    .build("fentbag_projectile"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
