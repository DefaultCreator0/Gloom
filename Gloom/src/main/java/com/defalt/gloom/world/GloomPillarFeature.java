package com.defalt.gloom.world;

import com.mojang.serialization.Codec;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.util.FeatureContext;

public class GloomPillarFeature extends Feature<GloomPillarFeatureConfig> {


    public GloomPillarFeature(Codec<GloomPillarFeatureConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public boolean generate(FeatureContext<GloomPillarFeatureConfig> context) {
        return false;
    }
}
