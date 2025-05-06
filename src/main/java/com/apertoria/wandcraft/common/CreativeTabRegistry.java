package com.apertoria.wandcraft.common;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import static com.apertoria.wandcraft.Wandcraft.MODID;
import static net.minecraft.world.item.Items.STICK;

/**
 * Класс регистрации креативной вкладки и предметов в ней.
 * @author Alex Brainhow
 * @version 1.0
 */
public class CreativeTabRegistry {
    /** Отложенная регистрация креативной вкладки */
    public static final DeferredRegister<CreativeModeTab> WANDCRAFT_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    /** Регистрация объекта креативной вкладки */
    public static final RegistryObject<CreativeModeTab> WANDCRAFT_TAB =
            WANDCRAFT_TABS.register("wandcraft_tab",
                    () -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(STICK::getDefaultInstance)
            .displayItems((parameters, output) -> {
                output.accept(STICK);
            }).build());

    /**
     * Конструктор для регистрации вкладки в IEventBus
     * @param eventBus экземпляр IEventBus
     */
    public static void register(IEventBus eventBus) {
        WANDCRAFT_TABS.register(eventBus);
    }
}
