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

package club.mcams.carpetpatcher.mixins.integratedServerClose;

import carpet.CarpetServer;
import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = CarpetServer.class, remap = false)
public class CarpetServerMixin {
    // This fix works generally btw the bug only crashes the game in 1.20.2+ versions
    @Inject(method = "onServerClosed(Lnet/minecraft/server/MinecraftServer;)V", at = @At("HEAD"), cancellable = true)
    private static void onlyCallIfServerNotnull(MinecraftServer server, CallbackInfo ci) {
        if (server == null) {
            ci.cancel();
        }
    }
}
