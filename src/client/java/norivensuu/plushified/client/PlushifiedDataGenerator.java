package norivensuu.plushified.client;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import norivensuu.plushified.Plushified;

import norivensuu.plushified.client.datagen.*;
import norivensuu.plushified.client.datagen.translation.*;

public class PlushifiedDataGenerator implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(BlockLootTableGenerator::new);
        pack.addProvider(BlockTagGenerator::new);
        pack.addProvider(ItemTagGenerator::new);
        pack.addProvider(ModelGenerator::new);
        pack.addProvider(RecipeGenerator::new);

        pack.addProvider(EnglishTranslationGenerator::new);
        pack.addProvider(RussianTranslationGenerator::new);
    }
}
