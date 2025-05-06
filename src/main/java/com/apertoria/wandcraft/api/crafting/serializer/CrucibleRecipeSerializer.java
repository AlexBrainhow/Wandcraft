//package com.apertoria.wandcraft.api.crafting.serializer;
//
//import com.apertoria.wandcraft.api.crafting.CrucibleRecipe;
//import net.minecraft.network.FriendlyByteBuf;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.world.item.crafting.RecipeSerializer;
//
//import com.google.gson.JsonObject;
//import org.jetbrains.annotations.NotNull;
//
//public class CrucibleRecipeSerializer implements RecipeSerializer<CrucibleRecipe> {
//    @Override
//    public @NotNull CrucibleRecipe fromJson(@NotNull ResourceLocation id, @NotNull JsonObject json) {
//        // Здесь ты парсишь JSON и создаёшь новый рецепт
//        // Например: ингредиенты, результат, аспекты, ключ исследования
//        // Заглушка:
//        throw new UnsupportedOperationException("Not yet implemented");
//    }
//
//    @Override
//    public CrucibleRecipe fromNetwork(@NotNull ResourceLocation id, @NotNull FriendlyByteBuf buffer) {
//        throw new UnsupportedOperationException("Not yet!");
//    }
//
//    @Override
//    public void toNetwork(@NotNull FriendlyByteBuf buffer, @NotNull CrucibleRecipe recipe) {
//        // Запись рецепта в сеть
//        throw new UnsupportedOperationException("Not yet implemented");
//    }
//}
