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

package club.mcams.carpetpatcher.mixins.fakePlayerNetworkAddonMemoryLeak;

import club.mcams.carpetpatcher.utils.ModIds;
import me.fallenbreath.conditionalmixin.api.annotation.Condition;
import me.fallenbreath.conditionalmixin.api.annotation.Restriction;
import net.fabricmc.fabric.impl.networking.AbstractChanneledNetworkAddon;
import net.minecraft.network.ClientConnection;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@SuppressWarnings("UnstableApiUsage")
@Restriction(require = @Condition(ModIds.fabric_networking_api))
@Mixin(value = AbstractChanneledNetworkAddon.class, remap = false)
public interface AbstractChanneledNetworkAddonInvoker {
    @Accessor("connection")
    ClientConnection getConnection();
}
