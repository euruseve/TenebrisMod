package net.euruseve.tenebris.datagen;

import net.euruseve.tenebris.Tenebris;
import net.euruseve.tenebris.init.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Tenebris.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.IGNIONITE_BLOCK);
        blockWithItem(ModBlocks.RAW_IGNIONITE_BLOCK);

        blockWithItem(ModBlocks.IGNIONITE_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_IGNIONITE_ORE);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
