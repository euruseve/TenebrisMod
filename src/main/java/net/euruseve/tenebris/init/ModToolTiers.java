package net.euruseve.tenebris.init;

import net.euruseve.tenebris.Tenebris;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers
{
    public static final Tier IGNIONITE = TierSortingRegistry.registerTier(
            new ForgeTier(5, 4000, 10, 4, 26,
                    ModTags.Blocks.NEEDS_IGNIONITE_TOOL,
                    () -> Ingredient.of(ModItems.IGNIONITE_INGOT.get())),
                new ResourceLocation(Tenebris.MODID, "ignionite"),
            List.of(Tiers.NETHERITE), List.of()
    );
}
