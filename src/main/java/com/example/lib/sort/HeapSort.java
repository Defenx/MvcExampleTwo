package com.example.lib.sort;

import java.util.ArrayList;
import java.util.List;

public class HeapSort implements Sortable {

    @Override
    public <T extends Comparable<T>> List<T> sort(List<T> toSort) {

        List<T> collect = new ArrayList<>(toSort);
        int n = collect.size();

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(collect, n, i);

        for (int i = n - 1; i >= 0; i--) {
            T temp = collect.get(0);
            collect.set(0, collect.get(i));
            collect.set(i, temp);
            heapify(collect, i, 0);
        }

        return collect;
    }

    <T extends Comparable<T>> void heapify(List<T> arr, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && arr.get(l).compareTo(arr.get(largest)) > 0)
            largest = l;
        if (r < n && arr.get(r).compareTo(arr.get(largest)) > 0)
            largest = r;
        if (largest != i) {
            T swap = arr.get(i);
            arr.set(i, arr.get(largest));
            arr.set(largest, swap);
            heapify(arr, n, largest);
        }
    }
}
