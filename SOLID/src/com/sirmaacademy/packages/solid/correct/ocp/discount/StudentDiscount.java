package com.sirmaacademy.packages.solid.correct.ocp.discount;

public class StudentDiscount implements DiscountType{
    @Override
    public double getDiscount(double price) {
        return price * 0.1;
    }
}
