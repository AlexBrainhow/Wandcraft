package com.apertoria.wandcraft.api.misc;

import com.apertoria.wandcraft.api.aspects.Aspect;
import com.apertoria.wandcraft.common.AspectRegistry;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.ChatFormatting;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryManager;

public class CommandList {
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(
                Commands.literal("wandcraft")
                        .then(Commands.literal("aspects")
                                .then(Commands.literal("primal")
                                        .executes(context -> {
                                            return listOfPrimalAspects(context.getSource());
                                        })
                                )
                                .then(Commands.literal("compound")
                                        .executes(context -> {
                                            return listOfCompoundAspects(context.getSource());
                                        })
                                )
                        )
        );
    }

    private static int listOfPrimalAspects(CommandSourceStack ctx) {
        IForgeRegistry<Aspect> aspects = RegistryManager.ACTIVE.getRegistry(AspectRegistry.ASPECT_REGISTRY_KEY);

        ctx.sendSystemMessage(Component.literal("=== Wandcraft Primal Aspects ==="));
        for (Aspect aspect : aspects) {
            if (aspect.isPrimal()) {
                ctx.sendSystemMessage(
                        Component.literal(aspect.getName()).withStyle(aspect.getChatFormatting())
                                .append(" ")
                                .append(aspect.getDescription()));
            }
        }
        return Command.SINGLE_SUCCESS;
    }

    private static int listOfCompoundAspects(CommandSourceStack ctx) {
        IForgeRegistry<Aspect> aspects = RegistryManager.ACTIVE.getRegistry(AspectRegistry.ASPECT_REGISTRY_KEY);

        ctx.sendSystemMessage(Component.literal("=== Wandcraft Compound Aspects ==="));
        for (Aspect aspect : aspects) {
            if (!aspect.isPrimal()) {
                ctx.sendSystemMessage(
                        Component.literal(aspect.getName())
                                .append(" ")
                                .append(aspect.getDescription()));
            }
        }
        return Command.SINGLE_SUCCESS;
    }

    @Mod.EventBusSubscriber(modid = "wandcraft")
    public static class ModEvents {
        @SubscribeEvent
        public static void onServerStarting(RegisterCommandsEvent event) {
            register(event.getDispatcher());
        }
    }
}
