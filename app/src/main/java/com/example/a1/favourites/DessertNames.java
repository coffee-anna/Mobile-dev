package com.example.a1.favourites;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DessertNames {

    static final List<String> dessertTipes = Arrays.asList(
            "ais kacang",
            "akok",
            "apple crumble",
            "brownies",
            "buchty",
            "cake",
            "cheesecake",
            "cekodok",
            "cempedak creme",
            "cempedak fritters",
            "cendol",
            "che mek molek",
            "chocolate",
            "cupcake",
            "eclair",
            "frgál",
            "kek lapis",
            "krapfen",
            "kremrole",
            "muffin",
            "macaroon",
            "pisang sira",
            "tart",
            "větrník",
            "waffle"
    );

    static final List<String> adjectives = Arrays.asList(
            "bbq",
            "berrylicious",
            "butterscotch",
            "caramel",
            "cheesy",
            "chocolate",
            "salted egg",
            "salty",
            "smoked",
            "strawberry",
            "sugar",
            "sweet",
            "zesty"
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
        additions.add(randomElement(adjectives));
        additions.add(randomElement(toppings));
        additions.add(randomElement(flavors));

        return "with " + String.join(" ", additions);
    }

    public static String generateCoffeeName() {
        List<String> coffeeParams = new ArrayList<>();
        coffeeParams.add(randomElement(dessertTipes));

        return String.join(" ", coffeeParams) + " " + generateAddons();
    }

    public static String randomElement(List<String> list) {
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }
}

