package softing.UBaH4ukDev.HomeWorks.HomeWork4;

import softing.UBaH4ukDev.HomeWorks.HomeWork1.HomeWork1;
import softing.UBaH4ukDev.HomeWorks.HomeWork3.HomeWork3;

import java.util.*;

/****
 Project Course2Algorithm
 Package softing.UBaH4ukDev.HomeWorks.HomeWork4

 Created by Ivan Sheynmaer (softing.UBaH4ukDev)

 2021.03.12
 v1.0
 */
public class HomeWork4 {

    public static void main(String[] args) {
        /*
        Задание 4.1
        На основе данных объектного списка из задания 3.4 реализуйте простой стек и его базовые методы.
        Оцените время выполнения операций с помощью базового метода System.nanoTime().
        */
        task1();
        /*
        Задание 4.2
        На основе данных объектного списка из задания 3.4 реализуйте простую очередь и его базовые методы.
        Реализуйте вспомогательные методы.
        Оцените время выполнения операций с помощью базового метода System.nanoTime().
        */
        task2();
        /*
        Задание 4.3
        На основе данных объектного списка из задания 3.4 реализуйте простой дек и его базовые методы.
        Оцените время выполнения операций с помощью базового метода System.nanoTime().
        */
        task3();
        /*
        Задание 4.4
        Реализуйте приоритетную очередь на основе ссылочных типов данных, например, integer.
        Оцените время выполнения операций с помощью базового метода System.nanoTime().
        */
        task4();
        /*
        Задание 4.5
        На основе данных из задания 4.1 и 4.2, реализуйте стек и очередь на базе связанного списка.
        Оцените время выполнения операций с помощью базового метода System.nanoTime().
        */
        task5();
    }

    private static void task5() {
        System.out.println("Задание 4.5");
        System.out.println("\tCтек на базе связанного списка");
        System.out.println("\tЗаполнение стека");
        long lStartTime = System.nanoTime();
        StackTwoLink<String> stackTwoLink = new StackTwoLink<>();
        stackTwoLink.push("Анна");
        stackTwoLink.push("Елизавета");
        stackTwoLink.push("Екатерина");
        stackTwoLink.push("Александр");
        stackTwoLink.push("Иван");
        System.out.println("\tПродолжительность операции " + (System.nanoTime() - lStartTime) + " ns");
        System.out.print("\tНаш стек: ");
        stackTwoLink.display();
        System.out.println();

        System.out.println("\tБазовый стек: ");
        System.out.println("\tЗаполнение стека");
        Stack<String> stack = new Stack<>();
        lStartTime = System.nanoTime();
        while (!stackTwoLink.isEmpty()) {
            stack.push(stackTwoLink.pop());
        }
        System.out.println("\tПродолжительность операции " + (System.nanoTime() - lStartTime) + " ns");
        System.out.println("\tБазовый стек вывод:");
        lStartTime = System.nanoTime();
        while (!stack.isEmpty()) {
            System.out.print("\t" + stack.pop() + "; ");
        }
        System.out.println();
        System.out.println("\tПродолжительность операции " + (System.nanoTime() - lStartTime) + " ns");
        System.out.println();

        //
        System.out.println("\tОчередь на базе связанного списка");
        System.out.println("\tЗаполнение очереди");
        lStartTime = System.nanoTime();
        QueueTwoLink<String> QueueTwoLink = new QueueTwoLink<>();
        QueueTwoLink.push("Анна");
        QueueTwoLink.push("Елизавета");
        QueueTwoLink.push("Екатерина");
        QueueTwoLink.push("Александр");
        QueueTwoLink.push("Иван");
        System.out.println("\tПродолжительность операции " + (System.nanoTime() - lStartTime) + " ns");
        System.out.print("\tЗаполненная очередь: ");
        QueueTwoLink.display();
        System.out.println();

        System.out.println("\tБазовая очередь: ");
        System.out.println("\tЗаполнение очереди");
        lStartTime = System.nanoTime();
        Queue<String> queue = new LinkedList<>();
        while (!QueueTwoLink.isEmpty()) {
            queue.add(QueueTwoLink.pop());
        }
        System.out.println("\tПродолжительность операции " + (System.nanoTime() - lStartTime) + " ns");
        System.out.println("\tБазовая очередь вывод: ");
        lStartTime = System.nanoTime();
        while (!queue.isEmpty()) {
            System.out.print("\t" + queue.poll() + "; ");
        }
        System.out.println();
        System.out.println("\tПродолжительность операции " + (System.nanoTime() - lStartTime) + " ns");
    }

