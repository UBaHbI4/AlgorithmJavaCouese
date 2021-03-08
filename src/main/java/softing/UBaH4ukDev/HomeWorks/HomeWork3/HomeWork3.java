package softing.UBaH4ukDev.HomeWorks.HomeWork3;

import softing.UBaH4ukDev.HomeWorks.HomeWork1.HomeWork1;

import java.util.*;

/****
 Project Course2Algorithm
 Package softing.UBaH4ukDev.HomeWorks.HomeWork3

 Created by Ivan Sheynmaer (softing.UBaH4ukDev)

 2021.03.06
 v1.0
 */
public class HomeWork3 {

    public static void main(String[] args) {
        /*
        Задание 3.1
        На основе массива из домашнего задания 2.1 реализуйте простой список и коллекцию.
        Оцените время выполнения преобразования.
        */
        task1();
        /*
        Задание 3.2
        На основе списка из задания 3.1 реализуйте основные методы добавления, удаления и получения объекта или элемента из списка.
        Оценить выполненные методы с помощью базового класса System.nanoTime().
        */
        task2();
        /*
        Задание 3.3
        Реализуйте простой односвязный список и его базовые методы.
        */
        task3();
        /*
        Задание 3.4
        На основе списка из задания 3.1 реализуйте простой двусторонний список и его базовые методы.
        Реализуйте список заполненный объектами из вашего класса из задания 1.3
        */
        task4();
        /*
        Задание 3.5
        Реализуйте итератор на основе связанных списков из задания 3.4 и выполните базовые операции итератора.
        Оцените время выполнения операций с помощью базового метода System.nanoTime()
        */
        task5();

    }

    private static void task5() {
        Random rnd = new Random();
        System.out.println("Задание 3.5");
        LinkedList<HomeWork1.Box> listBox = new LinkedList<>();
        listBox.insert(new HomeWork1.Box(rnd.nextInt(100)));
        listBox.insert(new HomeWork1.Box(rnd.nextInt(100)));
        listBox.insert(new HomeWork1.Box(rnd.nextInt(100)));
        listBox.insert(new HomeWork1.Box(rnd.nextInt(100)));
        listBox.display();
        System.out.println("\tУдаляем элемент");
        listBox.remove();
        listBox.display();
        Iterator<HomeWork1.Box> iterator = listBox.iterator();
        System.out.println("\tВыводим элементы с помощью итератора");
        long lStartTime = System.nanoTime();
        System.out.print("\t");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        System.out.println("\tПродолжительность операции " + (System.nanoTime() - lStartTime) / 1000000 + " ms");
    }

    private static void task4() {
        Random rnd = new Random();
        int size = 5;
        System.out.println("Задание 3.4");
        Integer[] array = new Integer[size];
        for(int i = 0; i < array.length; i++) {
            array[i] = rnd.nextInt(size);
        }
        List<Integer> list = new ArrayList<>();
        //Получили список из задания 3.1
        for (int element: array) {
            list.add(element);
        }
        System.out.println("\tИсходный список: " + list);
        LinkedList<Integer> lList = new LinkedList<>(list);
        System.out.print("\tДвусторонний список: ");
        lList.display();
        System.out.println("\tДобавляем элементы");
        lList.insert(rnd.nextInt(100));
        lList.insert(rnd.nextInt(100));
        lList.insert(rnd.nextInt(100));
        System.out.print("\tДвусторонний список: ");
        lList.display();
        System.out.print("\tСписок после удаления элемента");
        lList.remove();
        lList.display();
        int find = rnd.nextInt(size);
        System.out.println("\tПоиск " + find);
        System.out.println("\tНайден: " + lList.findItem(find));

        LinkedList<HomeWork1.Box> listBox = new LinkedList<>();
        listBox.display();
        listBox.insert(new HomeWork1.Box(rnd.nextInt(100)));
        listBox.insert(new HomeWork1.Box(rnd.nextInt(100)));
        listBox.insert(new HomeWork1.Box(rnd.nextInt(100)));
        listBox.insert(new HomeWork1.Box(rnd.nextInt(100)));
        System.out.print("\tСписок объектов класса Box из задания 1.3:");
        listBox.display();
        System.out.println("\tПоиск " + find);
        System.out.println("\tНайден: " + listBox.findItem(new HomeWork1.Box(rnd.nextInt(100))));
        listBox.display();
    }

