package com.apertoria.wandcraft.api.aspects;

import com.apertoria.wandcraft.common.AspectRegistry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryManager;

import java.io.Serializable;
import java.util.*;

/**
 * Класс списка аспектов
 * @author Alex Brainhow
 * @version 1.0
 */
public class AspectList implements Serializable {
    /** Поле карты ключ значение с аспектами и их кол-вом */
    private final LinkedHashMap<Aspect, Integer> aspectIntegerMap = new LinkedHashMap<>();
    /** Поле с регистром зарегистрированных аспектов */
    private static final IForgeRegistry<Aspect> registry = RegistryManager.ACTIVE.getRegistry(AspectRegistry.ASPECT_REGISTRY_KEY);

//    /**
//     * Конструктор списка аспектов
//     * @param stack принимает ItemStack, назначая в список аспекты по предмету
//     */
//    public AspectList(ItemStack stack) {
//        try {
//            AspectList temp = WandcraftApiHelper.getObjectAspects(stack);
//            if (temp != null) {
//                for (Aspect tag : temp.getAspects()) { this.add(tag, temp.getAmount(tag)); }
//            }
//        } catch (Exception var) {}
//    }

    /**
     * Пустой конструктор списка аспектов
     */
    public AspectList() {}

    /**
     * Метод копирующий список аспектов у искомого объекта
     * @return копия AspectList объекта
     */
    public AspectList copy() {
        AspectList out = new AspectList();
        for (Aspect aspect : this.getAspects()) { out.add(aspect, this.getAmount(aspect)); }
        return out;
    }

    /**
     * Метод возвращающий кол-во уникальных аспектов в листе
     * @return целое число кол-ва аспектов в листе
     */
    public int size() { return this.aspectIntegerMap.size(); }

    /**
     * Метод возвращающий общее кол-во аспектов в листе
     * @return целое число кол-ва аспектов в листе
     */
    public int visSize() {
        int value = 0;
        for (Aspect aspect : this.aspectIntegerMap.keySet()) { value += this.getAmount(aspect); }
        return value;
    }

    /**
     * Метод возвращающий массив аспектов из листа
     * @return массив из Aspect
     */
    public Aspect[] getAspects() { return registry.getValues().toArray(new Aspect[0]); }

    /**
     * Метод возвращающий массив всех изначальных зарегистрированных аспектов
     * @return массив из Aspect
     */
    public Aspect[] getPrimalAspects() {
        AspectList temp = new AspectList();
        for (Aspect aspect : registry) {
            if (aspect.isPrimal()) { temp.add(aspect, 1); }
        }
        return (Aspect[])temp.aspectIntegerMap.keySet().toArray(new Aspect[0]);
    }

    /**
     * Метод возвращающий массив зарегистрированных аспектов из листа отсортированных по алфавиту
     * @return массив из Aspect
     */
    public Aspect[] getAspectsSorted() {
        Aspect[] sorted = getAspects();
        Arrays.sort(sorted, (a, b) -> a.getTag().compareTo(b.getTag()));
        return sorted;
    }

    /**
     * Метод возвращающий массив зарегистрированных аспектов из листа отсортированных по кол-ву аспекта в листе
     * @return массив из Aspect
     */
    public Aspect[] GetAspectsSortedAmount() {
        Aspect[] sorted = getAspects();
        Arrays.sort(sorted, (a, b) -> Integer.compare(getAmount(b), getAmount(a)));
        return sorted;
    }

    /**
     * Метод возвращающий кол-во указанного аспекта в листе
     * @param aspect аспект, кол-во которого необходимо узнать
     * @return кол-во аспекта целым числом
     */
    public int getAmount(Aspect aspect) {
        return this.aspectIntegerMap.get(aspect) == null ? 0 : (Integer)this.aspectIntegerMap.get(aspect);
    }

    /**
     * Метод добавляющий аспект в лист и возвращающий его обратно
     * @param aspect Aspect который необходимо добавить в лист
     * @param amount кол-во аспекта необходимое в листе
     * @return AspectList возвращает сам себя
     */
    public AspectList add(Aspect aspect, int amount) {
        if (this.aspectIntegerMap.containsKey(aspect)) {
            int oldAmount = (Integer)this.aspectIntegerMap.get(aspect);
            amount += oldAmount;
        }
        this.aspectIntegerMap.put(aspect, amount);
        return this;
    }

    /**
     * Метод добавляющий аспекты из другого листа в лист и возвращающий его обратно
     * @param aspects AspectList с аспектами которые необходимо добавить в лист
     * @return AspectList возвращает сам себя
     */
    public AspectList add(AspectList aspects) {
        for (Aspect aspect : aspects.getAspects()) { this.add(aspect, aspects.getAmount(aspect)); }
        return this;
    }

    /**
     * Метод добавляющий имеющийся аспект в лист и возвращающий его обратно
     * @param aspect Aspect который необходимо добавить в лист
     * @param amount кол-во аспекта необходимое в листе
     * @return AspectList возвращает сам себя
     */
    public AspectList merge(Aspect aspect, int amount) {
        if (this.aspectIntegerMap.containsKey(aspect)) {
            int oldAmount = (Integer)this.aspectIntegerMap.get(aspect);
            if (amount < oldAmount) {
                amount = oldAmount;
            }
        }
        this.aspectIntegerMap.put(aspect, amount);
        return this;
    }

    /**
     * Метод добавляющий имеющийся аспект в лист и возвращающий его обратно
     * @param aspects Aspect который необходимо добавить в лист
     * @return AspectList возвращает сам себя
     */
    public AspectList merge(AspectList aspects) {
        for (Aspect aspect : aspects.getAspects()) { this.merge(aspect, aspects.getAmount(aspect)); }
        return this;
    }

    /**
     * Метод вычитающий аспекты из листа
     * @param aspect Aspect который необходимо добавить в лист
     * @param amount кол-во аспекта необходимое в листе
     * @return AspectList возвращает сам себя
     */
    public AspectList remove(Aspect aspect, int amount) {
        int value = this.getAmount(aspect) - amount;
        if (value <= 0) { this.aspectIntegerMap.remove(aspect); }
        else { this.aspectIntegerMap.put(aspect, value); }
        return this;
    }

    public AspectList remove(Aspect aspect) {
        this.aspectIntegerMap.remove(aspect);
        return this;
    }

    public boolean reduce(Aspect aspect, int amount) {
        if (this.getAmount(aspect) >= amount) {
            int value = this.getAmount(aspect) - amount;
            this.aspectIntegerMap.put(aspect, value);
            return true;
        } else { return false; }
    }

    public void readFromNBT(CompoundTag tag, String label) {
        this.aspectIntegerMap.clear();
        ListTag list = tag.getList(label, CompoundTag.TAG_COMPOUND);
        for (int i = 0; i < list.size(); ++i) {
            CompoundTag value = list.getCompound(i);
            if (value.contains("key")) { this.add(registry.getValue(new ResourceLocation(tag.getString("key"))), tag.getInt("amount")); }
        }
    }

    public void readFromNBT(CompoundTag tag) {
        this.readFromNBT(tag, "Aspects");
    }

    public void writeToNBT(CompoundTag tag, String label) {
        ListTag list = new ListTag();
        tag.put(label, list);
        for (Aspect aspect : this.getAspects()) {
            if (aspect != null) {
                CompoundTag temp = new CompoundTag();
                temp.putString("key", aspect.getTag());
                temp.putInt("amount", this.getAmount(aspect));
                list.add(temp);
            }
        }
    }

    public void writeToNBT(CompoundTag tag) {
        this.writeToNBT(tag, "Aspects");
    }
}
