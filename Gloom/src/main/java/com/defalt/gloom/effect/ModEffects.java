package com.defalt.gloom.effect;

import com.defalt.gloom.Gloom;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.stat.Stat;
import net.minecraft.util.Colors;
import net.minecraft.util.Identifier;

public class ModEffects extends StatusEffects {

    public static StatusEffect gloom;
    public static StatusEffect refresh;
    public static StatusEffect refresh_potion_effect;
    public static StatusEffect malice;

    public static void registerEffect(){
        gloom = Registry.register(Registries.STATUS_EFFECT, new Identifier(Gloom.ModID,"gloom"),
                new GloomEffect(StatusEffectCategory.HARMFUL,16711680));
        refresh = Registry.register(Registries.STATUS_EFFECT, new Identifier(Gloom.ModID,"refresh"),
                new RefreshEffect(StatusEffectCategory.BENEFICIAL,16628224));
        malice = Registry.register(Registries.STATUS_EFFECT, new Identifier(Gloom.ModID,"malice"),
                new MaliceEffect(StatusEffectCategory.HARMFUL,4521984));
        refresh_potion_effect = Registry.register(Registries.STATUS_EFFECT, new Identifier(Gloom.ModID,"refresh_potion_effect"),
                new RefreshPotionEffect(StatusEffectCategory.BENEFICIAL,16628224));

    }

}
