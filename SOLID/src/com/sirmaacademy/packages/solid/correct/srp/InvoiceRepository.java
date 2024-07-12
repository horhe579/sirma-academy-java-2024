package com.sirmaacademy.packages.solid.correct.srp;

public class InvoiceRepository {

    public void saveInvoice(Invoice invoice) {
        System.out.println("Saving " + invoice.toString() + "to database.");
    }
}
