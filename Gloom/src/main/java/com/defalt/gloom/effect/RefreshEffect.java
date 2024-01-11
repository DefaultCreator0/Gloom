package com.defalt.gloom.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;

import static com.defalt.gloom.effect.ModEffects.*;

public class RefreshEffect extends StatusEffect {

    protected RefreshEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }


    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        float CurrentHealth = entity.getHealth();
        float MaxHealth = 20;
        if (entity.isPlayer() && entity.getWorld().isSkyVisible(entity.getBlockPos())) {
            entity.removeStatusEffect(gloom);
            //entity.removeStatusEffect(malice);
            PlayerEntity p = (PlayerEntity) entity;
            if(p.getMaxHealth() <= 19){
                p.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH)
                        .addPersistentModifier(new EntityAttributeModifier("Refresh", 0.05f, EntityAttributeModifier.Operation.ADDITION));
            }
            else{
                entity.removeStatusEffect(refresh);
            }
        }
    }
}