    private static void task3() {
        System.out.println("Задание 3.3");
        SimpleLinkedList<String> simpleLinkCats = new SimpleLinkedList<>();
        simpleLinkCats.insert("Васька");
        simpleLinkCats.insert("Мурзик");
        simpleLinkCats.insert("Барсик");
        System.out.println("\tИщем кота Мурзика");
        System.out.println("\tНайден кот: " + simpleLinkCats.find("Мурзик"));
        System.out.println("\tСодержимое списка:");
        simpleLinkCats.display();
        System.out.println("\tУдаляем кота");
        simpleLinkCats.delete();
        System.out.println("\tСодержимое списка:");
        simpleLinkCats.display();
    }

    private static void task2() {
        Random rnd = new Random();
        List<Integer> list = new ArrayList<>();
        System.out.println("Задание 3.2");
        System.out.println("\tИсходный список: " + list);

        System.out.println("\tДобавляем элементы в список");
        long lStartTime = System.nanoTime();
        addItem(list, rnd.nextInt(100));
        addItem(list, rnd.nextInt(100));
        addItem(list, rnd.nextInt(100));
        System.out.println("\tПродолжительность операции " + (System.nanoTime() - lStartTime) / 1000000 + " ms");
        System.out.println("\tСписок после добавления элементов: " + list);

        System.out.println("\tПолучаем элементы списка");
        lStartTime = System.nanoTime();
        System.out.println("\tЭлемент списка: " + getItem(list, rnd.nextInt(list.size()-1)));
        System.out.println("\tПродолжительность операции " + (System.nanoTime() - lStartTime) / 1000000 + " ms");

        System.out.println("\tУдаляем элемент списка");
        lStartTime = System.nanoTime();
        System.out.println("\tУдален элемент " + removeItem(list, rnd.nextInt(list.size()-1)));
        System.out.println("\tПродолжительность операции " + (System.nanoTime() - lStartTime) / 1000000 + " ms");
        System.out.println("\tСписок после удаления элементов: " + list);
    }

    private static void task1() {
        Random rnd = new Random();
        int size = 20;
        System.out.println("Задание 3.1");
        Integer[] array = new Integer[size];
        System.out.println("\tЗаполнение массива случайными числами:");
        for(int i = 0; i < array.length; i++) {
            array[i] = rnd.nextInt(size);
        }
        System.out.println("\tИсходный массив: " + Arrays.toString(array));

        long lStartTime = System.nanoTime();
        List<Integer> list = new ArrayList<>();
        //Таким способом можно загнать весь массив в список одной строчкой кода Collections.addAll(list, array);
        for (int element: array) {
            list.add(element);
        }
        System.out.println("\tПродолжительность операции " + (System.nanoTime() - lStartTime) / 1000000 + " ms");
        System.out.println("\tПолученный список: " + list);

        lStartTime = System.nanoTime();
        Collection<Integer> collection = new ArrayList<>();
        //Таким способом можно загнать весь массив в список одной строчкой кода Collections.addAll(collection, array);
        for (int element: array) {
            collection.add(element);
        }
        System.out.println("\tПродолжительность операции " + (System.nanoTime() - lStartTime) / 1000000 + " ms");
        System.out.println("\tПолученная коллекция: " + collection);
    }

    public static void addItem(List<Integer> lst, int newItem) {
        lst.add(newItem);
    }
    public static int removeItem(List<Integer> lst, int indexItem) {
        try {
            return lst.remove(indexItem);
        } catch (Exception err) {
            System.out.println(err.getMessage());
            return -1;
        }
    }
    public static Integer getItem(List<Integer> lst, int index) {
        try {
            return lst.get(index);
        } catch (Exception err) {
            System.out.println(err.getMessage());
            return null;
        }
    }

