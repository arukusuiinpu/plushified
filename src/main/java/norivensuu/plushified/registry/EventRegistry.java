package norivensuu.plushified.registry;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.registry.RegistryKey;
import norivensuu.iinpulib.util.ConditionalInitializer;
import norivensuu.plushified.Plushified;
import norivensuu.plushified.config.PlushifiedConfig;

import java.util.ArrayList;
import java.util.List;

import static norivensuu.plushified.registry.BlockRegistry.PLUSHIES;

public class EventRegistry implements ConditionalInitializer {

    public void onInitialize() {

        for(int l = 0; l < PlushifiedConfig.getHandler().instance().lootTables.size(); l++) {
            int finalL = l;
            PLUSHIES.forEach((id, plushie) -> {
                addItemToLootTable(PlushifiedConfig.getHandler().instance().lootTables.get(finalL), plushie.asItem(), 1);
            });
        }

    }

    public static void addItemToLootTable(RegistryKey<LootTable> tableId, Item item, Integer weight) {
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if (source.isBuiltin() && tableId.equals(key)) {
                tableBuilder.modifyPools(poolBuilder -> poolBuilder.with(ItemEntry.builder(item).conditionally(RandomChanceLootCondition.builder(0.005f)).weight(weight)));
            }
        });
    }
}
