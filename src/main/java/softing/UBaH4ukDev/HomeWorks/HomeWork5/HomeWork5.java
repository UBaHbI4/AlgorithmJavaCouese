package softing.UBaH4ukDev.HomeWorks.HomeWork5;

import softing.UBaH4ukDev.HomeWorks.HomeWork2.HomeWork2;

import java.util.Arrays;
import java.util.Random;

/****
 Project Course2Algorithm
 Package softing.UBaH4ukDev.HomeWorks.HomeWork5

 Created by Ivan Sheynmaer (softing.UBaH4ukDev)

 2021.03.16
 v1.0
 */

public class HomeWork5 {

    public static void main(String[] args) {
        /*
        Задание 5.1
        Приведите пример использования рекурсии.
        Рекурсия может использоваться много где. Это вычисления факториала, числа Фибоначи,
        метод Гауса, фракталы и т.д.
        */
        //Реализуем нахождение факториала целого неотрицательного числа
        task1();
        System.out.println();
        /*
        Задание 5.2
        Реализуйте простой пример бесконечной рекурсии и обычной рекурсии с условием для выхода.
        */
        task2();
        System.out.println();
        /*
        Задание 5.3
        Приведите пример изображающий стек вызова и стек вызова с рекурсией.
        */
        System.out.println();
        task3();
        /*
        Задание 5.4
        Реализуйте простой алгоритм использующий цикл и простой алгоритм использующий рекурсию.
        Оцените два алгоритма с помощью базового метода System.nanoTime().
        */
        task4();
        System.out.println();
        /*
        Задание 5.5
        Реализуйте алгоритм двоичного рекурсивного поиска на основе массива из задания 2.1.
        Оцените алгоритм двоичного рекурсивного поиска с помощью базового метода System.nanoTime() и сравните с обычным двоичным поиском.
        */
        task5();
        System.out.println();
        /*
        Задание 5.6
        На основе массива из задания 2.1 реализуйте алгоритм сортировки слиянием.
        Оцените алгоритм сортировки слиянием с помощью базового метода System.nanoTime() и сравните с сортировкой методом sort().
        */
        task6();
    }

    private static void task6() {
        System.out.println("Задание 5.6");
        Random rnd = new Random();
        int size = 10;
        int needFind = rnd.nextInt(10);
        //массив из задания 2.1
        int[] array = new int[size];

        for(int i = 0; i < array.length; i++) {
            array[i] = rnd.nextInt(size);
        }
        System.out.println("\tМассив из задания 2.1: " + Arrays.toString(array));
        int[] arrayA = Arrays.copyOf(array, array.length);
        System.out.println("\tСортировка слиянием:");
        System.out.println("\tКопия исходного массива: " + Arrays.toString(arrayA));
        long lStartTime = System.nanoTime();
        arrayA = sortMerge(arrayA);
        System.out.println("\tПродолжительность операции " + (System.nanoTime() - lStartTime) + " ns");
        System.out.println("\tОтсортированный массив: " + Arrays.toString(arrayA));
        System.out.println();
        System.out.println("\tСортировка методом SORT:");
        int[] arrayB = Arrays.copyOf(array, array.length);
        System.out.println("\tКопия исходного массива: " + Arrays.toString(arrayB));

        lStartTime = System.nanoTime();
        Arrays.sort(arrayB);
        System.out.println("\tПродолжительность операции " + (System.nanoTime() - lStartTime) + " ns");
        System.out.println("\tОтсортированный массив: " + Arrays.toString(arrayB));
        //И снова рекурсивный метод выигрывает по времени
    }

