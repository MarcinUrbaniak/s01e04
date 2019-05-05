package io.github.com.javafaktura.s01.e04.model;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private final String name;
    private Dough dough;
    private Sauce sauce;
    private Size size;
    private List<Topping> toppings = new ArrayList<>();

    public Pizza(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public void setSauce(Sauce sauce) {
        this.sauce = sauce;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "name='" + name + '\'' +
                ", dough='" + dough + '\'' +
                ", sauce='" + sauce + '\'' +
                ", size='" + size + '\'' +
                ", toppings=" + toppings +
                '}';
    }
}
