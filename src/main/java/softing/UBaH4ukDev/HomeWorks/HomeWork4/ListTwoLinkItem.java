package softing.UBaH4ukDev.HomeWorks.HomeWork4;

import java.util.Objects;

/****
 Project Course2Algorithm
 Package softing.UBaH4ukDev.HomeWorks.HomeWork4

 Created by Ivan Sheynmaer (softing.UBaH4ukDev)

 2021.03.13
 v1.0
 */
public class ListTwoLinkItem<T> {
    private T item;
    private ListTwoLinkItem<T> prevItem;
    private ListTwoLinkItem<T> nextItem;

    public ListTwoLinkItem(T item) {
        this.item = item;
    }

    public ListTwoLinkItem<T> getNext() {
        return nextItem;
    }

    public void setNext(ListTwoLinkItem<T> nextItem) {
        this.nextItem = nextItem;
    }

    public ListTwoLinkItem<T> getPrev() {
        return prevItem;
    }

    public void setPrev(ListTwoLinkItem<T> prevItem) {
        this.prevItem = prevItem;
    }

    public T getItem() {
        return item;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListTwoLinkItem<?> that = (ListTwoLinkItem<?>) o;
        return Objects.equals(item, that.item) &&
                Objects.equals(prevItem, that.prevItem) &&
                Objects.equals(nextItem, that.nextItem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item, prevItem, nextItem);
    }

    @Override
    public String toString() {
        return item + "";
    }
}