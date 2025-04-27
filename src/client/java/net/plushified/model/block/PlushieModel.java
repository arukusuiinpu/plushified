package net.plushified.model.block;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.util.Identifier;
import net.plushified.Plushified;
import net.plushified.block.entity.PlushieBlockEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.model.GeoModel;

public class PlushieModel<T extends GeoAnimatable> extends GeoModel<T> {
    private final Identifier model;
    private final Identifier texture;
    private final Identifier animations;

    public PlushieModel(Identifier assetSubpath) {
        this.model = buildFormattedModelPath(assetSubpath);
        this.texture = buildFormattedTexturePath(assetSubpath);
        this.animations = buildFormattedAnimationPath(assetSubpath);
    }

    public Identifier buildFormattedModelPath(Identifier basePath) {
        return Identifier.of(basePath.getNamespace(),"geo/block/" + basePath.getPath() + ".geo.json");
    }

    public Identifier buildFormattedAnimationPath(Identifier basePath) {
        return Identifier.of(basePath.getNamespace(),"animations/block/plushie.animation.json");
    }

    public Identifier buildFormattedTexturePath(Identifier basePath) {
        return Identifier.of(basePath.getNamespace(),"textures/block/" + basePath.getPath() + ".png");
    }

    @Override
    public Identifier getModelResource(T animatable) {
        return this.model;
    }

    @Override
    public Identifier getTextureResource(T animatable) {
        return this.texture;
    }

    @Override
    public Identifier getAnimationResource(T animatable) {
        return this.animations;
    }
}
