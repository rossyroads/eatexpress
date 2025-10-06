package com.eatexpress.app.dish.domain;

public enum DishType {
    STARTER("Starter"),
    MAIN_COURSE("Main Course"),
    DESSERT("Dessert"),
    SIDE_DISH("Side Dish"),
    BEVERAGE("Beverage"),
    SOUP("Soup"),
    SALAD("Salad"),
    APPETIZER("Appetizer");

    private final String displayValue;

    DishType(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
