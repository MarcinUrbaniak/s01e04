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

        addPizza();
    }

    private void addPizza() {
        try(Scanner in = new Scanner(System.in)) {
            System.out.println("Give me name for your pizza");
            String pizzaName = in.nextLine();
            if (pizzaName.isBlank()) {
                pizzaName = "John";
            }

            System.out.println("Which dough do you want? (ITALIAN, POLISH, PLUMB)");
            String doughValue = in.nextLine();
            if (doughValue.isBlank()) {
                doughValue = "ITALIAN";
            }

            Dough dough = Dough.valueOf(doughValue);

            System.out.println("Which sauce do you want? (TOMATO, CHEESE, TOMATO-CHEESE)");
            String sauceValue = in.nextLine();
            if (sauceValue.isBlank()) {
                sauceValue = "TOMATO_CHEESE";
            }
            Sauce sauce = Sauce.valueOf(sauceValue);

            System.out.println("Give me the size of pizza (SMALL, MEDIUM, LARGE, EXTRA_LARGE)");
            String sizeValue = in.nextLine();
            if (sizeValue.isBlank()) {
                sizeValue = "MEDIUM";
            }
            Size size = Size.valueOf(sizeValue);

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
}