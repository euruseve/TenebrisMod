package net.euruseve.tenebris.init;

import net.euruseve.tenebris.Tenebris;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks
{
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Tenebris.MODID);


    public static final RegistryObject<Block> IGNIONITE_BLOCK =
            registerBlock("ignionite_block",
                    () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> RAW_IGNIONITE_BLOCK =
            registerBlock("raw_ignionite_block",
                    () -> new Block(BlockBehaviour.Properties.copy(Blocks.RAW_IRON_BLOCK)));

    public static final RegistryObject<Block> IGNIONITE_ORE =
            registerBlock("ignionite_ore",
                    () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_ORE)
                            .requiresCorrectToolForDrops(),
                            UniformInt.of(1,2)));

    public static final RegistryObject<Block> DEEPSLATE_IGNIONITE_ORE =
            registerBlock("deepslate_ignionite_ore",
                    () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_IRON_ORE)
                            .requiresCorrectToolForDrops(),
                            UniformInt.of(3,4)));


    public static final RegistryObject<Block> IGNIONITE_STAIRS =
            registerBlock("ignionite_stair",
                    () -> new StairBlock(()-> ModBlocks.IGNIONITE_BLOCK.get().defaultBlockState(),
                            BlockBehaviour.Properties.copy(Blocks.QUARTZ_STAIRS)
                                    .sound(SoundType.METAL)));


    public static final RegistryObject<Block> IGNIONITE_SLABS =
            registerBlock("ignionite_slab",
                    () -> new SlabBlock(
                            (BlockBehaviour.Properties.copy(Blocks.QUARTZ_SLAB))
                                    .sound(SoundType.METAL)));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block)
    {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block)
    {
        return ModItems.ITEMS.register(name,
                () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus)
    {
        BLOCKS.register(eventBus);
    }
}
