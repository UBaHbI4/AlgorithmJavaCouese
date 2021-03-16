package softing.UBaH4ukDev.HomeWorks.HomeWork4;

import java.util.Iterator;
import java.util.List;

/****
 Project Course2Algorithm
 Package softing.UBaH4ukDev.HomeWorks.HomeWork4

 Created by Ivan Sheynmaer (softing.UBaH4ukDev)

 2021.03.13
 v1.0
 */
public class ListTwoLink<T> implements Iterator<T> {
    private ListTwoLinkItem<T> item;
    private boolean iterStart = false;

    public ListTwoLink() {
        item = null;
    }

    public ListTwoLink(List<T> items) {
        item = null;
        for (T itemValue: items)
            add(itemValue);
    }

    @Override
    public void remove() {
        delete(item);
    }

    @Override
    public boolean hasNext() {
        return (!iterStart && item != null) || (iterStart && item != null && item.getPrev() != null);
    }

    @Override
    public T next() {
        T result = null;
        if (item != null) {
            if (iterStart && item.getPrev() != null) {
                item = item.getPrev();
            }
            iterStart = true;
            result = item.getItem();
        }
        return result;
    }

    public void add(T newItem) {
        ListTwoLinkItem<T> addedItem = new ListTwoLinkItem<>(newItem);
        if (item != null) {
            item.setNext(addedItem);
            addedItem.setPrev(item);
        }
        item = addedItem;
    }

    public ListTwoLinkItem<T> addFirst(T newItem) {
        ListTwoLinkItem<T> firstItem = item;
        ListTwoLinkItem<T> prevItem = firstItem != null ? firstItem.getPrev() : null;
        while (prevItem != null) {
            firstItem = prevItem;
            prevItem = firstItem.getPrev();
        }

        ListTwoLinkItem<T> addedItem = new ListTwoLinkItem<>(newItem);
        if (firstItem != null) {
            addedItem.setNext(firstItem);
            firstItem.setPrev(addedItem);
        } else { //добавляется самый первый элемент
            item.setNext(addedItem);
            addedItem.setPrev(item);
            item = addedItem;
        }

        return addedItem;
    }


    public ListTwoLinkItem<T> find(T targetItem) {
        ListTwoLinkItem<T> curItem = item;
        ListTwoLinkItem<T> result = null;
        while (curItem != null) {
            if (targetItem.equals(curItem.getItem())) {
                result = curItem;
                break;
            } else if (curItem.getNext() != null && targetItem.equals(curItem.getNext().getItem())) {
                result = curItem.getNext();
                break;
            };
            curItem = curItem.getPrev();
        }
        return result;
    }

    public ListTwoLinkItem<T> find(ListTwoLinkItem<T> targetItem) {
        ListTwoLinkItem<T> curItem = item;
        ListTwoLinkItem<T> result = null;
        while (curItem != null) {
            if (targetItem.equals(curItem)) {
                result = curItem;
                break;
            } else if (curItem.getNext() != null && targetItem.equals(curItem.getNext())) {
                result = curItem.getNext();
                break;
            };
            curItem = curItem.getPrev();
        }
        return result;
    }

    public void delete(ListTwoLinkItem<T> item) {
        delete(item, true);
    }
    public void delete(ListTwoLinkItem<T> findItem, boolean existNexnPrev) {
        ListTwoLinkItem<T> deletedItem = existNexnPrev ? find(findItem.getItem()) : find(findItem);
        if (deletedItem != null) {
            ListTwoLinkItem<T> prev = deletedItem.getPrev();
            ListTwoLinkItem<T> next = deletedItem.getNext();
            if (prev != null) prev.setNext(next);
            if (next != null) next.setPrev(prev);

            if (prev == null && next == null && deletedItem.equals(item)) item = null;
        }
    }

    public void print() {
        ListTwoLinkItem<T> curItem = item;
        while (curItem != null) {
            System.out.print(curItem.getItem() + "; ");
            curItem = curItem.getPrev();
        }
        System.out.println();
    }

    //задание 3.5
    public Iterator<T> iterator() {
        return this;
    }

    public ListTwoLinkItem<T> getItem() {
        return item;
    }
}
