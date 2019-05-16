package io.github.com.javafaktura.s01.e04.calculator;

import io.github.com.javafaktura.s01.e04.calculator.resolver.CalculationStrategyResolver;
import io.github.com.javafaktura.s01.e04.calculator.resolver.SwitchCalculationStrategyResolver;
import io.github.com.javafaktura.s01.e04.model.Pizza;

public class PriceCalculator {
    private final Pizza pizza;
    private final CalculationStrategyResolver resolver;

    public PriceCalculator(Pizza pizza, CalculationStrategyResolver resolver) {
        this.pizza = pizza;
        this.resolver = resolver;
    }

    public int calculatePrice() {
        CalculationStrategy calculationStrategy = resolver.choosePolicy(pizza.getSize());

        int price = calculationStrategy.calculate(pizza);
        System.out.println("Price: " + price);
        return price;
    }
}
