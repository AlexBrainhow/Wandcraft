package com.apertoria.wandcraft.common;

import com.apertoria.wandcraft.Wandcraft;
import com.apertoria.wandcraft.api.aspects.Aspect;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.*;

/**
 * Класс регистрации аспектов
 * @author Alex Brainhow
 * @version 1.0
 */
public class AspectRegistry {
    /** Объявление ключа регистра */
    public static final ResourceKey<Registry<Aspect>> ASPECT_REGISTRY_KEY =
            ResourceKey.createRegistryKey(new ResourceLocation(Wandcraft.MODID, "aspect"));

    /** Отложенная регистрация аспектов в регистре */
    public static final DeferredRegister<Aspect> ASPECTS =
            DeferredRegister.create(ASPECT_REGISTRY_KEY, Wandcraft.MODID);

    /** Метод регистрации регистра в шине событий */
    public static void createRegistry() {
        ASPECTS.makeRegistry(() -> new RegistryBuilder<Aspect>()
                .hasTags().setMaxID(256)
        );
    }

    //Изначальные аспекты
    public static final RegistryObject<Aspect> AIR =
            ASPECTS.register("aer",
                    () -> new Aspect("aer", 16777086, (Aspect[])null, 1, ChatFormatting.YELLOW));
    public static final RegistryObject<Aspect> EARTH =
            ASPECTS.register("terra",
                    () -> new Aspect("terra", 5685248, (Aspect[])null, 1, ChatFormatting.DARK_GREEN));
    public static final RegistryObject<Aspect> FIRE =
            ASPECTS.register("ignis",
                    () -> new Aspect("ignis", 16734721, (Aspect[])null, 1, ChatFormatting.RED));
    public static final RegistryObject<Aspect> WATER =
            ASPECTS.register("aqua",
                    () -> new Aspect("aqua", 3986684, (Aspect[])null, 1, ChatFormatting.AQUA));
    public static final RegistryObject<Aspect> ORDER =
            ASPECTS.register("ordo",
                    () -> new Aspect("ordo", 14013676, (Aspect[])null, 1, ChatFormatting.GRAY));
    public static final RegistryObject<Aspect> ENTROPY =
            ASPECTS.register("perditio",
                    () -> new Aspect("perditio", 4210752, (Aspect[])null, 771, ChatFormatting.DARK_GRAY));