    private static void task4() {
        System.out.println("Задание 4.4");
        Random rnd = new Random();
        int size = 5;


        MyPriorityQue myPriorityQue = new MyPriorityQue(size);
        System.out.println("\tДелаем push(new MyPriorityItem(\"Иван\", 36));");
        long lStartTime = System.nanoTime();
        myPriorityQue.push(new MyPriorityItem("Иван", 36));
        System.out.println("\tПродолжительность операции " + (System.nanoTime() - lStartTime) + " ns");
        myPriorityQue.display();
        System.out.println();

        System.out.println("\tДелаем push(new MyPriorityItem(\"Иван\", 36));");
        lStartTime = System.nanoTime();
        myPriorityQue.push(new MyPriorityItem("Александр", 8));
        System.out.println("\tПродолжительность операции " + (System.nanoTime() - lStartTime) + " ns");
        myPriorityQue.display();
        System.out.println();

        System.out.println("\tДелаем push(new MyPriorityItem(\"Анна\", 5));");
        lStartTime = System.nanoTime();
        myPriorityQue.push(new MyPriorityItem("Анна", 5));
        System.out.println("\tПродолжительность операции " + (System.nanoTime() - lStartTime) + " ns");
        myPriorityQue.display();
        System.out.println();

        System.out.println("\tДелаем push(new MyPriorityItem(\"Елизавета\", 5));");
        lStartTime = System.nanoTime();
        myPriorityQue.push(new MyPriorityItem("Елизавета", 5));
        System.out.println("\tПродолжительность операции " + (System.nanoTime() - lStartTime) + " ns");
        myPriorityQue.display();
        System.out.println();

        System.out.println("\tДелаем push(new MyPriorityItem(\"Екатерина\", 29));");
        lStartTime = System.nanoTime();
        myPriorityQue.push(new MyPriorityItem("Екатерина", 29));
        System.out.println("\tПродолжительность операции " + (System.nanoTime() - lStartTime) + " ns");
        myPriorityQue.display();
        System.out.println();

        System.out.println("\tДелаем pop();");
        lStartTime = System.nanoTime();
        myPriorityQue.pop();
        System.out.println("\tПродолжительность операции " + (System.nanoTime() - lStartTime) + " ns");
        myPriorityQue.display();
        System.out.println();

        System.out.println("\tДелаем peek;");
        lStartTime = System.nanoTime();
        System.out.println("\tpeek вернул " + myPriorityQue.peek().toString());
        System.out.println("\tПродолжительность операции " + (System.nanoTime() - lStartTime) + " ns");
        myPriorityQue.display();
        System.out.println();

        System.out.println("\tДелаем peek;");
        lStartTime = System.nanoTime();
        System.out.println("\tpeekLast вернул " + myPriorityQue.peekLast().toString());
        System.out.println("\tПродолжительность операции " + (System.nanoTime() - lStartTime) + " ns");
        myPriorityQue.display();
    }

