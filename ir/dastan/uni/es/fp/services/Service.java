package ir.dastan.uni.es.fp.services;

public interface Service<T extends Service<T, R, V>, R, V> {

    T set(V value);

    R perform();

}
