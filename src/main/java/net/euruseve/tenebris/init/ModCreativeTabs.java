package net.euruseve.tenebris.init;

import net.euruseve.tenebris.Tenebris;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTabs
{
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Tenebris.MODID);

    public static final RegistryObject<CreativeModeTab> TENEBRIS_TAB =
            CREATIVE_MODE_TABS.register("tenebris_tab",
                    () -> CreativeModeTab.builder()
                            .icon(() -> new ItemStack(ModItems.IGNIONITE_INGOT.get()))
                            .title(Component.translatable("creativetab.tenebris_tab"))
                            .displayItems((displayParameters, output) -> {
                                // Items
                                output.accept(ModItems.IGNIONITE_INGOT.get());
                                output.accept(ModItems.RAW_IGNIONITE.get());

                                output.accept(ModItems.YELLOW_PEAR.get());
                                output.accept(ModItems.GREEN_PEAR.get());
                                output.accept(ModItems.CHERRY.get());

                                output.accept(ModItems.PINK_WOOL_PAINTER.get());
                                output.accept(ModItems.MIRROR.get());

                                // Blocks
                                output.accept(ModBlocks.IGNIONITE_BLOCK.get());
                                output.accept(ModBlocks.IGNIONITE_ORE.get());
                                output.accept(ModBlocks.DEEPSLATE_IGNIONITE_ORE.get());
                                output.accept(ModBlocks.RAW_IGNIONITE_BLOCK.get());
                                output.accept(ModBlocks.IGNIONITE_STAIRS.get());
                                output.accept(ModBlocks.IGNIONITE_SLABS.get());

                                // Tools
                                output.accept(ModItems.IGNIONITE_SWORD.get());
                                output.accept(ModItems.IGNIONITE_PICKAXE.get());
                                output.accept(ModItems.IGNIONITE_AXE.get());
                                output.accept(ModItems.IGNIONITE_SHOVEL.get());
                                output.accept(ModItems.IGNIONITE_HOE.get());
                                output.accept(ModItems.IGNIONITE_PAXEL.get());
                                output.accept(ModItems.IGNIONITE_HAMMER.get());
                            })
                            .build());

    public static void register(IEventBus eventBus)
    {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
