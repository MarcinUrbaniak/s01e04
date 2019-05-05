package io.github.com.javafaktura.s01.e04.calculator;

import io.github.com.javafaktura.s01.e04.model.Pizza;
import io.github.com.javafaktura.s01.e04.model.Size;

public class PriceCalculator {
    private final Pizza pizza;

    public PriceCalculator(Pizza pizza) {
        this.pizza = pizza;
    }

    public int calculatePrice() {
        CalculationStrategy calculationStrategy = choosePolicy(pizza.getSize());

        int price = calculationStrategy.calculate(pizza);
        System.out.println("Price: " + price);
        return price;
    }

    private CalculationStrategy choosePolicy(Size size) {
        switch (size) {
            case SMALL:
                return new SmallPizzaCalculationStrategy();
            case MEDIUM:
                return new MediumPizzaCalculationStrategy();
            case LARGE:
                return new LargePizzaCalculationStrategy();
            case EXTRA_LARGE:
                return new ExtraLargePizzaCalculationStrategy();
            default:
                throw new IllegalStateException("Unknown size=" + size);
        }
    }
}
