package com.defalt.gloom.effect;

import com.defalt.gloom.Gloom;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class MaliceEffect extends StatusEffect {


    protected MaliceEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {

        if (entity.isPlayer()) {
            World world = entity.getWorld();
            PlayerEntity p = (PlayerEntity) entity;
            entity.damage(world.getDamageSources().generic(), 2.0f);
        }
    }




}
