/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.EntityType$Builder
 *  net.minecraft.world.entity.MobCategory
 *  net.minecraftforge.event.entity.EntityAttributeCreationEvent
 *  net.minecraftforge.eventbus.api.SubscribeEvent
 *  net.minecraftforge.fml.common.Mod$EventBusSubscriber
 *  net.minecraftforge.fml.common.Mod$EventBusSubscriber$Bus
 *  net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent
 *  net.minecraftforge.registries.DeferredRegister
 *  net.minecraftforge.registries.ForgeRegistries
 *  net.minecraftforge.registries.IForgeRegistry
 *  net.minecraftforge.registries.RegistryObject
 */
package net.mcreator.chaosentity.init;

import net.mcreator.chaosentity.entity.AppleCowEntity;
import net.mcreator.chaosentity.entity.CrystalAppleCowEntity;
import net.mcreator.chaosentity.entity.CrystalCreeperEntity;
import net.mcreator.chaosentity.entity.CrystalGoldenAppleEntity;
import net.mcreator.chaosentity.entity.DimensionPigEntity;
import net.mcreator.chaosentity.entity.GoldDimensionPigEntity;
import net.mcreator.chaosentity.entity.GoldenAppleCowEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class ChaosentitymodModEntities {
    public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create((IForgeRegistry)ForgeRegistries.ENTITY_TYPES, (String)"chaosentitymod");
    public static final RegistryObject<EntityType<DimensionPigEntity>> DIMENSION_PIG = ChaosentitymodModEntities.register("dimension_pig", EntityType.Builder.m_20704_(DimensionPigEntity::new, (MobCategory)MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(10).setUpdateInterval(3).setCustomClientFactory(DimensionPigEntity::new).m_20699_(0.6f, 1.8f));
    public static final RegistryObject<EntityType<GoldDimensionPigEntity>> GOLD_DIMENSION_PIG = ChaosentitymodModEntities.register("gold_dimension_pig", EntityType.Builder.m_20704_(GoldDimensionPigEntity::new, (MobCategory)MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(10).setUpdateInterval(3).setCustomClientFactory(GoldDimensionPigEntity::new).m_20699_(0.6f, 1.8f));
    public static final RegistryObject<EntityType<AppleCowEntity>> APPLE_COW = ChaosentitymodModEntities.register("apple_cow", EntityType.Builder.m_20704_(AppleCowEntity::new, (MobCategory)MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(AppleCowEntity::new).m_20699_(0.6f, 1.8f));
    public static final RegistryObject<EntityType<GoldenAppleCowEntity>> GOLDEN_APPLE_COW = ChaosentitymodModEntities.register("golden_apple_cow", EntityType.Builder.m_20704_(GoldenAppleCowEntity::new, (MobCategory)MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(GoldenAppleCowEntity::new).m_20699_(0.6f, 1.8f));
    public static final RegistryObject<EntityType<CrystalCreeperEntity>> CRYSTAL_CREEPER = ChaosentitymodModEntities.register("crystal_creeper", EntityType.Builder.m_20704_(CrystalCreeperEntity::new, (MobCategory)MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CrystalCreeperEntity::new).m_20699_(0.6f, 1.8f));
    public static final RegistryObject<EntityType<CrystalAppleCowEntity>> CRYSTAL_APPLE_COW = ChaosentitymodModEntities.register("crystal_apple_cow", EntityType.Builder.m_20704_(CrystalAppleCowEntity::new, (MobCategory)MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CrystalAppleCowEntity::new).m_20699_(0.6f, 1.8f));
    public static final RegistryObject<EntityType<CrystalGoldenAppleEntity>> CRYSTAL_GOLDEN_APPLE = ChaosentitymodModEntities.register("crystal_golden_apple", EntityType.Builder.m_20704_(CrystalGoldenAppleEntity::new, (MobCategory)MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CrystalGoldenAppleEntity::new).m_20699_(0.6f, 1.8f));

    private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
        return REGISTRY.register(registryname, () -> entityTypeBuilder.m_20712_(registryname));
    }

    @SubscribeEvent
    public static void init(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            DimensionPigEntity.init();
            GoldDimensionPigEntity.init();
            AppleCowEntity.init();
            GoldenAppleCowEntity.init();
            CrystalCreeperEntity.init();
            CrystalAppleCowEntity.init();
            CrystalGoldenAppleEntity.init();
        });
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put((EntityType)DIMENSION_PIG.get(), DimensionPigEntity.m_29503_().m_22265_());
        event.put((EntityType)GOLD_DIMENSION_PIG.get(), GoldDimensionPigEntity.createAttributes().m_22265_());
        event.put((EntityType)APPLE_COW.get(), AppleCowEntity.m_28307_().m_22265_());
        event.put((EntityType)GOLDEN_APPLE_COW.get(), GoldenAppleCowEntity.m_28307_().m_22265_());
        event.put((EntityType)CRYSTAL_CREEPER.get(), CrystalCreeperEntity.m_32318_().m_22265_());
        event.put((EntityType)CRYSTAL_APPLE_COW.get(), CrystalAppleCowEntity.m_28307_().m_22265_());
        event.put((EntityType)CRYSTAL_GOLDEN_APPLE.get(), CrystalGoldenAppleEntity.m_28307_().m_22265_());
    }
}

