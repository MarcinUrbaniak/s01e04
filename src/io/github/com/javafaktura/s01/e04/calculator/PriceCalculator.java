package io.github.com.javafaktura.s01.e04.calculator;

import io.github.com.javafaktura.s01.e04.model.Pizza;
import io.github.com.javafaktura.s01.e04.model.Size;

public class PriceCalculator {
    private final Pizza pizza;

    public PriceCalculator(Pizza pizza) {
        this.pizza = pizza;
    }

    public int calculatePrice() {
        CalculationPolicy calculationPolicy = choosePolicy(pizza.getSize());

        int price = calculationPolicy.calculate(pizza);
        System.out.println("Price: " + price);
        return price;
    }

    private CalculationPolicy choosePolicy(Size size) {
        switch (size) {
            case SMALL:
                return new SmallPizzaCalculationPolicy();
            case MEDIUM:
                return new MediumPizzaCalculationPolicy();
            case LARGE:
                return new LargePizzaCalculationPolicy();
            case EXTRA_LARGE:
                return new ExtraLargePizzaCalculationPolicy();
            default:
                throw new IllegalStateException("Unknown size=" + size);
        }
    }
}
