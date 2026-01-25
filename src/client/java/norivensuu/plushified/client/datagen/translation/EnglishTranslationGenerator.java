package norivensuu.plushified.client.datagen.translation;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;
import norivensuu.plushified.Plushified;

import java.nio.file.Path;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import static norivensuu.plushified.registry.BlockRegistry.*;

public class EnglishTranslationGenerator extends FabricLanguageProvider {
    public EnglishTranslationGenerator(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {
        PLUSHIES.forEach((id, plushie) -> translationBuilder.add(plushie, id.nickname+" plushie"));

        translationBuilder.add("text.config.plushified.title", "Plushified");
        translationBuilder.add("text.config.plushified.category.general", "General");
        translationBuilder.add("text.config.plushified.category.general.@Tooltip", "General");
        translationBuilder.add("text.config.plushified.option.plushies", "Plushies");
        translationBuilder.add("text.config.plushified.option.lootTables", "Loot Tables");

        translationBuilder.add("itemGroup.plushified.plushies", "Plushies");

        translationBuilder.add("subtitles.plushified.plushie_pat_sound", "Plushie squeak");

        try {
            Optional<Path> path = dataOutput.getModContainer().findPath("assets/plushified/lang/en_us.json");
            translationBuilder.add(path.get());
        } catch (Exception e) {
            LOGGER.info("Failed to merge language file: " + e);
        }
    }
}
