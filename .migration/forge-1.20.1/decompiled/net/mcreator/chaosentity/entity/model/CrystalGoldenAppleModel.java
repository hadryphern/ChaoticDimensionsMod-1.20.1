/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.resources.ResourceLocation
 *  software.bernie.geckolib.model.GeoModel
 */
package net.mcreator.chaosentity.entity.model;

import net.mcreator.chaosentity.entity.CrystalGoldenAppleEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CrystalGoldenAppleModel
extends GeoModel<CrystalGoldenAppleEntity> {
    public ResourceLocation getAnimationResource(CrystalGoldenAppleEntity entity) {
        return new ResourceLocation("chaosentitymod", "animations/crystal_apple_cow.animation.json");
    }

    public ResourceLocation getModelResource(CrystalGoldenAppleEntity entity) {
        return new ResourceLocation("chaosentitymod", "geo/crystal_apple_cow.geo.json");
    }

    public ResourceLocation getTextureResource(CrystalGoldenAppleEntity entity) {
        return new ResourceLocation("chaosentitymod", "textures/entities/" + entity.getTexture() + ".png");
    }
}

