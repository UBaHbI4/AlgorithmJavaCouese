package softing.UBaH4ukDev.HomeWorks.HomeWork2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/****
 Project Course2Algorithm
 Package softing.UBaH4ukDev.HomeWorks.HomeWork2

 Created by Ivan Sheynmaer (softing.UBaH4ukDev)

 2021.03.02
 v1.0
 */
public class HomeWork2 {
    private static long timeSort = 0;
    private static long timeBubble = 0;
    private static long timeSelect = 0;
    private static long timeInsert = 0;
    public static void main(String[] args) {


        /*
        Задание 2.1
        На основе программного кода из домашнего задания №1 реализуйте массив на основе существующих примитивных или ссылочных типов данных.
        Выполните обращение к массиву и базовые операции класса Arrays.
        Оценить выполненные методы с помощью базового класса System.nanoTime().
        */
        task1();
        /*
        Задание 2.2
        На основе написанного кода в задании 2.1 реализуйте линейный и двоичный поиск.
        Оценить алгоритмы линейного и двоичного поиска с помощью базового класса System.nanoTime(), при необходимости расширьте уже существующий массив данных.
        */
        taks2();
        /*
        Задание 2.3
        Создайте массив размером 400 элементов.
        Выполните сортировку с помощью метода sort().
        Оцените сортировку с помощью базового класса System.nanoTime().
        */
        int array[] = new int[400];
        Random rnd = new Random();
        for(int i = 0; i < array.length; i++) {
            array[i] = rnd.nextInt(200);
        }
        System.out.println();
        System.out.println("\tИсходный массив: " + Arrays.toString(array));
        task3(Arrays.copyOf(array, array.length));
        /*
        Задание 2.4
        На основе существующего массива данных из задания 2.3 реализуйте алгоритм сортировки пузырьком.
        Оцените сортировку с помощью базового класса System.nanoTime().
        Сравните время выполнения алгоритмы сортировки методом sort() из задания 2.1 и сортировку пузырьком.
        */
        task4(Arrays.copyOf(array, array.length));
        /*
        Задание 2.5
        На основе массива данных из задания 2.3 реализуйте алгоритм сортировки методом выбора.
        Оцените сортировку с помощью базового класса System.nanoTime().
        Сравните с временем выполнения алгоритмов сортировки из прошлых заданий 2.3 и 2.4.
        */
        task5(Arrays.copyOf(array, array.length));
        /*
        Задание 2.6
        На основе массива данных из задания 2.3 реализуйте алгоритм сортировки методом вставки.
        Оцените сортировку с помощью базового класса System.nanoTime().
        Сравните с временем выполнения алгоритмов сортировки из прошлых заданий 2.3, 2.4 и 2.5.
        */
        task6(Arrays.copyOf(array, array.length));

        System.out.println("\t\tИтоговые результаты:");
        System.out.printf("\t\tСортировка методом \r\n\t\tSort: %d ns\r\n\t\tпузырька: %d ns\r\n\t\tвыбора: %d ns\r\n\t\tвставки: %d ns", timeSort, timeBubble, timeSelect, timeInsert);

    }

    private static void task6(int[] array) {
        System.out.println("Задание 2.6");
        System.out.println("\tСорировка методом вставки");
        long lStartTime = System.nanoTime();
        array = sortInsert(array);
        timeInsert =  (System.nanoTime() - lStartTime);
        System.out.println("\tПродолжительность операции " + timeInsert + " ns");
        System.out.println("\tarray: " + Arrays.toString(array));
    }
    public static int[] sortInsert(int[] targetArray) {
        int tempValue = 0;
        int in = 0;

        for (int i = 0; i < targetArray.length; i++) {
            tempValue = targetArray[i];
            in = i;
            while (in > 0 && targetArray[in - 1] >= tempValue) {
                targetArray[in] = targetArray[in - 1];
                --in;
            }
            targetArray[in] = tempValue;
        }
        return targetArray;
    }

    private static void task5(int[] array) {
        System.out.println("Задание 2.5");
        System.out.println("\tСорировка методом выбора");
        long lStartTime = System.nanoTime();
        array = sortSelect(array);
        timeSelect =  (System.nanoTime() - lStartTime);
        System.out.println("\tПродолжительность операции " + timeSelect + " ns");
        System.out.println("\tarray: " + Arrays.toString(array));
    }