    static class SimpleLink<T> {
        private T link;
        private SimpleLink<T> next;

        public SimpleLink(T link) {
            this.link = link;
        }

        public SimpleLink<T> getNext() {
            return next;
        }

        public void setNext(SimpleLink<T> next) {
            this.next = next;
        }

        public T getValue() {
            return link;
        }
    }
    static class SimpleLinkedList<T> {
        private SimpleLink<T> first;

        public SimpleLinkedList() {
            first = null;
        }

        public boolean isEmpty() {
            return (first == null);
        }

        public void insert(T link) {
            SimpleLink<T> l = new SimpleLink<>(link);
            l.setNext(first);
            this.first = l;
        }

        public SimpleLink<T> delete() {
            SimpleLink<T> temp = first;
            first = first.getNext();
            return temp;
        }

        public void display() {
            String out = "";
            SimpleLink<T> current = first;
            while (current != null) {
                if (out.equals("")){
                    out += current.getValue();
                } else {
                    out += ", " + current.getValue();
                }
                current = current.getNext();
            }
            System.out.println("\t" + out);
        }

        public T find(T searchNode) {
            SimpleLink<T> findNode = new SimpleLink<>(searchNode);
            SimpleLink<T> current = first;
            while (current != null) {
                if (current.getValue().equals(findNode.getValue())) {
                    return findNode.getValue();
                }
                current = current.getNext();
            }
            return null;
        }

    }

    static class Link<T> {
        private T item;
        private Link<T> prevItem;
        private Link<T> nextItem;

        public Link(T item) {
            this.item = item;
        }

        public Link<T> getNextItem() {
            return nextItem;
        }

        public void setNextItem(Link<T> nextItem) {
            this.nextItem = nextItem;
        }

        public Link<T> getPrevItem() {
            return prevItem;
        }

        public void setPrevItem(Link<T> prevItem) {
            this.prevItem = prevItem;
        }

        public T getItem() {
            return item;
        }

        @Override
        public String toString() {
            return "[" + item + "]";
        }
    }
    static class LinkedList<T> implements Iterator<T> {
        private Link<T> first;
        private boolean iterStart = false;

        public LinkedList() {
            first = null;
        }

        public LinkedList(List<T> items) {
            first = null;
            for (T itemValue: items)
                insert(itemValue);
        }

        public void insert(T newItem) {
            Link<T> addItem = new Link<>(newItem);
            if (first != null) {
                first.setNextItem(addItem);
                addItem.setPrevItem(first);
            }
            first = addItem;
        }

        public Link<T> findItem(T targetItem) {
            Link<T> current = first;
            Link<T> find = null;
            while (current != null) {
                if (targetItem.equals(current.getItem())) {
                    find = current;
                    break;
                } else if (current.getNextItem() != null && targetItem.equals(current.getNextItem().getItem())) {
                    find = current.getNextItem();
                    break;
                };
                current = current.getPrevItem();
            }
            return find;
        }


        public void display() {
            String out = "";
            Link<T> current = first;
            while (current != null) {
                if (out.equals("")){
                    out += current.getItem();
                } else {
                    out += ", " + current.getItem();
                }
                current = current.getPrevItem();
            }
            System.out.println("\t" + out);
        }

        @Override
        public void remove() {
            Link<T> deletedItem = findItem(first.getItem());
            if (deletedItem != null) {
                Link<T> prev = deletedItem.getPrevItem();
                Link<T> next = deletedItem.getNextItem();

                if (deletedItem.getNextItem() != null) {
                    deletedItem.setNextItem(null);
                }

            if (first.getPrevItem() != null)
                first = first.getPrevItem();
            } else
                first = null;
        }

        @Override
        public boolean hasNext() {
            return (!iterStart && first != null) || (iterStart && first != null && first.getPrevItem() != null);
        }

        @Override
        public T next() {
            T result = null;
            if (first != null) {
                if (iterStart && first.getPrevItem() != null) {
                    first = first.getPrevItem();
                }
                iterStart = true;
                result = first.getItem();
            }
            return result;
        }

        public Iterator<T> iterator() {
            return this;
        }
    }
}
