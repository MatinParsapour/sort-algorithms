package ir.dastan.uni.es.fp.services.impl;

import ir.dastan.uni.es.fp.services.Service;

public class DisplayNumberServiceImpl implements Service<DisplayNumberServiceImpl, Boolean, Long> {

    private Long display;

    @Override
    public DisplayNumberServiceImpl set(Long value) {
        this.display = value;
        return this;
    }

    @Override
    public Boolean perform() {
        System.out.println(display);
        return true;
    }

    public Boolean performInline() {
        System.out.print(display);
        return true;
    }
}
