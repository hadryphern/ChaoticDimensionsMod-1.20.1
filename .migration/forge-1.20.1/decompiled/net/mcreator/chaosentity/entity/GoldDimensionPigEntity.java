/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.protocol.Packet
 *  net.minecraft.network.protocol.game.ClientGamePacketListener
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.tags.BlockTags
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.InteractionResult
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.entity.AgeableMob
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.Entity$RemovalReason
 *  net.minecraft.world.entity.EntityDimensions
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.MobSpawnType
 *  net.minecraft.world.entity.MobType
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.Pose
 *  net.minecraft.world.entity.SpawnPlacements
 *  net.minecraft.world.entity.SpawnPlacements$Type
 *  net.minecraft.world.entity.TamableAnimal
 *  net.minecraft.world.entity.ai.attributes.AttributeSupplier$Builder
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.ai.goal.FloatGoal
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.MeleeAttackGoal
 *  net.minecraft.world.entity.ai.goal.RandomLookAroundGoal
 *  net.minecraft.world.entity.ai.goal.RandomStrollGoal
 *  net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal
 *  net.minecraft.world.entity.animal.Animal
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.Items
 *  net.minecraft.world.item.SpawnEggItem
 *  net.minecraft.world.level.ItemLike
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.levelgen.Heightmap$Types
 *  net.minecraftforge.event.ForgeEventFactory
 *  net.minecraftforge.network.NetworkHooks
 *  net.minecraftforge.network.PlayMessages$SpawnEntity
 *  net.minecraftforge.registries.ForgeRegistries
 *  software.bernie.geckolib.animatable.GeoEntity
 *  software.bernie.geckolib.core.animatable.GeoAnimatable
 *  software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache
 *  software.bernie.geckolib.core.animation.AnimatableManager$ControllerRegistrar
 *  software.bernie.geckolib.core.animation.AnimationController
 *  software.bernie.geckolib.core.animation.AnimationController$State
 *  software.bernie.geckolib.core.animation.AnimationState
 *  software.bernie.geckolib.core.animation.RawAnimation
 *  software.bernie.geckolib.core.object.PlayState
 *  software.bernie.geckolib.util.GeckoLibUtil
 */
package net.mcreator.chaosentity.entity;

import java.util.List;
import net.mcreator.chaosentity.init.ChaosentitymodModEntities;
import net.mcreator.chaosentity.init.ChaosentitymodModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.registries.ForgeRegistries;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

