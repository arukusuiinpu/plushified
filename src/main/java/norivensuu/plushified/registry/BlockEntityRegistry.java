package norivensuu.plushified.registry;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import norivensuu.iinpulib.util.ConditionalInitializer;
import norivensuu.plushified.Plushified;

import static norivensuu.plushified.registry.BlockRegistry.*;

public class BlockEntityRegistry implements ConditionalInitializer {
    public void onInitialize() {
        PLUSHIES.forEach((id, plushie) ->
                Registry.register(Registries.BLOCK_ENTITY_TYPE,
                        Identifier.of(Plushified.MOD_ID, id.id.getPath()+"_block_entity"),
                        plushie.PLUSHIE_BLOCK_ENTITY_TYPE));

    }
}