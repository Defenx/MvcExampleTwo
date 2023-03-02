package com.example.lib.benchmark;

import java.time.Duration;
import java.util.function.Supplier;

public class BenchmarkImpl<R> implements Benchmark<R> {

    private final Supplier<R> supplier;

    private R result;

    private Duration duration;

    BenchmarkImpl(Supplier<R> supplier) {
        this.supplier = supplier;
    }

    @Override
    public Duration getDuration() {
        return duration;
    }

    @Override
    public R getResult() {
        return result;
    }

    @Override
    public void start() {

        long start = System.nanoTime();
        result = supplier.get();
        long end = System.nanoTime();

        duration = Duration.ofNanos(end - start);
    }
}
