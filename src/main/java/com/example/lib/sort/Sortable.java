package com.example.lib.sort;

import java.util.List;

public interface Sortable {

    <T extends Comparable<T>> List<T> sort(List<T> toSort);
}
