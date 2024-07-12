package com.sirmaacademy.packages.solid.faulty;

public class DiscountCalculator {
    public double calculateDiscount(String type, double price) {
        if ("STUDENT".equals(type)) {
            return price * 0.1;
        } else if ("SENIOR".equals(type)) {
            return price * 0.2;
        }
        return price;
    }
}