package com.apertoria.wandcraft.api.misc;

import net.minecraftforge.client.event.RenderTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "wandcraft", bus = Mod.EventBusSubscriber.Bus.FORGE)
public class TooltipHandler {

    @SubscribeEvent
    public static void onTooltip(RenderTooltipEvent.GatherComponents event) {
//        ItemStack stack = event.getItemStack();
//
//        if (!Screen.hasShiftDown()) return;
//
//        AspectList aspects = AspectDictionary.get(stack);
//        if (aspects == null || aspects.size() == 0) return;
//
//        for (Aspect aspect : aspects.getAspects()) {
//            AspectTooltipData data = new AspectTooltipData(aspect.getImage(), aspects.getAmount(aspect));
//            // Добавим визуальный компонент (например, снизу)
//            event.getTooltipElements().add(Either.right(data));
//        }
    }
}
