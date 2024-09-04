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

package club.mcams.carpetpatcher.utils.mixin;

import club.mcams.carpetpatcher.impl.pingSampleListInjection.PingSampleListMixinAdjuster;
import com.bawnorton.mixinsquared.adjuster.MixinAnnotationAdjusterRegistrar;
import me.fallenbreath.conditionalmixin.api.mixin.RestrictiveMixinConfigPlugin;

import java.util.List;
import java.util.Set;

public class MixinConfigPlugin extends RestrictiveMixinConfigPlugin {
    @Override
    public void onLoad(String mixinPackage) {
        MixinAnnotationAdjusterRegistrar.register(new PingSampleListMixinAdjuster());
    }

    @Override
    public String getRefMapperConfig() {
        return null;
    }

    @Override
    public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {

    }

    @Override
    public List<String> getMixins() {
        return null;
    }
}
