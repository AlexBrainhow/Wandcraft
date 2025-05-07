package com.apertoria.wandcraft.api.aspects.direct;

import com.apertoria.wandcraft.api.aspects.AspectList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;

import java.util.HashMap;
import java.util.Map;

public class AspectDictionary {
    private static final Map<ResourceLocation, AspectList> ITEM_TAGS = new HashMap<>();

    public static void register(ItemLike item, AspectList aspects) {
        ITEM_TAGS.put(BuiltInRegistries.ITEM.getKey(item.asItem()), aspects);
    }

    public static AspectList get(ItemStack stack) {
        return get(stack.getItem());
    }

    public static AspectList get(Item item) {
        ResourceLocation key = BuiltInRegistries.ITEM.getKey(item);
        return ITEM_TAGS.getOrDefault(key, AspectList.EMPTY);
    }


}
