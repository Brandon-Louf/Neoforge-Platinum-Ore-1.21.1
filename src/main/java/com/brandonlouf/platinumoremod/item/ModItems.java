package com.brandonlouf.platinumoremod.item;

import com.brandonlouf.platinumoremod.PlatinumOreMod;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    // Register for creating items.
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PlatinumOreMod.MOD_ID);
    // Raw Platinum item.
    public static final DeferredItem<Item> RAW_PLATINUM = ITEMS.register("raw_platinum",() -> new Item(new Item.Properties()));
    // Platinum Ingot item.
    public static final DeferredItem<Item> PLATINUM_INGOT = ITEMS.register("platinum_ingot",() -> new Item(new Item.Properties()));
    // EventBus to call main class.
    public static void register(IEventBus eventBus) {

        ITEMS.register(eventBus);
    }
}