    private static void task5() {
        System.out.println("Задание 5.5");
        Random rnd = new Random();
        int size = 10;
        int needFind = rnd.nextInt(10);
        //массив из задания 2.1
        int[] array = new int[size];
        for(int i = 0; i < array.length; i++) {
            array[i] = rnd.nextInt(size);
        }
        //Для бинарного поиска сортируем массив
        Arrays.sort(array);
        System.out.println("\tМассив из задания 2.1: " + Arrays.toString(array));
        System.out.println("\tИщем: " + needFind);
        System.out.println("\tРекурсивный поиск:");
        long lStartTime = System.nanoTime();
        System.out.println("\tРезультат поиска: " + binaryFindRecurse(needFind, 0, size - 1, array));
        System.out.println("\tПродолжительность операции " + (System.nanoTime() - lStartTime) + " ns");
        System.out.println("\tБинарный поиск из задания 2.2:");
        lStartTime = System.nanoTime();
        System.out.println("\tРезультат поиска: " + HomeWork2.binarySearch(array, needFind));
        System.out.println("\tПродолжительность операции " + (System.nanoTime() - lStartTime) + " ns");
        //Рекурсивный поиск во много раз быстрее срабатывает :)
        //Если обычный 1304000 ns, то рекурсивный 57500 ns в моих тестах
    }

    private static void task4() {
        System.out.println("Задание 5.4");
        int[] testArray = {1, 5, 6, 13, 8, 10, 84, 45, 2, 3, 9, 12, 13, 124, 15};
        int needFind = 45;
        System.out.println("\tИсходный массив: " + Arrays.toString(testArray) + "\r\n\tНужно найти: " + needFind);
        System.out.println("\tПоиск с помощью цикла:");
        long lStartTime = System.nanoTime();
        System.out.println("\tРезультат поиска: " + findWithCycle(testArray, needFind));
        System.out.println("\tПродолжительность операции " + (System.nanoTime() - lStartTime) + " ns");
        System.out.println("\tПоиск с помощью рекурсии:");
        lStartTime = System.nanoTime();
        System.out.println("\tРезультат поиска: " + findWithRecurse(testArray, needFind, testArray.length - 1));
        System.out.println("\tПродолжительность операции " + (System.nanoTime() - lStartTime) + " ns");
        //В данном примере рекурсивный поиск работает быстрее, хоть и незначительно. Но
        //с увеличением размера массива, растет и разница во времени
    }

