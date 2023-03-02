package com.example.studentsapp.domain.service.sort.impl;

import com.example.lib.sort.HeapSort;
import com.example.lib.sort.Sortable;
import com.example.studentsapp.domain.enums.SortingStrategyType;
import com.example.studentsapp.domain.service.sort.SortingService;
import org.springframework.stereotype.Service;

@Service
public class HeapSortingService implements SortingService {
    @Override
    public SortingStrategyType getSortingStrategyType() {
        return SortingStrategyType.HEAP;
    }

    @Override
    public Sortable getSortable() {
        return new HeapSort();
    }
}
