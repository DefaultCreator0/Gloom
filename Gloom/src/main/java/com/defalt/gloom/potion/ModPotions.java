package com.defalt.gloom.potion;

import com.defalt.gloom.Gloom;
import com.defalt.gloom.mixin.BrewingRecipeRegistryMixin;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static com.defalt.gloom.effect.ModEffects.*;
import static com.defalt.gloom.item.ModItems.Gloom_Whisp;
import static com.defalt.gloom.item.ModItems.Sundelion_Petal;

public class ModPotions {

    public static Potion ESSENCE_OF_HATE_POTION;
    public static Potion ESSENCE_OF_LIGHT;

    public static void registerPotions(){
        ESSENCE_OF_HATE_POTION = Registry.register(Registries.POTION, new Identifier(Gloom.ModID, "essence_of_hate_potion"),
                new Potion(new StatusEffectInstance(malice,40) , new StatusEffectInstance(gloom,-1)));
        ESSENCE_OF_LIGHT = Registry.register(Registries.POTION, new Identifier(Gloom.ModID, "essence_of_light_potion"),
                new Potion(new StatusEffectInstance(refresh_potion_effect,100)));
        registerPotionRecipes();
    }

    private static void registerPotionRecipes(){
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.AWKWARD, Gloom_Whisp, ESSENCE_OF_HATE_POTION);
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.MUNDANE, Sundelion_Petal, ESSENCE_OF_LIGHT);
    }

}
