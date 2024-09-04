/*
 * This file is part of the CarpetPatcher project, licensed under the
 * GNU Lesser General Public License v3.0
 *
 * Copyright (C) 2024  WenDavid and contributors
 *
 * CarpetPatcher is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * CarpetPatcher is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with CarpetPatcher.  If not, see <https://www.gnu.org/licenses/>.
 */

package club.mcams.carpetpatcher.mixins.fakePlayerCrashing;

import carpet.patches.EntityPlayerMPFake;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import com.mojang.authlib.GameProfile;
import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

@Mixin(value = EntityPlayerMPFake.class, remap = false)
public class EntityPlayerMPFakeMixin {
//    @WrapMethod(
//            method = "createFake"
//    )
//    private static EntityPlayerMPFake createFake(String username, MinecraftServer server, double d0, double d1, double d2, double yaw, double pitch, DimensionType dimension, GameMode gamemode, Operation<EntityPlayerMPFake> original) {
//        try {
//            CompletableFuture<EntityPlayerMPFake> future = CompletableFuture.supplyAsync(() -> original.call(username, server, d0, d1, d2, yaw, pitch, dimension, gamemode), server);
//            return future.get();
//        } catch (InterruptedException | ExecutionException e) {
//            // 异常处理
//            e.printStackTrace();
//            // 根据需求返回默认值或其他处理
//            return null;
//        }
//    }
//
//    @WrapOperation(
//            method = "createFake",
//
//    )
    //上面的先不管，优先处理会崩服的
    //#if MC>=12002 && MC<=12004
    //$$ @WrapOperation(
    //$$         method = "createFake",
    //$$         at = @At(
    //$$                 value = "INVOKE",
    //$$                 target = "Ljava/util/concurrent/CompletableFuture;thenAccept(Ljava/util/function/Consumer;)Ljava/util/concurrent/CompletableFuture;"
    //$$         )
    //$$ )
    //$$ private static CompletableFuture<Void> createFake(CompletableFuture<Optional<GameProfile>> instance, Consumer<Optional<GameProfile>> action, Operation<CompletableFuture<Void>> original, @Local(argsOnly = true) MinecraftServer server) {
    //$$     return instance.thenAcceptAsync(action, server);
    //$$ }
    //#endif
}
