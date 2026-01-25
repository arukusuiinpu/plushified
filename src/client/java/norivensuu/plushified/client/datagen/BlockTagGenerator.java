package norivensuu.plushified.client.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import norivensuu.plushified.Plushified;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

import static norivensuu.plushified.registry.BlockRegistry.*;

public class BlockTagGenerator extends FabricTagProvider.BlockTagProvider{
    public BlockTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, Identifier.of(Plushified.MOD_ID, "plushie")))
                .add((new ArrayList<>(){{for (var plushie : PLUSHIES.values()) {
                    add(RegistryKey.of(Registries.BLOCK.getKey(), Registries.BLOCK.getId(plushie)));
                }}}));
    }
}
