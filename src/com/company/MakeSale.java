package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class MakeSale {
    String name;
    int numProducts;
    float VAT;
    double bill;

    ArrayList<Order> myOrders = new ArrayList<>();

    MakeSale(String name, int numProducts) {
        this.name = name;
        this.numProducts = numProducts;
    }

    void makeSale() {
        VAT = (float) 16 / 100;
        bill = 0;
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < numProducts; i++) {

            System.out.print("\nEnter product name: ");
            String label = input.next();

            System.out.print("Enter product quantity: ");
            int number = input.nextInt();

            System.out.print("Enter product price: ");
            double value = input.nextDouble();

            Order myOrder = new Order(label,number,value);
            myOrders.add(myOrder);

            double total = number * (double) value;
            bill += total;
        }

        bill += (VAT * (double) bill);
        display();

    }

    void display(){
        Scanner input = new Scanner(System.in);

        System.out.println("\nName: "+ name);
        System.out.println("Number of Products: "+numProducts);


        for (Order order : myOrders) {
            System.out.println("\nProduct Name: " + order.item);
            System.out.println("Price: " + order.price);
            System.out.println("Quantity: " + order.quantity);
        }

        if (bill >= 1000) {
            float discount = (float)(0.05 * bill);
            bill -= (((float) 5 / 100) * bill);
            System.out.println("Discount: "+ discount);
        }else {
            System.out.println("No discount");}
        System.out.println("\nVAT: "+VAT);
        System.out.println("Total amount: "+bill);

        System.out.print("Enter the amount to be paid: ");
        double cash = input.nextDouble();
        if(cash>bill){
            int balance = (int) (cash - bill);
            System.out.println("Balance: "+(balance));
        }else{
            System.out.println("Insufficient funds");

        }
        MyJDB sales = new MyJDB();
        sales.saleDetails(name,numProducts,bill,cash);

    }

}
