package com.apertoria.wandcraft.api.crafting;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;

public interface IInfusionStabiliser {
    boolean canStabiliseInfusion(Level level, BlockPos pos);
}
