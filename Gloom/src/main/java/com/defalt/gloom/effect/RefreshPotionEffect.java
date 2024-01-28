package com.defalt.gloom.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;

import static com.defalt.gloom.effect.ModEffects.*;

public class RefreshPotionEffect extends StatusEffect {


    protected RefreshPotionEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    public void applyUpdateEffect(LivingEntity entity, int amplifier) {

        if(entity.isPlayer()){

            PlayerEntity p = (PlayerEntity) entity;
            entity.removeStatusEffect(gloom);
            entity.removeStatusEffect(malice);
            if(entity.getWorld().isSkyVisible(entity.getBlockPos())){
                p.removeStatusEffect(refresh_potion_effect);
            }

            if(p.getMaxHealth() <= 19){
                p.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH)
                        .addPersistentModifier(new EntityAttributeModifier("refresh_potion_effect", 0.05f, EntityAttributeModifier.Operation.ADDITION));
            }
            else{
                entity.removeStatusEffect(refresh_potion_effect);
            }

        }
    }
}
