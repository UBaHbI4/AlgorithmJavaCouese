package softing.UBaH4ukDev.HomeWorks.HomeWork4;

/****
 Project Course2Algorithm
 Package softing.UBaH4ukDev.HomeWorks.HomeWork4

 Created by Ivan Sheynmaer (softing.UBaH4ukDev)

 2021.03.13
 v1.0
 */
public class QueueTwoLink<T> {
    private ListTwoLink<T> link;
    private ListTwoLinkItem<T> first;

    public QueueTwoLink() {
        this.link = new ListTwoLink<>();
    }


    public void push(T item) {
        link.add(item);
        if (first == null) first = link.getItem();
    }


    public T pop() {
        T item = null;
        if (first != null) {
            item = first.getItem();
            link.delete(first, false);
            first = first.getNext();
        }
        return item;
    }


    public T peek() {
        return first == null ? null : first.getItem();
    }

    public boolean isEmpty() {
        return !link.hasNext();
    }


    public void display() {
        link.print();
    }
}
