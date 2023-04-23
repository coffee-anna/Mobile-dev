package com.example.a1.coffee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class CoffeeNames {

    static final List<String> sizes = Arrays.asList("Short", "Tall", "Grande", "Venti");

    static final List<String> coffeeTypes = Arrays.asList(
            "Caffè Americano",
            "Blonde Caffè Americano",
            "Blonde Roast",
            "Caffè Misto",
            "Dark Roast Coffee",
            "Pike Place Roast",
            "Decaf Pike Place",
            "Cappuccino",
            "Blonde Cappuccino",
            "Espresso",
            "Espresso con Panna",
            "Flat White",
            "Blonde Flat White",
            "Almondmilk Honey Flat White",
            "Almondmilk Honey Flat White with Blonde Espresso",
            "Coconutmilk Cascara Latte",
            "Coconutmilk Cascara Latte with Blonde Espresso",
            "Caffè Latte",
            "Cinnamon Dolce Latte",
            "Blonde Vanilla Latte",
            "Blonde Caffè Latte",
            "Cocoa Cloud Macchiato",
            "Blonde Cocoa Cloud Macchiato",
            "Caramel Cloud Macchiato",
            "Blonde Caramel Cloud Macchiato",
            "Caramel Macchiato",
            "Espresso Macchiato",
            "Caffè Mocha",
            "White Chocolate Mocha"
    );

    static final List<String> addIns = Arrays.asList(
            "1% Milk",
            "2% Milk",
            "Almondmilk",
            "Coconutmilk",
            "Cream",
            "Heavy Cream",
            "Nonfat Milk",
            "Soymilk",
            "Whole Milk"
    );

    static final List<String> toppings = Arrays.asList(
            "Cascara",
            "Cinnamon Dolce Sprinkles",
            "Caramel Drizzel",
            "Mocha Drizzle",
            "Chocolate Powder",
            "Cinnamon Powder",
            "Nutmeg Powder",
            "Vanilla Powder",
            "Whipped Cream",
            "Cold Foam",
            "Salted Honey Cold Foam",
            "Vanilla Sweet Cream Cold Foam"
    );

    static final List<String>  flavors = Arrays.asList(
            "Caramel Syrup",
            "Cinnamon Dolce Syrup",
            "Sugar Free Cinnamon Dolce Syrup",
            "Classic Syrup",
            "Hazelnut Syrup",
            "Peppermind Syrup",
            "Pineaplle Ginger Syrup",
            "Raspberry Syrup",
            "Toffee Nut Syrup",
            "Vanilla Syrup",
            "Sugar Free Vanilla Syrup",
            "Caramel Sauce",
            "Mocah Sauce",
            "Skinny Mocha Sauce",
            "White Chocolate Mocha Sauce"
    );

    public static String generateAddons() {
        List<String> additions = new ArrayList<>();
        additions.add(randomElement(addIns));
        additions.add(randomElement(toppings));
        additions.add(randomElement(flavors));

        return "with " + String.join(" ", additions);
    }

    public static String generateCoffeeName() {
        List<String> coffeeParams = new ArrayList<>();
        coffeeParams.add(randomElement(sizes));
        coffeeParams.add(randomElement(coffeeTypes));

        return String.join(" ", coffeeParams) + " " + generateAddons().trim();
    }

    public static String randomElement(List<String> list) {
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }
}
