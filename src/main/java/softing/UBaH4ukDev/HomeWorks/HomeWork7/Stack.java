package softing.UBaH4ukDev.HomeWorks.HomeWork7;

/****
 Project Course2Algorithm
 Package softing.UBaH4ukDev.HomeWorks.HomeWork7

 Created by Ivan Sheynmaer (softing.UBaH4ukDev)

 2021.03.24
 v1.0
 */
public class Stack {
    private int maxSize;
    private int[] stackArr;
    private int top;

    public Stack(int size) {
        this.maxSize = size;
        this.stackArr = new int[size];
        this.top = -1;
    }

    public void push (int i) {
        stackArr[++top] = i;
    }

    public int pop() {
        return stackArr[top--];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public int peek() {
        return stackArr[top];
    }

}


