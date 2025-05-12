package ir.dastan.uni.es.fp.services.impl;

import ir.dastan.uni.es.fp.services.Service;

public class DisplayTextServiceImpl implements Service<DisplayTextServiceImpl, Boolean, String> {

    private String display;

    @Override
    public DisplayTextServiceImpl set(String value) {
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
