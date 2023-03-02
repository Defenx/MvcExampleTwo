package com.example.lib.sort;

import java.util.ArrayList;
import java.util.List;

public class MergeSort implements Sortable {

    @Override
    public <T extends Comparable<T>> List<T> sort(List<T> toSort) {
        List<T> collect = new ArrayList<>(toSort);

        sort(collect, 0, collect.size() - 1);

        return collect;
    }

    @SuppressWarnings("unchecked")
    <T extends Comparable<T>> void merge(List<T> arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        T[] L = (T[])new Comparable[n1];
        T[] R = (T[])new Comparable[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr.get(l + i);
        for (int j = 0; j < n2; ++j)
            R[j] = arr.get(m + 1 + j);

        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (L[i].compareTo(R[j]) <= 0) {
                arr.set(k, L[i]);
                i++;
            } else {
                arr.set(k, R[i]);
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr.set(k, L[i]);
            i++;
            k++;
        }

        while (j < n2) {
            arr.set(k, R[i]);
            j++;
            k++;
        }
    }

    <T extends Comparable<T>> void sort(List<T> arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;

            sort(arr, l, m);
            sort(arr, m + 1, r);

            merge(arr, l, m, r);
        }
    }
}
