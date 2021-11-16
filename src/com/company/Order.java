package com.company;

public class Order {
    String item;
    int quantity;
    double price;

    public Order(String item, int quantity, double price) {
        this.item = item;
        this.quantity = quantity;
        this.price = price;

        MyJDB items= new MyJDB();
        items.order(item,price,quantity);
    }
}