public class GoldDimensionPigEntity
extends TamableAnimal
implements GeoEntity {
    public static final EntityDataAccessor<Boolean> SHOOT = SynchedEntityData.m_135353_(GoldDimensionPigEntity.class, (EntityDataSerializer)EntityDataSerializers.f_135035_);
    public static final EntityDataAccessor<String> ANIMATION = SynchedEntityData.m_135353_(GoldDimensionPigEntity.class, (EntityDataSerializer)EntityDataSerializers.f_135030_);
    public static final EntityDataAccessor<String> TEXTURE = SynchedEntityData.m_135353_(GoldDimensionPigEntity.class, (EntityDataSerializer)EntityDataSerializers.f_135030_);
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache((GeoAnimatable)this);
    private boolean swinging;
    private boolean lastloop;
    private long lastSwing;
    public String animationprocedure = "empty";
    String prevAnim = "empty";

    public GoldDimensionPigEntity(PlayMessages.SpawnEntity packet, Level world) {
        this((EntityType<GoldDimensionPigEntity>)((EntityType)ChaosentitymodModEntities.GOLD_DIMENSION_PIG.get()), world);
    }

    public GoldDimensionPigEntity(EntityType<GoldDimensionPigEntity> type, Level world) {
        super(type, world);
        this.f_21364_ = 6;
        this.m_21557_(false);
        this.m_274367_(0.6f);
    }

    protected void m_8097_() {
        super.m_8097_();
        this.f_19804_.m_135372_(SHOOT, (Object)false);
        this.f_19804_.m_135372_(ANIMATION, (Object)"undefined");
        this.f_19804_.m_135372_(TEXTURE, (Object)"gold_dimension_pig_texture");
    }

    public void setTexture(String texture) {
        this.f_19804_.m_135381_(TEXTURE, (Object)texture);
    }

    public String getTexture() {
        return (String)this.f_19804_.m_135370_(TEXTURE);
    }

    public Packet<ClientGamePacketListener> m_5654_() {
        return NetworkHooks.getEntitySpawningPacket((Entity)this);
    }

    protected void m_8099_() {
        super.m_8099_();
        this.f_21345_.m_25352_(1, (Goal)new MeleeAttackGoal((PathfinderMob)this, 1.2, false){

            protected double m_6639_(LivingEntity entity) {
                return this.f_25540_.m_20205_() * this.f_25540_.m_20205_() + entity.m_20205_();
            }
        });
        this.f_21345_.m_25352_(2, (Goal)new RandomStrollGoal((PathfinderMob)this, 1.0));
        this.f_21346_.m_25352_(3, (Goal)new HurtByTargetGoal((PathfinderMob)this, new Class[0]));
        this.f_21345_.m_25352_(4, (Goal)new RandomLookAroundGoal((Mob)this));
        this.f_21345_.m_25352_(5, (Goal)new FloatGoal((Mob)this));
    }

    public MobType m_6336_() {
        return MobType.f_21640_;
    }

    protected void m_7472_(DamageSource source, int looting, boolean recentlyHitIn) {
        super.m_7472_(source, looting, recentlyHitIn);
        this.m_19983_(new ItemStack((ItemLike)ChaosentitymodModItems.GOLD_DIMENSION_APPLE.get()));
    }

    public SoundEvent m_7515_() {
        return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.pig.ambient"));
    }

    public void m_7355_(BlockPos pos, BlockState blockIn) {
        this.m_5496_((SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.pig.step")), 0.15f, 1.0f);
    }

    public SoundEvent m_7975_(DamageSource ds) {
        return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.pig.hurt"));
    }

    public SoundEvent m_5592_() {
        return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.pig.death"));
    }

    public void m_7380_(CompoundTag compound) {
        super.m_7380_(compound);
        compound.m_128359_("Texture", this.getTexture());
    }

    public void m_7378_(CompoundTag compound) {
        super.m_7378_(compound);
        if (compound.m_128441_("Texture")) {
            this.setTexture(compound.m_128461_("Texture"));
        }
    }

    public InteractionResult m_6071_(Player sourceentity, InteractionHand hand) {
        ItemStack itemstack = sourceentity.m_21120_(hand);
        InteractionResult retval = InteractionResult.m_19078_((boolean)this.m_9236_().m_5776_());
        Item item = itemstack.m_41720_();
        if (itemstack.m_41720_() instanceof SpawnEggItem) {
            retval = super.m_6071_(sourceentity, hand);
        } else if (this.m_9236_().m_5776_()) {
            retval = this.m_21824_() && this.m_21830_((LivingEntity)sourceentity) || this.m_6898_(itemstack) ? InteractionResult.m_19078_((boolean)this.m_9236_().m_5776_()) : InteractionResult.PASS;
        } else if (this.m_21824_()) {
            if (this.m_21830_((LivingEntity)sourceentity)) {
                if (item.m_41472_() && this.m_6898_(itemstack) && this.m_21223_() < this.m_21233_()) {
                    this.m_142075_(sourceentity, hand, itemstack);
                    this.m_5634_(item.m_41473_().m_38744_());
                    retval = InteractionResult.m_19078_((boolean)this.m_9236_().m_5776_());
                } else if (this.m_6898_(itemstack) && this.m_21223_() < this.m_21233_()) {
                    this.m_142075_(sourceentity, hand, itemstack);
                    this.m_5634_(4.0f);
                    retval = InteractionResult.m_19078_((boolean)this.m_9236_().m_5776_());
                } else {
                    retval = super.m_6071_(sourceentity, hand);
                }
            }
        } else if (this.m_6898_(itemstack)) {
            this.m_142075_(sourceentity, hand, itemstack);
            if (this.f_19796_.m_188503_(3) == 0 && !ForgeEventFactory.onAnimalTame((Animal)this, (Player)sourceentity)) {
                this.m_21828_(sourceentity);
                this.m_9236_().m_7605_((Entity)this, (byte)7);
            } else {
                this.m_9236_().m_7605_((Entity)this, (byte)6);
            }
            this.m_21530_();
            retval = InteractionResult.m_19078_((boolean)this.m_9236_().m_5776_());
        } else {
            retval = super.m_6071_(sourceentity, hand);
            if (retval == InteractionResult.SUCCESS || retval == InteractionResult.CONSUME) {
                this.m_21530_();
            }
        }
        return retval;
    }

    public void m_6075_() {
        super.m_6075_();
        this.m_6210_();
    }

    public EntityDimensions m_6972_(Pose p_33597_) {
        return super.m_6972_(p_33597_).m_20388_(1.0f);
    }

    public AgeableMob m_142606_(ServerLevel serverWorld, AgeableMob ageable) {
        GoldDimensionPigEntity retval = (GoldDimensionPigEntity)((EntityType)ChaosentitymodModEntities.GOLD_DIMENSION_PIG.get()).m_20615_((Level)serverWorld);
        retval.m_6518_((ServerLevelAccessor)serverWorld, serverWorld.m_6436_(retval.m_20183_()), MobSpawnType.BREEDING, null, null);
        return retval;
    }

    public boolean m_6898_(ItemStack stack) {
        return List.of(Items.f_42410_).contains(stack.m_41720_());
    }

    public void m_8107_() {
        super.m_8107_();
        this.m_21203_();
    }

    public static void init() {
        SpawnPlacements.m_21754_((EntityType)((EntityType)ChaosentitymodModEntities.GOLD_DIMENSION_PIG.get()), (SpawnPlacements.Type)SpawnPlacements.Type.ON_GROUND, (Heightmap.Types)Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (entityType, world, reason, pos, random) -> world.m_8055_(pos.m_7495_()).m_204336_(BlockTags.f_184228_) && world.m_45524_(pos, 0) > 8);
    }

    public static AttributeSupplier.Builder createAttributes() {
        AttributeSupplier.Builder builder = Mob.m_21552_();
        builder = builder.m_22268_(Attributes.f_22279_, 0.25);
        builder = builder.m_22268_(Attributes.f_22276_, 10.0);
        builder = builder.m_22268_(Attributes.f_22284_, 0.0);
        builder = builder.m_22268_(Attributes.f_22281_, 0.0);
        builder = builder.m_22268_(Attributes.f_22277_, 10.0);
        return builder;
    }

    private PlayState movementPredicate(AnimationState event) {
        if (this.animationprocedure.equals("empty")) {
            if (event.isMoving() || !(event.getLimbSwingAmount() > -0.15f) || !(event.getLimbSwingAmount() < 0.15f)) {
                return event.setAndContinue(RawAnimation.begin().thenLoop("animation.dimension_pig.walk"));
            }
            return event.setAndContinue(RawAnimation.begin().thenLoop("animation.dimension_pig.idle"));
        }
        return PlayState.STOP;
    }

    private PlayState procedurePredicate(AnimationState event) {
        if (!this.animationprocedure.equals("empty") && event.getController().getAnimationState() == AnimationController.State.STOPPED || !this.animationprocedure.equals(this.prevAnim) && !this.animationprocedure.equals("empty")) {
            if (!this.animationprocedure.equals(this.prevAnim)) {
                event.getController().forceAnimationReset();
            }
            event.getController().setAnimation(RawAnimation.begin().thenPlay(this.animationprocedure));
            if (event.getController().getAnimationState() == AnimationController.State.STOPPED) {
                this.animationprocedure = "empty";
                event.getController().forceAnimationReset();
            }
        } else if (this.animationprocedure.equals("empty")) {
            this.prevAnim = "empty";
            return PlayState.STOP;
        }
        this.prevAnim = this.animationprocedure;
        return PlayState.CONTINUE;
    }

    protected void m_6153_() {
        ++this.f_20919_;
        if (this.f_20919_ == 20) {
            this.m_142687_(Entity.RemovalReason.KILLED);
            this.m_21226_();
        }
    }

    public String getSyncedAnimation() {
        return (String)this.f_19804_.m_135370_(ANIMATION);
    }

    public void setAnimation(String animation) {
        this.f_19804_.m_135381_(ANIMATION, (Object)animation);
    }

    public void registerControllers(AnimatableManager.ControllerRegistrar data) {
        data.add(new AnimationController[]{new AnimationController((GeoAnimatable)this, "movement", 4, this::movementPredicate)});
        data.add(new AnimationController[]{new AnimationController((GeoAnimatable)this, "procedure", 4, this::procedurePredicate)});
    }

    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }
}

