package net.plushified;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

import net.plushified.datagen.*;
import net.plushified.datagen.translation.*;

public class PlushifiedDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		Plushified.LOGGER.info("OMG! Initializing DataGen...");

		pack.addProvider(BlockLootTableGenerator::new);
		pack.addProvider(BlockTagGenerator::new);
		pack.addProvider(ItemTagGenerator::new);
		pack.addProvider(ModelGenerator::new);
		pack.addProvider(RecipeGenerator::new);



		Plushified.LOGGER.info("OMG! Initializing Translations...");

		pack.addProvider(EnglishTranslationGenerator::new);
		pack.addProvider(RussianTranslationGenerator::new);
	}
}