    //Составные аспекты
    public static final RegistryObject<Aspect> VOID =
            ASPECTS.register("vacous",
                    () -> new Aspect("vacous", 8947848, new Aspect[]{AIR.get(), ENTROPY.get()}, 771));
    public static final RegistryObject<Aspect> LIGHT =
            ASPECTS.register("lux",
                    () -> new Aspect("lux", 16774755, new Aspect[]{AIR.get(), FIRE.get()}));
    public static final RegistryObject<Aspect> WEATHER =
            ASPECTS.register("tempestas",
                    () -> new Aspect("tempestas", 16777215, new Aspect[]{AIR.get(), WATER.get()}));
    public static final RegistryObject<Aspect> MOTION =
            ASPECTS.register("motus",
                    () -> new Aspect("motus", 13487348, new Aspect[]{AIR.get(), ORDER.get()}));
    public static final RegistryObject<Aspect> COLD =
            ASPECTS.register("gelum",
                    () -> new Aspect("gelum", 14811135, new Aspect[]{FIRE.get(), ENTROPY.get()}));
    public static final RegistryObject<Aspect> CRYSTAL =
            ASPECTS.register("vitreus",
                    () -> new Aspect("vitreus", 8454143, new Aspect[]{EARTH.get(), ORDER.get()}));
    public static final RegistryObject<Aspect> LIFE =
            ASPECTS.register("victus",
                    () -> new Aspect("victus", 14548997, new Aspect[]{WATER.get(), EARTH.get()}));
    public static final RegistryObject<Aspect> POISON =
            ASPECTS.register("venenum",
                    () -> new Aspect("venenum", 9039872, new Aspect[]{WATER.get(), ENTROPY.get()}));
    public static final RegistryObject<Aspect> ENERGY =
            ASPECTS.register("potentia",
                    () -> new Aspect("potentia", 12648447, new Aspect[]{ORDER.get(), FIRE.get()}));
    public static final RegistryObject<Aspect> EXCHENGE =
            ASPECTS.register("permutatio",
                    () -> new Aspect("permutatio", 5735255, new Aspect[]{ENTROPY.get(), ORDER.get()}));
    public static final RegistryObject<Aspect> METAL =
            ASPECTS.register("metallum",
                    () -> new Aspect("metallum", 11908557, new Aspect[]{EARTH.get(), CRYSTAL.get()}));
    public static final RegistryObject<Aspect> DEATH =
            ASPECTS.register("motrus",
                    () -> new Aspect("mortus", 8943496, new Aspect[]{LIFE.get(), ENTROPY.get()}));
    public static final RegistryObject<Aspect> FLIGHT =
            ASPECTS.register("volatus",
                    () -> new Aspect("volatus", 15198167, new Aspect[]{AIR.get(), MOTION.get()}));
    public static final RegistryObject<Aspect> DARKNESS =
            ASPECTS.register("tenebrae",
                    () -> new Aspect("tenebrae", 2236962, new Aspect[]{VOID.get(), LIGHT.get()}));
    public static final RegistryObject<Aspect> SOUL =
            ASPECTS.register("spiritus",
                    () -> new Aspect("spiritus", 15461371, new Aspect[]{LIFE.get(), DEATH.get()}));
    public static final RegistryObject<Aspect> HEAL =
            ASPECTS.register("sano",
                    () -> new Aspect("sano", 16723764, new Aspect[]{LIFE.get(), ORDER.get()}));
    public static final RegistryObject<Aspect> TRAVEL =
            ASPECTS.register("iter",
                    () -> new Aspect("iter", 14702683, new Aspect[]{MOTION.get(), EARTH.get()}));
    public static final RegistryObject<Aspect> ELDRITCH =
            ASPECTS.register("alienis",
                    () -> new Aspect("alienis", 8409216, new Aspect[]{VOID.get(), DARKNESS.get()}));
    public static final RegistryObject<Aspect> MAGIC =
            ASPECTS.register("praecantatio",
                    () -> new Aspect("praecantatio", 9896128, new Aspect[]{VOID.get(), ENERGY.get()}));
    public static final RegistryObject<Aspect> AURA =
            ASPECTS.register("auram",
                    () -> new Aspect("auram", 16761087, new Aspect[]{MAGIC.get(), AIR.get()}));
    public static final RegistryObject<Aspect> TAINT =
            ASPECTS.register("vitium",
                    () -> new Aspect("vitium", 8388736, new Aspect[]{MAGIC.get(), ENTROPY.get()}));
    public static final RegistryObject<Aspect> SLIME =
            ASPECTS.register("limus",
                    () -> new Aspect("limus", 129024, new Aspect[]{LIFE.get(), WATER.get()}));
    public static final RegistryObject<Aspect> PLANT =
            ASPECTS.register("herba",
                    () -> new Aspect("herba", 109568, new Aspect[]{LIFE.get(), EARTH.get()}));
    public static final RegistryObject<Aspect> TREE =
            ASPECTS.register("arbor",
                    () -> new Aspect("arbor", 8873265, new Aspect[]{AIR.get(), PLANT.get()}));
    public static final RegistryObject<Aspect> BEAST =
            ASPECTS.register("bestia",
                    () -> new Aspect("bestia", 10445833, new Aspect[]{MOTION.get(), LIFE.get()}));
    public static final RegistryObject<Aspect> FLESH =
            ASPECTS.register("corpus",
                    () -> new Aspect("corpus", 15615885, new Aspect[]{DEATH.get(), BEAST.get()}));
    public static final RegistryObject<Aspect> UNDEAD =
            ASPECTS.register("exanimis",
                    () -> new Aspect("exanimis", 3817472, new Aspect[]{DEATH.get(), MOTION.get()}));
    public static final RegistryObject<Aspect> MIND =
            ASPECTS.register("cognitio",
                    () -> new Aspect("cognitio", 16761523, new Aspect[]{FIRE.get(), SOUL.get()}));
    public static final RegistryObject<Aspect> SENSES =
            ASPECTS.register("sensus",
                    () -> new Aspect("sensus", 1038847, new Aspect[]{AIR.get(), SOUL.get()}));
    public static final RegistryObject<Aspect> MAN =
            ASPECTS.register("humanus",
                    () -> new Aspect("humanus", 16766912, new Aspect[]{BEAST.get(), MIND.get()}));
    public static final RegistryObject<Aspect> CROP =
            ASPECTS.register("messis",
                    () -> new Aspect("messis", 14791537, new Aspect[]{PLANT.get(), MAN.get()}));
    public static final RegistryObject<Aspect> MINE =
            ASPECTS.register("perfodio",
                    () -> new Aspect("perfodio", 14471896, new Aspect[]{EARTH.get(), MAN.get()}));
    public static final RegistryObject<Aspect> TOOL =
            ASPECTS.register("instrumentum",
                    () -> new Aspect("instrumentum", 4210926, new Aspect[]{ORDER.get(), MAN.get()}));
    public static final RegistryObject<Aspect> HARVEST =
            ASPECTS.register("meto",
                    () -> new Aspect("meto", 15641986, new Aspect[]{CROP.get(), TOOL.get()}));
    public static final RegistryObject<Aspect> WEAPON =
            ASPECTS.register("telum",
                    () -> new Aspect("telum", 12603472, new Aspect[]{TOOL.get(), FIRE.get()}));
    public static final RegistryObject<Aspect> ARMOR =
            ASPECTS.register("tutamen",
                    () -> new Aspect("tutamen", 49344, new Aspect[]{TOOL.get(), EARTH.get()}));
    public static final RegistryObject<Aspect> HUNGER =
            ASPECTS.register("fames",
                    () -> new Aspect("fames", 10093317, new Aspect[]{LIFE.get(), VOID.get()}));
    public static final RegistryObject<Aspect> GREED =
            ASPECTS.register("lucrum",
                    () -> new Aspect("lucrum", 15121988, new Aspect[]{MAN.get(), HUNGER.get()}));
    public static final RegistryObject<Aspect> CRAFT =
            ASPECTS.register("fabrico",
                    () -> new Aspect("fabrico", 8428928, new Aspect[]{MAN.get(), TOOL.get()}));
    public static final RegistryObject<Aspect> CLOTH =
            ASPECTS.register("pannus",
                    () -> new Aspect("pannus", 15395522, new Aspect[]{BEAST.get(), TOOL.get()}));
    public static final RegistryObject<Aspect> MECHANISM =
            ASPECTS.register("machina",
                    () -> new Aspect("machina", 8421536, new Aspect[]{MOTION.get(), TOOL.get()}));
    public static final RegistryObject<Aspect> TRAP =
            ASPECTS.register("vinculum",
                    () -> new Aspect("vinculum", 10125440, new Aspect[]{MOTION.get(), ENTROPY.get()}));

    /** Метод регистрации аспектов в шине событий */
    public static void registerAspect(IEventBus eventBus) {
        createRegistry();
        ASPECTS.register(eventBus);
    }
}
