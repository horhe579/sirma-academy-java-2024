package com.sirmaacademy.packages.solid.correct.ocp.discount;

public class NoDiscount implements DiscountType{

    @Override
    public double getDiscount(double price) {
        return price;
    }
}
