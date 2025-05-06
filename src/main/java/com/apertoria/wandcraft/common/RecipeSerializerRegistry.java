//package com.apertoria.wandcraft.common;
//
//import com.apertoria.wandcraft.Wandcraft;
//import com.apertoria.wandcraft.api.crafting.CrucibleRecipe;
//import com.apertoria.wandcraft.api.crafting.serializer.CrucibleRecipeSerializer;
//import net.minecraft.world.item.crafting.RecipeSerializer;
//import net.minecraftforge.registries.DeferredRegister;
//import net.minecraftforge.registries.ForgeRegistries;
//import net.minecraftforge.registries.RegistryObject;
//
//public class RecipeSerializerRegistry {
//    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZER =
//            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, Wandcraft.MODID);
//
//    public static final RegistryObject<RecipeSerializer<CrucibleRecipe>> CRUCIBLE_SERIALIZER =
//            RECIPE_SERIALIZER.register("crucible", CrucibleRecipeSerializer::new);
//}
