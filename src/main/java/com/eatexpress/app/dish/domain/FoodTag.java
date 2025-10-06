package com.eatexpress.app.dish.domain;

public enum FoodTag {
    // Dietary Restrictions / Allergens
    VEGAN("Vegan"),
    VEGETARIAN("Vegetarian"),
    GLUTEN_FREE("Gluten Free"),
    LACTOSE_FREE("Lactose Free"),
    DAIRY_FREE("Dairy Free"),
    NUT_ALLERGY_WARNING("Nut Allergy Warning"),
    PEANUT_ALLERGY_WARNING("Peanut Allergy Warning"),
    SHELLFISH_ALLERGY("Shellfish Allergy"),
    SOY_ALLERGY("Soy Allergy"),
    EGG_ALLERGY("Egg Allergy"),
    WHEAT_ALLERGY("Wheat Allergy"),

    // Health / Style
    KETO("Keto"),
    PALEO("Paleo"),
    HIGH_PROTEIN("High Protein"),
    LOW_CARB("Low Carb"),
    LOW_FAT("Low Fat"),
    SUGAR_FREE("Sugar Free"),
    RAW("Raw"),

    // Preparation / Quality
    SPICY("Spicy"),
    MILD("Mild"),
    ORGANIC("Organic"),
    FREE_RANGE("Free Range"),
    GRILLED("Grilled"),
    BAKED("Baked"),
    FRIED("Fried"),
    FRESHLY_MADE("Freshly Made"),

    // Marketing / Special
    SIGNATURE_DISH("Signature Dish"),
    CHEF_SPECIAL("Chef's Special"),
    SEASONAL("Seasonal");

    private final String displayValue;

    FoodTag(String displayValue) {
        this.displayValue = displayValue;
    }

    /**
     * Gets the user-friendly string representation of the tag.
     * @return The formatted tag string.
     */
    public String getDisplayValue() {
        return displayValue;
    }
}
