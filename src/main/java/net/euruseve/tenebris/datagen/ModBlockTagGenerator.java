package net.euruseve.tenebris.datagen;

import net.euruseve.tenebris.Tenebris;
import net.euruseve.tenebris.init.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                                @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Tenebris.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.IGNIONITE_BLOCK.get(),
                     ModBlocks.RAW_IGNIONITE_BLOCK.get(),

                     ModBlocks.DEEPSLATE_IGNIONITE_ORE.get(),
                     ModBlocks.IGNIONITE_ORE.get()
                );

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.IGNIONITE_BLOCK.get(),
                     ModBlocks.RAW_IGNIONITE_BLOCK.get());

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.IGNIONITE_ORE.get(),
                     ModBlocks.DEEPSLATE_IGNIONITE_ORE.get());
    }

    @Override
    public String getName() {
        return "Block Tags";
    }
}
