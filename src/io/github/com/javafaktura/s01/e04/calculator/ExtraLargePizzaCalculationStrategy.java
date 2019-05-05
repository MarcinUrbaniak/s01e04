package io.github.com.javafaktura.s01.e04.calculator;

import io.github.com.javafaktura.s01.e04.model.Pizza;

import static io.github.com.javafaktura.s01.e04.model.Dough.PLUMB;

class ExtraLargePizzaCalculationStrategy implements CalculationStrategy {

    @Override
    public int calculate(Pizza pizza) {
        int price;
        if (pizza.getToppings().size() <= 2) {
            price = 40;
        } else {
            price = 50;
        }

        if (pizza.getDough() == PLUMB) {
            price +=10;
        }
        return price;
    }
}
