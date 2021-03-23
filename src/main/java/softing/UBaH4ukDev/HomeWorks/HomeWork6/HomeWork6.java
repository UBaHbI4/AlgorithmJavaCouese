package softing.UBaH4ukDev.HomeWorks.HomeWork6;

import softing.UBaH4ukDev.HomeWorks.HomeWork2.HomeWork2;

import java.util.Arrays;
import java.util.Random;

/****
 Project Course2Algorithm
 Package softing.UBaH4ukDev.HomeWorks.HomeWork6

 Created by Ivan Sheynmaer (softing.UBaH4ukDev)

 2021.03.19
 v1.0
 */
public class HomeWork6 {

    public static void main(String[] args) {
        /*
        Задание 6.1
        Приведите пример использования древовидной структуры.
        */
        task1();
        /*
        Задание 6.2
        Реализуйте класс узла дерева и базовый шаблон дерева с базовыми методами.
        */
        System.out.println("Задание 6.2");
        System.out.println("\tРеализован класс узла дерева Node и базовый шаблон дерева с базовыми методами Tree");
        System.out.println();
        //Создадим экземпляр нашего дерева
        Tree tree = new Tree();
        /*
        Задание 6.3
        Реализуйте методы поиска и вставки узла в дерево.
        */
        System.out.println("Задание 6.3");
        System.out.println("\tРеализован метод поиска и вставки узла в дерево в классе Tree");
        //Заполним наше дерево и испытаем поиск
        tree.insert(new Person(0, "Персон1", 28));
        tree.insert(new Person(1, "Персон2", 8));
        tree.insert(new Person(2, "Персон3", 36));
        tree.insert(new Person(3, "Персон4", 6));
        tree.insert(new Person(4, "Персон5", 9));
        tree.insert(new Person(5, "Персон6",35));
        tree.insert(new Person(6, "Персон7",38));
        //Поиск
        System.out.println("\tПопробуем найти узел с id = 9");
        Node findNode = tree.find(9);
        System.out.println("\tРезультат поиска:");
        if (findNode != null) {
            findNode.display();
        } else {
            System.out.println("\tУзел не найден");
        }
        System.out.println();
        /*
        Задание 6.4
        Реализуйте базовые методы обхода дерева и метода дисплей.
        Реализуйте поиск максимума и минимума.
        */
        System.out.println("Задание 6.4");
        System.out.println("\tБазовые методы обхода дерева и метода дисплей, а так же поиск максимума и минимума реализованы в классе Tree");
        System.out.println();
        System.out.println("\tСимметричный обход дерева");
        long lStartTime = System.nanoTime();
        tree.printSymmetric(tree.getRoot());
        System.out.println("\tПродолжительность операции " + (System.nanoTime() - lStartTime) + " ns");
        System.out.println();

        System.out.println("\tОбход дерева сверху вниз");
        lStartTime = System.nanoTime();
        tree.printTopToBottom(tree.getRoot());
        System.out.println("\tПродолжительность операции " + (System.nanoTime() - lStartTime) + " ns");
        System.out.println();

        System.out.println("\tОбход дерева снизу вверх");
        lStartTime = System.nanoTime();
        tree.printBottomToTop(tree.getRoot());
        System.out.println("\tПродолжительность операции " + (System.nanoTime() - lStartTime) + " ns");
        System.out.println();

        System.out.println("\tПоиск минимума");
        lStartTime = System.nanoTime();
        tree.min().display();
        System.out.println("\tПродолжительность операции " + (System.nanoTime() - lStartTime) + " ns");
        System.out.println();
        System.out.println("\tПоиск максимума");
        lStartTime = System.nanoTime();
        tree.max().display();
        System.out.println("\tПродолжительность операции " + (System.nanoTime() - lStartTime) + " ns");
        System.out.println();
        /*
        Задание 6.5
        Реализуйте метод удаления узла и выполните оценку времени базовых методов дерева с помощью System.nanoTime().
        */
        System.out.println("Задание 6.5");
        System.out.println("\tМетод удаления узла реализован в классе Tree");
        System.out.println("\tУдалим человека с возрастом ранвым 35");
        lStartTime = System.nanoTime();
        System.out.println("\tРезультат удаления: " + tree.delete(35));
        System.out.println("\tПродолжительность операции " + (System.nanoTime() - lStartTime) + " ns");
        System.out.println("\tВывод дерева");
        tree.printTopToBottom(tree.getRoot());
        /*
        Задание 6.6
        Реализуйте на основе массива из задания 2.1 алгоритм пирамидальной сортировки с реализацией бинарной пирамиды.
        Выполните оценку алгоритма пирамидальной сортировки с помощью System.nanoTime() и сравните с предыдущими алгоритмами сортировки.
        */
        System.out.println("Задание 6.6");
        task6();
        /*
        Задание 6.7
        Приведите пример сбалансированного дерева и его применения.
        */
        System.out.println();
        System.out.println("Задание 6.7");
        System.out.println("\tПримером является Красно-черное дерево, которое применяется в контейнерах setMap, в библиотеке STL C++, класс TreeMap языка java");
    }

