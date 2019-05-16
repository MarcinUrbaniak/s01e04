package io.github.com.javafaktura.s01.e04.calculator;

import java.time.LocalDateTime;

import io.github.com.javafaktura.s01.e04.model.Pizza;

class LoggingCalculationDecorator implements CalculationStrategy {

    private final CalculationStrategy decorated;

    LoggingCalculationDecorator(CalculationStrategy decorated) {
        this.decorated = decorated;
    }

    @Override
    public int calculate(Pizza pizza) {
        System.out.println("Calculation strategy " + decorated + " invoked at " + LocalDateTime.now());
        return decorated.calculate(pizza);
    }
}
