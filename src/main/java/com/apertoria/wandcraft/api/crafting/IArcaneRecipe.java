package com.apertoria.wandcraft.api.crafting;

import com.apertoria.wandcraft.api.aspects.AspectList;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.awt.*;

public interface IArcaneRecipe {
    boolean matches(Container container, Level level, Player player);
    ItemStack getCraftingResult(Container container);
    int getRecipeSize();
    ItemStack getRecipeOutput();
    AspectList getAspects();
    AspectList getAspects(Container container);
    String getResearch();
}
