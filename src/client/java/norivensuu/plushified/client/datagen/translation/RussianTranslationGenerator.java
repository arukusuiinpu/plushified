package norivensuu.plushified.client.datagen.translation;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;
import norivensuu.plushified.Plushified;

import java.nio.file.Path;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import static norivensuu.plushified.registry.BlockRegistry.*;

public class RussianTranslationGenerator extends FabricLanguageProvider {
    public RussianTranslationGenerator(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "ru_ru", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {
        PLUSHIES.forEach((id, plushie) -> translationBuilder.add(plushie, "Плюшевая игрушка "+id.nickname));

        translationBuilder.add("text.config.plushified.title", "Plushified");
        translationBuilder.add("text.config.plushified.category.general", "Главное");
        translationBuilder.add("text.config.plushified.category.general.@Tooltip", "Главное");
        translationBuilder.add("text.config.plushified.option.plushies", "Плюшевые игрушки");
        translationBuilder.add("text.config.plushified.option.lootTables", "Лут тейблы");

        translationBuilder.add("itemGroup."+ Plushified.MOD_ID+".plushies", "Плюшевые игрушки");

        translationBuilder.add("subtitles.plushified.plushie_pat_sound", "Писк плюшевой игрушки");

        try {
            Optional<Path> path = dataOutput.getModContainer().findPath("assets/plushified/lang/ru_ru.json");
            translationBuilder.add(path.get());
        } catch (Exception e) {
            LOGGER.info("Failed to merge language file: " + e);
        }
    }
}
