package norivensuu.plushified.client.config;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import dev.isxander.yacl3.api.*;
import dev.isxander.yacl3.api.controller.BooleanControllerBuilder;
import dev.isxander.yacl3.api.controller.IntegerFieldControllerBuilder;
import net.minecraft.text.Text;

import static norivensuu.plushified.config.PlushifiedConfig.HANDLER;

public class ModMenuIntegration implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return parentScreen -> YetAnotherConfigLib.createBuilder()
                .title(Text.translatable("text.config.plushified.title"))
                .category(ConfigCategory.createBuilder()
                        .name(Text.translatable("text.config.plushified.category.general"))
                        .tooltip(Text.translatable("text.config.plushified.category.general.@Tooltip"))
                        .build())
                .save(this::save)
                .build()
                .generateScreen(parentScreen);
    }

    public void save() {
        HANDLER.save();
    }
}