package net.euruseve.tenebris.init;

import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties
{
    public static final FoodProperties YELLOW_PEAR = new FoodProperties.Builder()
            .nutrition(3)
            .saturationMod(3)
            .build();

    public static final FoodProperties GREEN_PEAR = new FoodProperties.Builder()
            .nutrition(2)
            .saturationMod(4)
            .build();

    public static final FoodProperties CHERRY = new FoodProperties.Builder()
            .nutrition(5)
            .saturationMod(5)
            .build();
}
