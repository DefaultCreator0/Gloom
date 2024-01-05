package com.defalt.gloom.world;

import com.defalt.gloom.Gloom;
import com.defalt.gloom.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;

import java.util.List;

import static net.minecraft.world.gen.feature.Feature.SCULK_PATCH;

public class ModConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> GLOOM_KEY = registerKey("gloom");

    public static void boostrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplacables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest sculkPlacement = new TagMatchRuleTest(BlockTags.OVERWORLD_CARVER_REPLACEABLES);

        List<OreFeatureConfig.Target> gloomSpawn =
                List.of(OreFeatureConfig.createTarget(sculkPlacement, ModBlocks.Gloom_Block.getDefaultState()),
                        OreFeatureConfig.createTarget(stoneReplacables, ModBlocks.Gloom_Block.getDefaultState())
                );


        register(context, GLOOM_KEY, Feature.ORE,new OreFeatureConfig(gloomSpawn,15) );
        //register(context, GLOOM_KEY, SCULK_PATCH,new SculkPatchFeatureConfig());
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(Gloom.ModID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
