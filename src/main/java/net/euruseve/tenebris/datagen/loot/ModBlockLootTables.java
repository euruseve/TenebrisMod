package net.euruseve.tenebris.datagen.loot;

import net.euruseve.tenebris.init.ModBlocks;
import net.euruseve.tenebris.init.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {

    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate()
    {
        this.dropSelf(ModBlocks.IGNIONITE_BLOCK.get());
        this.dropSelf(ModBlocks.RAW_IGNIONITE_BLOCK.get());

        this.add(ModBlocks.IGNIONITE_ORE.get(),
                block -> createOreDrop(
                        ModBlocks.IGNIONITE_ORE.get(),
                        ModItems.RAW_IGNIONITE.get()
                ));

        this.add(ModBlocks.DEEPSLATE_IGNIONITE_ORE.get(),
                block -> createOreDrop(
                        ModBlocks.DEEPSLATE_IGNIONITE_ORE.get(),
                        ModItems.RAW_IGNIONITE.get()
                ));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
