package ir.dastan.uni.es.fp.services.impl;

import ir.dastan.uni.es.fp.services.Service;

import java.util.List;

public class DisplayListServiceImpl implements Service<DisplayListServiceImpl, Boolean, List<? extends Number>> {

    private List<? extends Number> list;

    @Override
    public DisplayListServiceImpl set(List<? extends Number> value) {
        this.list = value;
        return this;
    }

    @Override
    public Boolean perform() {
        int index = 0;
        for (index = 0; index < list.size(); index++) {
            if (index % 10 == 0 && index != 0) {
                System.out.println();
            }
            System.out.print(String.format("%-10d|", list.get(index)));
        }
        System.out.println();
        return true;
    }
}
