package ir.dastan.uni.es.fp.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Algorithm {

    protected final List<Integer> list = new ArrayList<>();
    protected boolean isSorted = false;

    public void populate(long size) {
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            list.add(random.nextInt(10000));
        }
    }

    public abstract void sort();

    public void clear() {
        list.clear();
        isSorted = false;
    }

    public List<Integer> getList() {return list;}

    public boolean isSorted() {return isSorted;}
}
