package norivensuu.plushified.client.datagen;


import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.BlockStateSupplier;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Model;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import norivensuu.plushified.Plushified;
import norivensuu.plushified.block.Plushie;
import norivensuu.plushified.config.PlushifiedConfig;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static norivensuu.plushified.Plushified.LOGGER;
import static norivensuu.plushified.registry.BlockRegistry.PLUSHIES;

public class ModelGenerator extends FabricModelProvider {
    public ModelGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        PLUSHIES.forEach((id, plushie) -> {
            createPlushieBlockModel(plushie, blockStateModelGenerator);
        });
    }

    public void createPlushieBlockModel(Plushie plushie, BlockStateModelGenerator blockStateModelGenerator) {
        Identifier identifier = Registries.BLOCK.getId(plushie);

        blockStateModelGenerator.modelCollector.accept(Identifier.of(identifier.getNamespace(), "block/"+identifier.getPath()), () -> getPlushieJsonModel(identifier));
        BlockStateSupplier supplier = new BlockStateSupplier() {
            @Override
            public Block getBlock() {
                return plushie;
            }
            @Override
            public JsonElement get() {
                JsonObject json = new JsonObject();
                JsonObject variants = new JsonObject();
                JsonObject model = new JsonObject();
                model.addProperty("model", identifier.getNamespace()+":block/"+identifier.getPath());
                variants.add("", model);
                json.add("variants", variants);
                return json;
            }
        };
        blockStateModelGenerator.blockStateCollector.accept(supplier);
    }

    private static JsonObject getPlushieJsonModel(Identifier identifier) {
        JsonObject json = new JsonObject();
        json.addProperty("parent", String.format("%s:custom/plushie", Plushified.MOD_ID));
        JsonObject textures = new JsonObject();
        String format = String.format("%s:block/%s", identifier.getNamespace(), identifier.getPath());
        textures.addProperty("all", format);
        textures.addProperty("particle", format);
        textures.addProperty("0", format);
        json.add("textures", textures);
        json.addProperty("render_type", "translusent");
        return json;
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        PLUSHIES.forEach((id, plushie) -> {
            itemModelGenerator.register(plushie.asItem(), new Model(Optional.of(Identifier.of(Plushified.MOD_ID,"block/"+id.id.getPath())), Optional.empty()));
        });
    }
}
