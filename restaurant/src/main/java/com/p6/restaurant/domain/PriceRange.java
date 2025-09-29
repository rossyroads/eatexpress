package com.eatexpress.app.restaurant.domain;
public enum PriceRange {
    CHEAP("€", null, 10, "Fast food, bakery dishes"),
    REGULAR("€€", 11, 30, "Comfort food"),
    EXPENSIVE("€€€", 31, 60, "Fine dining, fish menus"),
    PREMIUM("€€€€", 61, null, "Michelin star level dishes");

    private final String symbol;
    private final Integer minAveragePrice; // inclusive, null = no lower bound
    private final Integer maxAveragePrice; // inclusive, null = no upper bound
    private final String example;

    PriceRange(String symbol, Integer minAveragePrice, Integer maxAveragePrice, String example) {
        this.symbol = symbol;
        this.minAveragePrice = minAveragePrice;
        this.maxAveragePrice = maxAveragePrice;
        this.example = example;
    }

    public String getSymbol() { return symbol; }

    // description is the enum name (e.g., CHEAP, REGULAR)
    public String getDescription() { return name(); }

    public Integer getMinAveragePrice() { return minAveragePrice; }
    public Integer getMaxAveragePrice() { return maxAveragePrice; }
    public String getExample() { return example; }

    public boolean matches(int price) {
        if (minAveragePrice != null && price < minAveragePrice) return false;
        if (maxAveragePrice != null && price > maxAveragePrice) return false;
        return true;
    }

    public static PriceRange fromPrice(int price) {
        for (PriceRange r : values()) {
            if (r.matches(price)) return r;
        }
        return null;
    }

    public static PriceRange fromSymbol(String symbol) {
        for (PriceRange r : values()) {
            if (r.symbol.equals(symbol)) return r;
        }
        return null;
    }
}
