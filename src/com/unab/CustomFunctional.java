package com.unab;

@FunctionalInterface
public interface CustomFunctional<T, R> {

    String saludame(String nombre);

    default String defaultSaludo() {
        return saludame("Pastor");
    };

}
