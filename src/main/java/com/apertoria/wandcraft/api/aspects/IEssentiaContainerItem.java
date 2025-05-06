package com.apertoria.wandcraft.api.aspects;

import net.minecraft.world.item.ItemStack;

public interface IEssentiaContainerItem {
    AspectList getAspects(ItemStack stack);
    void setAspects(ItemStack stack, AspectList aspects);
}
