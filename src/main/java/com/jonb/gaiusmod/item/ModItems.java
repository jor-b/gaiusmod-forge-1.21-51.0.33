package com.jonb.gaiusmod.item;

import com.jonb.gaiusmod.GaiusMod;
import com.jonb.gaiusmod.item.custom.*;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, GaiusMod.MOD_ID);

    public static final RegistryObject<Item> FENT = ITEMS.register("fent",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> UNREFINED_FENT = ITEMS.register("unrefined_fent",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> FENT_CART = ITEMS.register("fent_cart",
            () -> new fentCartItem(new Item.Properties().durability(8)));

    public static final RegistryObject<Item> FENT_SPEAR = ITEMS.register("fent_spear",
            () -> new fentSpearItem(new Item.Properties().durability(160).attributes(fentSpearItem.createAttributes())));

    public static final RegistryObject<Item> COPPER_SHATTERSTICK = ITEMS.register("copper_shatterstick",
            () -> new copperShatterstickItem(new Item.Properties().durability(1).attributes(copperShatterstickItem.createAttributes())));

    public static final RegistryObject<Item> FENT_SYRINGE = ITEMS.register("fent_syringe",
            () -> new fentSyringeItem(new Item.Properties().durability(8).attributes(fentSyringeItem.createAttributes())));

    public static final RegistryObject<Item> FENT_BAG = ITEMS.register("fent_bag",
            () -> new fentBagItem(new Item.Properties().stacksTo(16)));

    public static final RegistryObject<Item> SHIV_RUSTY = ITEMS.register("shiv_rusty",
            () -> new shivRustyItem(new Item.Properties().durability(32).attributes(shivRustyItem.createAttributes())));

    public static final RegistryObject<Item> SHIV_CLEAN = ITEMS.register("shiv_clean",
            () -> new shivCleanItem(new Item.Properties().durability(256).attributes(shivCleanItem.createAttributes())));

    public static final RegistryObject<Item> HAMMER_CLEAN = ITEMS.register("hammer_clean",
            () -> new hammerCleanItem(new Item.Properties().durability(256).attributes(hammerCleanItem.createAttributes())));

    public static final RegistryObject<Item> KIARA_GUN = ITEMS.register("kiara_gun",
            () -> new kiaraGunItem(new Item.Properties().durability(6)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
