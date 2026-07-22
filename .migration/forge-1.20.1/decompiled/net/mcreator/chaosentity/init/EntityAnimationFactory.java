/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraftforge.event.entity.living.LivingEvent$LivingTickEvent
 *  net.minecraftforge.eventbus.api.SubscribeEvent
 *  net.minecraftforge.fml.common.Mod$EventBusSubscriber
 *  software.bernie.geckolib.animatable.GeoEntity
 */
package net.mcreator.chaosentity.init;

import net.mcreator.chaosentity.entity.AppleCowEntity;
import net.mcreator.chaosentity.entity.CrystalAppleCowEntity;
import net.mcreator.chaosentity.entity.CrystalCreeperEntity;
import net.mcreator.chaosentity.entity.CrystalGoldenAppleEntity;
import net.mcreator.chaosentity.entity.DimensionPigEntity;
import net.mcreator.chaosentity.entity.GoldDimensionPigEntity;
import net.mcreator.chaosentity.entity.GoldenAppleCowEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import software.bernie.geckolib.animatable.GeoEntity;

@Mod.EventBusSubscriber
public class EntityAnimationFactory {
    @SubscribeEvent
    public static void onEntityTick(LivingEvent.LivingTickEvent event) {
        if (event != null && event.getEntity() != null) {
            GeoEntity syncable;
            Object animation;
            LivingEntity livingEntity = event.getEntity();
            if (livingEntity instanceof DimensionPigEntity && !((String)(animation = (syncable = (DimensionPigEntity)livingEntity).getSyncedAnimation())).equals("undefined")) {
                syncable.setAnimation("undefined");
                syncable.animationprocedure = animation;
            }
            if ((animation = event.getEntity()) instanceof GoldDimensionPigEntity && !((String)(animation = (syncable = (GoldDimensionPigEntity)((Object)animation)).getSyncedAnimation())).equals("undefined")) {
                syncable.setAnimation("undefined");
                syncable.animationprocedure = animation;
            }
            if ((animation = event.getEntity()) instanceof AppleCowEntity && !((String)(animation = (syncable = (AppleCowEntity)((Object)animation)).getSyncedAnimation())).equals("undefined")) {
                syncable.setAnimation("undefined");
                syncable.animationprocedure = animation;
            }
            if ((animation = event.getEntity()) instanceof GoldenAppleCowEntity && !((String)(animation = (syncable = (GoldenAppleCowEntity)((Object)animation)).getSyncedAnimation())).equals("undefined")) {
                syncable.setAnimation("undefined");
                syncable.animationprocedure = animation;
            }
            if ((animation = event.getEntity()) instanceof CrystalCreeperEntity && !((String)(animation = (syncable = (CrystalCreeperEntity)((Object)animation)).getSyncedAnimation())).equals("undefined")) {
                syncable.setAnimation("undefined");
                syncable.animationprocedure = animation;
            }
            if ((animation = event.getEntity()) instanceof CrystalAppleCowEntity && !((String)(animation = (syncable = (CrystalAppleCowEntity)((Object)animation)).getSyncedAnimation())).equals("undefined")) {
                syncable.setAnimation("undefined");
                syncable.animationprocedure = animation;
            }
            if ((animation = event.getEntity()) instanceof CrystalGoldenAppleEntity && !((String)(animation = (syncable = (CrystalGoldenAppleEntity)((Object)animation)).getSyncedAnimation())).equals("undefined")) {
                syncable.setAnimation("undefined");
                syncable.animationprocedure = animation;
            }
        }
    }
}

