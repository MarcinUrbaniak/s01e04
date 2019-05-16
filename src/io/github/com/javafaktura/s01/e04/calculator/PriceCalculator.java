package io.github.com.javafaktura.s01.e04.calculator;

import io.github.com.javafaktura.s01.e04.calculator.resolver.CalculationStrategyResolver;

import java.time.Instant;
import java.time.LocalDateTime;

import io.github.com.javafaktura.s01.e04.model.Pizza;

public class PriceCalculator {
    private final Pizza pizza;
    private final CalculationStrategyResolver resolver;

    public PriceCalculator(Pizza pizza, CalculationStrategyResolver resolver) {
        this.pizza = pizza;
        this.resolver = resolver;
    }

    public int calculatePrice() {
        CalculationStrategy calculationStrategy = new LoggingCalculationDecorator(
                                                        new ComputationTimeDecorator(
                                                            resolver.choosePolicy(pizza.getSize())
                                                        )
                                                  );
        return calculationStrategy.calculate(pizza);
    }
}
