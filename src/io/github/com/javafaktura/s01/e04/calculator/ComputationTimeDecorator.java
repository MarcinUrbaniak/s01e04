package io.github.com.javafaktura.s01.e04.calculator;

import java.time.Instant;

import io.github.com.javafaktura.s01.e04.model.Pizza;

class ComputationTimeDecorator implements CalculationStrategy {

    private final CalculationStrategy decorated;

    ComputationTimeDecorator(CalculationStrategy decorated) {
        this.decorated = decorated;
    }

    @Override
    public int calculate(Pizza pizza) {
        int before = Instant.now().getNano();
        int price = decorated.calculate(pizza);
        int after = Instant.now().getNano();

        System.out.println("Calculation time=" + (after - before));

        return price;
    }
}
