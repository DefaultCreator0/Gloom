package com.defalt.gloom.world;

import com.defalt.gloom.datagen.ModWorldGenerator;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class GloomDataGenerator implements DataGeneratorEntrypoint {


    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {

        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(ModWorldGenerator::new);


    }

    @Override
    public void buildRegistry(RegistryBuilder registryBuilder) {
        registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ModConfiguredFeatures::boostrap);
        registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, ModPlacedFeatures::boostrap);
    }
}