    private static void task3() {
        System.out.println("Задание 4.3");
        Random rnd = new Random();
        int size = 5;
        HomeWork3.LinkedList<HomeWork1.Box> listBox = new HomeWork3.LinkedList<>();
        for (int i = 0; i < size; i++) {
            listBox.insert(new HomeWork1.Box(rnd.nextInt(100)));
        }
        System.out.println("\tИсходный объектный список из задания 3.4:");
        listBox.display();
        System.out.println();
        MyDeque<HomeWork1.Box> myDeque = new MyDeque<>(size);

        System.out.println("\tЗаполним очередь из списка задания 3.4 с помощью pushBack");
        long lStartTime = System.nanoTime();
        Iterator<HomeWork1.Box> iterator = listBox.iterator();
        while (iterator.hasNext()) {
            myDeque.pushBack(iterator.next());
        }
        System.out.println("\tПродолжительность операции " + (System.nanoTime() - lStartTime) + " ns");
        myDeque.display();
        System.out.println();

        System.out.println("\tДелаем peekFront()");
        lStartTime = System.nanoTime();
        System.out.println("\tpeekFront return" + myDeque.peekFront().toString());
        System.out.println("\tПродолжительность операции " + (System.nanoTime() - lStartTime) + " ns");
        myDeque.display();
        System.out.println();

        System.out.println("\tДелаем peekBack()");
        lStartTime = System.nanoTime();
        System.out.println("\tpeekBack return" + myDeque.peekBack().toString());
        System.out.println("\tПродолжительность операции " + (System.nanoTime() - lStartTime) + " ns");
        myDeque.display();
        System.out.println();



        System.out.println("\tДелаем popFront");
        lStartTime = System.nanoTime();
        myDeque.popFront();
        System.out.println("\tПродолжительность операции " + (System.nanoTime() - lStartTime) + " ns");
        myDeque.display();
        System.out.println();

        System.out.println("\tДелаем popBack");
        lStartTime = System.nanoTime();
        myDeque.popBack();
        System.out.println("\tПродолжительность операции " + (System.nanoTime() - lStartTime) + " ns");
        myDeque.display();
        System.out.println();

        System.out.println("\tДелаем popFront");
        lStartTime = System.nanoTime();
        myDeque.popFront();
        System.out.println("\tПродолжительность операции " + (System.nanoTime() - lStartTime) + " ns");
        myDeque.display();
        System.out.println();

        System.out.println("\tДелаем popFront");
        lStartTime = System.nanoTime();
        myDeque.popFront();
        System.out.println("\tПродолжительность операции " + (System.nanoTime() - lStartTime) + " ns");
        myDeque.display();
        System.out.println();

        //И еще раз, чтобы очистить полностью
        System.out.println("\tДелаем popFront");
        lStartTime = System.nanoTime();
        myDeque.popFront();
        System.out.println("\tПродолжительность операции " + (System.nanoTime() - lStartTime) + " ns");
        myDeque.display();
        System.out.println();

        System.out.println("\tДелаем pushFront (new HomeWork1.Box(2))");
        lStartTime = System.nanoTime();
        myDeque.pushFront(new HomeWork1.Box(2));
        System.out.println("\tПродолжительность операции " + (System.nanoTime() - lStartTime) + " ns");
        myDeque.display();
        System.out.println();

        System.out.println("\tДелаем pushFront new (HomeWork1.Box(1))");
        lStartTime = System.nanoTime();
        myDeque.pushFront(new HomeWork1.Box(1));
        System.out.println("\tПродолжительность операции " + (System.nanoTime() - lStartTime) + " ns");
        myDeque.display();
        System.out.println();

        System.out.println("\tДелаем pushBack new (HomeWork1.Box(3))");
        lStartTime = System.nanoTime();
        myDeque.pushBack(new HomeWork1.Box(3));
        System.out.println("\tПродолжительность операции " + (System.nanoTime() - lStartTime) + " ns");
        myDeque.display();
        System.out.println();

        System.out.println("\tСмотрим, что все добавилось в том порядке, как мы хотели.");
    }

