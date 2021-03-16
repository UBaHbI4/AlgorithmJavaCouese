package softing.UBaH4ukDev.HomeWorks.HomeWork4;

import javax.swing.plaf.IconUIResource;
import java.util.Arrays;
import java.util.Collections;

/****
 Project Course2Algorithm
 Package softing.UBaH4ukDev.HomeWorks.HomeWork4

 Created by Ivan Sheynmaer (softing.UBaH4ukDev)

 2021.03.13
 v1.0
 */
public class MyPriorityQue  {


    private int rear;
    private int front;
    private int countItems;
    private int maxSize;
    private MyPriorityItem[] que;

    public MyPriorityQue(int size){
        maxSize = size;
        que =  new MyPriorityItem[maxSize];
        front = -1;
        rear = 0;
        countItems = 0;
    }

    public void push(MyPriorityItem item) {
        if (countItems < maxSize) {
            que[++front] = item;
            sort();
            countItems++;
        }
    }

    public void pop() {
        MyPriorityItem tempValue;
        if (countItems > 0) {

            for (int i = 0; i < countItems - 1; i++) {
                tempValue = que[i];
                que[i] = que[i + 1];
                que[i + 1] = tempValue;
            }
            que[countItems - 1] = null;
            countItems--;
            front--;
        }
    }

    public MyPriorityItem peek () {
        return que[rear];
    }

    public MyPriorityItem peekLast () {
        return que[front];
    }

    private void sort () {
        boolean sorted = false;
        MyPriorityItem tempValue;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < countItems; i++) {
                if ((Integer)que[i].getAge() > ((Integer)que[i + 1].getAge())) {
                    sorted = false;
                    tempValue = que[i];
                    que[i] = que[i + 1];
                    que[i + 1] = tempValue;
                }
            }
        }
    }

    public void display() {
        String printValue = "";
        for (int i = 0; i < this.countItems; i++) {
            printValue += que[i].toString() + " ";
        }
        System.out.println("\tНаша очередь: " + (printValue.equals("")? "пуста":printValue));
    }


}
