package net.euruseve.tenebris.datagen;

import net.euruseve.tenebris.Tenebris;
import net.euruseve.tenebris.init.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Tenebris.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.IGNIONITE_INGOT);
        simpleItem(ModItems.RAW_IGNIONITE);

        simpleItem(ModItems.MIRROR);
        simpleItem(ModItems.PINK_WOOL_PAINTER);

        simpleItem(ModItems.GREEN_PEAR);
        simpleItem(ModItems.YELLOW_PEAR);
        simpleItem(ModItems.CHERRY);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Tenebris.MODID,"item/" + item.getId().getPath()));
    }
}
