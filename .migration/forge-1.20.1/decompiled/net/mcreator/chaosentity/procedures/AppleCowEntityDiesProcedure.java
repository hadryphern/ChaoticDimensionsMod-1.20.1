/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.item.ItemEntity
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.Items
 *  net.minecraft.world.level.ItemLike
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 */
package net.mcreator.chaosentity.procedures;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class AppleCowEntityDiesProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        ItemEntity entityToSpawn;
        ServerLevel _level;
        if (world instanceof ServerLevel) {
            _level = (ServerLevel)world;
            entityToSpawn = new ItemEntity((Level)_level, x, y, z, new ItemStack((ItemLike)Items.f_42410_));
            entityToSpawn.m_32010_(10);
            _level.m_7967_((Entity)entityToSpawn);
        }
        if (world instanceof ServerLevel) {
            _level = (ServerLevel)world;
            entityToSpawn = new ItemEntity((Level)_level, x, y, z, new ItemStack((ItemLike)Items.f_42579_));
            entityToSpawn.m_32010_(10);
            _level.m_7967_((Entity)entityToSpawn);
        }
        if (world instanceof ServerLevel) {
            _level = (ServerLevel)world;
            entityToSpawn = new ItemEntity((Level)_level, x, y, z, new ItemStack((ItemLike)Items.f_42579_));
            entityToSpawn.m_32010_(10);
            _level.m_7967_((Entity)entityToSpawn);
        }
        if (world instanceof ServerLevel) {
            _level = (ServerLevel)world;
            entityToSpawn = new ItemEntity((Level)_level, x, y, z, new ItemStack((ItemLike)Items.f_42454_));
            entityToSpawn.m_32010_(10);
            _level.m_7967_((Entity)entityToSpawn);
        }
        if (world instanceof ServerLevel) {
            _level = (ServerLevel)world;
            entityToSpawn = new ItemEntity((Level)_level, x, y, z, new ItemStack((ItemLike)Items.f_42454_));
            entityToSpawn.m_32010_(10);
            _level.m_7967_((Entity)entityToSpawn);
        }
    }
}

