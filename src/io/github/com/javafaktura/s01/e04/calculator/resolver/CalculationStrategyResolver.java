package io.github.com.javafaktura.s01.e04.calculator.resolver;

import io.github.com.javafaktura.s01.e04.calculator.CalculationStrategy;
import io.github.com.javafaktura.s01.e04.model.Size;

public interface CalculationStrategyResolver {

    CalculationStrategy choosePolicy(Size size);
}
