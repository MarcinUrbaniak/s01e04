package io.github.com.javafaktura.s01.e04.calculator;

import java.time.LocalDateTime;

import io.github.com.javafaktura.s01.e04.model.Pizza;

class LoggingCalculationDecorator extends CalculationStrategyDecorator {

    LoggingCalculationDecorator(CalculationStrategy decorated) {
        super(decorated);
    }

    @Override
    public int calculate(Pizza pizza) {
        System.out.println("Calculation strategy " + decorated + " invoked at " + LocalDateTime.now());
        return decorated.calculate(pizza);
    }
}
