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
            System.out.println("Give me a pizza name");
            String pizzaName = in.nextLine();

            System.out.println("Which dough do you want? (ITALIAN, POLISH, PLUMB)");
            Dough dough = Dough.valueOf(in.nextLine());

            System.out.println("Which sauce do you want? (TOMATO, CHEESE, TOMATO-CHEESE)");
            Sauce sauce = Sauce.valueOf(in.nextLine());

            System.out.println("Give me the size of pizza (SMALL, MEDIUM, LARGE, EXTRA_LARGE)");
            Size size = Size.valueOf(in.nextLine());

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