package net.euruseve.tenebris.datagen;

import net.euruseve.tenebris.Tenebris;
import net.euruseve.tenebris.init.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Tenebris.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels()
    {

        blockWithItem(ModBlocks.IGNIONITE_BLOCK);
        blockWithItem(ModBlocks.RAW_IGNIONITE_BLOCK);

        blockWithItem(ModBlocks.IGNIONITE_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_IGNIONITE_ORE);

        stairsBlock((StairBlock) ModBlocks.IGNIONITE_STAIRS.get(),
                blockTexture(ModBlocks.IGNIONITE_BLOCK.get()));

        blockItem(ModBlocks.IGNIONITE_STAIRS);

        slabBlock((SlabBlock) ModBlocks.IGNIONITE_SLABS.get(),
                blockTexture(ModBlocks.IGNIONITE_BLOCK.get()),
                blockTexture(ModBlocks.IGNIONITE_BLOCK.get()));

        blockItem(ModBlocks.IGNIONITE_SLABS);
    }


    private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("tenebris:block/"
                + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
