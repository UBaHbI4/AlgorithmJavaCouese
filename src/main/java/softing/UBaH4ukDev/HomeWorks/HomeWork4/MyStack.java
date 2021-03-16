package softing.UBaH4ukDev.HomeWorks.HomeWork4;


import java.util.Arrays;

/****
 Project Course2Algorithm
 Package softing.UBaH4ukDev.HomeWorks.HomeWork4

 Created by Ivan Sheynmaer (softing.UBaH4ukDev)

 2021.03.12
 v1.0
 */
public  class MyStack<T> {
    private int maxSize;
    private T[] stack;
    private int top;

    public T[] getStack() {
        return stack;
    }

    public void setStack(T[] stack) {
        this.stack = stack;
    }

    public MyStack(int size) {
        this.maxSize = size;
        this.stack = (T[]) new Object[maxSize];
        this.top = -1;
    }

    public void push(T value) {
        if (!this.isFull()) {
            this.stack[++this.top] = value;
        } else {
            System.out.println("\tСтек заполнен. Значение " + value + " не добавлено. ");
        }
    }

    public T pop() {
        return this.stack[this.top--];
    }

    public T peek() {
        return this.stack[this.top];
    }

    public boolean isEmpty() {
        return (this.top == -1);
    }

    public boolean isFull() {
        return (this.top == this.maxSize - 1);
    }

    public void display() {
        String printValue = "";
        for (int i = 0; i <= this.top; i++) {
            printValue += this.stack[i].toString() + " ";
        }
        System.out.println("\tНаш стек: " + (printValue.equals("")? "пуст":printValue));
    }

}