    private static void task6() {
        long lStartTime;
        long timeSort = 0;
        long timeBubble = 0;
        long timeSelect = 0;
        long timeInsert = 0;
        long timeTree = 0;
        //Получим массив из задания 2.1
        Random rnd = new Random();
        int size = 20;
        int[] array = new int[size];
        for(int i = 0; i < array.length; i++) {
            array[i] = rnd.nextInt(size);
        }

        int[] arrayCopy = Arrays.copyOf(array, array.length);
        System.out.println("\tИсходный массив: " + Arrays.toString(array));
        System.out.println("\tПирамидальная сортировка:");
        lStartTime = System.nanoTime();
        System.out.println("\tРезультат: " + Arrays.toString(HeapSort.sort(arrayCopy)));
        timeTree =  (System.nanoTime() - lStartTime);

        arrayCopy = Arrays.copyOf(array, array.length);
        System.out.println("\tСортировка методом вставки:");
        lStartTime = System.nanoTime();
        System.out.println("\tРезультат: " + Arrays.toString(HomeWork2.sortInsert(arrayCopy)));
        timeInsert =  (System.nanoTime() - lStartTime);

        arrayCopy = Arrays.copyOf(array, array.length);
        System.out.println("\tСортировка методом выбора:");
        lStartTime = System.nanoTime();
        System.out.println("\tРезультат: " + Arrays.toString(HomeWork2.sortSelect(arrayCopy)));
        timeSelect =  (System.nanoTime() - lStartTime);

        arrayCopy = Arrays.copyOf(array, array.length);
        System.out.println("\tСортировка методом пузырька:");
        lStartTime = System.nanoTime();
        System.out.println("\tРезультат: " +Arrays.toString(HomeWork2.sortBubble(arrayCopy)));
        timeBubble =  (System.nanoTime() - lStartTime);

        arrayCopy = Arrays.copyOf(array, array.length);
        System.out.println("\tСортировка методом Sort:");
        lStartTime = System.nanoTime();
        Arrays.sort(arrayCopy);
        System.out.println("\tРезультат: " +Arrays.toString(arrayCopy));
        timeSort =  (System.nanoTime() - lStartTime);


        System.out.println("\t\tИтоговые результаты:");
        System.out.printf("\t\tПирамидальная сортировка: %d ns\r\n\t\tSort: %d ns\r\n\t\tпузырька: %d ns\r\n\t\tвыбора: %d ns\r\n\t\tвставки: %d ns",
                timeTree, timeSort, timeBubble, timeSelect, timeInsert);
    }

    private static void task1() {
        System.out.println("Задание 6.1");
        String exampleTree = "\tПримеры древовидной структуры:\r\n" +
                "\t - структура вооруженных сил\r\n" +
                "\t - финансовая пирамида\r\n" +
                "\t - дерево навигации\r\n" +
                "\t - Active Directory";
        System.out.println(exampleTree);
        System.out.println();
    }
}
