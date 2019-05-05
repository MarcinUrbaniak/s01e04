package io.github.com.javafaktura.s01.e04;

import java.util.Scanner;

import io.github.com.javafaktura.s01.e04.model.*;

public class SkinnyHenrySystem {

    public static void main(String[] args) {
	    new SkinnyHenrySystem().run();
    }

    void run() {
        System.out.println("What's up! This is Skinny Henry pizzeria system.");

        try(Scanner in = new Scanner(System.in)) {
            System.out.println("Give me a pizza name");
            String pizzaName = in.nextLine();
            Pizza pizza = new Pizza(pizzaName);

            System.out.println("Which dough do you want? (ITALIAN, POLISH, PLUMB)");
            String dough = in.nextLine();
            pizza.setDough(Dough.valueOf(dough));

            System.out.println("Which sauce do you want? (TOMATO, CHEESE, TOMATO-CHEESE)");
            String sauce = in.nextLine();
            pizza.setSauce(Sauce.valueOf(sauce));

            System.out.println("Give me the size of pizza (SMALL, MEDIUM, LARGE, EXTRA_LARGE)");
            String size = in.nextLine();
            pizza.setSize(Size.valueOf(size));

            while (true) {
                System.out.println("Which topping do you want?");
                String topping = in.nextLine();
                pizza.getToppings().add(Topping.valueOf(topping));

                System.out.println("More toppings? (YES/NO)");
                String nextTopping = in.nextLine();

                if (nextTopping.equals("NO")) {
                    break;
                }
            }

            System.out.println(pizza);
        }
    }
}