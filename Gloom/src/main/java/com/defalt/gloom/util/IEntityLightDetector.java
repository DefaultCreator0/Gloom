package com.defalt.gloom.util;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public interface IEntityLightDetector {
    boolean getInSunlight(PlayerEntity player, World world);

    boolean getInSunlight();
}
