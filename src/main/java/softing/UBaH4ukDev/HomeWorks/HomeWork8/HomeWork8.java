package softing.UBaH4ukDev.HomeWorks.HomeWork8;

import java.util.Arrays;
import java.util.Random;

/****
 Project Course2Algorithm
 Package softing.UBaH4ukDev.HomeWorks.HomeWork8

 Created by Ivan Sheynmaer (softing.UBaH4ukDev)

 2021.03.27
 v1.0
 */
public class HomeWork8 {
    public static void main(String[] args) {
        /*
        Задание 8.1
        Приведите пример использование хеш-таблиц.
        */

        System.out.println("Задание 8.1");
        System.out.println("\tПример использования хеш-таблиц например можно назвать отдел кадров какого-то предприятия, где на стеллажах хранятся трудовые книжки.\n" +
                " \tКаждая полка обозначается буквами алфавита. Трудовые книжки лежат на полке,\n" +
                " \tкоторая содержит букву фамилии клиента.\n" +
                " \tХеш таблица - весь стелаж с трудовыми книжками, индекс хеш-таблицы - пронумированная ячейка.");

        /*
        Задание 8.2
        Приведите примеры ключей и коллизий.
        */
        System.out.println("Задание 8.2");
        System.out.println("\tНапример, ключ это фамилия сотрудника. А коллизия, это когда владельцы трудовой книжки" +
                "\tимеют одинаковые фамилии и наверное будет одинаковый хеш. ");

        /*
        Задание 8.3
        Приведите примеры популярных и эффективных хеш-функций.
        */
        System.out.println("Задание 8.3");
        System.out.println("\tSHA-1, SHA-2, SHA256, SHA512, CRC-32, MD5, Keccak, BLAKE, Grøstl, Skein, JH");
        /*
        Задание 8.4
        На основе данных массива из задания 2.3 реализуйте хеш-таблицу с помощью открытой адресации, а конкретнее метода линейного пробирования
        */
        task84();
        /*
        Задание 8.5
        Перестройте программный код задания 8.4 из алгоритма линейного пробирования в алгоритм двойного хеширования.
        */
        task85();
    }

    private static void task85() {
        System.out.println("Задание 8.5");
        //Массив из задания 2.3
        int size = 20;
        int[] testArr = new int[10];
        Random rnd = new Random();
        for(int i = 0; i < testArr.length; i++) {
            testArr[i] = rnd.nextInt(200);
        }
        System.out.println();
        HashTable hashTable = new HashTable(size);
        for (int value: testArr) {
            hashTable.insert(new Item(value), true);
        }
        System.out.println("\tИсходный массив: " + Arrays.toString(testArr));
        hashTable.display();
        System.out.println();

        System.out.println("\tПозиции элемента в массиве / позиция элемента в хеш-таблице:");
        for (int index = 0; index < testArr.length; index++) {
            System.out.println("\tЭлемент со значением: "+ testArr[index] + ": индекс в массиве = " + index + ", индекс в хеш-таблице " + hashTable.findPosition(testArr[index], true));
        }
    }

    private static void task84() {
        System.out.println("Задание 8.4");
        //Массив из задания 2.3
        int size = 20;
        int[] testArr = new int[10];
        Random rnd = new Random();
        for(int i = 0; i < testArr.length; i++) {
            testArr[i] = rnd.nextInt(200);
        }
        System.out.println();
        HashTable hashTable = new HashTable(size);
        for (int value: testArr) {
            hashTable.insert(new Item(value), false);
        }
        System.out.println("\tИсходный массив: " + Arrays.toString(testArr));
        hashTable.display();
        System.out.println();

        System.out.println("\tПозиции элемента в массиве / позиция элемента в хеш-таблице:");
        for (int index = 0; index < testArr.length; index++) {
            System.out.println("\tЭлемент со значением: "+ testArr[index] + ": индекс в массиве = " + index + ", индекс в хеш-таблице " + hashTable.findPosition(testArr[index], false));
        }
    }
}
