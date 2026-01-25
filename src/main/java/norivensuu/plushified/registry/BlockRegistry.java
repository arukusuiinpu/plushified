package norivensuu.plushified.registry;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import norivensuu.iinpulib.util.ConditionalInitializer;
import norivensuu.plushified.Plushified;
import norivensuu.plushified.block.Plushie;
import norivensuu.plushified.config.PlushifiedConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static norivensuu.plushified.registry.SoundEventRegistry.*;
import static norivensuu.plushified.config.PlushifiedConfig.*;

public class BlockRegistry implements ConditionalInitializer {

    public static final Map<PlushieID, Plushie> PLUSHIES = new HashMap<>(){{
        for (PlushieID s : PlushifiedConfig.getHandler().instance().plushies) {
            Plushie plushie = new Plushie(Block.Settings.create().strength(1.0f).sounds(PLUSHIE_SOUND_GROUP));
            put(s, plushie);
        }
    }};

    public void onInitialize() {
        PLUSHIES.forEach((id, plushie) ->
                RegisterBlockItem(id.id, plushie));
    }

    public static void RegisterBlockItem(Identifier path, Block block) {
        Registry.register(Registries.BLOCK, path, block);
        Registry.register(Registries.ITEM, path, new BlockItem(block, new Item.Settings()));
    }
}