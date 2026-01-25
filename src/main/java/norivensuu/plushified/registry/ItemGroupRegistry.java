package norivensuu.plushified.registry;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import norivensuu.iinpulib.util.ConditionalInitializer;
import norivensuu.plushified.Plushified;

import static norivensuu.plushified.registry.BlockRegistry.*;

public class ItemGroupRegistry implements ConditionalInitializer {
    private static final ItemGroup PLUSHIES_ITEMGROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(PLUSHIES.values().stream().findFirst().get()))
            .displayName(Text.translatable("itemGroup."+ Plushified.MOD_ID+".plushies"))
            .entries((context, entries) -> PLUSHIES.forEach((id, plushie) ->
                    entries.add(plushie)
            ))
            .build();

    public void onInitialize() {
        Registry.register(Registries.ITEM_GROUP, Identifier.of(Plushified.MOD_ID, "plushies"), PLUSHIES_ITEMGROUP);
    }
}
