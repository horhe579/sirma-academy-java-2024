package InventoryManagementSystem.Classes;

public class Payment {

    double funds = 1000000;
    Order order;
    boolean isComplete = false;

    public Payment(double funds, InventoryClient cli) {
        this.funds = funds;
        this.order = new Order(cli);
    }

    public void addFunds(double funds)
    {
        this.funds += funds;
    }

    public void addItemToCart(String ID, int quantity)
    {
        try {
            order.addItemToCart(ID, quantity);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

    public void removeItemFromCart(String ID, int quantity)
    {
        try {
            order.removeItemFromCart(ID, quantity);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

    //place order only if order collection is not empty
    public void completeOrderPayment()
    {
        if(funds < order.getOrderPrice())
        {
            throw new IllegalArgumentException("Insufficient funds");
        }

        try {
            order.emptyCart();
            funds -= order.getOrderPrice();
            this.isComplete = true;
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

    }

    public void printOrder()
    {
        System.out.println(this.order.toString());
    }

}
