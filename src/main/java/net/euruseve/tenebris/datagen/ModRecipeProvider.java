package net.euruseve.tenebris.datagen;

import net.euruseve.tenebris.Tenebris;
import net.euruseve.tenebris.init.ModBlocks;
import net.euruseve.tenebris.init.ModItems;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider {

    private List<ItemLike> IGNIONITE_SMELTABLES =
            List.of(ModItems.RAW_IGNIONITE.get(),
                    ModBlocks.IGNIONITE_ORE.get(),
                    ModBlocks.DEEPSLATE_IGNIONITE_ORE.get());

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {

        /// IGNIONITE BLOCK
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.IGNIONITE_BLOCK.get())
                .pattern("iii")
                .pattern("iii")
                .pattern("iii")
                .define('i', ModItems.IGNIONITE_INGOT.get())
                .unlockedBy("has_ignionite",
                        inventoryTrigger(ItemPredicate.Builder.item()
                                .of(ModItems.IGNIONITE_INGOT.get())
                                .build()))
                .save(pWriter);

        /// IGNIONITE INGOT
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.IGNIONITE_INGOT.get(), 9)
                .requires(ModBlocks.IGNIONITE_BLOCK.get())
                .unlockedBy("has_ignionite_block",
                        inventoryTrigger(ItemPredicate.Builder.item()
                                .of(ModBlocks.IGNIONITE_BLOCK.get())
                                .build()))
                .save(pWriter);

        oreSmelting(pWriter, IGNIONITE_SMELTABLES, RecipeCategory.MISC, ModItems.IGNIONITE_INGOT.get(),
                .25f, 200, "ingionite");
        oreBlasting(pWriter, IGNIONITE_SMELTABLES, RecipeCategory.MISC, ModItems.IGNIONITE_INGOT.get(),
                .25f, 100, "ingionite");


        /// RAW IGNIONITE + BLOCK
        nineBlockStorageRecipes(pWriter, RecipeCategory.MISC, ModItems.RAW_IGNIONITE.get(), RecipeCategory.MISC, ModBlocks.RAW_IGNIONITE_BLOCK.get(),
                "tenebris:raw_ignionite", null, "tenebris:raw_ignionite_block", null);

        /// MIRROR
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.MIRROR.get())
                .pattern("#")
                .pattern("A")
                .pattern("A")
                .define('#', Items.GLASS_PANE)
                .define('A', Items.AMETHYST_SHARD)
                .unlockedBy("has_amethyst_shard",
                        inventoryTrigger(ItemPredicate.Builder.item()
                                .of(Items.AMETHYST_SHARD)
                                .build()))
                .save(pWriter);

        /// IGNIONITE SWORD
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.IGNIONITE_SWORD.get())
                .pattern("i")
                .pattern("i")
                .pattern("s")
                .define('i', ModItems.IGNIONITE_INGOT.get())
                .define('s', Items.STICK)
                .unlockedBy("has_ignionite",
                        inventoryTrigger(ItemPredicate.Builder.item()
                                .of(ModItems.IGNIONITE_INGOT.get())
                                .build()))
                .save(pWriter);

        /// IGNIONITE PICKAXE
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.IGNIONITE_PICKAXE.get())
                .pattern("iii")
                .pattern(" s ")
                .pattern(" s ")
                .define('i', ModItems.IGNIONITE_INGOT.get())
                .define('s', Items.STICK)
                .unlockedBy("has_ignionite",
                        inventoryTrigger(ItemPredicate.Builder.item()
                                .of(ModItems.IGNIONITE_INGOT.get())
                                .build()))
                .save(pWriter);


        /// IGNIONITE SHOVEL
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.IGNIONITE_SHOVEL.get())
                .pattern("i")
                .pattern("s")
                .pattern("s")
                .define('i', ModItems.IGNIONITE_INGOT.get())
                .define('s', Items.STICK)
                .unlockedBy("has_ignionite",
                        inventoryTrigger(ItemPredicate.Builder.item()
                                .of(ModItems.IGNIONITE_INGOT.get())
                                .build()))
                .save(pWriter);

        /// IGNIONITE AXE
        axeRecipe(pWriter, ModItems.IGNIONITE_AXE.get(), ModItems.IGNIONITE_INGOT.get(), Items.STICK, "ignionite");

        /// IGNIONITE HOE
        hoeRecipe(pWriter, ModItems.IGNIONITE_HOE.get(), ModItems.IGNIONITE_INGOT.get(), Items.STICK, "ignionite");
    }


    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer,
                                     List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime,
                            pCookingSerializer).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, Tenebris.MODID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }

    protected static void axeRecipe(Consumer<FinishedRecipe> pWriter, ItemLike axe, ItemLike material, ItemLike stick, String materialName) {
        // Left Side
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, axe)
                .pattern("mm")
                .pattern("ms")
                .pattern(" s")
                .define('m', material)
                .define('s', stick)
                .unlockedBy("has_" + materialName, inventoryTrigger(ItemPredicate.Builder.item().of(material).build()))
                .save(pWriter, Tenebris.MODID + ":" + getItemName(axe) + "_left");

        // Right side
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, axe)
                .pattern("mm")
                .pattern("sm")
                .pattern("s ")
                .define('m', material)
                .define('s', stick)
                .unlockedBy("has_" + materialName, inventoryTrigger(ItemPredicate.Builder.item().of(material).build()))
                .save(pWriter, Tenebris.MODID + ":" + getItemName(axe) + "_right");
    }

    protected static void hoeRecipe(Consumer<FinishedRecipe> pWriter, ItemLike hoe, ItemLike material, ItemLike stick, String materialName) {
        // Left Side
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, hoe)
                .pattern("mm")
                .pattern(" s")
                .pattern(" s")
                .define('m', material)
                .define('s', stick)
                .unlockedBy("has_" + materialName, inventoryTrigger(ItemPredicate.Builder.item().of(material).build()))
                .save(pWriter, Tenebris.MODID + ":" + getItemName(hoe) + "_left");

        // Right side
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, hoe)
                .pattern("mm")
                .pattern("s ")
                .pattern("s ")
                .define('m', material)
                .define('s', stick)
                .unlockedBy("has_" + materialName, inventoryTrigger(ItemPredicate.Builder.item().of(material).build()))
                .save(pWriter, Tenebris.MODID + ":" + getItemName(hoe) + "_right");
    }
}