    //Метод для поиска числа в массиве с помощью цикла
    private static int findWithCycle(int[] array, int targetFind) {
        int result = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == targetFind) {
                result = i;
                break;
            }
        }
        return result;
    }

    //Метод для поиска числа в массиве с помощью рекурсии
    private static int findWithRecurse(int[] array, int targetFind, int n) {
        int result = -1;
        if (n == 0 || array[n] == targetFind) {
            return n;
        }
        return findWithRecurse(array, targetFind, n - 1);
    }

    private static void task3() {
    /*
    Представим, что у нас какой-то метод hello, в котором параметром передается аргумент с именем человека,
    которого следует поприветствовать. Внутри этого метода вызывается метод  System.out.println(),
    выводящий приветствие на экран и метод by, который прощается с человеком.
    Первым в методе task3 вызывается метод hello и записывается в  стеке вызовов. Далее вызывается метод
    System.out.println() и записывается так же в стеке вызовов.
    Теперь после этого строка с надписью "Привет Иван" и метод  System.out.println() удаляется из стека.
    На его место помещается метод By, который вызывается следом за методом System.out.println().
    В методе By вызывается метод System.out.println() и помещается в стеке вызовов.
    Далее по очереди выводится сообщения на экран и завершается все это методом By.
    И завершается метод сам Hello.
    */
        System.out.println("Задание 5.3");
        System.out.println("\tПример, изображающий стек вызова");
        //Вызвали метод hello.
        hello("Иван");
        //Метод Hello вызвал метод println и далыы вызвал метод  by
        //Метод by вызвал метод println и далее вернулся в метод Hello
        //После чего Hello вернулся в метод task3 и работу продолжил метод task3
        //который в итоге вернулся в метод main и далее работают следующие методы...

        System.out.println("\tПример, изображающий стек вызова с рекурсией");
        /*
        Вызов метода getFactorial(3). Сначало идет вызов самой функции, которая в последующем вернет нам 1.
        После чего идет вызов функции с n-1, и возвращает нам 2. После этого мы вызываем функцию еще и
        она в итоге нам возвращает 6. Получается что методы сначало помещаются в стек вызовов, а когда рекурсивный вызов заканчивается,
        они начинают выполняться с конца.
        Т.е. сначало идет заполнение стека вызовов и только после того, как закончилась рекурсия и мы из нее вышли,
        нам идет отображение, идет расчет и сворачивание обратно. Идет вызов функции, возврат 1.
        Вызов функции, возврат 2. Вызов функции, возврат 6.
        */
        getFactorialOut(3);
    }

    private static void task2() {
        System.out.println("Задание 5.2");
        System.out.println("\tПример бесконечной рекурсии:");
        //decDigit(50); //Закомментил, чтобы не видеть ошибок бесконечной рекурсии.
        System.out.println("\tПример обычной рекурсии:");
        System.out.print("\t");
        decDigitWithExit(100);
    }

    private static void task1() {
        System.out.println("Задание 5.1");
        Random rnd = new Random();
        for (int i = 0; i < 5; i++) {
            int n = rnd.nextInt(10);
            try {
                if (i == 1) n = -2;//проверка, что мы не кушаем отрицательные числа
                System.out.println("\tФакториал числа " + n + " равен " + getFactorial(n));
            } catch (Exception e) {
                System.out.println("\t" + e.getMessage());
            }
        }
    }

    //Метод для получения факториала от целого неотрицательного числа
    private static int getFactorial(int n) {
        if (n > -1) {
            if (n <= 1) return 1;
            return n * getFactorial(n - 1);
        } else
            throw new RuntimeException("Число должно быть не меньше нуля!");

    }

    //Метод для получения факториала от целого неотрицательного числа с отображением последовательности вызова
    private static int getFactorialOut(int n) {
        if (n > -1) {
            System.out.println("\tgetFactorialOut(" + n + ")");
            if (n <= 1) {
                System.out.println("\tgetFactorialOut(" + n + ") вернул 1");
                return 1;
            }
            int tempN = n - 1;
            int res = n * getFactorialOut(tempN);
            System.out.println("\tgetFactorialOut(" + n + ") вернул " + res);
            return res;
        } else
            throw new RuntimeException("Число должно быть не меньше нуля!");

    }

    //Метод реализации бесконечной рекурсии (условно конечно. Мы ограничены диапазоном, в нашем случае int-а.
    //Но ранее возникает StackOverflow)
    public static int decDigit(int n) {
        System.out.println(n);
        return decDigit(n - 1);
    }

    //Метод реализации обычной рекурсии с условием выхода
    public static int decDigitWithExit(int n) {
        System.out.print(n + " ");
        if (n == 1) return 1;
        return decDigitWithExit(n - 1);
    }

    public static void hello(String name) {
        System.out.println("\tПривет " + name);
        by(name);
    }

    public static void by(String name) {
        System.out.println("\tПока " + name);
    }

    private static int binaryFindRecurse (int targetFind, int low, int hight, int[] array) {
        if (low > hight)
            return -1;
        int mid = (low + hight) / 2;

        if (array[mid] == targetFind) {
            return mid;
        } else if (array[mid] < targetFind) {
            return binaryFindRecurse(targetFind, low + 1, hight, array);
        } else {
            return binaryFindRecurse(targetFind, low, hight - 1, array);
        }
    }

    private static int[] sortMerge(int[] arr) {
        int len = arr.length;
        if (len < 2) return arr;
        int middle = len / 2;
        return merge(sortMerge(Arrays.copyOfRange(arr, 0, middle)),
                sortMerge(Arrays.copyOfRange(arr, middle, len)));
    }

    private static int[] merge(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int aIndex = 0;
        int bIndex = 0;

        for (int i = 0; i< result.length; i++) {
            result[i] = a[aIndex] < b[bIndex] ? a[aIndex++] : b[bIndex++];
            if (aIndex == a.length) {
                System.arraycopy(b, bIndex, result, ++i, b.length - bIndex);
                break;
            }

            if (bIndex == b.length) {
                System.arraycopy(a, aIndex, result, ++i, a.length - aIndex);
                break;
            }
        }
        return result;
    }
}
