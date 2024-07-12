package com.sirmaacademy.packages.solid.correct.ocp.discount;

import java.util.HashMap;

public class DiscountCalculator {

    private HashMap<String, DiscountType> discounts = new HashMap<>();

    public DiscountCalculator()
    {
        discounts.put("STUDENT", new StudentDiscount());
        discounts.put("SENIOR", new SeniorDiscount());
    }

    public double calculateDiscount(String discountType, double price)
    {
        return (this.discounts.getOrDefault(discountType, new NoDiscount()).getDiscount(price));
    }

}
