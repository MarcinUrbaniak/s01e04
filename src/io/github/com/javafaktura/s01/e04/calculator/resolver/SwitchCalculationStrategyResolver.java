package io.github.com.javafaktura.s01.e04.calculator.resolver;

import io.github.com.javafaktura.s01.e04.calculator.*;
import io.github.com.javafaktura.s01.e04.model.Size;

public class SwitchCalculationStrategyResolver implements CalculationStrategyResolver {

    @Override
    public CalculationStrategy choosePolicy(Size size) {
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
