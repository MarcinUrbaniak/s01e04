package io.github.com.javafaktura.s01.e04;

import java.util.List;
import java.util.Scanner;

import io.github.com.javafaktura.s01.e04.model.*;

import static io.github.com.javafaktura.s01.e04.model.Dough.PLUMB;
import static io.github.com.javafaktura.s01.e04.model.Topping.ANANAS;

public class SkinnyHenrySystem {

    public static void main(String[] args) {
	    new SkinnyHenrySystem().run();
    }

    void run() {
        System.out.println("What's up! This is Skinny Henry pizzeria system.");

        var pizza = createPizza();

        calculatePrice(pizza);
    }

    private int calculatePrice(Pizza pizza) {
        Size size = pizza.getSize();
        int price = 0;

        switch (size) {
            case SMALL:
                if (pizza.getToppings().size() <= 2) {
                    price = 18;
                } else {
                    price = 22;
                }
                break;
            case MEDIUM:
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
                break;
            case LARGE:
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

                break;
            case EXTRA_LARGE:
                if (pizza.getToppings().size() <= 2) {
                    price = 40;
                } else {
                    price = 50;
                }

                if (pizza.getDough() == PLUMB) {
                    price +=10;
                }
                break;
            default:
                throw new IllegalStateException("Unknown size=" + size);
        }

        System.out.println("Price: " + price);
        return price;
    }

    private static double getMeatToppingsPercentage(List<Topping> toppings) {
        long count = toppings.stream()
                .filter(Topping::isMeat)
                .count();

        return ((double) count/(double) toppings.size()) * 100;
    }

    private Pizza createPizza() {
        try(Scanner in = new Scanner(System.in)) {
            PizzaBuilder pizzaBuilder = new PizzaBuilder();

            System.out.println("Give me name for your pizza");
            pizzaBuilder.withName(in.nextLine());

            System.out.println("Which dough? (ITALIAN, POLISH, PLUMB)");
            pizzaBuilder.withDough(in.nextLine());

            System.out.println("Which sauce? (TOMATO, CHEESE, TOMATO_CHEESE)");
            pizzaBuilder.withSauce(in.nextLine());

            System.out.println("Which size? (SMALL, MEDIUM, LARGE, EXTRA_LARGE)");
            pizzaBuilder.withSize(in.nextLine());

            while (true) {
                System.out.println("Which topping do you want?");
                pizzaBuilder.withTopping(Topping.valueOf(in.nextLine()));

                System.out.println("More toppings? (YES/NO)");

                if (in.nextLine().equals("NO")) {
                    break;
                }
            }

            Pizza pizza = pizzaBuilder.build();
            System.out.println(pizza);

            return pizza;
        }
    }
}