    private static void task2() {
        System.out.println("Задание 4.2");
        Random rnd = new Random();
        int size = 5;
        HomeWork3.LinkedList<HomeWork1.Box> listBox = new HomeWork3.LinkedList<>();
        for (int i = 0; i < size; i++) {
            listBox.insert(new HomeWork1.Box(rnd.nextInt(100)));
        }
        System.out.println("\tИсходный объектный список из задания 3.4:");
        listBox.display();
        System.out.println();
        MyQueue<HomeWork1.Box> myQueue = new MyQueue<>(size);
        System.out.println("\tЗаполняем очередь значениями на основе данных объектного списка из задания 3.4");
        long lStartTime = System.nanoTime();
        Iterator<HomeWork1.Box> iterator = listBox.iterator();
        while (iterator.hasNext()) {
            myQueue.insert(iterator.next());
        }
        System.out.println("\tПродолжительность операции " + (System.nanoTime() - lStartTime) + " ns");
        myQueue.display();

        System.out.println();
        System.out.println("\tВызов метода peek вернул объект Box, который в очередь пришел первым.");
        lStartTime = System.nanoTime();
        HomeWork1.Box tempBox = myQueue.peek();
        System.out.println("\t" + tempBox.toString());

        System.out.println("\tПродолжительность операции " + (System.nanoTime() - lStartTime) + " ns");
        System.out.println();
        System.out.println("\tВызов pop для всех элементов очереди.");
        lStartTime = System.nanoTime();
        while (!myQueue.isEmpty()) {
            System.out.println("\t" + myQueue.remove().toString());
        }
        System.out.println("\tПродолжительность операции " + (System.nanoTime() - lStartTime) + " ns");
        myQueue.display();
        System.out.println();

        System.out.println("\tДобавим элементы в очередь и выведем");
        myQueue.insert(new HomeWork1.Box(rnd.nextInt(100)));
        myQueue.insert(new HomeWork1.Box(rnd.nextInt(100)));
        myQueue.insert(new HomeWork1.Box(rnd.nextInt(100)));
        myQueue.display();
    }

    private static void task1() {
        System.out.println("Задание 4.1");
        Random rnd = new Random();
        int size = 5;
        HomeWork3.LinkedList<HomeWork1.Box> listBox = new HomeWork3.LinkedList<>();
        for (int i = 0; i < size; i++) {
            listBox.insert(new HomeWork1.Box(rnd.nextInt(100)));
        }
        System.out.println("\tИсходный объектный список из задания 3.4:");
        listBox.display();
        System.out.println();
        //Сделаем размер стека меньше списка на 1. Чтобы проверить метод isFull
        MyStack<HomeWork1.Box> myStack = new MyStack<>(size - 1);
        System.out.println("\tЗаполняем стек значениями на основе данных объектного списка из задания 3.4");
        long lStartTime = System.nanoTime();
        Iterator<HomeWork1.Box> iterator = listBox.iterator();
        while (iterator.hasNext()) {
            myStack.push(iterator.next());
        }
        System.out.println("\tПродолжительность операции " + (System.nanoTime() - lStartTime) + " ns");
        myStack.display();

        System.out.println();
        System.out.println("\tВызов метода peek вернул объект Box, который в стек пришел последним.");
        lStartTime = System.nanoTime();
        HomeWork1.Box tempBox = myStack.peek();
        System.out.println("\t" + tempBox.toString());

        System.out.println("\tПродолжительность операции " + (System.nanoTime() - lStartTime) + " ns");
        System.out.println();
        System.out.println("\tВызов pop для всех элементов стека.");
        lStartTime = System.nanoTime();
        while (!myStack.isEmpty()) {
            System.out.println("\t" + myStack.pop().toString());
        }
        System.out.println("\tПродолжительность операции " + (System.nanoTime() - lStartTime) + " ns");
        myStack.display();
        System.out.println();

        System.out.println("\tДобавим элементы в стек и выведем");
        myStack.push(new HomeWork1.Box(rnd.nextInt(100)));
        myStack.push(new HomeWork1.Box(rnd.nextInt(100)));
        myStack.push(new HomeWork1.Box(rnd.nextInt(100)));
        myStack.display();
    }
}
