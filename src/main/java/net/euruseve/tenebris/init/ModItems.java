package net.euruseve.tenebris.init;

import net.euruseve.tenebris.Tenebris;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems
{
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Tenebris.MODID);

    public static final RegistryObject<Item> IGNIONITE_INGOT
            = ITEMS.register("ignionite_ingot",
            () ->  new Item(new Item.Properties()));

    public static final RegistryObject<Item> RAW_IGNIONITE
            = ITEMS.register("raw_ignionite",
            () ->  new Item(new Item.Properties()));

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
