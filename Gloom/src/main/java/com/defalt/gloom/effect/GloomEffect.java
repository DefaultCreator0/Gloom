package com.defalt.gloom.effect;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.*;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;

import java.util.Map;

import static com.defalt.gloom.effect.ModEffects.*;

public class GloomEffect extends StatusEffect {


    protected GloomEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        super.applyUpdateEffect(entity, amplifier);

            float CurrentHealth = entity.getHealth();

            if(entity.isPlayer()){
                PlayerEntity p = (PlayerEntity)entity;
                if(entity.getY() < 20){
                    if(p.hasStatusEffect(malice) && p.getHealth() < p.getMaxHealth())
                        p.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH)
                                .addPersistentModifier(new EntityAttributeModifier("Gloom",CurrentHealth-entity.getMaxHealth(), EntityAttributeModifier.Operation.ADDITION));
                }
                else{
                    if(entity.isPlayer() && !entity.getWorld().isSkyVisible(entity.getBlockPos())){
                        if(p.hasStatusEffect(malice) && p.getHealth() < p.getMaxHealth()){
                            p.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH)
                                    .addPersistentModifier(new EntityAttributeModifier("Gloom",CurrentHealth-entity.getMaxHealth(), EntityAttributeModifier.Operation.ADDITION));
                        }
                    }
                }
                if(entity.getY() > 20 && entity.getWorld().isSkyVisible(entity.getBlockPos())){
                    p.addStatusEffect(new StatusEffectInstance(refresh,-1) );
                }
            }
    }




}
