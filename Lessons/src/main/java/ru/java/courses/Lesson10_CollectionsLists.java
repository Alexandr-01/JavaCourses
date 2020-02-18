package ru.java.courses;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Lesson10_CollectionsLists {

    /**
     * В этом методе необходимо реализовать:
     * 1. На вход получаем список чисел
     * 2. Удаляем все дубли
     * 3. Сортируем список по возрастанию
     * 4. Преобразуем числа в строки
     * <p>
     * Подсказки:
     * Collections.sort() - сортировка
     * Удалять элементы из итерируемого списка нельзя - выпадет исключение
     */
    public static List<String> task1(List<Integer> source) {
        Set<Integer> res = new TreeSet<>(source);
        List<String> resStr = new ArrayList<>();
        for (Integer k : res) {
            resStr.add(k.toString());
        }
        return resStr;
    }

    /**
     * В этом методе необходимо реализовать следующий алгоритм:
     * 1. Получаем на входе массив чисел
     * 2. Преобразовываем его к списку
     * 4. Все четные числа увеличиваем на единицу
     * 5. Возвращаем кусок списка с 3-го по 7-й элемент
     * <p>
     * Подсказка: на входе может быть любое количество чисел
     */
    public static List<Integer> task2(Integer... array) {
        List<Integer> res = new ArrayList<>();
        if (array.length >= 4) {
            for (int i = 3; i < Math.min(array.length, 8); i++) {
                res.add(array[i] % 2 == 0 ? ++array[i] : array[i]);
            }
        }
        return res;
    }
}
