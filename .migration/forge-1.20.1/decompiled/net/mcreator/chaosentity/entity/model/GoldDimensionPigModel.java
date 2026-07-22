/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.resources.ResourceLocation
 *  software.bernie.geckolib.model.GeoModel
 */
package net.mcreator.chaosentity.entity.model;

import net.mcreator.chaosentity.entity.GoldDimensionPigEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class GoldDimensionPigModel
extends GeoModel<GoldDimensionPigEntity> {
    public ResourceLocation getAnimationResource(GoldDimensionPigEntity entity) {
        return new ResourceLocation("chaosentitymod", "animations/dimension_pig.animation.json");
    }

    public ResourceLocation getModelResource(GoldDimensionPigEntity entity) {
        return new ResourceLocation("chaosentitymod", "geo/dimension_pig.geo.json");
    }

    public ResourceLocation getTextureResource(GoldDimensionPigEntity entity) {
        return new ResourceLocation("chaosentitymod", "textures/entities/" + entity.getTexture() + ".png");
    }
}

