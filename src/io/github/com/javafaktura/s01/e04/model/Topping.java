package io.github.com.javafaktura.s01.e04.model;

public enum Topping {

    HAM(true),
    BACON(true),
    SALAMI(true),
    MUSHROOMS(false),
    TOMATO(false),
    ANANAS(false),
    CORN(false),
    CHEDDAR(false),
    GOUDA(false),
    MARJORAM(false),
    CHILLI(false),
    ROCKET(false);

    private final boolean meat;

    Topping(boolean meat) {
        this.meat = meat;
    }

    public boolean isMeat() {
        return meat;
    }
}
