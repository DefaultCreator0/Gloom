package com.defalt.gloom;

import com.defalt.gloom.block.ModBlocks;
import com.defalt.gloom.effect.ModEffects;
import com.defalt.gloom.item.ModItemGroups;
import com.defalt.gloom.item.ModItems;
import com.defalt.gloom.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static com.defalt.gloom.potion.ModPotions.registerPotions;

public class Gloom implements ModInitializer {

	public static final String ModID = "gloom";
    public static final Logger LOGGER = LoggerFactory.getLogger(ModID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Producing  Gloom");
		ModItems.registerModItems();
		ModItemGroups.registerItemGroups();
		ModBlocks.registerModBlocks();
		ModEffects.registerEffect();
		ModWorldGeneration.generateModWorldGen();
		registerPotions();



	}
}