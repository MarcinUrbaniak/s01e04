package io.github.com.javafaktura.s01.e04.calculator.resolver;

import java.util.Map;
import java.util.Optional;

import io.github.com.javafaktura.s01.e04.calculator.*;
import io.github.com.javafaktura.s01.e04.model.Size;

import static io.github.com.javafaktura.s01.e04.model.Size.*;
import static io.github.com.javafaktura.s01.e04.model.Size.MEDIUM;

public class MapCalculationStrategyResolver implements CalculationStrategyResolver {

    private static final Map<Size, CalculationStrategy> calculators = Map.of(
            SMALL, new SmallPizzaCalculationStrategy(),
            MEDIUM, new MediumPizzaCalculationStrategy(),
            LARGE, new LargePizzaCalculationStrategy(),
            EXTRA_LARGE, new ExtraLargePizzaCalculationStrategy()
    );

    public CalculationStrategy choosePolicy(Size size) {
        return Optional.ofNullable(calculators.get(size))
                .orElseThrow(() -> new IllegalStateException("Unknown pizza size=" + size));
    }
}
