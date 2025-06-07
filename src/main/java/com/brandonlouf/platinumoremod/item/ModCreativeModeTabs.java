package com.brandonlouf.platinumoremod.item;

import com.brandonlouf.platinumoremod.PlatinumOreMod;
import com.brandonlouf.platinumoremod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    // Register for creative mode tabs.
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, PlatinumOreMod.MOD_ID);
    // Defines the creative tab. This builds it, names it, allows it to display items, and defines those specific items. (Where the tab appears in the menu not included.)
    public static final Supplier<CreativeModeTab> PLATINUM_ORE_TAB = CREATIVE_MODE_TAB.register("platinum_ore_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.RAW_PLATINUM.get()))
                    .title(Component.translatable("creativetab.platinumoremod.platinum_ore"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.RAW_PLATINUM);
                        output.accept(ModItems.PLATINUM_INGOT);
                        output.accept(ModBlocks.PLATINUM_ORE);
                        output.accept(ModBlocks.DEEPSLATE_PLATINUM_ORE);
                        output.accept(ModBlocks.PLATINUM_BLOCK);
                    }).build());

    // Passes the class to the main class eventbus.
    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
