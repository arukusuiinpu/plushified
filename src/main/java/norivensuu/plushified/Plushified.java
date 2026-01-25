package norivensuu.plushified;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.SimpleSynchronousResourceReloadListener;
import net.minecraft.resource.ResourceManager;
import net.minecraft.resource.ResourceType;
import net.minecraft.util.Identifier;
import norivensuu.iinpulib.util.ConditionalInitializer;
import norivensuu.plushified.registry.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;

public class Plushified implements ModInitializer {
    public static final String MOD_ID = "plushified";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("OMG! Initializing Plushified...");

        ResourceManagerHelper.get(ResourceType.SERVER_DATA).registerReloadListener(new SimpleSynchronousResourceReloadListener() {
            @Override
            public Identifier getFabricId() {
                return Identifier.of(MOD_ID, "resources");
            }

            @Override
            public void reload(ResourceManager manager) {
                LOGGER.info(manager.findAllResources(".", path -> true).toString());
                for(Identifier id : manager.findResources(".", path -> path.toString().endsWith(".png")).keySet()) {
                    LOGGER.info(String.valueOf(id));
                    try(InputStream stream = manager.getResource(id).get().getInputStream()) {
                        LOGGER.info("whatttt");
                    } catch(Exception e) {
                        LOGGER.error("Error occurred while loading resource png" + id.toString(), e);
                    }
                }
            }
        });

        ConditionalInitializer.Initialize(BlockRegistry.class);
        ConditionalInitializer.Initialize(BlockEntityRegistry.class);
        ConditionalInitializer.Initialize(EventRegistry.class);
        ConditionalInitializer.Initialize(ItemGroupRegistry.class);
        ConditionalInitializer.Initialize(SoundEventRegistry.class);
    }
}