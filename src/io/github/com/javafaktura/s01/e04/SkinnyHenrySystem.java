package io.github.com.javafaktura.s01.e04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import io.github.com.javafaktura.s01.e04.model.*;

public class SkinnyHenrySystem {

    public static void main(String[] args) {
	    new SkinnyHenrySystem().run();
    }

    void run() {
        System.out.println("What's up! This is Skinny Henry pizzeria system.");

        createPizza();
    }

    private void createPizza() {
        try(Scanner in = new Scanner(System.in)) {
            System.out.println("Give me name for your pizza");
            String pizzaName = getName(in.nextLine());

            System.out.println("Which dough? (ITALIAN, POLISH, PLUMB)");
            Dough dough = getDough(in.nextLine());

            System.out.println("Which sauce? (TOMATO, CHEESE, TOMATO_CHEESE)");
            Sauce sauce = getSauce(in.nextLine());

            System.out.println("Which size? (SMALL, MEDIUM, LARGE, EXTRA_LARGE)");
            Size size = getSize(in.nextLine());

            List<Topping> toppings = new ArrayList<>();
            while (true) {
                System.out.println("Which topping do you want?");
                toppings.add(Topping.valueOf(in.nextLine()));

                System.out.println("More toppings? (YES/NO)");
                String nextTopping = in.nextLine();

                if (nextTopping.equals("NO")) {
                    break;
                }
            }

            Pizza pizza = new Pizza(pizzaName, dough, sauce, size, toppings);
            System.out.println(pizza);
        }
    }

    private String getName(String pizzaName) {
        if (pizzaName.isBlank()) {
            pizzaName = "Mine pizza";
        }
        return pizzaName;
    }

    private Size getSize(String sizeValue) {
        if (sizeValue.isBlank()) {
            sizeValue = "MEDIUM";
        }
        return Size.valueOf(sizeValue);
    }

    private Sauce getSauce(String sauceValue) {
        if (sauceValue.isBlank()) {
            sauceValue = "TOMATO_CHEESE";
        }
        return Sauce.valueOf(sauceValue);
    }

    private Dough getDough(String doughValue) {
        if (doughValue.isBlank()) {
            doughValue = "ITALIAN";
        }

        return Dough.valueOf(doughValue);
    }
}