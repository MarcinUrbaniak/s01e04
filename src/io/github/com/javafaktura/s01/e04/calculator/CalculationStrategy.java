package io.github.com.javafaktura.s01.e04.calculator;

import io.github.com.javafaktura.s01.e04.model.Pizza;

interface CalculationStrategy {

    int calculate(Pizza pizza);
}
