//package com.apertoria.wandcraft.api.crafting;
//
//import com.apertoria.wandcraft.api.aspects.Aspect;
//import com.apertoria.wandcraft.api.aspects.AspectList;
//import com.apertoria.wandcraft.api.crafting.container.CrucibleContainer;
//import net.minecraft.core.RegistryAccess;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.item.crafting.Ingredient;
//import net.minecraft.world.item.crafting.Recipe;
//
//import net.minecraft.world.level.Level;
//import org.jetbrains.annotations.NotNull;
//
//public class CrucibleRecipe implements Recipe<CrucibleContainer> {
//    private final ItemStack recipeOutput;
//    private final Ingredient recipeInput;
//    private final AspectList aspects;
//    private final String requiredResearch;
//    private final ResourceLocation id;
//    public int hash;
//
//    public CrucibleRecipe(String researchKey, Ingredient catalyst, ItemStack result, AspectList aspects, ResourceLocation id) {
//        this.recipeOutput = result;
//        this.aspects = aspects;
//        this.requiredResearch = researchKey;
//        this.recipeInput = catalyst;
//        StringBuilder hachCod = new StringBuilder(researchKey + result.toString());
//        for (Aspect aspect : aspects.getAspects()) { hachCod.append(aspect.getTag()).append(aspects.getAmount(aspect)); }
//        for (ItemStack item : catalyst.getItems()) { hachCod.append(item.toString()); }
//        this.hash = hachCod.hashCode();
//        this.id = id;
//    }
//
//    @Override
//    public boolean matches(CrucibleContainer container, @NotNull Level level) {
//        ItemStack input = container.getItem(0);
//        AspectList aspects = container.getAspects();
//        return this.matches(aspects, input);
//    }
//
//    @Override
//    public @NotNull ItemStack getResultItem(@NotNull RegistryAccess access) { return recipeOutput.copy(); }
//
//    @Override
//    public @NotNull ItemStack assemble(@NotNull CrucibleContainer container, @NotNull RegistryAccess access) { return recipeOutput.copy(); }
//
//    @Override
//    public boolean canCraftInDimensions(int w, int h) { return true; }
//
//    @Override
//    public @NotNull ResourceLocation getId() { return this.id; }
//
//    public boolean matches(AspectList aspects, ItemStack catalyst) {
//        if (this.recipeInput.getItems().length == 1 && !WandcraftApiHelper.itemMatches(this.recipeInput.getItems(), catalyst, false)) {
//            return false;
//        } else {
//            if (this.recipeInput.getItems().length > 0) {
//                ItemStack[] items = (ItemStack[])this.recipeInput.getItems();
//                if (!WandcraftApiHelper.containsMatch(false, new ItemStack[] {catalyst}, items)) {
//                    return false;
//                }
//            }
//            if (aspects == null) { return false; }
//            else {
//                for (Aspect aspect : this.aspects.getAspects()) {
//                    if (aspects.getAmount(aspect) < this.aspects.getAmount(aspect)) { return false; }
//                }
//                return true;
//            }
//        }
//    }
//
//    public boolean catalystMatches(ItemStack item) {
//        if (this.recipeInput.getItems().length == 1 && WandcraftApiHelper.itemMatches(this.recipeInput.getItems(), item, false)) {
//            return true;
//        } else {
//            if (this.recipeInput.getItems().length > 0) {
//                ItemStack[] items = (ItemStack[])this.recipeInput.getItems();
//                return WandcraftApiHelper.containtMatch(false, new ItemStack[]{item}, items);
//            }
//            return false;
//        }
//    }
//
//    public AspectList removeMatching(AspectList aspects) {
//        AspectList temp = aspects.copy();
//        for (Aspect aspect : this.aspects.getAspects()) { temp.remove(aspect, this.aspects.getAmount(aspect)); }
//        return temp;
//    }
//
//    public ItemStack getRecipeOutput() { return this.recipeOutput; }
//
//    public String getRequiredResearch() { return this.requiredResearch; }
//}
