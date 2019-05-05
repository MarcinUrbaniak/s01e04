package io.github.com.javafaktura.s01.e04;

import java.util.Scanner;

import io.github.com.javafaktura.s01.e04.calculator.PriceCalculator;
import io.github.com.javafaktura.s01.e04.model.*;

public class SkinnyHenrySystem {

    public static void main(String[] args) {
	    new SkinnyHenrySystem().run();
    }

    void run() {
        System.out.println("What's up! This is Skinny Henry pizzeria system.");

        var pizza = createPizza();

        PriceCalculator priceCalculator = new PriceCalculator(pizza);
        priceCalculator.calculatePrice();
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