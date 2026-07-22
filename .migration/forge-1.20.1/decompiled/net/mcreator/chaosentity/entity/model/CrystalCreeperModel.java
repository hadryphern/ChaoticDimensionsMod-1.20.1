/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.resources.ResourceLocation
 *  software.bernie.geckolib.model.GeoModel
 */
package net.mcreator.chaosentity.entity.model;

import net.mcreator.chaosentity.entity.CrystalCreeperEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CrystalCreeperModel
extends GeoModel<CrystalCreeperEntity> {
    public ResourceLocation getAnimationResource(CrystalCreeperEntity entity) {
        return new ResourceLocation("chaosentitymod", "animations/crystal_creeper.animation.json");
    }

    public ResourceLocation getModelResource(CrystalCreeperEntity entity) {
        return new ResourceLocation("chaosentitymod", "geo/crystal_creeper.geo.json");
    }

    public ResourceLocation getTextureResource(CrystalCreeperEntity entity) {
        return new ResourceLocation("chaosentitymod", "textures/entities/" + entity.getTexture() + ".png");
    }
}

