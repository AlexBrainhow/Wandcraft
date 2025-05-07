package com.apertoria.wandcraft.common;

import com.apertoria.wandcraft.api.aspects.AspectList;
import com.apertoria.wandcraft.api.aspects.direct.AspectDictionary;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.ForgeRegistries;

public class ConfigAspects {
    public static void init(FMLCommonSetupEvent event) {
        registerItemAspects(event);
    }

    public static void registerItemAspects(FMLCommonSetupEvent event) {
        event.enqueueWork( () -> {
            AspectDictionary.register(Items.STONE, new AspectList()
                    .add(AspectRegistry.EARTH.get(), 2));
            AspectDictionary.register(Items.COBBLESTONE, new AspectList()
                    .add(AspectRegistry.EARTH.get(), 1)
                    .add(AspectRegistry.ENTROPY.get(), 1));
            AspectDictionary.register(Items.STICK, new AspectList()
                    .add(AspectRegistry.TREE.get(), 1));
            AspectDictionary.register(Items.BLACK_DYE, new AspectList()
                    .add(AspectRegistry.SENSES.get(), 1));
            AspectDictionary.register(Items.BLUE_DYE, new AspectList()
                    .add(AspectRegistry.SENSES.get(), 1));
            AspectDictionary.register(Items.BROWN_DYE, new AspectList()
                    .add(AspectRegistry.SENSES.get(), 1));
            AspectDictionary.register(Items.CYAN_DYE, new AspectList()
                    .add(AspectRegistry.SENSES.get(), 1));
            AspectDictionary.register(Items.GRAY_DYE, new AspectList()
                    .add(AspectRegistry.SENSES.get(), 1));
            AspectDictionary.register(Items.GREEN_DYE, new AspectList()
                    .add(AspectRegistry.SENSES.get(), 1));
            AspectDictionary.register(Items.LIGHT_BLUE_DYE, new AspectList()
                    .add(AspectRegistry.SENSES.get(), 1));
            AspectDictionary.register(Items.LIGHT_GRAY_DYE, new AspectList()
                    .add(AspectRegistry.SENSES.get(), 1));
            AspectDictionary.register(Items.LIME_DYE, new AspectList()
                    .add(AspectRegistry.SENSES.get(), 1));
            AspectDictionary.register(Items.MAGENTA_DYE, new AspectList()
                    .add(AspectRegistry.SENSES.get(), 1));
            AspectDictionary.register(Items.ORANGE_DYE, new AspectList()
                    .add(AspectRegistry.SENSES.get(), 1));
            AspectDictionary.register(Items.PINK_DYE, new AspectList()
                    .add(AspectRegistry.SENSES.get(), 1));
            AspectDictionary.register(Items.PURPLE_DYE, new AspectList()
                    .add(AspectRegistry.SENSES.get(), 1));
            AspectDictionary.register(Items.RED_DYE, new AspectList()
                    .add(AspectRegistry.SENSES.get(), 1));
            AspectDictionary.register(Items.WHITE_DYE, new AspectList()
                    .add(AspectRegistry.SENSES.get(), 1));
            AspectDictionary.register(Items.YELLOW_DYE, new AspectList()
                    .add(AspectRegistry.SENSES.get(), 1));
            AspectDictionary.register(Items.DIAMOND, new AspectList()
                    .add(AspectRegistry.GREED.get(), 4)
                    .add(AspectRegistry.CRYSTAL.get(), 4));
            AspectDictionary.register(Items.EMERALD, new AspectList()
                    .add(AspectRegistry.GREED.get(), 5)
                    .add(AspectRegistry.CRYSTAL.get(), 4));
//            AspectDictionary.register(Items.ENCHANTING_TABLE, new AspectList()
//                    .add(AspectRegistry.GREED.get(), 4)
//                    .add(AspectRegistry.CRYSTAL.get(), 4));
            AspectDictionary.register(Items.NETHER_QUARTZ_ORE, new AspectList()
                    .add(AspectRegistry.GREED.get(), 4)
                    .add(AspectRegistry.CRYSTAL.get(), 4));

            for (Item item : ForgeRegistries.ITEMS.getValues()) {
                if (item.builtInRegistryHolder().is(ItemTags.LOGS)) {
                    AspectDictionary.register(item, new AspectList()
                            .add(AspectRegistry.TREE.get(), 4)); }
                if (item.builtInRegistryHolder().is(ItemTags.PLANKS)) {
                    AspectDictionary.register(item, new AspectList()
                            .add(AspectRegistry.TREE.get(), 1)); }
                if (item.builtInRegistryHolder().is(ItemTags.WOODEN_SLABS)) {
                    AspectDictionary.register(item, new AspectList()
                            .add(AspectRegistry.TREE.get(), 1)); }
                if (item.builtInRegistryHolder().is(ItemTags.WOODEN_STAIRS)) {
                    AspectDictionary.register(item, new AspectList()
                            .add(AspectRegistry.TREE.get(), 1)); }
                if (item.builtInRegistryHolder().is(ItemTags.SAPLINGS)) {
                    AspectDictionary.register(item, new AspectList()
                            .add(AspectRegistry.TREE.get(), 1)
                            .add(AspectRegistry.PLANT.get(), 1)); }
                if (item.builtInRegistryHolder().is(ItemTags.LEAVES)) {
                    AspectDictionary.register(item, new AspectList()
                            .add(AspectRegistry.PLANT.get(), 1)); }
                if (item.builtInRegistryHolder().is(ItemTags.LAPIS_ORES)) {
                    AspectDictionary.register(item, new AspectList()
                            .add(AspectRegistry.EARTH.get(), 1)
                            .add(AspectRegistry.SENSES.get(), 3)); }
                if (item.builtInRegistryHolder().is(ItemTags.DIAMOND_ORES)) {
                    AspectDictionary.register(item, new AspectList()
                            .add(AspectRegistry.EARTH.get(), 1)
                            .add(AspectRegistry.GREED.get(), 3)
                            .add(AspectRegistry.CRYSTAL.get(), 1)); }
                if (item.builtInRegistryHolder().is(ItemTags.REDSTONE_ORES)) {
                    AspectDictionary.register(item, new AspectList()
                            .add(AspectRegistry.EARTH.get(), 1)
                            .add(AspectRegistry.ENERGY.get(), 2)
                            .add(AspectRegistry.MECHANISM.get(), 2)); }
                if (item.builtInRegistryHolder().is(ItemTags.EMERALD_ORES)) {
                    AspectDictionary.register(item, new AspectList()
                            .add(AspectRegistry.EARTH.get(), 1)
                            .add(AspectRegistry.GREED.get(), 4)
                            .add(AspectRegistry.CRYSTAL.get(), 3)); }
//                if (item.builtInRegistryHolder().is(ItemTags.OR)) {
//                    AspectDictionary.register(item, new AspectList()
//                            .add(AspectRegistry.EARTH.get(), 1)
//                            .add(AspectRegistry.GREED.get(), 4)
//                            .add(AspectRegistry.CRYSTAL.get(), 3)); }
            }
        });
    }
}
