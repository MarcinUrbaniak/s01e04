package io.github.com.javafaktura.s01.e04.model;

import java.util.List;

public class Pizza {
    private final String name;
    private final Dough dough;
    private final Sauce sauce;
    private final Size size;
    private final List<Topping> toppings;

    public Pizza(String name, Dough dough, Sauce sauce, Size size, List<Topping> toppings) {
        this.name = name;
        this.dough = dough;
        this.sauce = sauce;
        this.size = size;
        this.toppings = List.copyOf(toppings);
    }

    public Dough getDough() {
        return dough;
    }

    public Sauce getSauce() {
        return sauce;
    }

    public Size getSize() {
        return size;
    }

    public String getName() {
        return name;
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
