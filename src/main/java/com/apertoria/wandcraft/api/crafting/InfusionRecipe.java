//package com.apertoria.wandcraft.api.crafting;
//
//import com.apertoria.wandcraft.api.aspects.AspectList;
//import net.minecraft.core.HolderSet;
//import net.minecraft.core.registries.BuiltInRegistries;
//import net.minecraft.tags.TagKey;
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.item.Item;
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.item.crafting.Ingredient;
//import net.minecraft.world.item.enchantment.Enchantment;
//import net.minecraft.world.item.enchantment.EnchantmentHelper;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.logging.Level;
//import java.util.stream.Collectors;
//
//public class InfusionRecipe {
//    protected AspectList aspects;
//    protected String research;
//    private ItemStack[] components;
//    private ItemStack recipeInput;
//    protected ItemStack recipeOutput;
//    protected  int instability;
//
//    public InfusionRecipe(String research, ItemStack recipeOutput, int instability, AspectList aspects, ItemStack recipeInput, ItemStack[] components) {
//        this.aspects = aspects;
//        this.research = research;
//        this.components = components;
//        this.recipeInput = recipeInput;
//        this.recipeOutput = recipeOutput;
//        this.instability = instability;
//    }
//
//    public boolean matches(ArrayList<ItemStack> input, ItemStack central, Level level, Player player) {
//        if (this.getRecipeInput() == null) { return false; }
//        if (!this.research.isEmpty() && !ThaumcraftApiHelper.isResearchComplete(player.getName().getString(), this.research)) { return false; }
//        ItemStack i2 = central.copy();
//        if (this.getRecipeInput().getDamageValue() == Short.MAX_VALUE) { i2.setDamageValue(Short.MAX_VALUE); }
//        if (!areItemStacksEqual(i2, this.getRecipeInput(), true)) { return false; }
//        ArrayList<ItemStack> ii = new ArrayList<>();
//        for (ItemStack is : input) { ii.add(is.copy()); }
//        for (ItemStack comp : this.getComponents()) {
//            boolean b = false;
//            for (int a = 0; a < ii.size(); ++a) {
//                i2 = ii.get(a).copy();
//                if (comp.getDamageValue() == Short.MAX_VALUE) { i2.setDamageValue(Short.MAX_VALUE); }
//                if (areItemStacksEqual(i2, comp, true)) {
//                    ii.remove(a);
//                    b = true;
//                    break;
//                }
//            }
//            if (!b) { return false; }
//        }
//        return ii.isEmpty();
//    }
//
//    public static boolean areItemStacksEqual(ItemStack stack0, ItemStack stack1, boolean fuzzy) {
//        if (stack0 == null && stack1 != null) { return false; }
//        else if (stack0 != null && stack1 == null) { return false; }
//        else if (stack0 == null && stack1 == null) { return true; }
//        else {
//            boolean t1 = ThaumcraftApiHelper.areItemStackTagsEqualForCrafting(stack0, stack1);
//            if (!t1) { return false; }
//            else {
//                if (fuzzy) {
//                    for (TagKey<Item> tag : stack0.getTags().toList()) {
//                        var tagItems = BuiltInRegistries.ITEM.getTag(tag).orElse(null);
//                        if (tagItems != null) {
//                            List<ItemStack> ores = tagItems.stream()
//                                    .map(holder -> new ItemStack(holder.value()))
//                                    .toList();
//                            if (ThaumcraftApiHelper.containsMatch(false, new ItemStack[]{stack1}, ores.toArray(new ItemStack[0]))) { return true; }
//                        }
//                    }
//                }
//                boolean damageMatches = stack0.getDamageValue() == stack1.getDamageValue() || stack1.getDamageValue() == Short.MAX_VALUE;
//                return stack0.getItem() != stack1.getItem()
//                        ? false
//                        : (!damageMatches ? false : stack0.getCount() <= stack0.getMaxStackSize());
//            }
//        }
//    }
//
//    public ItemStack getRecipeOutput() { return  this.getRecipeOutput(this.getRecipeInput()); }
//    public ItemStack getRecipeOutput(ItemStack input) { return this.recipeOutput; }
//
//    public AspectList getAspects() { return this.getAspects(this.getRecipeInput()); }
//    public AspectList getAspects(ItemStack input) { return this.aspects; }
//
//    public int getInstability() { return this.getInstability(this.getRecipeInput()); }
//    public int getInstability(ItemStack input) { return this.instability; }
//
//    public ItemStack getRecipeInput() { return this.recipeInput; }
//
//    public String getResearch() { return this.research; }
//
//    public ItemStack[] getComponents() { return this.components; }
//}
