package com.company;

import java.sql.*;
import java.util.ArrayList;


public class MyJDB {
    String name;
    int numProducts;
    double bill;
    double amount;
    String item;
    double price;
    int quantity;

    ArrayList<Order> myOrders = new ArrayList<>();

    public void saleDetails(String name, int numProducts, double bill, double amount){
        this.name = name;
        this.numProducts = numProducts;
        this.bill = bill;
        this.amount = amount;
    }

    public void order(String item,double price,int quantity){
        this.item = item;
        this.price = price;
        this.quantity = quantity;
    }

    void connect(){
        String id = "EDP445361";
        try {

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdb", "root", "Deadpool-79sql");
            Statement statement = connection.createStatement();
            statement.executeUpdate("insert into sales (customer_name, reciept_no, no_of_products, bill, amount_payed) values('"+name+"','"+id+"','"+numProducts+"','"+bill+"','"+amount+"')");


//            Order myOrder = new Order(item,quantity,price);
//            myOrders.add(myOrder);
//            statement.executeUpdate("insert into items"+"()");
            // Return Values from the Database


            ResultSet resultSet = statement.executeQuery("select * from sales");

//             while resultSet is not empty, continue to print values in DB
            while (resultSet.next()) {
                System.out.println(resultSet.getString("customer_name"));
                System.out.println(resultSet.getString("reciept_no"));
                System.out.println(resultSet.getString("no_of_products"));
                System.out.println(resultSet.getString("amount_payed"));

            }
        } catch (SQLException e){
            e.printStackTrace();
        }

    }

}
