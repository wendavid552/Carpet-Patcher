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

//#if MC>=12003
//$$ import carpet.patches.FakeClientConnection;
//#endif
import club.mcams.carpetpatcher.utils.ModIds;
import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import me.fallenbreath.conditionalmixin.api.annotation.Condition;
import me.fallenbreath.conditionalmixin.api.annotation.Restriction;
import net.fabricmc.fabric.impl.networking.AbstractChanneledNetworkAddon;
import net.fabricmc.fabric.impl.networking.AbstractNetworkAddon;
import net.fabricmc.fabric.impl.networking.GlobalReceiverRegistry;
import net.minecraft.network.ClientConnection;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@SuppressWarnings("UnstableApiUsage")
@Restriction(require = @Condition(ModIds.fabric_networking_api))
@Mixin(value = AbstractNetworkAddon.class, priority = 998, remap = false)
public abstract class AbstractNetworkAddonMixin {
    //#if MC>=12003
    //$$ @SuppressWarnings("RedundantIfStatement")
    //$$ @WrapWithCondition(method = "lateInit", at = @At(value = "INVOKE", target = "Lnet/fabricmc/fabric/impl/networking/GlobalReceiverRegistry;startSession(Lnet/fabricmc/fabric/impl/networking/AbstractNetworkAddon;)V"))
    //$$ private boolean notStartSession_ifFakeClientConnection(GlobalReceiverRegistry<?> instance, AbstractNetworkAddon<?> addon) {
    //$$     // 修复fabric api和Carpet的内存泄漏问题
    //$$     if (addon instanceof AbstractChanneledNetworkAddon<?>) {
    //$$         ClientConnection connection = ((AbstractChanneledNetworkAddonInvoker) addon).getConnection();
    //$$         if (connection instanceof FakeClientConnection) {
    //$$             return false;
    //$$         }
    //$$     }
    //$$     return true;
    //$$ }
    //#endif
}
