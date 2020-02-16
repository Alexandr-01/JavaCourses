package ru.java.courses;

import java.util.*;
import java.util.Map.Entry;

public class Lesson11to12_SetMap {

    public static class User {

        private String name;
        private int age;
        private String phone;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public User(String phone) {
            this.phone = phone;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }
    }

    /**
     * В этом методе необходимо реализовать:
     * 1. На вход получаем коллекцию пользователей
     * 2. Удаляем все дубли (одинаковое имя и возраст)
     * 3. Сортируем по имени и возрасту
     * 4. Возвращаем последнего пользователя
     */
    public static User task1(Collection<User> source) {
        TreeSet<User> res = new TreeSet<>(new UsersComparator());
        res.addAll(source);
        return res.last();
    }

    static class UsersComparator implements Comparator<User> {

        @Override
        public int compare(User o1, User o2) {
            int res = o1.name.compareTo(o2.name);
            if (res != 0) {
                return res;
            } else {
                return Integer.compare(o1.age, o2.age);
            }
        }
    }

    /**
     * В этом методе необходимо реализовать следующий алгоритм:
     * 1. На вход получаем коллекцию пользователей
     * 2. Преобразовываем его в справочник [номер телефона -> пользователь]
     * 3. Один номер телефона на одного пользователя
     * 4. Вернуть количество записей в справочнике
     */
    public static int task2(Collection<User> source) {
        HashMap<String, User> res = new HashMap<>();
        for (User user : source) {
            res.putIfAbsent(user.phone, user);
        }
        return res.size();
    }


    /**
     * В этом методе необходимо реализовать следующий алгоритм:
     * 1. На вход получаем список названий книг
     * 2. Распределяем книги по полкам так, чтобы на каждой полке было примерно одинаковое количество книг
     * 3. Все книги должны быть отсортированы по алфавиту с первой до последней полки
     * 4. Количество полок константное - 5 штук
     * 5. Вернуть книги распределенные по полкам
     * <p>
     * Нумерация полок начинается с единицы!
     */
    public static Map task3(Collection<String> source) {
        final int SHELVES_NUMBER = 5;
        List<String> sortSource = new ArrayList<>(source);
        Collections.sort(sortSource);
        HashMap<Integer, ArrayList<String>> res = new HashMap<>();
        int booksOnShelve = sortSource.size() / SHELVES_NUMBER;
        int balanceBook = sortSource.size() % SHELVES_NUMBER;
        int currentBook = 0;
        for (int i = 1; i <= SHELVES_NUMBER; i++) {
            if (balanceBook != 0) {
                res.put(i, new ArrayList<>(sortSource.subList(currentBook, currentBook + booksOnShelve + 1)));
                currentBook += booksOnShelve + 1;
                balanceBook--;
            } else {
                res.put(i, new ArrayList<>(sortSource.subList(currentBook, currentBook + booksOnShelve)));
                currentBook += booksOnShelve;
            }
        }
        return res;
    }


    /**
     * В этом методе необходимо реализовать следующий алгоритм:
     * 1. На вход получаем книги, распределенные по полкам
     * 5. Вернуть справочник [название книги -> номер полки]
     */
    public static Map task4(Map<Integer, String> source) {
        HashMap<String, Integer> res = new HashMap<>();
        for (Entry<Integer, String> entry : source.entrySet()) {
            res.put(entry.getValue(), entry.getKey());
        }
        return res;
    }
}

