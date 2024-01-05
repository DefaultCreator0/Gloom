package com.defalt.gloom.block.custom;

import com.defalt.gloom.Gloom;
import com.defalt.gloom.effect.GloomEffect;
import com.defalt.gloom.effect.MaliceEffect;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.concurrent.TimeUnit;

import static com.defalt.gloom.effect.ModEffects.*;

public class GloomBlock extends Block {
    public GloomBlock(Settings settings) {
        super(settings);
    }
    private int dmg = 1;


    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        LivingEntity livingEntity;

        if (entity instanceof LivingEntity) {
            ((LivingEntity) entity).removeStatusEffect(refresh);
            if(dmg >= 5 && entity.isAlive())
            {
                livingEntity = (LivingEntity) entity;
                livingEntity.addStatusEffect(new StatusEffectInstance(malice,1));
                livingEntity.addStatusEffect(new StatusEffectInstance(gloom, -1));

                livingEntity.removeStatusEffect(REGENERATION);
                this.dmg = 1;
            }
            else{this.dmg = dmg + 1;}
        }



    }


}
