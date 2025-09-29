package com.eatexpress.app.restaurant.domain;

public enum CuisineType {
    AMERICAN("American"),
    BRITISH("British"),
    FRENCH("French"),
    ITALIAN("Italian"),
    SPANISH("Spanish"),
    PORTUGUESE("Portuguese"),
    GERMAN("German"),
    NORDIC("Nordic"),
    MEDITERRANEAN("Mediterranean"),
    GREEK("Greek"),
    MIDDLE_EASTERN("Middle Eastern"),
    PERSIAN("Persian"),
    TURKISH("Turkish"),
    INDIAN("Indian"),
    PAKISTANI("Pakistani"),
    BANGLADESHI("Bangladeshi"),
    SOUTHEAST_ASIAN("Southeast Asian"),
    THAI("Thai"),
    VIETNAMESE("Vietnamese"),
    MALAYSIAN("Malaysian"),
    INDONESIAN("Indonesian"),
    FILIPINO("Filipino"),
    CHINESE("Chinese"),
    CANTONESE("Cantonese"),
    SZECHUAN("Szechuan"),
    SHANGHAI("Shanghai"),
    JAPANESE("Japanese"),
    SUSHI("Sushi"),
    KOREAN("Korean"),
    MEXICAN("Mexican"),
    CENTRAL_AMERICAN("Central American"),
    CARIBBEAN("Caribbean"),
    BRAZILIAN("Brazilian"),
    ARGENTINIAN("Argentinian"),
    SOUTH_AMERICAN("South American"),
    AFRICAN("African"),
    NORTH_AFRICAN("North African"),
    ETHIOPIAN("Ethiopian"),
    MOROCCAN("Moroccan"),
    VEGETARIAN("Vegetarian"),
    VEGAN("Vegan"),
    GLUTEN_FREE("Gluten-Free"),
    SEAFOOD("Seafood"),
    BARBECUE("Barbecue"),
    FAST_FOOD("Fast Food"),
    DESSERTS("Desserts"),
    BAKERY("Bakery"),
    FUSION("Fusion"),
    OTHER("Other");

    private final String displayName;

    CuisineType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static CuisineType fromDisplayName(String name) {
        if (name == null) return null;
        String normalized = name.trim().toLowerCase();
        for (CuisineType c : values()) {
            if (
                c.displayName.toLowerCase().equals(normalized) ||
                c.name().toLowerCase().equals(normalized)
            ) {
                return c;
            }
        }
        throw new IllegalArgumentException("Unknown CuisineType");
    }
}
