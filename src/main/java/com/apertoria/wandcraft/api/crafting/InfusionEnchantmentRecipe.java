//package com.apertoria.wandcraft.api.crafting;
//
//import com.apertoria.wandcraft.api.aspects.AspectList;
//import net.minecraft.core.HolderSet;
//import net.minecraft.core.registries.BuiltInRegistries;
//import net.minecraft.tags.TagKey;
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.item.Item;
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.item.enchantment.Enchantment;
//import net.minecraft.world.item.enchantment.EnchantmentHelper;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.logging.Level;
//import java.util.stream.Collectors;
//
//public class InfusionEnchantmentRecipe {
//    private final AspectList aspects;
//    private final String research;
//    private final ItemStack[] components;
//    private final Enchantment enchantment;
//    private final int recipeXP;
//    private final int instability;
//
//    public InfusionEnchantmentRecipe(String research, Enchantment input, int instability, AspectList aspects, ItemStack[] items) {
//        this.research = research;
//        this.enchantment = input;
//        this.instability = instability;
//        this.aspects = aspects;
//        this.components = items;
//        this.recipeXP = Math.max(1, input.getMinCost(1) / 3);
//    }
//
//    public boolean matches(List<ItemStack> input, ItemStack central, Level level, Player player) {
//        if (!this.research.isEmpty() && !WandcraftApiHelper.isResearchComplete(player.getName().getString(), this.research)) { return false; }
//        if (!this.enchantment.canEnchant(central) || !central.isEnchantable()) { return false; }
//        Map<Enchantment, Integer> existing = EnchantmentHelper.getEnchantments(central);
//        for (Map.Entry<Enchantment, Integer> entry : existing.entrySet()) {
//            Enchantment ench = entry.getKey();
//            int levelExisting = entry.getValue();
//            if (ench == this.enchantment && levelExisting >= ench.getMaxLevel()) { return false; }
//            if (!this.enchantment.isCompatibleWith(ench)) { return false; }
//        }
//        List<ItemStack> remaining = input.stream()
//                .map(ItemStack::copy)
//                .collect(Collectors.toCollection(ArrayList::new));
//        for (ItemStack required : this.components) {
//            boolean found = false;
//            for (int i = 0; i < remaining.size(); i++) {
//                ItemStack candidate = remaining.get(i).copy();
//                if (required.getDamageValue() == Short.MAX_VALUE) { candidate.setDamageValue(Short.MAX_VALUE); }
//                if (this.areItemStacksEqual(candidate, required, true)) {
//                    remaining.remove(i);
//                    found = true;
//                    break;
//                }
//            }
//            if (!found) { return false; }
//        }
//        return remaining.isEmpty();
//    }
//
//    protected boolean areItemStacksEqual(ItemStack stack0, ItemStack stack1, boolean fuzzy) {
//        if ((stack0.isEmpty() && !stack1.isEmpty()) || (!stack0.isEmpty() && stack1.isEmpty())) { return false; }
//        else if (stack0.isEmpty() && stack1.isEmpty()) { return true; }
//        else {
//            if (!WandcraftApiHelper.areItemStackTagsEqualForCrafting(stack0, stack1)) { return false; }
//            else {
//                if (fuzzy) {
//                    for (TagKey<Item> tag : stack0.getTags().toList()) {
//                        HolderSet<Item> tagItem = BuiltInRegistries.ITEM.getTag(tag).orElse(null);
//                        if (tagItem != null) {
//                            List<ItemStack> matchingItems = tagItem.stream()
//                                    .map(holder -> new ItemStack(holder.value()))
//                                    .toList();
//                            if (WandcraftApiHelper.containsMatch(false, new ItemStack[]{stack1}, matchingItems.toArray(new ItemStack[0]))) {
//                                return true;
//                            }
//                        }
//                    }
//                }
//                return stack0.getItem() != stack1.getItem()
//                        ? false
//                        : (stack0.getDamageValue() != stack1.getDamageValue()
//                            ? false
//                            : stack0.getCount() <= stack0.getMaxStackSize());
//            }
//        }
//    }
//
//    public Enchantment getEnchantment() { return this.enchantment; }
//
//    public AspectList getAspects() { return this.aspects; }
//
//    public String getResearch() { return this.research; }
//
//    public int calcInstability(ItemStack recipeInput) {
//        int total = 0;
//        Map<Enchantment, Integer> map = EnchantmentHelper.getEnchantments(recipeInput);
//        for (int i : map.values()) { total += i; }
//        return total / 2 + this.instability;
//    }
//
//    public int calcXP(ItemStack recipeInput) { return this.recipeXP * (1 + EnchantmentHelper.getItemEnchantmentLevel(this.enchantment, recipeInput)); }
//
//    public float getEssentiaMod(ItemStack recipeInput) {
//        float mod = (float) EnchantmentHelper.getItemEnchantmentLevel(this.enchantment, recipeInput);
//        Map<Enchantment, Integer> map = EnchantmentHelper.getEnchantments(recipeInput);
//        for (Map.Entry<Enchantment, Integer> i : map.entrySet()) {
//            Enchantment ench = i.getKey();
//            int level = i.getValue();
//            if (ench != this.enchantment) { mod += level * 0.1f; }
//        }
//        return mod;
//    }
//}
