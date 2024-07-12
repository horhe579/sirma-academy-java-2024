package com.sirmaacademy.packages.solid.correct.ocp.discount;

public class SeniorDiscount implements DiscountType{

    @Override
    public double getDiscount(double price) {
        return price * 0.2;
    }
}
