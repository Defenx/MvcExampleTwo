package com.example.lib.benchmark;


import java.util.function.Supplier;

public class BenchmarkBuilder<R> {

    private Supplier<R> supplier;

    public BenchmarkBuilder<R> supplier(Supplier<R> supplier) {
        this.supplier = supplier;

        return this;
    }

    public static <R> BenchmarkBuilder<R> of() {
        return new BenchmarkBuilder<>();
    }

    public Benchmark<R> build() {
        return new BenchmarkImpl<>(supplier);
    }
}
