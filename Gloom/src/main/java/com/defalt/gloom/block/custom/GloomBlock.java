package com.defalt.gloom.block.custom;

import com.defalt.gloom.Gloom;
import com.defalt.gloom.effect.GloomEffect;
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

import static com.defalt.gloom.effect.ModEffects.gloom;
import static com.defalt.gloom.effect.ModEffects.refresh;

public class GloomBlock extends Block {
    public GloomBlock(Settings settings) {
        super(settings);
    }
    private int dmg = 1;

    //@Override
    //public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
    //    entity.damage(world.getDamageSources().generic(), 1.0f);
    //}

    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        LivingEntity livingEntity;
        if (entity instanceof LivingEntity) {
            ((LivingEntity) entity).removeStatusEffect(refresh);
            if(dmg >= 5 && entity.isAlive())
            {
                livingEntity = (LivingEntity) entity;
                entity.damage(world.getDamageSources().generic(), 3.0f);
                livingEntity.addStatusEffect(new StatusEffectInstance(gloom, -1));
                this.dmg = 1;
            }
            else{this.dmg = dmg + 1; Gloom.LOGGER.info(""+dmg);}
        }



    }


}
