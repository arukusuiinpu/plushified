package norivensuu.plushified.config;

import dev.isxander.yacl3.config.v2.api.ConfigClassHandler;
import dev.isxander.yacl3.config.v2.api.SerialEntry;
import dev.isxander.yacl3.config.v2.api.serializer.GsonConfigSerializerBuilder;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTables;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import norivensuu.plushified.Plushified;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class PlushifiedConfig {
    public static ConfigClassHandler<PlushifiedConfig> HANDLER = getHandler();

    public static ConfigClassHandler<PlushifiedConfig> getHandler() {
        ConfigClassHandler<PlushifiedConfig> handler = ConfigClassHandler.createBuilder(PlushifiedConfig.class)
                .id(Identifier.of(Plushified.MOD_ID, "plushified_config"))
                .serializer(config -> GsonConfigSerializerBuilder.create(config)
                        .setPath(FabricLoader.getInstance().getConfigDir().resolve("plushified.json5"))
                        .setJson5(true)
                        .build())
                .build();

        handler.load();
        return handler;
    }

    @SerialEntry
    public List<PlushieID> plushies = new ArrayList<>(){{
        add(PlushieID.of("4cvit", "4cvit_plushie"));
        add(PlushieID.of("8onfire", "8onfire_plushie"));
        add(PlushieID.of("_Heo_", "_heo__plushie"));
        add(PlushieID.of("Alcest_m", "alcest_m_plushie"));
        add(PlushieID.of("AlexNompe", "alexnompe_plushie"));
        add(PlushieID.of("Alfedov", "alfedov_plushie"));
        add(PlushieID.of("Alttera_", "alttera__plushie"));
        add(PlushieID.of("Antfrost", "antfrost_plushie"));
        add(PlushieID.of("Arathain", "arathain_plushie"));
        add(PlushieID.of("Arlabus", "arlabus_plushie"));
        add(PlushieID.of("Aruyuki", "aruyuki_plushie"));
        add(PlushieID.of("Asai_hatsuyo", "asai_hatsuyo_plushie"));
        add(PlushieID.of("Ashswagg", "ashswagg_plushie"));
        add(PlushieID.of("Astronyu", "astronyu_plushie"));
        add(PlushieID.of("Awesamdude", "awesamdude_plushie"));
        add(PlushieID.of("Baconnwaffles0", "baconnwaffles0_plushie"));
        add(PlushieID.of("Badboyhalo", "badboyhalo_plushie"));
        add(PlushieID.of("Barsigold", "barsigold_plushie"));
        add(PlushieID.of("BdoubleO100", "bdoubleo100_plushie"));
        add(PlushieID.of("Bez_ls", "bez_ls_plushie"));
        add(PlushieID.of("Blackhole", "blackhole_plushie"));
        add(PlushieID.of("Branzycraft", "branzycraft_plushie"));
        add(PlushieID.of("Brim", "brim_plushie"));
        add(PlushieID.of("Captainpuffy", "captainpuffy_plushie"));
        add(PlushieID.of("Capxenomorph", "capxenomorph_plushie"));
        add(PlushieID.of("Checkgoodman", "checkgoodman_plushie"));
        add(PlushieID.of("Chiefxd", "chiefxd_plushie"));
        add(PlushieID.of("Clownpierce", "clownpierce_plushie"));
        add(PlushieID.of("Connoreatspants", "connoreatspants_plushie"));
        add(PlushieID.of("Cubfan135", "cubfan135_plushie"));
        add(PlushieID.of("Deb", "deb_plushie"));
        add(PlushieID.of("Derapchu", "derapchu_plushie"));
        add(PlushieID.of("Diamkey", "diamkey_plushie"));
        add(PlushieID.of("Diansu", "diansu_plushie"));
        add(PlushieID.of("Dlz", "dlz_plushie"));
        add(PlushieID.of("Docm77", "docm77_plushie"));
        add(PlushieID.of("Doctor4t", "doctor4t_plushie"));
        add(PlushieID.of("Doubleazerosix", "doublea06_plushie"));
        add(PlushieID.of("Dream", "dream_plushie"));
        add(PlushieID.of("Durawka", "durawka_plushie"));
        add(PlushieID.of("Dushenka_", "dushenka__plushie"));
        add(PlushieID.of("Eboni", "eboni_plushie"));
        add(PlushieID.of("Ecorridor", "ecorridor_plushie"));
        add(PlushieID.of("Eightsidedsquare", "eightsidedsquare_plushie"));
        add(PlushieID.of("Eret", "eret_plushie"));
        add(PlushieID.of("Falsesymmetry", "falsesymmetry_plushie"));
        add(PlushieID.of("Faradey", "faradey_plushie"));
        add(PlushieID.of("Felikton", "felikton_plushie"));
        add(PlushieID.of("Fereden", "fereden_plushie"));
        add(PlushieID.of("Finek", "finek_plushie"));
        add(PlushieID.of("Flamefrags", "flamefrags_plushie"));
        add(PlushieID.of("Foolish", "foolish_plushie"));
        add(PlushieID.of("Fowr0", "fowr0_plushie"));
        add(PlushieID.of("Freakgenius", "freakgenius_plushie"));
        add(PlushieID.of("Fundy", "fundy_plushie"));
        add(PlushieID.of("Gel_mo", "gel_mo_plushie"));
        add(PlushieID.of("Geminitay", "geminitay_plushie"));
        add(PlushieID.of("Georgenotfound", "georgenotfound_plushie"));
        add(PlushieID.of("Goodtimeswithscar", "goodtimeswithscar_plushie"));
        add(PlushieID.of("Goose", "goose_plushie"));
        add(PlushieID.of("Grian", "grian_plushie"));
        add(PlushieID.of("Hannahxxrose", "hannahxxrose_plushie"));
        add(PlushieID.of("Hayd1_", "hayd1__plushie"));
        add(PlushieID.of("Hbomb94", "hbomb94_plushie"));
        add(PlushieID.of("Hrel_mc", "hrel_mc_plushie"));
        add(PlushieID.of("Hypnotizd", "hypnotizd_plushie"));
        add(PlushieID.of("Ijevin", "ijevin_plushie"));
        add(PlushieID.of("Impulsesv", "impulsesv_plushie"));
        add(PlushieID.of("Inaggy", "inaggy_plushie"));
        add(PlushieID.of("Iskall85", "iskall85_plushie"));
        add(PlushieID.of("Jackmanifold", "jackmanifold_plushie"));
        add(PlushieID.of("Jay_pokerman", "jay_pokerman_plushie"));
        add(PlushieID.of("Jepexx", "jepexx_plushie"));
        add(PlushieID.of("Jeremi", "jeremi_plushie"));
        add(PlushieID.of("Joehillssays", "joehillssays_plushie"));
        add(PlushieID.of("Jumperwho", "jumperwho_plushie"));
        add(PlushieID.of("Just_s", "just_s_plushie"));
        add(PlushieID.of("Justkaboodle", "justkaboodle_plushie"));
        add(PlushieID.of("Kadotanukles", "kadotanukles_plushie"));
        add(PlushieID.of("Karljacobs", "karljacobs_plushie"));
        add(PlushieID.of("Kavkin", "kavkin_plushie"));
        add(PlushieID.of("Keralis", "keralis_plushie"));
        add(PlushieID.of("Ketrincyst", "ketrincyst_plushie"));
        add(PlushieID.of("Kiricattus", "kiricattus_plushie"));
        add(PlushieID.of("Klashraick", "klashraick_plushie"));
        add(PlushieID.of("Kluv_v", "kluv_v_plushie"));
        add(PlushieID.of("Krolikmun", "krolikmun_plushie"));
        add(PlushieID.of("Lampcat", "lampcat_plushie"));
        add(PlushieID.of("Leow0ok", "leow0ok_plushie"));
        add(PlushieID.of("Lordsantos", "lordsantos_plushie"));
        add(PlushieID.of("Lux", "lux_plushie"));
        add(PlushieID.of("M_mafinev", "m_mafinev_plushie"));
        add(PlushieID.of("Magmustx", "magmustx_plushie"));
        add(PlushieID.of("Makafolz", "makafolz_plushie"));
        add(PlushieID.of("Manepear", "manepear_plushie"));
        add(PlushieID.of("Mapicc", "mapicc_plushie"));
        add(PlushieID.of("Martscomm", "martscomm_plushie"));
        add(PlushieID.of("Mask", "mask_plushie"));
        add(PlushieID.of("Michaelmcchill", "michaelmcchill_plushie"));
        add(PlushieID.of("Minutetech", "minutetech_plushie"));
        add(PlushieID.of("Mo1vine", "mo1vine_plushie"));
        add(PlushieID.of("Moddy", "moddy_plushie"));
        add(PlushieID.of("Moriyashiine", "moriyashiine_plushie"));
        add(PlushieID.of("Mrcube6", "mrcube6_plushie"));
        add(PlushieID.of("Mrpupe", "mrpupe_plushie"));
        add(PlushieID.of("Mumbojumbo", "mumbojumbo_plushie"));
        add(PlushieID.of("Nagibayka", "nagibayka_plushie"));
        add(PlushieID.of("Neadaptar", "neadaptar_plushie"));
        add(PlushieID.of("Nerkin_", "nerkin__plushie"));
        add(PlushieID.of("Nihachu", "nihachu_plushie"));
        add(PlushieID.of("Niki", "niki_plushie"));
        add(PlushieID.of("Novikony", "novikony_plushie"));
        add(PlushieID.of("Noxintrus", "noxintrus_plushie"));
        add(PlushieID.of("Nurofen", "nurofen_plushie"));
        add(PlushieID.of("Obsi", "obsi_plushie"));
        add(PlushieID.of("Olyachesapik", "olyachesapik_plushie"));
        add(PlushieID.of("Optimist_ezz", "optimist_ezz_plushie"));
        add(PlushieID.of("Pangi", "pangi_plushie"));
        add(PlushieID.of("Pearlescentmoon", "pearlescentmoon_plushie"));
        add(PlushieID.of("Peentar", "peentar_plushie"));
        add(PlushieID.of("Philza", "philza_plushie"));
        add(PlushieID.of("Planetlord", "planetlord_plushie"));
        add(PlushieID.of("Ponk", "ponk_plushie"));
        add(PlushieID.of("Princezam", "princezam_plushie"));
        add(PlushieID.of("Purpled", "purpled_plushie"));
        add(PlushieID.of("Pwgoood", "pwgoood_plushie"));
        add(PlushieID.of("Quackity", "quackity_plushie"));
        add(PlushieID.of("R4tmaid", "r4tmaid_plushie"));
        add(PlushieID.of("Ranboo", "ranboo_plushie"));
        add(PlushieID.of("Reddoons", "reddoons_plushie"));
        add(PlushieID.of("Rendog", "rendog_plushie"));
        add(PlushieID.of("Resota", "resota_plushie"));
        add(PlushieID.of("Roshambogames", "roshambogames_plushie"));
        add(PlushieID.of("Sanchez", "sanhez_plushie"));
        add(PlushieID.of("Sapnap", "sapnap_plushie"));
        add(PlushieID.of("Sb737", "sb737_plushie"));
        add(PlushieID.of("Secb", "secb_plushie"));
        add(PlushieID.of("Sillviatv", "sillviatv_plushie"));
        add(PlushieID.of("Sirpiligrim", "sirpiligrim_plushie"));
        add(PlushieID.of("Skeppy", "skeppy_plushie"));
        add(PlushieID.of("Skizzleman", "skizzleman_plushie"));
        add(PlushieID.of("Slovenof", "slovenof_plushie"));
        add(PlushieID.of("Smallishbeans", "smallishbeans_plushie"));
        add(PlushieID.of("Smmassh", "smmassh_plushie"));
        add(PlushieID.of("Sneegsnag", "sneegsnag_plushie"));
        add(PlushieID.of("Snrgiraffe", "snrgiraffe_plushie"));
        add(PlushieID.of("Spepticle", "spepticle_plushie"));
        add(PlushieID.of("Spokeishere", "spokeishere_plushie"));
        add(PlushieID.of("Squiddo", "squiddo_plushie"));
        add(PlushieID.of("Stalin", "stalin_plushie"));
        add(PlushieID.of("Stressmonster101", "stressmonster101_plushie"));
        add(PlushieID.of("Talon", "talon_plushie"));
        add(PlushieID.of("Tangotek", "tangotek_plushie"));
        add(PlushieID.of("Techno", "techno_plushie"));
        add(PlushieID.of("Theklyde", "theklyde_plushie"));
        add(PlushieID.of("Theterrain", "theterrain_plushie"));
        add(PlushieID.of("Tommyinnit", "tommyinnit_plushie"));
        add(PlushieID.of("Tubbo", "tubbo_plushie"));
        add(PlushieID.of("Tuviku", "tuviku_plushie"));
        add(PlushieID.of("Vacmakac", "vacmakac_plushie"));
        add(PlushieID.of("Venazar", "venazar_plushie"));
        add(PlushieID.of("Verylouder", "verylouder_plushie"));
        add(PlushieID.of("Vikkstar123", "vikkstar123_plushie"));
        add(PlushieID.of("Vintagebeef", "vintagebeef_plushie"));
        add(PlushieID.of("Vipsss", "vipsss_plushie"));
        add(PlushieID.of("Vmuted", "vmuted_plushie"));
        add(PlushieID.of("Vort3xdragon", "vort3xdragon_plushie"));
        add(PlushieID.of("Wemmbu", "wemmbu_plushie"));
        add(PlushieID.of("Wilbursoot", "wilbursoot_plushie"));
        add(PlushieID.of("Winsweep", "winsweep_plushie"));
        add(PlushieID.of("Woogiex", "woogiex_plushie"));
        add(PlushieID.of("Xbcrafted", "xbcrafted_plushie"));
        add(PlushieID.of("Xisuma", "xisuma_plushie"));
        add(PlushieID.of("Yahiamice", "yahiamice_plushie"));
        add(PlushieID.of("Yeah_jaron", "yeah_jaron_plushie"));
        add(PlushieID.of("Zakviel", "zakviel_plushie"));
        add(PlushieID.of("Zedaph", "zedaph_plushie"));
        add(PlushieID.of("Zmeec", "zmeec_plushie"));
        add(PlushieID.of("Zmeevig", "zmeevig_plushie"));
        add(PlushieID.of("Zombiecleo", "zombiecleo_plushie"));
    }};

    public static class PlushieID {
        public String nickname;
        public Identifier id;

        public PlushieID (String nickname, Identifier id) {
            this.nickname = nickname;
            this.id = id;
        }
        public PlushieID (String nickname, String id) {
            this.nickname = nickname;
            this.id = Identifier.of(Plushified.MOD_ID, id);
        }
        public PlushieID() {
        }

        public static PlushieID of (String nickname, String id) {
            return new PlushieID(nickname, id);
        }

        public static PlushieID of (String nickname, Identifier id) {
            return new PlushieID(nickname, id);
        }
    }

    @SerialEntry
    public List<RegistryKey<LootTable>> lootTables = new ArrayList<>(){{
        add(LootTables.SPAWN_BONUS_CHEST);
        add(LootTables.ABANDONED_MINESHAFT_CHEST);
        add(LootTables.ANCIENT_CITY_CHEST);
        add(LootTables.ANCIENT_CITY_ICE_BOX_CHEST);
        add(LootTables.BASTION_BRIDGE_CHEST);
        add(LootTables.BASTION_HOGLIN_STABLE_CHEST);
        add(LootTables.BASTION_OTHER_CHEST);
        add(LootTables.BASTION_TREASURE_CHEST);
        add(LootTables.BURIED_TREASURE_CHEST);
        add(LootTables.CAT_MORNING_GIFT_GAMEPLAY);
        add(LootTables.DESERT_PYRAMID_ARCHAEOLOGY);
        add(LootTables.DESERT_PYRAMID_CHEST);
        add(LootTables.DESERT_WELL_ARCHAEOLOGY);
        add(LootTables.END_CITY_TREASURE_CHEST);
        add(LootTables.FISHING_TREASURE_GAMEPLAY);
        add(LootTables.FISHING_GAMEPLAY);
        add(LootTables.FISHING_FISH_GAMEPLAY);
        add(LootTables.FISHING_JUNK_GAMEPLAY);
        add(LootTables.HERO_OF_THE_VILLAGE_ARMORER_GIFT_GAMEPLAY);
        add(LootTables.HERO_OF_THE_VILLAGE_BUTCHER_GIFT_GAMEPLAY);
        add(LootTables.HERO_OF_THE_VILLAGE_CARTOGRAPHER_GIFT_GAMEPLAY);
        add(LootTables.HERO_OF_THE_VILLAGE_CLERIC_GIFT_GAMEPLAY);
        add(LootTables.HERO_OF_THE_VILLAGE_FARMER_GIFT_GAMEPLAY);
        add(LootTables.HERO_OF_THE_VILLAGE_FISHERMAN_GIFT_GAMEPLAY);
        add(LootTables.HERO_OF_THE_VILLAGE_FLETCHER_GIFT_GAMEPLAY);
        add(LootTables.HERO_OF_THE_VILLAGE_LEATHERWORKER_GIFT_GAMEPLAY);
        add(LootTables.HERO_OF_THE_VILLAGE_LIBRARIAN_GIFT_GAMEPLAY);
        add(LootTables.HERO_OF_THE_VILLAGE_MASON_GIFT_GAMEPLAY);
        add(LootTables.HERO_OF_THE_VILLAGE_SHEPHERD_GIFT_GAMEPLAY);
        add(LootTables.HERO_OF_THE_VILLAGE_TOOLSMITH_GIFT_GAMEPLAY);
        add(LootTables.HERO_OF_THE_VILLAGE_WEAPONSMITH_GIFT_GAMEPLAY);
        add(LootTables.IGLOO_CHEST_CHEST);
        add(LootTables.JUNGLE_TEMPLE_CHEST);
        add(LootTables.JUNGLE_TEMPLE_DISPENSER_CHEST);
        add(LootTables.NETHER_BRIDGE_CHEST);
        add(LootTables.OCEAN_RUIN_COLD_ARCHAEOLOGY);
        add(LootTables.OCEAN_RUIN_WARM_ARCHAEOLOGY);
        add(LootTables.PIGLIN_BARTERING_GAMEPLAY);
        add(LootTables.PILLAGER_OUTPOST_CHEST);
        add(LootTables.RUINED_PORTAL_CHEST);
        add(LootTables.SHIPWRECK_MAP_CHEST);
        add(LootTables.SHIPWRECK_SUPPLY_CHEST);
        add(LootTables.SHIPWRECK_TREASURE_CHEST);
        add(LootTables.SIMPLE_DUNGEON_CHEST);
        add(LootTables.SNIFFER_DIGGING_GAMEPLAY);
        add(LootTables.STRONGHOLD_CORRIDOR_CHEST);
        add(LootTables.STRONGHOLD_CROSSING_CHEST);
        add(LootTables.STRONGHOLD_LIBRARY_CHEST);
        add(LootTables.TRAIL_RUINS_COMMON_ARCHAEOLOGY);
        add(LootTables.TRAIL_RUINS_RARE_ARCHAEOLOGY);
        add(LootTables.TRIAL_CHAMBERS_INTERSECTION_BARREL_CHEST);
        add(LootTables.UNDERWATER_RUIN_BIG_CHEST);
        add(LootTables.UNDERWATER_RUIN_SMALL_CHEST);
        add(LootTables.VILLAGE_ARMORER_CHEST);
        add(LootTables.VILLAGE_BUTCHER_CHEST);
        add(LootTables.VILLAGE_CARTOGRAPHER_CHEST);
        add(LootTables.VILLAGE_FISHER_CHEST);
        add(LootTables.VILLAGE_DESERT_HOUSE_CHEST);
        add(LootTables.VILLAGE_FLETCHER_CHEST);
        add(LootTables.VILLAGE_MASON_CHEST);
        add(LootTables.VILLAGE_PLAINS_CHEST);
        add(LootTables.VILLAGE_SAVANNA_HOUSE_CHEST);
        add(LootTables.VILLAGE_SHEPARD_CHEST);
        add(LootTables.VILLAGE_SNOWY_HOUSE_CHEST);
        add(LootTables.VILLAGE_TAIGA_HOUSE_CHEST);
        add(LootTables.VILLAGE_TANNERY_CHEST);
        add(LootTables.VILLAGE_TEMPLE_CHEST);
        add(LootTables.VILLAGE_TOOLSMITH_CHEST);
        add(LootTables.VILLAGE_WEAPONSMITH_CHEST);
        add(LootTables.WOODLAND_MANSION_CHEST);
    }};
}
