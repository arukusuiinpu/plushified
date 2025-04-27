package net.plushified.registry;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.item.Item;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.condition.LootCondition;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.context.LootContextType;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.entry.LootTableEntry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.LootNumberProvider;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.plushified.Plushified;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import static net.plushified.registry.BlockRegistry.*;

public class EventRegistry {

    public static List<Identifier> LOOT_TABLES = new ArrayList<Identifier>();

    private static void addNecessaryLootTables() {
        LOOT_TABLES.add(LootTables.SPAWN_BONUS_CHEST);
        LOOT_TABLES.add(LootTables.ABANDONED_MINESHAFT_CHEST);
        LOOT_TABLES.add(LootTables.ANCIENT_CITY_CHEST);
        LOOT_TABLES.add(LootTables.ANCIENT_CITY_ICE_BOX_CHEST);
        LOOT_TABLES.add(LootTables.BASTION_BRIDGE_CHEST);
        LOOT_TABLES.add(LootTables.BASTION_HOGLIN_STABLE_CHEST);
        LOOT_TABLES.add(LootTables.BASTION_OTHER_CHEST);
        LOOT_TABLES.add(LootTables.BASTION_TREASURE_CHEST);
        LOOT_TABLES.add(LootTables.BURIED_TREASURE_CHEST);
        LOOT_TABLES.add(LootTables.CAT_MORNING_GIFT_GAMEPLAY);
        LOOT_TABLES.add(LootTables.DESERT_PYRAMID_ARCHAEOLOGY);
        LOOT_TABLES.add(LootTables.DESERT_PYRAMID_CHEST);
        LOOT_TABLES.add(LootTables.DESERT_WELL_ARCHAEOLOGY);
        LOOT_TABLES.add(LootTables.END_CITY_TREASURE_CHEST);
        LOOT_TABLES.add(LootTables.FISHING_TREASURE_GAMEPLAY);
        LOOT_TABLES.add(LootTables.FISHING_GAMEPLAY);
        LOOT_TABLES.add(LootTables.FISHING_FISH_GAMEPLAY);
        LOOT_TABLES.add(LootTables.FISHING_JUNK_GAMEPLAY);
        LOOT_TABLES.add(LootTables.HERO_OF_THE_VILLAGE_ARMORER_GIFT_GAMEPLAY);
        LOOT_TABLES.add(LootTables.HERO_OF_THE_VILLAGE_BUTCHER_GIFT_GAMEPLAY);
        LOOT_TABLES.add(LootTables.HERO_OF_THE_VILLAGE_CARTOGRAPHER_GIFT_GAMEPLAY);
        LOOT_TABLES.add(LootTables.HERO_OF_THE_VILLAGE_CLERIC_GIFT_GAMEPLAY);
        LOOT_TABLES.add(LootTables.HERO_OF_THE_VILLAGE_FARMER_GIFT_GAMEPLAY);
        LOOT_TABLES.add(LootTables.HERO_OF_THE_VILLAGE_FISHERMAN_GIFT_GAMEPLAY);
        LOOT_TABLES.add(LootTables.HERO_OF_THE_VILLAGE_FLETCHER_GIFT_GAMEPLAY);
        LOOT_TABLES.add(LootTables.HERO_OF_THE_VILLAGE_LEATHERWORKER_GIFT_GAMEPLAY);
        LOOT_TABLES.add(LootTables.HERO_OF_THE_VILLAGE_LIBRARIAN_GIFT_GAMEPLAY);
        LOOT_TABLES.add(LootTables.HERO_OF_THE_VILLAGE_MASON_GIFT_GAMEPLAY);
        LOOT_TABLES.add(LootTables.HERO_OF_THE_VILLAGE_SHEPHERD_GIFT_GAMEPLAY);
        LOOT_TABLES.add(LootTables.HERO_OF_THE_VILLAGE_TOOLSMITH_GIFT_GAMEPLAY);
        LOOT_TABLES.add(LootTables.HERO_OF_THE_VILLAGE_WEAPONSMITH_GIFT_GAMEPLAY);
        LOOT_TABLES.add(LootTables.IGLOO_CHEST_CHEST);
        LOOT_TABLES.add(LootTables.JUNGLE_TEMPLE_CHEST);
        LOOT_TABLES.add(LootTables.JUNGLE_TEMPLE_DISPENSER_CHEST);
        LOOT_TABLES.add(LootTables.NETHER_BRIDGE_CHEST);
        LOOT_TABLES.add(LootTables.OCEAN_RUIN_COLD_ARCHAEOLOGY);
        LOOT_TABLES.add(LootTables.OCEAN_RUIN_WARM_ARCHAEOLOGY);
        LOOT_TABLES.add(LootTables.PIGLIN_BARTERING_GAMEPLAY);
        LOOT_TABLES.add(LootTables.PILLAGER_OUTPOST_CHEST);
        LOOT_TABLES.add(LootTables.RUINED_PORTAL_CHEST);
        LOOT_TABLES.add(LootTables.SHIPWRECK_MAP_CHEST);
        LOOT_TABLES.add(LootTables.SHIPWRECK_SUPPLY_CHEST);
        LOOT_TABLES.add(LootTables.SHIPWRECK_TREASURE_CHEST);
        LOOT_TABLES.add(LootTables.SIMPLE_DUNGEON_CHEST);
        LOOT_TABLES.add(LootTables.SNIFFER_DIGGING_GAMEPLAY);
        LOOT_TABLES.add(LootTables.STRONGHOLD_CORRIDOR_CHEST);
        LOOT_TABLES.add(LootTables.STRONGHOLD_CROSSING_CHEST);
        LOOT_TABLES.add(LootTables.STRONGHOLD_LIBRARY_CHEST);
        LOOT_TABLES.add(LootTables.TRAIL_RUINS_COMMON_ARCHAEOLOGY);
        LOOT_TABLES.add(LootTables.TRAIL_RUINS_RARE_ARCHAEOLOGY);
        LOOT_TABLES.add(LootTables.UNDERWATER_RUIN_BIG_CHEST);
        LOOT_TABLES.add(LootTables.UNDERWATER_RUIN_SMALL_CHEST);
        LOOT_TABLES.add(LootTables.VILLAGE_ARMORER_CHEST);
        LOOT_TABLES.add(LootTables.VILLAGE_BUTCHER_CHEST);
        LOOT_TABLES.add(LootTables.VILLAGE_CARTOGRAPHER_CHEST);
        LOOT_TABLES.add(LootTables.VILLAGE_FISHER_CHEST);
        LOOT_TABLES.add(LootTables.VILLAGE_DESERT_HOUSE_CHEST);
        LOOT_TABLES.add(LootTables.VILLAGE_FLETCHER_CHEST);
        LOOT_TABLES.add(LootTables.VILLAGE_MASON_CHEST);
        LOOT_TABLES.add(LootTables.VILLAGE_PLAINS_CHEST);
        LOOT_TABLES.add(LootTables.VILLAGE_SAVANNA_HOUSE_CHEST);
        LOOT_TABLES.add(LootTables.VILLAGE_SHEPARD_CHEST);
        LOOT_TABLES.add(LootTables.VILLAGE_SNOWY_HOUSE_CHEST);
        LOOT_TABLES.add(LootTables.VILLAGE_TAIGA_HOUSE_CHEST);
        LOOT_TABLES.add(LootTables.VILLAGE_TANNERY_CHEST);
        LOOT_TABLES.add(LootTables.VILLAGE_TEMPLE_CHEST);
        LOOT_TABLES.add(LootTables.VILLAGE_TOOLSMITH_CHEST);
        LOOT_TABLES.add(LootTables.VILLAGE_WEAPONSMITH_CHEST);
        LOOT_TABLES.add(LootTables.WOODLAND_MANSION_CHEST);
    }

    public static void registering() {
        Plushified.LOGGER.info("OMG! Event registry...");

        addNecessaryLootTables();

        for(int l = 0; l < LOOT_TABLES.size(); l++) {
            for(int i = 0; i < PLUSHIES.length; i++) {
                addItemToLootTable(LOOT_TABLES.get(l), PLUSHIES[i].asItem(), 1);
                //Plushified.LOGGER.info("DEBUG! Adding "+PLUSHIES[i].toString()+" to "+LOOT_TABLES.get(l).toString());
            }
        }

    }

    public static void addItemToLootTable(Identifier tableId, Item item, Integer weight) {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (tableId.equals(id)) {
                tableBuilder.modifyPools(poolBuilder -> poolBuilder.with(ItemEntry.builder(item).conditionally(RandomChanceLootCondition.builder(0.005f)).weight(weight)));
            }
        });
    }
}
