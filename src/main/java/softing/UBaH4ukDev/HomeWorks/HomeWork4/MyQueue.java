package softing.UBaH4ukDev.HomeWorks.HomeWork4;

/****
 Project Course2Algorithm
 Package softing.UBaH4ukDev.HomeWorks.HomeWork4

 Created by Ivan Sheynmaer (softing.UBaH4ukDev)

 2021.03.12
 v1.0
 */
public class MyQueue<T> {
    private int maxSize;
    private T[] queue;
    private int front;
    private int rear;
    private int itemsCount;

    public MyQueue(int size) {
        maxSize = size;
        queue = (T[]) new Object[maxSize];
        front = 0;
        rear = -1;
        itemsCount = 0;
    }

    public void insert(T newItem) {
        if (rear == maxSize - 1)
            rear = -1;
        queue[++rear] = newItem;
        itemsCount++;
    }

    public T remove() {
        T temp = queue[front++];
        if (front == maxSize)
            front = 0;
        itemsCount--;
        return temp;
    }

    public T peek() {
        return queue[front];
    }

    public boolean isEmpty () {
        return (itemsCount == 0);
    }

    public boolean isFull() {
        return (itemsCount == maxSize);
    }

    public int size() {
        return itemsCount;
    }

    public void display() {
        String printValue = "";
        for (int i = 0; i < this.itemsCount; i++) {
            printValue += queue[i].toString() + " ";
        }
        System.out.println("\tНаша очередь: " + (printValue.equals("")? "пуста":printValue));
    }
}
