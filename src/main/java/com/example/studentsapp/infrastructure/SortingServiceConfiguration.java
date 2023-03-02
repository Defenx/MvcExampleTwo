package com.example.studentsapp.infrastructure;

import com.example.studentsapp.domain.enums.SortingStrategyType;
import com.example.studentsapp.domain.service.sort.SortingService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Configuration
public class SortingServiceConfiguration {

    @Bean
    public Map<SortingStrategyType, SortingService> sortingStrategyTypeSortingServiceMap(
            List<SortingService> sortingServices
    ) {
        return sortingServices
                .stream()
                .collect(Collectors.toMap(SortingService::getSortingStrategyType, Function.identity()));
    }
}
