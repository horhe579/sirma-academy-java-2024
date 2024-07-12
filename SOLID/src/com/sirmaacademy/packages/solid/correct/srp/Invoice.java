package com.sirmaacademy.packages.solid.correct.srp;

public class Invoice {
    private double amount;
    private String customerName;

    public Invoice(double amount, String customerName) {
        this.amount = amount;
        this.customerName = customerName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void printInvoice()
    {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "amount=" + amount +
                ", customerName='" + customerName + '\'' +
                '}';
    }
}
