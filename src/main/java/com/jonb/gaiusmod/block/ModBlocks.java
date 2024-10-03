package com.jonb.gaiusmod.block;

import com.jonb.gaiusmod.GaiusMod;
import com.jonb.gaiusmod.block.custom.fentTrapBlock;
import com.jonb.gaiusmod.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FurnaceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, GaiusMod.MOD_ID);

    public static final RegistryObject<Block> HOGBLOCK = registerBlock("hogblock",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(8f)
                    .sound(SoundType.STONE)
                    .strength(0.5f, 36000000)
            ));

    public static final RegistryObject<Block> FENTLABBLOCK = registerBlock("fent_lab_block",
            () -> new FurnaceBlock(BlockBehaviour.Properties.of()
                    .strength(1f)
                    .sound(SoundType.GLASS)
                    .strength(0.5f, 600)
            ));

    public static final RegistryObject<Block> FENTTRAPBLOCK = registerBlock("fent_trap_block",
            () -> new fentTrapBlock(BlockBehaviour.Properties.of()
                    .strength(8f)
                    .sound(SoundType.ANVIL)
                    .strength(0.5f, 36000000)
            ));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}

