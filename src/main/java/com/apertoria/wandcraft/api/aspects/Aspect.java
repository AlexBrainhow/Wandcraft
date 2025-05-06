package com.apertoria.wandcraft.api.aspects;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

/**
 * Класс объекта аспекта
 * @author Alex Brainhow
 * @version 1.0
 */
public class Aspect {
    /** Поле имени аспекта (Возможно не нужно) */
    private final String tag;
    /** Поле состава аспекта, если он не изначальный */
    private final Aspect[] components;
    /** Поле цвета объекта */
    private final int color;
    /** Поле текстового форматирования аспекта*/
    private final ChatFormatting chatFormatting;
    /** Поле ссылки на иконку аспекта */
    private final ResourceLocation image;
    /** Поле смешивания цвета */
    private final int blend;

    /**
     * Конструктор объекта аспекта
     * @param tag имя аспекта
     * @param color цвет аспекта
     * @param components составные компоненты аспекта
     * @param blend тип смешивания/наложения цвета
     * @param chatFormatting цвет аспекта при выводе в чат
     */
    public Aspect(String tag, int color, Aspect[] components, int blend, ChatFormatting chatFormatting) {
        this.tag = tag;
        this.color = color;
        this.components = components;
        this.image = new ResourceLocation("wandcraft", "aspects/" + tag);
        this.blend = blend;
        this.chatFormatting = chatFormatting;
    }

    /**
     * Конструктор аспекта без указания цвета форматирования в чате
     * @param tag имя аспекта
     * @param color цвет аспекта
     * @param components составные компоненты аспекта
     * @param blend тип смешивания/наложения цвета
     */
    public Aspect(String tag, int color, Aspect[] components, int blend){
        this(tag, color, components, blend, ChatFormatting.WHITE);
    }

    /**
     * Конструктор аспекта без указания цвета форматирования в чате и типа смешивания
     * @param tag имя аспекта
     * @param color цвет аспекта
     * @param components составные компоненты аспекта
     */
    public Aspect(String tag, int color, Aspect[] components){
        this(tag, color, components, 1, ChatFormatting.WHITE);
    }

    /**
     * Метод получения локализированного имени аспекта
     * @return строка с названием аспекта
     */
    public String getName() {
        String value = "wandcraft.aspect." + this.tag;
        return Component.translatable(value).getString();
    }

    /**
     * Метод получения локализованного описания аспекта
     * @return строка с описанием аспекта
     */
    public String getDescription() { return Component.translatable("wandcraft.aspect.description." + this.tag).getString(); }

    public String getTag() { return this.tag; }

    public int getColor() { return color; }

    public Aspect[] getComponents() { return components; }

    public ResourceLocation getImage() { return this.image; }

    public int getBlend() { return this.blend; }

    public ChatFormatting getChatFormatting() { return this.chatFormatting; }

    /**
     * Конструктор проверки является ли аспект изначальным
     * @return возвращает истинну, если аспект изначальный
     */
    public boolean isPrimal() { return this.getComponents() == null || this.getComponents().length != 2; }
}
