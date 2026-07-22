/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.resources.ResourceLocation
 *  software.bernie.geckolib.model.GeoModel
 */
package net.mcreator.chaosentity.entity.model;

import net.mcreator.chaosentity.entity.AppleCowEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class AppleCowModel
extends GeoModel<AppleCowEntity> {
    public ResourceLocation getAnimationResource(AppleCowEntity entity) {
        return new ResourceLocation("chaosentitymod", "animations/apple_cow.animation.json");
    }

    public ResourceLocation getModelResource(AppleCowEntity entity) {
        return new ResourceLocation("chaosentitymod", "geo/apple_cow.geo.json");
    }

    public ResourceLocation getTextureResource(AppleCowEntity entity) {
        return new ResourceLocation("chaosentitymod", "textures/entities/" + entity.getTexture() + ".png");
    }
}

