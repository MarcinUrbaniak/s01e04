package io.github.com.javafaktura.s01.e04.calculator;

import io.github.com.javafaktura.s01.e04.model.Pizza;

import static io.github.com.javafaktura.s01.e04.calculator.PriceCalculatorUtils.getMeatToppingsPercentage;
import static io.github.com.javafaktura.s01.e04.model.Dough.PLUMB;
import static io.github.com.javafaktura.s01.e04.model.Topping.ANANAS;

public class LargePizzaCalculationStrategy implements CalculationStrategy {

    @Override
    public int calculate(Pizza pizza) {
        int price;
        if (pizza.getToppings().size() <= 3) {
            if (getMeatToppingsPercentage(pizza.getToppings()) < 40) {
                price = 30;
            } else {
                price = 35;
            }
        } else {
            if (pizza.getToppings().contains(ANANAS)) {
                price = 37;
            } else {
                price = 40;
            }
        }

        if (pizza.getDough() == PLUMB) {
            price += 5;
        }
        return price;
    }
}
