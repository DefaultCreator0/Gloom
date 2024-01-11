//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.defalt.gloom.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import static com.defalt.gloom.effect.ModEffects.gloom;
import static com.defalt.gloom.effect.ModEffects.refresh;

@Mixin({PlayerEntity.class})
public abstract class PlayerSunDetection extends LivingEntity {

    protected PlayerSunDetection(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(at = {@At("HEAD")}, method = {"tick"})
    public void onTick(CallbackInfo ci) {
        LivingEntity player = this;
        if(player.getY() > 40){
            if (player.getWorld().isSkyVisible(player.getBlockPos()) && player.hasStatusEffect(gloom)) {
                player.addStatusEffect(new StatusEffectInstance(refresh,-1));
            }
        }
        if(player.getY() > 240){
            if(true/*If armor doesn't have the capability to keep warmth*/){
                //Apply a freezing effect to the player
            }
        }
    }
}