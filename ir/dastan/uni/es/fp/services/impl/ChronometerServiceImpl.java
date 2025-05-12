package ir.dastan.uni.es.fp.services.impl;

import ir.dastan.uni.es.fp.entity.Algorithm;
import ir.dastan.uni.es.fp.services.Service;

import java.util.concurrent.TimeUnit;

public class ChronometerServiceImpl implements Service<ChronometerServiceImpl, Long, Algorithm> {

    private Algorithm algorithm;

    @Override
    public ChronometerServiceImpl set(Algorithm value) {
        this.algorithm = value;
        return this;
    }

    @Override
    public Long perform() {
        long start =System.nanoTime();
        algorithm.sort();
        long end =System.nanoTime();
        return end - start;
    }
}
