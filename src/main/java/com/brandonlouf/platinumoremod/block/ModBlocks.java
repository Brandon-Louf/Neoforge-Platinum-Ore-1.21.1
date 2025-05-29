package com.brandonlouf.platinumoremod.block;

import com.brandonlouf.platinumoremod.PlatinumOreMod;
import com.brandonlouf.platinumoremod.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    // Register for mod class.
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(PlatinumOreMod.MOD_ID);

    // Platinum Ore block, including mining strength, tool requirement check, and break sound.
    public static final DeferredBlock<Block> PLATINUM_ORE = registerBlock("platinum_ore", () -> new Block(BlockBehaviour.Properties.of()
            .strength(5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    // Registers and returns items as blocks.
    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    // Registers a new item from the Mod Items register.
    public static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    // EventBus to call main class.
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
