package io.github.com.javafaktura.s01.e04.calculator;

abstract class CalculationStrategyDecorator implements CalculationStrategy {

    protected final CalculationStrategy decorated;

    protected CalculationStrategyDecorator(CalculationStrategy decorated) {
        this.decorated = decorated;
    }
}
