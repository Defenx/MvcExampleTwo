package com.example.lib.benchmark;

import java.time.Duration;

public interface Benchmark<R> {

    Duration getDuration();

    R getResult();

    void start();
}
