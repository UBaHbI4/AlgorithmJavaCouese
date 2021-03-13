package softing.UBaH4ukDev.HomeWorks.HomeWork4;

/****
 Project Course2Algorithm
 Package softing.UBaH4ukDev.HomeWorks.HomeWork4

 Created by Ivan Sheynmaer (softing.UBaH4ukDev)

 2021.03.13
 v1.0
 */
public class StackTwoLink<T> {
    private ListTwoLink<T> listTwoLink;

    public StackTwoLink() {
        this.listTwoLink = new ListTwoLink<>();
    }

    public void push(T item) {
        listTwoLink.add(item);
    }

    public T pop() {
        T item = listTwoLink.hasNext() ? listTwoLink.next() : null;
        if (item != null) listTwoLink.remove();
        return item;
    }

    public boolean isEmpty() {
        return !listTwoLink.hasNext();
    }

    public void display() {
        listTwoLink.print();
    }
}
