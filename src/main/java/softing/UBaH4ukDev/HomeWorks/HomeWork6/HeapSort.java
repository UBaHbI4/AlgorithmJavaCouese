package softing.UBaH4ukDev.HomeWorks.HomeWork6;

/****
 Project Course2Algorithm
 Package softing.UBaH4ukDev.HomeWorks.HomeWork6

 Created by Ivan Sheynmaer (softing.UBaH4ukDev)

 2021.03.20
 v1.0
 */
public class HeapSort {
    private static int heapSize;

    public static int[] sort(int[] a) {
        buildHeap(a);
        while (heapSize > 1) {
            swap(a, 0, heapSize - 1);
            heapSize--;
            heapify(a, 0);
        }
        return a;
    }

    private static void buildHeap(int[] a) {
        heapSize = a.length;
        for (int i = a.length / 2; i >= 0; i--) {
            heapify(a, i);
        }
    }

    private static void heapify(int[] a, int i) {
        int l = left(i);
        int r = right(i);
        int largest = i;

        if (l < heapSize && a[i] < a[l]) {
            largest = l;
        }

        if (r < heapSize && a[largest] < a[r]) {
            largest = r;
        }

        if (i != largest) {
            swap(a, i , largest);
            heapify(a, largest);
        }
    }

    private static int right(int i) {
        return 2 * i + 2;
    }

    private static int left (int i) {
        return 2 * i + 1;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
