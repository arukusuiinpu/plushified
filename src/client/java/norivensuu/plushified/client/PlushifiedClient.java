package norivensuu.plushified.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.util.Identifier;
import norivensuu.plushified.Plushified;
import norivensuu.plushified.client.block.PlushieRenderer;

import static norivensuu.plushified.registry.BlockRegistry.*;

@Environment(EnvType.CLIENT)
public class PlushifiedClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        PLUSHIES.forEach((id, plushie) -> {
            BlockRenderLayerMap.INSTANCE.putBlock(plushie, RenderLayer.getTranslucent());

            BlockEntityRendererFactories.register(plushie.PLUSHIE_BLOCK_ENTITY_TYPE,
                    context -> new PlushieRenderer(id.id));
        });
    }
}