package softing.UBaH4ukDev.HomeWorks.HomeWork1;
import java.util.Arrays;
import java.util.Random;
/****
 Project HomeWork1
 Package softing.UBaH4ukDev.HomeWorks.HomeWork1

 Created by Ivan Sheynmaer

 2021.02.26
 v1.0
 */
/*
Задание 1.1
Приведите пример алгоритмов и структур данных из жизни:

Алгоритм заказа в терминале самообслуживания KFC:
    1.  Из главного меню перейти в каталог товаров.
    2.  Выбрать категорию товара
    3.  Выбрать товар
    4.  Задать количество
    5.  Выбрать дополнительные опции.
    6.  Если нужно добавить еще товары, повторить шаги 2-5.
    7.  Нажать на кнопку оплаты.
    8.  Проверить корректность заказа.
    9.  Приложить банковскую карту для оплаты
    10. Получить чек с номером заказа.
    11. Ждать готовности заказа по электронному таблу очередей.
    12. Забрать заказ.
Алгоритм оплаты в магазине с помощью банковской карты
Алгоритм подачи звонков в школе
Алгоритм приготовления салата "Цезарь"

Генеалогическое древо (дерево)
Вертикальная стопка книг (стек - Последним пришел, первым вышел. Чтобы взять книгу, например  с середины, нужно убрать все книги, лежащие на ней.)
Очередь в магазин (очередь - первый в очереди ее первый покинет, а последний в очереди последний ее и покинет)
-----------------------------------------------------------
Задание 1.2
Приведите пример алгоритмов и структур данных в программировании.

Массивы, стек, очередь, списки, деревья, графы, хэш таблицы

Алгоритмы:  Разные алгоритмы сортировок и поиска, перебора, замены элементов по условию и т.д, алгоритм нахождения корней уравнения, вычисления факториала
нахождение минимльного/максимального значения и другие
------------------------------------------------------------

*/

//Задания 1.3, 1.4.
public class HomeWork1 {

        public static class Box {
        private int weight = 0;

        public Box(int weight) {
            this.weight = weight;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "" + weight;
        }

        public boolean equals(Box otherBox) {
            return this.weight == otherBox.weight;
        }
    }

    private static final Random RANDOM = new Random();

    public static void main(String[] args) {

        //Вариант 1 для 3,4-го задания
        System.out.println("------------Вариант 1:");
        variantOne();


        //Вариант 2 для 3,4-го задания
        System.out.println();
        System.out.println("------------Вариант 2:");
        variantTwo();
    }

    private static void variantOne() {
        //Примитивный тип
        int weightBox1 = 125;
        //Ссылочный тип
        String weightBox2 = "125";
        //Тип класса Box
        Box box3 = new Box(125);

        //Выводим все данные
        System.out.println("Вес первой коробки (примитивный тип) " + weightBox1);
        System.out.println("Вес второй коробки (ссылочный тип) " + weightBox2);
        System.out.println("Вес третьей коробки (тип класса Box) " + box3);

        //Заносим все переменные в массив, для перебора
        Object[] collectionVariable = new Object[3];
        collectionVariable[0] = weightBox1;
        collectionVariable[1] = weightBox2;
        collectionVariable[2] = box3;

        //Создаем переменные примитивного, ссылочного типа и переменные класса Box, find3 новый экземпляр, find4 ссылка на box3
        int find1 = new Integer(125);
        String find2 = "125";
        Box find3 = new Box(125);
        Box find4 = box3;
        //Заносим все переменные в массив, для перебора
        Object[] collectionFind = new Object[4];
        collectionFind[0] = find1;
        collectionFind[1] = find2;
        collectionFind[2] = find3;
        collectionFind[3] = find4;

        //Получаем время начала перебора по массиву объектов
        long lStartTime = System.nanoTime();


        /*
        Перебираем для каждого типа переменной все значения (разных типов) для сравнения и выводим результат сравнения
        */
        for(Object obj : collectionVariable)
            for (Object objFind : collectionFind) {
                if (obj.equals(objFind)) {
                    System.out.println("(" + obj.getClass().getSimpleName() +")" + obj + " равен " + "(" + ((Object)objFind).getClass().getSimpleName() + ")" + objFind);
                } else {
                    System.out.println("(" + obj.getClass().getSimpleName() +")" + obj + " не равен " + "(" + ((Object)objFind).getClass().getSimpleName() + ")" + objFind);
                }
            }

        //Отнимаем от текущего времени время начала перебора и получаем длительность операции в мс
        System.out.println("Время перебора и сравнения: " + (System.nanoTime() - lStartTime) / 1000000 + " ms");
    }

    private static void variantTwo() {
        final int size = 10;
        boolean isFind = false;

        //Задание 1.3.
        int[] arrayPrimitives = new int[size];      //Массив примитивов
        Integer[] arrayLinks = new Integer[size];   //Массив данных ссылочного типа
        Box[] arrayBoxes = new Box[size];           //Массив данных типа класса Box

        for (int i = 0; i < size; i++) {
            arrayPrimitives[i] = RANDOM.nextInt(10);
            arrayLinks[i] = RANDOM.nextInt(10);
            arrayBoxes[i] = new Box(RANDOM.nextInt(10));
        }

        //Выводим данные
        System.out.println("Массив примитивов: " + Arrays.toString(arrayPrimitives));
        System.out.println("Массив данных ссылочного типа: " + Arrays.toString(arrayLinks));
        System.out.println("Массив данных типа Box: " + Arrays.toString(arrayBoxes));

        //Задание 1.4.
        int findOne = RANDOM.nextInt(20);
        Integer findTwo = new Integer(findOne);
        Box findTThree = new Box(findOne);
        System.out.println("Ищем число " + findOne);

        System.out.println("\tв массиве примитивов:");
        isFind = false;
        //Получаем время начала ппоиска
        long lStartTime = System.nanoTime();
        for (int i = 0; i < size ; i++) {
            if(findOne == arrayPrimitives[i]) {
                isFind = true;
                System.out.println("\t\tЧисло " + findOne + " найдено в позиции " + (i + 1));
                break;
            }
        }
        if (!isFind) System.out.println("\t\tЧисло " + findOne + " не найдено");
        //Отнимаем от текущего времени время начала перебора и получаем длительность операции в мс
        System.out.println("\t\tВремя поиска: " + (System.nanoTime() - lStartTime) / 1000000 + " ms");

        System.out.println("\tв массиве данных ссылочного типа:");
        isFind = false;
        lStartTime = System.nanoTime();
        for (int i = 0; i < size ; i++) {
            if(findTwo.equals(arrayLinks[i])) {
                isFind = true;
                System.out.println("\t\tЧисло " + findTwo + " найдено в позиции " + (i + 1));
                break;
            }
        }
        if (!isFind) System.out.println("\t\tЧисло " + findTwo + " не найдено");
        System.out.println("\t\tВремя поиска: " + (System.nanoTime() - lStartTime) / 1000000 + " ms");

        System.out.println("\tв массиве данных типа Box:");
        isFind = false;
        lStartTime = System.nanoTime();
        for (int i = 0; i < size ; i++) {
            if(findTThree.equals(arrayBoxes[i])) {
                isFind = true;
                System.out.println("\t\tЧисло " + findTThree + " найдено в позиции " + (i + 1));
                break;
            }
        }
        if (!isFind) System.out.println("\t\tЧисло " + findTwo + " не найдено");
        System.out.println("\t\tВремя поиска: " + (System.nanoTime() - lStartTime) / 1000000 + " ms");
    }
}
