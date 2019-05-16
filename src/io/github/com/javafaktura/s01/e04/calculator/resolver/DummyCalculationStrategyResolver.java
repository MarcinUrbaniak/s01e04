package io.github.com.javafaktura.s01.e04.calculator.resolver;

import io.github.com.javafaktura.s01.e04.calculator.CalculationStrategy;
import io.github.com.javafaktura.s01.e04.calculator.ExtraLargePizzaCalculationStrategy;
import io.github.com.javafaktura.s01.e04.model.Size;

public class DummyCalculationStrategyResolver implements CalculationStrategyResolver {
    @Override
    public CalculationStrategy choosePolicy(Size size) {
        return new ExtraLargePizzaCalculationStrategy();
    }
}
