package softing.UBaH4ukDev.HomeWorks.HomeWork4;

/****
 Project Course2Algorithm
 Package softing.UBaH4ukDev.HomeWorks.HomeWork4

 Created by Ivan Sheynmaer (softing.UBaH4ukDev)

 2021.03.13
 v1.0
 */
public class MyDeque <T> {
    private int maxSize;
    private T[] deque;
    private int front;
    private int rear;
    private int itemsCount;

    public MyDeque(int size) {
        maxSize = size;
        deque = (T[]) new Object[maxSize];
        front = -1;
        rear = 0;
        itemsCount = 0;
    }

    public void pushFront(T item) {
        T tempValue;
        if ((itemsCount < maxSize)) {
            for (int i = itemsCount; i > 0; i--) {
                tempValue = deque[i];
                deque[i] = deque[i - 1];
                deque[i - 1] = tempValue;
            }
            deque[rear] = item;
            itemsCount++;
            front++;
        }
    }

    public void pushBack(T item) {
        T tempValue;
        if ((itemsCount < maxSize)) {
            deque[++front] = item;
            itemsCount++;
        }
    }

    public void popFront() {
        T tempValue;
        if ((itemsCount <= maxSize)) {
            for (int i = 0; i < itemsCount - 1; i++) {
                tempValue = deque[i];
                deque[i] = deque[i +1];
                deque[i + 1] = tempValue;
            }
            itemsCount--;
            front--;
        }
    }

    public void popBack() {
        T tempValue;
        if ((itemsCount < maxSize)) {
            deque[front--] = null;
            itemsCount--;
        }
    }

    public T peekFront() {
        return deque[rear];
    }

    //просто просмотреть последний элемент в деке
    public T peekBack() {
        return deque[front];
    }

    public void display() {
        String printValue = "";
        for (int i = 0; i < this.itemsCount; i++) {
            printValue += deque[i].toString() + " ";
        }
        System.out.println("\tНаша очередь: " + (printValue.equals("")? "пуста":printValue));
    }
}
