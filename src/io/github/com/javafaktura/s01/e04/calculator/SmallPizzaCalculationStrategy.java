package io.github.com.javafaktura.s01.e04.calculator;

import io.github.com.javafaktura.s01.e04.model.Pizza;

public class SmallPizzaCalculationStrategy implements CalculationStrategy {

    @Override
    public int calculate(Pizza pizza) {
        int price;
        if (pizza.getToppings().size() <= 2) {
            price = 18;
        } else {
            price = 22;
        }
        return price;
    }
}
