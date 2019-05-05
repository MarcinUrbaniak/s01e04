package io.github.com.javafaktura.s01.e04;

import java.util.List;

import io.github.com.javafaktura.s01.e04.model.Pizza;
import io.github.com.javafaktura.s01.e04.model.Size;
import io.github.com.javafaktura.s01.e04.model.Topping;

import static io.github.com.javafaktura.s01.e04.model.Dough.PLUMB;
import static io.github.com.javafaktura.s01.e04.model.Topping.ANANAS;

class PriceCalculator {
    private final Pizza pizza;

    public PriceCalculator(Pizza pizza) {
        this.pizza = pizza;
    }

    public int calculatePrice() {
        Size size = pizza.getSize();
        int price = 0;

        switch (size) {
            case SMALL:
                price = calculatePriceForSmallPizza(pizza);
                break;
            case MEDIUM:
                price = calculatePriceForMediumPizza(pizza);
                break;
            case LARGE:
                price = calculatePriceForLargePizza(pizza);
                break;
            case EXTRA_LARGE:
                price = calculatePriceForExtraLargePizza(pizza);
                break;
            default:
                throw new IllegalStateException("Unknown size=" + size);
        }

        System.out.println("Price: " + price);
        return price;
    }

    private int calculatePriceForExtraLargePizza(Pizza pizza) {
        int price;
        if (pizza.getToppings().size() <= 2) {
            price = 40;
        } else {
            price = 50;
        }

        if (pizza.getDough() == PLUMB) {
            price +=10;
        }
        return price;
    }

    private int calculatePriceForLargePizza(Pizza pizza) {
        int price;
        if (pizza.getToppings().size() <= 3) {
            if (getMeatToppingsPercentage(pizza.getToppings()) < 40) {
                price = 30;
            } else {
                price = 35;
            }
        } else {
            if (pizza.getToppings().contains(ANANAS)) {
                price = 37;
            } else {
                price = 40;
            }
        }

        if (pizza.getDough() == PLUMB) {
            price += 5;
        }
        return price;
    }

    private int calculatePriceForMediumPizza(Pizza pizza) {
        int price;
        if (pizza.getToppings().size() <= 3) {
            if (getMeatToppingsPercentage(pizza.getToppings()) < 50) {
                price = 25;
            } else {
                price = 27;
            }
        } else {
            if (getMeatToppingsPercentage(pizza.getToppings()) < 40) {
                price = 27;
            } else {
                price = 29;
            }
        }
        return price;
    }

    private int calculatePriceForSmallPizza(Pizza pizza) {
        int price;
        if (pizza.getToppings().size() <= 2) {
            price = 18;
        } else {
            price = 22;
        }
        return price;
    }

    private double getMeatToppingsPercentage(List<Topping> toppings) {
        long count = toppings.stream()
                .filter(Topping::isMeat)
                .count();

        return ((double) count/(double) toppings.size()) * 100;
    }

}
