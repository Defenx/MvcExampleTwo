package com.example.lib.sort;

import java.util.ArrayList;
import java.util.List;

public class BubbleSort implements Sortable {

    @Override
    public <T extends Comparable<T>> List<T> sort(List<T> toSort) {


        List<T> collect = new ArrayList<>(toSort);

        var len = collect.size();

        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (collect.get(j + 1).compareTo(collect.get(j)) < 0) {
                    T swap = collect.get(j);
                    collect.set(j, collect.get(j + 1));
                    collect.set(j + 1, swap);
                }
            }
        }

        return collect;
    }
}
