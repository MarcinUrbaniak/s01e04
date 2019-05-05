package io.github.com.javafaktura.s01.e04.calculator;

import java.util.List;

import io.github.com.javafaktura.s01.e04.model.Topping;

class PriceCalculatorUtils {

    static double getMeatToppingsPercentage(List<Topping> toppings) {
        long count = toppings.stream()
                .filter(Topping::isMeat)
                .count();

        return ((double) count/(double) toppings.size()) * 100;
    }
}