    public static int[] sortSelect(int[] targetArray) {
        int tempValue = 0;
        for (int i = 0; i < targetArray.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < targetArray.length; j++) {
                if (targetArray[j] < targetArray[min]) {
                    min = j;
                }
            }
            tempValue = targetArray[i];
            targetArray[i] = targetArray[min];
            targetArray[min] = tempValue;

        }
        return targetArray;
    }

    private static void task4(int[] array) {
        System.out.println("Задание 2.4");
        System.out.println("\tСорировка пузырьком");
        long lStartTime = System.nanoTime();
        array = sortBubble(array);
        timeBubble =  (System.nanoTime() - lStartTime);
        System.out.println("\tПродолжительность операции " + timeBubble + " ns");
        System.out.println("\tarray: " + Arrays.toString(array));
    }

    public static int[] sortBubble(int[] targetArray) {
        int tempValue = 0;
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < targetArray.length - 1; i++) {
                if (targetArray[i] > targetArray[i + 1]) {
                    sorted = false;
                    tempValue = targetArray[i];
                    targetArray[i] = targetArray[i + 1];
                    targetArray[i + 1] = tempValue;
                }

            }
        }
        return targetArray;
    }


    private static void task3(int[] array) {
        System.out.println("Задание 2.3");

        long lStartTime = System.nanoTime();
        System.out.println("\tСортировка массива методом Sort");
        Arrays.sort(array);
        timeSort = (System.nanoTime() - lStartTime);
        System.out.println("\tПродолжительность операции " + timeSort + " ns");
        System.out.println("\tarray: " + Arrays.toString(array));
    }

    private static void taks2() {
        Random rnd = new Random();
        int size = 20;
        System.out.println("Задание 2.2");
        //Реализовал массив на основе существующих примитивных данных
        int[] array = new int[size];
        long lStartTime = System.nanoTime();
        System.out.println("\tЗаполнение массива случайными числами:");
        for(int i = 0; i < array.length; i++) {
            array[i] = rnd.nextInt(size);
        }
        System.out.println("\tПродолжительность операции " + (System.nanoTime() - lStartTime) + " ns");
        //Выводим исходный массив
        System.out.println("\tarray: " + Arrays.toString(array));
        System.out.println();

        System.out.println("\tСортируем массив для линейного и двоичного поиска, чтобы создать равные условия. Хотя сортировка нужна только для двоичного поиска.");
        Arrays.sort(array);
        System.out.println("\tarray: " + Arrays.toString(array));

        //Линейный поиск:
        int findValue = 5;
        int findIndex = -1;
        System.out.println("\tЛинейный поиск:");
        lStartTime = System.nanoTime();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == findValue) {
                findIndex = i;
                break;
            }
        }
        if (findIndex > -1) {
            System.out.println("\tНайдено значение " + findValue + " в array[" + findIndex + "]");
        } else {
            System.out.println("\tЗначение не найдено");
        }
        System.out.println("\tПродолжительность операции " + (System.nanoTime() - lStartTime) + " ns");
        System.out.println();

        //Двоичный поиск:
        System.out.println("\tДвоичный поиск:");
        lStartTime = System.nanoTime();
        findIndex = binarySearch(array, findValue);
        if (findIndex > -1) {
            System.out.println("\tНайдено значение " + findValue + " в array[" + findIndex + "]");
        } else {
            System.out.println("\tЗначение не найдено");
        }
        System.out.println("\tПродолжительность операции " + (System.nanoTime() - lStartTime)+ " ns");
    }

    //Метод двоичного поиска
    public static int binarySearch(int targetArray[], int targetValue) {
       int startIndex = 0;
       int endIndex = targetArray.length - 1;
       while (startIndex <= endIndex) {
           int middleIndex = (startIndex + endIndex) / 2;

           if (targetArray[middleIndex] == targetValue) {
               return  middleIndex;
           } else if (targetArray[middleIndex] < targetValue) {
               startIndex = middleIndex + 1;
           } else if (targetArray[middleIndex] > targetValue) endIndex = middleIndex - 1;
       }
       return -1;
    }

    private static void task1() {
        Random rnd = new Random();
        int size = 20;
        System.out.println("Задание 2.1");
        //Реализовал массив на основе существующих примитивных данных
        Integer[] array = new Integer[size];
        long lStartTime = System.nanoTime();
        System.out.println("\tЗаполнение массива случайными числами:");
        for(int i = 0; i < array.length; i++) {
            array[i] = rnd.nextInt(size);
        }
        System.out.println("\tПродолжительность операции " + (System.nanoTime() - lStartTime) + " ns");
        //Выводим исходный массив
        System.out.println("\tarray: " + Arrays.toString(array));
        System.out.println();
        //Выполнил обращение к массиву. Нечетные числа увеличиваем на 1, а четные уменьшаем, например
        System.out.println("\tНечетные числа увеличиваем на 1, а четные уменьшаем на 1");
        lStartTime = System.nanoTime();
        for(int i = 0; i< array.length; i++) {
            if (array[i] % 2 == 0) {
                array[i]--;
            } else {
                array[i]++;
            }
        }
        System.out.println("\tПродолжительность операции " + (System.nanoTime() - lStartTime) + " ns");
        //Выводим результат
        System.out.println("\tarray: " + Arrays.toString(array));
        System.out.println();
        //Базовые операции класса Arrays:
        //Сортировка по возрастанию
        System.out.println("\tСортировка по возрастанию:");
        lStartTime = System.nanoTime();
        Arrays.sort(array);
        System.out.println("\tПродолжительность операции " + (System.nanoTime() - lStartTime) + " ns");
        //Выводим результат
        System.out.println("\tarray: " + Arrays.toString(array));
        System.out.println();
        //Сортировка по убыванию
        System.out.println("\tСортировка по убыванию:");
        lStartTime = System.nanoTime();
        Arrays.sort(array, Collections.reverseOrder());
        System.out.println("\tПродолжительность операции " + (System.nanoTime() - lStartTime) + " ns");
        //Выводим результат
        System.out.println("\tarray: " + Arrays.toString(array));
        System.out.println();
        //Заполнение массива пятерками
        System.out.println("\tЗаполнение массива пятерками");
        lStartTime = System.nanoTime();
        Arrays.fill(array,5);
        System.out.println("\tПродолжительность операции " + (System.nanoTime() - lStartTime) + " ns");
        //Выводим результат
        System.out.println("\tarray: " + Arrays.toString(array));
    }
}
