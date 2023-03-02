package com.example.studentsapp.domain.service.sort.impl;

import com.example.lib.sort.MergeSort;
import com.example.lib.sort.Sortable;
import com.example.studentsapp.domain.enums.SortingStrategyType;
import com.example.studentsapp.domain.service.sort.SortingService;
import org.springframework.stereotype.Service;

@Service
public class MergeSortingService implements SortingService {
    @Override
    public SortingStrategyType getSortingStrategyType() {
        return SortingStrategyType.MERGE;
    }

    @Override
    public Sortable getSortable() {
        return new MergeSort();
    }
}
