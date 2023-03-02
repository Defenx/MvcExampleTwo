package com.example.studentsapp.domain.service.sort.impl;

import com.example.lib.sort.BubbleSort;
import com.example.lib.sort.Sortable;
import com.example.studentsapp.domain.enums.SortingStrategyType;
import com.example.studentsapp.domain.service.sort.SortingService;
import org.springframework.stereotype.Service;

@Service
public class BubbleSortingService implements SortingService {

    @Override
    public SortingStrategyType getSortingStrategyType() {
        return SortingStrategyType.BUBBLE;
    }

    @Override
    public Sortable getSortable() {
        return new BubbleSort();
    }
}
