package com.example.studentsapp.domain.service.sort;

import com.example.lib.sort.Sortable;
import com.example.studentsapp.domain.enums.SortingStrategyType;

import java.util.List;

public interface SortingService {

    default <T extends Comparable<T>> List<T> sort(List<T> toSort) {
        return getSortable().sort(toSort);
    }

    SortingStrategyType getSortingStrategyType();

    Sortable getSortable();
}
